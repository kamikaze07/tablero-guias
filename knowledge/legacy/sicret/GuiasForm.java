/*       */ package sicret;
/*       */ import com.mxrck.autocompleter.TextAutoCompleter;
/*       */ import com.placeholder.PlaceHolder;
/*       */ import com.toedter.calendar.JDateChooser;
/*       */ import java.awt.Color;
/*       */ import java.awt.Component;
/*       */ import java.awt.Dimension;
/*       */ import java.awt.Font;
/*       */ import java.awt.GridBagConstraints;
/*       */ import java.awt.GridBagLayout;
/*       */ import java.awt.GridLayout;
/*       */ import java.awt.Insets;
/*       */ import java.awt.LayoutManager;
/*       */ import java.awt.Point;
/*       */ import java.awt.event.ActionEvent;
/*       */ import java.awt.event.ActionListener;
/*       */ import java.awt.event.FocusAdapter;
/*       */ import java.awt.event.FocusEvent;
/*       */ import java.awt.event.KeyAdapter;
/*       */ import java.awt.event.KeyEvent;
/*       */ import java.awt.event.MouseAdapter;
/*       */ import java.awt.event.MouseEvent;
/*       */ import java.awt.event.MouseMotionAdapter;
/*       */ import java.io.BufferedWriter;
/*       */ import java.io.File;
/*       */ import java.io.IOException;
/*       */ import java.text.DateFormat;
/*       */ import java.text.ParseException;
/*       */ import java.text.SimpleDateFormat;
/*       */ import java.time.LocalDateTime;
/*       */ import java.util.ArrayList;
/*       */ import java.util.Date;
/*       */ import java.util.List;
/*       */ import java.util.Map;
/*       */ import java.util.TreeMap;
/*       */ import java.util.logging.Level;
/*       */ import java.util.logging.Logger;
/*       */ import javax.swing.BorderFactory;
/*       */ import javax.swing.DefaultComboBoxModel;
/*       */ import javax.swing.GroupLayout;
/*       */ import javax.swing.Icon;
/*       */ import javax.swing.ImageIcon;
/*       */ import javax.swing.JButton;
/*       */ import javax.swing.JCheckBox;
/*       */ import javax.swing.JComboBox;
/*       */ import javax.swing.JDialog;
/*       */ import javax.swing.JEditorPane;
/*       */ import javax.swing.JFileChooser;
/*       */ import javax.swing.JFormattedTextField;
/*       */ import javax.swing.JLabel;
/*       */ import javax.swing.JOptionPane;
/*       */ import javax.swing.JPanel;
/*       */ import javax.swing.JRadioButton;
/*       */ import javax.swing.JRootPane;
/*       */ import javax.swing.JScrollPane;
/*       */ import javax.swing.JSeparator;
/*       */ import javax.swing.JSpinner;
/*       */ import javax.swing.JTable;
/*       */ import javax.swing.JTextField;
/*       */ import javax.swing.KeyStroke;
/*       */ import javax.swing.LayoutStyle;
/*       */ import javax.swing.table.DefaultTableCellRenderer;
/*       */ import javax.swing.table.DefaultTableModel;
/*       */ import javax.swing.text.DefaultFormatterFactory;
/*       */ import net.sf.jasperreports.engine.JRDataSource;
/*       */ import net.sf.jasperreports.engine.JRException;
/*       */ import net.sf.jasperreports.engine.JRPrintPage;
/*       */ import net.sf.jasperreports.engine.JasperFillManager;
/*       */ import net.sf.jasperreports.engine.JasperPrint;
/*       */ import net.sf.jasperreports.engine.JasperReport;
/*       */ import net.sf.jasperreports.engine.data.JRTableModelDataSource;
/*       */ import net.sf.jasperreports.engine.export.JRPdfExporter;
/*       */ import principal.MaterialButton;
/*       */ import rojerusan.RSTableMetro;
/*       */ import utilerias.timbrarFacturaCartaPorte;
/*       */ 
/*       */ public class GuiasForm extends JDialog {
/*       */   private int xx;
/*       */   private int xy;
/*       */   JScrollPane panel;
/*    81 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*    82 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*    83 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*    84 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*    85 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*    86 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*    87 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*    88 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*    89 */   Icon MODIFI = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/modificar.png")));
/*    90 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*    91 */   Image iconoImprimir = this.tk.getImage(getClass().getResource("/entrada/Imagenes/botones/Print.png"));
/*    92 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*    93 */   JFrame padre = null;
/*    94 */   JTabbedPane fichas = null;
/*       */   Map<String, String> CAMPOSGENERALES;
/*    96 */   MensajePop mensajeTry = null;
/*       */   String USUARIO;
/*    98 */   SColores lc = new SColores();
/*    99 */   Fuentes fuentes = new Fuentes();
/*   100 */   PlaceHolder placeHolder = null;
/*   101 */   String holderBuscarT = "BUSCAR...";
/*   102 */   String holderBuscarUbic = "BUSCAR...";
/*   103 */   String holderBuscarEco = "BUSCAR...";
/*   104 */   String holderBuscarManfiesto = "BUSCAR...";
/*   105 */   Consultas2 con2 = new Consultas2();
/*   106 */   Consultas2 con = new Consultas2();
/*   107 */   String TIPO = "";
/*   108 */   String SUCURSAL = "";
/*   109 */   int numSUC = 0;
/*   110 */   String ID = "";
/*   111 */   pintarComponentes pintar = new pintarComponentes();
/*       */   boolean actualizado = false;
/*   113 */   ArrayList LISTACODIGOS = null;
/*   114 */   TextAutoCompleter com_ListaCodigos = null;
/*   115 */   List<Tras_codigos> CODIGOSP = null;
/*   116 */   Map<String, String> CLAVECATALOGO = new TreeMap<>();
/*   117 */   Utilerias utilerias = new Utilerias();
/*   118 */   Map<String, String> Origen = new TreeMap<>();
/*   119 */   private MaskFormatter formaTel = null; private MaskFormatter formaTel2 = null;
/*   120 */   NumerosALetras numLetra = null;
/*   121 */   Date fechaActual = new Date();
/*   122 */   String DIRECTIVA = "";
/*       */   GuiasFormCat clienteForm;
/*   124 */   List<Clientes> CLIENTES = new ArrayList<>();
/*   125 */   List<Operadores> OPERADORES = new ArrayList<>();
/*   126 */   List<OrigenesDestinos> ORIGENESDESTINOS = new ArrayList<>();
/*   127 */   List<Unidades> UNIDADES = new ArrayList<>();
/*   128 */   List<Mercancias> MERCANCIAS = new ArrayList<>();
/*       */   boolean entraCatCliente = false;
/*       */   boolean entraCatOpe = false;
/*       */   boolean entraPrimeraPozos = false;
/*       */   boolean entraPrimeraUbic = false;
/*   133 */   TextAutoCompleter com_Pozos = null;
/*   134 */   TextAutoCompleter com_Plataformas = null;
/*   135 */   TextAutoCompleter com_Equipos = null;
/*   136 */   TextAutoCompleter com_Tractos = null;
/*   137 */   TextAutoCompleter com_TipoEq = null;
/*   138 */   ArrayList TODOS_POZOS = new ArrayList();
/*   139 */   ArrayList TODOS_PLATAFORMAS = new ArrayList();
/*   140 */   ArrayList TODOS_EQUIPOS = new ArrayList();
/*   141 */   ArrayList TODOS_TRACTOS = new ArrayList();
/*   142 */   ArrayList TODOS_REMOLQUES = new ArrayList();
/*   143 */   ArrayList TODOS_TIPOEQ = new ArrayList();
/*   144 */   CeldaRender1 celda1 = new CeldaRender1();
/*   145 */   CeldaRender2 celda2 = new CeldaRender2();
/*   146 */   CeldaRender3 celda3 = new CeldaRender3();
/*   147 */   String TIPOSELEC = "";
/*       */   boolean TRACTOACTIVADO = false;
/*       */   boolean REM1ACTIVADO = false;
/*       */   boolean REM2ACTIVADO = false;
/*       */   boolean DOLLYACTIVADO = false;
/*   152 */   String[] datosExtra2 = null;
/*   153 */   String TIPOCAT = "";
/*   154 */   int NUMCONTENEDOR = 0;
/*   155 */   Map<String, String> TIPOCONTENEDORES = new TreeMap<>();
/*   156 */   Map<Integer, Contenedores> LISTACONTENEDORES = new TreeMap<>();
/*   157 */   String NOMBRE = "";
/*   158 */   int paso = 0;
/*   159 */   int DIASVENCIDOS = 0;
/*   160 */   Errores error = new Errores(false);
/*       */   
/*       */   boolean cargado2 = false;
/*       */   
/*       */   boolean cargado3 = false;
/*       */   boolean cargado4 = false;
/*       */   boolean entraModificarUbic = false;
/*       */   boolean entraModificarMercancias = false;
/*       */   boolean entraModificarContenedores = false;
/*       */   boolean entraModificarUnidades = false;
/*       */   boolean entraModificarPrincipal = false;
/*   171 */   List<String> SUPERUSUARIOS = new ArrayList<>();
/*   172 */   List<String> DEPARTAMENTOS = new ArrayList<>();
/*   173 */   String fechaOriginal = "";
/*   174 */   String RUTA = "";
/*   175 */   String RUTATEMP = "";
/*   176 */   String CERTIFICADO = "";
/*   177 */   String CODIGOPOSTAL = "";
/*   178 */   String TIPOMANIFIESTO = "";
/*   179 */   double pesoNeto = 0.0D;
/*   180 */   double pesoBruto = 0.0D; String[] VEROPERADOR; private ButtonGroup buttonGroup1; private JButton jButton1; private JButton jButton10; private JButton jButton100; private JButton jButton101; private JButton jButton102; private JButton jButton103; private JButton jButton104; private JButton jButton105; private JButton jButton106; private JButton jButton107; private JButton jButton11; private JButton jButton110; private JButton jButton111; private JButton jButton112; private JButton jButton12; private JButton jButton13; private JButton jButton2; private JButton jButton3; private JButton jButton4; private JButton jButton47; private JButton jButton48; private JButton jButton5; private JButton jButton58; private JButton jButton59; private JButton jButton6; private JButton jButton60; private JButton jButton61; private JButton jButton62; private JButton jButton63; private JButton jButton64; private JButton jButton65; private JButton jButton66; private JButton jButton7; private JCheckBox jCheckBox1; private JCheckBox jCheckBox4; private JCheckBox jCheckBox5; private JComboBox jComboBox1; private JComboBox jComboBox100; private JComboBox jComboBox101; private JComboBox<String> jComboBox102; private JComboBox jComboBox2; private JComboBox jComboBox21; private JComboBox jComboBox22; private JComboBox jComboBox3; private JComboBox jComboBox4; private JComboBox<String> jComboBox5; private JComboBox jComboBox50; private JDateChooser jDateChooser1; private JDateChooser jDateChooser31; private JDialog jDialog1; private JDialog jDialog10; private JDialog jDialog11; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog4; private JDialog jDialog5; private JDialog jDialog6; private JDialog jDialog7; private JDialog jDialog8; private JDialog jDialog9; private JEditorPane jEditorPane1; private JEditorPane jEditorPane100; private JFormattedTextField jFormattedTextField100; private JFormattedTextField jFormattedTextField101; private JFormattedTextField jFormattedTextField102; private JFormattedTextField jFormattedTextField103; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel100; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel128; private JLabel jLabel129; private JLabel jLabel13; private JLabel jLabel130; private JLabel jLabel131; private JLabel jLabel132; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel155; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel214; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel45; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel5; private JLabel jLabel50; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54; private JLabel jLabel55; private JLabel jLabel56; private JLabel jLabel57; private JLabel jLabel58; private JLabel jLabel59; private JLabel jLabel6; private JLabel jLabel60; private JLabel jLabel61; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel68; private JLabel jLabel69; private JLabel jLabel7; private JLabel jLabel70; private JLabel jLabel71; private JLabel jLabel72; private JLabel jLabel73; private JLabel jLabel74; private JLabel jLabel75; private JLabel jLabel76; private JLabel jLabel77; private JLabel jLabel78; private JLabel jLabel79; private JLabel jLabel8; private JLabel jLabel80; private JLabel jLabel81; private JLabel jLabel82; private JLabel jLabel83; private JLabel jLabel84; private JLabel jLabel85; private JLabel jLabel86; private JLabel jLabel87; private JLabel jLabel88; private JLabel jLabel89; private JLabel jLabel9; private JLabel jLabel90; private JLabel jLabel91; private JLabel jLabel92; private JLabel jLabel93; private JLabel jLabel94; private JLabel jLabel95; private JLabel jLabel96; private JLabel jLabel97; private JLabel jLabel98; private JLabel jLabel99; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel102; private JPanel jPanel103; private JPanel jPanel104; private JPanel jPanel105; private JPanel jPanel106; private JPanel jPanel107; private JPanel jPanel108; private JPanel jPanel109; private JPanel jPanel11; private JPanel jPanel110; private JPanel jPanel114; private JPanel jPanel115; private JPanel jPanel12; private JPanel jPanel121; private JPanel jPanel122; private JPanel jPanel123; private JPanel jPanel124; private JPanel jPanel127; private JPanel jPanel128; private JPanel jPanel129; private JPanel jPanel13; private JPanel jPanel130; private JPanel jPanel131; private JPanel jPanel132; private JPanel jPanel133; private JPanel jPanel134;
/*       */   private JPanel jPanel135;
/*       */   private JPanel jPanel136;
/*       */   private JPanel jPanel137;
/*       */   private JPanel jPanel138;
/*       */   
/*       */   public GuiasForm(String USUARIO, JFrame padre, Map<String, String> CAMPOSGENERALES, String TIPO, boolean actualizado, ArrayList LISTACODIGOS, List<Tras_codigos> CODIGOSP, String ID) {
/*   187 */     this.SUPERUSUARIOS.add("KOFUZ01");
/*   188 */     this.SUPERUSUARIOS.add("CESAR01");
/*   189 */     this.SUPERUSUARIOS.add("RTOMAS");
/*   190 */     this.SUPERUSUARIOS.add("JQUIROZ");
/*   191 */     this.SUPERUSUARIOS.add("CARLOS");
/*   192 */     this.DEPARTAMENTOS.add("SUPER USUARIO");
/*   193 */     this.DEPARTAMENTOS.add("TRÁFICO");
/*   194 */     this.DEPARTAMENTOS.add("FACTURACIÓN");
/*       */     
/*   196 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*   197 */     this.mensajeTry = this.mensajeTry;
/*   198 */     this.TIPO = TIPO;
/*   199 */     this.padre = padre;
/*   200 */     this.fichas = this.fichas;
/*   201 */     this.USUARIO = USUARIO;
/*   202 */     this.actualizado = actualizado;
/*   203 */     this.LISTACODIGOS = LISTACODIGOS;
/*   204 */     this.CODIGOSP = CODIGOSP;
/*   205 */     this.con2.setBaseDatos("sicre2PR");
/*   206 */     initComponents();
/*   207 */     llenarTipoContenedores();
/*   208 */     this.placeHolder = new PlaceHolder(this.jTextField80, new Color(189, 189, 189), Color.BLACK, this.holderBuscarT, false, "Century Gothic", 11);
/*   209 */     this.placeHolder = new PlaceHolder(this.jTextField81, new Color(189, 189, 189), Color.BLACK, this.holderBuscarUbic, false, "Century Gothic", 11);
/*   210 */     this.placeHolder = new PlaceHolder(this.jTextField82, new Color(189, 189, 189), Color.BLACK, this.holderBuscarUbic, false, "Century Gothic", 11);
/*   211 */     this.placeHolder = new PlaceHolder(this.jTextField83, new Color(189, 189, 189), Color.BLACK, this.holderBuscarManfiesto, false, "Century Gothic", 11);
/*   212 */     this.utilerias.activarVentanajDialog(this.jDialog1, 375, 200);
/*   213 */     this.utilerias.activarVentanajDialog(this.jDialog2, 495, 140);
/*   214 */     this.utilerias.activarVentanajDialog(this.jDialog3, 610, 410);
/*   215 */     this.utilerias.activarVentanajDialog(this.jDialog4, 410, 210);
/*   216 */     this.utilerias.activarVentanajDialog(this.jDialog5, 800, 555);
/*   217 */     this.utilerias.activarVentanajDialog(this.jDialog6, 500, 340);
/*   218 */     this.utilerias.activarVentanajDialog(this.jDialog7, 450, 200);
/*   219 */     this.utilerias.activarVentanajDialog(this.jDialog8, 680, 252);
/*   220 */     this.utilerias.activarVentanajDialog(this.jDialog9, 380, 125);
/*   221 */     this.utilerias.activarVentanajDialog(this.jDialog10, 475, 300);
/*   222 */     this.utilerias.activarVentanajDialog(this.jDialog11, 525, 140);
/*   223 */     this.utilerias.cargarMouse(this);
/*       */     
/*   225 */     limpiar();
/*   226 */     colorear();
/*   227 */     this.DIRECTIVA = this.CAMPOSGENERALES.get("directiva");
/*   228 */     this.utilerias.formatearAPesos(this.jFormattedTextField101);
/*       */     
/*   230 */     if (this.TIPO.equals("NUEVA")) {
/*   231 */       this.NOMBRE = (String)CAMPOSGENERALES.get("empleados.nombre") + " " + (String)CAMPOSGENERALES.get("empleados.nombre") + " " + (String)CAMPOSGENERALES.get("empleados.ap_pat");
/*   232 */       this.jTextField58.setText(this.NOMBRE);
/*   233 */       llenarClientes();
/*   234 */       llenarOperadores();
/*   235 */       consultarServicios();
/*   236 */       llenarServicios();
/*   237 */       llenarUnidades();
/*   238 */       llenarTipoEq();
/*       */       
/*   240 */       this.jTabbedPane1.remove(3);
/*   241 */       this.jTabbedPane1.remove(2);
/*   242 */       this.jTabbedPane1.remove(1);
/*   243 */       this.paso = 1;
/*   244 */       this.jLabel20.setText("Guía Nueva");
/*   245 */       sacarMayor();
/*   246 */       this.materialButton1.setVisible(true);
/*   247 */       this.materialButton1.setText("Guardar");
/*   248 */       this.materialButton1.setToolTipText("Guardar (Alt + G)");
/*   249 */       this.materialButton9.setVisible(false);
/*   250 */       this.jPanel90.setVisible(false);
/*   251 */     } else if (this.TIPO.equals("VER")) {
/*   252 */       this.ID = ID;
/*   253 */       this.jPanel1.setVisible(false);
/*   254 */       desabilitar();
/*   255 */       this.materialButton1.setVisible(true);
/*   256 */       this.materialButton1.setText("Imprimir");
/*   257 */       this.materialButton1.setToolTipText("Imprimir (Alt + I)");
/*   258 */       this.materialButton1.setEnabled(true);
/*   259 */       this.con.consultar("estatus", "guias", "where num_guia = '" + ID + "'");
/*       */       
/*   261 */       verDatos1(ID);
/*   262 */       this.jPanel90.setVisible(true);
/*   263 */     } else if (this.TIPO.equals("MODIFICAR")) {
/*   264 */       this.NOMBRE = (String)CAMPOSGENERALES.get("empleados.nombre") + " " + (String)CAMPOSGENERALES.get("empleados.nombre") + " " + (String)CAMPOSGENERALES.get("empleados.ap_pat");
/*   265 */       this.jTextField58.setText(this.NOMBRE);
/*   266 */       llenarClientes();
/*   267 */       llenarOperadores();
/*   268 */       consultarServicios();
/*   269 */       llenarServicios();
/*   270 */       llenarTipoEq();
/*   271 */       llenarUnidades();
/*   272 */       this.jTabbedPane1.remove(3);
/*   273 */       this.jTabbedPane1.remove(2);
/*   274 */       this.jTabbedPane1.remove(1);
/*   275 */       this.paso = 1;
/*       */       
/*   277 */       this.ID = ID;
/*   278 */       this.materialButton1.setVisible(true);
/*   279 */       this.materialButton1.setText("Modificar");
/*   280 */       this.materialButton1.setToolTipText("Modificar (Alt + M)");
/*   281 */       this.materialButton9.setVisible(false);
/*   282 */       verDatos1(ID);
/*   283 */       verDatos2(ID);
/*   284 */       verDatos3(ID);
/*   285 */       verDatos4(ID);
/*       */       
/*   287 */       privilegios();
/*   288 */       this.jPanel90.setVisible(false);
/*   289 */     } else if (this.TIPO.equals("COPIAR")) {
/*   290 */       this.NOMBRE = (String)CAMPOSGENERALES.get("empleados.nombre") + " " + (String)CAMPOSGENERALES.get("empleados.nombre") + " " + (String)CAMPOSGENERALES.get("empleados.ap_pat");
/*   291 */       this.jTextField58.setText(this.NOMBRE);
/*   292 */       llenarClientes();
/*   293 */       llenarOperadores();
/*   294 */       consultarServicios();
/*   295 */       llenarServicios();
/*   296 */       llenarTipoEq();
/*   297 */       llenarUnidades();
/*   298 */       this.jTabbedPane1.remove(3);
/*   299 */       this.jTabbedPane1.remove(2);
/*   300 */       this.jTabbedPane1.remove(1);
/*   301 */       this.paso = 1;
/*       */       
/*   303 */       this.ID = ID;
/*   304 */       verDatos1(ID);
/*   305 */       verDatos2(ID);
/*   306 */       verDatos3(ID);
/*       */ 
/*       */       
/*   309 */       this.jLabel20.setText("Guía Nueva");
/*   310 */       sacarMayor();
/*   311 */       this.materialButton1.setVisible(true);
/*   312 */       this.materialButton1.setText("Guardar");
/*   313 */       this.materialButton1.setToolTipText("Guardar (Alt + G)");
/*   314 */       this.materialButton9.setVisible(false);
/*   315 */       this.jPanel90.setVisible(false);
/*       */     } 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*   324 */     String[] conf = { this.CAMPOSGENERALES.get("directiva"), this.CAMPOSGENERALES.get("semarnat"), this.CAMPOSGENERALES.get("sucursal"), this.CAMPOSGENERALES.get("numCertificado"), this.CAMPOSGENERALES.get("codigoPostal"), this.CAMPOSGENERALES.get("rutaCompTraslado") };
/*       */     
/*   326 */     this.CERTIFICADO = conf[3];
/*   327 */     this.CODIGOPOSTAL = conf[4];
/*   328 */     this.SUCURSAL = conf[2];
/*   329 */     this.RUTA = conf[5];
/*   330 */     this.RUTATEMP = this.RUTA;
/*       */     
/*   332 */     this.buttonGroup1.add(this.jRadioButton1);
/*   333 */     this.buttonGroup1.add(this.jRadioButton2);
/*   334 */     this.buttonGroup1.add(this.jRadioButton3);
/*   335 */     setLocationRelativeTo(null);
/*   336 */     setVisible(true);
/*   337 */     setResizable(true);
/*       */   }
/*       */   private JPanel jPanel139; private JPanel jPanel14; private JPanel jPanel140; private JPanel jPanel141; private JPanel jPanel142; private JPanel jPanel15; private JPanel jPanel16; private JPanel jPanel17; private JPanel jPanel172; private JPanel jPanel18; private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel23; private JPanel jPanel24; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel27; private JPanel jPanel28; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel30; private JPanel jPanel31; private JPanel jPanel32; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel35; private JPanel jPanel36; private JPanel jPanel37; private JPanel jPanel38; private JPanel jPanel39; private JPanel jPanel4; private JPanel jPanel40; private JPanel jPanel41; private JPanel jPanel42; private JPanel jPanel43; private JPanel jPanel44; private JPanel jPanel45; private JPanel jPanel46; private JPanel jPanel47; private JPanel jPanel48; private JPanel jPanel49; private JPanel jPanel5; private JPanel jPanel50; private JPanel jPanel51; private JPanel jPanel52; private JPanel jPanel53; private JPanel jPanel54; private JPanel jPanel55; private JPanel jPanel56; private JPanel jPanel57; private JPanel jPanel58; private JPanel jPanel59; private JPanel jPanel6; private JPanel jPanel60; private JPanel jPanel61; private JPanel jPanel62; private JPanel jPanel63; private JPanel jPanel64; private JPanel jPanel65; private JPanel jPanel66; private JPanel jPanel67; private JPanel jPanel68; private JPanel jPanel69; private JPanel jPanel7; private JPanel jPanel70; private JPanel jPanel71; private JPanel jPanel72; private JPanel jPanel73; private JPanel jPanel74; private JPanel jPanel75; private JPanel jPanel76; private JPanel jPanel77; private JPanel jPanel78; private JPanel jPanel79; private JPanel jPanel8; private JPanel jPanel80; private JPanel jPanel81; private JPanel jPanel82; private JPanel jPanel83; private JPanel jPanel84; private JPanel jPanel85; private JPanel jPanel86; private JPanel jPanel87; private JPanel jPanel88; private JPanel jPanel89; private JPanel jPanel9; private JPanel jPanel90; private JPanel jPanel91; private JPanel jPanel92; private JPanel jPanel95; private JPanel jPanel96; private JPanel jPanel99; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JRadioButton jRadioButton3; private JScrollPane jScrollPane1; private JScrollPane jScrollPane3; private JScrollPane jScrollPane33;
/*       */   private JScrollPane jScrollPane34;
/*       */   private JScrollPane jScrollPane35;
/*       */   private JScrollPane jScrollPane36;
/*       */   
/*       */   private void initComponents() {
/*   345 */     this.jDialog1 = new CerrarVentana(this);
/*   346 */     this.jPanel136 = new JPanel();
/*   347 */     this.jScrollPane33 = new JScrollPane();
/*   348 */     this.rSTableMetro3 = new RSTableMetro();
/*   349 */     this.jButton58 = new JButton();
/*   350 */     this.jButton59 = new JButton();
/*   351 */     this.jButton61 = new JButton();
/*   352 */     this.jTextField80 = new JTextField();
/*   353 */     this.jDialog2 = new CerrarVentana(this.padre);
/*   354 */     this.jPanel67 = new JPanel();
/*   355 */     this.jLabel55 = new JLabel();
/*   356 */     this.jTextField42 = new JTextField();
/*   357 */     this.materialButton4 = new MaterialButton();
/*   358 */     this.materialButton3 = new MaterialButton();
/*   359 */     this.jDialog3 = new CerrarVentana(this);
/*   360 */     this.jPanel137 = new JPanel();
/*   361 */     this.jButton60 = new JButton();
/*   362 */     this.jButton62 = new JButton();
/*   363 */     this.jTextField81 = new JTextField();
/*   364 */     this.jPanel52 = new JPanel();
/*   365 */     this.jLabel56 = new JLabel();
/*   366 */     this.jPanel81 = new JPanel();
/*   367 */     this.jLabel129 = new JLabel();
/*   368 */     this.jPanel17 = new JPanel();
/*   369 */     this.jRadioButton1 = new JRadioButton();
/*   370 */     this.jRadioButton3 = new JRadioButton();
/*   371 */     this.jRadioButton2 = new JRadioButton();
/*   372 */     this.jLabel57 = new JLabel();
/*   373 */     this.materialButton5 = new MaterialButton();
/*   374 */     this.jPanel30 = new JPanel();
/*   375 */     this.jLabel58 = new JLabel();
/*   376 */     this.jPanel40 = new JPanel();
/*   377 */     this.jSpinner4 = new JSpinner();
/*   378 */     this.jPanel41 = new JPanel();
/*   379 */     this.jLabel59 = new JLabel();
/*   380 */     this.jPanel39 = new JPanel();
/*   381 */     this.jDateChooser31 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*   382 */     this.jPanel35 = new JPanel();
/*   383 */     this.jSpinner1 = new JSpinner();
/*   384 */     this.jSpinner2 = new JSpinner();
/*   385 */     this.jSpinner3 = new JSpinner();
/*   386 */     this.jScrollPane3 = new JScrollPane();
/*   387 */     this.jPanel38 = new JPanel();
/*   388 */     this.jScrollPane34 = new JScrollPane();
/*   389 */     this.rSTableMetro4 = new RSTableMetro();
/*   390 */     this.jButton63 = new JButton();
/*   391 */     this.jDialog4 = new CerrarVentana(this);
/*   392 */     this.jPanel138 = new JPanel();
/*   393 */     this.jScrollPane36 = new JScrollPane();
/*   394 */     this.rSTableMetro5 = new RSTableMetro();
/*   395 */     this.jTextField82 = new JTextField();
/*   396 */     this.jLabel61 = new JLabel();
/*   397 */     this.jDialog5 = new CerrarVentana(this);
/*   398 */     this.jPanel15 = new JPanel();
/*   399 */     this.jPanel68 = new JPanel();
/*   400 */     this.jLabel63 = new JLabel();
/*   401 */     this.jPanel82 = new JPanel();
/*   402 */     this.jLabel130 = new JLabel();
/*   403 */     this.jPanel110 = new JPanel();
/*   404 */     this.jPanel131 = new JPanel();
/*   405 */     this.jPanel69 = new JPanel();
/*   406 */     this.jLabel9 = new JLabel();
/*   407 */     this.jFormattedTextField100 = new JFormattedTextField();
/*   408 */     this.jPanel71 = new JPanel();
/*   409 */     this.jPanel73 = new JPanel();
/*   410 */     this.jPanel75 = new JPanel();
/*   411 */     this.jPanel76 = new JPanel();
/*   412 */     this.jPanel91 = new JPanel();
/*   413 */     this.jLabel65 = new JLabel();
/*   414 */     this.jPanel92 = new JPanel();
/*   415 */     this.jButton100 = new JButton();
/*   416 */     this.jTextField101 = new JTextField();
/*   417 */     this.jLabel66 = new JLabel();
/*   418 */     this.jTextField102 = new JTextField();
/*   419 */     this.jPanel133 = new JPanel();
/*   420 */     this.jLabel80 = new JLabel();
/*   421 */     this.jPanel134 = new JPanel();
/*   422 */     this.jButton101 = new JButton();
/*   423 */     this.jTextField103 = new JTextField();
/*   424 */     this.jLabel81 = new JLabel();
/*   425 */     this.jTextField104 = new JTextField();
/*   426 */     this.jPanel135 = new JPanel();
/*   427 */     this.jLabel82 = new JLabel();
/*   428 */     this.jPanel139 = new JPanel();
/*   429 */     this.jButton102 = new JButton();
/*   430 */     this.jTextField105 = new JTextField();
/*   431 */     this.jLabel83 = new JLabel();
/*   432 */     this.jTextField106 = new JTextField();
/*   433 */     this.jPanel95 = new JPanel();
/*   434 */     this.jLabel67 = new JLabel();
/*   435 */     this.jScrollPane1 = new JScrollPane();
/*   436 */     this.jEditorPane100 = new JEditorPane();
/*   437 */     this.jButton107 = new JButton();
/*   438 */     this.jPanel84 = new JPanel();
/*   439 */     this.jPanel83 = new JPanel();
/*   440 */     this.jLabel68 = new JLabel();
/*   441 */     this.jTextField107 = new JTextField();
/*   442 */     this.jLabel69 = new JLabel();
/*   443 */     this.jFormattedTextField102 = new JFormattedTextField();
/*   444 */     this.jLabel95 = new JLabel();
/*   445 */     this.jFormattedTextField103 = new JFormattedTextField();
/*   446 */     this.jPanel96 = new JPanel();
/*   447 */     this.jLabel73 = new JLabel();
/*   448 */     this.jFormattedTextField101 = new JFormattedTextField();
/*   449 */     this.jLabel71 = new JLabel();
/*   450 */     this.jPanel99 = new JPanel();
/*   451 */     this.jButton103 = new JButton();
/*   452 */     this.jTextField109 = new JTextField();
/*   453 */     this.jPanel102 = new JPanel();
/*   454 */     this.jPanel103 = new JPanel();
/*   455 */     this.jPanel105 = new JPanel();
/*   456 */     this.jLabel70 = new JLabel();
/*   457 */     this.jComboBox100 = new JComboBox();
/*   458 */     this.jLabel72 = new JLabel();
/*   459 */     this.jComboBox101 = new JComboBox();
/*   460 */     this.jPanel114 = new JPanel();
/*   461 */     this.jPanel115 = new JPanel();
/*   462 */     this.jCheckBox4 = new JCheckBox();
/*   463 */     this.jPanel77 = new JPanel();
/*   464 */     this.jPanel121 = new JPanel();
/*   465 */     this.jLabel84 = new JLabel();
/*   466 */     this.jPanel122 = new JPanel();
/*   467 */     this.jButton104 = new JButton();
/*   468 */     this.jTextField110 = new JTextField();
/*   469 */     this.jLabel85 = new JLabel();
/*   470 */     this.jTextField111 = new JTextField();
/*   471 */     this.jPanel123 = new JPanel();
/*   472 */     this.jLabel86 = new JLabel();
/*   473 */     this.jPanel124 = new JPanel();
/*   474 */     this.jButton105 = new JButton();
/*   475 */     this.jTextField112 = new JTextField();
/*   476 */     this.jLabel87 = new JLabel();
/*   477 */     this.jTextField113 = new JTextField();
/*   478 */     this.jCheckBox5 = new JCheckBox();
/*   479 */     this.jPanel127 = new JPanel();
/*   480 */     this.jLabel77 = new JLabel();
/*   481 */     this.jPanel128 = new JPanel();
/*   482 */     this.jButton106 = new JButton();
/*   483 */     this.jTextField114 = new JTextField();
/*   484 */     this.jLabel78 = new JLabel();
/*   485 */     this.jTextField115 = new JTextField();
/*   486 */     this.jLabel79 = new JLabel();
/*   487 */     this.jTextField116 = new JTextField();
/*   488 */     this.jPanel129 = new JPanel();
/*   489 */     this.jLabel88 = new JLabel();
/*   490 */     this.jButton110 = new JButton();
/*   491 */     this.jLabel89 = new JLabel();
/*   492 */     this.jButton111 = new JButton();
/*   493 */     this.jLabel90 = new JLabel();
/*   494 */     this.jButton112 = new JButton();
/*   495 */     this.jPanel130 = new JPanel();
/*   496 */     this.materialButton8 = new MaterialButton();
/*   497 */     this.jDialog6 = new CerrarVentana(this.jDialog5);
/*   498 */     this.jPanel140 = new JPanel();
/*   499 */     this.jScrollPane38 = new JScrollPane();
/*   500 */     this.rSTableMetro6 = new RSTableMetro();
/*   501 */     this.jLabel62 = new JLabel();
/*   502 */     this.jPanel78 = new JPanel();
/*   503 */     this.jLabel10 = new JLabel();
/*   504 */     this.jTextField120 = new JTextField();
/*   505 */     this.jLabel13 = new JLabel();
/*   506 */     this.jTextField121 = new JTextField();
/*   507 */     this.jDialog7 = new CerrarVentana(this.jDialog5);
/*   508 */     this.jPanel141 = new JPanel();
/*   509 */     this.jPanel85 = new JPanel();
/*   510 */     this.jLabel64 = new JLabel();
/*   511 */     this.jPanel86 = new JPanel();
/*   512 */     this.jLabel131 = new JLabel();
/*   513 */     this.materialButton6 = new MaterialButton();
/*   514 */     this.jPanel87 = new JPanel();
/*   515 */     this.jLabel74 = new JLabel();
/*   516 */     this.jTextField122 = new JTextField();
/*   517 */     this.jLabel75 = new JLabel();
/*   518 */     this.jComboBox102 = new JComboBox<>();
/*   519 */     this.jLabel76 = new JLabel();
/*   520 */     this.jTextField123 = new JTextField();
/*   521 */     this.jLabel91 = new JLabel();
/*   522 */     this.jTextField124 = new JTextField();
/*   523 */     this.jDialog8 = new CerrarVentana(this);
/*   524 */     this.jPanel88 = new JPanel();
/*   525 */     this.jLabel97 = new JLabel();
/*   526 */     this.jSeparator9 = new JSeparator();
/*   527 */     this.jLabel98 = new JLabel();
/*   528 */     this.jLabel99 = new JLabel();
/*   529 */     this.jLabel100 = new JLabel();
/*   530 */     this.materialButton7 = new MaterialButton();
/*   531 */     this.jDialog9 = new CerrarVentana(this.padre);
/*   532 */     this.jPanel172 = new JPanel();
/*   533 */     this.materialButton40 = new MaterialButton();
/*   534 */     this.materialButton41 = new MaterialButton();
/*   535 */     this.jTextField41 = new JTextField();
/*   536 */     this.jDialog10 = new CerrarVentana(this.padre);
/*   537 */     this.jPanel142 = new JPanel();
/*   538 */     this.jScrollPane39 = new JScrollPane();
/*   539 */     this.rSTableMetro7 = new RSTableMetro();
/*   540 */     this.jButton64 = new JButton();
/*   541 */     this.jButton65 = new JButton();
/*   542 */     this.jButton66 = new JButton();
/*   543 */     this.jTextField83 = new JTextField();
/*   544 */     this.jDialog11 = new CerrarVentana(this.padre);
/*   545 */     this.jPanel89 = new JPanel();
/*   546 */     this.jLabel94 = new JLabel();
/*   547 */     this.jTextField43 = new JTextField();
/*   548 */     this.materialButton10 = new MaterialButton();
/*   549 */     this.materialButton11 = new MaterialButton();
/*   550 */     this.jComboBox5 = new JComboBox<>();
/*   551 */     this.jPanel36 = new JPanel();
/*   552 */     this.jPanel132 = new JPanel();
/*   553 */     this.jLabel96 = new JLabel();
/*   554 */     this.jPanel104 = new JPanel();
/*   555 */     this.jPanel106 = new JPanel();
/*   556 */     this.jPanel107 = new JPanel();
/*   557 */     this.jPanel108 = new JPanel();
/*   558 */     this.jPanel109 = new JPanel();
/*   559 */     this.jTextField14 = new JTextField();
/*   560 */     this.buttonGroup1 = new ButtonGroup();
/*   561 */     this.jPanel12 = new JPanel();
/*   562 */     this.jPanel50 = new JPanel();
/*   563 */     this.jLabel20 = new JLabel();
/*   564 */     this.jPanel80 = new JPanel();
/*   565 */     this.jLabel128 = new JLabel();
/*   566 */     this.jLabel27 = new JLabel();
/*   567 */     this.jLabel54 = new JLabel();
/*   568 */     this.jPanel79 = new JPanel();
/*   569 */     this.materialButton2 = new MaterialButton();
/*   570 */     this.materialButton9 = new MaterialButton();
/*   571 */     this.materialButton1 = new MaterialButton();
/*   572 */     this.jPanel1 = new JPanel();
/*   573 */     this.jPanel2 = new JPanel();
/*   574 */     this.jButton47 = new JButton();
/*   575 */     this.jButton48 = new JButton();
/*   576 */     this.jPanel3 = new JPanel();
/*   577 */     this.jLabel214 = new JLabel();
/*   578 */     this.jPanel90 = new JPanel();
/*   579 */     this.jLabel132 = new JLabel();
/*   580 */     this.jTabbedPane1 = new JTabbedPane();
/*   581 */     this.jPanel4 = new JPanel();
/*   582 */     this.jPanel7 = new JPanel();
/*   583 */     this.jPanel8 = new JPanel();
/*   584 */     this.jLabel1 = new JLabel();
/*   585 */     this.jTextField1 = new JTextField();
/*   586 */     this.jPanel9 = new JPanel();
/*   587 */     this.jLabel2 = new JLabel();
/*   588 */     this.jTextField2 = new JTextField();
/*   589 */     this.jPanel10 = new JPanel();
/*   590 */     this.jLabel3 = new JLabel();
/*   591 */     this.jDateChooser1 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*   592 */     this.jSeparator2 = new JSeparator();
/*   593 */     this.jPanel11 = new JPanel();
/*   594 */     this.jPanel60 = new JPanel();
/*   595 */     this.jButton1 = new JButton();
/*   596 */     this.jComboBox1 = new JComboBox();
/*   597 */     this.jLabel4 = new JLabel();
/*   598 */     this.jLabel5 = new JLabel();
/*   599 */     this.jTextField3 = new JTextField();
/*   600 */     this.jLabel6 = new JLabel();
/*   601 */     this.jLabel7 = new JLabel();
/*   602 */     this.jTextField4 = new JTextField();
/*   603 */     this.jTextField5 = new JTextField();
/*   604 */     this.jLabel8 = new JLabel();
/*   605 */     this.jPanel61 = new JPanel();
/*   606 */     this.jButton2 = new JButton();
/*   607 */     this.jComboBox2 = new JComboBox();
/*   608 */     this.jLabel11 = new JLabel();
/*   609 */     this.jLabel37 = new JLabel();
/*   610 */     this.jTextField6 = new JTextField();
/*   611 */     this.jLabel38 = new JLabel();
/*   612 */     this.jTextField7 = new JTextField();
/*   613 */     this.jLabel39 = new JLabel();
/*   614 */     this.jTextField8 = new JTextField();
/*   615 */     this.jPanel62 = new JPanel();
/*   616 */     this.jButton3 = new JButton();
/*   617 */     this.jComboBox3 = new JComboBox();
/*   618 */     this.jLabel92 = new JLabel();
/*   619 */     this.jComboBox4 = new JComboBox();
/*   620 */     this.jLabel93 = new JLabel();
/*   621 */     this.jTextField9 = new JTextField();
/*   622 */     this.jPanel5 = new JPanel();
/*   623 */     this.jPanel18 = new JPanel();
/*   624 */     this.jButton10 = new JButton();
/*   625 */     this.jButton12 = new JButton();
/*   626 */     this.jLabel12 = new JLabel();
/*   627 */     this.jTextField10 = new JTextField();
/*   628 */     this.jScrollPane6 = new JScrollPane();
/*   629 */     this.jPanel42 = new JPanel();
/*   630 */     this.jScrollPane35 = new JScrollPane();
/*   631 */     this.rSTableMetro1 = new RSTableMetro();
/*   632 */     this.jPanel14 = new JPanel();
/*   633 */     this.jLabel40 = new JLabel();
/*   634 */     this.jTextField11 = new JTextField();
/*   635 */     this.jLabel41 = new JLabel();
/*   636 */     this.jTextField12 = new JTextField();
/*   637 */     this.jLabel42 = new JLabel();
/*   638 */     this.jTextField13 = new JTextField();
/*   639 */     this.jCheckBox1 = new JCheckBox();
/*   640 */     this.jPanel6 = new JPanel();
/*   641 */     this.jPanel44 = new JPanel();
/*   642 */     this.jButton11 = new JButton();
/*   643 */     this.jButton13 = new JButton();
/*   644 */     this.jLabel60 = new JLabel();
/*   645 */     this.jTextField20 = new JTextField();
/*   646 */     this.jScrollPane7 = new JScrollPane();
/*   647 */     this.jPanel45 = new JPanel();
/*   648 */     this.jScrollPane37 = new JScrollPane();
/*   649 */     this.rSTableMetro2 = new RSTableMetro();
/*   650 */     this.jPanel19 = new JPanel();
/*   651 */     this.jPanel43 = new JPanel();
/*   652 */     this.jPanel47 = new JPanel();
/*   653 */     this.jLabel43 = new JLabel();
/*   654 */     this.jComboBox21 = new JComboBox();
/*   655 */     this.jPanel48 = new JPanel();
/*   656 */     this.jLabel19 = new JLabel();
/*   657 */     this.jPanel63 = new JPanel();
/*   658 */     this.jButton4 = new JButton();
/*   659 */     this.jTextField21 = new JTextField();
/*   660 */     this.jPanel49 = new JPanel();
/*   661 */     this.jLabel16 = new JLabel();
/*   662 */     this.jPanel64 = new JPanel();
/*   663 */     this.jButton5 = new JButton();
/*   664 */     this.jTextField26 = new JTextField();
/*   665 */     this.jPanel54 = new JPanel();
/*   666 */     this.jLabel18 = new JLabel();
/*   667 */     this.jPanel65 = new JPanel();
/*   668 */     this.jButton6 = new JButton();
/*   669 */     this.jTextField31 = new JTextField();
/*   670 */     this.jPanel55 = new JPanel();
/*   671 */     this.jLabel15 = new JLabel();
/*   672 */     this.jPanel66 = new JPanel();
/*   673 */     this.jButton7 = new JButton();
/*   674 */     this.jTextField36 = new JTextField();
/*   675 */     this.jPanel56 = new JPanel();
/*   676 */     this.jLabel14 = new JLabel();
/*   677 */     this.jComboBox22 = new JComboBox();
/*   678 */     this.jPanel46 = new JPanel();
/*   679 */     this.jPanel57 = new JPanel();
/*   680 */     this.jPanel58 = new JPanel();
/*   681 */     this.jLabel24 = new JLabel();
/*   682 */     this.jTextField22 = new JTextField();
/*   683 */     this.jLabel25 = new JLabel();
/*   684 */     this.jTextField23 = new JTextField();
/*   685 */     this.jLabel26 = new JLabel();
/*   686 */     this.jTextField24 = new JTextField();
/*   687 */     this.jLabel28 = new JLabel();
/*   688 */     this.jTextField25 = new JTextField();
/*   689 */     this.jPanel59 = new JPanel();
/*   690 */     this.jLabel29 = new JLabel();
/*   691 */     this.jTextField27 = new JTextField();
/*   692 */     this.jLabel30 = new JLabel();
/*   693 */     this.jTextField28 = new JTextField();
/*   694 */     this.jLabel31 = new JLabel();
/*   695 */     this.jTextField29 = new JTextField();
/*   696 */     this.jLabel32 = new JLabel();
/*   697 */     this.jTextField30 = new JTextField();
/*   698 */     this.jPanel70 = new JPanel();
/*   699 */     this.jLabel33 = new JLabel();
/*   700 */     this.jTextField32 = new JTextField();
/*   701 */     this.jLabel34 = new JLabel();
/*   702 */     this.jTextField33 = new JTextField();
/*   703 */     this.jLabel35 = new JLabel();
/*   704 */     this.jTextField34 = new JTextField();
/*   705 */     this.jLabel36 = new JLabel();
/*   706 */     this.jTextField35 = new JTextField();
/*   707 */     this.jPanel72 = new JPanel();
/*   708 */     this.jLabel17 = new JLabel();
/*   709 */     this.jTextField37 = new JTextField();
/*   710 */     this.jLabel22 = new JLabel();
/*   711 */     this.jTextField38 = new JTextField();
/*   712 */     this.jLabel23 = new JLabel();
/*   713 */     this.jTextField39 = new JTextField();
/*   714 */     this.jLabel21 = new JLabel();
/*   715 */     this.jTextField40 = new JTextField();
/*   716 */     this.jPanel74 = new JPanel();
/*   717 */     this.jPanel13 = new JPanel();
/*   718 */     this.jPanel16 = new JPanel();
/*   719 */     this.jPanel20 = new JPanel();
/*   720 */     this.jLabel44 = new JLabel();
/*   721 */     this.jTextField50 = new JTextField();
/*   722 */     this.jPanel21 = new JPanel();
/*   723 */     this.jLabel45 = new JLabel();
/*   724 */     this.jTextField51 = new JTextField();
/*   725 */     this.jPanel22 = new JPanel();
/*   726 */     this.jLabel46 = new JLabel();
/*   727 */     this.jTextField52 = new JTextField();
/*   728 */     this.jPanel23 = new JPanel();
/*   729 */     this.jPanel24 = new JPanel();
/*   730 */     this.jLabel47 = new JLabel();
/*   731 */     this.jComboBox50 = new JComboBox();
/*   732 */     this.jPanel25 = new JPanel();
/*   733 */     this.jLabel48 = new JLabel();
/*   734 */     this.jTextField53 = new JTextField();
/*   735 */     this.jPanel26 = new JPanel();
/*   736 */     this.jPanel27 = new JPanel();
/*   737 */     this.jPanel28 = new JPanel();
/*   738 */     this.jLabel49 = new JLabel();
/*   739 */     this.jTextField54 = new JTextField();
/*   740 */     this.jLabel50 = new JLabel();
/*   741 */     this.jTextField55 = new JTextField();
/*   742 */     this.jPanel29 = new JPanel();
/*   743 */     this.jPanel31 = new JPanel();
/*   744 */     this.jPanel32 = new JPanel();
/*   745 */     this.jLabel51 = new JLabel();
/*   746 */     this.jTextField56 = new JTextField();
/*   747 */     this.jPanel33 = new JPanel();
/*   748 */     this.jPanel34 = new JPanel();
/*   749 */     this.jPanel37 = new JPanel();
/*   750 */     this.jLabel52 = new JLabel();
/*   751 */     this.jTextField57 = new JTextField();
/*   752 */     this.jPanel51 = new JPanel();
/*   753 */     this.jPanel53 = new JPanel();
/*   754 */     this.jLabel155 = new JLabel();
/*   755 */     this.jScrollPane5 = new JScrollPane();
/*   756 */     this.jEditorPane1 = new JEditorPane();
/*   757 */     this.jLabel53 = new JLabel();
/*   758 */     this.jTextField58 = new JTextField();
/*       */     
/*   760 */     this.jDialog1.setTitle("Tipo de Servicio");
/*   761 */     this.jDialog1.setModal(true);
/*   762 */     this.jDialog1.setUndecorated(true);
/*       */     
/*   764 */     this.rSTableMetro3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Tipo" })
/*       */         {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*   772 */           boolean[] canEdit = new boolean[] { false, false };
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*   777 */             return this.canEdit[columnIndex];
/*       */           }
/*       */         });
/*   780 */     this.rSTableMetro3.setAltoHead(25);
/*   781 */     this.rSTableMetro3.setColorBackgoundHead(this.lc.PRIMARIO1);
/*   782 */     this.rSTableMetro3.setColorBordeFilas(new Color(200, 200, 200));
/*   783 */     this.rSTableMetro3.setColorBordeHead(this.lc.PRIMARIO1);
/*   784 */     this.rSTableMetro3.setColorFilasBackgound2(new Color(239, 239, 239));
/*   785 */     this.rSTableMetro3.setColorFilasForeground1(new Color(102, 102, 102));
/*   786 */     this.rSTableMetro3.setColorFilasForeground2(new Color(102, 102, 102));
/*   787 */     this.rSTableMetro3.setColorSelBackgound(new Color(237, 107, 107));
/*   788 */     this.rSTableMetro3.setFuenteFilas(new Font("Cantarell", 0, 11));
/*   789 */     this.rSTableMetro3.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*   790 */     this.rSTableMetro3.setFuenteHead(new Font("Cantarell", 1, 12));
/*   791 */     this.rSTableMetro3.setGrosorBordeFilas(0);
/*   792 */     this.rSTableMetro3.setSelectionBackground(this.lc.PRIMARIO2);
/*   793 */     this.rSTableMetro3.getTableHeader().setResizingAllowed(false);
/*   794 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/*   795 */     this.rSTableMetro3.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*   797 */             GuiasForm.this.rSTableMetro3MouseClicked(evt);
/*       */           }
/*       */         });
/*   800 */     this.rSTableMetro3.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*   802 */             GuiasForm.this.rSTableMetro3KeyReleased(evt);
/*       */           }
/*       */         });
/*   805 */     this.jScrollPane33.setViewportView((Component)this.rSTableMetro3);
/*       */     
/*   807 */     this.jButton58.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/*   808 */     this.jButton58.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*   810 */             GuiasForm.this.jButton58ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*   814 */     this.jButton59.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/*   815 */     this.jButton59.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*   817 */             GuiasForm.this.jButton59ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*   821 */     this.jButton61.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/*   822 */     this.jButton61.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*   824 */             GuiasForm.this.jButton61ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*   828 */     this.jTextField80.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*   830 */             GuiasForm.this.jTextField80ActionPerformed(evt);
/*       */           }
/*       */         });
/*   833 */     this.jTextField80.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*   835 */             GuiasForm.this.jTextField80KeyReleased(evt);
/*       */           }
/*       */         });
/*       */     
/*   839 */     GroupLayout jPanel136Layout = new GroupLayout(this.jPanel136);
/*   840 */     this.jPanel136.setLayout(jPanel136Layout);
/*   841 */     jPanel136Layout.setHorizontalGroup(jPanel136Layout
/*   842 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*   843 */         .addComponent(this.jScrollPane33, -1, 418, 32767)
/*   844 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel136Layout.createSequentialGroup()
/*   845 */           .addContainerGap()
/*   846 */           .addComponent(this.jTextField80, -2, 179, -2)
/*   847 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*   848 */           .addComponent(this.jButton58)
/*   849 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*   850 */           .addComponent(this.jButton59)
/*   851 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*   852 */           .addComponent(this.jButton61)
/*   853 */           .addContainerGap()));
/*       */     
/*   855 */     jPanel136Layout.setVerticalGroup(jPanel136Layout
/*   856 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*   857 */         .addGroup(jPanel136Layout.createSequentialGroup()
/*   858 */           .addComponent(this.jScrollPane33, -1, 172, 32767)
/*   859 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*   860 */           .addGroup(jPanel136Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*   861 */             .addComponent(this.jButton58, -2, 26, -2)
/*   862 */             .addComponent(this.jButton59, -2, 26, -2)
/*   863 */             .addComponent(this.jButton61, -2, 26, -2)
/*   864 */             .addComponent(this.jTextField80, -2, -1, -2))));
/*       */ 
/*       */     
/*   867 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*   868 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*   869 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*   870 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*   871 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
/*   872 */           .addGap(0, 0, 0)
/*   873 */           .addComponent(this.jPanel136, -1, -1, 32767)));
/*       */     
/*   875 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*   876 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*   877 */         .addGroup(jDialog1Layout.createSequentialGroup()
/*   878 */           .addComponent(this.jPanel136, -1, -1, 32767)
/*   879 */           .addGap(0, 0, 0)));
/*       */ 
/*       */     
/*   882 */     this.jDialog2.setTitle("Marcas");
/*   883 */     this.jDialog2.setModal(true);
/*       */     
/*   885 */     this.jLabel55.setText("Ingresa el tipo de servicio");
/*       */     
/*   887 */     this.jTextField42.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*   889 */             GuiasForm.this.jTextField42ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*   893 */     this.materialButton4.setBackground(this.lc.SECUNDARIO1);
/*   894 */     this.materialButton4.setForeground(new Color(255, 255, 255));
/*   895 */     this.materialButton4.setMnemonic('C');
/*   896 */     this.materialButton4.setText("Cerrar");
/*   897 */     this.materialButton4.setToolTipText("Cerrar (Alt+C)");
/*   898 */     this.materialButton4.setFont(new Font("Cantarell", 0, 12));
/*   899 */     this.materialButton4.setHorizontalTextPosition(0);
/*   900 */     this.materialButton4.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*   902 */             GuiasForm.this.materialButton4ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*   906 */     this.materialButton3.setBackground(this.lc.PRIMARIO1);
/*   907 */     this.materialButton3.setForeground(new Color(255, 255, 255));
/*   908 */     this.materialButton3.setMnemonic('G');
/*   909 */     this.materialButton3.setText("Guardar");
/*   910 */     this.materialButton3.setToolTipText("Guardar (Alt +G)");
/*   911 */     this.materialButton3.setFont(new Font("Cantarell", 0, 12));
/*   912 */     this.materialButton3.setHorizontalTextPosition(0);
/*   913 */     this.materialButton3.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*   915 */             GuiasForm.this.materialButton3ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*   919 */     GroupLayout jPanel67Layout = new GroupLayout(this.jPanel67);
/*   920 */     this.jPanel67.setLayout(jPanel67Layout);
/*   921 */     jPanel67Layout.setHorizontalGroup(jPanel67Layout
/*   922 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*   923 */         .addGroup(jPanel67Layout.createSequentialGroup()
/*   924 */           .addContainerGap()
/*   925 */           .addGroup(jPanel67Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*   926 */             .addComponent(this.jTextField42)
/*   927 */             .addComponent(this.jLabel55, -1, 455, 32767)
/*   928 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel67Layout.createSequentialGroup()
/*   929 */               .addGap(0, 0, 32767)
/*   930 */               .addComponent((Component)this.materialButton3, -2, 150, -2)
/*   931 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*   932 */               .addComponent((Component)this.materialButton4, -2, 105, -2)))
/*   933 */           .addContainerGap()));
/*       */     
/*   935 */     jPanel67Layout.setVerticalGroup(jPanel67Layout
/*   936 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*   937 */         .addGroup(jPanel67Layout.createSequentialGroup()
/*   938 */           .addComponent(this.jLabel55, -2, 26, -2)
/*   939 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*   940 */           .addComponent(this.jTextField42, -2, -1, -2)
/*   941 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*   942 */           .addGroup(jPanel67Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*   943 */             .addComponent((Component)this.materialButton4, -2, 38, -2)
/*   944 */             .addComponent((Component)this.materialButton3, -2, 38, -2))
/*   945 */           .addContainerGap(-1, 32767)));
/*       */ 
/*       */     
/*   948 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*   949 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*   950 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*   951 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*   952 */         .addGroup(jDialog2Layout.createSequentialGroup()
/*   953 */           .addComponent(this.jPanel67, -2, -1, -2)
/*   954 */           .addGap(0, 0, 32767)));
/*       */     
/*   956 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/*   957 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*   958 */         .addComponent(this.jPanel67, -1, -1, 32767));
/*       */ 
/*       */     
/*   961 */     this.jDialog3.setTitle("Orgienes / Destinos");
/*   962 */     this.jDialog3.setModal(true);
/*   963 */     this.jDialog3.setUndecorated(true);
/*       */     
/*   965 */     this.jButton60.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/*   966 */     this.jButton60.setToolTipText("Nuevo");
/*   967 */     this.jButton60.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*   969 */             GuiasForm.this.jButton60ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*   973 */     this.jButton62.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/*   974 */     this.jButton62.setToolTipText("Modificar");
/*   975 */     this.jButton62.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*   977 */             GuiasForm.this.jButton62ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*   981 */     this.jTextField81.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*   983 */             GuiasForm.this.jTextField81ActionPerformed(evt);
/*       */           }
/*       */         });
/*   986 */     this.jTextField81.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*   988 */             GuiasForm.this.jTextField81KeyReleased(evt);
/*       */           }
/*       */         });
/*       */     
/*   992 */     this.jPanel52.setBackground(this.lc.SECUNDARIO1);
/*       */     
/*   994 */     this.jLabel56.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 12.0F));
/*   995 */     this.jLabel56.setForeground(new Color(255, 255, 255));
/*   996 */     this.jLabel56.setHorizontalAlignment(0);
/*   997 */     this.jLabel56.setText("Otigenes y Destinos");
/*   998 */     this.jLabel56.addMouseMotionListener(new MouseMotionAdapter() {
/*       */           public void mouseDragged(MouseEvent evt) {
/*  1000 */             GuiasForm.this.jLabel56MouseDragged(evt);
/*       */           }
/*       */         });
/*  1003 */     this.jLabel56.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  1005 */             GuiasForm.this.jLabel56MouseClicked(evt);
/*       */           }
/*       */         });
/*       */     
/*  1009 */     this.jPanel81.setBackground(this.lc.PRIMARIO1);
/*  1010 */     this.jPanel81.setLayout(new GridLayout(1, 0));
/*       */     
/*  1012 */     this.jLabel129.setHorizontalAlignment(0);
/*  1013 */     this.jLabel129.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*  1014 */     this.jLabel129.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  1016 */             GuiasForm.this.jLabel129MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  1019 */             GuiasForm.this.jLabel129MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  1022 */             GuiasForm.this.jLabel129MouseExited(evt);
/*       */           }
/*       */         });
/*  1025 */     this.jPanel81.add(this.jLabel129);
/*       */     
/*  1027 */     GroupLayout jPanel52Layout = new GroupLayout(this.jPanel52);
/*  1028 */     this.jPanel52.setLayout(jPanel52Layout);
/*  1029 */     jPanel52Layout.setHorizontalGroup(jPanel52Layout
/*  1030 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1031 */         .addGroup(jPanel52Layout.createSequentialGroup()
/*  1032 */           .addComponent(this.jLabel56, -1, -1, 32767)
/*  1033 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1034 */           .addComponent(this.jPanel81, -2, 34, -2)));
/*       */     
/*  1036 */     jPanel52Layout.setVerticalGroup(jPanel52Layout
/*  1037 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1038 */         .addComponent(this.jPanel81, -1, 22, 32767)
/*  1039 */         .addComponent(this.jLabel56, -1, -1, 32767));
/*       */ 
/*       */     
/*  1042 */     this.jPanel17.setLayout(new GridLayout(1, 2, 24, 0));
/*       */     
/*  1044 */     this.jRadioButton1.setSelected(true);
/*  1045 */     this.jRadioButton1.setText("Origenes");
/*  1046 */     this.jRadioButton1.setHorizontalAlignment(0);
/*  1047 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1049 */             GuiasForm.this.jRadioButton1ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1052 */     this.jPanel17.add(this.jRadioButton1);
/*       */     
/*  1054 */     this.jRadioButton3.setText("Intermedio");
/*  1055 */     this.jRadioButton3.setHorizontalAlignment(0);
/*  1056 */     this.jRadioButton3.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1058 */             GuiasForm.this.jRadioButton3ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1061 */     this.jPanel17.add(this.jRadioButton3);
/*       */     
/*  1063 */     this.jRadioButton2.setText("Destinos");
/*  1064 */     this.jRadioButton2.setHorizontalAlignment(0);
/*  1065 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1067 */             GuiasForm.this.jRadioButton2ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1070 */     this.jPanel17.add(this.jRadioButton2);
/*       */     
/*  1072 */     this.jLabel57.setText(" Buscar por nombre");
/*       */     
/*  1074 */     this.materialButton5.setBackground(this.lc.PRIMARIO1);
/*  1075 */     this.materialButton5.setForeground(new Color(255, 255, 255));
/*  1076 */     this.materialButton5.setMnemonic('A');
/*  1077 */     this.materialButton5.setText("Agregar");
/*  1078 */     this.materialButton5.setToolTipText("Guardar (Alt+A)");
/*  1079 */     this.materialButton5.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/*  1080 */     this.materialButton5.setHorizontalTextPosition(0);
/*  1081 */     this.materialButton5.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1083 */             GuiasForm.this.materialButton5ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1087 */     this.jPanel30.setLayout(new GridLayout(2, 2, 6, 6));
/*       */     
/*  1089 */     this.jLabel58.setText(" Distancia en Km");
/*  1090 */     this.jPanel30.add(this.jLabel58);
/*       */     
/*  1092 */     this.jPanel40.setLayout(new GridLayout(1, 2, 6, 0));
/*       */     
/*  1094 */     this.jSpinner4.setModel(new SpinnerNumberModel(1, 1, 8000, 1));
/*  1095 */     this.jSpinner4.setEnabled(false);
/*  1096 */     this.jPanel40.add(this.jSpinner4);
/*       */     
/*  1098 */     GroupLayout jPanel41Layout = new GroupLayout(this.jPanel41);
/*  1099 */     this.jPanel41.setLayout(jPanel41Layout);
/*  1100 */     jPanel41Layout.setHorizontalGroup(jPanel41Layout
/*  1101 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1102 */         .addGap(0, 140, 32767));
/*       */     
/*  1104 */     jPanel41Layout.setVerticalGroup(jPanel41Layout
/*  1105 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1106 */         .addGap(0, 21, 32767));
/*       */ 
/*       */     
/*  1109 */     this.jPanel40.add(this.jPanel41);
/*       */     
/*  1111 */     this.jPanel30.add(this.jPanel40);
/*       */     
/*  1113 */     this.jLabel59.setText(" Fecha de Carga / Descarga");
/*  1114 */     this.jPanel30.add(this.jLabel59);
/*       */     
/*  1116 */     this.jPanel39.setLayout(new GridLayout(1, 2, 6, 0));
/*       */     
/*  1118 */     this.jDateChooser31.setDate(this.fechaActual);
/*  1119 */     this.jDateChooser31.setDateFormatString("dd/MM/yyyy");
/*  1120 */     this.jDateChooser31.setIcon(this.icon);
/*  1121 */     this.jDateChooser31.setMinSelectableDate(new Date(1257058862000L));
/*  1122 */     this.jPanel39.add((Component)this.jDateChooser31);
/*       */     
/*  1124 */     this.jPanel35.setLayout(new GridLayout(1, 3));
/*       */     
/*  1126 */     this.jSpinner1.setModel(new SpinnerListModel((Object[])new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
/*  1127 */     this.jPanel35.add(this.jSpinner1);
/*       */     
/*  1129 */     this.jSpinner2.setModel(new SpinnerListModel((Object[])new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
/*  1130 */     this.jPanel35.add(this.jSpinner2);
/*       */     
/*  1132 */     this.jSpinner3.setModel(new SpinnerListModel((Object[])new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
/*  1133 */     this.jPanel35.add(this.jSpinner3);
/*       */     
/*  1135 */     this.jPanel39.add(this.jPanel35);
/*       */     
/*  1137 */     this.jPanel30.add(this.jPanel39);
/*       */     
/*  1139 */     this.rSTableMetro4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Tipo" })
/*       */         {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*  1147 */           boolean[] canEdit = new boolean[] { false, false };
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  1152 */             return this.canEdit[columnIndex];
/*       */           }
/*       */         });
/*  1155 */     this.rSTableMetro4.setAltoHead(25);
/*  1156 */     this.rSTableMetro4.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  1157 */     this.rSTableMetro4.setColorBordeFilas(new Color(200, 200, 200));
/*  1158 */     this.rSTableMetro4.setColorBordeHead(this.lc.PRIMARIO1);
/*  1159 */     this.rSTableMetro4.setColorFilasBackgound2(new Color(239, 239, 239));
/*  1160 */     this.rSTableMetro4.setColorFilasForeground1(new Color(102, 102, 102));
/*  1161 */     this.rSTableMetro4.setColorFilasForeground2(new Color(102, 102, 102));
/*  1162 */     this.rSTableMetro4.setColorSelBackgound(new Color(237, 107, 107));
/*  1163 */     this.rSTableMetro4.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  1164 */     this.rSTableMetro4.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  1165 */     this.rSTableMetro4.setFuenteHead(new Font("Cantarell", 1, 12));
/*  1166 */     this.rSTableMetro4.setGrosorBordeFilas(0);
/*  1167 */     this.rSTableMetro4.setSelectionBackground(this.lc.PRIMARIO2);
/*  1168 */     this.rSTableMetro4.getTableHeader().setResizingAllowed(false);
/*  1169 */     this.rSTableMetro4.getTableHeader().setReorderingAllowed(false);
/*  1170 */     this.rSTableMetro4.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  1172 */             GuiasForm.this.rSTableMetro4MouseClicked(evt);
/*       */           }
/*       */         });
/*  1175 */     this.rSTableMetro4.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  1177 */             GuiasForm.this.rSTableMetro4KeyReleased(evt);
/*       */           }
/*       */         });
/*  1180 */     this.jScrollPane34.setViewportView((Component)this.rSTableMetro4);
/*  1181 */     if (this.rSTableMetro4.getColumnModel().getColumnCount() > 0) {
/*  1182 */       this.rSTableMetro4.getColumnModel().getColumn(0).setMinWidth(60);
/*  1183 */       this.rSTableMetro4.getColumnModel().getColumn(0).setMaxWidth(60);
/*       */     } 
/*       */     
/*  1186 */     GroupLayout jPanel38Layout = new GroupLayout(this.jPanel38);
/*  1187 */     this.jPanel38.setLayout(jPanel38Layout);
/*  1188 */     jPanel38Layout.setHorizontalGroup(jPanel38Layout
/*  1189 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1190 */         .addGroup(jPanel38Layout.createSequentialGroup()
/*  1191 */           .addComponent(this.jScrollPane34, -2, 919, -2)
/*  1192 */           .addGap(0, 0, 32767)));
/*       */     
/*  1194 */     jPanel38Layout.setVerticalGroup(jPanel38Layout
/*  1195 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1196 */         .addComponent(this.jScrollPane34, -1, 131, 32767));
/*       */ 
/*       */     
/*  1199 */     this.jScrollPane3.setViewportView(this.jPanel38);
/*       */     
/*  1201 */     this.jButton63.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/*  1202 */     this.jButton63.setToolTipText("Ver");
/*  1203 */     this.jButton63.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1205 */             GuiasForm.this.jButton63ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1209 */     GroupLayout jPanel137Layout = new GroupLayout(this.jPanel137);
/*  1210 */     this.jPanel137.setLayout(jPanel137Layout);
/*  1211 */     jPanel137Layout.setHorizontalGroup(jPanel137Layout
/*  1212 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1213 */         .addComponent(this.jPanel52, -1, -1, 32767)
/*  1214 */         .addComponent(this.jPanel17, -1, -1, 32767)
/*  1215 */         .addComponent(this.jPanel30, -2, 0, 32767)
/*  1216 */         .addGroup(jPanel137Layout.createSequentialGroup()
/*  1217 */           .addGroup(jPanel137Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1218 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel137Layout.createSequentialGroup()
/*  1219 */               .addComponent(this.jLabel57, -2, 129, -2)
/*  1220 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1221 */               .addComponent(this.jTextField81, -2, 248, -2)
/*  1222 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 100, 32767)
/*  1223 */               .addComponent(this.jButton60)
/*  1224 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1225 */               .addComponent(this.jButton62)
/*  1226 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1227 */               .addComponent(this.jButton63))
/*  1228 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel137Layout.createSequentialGroup()
/*  1229 */               .addContainerGap(-1, 32767)
/*  1230 */               .addComponent((Component)this.materialButton5, -2, 150, -2)))
/*  1231 */           .addContainerGap())
/*  1232 */         .addComponent(this.jScrollPane3, -2, 0, 32767));
/*       */     
/*  1234 */     jPanel137Layout.setVerticalGroup(jPanel137Layout
/*  1235 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1236 */         .addGroup(jPanel137Layout.createSequentialGroup()
/*  1237 */           .addComponent(this.jPanel52, -2, -1, -2)
/*  1238 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1239 */           .addComponent(this.jPanel17, -2, -1, -2)
/*  1240 */           .addGap(18, 18, 18)
/*  1241 */           .addGroup(jPanel137Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1242 */             .addGroup(jPanel137Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  1243 */               .addComponent(this.jLabel57)
/*  1244 */               .addComponent(this.jTextField81, -2, -1, -2))
/*  1245 */             .addComponent(this.jButton60, -2, 26, -2)
/*  1246 */             .addComponent(this.jButton62, -2, 26, -2)
/*  1247 */             .addComponent(this.jButton63, -2, 26, -2))
/*  1248 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1249 */           .addComponent(this.jScrollPane3, -1, 143, 32767)
/*  1250 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1251 */           .addComponent(this.jPanel30, -2, -1, -2)
/*  1252 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1253 */           .addComponent((Component)this.materialButton5, -2, 38, -2)
/*  1254 */           .addContainerGap()));
/*       */ 
/*       */     
/*  1257 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/*  1258 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/*  1259 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/*  1260 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1261 */         .addComponent(this.jPanel137, -1, -1, 32767));
/*       */     
/*  1263 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/*  1264 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1265 */         .addComponent(this.jPanel137, -1, -1, 32767));
/*       */ 
/*       */     
/*  1268 */     this.jDialog4.setTitle("Unidades");
/*  1269 */     this.jDialog4.setModal(true);
/*  1270 */     this.jDialog4.setUndecorated(true);
/*       */     
/*  1272 */     this.rSTableMetro5.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Tipo" })
/*       */         {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*  1280 */           boolean[] canEdit = new boolean[] { false, false };
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  1285 */             return this.canEdit[columnIndex];
/*       */           }
/*       */         });
/*  1288 */     this.rSTableMetro5.setAltoHead(25);
/*  1289 */     this.rSTableMetro5.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  1290 */     this.rSTableMetro5.setColorBordeFilas(new Color(200, 200, 200));
/*  1291 */     this.rSTableMetro5.setColorBordeHead(this.lc.PRIMARIO1);
/*  1292 */     this.rSTableMetro5.setColorFilasBackgound2(new Color(239, 239, 239));
/*  1293 */     this.rSTableMetro5.setColorFilasForeground1(new Color(102, 102, 102));
/*  1294 */     this.rSTableMetro5.setColorFilasForeground2(new Color(102, 102, 102));
/*  1295 */     this.rSTableMetro5.setColorSelBackgound(new Color(237, 107, 107));
/*  1296 */     this.rSTableMetro5.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  1297 */     this.rSTableMetro5.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  1298 */     this.rSTableMetro5.setFuenteHead(new Font("Cantarell", 1, 12));
/*  1299 */     this.rSTableMetro5.setGrosorBordeFilas(0);
/*  1300 */     this.rSTableMetro5.setSelectionBackground(this.lc.PRIMARIO2);
/*  1301 */     this.rSTableMetro5.getTableHeader().setResizingAllowed(false);
/*  1302 */     this.rSTableMetro5.getTableHeader().setReorderingAllowed(false);
/*  1303 */     this.rSTableMetro5.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  1305 */             GuiasForm.this.rSTableMetro5MouseClicked(evt);
/*       */           }
/*       */         });
/*  1308 */     this.rSTableMetro5.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  1310 */             GuiasForm.this.rSTableMetro5KeyReleased(evt);
/*       */           }
/*       */         });
/*  1313 */     this.jScrollPane36.setViewportView((Component)this.rSTableMetro5);
/*       */     
/*  1315 */     this.jTextField82.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1317 */             GuiasForm.this.jTextField82ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1320 */     this.jTextField82.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  1322 */             GuiasForm.this.jTextField82KeyReleased(evt);
/*       */           }
/*       */         });
/*       */     
/*  1326 */     this.jLabel61.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/*  1327 */     this.jLabel61.setForeground(this.lc.PRIMARIO1);
/*  1328 */     this.jLabel61.setHorizontalAlignment(4);
/*  1329 */     this.jLabel61.setText("0");
/*       */     
/*  1331 */     GroupLayout jPanel138Layout = new GroupLayout(this.jPanel138);
/*  1332 */     this.jPanel138.setLayout(jPanel138Layout);
/*  1333 */     jPanel138Layout.setHorizontalGroup(jPanel138Layout
/*  1334 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1335 */         .addComponent(this.jScrollPane36, -1, 418, 32767)
/*  1336 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel138Layout.createSequentialGroup()
/*  1337 */           .addContainerGap()
/*  1338 */           .addComponent(this.jTextField82, -2, 179, -2)
/*  1339 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  1340 */           .addComponent(this.jLabel61, -2, 78, -2)
/*  1341 */           .addContainerGap()));
/*       */     
/*  1343 */     jPanel138Layout.setVerticalGroup(jPanel138Layout
/*  1344 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1345 */         .addGroup(jPanel138Layout.createSequentialGroup()
/*  1346 */           .addComponent(this.jScrollPane36, -1, 172, 32767)
/*  1347 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1348 */           .addGroup(jPanel138Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  1349 */             .addComponent(this.jTextField82, -2, -1, -2)
/*  1350 */             .addComponent(this.jLabel61))
/*  1351 */           .addGap(5, 5, 5)));
/*       */ 
/*       */     
/*  1354 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/*  1355 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/*  1356 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/*  1357 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1358 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog4Layout.createSequentialGroup()
/*  1359 */           .addGap(0, 0, 0)
/*  1360 */           .addComponent(this.jPanel138, -1, -1, 32767)));
/*       */     
/*  1362 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/*  1363 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1364 */         .addGroup(jDialog4Layout.createSequentialGroup()
/*  1365 */           .addComponent(this.jPanel138, -1, -1, 32767)
/*  1366 */           .addGap(0, 0, 0)));
/*       */ 
/*       */     
/*  1369 */     this.jDialog5.setTitle("Orgienes / Destinos");
/*  1370 */     this.jDialog5.setBackground(new Color(255, 255, 255));
/*  1371 */     this.jDialog5.setModal(true);
/*  1372 */     this.jDialog5.setUndecorated(true);
/*       */     
/*  1374 */     this.jPanel15.setBackground(new Color(255, 255, 255));
/*  1375 */     this.jPanel15.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO2));
/*       */     
/*  1377 */     this.jPanel68.setBackground(this.lc.SECUNDARIO1);
/*       */     
/*  1379 */     this.jLabel63.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 12.0F));
/*  1380 */     this.jLabel63.setForeground(new Color(255, 255, 255));
/*  1381 */     this.jLabel63.setHorizontalAlignment(0);
/*  1382 */     this.jLabel63.setText("Mercancías");
/*  1383 */     this.jLabel63.addMouseMotionListener(new MouseMotionAdapter() {
/*       */           public void mouseDragged(MouseEvent evt) {
/*  1385 */             GuiasForm.this.jLabel63MouseDragged(evt);
/*       */           }
/*       */         });
/*  1388 */     this.jLabel63.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  1390 */             GuiasForm.this.jLabel63MouseClicked(evt);
/*       */           }
/*       */         });
/*       */     
/*  1394 */     this.jPanel82.setBackground(this.lc.PRIMARIO1);
/*  1395 */     this.jPanel82.setLayout(new GridLayout(1, 0));
/*       */     
/*  1397 */     this.jLabel130.setHorizontalAlignment(0);
/*  1398 */     this.jLabel130.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*  1399 */     this.jLabel130.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  1401 */             GuiasForm.this.jLabel130MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  1404 */             GuiasForm.this.jLabel130MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  1407 */             GuiasForm.this.jLabel130MouseExited(evt);
/*       */           }
/*       */         });
/*  1410 */     this.jPanel82.add(this.jLabel130);
/*       */     
/*  1412 */     GroupLayout jPanel68Layout = new GroupLayout(this.jPanel68);
/*  1413 */     this.jPanel68.setLayout(jPanel68Layout);
/*  1414 */     jPanel68Layout.setHorizontalGroup(jPanel68Layout
/*  1415 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1416 */         .addGroup(jPanel68Layout.createSequentialGroup()
/*  1417 */           .addComponent(this.jLabel63, -1, -1, 32767)
/*  1418 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1419 */           .addComponent(this.jPanel82, -2, 34, -2)));
/*       */     
/*  1421 */     jPanel68Layout.setVerticalGroup(jPanel68Layout
/*  1422 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1423 */         .addComponent(this.jPanel82, -1, 22, 32767)
/*  1424 */         .addComponent(this.jLabel63, -1, -1, 32767));
/*       */ 
/*       */     
/*  1427 */     this.jPanel110.setBackground(new Color(255, 255, 255));
/*       */     
/*  1429 */     this.jPanel131.setBackground(new Color(255, 255, 255));
/*  1430 */     this.jPanel131.setLayout(new GridLayout(4, 0, 0, 6));
/*       */     
/*  1432 */     this.jPanel69.setBackground(new Color(255, 255, 255));
/*  1433 */     this.jPanel69.setLayout(new GridLayout(1, 6, 6, 0));
/*       */     
/*  1435 */     this.jLabel9.setFont(new Font("SF UI Display Light", 1, 12));
/*  1436 */     this.jLabel9.setText(" Cantidad");
/*  1437 */     this.jPanel69.add(this.jLabel9);
/*       */     
/*  1439 */     this.jFormattedTextField100.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*  1440 */     this.jFormattedTextField100.setHorizontalAlignment(4);
/*  1441 */     this.jFormattedTextField100.addFocusListener(new FocusAdapter() {
/*       */           public void focusGained(FocusEvent evt) {
/*  1443 */             GuiasForm.this.jFormattedTextField100FocusGained(evt);
/*       */           }
/*       */           public void focusLost(FocusEvent evt) {
/*  1446 */             GuiasForm.this.jFormattedTextField100FocusLost(evt);
/*       */           }
/*       */         });
/*  1449 */     this.jFormattedTextField100.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1451 */             GuiasForm.this.jFormattedTextField100ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1454 */     this.jPanel69.add(this.jFormattedTextField100);
/*       */     
/*  1456 */     this.jPanel71.setBackground(new Color(255, 255, 255));
/*       */     
/*  1458 */     GroupLayout jPanel71Layout = new GroupLayout(this.jPanel71);
/*  1459 */     this.jPanel71.setLayout(jPanel71Layout);
/*  1460 */     jPanel71Layout.setHorizontalGroup(jPanel71Layout
/*  1461 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1462 */         .addGap(0, 130, 32767));
/*       */     
/*  1464 */     jPanel71Layout.setVerticalGroup(jPanel71Layout
/*  1465 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1466 */         .addGap(0, 26, 32767));
/*       */ 
/*       */     
/*  1469 */     this.jPanel69.add(this.jPanel71);
/*       */     
/*  1471 */     this.jPanel73.setBackground(new Color(255, 255, 255));
/*       */     
/*  1473 */     GroupLayout jPanel73Layout = new GroupLayout(this.jPanel73);
/*  1474 */     this.jPanel73.setLayout(jPanel73Layout);
/*  1475 */     jPanel73Layout.setHorizontalGroup(jPanel73Layout
/*  1476 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1477 */         .addGap(0, 130, 32767));
/*       */     
/*  1479 */     jPanel73Layout.setVerticalGroup(jPanel73Layout
/*  1480 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1481 */         .addGap(0, 26, 32767));
/*       */ 
/*       */     
/*  1484 */     this.jPanel69.add(this.jPanel73);
/*       */     
/*  1486 */     this.jPanel75.setBackground(new Color(255, 255, 255));
/*       */     
/*  1488 */     GroupLayout jPanel75Layout = new GroupLayout(this.jPanel75);
/*  1489 */     this.jPanel75.setLayout(jPanel75Layout);
/*  1490 */     jPanel75Layout.setHorizontalGroup(jPanel75Layout
/*  1491 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1492 */         .addGap(0, 130, 32767));
/*       */     
/*  1494 */     jPanel75Layout.setVerticalGroup(jPanel75Layout
/*  1495 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1496 */         .addGap(0, 26, 32767));
/*       */ 
/*       */     
/*  1499 */     this.jPanel69.add(this.jPanel75);
/*       */     
/*  1501 */     this.jPanel76.setBackground(new Color(255, 255, 255));
/*       */     
/*  1503 */     GroupLayout jPanel76Layout = new GroupLayout(this.jPanel76);
/*  1504 */     this.jPanel76.setLayout(jPanel76Layout);
/*  1505 */     jPanel76Layout.setHorizontalGroup(jPanel76Layout
/*  1506 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1507 */         .addGap(0, 130, 32767));
/*       */     
/*  1509 */     jPanel76Layout.setVerticalGroup(jPanel76Layout
/*  1510 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1511 */         .addGap(0, 26, 32767));
/*       */ 
/*       */     
/*  1514 */     this.jPanel69.add(this.jPanel76);
/*       */     
/*  1516 */     this.jPanel131.add(this.jPanel69);
/*       */     
/*  1518 */     this.jPanel91.setBackground(new Color(255, 255, 255));
/*  1519 */     this.jPanel91.setLayout((LayoutManager)null);
/*       */     
/*  1521 */     this.jLabel65.setFont(new Font("SF UI Display Light", 1, 12));
/*  1522 */     this.jLabel65.setText(" Clave del Unidad");
/*  1523 */     this.jPanel91.add(this.jLabel65);
/*  1524 */     this.jLabel65.setBounds(0, 0, 130, 24);
/*       */     
/*  1526 */     this.jPanel92.setBackground(new Color(255, 255, 255));
/*       */     
/*  1528 */     this.jButton100.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  1529 */     this.jButton100.setMnemonic('F');
/*  1530 */     this.jButton100.setToolTipText("Filtrar información (Alt+F)");
/*  1531 */     this.jButton100.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1533 */             GuiasForm.this.jButton100ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1537 */     this.jTextField101.setText("jTextField101");
/*  1538 */     this.jTextField101.setEnabled(false);
/*  1539 */     this.jTextField101.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1541 */             GuiasForm.this.jTextField101ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1544 */     this.jTextField101.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  1546 */             GuiasForm.this.jTextField101KeyReleased(evt);
/*       */           }
/*       */         });
/*       */     
/*  1550 */     GroupLayout jPanel92Layout = new GroupLayout(this.jPanel92);
/*  1551 */     this.jPanel92.setLayout(jPanel92Layout);
/*  1552 */     jPanel92Layout.setHorizontalGroup(jPanel92Layout
/*  1553 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1554 */         .addGroup(jPanel92Layout.createSequentialGroup()
/*  1555 */           .addComponent(this.jTextField101, -1, 105, 32767)
/*  1556 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1557 */           .addComponent(this.jButton100, -2, 19, -2)));
/*       */     
/*  1559 */     jPanel92Layout.setVerticalGroup(jPanel92Layout
/*  1560 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1561 */         .addGroup(jPanel92Layout.createSequentialGroup()
/*  1562 */           .addGroup(jPanel92Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  1563 */             .addComponent(this.jButton100, -1, -1, 32767)
/*  1564 */             .addComponent(this.jTextField101))
/*  1565 */           .addGap(0, 0, 32767)));
/*       */ 
/*       */     
/*  1568 */     this.jPanel91.add(this.jPanel92);
/*  1569 */     this.jPanel92.setBounds(136, 0, 130, 29);
/*       */     
/*  1571 */     this.jLabel66.setFont(new Font("SF UI Display Light", 1, 12));
/*  1572 */     this.jLabel66.setHorizontalAlignment(0);
/*  1573 */     this.jLabel66.setText("<html><u>Descripción</u></html>");
/*  1574 */     this.jLabel66.setToolTipText("Máximo 20 caracteres");
/*  1575 */     this.jPanel91.add(this.jLabel66);
/*  1576 */     this.jLabel66.setBounds(272, 0, 120, 24);
/*       */     
/*  1578 */     this.jTextField102.setText("jTextField102");
/*  1579 */     this.jPanel91.add(this.jTextField102);
/*  1580 */     this.jTextField102.setBounds(402, 0, 390, 24);
/*       */     
/*  1582 */     this.jPanel131.add(this.jPanel91);
/*       */     
/*  1584 */     this.jPanel133.setBackground(new Color(255, 255, 255));
/*  1585 */     this.jPanel133.setLayout((LayoutManager)null);
/*       */     
/*  1587 */     this.jLabel80.setText(" Clave STCC");
/*  1588 */     this.jPanel133.add(this.jLabel80);
/*  1589 */     this.jLabel80.setBounds(0, 0, 130, 24);
/*       */     
/*  1591 */     this.jPanel134.setBackground(new Color(255, 255, 255));
/*       */     
/*  1593 */     this.jButton101.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  1594 */     this.jButton101.setMnemonic('F');
/*  1595 */     this.jButton101.setToolTipText("Filtrar información (Alt+F)");
/*  1596 */     this.jButton101.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1598 */             GuiasForm.this.jButton101ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1602 */     this.jTextField103.setText("jTextField103");
/*  1603 */     this.jTextField103.setEnabled(false);
/*  1604 */     this.jTextField103.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1606 */             GuiasForm.this.jTextField103ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1609 */     this.jTextField103.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  1611 */             GuiasForm.this.jTextField103KeyReleased(evt);
/*       */           }
/*       */         });
/*       */     
/*  1615 */     GroupLayout jPanel134Layout = new GroupLayout(this.jPanel134);
/*  1616 */     this.jPanel134.setLayout(jPanel134Layout);
/*  1617 */     jPanel134Layout.setHorizontalGroup(jPanel134Layout
/*  1618 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1619 */         .addGroup(jPanel134Layout.createSequentialGroup()
/*  1620 */           .addComponent(this.jTextField103, -1, 105, 32767)
/*  1621 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1622 */           .addComponent(this.jButton101, -2, 19, -2)));
/*       */     
/*  1624 */     jPanel134Layout.setVerticalGroup(jPanel134Layout
/*  1625 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1626 */         .addGroup(jPanel134Layout.createSequentialGroup()
/*  1627 */           .addGroup(jPanel134Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  1628 */             .addComponent(this.jButton101, -1, -1, 32767)
/*  1629 */             .addComponent(this.jTextField103))
/*  1630 */           .addGap(0, 0, 32767)));
/*       */ 
/*       */     
/*  1633 */     this.jPanel133.add(this.jPanel134);
/*  1634 */     this.jPanel134.setBounds(136, 0, 130, 29);
/*       */     
/*  1636 */     this.jLabel81.setHorizontalAlignment(0);
/*  1637 */     this.jLabel81.setText("Descripción");
/*  1638 */     this.jPanel133.add(this.jLabel81);
/*  1639 */     this.jLabel81.setBounds(272, 0, 120, 24);
/*       */     
/*  1641 */     this.jTextField104.setText("jTextField104");
/*  1642 */     this.jTextField104.setEnabled(false);
/*  1643 */     this.jPanel133.add(this.jTextField104);
/*  1644 */     this.jTextField104.setBounds(402, 0, 390, 24);
/*       */     
/*  1646 */     this.jPanel131.add(this.jPanel133);
/*       */     
/*  1648 */     this.jPanel135.setBackground(new Color(255, 255, 255));
/*  1649 */     this.jPanel135.setLayout((LayoutManager)null);
/*       */     
/*  1651 */     this.jLabel82.setFont(new Font("SF UI Display Light", 1, 12));
/*  1652 */     this.jLabel82.setText(" Clave del Producto");
/*  1653 */     this.jPanel135.add(this.jLabel82);
/*  1654 */     this.jLabel82.setBounds(0, 0, 130, 24);
/*       */     
/*  1656 */     this.jPanel139.setBackground(new Color(255, 255, 255));
/*       */     
/*  1658 */     this.jButton102.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  1659 */     this.jButton102.setMnemonic('F');
/*  1660 */     this.jButton102.setToolTipText("Filtrar información (Alt+F)");
/*  1661 */     this.jButton102.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1663 */             GuiasForm.this.jButton102ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1667 */     this.jTextField105.setText("jTextField105");
/*  1668 */     this.jTextField105.setEnabled(false);
/*  1669 */     this.jTextField105.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1671 */             GuiasForm.this.jTextField105ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1674 */     this.jTextField105.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  1676 */             GuiasForm.this.jTextField105KeyReleased(evt);
/*       */           }
/*       */         });
/*       */     
/*  1680 */     GroupLayout jPanel139Layout = new GroupLayout(this.jPanel139);
/*  1681 */     this.jPanel139.setLayout(jPanel139Layout);
/*  1682 */     jPanel139Layout.setHorizontalGroup(jPanel139Layout
/*  1683 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1684 */         .addGroup(jPanel139Layout.createSequentialGroup()
/*  1685 */           .addComponent(this.jTextField105, -1, 105, 32767)
/*  1686 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1687 */           .addComponent(this.jButton102, -2, 19, -2)));
/*       */     
/*  1689 */     jPanel139Layout.setVerticalGroup(jPanel139Layout
/*  1690 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1691 */         .addGroup(jPanel139Layout.createSequentialGroup()
/*  1692 */           .addGroup(jPanel139Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  1693 */             .addComponent(this.jButton102, -1, -1, 32767)
/*  1694 */             .addComponent(this.jTextField105))
/*  1695 */           .addGap(0, 0, 32767)));
/*       */ 
/*       */     
/*  1698 */     this.jPanel135.add(this.jPanel139);
/*  1699 */     this.jPanel139.setBounds(136, 0, 130, 29);
/*       */     
/*  1701 */     this.jLabel83.setFont(new Font("SF UI Display Light", 1, 12));
/*  1702 */     this.jLabel83.setHorizontalAlignment(0);
/*  1703 */     this.jLabel83.setText("Descripción");
/*  1704 */     this.jPanel135.add(this.jLabel83);
/*  1705 */     this.jLabel83.setBounds(272, 0, 120, 24);
/*       */     
/*  1707 */     this.jTextField106.setText("jTextField106");
/*  1708 */     this.jTextField106.setEnabled(false);
/*  1709 */     this.jPanel135.add(this.jTextField106);
/*  1710 */     this.jTextField106.setBounds(402, 0, 390, 24);
/*       */     
/*  1712 */     this.jPanel131.add(this.jPanel135);
/*       */     
/*  1714 */     this.jPanel95.setBackground(new Color(255, 255, 255));
/*       */     
/*  1716 */     this.jLabel67.setFont(new Font("SF UI Display Light", 1, 12));
/*  1717 */     this.jLabel67.setText(" Descripción Intern");
/*       */     
/*  1719 */     this.jEditorPane100.setText("100");
/*  1720 */     this.jScrollPane1.setViewportView(this.jEditorPane100);
/*       */     
/*  1722 */     this.jButton107.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  1723 */     this.jButton107.setMnemonic('F');
/*  1724 */     this.jButton107.setToolTipText("Filtrar información (Alt+F)");
/*  1725 */     this.jButton107.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1727 */             GuiasForm.this.jButton107ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1731 */     GroupLayout jPanel95Layout = new GroupLayout(this.jPanel95);
/*  1732 */     this.jPanel95.setLayout(jPanel95Layout);
/*  1733 */     jPanel95Layout.setHorizontalGroup(jPanel95Layout
/*  1734 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1735 */         .addGroup(jPanel95Layout.createSequentialGroup()
/*  1736 */           .addComponent(this.jLabel67, -2, 124, -2)
/*  1737 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1738 */           .addComponent(this.jScrollPane1)
/*  1739 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1740 */           .addComponent(this.jButton107, -2, 19, -2)
/*  1741 */           .addContainerGap()));
/*       */     
/*  1743 */     jPanel95Layout.setVerticalGroup(jPanel95Layout
/*  1744 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1745 */         .addGroup(jPanel95Layout.createSequentialGroup()
/*  1746 */           .addComponent(this.jLabel67, -2, 24, -2)
/*  1747 */           .addContainerGap(32, 32767))
/*  1748 */         .addComponent(this.jScrollPane1)
/*  1749 */         .addComponent(this.jButton107, -1, -1, 32767));
/*       */ 
/*       */     
/*  1752 */     this.jPanel84.setBackground(new Color(255, 255, 255));
/*  1753 */     this.jPanel84.setLayout(new GridLayout(3, 0, 0, 6));
/*       */     
/*  1755 */     this.jPanel83.setBackground(new Color(255, 255, 255));
/*  1756 */     this.jPanel83.setLayout(new GridLayout(1, 6, 6, 0));
/*       */     
/*  1758 */     this.jLabel68.setText(" Dimensiones");
/*  1759 */     this.jPanel83.add(this.jLabel68);
/*       */     
/*  1761 */     this.jTextField107.setHorizontalAlignment(4);
/*  1762 */     this.jTextField107.setText("jTextField107");
/*  1763 */     this.jPanel83.add(this.jTextField107);
/*       */     
/*  1765 */     this.jLabel69.setFont(new Font("SF UI Display Light", 1, 12));
/*  1766 */     this.jLabel69.setHorizontalAlignment(0);
/*  1767 */     this.jLabel69.setText("<html><u>Peso Neto en Kg</u></html>");
/*  1768 */     this.jLabel69.setToolTipText("Peso de la mercancía");
/*  1769 */     this.jPanel83.add(this.jLabel69);
/*       */     
/*  1771 */     this.jFormattedTextField102.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*  1772 */     this.jFormattedTextField102.setHorizontalAlignment(4);
/*  1773 */     this.jFormattedTextField102.addFocusListener(new FocusAdapter() {
/*       */           public void focusGained(FocusEvent evt) {
/*  1775 */             GuiasForm.this.jFormattedTextField102FocusGained(evt);
/*       */           }
/*       */           public void focusLost(FocusEvent evt) {
/*  1778 */             GuiasForm.this.jFormattedTextField102FocusLost(evt);
/*       */           }
/*       */         });
/*  1781 */     this.jFormattedTextField102.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1783 */             GuiasForm.this.jFormattedTextField102ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1786 */     this.jPanel83.add(this.jFormattedTextField102);
/*       */     
/*  1788 */     this.jLabel95.setFont(new Font("SF UI Display Light", 1, 12));
/*  1789 */     this.jLabel95.setHorizontalAlignment(0);
/*  1790 */     this.jLabel95.setText("<html><u>Peso Bruto en Kg</u></html>");
/*  1791 */     this.jLabel95.setToolTipText("Peso de la mercancía + contenedores");
/*  1792 */     this.jPanel83.add(this.jLabel95);
/*       */     
/*  1794 */     this.jFormattedTextField103.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*  1795 */     this.jFormattedTextField103.setHorizontalAlignment(4);
/*  1796 */     this.jFormattedTextField103.addFocusListener(new FocusAdapter() {
/*       */           public void focusGained(FocusEvent evt) {
/*  1798 */             GuiasForm.this.jFormattedTextField103FocusGained(evt);
/*       */           }
/*       */           public void focusLost(FocusEvent evt) {
/*  1801 */             GuiasForm.this.jFormattedTextField103FocusLost(evt);
/*       */           }
/*       */         });
/*  1804 */     this.jFormattedTextField103.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1806 */             GuiasForm.this.jFormattedTextField103ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1809 */     this.jPanel83.add(this.jFormattedTextField103);
/*       */     
/*  1811 */     this.jPanel84.add(this.jPanel83);
/*       */     
/*  1813 */     this.jPanel96.setBackground(new Color(255, 255, 255));
/*  1814 */     this.jPanel96.setLayout(new GridLayout(1, 6, 6, 0));
/*       */     
/*  1816 */     this.jLabel73.setText(" Valor");
/*  1817 */     this.jPanel96.add(this.jLabel73);
/*       */     
/*  1819 */     this.jFormattedTextField101.setHorizontalAlignment(4);
/*  1820 */     this.jFormattedTextField101.addFocusListener(new FocusAdapter() {
/*       */           public void focusLost(FocusEvent evt) {
/*  1822 */             GuiasForm.this.jFormattedTextField101FocusLost(evt);
/*       */           }
/*       */         });
/*  1825 */     this.jPanel96.add(this.jFormattedTextField101);
/*       */     
/*  1827 */     this.jLabel71.setFont(new Font("SF UI Display Light", 1, 12));
/*  1828 */     this.jLabel71.setHorizontalAlignment(0);
/*  1829 */     this.jLabel71.setText(" Moneda");
/*  1830 */     this.jPanel96.add(this.jLabel71);
/*       */     
/*  1832 */     this.jPanel99.setBackground(new Color(255, 255, 255));
/*       */     
/*  1834 */     this.jButton103.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  1835 */     this.jButton103.setMnemonic('F');
/*  1836 */     this.jButton103.setToolTipText("Filtrar información (Alt+F)");
/*  1837 */     this.jButton103.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1839 */             GuiasForm.this.jButton103ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1843 */     this.jTextField109.setText("jTextField109");
/*  1844 */     this.jTextField109.setEnabled(false);
/*  1845 */     this.jTextField109.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1847 */             GuiasForm.this.jTextField109ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1850 */     this.jTextField109.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  1852 */             GuiasForm.this.jTextField109KeyReleased(evt);
/*       */           }
/*       */         });
/*       */     
/*  1856 */     GroupLayout jPanel99Layout = new GroupLayout(this.jPanel99);
/*  1857 */     this.jPanel99.setLayout(jPanel99Layout);
/*  1858 */     jPanel99Layout.setHorizontalGroup(jPanel99Layout
/*  1859 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1860 */         .addGroup(jPanel99Layout.createSequentialGroup()
/*  1861 */           .addComponent(this.jTextField109, -1, 103, 32767)
/*  1862 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1863 */           .addComponent(this.jButton103, -2, 19, -2)));
/*       */     
/*  1865 */     jPanel99Layout.setVerticalGroup(jPanel99Layout
/*  1866 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1867 */         .addGroup(jPanel99Layout.createSequentialGroup()
/*  1868 */           .addGroup(jPanel99Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  1869 */             .addComponent(this.jButton103, -1, -1, 32767)
/*  1870 */             .addComponent(this.jTextField109))
/*  1871 */           .addGap(0, 0, 32767)));
/*       */ 
/*       */     
/*  1874 */     this.jPanel96.add(this.jPanel99);
/*       */     
/*  1876 */     this.jPanel102.setBackground(new Color(255, 255, 255));
/*       */     
/*  1878 */     GroupLayout jPanel102Layout = new GroupLayout(this.jPanel102);
/*  1879 */     this.jPanel102.setLayout(jPanel102Layout);
/*  1880 */     jPanel102Layout.setHorizontalGroup(jPanel102Layout
/*  1881 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1882 */         .addGap(0, 128, 32767));
/*       */     
/*  1884 */     jPanel102Layout.setVerticalGroup(jPanel102Layout
/*  1885 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1886 */         .addGap(0, 24, 32767));
/*       */ 
/*       */     
/*  1889 */     this.jPanel96.add(this.jPanel102);
/*       */     
/*  1891 */     this.jPanel103.setBackground(new Color(255, 255, 255));
/*       */     
/*  1893 */     GroupLayout jPanel103Layout = new GroupLayout(this.jPanel103);
/*  1894 */     this.jPanel103.setLayout(jPanel103Layout);
/*  1895 */     jPanel103Layout.setHorizontalGroup(jPanel103Layout
/*  1896 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1897 */         .addGap(0, 128, 32767));
/*       */     
/*  1899 */     jPanel103Layout.setVerticalGroup(jPanel103Layout
/*  1900 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1901 */         .addGap(0, 24, 32767));
/*       */ 
/*       */     
/*  1904 */     this.jPanel96.add(this.jPanel103);
/*       */     
/*  1906 */     this.jPanel84.add(this.jPanel96);
/*       */     
/*  1908 */     this.jPanel105.setBackground(new Color(255, 255, 255));
/*  1909 */     this.jPanel105.setLayout(new GridLayout(1, 6, 6, 0));
/*       */     
/*  1911 */     this.jLabel70.setFont(new Font("SF UI Display Light", 1, 12));
/*  1912 */     this.jLabel70.setText(" Origen");
/*  1913 */     this.jPanel105.add(this.jLabel70);
/*       */     
/*  1915 */     this.jComboBox100.setBackground(new Color(244, 244, 244));
/*  1916 */     this.jComboBox100.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1918 */             GuiasForm.this.jComboBox100ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1921 */     this.jPanel105.add(this.jComboBox100);
/*       */     
/*  1923 */     this.jLabel72.setFont(new Font("SF UI Display Light", 1, 12));
/*  1924 */     this.jLabel72.setHorizontalAlignment(0);
/*  1925 */     this.jLabel72.setText("Destino");
/*  1926 */     this.jPanel105.add(this.jLabel72);
/*       */     
/*  1928 */     this.jComboBox101.setBackground(new Color(244, 244, 244));
/*  1929 */     this.jComboBox101.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1931 */             GuiasForm.this.jComboBox101ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1934 */     this.jPanel105.add(this.jComboBox101);
/*       */     
/*  1936 */     this.jPanel114.setBackground(new Color(255, 255, 255));
/*       */     
/*  1938 */     GroupLayout jPanel114Layout = new GroupLayout(this.jPanel114);
/*  1939 */     this.jPanel114.setLayout(jPanel114Layout);
/*  1940 */     jPanel114Layout.setHorizontalGroup(jPanel114Layout
/*  1941 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1942 */         .addGap(0, 128, 32767));
/*       */     
/*  1944 */     jPanel114Layout.setVerticalGroup(jPanel114Layout
/*  1945 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1946 */         .addGap(0, 24, 32767));
/*       */ 
/*       */     
/*  1949 */     this.jPanel105.add(this.jPanel114);
/*       */     
/*  1951 */     this.jPanel115.setBackground(new Color(255, 255, 255));
/*       */     
/*  1953 */     GroupLayout jPanel115Layout = new GroupLayout(this.jPanel115);
/*  1954 */     this.jPanel115.setLayout(jPanel115Layout);
/*  1955 */     jPanel115Layout.setHorizontalGroup(jPanel115Layout
/*  1956 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1957 */         .addGap(0, 128, 32767));
/*       */     
/*  1959 */     jPanel115Layout.setVerticalGroup(jPanel115Layout
/*  1960 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1961 */         .addGap(0, 24, 32767));
/*       */ 
/*       */     
/*  1964 */     this.jPanel105.add(this.jPanel115);
/*       */     
/*  1966 */     this.jPanel84.add(this.jPanel105);
/*       */     
/*  1968 */     this.jCheckBox4.setText("Material Peligroso");
/*  1969 */     this.jCheckBox4.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1971 */             GuiasForm.this.jCheckBox4ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1975 */     this.jPanel77.setBackground(new Color(255, 255, 255));
/*  1976 */     this.jPanel77.setLayout(new GridLayout(2, 0, 0, 6));
/*       */     
/*  1978 */     this.jPanel121.setBackground(new Color(255, 255, 255));
/*  1979 */     this.jPanel121.setLayout((LayoutManager)null);
/*       */     
/*  1981 */     this.jLabel84.setText(" Clave");
/*  1982 */     this.jPanel121.add(this.jLabel84);
/*  1983 */     this.jLabel84.setBounds(0, 0, 130, 24);
/*       */     
/*  1985 */     this.jPanel122.setBackground(new Color(255, 255, 255));
/*       */     
/*  1987 */     this.jButton104.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  1988 */     this.jButton104.setMnemonic('F');
/*  1989 */     this.jButton104.setToolTipText("Filtrar información (Alt+F)");
/*  1990 */     this.jButton104.setEnabled(false);
/*  1991 */     this.jButton104.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1993 */             GuiasForm.this.jButton104ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1997 */     this.jTextField110.setText("jTextField110");
/*  1998 */     this.jTextField110.setEnabled(false);
/*  1999 */     this.jTextField110.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2001 */             GuiasForm.this.jTextField110ActionPerformed(evt);
/*       */           }
/*       */         });
/*  2004 */     this.jTextField110.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  2006 */             GuiasForm.this.jTextField110KeyReleased(evt);
/*       */           }
/*       */         });
/*       */     
/*  2010 */     GroupLayout jPanel122Layout = new GroupLayout(this.jPanel122);
/*  2011 */     this.jPanel122.setLayout(jPanel122Layout);
/*  2012 */     jPanel122Layout.setHorizontalGroup(jPanel122Layout
/*  2013 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2014 */         .addGroup(jPanel122Layout.createSequentialGroup()
/*  2015 */           .addComponent(this.jTextField110, -1, 105, 32767)
/*  2016 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2017 */           .addComponent(this.jButton104, -2, 19, -2)));
/*       */     
/*  2019 */     jPanel122Layout.setVerticalGroup(jPanel122Layout
/*  2020 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2021 */         .addGroup(jPanel122Layout.createSequentialGroup()
/*  2022 */           .addGroup(jPanel122Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  2023 */             .addComponent(this.jButton104, -1, -1, 32767)
/*  2024 */             .addComponent(this.jTextField110))
/*  2025 */           .addGap(0, 0, 32767)));
/*       */ 
/*       */     
/*  2028 */     this.jPanel121.add(this.jPanel122);
/*  2029 */     this.jPanel122.setBounds(136, 0, 130, 29);
/*       */     
/*  2031 */     this.jLabel85.setHorizontalAlignment(0);
/*  2032 */     this.jLabel85.setText("Descripción");
/*  2033 */     this.jPanel121.add(this.jLabel85);
/*  2034 */     this.jLabel85.setBounds(272, 0, 120, 24);
/*       */     
/*  2036 */     this.jTextField111.setText("jTextField111");
/*  2037 */     this.jTextField111.setEnabled(false);
/*  2038 */     this.jPanel121.add(this.jTextField111);
/*  2039 */     this.jTextField111.setBounds(402, 0, 390, 24);
/*       */     
/*  2041 */     this.jPanel77.add(this.jPanel121);
/*       */     
/*  2043 */     this.jPanel123.setBackground(new Color(255, 255, 255));
/*  2044 */     this.jPanel123.setLayout((LayoutManager)null);
/*       */     
/*  2046 */     this.jLabel86.setText(" Embalaje");
/*  2047 */     this.jPanel123.add(this.jLabel86);
/*  2048 */     this.jLabel86.setBounds(0, 0, 130, 24);
/*       */     
/*  2050 */     this.jPanel124.setBackground(new Color(255, 255, 255));
/*       */     
/*  2052 */     this.jButton105.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  2053 */     this.jButton105.setMnemonic('F');
/*  2054 */     this.jButton105.setToolTipText("Filtrar información (Alt+F)");
/*  2055 */     this.jButton105.setEnabled(false);
/*  2056 */     this.jButton105.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2058 */             GuiasForm.this.jButton105ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2062 */     this.jTextField112.setText("jTextField112");
/*  2063 */     this.jTextField112.setEnabled(false);
/*  2064 */     this.jTextField112.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2066 */             GuiasForm.this.jTextField112ActionPerformed(evt);
/*       */           }
/*       */         });
/*  2069 */     this.jTextField112.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  2071 */             GuiasForm.this.jTextField112KeyReleased(evt);
/*       */           }
/*       */         });
/*       */     
/*  2075 */     GroupLayout jPanel124Layout = new GroupLayout(this.jPanel124);
/*  2076 */     this.jPanel124.setLayout(jPanel124Layout);
/*  2077 */     jPanel124Layout.setHorizontalGroup(jPanel124Layout
/*  2078 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2079 */         .addGroup(jPanel124Layout.createSequentialGroup()
/*  2080 */           .addComponent(this.jTextField112, -1, 105, 32767)
/*  2081 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2082 */           .addComponent(this.jButton105, -2, 19, -2)));
/*       */     
/*  2084 */     jPanel124Layout.setVerticalGroup(jPanel124Layout
/*  2085 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2086 */         .addGroup(jPanel124Layout.createSequentialGroup()
/*  2087 */           .addGroup(jPanel124Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  2088 */             .addComponent(this.jButton105, -1, -1, 32767)
/*  2089 */             .addComponent(this.jTextField112))
/*  2090 */           .addGap(0, 0, 32767)));
/*       */ 
/*       */     
/*  2093 */     this.jPanel123.add(this.jPanel124);
/*  2094 */     this.jPanel124.setBounds(136, 0, 130, 29);
/*       */     
/*  2096 */     this.jLabel87.setHorizontalAlignment(0);
/*  2097 */     this.jLabel87.setText("Descripción");
/*  2098 */     this.jPanel123.add(this.jLabel87);
/*  2099 */     this.jLabel87.setBounds(272, 0, 120, 24);
/*       */     
/*  2101 */     this.jTextField113.setText("jTextField113");
/*  2102 */     this.jTextField113.setEnabled(false);
/*  2103 */     this.jPanel123.add(this.jTextField113);
/*  2104 */     this.jTextField113.setBounds(402, 0, 390, 24);
/*       */     
/*  2106 */     this.jPanel77.add(this.jPanel123);
/*       */     
/*  2108 */     this.jCheckBox5.setText("Aranceles del Extranjero");
/*  2109 */     this.jCheckBox5.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2111 */             GuiasForm.this.jCheckBox5ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2115 */     this.jPanel127.setBackground(new Color(255, 255, 255));
/*  2116 */     this.jPanel127.setLayout(new GridLayout(1, 6, 6, 0));
/*       */     
/*  2118 */     this.jLabel77.setText(" Clave");
/*  2119 */     this.jPanel127.add(this.jLabel77);
/*       */     
/*  2121 */     this.jPanel128.setBackground(new Color(255, 255, 255));
/*       */     
/*  2123 */     this.jButton106.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  2124 */     this.jButton106.setMnemonic('F');
/*  2125 */     this.jButton106.setToolTipText("Filtrar información (Alt+F)");
/*  2126 */     this.jButton106.setEnabled(false);
/*  2127 */     this.jButton106.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2129 */             GuiasForm.this.jButton106ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2133 */     this.jTextField114.setText("jTextField114");
/*  2134 */     this.jTextField114.setEnabled(false);
/*  2135 */     this.jTextField114.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2137 */             GuiasForm.this.jTextField114ActionPerformed(evt);
/*       */           }
/*       */         });
/*  2140 */     this.jTextField114.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  2142 */             GuiasForm.this.jTextField114KeyReleased(evt);
/*       */           }
/*       */         });
/*       */     
/*  2146 */     GroupLayout jPanel128Layout = new GroupLayout(this.jPanel128);
/*  2147 */     this.jPanel128.setLayout(jPanel128Layout);
/*  2148 */     jPanel128Layout.setHorizontalGroup(jPanel128Layout
/*  2149 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2150 */         .addGroup(jPanel128Layout.createSequentialGroup()
/*  2151 */           .addComponent(this.jTextField114, -1, 103, 32767)
/*  2152 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2153 */           .addComponent(this.jButton106, -2, 19, -2)));
/*       */     
/*  2155 */     jPanel128Layout.setVerticalGroup(jPanel128Layout
/*  2156 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2157 */         .addGroup(jPanel128Layout.createSequentialGroup()
/*  2158 */           .addGroup(jPanel128Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  2159 */             .addComponent(this.jButton106, -1, -1, 32767)
/*  2160 */             .addComponent(this.jTextField114))
/*  2161 */           .addGap(0, 0, 32767)));
/*       */ 
/*       */     
/*  2164 */     this.jPanel127.add(this.jPanel128);
/*       */     
/*  2166 */     this.jLabel78.setHorizontalAlignment(0);
/*  2167 */     this.jLabel78.setText("Descripción");
/*  2168 */     this.jPanel127.add(this.jLabel78);
/*       */     
/*  2170 */     this.jTextField115.setText("jTextField115");
/*  2171 */     this.jTextField115.setEnabled(false);
/*  2172 */     this.jTextField115.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2174 */             GuiasForm.this.jTextField115ActionPerformed(evt);
/*       */           }
/*       */         });
/*  2177 */     this.jTextField115.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  2179 */             GuiasForm.this.jTextField115KeyReleased(evt);
/*       */           }
/*       */         });
/*  2182 */     this.jPanel127.add(this.jTextField115);
/*       */     
/*  2184 */     this.jLabel79.setHorizontalAlignment(0);
/*  2185 */     this.jLabel79.setText("UUID");
/*  2186 */     this.jPanel127.add(this.jLabel79);
/*       */     
/*  2188 */     this.jTextField116.setText("jTextField116");
/*  2189 */     this.jTextField116.setEnabled(false);
/*  2190 */     this.jTextField116.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2192 */             GuiasForm.this.jTextField116ActionPerformed(evt);
/*       */           }
/*       */         });
/*  2195 */     this.jTextField116.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  2197 */             GuiasForm.this.jTextField116KeyReleased(evt);
/*       */           }
/*       */         });
/*  2200 */     this.jPanel127.add(this.jTextField116);
/*       */     
/*  2202 */     this.jPanel129.setBackground(new Color(255, 255, 255));
/*  2203 */     this.jPanel129.setLayout(new GridLayout(1, 6, 6, 0));
/*       */     
/*  2205 */     this.jLabel88.setText(" Contenedor 1");
/*  2206 */     this.jPanel129.add(this.jLabel88);
/*       */     
/*  2208 */     this.jButton110.setText("Agregar");
/*  2209 */     this.jButton110.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2211 */             GuiasForm.this.jButton110ActionPerformed(evt);
/*       */           }
/*       */         });
/*  2214 */     this.jPanel129.add(this.jButton110);
/*       */     
/*  2216 */     this.jLabel89.setHorizontalAlignment(0);
/*  2217 */     this.jLabel89.setText("Contenedor 2");
/*  2218 */     this.jPanel129.add(this.jLabel89);
/*       */     
/*  2220 */     this.jButton111.setText("Agregar");
/*  2221 */     this.jButton111.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2223 */             GuiasForm.this.jButton111ActionPerformed(evt);
/*       */           }
/*       */         });
/*  2226 */     this.jPanel129.add(this.jButton111);
/*       */     
/*  2228 */     this.jLabel90.setHorizontalAlignment(0);
/*  2229 */     this.jLabel90.setText("Contenedor 3");
/*  2230 */     this.jPanel129.add(this.jLabel90);
/*       */     
/*  2232 */     this.jButton112.setText("Agreagar");
/*  2233 */     this.jButton112.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2235 */             GuiasForm.this.jButton112ActionPerformed(evt);
/*       */           }
/*       */         });
/*  2238 */     this.jPanel129.add(this.jButton112);
/*       */     
/*  2240 */     GroupLayout jPanel110Layout = new GroupLayout(this.jPanel110);
/*  2241 */     this.jPanel110.setLayout(jPanel110Layout);
/*  2242 */     jPanel110Layout.setHorizontalGroup(jPanel110Layout
/*  2243 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2244 */         .addComponent(this.jPanel131, -1, 813, 32767)
/*  2245 */         .addComponent(this.jPanel95, -1, -1, 32767)
/*  2246 */         .addComponent(this.jPanel77, -1, -1, 32767)
/*  2247 */         .addGroup(jPanel110Layout.createSequentialGroup()
/*  2248 */           .addGroup(jPanel110Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2249 */             .addComponent(this.jPanel84, -2, 801, -2)
/*  2250 */             .addComponent(this.jPanel127, -2, 801, -2)
/*  2251 */             .addComponent(this.jPanel129, -2, 801, -2)
/*  2252 */             .addComponent(this.jCheckBox4, -2, 202, -2)
/*  2253 */             .addComponent(this.jCheckBox5, -2, 204, -2))
/*  2254 */           .addGap(0, 0, 32767)));
/*       */     
/*  2256 */     jPanel110Layout.setVerticalGroup(jPanel110Layout
/*  2257 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2258 */         .addGroup(jPanel110Layout.createSequentialGroup()
/*  2259 */           .addComponent(this.jPanel131, -2, -1, -2)
/*  2260 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2261 */           .addComponent(this.jPanel95, -2, -1, -2)
/*  2262 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2263 */           .addComponent(this.jPanel84, -2, -1, -2)
/*  2264 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2265 */           .addComponent(this.jPanel129, -2, 24, -2)
/*  2266 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2267 */           .addComponent(this.jCheckBox4)
/*  2268 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2269 */           .addComponent(this.jPanel77, -2, 55, -2)
/*  2270 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2271 */           .addComponent(this.jCheckBox5)
/*  2272 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2273 */           .addComponent(this.jPanel127, -2, -1, -2)
/*  2274 */           .addContainerGap(24, 32767)));
/*       */ 
/*       */     
/*  2277 */     this.jPanel130.setBackground(this.lc.SECUNDARIO2);
/*       */     
/*  2279 */     this.materialButton8.setBackground(this.lc.PRIMARIO1);
/*  2280 */     this.materialButton8.setForeground(new Color(255, 255, 255));
/*  2281 */     this.materialButton8.setMnemonic('A');
/*  2282 */     this.materialButton8.setText("Agregar");
/*  2283 */     this.materialButton8.setToolTipText("Agregar Nuevo (Alt+A)");
/*  2284 */     this.materialButton8.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/*  2285 */     this.materialButton8.setHorizontalTextPosition(0);
/*  2286 */     this.materialButton8.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2288 */             GuiasForm.this.materialButton8ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2292 */     GroupLayout jPanel130Layout = new GroupLayout(this.jPanel130);
/*  2293 */     this.jPanel130.setLayout(jPanel130Layout);
/*  2294 */     jPanel130Layout.setHorizontalGroup(jPanel130Layout
/*  2295 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2296 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel130Layout.createSequentialGroup()
/*  2297 */           .addContainerGap(-1, 32767)
/*  2298 */           .addComponent((Component)this.materialButton8, -2, 150, -2)
/*  2299 */           .addContainerGap()));
/*       */     
/*  2301 */     jPanel130Layout.setVerticalGroup(jPanel130Layout
/*  2302 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2303 */         .addGroup(jPanel130Layout.createSequentialGroup()
/*  2304 */           .addComponent((Component)this.materialButton8, -2, 38, -2)
/*  2305 */           .addGap(0, 2, 32767)));
/*       */ 
/*       */     
/*  2308 */     GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
/*  2309 */     this.jPanel15.setLayout(jPanel15Layout);
/*  2310 */     jPanel15Layout.setHorizontalGroup(jPanel15Layout
/*  2311 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2312 */         .addComponent(this.jPanel68, -1, -1, 32767)
/*  2313 */         .addComponent(this.jPanel110, -1, -1, 32767)
/*  2314 */         .addComponent(this.jPanel130, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*       */     
/*  2316 */     jPanel15Layout.setVerticalGroup(jPanel15Layout
/*  2317 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2318 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
/*  2319 */           .addComponent(this.jPanel68, -2, -1, -2)
/*  2320 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2321 */           .addComponent(this.jPanel110, -1, -1, 32767)
/*  2322 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2323 */           .addComponent(this.jPanel130, -2, -1, -2)));
/*       */ 
/*       */     
/*  2326 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/*  2327 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/*  2328 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/*  2329 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2330 */         .addGap(0, 815, 32767)
/*  2331 */         .addGroup(jDialog5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2332 */           .addComponent(this.jPanel15, -1, -1, 32767)));
/*       */     
/*  2334 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/*  2335 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2336 */         .addGap(0, 575, 32767)
/*  2337 */         .addGroup(jDialog5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2338 */           .addComponent(this.jPanel15, -1, -1, 32767)));
/*       */ 
/*       */     
/*  2341 */     this.jDialog6.setTitle("Catálogos");
/*  2342 */     this.jDialog6.setModal(true);
/*  2343 */     this.jDialog6.setUndecorated(true);
/*       */     
/*  2345 */     this.jPanel140.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO2));
/*       */     
/*  2347 */     this.rSTableMetro6.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Tipo" })
/*       */         {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*  2355 */           boolean[] canEdit = new boolean[] { false, false };
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  2360 */             return this.canEdit[columnIndex];
/*       */           }
/*       */         });
/*  2363 */     this.rSTableMetro6.setAltoHead(25);
/*  2364 */     this.rSTableMetro6.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  2365 */     this.rSTableMetro6.setColorBordeFilas(new Color(200, 200, 200));
/*  2366 */     this.rSTableMetro6.setColorBordeHead(this.lc.PRIMARIO1);
/*  2367 */     this.rSTableMetro6.setColorFilasBackgound2(new Color(239, 239, 239));
/*  2368 */     this.rSTableMetro6.setColorFilasForeground1(new Color(102, 102, 102));
/*  2369 */     this.rSTableMetro6.setColorFilasForeground2(new Color(102, 102, 102));
/*  2370 */     this.rSTableMetro6.setColorSelBackgound(new Color(237, 107, 107));
/*  2371 */     this.rSTableMetro6.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  2372 */     this.rSTableMetro6.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  2373 */     this.rSTableMetro6.setFuenteHead(new Font("Cantarell", 1, 12));
/*  2374 */     this.rSTableMetro6.setGrosorBordeFilas(0);
/*  2375 */     this.rSTableMetro6.setSelectionBackground(this.lc.PRIMARIO2);
/*  2376 */     this.rSTableMetro6.getTableHeader().setResizingAllowed(false);
/*  2377 */     this.rSTableMetro6.getTableHeader().setReorderingAllowed(false);
/*  2378 */     this.rSTableMetro6.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  2380 */             GuiasForm.this.rSTableMetro6MouseClicked(evt);
/*       */           }
/*       */         });
/*  2383 */     this.rSTableMetro6.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  2385 */             GuiasForm.this.rSTableMetro6KeyReleased(evt);
/*       */           }
/*       */         });
/*  2388 */     this.jScrollPane38.setViewportView((Component)this.rSTableMetro6);
/*       */     
/*  2390 */     this.jLabel62.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/*  2391 */     this.jLabel62.setForeground(this.lc.PRIMARIO1);
/*  2392 */     this.jLabel62.setHorizontalAlignment(4);
/*  2393 */     this.jLabel62.setText("0");
/*       */     
/*  2395 */     this.jLabel10.setText(" Clave");
/*       */     
/*  2397 */     this.jTextField120.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2399 */             GuiasForm.this.jTextField120ActionPerformed(evt);
/*       */           }
/*       */         });
/*  2402 */     this.jTextField120.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  2404 */             GuiasForm.this.jTextField120KeyReleased(evt);
/*       */           }
/*       */         });
/*       */     
/*  2408 */     this.jLabel13.setHorizontalAlignment(4);
/*  2409 */     this.jLabel13.setText("Descripción");
/*       */     
/*  2411 */     this.jTextField121.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2413 */             GuiasForm.this.jTextField121ActionPerformed(evt);
/*       */           }
/*       */         });
/*  2416 */     this.jTextField121.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  2418 */             GuiasForm.this.jTextField121KeyReleased(evt);
/*       */           }
/*       */         });
/*       */     
/*  2422 */     GroupLayout jPanel78Layout = new GroupLayout(this.jPanel78);
/*  2423 */     this.jPanel78.setLayout(jPanel78Layout);
/*  2424 */     jPanel78Layout.setHorizontalGroup(jPanel78Layout
/*  2425 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2426 */         .addGroup(jPanel78Layout.createSequentialGroup()
/*  2427 */           .addGap(1, 1, 1)
/*  2428 */           .addComponent(this.jLabel10, -2, 59, -2)
/*  2429 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2430 */           .addComponent(this.jTextField120, -2, 96, -2)
/*  2431 */           .addGap(18, 18, 18)
/*  2432 */           .addComponent(this.jLabel13, -2, 80, -2)
/*  2433 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2434 */           .addComponent(this.jTextField121, -1, 130, 32767)));
/*       */     
/*  2436 */     jPanel78Layout.setVerticalGroup(jPanel78Layout
/*  2437 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2438 */         .addGroup(jPanel78Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2439 */           .addComponent(this.jLabel10, -2, 21, -2)
/*  2440 */           .addComponent(this.jTextField120, -2, -1, -2)
/*  2441 */           .addComponent(this.jLabel13, -2, 21, -2))
/*  2442 */         .addComponent(this.jTextField121, -2, -1, -2));
/*       */ 
/*       */     
/*  2445 */     GroupLayout jPanel140Layout = new GroupLayout(this.jPanel140);
/*  2446 */     this.jPanel140.setLayout(jPanel140Layout);
/*  2447 */     jPanel140Layout.setHorizontalGroup(jPanel140Layout
/*  2448 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2449 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel140Layout.createSequentialGroup()
/*  2450 */           .addContainerGap(-1, 32767)
/*  2451 */           .addComponent(this.jLabel62, -2, 119, -2)
/*  2452 */           .addContainerGap())
/*  2453 */         .addGroup(jPanel140Layout.createSequentialGroup()
/*  2454 */           .addGroup(jPanel140Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  2455 */             .addComponent(this.jScrollPane38, GroupLayout.Alignment.LEADING, -2, 0, 32767)
/*  2456 */             .addComponent(this.jPanel78, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/*  2457 */           .addGap(6, 6, 6)));
/*       */     
/*  2459 */     jPanel140Layout.setVerticalGroup(jPanel140Layout
/*  2460 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2461 */         .addGroup(jPanel140Layout.createSequentialGroup()
/*  2462 */           .addComponent(this.jPanel78, -2, -1, -2)
/*  2463 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2464 */           .addComponent(this.jScrollPane38, -1, 194, 32767)
/*  2465 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2466 */           .addComponent(this.jLabel62)
/*  2467 */           .addGap(8, 8, 8)));
/*       */ 
/*       */     
/*  2470 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/*  2471 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/*  2472 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/*  2473 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2474 */         .addComponent(this.jPanel140, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*       */     
/*  2476 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/*  2477 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2478 */         .addGroup(jDialog6Layout.createSequentialGroup()
/*  2479 */           .addComponent(this.jPanel140, -1, -1, 32767)
/*  2480 */           .addGap(0, 0, 0)));
/*       */ 
/*       */     
/*  2483 */     this.jDialog7.setTitle("Contenedores");
/*  2484 */     this.jDialog7.setModal(true);
/*  2485 */     this.jDialog7.setUndecorated(true);
/*       */     
/*  2487 */     this.jPanel85.setBackground(this.lc.SECUNDARIO1);
/*       */     
/*  2489 */     this.jLabel64.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 12.0F));
/*  2490 */     this.jLabel64.setForeground(new Color(255, 255, 255));
/*  2491 */     this.jLabel64.setHorizontalAlignment(0);
/*  2492 */     this.jLabel64.setText("Contenedores");
/*  2493 */     this.jLabel64.addMouseMotionListener(new MouseMotionAdapter() {
/*       */           public void mouseDragged(MouseEvent evt) {
/*  2495 */             GuiasForm.this.jLabel64MouseDragged(evt);
/*       */           }
/*       */         });
/*  2498 */     this.jLabel64.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  2500 */             GuiasForm.this.jLabel64MouseClicked(evt);
/*       */           }
/*       */         });
/*       */     
/*  2504 */     this.jPanel86.setBackground(this.lc.PRIMARIO1);
/*  2505 */     this.jPanel86.setLayout(new GridLayout(1, 0));
/*       */     
/*  2507 */     this.jLabel131.setHorizontalAlignment(0);
/*  2508 */     this.jLabel131.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*  2509 */     this.jLabel131.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  2511 */             GuiasForm.this.jLabel131MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  2514 */             GuiasForm.this.jLabel131MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  2517 */             GuiasForm.this.jLabel131MouseExited(evt);
/*       */           }
/*       */         });
/*  2520 */     this.jPanel86.add(this.jLabel131);
/*       */     
/*  2522 */     GroupLayout jPanel85Layout = new GroupLayout(this.jPanel85);
/*  2523 */     this.jPanel85.setLayout(jPanel85Layout);
/*  2524 */     jPanel85Layout.setHorizontalGroup(jPanel85Layout
/*  2525 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2526 */         .addGroup(jPanel85Layout.createSequentialGroup()
/*  2527 */           .addComponent(this.jLabel64, -1, -1, 32767)
/*  2528 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2529 */           .addComponent(this.jPanel86, -2, 34, -2)));
/*       */     
/*  2531 */     jPanel85Layout.setVerticalGroup(jPanel85Layout
/*  2532 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2533 */         .addComponent(this.jPanel86, -1, 22, 32767)
/*  2534 */         .addComponent(this.jLabel64, -1, -1, 32767));
/*       */ 
/*       */     
/*  2537 */     this.materialButton6.setBackground(this.lc.PRIMARIO1);
/*  2538 */     this.materialButton6.setForeground(new Color(255, 255, 255));
/*  2539 */     this.materialButton6.setMnemonic('I');
/*  2540 */     this.materialButton6.setText("Ingresar");
/*  2541 */     this.materialButton6.setToolTipText("Ingresar (Alt+I)");
/*  2542 */     this.materialButton6.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/*  2543 */     this.materialButton6.setHorizontalTextPosition(0);
/*  2544 */     this.materialButton6.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2546 */             GuiasForm.this.materialButton6ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2550 */     this.jLabel74.setFont(new Font("SF UI Display Light", 1, 12));
/*  2551 */     this.jLabel74.setHorizontalAlignment(2);
/*  2552 */     this.jLabel74.setText("Matricula");
/*       */     
/*  2554 */     this.jTextField122.setText("jTextField122");
/*       */     
/*  2556 */     this.jLabel75.setFont(new Font("SF UI Display Light", 1, 12));
/*  2557 */     this.jLabel75.setHorizontalAlignment(2);
/*  2558 */     this.jLabel75.setText("Tipo");
/*       */     
/*  2560 */     this.jComboBox102.setBackground(new Color(255, 255, 255));
/*  2561 */     this.jComboBox102.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2563 */             GuiasForm.this.jComboBox102ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2567 */     this.jLabel76.setHorizontalAlignment(2);
/*  2568 */     this.jLabel76.setText("Precinto o Sello");
/*       */     
/*  2570 */     this.jTextField123.setText("jTextField123");
/*       */     
/*  2572 */     this.jLabel91.setHorizontalAlignment(2);
/*  2573 */     this.jLabel91.setText("Otros datos");
/*       */     
/*  2575 */     this.jTextField124.setText("jTextField124");
/*       */     
/*  2577 */     GroupLayout jPanel87Layout = new GroupLayout(this.jPanel87);
/*  2578 */     this.jPanel87.setLayout(jPanel87Layout);
/*  2579 */     jPanel87Layout.setHorizontalGroup(jPanel87Layout
/*  2580 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2581 */         .addGroup(jPanel87Layout.createSequentialGroup()
/*  2582 */           .addGap(10, 10, 10)
/*  2583 */           .addGroup(jPanel87Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2584 */             .addGroup(jPanel87Layout.createSequentialGroup()
/*  2585 */               .addComponent(this.jLabel74, -1, -1, 32767)
/*  2586 */               .addGap(18, 18, 18))
/*  2587 */             .addGroup(jPanel87Layout.createSequentialGroup()
/*  2588 */               .addComponent(this.jLabel75, -1, -1, 32767)
/*  2589 */               .addGap(18, 18, 18))
/*  2590 */             .addGroup(jPanel87Layout.createSequentialGroup()
/*  2591 */               .addComponent(this.jLabel76, -1, -1, 32767)
/*  2592 */               .addGap(18, 18, 18))
/*  2593 */             .addGroup(jPanel87Layout.createSequentialGroup()
/*  2594 */               .addComponent(this.jLabel91, -1, -1, 32767)
/*  2595 */               .addGap(18, 18, 18)))
/*  2596 */           .addGroup(jPanel87Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2597 */             .addComponent(this.jTextField124, -1, 178, 32767)
/*  2598 */             .addComponent(this.jTextField123)
/*  2599 */             .addComponent(this.jComboBox102, 0, -1, 32767)
/*  2600 */             .addComponent(this.jTextField122))
/*  2601 */           .addGap(10, 10, 10)));
/*       */     
/*  2603 */     jPanel87Layout.setVerticalGroup(jPanel87Layout
/*  2604 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2605 */         .addGroup(jPanel87Layout.createSequentialGroup()
/*  2606 */           .addGroup(jPanel87Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2607 */             .addGroup(jPanel87Layout.createSequentialGroup()
/*  2608 */               .addGap(3, 3, 3)
/*  2609 */               .addComponent(this.jLabel74))
/*  2610 */             .addComponent(this.jTextField122, -2, -1, -2))
/*  2611 */           .addGap(5, 5, 5)
/*  2612 */           .addGroup(jPanel87Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2613 */             .addGroup(jPanel87Layout.createSequentialGroup()
/*  2614 */               .addGap(3, 3, 3)
/*  2615 */               .addComponent(this.jLabel75))
/*  2616 */             .addComponent(this.jComboBox102, -2, -1, -2))
/*  2617 */           .addGap(5, 5, 5)
/*  2618 */           .addGroup(jPanel87Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2619 */             .addGroup(jPanel87Layout.createSequentialGroup()
/*  2620 */               .addGap(3, 3, 3)
/*  2621 */               .addComponent(this.jLabel76))
/*  2622 */             .addComponent(this.jTextField123, -2, -1, -2))
/*  2623 */           .addGap(5, 5, 5)
/*  2624 */           .addGroup(jPanel87Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2625 */             .addGroup(jPanel87Layout.createSequentialGroup()
/*  2626 */               .addGap(3, 3, 3)
/*  2627 */               .addComponent(this.jLabel91))
/*  2628 */             .addComponent(this.jTextField124, -2, -1, -2))));
/*       */ 
/*       */     
/*  2631 */     GroupLayout jPanel141Layout = new GroupLayout(this.jPanel141);
/*  2632 */     this.jPanel141.setLayout(jPanel141Layout);
/*  2633 */     jPanel141Layout.setHorizontalGroup(jPanel141Layout
/*  2634 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2635 */         .addComponent(this.jPanel85, -1, -1, 32767)
/*  2636 */         .addGroup(jPanel141Layout.createSequentialGroup()
/*  2637 */           .addContainerGap(-1, 32767)
/*  2638 */           .addComponent((Component)this.materialButton6, -2, 150, -2)
/*  2639 */           .addContainerGap())
/*  2640 */         .addComponent(this.jPanel87, -1, -1, 32767));
/*       */     
/*  2642 */     jPanel141Layout.setVerticalGroup(jPanel141Layout
/*  2643 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2644 */         .addGroup(jPanel141Layout.createSequentialGroup()
/*  2645 */           .addComponent(this.jPanel85, -2, -1, -2)
/*  2646 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2647 */           .addComponent(this.jPanel87, -1, -1, 32767)
/*  2648 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2649 */           .addComponent((Component)this.materialButton6, -2, 38, -2)
/*  2650 */           .addContainerGap()));
/*       */ 
/*       */     
/*  2653 */     GroupLayout jDialog7Layout = new GroupLayout(this.jDialog7.getContentPane());
/*  2654 */     this.jDialog7.getContentPane().setLayout(jDialog7Layout);
/*  2655 */     jDialog7Layout.setHorizontalGroup(jDialog7Layout
/*  2656 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2657 */         .addComponent(this.jPanel141, -1, -1, 32767));
/*       */     
/*  2659 */     jDialog7Layout.setVerticalGroup(jDialog7Layout
/*  2660 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2661 */         .addComponent(this.jPanel141, -1, -1, 32767));
/*       */ 
/*       */     
/*  2664 */     this.jDialog8.setTitle("Licencia Vencida");
/*  2665 */     this.jDialog8.setModal(true);
/*       */     
/*  2667 */     this.jPanel88.setBackground(new Color(255, 255, 255));
/*       */     
/*  2669 */     this.jLabel97.setFont(new Font("Tahoma", 1, 17));
/*  2670 */     this.jLabel97.setForeground(new Color(0, 102, 102));
/*  2671 */     this.jLabel97.setHorizontalAlignment(0);
/*  2672 */     this.jLabel97.setText("Próximo Vencimiento de Licencia");
/*       */     
/*  2674 */     this.jLabel98.setFont(new Font("Tahoma", 1, 15));
/*  2675 */     this.jLabel98.setForeground(Color.red);
/*  2676 */     this.jLabel98.setHorizontalAlignment(0);
/*  2677 */     this.jLabel98.setText("<html><center>LA LICENCIA DEL OPERADOR QUE SELECCIONASTE ESTÁ PRÓXIMA A VENCER</center></html>");
/*       */     
/*  2679 */     this.jLabel99.setFont(new Font("Tahoma", 3, 11));
/*  2680 */     this.jLabel99.setHorizontalAlignment(0);
/*  2681 */     this.jLabel99.setText("<html><center>La vigencia de la licencia se vencerá en menos de un mes, si no se renueva no se podrá dar viajes en éste módulo.</center></html>");
/*       */     
/*  2683 */     this.jLabel100.setHorizontalAlignment(0);
/*  2684 */     this.jLabel100.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/credit-card.png")));
/*       */     
/*  2686 */     this.materialButton7.setBackground(this.lc.SECUNDARIO1);
/*  2687 */     this.materialButton7.setForeground(new Color(255, 255, 255));
/*  2688 */     this.materialButton7.setMnemonic('R');
/*  2689 */     this.materialButton7.setText("Cerrar");
/*  2690 */     this.materialButton7.setToolTipText("Cerrar (Alt+R)");
/*  2691 */     this.materialButton7.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/*  2692 */     this.materialButton7.setHorizontalTextPosition(0);
/*  2693 */     this.materialButton7.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2695 */             GuiasForm.this.materialButton7ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2699 */     GroupLayout jPanel88Layout = new GroupLayout(this.jPanel88);
/*  2700 */     this.jPanel88.setLayout(jPanel88Layout);
/*  2701 */     jPanel88Layout.setHorizontalGroup(jPanel88Layout
/*  2702 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2703 */         .addGroup(jPanel88Layout.createSequentialGroup()
/*  2704 */           .addContainerGap()
/*  2705 */           .addGroup(jPanel88Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  2706 */             .addComponent(this.jSeparator9, GroupLayout.Alignment.LEADING, -1, 628, 32767)
/*  2707 */             .addComponent(this.jLabel97, GroupLayout.Alignment.LEADING, -1, 628, 32767)
/*  2708 */             .addGroup(jPanel88Layout.createSequentialGroup()
/*  2709 */               .addComponent(this.jLabel100, -1, 155, 32767)
/*  2710 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  2711 */               .addGroup(jPanel88Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2712 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel88Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  2713 */                   .addComponent(this.jLabel99, GroupLayout.Alignment.TRAILING, 0, 0, 32767)
/*  2714 */                   .addComponent(this.jLabel98, GroupLayout.Alignment.TRAILING, -1, 466, 32767))
/*  2715 */                 .addComponent((Component)this.materialButton7, GroupLayout.Alignment.TRAILING, -2, 105, -2))))
/*  2716 */           .addContainerGap()));
/*       */     
/*  2718 */     jPanel88Layout.setVerticalGroup(jPanel88Layout
/*  2719 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2720 */         .addGroup(jPanel88Layout.createSequentialGroup()
/*  2721 */           .addComponent(this.jLabel97)
/*  2722 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2723 */           .addComponent(this.jSeparator9, -2, 10, -2)
/*  2724 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2725 */           .addGroup(jPanel88Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2726 */             .addGroup(jPanel88Layout.createSequentialGroup()
/*  2727 */               .addComponent(this.jLabel100, -2, 167, -2)
/*  2728 */               .addContainerGap())
/*  2729 */             .addGroup(jPanel88Layout.createSequentialGroup()
/*  2730 */               .addComponent(this.jLabel98, -2, 69, -2)
/*  2731 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2732 */               .addComponent(this.jLabel99, -2, 44, -2)
/*  2733 */               .addGap(16, 16, 16)
/*  2734 */               .addComponent((Component)this.materialButton7, -1, -1, 32767)))));
/*       */ 
/*       */     
/*  2737 */     GroupLayout jDialog8Layout = new GroupLayout(this.jDialog8.getContentPane());
/*  2738 */     this.jDialog8.getContentPane().setLayout(jDialog8Layout);
/*  2739 */     jDialog8Layout.setHorizontalGroup(jDialog8Layout
/*  2740 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2741 */         .addComponent(this.jPanel88, -1, -1, 32767));
/*       */     
/*  2743 */     jDialog8Layout.setVerticalGroup(jDialog8Layout
/*  2744 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2745 */         .addComponent(this.jPanel88, -2, -1, -2));
/*       */ 
/*       */     
/*  2748 */     this.jDialog9.setTitle("Ruta del Timbrado");
/*  2749 */     this.jDialog9.setModal(true);
/*       */     
/*  2751 */     this.materialButton40.setBackground(this.lc.PRIMARIO1);
/*  2752 */     this.materialButton40.setForeground(new Color(255, 255, 255));
/*  2753 */     this.materialButton40.setMnemonic('T');
/*  2754 */     this.materialButton40.setText("Predeterminada");
/*  2755 */     this.materialButton40.setToolTipText("Timbrar CFDI (Alt+T)");
/*  2756 */     this.materialButton40.setFont(new Font("Cantarell", 0, 12));
/*  2757 */     this.materialButton40.setHorizontalTextPosition(0);
/*  2758 */     this.materialButton40.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2760 */             GuiasForm.this.materialButton40ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2764 */     this.materialButton41.setBackground(this.lc.PRIMARIO1);
/*  2765 */     this.materialButton41.setForeground(new Color(255, 255, 255));
/*  2766 */     this.materialButton41.setMnemonic('T');
/*  2767 */     this.materialButton41.setText("Nueva");
/*  2768 */     this.materialButton41.setToolTipText("Timbrar CFDI (Alt+T)");
/*  2769 */     this.materialButton41.setFont(new Font("Cantarell", 0, 12));
/*  2770 */     this.materialButton41.setHorizontalTextPosition(0);
/*  2771 */     this.materialButton41.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2773 */             GuiasForm.this.materialButton41ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2777 */     this.jTextField41.setEditable(false);
/*       */     
/*  2779 */     GroupLayout jPanel172Layout = new GroupLayout(this.jPanel172);
/*  2780 */     this.jPanel172.setLayout(jPanel172Layout);
/*  2781 */     jPanel172Layout.setHorizontalGroup(jPanel172Layout
/*  2782 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2783 */         .addGroup(jPanel172Layout.createSequentialGroup()
/*  2784 */           .addContainerGap()
/*  2785 */           .addGroup(jPanel172Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2786 */             .addGroup(jPanel172Layout.createSequentialGroup()
/*  2787 */               .addComponent((Component)this.materialButton40, -2, 150, -2)
/*  2788 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2789 */               .addComponent(this.jTextField41, -1, 256, 32767))
/*  2790 */             .addGroup(jPanel172Layout.createSequentialGroup()
/*  2791 */               .addComponent((Component)this.materialButton41, -2, 150, -2)
/*  2792 */               .addGap(0, 0, 32767)))
/*  2793 */           .addContainerGap()));
/*       */     
/*  2795 */     jPanel172Layout.setVerticalGroup(jPanel172Layout
/*  2796 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2797 */         .addGroup(jPanel172Layout.createSequentialGroup()
/*  2798 */           .addContainerGap()
/*  2799 */           .addGroup(jPanel172Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2800 */             .addComponent((Component)this.materialButton40, -2, 38, -2)
/*  2801 */             .addComponent(this.jTextField41, -2, -1, -2))
/*  2802 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2803 */           .addComponent((Component)this.materialButton41, -2, 38, -2)
/*  2804 */           .addContainerGap(-1, 32767)));
/*       */ 
/*       */     
/*  2807 */     GroupLayout jDialog9Layout = new GroupLayout(this.jDialog9.getContentPane());
/*  2808 */     this.jDialog9.getContentPane().setLayout(jDialog9Layout);
/*  2809 */     jDialog9Layout.setHorizontalGroup(jDialog9Layout
/*  2810 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2811 */         .addComponent(this.jPanel172, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*       */     
/*  2813 */     jDialog9Layout.setVerticalGroup(jDialog9Layout
/*  2814 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2815 */         .addComponent(this.jPanel172, -2, -1, -2));
/*       */ 
/*       */     
/*  2818 */     this.jDialog10.setTitle("Tipo de Manifiesto");
/*  2819 */     this.jDialog10.setModal(true);
/*  2820 */     this.jDialog10.setUndecorated(true);
/*       */     
/*  2822 */     this.rSTableMetro7.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Tipo" })
/*       */         {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*  2830 */           boolean[] canEdit = new boolean[] { false, false };
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  2835 */             return this.canEdit[columnIndex];
/*       */           }
/*       */         });
/*  2838 */     this.rSTableMetro7.setAltoHead(25);
/*  2839 */     this.rSTableMetro7.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  2840 */     this.rSTableMetro7.setColorBordeFilas(new Color(200, 200, 200));
/*  2841 */     this.rSTableMetro7.setColorBordeHead(this.lc.PRIMARIO1);
/*  2842 */     this.rSTableMetro7.setColorFilasBackgound2(new Color(239, 239, 239));
/*  2843 */     this.rSTableMetro7.setColorFilasForeground1(new Color(102, 102, 102));
/*  2844 */     this.rSTableMetro7.setColorFilasForeground2(new Color(102, 102, 102));
/*  2845 */     this.rSTableMetro7.setColorSelBackgound(new Color(237, 107, 107));
/*  2846 */     this.rSTableMetro7.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  2847 */     this.rSTableMetro7.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  2848 */     this.rSTableMetro7.setFuenteHead(new Font("Cantarell", 1, 12));
/*  2849 */     this.rSTableMetro7.setGrosorBordeFilas(0);
/*  2850 */     this.rSTableMetro7.setSelectionBackground(this.lc.PRIMARIO2);
/*  2851 */     this.rSTableMetro7.getTableHeader().setResizingAllowed(false);
/*  2852 */     this.rSTableMetro7.getTableHeader().setReorderingAllowed(false);
/*  2853 */     this.rSTableMetro7.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  2855 */             GuiasForm.this.rSTableMetro7MouseClicked(evt);
/*       */           }
/*       */         });
/*  2858 */     this.rSTableMetro7.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  2860 */             GuiasForm.this.rSTableMetro7KeyReleased(evt);
/*       */           }
/*       */         });
/*  2863 */     this.jScrollPane39.setViewportView((Component)this.rSTableMetro7);
/*       */     
/*  2865 */     this.jButton64.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/*  2866 */     this.jButton64.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2868 */             GuiasForm.this.jButton64ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2872 */     this.jButton65.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/*  2873 */     this.jButton65.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2875 */             GuiasForm.this.jButton65ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2879 */     this.jButton66.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/*  2880 */     this.jButton66.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2882 */             GuiasForm.this.jButton66ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2886 */     this.jTextField83.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2888 */             GuiasForm.this.jTextField83ActionPerformed(evt);
/*       */           }
/*       */         });
/*  2891 */     this.jTextField83.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  2893 */             GuiasForm.this.jTextField83KeyReleased(evt);
/*       */           }
/*       */         });
/*       */     
/*  2897 */     GroupLayout jPanel142Layout = new GroupLayout(this.jPanel142);
/*  2898 */     this.jPanel142.setLayout(jPanel142Layout);
/*  2899 */     jPanel142Layout.setHorizontalGroup(jPanel142Layout
/*  2900 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2901 */         .addComponent(this.jScrollPane39, -1, 418, 32767)
/*  2902 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel142Layout.createSequentialGroup()
/*  2903 */           .addContainerGap()
/*  2904 */           .addComponent(this.jTextField83, -2, 179, -2)
/*  2905 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  2906 */           .addComponent(this.jButton64)
/*  2907 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2908 */           .addComponent(this.jButton65)
/*  2909 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2910 */           .addComponent(this.jButton66)
/*  2911 */           .addContainerGap()));
/*       */     
/*  2913 */     jPanel142Layout.setVerticalGroup(jPanel142Layout
/*  2914 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2915 */         .addGroup(jPanel142Layout.createSequentialGroup()
/*  2916 */           .addComponent(this.jScrollPane39, -1, 172, 32767)
/*  2917 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2918 */           .addGroup(jPanel142Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2919 */             .addComponent(this.jButton64, -2, 26, -2)
/*  2920 */             .addComponent(this.jButton65, -2, 26, -2)
/*  2921 */             .addComponent(this.jButton66, -2, 26, -2)
/*  2922 */             .addComponent(this.jTextField83, -2, -1, -2))));
/*       */ 
/*       */     
/*  2925 */     GroupLayout jDialog10Layout = new GroupLayout(this.jDialog10.getContentPane());
/*  2926 */     this.jDialog10.getContentPane().setLayout(jDialog10Layout);
/*  2927 */     jDialog10Layout.setHorizontalGroup(jDialog10Layout
/*  2928 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2929 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog10Layout.createSequentialGroup()
/*  2930 */           .addGap(0, 0, 0)
/*  2931 */           .addComponent(this.jPanel142, -1, -1, 32767)));
/*       */     
/*  2933 */     jDialog10Layout.setVerticalGroup(jDialog10Layout
/*  2934 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2935 */         .addGroup(jDialog10Layout.createSequentialGroup()
/*  2936 */           .addComponent(this.jPanel142, -1, -1, 32767)
/*  2937 */           .addGap(0, 0, 0)));
/*       */ 
/*       */     
/*  2940 */     this.jDialog11.setTitle("Manifiestos");
/*  2941 */     this.jDialog11.setModal(true);
/*       */     
/*  2943 */     this.jLabel94.setText("Ingresa el tipo de residuo o carga");
/*       */     
/*  2945 */     this.jTextField43.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2947 */             GuiasForm.this.jTextField43ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2951 */     this.materialButton10.setBackground(this.lc.SECUNDARIO1);
/*  2952 */     this.materialButton10.setForeground(new Color(255, 255, 255));
/*  2953 */     this.materialButton10.setMnemonic('C');
/*  2954 */     this.materialButton10.setText("Cerrar");
/*  2955 */     this.materialButton10.setToolTipText("Cerrar (Alt+C)");
/*  2956 */     this.materialButton10.setFont(new Font("Cantarell", 0, 12));
/*  2957 */     this.materialButton10.setHorizontalTextPosition(0);
/*  2958 */     this.materialButton10.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2960 */             GuiasForm.this.materialButton10ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2964 */     this.materialButton11.setBackground(this.lc.PRIMARIO1);
/*  2965 */     this.materialButton11.setForeground(new Color(255, 255, 255));
/*  2966 */     this.materialButton11.setMnemonic('G');
/*  2967 */     this.materialButton11.setText("Guardar");
/*  2968 */     this.materialButton11.setToolTipText("Guardar (Alt +G)");
/*  2969 */     this.materialButton11.setFont(new Font("Cantarell", 0, 12));
/*  2970 */     this.materialButton11.setHorizontalTextPosition(0);
/*  2971 */     this.materialButton11.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2973 */             GuiasForm.this.materialButton11ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2977 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "ACEITE", "AGUA" }));
/*       */     
/*  2979 */     GroupLayout jPanel89Layout = new GroupLayout(this.jPanel89);
/*  2980 */     this.jPanel89.setLayout(jPanel89Layout);
/*  2981 */     jPanel89Layout.setHorizontalGroup(jPanel89Layout
/*  2982 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2983 */         .addGroup(jPanel89Layout.createSequentialGroup()
/*  2984 */           .addContainerGap()
/*  2985 */           .addGroup(jPanel89Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2986 */             .addComponent(this.jLabel94, -1, 455, 32767)
/*  2987 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel89Layout.createSequentialGroup()
/*  2988 */               .addGap(0, 0, 32767)
/*  2989 */               .addComponent((Component)this.materialButton11, -2, 150, -2)
/*  2990 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2991 */               .addComponent((Component)this.materialButton10, -2, 105, -2))
/*  2992 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel89Layout.createSequentialGroup()
/*  2993 */               .addComponent(this.jTextField43)
/*  2994 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2995 */               .addComponent(this.jComboBox5, -2, 132, -2)))
/*  2996 */           .addContainerGap()));
/*       */     
/*  2998 */     jPanel89Layout.setVerticalGroup(jPanel89Layout
/*  2999 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3000 */         .addGroup(jPanel89Layout.createSequentialGroup()
/*  3001 */           .addComponent(this.jLabel94, -2, 26, -2)
/*  3002 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3003 */           .addGroup(jPanel89Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  3004 */             .addComponent(this.jTextField43, -2, -1, -2)
/*  3005 */             .addComponent(this.jComboBox5, -2, -1, -2))
/*  3006 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3007 */           .addGroup(jPanel89Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  3008 */             .addComponent((Component)this.materialButton10, -2, 38, -2)
/*  3009 */             .addComponent((Component)this.materialButton11, -2, 38, -2))
/*  3010 */           .addContainerGap(-1, 32767)));
/*       */ 
/*       */     
/*  3013 */     GroupLayout jDialog11Layout = new GroupLayout(this.jDialog11.getContentPane());
/*  3014 */     this.jDialog11.getContentPane().setLayout(jDialog11Layout);
/*  3015 */     jDialog11Layout.setHorizontalGroup(jDialog11Layout
/*  3016 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3017 */         .addGroup(jDialog11Layout.createSequentialGroup()
/*  3018 */           .addComponent(this.jPanel89, -2, -1, -2)
/*  3019 */           .addGap(0, 0, 32767)));
/*       */     
/*  3021 */     jDialog11Layout.setVerticalGroup(jDialog11Layout
/*  3022 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3023 */         .addComponent(this.jPanel89, -1, -1, 32767));
/*       */ 
/*       */     
/*  3026 */     this.jPanel132.setLayout(new GridLayout(8, 0, 0, 6));
/*       */     
/*  3028 */     this.jLabel96.setText("Peso Vehicular");
/*  3029 */     this.jPanel132.add(this.jLabel96);
/*       */     
/*  3031 */     this.jPanel104.setLayout(new GridLayout(1, 6, 6, 0));
/*       */     
/*  3033 */     GroupLayout jPanel106Layout = new GroupLayout(this.jPanel106);
/*  3034 */     this.jPanel106.setLayout(jPanel106Layout);
/*  3035 */     jPanel106Layout.setHorizontalGroup(jPanel106Layout
/*  3036 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3037 */         .addGap(0, 204, 32767));
/*       */     
/*  3039 */     jPanel106Layout.setVerticalGroup(jPanel106Layout
/*  3040 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3041 */         .addGap(0, 24, 32767));
/*       */ 
/*       */     
/*  3044 */     this.jPanel104.add(this.jPanel106);
/*       */     
/*  3046 */     GroupLayout jPanel107Layout = new GroupLayout(this.jPanel107);
/*  3047 */     this.jPanel107.setLayout(jPanel107Layout);
/*  3048 */     jPanel107Layout.setHorizontalGroup(jPanel107Layout
/*  3049 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3050 */         .addGap(0, 204, 32767));
/*       */     
/*  3052 */     jPanel107Layout.setVerticalGroup(jPanel107Layout
/*  3053 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3054 */         .addGap(0, 24, 32767));
/*       */ 
/*       */     
/*  3057 */     this.jPanel104.add(this.jPanel107);
/*       */     
/*  3059 */     GroupLayout jPanel108Layout = new GroupLayout(this.jPanel108);
/*  3060 */     this.jPanel108.setLayout(jPanel108Layout);
/*  3061 */     jPanel108Layout.setHorizontalGroup(jPanel108Layout
/*  3062 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3063 */         .addGap(0, 204, 32767));
/*       */     
/*  3065 */     jPanel108Layout.setVerticalGroup(jPanel108Layout
/*  3066 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3067 */         .addGap(0, 24, 32767));
/*       */ 
/*       */     
/*  3070 */     this.jPanel104.add(this.jPanel108);
/*       */     
/*  3072 */     GroupLayout jPanel109Layout = new GroupLayout(this.jPanel109);
/*  3073 */     this.jPanel109.setLayout(jPanel109Layout);
/*  3074 */     jPanel109Layout.setHorizontalGroup(jPanel109Layout
/*  3075 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3076 */         .addGap(0, 204, 32767));
/*       */     
/*  3078 */     jPanel109Layout.setVerticalGroup(jPanel109Layout
/*  3079 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3080 */         .addGap(0, 24, 32767));
/*       */ 
/*       */     
/*  3083 */     this.jPanel104.add(this.jPanel109);
/*       */     
/*  3085 */     this.jPanel132.add(this.jPanel104);
/*  3086 */     this.jPanel132.add(this.jTextField14);
/*       */     
/*  3088 */     GroupLayout jPanel36Layout = new GroupLayout(this.jPanel36);
/*  3089 */     this.jPanel36.setLayout(jPanel36Layout);
/*  3090 */     jPanel36Layout.setHorizontalGroup(jPanel36Layout
/*  3091 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3092 */         .addComponent(this.jPanel132, -1, 837, 32767));
/*       */     
/*  3094 */     jPanel36Layout.setVerticalGroup(jPanel36Layout
/*  3095 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3096 */         .addGroup(jPanel36Layout.createSequentialGroup()
/*  3097 */           .addComponent(this.jPanel132, -2, -1, -2)
/*  3098 */           .addGap(0, 306, 32767)));
/*       */ 
/*       */     
/*  3101 */     setDefaultCloseOperation(2);
/*  3102 */     setModal(true);
/*  3103 */     setUndecorated(true);
/*       */     
/*  3105 */     this.jPanel12.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO2));
/*       */     
/*  3107 */     this.jPanel50.setBackground(this.lc.SECUNDARIO1);
/*       */     
/*  3109 */     this.jLabel20.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/*  3110 */     this.jLabel20.setForeground(new Color(255, 255, 255));
/*  3111 */     this.jLabel20.setHorizontalAlignment(0);
/*  3112 */     this.jLabel20.setText("Guía");
/*  3113 */     this.jLabel20.addMouseMotionListener(new MouseMotionAdapter() {
/*       */           public void mouseDragged(MouseEvent evt) {
/*  3115 */             GuiasForm.this.jLabel20MouseDragged(evt);
/*       */           }
/*       */         });
/*  3118 */     this.jLabel20.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3120 */             GuiasForm.this.jLabel20MouseClicked(evt);
/*       */           }
/*       */         });
/*       */     
/*  3124 */     this.jPanel80.setBackground(this.lc.PRIMARIO1);
/*  3125 */     this.jPanel80.setLayout(new GridLayout(1, 0));
/*       */     
/*  3127 */     this.jLabel128.setHorizontalAlignment(0);
/*  3128 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*  3129 */     this.jLabel128.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3131 */             GuiasForm.this.jLabel128MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3134 */             GuiasForm.this.jLabel128MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3137 */             GuiasForm.this.jLabel128MouseExited(evt);
/*       */           }
/*       */         });
/*  3140 */     this.jPanel80.add(this.jLabel128);
/*       */     
/*  3142 */     this.jLabel27.setHorizontalAlignment(0);
/*  3143 */     this.jLabel27.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/menu.png")));
/*       */     
/*  3145 */     this.jLabel54.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/*  3146 */     this.jLabel54.setForeground(new Color(255, 255, 255));
/*  3147 */     this.jLabel54.setHorizontalAlignment(0);
/*  3148 */     this.jLabel54.setText("PR-98374");
/*  3149 */     this.jLabel54.setHorizontalTextPosition(0);
/*       */     
/*  3151 */     GroupLayout jPanel50Layout = new GroupLayout(this.jPanel50);
/*  3152 */     this.jPanel50.setLayout(jPanel50Layout);
/*  3153 */     jPanel50Layout.setHorizontalGroup(jPanel50Layout
/*  3154 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3155 */         .addGroup(jPanel50Layout.createSequentialGroup()
/*  3156 */           .addGap(1, 1, 1)
/*  3157 */           .addComponent(this.jLabel27, -2, 36, -2)
/*  3158 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3159 */           .addComponent(this.jLabel54, -2, 102, -2)
/*  3160 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3161 */           .addComponent(this.jLabel20, -1, -1, 32767)
/*  3162 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3163 */           .addComponent(this.jPanel80, -2, 34, -2)));
/*       */     
/*  3165 */     jPanel50Layout.setVerticalGroup(jPanel50Layout
/*  3166 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3167 */         .addComponent(this.jPanel80, -1, -1, 32767)
/*  3168 */         .addGroup(jPanel50Layout.createSequentialGroup()
/*  3169 */           .addGroup(jPanel50Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  3170 */             .addComponent(this.jLabel27, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  3171 */             .addComponent(this.jLabel20, -1, 30, 32767)
/*  3172 */             .addComponent(this.jLabel54, -1, -1, 32767))
/*  3173 */           .addGap(0, 0, 32767)));
/*       */ 
/*       */     
/*  3176 */     this.jPanel79.setBackground(this.lc.SECUNDARIO2);
/*       */     
/*  3178 */     this.materialButton2.setBackground(this.lc.SECUNDARIO1);
/*  3179 */     this.materialButton2.setForeground(new Color(255, 255, 255));
/*  3180 */     this.materialButton2.setMnemonic('R');
/*  3181 */     this.materialButton2.setText("Cerrar");
/*  3182 */     this.materialButton2.setToolTipText("Cerrar (Alt+R)");
/*  3183 */     this.materialButton2.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/*  3184 */     this.materialButton2.setHorizontalTextPosition(0);
/*  3185 */     this.materialButton2.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3187 */             GuiasForm.this.materialButton2ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3191 */     this.materialButton9.setBackground(this.lc.PRIMARIO1);
/*  3192 */     this.materialButton9.setForeground(new Color(255, 255, 255));
/*  3193 */     this.materialButton9.setMnemonic('T');
/*  3194 */     this.materialButton9.setText("Timbrar");
/*  3195 */     this.materialButton9.setToolTipText("Timbrar (Alt +T)");
/*  3196 */     this.materialButton9.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/*  3197 */     this.materialButton9.setHorizontalTextPosition(0);
/*  3198 */     this.materialButton9.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3200 */             GuiasForm.this.materialButton9ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3204 */     this.materialButton1.setBackground(this.lc.PRIMARIO1);
/*  3205 */     this.materialButton1.setForeground(new Color(255, 255, 255));
/*  3206 */     this.materialButton1.setMnemonic('G');
/*  3207 */     this.materialButton1.setText("Guardar");
/*  3208 */     this.materialButton1.setToolTipText("Guardar (Alt+G)");
/*  3209 */     this.materialButton1.setEnabled(false);
/*  3210 */     this.materialButton1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/*  3211 */     this.materialButton1.setHorizontalTextPosition(0);
/*  3212 */     this.materialButton1.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3214 */             GuiasForm.this.materialButton1ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3218 */     this.jPanel1.setBackground(this.lc.SECUNDARIO2);
/*  3219 */     this.jPanel1.setLayout(new GridLayout(1, 3, 6, 0));
/*       */     
/*  3221 */     this.jPanel2.setBackground(this.lc.SECUNDARIO2);
/*  3222 */     this.jPanel2.setLayout(new GridLayout(1, 2, 6, 0));
/*       */     
/*  3224 */     this.jButton47.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/flechaAzulDer.png")));
/*  3225 */     this.jButton47.setEnabled(false);
/*  3226 */     this.jButton47.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3228 */             GuiasForm.this.jButton47ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3231 */     this.jPanel2.add(this.jButton47);
/*       */     
/*  3233 */     this.jButton48.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/flechaAzulIzq.png")));
/*  3234 */     this.jButton48.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3236 */             GuiasForm.this.jButton48ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3239 */     this.jPanel2.add(this.jButton48);
/*       */     
/*  3241 */     this.jPanel1.add(this.jPanel2);
/*       */     
/*  3243 */     this.jPanel3.setBackground(this.lc.SECUNDARIO2);
/*  3244 */     this.jPanel3.setLayout(new GridLayout(1, 0));
/*       */     
/*  3246 */     this.jLabel214.setFont(new Font("Cantarell", 1, 13));
/*  3247 */     this.jLabel214.setForeground(this.lc.PRIMARIO1);
/*  3248 */     this.jLabel214.setHorizontalAlignment(4);
/*  3249 */     this.jLabel214.setText("Paso 1/4");
/*  3250 */     this.jLabel214.setHorizontalTextPosition(0);
/*  3251 */     this.jPanel3.add(this.jLabel214);
/*       */     
/*  3253 */     this.jPanel1.add(this.jPanel3);
/*       */     
/*  3255 */     this.jPanel90.setBackground(this.lc.PRIMARIO1);
/*       */     
/*  3257 */     this.jLabel132.setHorizontalAlignment(0);
/*  3258 */     this.jLabel132.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/copy(1).png")));
/*  3259 */     this.jLabel132.setToolTipText("Copiar información de la guía");
/*  3260 */     this.jLabel132.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3262 */             GuiasForm.this.jLabel132MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3265 */             GuiasForm.this.jLabel132MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3268 */             GuiasForm.this.jLabel132MouseExited(evt);
/*       */           }
/*       */         });
/*       */     
/*  3272 */     GroupLayout jPanel90Layout = new GroupLayout(this.jPanel90);
/*  3273 */     this.jPanel90.setLayout(jPanel90Layout);
/*  3274 */     jPanel90Layout.setHorizontalGroup(jPanel90Layout
/*  3275 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3276 */         .addGroup(jPanel90Layout.createSequentialGroup()
/*  3277 */           .addComponent(this.jLabel132, -2, 40, -2)
/*  3278 */           .addGap(0, 6, 32767)));
/*       */     
/*  3280 */     jPanel90Layout.setVerticalGroup(jPanel90Layout
/*  3281 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3282 */         .addComponent(this.jLabel132, -1, -1, 32767));
/*       */ 
/*       */     
/*  3285 */     GroupLayout jPanel79Layout = new GroupLayout(this.jPanel79);
/*  3286 */     this.jPanel79.setLayout(jPanel79Layout);
/*  3287 */     jPanel79Layout.setHorizontalGroup(jPanel79Layout
/*  3288 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3289 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel79Layout.createSequentialGroup()
/*  3290 */           .addComponent(this.jPanel90, -2, -1, -2)
/*  3291 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3292 */           .addComponent(this.jPanel1, -2, 117, -2)
/*  3293 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  3294 */           .addComponent((Component)this.materialButton9, -2, 150, -2)
/*  3295 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3296 */           .addComponent((Component)this.materialButton1, -2, 150, -2)
/*  3297 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3298 */           .addComponent((Component)this.materialButton2, -2, 105, -2)
/*  3299 */           .addContainerGap()));
/*       */     
/*  3301 */     jPanel79Layout.setVerticalGroup(jPanel79Layout
/*  3302 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3303 */         .addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/*  3304 */         .addGroup(jPanel79Layout.createSequentialGroup()
/*  3305 */           .addGroup(jPanel79Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  3306 */             .addComponent((Component)this.materialButton1, -1, 38, 32767)
/*  3307 */             .addComponent((Component)this.materialButton2, -1, -1, 32767)
/*  3308 */             .addComponent((Component)this.materialButton9, -1, -1, 32767))
/*  3309 */           .addGap(0, 2, 32767))
/*  3310 */         .addComponent(this.jPanel90, -1, -1, 32767));
/*       */ 
/*       */     
/*  3313 */     this.jTabbedPane1.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3315 */             GuiasForm.this.jTabbedPane1MouseClicked(evt);
/*       */           }
/*       */         });
/*       */     
/*  3319 */     this.jPanel7.setLayout(new GridLayout(1, 3, 16, 0));
/*       */     
/*  3321 */     this.jPanel8.setLayout(new GridLayout(1, 2, 6, 0));
/*       */     
/*  3323 */     this.jLabel1.setFont(new Font("SF UI Display Light", 1, 12));
/*  3324 */     this.jLabel1.setHorizontalAlignment(4);
/*  3325 */     this.jLabel1.setText("Folio SICRET *");
/*  3326 */     this.jPanel8.add(this.jLabel1);
/*       */     
/*  3328 */     this.jTextField1.setText("jTextField1");
/*  3329 */     this.jTextField1.setEnabled(false);
/*  3330 */     this.jPanel8.add(this.jTextField1);
/*       */     
/*  3332 */     this.jPanel7.add(this.jPanel8);
/*       */     
/*  3334 */     this.jPanel9.setLayout(new GridLayout(1, 2, 6, 0));
/*       */     
/*  3336 */     this.jLabel2.setHorizontalAlignment(4);
/*  3337 */     this.jLabel2.setText("Folio Impreso (Rojo)");
/*  3338 */     this.jPanel9.add(this.jLabel2);
/*       */     
/*  3340 */     this.jTextField2.setText("jTextField2");
/*  3341 */     this.jPanel9.add(this.jTextField2);
/*       */     
/*  3343 */     this.jPanel7.add(this.jPanel9);
/*       */     
/*  3345 */     this.jPanel10.setLayout(new GridLayout(1, 2, 6, 0));
/*       */     
/*  3347 */     this.jLabel3.setFont(new Font("SF UI Display Light", 1, 12));
/*  3348 */     this.jLabel3.setHorizontalAlignment(4);
/*  3349 */     this.jLabel3.setText("Fecha *");
/*  3350 */     this.jPanel10.add(this.jLabel3);
/*       */     
/*  3352 */     this.jDateChooser1.setDate(this.fechaActual);
/*  3353 */     this.jDateChooser1.setDateFormatString("dd/MM/yyyy");
/*  3354 */     this.jDateChooser1.setEnabled(false);
/*  3355 */     this.jDateChooser1.setIcon(this.icon);
/*  3356 */     this.jDateChooser1.setMinSelectableDate(new Date(1257058862000L));
/*  3357 */     this.jPanel10.add((Component)this.jDateChooser1);
/*       */     
/*  3359 */     this.jPanel7.add(this.jPanel10);
/*       */     
/*  3361 */     GridBagLayout jPanel11Layout = new GridBagLayout();
/*  3362 */     jPanel11Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*  3363 */     jPanel11Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*  3364 */     this.jPanel11.setLayout(jPanel11Layout);
/*       */     
/*  3366 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  3367 */     this.jButton1.setMnemonic('F');
/*  3368 */     this.jButton1.setToolTipText("Filtrar información (Alt+F)");
/*  3369 */     this.jButton1.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3371 */             GuiasForm.this.jButton1ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3375 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/*  3376 */     this.jComboBox1.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3378 */             GuiasForm.this.jComboBox1ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3382 */     GroupLayout jPanel60Layout = new GroupLayout(this.jPanel60);
/*  3383 */     this.jPanel60.setLayout(jPanel60Layout);
/*  3384 */     jPanel60Layout.setHorizontalGroup(jPanel60Layout
/*  3385 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3386 */         .addGroup(jPanel60Layout.createSequentialGroup()
/*  3387 */           .addComponent(this.jComboBox1, 0, 0, 32767)
/*  3388 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3389 */           .addComponent(this.jButton1, -2, 20, -2)
/*  3390 */           .addGap(0, 0, 0)));
/*       */     
/*  3392 */     jPanel60Layout.setVerticalGroup(jPanel60Layout
/*  3393 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3394 */         .addGroup(jPanel60Layout.createSequentialGroup()
/*  3395 */           .addGroup(jPanel60Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  3396 */             .addComponent(this.jComboBox1, GroupLayout.Alignment.LEADING)
/*  3397 */             .addComponent(this.jButton1, GroupLayout.Alignment.LEADING, -2, 0, 32767))
/*  3398 */           .addContainerGap(-1, 32767)));
/*       */ 
/*       */     
/*  3401 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  3402 */     gridBagConstraints.gridx = 14;
/*  3403 */     gridBagConstraints.gridy = 0;
/*  3404 */     gridBagConstraints.gridwidth = 15;
/*  3405 */     gridBagConstraints.fill = 1;
/*  3406 */     gridBagConstraints.anchor = 19;
/*  3407 */     gridBagConstraints.weightx = 1.0D;
/*  3408 */     this.jPanel11.add(this.jPanel60, gridBagConstraints);
/*       */     
/*  3410 */     this.jLabel4.setFont(new Font("SF UI Display Light", 1, 12));
/*  3411 */     this.jLabel4.setText("Domicilio *");
/*  3412 */     gridBagConstraints = new GridBagConstraints();
/*  3413 */     gridBagConstraints.gridx = 4;
/*  3414 */     gridBagConstraints.gridy = 2;
/*  3415 */     gridBagConstraints.fill = 2;
/*  3416 */     this.jPanel11.add(this.jLabel4, gridBagConstraints);
/*       */     
/*  3418 */     this.jLabel5.setFont(new Font("SF UI Display Light", 1, 12));
/*  3419 */     this.jLabel5.setText("Cliente *");
/*  3420 */     gridBagConstraints = new GridBagConstraints();
/*  3421 */     gridBagConstraints.gridx = 4;
/*  3422 */     gridBagConstraints.gridy = 0;
/*  3423 */     gridBagConstraints.fill = 2;
/*  3424 */     gridBagConstraints.anchor = 21;
/*  3425 */     gridBagConstraints.insets = new Insets(0, 0, 6, 0);
/*  3426 */     this.jPanel11.add(this.jLabel5, gridBagConstraints);
/*       */     
/*  3428 */     this.jTextField3.setText("jTextField3");
/*  3429 */     this.jTextField3.setEnabled(false);
/*  3430 */     gridBagConstraints = new GridBagConstraints();
/*  3431 */     gridBagConstraints.gridx = 14;
/*  3432 */     gridBagConstraints.gridy = 2;
/*  3433 */     gridBagConstraints.gridwidth = 15;
/*  3434 */     gridBagConstraints.fill = 2;
/*  3435 */     gridBagConstraints.weightx = 1.0D;
/*  3436 */     this.jPanel11.add(this.jTextField3, gridBagConstraints);
/*       */     
/*  3438 */     this.jLabel6.setFont(new Font("SF UI Display Light", 1, 12));
/*  3439 */     this.jLabel6.setText("Tipo de Servicio *");
/*  3440 */     gridBagConstraints = new GridBagConstraints();
/*  3441 */     gridBagConstraints.gridx = 4;
/*  3442 */     gridBagConstraints.gridy = 14;
/*  3443 */     gridBagConstraints.fill = 2;
/*  3444 */     gridBagConstraints.anchor = 21;
/*  3445 */     gridBagConstraints.insets = new Insets(0, 0, 6, 0);
/*  3446 */     this.jPanel11.add(this.jLabel6, gridBagConstraints);
/*       */     
/*  3448 */     this.jLabel7.setFont(new Font("SF UI Display Light", 1, 12));
/*  3449 */     this.jLabel7.setText("Colonia *");
/*  3450 */     gridBagConstraints = new GridBagConstraints();
/*  3451 */     gridBagConstraints.gridx = 4;
/*  3452 */     gridBagConstraints.gridy = 4;
/*  3453 */     gridBagConstraints.fill = 2;
/*  3454 */     this.jPanel11.add(this.jLabel7, gridBagConstraints);
/*       */     
/*  3456 */     this.jTextField4.setText("jTextField4");
/*  3457 */     this.jTextField4.setEnabled(false);
/*  3458 */     this.jTextField4.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3460 */             GuiasForm.this.jTextField4ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3463 */     gridBagConstraints = new GridBagConstraints();
/*  3464 */     gridBagConstraints.gridx = 14;
/*  3465 */     gridBagConstraints.gridy = 4;
/*  3466 */     gridBagConstraints.gridwidth = 15;
/*  3467 */     gridBagConstraints.fill = 2;
/*  3468 */     gridBagConstraints.weightx = 1.0D;
/*  3469 */     this.jPanel11.add(this.jTextField4, gridBagConstraints);
/*       */     
/*  3471 */     this.jTextField5.setText("jTextField5");
/*  3472 */     this.jTextField5.setEnabled(false);
/*  3473 */     gridBagConstraints = new GridBagConstraints();
/*  3474 */     gridBagConstraints.gridx = 14;
/*  3475 */     gridBagConstraints.gridy = 8;
/*  3476 */     gridBagConstraints.gridwidth = 15;
/*  3477 */     gridBagConstraints.fill = 2;
/*  3478 */     gridBagConstraints.weightx = 1.0D;
/*  3479 */     this.jPanel11.add(this.jTextField5, gridBagConstraints);
/*       */     
/*  3481 */     this.jLabel8.setFont(new Font("SF UI Display Light", 1, 12));
/*  3482 */     this.jLabel8.setText("RFC *");
/*  3483 */     gridBagConstraints = new GridBagConstraints();
/*  3484 */     gridBagConstraints.gridx = 4;
/*  3485 */     gridBagConstraints.gridy = 8;
/*  3486 */     gridBagConstraints.fill = 2;
/*  3487 */     this.jPanel11.add(this.jLabel8, gridBagConstraints);
/*       */     
/*  3489 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  3490 */     this.jButton2.setMnemonic('F');
/*  3491 */     this.jButton2.setToolTipText("Filtrar información (Alt+F)");
/*  3492 */     this.jButton2.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3494 */             GuiasForm.this.jButton2ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3498 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/*  3499 */     this.jComboBox2.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3501 */             GuiasForm.this.jComboBox2ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3505 */     GroupLayout jPanel61Layout = new GroupLayout(this.jPanel61);
/*  3506 */     this.jPanel61.setLayout(jPanel61Layout);
/*  3507 */     jPanel61Layout.setHorizontalGroup(jPanel61Layout
/*  3508 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3509 */         .addGroup(jPanel61Layout.createSequentialGroup()
/*  3510 */           .addComponent(this.jComboBox2, 0, 0, 32767)
/*  3511 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3512 */           .addComponent(this.jButton2, -2, 20, -2)
/*  3513 */           .addGap(0, 0, 0)));
/*       */     
/*  3515 */     jPanel61Layout.setVerticalGroup(jPanel61Layout
/*  3516 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3517 */         .addGroup(jPanel61Layout.createSequentialGroup()
/*  3518 */           .addGroup(jPanel61Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  3519 */             .addComponent(this.jComboBox2, GroupLayout.Alignment.LEADING)
/*  3520 */             .addComponent(this.jButton2, GroupLayout.Alignment.LEADING, -2, 0, 32767))
/*  3521 */           .addContainerGap(-1, 32767)));
/*       */ 
/*       */     
/*  3524 */     gridBagConstraints = new GridBagConstraints();
/*  3525 */     gridBagConstraints.gridx = 14;
/*  3526 */     gridBagConstraints.gridy = 14;
/*  3527 */     gridBagConstraints.gridwidth = 15;
/*  3528 */     gridBagConstraints.fill = 2;
/*  3529 */     gridBagConstraints.weightx = 1.0D;
/*  3530 */     this.jPanel11.add(this.jPanel61, gridBagConstraints);
/*       */     
/*  3532 */     this.jLabel11.setFont(new Font("SF UI Display Light", 1, 12));
/*  3533 */     this.jLabel11.setText("Operador *");
/*  3534 */     gridBagConstraints = new GridBagConstraints();
/*  3535 */     gridBagConstraints.gridx = 4;
/*  3536 */     gridBagConstraints.gridy = 16;
/*  3537 */     gridBagConstraints.fill = 2;
/*  3538 */     gridBagConstraints.anchor = 21;
/*  3539 */     gridBagConstraints.insets = new Insets(0, 0, 6, 0);
/*  3540 */     this.jPanel11.add(this.jLabel11, gridBagConstraints);
/*       */     
/*  3542 */     this.jLabel37.setText("RFC");
/*  3543 */     gridBagConstraints = new GridBagConstraints();
/*  3544 */     gridBagConstraints.gridx = 14;
/*  3545 */     gridBagConstraints.gridy = 18;
/*  3546 */     this.jPanel11.add(this.jLabel37, gridBagConstraints);
/*       */     
/*  3548 */     this.jTextField6.setText("jTextField6");
/*  3549 */     this.jTextField6.setEnabled(false);
/*  3550 */     gridBagConstraints = new GridBagConstraints();
/*  3551 */     gridBagConstraints.gridx = 16;
/*  3552 */     gridBagConstraints.gridy = 18;
/*  3553 */     gridBagConstraints.fill = 2;
/*  3554 */     gridBagConstraints.weightx = 1.0D;
/*  3555 */     this.jPanel11.add(this.jTextField6, gridBagConstraints);
/*       */     
/*  3557 */     this.jLabel38.setText("Licencia");
/*  3558 */     gridBagConstraints = new GridBagConstraints();
/*  3559 */     gridBagConstraints.gridx = 20;
/*  3560 */     gridBagConstraints.gridy = 18;
/*  3561 */     this.jPanel11.add(this.jLabel38, gridBagConstraints);
/*       */     
/*  3563 */     this.jTextField7.setText("jTextField7");
/*  3564 */     this.jTextField7.setEnabled(false);
/*  3565 */     gridBagConstraints = new GridBagConstraints();
/*  3566 */     gridBagConstraints.gridx = 22;
/*  3567 */     gridBagConstraints.gridy = 18;
/*  3568 */     gridBagConstraints.fill = 2;
/*  3569 */     gridBagConstraints.weightx = 1.0D;
/*  3570 */     this.jPanel11.add(this.jTextField7, gridBagConstraints);
/*       */     
/*  3572 */     this.jLabel39.setText("Dirección");
/*  3573 */     gridBagConstraints = new GridBagConstraints();
/*  3574 */     gridBagConstraints.gridx = 26;
/*  3575 */     gridBagConstraints.gridy = 18;
/*  3576 */     this.jPanel11.add(this.jLabel39, gridBagConstraints);
/*       */     
/*  3578 */     this.jTextField8.setText("jTextField8");
/*  3579 */     this.jTextField8.setEnabled(false);
/*  3580 */     gridBagConstraints = new GridBagConstraints();
/*  3581 */     gridBagConstraints.gridx = 28;
/*  3582 */     gridBagConstraints.gridy = 18;
/*  3583 */     gridBagConstraints.fill = 2;
/*  3584 */     gridBagConstraints.weightx = 1.0D;
/*  3585 */     this.jPanel11.add(this.jTextField8, gridBagConstraints);
/*       */     
/*  3587 */     this.jButton3.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  3588 */     this.jButton3.setMnemonic('F');
/*  3589 */     this.jButton3.setToolTipText("Filtrar información (Alt+F)");
/*  3590 */     this.jButton3.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3592 */             GuiasForm.this.jButton3ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3596 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/*  3597 */     this.jComboBox3.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3599 */             GuiasForm.this.jComboBox3ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3603 */     GroupLayout jPanel62Layout = new GroupLayout(this.jPanel62);
/*  3604 */     this.jPanel62.setLayout(jPanel62Layout);
/*  3605 */     jPanel62Layout.setHorizontalGroup(jPanel62Layout
/*  3606 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3607 */         .addGroup(jPanel62Layout.createSequentialGroup()
/*  3608 */           .addComponent(this.jComboBox3, 0, 0, 32767)
/*  3609 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3610 */           .addComponent(this.jButton3, -2, 20, -2)
/*  3611 */           .addGap(0, 0, 0)));
/*       */     
/*  3613 */     jPanel62Layout.setVerticalGroup(jPanel62Layout
/*  3614 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3615 */         .addGroup(jPanel62Layout.createSequentialGroup()
/*  3616 */           .addGroup(jPanel62Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  3617 */             .addComponent(this.jComboBox3, GroupLayout.Alignment.LEADING)
/*  3618 */             .addComponent(this.jButton3, GroupLayout.Alignment.LEADING, -2, 0, 32767))
/*  3619 */           .addContainerGap(-1, 32767)));
/*       */ 
/*       */     
/*  3622 */     gridBagConstraints = new GridBagConstraints();
/*  3623 */     gridBagConstraints.gridx = 14;
/*  3624 */     gridBagConstraints.gridy = 16;
/*  3625 */     gridBagConstraints.gridwidth = 15;
/*  3626 */     gridBagConstraints.fill = 2;
/*  3627 */     gridBagConstraints.weightx = 1.0D;
/*  3628 */     this.jPanel11.add(this.jPanel62, gridBagConstraints);
/*       */     
/*  3630 */     this.jLabel92.setFont(new Font("SF UI Display Light", 1, 12));
/*  3631 */     this.jLabel92.setText("Permiso SCT *");
/*  3632 */     gridBagConstraints = new GridBagConstraints();
/*  3633 */     gridBagConstraints.gridx = 4;
/*  3634 */     gridBagConstraints.gridy = 10;
/*  3635 */     gridBagConstraints.fill = 2;
/*  3636 */     this.jPanel11.add(this.jLabel92, gridBagConstraints);
/*       */     
/*  3638 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/*  3639 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "TPAF01 - AUT. FED. DE CARGA GENERAL", "TPAF03 - AUT. FED. DE CARGA ESP. DE MAT Y RESIDUOS PELIGROSOS" }));
/*  3640 */     this.jComboBox4.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3642 */             GuiasForm.this.jComboBox4ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3645 */     gridBagConstraints = new GridBagConstraints();
/*  3646 */     gridBagConstraints.gridx = 14;
/*  3647 */     gridBagConstraints.gridy = 10;
/*  3648 */     gridBagConstraints.gridwidth = 15;
/*  3649 */     gridBagConstraints.fill = 2;
/*  3650 */     this.jPanel11.add(this.jComboBox4, gridBagConstraints);
/*       */     
/*  3652 */     this.jLabel93.setFont(new Font("SF UI Display Light", 0, 12));
/*  3653 */     this.jLabel93.setText("Localidad *");
/*  3654 */     gridBagConstraints = new GridBagConstraints();
/*  3655 */     gridBagConstraints.gridx = 4;
/*  3656 */     gridBagConstraints.gridy = 6;
/*  3657 */     gridBagConstraints.fill = 2;
/*  3658 */     this.jPanel11.add(this.jLabel93, gridBagConstraints);
/*       */     
/*  3660 */     this.jTextField9.setText("jTextField9");
/*  3661 */     this.jTextField9.setEnabled(false);
/*  3662 */     gridBagConstraints = new GridBagConstraints();
/*  3663 */     gridBagConstraints.gridx = 14;
/*  3664 */     gridBagConstraints.gridy = 6;
/*  3665 */     gridBagConstraints.gridwidth = 15;
/*  3666 */     gridBagConstraints.fill = 2;
/*  3667 */     gridBagConstraints.weightx = 1.0D;
/*  3668 */     this.jPanel11.add(this.jTextField9, gridBagConstraints);
/*       */     
/*  3670 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  3671 */     this.jPanel4.setLayout(jPanel4Layout);
/*  3672 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  3673 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3674 */         .addComponent(this.jPanel7, -2, 784, 32767)
/*  3675 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  3676 */           .addContainerGap()
/*  3677 */           .addComponent(this.jSeparator2)
/*  3678 */           .addContainerGap())
/*  3679 */         .addComponent(this.jPanel11, -1, -1, 32767));
/*       */     
/*  3681 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/*  3682 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3683 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  3684 */           .addContainerGap()
/*  3685 */           .addComponent(this.jPanel7, -2, -1, -2)
/*  3686 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3687 */           .addComponent(this.jSeparator2, -2, 10, -2)
/*  3688 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3689 */           .addComponent(this.jPanel11, -2, 315, -2)
/*  3690 */           .addContainerGap(14, 32767)));
/*       */ 
/*       */     
/*  3693 */     this.jTabbedPane1.addTab("Información General", this.jPanel4);
/*       */     
/*  3695 */     this.jPanel18.setBorder(BorderFactory.createTitledBorder("Origenes y destinos"));
/*       */     
/*  3697 */     this.jButton10.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/*  3698 */     this.jButton10.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3700 */             GuiasForm.this.jButton10ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3704 */     this.jButton12.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/*  3705 */     this.jButton12.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3707 */             GuiasForm.this.jButton12ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3711 */     this.jLabel12.setFont(new Font("SF UI Display Light", 0, 12));
/*  3712 */     this.jLabel12.setHorizontalAlignment(4);
/*  3713 */     this.jLabel12.setText("Kilometros Totales");
/*       */     
/*  3715 */     this.jTextField10.setHorizontalAlignment(4);
/*  3716 */     this.jTextField10.setText("10");
/*  3717 */     this.jTextField10.setEnabled(false);
/*       */     
/*  3719 */     this.jScrollPane6.setVerticalScrollBarPolicy(21);
/*       */     
/*  3721 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Tipo", "Tipo Estación", "ID", "Nombre", "RFC", "C.P.", "Calle", "Núm", "Col", "Ciudad", "Distancia", "Fecha y hora" })
/*       */         {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*  3729 */           boolean[] canEdit = new boolean[] { 
/*       */               false, false, false, false, false, false, false, false, false, false, 
/*       */               false, false };
/*       */           
/*       */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  3734 */             return this.canEdit[columnIndex];
/*       */           }
/*       */         });
/*  3737 */     this.rSTableMetro1.setAltoHead(25);
/*  3738 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  3739 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/*  3740 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/*  3741 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/*  3742 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/*  3743 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/*  3744 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/*  3745 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  3746 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  3747 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/*  3748 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/*  3749 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/*  3750 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/*  3751 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/*  3752 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3754 */             GuiasForm.this.rSTableMetro1MouseClicked(evt);
/*       */           }
/*       */         });
/*  3757 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  3759 */             GuiasForm.this.rSTableMetro1KeyReleased(evt);
/*       */           }
/*       */         });
/*  3762 */     this.jScrollPane35.setViewportView((Component)this.rSTableMetro1);
/*  3763 */     if (this.rSTableMetro1.getColumnModel().getColumnCount() > 0) {
/*  3764 */       this.rSTableMetro1.getColumnModel().getColumn(0).setMinWidth(60);
/*  3765 */       this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(60);
/*  3766 */       this.rSTableMetro1.getColumnModel().getColumn(2).setMinWidth(60);
/*  3767 */       this.rSTableMetro1.getColumnModel().getColumn(2).setMaxWidth(60);
/*  3768 */       this.rSTableMetro1.getColumnModel().getColumn(4).setMinWidth(90);
/*  3769 */       this.rSTableMetro1.getColumnModel().getColumn(4).setMaxWidth(90);
/*  3770 */       this.rSTableMetro1.getColumnModel().getColumn(5).setMinWidth(45);
/*  3771 */       this.rSTableMetro1.getColumnModel().getColumn(5).setMaxWidth(45);
/*  3772 */       this.rSTableMetro1.getColumnModel().getColumn(7).setMinWidth(60);
/*  3773 */       this.rSTableMetro1.getColumnModel().getColumn(7).setMaxWidth(60);
/*  3774 */       this.rSTableMetro1.getColumnModel().getColumn(10).setMinWidth(65);
/*  3775 */       this.rSTableMetro1.getColumnModel().getColumn(10).setMaxWidth(65);
/*  3776 */       this.rSTableMetro1.getColumnModel().getColumn(11).setMinWidth(110);
/*  3777 */       this.rSTableMetro1.getColumnModel().getColumn(11).setMaxWidth(110);
/*       */     } 
/*       */     
/*  3780 */     GroupLayout jPanel42Layout = new GroupLayout(this.jPanel42);
/*  3781 */     this.jPanel42.setLayout(jPanel42Layout);
/*  3782 */     jPanel42Layout.setHorizontalGroup(jPanel42Layout
/*  3783 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3784 */         .addGroup(jPanel42Layout.createSequentialGroup()
/*  3785 */           .addComponent(this.jScrollPane35, -2, 1200, -2)
/*  3786 */           .addGap(0, 0, 32767)));
/*       */     
/*  3788 */     jPanel42Layout.setVerticalGroup(jPanel42Layout
/*  3789 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3790 */         .addGroup(jPanel42Layout.createSequentialGroup()
/*  3791 */           .addComponent(this.jScrollPane35, -2, 103, -2)
/*  3792 */           .addGap(0, 14, 32767)));
/*       */ 
/*       */     
/*  3795 */     this.jScrollPane6.setViewportView(this.jPanel42);
/*       */     
/*  3797 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/*  3798 */     this.jPanel18.setLayout(jPanel18Layout);
/*  3799 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/*  3800 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3801 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
/*  3802 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3803 */             .addGroup(jPanel18Layout.createSequentialGroup()
/*  3804 */               .addGap(0, 520, 32767)
/*  3805 */               .addComponent(this.jLabel12, -2, 115, -2)
/*  3806 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3807 */               .addComponent(this.jTextField10, -2, 95, -2))
/*  3808 */             .addComponent(this.jScrollPane6, -2, 0, 32767))
/*  3809 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3810 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3811 */             .addComponent(this.jButton10)
/*  3812 */             .addComponent(this.jButton12))
/*  3813 */           .addContainerGap()));
/*       */     
/*  3815 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/*  3816 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3817 */         .addGroup(jPanel18Layout.createSequentialGroup()
/*  3818 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3819 */             .addGroup(jPanel18Layout.createSequentialGroup()
/*  3820 */               .addComponent(this.jButton10, -2, 26, -2)
/*  3821 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3822 */               .addComponent(this.jButton12, -2, 26, -2)
/*  3823 */               .addGap(0, 0, 32767))
/*  3824 */             .addComponent(this.jScrollPane6, -1, 129, 32767))
/*  3825 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3826 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  3827 */             .addComponent(this.jLabel12)
/*  3828 */             .addComponent(this.jTextField10, -2, -1, -2))));
/*       */ 
/*       */     
/*  3831 */     GridBagLayout jPanel14Layout = new GridBagLayout();
/*  3832 */     jPanel14Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*  3833 */     jPanel14Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*  3834 */     this.jPanel14.setLayout(jPanel14Layout);
/*       */     
/*  3836 */     this.jLabel40.setText("Equipo");
/*  3837 */     gridBagConstraints = new GridBagConstraints();
/*  3838 */     gridBagConstraints.gridx = 4;
/*  3839 */     gridBagConstraints.gridy = 8;
/*  3840 */     gridBagConstraints.anchor = 21;
/*  3841 */     this.jPanel14.add(this.jLabel40, gridBagConstraints);
/*       */     
/*  3843 */     this.jTextField11.setText("jTextField11");
/*  3844 */     this.jTextField11.setEnabled(false);
/*  3845 */     gridBagConstraints = new GridBagConstraints();
/*  3846 */     gridBagConstraints.gridx = 6;
/*  3847 */     gridBagConstraints.gridy = 8;
/*  3848 */     gridBagConstraints.fill = 2;
/*  3849 */     gridBagConstraints.weightx = 1.0D;
/*  3850 */     this.jPanel14.add(this.jTextField11, gridBagConstraints);
/*       */     
/*  3852 */     this.jLabel41.setText("Plataforma");
/*  3853 */     gridBagConstraints = new GridBagConstraints();
/*  3854 */     gridBagConstraints.gridx = 4;
/*  3855 */     gridBagConstraints.gridy = 10;
/*  3856 */     gridBagConstraints.anchor = 21;
/*  3857 */     this.jPanel14.add(this.jLabel41, gridBagConstraints);
/*       */     
/*  3859 */     this.jTextField12.setText("jTextField12");
/*  3860 */     this.jTextField12.setEnabled(false);
/*  3861 */     gridBagConstraints = new GridBagConstraints();
/*  3862 */     gridBagConstraints.gridx = 6;
/*  3863 */     gridBagConstraints.gridy = 10;
/*  3864 */     gridBagConstraints.fill = 2;
/*  3865 */     gridBagConstraints.weightx = 1.0D;
/*  3866 */     this.jPanel14.add(this.jTextField12, gridBagConstraints);
/*       */     
/*  3868 */     this.jLabel42.setText("Pozo");
/*  3869 */     gridBagConstraints = new GridBagConstraints();
/*  3870 */     gridBagConstraints.gridx = 4;
/*  3871 */     gridBagConstraints.gridy = 12;
/*  3872 */     gridBagConstraints.anchor = 21;
/*  3873 */     this.jPanel14.add(this.jLabel42, gridBagConstraints);
/*       */     
/*  3875 */     this.jTextField13.setText("jTextField13");
/*  3876 */     this.jTextField13.setEnabled(false);
/*  3877 */     gridBagConstraints = new GridBagConstraints();
/*  3878 */     gridBagConstraints.gridx = 6;
/*  3879 */     gridBagConstraints.gridy = 12;
/*  3880 */     gridBagConstraints.fill = 2;
/*  3881 */     gridBagConstraints.weightx = 1.0D;
/*  3882 */     this.jPanel14.add(this.jTextField13, gridBagConstraints);
/*       */     
/*  3884 */     this.jCheckBox1.setText("Activar detalles de perforación");
/*  3885 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3887 */             GuiasForm.this.jCheckBox1ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3890 */     gridBagConstraints = new GridBagConstraints();
/*  3891 */     gridBagConstraints.gridx = 6;
/*  3892 */     gridBagConstraints.gridy = 6;
/*  3893 */     gridBagConstraints.gridwidth = 5;
/*  3894 */     gridBagConstraints.fill = 2;
/*  3895 */     this.jPanel14.add(this.jCheckBox1, gridBagConstraints);
/*       */     
/*  3897 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*  3898 */     this.jPanel5.setLayout(jPanel5Layout);
/*  3899 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/*  3900 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3901 */         .addComponent(this.jPanel18, -1, -1, 32767)
/*  3902 */         .addGroup(jPanel5Layout.createSequentialGroup()
/*  3903 */           .addContainerGap()
/*  3904 */           .addComponent(this.jPanel14, -2, 468, -2)
/*  3905 */           .addContainerGap(-1, 32767)));
/*       */     
/*  3907 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/*  3908 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3909 */         .addGroup(jPanel5Layout.createSequentialGroup()
/*  3910 */           .addComponent(this.jPanel18, -2, -1, -2)
/*  3911 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3912 */           .addComponent(this.jPanel14, -2, 137, -2)
/*  3913 */           .addContainerGap(57, 32767)));
/*       */ 
/*       */     
/*  3916 */     this.jTabbedPane1.addTab("Ubicaciones", this.jPanel5);
/*       */     
/*  3918 */     this.jPanel44.setBorder(BorderFactory.createTitledBorder("Mercancías"));
/*       */     
/*  3920 */     this.jButton11.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/*  3921 */     this.jButton11.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3923 */             GuiasForm.this.jButton11ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3927 */     this.jButton13.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/*  3928 */     this.jButton13.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3930 */             GuiasForm.this.jButton13ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3934 */     this.jLabel60.setFont(new Font("SF UI Display Light", 0, 12));
/*  3935 */     this.jLabel60.setHorizontalAlignment(4);
/*  3936 */     this.jLabel60.setText("Total de Mercancías");
/*       */     
/*  3938 */     this.jTextField20.setHorizontalAlignment(4);
/*  3939 */     this.jTextField20.setText("10");
/*  3940 */     this.jTextField20.setEnabled(false);
/*       */     
/*  3942 */     this.jScrollPane7.setVerticalScrollBarPolicy(21);
/*       */     
/*  3944 */     this.rSTableMetro2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Cant", "Clave Unidad SAT", "Clave Prod SAT", "Descripción Interna", "Dimensiones", "Peso", "Valor", "Moneda", "Mat. Peligroso", "Origen", "Destino", "Fracc. Arrancelaria" })
/*       */         {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*  3952 */           boolean[] canEdit = new boolean[] { 
/*       */               false, false, false, false, false, false, false, false, false, false, 
/*       */               false, false };
/*       */           
/*       */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  3957 */             return this.canEdit[columnIndex];
/*       */           }
/*       */         });
/*  3960 */     this.rSTableMetro2.setAltoHead(25);
/*  3961 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  3962 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/*  3963 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/*  3964 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/*  3965 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/*  3966 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/*  3967 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/*  3968 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  3969 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  3970 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/*  3971 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/*  3972 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/*  3973 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/*  3974 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/*  3975 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3977 */             GuiasForm.this.rSTableMetro2MouseClicked(evt);
/*       */           }
/*       */         });
/*  3980 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  3982 */             GuiasForm.this.rSTableMetro2KeyReleased(evt);
/*       */           }
/*       */         });
/*  3985 */     this.jScrollPane37.setViewportView((Component)this.rSTableMetro2);
/*  3986 */     if (this.rSTableMetro2.getColumnModel().getColumnCount() > 0) {
/*  3987 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMinWidth(50);
/*  3988 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMaxWidth(50);
/*  3989 */       this.rSTableMetro2.getColumnModel().getColumn(3).setMinWidth(240);
/*  3990 */       this.rSTableMetro2.getColumnModel().getColumn(3).setMaxWidth(240);
/*  3991 */       this.rSTableMetro2.getColumnModel().getColumn(4).setMinWidth(85);
/*  3992 */       this.rSTableMetro2.getColumnModel().getColumn(4).setMaxWidth(85);
/*  3993 */       this.rSTableMetro2.getColumnModel().getColumn(5).setMinWidth(55);
/*  3994 */       this.rSTableMetro2.getColumnModel().getColumn(5).setMaxWidth(55);
/*  3995 */       this.rSTableMetro2.getColumnModel().getColumn(6).setMinWidth(65);
/*  3996 */       this.rSTableMetro2.getColumnModel().getColumn(6).setMaxWidth(65);
/*  3997 */       this.rSTableMetro2.getColumnModel().getColumn(7).setMinWidth(55);
/*  3998 */       this.rSTableMetro2.getColumnModel().getColumn(7).setMaxWidth(55);
/*  3999 */       this.rSTableMetro2.getColumnModel().getColumn(8).setMinWidth(90);
/*  4000 */       this.rSTableMetro2.getColumnModel().getColumn(8).setMaxWidth(90);
/*  4001 */       this.rSTableMetro2.getColumnModel().getColumn(9).setMinWidth(75);
/*  4002 */       this.rSTableMetro2.getColumnModel().getColumn(9).setMaxWidth(75);
/*  4003 */       this.rSTableMetro2.getColumnModel().getColumn(10).setMinWidth(75);
/*  4004 */       this.rSTableMetro2.getColumnModel().getColumn(10).setMaxWidth(75);
/*  4005 */       this.rSTableMetro2.getColumnModel().getColumn(11).setMinWidth(110);
/*  4006 */       this.rSTableMetro2.getColumnModel().getColumn(11).setMaxWidth(110);
/*       */     } 
/*       */     
/*  4009 */     GroupLayout jPanel45Layout = new GroupLayout(this.jPanel45);
/*  4010 */     this.jPanel45.setLayout(jPanel45Layout);
/*  4011 */     jPanel45Layout.setHorizontalGroup(jPanel45Layout
/*  4012 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4013 */         .addGroup(jPanel45Layout.createSequentialGroup()
/*  4014 */           .addComponent(this.jScrollPane37, -2, 1200, -2)
/*  4015 */           .addGap(0, 0, 32767)));
/*       */     
/*  4017 */     jPanel45Layout.setVerticalGroup(jPanel45Layout
/*  4018 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4019 */         .addGroup(jPanel45Layout.createSequentialGroup()
/*  4020 */           .addComponent(this.jScrollPane37, -2, 103, -2)
/*  4021 */           .addGap(0, 14, 32767)));
/*       */ 
/*       */     
/*  4024 */     this.jScrollPane7.setViewportView(this.jPanel45);
/*       */     
/*  4026 */     GroupLayout jPanel44Layout = new GroupLayout(this.jPanel44);
/*  4027 */     this.jPanel44.setLayout(jPanel44Layout);
/*  4028 */     jPanel44Layout.setHorizontalGroup(jPanel44Layout
/*  4029 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4030 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
/*  4031 */           .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4032 */             .addGroup(jPanel44Layout.createSequentialGroup()
/*  4033 */               .addGap(0, 504, 32767)
/*  4034 */               .addComponent(this.jLabel60, -2, 131, -2)
/*  4035 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4036 */               .addComponent(this.jTextField20, -2, 95, -2))
/*  4037 */             .addComponent(this.jScrollPane7, -2, 0, 32767))
/*  4038 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4039 */           .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4040 */             .addComponent(this.jButton11)
/*  4041 */             .addComponent(this.jButton13))
/*  4042 */           .addContainerGap()));
/*       */     
/*  4044 */     jPanel44Layout.setVerticalGroup(jPanel44Layout
/*  4045 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4046 */         .addGroup(jPanel44Layout.createSequentialGroup()
/*  4047 */           .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4048 */             .addGroup(jPanel44Layout.createSequentialGroup()
/*  4049 */               .addComponent(this.jButton11, -2, 26, -2)
/*  4050 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4051 */               .addComponent(this.jButton13, -2, 26, -2)
/*  4052 */               .addGap(0, 0, 32767))
/*  4053 */             .addComponent(this.jScrollPane7, -1, 129, 32767))
/*  4054 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4055 */           .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  4056 */             .addComponent(this.jLabel60)
/*  4057 */             .addComponent(this.jTextField20, -2, -1, -2))));
/*       */ 
/*       */     
/*  4060 */     this.jPanel43.setLayout(new GridLayout(6, 0, 0, 6));
/*       */     
/*  4062 */     this.jPanel47.setLayout(new GridLayout(1, 4, 6, 0));
/*       */     
/*  4064 */     this.jLabel43.setFont(new Font("SF UI Display Light", 1, 12));
/*  4065 */     this.jLabel43.setText("Tipo de Unidad *");
/*  4066 */     this.jPanel47.add(this.jLabel43);
/*       */     
/*  4068 */     this.jComboBox21.setBackground(new Color(244, 244, 244));
/*  4069 */     this.jComboBox21.setModel(new DefaultComboBoxModel<>(new String[] { "TRACTO", "UTILITARIO" }));
/*  4070 */     this.jComboBox21.setEnabled(false);
/*  4071 */     this.jComboBox21.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4073 */             GuiasForm.this.jComboBox21ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4076 */     this.jPanel47.add(this.jComboBox21);
/*       */     
/*  4078 */     this.jPanel43.add(this.jPanel47);
/*       */     
/*  4080 */     this.jPanel48.setLayout(new GridLayout(1, 4, 6, 0));
/*       */     
/*  4082 */     this.jLabel19.setFont(new Font("SF UI Display Light", 1, 12));
/*  4083 */     this.jLabel19.setText("Unidad *");
/*  4084 */     this.jPanel48.add(this.jLabel19);
/*       */     
/*  4086 */     this.jButton4.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  4087 */     this.jButton4.setMnemonic('F');
/*  4088 */     this.jButton4.setToolTipText("Filtrar información (Alt+F)");
/*  4089 */     this.jButton4.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4091 */             GuiasForm.this.jButton4ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  4095 */     this.jTextField21.setHorizontalAlignment(4);
/*  4096 */     this.jTextField21.setText("jTextField21");
/*  4097 */     this.jTextField21.setEnabled(false);
/*  4098 */     this.jTextField21.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4100 */             GuiasForm.this.jTextField21ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4103 */     this.jTextField21.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  4105 */             GuiasForm.this.jTextField21KeyReleased(evt);
/*       */           }
/*       */         });
/*       */     
/*  4109 */     GroupLayout jPanel63Layout = new GroupLayout(this.jPanel63);
/*  4110 */     this.jPanel63.setLayout(jPanel63Layout);
/*  4111 */     jPanel63Layout.setHorizontalGroup(jPanel63Layout
/*  4112 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4113 */         .addGroup(jPanel63Layout.createSequentialGroup()
/*  4114 */           .addComponent(this.jTextField21, -1, 112, 32767)
/*  4115 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4116 */           .addComponent(this.jButton4, -2, 19, -2)));
/*       */     
/*  4118 */     jPanel63Layout.setVerticalGroup(jPanel63Layout
/*  4119 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4120 */         .addGroup(jPanel63Layout.createSequentialGroup()
/*  4121 */           .addGroup(jPanel63Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  4122 */             .addComponent(this.jButton4, -2, 24, 32767)
/*  4123 */             .addComponent(this.jTextField21))
/*  4124 */           .addGap(0, 0, 32767)));
/*       */ 
/*       */     
/*  4127 */     this.jPanel48.add(this.jPanel63);
/*       */     
/*  4129 */     this.jPanel43.add(this.jPanel48);
/*       */     
/*  4131 */     this.jPanel49.setLayout(new GridLayout(1, 4, 6, 0));
/*       */     
/*  4133 */     this.jLabel16.setFont(new Font("SF UI Display Light", 0, 12));
/*  4134 */     this.jLabel16.setText("Remolque 1 ");
/*  4135 */     this.jPanel49.add(this.jLabel16);
/*       */     
/*  4137 */     this.jButton5.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  4138 */     this.jButton5.setMnemonic('F');
/*  4139 */     this.jButton5.setToolTipText("Filtrar información (Alt+F)");
/*  4140 */     this.jButton5.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4142 */             GuiasForm.this.jButton5ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  4146 */     this.jTextField26.setHorizontalAlignment(4);
/*  4147 */     this.jTextField26.setText("jTextField26");
/*  4148 */     this.jTextField26.setEnabled(false);
/*  4149 */     this.jTextField26.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4151 */             GuiasForm.this.jTextField26ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4154 */     this.jTextField26.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  4156 */             GuiasForm.this.jTextField26KeyReleased(evt);
/*       */           }
/*       */         });
/*       */     
/*  4160 */     GroupLayout jPanel64Layout = new GroupLayout(this.jPanel64);
/*  4161 */     this.jPanel64.setLayout(jPanel64Layout);
/*  4162 */     jPanel64Layout.setHorizontalGroup(jPanel64Layout
/*  4163 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4164 */         .addGroup(jPanel64Layout.createSequentialGroup()
/*  4165 */           .addComponent(this.jTextField26, -1, 111, 32767)
/*  4166 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4167 */           .addComponent(this.jButton5, -2, 20, -2)));
/*       */     
/*  4169 */     jPanel64Layout.setVerticalGroup(jPanel64Layout
/*  4170 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4171 */         .addGroup(jPanel64Layout.createSequentialGroup()
/*  4172 */           .addGroup(jPanel64Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  4173 */             .addComponent(this.jButton5, -2, 24, 32767)
/*  4174 */             .addComponent(this.jTextField26))
/*  4175 */           .addGap(0, 0, 32767)));
/*       */ 
/*       */     
/*  4178 */     this.jPanel49.add(this.jPanel64);
/*       */     
/*  4180 */     this.jPanel43.add(this.jPanel49);
/*       */     
/*  4182 */     this.jPanel54.setLayout(new GridLayout(1, 4, 6, 0));
/*       */     
/*  4184 */     this.jLabel18.setFont(new Font("SF UI Display Light", 0, 12));
/*  4185 */     this.jLabel18.setText("Remolque 2");
/*  4186 */     this.jPanel54.add(this.jLabel18);
/*       */     
/*  4188 */     this.jButton6.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  4189 */     this.jButton6.setMnemonic('F');
/*  4190 */     this.jButton6.setToolTipText("Filtrar información (Alt+F)");
/*  4191 */     this.jButton6.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4193 */             GuiasForm.this.jButton6ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  4197 */     this.jTextField31.setHorizontalAlignment(4);
/*  4198 */     this.jTextField31.setText("jTextField31");
/*  4199 */     this.jTextField31.setEnabled(false);
/*  4200 */     this.jTextField31.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4202 */             GuiasForm.this.jTextField31ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4205 */     this.jTextField31.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  4207 */             GuiasForm.this.jTextField31KeyReleased(evt);
/*       */           }
/*       */         });
/*       */     
/*  4211 */     GroupLayout jPanel65Layout = new GroupLayout(this.jPanel65);
/*  4212 */     this.jPanel65.setLayout(jPanel65Layout);
/*  4213 */     jPanel65Layout.setHorizontalGroup(jPanel65Layout
/*  4214 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4215 */         .addGroup(jPanel65Layout.createSequentialGroup()
/*  4216 */           .addComponent(this.jTextField31, -1, 111, 32767)
/*  4217 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4218 */           .addComponent(this.jButton6, -2, 20, -2)));
/*       */     
/*  4220 */     jPanel65Layout.setVerticalGroup(jPanel65Layout
/*  4221 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4222 */         .addGroup(jPanel65Layout.createSequentialGroup()
/*  4223 */           .addGroup(jPanel65Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  4224 */             .addComponent(this.jButton6, -2, 24, 32767)
/*  4225 */             .addComponent(this.jTextField31))
/*  4226 */           .addGap(0, 0, 32767)));
/*       */ 
/*       */     
/*  4229 */     this.jPanel54.add(this.jPanel65);
/*       */     
/*  4231 */     this.jPanel43.add(this.jPanel54);
/*       */     
/*  4233 */     this.jPanel55.setLayout(new GridLayout(1, 4, 6, 0));
/*       */     
/*  4235 */     this.jLabel15.setFont(new Font("SF UI Display Light", 0, 12));
/*  4236 */     this.jLabel15.setText("Dolly");
/*  4237 */     this.jPanel55.add(this.jLabel15);
/*       */     
/*  4239 */     this.jButton7.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/*  4240 */     this.jButton7.setMnemonic('F');
/*  4241 */     this.jButton7.setToolTipText("Filtrar información (Alt+F)");
/*  4242 */     this.jButton7.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4244 */             GuiasForm.this.jButton7ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  4248 */     this.jTextField36.setHorizontalAlignment(4);
/*  4249 */     this.jTextField36.setText("jTextField36");
/*  4250 */     this.jTextField36.setEnabled(false);
/*  4251 */     this.jTextField36.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4253 */             GuiasForm.this.jTextField36ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4256 */     this.jTextField36.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  4258 */             GuiasForm.this.jTextField36KeyReleased(evt);
/*       */           }
/*       */         });
/*       */     
/*  4262 */     GroupLayout jPanel66Layout = new GroupLayout(this.jPanel66);
/*  4263 */     this.jPanel66.setLayout(jPanel66Layout);
/*  4264 */     jPanel66Layout.setHorizontalGroup(jPanel66Layout
/*  4265 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4266 */         .addGroup(jPanel66Layout.createSequentialGroup()
/*  4267 */           .addComponent(this.jTextField36, -1, 111, 32767)
/*  4268 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4269 */           .addComponent(this.jButton7, -2, 20, -2)));
/*       */     
/*  4271 */     jPanel66Layout.setVerticalGroup(jPanel66Layout
/*  4272 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4273 */         .addGroup(jPanel66Layout.createSequentialGroup()
/*  4274 */           .addGroup(jPanel66Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  4275 */             .addComponent(this.jButton7, -2, 24, 32767)
/*  4276 */             .addComponent(this.jTextField36))
/*  4277 */           .addGap(0, 0, 32767)));
/*       */ 
/*       */     
/*  4280 */     this.jPanel55.add(this.jPanel66);
/*       */     
/*  4282 */     this.jPanel43.add(this.jPanel55);
/*       */     
/*  4284 */     this.jPanel56.setLayout(new GridLayout(1, 4, 6, 0));
/*       */     
/*  4286 */     this.jLabel14.setFont(new Font("SF UI Display Light", 1, 12));
/*  4287 */     this.jLabel14.setText("Tipo de Equipo *");
/*  4288 */     this.jPanel56.add(this.jLabel14);
/*       */     
/*  4290 */     this.jComboBox22.setBackground(new Color(244, 244, 244));
/*  4291 */     this.jComboBox22.setEditable(true);
/*  4292 */     this.jComboBox22.setModel(new DefaultComboBoxModel<>(new String[] { "EQUIPO" }));
/*  4293 */     this.jComboBox22.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4295 */             GuiasForm.this.jComboBox22ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4298 */     this.jPanel56.add(this.jComboBox22);
/*       */     
/*  4300 */     this.jPanel43.add(this.jPanel56);
/*       */     
/*  4302 */     this.jPanel46.setLayout(new GridLayout(6, 0, 0, 6));
/*       */     
/*  4304 */     GroupLayout jPanel57Layout = new GroupLayout(this.jPanel57);
/*  4305 */     this.jPanel57.setLayout(jPanel57Layout);
/*  4306 */     jPanel57Layout.setHorizontalGroup(jPanel57Layout
/*  4307 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4308 */         .addGap(0, 0, 32767));
/*       */     
/*  4310 */     jPanel57Layout.setVerticalGroup(jPanel57Layout
/*  4311 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4312 */         .addGap(0, 24, 32767));
/*       */ 
/*       */     
/*  4315 */     this.jPanel46.add(this.jPanel57);
/*       */     
/*  4317 */     this.jPanel58.setLayout(new GridLayout(1, 8, 6, 0));
/*       */     
/*  4319 */     this.jLabel24.setFont(new Font("SF UI Display Light", 1, 12));
/*  4320 */     this.jLabel24.setHorizontalAlignment(0);
/*  4321 */     this.jLabel24.setText("Placa *");
/*  4322 */     this.jPanel58.add(this.jLabel24);
/*       */     
/*  4324 */     this.jTextField22.setHorizontalAlignment(4);
/*  4325 */     this.jTextField22.setText("jTextField22");
/*  4326 */     this.jTextField22.setEnabled(false);
/*  4327 */     this.jTextField22.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4329 */             GuiasForm.this.jTextField22ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4332 */     this.jTextField22.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  4334 */             GuiasForm.this.jTextField22KeyReleased(evt);
/*       */           }
/*       */         });
/*  4337 */     this.jPanel58.add(this.jTextField22);
/*       */     
/*  4339 */     this.jLabel25.setFont(new Font("SF UI Display Light", 1, 12));
/*  4340 */     this.jLabel25.setHorizontalAlignment(0);
/*  4341 */     this.jLabel25.setText("Modelo *");
/*  4342 */     this.jPanel58.add(this.jLabel25);
/*       */     
/*  4344 */     this.jTextField23.setHorizontalAlignment(4);
/*  4345 */     this.jTextField23.setText("jTextField23");
/*  4346 */     this.jTextField23.setEnabled(false);
/*  4347 */     this.jTextField23.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4349 */             GuiasForm.this.jTextField23ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4352 */     this.jTextField23.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  4354 */             GuiasForm.this.jTextField23KeyReleased(evt);
/*       */           }
/*       */         });
/*  4357 */     this.jPanel58.add(this.jTextField23);
/*       */     
/*  4359 */     this.jLabel26.setFont(new Font("SF UI Display Light", 1, 12));
/*  4360 */     this.jLabel26.setHorizontalAlignment(0);
/*  4361 */     this.jLabel26.setText("Póliza *");
/*  4362 */     this.jPanel58.add(this.jLabel26);
/*       */     
/*  4364 */     this.jTextField24.setText("jTextField24");
/*  4365 */     this.jTextField24.setEnabled(false);
/*  4366 */     this.jTextField24.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4368 */             GuiasForm.this.jTextField24ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4371 */     this.jTextField24.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  4373 */             GuiasForm.this.jTextField24KeyReleased(evt);
/*       */           }
/*       */         });
/*  4376 */     this.jPanel58.add(this.jTextField24);
/*       */     
/*  4378 */     this.jLabel28.setFont(new Font("SF UI Display Light", 1, 12));
/*  4379 */     this.jLabel28.setHorizontalAlignment(0);
/*  4380 */     this.jLabel28.setText("Tipo");
/*  4381 */     this.jPanel58.add(this.jLabel28);
/*       */     
/*  4383 */     this.jTextField25.setText("jTextField25");
/*  4384 */     this.jTextField25.setEnabled(false);
/*  4385 */     this.jTextField25.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4387 */             GuiasForm.this.jTextField25ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4390 */     this.jTextField25.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  4392 */             GuiasForm.this.jTextField25KeyReleased(evt);
/*       */           }
/*       */         });
/*  4395 */     this.jPanel58.add(this.jTextField25);
/*       */     
/*  4397 */     this.jPanel46.add(this.jPanel58);
/*       */     
/*  4399 */     this.jPanel59.setLayout(new GridLayout(1, 8, 6, 0));
/*       */     
/*  4401 */     this.jLabel29.setFont(new Font("SF UI Display Light", 0, 12));
/*  4402 */     this.jLabel29.setHorizontalAlignment(0);
/*  4403 */     this.jLabel29.setText("Placa ");
/*  4404 */     this.jPanel59.add(this.jLabel29);
/*       */     
/*  4406 */     this.jTextField27.setHorizontalAlignment(4);
/*  4407 */     this.jTextField27.setText("jTextField27");
/*  4408 */     this.jTextField27.setEnabled(false);
/*  4409 */     this.jTextField27.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4411 */             GuiasForm.this.jTextField27ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4414 */     this.jTextField27.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  4416 */             GuiasForm.this.jTextField27KeyReleased(evt);
/*       */           }
/*       */         });
/*  4419 */     this.jPanel59.add(this.jTextField27);
/*       */     
/*  4421 */     this.jLabel30.setFont(new Font("SF UI Display Light", 0, 12));
/*  4422 */     this.jLabel30.setHorizontalAlignment(0);
/*  4423 */     this.jLabel30.setText("Modelo ");
/*  4424 */     this.jPanel59.add(this.jLabel30);
/*       */     
/*  4426 */     this.jTextField28.setHorizontalAlignment(4);
/*  4427 */     this.jTextField28.setText("jTextField28");
/*  4428 */     this.jTextField28.setEnabled(false);
/*  4429 */     this.jTextField28.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4431 */             GuiasForm.this.jTextField28ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4434 */     this.jTextField28.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  4436 */             GuiasForm.this.jTextField28KeyReleased(evt);
/*       */           }
/*       */         });
/*  4439 */     this.jPanel59.add(this.jTextField28);
/*       */     
/*  4441 */     this.jLabel31.setFont(new Font("SF UI Display Light", 0, 12));
/*  4442 */     this.jLabel31.setHorizontalAlignment(0);
/*  4443 */     this.jLabel31.setText("Póliza ");
/*  4444 */     this.jPanel59.add(this.jLabel31);
/*       */     
/*  4446 */     this.jTextField29.setText("jTextField29");
/*  4447 */     this.jTextField29.setEnabled(false);
/*  4448 */     this.jTextField29.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4450 */             GuiasForm.this.jTextField29ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4453 */     this.jTextField29.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  4455 */             GuiasForm.this.jTextField29KeyReleased(evt);
/*       */           }
/*       */         });
/*  4458 */     this.jPanel59.add(this.jTextField29);
/*       */     
/*  4460 */     this.jLabel32.setFont(new Font("SF UI Display Light", 1, 12));
/*  4461 */     this.jLabel32.setHorizontalAlignment(0);
/*  4462 */     this.jLabel32.setText("Tipo *");
/*  4463 */     this.jPanel59.add(this.jLabel32);
/*       */     
/*  4465 */     this.jTextField30.setText("jTextField30");
/*  4466 */     this.jTextField30.setEnabled(false);
/*  4467 */     this.jTextField30.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4469 */             GuiasForm.this.jTextField30ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4472 */     this.jTextField30.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  4474 */             GuiasForm.this.jTextField30KeyReleased(evt);
/*       */           }
/*       */         });
/*  4477 */     this.jPanel59.add(this.jTextField30);
/*       */     
/*  4479 */     this.jPanel46.add(this.jPanel59);
/*       */     
/*  4481 */     this.jPanel70.setLayout(new GridLayout(1, 8, 6, 0));
/*       */     
/*  4483 */     this.jLabel33.setFont(new Font("SF UI Display Light", 0, 12));
/*  4484 */     this.jLabel33.setHorizontalAlignment(0);
/*  4485 */     this.jLabel33.setText("Placa ");
/*  4486 */     this.jPanel70.add(this.jLabel33);
/*       */     
/*  4488 */     this.jTextField32.setHorizontalAlignment(4);
/*  4489 */     this.jTextField32.setText("jTextField32");
/*  4490 */     this.jTextField32.setEnabled(false);
/*  4491 */     this.jTextField32.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4493 */             GuiasForm.this.jTextField32ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4496 */     this.jTextField32.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  4498 */             GuiasForm.this.jTextField32KeyReleased(evt);
/*       */           }
/*       */         });
/*  4501 */     this.jPanel70.add(this.jTextField32);
/*       */     
/*  4503 */     this.jLabel34.setFont(new Font("SF UI Display Light", 0, 12));
/*  4504 */     this.jLabel34.setHorizontalAlignment(0);
/*  4505 */     this.jLabel34.setText("Modelo ");
/*  4506 */     this.jPanel70.add(this.jLabel34);
/*       */     
/*  4508 */     this.jTextField33.setHorizontalAlignment(4);
/*  4509 */     this.jTextField33.setText("jTextField33");
/*  4510 */     this.jTextField33.setEnabled(false);
/*  4511 */     this.jTextField33.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4513 */             GuiasForm.this.jTextField33ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4516 */     this.jTextField33.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  4518 */             GuiasForm.this.jTextField33KeyReleased(evt);
/*       */           }
/*       */         });
/*  4521 */     this.jPanel70.add(this.jTextField33);
/*       */     
/*  4523 */     this.jLabel35.setFont(new Font("SF UI Display Light", 0, 12));
/*  4524 */     this.jLabel35.setHorizontalAlignment(0);
/*  4525 */     this.jLabel35.setText("Póliza ");
/*  4526 */     this.jPanel70.add(this.jLabel35);
/*       */     
/*  4528 */     this.jTextField34.setText("jTextField34");
/*  4529 */     this.jTextField34.setEnabled(false);
/*  4530 */     this.jTextField34.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4532 */             GuiasForm.this.jTextField34ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4535 */     this.jTextField34.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  4537 */             GuiasForm.this.jTextField34KeyReleased(evt);
/*       */           }
/*       */         });
/*  4540 */     this.jPanel70.add(this.jTextField34);
/*       */     
/*  4542 */     this.jLabel36.setFont(new Font("SF UI Display Light", 1, 12));
/*  4543 */     this.jLabel36.setHorizontalAlignment(0);
/*  4544 */     this.jLabel36.setText("Tipo *");
/*  4545 */     this.jPanel70.add(this.jLabel36);
/*       */     
/*  4547 */     this.jTextField35.setText("jTextField35");
/*  4548 */     this.jTextField35.setEnabled(false);
/*  4549 */     this.jTextField35.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4551 */             GuiasForm.this.jTextField35ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4554 */     this.jTextField35.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  4556 */             GuiasForm.this.jTextField35KeyReleased(evt);
/*       */           }
/*       */         });
/*  4559 */     this.jPanel70.add(this.jTextField35);
/*       */     
/*  4561 */     this.jPanel46.add(this.jPanel70);
/*       */     
/*  4563 */     this.jPanel72.setLayout(new GridLayout(1, 8, 6, 0));
/*       */     
/*  4565 */     this.jLabel17.setFont(new Font("SF UI Display Light", 0, 12));
/*  4566 */     this.jLabel17.setHorizontalAlignment(0);
/*  4567 */     this.jLabel17.setText("Placa ");
/*  4568 */     this.jPanel72.add(this.jLabel17);
/*       */     
/*  4570 */     this.jTextField37.setHorizontalAlignment(4);
/*  4571 */     this.jTextField37.setText("jTextField37");
/*  4572 */     this.jTextField37.setEnabled(false);
/*  4573 */     this.jTextField37.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4575 */             GuiasForm.this.jTextField37ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4578 */     this.jTextField37.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  4580 */             GuiasForm.this.jTextField37KeyReleased(evt);
/*       */           }
/*       */         });
/*  4583 */     this.jPanel72.add(this.jTextField37);
/*       */     
/*  4585 */     this.jLabel22.setFont(new Font("SF UI Display Light", 0, 12));
/*  4586 */     this.jLabel22.setHorizontalAlignment(0);
/*  4587 */     this.jLabel22.setText("Modelo ");
/*  4588 */     this.jPanel72.add(this.jLabel22);
/*       */     
/*  4590 */     this.jTextField38.setHorizontalAlignment(4);
/*  4591 */     this.jTextField38.setText("jTextField38");
/*  4592 */     this.jTextField38.setEnabled(false);
/*  4593 */     this.jTextField38.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4595 */             GuiasForm.this.jTextField38ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4598 */     this.jTextField38.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  4600 */             GuiasForm.this.jTextField38KeyReleased(evt);
/*       */           }
/*       */         });
/*  4603 */     this.jPanel72.add(this.jTextField38);
/*       */     
/*  4605 */     this.jLabel23.setFont(new Font("SF UI Display Light", 0, 12));
/*  4606 */     this.jLabel23.setHorizontalAlignment(0);
/*  4607 */     this.jLabel23.setText("Póliza ");
/*  4608 */     this.jPanel72.add(this.jLabel23);
/*       */     
/*  4610 */     this.jTextField39.setText("jTextField39");
/*  4611 */     this.jTextField39.setEnabled(false);
/*  4612 */     this.jTextField39.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4614 */             GuiasForm.this.jTextField39ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4617 */     this.jTextField39.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  4619 */             GuiasForm.this.jTextField39KeyReleased(evt);
/*       */           }
/*       */         });
/*  4622 */     this.jPanel72.add(this.jTextField39);
/*       */     
/*  4624 */     this.jLabel21.setFont(new Font("SF UI Display Light", 0, 12));
/*  4625 */     this.jLabel21.setHorizontalAlignment(0);
/*  4626 */     this.jLabel21.setText("Tipo");
/*  4627 */     this.jPanel72.add(this.jLabel21);
/*       */     
/*  4629 */     this.jTextField40.setText("jTextField40");
/*  4630 */     this.jTextField40.setEnabled(false);
/*  4631 */     this.jTextField40.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4633 */             GuiasForm.this.jTextField40ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4636 */     this.jTextField40.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  4638 */             GuiasForm.this.jTextField40KeyReleased(evt);
/*       */           }
/*       */         });
/*  4641 */     this.jPanel72.add(this.jTextField40);
/*       */     
/*  4643 */     this.jPanel46.add(this.jPanel72);
/*       */     
/*  4645 */     this.jPanel74.setLayout(new GridLayout(1, 4, 6, 0));
/*  4646 */     this.jPanel46.add(this.jPanel74);
/*       */     
/*  4648 */     GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
/*  4649 */     this.jPanel19.setLayout(jPanel19Layout);
/*  4650 */     jPanel19Layout.setHorizontalGroup(jPanel19Layout
/*  4651 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4652 */         .addGroup(jPanel19Layout.createSequentialGroup()
/*  4653 */           .addComponent(this.jPanel43, -2, 281, -2)
/*  4654 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4655 */           .addComponent(this.jPanel46, -2, 0, 32767)));
/*       */     
/*  4657 */     jPanel19Layout.setVerticalGroup(jPanel19Layout
/*  4658 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4659 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
/*  4660 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  4661 */             .addComponent(this.jPanel46, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  4662 */             .addComponent(this.jPanel43, -1, -1, 32767))
/*  4663 */           .addContainerGap()));
/*       */ 
/*       */     
/*  4666 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  4667 */     this.jPanel6.setLayout(jPanel6Layout);
/*  4668 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/*  4669 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4670 */         .addComponent(this.jPanel44, -1, -1, 32767)
/*  4671 */         .addComponent(this.jPanel19, -1, -1, 32767));
/*       */     
/*  4673 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/*  4674 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4675 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  4676 */           .addComponent(this.jPanel44, -2, -1, -2)
/*  4677 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4678 */           .addComponent(this.jPanel19, -2, -1, -2)
/*  4679 */           .addContainerGap(14, 32767)));
/*       */ 
/*       */     
/*  4682 */     this.jTabbedPane1.addTab("Mercancía y Unidades", this.jPanel6);
/*       */     
/*  4684 */     this.jPanel16.setLayout(new GridLayout(1, 3, 12, 0));
/*       */     
/*  4686 */     this.jPanel20.setLayout(new GridLayout(1, 2, 6, 0));
/*       */     
/*  4688 */     this.jLabel44.setText("Vale de Liquidaciones");
/*  4689 */     this.jPanel20.add(this.jLabel44);
/*       */     
/*  4691 */     this.jTextField50.setText("jTextField50");
/*  4692 */     this.jTextField50.setEnabled(false);
/*  4693 */     this.jPanel20.add(this.jTextField50);
/*       */     
/*  4695 */     this.jPanel16.add(this.jPanel20);
/*       */     
/*  4697 */     this.jPanel21.setLayout(new GridLayout(1, 2, 6, 0));
/*       */     
/*  4699 */     this.jLabel45.setHorizontalAlignment(0);
/*  4700 */     this.jLabel45.setText("Tickets");
/*  4701 */     this.jPanel21.add(this.jLabel45);
/*       */     
/*  4703 */     this.jTextField51.setText("jTextField51");
/*  4704 */     this.jTextField51.setEnabled(false);
/*  4705 */     this.jPanel21.add(this.jTextField51);
/*       */     
/*  4707 */     this.jPanel16.add(this.jPanel21);
/*       */     
/*  4709 */     this.jPanel22.setLayout(new GridLayout(1, 2, 6, 0));
/*       */     
/*  4711 */     this.jLabel46.setHorizontalAlignment(0);
/*  4712 */     this.jLabel46.setText("Manifiesto");
/*  4713 */     this.jPanel22.add(this.jLabel46);
/*       */     
/*  4715 */     this.jTextField52.setText("jTextField52");
/*  4716 */     this.jTextField52.setEnabled(false);
/*  4717 */     this.jPanel22.add(this.jTextField52);
/*       */     
/*  4719 */     this.jPanel16.add(this.jPanel22);
/*       */     
/*  4721 */     this.jPanel23.setLayout(new GridLayout(1, 0));
/*       */     
/*  4723 */     this.jPanel24.setLayout(new GridLayout(1, 2, 6, 0));
/*       */     
/*  4725 */     this.jLabel47.setFont(new Font("SF UI Display Light", 1, 12));
/*  4726 */     this.jLabel47.setText("Activa / Baja *");
/*  4727 */     this.jPanel24.add(this.jLabel47);
/*       */     
/*  4729 */     this.jComboBox50.setBackground(new Color(244, 244, 244));
/*  4730 */     this.jComboBox50.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVA", "CANCELADA" }));
/*  4731 */     this.jComboBox50.setEnabled(false);
/*  4732 */     this.jPanel24.add(this.jComboBox50);
/*       */     
/*  4734 */     this.jPanel23.add(this.jPanel24);
/*       */     
/*  4736 */     this.jPanel25.setLayout(new GridLayout(1, 2, 6, 0));
/*       */     
/*  4738 */     this.jLabel48.setFont(new Font("SF UI Display Light", 1, 12));
/*  4739 */     this.jLabel48.setHorizontalAlignment(0);
/*  4740 */     this.jLabel48.setText("Estatus *");
/*  4741 */     this.jPanel25.add(this.jLabel48);
/*       */     
/*  4743 */     this.jTextField53.setText("jTextField53");
/*  4744 */     this.jTextField53.setEnabled(false);
/*  4745 */     this.jPanel25.add(this.jTextField53);
/*       */     
/*  4747 */     this.jPanel23.add(this.jPanel25);
/*       */     
/*  4749 */     this.jPanel26.setLayout(new GridLayout(1, 2, 6, 0));
/*  4750 */     this.jPanel23.add(this.jPanel26);
/*       */     
/*  4752 */     this.jPanel27.setLayout(new GridLayout(1, 3, 12, 0));
/*       */     
/*  4754 */     this.jPanel28.setLayout(new GridLayout(2, 2, 6, 6));
/*       */     
/*  4756 */     this.jLabel49.setText("Pedido");
/*  4757 */     this.jPanel28.add(this.jLabel49);
/*       */     
/*  4759 */     this.jTextField54.setText("jTextField54");
/*  4760 */     this.jTextField54.setEnabled(false);
/*  4761 */     this.jPanel28.add(this.jTextField54);
/*       */     
/*  4763 */     this.jLabel50.setText("Reporte Interno");
/*  4764 */     this.jPanel28.add(this.jLabel50);
/*       */     
/*  4766 */     this.jTextField55.setHorizontalAlignment(4);
/*  4767 */     this.jTextField55.setText("jTextField55");
/*  4768 */     this.jTextField55.setEnabled(false);
/*  4769 */     this.jPanel28.add(this.jTextField55);
/*       */     
/*  4771 */     this.jPanel27.add(this.jPanel28);
/*       */     
/*  4773 */     this.jPanel29.setLayout(new GridLayout(2, 2, 6, 6));
/*       */     
/*  4775 */     GroupLayout jPanel31Layout = new GroupLayout(this.jPanel31);
/*  4776 */     this.jPanel31.setLayout(jPanel31Layout);
/*  4777 */     jPanel31Layout.setHorizontalGroup(jPanel31Layout
/*  4778 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4779 */         .addGap(0, 251, 32767));
/*       */     
/*  4781 */     jPanel31Layout.setVerticalGroup(jPanel31Layout
/*  4782 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4783 */         .addGap(0, 26, 32767));
/*       */ 
/*       */     
/*  4786 */     this.jPanel29.add(this.jPanel31);
/*       */     
/*  4788 */     this.jPanel32.setLayout(new GridLayout(1, 2, 6, 0));
/*       */     
/*  4790 */     this.jLabel51.setHorizontalAlignment(0);
/*  4791 */     this.jLabel51.setText("Prefactura");
/*  4792 */     this.jPanel32.add(this.jLabel51);
/*       */     
/*  4794 */     this.jTextField56.setHorizontalAlignment(4);
/*  4795 */     this.jTextField56.setText("jTextField56");
/*  4796 */     this.jTextField56.setEnabled(false);
/*  4797 */     this.jPanel32.add(this.jTextField56);
/*       */     
/*  4799 */     this.jPanel29.add(this.jPanel32);
/*       */     
/*  4801 */     this.jPanel27.add(this.jPanel29);
/*       */     
/*  4803 */     this.jPanel33.setLayout(new GridLayout(2, 2, 6, 6));
/*       */     
/*  4805 */     GroupLayout jPanel34Layout = new GroupLayout(this.jPanel34);
/*  4806 */     this.jPanel34.setLayout(jPanel34Layout);
/*  4807 */     jPanel34Layout.setHorizontalGroup(jPanel34Layout
/*  4808 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4809 */         .addGap(0, 251, 32767));
/*       */     
/*  4811 */     jPanel34Layout.setVerticalGroup(jPanel34Layout
/*  4812 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4813 */         .addGap(0, 26, 32767));
/*       */ 
/*       */     
/*  4816 */     this.jPanel33.add(this.jPanel34);
/*       */     
/*  4818 */     this.jPanel37.setLayout(new GridLayout(1, 2, 6, 0));
/*       */     
/*  4820 */     this.jLabel52.setHorizontalAlignment(0);
/*  4821 */     this.jLabel52.setText("Factura");
/*  4822 */     this.jPanel37.add(this.jLabel52);
/*       */     
/*  4824 */     this.jTextField57.setHorizontalAlignment(4);
/*  4825 */     this.jTextField57.setText("jTextField57");
/*  4826 */     this.jTextField57.setEnabled(false);
/*  4827 */     this.jPanel37.add(this.jTextField57);
/*       */     
/*  4829 */     this.jPanel33.add(this.jPanel37);
/*       */     
/*  4831 */     this.jPanel27.add(this.jPanel33);
/*       */     
/*  4833 */     this.jPanel51.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/*  4834 */     this.jPanel51.setLayout((LayoutManager)null);
/*       */     
/*  4836 */     this.jPanel53.setBackground(this.lc.PRIMARIO1);
/*       */     
/*  4838 */     GroupLayout jPanel53Layout = new GroupLayout(this.jPanel53);
/*  4839 */     this.jPanel53.setLayout(jPanel53Layout);
/*  4840 */     jPanel53Layout.setHorizontalGroup(jPanel53Layout
/*  4841 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4842 */         .addGap(0, 950, 32767));
/*       */     
/*  4844 */     jPanel53Layout.setVerticalGroup(jPanel53Layout
/*  4845 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4846 */         .addGap(0, 0, 32767));
/*       */ 
/*       */     
/*  4849 */     this.jPanel51.add(this.jPanel53);
/*  4850 */     this.jPanel53.setBounds(0, 0, 950, 7);
/*       */     
/*  4852 */     this.jLabel155.setText("Comentarios");
/*  4853 */     this.jPanel51.add(this.jLabel155);
/*  4854 */     this.jLabel155.setBounds(5, 10, 140, 15);
/*       */     
/*  4856 */     this.jEditorPane1.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
/*  4857 */     this.jScrollPane5.setViewportView(this.jEditorPane1);
/*       */     
/*  4859 */     this.jPanel51.add(this.jScrollPane5);
/*  4860 */     this.jScrollPane5.setBounds(10, 30, 940, 60);
/*       */     
/*  4862 */     this.jLabel53.setFont(new Font("SF UI Display Light", 1, 12));
/*  4863 */     this.jLabel53.setText("Autorizó *");
/*       */     
/*  4865 */     this.jTextField58.setText("jTextField58");
/*  4866 */     this.jTextField58.setEnabled(false);
/*       */     
/*  4868 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/*  4869 */     this.jPanel13.setLayout(jPanel13Layout);
/*  4870 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/*  4871 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4872 */         .addComponent(this.jPanel51, -1, -1, 32767)
/*  4873 */         .addGroup(jPanel13Layout.createSequentialGroup()
/*  4874 */           .addContainerGap()
/*  4875 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4876 */             .addComponent(this.jPanel27, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/*  4877 */             .addComponent(this.jPanel23, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/*  4878 */             .addGroup(jPanel13Layout.createSequentialGroup()
/*  4879 */               .addComponent(this.jLabel53, -2, 77, -2)
/*  4880 */               .addGap(73, 73, 73)
/*  4881 */               .addComponent(this.jTextField58, -2, 465, -2)
/*  4882 */               .addGap(0, 0, 32767))
/*  4883 */             .addComponent(this.jPanel16, -1, -1, 32767))));
/*       */     
/*  4885 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/*  4886 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4887 */         .addGroup(jPanel13Layout.createSequentialGroup()
/*  4888 */           .addComponent(this.jPanel16, -2, -1, -2)
/*  4889 */           .addGap(30, 30, 30)
/*  4890 */           .addComponent(this.jPanel23, -2, -1, -2)
/*  4891 */           .addGap(36, 36, 36)
/*  4892 */           .addComponent(this.jPanel27, -2, 58, -2)
/*  4893 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, 32767)
/*  4894 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  4895 */             .addComponent(this.jLabel53)
/*  4896 */             .addComponent(this.jTextField58, -2, -1, -2))
/*  4897 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4898 */           .addComponent(this.jPanel51, -2, 100, -2)
/*  4899 */           .addGap(47, 47, 47)));
/*       */ 
/*       */     
/*  4902 */     this.jTabbedPane1.addTab("Otros datos", this.jPanel13);
/*       */     
/*  4904 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/*  4905 */     this.jPanel12.setLayout(jPanel12Layout);
/*  4906 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/*  4907 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4908 */         .addComponent(this.jPanel50, -1, -1, 32767)
/*  4909 */         .addComponent(this.jPanel79, -1, -1, 32767)
/*  4910 */         .addComponent(this.jTabbedPane1));
/*       */     
/*  4912 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/*  4913 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4914 */         .addGroup(jPanel12Layout.createSequentialGroup()
/*  4915 */           .addComponent(this.jPanel50, -2, -1, -2)
/*  4916 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4917 */           .addComponent(this.jTabbedPane1)
/*  4918 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4919 */           .addComponent(this.jPanel79, -2, -1, -2)));
/*       */ 
/*       */     
/*  4922 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  4923 */     getContentPane().setLayout(layout);
/*  4924 */     layout.setHorizontalGroup(layout
/*  4925 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4926 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*       */     
/*  4928 */     layout.setVerticalGroup(layout
/*  4929 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4930 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*       */ 
/*       */     
/*  4933 */     pack();
/*       */   } private JScrollPane jScrollPane37; private JScrollPane jScrollPane38; private JScrollPane jScrollPane39; private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JScrollPane jScrollPane7; private JSeparator jSeparator2; private JSeparator jSeparator9; private JSpinner jSpinner1; private JSpinner jSpinner2; private JSpinner jSpinner3; private JSpinner jSpinner4; private JTabbedPane jTabbedPane1; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField101; private JTextField jTextField102; private JTextField jTextField103; private JTextField jTextField104; private JTextField jTextField105; private JTextField jTextField106; private JTextField jTextField107; private JTextField jTextField109; private JTextField jTextField11; private JTextField jTextField110; private JTextField jTextField111; private JTextField jTextField112; private JTextField jTextField113; private JTextField jTextField114; private JTextField jTextField115; private JTextField jTextField116; private JTextField jTextField12; private JTextField jTextField120; private JTextField jTextField121; private JTextField jTextField122; private JTextField jTextField123; private JTextField jTextField124; private JTextField jTextField13; private JTextField jTextField14; private JTextField jTextField2; private JTextField jTextField20; private JTextField jTextField21; private JTextField jTextField22; private JTextField jTextField23; private JTextField jTextField24; private JTextField jTextField25; private JTextField jTextField26; private JTextField jTextField27; private JTextField jTextField28; private JTextField jTextField29; private JTextField jTextField3; private JTextField jTextField30; private JTextField jTextField31; private JTextField jTextField32; private JTextField jTextField33; private JTextField jTextField34; private JTextField jTextField35; private JTextField jTextField36; private JTextField jTextField37; private JTextField jTextField38; private JTextField jTextField39; private JTextField jTextField4; private JTextField jTextField40; private JTextField jTextField41; private JTextField jTextField42; private JTextField jTextField43; private JTextField jTextField5; private JTextField jTextField50; private JTextField jTextField51; private JTextField jTextField52; private JTextField jTextField53; private JTextField jTextField54; private JTextField jTextField55; private JTextField jTextField56; private JTextField jTextField57; private JTextField jTextField58; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8; private JTextField jTextField80; private JTextField jTextField81; private JTextField jTextField82; private JTextField jTextField83; private JTextField jTextField9; private MaterialButton materialButton1; private MaterialButton materialButton10; private MaterialButton materialButton11; private MaterialButton materialButton2; private MaterialButton materialButton3; private MaterialButton materialButton4; private MaterialButton materialButton40; private MaterialButton materialButton41; private MaterialButton materialButton5; private MaterialButton materialButton6; private MaterialButton materialButton7; private MaterialButton materialButton8; private MaterialButton materialButton9; private RSTableMetro rSTableMetro1; private RSTableMetro rSTableMetro2; private RSTableMetro rSTableMetro3; private RSTableMetro rSTableMetro4; private RSTableMetro rSTableMetro5; private RSTableMetro rSTableMetro6; private RSTableMetro rSTableMetro7;
/*       */   
/*       */   private void jLabel20MouseDragged(MouseEvent evt) {
/*  4937 */     int x = evt.getXOnScreen();
/*  4938 */     int y = evt.getYOnScreen();
/*  4939 */     setLocation(x - this.xx, y - this.xy);
/*       */   }
/*       */   
/*       */   private void jLabel20MouseClicked(MouseEvent evt) {
/*  4943 */     this.xx = evt.getX();
/*  4944 */     this.xy = evt.getY();
/*       */   }
/*       */   
/*       */   private void jLabel128MouseClicked(MouseEvent evt) {
/*  4948 */     setVisible(false);
/*       */   }
/*       */   
/*       */   private void jLabel128MouseEntered(MouseEvent evt) {
/*  4952 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*       */   }
/*       */   
/*       */   private void jLabel128MouseExited(MouseEvent evt) {
/*  4956 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*       */   }
/*       */   
/*       */   private void materialButton2ActionPerformed(ActionEvent evt) {
/*  4960 */     this.actualizado = false;
/*  4961 */     setVisible(false);
/*       */   }
/*       */   
/*       */   private void materialButton1ActionPerformed(ActionEvent evt) {
/*  4965 */     if (this.materialButton1.getText().equals("Imprimir")) {
/*  4966 */       verDatos2(this.ID);
/*  4967 */       verDatos3(this.ID);
/*  4968 */       verDatos4(this.ID);
/*       */     } 
/*       */     
/*  4971 */     double peso = 0.0D;
/*  4972 */     for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/*  4973 */       String p = this.rSTableMetro2.getValueAt(i, 5).toString();
/*  4974 */       peso += Double.parseDouble(p);
/*       */     } 
/*  4976 */     boolean salir = false;
/*  4977 */     String tabla = "";
/*  4978 */     String componer = "";
/*  4979 */     String cliente = String.valueOf(this.jComboBox1.getSelectedItem());
/*  4980 */     String decla = "";
/*  4981 */     String rem1 = "0";
/*       */     
/*  4983 */     this.error.MODAL = true;
/*  4984 */     String[] campos = { "Guía", "Cliente", "Tipo de Servicio", "Operador", "Origen", "Destino", "Mercancía", "Económico", "Remolque 1", "Remolque 2", "Dolly", "Tipo de Equipo" };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  5010 */     String[] info = { this.jTextField1.getText().toUpperCase(), this.jComboBox1.getSelectedItem().toString(), this.jComboBox2.getSelectedItem().toString(), this.jComboBox3.getSelectedItem().toString(), ((OrigenesDestinos)this.ORIGENESDESTINOS.get(0)).getNombre(), this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getNombre()).toArray()[0].toString(), ((Mercancias)this.MERCANCIAS.get(0)).getDescInterna(), this.jTextField21.getText().toUpperCase(), this.jTextField26.getText().toUpperCase(), this.jTextField31.getText().toUpperCase(), this.jTextField36.getText().toUpperCase(), this.jComboBox22.getSelectedItem().toString() };
/*       */     
/*  5012 */     if (this.materialButton1.getText().equals("Guardar")) {
/*  5013 */       int res = this.error.cargarDatos(campos, info);
/*  5014 */       if (res == 0) {
/*  5015 */         String mercancia = "";
/*  5016 */         for (int j = 0; j < this.rSTableMetro2.getRowCount(); j++) {
/*  5017 */           mercancia = mercancia + mercancia + "| ";
/*       */         }
/*  5019 */         sacarMayor();
/*  5020 */         if (!this.jTextField26.getText().equals("")) {
/*  5021 */           rem1 = this.jTextField26.getText();
/*       */         }
/*       */         
/*  5024 */         String origenCorto = ((OrigenesDestinos)this.ORIGENESDESTINOS.get(0)).getNombre();
/*  5025 */         if (origenCorto.length() > 25) {
/*  5026 */           origenCorto = origenCorto.substring(0, 25) + " [" + origenCorto.substring(0, 25) + "]";
/*       */         } else {
/*  5028 */           origenCorto = origenCorto + " [" + origenCorto + "]";
/*       */         } 
/*       */         
/*  5031 */         String destinoCorto = this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getNombre()).toArray()[0].toString();
/*  5032 */         if (destinoCorto.length() > 25) {
/*  5033 */           destinoCorto = destinoCorto.substring(0, 25) + " [" + destinoCorto.substring(0, 25) + "]";
/*       */         } else {
/*  5035 */           destinoCorto = destinoCorto + " [" + destinoCorto + "]";
/*       */         } 
/*       */         
/*  5038 */         this.con.inserSinMsj("insert into llamadas_historicas (residuo, fecha_ped, ingreso, prioridad, descrip, estado, comen, num_equipo, num_plata, num_pozo, nombre_usu, num_guia, num_ope, clave_gene, clave_desti, num_tracto, num_rem, placas1, eq, plat, poz, origen, destino) values ('" + mercancia + "', now(), now(), 5, '" + this.jEditorPane1
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*  5051 */             .getText().toUpperCase() + "', 'ACTIVADA', '', 0, 0, 0, '" + (String)this.CAMPOSGENERALES
/*       */             
/*  5053 */             .get("usuario") + "', '" + this.jTextField1.getText() + "', " + ((Operadores)this.OPERADORES
/*  5054 */             .get(this.jComboBox3.getSelectedIndex() - 1)).getNum_ope() + "," + ((Clientes)this.CLIENTES.get(this.jComboBox1.getSelectedIndex() - 1)).getClave_gene() + "," + this.ORIGENESDESTINOS
/*  5055 */             .stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getClave_gene_desti()).toArray()[0].toString() + ", " + this.jTextField21
/*  5056 */             .getText() + ", " + rem1 + ", '" + this.jTextField22.getText() + "', '" + this.jTextField11
/*  5057 */             .getText().toUpperCase() + "', '" + this.jTextField12.getText().toUpperCase() + "', '" + this.jTextField13.getText().toUpperCase() + "', '" + origenCorto + "', '" + destinoCorto + "')");
/*       */ 
/*       */         
/*  5060 */         this.con.consultar("max(num_llama)", "llamadas_historicas", "");
/*  5061 */         String numllama = this.con.Campo;
/*  5062 */         this.con.inserSinMsj("insert into guias(num_guia, folio_imp, fecha, num_llama, estado, nombre, tipo,num_vale, diesel, servicio,estatus, comen_pre, factura,pedido, factimpresa, manifiesto,operador, prefactura, rem1,placas1, rem2, placas2,fecha_c, fecha_d, ticket1,tons1, ticket2, tons2, claveproductoSat, claveUnidadSat, linea, km, do, lid, actualizacion )values('" + this.jTextField1
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*  5074 */             .getText() + "','" + this.jTextField2.getText().toUpperCase() + "',now()," + numllama + ",'ACTIVA','" + this.jTextField58
/*  5075 */             .getText() + "','" + this.jComboBox22.getSelectedItem().toString().toUpperCase() + "','','','" + 
/*  5076 */             String.valueOf(this.jComboBox2.getSelectedItem()) + "','<Por Timbrar>','',0,'','','','" + 
/*       */ 
/*       */             
/*  5079 */             String.valueOf(this.jComboBox3.getSelectedItem()) + "',0,'" + this.jTextField26.getText() + "','" + this.jTextField27
/*  5080 */             .getText() + "','" + this.jTextField31.getText() + "','" + this.jTextField32.getText() + "',now(),now(),''," + peso + ",'',0, '','','','" + this.jTextField10
/*       */ 
/*       */             
/*  5083 */             .getText() + "','','','')");
/*  5084 */         int indOp = this.jComboBox3.getSelectedIndex();
/*  5085 */         indOp--;
/*  5086 */         String SCT = this.jComboBox4.getSelectedItem().toString().substring(0, 6);
/*  5087 */         this.con.inserSinMsj("insert into tras_cartaporte ( guia, tipoVehiculoF, op_rfc, op_cp, op_licencia, op_calle, op_num, op_col, op_ciudad, op_estado, op_c_colonia, op_c_municipio, op_c_estado, sct, op_c_localidad, op_localidad, pesoVehicular) values ('" + this.jTextField1
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*  5094 */             .getText() + "', '" + String.valueOf(this.jComboBox21.getSelectedItem()) + "', '" + ((Operadores)this.OPERADORES.get(indOp)).getRfc() + "', '" + ((Operadores)this.OPERADORES
/*  5095 */             .get(indOp)).getCp() + "', '" + ((Operadores)this.OPERADORES.get(indOp)).getNum_Licen() + "', '" + ((Operadores)this.OPERADORES
/*  5096 */             .get(indOp)).getCalle() + "', '" + ((Operadores)this.OPERADORES.get(indOp)).getNum() + "', '" + ((Operadores)this.OPERADORES.get(indOp)).getCol() + "', '" + ((Operadores)this.OPERADORES
/*  5097 */             .get(indOp)).getCiudad() + "', '" + ((Operadores)this.OPERADORES.get(indOp)).getEstado() + "', '" + ((Operadores)this.OPERADORES.get(indOp)).getC_colonia() + "', '" + ((Operadores)this.OPERADORES
/*  5098 */             .get(indOp)).getC_municipio() + "', '" + ((Operadores)this.OPERADORES.get(indOp)).getC_estado() + "', '" + SCT + "', '" + ((Operadores)this.OPERADORES.get(indOp)).getC_localidad() + "', '" + ((Operadores)this.OPERADORES.get(indOp)).getLocalidad() + "', " + this.jTextField14.getText() + " )");
/*       */         
/*  5100 */         insertarTrasUbic();
/*  5101 */         insertarTrasMercancias();
/*  5102 */         insertarTrasUni();
/*  5103 */         insertarTrasContenedores();
/*  5104 */         activarModificacion();
/*       */         
/*  5106 */         if (((String)this.CAMPOSGENERALES.get("complementoTraslado")).equals("DESACTIVADO")) {
/*       */           try {
/*  5108 */             timbrarGuia(this.jLabel54.getText());
/*  5109 */           } catch (IOException ex) {
/*  5110 */             Logger.getLogger(GuiasForm.class.getName()).log(Level.SEVERE, (String)null, ex);
/*       */           } 
/*  5112 */         } else if (((String)this.CAMPOSGENERALES.get("complementoTraslado")).equals("ACTIVADO") && 
/*  5113 */           this.jTextField5.getText().equals("FMF901004UZ9")) {
/*  5114 */           res = JOptionPane.showConfirmDialog(this, "¿Deseas timbrar el Comprobante de Traslado y Carta Porte?", "Carta Porte", 0, 3, this.PREG);
/*  5115 */           if (res == 0) {
/*       */             try {
/*  5117 */               timbrarComprobanteTraslado();
/*  5118 */             } catch (IOException ex) {
/*  5119 */               Logger.getLogger(GuiasForm.class.getName()).log(Level.SEVERE, (String)null, ex);
/*       */             } 
/*       */           }
/*       */         } 
/*       */ 
/*       */ 
/*       */         
/*  5126 */         if (!this.TIPOMANIFIESTO.equals("")) {
/*  5127 */           if (this.TIPOMANIFIESTO.equals("AGUA")) {
/*  5128 */             tabla = "manifiestos_lodoagua";
/*  5129 */             componer = "FPR-AG-";
/*  5130 */           } else if (this.TIPOMANIFIESTO.equals("ACEITE")) {
/*  5131 */             tabla = "manifiestos_recorteaceite";
/*  5132 */             componer = "FPR-";
/*       */           } 
/*       */           
/*  5135 */           this.con.inserSinMsj("insert into " + tabla + "(manifiesto,ubicacion,municipio,num_guia,id_edo)values('','','','" + this.jTextField1.getText() + "',33)");
/*  5136 */           this.con.consultar("max(num)", tabla, "");
/*  5137 */           componer = componer + componer;
/*  5138 */           this.con.inserSinMsj("update " + tabla + " set manifiesto = '" + componer + "' where num_guia = '" + this.jTextField1.getText() + "'");
/*  5139 */           this.con.inserSinMsj("update guias set manifiesto='" + componer + "' where num_guia = '" + this.jTextField1.getText() + "'");
/*       */         } 
/*  5141 */         imprimirGuia();
/*  5142 */         setVisible(false);
/*       */       } 
/*  5144 */     } else if (this.materialButton1.getText().equals("Imprimir")) {
/*  5145 */       imprimirGuia();
/*  5146 */       setVisible(false);
/*       */     }
/*  5148 */     else if (this.materialButton1.getText().equals("Modificar") && 
/*  5149 */       validar1() && 
/*  5150 */       validar2() && 
/*  5151 */       validar3()) {
/*  5152 */       if (this.rSTableMetro2.getValueAt(0, 9).toString().equals("")) {
/*  5153 */         JOptionPane.showMessageDialog(this, "Necesitas actualizar la lista de origenes y destinos dentro de la tabla de mercancías", "Falta actualziar origenes y destinos", 0, this.ERROR);
/*       */         return;
/*       */       } 
/*  5156 */       int res = this.error.cargarDatos2(campos, info);
/*  5157 */       if (res == 0) {
/*  5158 */         String mercancia = "";
/*  5159 */         for (int j = 0; j < this.rSTableMetro2.getRowCount(); j++) {
/*  5160 */           mercancia = mercancia + mercancia + "| ";
/*       */         }
/*       */         
/*  5163 */         if (!this.jTextField26.getText().equals("")) {
/*  5164 */           rem1 = this.jTextField26.getText();
/*       */         }
/*       */         
/*  5167 */         String origenCorto = ((OrigenesDestinos)this.ORIGENESDESTINOS.get(0)).getNombre();
/*  5168 */         if (origenCorto.length() > 25) {
/*  5169 */           origenCorto = origenCorto.substring(0, 25) + " [" + origenCorto.substring(0, 25) + "]";
/*       */         } else {
/*  5171 */           origenCorto = origenCorto + " [" + origenCorto + "]";
/*       */         } 
/*       */         
/*  5174 */         String destinoCorto = this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getNombre()).toArray()[0].toString();
/*  5175 */         if (destinoCorto.length() > 25) {
/*  5176 */           destinoCorto = destinoCorto.substring(0, 25) + " [" + destinoCorto.substring(0, 25) + "]";
/*       */         } else {
/*  5178 */           destinoCorto = destinoCorto + " [" + destinoCorto + "]";
/*       */         } 
/*       */         
/*  5181 */         this.con.inserSinMsj("update llamadas_historicas set residuo = '" + mercancia + "', descrip = '" + this.jEditorPane1
/*  5182 */             .getText().toUpperCase() + "', estado = '" + 
/*  5183 */             String.valueOf(this.jComboBox50.getSelectedItem()) + "', nombre_usu = '" + (String)this.CAMPOSGENERALES.get("usuario") + "', num_ope = " + ((Operadores)this.OPERADORES
/*  5184 */             .get(this.jComboBox3.getSelectedIndex() - 1)).getNum_ope() + ", clave_gene = " + ((Clientes)this.CLIENTES
/*  5185 */             .get(this.jComboBox1.getSelectedIndex() - 1)).getClave_gene() + ", clave_desti = " + this.ORIGENESDESTINOS
/*  5186 */             .stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getClave_gene_desti()).toArray()[0].toString() + ", num_tracto = " + this.jTextField21
/*  5187 */             .getText() + ", num_rem = " + rem1 + ", placas1 = '" + this.jTextField22
/*  5188 */             .getText() + "', eq ='" + this.jTextField11.getText() + "', plat = '" + this.jTextField12
/*  5189 */             .getText() + "', poz='" + this.jTextField13.getText() + "', origen ='" + origenCorto + "', destino = '" + destinoCorto + "' where num_guia = '" + this.ID + "'");
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  5194 */         this.con.inserSinMsj("update guias set folio_imp = '" + this.jTextField2
/*  5195 */             .getText().toUpperCase() + "', estado = '" + String.valueOf(this.jComboBox50.getSelectedItem()) + "', nombre = '" + this.jTextField58
/*  5196 */             .getText() + "', tipo = '" + this.jComboBox22.getSelectedItem().toString().toUpperCase() + "', servicio = '" + 
/*  5197 */             String.valueOf(this.jComboBox2.getSelectedItem()) + "', estatus='" + this.jTextField53.getText() + "', operador = '" + 
/*  5198 */             String.valueOf(this.jComboBox3.getSelectedItem()) + "', rem1 = '" + this.jTextField26.getText() + "', placas1 = '" + this.jTextField27
/*  5199 */             .getText() + "', rem2 ='" + this.jTextField31.getText() + "', placas2 ='" + this.jTextField32
/*  5200 */             .getText() + "', ticket1 = '" + this.jTextField51.getText().toUpperCase() + "', tons1 = " + peso + ", km ='" + this.jTextField10
/*  5201 */             .getText() + "', factura = " + this.jTextField55
/*  5202 */             .getText() + ", prefactura = " + this.jTextField56.getText() + ", factImpresa ='" + this.jTextField57.getText().toUpperCase() + "' where num_guia = '" + this.jTextField1
/*  5203 */             .getText() + "'");
/*       */ 
/*       */         
/*  5206 */         this.con.eliminar2("tras_cartaporte", "where guia = '" + this.jTextField1.getText() + "'");
/*  5207 */         int indOp = this.jComboBox3.getSelectedIndex();
/*  5208 */         indOp--;
/*  5209 */         String SCT = this.jComboBox4.getSelectedItem().toString().substring(0, 6);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  5224 */         this.con.inserSinMsj("insert into tras_cartaporte ( guia, tipoVehiculoF, op_rfc, op_cp, op_licencia, op_calle, op_num, op_col, op_ciudad, op_estado, op_c_colonia, op_c_municipio, op_c_estado, sct, op_c_localidad, op_localidad, pesoVehicular) values ('" + this.jTextField1
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */             
/*  5231 */             .getText() + "', '" + String.valueOf(this.jComboBox21.getSelectedItem()) + "', '" + ((Operadores)this.OPERADORES.get(indOp)).getRfc() + "', '" + ((Operadores)this.OPERADORES
/*  5232 */             .get(indOp)).getCp() + "', '" + ((Operadores)this.OPERADORES.get(indOp)).getNum_Licen() + "', '" + ((Operadores)this.OPERADORES
/*  5233 */             .get(indOp)).getCalle() + "', '" + ((Operadores)this.OPERADORES.get(indOp)).getNum() + "', '" + ((Operadores)this.OPERADORES.get(indOp)).getCol() + "', '" + ((Operadores)this.OPERADORES
/*  5234 */             .get(indOp)).getCiudad() + "', '" + ((Operadores)this.OPERADORES.get(indOp)).getEstado() + "', '" + ((Operadores)this.OPERADORES.get(indOp)).getC_colonia() + "', '" + ((Operadores)this.OPERADORES
/*  5235 */             .get(indOp)).getC_municipio() + "', '" + ((Operadores)this.OPERADORES.get(indOp)).getC_estado() + "', '" + SCT + "', '" + ((Operadores)this.OPERADORES.get(indOp)).getC_localidad() + "', '" + ((Operadores)this.OPERADORES.get(indOp)).getLocalidad() + "', " + this.jTextField14.getText() + " )");
/*       */ 
/*       */         
/*  5238 */         this.con.inserSinMsj("update vales set ticket = '" + this.jTextField51.getText().toUpperCase() + "' where num_guia = '" + this.jLabel54.getText() + "'");
/*  5239 */         if (this.entraModificarUbic) {
/*  5240 */           this.con.eliminar2("tras_cartaporte_ubic", "where guia = '" + this.jTextField1.getText() + "'");
/*  5241 */           insertarTrasUbic();
/*       */         } 
/*       */         
/*  5244 */         if (this.entraModificarMercancias) {
/*  5245 */           this.con.eliminar2("tras_cartaporte_mercancias", "where guia = '" + this.jTextField1.getText() + "'");
/*  5246 */           insertarTrasMercancias();
/*       */         } 
/*       */         
/*  5249 */         if (this.entraModificarContenedores) {
/*  5250 */           this.con.eliminar2("tras_cartaporte_mercancias_contenedores", "where guia = '" + this.jTextField1.getText() + "'");
/*  5251 */           insertarTrasContenedores();
/*       */         } 
/*       */         
/*  5254 */         if (this.entraModificarUnidades) {
/*  5255 */           this.con.eliminar2("tras_cartaporte_unidades", "where guia = '" + this.jTextField1.getText() + "'");
/*  5256 */           insertarTrasUni();
/*       */         } 
/*  5258 */         activarModificacion();
/*  5259 */         setVisible(false);
/*       */         
/*  5261 */         imprimirGuia();
/*  5262 */         setVisible(false);
/*       */       } 
/*       */     } 
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   private void jButton47ActionPerformed(ActionEvent evt) {
/*  5271 */     boolean entra = true;
/*  5272 */     if (entra) {
/*  5273 */       this.jButton48.setEnabled(true);
/*  5274 */       this.materialButton1.setEnabled(false);
/*  5275 */       if (this.paso > 0) {
/*  5276 */         this.paso--;
/*       */       }
/*  5278 */       this.jTabbedPane1.removeAll();
/*  5279 */       if (this.paso == 1) {
/*  5280 */         this.jTabbedPane1.add("Información General", this.jPanel4);
/*  5281 */         this.jButton47.setEnabled(false);
/*  5282 */         this.jLabel214.setText("Paso 1/4");
/*       */       } 
/*  5284 */       if (this.paso == 2) {
/*  5285 */         this.jTabbedPane1.add("Ubicaciones", this.jPanel5);
/*  5286 */         this.jLabel214.setText("Paso 2/4");
/*       */       } 
/*  5288 */       if (this.paso == 3) {
/*  5289 */         this.jTabbedPane1.add("Mercancías y Unidades", this.jPanel6);
/*  5290 */         this.jLabel214.setText("Paso 3/4");
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jButton48ActionPerformed(ActionEvent evt) {
/*  5296 */     boolean entra = false;
/*  5297 */     if (this.jLabel214.getText().equals("Paso 1/4")) {
/*  5298 */       entra = validar1();
/*  5299 */     } else if (this.jLabel214.getText().equals("Paso 2/4")) {
/*  5300 */       entra = validar2();
/*  5301 */     } else if (this.jLabel214.getText().equals("Paso 3/4")) {
/*  5302 */       entra = validar3();
/*       */     } 
/*       */     
/*  5305 */     if (entra) {
/*  5306 */       this.jButton47.setEnabled(true);
/*  5307 */       if (this.paso < 4) {
/*  5308 */         this.paso++;
/*       */       }
/*  5310 */       this.jTabbedPane1.removeAll();
/*  5311 */       if (this.paso == 2) {
/*  5312 */         this.jTabbedPane1.add("Ubicaciones", this.jPanel5);
/*  5313 */         this.jLabel214.setText("Paso 2/4");
/*       */       } 
/*  5315 */       if (this.paso == 3) {
/*  5316 */         this.jTabbedPane1.add("Mercancías y Unidades", this.jPanel6);
/*  5317 */         this.jLabel214.setText("Paso 3/4");
/*  5318 */         if (this.materialButton1.getText().equals("Modificar") && this.entraModificarUbic) {
/*  5319 */           actualizarTablaMercanciasDestinos();
/*       */         }
/*       */       } 
/*  5322 */       if (this.paso == 4) {
/*  5323 */         this.jTabbedPane1.add("Otros datos", this.jPanel13);
/*  5324 */         this.jLabel214.setText("Paso 4/4");
/*  5325 */         this.jButton48.setEnabled(false);
/*  5326 */         this.materialButton1.setEnabled(true);
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jButton1ActionPerformed(ActionEvent evt) {
/*  5332 */     this.clienteForm = new GuiasFormCat(this, true, "emp_generadora", this.jButton1);
/*  5333 */     if (this.clienteForm.seleccionado) {
/*  5334 */       this.jComboBox1.setSelectedItem(this.clienteForm.cliente.getNombre());
/*       */     }
/*       */   }
/*       */   
/*       */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/*  5339 */     if (this.entraCatCliente) {
/*  5340 */       int selec = this.jComboBox1.getSelectedIndex();
/*  5341 */       if (selec > 0) {
/*  5342 */         this.jTextField3.setText(((Clientes)this.CLIENTES.get(selec - 1)).getCalle() + ", " + ((Clientes)this.CLIENTES.get(selec - 1)).getCalle());
/*  5343 */         this.jTextField4.setText(((Clientes)this.CLIENTES.get(selec - 1)).getCol() + ", C.P. " + ((Clientes)this.CLIENTES.get(selec - 1)).getCol() + ", " + ((Clientes)this.CLIENTES.get(selec - 1)).getCp());
/*  5344 */         this.jTextField5.setText(((Clientes)this.CLIENTES.get(selec - 1)).getRfc());
/*  5345 */         this.jTextField9.setText(((Clientes)this.CLIENTES.get(selec - 1)).getC_localidad() + " - " + ((Clientes)this.CLIENTES.get(selec - 1)).getC_localidad());
/*  5346 */         if (((Clientes)this.CLIENTES.get(selec - 1)).getSct().equals("TPAF01")) {
/*  5347 */           this.jComboBox4.setSelectedIndex(0);
/*  5348 */         } else if (((Clientes)this.CLIENTES.get(selec - 1)).getSct().equals("TPAF03")) {
/*  5349 */           this.jComboBox4.setSelectedIndex(1);
/*       */         } 
/*       */       } else {
/*  5352 */         this.jTextField3.setText("");
/*  5353 */         this.jTextField4.setText("");
/*  5354 */         this.jTextField5.setText("");
/*  5355 */         this.jTextField9.setText("");
/*  5356 */         this.jComboBox4.setSelectedIndex(0);
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jButton2ActionPerformed(ActionEvent evt) {
/*  5362 */     Dimension di = this.jButton2.getSize();
/*  5363 */     Point p = this.jButton2.getLocationOnScreen();
/*  5364 */     this.jDialog1.setLocation(p.x - 100, p.y + 35);
/*  5365 */     this.jDialog1.setVisible(true);
/*       */   }
/*       */ 
/*       */   
/*       */   private void jComboBox2ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jButton10ActionPerformed(ActionEvent evt) {
/*  5373 */     this.jSpinner4.setValue(Integer.valueOf(1));
/*  5374 */     if (!this.entraPrimeraUbic) {
/*  5375 */       consultarUbic();
/*       */     }
/*  5377 */     this.entraModificarUbic = true;
/*  5378 */     this.jDialog3.setVisible(true);
/*       */   }
/*       */   
/*       */   private void jButton12ActionPerformed(ActionEvent evt) {
/*  5382 */     int ind = this.rSTableMetro1.getSelectedRow();
/*  5383 */     if (ind < 0) {
/*  5384 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder quitarlo", "Selecciona un registro", 0, this.ADVER);
/*       */     } else {
/*  5386 */       this.ORIGENESDESTINOS.remove(ind);
/*  5387 */       this.entraModificarUbic = true;
/*  5388 */       this.entraModificarMercancias = true;
/*  5389 */       this.utilerias.eliminarRegTabla((JTable)this.rSTableMetro1, ind);
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   private void jButton4ActionPerformed(ActionEvent evt) {
/*  5395 */     String tipo = this.jComboBox21.getSelectedItem().toString();
/*  5396 */     if (tipo.equals("TRACTO")) {
/*  5397 */       this.TIPOSELEC = "TRACTO";
/*  5398 */       buscarEco(this.TIPOSELEC);
/*  5399 */     } else if (tipo.equals("UTILITARIO")) {
/*  5400 */       buscarEco("Tracto");
/*       */     } 
/*       */     
/*  5403 */     this.entraModificarUnidades = true;
/*  5404 */     Dimension di = this.jButton4.getSize();
/*  5405 */     Point p = this.jButton4.getLocationOnScreen();
/*  5406 */     this.jDialog4.setLocation(p.x - 100, p.y + 35);
/*  5407 */     this.jDialog4.setVisible(true);
/*       */   }
/*       */ 
/*       */   
/*       */   private void jTextField21ActionPerformed(ActionEvent evt) {
/*  5412 */     this.UNIDADES.stream().filter(c -> (c.getTipo().equals(this.jComboBox21.getSelectedItem().toString()) && c.getEco().equals(this.jTextField21.getText()))).map(c -> c.getPlaca()).forEach(c -> this.jTextField22.setText(c));
/*  5413 */     this.UNIDADES.stream().filter(c -> (c.getTipo().equals(this.jComboBox21.getSelectedItem().toString()) && c.getEco().equals(this.jTextField21.getText()))).map(c -> c.getModelo()).forEach(c -> this.jTextField23.setText(c));
/*  5414 */     this.UNIDADES.stream().filter(c -> (c.getTipo().equals(this.jComboBox21.getSelectedItem().toString()) && c.getEco().equals(this.jTextField21.getText()))).map(c -> c.getPoliza()).forEach(c -> this.jTextField24.setText(c));
/*  5415 */     this.UNIDADES.stream().filter(c -> (c.getTipo().equals(this.jComboBox21.getSelectedItem().toString()) && c.getEco().equals(this.jTextField21.getText()))).map(c -> c.getTipoSat()).forEach(c -> this.jTextField25.setText(c));
/*  5416 */     this.TRACTOACTIVADO = true;
/*       */   }
/*       */   
/*       */   private void jTextField21KeyReleased(KeyEvent evt) {
/*  5420 */     String texto = this.jTextField21.getText();
/*  5421 */     if (texto.equals("")) {
/*  5422 */       this.TRACTOACTIVADO = false;
/*       */     }
/*  5424 */     if (!this.TRACTOACTIVADO) {
/*  5425 */       this.jTextField22.setText("");
/*  5426 */       this.jTextField23.setText("");
/*  5427 */       this.jTextField24.setText("");
/*  5428 */       this.jTextField25.setText("");
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jButton5ActionPerformed(ActionEvent evt) {
/*  5433 */     this.TIPOSELEC = "REMOLQUE 1";
/*  5434 */     buscarEco(this.TIPOSELEC);
/*  5435 */     Dimension di = this.jButton4.getSize();
/*  5436 */     Point p = this.jButton4.getLocationOnScreen();
/*  5437 */     this.entraModificarUnidades = true;
/*  5438 */     this.jDialog4.setLocation(p.x - 100, p.y + 35);
/*  5439 */     this.jDialog4.setVisible(true);
/*       */   }
/*       */   
/*       */   private void jTextField26ActionPerformed(ActionEvent evt) {
/*  5443 */     this.UNIDADES.stream().filter(c -> (c.getTipo().equals("REMOLQUE 1") && c.getEco().equals(this.jTextField26.getText()))).map(c -> c.getPlaca()).forEach(c -> this.jTextField27.setText(c));
/*  5444 */     this.UNIDADES.stream().filter(c -> (c.getTipo().equals("REMOLQUE 1") && c.getEco().equals(this.jTextField26.getText()))).map(c -> c.getModelo()).forEach(c -> this.jTextField28.setText(c));
/*  5445 */     this.UNIDADES.stream().filter(c -> (c.getTipo().equals("REMOLQUE 1") && c.getEco().equals(this.jTextField26.getText()))).map(c -> c.getPoliza()).forEach(c -> this.jTextField29.setText(c));
/*  5446 */     this.UNIDADES.stream().filter(c -> (c.getTipo().equals("REMOLQUE 1") && c.getEco().equals(this.jTextField26.getText()))).map(c -> c.getTipoSat()).forEach(c -> this.jTextField30.setText(c));
/*  5447 */     this.REM1ACTIVADO = true;
/*  5448 */     if (!this.jTextField30.getText().equals("")) {
/*  5449 */       this.datosExtra2 = sacarDatosExtra2(this.jTextField26.getText());
/*  5450 */       this.jComboBox22.setSelectedItem(this.datosExtra2[0]);
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jTextField26KeyReleased(KeyEvent evt) {
/*  5455 */     String texto = this.jTextField26.getText();
/*  5456 */     if (texto.equals("")) {
/*  5457 */       this.REM1ACTIVADO = false;
/*       */     }
/*  5459 */     if (!this.REM1ACTIVADO) {
/*  5460 */       this.jTextField27.setText("");
/*  5461 */       this.jTextField28.setText("");
/*  5462 */       this.jTextField29.setText("");
/*  5463 */       this.jTextField30.setText("");
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jButton6ActionPerformed(ActionEvent evt) {
/*  5468 */     if (this.jTextField26.getText().equals("")) {
/*  5469 */       JOptionPane.showMessageDialog(this, "Necesitas ingresar el primer remolque", "Ingresa el primer remolque", 0, this.ADVER);
/*       */     } else {
/*  5471 */       this.TIPOSELEC = "REMOLQUE 2";
/*  5472 */       buscarEco(this.TIPOSELEC);
/*  5473 */       this.entraModificarUnidades = true;
/*  5474 */       Dimension di = this.jButton4.getSize();
/*  5475 */       Point p = this.jButton6.getLocationOnScreen();
/*  5476 */       this.jDialog4.setLocation(p.x + 50, p.y);
/*  5477 */       this.jDialog4.setVisible(true);
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jTextField31ActionPerformed(ActionEvent evt) {
/*  5482 */     this.UNIDADES.stream().filter(c -> (c.getTipo().equals("REMOLQUE 1") && c.getEco().equals(this.jTextField31.getText()))).map(c -> c.getPlaca()).forEach(c -> this.jTextField32.setText(c));
/*  5483 */     this.UNIDADES.stream().filter(c -> (c.getTipo().equals("REMOLQUE 1") && c.getEco().equals(this.jTextField31.getText()))).map(c -> c.getModelo()).forEach(c -> this.jTextField33.setText(c));
/*  5484 */     this.UNIDADES.stream().filter(c -> (c.getTipo().equals("REMOLQUE 1") && c.getEco().equals(this.jTextField31.getText()))).map(c -> c.getPoliza()).forEach(c -> this.jTextField34.setText(c));
/*  5485 */     this.UNIDADES.stream().filter(c -> (c.getTipo().equals("REMOLQUE 1") && c.getEco().equals(this.jTextField31.getText()))).map(c -> c.getTipoSat()).forEach(c -> this.jTextField35.setText(c));
/*  5486 */     this.REM2ACTIVADO = true;
/*       */   }
/*       */   
/*       */   private void jTextField31KeyReleased(KeyEvent evt) {
/*  5490 */     String texto = this.jTextField31.getText();
/*  5491 */     if (texto.equals("")) {
/*  5492 */       this.REM2ACTIVADO = false;
/*       */     }
/*  5494 */     if (!this.REM2ACTIVADO) {
/*  5495 */       this.jTextField32.setText("");
/*  5496 */       this.jTextField33.setText("");
/*  5497 */       this.jTextField34.setText("");
/*  5498 */       this.jTextField35.setText("");
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jButton7ActionPerformed(ActionEvent evt) {
/*  5503 */     this.TIPOSELEC = "DOLLY";
/*  5504 */     buscarEco(this.TIPOSELEC);
/*  5505 */     this.entraModificarUnidades = true;
/*  5506 */     Dimension di = this.jButton7.getSize();
/*  5507 */     Point p = this.jButton7.getLocationOnScreen();
/*  5508 */     this.jDialog4.setLocation(p.x + 50, p.y);
/*  5509 */     this.jDialog4.setVisible(true);
/*       */   }
/*       */   
/*       */   private void jTextField36ActionPerformed(ActionEvent evt) {
/*  5513 */     this.UNIDADES.stream().filter(c -> (c.getTipo().equals("DOLLY") && c.getEco().equals(this.jTextField36.getText()))).map(c -> c.getPlaca()).forEach(c -> this.jTextField37.setText(c));
/*  5514 */     this.UNIDADES.stream().filter(c -> (c.getTipo().equals("DOLLY") && c.getEco().equals(this.jTextField36.getText()))).map(c -> c.getModelo()).forEach(c -> this.jTextField38.setText(c));
/*  5515 */     this.UNIDADES.stream().filter(c -> (c.getTipo().equals("DOLLY") && c.getEco().equals(this.jTextField36.getText()))).map(c -> c.getPoliza()).forEach(c -> this.jTextField39.setText(c));
/*  5516 */     this.UNIDADES.stream().filter(c -> (c.getTipo().equals("DOLLY") && c.getEco().equals(this.jTextField36.getText()))).map(c -> c.getTipoSat()).forEach(c -> this.jTextField40.setText(c));
/*  5517 */     this.DOLLYACTIVADO = true;
/*       */   }
/*       */   
/*       */   private void jTextField36KeyReleased(KeyEvent evt) {
/*  5521 */     String texto = this.jTextField36.getText();
/*  5522 */     if (texto.equals("")) {
/*  5523 */       this.DOLLYACTIVADO = false;
/*       */     }
/*  5525 */     if (!this.DOLLYACTIVADO) {
/*  5526 */       this.jTextField37.setText("");
/*  5527 */       this.jTextField38.setText("");
/*  5528 */       this.jTextField39.setText("");
/*  5529 */       this.jTextField40.setText("");
/*       */     } 
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField37ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField37KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField40ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField40KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField38ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField38KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField39ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField39KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField22ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField22KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField23ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField23KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField24ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField24KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField25ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField25KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField27ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField27KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField28ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField28KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField29ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField29KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField30ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField30KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField32ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField32KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField33ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField33KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField34ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField34KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField35ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jTextField35KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jButton3ActionPerformed(ActionEvent evt) {
/*  5662 */     this.clienteForm = new GuiasFormCat(this, true, "operadores", this.jButton1);
/*  5663 */     if (this.clienteForm.seleccionado) {
/*  5664 */       this.jComboBox3.setSelectedItem(this.clienteForm.operadores.getNombre() + " " + this.clienteForm.operadores.getNombre() + " " + this.clienteForm.operadores.getAp_pat());
/*       */     }
/*       */   }
/*       */   
/*       */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/*  5669 */     if (this.entraCatOpe) {
/*  5670 */       int selec = this.jComboBox3.getSelectedIndex();
/*  5671 */       if (selec > 0) {
/*  5672 */         this.jTextField6.setText(((Operadores)this.OPERADORES.get(selec - 1)).getRfc());
/*  5673 */         this.jTextField7.setText(((Operadores)this.OPERADORES.get(selec - 1)).getNum_Licen());
/*  5674 */         this.jTextField8.setText(((Operadores)this.OPERADORES
/*  5675 */             .get(selec - 1)).getCalle() + ", " + ((Operadores)this.OPERADORES.get(selec - 1)).getCalle() + ", " + ((Operadores)this.OPERADORES
/*  5676 */             .get(selec - 1)).getNum() + ", " + ((Operadores)this.OPERADORES
/*  5677 */             .get(selec - 1)).getCol());
/*       */ 
/*       */         
/*  5680 */         validarLicencia();
/*       */       } else {
/*  5682 */         this.jTextField6.setText("");
/*  5683 */         this.jTextField7.setText("");
/*  5684 */         this.jTextField8.setText("");
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   private void rSTableMetro3MouseClicked(MouseEvent evt) {
/*  5690 */     if (evt.getClickCount() > 1) {
/*  5691 */       this.jComboBox2.setSelectedItem(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1));
/*  5692 */       this.jDialog1.setVisible(false);
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   private void rSTableMetro3KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jButton58ActionPerformed(ActionEvent evt) {
/*  5701 */     this.jTextField42.setText("");
/*  5702 */     this.materialButton3.setText("Agregar");
/*  5703 */     this.materialButton3.setMnemonic('A');
/*  5704 */     this.materialButton3.setToolTipText("Agregar (Alt+A)");
/*  5705 */     this.jDialog2.setTitle("Agregar");
/*  5706 */     this.jDialog2.setVisible(true);
/*       */   }
/*       */   
/*       */   private void jButton59ActionPerformed(ActionEvent evt) {
/*  5710 */     int ind = this.rSTableMetro3.getSelectedRow();
/*  5711 */     if (ind < 0) {
/*  5712 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder modificarlo", "Selecciona un registro", 0, this.ADVER);
/*       */     } else {
/*  5714 */       this.materialButton3.setText("Modificar");
/*  5715 */       this.materialButton3.setMnemonic('M');
/*  5716 */       this.materialButton3.setToolTipText("Modificar tipo (Alt+M)");
/*  5717 */       this.jTextField42.setText(this.rSTableMetro3.getValueAt(ind, 1).toString());
/*  5718 */       this.jDialog2.setVisible(true);
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   private void jButton61ActionPerformed(ActionEvent evt) {
/*  5724 */     int ind = this.rSTableMetro3.getSelectedRow();
/*  5725 */     if (ind < 0) {
/*  5726 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder eliminarlo", "Selecciona el dato a eliminar", 0, this.ADVER);
/*       */     } else {
/*  5728 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas eleiminar la información que seleccionaste?", "Eliminar...", 0, 3, this.PREG);
/*  5729 */       if (res == 0) {
/*  5730 */         this.con2.eliminar("tras_tiposervicios", "where num=" + String.valueOf(this.rSTableMetro3.getValueAt(ind, 0)));
/*  5731 */         this.jComboBox2.removeItem(this.rSTableMetro3.getValueAt(ind, 1));
/*  5732 */         this.utilerias.eliminarRegTabla((JTable)this.rSTableMetro3, ind);
/*       */       } 
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   private void jTextField80ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jTextField80KeyReleased(KeyEvent evt) {
/*  5742 */     consultarServicios();
/*       */   }
/*       */   
/*       */   private void jTextField42ActionPerformed(ActionEvent evt) {
/*  5746 */     guardarTipos();
/*       */   }
/*       */   
/*       */   private void materialButton4ActionPerformed(ActionEvent evt) {
/*  5750 */     this.jDialog2.setVisible(false);
/*       */   }
/*       */   
/*       */   private void materialButton3ActionPerformed(ActionEvent evt) {
/*  5754 */     guardarTipos();
/*       */   }
/*       */   
/*       */   private void jTabbedPane1MouseClicked(MouseEvent evt) {
/*  5758 */     if (this.jTabbedPane1.getSelectedIndex() == 1) {
/*  5759 */       verDatos2(this.ID);
/*       */     }
/*  5761 */     if (this.jTabbedPane1.getSelectedIndex() == 2) {
/*  5762 */       verDatos3(this.ID);
/*       */     }
/*  5764 */     if (this.jTabbedPane1.getSelectedIndex() == 3) {
/*  5765 */       verDatos4(this.ID);
/*       */     }
/*       */   }
/*       */   
/*       */   private void jCheckBox1ActionPerformed(ActionEvent evt) {
/*  5770 */     if (this.jCheckBox1.isSelected()) {
/*  5771 */       this.jTextField11.setEnabled(true);
/*  5772 */       this.jTextField12.setEnabled(true);
/*  5773 */       this.jTextField13.setEnabled(true);
/*  5774 */       if (!this.entraPrimeraPozos) {
/*  5775 */         llenarPozos();
/*       */       }
/*       */     } else {
/*  5778 */       this.jTextField11.setEnabled(false);
/*  5779 */       this.jTextField12.setEnabled(false);
/*  5780 */       this.jTextField13.setEnabled(false);
/*  5781 */       this.jTextField11.setText("");
/*  5782 */       this.jTextField12.setText("");
/*  5783 */       this.jTextField13.setText("");
/*       */     } 
/*       */   }
/*       */   
/*       */   private void rSTableMetro4MouseClicked(MouseEvent evt) {
/*  5788 */     int ind = this.rSTableMetro4.getSelectedRow();
/*  5789 */     if (evt.getClickCount() > 1) {
/*  5790 */       llenarOrigenDestino();
/*       */     }
/*  5792 */     else if (this.jRadioButton2.isSelected()) {
/*  5793 */       String valor = this.rSTableMetro4.getValueAt(ind, 9).toString();
/*  5794 */       this.jSpinner4.setValue(Integer.valueOf(Integer.parseInt(valor)));
/*       */     } 
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void rSTableMetro4KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jButton60ActionPerformed(ActionEvent evt) {
/*  5804 */     this.actualizado = false;
/*  5805 */     if (this.jRadioButton1.isSelected()) {
/*  5806 */       tras_Origenes_Form form = new tras_Origenes_Form(this.USUARIO, this.padre, this.CAMPOSGENERALES, "NUEVO", this.actualizado, this.LISTACODIGOS, this.CODIGOSP, "");
/*  5807 */       this.actualizado = form.actualizado;
/*  5808 */       if (this.actualizado) {
/*  5809 */         this.jTextField81.setText(form.Origen.get("NOMBRE"));
/*  5810 */         this.jTextField81.setForeground(Color.BLACK);
/*  5811 */         consultarUbic();
/*       */       } 
/*       */     } else {
/*  5814 */       tras_Destinos_Form form = new tras_Destinos_Form(this.USUARIO, this.padre, this.CAMPOSGENERALES, "NUEVO", this.actualizado, this.LISTACODIGOS, this.CODIGOSP, "");
/*  5815 */       this.actualizado = form.actualizado;
/*  5816 */       if (this.actualizado) {
/*  5817 */         this.jTextField81.setText(form.Origen.get("NOMBRE"));
/*  5818 */         this.jTextField81.setForeground(Color.BLACK);
/*  5819 */         consultarUbic();
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jButton62ActionPerformed(ActionEvent evt) {
/*  5825 */     int indice = this.rSTableMetro4.getSelectedRow();
/*  5826 */     if (indice < 0) {
/*  5827 */       JOptionPane.showMessageDialog(this.jDialog3, "Necesitas seleccionar un registro para modificar la información", "Selecciona un registro", 0, this.ADVER);
/*       */     } else {
/*  5829 */       String ID = this.rSTableMetro4.getValueAt(this.rSTableMetro4.getSelectedRow(), 1).toString();
/*  5830 */       this.actualizado = false;
/*  5831 */       if (this.jRadioButton1.isSelected()) {
/*  5832 */         tras_Origenes_Form form = new tras_Origenes_Form(this.USUARIO, this.padre, this.CAMPOSGENERALES, "MODIFICAR", this.actualizado, this.LISTACODIGOS, this.CODIGOSP, ID);
/*  5833 */         this.actualizado = form.actualizado;
/*  5834 */         this.jTextField81.setText(form.Origen.get("NOMBRE"));
/*       */       } else {
/*  5836 */         tras_Destinos_Form form = new tras_Destinos_Form(this.USUARIO, this.padre, this.CAMPOSGENERALES, "MODIFICAR", this.actualizado, this.LISTACODIGOS, this.CODIGOSP, ID);
/*  5837 */         this.actualizado = form.actualizado;
/*  5838 */         this.jTextField81.setText(form.Origen.get("NOMBRE"));
/*       */       } 
/*  5840 */       if (this.actualizado) {
/*  5841 */         this.jTextField81.setForeground(Color.BLACK);
/*  5842 */         consultarUbic();
/*       */       } 
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   private void jTextField81ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jTextField81KeyReleased(KeyEvent evt) {
/*  5852 */     consultarUbic();
/*       */   }
/*       */   
/*       */   private void jLabel56MouseDragged(MouseEvent evt) {
/*  5856 */     int x = evt.getXOnScreen();
/*  5857 */     int y = evt.getYOnScreen();
/*  5858 */     this.jDialog3.setLocation(x - this.xx, y - this.xy);
/*       */   }
/*       */   
/*       */   private void jLabel56MouseClicked(MouseEvent evt) {
/*  5862 */     this.xx = evt.getX();
/*  5863 */     this.xy = evt.getY();
/*       */   }
/*       */   
/*       */   private void jLabel129MouseClicked(MouseEvent evt) {
/*  5867 */     this.jDialog3.setVisible(false);
/*       */   }
/*       */   
/*       */   private void jLabel129MouseEntered(MouseEvent evt) {
/*  5871 */     this.jLabel129.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*       */   }
/*       */   
/*       */   private void jLabel129MouseExited(MouseEvent evt) {
/*  5875 */     this.jLabel129.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*       */   }
/*       */   
/*       */   private void materialButton5ActionPerformed(ActionEvent evt) {
/*  5879 */     llenarOrigenDestino();
/*       */   }
/*       */   
/*       */   private void jRadioButton1ActionPerformed(ActionEvent evt) {
/*  5883 */     this.jSpinner4.setEnabled(false);
/*  5884 */     consultarUbic();
/*       */   }
/*       */   
/*       */   private void jRadioButton2ActionPerformed(ActionEvent evt) {
/*  5888 */     this.jSpinner4.setEnabled(true);
/*       */     
/*  5890 */     String cadenaFecha = "";
/*  5891 */     if (this.rSTableMetro1.getRowCount() > 0) {
/*  5892 */       cadenaFecha = this.rSTableMetro1.getValueAt(0, 11).toString();
/*  5893 */       String AÑO = cadenaFecha.substring(0, 4);
/*  5894 */       String MES = cadenaFecha.substring(5, 7);
/*  5895 */       String DIA = cadenaFecha.substring(8, 10);
/*  5896 */       String HORA = cadenaFecha.substring(11, 13);
/*  5897 */       String MIN = cadenaFecha.substring(14, 16);
/*  5898 */       String SEG = cadenaFecha.substring(17, 19);
/*  5899 */       LocalDateTime ahora = LocalDateTime.of(
/*  5900 */           Integer.parseInt(AÑO), 
/*  5901 */           Integer.parseInt(MES), 
/*  5902 */           Integer.parseInt(DIA), 
/*  5903 */           Integer.parseInt(HORA), 
/*  5904 */           Integer.parseInt(MIN), Integer.parseInt(SEG));
/*       */       
/*  5906 */       LocalDateTime NuevaFecha = ahora.plusHours(12L);
/*  5907 */       this.jDateChooser31.setDate(Timestamp.valueOf(NuevaFecha));
/*       */       
/*  5909 */       int hh = NuevaFecha.getHour();
/*  5910 */       int mm = NuevaFecha.getMinute();
/*  5911 */       int ss = NuevaFecha.getSecond();
/*       */       
/*  5913 */       String Shh = "" + hh;
/*  5914 */       String Smm = "" + mm;
/*  5915 */       String Sss = "" + ss;
/*  5916 */       if (mm < 10) {
/*  5917 */         Smm = "0" + mm;
/*       */       }
/*  5919 */       if (ss < 10) {
/*  5920 */         Sss = "0" + ss;
/*       */       }
/*  5922 */       if (hh < 10) {
/*  5923 */         Shh = "0" + hh;
/*       */       }
/*  5925 */       this.jSpinner1.setValue(Shh);
/*  5926 */       this.jSpinner2.setValue(Smm);
/*  5927 */       this.jSpinner3.setValue(Sss);
/*       */     } 
/*  5929 */     consultarUbic();
/*       */   }
/*       */   
/*       */   private void jButton63ActionPerformed(ActionEvent evt) {
/*  5933 */     int indice = this.rSTableMetro4.getSelectedRow();
/*  5934 */     if (indice < 0) {
/*  5935 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar un registro para ver la información", "Selecciona un registro", 0, this.ADVER);
/*       */     } else {
/*  5937 */       String ID = this.rSTableMetro4.getValueAt(this.rSTableMetro4.getSelectedRow(), 1).toString();
/*  5938 */       if (this.jRadioButton1.isSelected()) {
/*  5939 */         tras_Origenes_Form tras_Origenes_Form = new tras_Origenes_Form(this.USUARIO, this.padre, this.CAMPOSGENERALES, "VER", this.actualizado, this.LISTACODIGOS, this.CODIGOSP, ID);
/*       */       } else {
/*  5941 */         tras_Destinos_Form tras_Destinos_Form = new tras_Destinos_Form(this.USUARIO, this.padre, this.CAMPOSGENERALES, "VER", this.actualizado, this.LISTACODIGOS, this.CODIGOSP, ID);
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/*  5947 */     if (evt.getClickCount() > 1) {
/*  5948 */       String tipo = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString();
/*  5949 */       if (tipo.equals("ORIGEN")) {
/*  5950 */         String ID = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2).toString();
/*  5951 */         tras_Origenes_Form tras_Origenes_Form = new tras_Origenes_Form(this.USUARIO, this.padre, this.CAMPOSGENERALES, "VER", this.actualizado, this.LISTACODIGOS, this.CODIGOSP, ID);
/*       */       } else {
/*  5953 */         String ID = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2).toString();
/*  5954 */         tras_Destinos_Form tras_Destinos_Form = new tras_Destinos_Form(this.USUARIO, this.padre, this.CAMPOSGENERALES, "VER", this.actualizado, this.LISTACODIGOS, this.CODIGOSP, ID);
/*       */       } 
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jRadioButton3ActionPerformed(ActionEvent evt) {
/*  5964 */     this.jSpinner4.setEnabled(false);
/*  5965 */     consultarUbic();
/*       */   }
/*       */   
/*       */   private void jButton11ActionPerformed(ActionEvent evt) {
/*  5969 */     llenarOrigenDestinoMercancias();
/*  5970 */     limpiarContenedor();
/*  5971 */     limpiarConcepto();
/*  5972 */     this.entraModificarMercancias = true;
/*  5973 */     this.materialButton8.setText("Agregar");
/*  5974 */     this.materialButton8.setToolTipText("Agregar Nuevo");
/*  5975 */     this.materialButton8.setMnemonic('A');
/*  5976 */     this.entraModificarUbic = true;
/*  5977 */     this.materialButton8.setEnabled(true);
/*  5978 */     if (this.jComboBox2.getSelectedItem().toString().equals("SERVICIO INTEGRAL")) {
/*  5979 */       this.jEditorPane100.setEnabled(false);
/*  5980 */       this.jButton107.setEnabled(true);
/*       */     } else {
/*  5982 */       this.jEditorPane100.setEnabled(true);
/*  5983 */       this.jButton107.setEnabled(false);
/*       */     } 
/*  5985 */     this.jTextField102.setEnabled(true);
/*  5986 */     this.jDialog5.setVisible(true);
/*       */   }
/*       */   
/*       */   private void jButton13ActionPerformed(ActionEvent evt) {
/*  5990 */     int ind = this.rSTableMetro2.getSelectedRow();
/*  5991 */     if (ind < 0) {
/*  5992 */       JOptionPane.showMessageDialog(this, "Necesitas seleccionar una mercancía para poder quitarla", "Selecciona una mercancía", 0, this.ADVER);
/*       */     } else {
/*  5994 */       this.MERCANCIAS.remove(ind);
/*  5995 */       this.entraModificarMercancias = true;
/*  5996 */       this.utilerias.eliminarRegTabla((JTable)this.rSTableMetro2, ind);
/*  5997 */       this.jTextField20.setText("" + this.rSTableMetro2.getRowCount());
/*  5998 */       this.entraModificarUbic = true;
/*       */     } 
/*       */   }
/*       */   
/*       */   private void rSTableMetro2MouseClicked(MouseEvent evt) {
/*  6003 */     if (evt.getClickCount() > 1) {
/*  6004 */       limpiarConcepto();
/*  6005 */       llenarOrigenDestinoMercancias();
/*  6006 */       Mercancias m = this.MERCANCIAS.get(this.rSTableMetro2.getSelectedRow());
/*  6007 */       this.jFormattedTextField100.setValue(Double.valueOf(this.utilerias.convertirCantTexto(m.getCantidad())));
/*  6008 */       this.jTextField101.setText(m.getClaveUnidad());
/*  6009 */       this.jTextField102.setText(m.getClaveUnidadDesc());
/*  6010 */       this.jTextField103.setText(m.getClaveSTCC());
/*  6011 */       this.jTextField104.setText(m.getClaveSTCCDesc());
/*  6012 */       this.jTextField105.setText(m.getClaveProd());
/*  6013 */       this.jTextField106.setText(m.getClaveProdDesc());
/*  6014 */       this.jEditorPane100.setText(m.getDescInterna());
/*  6015 */       this.jTextField107.setText(m.getDimensiones());
/*  6016 */       this.jFormattedTextField102.setText(m.getPeso());
/*  6017 */       this.jFormattedTextField103.setText(m.getPesoBruto());
/*  6018 */       this.jFormattedTextField101.setValue(Double.valueOf(this.utilerias.convertirCantTexto(m.getValor())));
/*  6019 */       this.jTextField109.setText(m.getMoneda());
/*  6020 */       this.jComboBox100.setSelectedItem(m.getOrigen());
/*  6021 */       this.jComboBox101.setSelectedItem(m.getDestino());
/*  6022 */       if (m.getMatPeligroso().equals("SI")) {
/*  6023 */         this.jCheckBox4.setSelected(true);
/*  6024 */         this.jTextField110.setText(m.getClaveMatPeligroso());
/*  6025 */         this.jTextField111.setText(m.getClaveMatPeligrosoDesc());
/*  6026 */         this.jTextField112.setText(m.getClaveEmbalaje());
/*  6027 */         this.jTextField113.setText(m.getClaveEmbalajeDesc());
/*  6028 */         this.jButton104.setEnabled(true);
/*  6029 */         this.jButton105.setEnabled(true);
/*       */       } 
/*  6031 */       if (m.getArancel().equals("SI")) {
/*  6032 */         this.jCheckBox5.setSelected(true);
/*  6033 */         this.jTextField114.setText(m.getClaveAranceles());
/*  6034 */         this.jTextField115.setText(m.getClaveArancelesDesc());
/*  6035 */         this.jTextField116.setText(m.getUUID());
/*  6036 */         this.jButton106.setEnabled(true);
/*       */       } 
/*       */       
/*  6039 */       if (this.materialButton1.getText().equals("Guardar") || this.materialButton1.getText().equals("Modificar")) {
/*  6040 */         this.materialButton8.setText("Modificar");
/*  6041 */         this.materialButton8.setToolTipText("Modificar Mercancía");
/*  6042 */         this.materialButton8.setMnemonic('M');
/*  6043 */         this.materialButton8.setEnabled(true);
/*  6044 */         this.jButton110.setEnabled(true);
/*  6045 */         this.jButton111.setEnabled(true);
/*  6046 */         this.jButton112.setEnabled(true);
/*  6047 */         this.materialButton6.setEnabled(true);
/*       */       } 
/*       */       
/*  6050 */       if (this.materialButton1.getText().equals("Imprimir")) {
/*  6051 */         this.jCheckBox4.setEnabled(false);
/*  6052 */         this.jTextField110.setEnabled(false);
/*  6053 */         this.jTextField111.setEnabled(false);
/*  6054 */         this.jTextField112.setEnabled(false);
/*  6055 */         this.jTextField113.setEnabled(false);
/*  6056 */         this.jButton104.setEnabled(false);
/*  6057 */         this.jButton105.setEnabled(false);
/*       */         
/*  6059 */         this.jCheckBox5.setEnabled(false);
/*  6060 */         this.jTextField114.setEnabled(false);
/*  6061 */         this.jTextField115.setEnabled(false);
/*  6062 */         this.jTextField116.setEnabled(false);
/*  6063 */         this.jButton106.setEnabled(false);
/*       */         
/*  6065 */         this.materialButton8.setEnabled(false);
/*       */       } 
/*       */       
/*  6068 */       if (!this.jTextField53.getText().equals("<Por Timbrar>")) {
/*  6069 */         this.jCheckBox4.setEnabled(false);
/*  6070 */         this.jCheckBox5.setEnabled(false);
/*       */         
/*  6072 */         this.jButton104.setEnabled(false);
/*  6073 */         this.jButton105.setEnabled(false);
/*       */         
/*  6075 */         this.jButton106.setEnabled(false);
/*  6076 */         this.materialButton6.setEnabled(false);
/*  6077 */         this.materialButton8.setEnabled(false);
/*       */       } 
/*       */       
/*  6080 */       this.jDialog5.setVisible(true);
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   private void rSTableMetro2KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void rSTableMetro5MouseClicked(MouseEvent evt) {
/*  6089 */     if (evt.getClickCount() > 1) {
/*  6090 */       pasarEco(this.TIPOSELEC, this.rSTableMetro5.getSelectedRow());
/*       */     }
/*       */   }
/*       */ 
/*       */   
/*       */   private void rSTableMetro5KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jTextField82ActionPerformed(ActionEvent evt) {
/*  6099 */     int ind = this.rSTableMetro5.getRowCount();
/*  6100 */     if (ind > 0) {
/*  6101 */       pasarEco(this.TIPOSELEC, 0);
/*       */     }
/*       */   }
/*       */   
/*       */   private void jTextField82KeyReleased(KeyEvent evt) {
/*  6106 */     buscarEco(this.TIPOSELEC);
/*       */   }
/*       */   
/*       */   private void jComboBox21ActionPerformed(ActionEvent evt) {
/*  6110 */     this.jTextField21.setText("");
/*  6111 */     this.jTextField22.setText("");
/*  6112 */     this.jTextField23.setText("");
/*  6113 */     this.jTextField24.setText("");
/*  6114 */     this.jTextField25.setText("");
/*       */   }
/*       */ 
/*       */   
/*       */   private void jComboBox22ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jLabel63MouseDragged(MouseEvent evt) {
/*  6122 */     int x = evt.getXOnScreen();
/*  6123 */     int y = evt.getYOnScreen();
/*  6124 */     this.jDialog5.setLocation(x - this.xx, y - this.xy);
/*       */   }
/*       */   
/*       */   private void jLabel63MouseClicked(MouseEvent evt) {
/*  6128 */     this.xx = evt.getX();
/*  6129 */     this.xy = evt.getY();
/*       */   }
/*       */   
/*       */   private void jLabel130MouseClicked(MouseEvent evt) {
/*  6133 */     this.jDialog5.setVisible(false);
/*       */   }
/*       */   
/*       */   private void jLabel130MouseEntered(MouseEvent evt) {
/*  6137 */     this.jLabel130.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*       */   }
/*       */   
/*       */   private void jLabel130MouseExited(MouseEvent evt) {
/*  6141 */     this.jLabel130.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jFormattedTextField100FocusGained(FocusEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jFormattedTextField100FocusLost(FocusEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jFormattedTextField100ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jButton100ActionPerformed(ActionEvent evt) {
/*  6157 */     this.TIPOCAT = "UNIDAD";
/*  6158 */     Dimension di = this.jButton100.getSize();
/*  6159 */     Point p = this.jButton100.getLocationOnScreen();
/*  6160 */     consultarCatalogo(this.TIPOCAT);
/*  6161 */     this.jDialog6.setLocation(p.x + 30, p.y - 10);
/*  6162 */     this.jDialog6.setVisible(true);
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField101ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jTextField101KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jButton103ActionPerformed(ActionEvent evt) {
/*  6174 */     this.TIPOCAT = "MONEDA";
/*  6175 */     Dimension di = this.jButton103.getSize();
/*  6176 */     Point p = this.jButton103.getLocationOnScreen();
/*  6177 */     consultarCatalogo(this.TIPOCAT);
/*  6178 */     this.jDialog6.setLocation(p.x + 30, p.y - 10);
/*  6179 */     this.jDialog6.setVisible(true);
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField109ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField109KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jComboBox100ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jComboBox101ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jButton106ActionPerformed(ActionEvent evt) {
/*  6199 */     this.TIPOCAT = "ARANCEL";
/*  6200 */     Dimension di = this.jButton106.getSize();
/*  6201 */     Point p = this.jButton106.getLocationOnScreen();
/*  6202 */     consultarCatalogo(this.TIPOCAT);
/*  6203 */     this.jDialog6.setLocation(p.x + 30, p.y - 170);
/*  6204 */     this.jDialog6.setVisible(true);
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField114ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField114KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField116ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jTextField116KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void materialButton8ActionPerformed(ActionEvent evt) {
/*  6224 */     if (this.jFormattedTextField100.getText().equals("0.00")) {
/*  6225 */       this.jFormattedTextField100.setBackground(Color.RED);
/*  6226 */       JOptionPane.showMessageDialog(this.jDialog5, "Falta agregar la información de la cantidad", "Falta la cantidad", 0, this.ERROR);
/*  6227 */     } else if (this.jTextField101.getText().equals("")) {
/*  6228 */       JOptionPane.showMessageDialog(this.jDialog5, "Falta agregar la clave de la unidad", "Falta la clave de unidad", 0, this.ERROR);
/*  6229 */     } else if (this.jTextField102.getText().length() > 20) {
/*  6230 */       this.jTextField102.setBackground(Color.RED);
/*  6231 */       JOptionPane.showMessageDialog(this.jDialog5, "La descripción de la unidad no debe superar 20 caracteres", "Límite 20 Caracteres", 0, this.ERROR);
/*  6232 */     } else if (this.jTextField105.getText().equals("")) {
/*  6233 */       JOptionPane.showMessageDialog(this.jDialog5, "Falta agregar la clave del producto", "Falta la clave del producto", 0, this.ERROR);
/*  6234 */     } else if (this.jEditorPane100.getText().equals("")) {
/*  6235 */       this.jEditorPane100.setBackground(Color.RED);
/*  6236 */       JOptionPane.showMessageDialog(this.jDialog5, "Falta agregar la descripción interna de la mercancía", "Falta la descripción", 0, this.ERROR);
/*  6237 */     } else if (this.jFormattedTextField102.getText().equals("0.00")) {
/*  6238 */       this.jFormattedTextField102.setBackground(Color.RED);
/*  6239 */       JOptionPane.showMessageDialog(this.jDialog5, "Falta agregar el peso Neto de la mercancía", "Falta el peso Neto", 0, this.ERROR);
/*  6240 */     } else if (this.jFormattedTextField103.getText().equals("0.00")) {
/*  6241 */       this.jFormattedTextField103.setBackground(Color.RED);
/*  6242 */       JOptionPane.showMessageDialog(this.jDialog5, "Falta agregar el peso Bruto de la mercancía", "Falta el peso Bruto", 0, this.ERROR);
/*       */ 
/*       */     
/*       */     }
/*  6246 */     else if (this.jCheckBox4.isSelected() && this.jTextField110.getText().equals("")) {
/*  6247 */       JOptionPane.showMessageDialog(this.jDialog5, "Falta agregar clave del Material Peligroso", "Falta clave", 0, this.ERROR);
/*  6248 */     } else if (this.jCheckBox4.isSelected() && this.jTextField112.getText().equals("")) {
/*  6249 */       JOptionPane.showMessageDialog(this.jDialog5, "Falta agregar clave del Embalaje", "Fala clave", 0, this.ERROR);
/*  6250 */     } else if (this.jCheckBox5.isSelected() && this.jTextField114.getText().equals("")) {
/*  6251 */       JOptionPane.showMessageDialog(this.jDialog5, "Falta agregar clave de los Aranceles", "Falta clave", 0, this.ERROR);
/*       */     } else {
/*  6253 */       String MatPeligroso = "NO";
/*  6254 */       String Aranceles = "NO";
/*  6255 */       if (this.jCheckBox4.isSelected()) {
/*  6256 */         MatPeligroso = "SI";
/*       */       }
/*  6258 */       if (this.jCheckBox5.isSelected()) {
/*  6259 */         Aranceles = "SI";
/*       */       }
/*       */       
/*  6262 */       Mercancias m = new Mercancias();
/*  6263 */       m.setCantidad(this.jFormattedTextField100.getText());
/*  6264 */       m.setClaveUnidad(this.jTextField101.getText().toUpperCase());
/*  6265 */       m.setClaveUnidadDesc(this.jTextField102.getText().toUpperCase());
/*  6266 */       m.setClaveSTCC(this.jTextField103.getText().toUpperCase());
/*  6267 */       m.setClaveSTCCDesc(this.jTextField104.getText().toUpperCase());
/*  6268 */       m.setClaveProd(this.jTextField105.getText().toUpperCase());
/*  6269 */       m.setClaveProdDesc(this.jTextField106.getText().toUpperCase());
/*  6270 */       m.setDescInterna(this.jEditorPane100.getText().toUpperCase());
/*  6271 */       m.setDimensiones(this.jTextField107.getText().toUpperCase());
/*  6272 */       m.setPeso(this.jFormattedTextField102.getText().toUpperCase());
/*  6273 */       m.setPesoBruto(this.jFormattedTextField103.getText().toUpperCase());
/*  6274 */       m.setValor(this.jFormattedTextField101.getText());
/*  6275 */       m.setMoneda(this.jTextField109.getText());
/*  6276 */       m.setOrigen(this.jComboBox100.getSelectedItem().toString());
/*  6277 */       m.setDestino(this.jComboBox101.getSelectedItem().toString());
/*  6278 */       m.setMatPeligroso(MatPeligroso);
/*  6279 */       m.setClaveMatPeligroso(this.jTextField110.getText().toUpperCase());
/*  6280 */       m.setClaveMatPeligrosoDesc(this.jTextField111.getText().toUpperCase());
/*  6281 */       m.setClaveEmbalaje(this.jTextField112.getText().toUpperCase());
/*  6282 */       m.setClaveEmbalajeDesc(this.jTextField113.getText().toUpperCase());
/*  6283 */       m.setArancel(Aranceles);
/*  6284 */       m.setClaveAranceles(this.jTextField114.getText().toUpperCase());
/*  6285 */       m.setClaveArancelesDesc(this.jTextField115.getText().toUpperCase());
/*  6286 */       m.setUUID(this.jTextField116.getText().toUpperCase());
/*       */       
/*  6288 */       if (this.materialButton8.getText().equals("Agregar")) {
/*  6289 */         this.MERCANCIAS.add(m);
/*  6290 */         this.utilerias.agregarCampoTablas(new String[] { m
/*       */               
/*  6292 */               .getCantidad(), m
/*  6293 */               .getClaveUnidad() + " - " + m.getClaveUnidad(), m.claveProd, m
/*       */               
/*  6295 */               .getDescInterna(), m
/*  6296 */               .getDimensiones(), m
/*  6297 */               .getPeso(), m
/*  6298 */               .getValor(), m
/*  6299 */               .getMoneda(), m
/*  6300 */               .getMatPeligroso() + "  " + m.getMatPeligroso(), m
/*  6301 */               .getOrigen(), m
/*  6302 */               .getDestino(), m
/*  6303 */               .getArancel() + "  " + m.getArancel() }, (JTable)this.rSTableMetro2);
/*       */       }
/*       */       else {
/*       */         
/*  6307 */         int ind = this.rSTableMetro2.getSelectedRow();
/*  6308 */         this.MERCANCIAS.set(ind, m);
/*  6309 */         this.rSTableMetro2.setValueAt(m.getCantidad(), ind, 0);
/*  6310 */         this.rSTableMetro2.setValueAt(m.getClaveUnidad() + " - " + m.getClaveUnidad(), ind, 1);
/*  6311 */         this.rSTableMetro2.setValueAt(m.getClaveProd(), ind, 2);
/*  6312 */         this.rSTableMetro2.setValueAt(m.getDescInterna(), ind, 3);
/*  6313 */         this.rSTableMetro2.setValueAt(m.getDimensiones(), ind, 4);
/*  6314 */         this.rSTableMetro2.setValueAt(m.getPeso(), ind, 5);
/*  6315 */         this.rSTableMetro2.setValueAt(m.getValor(), ind, 6);
/*  6316 */         this.rSTableMetro2.setValueAt(m.getMoneda(), ind, 7);
/*  6317 */         this.rSTableMetro2.setValueAt(m.getMatPeligroso() + "  " + m.getMatPeligroso(), ind, 8);
/*  6318 */         this.rSTableMetro2.setValueAt(m.getOrigen(), ind, 9);
/*  6319 */         this.rSTableMetro2.setValueAt(m.getDestino(), ind, 10);
/*  6320 */         this.rSTableMetro2.setValueAt(m.getArancel() + "  " + m.getArancel(), ind, 11);
/*       */       } 
/*  6322 */       this.entraModificarMercancias = true;
/*  6323 */       this.jTextField20.setText("" + this.rSTableMetro2.getRowCount());
/*  6324 */       this.jDialog5.setVisible(false);
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jButton101ActionPerformed(ActionEvent evt) {
/*  6329 */     this.TIPOCAT = "STCC";
/*  6330 */     Dimension di = this.jButton101.getSize();
/*  6331 */     Point p = this.jButton101.getLocationOnScreen();
/*  6332 */     consultarCatalogo(this.TIPOCAT);
/*  6333 */     this.jDialog6.setLocation(p.x + 30, p.y - 10);
/*  6334 */     this.jDialog6.setVisible(true);
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField103ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jTextField103KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jButton102ActionPerformed(ActionEvent evt) {
/*  6346 */     this.TIPOCAT = "PRODUCTO";
/*  6347 */     Dimension di = this.jButton102.getSize();
/*  6348 */     Point p = this.jButton102.getLocationOnScreen();
/*  6349 */     consultarCatalogo(this.TIPOCAT);
/*  6350 */     this.jDialog6.setLocation(p.x + 30, p.y - 10);
/*  6351 */     this.jDialog6.setVisible(true);
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField105ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jTextField105KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jButton104ActionPerformed(ActionEvent evt) {
/*  6363 */     this.TIPOCAT = "MATPELIGROSO";
/*  6364 */     Dimension di = this.jButton104.getSize();
/*  6365 */     Point p = this.jButton104.getLocationOnScreen();
/*  6366 */     consultarCatalogo(this.TIPOCAT);
/*  6367 */     this.jDialog6.setLocation(p.x + 30, p.y - 10);
/*  6368 */     this.jDialog6.setVisible(true);
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField110ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jTextField110KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jButton105ActionPerformed(ActionEvent evt) {
/*  6380 */     this.TIPOCAT = "EMBALAJE";
/*  6381 */     Dimension di = this.jButton105.getSize();
/*  6382 */     Point p = this.jButton105.getLocationOnScreen();
/*  6383 */     consultarCatalogo(this.TIPOCAT);
/*  6384 */     this.jDialog6.setLocation(p.x + 30, p.y - 70);
/*  6385 */     this.jDialog6.setVisible(true);
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField112ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField112KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField115ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jTextField115KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jCheckBox4ActionPerformed(ActionEvent evt) {
/*  6405 */     if (this.jCheckBox4.isSelected()) {
/*  6406 */       this.jButton104.setEnabled(true);
/*  6407 */       this.jButton105.setEnabled(true);
/*       */     } else {
/*  6409 */       this.jButton104.setEnabled(false);
/*  6410 */       this.jButton105.setEnabled(false);
/*  6411 */       this.jTextField110.setText("");
/*  6412 */       this.jTextField111.setText("");
/*  6413 */       this.jTextField112.setText("");
/*  6414 */       this.jTextField113.setText("");
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jCheckBox5ActionPerformed(ActionEvent evt) {
/*  6419 */     if (this.jCheckBox5.isSelected()) {
/*  6420 */       this.jButton106.setEnabled(true);
/*  6421 */       this.jTextField116.setEnabled(true);
/*       */     } else {
/*  6423 */       this.jButton106.setEnabled(false);
/*  6424 */       this.jTextField114.setText("");
/*  6425 */       this.jTextField115.setText("");
/*  6426 */       this.jTextField116.setText("");
/*  6427 */       this.jTextField116.setEnabled(false);
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   private void jFormattedTextField101FocusLost(FocusEvent evt) {}
/*       */ 
/*       */   
/*       */   private void rSTableMetro6MouseClicked(MouseEvent evt) {
/*  6436 */     if (evt.getClickCount() > 1) {
/*  6437 */       asignarCat(this.TIPOCAT);
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void rSTableMetro6KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jTextField120ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jTextField120KeyReleased(KeyEvent evt) {
/*  6450 */     consultarCatalogo(this.TIPOCAT);
/*       */   }
/*       */ 
/*       */   
/*       */   private void jTextField121ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jTextField121KeyReleased(KeyEvent evt) {
/*  6458 */     consultarCatalogo(this.TIPOCAT);
/*       */   }
/*       */   
/*       */   private void jLabel64MouseDragged(MouseEvent evt) {
/*  6462 */     int x = evt.getXOnScreen();
/*  6463 */     int y = evt.getYOnScreen();
/*  6464 */     this.jDialog7.setLocation(x - this.xx, y - this.xy);
/*       */   }
/*       */   
/*       */   private void jLabel64MouseClicked(MouseEvent evt) {
/*  6468 */     this.xx = evt.getX();
/*  6469 */     this.xy = evt.getY();
/*       */   }
/*       */   
/*       */   private void jLabel131MouseClicked(MouseEvent evt) {
/*  6473 */     this.jDialog7.setVisible(false);
/*       */   }
/*       */   
/*       */   private void jLabel131MouseEntered(MouseEvent evt) {
/*  6477 */     this.jLabel131.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*       */   }
/*       */   
/*       */   private void jLabel131MouseExited(MouseEvent evt) {
/*  6481 */     this.jLabel131.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*       */   }
/*       */   
/*       */   private void materialButton6ActionPerformed(ActionEvent evt) {
/*  6485 */     if (this.jTextField122.getText().equals("")) {
/*  6486 */       this.jTextField122.setBackground(Color.RED);
/*  6487 */       JOptionPane.showMessageDialog(this.jDialog7, "Necesitas ingresar el número de matrícula", "Ingresa la matrícula", 0, this.ADVER);
/*       */     } else {
/*  6489 */       this.LISTACONTENEDORES.put(
/*  6490 */           Integer.valueOf(this.NUMCONTENEDOR), new Contenedores(this.jTextField122
/*       */             
/*  6492 */             .getText().toUpperCase(), this.TIPOCONTENEDORES
/*  6493 */             .keySet().toArray()[this.jComboBox102.getSelectedIndex()].toString(), this.jTextField123
/*  6494 */             .getText().toUpperCase(), this.jTextField124
/*  6495 */             .getText().toUpperCase()));
/*       */ 
/*       */       
/*  6498 */       if (this.NUMCONTENEDOR == 1) {
/*  6499 */         this.jButton110.setText(this.jTextField122.getText().toUpperCase());
/*  6500 */       } else if (this.NUMCONTENEDOR == 2) {
/*  6501 */         this.jButton111.setText(this.jTextField122.getText().toUpperCase());
/*  6502 */       } else if (this.NUMCONTENEDOR == 3) {
/*  6503 */         this.jButton112.setText(this.jTextField122.getText().toUpperCase());
/*       */       } 
/*       */       
/*  6506 */       this.LISTACONTENEDORES.forEach((x, y) -> System.out.println(y.getMatricula()));
/*       */       
/*  6508 */       this.jDialog7.setVisible(false);
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jButton110ActionPerformed(ActionEvent evt) {
/*  6513 */     this.jTextField122.setText("");
/*  6514 */     this.jTextField123.setText("");
/*  6515 */     this.jTextField124.setText("");
/*  6516 */     this.jComboBox102.setSelectedIndex(0);
/*  6517 */     this.NUMCONTENEDOR = 1;
/*  6518 */     this.entraModificarContenedores = true;
/*  6519 */     contenedor(this.NUMCONTENEDOR, this.jButton110.getText());
/*       */   }
/*       */   
/*       */   private void jButton111ActionPerformed(ActionEvent evt) {
/*  6523 */     if (this.jButton110.getText().equals("Agregar")) {
/*  6524 */       JOptionPane.showMessageDialog(this.jDialog7, "Necesitas ingresar el primer contenedor", "Ingresa el primero", 0, this.ADVER);
/*       */     } else {
/*  6526 */       this.jComboBox102.setSelectedIndex(0);
/*  6527 */       this.jTextField122.setText("");
/*  6528 */       this.jTextField123.setText("");
/*  6529 */       this.jTextField124.setText("");
/*  6530 */       this.entraModificarContenedores = true;
/*  6531 */       this.NUMCONTENEDOR = 2;
/*  6532 */       contenedor(this.NUMCONTENEDOR, this.jButton111.getText());
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jButton112ActionPerformed(ActionEvent evt) {
/*  6537 */     if ((this.jButton110.getText().equals("Agregar") && this.jButton111.getText().equals("Agregar")) || this.jButton111.getText().equals("Agregar")) {
/*  6538 */       JOptionPane.showMessageDialog(this.jDialog7, "Necesitas ingresar el primer y segundo contenedor", "Ingresa los contenedore", 0, this.ADVER);
/*       */     } else {
/*  6540 */       this.jComboBox102.setSelectedIndex(0);
/*  6541 */       this.jTextField122.setText("");
/*  6542 */       this.jTextField123.setText("");
/*  6543 */       this.jTextField124.setText("");
/*  6544 */       this.entraModificarContenedores = true;
/*  6545 */       this.NUMCONTENEDOR = 3;
/*  6546 */       contenedor(this.NUMCONTENEDOR, this.jButton112.getText());
/*       */     } 
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jComboBox102ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void materialButton7ActionPerformed(ActionEvent evt) {
/*  6557 */     this.jDialog8.setVisible(false);
/*       */   }
/*       */   
/*       */   private void materialButton9ActionPerformed(ActionEvent evt) {
/*  6561 */     this.jTextField41.setText(this.RUTA);
/*  6562 */     this.jDialog9.setVisible(true);
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jFormattedTextField102FocusGained(FocusEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jFormattedTextField102FocusLost(FocusEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jFormattedTextField102ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void materialButton40ActionPerformed(ActionEvent evt) {
/*       */     try {
/*  6579 */       this.con.consultar("factImpresa", "guias", "where num_guia = '" + this.jTextField1.getText() + "'");
/*  6580 */       String FAC = this.con.Campo;
/*  6581 */       if (((String)this.CAMPOSGENERALES.get("complementoTraslado")).equals("ACTIVADO")) {
/*  6582 */         if (this.jTextField5.getText().equals("FMF901004UZ9")) {
/*  6583 */           verDatos2(this.jTextField1.getText());
/*  6584 */           verDatos3(this.jTextField1.getText());
/*  6585 */           verDatos4(this.jTextField1.getText());
/*  6586 */           timbrarComprobanteTraslado();
/*       */         
/*       */         }
/*       */         else {
/*       */ 
/*       */           
/*  6592 */           timbrarFacturaCartaPorte timbrarFacturaCartaPorte = new timbrarFacturaCartaPorte(FAC, this.jTextField1.getText(), this.CAMPOSGENERALES, this.CAMPOSGENERALES.get("rutaCompTraslado"));
/*       */         } 
/*       */       } else {
/*       */         
/*  6596 */         verDatos3(this.jLabel54.getText());
/*  6597 */         timbrarGuia(this.jLabel54.getText());
/*       */       } 
/*  6599 */     } catch (IOException ex) {
/*  6600 */       Logger.getLogger(GuiasForm.class.getName()).log(Level.SEVERE, (String)null, ex);
/*       */     } 
/*  6602 */     JOptionPane.showMessageDialog(this.jDialog2, "El comprobante de traslado se ha generado correctamente.", "Comprobante generado", 0, this.INFO);
/*  6603 */     this.jDialog9.setVisible(false);
/*       */   }
/*       */   
/*       */   private void materialButton41ActionPerformed(ActionEvent evt) {
/*  6607 */     String dir = direccion();
/*  6608 */     System.out.println(dir);
/*  6609 */     this.RUTA = dir;
/*  6610 */     this.con.consultar("factImpresa", "guias", "where num_guia = '" + this.jTextField1.getText() + "'");
/*  6611 */     String FAC = this.con.Campo;
/*       */     try {
/*  6613 */       if (((String)this.CAMPOSGENERALES.get("complementoTraslado")).equals("ACTIVADO")) {
/*  6614 */         if (this.jTextField5.getText().equals("FMF901004UZ9")) {
/*  6615 */           verDatos2(this.jTextField1.getText());
/*  6616 */           verDatos3(this.jTextField1.getText());
/*  6617 */           verDatos4(this.jTextField1.getText());
/*  6618 */           timbrarComprobanteTraslado();
/*       */         }
/*       */         else {
/*       */           
/*  6622 */           timbrarFacturaCartaPorte timbrarFacturaCartaPorte = new timbrarFacturaCartaPorte(FAC, this.jTextField1.getText(), this.CAMPOSGENERALES, this.RUTA);
/*       */         }
/*       */       
/*       */       }
/*       */       else {
/*       */         
/*  6628 */         verDatos3(this.jLabel54.getText());
/*  6629 */         timbrarGuia(this.jLabel54.getText());
/*       */       } 
/*  6631 */     } catch (IOException ex) {
/*  6632 */       Logger.getLogger(GuiasForm.class.getName()).log(Level.SEVERE, (String)null, ex);
/*       */     } 
/*  6634 */     JOptionPane.showMessageDialog(this.jDialog2, "El comprobante de traslado se ha generado correctamente.", "Comprobante generado", 0, this.INFO);
/*  6635 */     this.jDialog9.setVisible(false);
/*  6636 */     this.RUTA = this.RUTATEMP;
/*       */   }
/*       */ 
/*       */   
/*       */   private void jComboBox4ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jButton107ActionPerformed(ActionEvent evt) {
/*  6644 */     consultarManifiestos();
/*  6645 */     Dimension di = this.jButton100.getSize();
/*  6646 */     Point p = this.jButton107.getLocationOnScreen();
/*  6647 */     this.jDialog10.setLocation(p.x - 500, p.y - 10);
/*  6648 */     this.jDialog10.setVisible(true);
/*       */   }
/*       */   
/*       */   private void rSTableMetro7MouseClicked(MouseEvent evt) {
/*  6652 */     if (evt.getClickCount() > 1) {
/*  6653 */       this.TIPOMANIFIESTO = this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 2).toString();
/*  6654 */       this.jEditorPane100.setText(this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 1).toString());
/*  6655 */       this.jDialog10.setVisible(false);
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   private void rSTableMetro7KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jButton64ActionPerformed(ActionEvent evt) {
/*  6664 */     this.jTextField43.setText("");
/*  6665 */     this.materialButton11.setText("Agregar");
/*  6666 */     this.materialButton11.setMnemonic('A');
/*  6667 */     this.materialButton11.setToolTipText("Agregar (Alt+A)");
/*  6668 */     this.jDialog11.setTitle("Agregar");
/*  6669 */     this.jDialog11.setVisible(true);
/*       */   }
/*       */   
/*       */   private void jButton65ActionPerformed(ActionEvent evt) {
/*  6673 */     int ind = this.rSTableMetro7.getSelectedRow();
/*  6674 */     if (ind < 0) {
/*  6675 */       JOptionPane.showMessageDialog(this.jDialog10, "Necesitas seleccionar un registro para poder modificarlo", "Selecciona un registro", 0, this.ADVER);
/*       */     } else {
/*  6677 */       this.materialButton11.setText("Modificar");
/*  6678 */       this.materialButton11.setMnemonic('M');
/*  6679 */       this.materialButton11.setToolTipText("Modificar tipo (Alt+M)");
/*  6680 */       this.jTextField43.setText(this.rSTableMetro7.getValueAt(ind, 1).toString());
/*  6681 */       this.jDialog11.setVisible(true);
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   private void jButton66ActionPerformed(ActionEvent evt) {
/*  6687 */     int ind = this.rSTableMetro7.getSelectedRow();
/*  6688 */     if (ind < 0) {
/*  6689 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas seleccionar un registro para poder eliminarlo", "Selecciona el dato a eliminar", 0, this.ADVER);
/*       */     } else {
/*  6691 */       int res = JOptionPane.showConfirmDialog(this.jDialog10, "¿Estás seguro que deseas eleiminar la información que seleccionaste?", "Eliminar...", 0, 3, this.PREG);
/*  6692 */       if (res == 0) {
/*  6693 */         this.con2.eliminar("tras_manifiestos", "where num=" + String.valueOf(this.rSTableMetro7.getValueAt(ind, 0)));
/*  6694 */         this.utilerias.eliminarRegTabla((JTable)this.rSTableMetro7, ind);
/*       */       } 
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   private void jTextField83ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jTextField83KeyReleased(KeyEvent evt) {
/*  6704 */     consultarManifiestos();
/*       */   }
/*       */ 
/*       */   
/*       */   private void jTextField43ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void materialButton10ActionPerformed(ActionEvent evt) {
/*  6712 */     this.jDialog11.setVisible(false);
/*       */   }
/*       */   
/*       */   private void materialButton11ActionPerformed(ActionEvent evt) {
/*  6716 */     guardarManifiestos();
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jFormattedTextField103FocusGained(FocusEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jFormattedTextField103FocusLost(FocusEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jFormattedTextField103ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jLabel132MouseClicked(MouseEvent evt) {
/*  6732 */     verDatos2(this.ID);
/*  6733 */     verDatos3(this.ID);
/*  6734 */     verDatos4(this.ID);
/*  6735 */     Map<String, String> DATOS = new LinkedHashMap<>();
/*  6736 */     DATOS.put("GUÍA", this.jTextField1.getText());
/*  6737 */     DATOS.put("FOLIO IMPRESO", this.jTextField2.getText());
/*  6738 */     DATOS.put("FECHA", this.utilerias.convertirFechaDateStringBarras(this.jDateChooser1.getDate()));
/*  6739 */     DATOS.put("CLIENTE", this.jComboBox1.getSelectedItem().toString());
/*  6740 */     DATOS.put("DOMICILIO", this.jTextField3.getText() + " " + this.jTextField3.getText());
/*  6741 */     DATOS.put("RFC CLIENTE", this.jTextField5.getText());
/*  6742 */     DATOS.put("PERMISO SCT", this.jComboBox4.getSelectedItem().toString());
/*  6743 */     DATOS.put("TIPO DE SERVICIO", this.jComboBox2.getSelectedItem().toString());
/*  6744 */     DATOS.put("OPERADOR", this.jComboBox3.getSelectedItem().toString());
/*  6745 */     DATOS.put("RFC OP", this.jTextField6.getText());
/*  6746 */     DATOS.put("LICENCIA", this.jTextField7.getText());
/*  6747 */     DATOS.put("DIRECCIÓN", this.jTextField8.getText()); int i;
/*  6748 */     for (i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/*  6749 */       DATOS.put(this.rSTableMetro1
/*  6750 */           .getValueAt(i, 0).toString(), this.rSTableMetro1
/*  6751 */           .getValueAt(i, 3).toString() + ", " + this.rSTableMetro1.getValueAt(i, 3).toString() + ", " + this.rSTableMetro1
/*  6752 */           .getValueAt(i, 4).toString() + ", " + this.rSTableMetro1
/*  6753 */           .getValueAt(i, 5).toString() + ", " + this.rSTableMetro1
/*  6754 */           .getValueAt(i, 6).toString() + ", " + this.rSTableMetro1
/*  6755 */           .getValueAt(i, 7).toString() + ", " + this.rSTableMetro1
/*  6756 */           .getValueAt(i, 8).toString() + ", " + this.rSTableMetro1
/*  6757 */           .getValueAt(i, 9).toString());
/*       */     }
/*       */ 
/*       */     
/*  6761 */     DATOS.put("KM TOTALES", this.jTextField10.getText());
/*  6762 */     if (this.jCheckBox1.isSelected()) {
/*  6763 */       DATOS.put("EQUIPO ", this.jTextField11.getText());
/*  6764 */       DATOS.put("PLATAFORMA ", this.jTextField12.getText());
/*  6765 */       DATOS.put("POZO ", this.jTextField13.getText());
/*       */     } 
/*       */     
/*  6768 */     for (i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/*  6769 */       DATOS.put("MERCANCÍA ", this.rSTableMetro2
/*       */           
/*  6771 */           .getValueAt(i, 1).toString() + ", " + this.rSTableMetro2.getValueAt(i, 1).toString() + ", " + this.rSTableMetro2
/*  6772 */           .getValueAt(i, 2).toString() + ", " + this.rSTableMetro2
/*  6773 */           .getValueAt(i, 3).toString() + ", " + this.rSTableMetro2
/*  6774 */           .getValueAt(i, 4).toString() + ", " + this.rSTableMetro2
/*  6775 */           .getValueAt(i, 5).toString() + ", " + this.rSTableMetro2
/*  6776 */           .getValueAt(i, 6).toString() + ", " + this.rSTableMetro2
/*  6777 */           .getValueAt(i, 7).toString() + ", ");
/*       */     }
/*       */ 
/*       */     
/*  6781 */     DATOS.put("UNIDADES ", "ECO " + this.jTextField21.getText() + ", REM1 " + this.jTextField26.getText() + ", REM2 " + this.jTextField31.getText() + ", DOLLY " + this.jTextField36.getText());
/*  6782 */     DATOS.put("TIPO DE EQUIPO ", this.jComboBox22.getSelectedItem().toString());
/*       */     
/*  6784 */     DATOS.put("VALE DE LIQ ", this.jTextField50.getText());
/*  6785 */     DATOS.put("TICKETS ", this.jTextField51.getText());
/*  6786 */     DATOS.put("MANIFIESTO ", this.jTextField52.getText());
/*  6787 */     DATOS.put("ACTIVA/BAJA", this.jComboBox50.getSelectedItem().toString());
/*  6788 */     DATOS.put("ESTATUS ", this.jTextField53.getText());
/*  6789 */     DATOS.put("PEDIDO ", this.jTextField54.getText());
/*  6790 */     DATOS.put("REPORTE INTERNO ", this.jTextField55.getText());
/*  6791 */     DATOS.put("PREFACTURA ", this.jTextField56.getText());
/*  6792 */     DATOS.put("FACTURA ", this.jTextField57.getText());
/*  6793 */     DATOS.put("AUTORIZÓ ", this.jTextField58.getText());
/*  6794 */     DATOS.put("COMENTARIOS ", this.jEditorPane1.getText());
/*       */     
/*  6796 */     CopiarContenidoGuia guia = new CopiarContenidoGuia(DATOS);
/*  6797 */     JOptionPane.showMessageDialog(this, "¡Los datos han sido copiados!", "Guia " + this.jTextField1.getText(), 0, this.INFO);
/*       */   }
/*       */   
/*       */   private void jLabel132MouseEntered(MouseEvent evt) {
/*  6801 */     this.jLabel132.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/copy.png")));
/*       */   }
/*       */   
/*       */   private void jLabel132MouseExited(MouseEvent evt) {
/*  6805 */     this.jLabel132.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/copy(1).png")));
/*       */   }
/*       */ 
/*       */   
/*       */   private void jTextField4ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   public void consultarManifiestos() {
/*  6813 */     String carga = "";
/*  6814 */     if (!this.jTextField83.getText().equals(this.holderBuscarManfiesto)) {
/*  6815 */       carga = this.jTextField83.getText();
/*       */     }
/*  6817 */     this.utilerias.consultaGralTabla(this.con2, (JTable)this.rSTableMetro7, new String[] { "Núm", "Carga | Residuo", "Tipo" }, "num, carga, tipo", "tras_manifiestos", "where carga like '%" + carga + "%' order by tipo, carga");
/*       */ 
/*       */     
/*  6820 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro7, 0, 50);
/*  6821 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro7, 2, 100);
/*  6822 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro7);
/*       */   }
/*       */   
/*       */   public String direccion() {
/*  6826 */     JFileChooser fileChooser = new JFileChooser();
/*  6827 */     fileChooser.setFileSelectionMode(1);
/*  6828 */     String fileName = "";
/*  6829 */     int retVal = fileChooser.showSaveDialog(null);
/*  6830 */     if (retVal == 0) {
/*  6831 */       fileName = fileChooser.getSelectedFile().getAbsolutePath();
/*  6832 */       return fileName;
/*       */     } 
/*  6834 */     return "no";
/*       */   }
/*       */   
/*       */   public void timbrarGuia(String GUIA) throws IOException {
/*  6838 */     String[] fact = GUIA.split("-");
/*  6839 */     String folio = "T" + fact[0] + fact[1];
/*  6840 */     BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.RUTA + "/" + this.RUTA + ".yaml"), "utf-8"));
/*  6841 */     out.write("\n");
/*  6842 */     out.write("#Archivo propiedad de Fletes y Materiales Forsis, SA de CV\n");
/*  6843 */     out.write("#Desarrollador T.I. Uzziel Contreras Portilla - kofuz01@gmail.com\n");
/*  6844 */     out.write("#Este formato es compatible con YAML (http://www.yaml.org/spec/1.2/spec.html). \n");
/*  6845 */     out.write("\n");
/*  6846 */     out.write("--- !diverza.com/v2.0\n\n");
/*  6847 */     out.write("#DATOS GENERALES\n");
/*  6848 */     out.write("Comprobante:\n\n");
/*  6849 */     out.write("  NombreCfdi: \"" + folio + "\"\n");
/*  6850 */     out.write("  RefId: \"" + folio + "\"\n");
/*  6851 */     out.write("  Version: \"3.3\"\n");
/*  6852 */     out.write("  Serie: \"T" + fact[0] + "\"\n");
/*  6853 */     out.write("  Folio: \"" + fact[1] + "\"\n");
/*       */ 
/*       */     
/*  6856 */     DateFormat hr = new SimpleDateFormat("HH:mm:ss");
/*  6857 */     String hora = hr.format(new Date());
/*  6858 */     String[] horario = hora.split(":");
/*  6859 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  6860 */     String cadenaFecha = "";
/*  6861 */     cadenaFecha = formato.format(this.jDateChooser1.getDate());
/*       */ 
/*       */ 
/*       */     
/*  6865 */     String año = cadenaFecha.substring(0, 4);
/*  6866 */     String mes = cadenaFecha.substring(4, 6);
/*  6867 */     String dia = cadenaFecha.substring(6, 8);
/*  6868 */     String hh = horario[0];
/*  6869 */     String mm = horario[1];
/*  6870 */     String ss = horario[2];
/*       */     
/*  6872 */     out.write("  Fecha: \"" + año + "-" + mes + "-" + dia + "T" + hh + ":" + mm + ":" + ss + "\"\n");
/*  6873 */     out.write("  Sello: \"\"\n");
/*  6874 */     out.write("  NoCertificado: \"" + this.CERTIFICADO + "\"\n");
/*  6875 */     out.write("  Certificado: \"\"\n");
/*  6876 */     out.write("  SubTotal: \"0\"\n");
/*  6877 */     out.write("  Moneda: \"MXN\"\n");
/*  6878 */     out.write("  TipoCambio: \"1\"\n");
/*  6879 */     out.write("  Total: \"0\"\n");
/*  6880 */     out.write("  TipoDeComprobante: \"T\"\n");
/*  6881 */     out.write("  LugarExpedicion: \"" + this.CODIGOPOSTAL + "\"\n\n");
/*  6882 */     out.write("\n");
/*  6883 */     out.write("  Emisor:\n");
/*  6884 */     out.write("    Rfc: \"FMF901004UZ9\"\n");
/*  6885 */     out.write("    Nombre: \"FLETES Y MATERIALES FORSIS, S.A. DE C.V.\"\n");
/*  6886 */     out.write("    RegimenFiscal: \"624\"\n\n");
/*       */     
/*  6888 */     out.write("  Receptor: \n");
/*  6889 */     out.write("    Rfc: \"XAXX010101000\"\n");
/*  6890 */     out.write("    UsoCFDI: \"P01\"\n\n");
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  6896 */     out.write("  Conceptos: \n");
/*  6897 */     for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/*  6898 */       out.write("    -\n");
/*  6899 */       out.write("      Concepto: \"\"\n");
/*  6900 */       out.write("      ClaveProdServ: \"" + ((Mercancias)this.MERCANCIAS.get(i)).getClaveProd() + "\"\n");
/*  6901 */       out.write("      NoIdentificacion: \"" + ((Mercancias)this.MERCANCIAS.get(i)).getClaveUnidad() + "\"\n");
/*  6902 */       out.write("      Cantidad: \"" + String.valueOf(this.rSTableMetro2.getValueAt(i, 0)) + "\"\n");
/*  6903 */       out.write("      ClaveUnidad: \"" + ((Mercancias)this.MERCANCIAS.get(i)).getClaveUnidad() + "\"\n");
/*  6904 */       out.write("      Unidad: \"" + String.valueOf(this.jComboBox2.getSelectedItem()) + "\"\n");
/*  6905 */       out.write("      Descripcion: \"" + ((Mercancias)this.MERCANCIAS.get(i)).getDescInterna() + " - " + ((Mercancias)this.MERCANCIAS.get(i)).getClaveProdDesc() + "\"\n");
/*  6906 */       out.write("      ValorUnitario: \"0\"\n");
/*  6907 */       out.write("      Importe: \"0\"\n");
/*       */     } 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  6920 */     out.write("\n");
/*  6921 */     out.write("  Addenda: \n");
/*  6922 */     out.write("    Diverza: \n");
/*  6923 */     out.write("      Version: \"1.1\"\n\n");
/*  6924 */     out.write("      Generales: \n");
/*       */     
/*  6926 */     out.write("      DatosContactoE: \n");
/*  6927 */     out.write("        Telefono: \"01 (229) 924-8600 al 03\"\n");
/*  6928 */     out.write("        Web: \"www.forsis.com.mx\"\n\n");
/*       */     
/*  6930 */     out.write("      Emisor: \n");
/*  6931 */     out.write("        DomicilioFiscalE: \n");
/*  6932 */     out.write("          Calle: \"AUTOPISTA CADEREYTA - MONTERREY\"\n");
/*  6933 */     out.write("          Numero: \"KM 32.5\"\n");
/*  6934 */     out.write("          Ciudad: \"CADEREYTA JIMENEZ\"\n");
/*  6935 */     out.write("          Municipio: \"CADEREYTA JIMENEZ\"\n");
/*  6936 */     out.write("          Estado: \"NUEVO LEON\"\n");
/*  6937 */     out.write("          Pais: \"MEXICO\"\n");
/*  6938 */     out.write("          CodigoPostal: \"67483\"\n");
/*  6939 */     out.write("        SucursalE: \n");
/*  6940 */     out.write("          Alias: \"" + this.SUCURSAL + "\"\n");
/*  6941 */     out.write("          DomicilioSucursal: \n");
/*  6942 */     out.write("            Calle: \"CARRETERA A CARDEL (NUEVA ERA) KM 5\"\n");
/*  6943 */     out.write("            Ciudad: \"VERACRUZ\"\n");
/*  6944 */     out.write("            Estado: \"VERACRUZ\"\n");
/*  6945 */     out.write("            Pais: \"MÉXICO\"\n");
/*  6946 */     out.write("            CodigoPostal: \"91809\"\n\n");
/*       */     
/*  6948 */     out.write("  LeyendasImpresion: \n");
/*  6949 */     out.write("    -\n");
/*  6950 */     out.write("      Atributo: \"SEMARNAT\"\n");
/*  6951 */     out.write("      Valor: \"PERMISO SEMARNAT 19-I-036D-10, PERMISO SCT CG20045\"\n");
/*       */     
/*  6953 */     out.write("      Atributo: \"IMPUESTO RETENIDO\"\n");
/*  6954 */     out.write("      Valor: \"IMPUESTO RETENIDO DE CONFORMIDAD CON LA LEY DEL IMPUESTO AL VALOR AGREGADO\"\n");
/*       */     
/*  6956 */     out.write("      Atributo: \"DEBEMOS\"\n");
/*  6957 */     out.write("      Valor: \"DEBO(MOS) Y PAGARE(MOS) INCONDICIONALMENTE EN ESTA CIUDAD A LA ORDEN DE FLETES Y MATERIALES FORSIS, S.A. DE C.V. LA CANTIDAD QUE SE INDICA COMO TOTAL EN ESTE DOCUMENTO, VALOR DEL SERCIVIO ARRIBA DESCRITO Y QUE HEMOS RECIBIDO DE CONFORMIDAD, SI ESTA CANTIDAD NO FUERE CUBIERTA A LA PRESENTACION DE ESTE PAGARE, CAUSARA INTERESES MORATORIOS A RAZON DE % ANUAL HASTA SU TOTAL SOLUCION\"\n");
/*  6958 */     out.write("---");
/*  6959 */     out.close();
/*       */   }
/*       */   
/*       */   public void actualizarTablaMercanciasDestinos() {
/*  6963 */     int reg = this.rSTableMetro1.getRowCount();
/*  6964 */     if (reg == 2) {
/*  6965 */       for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/*  6966 */         this.rSTableMetro2.setValueAt(this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("ORIGEN")).map(c -> c.getId()).toArray()[0].toString(), i, 9);
/*  6967 */         this.rSTableMetro2.setValueAt(this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getId()).toArray()[0].toString(), i, 10);
/*  6968 */         ((Mercancias)this.MERCANCIAS.get(i)).setOrigen(this.rSTableMetro2.getValueAt(i, 9).toString());
/*  6969 */         ((Mercancias)this.MERCANCIAS.get(i)).setDestino(this.rSTableMetro2.getValueAt(i, 10).toString());
/*       */       } 
/*       */     } else {
/*  6972 */       for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/*  6973 */         this.rSTableMetro2.setValueAt("", i, 9);
/*  6974 */         this.rSTableMetro2.setValueAt("", i, 10);
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   public void privilegios() {
/*  6980 */     if (this.SUPERUSUARIOS.contains(this.CAMPOSGENERALES.get("usuario"))) {
/*  6981 */       this.jTextField51.setEnabled(true);
/*  6982 */       this.jTextField53.setEnabled(true);
/*  6983 */       this.jTextField55.setEnabled(true);
/*  6984 */       this.jTextField56.setEnabled(true);
/*  6985 */       this.jTextField57.setEnabled(true);
/*  6986 */       this.jComboBox50.setEnabled(true);
/*  6987 */       if (!this.USUARIO.equals("KOFUZ01")) {
/*  6988 */         this.jTextField53.setEnabled(false);
/*  6989 */         this.jComboBox50.setEnabled(false);
/*  6990 */         this.jTextField57.setEnabled(false);
/*       */       }
/*       */     
/*  6993 */     } else if (((String)this.CAMPOSGENERALES.get("complementoTraslado")).equals("ACTIVADO") && 
/*  6994 */       !this.jTextField53.getText().equals("<Por Timbrar>")) {
/*  6995 */       desabilitar();
/*  6996 */       activarGuiaTimbrada();
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   public static int restarFechas(Date fechaInicial, Date fechaFinal) {
/*  7002 */     DateFormat df = DateFormat.getDateInstance(2);
/*  7003 */     String fechaInicioString = df.format(fechaInicial);
/*       */     try {
/*  7005 */       fechaInicial = df.parse(fechaInicioString);
/*  7006 */     } catch (ParseException parseException) {}
/*       */     
/*  7008 */     String fechaFinalString = df.format(fechaFinal);
/*       */     try {
/*  7010 */       fechaFinal = df.parse(fechaFinalString);
/*  7011 */     } catch (ParseException parseException) {}
/*       */     
/*  7013 */     long fechaInicialMs = fechaInicial.getTime();
/*  7014 */     long fechaFinalMs = fechaFinal.getTime();
/*  7015 */     long diferencia = fechaFinalMs - fechaInicialMs;
/*  7016 */     double dias = Math.floor((diferencia / 86400000L));
/*  7017 */     return (int)dias;
/*       */   }
/*       */   
/*       */   public void activarModificacion() {
/*  7021 */     this.actualizado = true;
/*  7022 */     setVisible(false);
/*       */   }
/*       */   
/*       */   public void insertarTrasUbic() {
/*  7026 */     String consulta = "";
/*  7027 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  7035 */       consulta = consulta + "('" + consulta + "','" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getClave_gene_desti() + "', '" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getTipo() + "', '" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getTipoEst() + "', '" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getTipoEstDesc() + "', '" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getId() + "', '" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getRfc() + "', '" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getNombre() + "', '" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getCp() + "', '" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getCalle() + "', '" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getNum() + "', '" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getCol() + "', '" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getCiudad() + "', '" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getEstado() + "', '" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getPais() + "', '" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getC_colonia() + "', '" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getC_municipio() + "', '" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getC_estado() + "', '" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getDistancia() + "', '" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getFechaHora() + "', '" + this.jTextField1.getText() + "', '" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getMonto() + "', '" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getLetra() + "','" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(i)).getC_localidad() + "')";
/*       */       
/*  7037 */       if (i + 1 != this.rSTableMetro1.getRowCount()) {
/*  7038 */         consulta = consulta + ",";
/*       */       }
/*       */     } 
/*  7041 */     this.con.inserSinMsj("insert into tras_cartaporte_ubic ( clave_gene_desti, tipo_ubic, tipoEstacion, tipoEstacionDesc, id, rfc, nombre, cp, calle, num, col, ciudad, estado, pais, c_colonia, c_municipio, c_estado, distancia, fechaHora, guia, monto, letra, c_localidad, localidad) values " + consulta);
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public void insertarTrasMercancias() {
/*  7053 */     String consulta = "";
/*  7054 */     for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  7064 */       consulta = consulta + "('" + consulta + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getCantidad() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getClaveUnidad() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getClaveUnidadDesc() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getClaveSTCC() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getClaveSTCCDesc() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getClaveProd() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getClaveProdDesc() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getDescInterna() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getDimensiones() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getPeso() + "','" + ((Mercancias)this.MERCANCIAS.get(i)).getPesoBruto() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getValor() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getOrigen() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getDestino() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getMoneda() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getMatPeligroso() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getClaveMatPeligroso() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getClaveMatPeligrosoDesc() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getClaveEmbalaje() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getClaveEmbalajeDesc() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getArancel() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getClaveAranceles() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getClaveArancelesDesc() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getUUID() + "', '" + ((Mercancias)this.MERCANCIAS.get(i)).getCantidad() + "')";
/*       */       
/*  7066 */       if (i + 1 != this.rSTableMetro2.getRowCount()) {
/*  7067 */         consulta = consulta + ",";
/*       */       }
/*       */     } 
/*  7070 */     this.con.inserSinMsj("insert into tras_cartaporte_mercancias (cant, claveUnidadSat, claveUnidadSatDesc, claveSTCC, claveSTCCDesc, claveProdSat, claveProdSatDesc, descripcionInterna, dimensiones, peso, pesoBruto, valor, origen, destino, moneda, materialPeligroso, claveMaterialPeligroso, descMaterialPeligroso, embalajeClave, embalajeDesc, fraccionArancelaria, fraccionArancelClave, fraccionArancelClaveDesc, uuid, cantTransportada, guia) values " + consulta);
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public void timbrarComprobanteTraslado() throws IOException {
/*  7085 */     boolean peligroso = false;
/*  7086 */     int selec = this.jComboBox3.getSelectedIndex();
/*  7087 */     for (int i = 0; i < this.VEROPERADOR.length; i++) {
/*  7088 */       System.out.println("" + i + " " + i);
/*       */     }
/*       */     
/*  7091 */     String[] fact = this.jTextField1.getText().split("-");
/*  7092 */     String folio = "T" + fact[0] + fact[1];
/*  7093 */     BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.RUTA + "/" + this.RUTA + ".yaml"), "utf-8"));
/*  7094 */     out.write("\n");
/*  7095 */     out.write("#Archivo propiedad de Fletes y Materiales Forsis, SA de CV\n");
/*  7096 */     out.write("#Desarrollador T.I. Uzziel Contreras Portilla - kofuz01@gmail.com\n");
/*  7097 */     out.write("#Este formato es compatible con YAML (http://www.yaml.org/spec/1.2/spec.html). \n");
/*  7098 */     out.write("#Vesion 1.230719\n");
/*  7099 */     out.write("\n");
/*  7100 */     out.write("--- !diverza.com/v2.0\n\n");
/*  7101 */     out.write("#DATOS GENERALES\n");
/*  7102 */     out.write("Comprobante:\n\n");
/*  7103 */     out.write("  NombreCfdi: \"" + folio + "\"\n");
/*  7104 */     out.write("  RefId: \"" + folio + "\"\n");
/*  7105 */     out.write("  Version: \"4.0\"\n");
/*  7106 */     out.write("  Serie: \"T" + fact[0] + "\"\n");
/*  7107 */     out.write("  Folio: \"" + fact[1] + "\"\n");
/*       */     
/*  7109 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  7110 */     String fecha = formato.format(this.jDateChooser1.getDate());
/*  7111 */     DateFormat hr = new SimpleDateFormat("HH:mm:ss");
/*  7112 */     String hora = hr.format(new Date());
/*  7113 */     String[] horario = hora.split(":");
/*  7114 */     String año = fecha.substring(0, 4);
/*  7115 */     String mes = fecha.substring(4, 6);
/*  7116 */     String dia = fecha.substring(6, 8);
/*       */     
/*  7118 */     String hh = horario[0];
/*  7119 */     String mm = horario[1];
/*  7120 */     String ss = horario[2];
/*  7121 */     out.write("  Fecha: \"" + año + "-" + mes + "-" + dia + "T" + hh + ":" + mm + ":" + ss + "\"\n");
/*  7122 */     out.write("  Sello: \"\"\n");
/*  7123 */     out.write("  NoCertificado: \"" + this.CERTIFICADO + "\"\n");
/*  7124 */     out.write("  Certificado: \"\"\n");
/*  7125 */     out.write("  SubTotal: \"0\"\n");
/*  7126 */     out.write("  Exportacion: \"01\"\n");
/*  7127 */     out.write("  Moneda: \"XXX\"\n");
/*  7128 */     out.write("  Total: \"0\"\n");
/*  7129 */     out.write("  TipoDeComprobante: \"T\"\n");
/*  7130 */     out.write("  LugarExpedicion: \"" + this.CODIGOPOSTAL + "\"\n\n");
/*       */     
/*  7132 */     out.write("\n");
/*  7133 */     out.write("  Emisor:\n");
/*  7134 */     out.write("    Rfc: \"FMF901004UZ9\"\n");
/*  7135 */     out.write("    Nombre: \"FLETES Y MATERIALES FORSIS\"\n");
/*  7136 */     out.write("    RegimenFiscal: \"624\"\n\n");
/*       */     
/*  7138 */     out.write("  Receptor: \n");
/*  7139 */     out.write("    Nombre: \"FLETES Y MATERIALES FORSIS\"\n");
/*  7140 */     out.write("    Rfc: \"FMF901004UZ9\"\n");
/*  7141 */     out.write("    RegimenFiscalReceptor: \"624\"\n");
/*  7142 */     out.write("    UsoCFDI: \"S01\"\n\n");
/*       */     
/*  7144 */     out.write("  Conceptos: \n");
/*  7145 */     out.write("    Concepto: \n");
/*  7146 */     out.write("      -\n");
/*       */     
/*  7148 */     out.write("        ClaveProdServ: \"78101802\"\n");
/*       */     
/*  7150 */     out.write("        Cantidad: \"1\"\n");
/*  7151 */     out.write("        ClaveUnidad: \"E48\"\n");
/*  7152 */     out.write("        Unidad: \"UNIDAD DE SERVICIO\"\n");
/*  7153 */     out.write("        Descripcion: \" SERVICIOS TRANSPORTE DE CARGA POR CARRETERA (EN CAMIÓN) A NIVEL REGIONAL Y NACIONAL  \"\n");
/*  7154 */     out.write("        ValorUnitario: \"0\"\n");
/*  7155 */     out.write("        ObjetoImp: \"01\"\n");
/*  7156 */     out.write("        Importe: \"0\"\n\n");
/*       */     
/*  7158 */     out.write("  Complemento: \n");
/*  7159 */     out.write("    CartaPorte: \n");
/*  7160 */     out.write("      Version: \"3.1\"\n");
/*  7161 */     out.write("      TranspInternac: \"No\"\n");
/*  7162 */     out.write("      TotalDistRec: \"" + this.jTextField10.getText() + "\"\n");
/*  7163 */     out.write("      Ubicaciones: \n");
/*  7164 */     out.write("        Ubicacion: \n"); int j;
/*  7165 */     for (j = 0; j < this.rSTableMetro1.getRowCount(); j++) {
/*  7166 */       out.write("          -\n");
/*  7167 */       if (this.rSTableMetro1.getValueAt(j, 0).toString().equals("ORIGEN")) {
/*  7168 */         out.write("            TipoUbicacion: \"Origen\"\n");
/*       */       } else {
/*  7170 */         out.write("            TipoUbicacion: \"Destino\"\n");
/*       */       } 
/*  7172 */       out.write("            IDUbicacion: \"" + this.rSTableMetro1.getValueAt(j, 2).toString() + "\"\n");
/*  7173 */       out.write("            RFCRemitenteDestinatario: \"" + this.rSTableMetro1.getValueAt(j, 4).toString() + "\"\n");
/*  7174 */       out.write("            NombreRemitenteDestinatario: \"" + this.rSTableMetro1.getValueAt(j, 3).toString() + "\"\n");
/*  7175 */       out.write("            FechaHoraSalidaLlegada: \"" + this.utilerias.convertirFechaCFDI(this.rSTableMetro1.getValueAt(j, 11).toString()) + "\"\n");
/*  7176 */       if (this.rSTableMetro1.getValueAt(j, 0).toString().equals("DESTINO")) {
/*  7177 */         out.write("            DistanciaRecorrida: \"" + this.rSTableMetro1.getValueAt(j, 10).toString() + "\"\n");
/*       */       }
/*  7179 */       out.write("            Domicilio:\n");
/*  7180 */       out.write("              Calle: \"" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(j)).getCalle() + "\"\n");
/*  7181 */       out.write("              NumeroExterior: \"" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(j)).getNum() + "\"\n");
/*  7182 */       out.write("              Colonia: \"" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(j)).getC_colonia() + "\"\n");
/*  7183 */       out.write("              Referencia: \"Col: " + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(j)).getCol() + ", Municipio: " + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(j)).getCiudad() + "\"\n");
/*  7184 */       out.write("              Municipio: \"" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(j)).getC_municipio() + "\"\n");
/*  7185 */       out.write("              Estado: \"" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(j)).getC_estado() + "\"\n");
/*  7186 */       out.write("              Pais: \"MEX\"\n");
/*  7187 */       out.write("              CodigoPostal: \"" + ((OrigenesDestinos)this.ORIGENESDESTINOS.get(j)).getCp() + "\"\n");
/*       */     } 
/*       */     
/*  7190 */     out.write("      Mercancias:\n");
/*  7191 */     out.write("        PesoBrutoTotal: \"" + this.pesoNeto + "\"\n");
/*  7192 */     out.write("        UnidadPeso: \"KGM\"\n");
/*  7193 */     out.write("        PesoNetoTotal: \"" + this.pesoNeto + "\"\n");
/*  7194 */     out.write("        NumTotalMercancias: \"" + this.MERCANCIAS.size() + "\"\n");
/*  7195 */     out.write("        Mercancia:\n");
/*  7196 */     for (j = 0; j < this.MERCANCIAS.size(); j++) {
/*  7197 */       out.write("          -\n");
/*  7198 */       out.write("            BienesTransp: \"" + ((Mercancias)this.MERCANCIAS.get(j)).getClaveProd() + "\"\n");
/*  7199 */       out.write("            ClaveSTCC: \"" + ((Mercancias)this.MERCANCIAS.get(j)).getClaveSTCC() + "\"\n");
/*  7200 */       out.write("            Descripcion: \"" + ((Mercancias)this.MERCANCIAS.get(j)).getDescInterna() + "\"\n");
/*  7201 */       out.write("            Cantidad: \"" + ((Mercancias)this.MERCANCIAS.get(j)).getCantidad() + "\"\n");
/*  7202 */       out.write("            ClaveUnidad: \"" + ((Mercancias)this.MERCANCIAS.get(j)).getClaveUnidad() + "\"\n");
/*  7203 */       if (((Mercancias)this.MERCANCIAS.get(j)).getClaveUnidadDesc().length() > 19) {
/*  7204 */         out.write("            Unidad: \"" + ((Mercancias)this.MERCANCIAS.get(j)).getClaveUnidadDesc().substring(0, 19) + "\"\n");
/*       */       } else {
/*  7206 */         out.write("            Unidad: \"" + ((Mercancias)this.MERCANCIAS.get(j)).getClaveUnidadDesc() + "\"\n");
/*       */       } 
/*       */       
/*  7209 */       if (((Mercancias)this.MERCANCIAS.get(j)).getMatPeligroso().equals("SI")) {
/*  7210 */         peligroso = true;
/*  7211 */         out.write("            MaterialPeligroso: \"Si\"\n");
/*  7212 */         out.write("            CveMaterialPeligroso: \"" + ((Mercancias)this.MERCANCIAS.get(j)).getClaveMatPeligroso() + "\"\n");
/*  7213 */         out.write("            Embalaje: \"" + ((Mercancias)this.MERCANCIAS.get(j)).getClaveEmbalaje() + "\"\n");
/*  7214 */         out.write("            DescripEmbalaje: \"" + ((Mercancias)this.MERCANCIAS.get(j)).getClaveEmbalajeDesc() + "\"\n");
/*       */       } else {
/*  7216 */         this.con2.consultar("matPeligroso", "tras_productos", "where clave = '" + ((Mercancias)this.MERCANCIAS.get(j)).getClaveProd() + "'");
/*  7217 */         if (this.con2.dameCampo().equals("0,1")) {
/*  7218 */           out.write("            MaterialPeligroso: \"No\"\n");
/*       */         }
/*       */       } 
/*  7221 */       out.write("            PesoEnKg: \"" + ((Mercancias)this.MERCANCIAS.get(j)).getPeso() + "\"\n");
/*  7222 */       out.write("            ValorMercancia: \"" + this.utilerias.convertirCantTexto(((Mercancias)this.MERCANCIAS.get(j)).getValor()) + "\"\n");
/*  7223 */       out.write("            Moneda: \"" + ((Mercancias)this.MERCANCIAS.get(j)).getMoneda() + "\"\n");
/*       */     } 
/*       */     
/*  7226 */     out.write("        Autotransporte:\n");
/*  7227 */     out.write("          PermSCT: \"" + this.jComboBox4.getSelectedItem().toString().substring(0, 6) + "\"\n");
/*  7228 */     out.write("          NumPermisoSCT: \"CG20045\"\n");
/*  7229 */     out.write("          IdentificacionVehicular:\n");
/*  7230 */     out.write("            ConfigVehicular: \"" + this.jTextField25.getText() + "\"\n");
/*  7231 */     out.write("            PlacaVM: \"" + this.jTextField22.getText() + "\"\n");
/*  7232 */     out.write("            AnioModeloVM: \"" + this.jTextField23.getText() + "\"\n");
/*  7233 */     out.write("            PesoBrutoVehicular: \"" + this.jTextField14.getText() + "\"\n");
/*  7234 */     out.write("          Seguros:\n");
/*  7235 */     out.write("            AseguraRespCivil: \"GRUPO NACIONAL PROVINCIAL, S.A.B.\"\n");
/*  7236 */     out.write("            PolizaRespCivil: \"" + this.jTextField24.getText() + "\"\n");
/*  7237 */     if (peligroso) {
/*  7238 */       out.write("            AseguraMedAmbiente: \"" + this.jTextField24.getText() + "\"\n");
/*  7239 */       out.write("            PolizaMedAmbiente: \"" + this.jTextField24.getText() + "\"\n");
/*       */     } 
/*  7241 */     if (!this.jTextField26.getText().equals("")) {
/*  7242 */       out.write("          Remolques:\n");
/*  7243 */       out.write("            Remolque:\n");
/*  7244 */       out.write("              -\n");
/*  7245 */       out.write("                SubTipoRem: \"" + this.jTextField30.getText() + "\"\n");
/*  7246 */       out.write("                Placa: \"" + this.jTextField27.getText() + "\"\n");
/*       */     } 
/*  7248 */     if (!this.jTextField31.getText().equals("")) {
/*  7249 */       out.write("              -\n");
/*  7250 */       out.write("                SubTipoRem: \"" + this.jTextField35.getText() + "\"\n");
/*  7251 */       out.write("                Placa: \"" + this.jTextField32.getText() + "\"\n");
/*       */     } 
/*       */     
/*  7254 */     out.write("      FiguraTransporte: \n");
/*  7255 */     out.write("        TiposFigura: \n");
/*  7256 */     out.write("          -\n");
/*  7257 */     out.write("            TipoFigura: \"01\"\n");
/*  7258 */     out.write("            RFCFigura: \"" + this.jTextField6.getText() + "\"\n");
/*  7259 */     out.write("            NumLicencia: \"" + this.jTextField7.getText() + "\"\n");
/*  7260 */     out.write("            NombreFigura: \"" + String.valueOf(this.jComboBox3.getSelectedItem()) + "\"\n");
/*  7261 */     out.write("            Domicilio:\n");
/*  7262 */     out.write("              Calle: \"" + this.VEROPERADOR[0] + "\"\n");
/*  7263 */     out.write("              NumeroExterior: \"" + this.VEROPERADOR[1] + "\"\n");
/*  7264 */     out.write("              Colonia: \"" + this.VEROPERADOR[2] + "\"\n");
/*  7265 */     out.write("              Referencia: \"Col: " + this.VEROPERADOR[6] + ", Municipio: " + this.VEROPERADOR[7] + "\"\n");
/*  7266 */     out.write("              Municipio: \"" + this.VEROPERADOR[3] + "\"\n");
/*  7267 */     out.write("              Estado: \"" + this.VEROPERADOR[4] + "\"\n");
/*  7268 */     out.write("              Pais: \"MEX\"\n");
/*  7269 */     out.write("              CodigoPostal: \"" + this.VEROPERADOR[5] + "\"\n");
/*       */     
/*  7271 */     out.write("\n");
/*  7272 */     out.write("  Addenda: \n");
/*  7273 */     out.write("    Diverza: \n");
/*  7274 */     out.write("      Version: \"1.1\"\n\n");
/*  7275 */     out.write("      Generales: \n");
/*  7276 */     out.write("        TotalConLetra: \"CERO PESOS 00/100 M.N\"\n");
/*  7277 */     out.write("        Observaciones: \"CARTA PORTE: " + this.jTextField1.getText() + " / " + this.jEditorPane1.getText().toUpperCase() + "\"\n");
/*       */     
/*  7279 */     out.write("      DatosContactoE: \n");
/*  7280 */     if (((String)this.CAMPOSGENERALES.get("sucursal")).toString().equals("POZA RICA")) {
/*  7281 */       out.write("        Telefono: \"01 782 825 6455 al 01 782 825 6458\"\n");
/*  7282 */     } else if (((String)this.CAMPOSGENERALES.get("sucursal")).toString().equals("VERACRUZ")) {
/*  7283 */       out.write("        Telefono: \"01 (229) 924-8600 al 03\"\n");
/*  7284 */     } else if (((String)this.CAMPOSGENERALES.get("sucursal")).toString().equals("CARDENAS")) {
/*  7285 */       out.write("        Telefono: \"(01 937) 372 7301 al 10\"\n");
/*  7286 */     } else if (((String)this.CAMPOSGENERALES.get("sucursal")).toString().equals("CADEREYTA")) {
/*  7287 */       out.write("        Telefono: \"828 284 4444\"\n");
/*       */     } 
/*  7289 */     out.write("        Web: \"www.forsis.com.mx\"\n\n");
/*       */     
/*  7291 */     out.write("      Emisor: \n");
/*  7292 */     out.write("        DomicilioFiscalE: \n");
/*  7293 */     out.write("          Calle: \"AUTOPISTA CADEREYTA - MONTERREY\"\n");
/*  7294 */     out.write("          Numero: \"KM 32.5\"\n");
/*  7295 */     out.write("          Ciudad: \"CADEREYTA JIMENEZ\"\n");
/*  7296 */     out.write("          Municipio: \"CADEREYTA JIMENEZ\"\n");
/*  7297 */     out.write("          Estado: \"NUEVO LEON\"\n");
/*  7298 */     out.write("          Pais: \"MEXICO\"\n");
/*  7299 */     out.write("          CodigoPostal: \"67483\"\n");
/*       */     
/*  7301 */     if (((String)this.CAMPOSGENERALES.get("sucursal")).toString().equals("POZA RICA")) {
/*  7302 */       out.write("        SucursalE: \n");
/*  7303 */       out.write("          Alias: \"" + (String)this.CAMPOSGENERALES.get("sucursal") + "\"\n");
/*  7304 */       out.write("          DomicilioSucursal: \n");
/*  7305 */       out.write("            Calle: \"CARRETERA POZA RICA A TIHUATLAN KM 8.5 \"\n");
/*  7306 */       out.write("            Ciudad: \"TIHUATLAN\"\n");
/*  7307 */       out.write("            Estado: \"VERACRUZ\"\n");
/*  7308 */       out.write("            Pais: \"MÉXICO\"\n");
/*  7309 */       out.write("            CodigoPostal: \"92900\"\n\n");
/*  7310 */     } else if (((String)this.CAMPOSGENERALES.get("sucursal")).toString().equals("VERACRUZ")) {
/*  7311 */       out.write("        SucursalE: \n");
/*  7312 */       out.write("          Alias: \"" + (String)this.CAMPOSGENERALES.get("sucursal") + "\"\n");
/*  7313 */       out.write("          DomicilioSucursal: \n");
/*  7314 */       out.write("            Calle: \"CARRETERA A CARDEL (NUEVA ERA) KM 5\"\n");
/*  7315 */       out.write("            Ciudad: \"VERACRUZ\"\n");
/*  7316 */       out.write("            Estado: \"VERACRUZ\"\n");
/*  7317 */       out.write("            Pais: \"MÉXICO\"\n");
/*  7318 */       out.write("            CodigoPostal: \"91809\"\n\n");
/*  7319 */     } else if (((String)this.CAMPOSGENERALES.get("sucursal")).toString().equals("CARDENAS")) {
/*  7320 */       out.write("        SucursalE: \n");
/*  7321 */       out.write("          Alias: \"" + (String)this.CAMPOSGENERALES.get("sucursal") + "\"\n");
/*  7322 */       out.write("          DomicilioSucursal: \n");
/*  7323 */       out.write("            Calle: \"CARRETERA VILLAHERMOSA-CARDENAS KM 125+500\"\n");
/*  7324 */       out.write("            Ciudad: \"H. CARDENAS\"\n");
/*  7325 */       out.write("            Estado: \"TABASCO\"\n");
/*  7326 */       out.write("            Pais: \"MÉXICO\"\n");
/*  7327 */       out.write("            CodigoPostal: \"86470\"\n\n");
/*       */     } 
/*       */     
/*  7330 */     out.write("  LeyendasImpresion: \n");
/*  7331 */     out.write("    -\n");
/*  7332 */     out.write("      Atributo: \"SEMARNAT\"\n");
/*  7333 */     out.write("      Valor: \"PERMISO SEMARNAT 19-I-036D-10, PERMISO SCT CG20045\"\n");
/*       */     
/*  7335 */     out.write("      Atributo: \"IMPUESTO RETENIDO\"\n");
/*  7336 */     out.write("      Valor: \"IMPUESTO RETENIDO DE CONFORMIDAD CON LA LEY DEL IMPUESTO AL VALOR AGREGADO\"\n");
/*       */     
/*  7338 */     out.write("      Atributo: \"DEBEMOS\"\n");
/*  7339 */     out.write("      Valor: \"DEBO(MOS) Y PAGARE(MOS) INCONDICIONALMENTE EN ESTA CIUDAD A LA ORDEN DE FLETES Y MATERIALES FORSIS, S.A. DE C.V. LA CANTIDAD QUE SE INDICA COMO TOTAL EN ESTE DOCUMENTO, VALOR DEL SERCIVIO ARRIBA DESCRITO Y QUE HEMOS RECIBIDO DE CONFORMIDAD, SI ESTA CANTIDAD NO FUERE CUBIERTA A LA PRESENTACION DE ESTE PAGARE, CAUSARA INTERESES MORATORIOS A RAZON DE % ANUAL HASTA SU TOTAL SOLUCION\"\n");
/*       */     
/*  7341 */     out.write("---");
/*  7342 */     out.close();
/*       */   }
/*       */   
/*       */   public void imprimirGuia2025() throws JRException {
/*  7346 */     String mercancia = "";
/*  7347 */     for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/*  7348 */       mercancia = mercancia + mercancia + "| ";
/*       */     }
/*       */     
/*  7351 */     String fecha = this.utilerias.convertirFechaDateStringBarras(this.jDateChooser1.getDate());
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  7361 */     String[] origenes = { ((OrigenesDestinos)this.ORIGENESDESTINOS.get(0)).getNombre(), ((OrigenesDestinos)this.ORIGENESDESTINOS.get(0)).getCalle(), ((OrigenesDestinos)this.ORIGENESDESTINOS.get(0)).getNum(), ((OrigenesDestinos)this.ORIGENESDESTINOS.get(0)).getCol(), ((OrigenesDestinos)this.ORIGENESDESTINOS.get(0)).getCp(), ((OrigenesDestinos)this.ORIGENESDESTINOS.get(0)).getCiudad(), ((OrigenesDestinos)this.ORIGENESDESTINOS.get(0)).getRfc(), ((OrigenesDestinos)this.ORIGENESDESTINOS.get(0)).getCiudad(), ((OrigenesDestinos)this.ORIGENESDESTINOS.get(0)).getC_estado() };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  7374 */     String[] destinos = { this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getNombre()).toArray()[0].toString(), this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getCalle()).toArray()[0].toString(), this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getNum()).toArray()[0].toString(), this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getCol()).toArray()[0].toString(), this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getCp()).toArray()[0].toString(), this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getCiudad()).toArray()[0].toString(), this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getRfc()).toArray()[0].toString(), this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getMonto()).toArray()[0].toString(), this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getLetra()).toArray()[0].toString(), this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getC_estado()).toArray()[0].toString() };
/*       */ 
/*       */     
/*  7377 */     double sum = this.MERCANCIAS.stream().mapToDouble(c -> Double.parseDouble(c.getPeso())).sum();
/*  7378 */     String CLIENTE = this.jComboBox1.getSelectedItem().toString();
/*       */     
/*  7380 */     String tons = "" + sum + " TONS.";
/*  7381 */     String sub = "";
/*  7382 */     String iva = "";
/*  7383 */     String total = this.utilerias.convertirDoublePesos(Double.parseDouble(destinos[7]));
/*  7384 */     String cantidad = destinos[8];
/*       */     
/*  7386 */     String pozo = this.jTextField13.getText().toUpperCase();
/*  7387 */     if (!pozo.equals("")) {
/*  7388 */       pozo = "POZO: " + pozo;
/*       */     }
/*       */     
/*  7391 */     String rem2 = this.jTextField31.getText().toUpperCase();
/*  7392 */     String placasT = this.jTextField22.getText();
/*  7393 */     String placasR = this.jTextField27.getText();
/*  7394 */     String residuo = mercancia;
/*       */     
/*  7396 */     String origen = origenes[0];
/*  7397 */     if (origen.length() > 50) {
/*  7398 */       origen = origen.substring(0, 49);
/*       */     }
/*       */     
/*  7401 */     String desti = origenes[1] + " " + origenes[1];
/*  7402 */     if (desti.length() > 50) {
/*  7403 */       desti = desti.substring(0, 49);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  7437 */     String[] enviar = { fecha, origenes[7] + ", " + origenes[7], origen, desti, origenes[3], origenes[6], destinos[5] + ", " + destinos[5], destinos[0], destinos[1] + " " + destinos[1], destinos[3], destinos[6], this.jComboBox22.getSelectedItem().toString().toUpperCase(), residuo, this.jTextField11.getText().toUpperCase(), this.jTextField12.getText().toUpperCase(), tons, sub, iva, total, this.jComboBox3.getSelectedItem().toString(), pozo, this.jTextField21.getText(), placasT, this.jTextField26.getText(), placasR, cantidad, this.jTextField58.getText(), this.jLabel54.getText(), this.jComboBox2.getSelectedItem().toString(), this.jEditorPane1.getText().toUpperCase(), this.CAMPOSGENERALES.get("semarnat"), this.jTextField31.getText(), this.jTextField32.getText(), CLIENTE };
/*       */ 
/*       */ 
/*       */     
/*  7441 */     for (int j = 0; j < enviar.length; j++) {
/*  7442 */       System.out.println("dat " + j + ": " + enviar[j]);
/*       */     }
/*       */     
/*  7445 */     DefaultTableModel model = new DefaultTableModel();
/*  7446 */     model.addColumn("cant");
/*  7447 */     model.addColumn("tipo");
/*  7448 */     model.addColumn("desc");
/*  7449 */     model.addColumn("peso");
/*  7450 */     model.addColumn("cobrar");
/*       */     
/*  7452 */     for (int k = 0; k < this.rSTableMetro2.getRowCount(); k++) {
/*  7453 */       model.addRow((Object[])new String[] { "1", this.jComboBox2
/*       */             
/*  7455 */             .getSelectedItem().toString().toUpperCase() + " DE " + this.jComboBox2.getSelectedItem().toString().toUpperCase(), this.rSTableMetro2
/*  7456 */             .getValueAt(k, 3).toString(), this.rSTableMetro2
/*  7457 */             .getValueAt(k, 5).toString(), enviar[18] });
/*       */     } 
/*       */ 
/*       */     
/*  7461 */     JTable tabla = new JTable(model);
/*       */     
/*  7463 */     List<String> legends = List.of("ORIGINAL", "CLIENTE", "OPERADOR", "SEMARNAT", "EMBARQUE");
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  7470 */     Map<Object, Object> datos = new HashMap<>();
/*  7471 */     this.utilerias.cargarImagenesAReporte(datos);
/*  7472 */     datos.put("folio", this.jTextField1.getText().toUpperCase());
/*  7473 */     datos.put("fecha", fecha);
/*  7474 */     datos.put("cliente", enviar[33]);
/*  7475 */     datos.put("or_origen", origenes[7] + ", " + origenes[7]);
/*  7476 */     datos.put("or_remitente", enviar[2]);
/*  7477 */     datos.put("or_domicilio", enviar[3]);
/*  7478 */     datos.put("or_colonia", enviar[4]);
/*  7479 */     datos.put("or_rfc", enviar[5]);
/*       */     
/*  7481 */     datos.put("des_destino", enviar[6]);
/*  7482 */     datos.put("des_destinatario", enviar[7]);
/*  7483 */     datos.put("des_domicilio", enviar[8]);
/*  7484 */     datos.put("des_colonia", enviar[9]);
/*  7485 */     datos.put("des_rfc", enviar[10]);
/*       */     
/*  7487 */     datos.put("total", enviar[18]);
/*  7488 */     datos.put("totalLetra", enviar[25]);
/*  7489 */     datos.put("observaciones", enviar[29]);
/*       */     
/*  7491 */     datos.put("unidad", enviar[21]);
/*  7492 */     datos.put("unidad_placas", enviar[22]);
/*  7493 */     datos.put("rem1", enviar[23]);
/*  7494 */     datos.put("rem1_placas", enviar[24]);
/*  7495 */     datos.put("rem2", enviar[31]);
/*  7496 */     datos.put("rem2_placas", enviar[32]);
/*       */     
/*  7498 */     datos.put("operador", enviar[19]);
/*  7499 */     datos.put("usuario", enviar[26]);
/*       */     
/*  7501 */     String nombreArchivo = "guia.pdf";
/*       */     
/*  7503 */     JRTableModelDataSource jRTableModelDataSource1 = new JRTableModelDataSource(tabla.getModel());
/*  7504 */     JRTableModelDataSource jRTableModelDataSource2 = new JRTableModelDataSource(tabla.getModel());
/*  7505 */     JRTableModelDataSource jRTableModelDataSource3 = new JRTableModelDataSource(tabla.getModel());
/*  7506 */     JRTableModelDataSource jRTableModelDataSource4 = new JRTableModelDataSource(tabla.getModel());
/*  7507 */     JRTableModelDataSource jRTableModelDataSource5 = new JRTableModelDataSource(tabla.getModel());
/*  7508 */     JasperReport reporte = (JasperReport)JRLoader.loadObject(getClass().getResource("/Reportes/Trafico/Guia2025.jasper"));
/*       */     
/*  7510 */     JasperPrint report1 = null;
/*  7511 */     JasperPrint report2 = null;
/*  7512 */     JasperPrint report3 = null;
/*  7513 */     JasperPrint report4 = null;
/*  7514 */     JasperPrint report5 = null;
/*       */     
/*  7516 */     for (String legend : legends) {
/*  7517 */       datos.put("hoja", legend);
/*  7518 */       if (legend.equals("ORIGINAL")) {
/*  7519 */         report1 = JasperFillManager.fillReport(reporte, datos, (JRDataSource)jRTableModelDataSource1);
/*       */       }
/*  7521 */       if (legend.equals("CLIENTE")) {
/*  7522 */         report2 = JasperFillManager.fillReport(reporte, datos, (JRDataSource)jRTableModelDataSource2);
/*       */       }
/*  7524 */       if (legend.equals("OPERADOR")) {
/*  7525 */         report3 = JasperFillManager.fillReport(reporte, datos, (JRDataSource)jRTableModelDataSource4);
/*       */       }
/*  7527 */       if (legend.equals("SEMARNAT")) {
/*  7528 */         report4 = JasperFillManager.fillReport(reporte, datos, (JRDataSource)jRTableModelDataSource5);
/*       */       }
/*  7530 */       if (legend.equals("EMBARQUE")) {
/*  7531 */         report5 = JasperFillManager.fillReport(reporte, datos, (JRDataSource)jRTableModelDataSource3);
/*       */       }
/*       */     } 
/*       */     
/*       */     try {
/*  7536 */       List<JasperPrint> jasperPrintList = new ArrayList<>();
/*       */       
/*  7538 */       jasperPrintList.add(report1);
/*  7539 */       jasperPrintList.add(report2);
/*  7540 */       jasperPrintList.add(report3);
/*  7541 */       jasperPrintList.add(report4);
/*  7542 */       jasperPrintList.add(report5);
/*       */       
/*  7544 */       JRPdfExporter exporter = new JRPdfExporter();
/*  7545 */       exporter.setExporterInput((ExporterInput)SimpleExporterInput.getInstance(jasperPrintList));
/*  7546 */       exporter.setExporterOutput((ExporterOutput)new SimpleOutputStreamExporterOutput(nombreArchivo));
/*  7547 */       exporter.exportReport();
/*  7548 */       setVisible(false);
/*       */ 
/*       */ 
/*       */       
/*       */       try {
/*  7553 */         File path = new File(nombreArchivo);
/*  7554 */         Desktop.getDesktop().open(path);
/*  7555 */       } catch (IOException ex) {
/*  7556 */         ex.printStackTrace();
/*       */       
/*       */       }
/*       */     
/*       */     }
/*  7561 */     catch (JRException e) {
/*  7562 */       e.printStackTrace();
/*       */     } 
/*       */   }
/*       */   
/*       */   private static void addPagesToReport(JasperPrint target, JasperPrint source) {
/*  7567 */     if (source != null) {
/*  7568 */       List<JRPrintPage> pages = source.getPages();
/*  7569 */       if (pages != null) {
/*  7570 */         target.getPages().addAll(pages);
/*  7571 */         System.out.println("agrega pag: " + pages.size());
/*       */       } 
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   public void imprimirGuia() {
/*       */     try {
/*  7579 */       imprimirGuia2025();
/*  7580 */     } catch (JRException e) {
/*  7581 */       Logger.getLogger(GuiasForm.class.getName()).log(Level.SEVERE, (String)null, (Throwable)e);
/*       */     } 
/*       */     
/*  7584 */     String mercancia = "";
/*  7585 */     for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/*  7586 */       mercancia = mercancia + mercancia + "| ";
/*       */     }
/*       */     
/*  7589 */     String fecha = this.utilerias.convertirFechaDateStringBarras(this.jDateChooser1.getDate());
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  7600 */     String[] origenes = { ((OrigenesDestinos)this.ORIGENESDESTINOS.get(0)).getNombre(), ((OrigenesDestinos)this.ORIGENESDESTINOS.get(0)).getCalle(), ((OrigenesDestinos)this.ORIGENESDESTINOS.get(0)).getNum(), ((OrigenesDestinos)this.ORIGENESDESTINOS.get(0)).getCol(), ((OrigenesDestinos)this.ORIGENESDESTINOS.get(0)).getCp(), ((OrigenesDestinos)this.ORIGENESDESTINOS.get(0)).getCiudad(), ((OrigenesDestinos)this.ORIGENESDESTINOS.get(0)).getRfc(), ((OrigenesDestinos)this.ORIGENESDESTINOS.get(0)).getCiudad(), ((OrigenesDestinos)this.ORIGENESDESTINOS.get(0)).getC_estado() };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  7613 */     String[] destinos = { this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getNombre()).toArray()[0].toString(), this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getCalle()).toArray()[0].toString(), this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getNum()).toArray()[0].toString(), this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getCol()).toArray()[0].toString(), this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getCp()).toArray()[0].toString(), this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getCiudad()).toArray()[0].toString(), this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getRfc()).toArray()[0].toString(), this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getMonto()).toArray()[0].toString(), this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getLetra()).toArray()[0].toString(), this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getC_estado()).toArray()[0].toString() };
/*       */ 
/*       */     
/*  7616 */     double sum = this.MERCANCIAS.stream().mapToDouble(c -> Double.parseDouble(c.getPeso())).sum();
/*  7617 */     String CLIENTE = this.jComboBox1.getSelectedItem().toString();
/*       */     
/*  7619 */     String tons = "" + sum + " TONS.";
/*  7620 */     String sub = "";
/*  7621 */     String iva = "";
/*  7622 */     String total = this.utilerias.convertirDoublePesos(Double.parseDouble(destinos[7]));
/*  7623 */     String cantidad = destinos[8];
/*       */     
/*  7625 */     String pozo = this.jTextField13.getText().toUpperCase();
/*  7626 */     if (!pozo.equals("")) {
/*  7627 */       pozo = "POZO: " + pozo;
/*       */     }
/*       */     
/*  7630 */     String rem2 = this.jTextField31.getText().toUpperCase();
/*  7631 */     String placasT = this.jTextField22.getText();
/*  7632 */     String placasR = this.jTextField27.getText();
/*  7633 */     String residuo = mercancia;
/*       */     
/*  7635 */     String origen = origenes[0];
/*  7636 */     if (origen.length() > 50) {
/*  7637 */       origen = origen.substring(0, 49);
/*       */     }
/*       */     
/*  7640 */     String desti = origenes[1] + " " + origenes[1];
/*  7641 */     if (desti.length() > 50) {
/*  7642 */       desti = desti.substring(0, 49);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  7676 */     String[] enviar = { fecha, origenes[7] + ", " + origenes[7], origen, desti, origenes[3], origenes[6], destinos[5] + ", " + destinos[5], destinos[0], destinos[1] + " " + destinos[1], destinos[3], destinos[6], this.jComboBox22.getSelectedItem().toString().toUpperCase(), residuo, this.jTextField11.getText().toUpperCase(), this.jTextField12.getText().toUpperCase(), tons, sub, iva, total, this.jComboBox3.getSelectedItem().toString(), pozo, this.jTextField21.getText(), placasT, this.jTextField26.getText(), placasR, cantidad, this.jTextField58.getText(), this.jLabel54.getText(), this.jComboBox2.getSelectedItem().toString(), this.jEditorPane1.getText().toUpperCase(), this.CAMPOSGENERALES.get("semarnat"), this.jTextField31.getText(), this.jTextField32.getText(), CLIENTE };
/*       */ 
/*       */     
/*  7679 */     Imprimir im = new Imprimir();
/*  7680 */     im.recibeDatos(enviar);
/*       */   }
/*       */   
/*       */   public void insertarTrasUni() {
/*  7684 */     String insertar = "";
/*       */ 
/*       */ 
/*       */     
/*  7688 */     insertar = insertar + "'" + insertar + "', '" + String.valueOf(this.jComboBox21.getSelectedItem()) + "', '" + this.jTextField21.getText() + "', '" + this.jTextField25.getText() + "', '" + this.jTextField22.getText() + "', '" + this.jTextField23.getText() + "', '" + this.jTextField24.getText() + "'";
/*       */     
/*  7690 */     if (!this.jTextField26.getText().equals(""))
/*       */     {
/*       */ 
/*       */       
/*  7694 */       insertar = insertar + "), ('REMOLQUE1', '" + insertar + "', '" + this.jTextField26.getText() + "', '" + this.jTextField30.getText() + "', '" + this.jTextField27.getText() + "', '" + this.jTextField28.getText() + "', '" + this.jTextField29.getText() + "'";
/*       */     }
/*       */     
/*  7697 */     if (!this.jTextField31.getText().equals(""))
/*       */     {
/*       */ 
/*       */       
/*  7701 */       insertar = insertar + "), ('REMOLQUE2', '" + insertar + "', '" + this.jTextField31.getText() + "', '" + this.jTextField35.getText() + "', '" + this.jTextField32.getText() + "', '" + this.jTextField33.getText() + "', '" + this.jTextField34.getText() + "'";
/*       */     }
/*       */     
/*  7704 */     if (!this.jTextField36.getText().equals(""))
/*       */     {
/*       */ 
/*       */       
/*  7708 */       insertar = insertar + "), ('DOLLY', '" + insertar + "', '" + this.jTextField36.getText() + "', '" + this.jTextField40.getText() + "', '" + this.jTextField37.getText() + "', '" + this.jTextField38.getText() + "', '" + this.jTextField39.getText() + "'";
/*       */     }
/*       */     
/*  7711 */     this.con.inserSinMsj("insert into tras_cartaporte_unidades(tipoF, unidad, claveSat, placa, modelo, poliza, guia) values (" + insertar + ")");
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public void insertarTrasContenedores() {
/*  7721 */     String consulta = "";
/*  7722 */     for (int i = 0; i < this.LISTACONTENEDORES.size(); i++) {
/*  7723 */       int num = i + 1;
/*       */ 
/*       */ 
/*       */       
/*  7727 */       consulta = consulta + "('" + consulta + "','" + ((Contenedores)this.LISTACONTENEDORES.get(Integer.valueOf(num))).getMatricula() + "','" + ((Contenedores)this.LISTACONTENEDORES.get(Integer.valueOf(num))).getTipo() + "', '" + ((Contenedores)this.LISTACONTENEDORES.get(Integer.valueOf(num))).getOtro() + "', '" + ((Contenedores)this.LISTACONTENEDORES.get(Integer.valueOf(num))).getPrecinto() + "')";
/*       */       
/*  7729 */       if (i + 1 != this.LISTACONTENEDORES.size()) {
/*  7730 */         consulta = consulta + ",";
/*       */       }
/*       */     } 
/*  7733 */     if (this.LISTACONTENEDORES.size() > 0) {
/*  7734 */       this.con.inserSinMsj("insert into tras_cartaporte_mercancias_contenedores(matricula, tipo, descripcion, numPrecinto, guia) values " + consulta);
/*       */     }
/*       */   }
/*       */   
/*       */   public void validarLicencia() {
/*  7739 */     this.con.consultar("fecha_licen", "operadores", "where num_ope=" + ((Operadores)this.OPERADORES.get(this.jComboBox3.getSelectedIndex() - 1)).getNum_ope());
/*       */     
/*  7741 */     String año = this.con.Campo.substring(0, 4);
/*  7742 */     String mes = this.con.Campo.substring(5, 7);
/*  7743 */     String dia = this.con.Campo.substring(8, 10);
/*       */     
/*  7745 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  7746 */     String strFecha = dia + "-" + dia + "-" + mes;
/*  7747 */     Date fechaLicen = null;
/*       */     try {
/*  7749 */       fechaLicen = formatoDelTexto.parse(strFecha);
/*  7750 */     } catch (ParseException ex) {
/*  7751 */       ex.printStackTrace();
/*       */     } 
/*  7753 */     Date fechaAc = new Date();
/*  7754 */     this.DIASVENCIDOS = restarFechas(fechaLicen, fechaAc);
/*  7755 */     int DD = -1 * this.DIASVENCIDOS;
/*  7756 */     if (this.DIASVENCIDOS < 0 && this.DIASVENCIDOS > -31) {
/*  7757 */       this.jDialog8.setTitle("Licencia está por vencerse");
/*  7758 */       this.jLabel97.setText("Próximo Vencimiento de Licencia");
/*  7759 */       this.jLabel98.setText("<html><center>LA LICENCIA DEL OPERADOR QUE SELECCIONASTE ESTÁ PRÓXIMA A VENCER.</center></html>");
/*  7760 */       this.jLabel99.setText("<html><center>La vigencia de la licencia caducará en " + DD + " días, si no se renueva no se podrá dar viajes en éste módulo.</center></html>");
/*  7761 */       this.jDialog8.setVisible(true);
/*  7762 */     } else if (this.DIASVENCIDOS > 0 && this.DIASVENCIDOS < 15) {
/*       */       
/*  7764 */       this.jDialog8.setTitle("Licencia Vencida");
/*  7765 */       this.jLabel97.setText("Actualizar Licencia");
/*  7766 */       this.jLabel98.setText("<html><center>LA LICENCIA ESTÁ VENCIDA Y NECESITA ACTUALIZARLA.</center></html>");
/*  7767 */       this.jLabel99.setText("<html><center>El operador que seleccionaste cuenta con una licencia vencida, necesita actualizarla ya que sino lo hace, quedará bloquedo dentro de " + 15 - this.DIASVENCIDOS + " días.</center></html>");
/*  7768 */       this.jDialog8.setVisible(true);
/*  7769 */     } else if (this.DIASVENCIDOS > 15) {
/*       */       
/*  7771 */       this.jDialog8.setTitle("Licencia Vencida");
/*  7772 */       this.jLabel97.setText("Operador Bloqueado");
/*  7773 */       this.jLabel98.setText("<html><center>LICENCIA VENCIDA.</center></html>");
/*  7774 */       this.jLabel99.setText("<html><center>El operador ha sido bloqueado por no actualizar su licencia, no se podrá dar viajes hasta que refrende éste documento.</center></html>");
/*  7775 */       this.jDialog8.setVisible(true);
/*  7776 */       this.jComboBox3.setSelectedIndex(0);
/*  7777 */       this.jTextField6.setText("");
/*  7778 */       this.jTextField7.setText("");
/*  7779 */       this.jTextField8.setText("");
/*       */     } 
/*       */   }
/*       */   
/*       */   public void contenedor(int num, String matricula) {
/*  7784 */     if (!matricula.equals("Agregar")) {
/*  7785 */       this.jTextField122.setText(((Contenedores)this.LISTACONTENEDORES.get(Integer.valueOf(this.NUMCONTENEDOR))).getMatricula());
/*  7786 */       this.jTextField123.setText(((Contenedores)this.LISTACONTENEDORES.get(Integer.valueOf(this.NUMCONTENEDOR))).getPrecinto());
/*  7787 */       this.jComboBox102.setSelectedItem(this.TIPOCONTENEDORES.get(((Contenedores)this.LISTACONTENEDORES.get(Integer.valueOf(this.NUMCONTENEDOR))).getTipo()));
/*  7788 */       this.jTextField124.setText(((Contenedores)this.LISTACONTENEDORES.get(Integer.valueOf(this.NUMCONTENEDOR))).getOtro());
/*  7789 */       if (this.materialButton1.getText().equals("Imprimir")) {
/*  7790 */         this.jTextField122.setEnabled(false);
/*  7791 */         this.jComboBox102.setEnabled(false);
/*  7792 */         this.jTextField123.setEnabled(false);
/*  7793 */         this.jTextField124.setEnabled(false);
/*       */       } 
/*       */     } 
/*  7796 */     this.jDialog7.setVisible(true);
/*       */   }
/*       */   
/*       */   public void asignarCat(String tipo) {
/*  7800 */     int ind = this.rSTableMetro6.getSelectedRow();
/*  7801 */     if (tipo.equals("UNIDAD")) {
/*  7802 */       this.jTextField101.setText(this.rSTableMetro6.getValueAt(ind, 0).toString());
/*  7803 */       String unid = this.rSTableMetro6.getValueAt(ind, 1).toString();
/*  7804 */       if (unid.length() > 20) {
/*  7805 */         this.jTextField102.setText(this.rSTableMetro6.getValueAt(ind, 1).toString().substring(0, 19));
/*       */       } else {
/*  7807 */         this.jTextField102.setText(this.rSTableMetro6.getValueAt(ind, 1).toString());
/*       */       } 
/*       */       
/*  7810 */       String clave = this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 0).toString();
/*  7811 */       this.con.consultar("uso", "catunidades", "where clave_unidad='" + clave + "'");
/*  7812 */       int i = Integer.parseInt(this.con.Campo);
/*  7813 */       i++;
/*  7814 */       this.con.inserSinMsj("update catunidades set uso='" + i + "' where clave_unidad='" + clave + "'");
/*       */     } 
/*  7816 */     if (tipo.equals("STCC")) {
/*  7817 */       this.jTextField103.setText(this.rSTableMetro6.getValueAt(ind, 0).toString());
/*  7818 */       this.jTextField104.setText(this.rSTableMetro6.getValueAt(ind, 1).toString());
/*       */     } 
/*  7820 */     if (tipo.equals("PRODUCTO")) {
/*  7821 */       this.jTextField105.setText(this.rSTableMetro6.getValueAt(ind, 0).toString());
/*  7822 */       this.jTextField106.setText(this.rSTableMetro6.getValueAt(ind, 1).toString());
/*  7823 */       if (!this.jComboBox2.getSelectedItem().toString().equals("SERVICIO INTEGRAL")) {
/*  7824 */         this.jEditorPane100.setText(this.rSTableMetro6.getValueAt(ind, 1).toString());
/*       */       }
/*  7826 */       this.con2.consultar("uso", "tras_productos", "where clave='" + this.jTextField105.getText() + "'");
/*  7827 */       int i = Integer.parseInt(this.con2.Campo);
/*  7828 */       i++;
/*  7829 */       this.con2.inserSinMsj("update tras_productos set uso='" + i + "' where clave='" + this.jTextField105.getText() + "'");
/*  7830 */       String mat = this.rSTableMetro6.getValueAt(ind, 2).toString();
/*       */       
/*  7832 */       if (mat.equals("0")) {
/*  7833 */         this.jCheckBox4.setSelected(false);
/*  7834 */         this.jCheckBox4.setEnabled(false);
/*  7835 */       } else if (mat.equals("1")) {
/*  7836 */         this.jCheckBox4.setSelected(true);
/*  7837 */         this.jCheckBox4.setEnabled(false);
/*  7838 */         this.jButton104.setEnabled(true);
/*  7839 */         this.jButton105.setEnabled(true);
/*       */       } else {
/*  7841 */         this.jCheckBox4.setSelected(false);
/*  7842 */         this.jCheckBox4.setEnabled(true);
/*  7843 */         this.jButton104.setEnabled(false);
/*  7844 */         this.jButton105.setEnabled(false);
/*       */       } 
/*       */     } 
/*  7847 */     if (tipo.equals("MONEDA")) {
/*  7848 */       this.jTextField109.setText(this.rSTableMetro6.getValueAt(ind, 0).toString());
/*       */     }
/*  7850 */     if (tipo.equals("MATPELIGROSO")) {
/*  7851 */       this.jTextField110.setText(this.rSTableMetro6.getValueAt(ind, 0).toString());
/*  7852 */       this.jTextField111.setText(this.rSTableMetro6.getValueAt(ind, 1).toString());
/*       */     } 
/*  7854 */     if (tipo.equals("EMBALAJE")) {
/*  7855 */       this.jTextField112.setText(this.rSTableMetro6.getValueAt(ind, 0).toString());
/*  7856 */       this.jTextField113.setText(this.rSTableMetro6.getValueAt(ind, 1).toString());
/*       */     } 
/*  7858 */     if (tipo.equals("ARANCEL")) {
/*  7859 */       this.jTextField114.setText(this.rSTableMetro6.getValueAt(ind, 0).toString());
/*  7860 */       this.jTextField115.setText(this.rSTableMetro6.getValueAt(ind, 1).toString());
/*       */     } 
/*  7862 */     this.jDialog6.setVisible(false);
/*       */   }
/*       */   
/*       */   public void consultarCatalogo(String tipo) {
/*  7866 */     String clave = "";
/*  7867 */     String desc = "";
/*  7868 */     if (!this.jTextField120.equals("")) {
/*  7869 */       clave = this.jTextField120.getText();
/*       */     }
/*  7871 */     if (!this.jTextField121.equals("")) {
/*  7872 */       desc = this.jTextField121.getText();
/*       */     }
/*  7874 */     if (tipo.equals("UNIDAD")) {
/*  7875 */       this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro6, new String[] { "Clave", "Descripción" }, "clave_unidad,descripcion_unidad", "catunidades", "where clave_unidad like '%" + clave + "%' and descripcion_unidad like '%" + desc + "%' order by uso desc,descripcion_unidad asc");
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     }
/*  7881 */     else if (tipo.equals("STCC")) {
/*  7882 */       this.utilerias.consultaGralTabla(this.con2, (JTable)this.rSTableMetro6, new String[] { "Clave", "Descripción" }, "clave,descripcion", "tras_stcc", "where clave like '%" + clave + "%' and descripcion like '%" + desc + "%' order by descripcion");
/*       */ 
/*       */ 
/*       */     
/*       */     }
/*  7887 */     else if (tipo.equals("PRODUCTO")) {
/*  7888 */       this.utilerias.consultaGralTabla(this.con2, (JTable)this.rSTableMetro6, new String[] { "Clave", "Descripción", "Mat Peligroso" }, "clave, descripcion, matPeligroso", "tras_productos", "where clave like '%" + clave + "%' and (descripcion like '%" + desc + "%' || descsimilar like '%" + desc + "%') order by uso desc, descripcion asc");
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  7893 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro6, 2, 100);
/*  7894 */     } else if (tipo.equals("MONEDA")) {
/*  7895 */       this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro6, new String[] { "Moneda", "Descripción" }, "moneda,descripcion", "catmoneda", "where moneda like '%" + clave + "%' and descripcion like '%" + desc + "%' order by descripcion");
/*       */ 
/*       */ 
/*       */     
/*       */     }
/*  7900 */     else if (tipo.equals("MATPELIGROSO")) {
/*  7901 */       this.utilerias.consultaGralTabla(this.con2, (JTable)this.rSTableMetro6, new String[] { "Clave", "Descripción", "Clase" }, "clave, descripcion, clase", "tras_mat_peligroso", "where clave like '%" + clave + "%' and descripcion like '%" + desc + "%' order by descripcion");
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  7906 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro6, 2, 60);
/*  7907 */     } else if (tipo.equals("EMBALAJE")) {
/*  7908 */       this.utilerias.consultaGralTabla(this.con2, (JTable)this.rSTableMetro6, new String[] { "Clave", "Descripción" }, "clave, descripcion", "tras_embalaje", "where clave like '%" + clave + "%' and descripcion like '%" + desc + "%' order by descripcion");
/*       */ 
/*       */ 
/*       */     
/*       */     }
/*  7913 */     else if (tipo.equals("ARANCEL")) {
/*  7914 */       this.utilerias.consultaGralTabla(this.con2, (JTable)this.rSTableMetro6, new String[] { "Clave", "Descripción" }, "clave, descripcion", "tras_aranceles", "where clave like '%" + clave + "%' and descripcion like '%" + desc + "%' order by descripcion");
/*       */     } 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  7920 */     this.jLabel62.setText("" + this.rSTableMetro6.getRowCount());
/*  7921 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro6, 0, 70);
/*  7922 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro6);
/*       */   }
/*       */   
/*       */   public boolean validar1() {
/*  7926 */     int selec = this.jComboBox3.getSelectedIndex();
/*  7927 */     boolean entra = false;
/*  7928 */     if (this.jComboBox1.getSelectedIndex() == 0) {
/*  7929 */       this.jComboBox1.setBackground(Color.RED);
/*  7930 */       JOptionPane.showMessageDialog(this, "Necesitas seleccionar el cliente", "Falta el cliente", 0, this.ADVER);
/*  7931 */     } else if (this.jTextField5.getText().equals("")) {
/*  7932 */       JOptionPane.showMessageDialog(this, "El RFC del cliente no puede estar vacío", "Falta RFC del cliente", 0, this.ERROR);
/*  7933 */     } else if (this.jTextField5.getText().contains("XXX")) {
/*  7934 */       JOptionPane.showMessageDialog(this, "El cliente necesita un RFC válido", "RFC Inválido", 0, this.ERROR);
/*  7935 */     } else if (this.jComboBox2.getSelectedIndex() == 0) {
/*  7936 */       this.jComboBox2.setBackground(Color.RED);
/*  7937 */       JOptionPane.showMessageDialog(this, "Necesitas seleccionar el tipo de Servicio", "Falta el servicio", 0, this.ADVER);
/*  7938 */     } else if (this.jComboBox3.getSelectedIndex() == 0) {
/*  7939 */       this.jComboBox3.setBackground(Color.RED);
/*  7940 */       JOptionPane.showMessageDialog(this, "Necesitas seleccionar el operador", "Falta el operador", 0, this.ADVER);
/*  7941 */     } else if (this.jTextField6.getText().equals("")) {
/*  7942 */       JOptionPane.showMessageDialog(this, "El RFC del operador no puede estar vacío", "Falta RFC del operador", 0, this.ERROR);
/*  7943 */     } else if (((Operadores)this.OPERADORES.get(selec - 1)).getLocalidad().equals("")) {
/*       */       
/*  7945 */       JOptionPane.showMessageDialog(this, "Falta ingresar la Localidad en la dirección del operador, ", "Falta Ingresar la Localidad", 0, this.ERROR);
/*  7946 */     } else if (this.jTextField6.getText().contains("XXX")) {
/*  7947 */       JOptionPane.showMessageDialog(this, "El Operador necesita un RFC válido", "RFC Inválido", 0, this.ERROR);
/*       */     } else {
/*  7949 */       entra = true;
/*       */     } 
/*  7951 */     return entra;
/*       */   }
/*       */   
/*       */   public boolean validar2() {
/*  7955 */     boolean entra = false;
/*  7956 */     long origenes = this.ORIGENESDESTINOS.stream().filter(c -> c.getTipo().equals("ORIGEN")).map(c -> c.getId()).count();
/*  7957 */     long destinos = this.ORIGENESDESTINOS.stream().filter(c -> c.getTipo().equals("DESTINO")).map(c -> c.getId()).count();
/*  7958 */     if (origenes < 1L) {
/*  7959 */       JOptionPane.showMessageDialog(this, "Necesitas ingresar por lo menos un ORIGEN", "Ingresa el Origen", 0, this.ERROR);
/*  7960 */     } else if (destinos < 1L) {
/*  7961 */       JOptionPane.showMessageDialog(this, "Necesitas ingresar por lo menos un DESTINO", "Ingresa el Destino", 0, this.ERROR);
/*       */     } else {
/*  7963 */       entra = true;
/*       */     } 
/*  7965 */     return entra;
/*       */   }
/*       */   
/*       */   public boolean validar3() {
/*  7969 */     boolean vacioOR = false;
/*  7970 */     for (int i = 0; i < this.rSTableMetro2.getRowCount(); i++) {
/*  7971 */       String celda = this.rSTableMetro2.getValueAt(i, 9).toString();
/*  7972 */       if (celda.equals("")) {
/*  7973 */         vacioOR = true;
/*       */         
/*       */         break;
/*       */       } 
/*       */     } 
/*  7978 */     boolean entra = false;
/*  7979 */     if (this.rSTableMetro2.getRowCount() < 1) {
/*  7980 */       JOptionPane.showMessageDialog(this, "Necesitas ingresar por lo menos una MERCANCÍA", "Ingresa la mercancía", 0, this.ERROR);
/*  7981 */     } else if (this.jTextField21.getText().equals("")) {
/*  7982 */       JOptionPane.showMessageDialog(this, "Necesitas ingresar el económico", "Ingresa el económico", 0, this.ERROR);
/*  7983 */     } else if (!this.jTextField26.getText().equals("") && !this.jTextField31.getText().equals("") && this.jTextField36.getText().equals("")) {
/*  7984 */       JOptionPane.showMessageDialog(this, "Has ingresado en modalidad FULL al ingresar los 2 remolques, pero aún no has ingresado un Dolly", "Deberías ingresar el DOlly", 0, this.ADVER);
/*       */     }
/*  7986 */     else if (this.jTextField14.getText().equals("0") || this.jTextField14.getText().equals("")) {
/*  7987 */       JOptionPane.showMessageDialog(this, "Falta ingresar el PESO BRTUO DE LA UNIDAD, el peso es en toneladas", "Falta el peso de la unidad", 0, this.ADVER);
/*  7988 */     } else if (this.jComboBox22.getSelectedItem().toString().equals("") || this.jComboBox22.getSelectedItem().toString().equals("EQUIPO")) {
/*  7989 */       JOptionPane.showMessageDialog(this, "Falta ingresar el tipo de Equipo, por ej: PORTACONETENDOR DE 20, TOLVA, PRESIÓN Y VACÍO, SÓLO TRACTO", "Falta el Equipo", 0, this.ADVER);
/*  7990 */     } else if (vacioOR) {
/*  7991 */       JOptionPane.showMessageDialog(this, "Las ubicaciones se han actualizado, es necesario que actualices los datos dentro de la mercancía", "Actualiza las ubicaciones", 0, this.ADVER);
/*       */     } else {
/*  7993 */       if (this.materialButton1.getText().equals("Guardar")) {
/*  7994 */         this.jEditorPane1.setText("");
/*  7995 */         if (this.entraModificarContenedores) {
/*  7996 */           this.LISTACONTENEDORES.forEach((x, y) -> this.jEditorPane1.setText(this.jEditorPane1.getText() + " Contenedor: " + this.jEditorPane1.getText() + "/Sello: " + y.getMatricula() + "        "));
/*       */         }
/*       */       } 
/*  7999 */       entra = true;
/*       */     } 
/*  8001 */     return entra;
/*       */   }
/*       */   
/*       */   public String[] sacarDatosExtra2(String rem) {
/*  8005 */     String[] dat = this.con.regresaRegIndex("tipo", "remolque", "where num_rem = " + rem);
/*  8006 */     return dat;
/*       */   }
/*       */   
/*       */   public void pasarEco(String tipo, int ind) {
/*  8010 */     if (tipo.equals("TRACTO")) {
/*  8011 */       String poliza = this.rSTableMetro5.getValueAt(ind, 3).toString();
/*  8012 */       String tipoSat = this.rSTableMetro5.getValueAt(ind, 4).toString();
/*  8013 */       String peso = this.rSTableMetro5.getValueAt(ind, 5).toString();
/*  8014 */       if (poliza.equals("")) {
/*  8015 */         JOptionPane.showMessageDialog(this.jDialog4, "Necesitas ingresar la póliza de seguro de la unidad", "Falta póliza", 0, this.ADVER); return;
/*       */       } 
/*  8017 */       if (tipoSat.equals("")) {
/*  8018 */         JOptionPane.showMessageDialog(this.jDialog4, "Necesitas ingresar la clave del tipo de vehículo\nProporcionada en el catálogo del SAT.", "Falta tipo", 0, this.ADVER); return;
/*       */       } 
/*  8020 */       if (peso.equals("0")) {
/*  8021 */         JOptionPane.showMessageDialog(this.jDialog4, "Necesitas ingresar el peso del vehículo.\nSe necesita el PESO BRUTO de la tarjeta de circulación, no puede ser igual a cero.", "Falta el peso", 0, this.ADVER);
/*       */         return;
/*       */       } 
/*  8024 */       this.jTextField21.setText(this.rSTableMetro5.getValueAt(ind, 0).toString());
/*  8025 */       this.jTextField22.setText(this.rSTableMetro5.getValueAt(ind, 1).toString());
/*  8026 */       this.jTextField23.setText(this.rSTableMetro5.getValueAt(ind, 2).toString());
/*  8027 */       this.jTextField24.setText(this.rSTableMetro5.getValueAt(ind, 3).toString());
/*  8028 */       this.jTextField25.setText(this.rSTableMetro5.getValueAt(ind, 4).toString());
/*  8029 */       this.jTextField14.setText(this.rSTableMetro5.getValueAt(ind, 5).toString());
/*  8030 */       if (!this.jTextField26.getText().equals("")) {
/*  8031 */         this.jTextField25.setText("T2S2");
/*       */       }
/*  8033 */       if (!this.jTextField31.getText().equals("")) {
/*  8034 */         this.jTextField25.setText("T3S2R4");
/*       */       }
/*  8036 */       this.jDialog4.setVisible(false);
/*       */     
/*       */     }
/*  8039 */     else if (!tipo.equals("UTILITARIO")) {
/*  8040 */       if (tipo.equals("REMOLQUE 1")) {
/*  8041 */         String tipoSat = this.rSTableMetro5.getValueAt(ind, 4).toString();
/*  8042 */         if (tipoSat.equals("")) {
/*  8043 */           JOptionPane.showMessageDialog(this.jDialog4, "Necesitas ingresar la clave del tipo del remolque\nProporcionada en el catálogo del SAT.", "Falta tipo", 0, this.ADVER);
/*       */           return;
/*       */         } 
/*  8046 */         this.jTextField26.setText(this.rSTableMetro5.getValueAt(ind, 0).toString());
/*  8047 */         this.jTextField27.setText(this.rSTableMetro5.getValueAt(ind, 1).toString());
/*  8048 */         this.jTextField28.setText(this.rSTableMetro5.getValueAt(ind, 2).toString());
/*  8049 */         this.jTextField29.setText(this.rSTableMetro5.getValueAt(ind, 3).toString());
/*  8050 */         this.jTextField30.setText(this.rSTableMetro5.getValueAt(ind, 4).toString());
/*  8051 */         this.jDialog4.setVisible(false);
/*  8052 */         this.datosExtra2 = sacarDatosExtra2(this.jTextField26.getText());
/*  8053 */         this.jComboBox22.setSelectedItem(this.datosExtra2[0].toUpperCase());
/*  8054 */         if (this.jTextField31.getText().equals("")) {
/*  8055 */           this.jTextField25.setText("T2S2");
/*       */         }
/*       */       }
/*  8058 */       else if (tipo.equals("REMOLQUE 2")) {
/*  8059 */         String tipoSat = this.rSTableMetro5.getValueAt(ind, 4).toString();
/*  8060 */         if (tipoSat.equals("")) {
/*  8061 */           JOptionPane.showMessageDialog(this.jDialog4, "Necesitas ingresar la clave del tipo del remolque\nProporcionada en el catálogo del SAT.", "Falta tipo", 0, this.ADVER);
/*       */           return;
/*       */         } 
/*  8064 */         this.jTextField31.setText(this.rSTableMetro5.getValueAt(ind, 0).toString());
/*  8065 */         this.jTextField32.setText(this.rSTableMetro5.getValueAt(ind, 1).toString());
/*  8066 */         this.jTextField33.setText(this.rSTableMetro5.getValueAt(ind, 2).toString());
/*  8067 */         this.jTextField34.setText(this.rSTableMetro5.getValueAt(ind, 3).toString());
/*  8068 */         this.jTextField35.setText(this.rSTableMetro5.getValueAt(ind, 4).toString());
/*  8069 */         this.jTextField25.setText("T3S2R4");
/*  8070 */         this.jDialog4.setVisible(false);
/*       */       }
/*  8072 */       else if (tipo.equals("DOLLY")) {
/*  8073 */         this.jTextField36.setText(this.rSTableMetro5.getValueAt(ind, 0).toString());
/*  8074 */         this.jTextField37.setText(this.rSTableMetro5.getValueAt(ind, 1).toString());
/*  8075 */         this.jTextField38.setText(this.rSTableMetro5.getValueAt(ind, 2).toString());
/*  8076 */         this.jTextField39.setText(this.rSTableMetro5.getValueAt(ind, 3).toString());
/*  8077 */         this.jTextField40.setText(this.rSTableMetro5.getValueAt(ind, 4).toString());
/*  8078 */         this.jDialog4.setVisible(false);
/*       */       } 
/*       */     } 
/*       */   }
/*       */   public void buscarEco(String tipo) {
/*  8083 */     String eco = "";
/*  8084 */     if (!this.jTextField82.getText().equals(this.holderBuscarEco)) {
/*  8085 */       eco = this.jTextField82.getText();
/*       */     }
/*  8087 */     if (tipo.equals("TRACTO")) {
/*  8088 */       this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro5, new String[] { "Eco", "Placas", "Modelo", "Póliza", "Tipo", "Peso Tons" }, "num_tracto, placas, modelo, poliza, claveCat, pesoVehicular", "tracto", "where num_tracto like '%" + eco + "%' and num_tracto<>0 and estado ='ACTIVO' and sucursal='" + (String)this.CAMPOSGENERALES
/*       */ 
/*       */ 
/*       */           
/*  8092 */           .get("sucursal") + "' order by num_tracto");
/*  8093 */     } else if (!tipo.equals("UTILITARIO")) {
/*       */       
/*  8095 */       if (tipo.equals("REMOLQUE 1") || tipo.equals("REMOLQUE 2")) {
/*  8096 */         this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro5, new String[] { "Eco", "Placas", "Modelo", "Póliza", "Tipo" }, "num_rem, placas, modelo, poliza, clavetipoRem", "remolque", "where num_rem like '%" + eco + "%' and num_rem<>0 and estado ='ACTIVO' and sucursal='" + (String)this.CAMPOSGENERALES
/*       */ 
/*       */ 
/*       */             
/*  8100 */             .get("sucursal") + "' order by num_rem");
/*  8101 */       } else if (tipo.equals("DOLLY")) {
/*  8102 */         this.utilerias.consultaGralTabla(this.con, (JTable)this.rSTableMetro5, new String[] { "Eco", "Placas", "Modelo", "Póliza", "Tipo" }, "ecoDolly, placas, modelo, poliza, tipo", "dollys", "where ecoDolly like '%" + eco + "%' and estado ='ACTIVO' and sucursal='" + (String)this.CAMPOSGENERALES
/*       */ 
/*       */ 
/*       */             
/*  8106 */             .get("sucursal") + "' order by ecoDolly");
/*       */       } 
/*  8108 */     }  this.jLabel61.setText("" + this.rSTableMetro5.getRowCount());
/*  8109 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro5);
/*       */   }
/*       */   
/*       */   public void llenarOrigenDestino() {
/*  8113 */     int ind = this.rSTableMetro4.getSelectedRow();
/*  8114 */     if (ind < 0) {
/*  8115 */       JOptionPane.showMessageDialog(this.jDialog3, "Necesitas seleccionar un registro", "Selecciona un registro", 0, this.ADVER);
/*       */     } else {
/*  8117 */       String id = this.rSTableMetro4.getValueAt(ind, 1).toString();
/*  8118 */       if (this.utilerias.buscarDatoEnTabla((JTable)this.rSTableMetro1, id, 2)) {
/*  8119 */         JOptionPane.showMessageDialog(this.jDialog3, "El dato que has seleccionado ya se encuentra registrado: " + id, "Ya se encuentra", 0, this.ERROR);
/*       */         return;
/*       */       } 
/*  8122 */       if (this.utilerias.buscarDatoEnTabla((JTable)this.rSTableMetro1, "03.- DESTINO FINAL NACIONAL", 1)) {
/*  8123 */         JOptionPane.showMessageDialog(this.jDialog3, "Sólo puedes ingresar un sólo Destino Final Nacional: " + id, "Ya se encuentra el destino final", 0, this.ERROR);
/*       */         return;
/*       */       } 
/*  8126 */       String RFC = this.rSTableMetro4.getValueAt(ind, 3).toString();
/*       */       
/*  8128 */       if (RFC.contains(" ")) {
/*       */         
/*  8130 */         JOptionPane.showMessageDialog(this, "No puedes ingresar espacios en el campo del RFC", "Espacios detectados", 0, this.ERROR);
/*  8131 */       } else if (RFC.length() < 12) {
/*       */         
/*  8133 */         JOptionPane.showMessageDialog(this, "<html>Te faltan caracteres en el RFC: <p><b>Persona Física: </b> 12 Caracteres <p><b>Persona Moral:</b> 13 Caracteres<p>En caso que el RFC no sea válido, los comprobantes con estos datos no se timbrarán<html>", "Espacios detectados", 0, this.ERROR);
/*       */ 
/*       */ 
/*       */       
/*       */       }
/*  8138 */       else if (RFC.length() > 13) {
/*  8139 */         this.jTextField2.setBackground(Color.RED);
/*  8140 */         JOptionPane.showMessageDialog(this, "<html>Caracteres de más en el RFC: <p><b>Persona Física: </b> 12 Caracteres <p><b>Persona Moral:</b> 13 Caracteres<p>En caso que el RFC no sea válido, los comprobantes con estos datos no se timbrarán<html>", "Espacios detectados", 0, this.ERROR);
/*       */ 
/*       */ 
/*       */       
/*       */       }
/*  8145 */       else if (!this.utilerias.validarRFC(RFC)) {
/*       */         
/*  8147 */         String mensaje = "<html><body><b>¡RFC INCORRECTO!</b><br><br><b>Para capturar el RFC correctamente, ten en cuenta lo siguiente:</b><br><br><b>Persona Física:</b><br>1. El RFC consta de 13 caracteres.<br>2. Los primeros 4 caracteres son las primeras letras del apellido paterno.<br>3. Los siguientes 6 caracteres son la fecha de nacimiento en formato AA-MM-DD.<br>4. Los últimos 3 caracteres son homoclave (pueden ser letras o números).<br><br><b>Ejemplo: GOME900101ABC</b><br><br><b>Persona Moral:</b><br>1. El RFC consta de 12 caracteres.<br>2. Los primeros 3 caracteres son las primeras letras de la razón social.<br>3. Los siguientes 6 caracteres son la fecha de constitución en formato AA-MM-DD.<br>4. Los últimos 3 caracteres son homoclave (pueden ser letras o números).<br><br><b>Ejemplo: EMP200101ABC</b><br><br><b>¡Asegúrate de capturar correctamente tu RFC!</b><br>Presiona Aceptar para continuar.</body></html>";
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8163 */         JOptionPane.showMessageDialog(this, mensaje, "Instrucciones para capturar el RFC", 0, this.ERROR);
/*  8164 */       } else if (RFC.equals("") && (this.jRadioButton1.isSelected() || this.jRadioButton3.isSelected())) {
/*  8165 */         JOptionPane.showMessageDialog(this.jDialog3, "El RFC no puede estar vacío", "Falta RFC", 0, this.ERROR);
/*  8166 */       } else if (RFC.contains("XXX")) {
/*  8167 */         JOptionPane.showMessageDialog(this.jDialog3, "El remitente o destinatario necesita un RFC válido", "RFC Inválido", 0, this.ERROR);
/*  8168 */       } else if (this.jRadioButton2.isSelected() && this.jSpinner4.getValue().toString().equals("0")) {
/*  8169 */         JOptionPane.showMessageDialog(this.jDialog3, "Necesitas ingresar los kilometros de recorrdo", "Falta el Kilometraje", 0, this.ADVER);
/*  8170 */       } else if ((this.jRadioButton1.isSelected() || this.jRadioButton3.isSelected()) && this.rSTableMetro4.getValueAt(this.rSTableMetro4.getSelectedRow(), 9).toString().equals("")) {
/*  8171 */         JOptionPane.showMessageDialog(this.jDialog3, "Falta la localidad en la dirección del Origen", "Falta Localidad", 0, this.ADVER);
/*  8172 */       } else if (this.jRadioButton2.isSelected() && this.rSTableMetro4.getValueAt(this.rSTableMetro4.getSelectedRow(), 10).toString().equals("")) {
/*  8173 */         JOptionPane.showMessageDialog(this.jDialog3, "Falta la localidad en la dirección del Destino", "Falta Localidad", 0, this.ADVER);
/*  8174 */       } else if (this.jDateChooser31.getDate() == null) {
/*  8175 */         JOptionPane.showMessageDialog(this.jDialog3, "Necesitas ingresar la Fecha de Carga o Descarga", "Falta fecha", 0, this.ADVER);
/*       */       } else {
/*  8177 */         if (this.rSTableMetro1.getRowCount() < 1 && this.jRadioButton3.isSelected()) {
/*  8178 */           JOptionPane.showMessageDialog(this.jDialog3, "Necesitas ingresar primero los origenes de la mercancía", "Faltan origenes", 0, this.ADVER);
/*       */           return;
/*       */         } 
/*  8181 */         if (this.rSTableMetro1.getRowCount() < 1 && this.jRadioButton2.isSelected()) {
/*  8182 */           JOptionPane.showMessageDialog(this.jDialog3, "Necesitas ingresar primero los origenes de la mercancía", "Faltan origenes", 0, this.ADVER);
/*       */           
/*       */           return;
/*       */         } 
/*  8186 */         String tipo = "ORIGEN";
/*  8187 */         String tipoUbic = "01";
/*  8188 */         String tipoUbicDesc = "ORIGEN NACIONAL";
/*  8189 */         String km = "0";
/*  8190 */         String fecha = this.utilerias.convertirFechaDateString(this.jDateChooser31.getDate()) + " " + this.utilerias.convertirFechaDateString(this.jDateChooser31.getDate()) + ":" + String.valueOf(this.jSpinner1.getValue()) + ":" + String.valueOf(this.jSpinner2.getValue());
/*  8191 */         String monto = "";
/*  8192 */         String letra = "";
/*       */         
/*  8194 */         String c_Localidad = "";
/*  8195 */         String Localidad = "";
/*  8196 */         if (this.jRadioButton3.isSelected()) {
/*  8197 */           tipo = "ORIGEN";
/*  8198 */           tipoUbic = "02";
/*  8199 */           tipoUbicDesc = "INTERMEDIA";
/*  8200 */         } else if (this.jRadioButton2.isSelected()) {
/*  8201 */           tipo = "DESTINO";
/*  8202 */           tipoUbic = "03";
/*  8203 */           tipoUbicDesc = "DESTINO FINAL NACIONAL";
/*  8204 */           km = this.jSpinner4.getValue().toString();
/*  8205 */           String[] datos = this.con.regresaRegIndex("monto, letra", "emp_destinataria", "where clave_desti = " + String.valueOf(this.rSTableMetro4.getValueAt(ind, 0)));
/*  8206 */           monto = datos[0];
/*  8207 */           letra = datos[1];
/*       */         } 
/*  8209 */         String[] dir = regresaOD(tipo, this.rSTableMetro4.getValueAt(ind, 1).toString());
/*  8210 */         if (this.jRadioButton1.isSelected() || this.jRadioButton3.isSelected()) {
/*  8211 */           c_Localidad = dir[4];
/*  8212 */           Localidad = dir[5];
/*       */         } else {
/*  8214 */           c_Localidad = dir[7];
/*  8215 */           Localidad = dir[8];
/*       */         } 
/*       */         
/*  8218 */         if (dir[2].equals("")) {
/*  8219 */           JOptionPane.showMessageDialog(this.jDialog3, "En la Dirección: falta ingresar el Estado y su Clave, ahora es obligatoria la dirección", "Falta Estado", 0, this.ERROR);
/*       */         } else {
/*  8221 */           this.ORIGENESDESTINOS.add(new OrigenesDestinos(this.rSTableMetro4
/*  8222 */                 .getValueAt(ind, 0).toString(), tipo, tipoUbic, tipoUbicDesc, this.rSTableMetro4
/*       */ 
/*       */ 
/*       */                 
/*  8226 */                 .getValueAt(ind, 1).toString(), this.rSTableMetro4
/*  8227 */                 .getValueAt(ind, 2).toString(), this.rSTableMetro4
/*  8228 */                 .getValueAt(ind, 3).toString(), this.rSTableMetro4
/*  8229 */                 .getValueAt(ind, 4).toString(), this.rSTableMetro4
/*  8230 */                 .getValueAt(ind, 5).toString(), this.rSTableMetro4
/*  8231 */                 .getValueAt(ind, 6).toString(), this.rSTableMetro4
/*  8232 */                 .getValueAt(ind, 7).toString(), this.rSTableMetro4
/*  8233 */                 .getValueAt(ind, 8).toString(), dir[0], "MÉXICO", dir[1], dir[2], dir[3], fecha, km, monto, letra, c_Localidad, Localidad));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*  8252 */           String[] campos = { tipo, tipoUbic + ".- " + tipoUbic, this.rSTableMetro4.getValueAt(ind, 1).toString(), this.rSTableMetro4.getValueAt(ind, 2).toString(), this.rSTableMetro4.getValueAt(ind, 3).toString(), this.rSTableMetro4.getValueAt(ind, 4).toString(), this.rSTableMetro4.getValueAt(ind, 5).toString(), this.rSTableMetro4.getValueAt(ind, 6).toString(), this.rSTableMetro4.getValueAt(ind, 7).toString(), this.rSTableMetro4.getValueAt(ind, 8).toString(), km, fecha };
/*       */ 
/*       */ 
/*       */           
/*  8256 */           this.utilerias.agregarCampoTablas(campos, (JTable)this.rSTableMetro1);
/*  8257 */           this.jTextField10.setText(km);
/*  8258 */           if (this.jRadioButton2.isSelected()) {
/*  8259 */             this.jDialog3.setVisible(false);
/*       */           }
/*       */         } 
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   public void llenarUnidades() {
/*  8267 */     buscarEco("TRACTO"); int i;
/*  8268 */     for (i = 0; i < this.rSTableMetro5.getRowCount(); i++) {
/*  8269 */       this.UNIDADES.add(new Unidades("TRACTO", this.rSTableMetro5
/*       */             
/*  8271 */             .getValueAt(i, 0).toString(), this.rSTableMetro5
/*  8272 */             .getValueAt(i, 1).toString(), this.rSTableMetro5
/*  8273 */             .getValueAt(i, 2).toString(), this.rSTableMetro5
/*  8274 */             .getValueAt(i, 3).toString(), this.rSTableMetro5
/*  8275 */             .getValueAt(i, 4).toString()));
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*  8280 */     buscarEco("REMOLQUE 1");
/*  8281 */     for (i = 0; i < this.rSTableMetro5.getRowCount(); i++) {
/*  8282 */       this.UNIDADES.add(new Unidades("REMOLQUE 1", this.rSTableMetro5
/*       */             
/*  8284 */             .getValueAt(i, 0).toString(), this.rSTableMetro5
/*  8285 */             .getValueAt(i, 1).toString(), this.rSTableMetro5
/*  8286 */             .getValueAt(i, 2).toString(), this.rSTableMetro5
/*  8287 */             .getValueAt(i, 3).toString(), this.rSTableMetro5
/*  8288 */             .getValueAt(i, 4).toString()));
/*       */     }
/*       */ 
/*       */     
/*  8292 */     buscarEco("DOLLY");
/*  8293 */     for (i = 0; i < this.rSTableMetro5.getRowCount(); i++) {
/*  8294 */       this.UNIDADES.add(new Unidades("DOLLY", this.rSTableMetro5
/*       */             
/*  8296 */             .getValueAt(i, 0).toString(), this.rSTableMetro5
/*  8297 */             .getValueAt(i, 1).toString(), this.rSTableMetro5
/*  8298 */             .getValueAt(i, 2).toString(), this.rSTableMetro5
/*  8299 */             .getValueAt(i, 3).toString(), this.rSTableMetro5
/*  8300 */             .getValueAt(i, 4).toString()));
/*       */     }
/*       */   }
/*       */ 
/*       */   
/*       */   public String[] regresaOD(String tipo, String ID) {
/*  8306 */     String[] datos = null;
/*  8307 */     if (tipo.equals("ORIGEN")) {
/*  8308 */       datos = this.con2.regresaRegIndex("edo, c_colonia, c_municipio, c_estado, c_localidad, localidad", "tras_origenes", "where id= '" + ID + "'");
/*       */     } else {
/*  8310 */       datos = this.con.regresaRegIndex("edo, c_colonia, c_municipio, c_estado, km, monto, letra, c_localidad, localidad", "emp_destinataria", "where id= '" + ID + "'");
/*       */     } 
/*  8312 */     return datos;
/*       */   }
/*       */   
/*       */   public void consultarUbic() {
/*  8316 */     String nombre = "";
/*  8317 */     if (!this.jTextField81.getText().equals(this.holderBuscarUbic)) {
/*  8318 */       nombre = this.jTextField81.getText();
/*       */     }
/*  8320 */     if (this.jRadioButton1.isSelected() || this.jRadioButton3.isSelected()) {
/*  8321 */       this.utilerias.consultaGralTabla(this.con2, (JTable)this.rSTableMetro4, new String[] { "Núm", "ID", "Nombre", "RFC", "CP", "Calle", "Num", "Colonia", "Ciudad", "Localidad" }, "num_o, id, nombre, rfc, cp, calle, num, col, ciudad, localidad", "tras_origenes", "where nombre like '%" + nombre + "%' order by nombre");
/*       */     }
/*       */     else {
/*       */       
/*  8325 */       this.con2.setBaseDatos("sicrePR");
/*  8326 */       this.utilerias.consultaGralTabla(this.con2, (JTable)this.rSTableMetro4, new String[] { "Núm", "ID", "Nombre", "RFC", "CP", "Calle", "Num", "Colonia", "Ciudad", "Km", "Localidad" }, "clave_desti, id, empresa, rfc, cp, calle, num, col, ciudad, km, localidad", "emp_destinataria", "where clave_desti<>0 and empresa like '%" + nombre + "%' order by empresa");
/*       */     } 
/*       */ 
/*       */     
/*  8330 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro4, 0, 40);
/*  8331 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro4, 1, 70);
/*  8332 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro4, 2, 210);
/*  8333 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro4, 4, 50);
/*  8334 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro4, this.celda1);
/*  8335 */     this.con2.setBaseDatos("sicre2PR");
/*       */   }
/*       */   
/*       */   public void agregarCampo(ArrayList<String> datos, String valor) {
/*  8339 */     if (!datos.contains(valor)) {
/*  8340 */       datos.add(valor);
/*       */     }
/*       */   }
/*       */   
/*       */   public void guardarTipos() {
/*  8345 */     String tipo = this.jTextField42.getText().toUpperCase();
/*  8346 */     if (tipo.equals("")) {
/*  8347 */       this.jTextField42.setBackground(Color.RED);
/*  8348 */       JOptionPane.showMessageDialog(this.jDialog2, "No puedes dejar el campo vacío, por favor verifica tu información", "Falta información", 0, this.ADVER);
/*  8349 */     } else if (this.materialButton3.getText().equals("Agregar")) {
/*  8350 */       int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas agregar el nuevo tipo de Servicio?", "Agregar nuevo Servicio", 0, 3, this.PREG);
/*  8351 */       if (res == 0) {
/*  8352 */         this.con2.inserSinMsj("insert into tras_tiposervicios(servicio) values('" + tipo + "')");
/*  8353 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos) values (now(),'" + this.USUARIO + "','Creó un nuevo Servicio.','\nServicio: " + tipo + "')");
/*  8354 */         this.jDialog1.setVisible(false);
/*  8355 */         this.jDialog2.setVisible(false);
/*  8356 */         this.jComboBox2.addItem(tipo);
/*  8357 */         this.jComboBox2.setSelectedItem(tipo);
/*       */       } 
/*       */     } else {
/*  8360 */       int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas modificar el nuevo tipo de Servicio?", "Modificar  Servicio", 0, 3, this.MODIFI);
/*  8361 */       if (res == 0) {
/*  8362 */         this.jComboBox2.removeItem(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1));
/*  8363 */         this.con2.inserSinMsj("update tras_tiposervicios set servicio ='" + this.jTextField42.getText().toUpperCase() + "' where num ='" + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 0)) + "'");
/*  8364 */         this.rSTableMetro3.setValueAt(this.jTextField42.getText().toUpperCase(), this.rSTableMetro3.getSelectedRow(), 1);
/*  8365 */         this.jComboBox2.addItem(this.jTextField42.getText().toUpperCase());
/*  8366 */         this.jComboBox2.setSelectedItem(this.jTextField42.getText().toUpperCase());
/*  8367 */         this.jDialog1.setVisible(false);
/*  8368 */         this.jDialog2.setVisible(false);
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   public void guardarManifiestos() {
/*  8374 */     String tipo = this.jTextField43.getText().toUpperCase();
/*  8375 */     if (tipo.equals("")) {
/*  8376 */       this.jTextField43.setBackground(Color.RED);
/*  8377 */       JOptionPane.showMessageDialog(this.jDialog2, "No puedes dejar el campo vacío, por favor verifica tu información", "Falta información", 0, this.ADVER);
/*  8378 */     } else if (this.materialButton11.getText().equals("Agregar")) {
/*  8379 */       int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas agregar el nuevo residuo?", "Agregar nuevo residuo", 0, 3, this.PREG);
/*  8380 */       if (res == 0) {
/*  8381 */         this.con2.inserSinMsj("insert into tras_manifiestos(carga, tipo) values('" + tipo + "', '" + String.valueOf(this.jComboBox5.getSelectedItem()) + "')");
/*  8382 */         this.TIPOMANIFIESTO = this.jComboBox5.getSelectedItem().toString();
/*  8383 */         this.jEditorPane100.setText(tipo);
/*  8384 */         this.jDialog10.setVisible(false);
/*  8385 */         this.jDialog11.setVisible(false);
/*       */       } 
/*       */     } else {
/*  8388 */       int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas modificar el nuevo tipo de Residuo?", "Modificar Residuo", 0, 3, this.MODIFI);
/*  8389 */       if (res == 0) {
/*  8390 */         this.TIPOMANIFIESTO = this.jComboBox5.getSelectedItem().toString();
/*       */         
/*  8392 */         this.con2.inserSinMsj("update tras_manifiestos set carga ='" + this.jTextField43.getText().toUpperCase() + "', tipo ='" + this.TIPOMANIFIESTO + "' where num ='" + String.valueOf(this.rSTableMetro7.getValueAt(this.rSTableMetro7.getSelectedRow(), 0)) + "'");
/*  8393 */         this.rSTableMetro7.setValueAt(this.jTextField43.getText().toUpperCase(), this.rSTableMetro7.getSelectedRow(), 1);
/*  8394 */         this.jEditorPane100.setText(this.jTextField43.getText().toUpperCase());
/*  8395 */         this.jDialog11.setVisible(false);
/*  8396 */         this.jDialog10.setVisible(false);
/*       */       } 
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   protected JRootPane createRootPane() {
/*  8403 */     JRootPane rootPane = new JRootPane();
/*  8404 */     KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
/*  8405 */     Action actionListener = new AbstractAction() {
/*       */         public void actionPerformed(ActionEvent actionEvent) {
/*  8407 */           GuiasForm.this.actualizado = false;
/*  8408 */           GuiasForm.this.setVisible(false);
/*       */         }
/*       */       };
/*  8411 */     InputMap inputMap = rootPane.getInputMap(2);
/*  8412 */     inputMap.put(stroke, "ESCAPE");
/*  8413 */     rootPane.getActionMap().put("ESCAPE", actionListener);
/*  8414 */     return rootPane;
/*       */   }
/*       */   
/*       */   public void llenarClientes() {
/*  8418 */     this.jComboBox1.removeAllItems();
/*  8419 */     this.jComboBox1.addItem("SELECCIONA UN CLIENTE...");
/*  8420 */     String[][] datos = this.con.buscarDatos("clave_gene, empresa, rfc, cp, calle, num, col, ciudad, nombre_corto, c_localidad, localidad, sct", "emp_generadora", "where activo = 'Activado' order by empresa");
/*  8421 */     for (String[] c : datos) {
/*  8422 */       this.CLIENTES.add(new Clientes(c[0], c[1], c[2], c[3], c[4], c[5], c[6], c[7], c[8], c[9], c[10], c[11]));
/*       */     }
/*  8424 */     this.CLIENTES.forEach(c -> this.jComboBox1.addItem(c.getNombre()));
/*  8425 */     this.entraCatCliente = true;
/*       */   }
/*       */   
/*       */   public void llenarOperadores() {
/*  8429 */     this.jComboBox3.removeAllItems();
/*  8430 */     this.jComboBox3.addItem("SELECCIONA UN OPERADOR...");
/*  8431 */     String[][] datos = this.con.buscarDatos("num_ope, nombre, ap_pat, ap_mat, calle, num, col, cp, ciudad, edo, c_colonia, c_municipio, c_estado, rfcOriginal, num_licen, c_localidad, localidad", "operadores", "where actual = 0 order by nombre, ap_pat, ap_mat");
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  8436 */     for (String[] c : datos) {
/*  8437 */       this.OPERADORES.add(new Operadores(c[0], c[1], c[2], c[3], c[4], c[5], c[6], c[7], c[8], c[9], c[10], c[11], c[12], c[13], c[14], c[15], c[16]));
/*       */     }
/*  8439 */     this.OPERADORES.forEach(c -> this.jComboBox3.addItem(c.getNombre() + " " + c.getNombre() + " " + c.getAp_pat()));
/*  8440 */     this.entraCatOpe = true;
/*       */   }
/*       */   
/*       */   public void consultarServicios() {
/*  8444 */     String tipo = "";
/*  8445 */     if (!this.jTextField80.getText().equals(this.holderBuscarT)) {
/*  8446 */       tipo = this.jTextField80.getText();
/*       */     }
/*  8448 */     this.utilerias.consultaGralTabla(this.con2, (JTable)this.rSTableMetro3, new String[] { "Núm", "Servicio" }, "num, servicio", "tras_tiposervicios", "where servicio like '%" + tipo + "%' order by servicio");
/*       */ 
/*       */     
/*  8451 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro3, 0, 50);
/*  8452 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro3);
/*       */   }
/*       */   
/*       */   public void llenarServicios() {
/*  8456 */     this.jComboBox2.removeAllItems();
/*  8457 */     this.jComboBox2.addItem("SELECCIONA EL TIPO DE SERVICIO...");
/*  8458 */     for (int i = 0; i < this.rSTableMetro3.getRowCount(); i++) {
/*  8459 */       this.jComboBox2.addItem(this.rSTableMetro3.getValueAt(i, 1).toString());
/*       */     }
/*       */   }
/*       */   
/*       */   public void llenarTipoEq() {
/*  8464 */     String[] DATOS = this.con.regresaColIndex("distinct(tipo)", "guias", "where tipo<>'' order by tipo");
/*  8465 */     for (String d : DATOS) {
/*  8466 */       this.jComboBox22.addItem(d);
/*       */     }
/*       */   }
/*       */   
/*       */   public void llenarTipoContenedores() {
/*  8471 */     this.TIPOCONTENEDORES.put("CM001", "CONTENEDORES REFRIGERADOS DE 20FT");
/*  8472 */     this.TIPOCONTENEDORES.put("CM002", "CONTENEDORES REFRIGERADOS DE 40FT");
/*  8473 */     this.TIPOCONTENEDORES.put("CM003", "CONTENEDORES ESTÁNDAR DE 8FT");
/*  8474 */     this.TIPOCONTENEDORES.put("CM004", "CONTENEDORES ESTÁNDAR DE 10FT");
/*  8475 */     this.TIPOCONTENEDORES.put("CM005", "CONTENEDORES ESTÁNDAR DE 20FT");
/*  8476 */     this.TIPOCONTENEDORES.put("CM006", "CONTENEDORES ESTÁNDAR DE 40FT");
/*  8477 */     this.TIPOCONTENEDORES.put("CM007", "CONTENEDORES OPEN SIDE");
/*  8478 */     this.TIPOCONTENEDORES.put("CM008", "CONTENEDORES ISOTANQUE");
/*  8479 */     this.TIPOCONTENEDORES.put("CM009", "CONTENEDORES FLAT RACKS");
/*  8480 */     this.TIPOCONTENEDORES.put("TC01", "CONTENEDOR DE 6.1 MTS DE LONGITUD 20FT");
/*  8481 */     this.TIPOCONTENEDORES.put("TC02", "CONTENEDOR DE 12.2 MTS DE LONGITUD 40FT");
/*  8482 */     this.TIPOCONTENEDORES.put("TC03", "CONTENEDOR DE 13.7 MTS DE LONGITUD 45FT");
/*  8483 */     this.TIPOCONTENEDORES.put("TC04", "CONTENEDOR DE 14.6 MTS DE LONGITUD 48FT");
/*  8484 */     this.TIPOCONTENEDORES.put("TC05", "CONTENEDOR DE 16.1 MTS DE LONGITUD 53FT");
/*  8485 */     this.TIPOCONTENEDORES.values().stream().forEach(x -> this.jComboBox102.addItem(x));
/*       */   }
/*       */   
/*       */   public void llenarPozos() {
/*  8489 */     this.entraPrimeraPozos = true;
/*  8490 */     String[][] DATOS = this.con.buscarDatos("distinct(equipo)", "equipos", "order by equipo");
/*  8491 */     for (String[] d : DATOS) {
/*  8492 */       agregarCampo(this.TODOS_EQUIPOS, d[0]);
/*       */     }
/*  8494 */     this.com_Equipos = new TextAutoCompleter(this.jTextField11, this.TODOS_EQUIPOS);
/*       */     
/*  8496 */     DATOS = this.con.buscarDatos("distinct(plataforma)", "plataformas", "order by plataforma");
/*  8497 */     for (String[] d : DATOS) {
/*  8498 */       agregarCampo(this.TODOS_PLATAFORMAS, d[0]);
/*       */     }
/*  8500 */     this.com_Plataformas = new TextAutoCompleter(this.jTextField12, this.TODOS_PLATAFORMAS);
/*       */     
/*  8502 */     DATOS = this.con.buscarDatos("distinct(nombre)", "pozos", "order by nombre");
/*  8503 */     for (String[] d : DATOS) {
/*  8504 */       agregarCampo(this.TODOS_POZOS, d[0]);
/*       */     }
/*  8506 */     this.com_Pozos = new TextAutoCompleter(this.jTextField13, this.TODOS_POZOS);
/*       */   }
/*       */ 
/*       */   
/*       */   public void colorear() {
/*  8511 */     this.pintar.colorear(this.jTextField2);
/*  8512 */     this.pintar.colorear(this.jComboBox1);
/*  8513 */     this.pintar.colorear(this.jComboBox2);
/*  8514 */     this.pintar.colorear(this.jComboBox3);
/*  8515 */     this.pintar.colorear(this.jComboBox4);
/*       */     
/*  8517 */     this.pintar.colorear(this.jTextField11);
/*  8518 */     this.pintar.colorear(this.jTextField12);
/*  8519 */     this.pintar.colorear(this.jTextField13);
/*       */     
/*  8521 */     this.pintar.colorear(this.jTextField21);
/*  8522 */     this.pintar.colorear(this.jTextField26);
/*  8523 */     this.pintar.colorear(this.jTextField31);
/*  8524 */     this.pintar.colorear(this.jTextField36);
/*  8525 */     this.pintar.colorear(this.jComboBox22);
/*       */     
/*  8527 */     this.pintar.colorear(this.jEditorPane1);
/*       */     
/*  8529 */     this.pintar.colorear(this.jTextField80);
/*  8530 */     this.pintar.colorear(this.jTextField42);
/*       */     
/*  8532 */     this.pintar.colorear(this.jTextField81);
/*       */     
/*  8534 */     this.pintar.colorear(this.jComboBox21);
/*  8535 */     this.pintar.colorear(this.jTextField21);
/*  8536 */     this.pintar.colorear(this.jTextField26);
/*  8537 */     this.pintar.colorear(this.jTextField31);
/*  8538 */     this.pintar.colorear(this.jTextField36);
/*       */     
/*  8540 */     this.pintar.colorear(this.jTextField82);
/*       */     
/*  8542 */     this.pintar.colorear(this.jFormattedTextField100);
/*  8543 */     this.pintar.colorear(this.jFormattedTextField101);
/*  8544 */     this.pintar.colorear(this.jFormattedTextField102);
/*  8545 */     this.pintar.colorear(this.jFormattedTextField103);
/*  8546 */     this.pintar.colorear(this.jEditorPane100);
/*  8547 */     this.pintar.colorear(this.jComboBox100);
/*  8548 */     this.pintar.colorear(this.jComboBox101);
/*  8549 */     this.pintar.colorear(this.jTextField107);
/*  8550 */     this.pintar.colorear(this.jFormattedTextField102);
/*  8551 */     this.pintar.colorear(this.jTextField116);
/*  8552 */     this.pintar.colorear(this.jTextField102);
/*       */     
/*  8554 */     this.pintar.colorear(this.jTextField120);
/*  8555 */     this.pintar.colorear(this.jTextField121);
/*       */     
/*  8557 */     this.pintar.colorear(this.jTextField122);
/*  8558 */     this.pintar.colorear(this.jTextField123);
/*  8559 */     this.pintar.colorear(this.jTextField124);
/*  8560 */     this.pintar.colorear(this.jComboBox102);
/*       */     
/*  8562 */     this.pintar.colorear(this.jComboBox50);
/*  8563 */     this.pintar.colorear(this.jTextField51);
/*  8564 */     this.pintar.colorear(this.jTextField53);
/*  8565 */     this.pintar.colorear(this.jTextField55);
/*  8566 */     this.pintar.colorear(this.jTextField56);
/*  8567 */     this.pintar.colorear(this.jTextField57);
/*       */     
/*  8569 */     this.pintar.colorear(this.jComboBox5);
/*       */   }
/*       */   
/*       */   public void activarGuiaTimbrada() {
/*  8573 */     this.jTextField2.setEnabled(true);
/*  8574 */     this.jComboBox2.setEnabled(true);
/*  8575 */     this.jCheckBox1.setEnabled(true);
/*  8576 */     this.jComboBox22.setEnabled(true);
/*  8577 */     this.jTextField11.setEnabled(true);
/*  8578 */     this.jTextField12.setEnabled(true);
/*  8579 */     this.jTextField13.setEnabled(true);
/*  8580 */     this.jComboBox22.setEnabled(true);
/*  8581 */     this.jEditorPane1.setEnabled(true);
/*       */   }
/*       */   
/*       */   public void desabilitar() {
/*  8585 */     this.jTextField2.setEnabled(false);
/*  8586 */     this.jTextField3.setEnabled(false);
/*  8587 */     this.jTextField4.setEnabled(false);
/*  8588 */     this.jTextField5.setEnabled(false);
/*  8589 */     this.jTextField6.setEnabled(false);
/*  8590 */     this.jTextField7.setEnabled(false);
/*  8591 */     this.jTextField8.setEnabled(false);
/*  8592 */     this.jComboBox1.setEnabled(false);
/*  8593 */     this.jComboBox2.setEnabled(false);
/*  8594 */     this.jComboBox3.setEnabled(false);
/*  8595 */     this.jComboBox4.setEnabled(false);
/*  8596 */     this.jButton1.setEnabled(false);
/*  8597 */     this.jButton2.setEnabled(false);
/*  8598 */     this.jButton3.setEnabled(false);
/*       */     
/*  8600 */     this.jButton10.setEnabled(false);
/*  8601 */     this.jButton12.setEnabled(false);
/*  8602 */     this.jCheckBox1.setEnabled(false);
/*  8603 */     this.jTextField11.setEnabled(false);
/*  8604 */     this.jTextField12.setEnabled(false);
/*  8605 */     this.jTextField13.setEnabled(false);
/*       */     
/*  8607 */     this.jButton11.setEnabled(false);
/*  8608 */     this.jButton13.setEnabled(false);
/*  8609 */     this.jComboBox21.setEnabled(false);
/*  8610 */     this.jComboBox22.setEnabled(false);
/*  8611 */     this.jButton4.setEnabled(false);
/*  8612 */     this.jButton5.setEnabled(false);
/*  8613 */     this.jButton6.setEnabled(false);
/*  8614 */     this.jButton7.setEnabled(false);
/*       */     
/*  8616 */     this.jFormattedTextField100.setEnabled(false);
/*  8617 */     this.jButton100.setEnabled(false);
/*  8618 */     this.jButton101.setEnabled(false);
/*  8619 */     this.jButton102.setEnabled(false);
/*  8620 */     this.jButton107.setEnabled(false);
/*  8621 */     this.jEditorPane100.setEnabled(false);
/*  8622 */     this.jTextField102.setEnabled(false);
/*  8623 */     this.jTextField107.setEnabled(false);
/*  8624 */     this.jFormattedTextField102.setEnabled(false);
/*  8625 */     this.jFormattedTextField101.setEnabled(false);
/*  8626 */     this.jFormattedTextField103.setEnabled(false);
/*  8627 */     this.jButton103.setEnabled(false);
/*  8628 */     this.jComboBox100.setEnabled(false);
/*  8629 */     this.jComboBox101.setEnabled(false);
/*  8630 */     this.jCheckBox4.setEnabled(false);
/*  8631 */     this.jButton104.setEnabled(false);
/*  8632 */     this.jButton105.setEnabled(false);
/*  8633 */     this.jCheckBox4.setEnabled(false);
/*  8634 */     this.jCheckBox5.setEnabled(false);
/*  8635 */     this.jButton106.setEnabled(false);
/*  8636 */     this.jTextField116.setEnabled(false);
/*       */     
/*  8638 */     this.jEditorPane1.setEnabled(false);
/*  8639 */     this.materialButton9.setEnabled(false);
/*  8640 */     this.DEPARTAMENTOS.stream().filter(c -> c.equals(this.CAMPOSGENERALES.get("priv"))).forEach(c -> this.materialButton9.setEnabled(true));
/*       */   }
/*       */   
/*       */   public void limpiar() {
/*  8644 */     this.TIPOMANIFIESTO = "";
/*  8645 */     this.jTextField1.setText("");
/*  8646 */     this.jTextField2.setText("");
/*  8647 */     this.jTextField3.setText("");
/*  8648 */     this.jTextField4.setText("");
/*  8649 */     this.jTextField5.setText("");
/*  8650 */     this.jTextField6.setText("");
/*  8651 */     this.jTextField7.setText("");
/*  8652 */     this.jTextField8.setText("");
/*  8653 */     this.jTextField9.setText("");
/*       */ 
/*       */ 
/*       */     
/*  8657 */     this.jDateChooser1.setDate(new Date());
/*       */     
/*  8659 */     this.jTextField10.setText("0");
/*  8660 */     this.jTextField11.setText("");
/*  8661 */     this.jTextField12.setText("");
/*  8662 */     this.jTextField13.setText("");
/*       */     
/*  8664 */     this.jTextField20.setText("0");
/*  8665 */     this.jTextField21.setText("");
/*  8666 */     this.jTextField22.setText("");
/*  8667 */     this.jTextField23.setText("");
/*  8668 */     this.jTextField24.setText("");
/*  8669 */     this.jTextField25.setText("");
/*  8670 */     this.jTextField26.setText("");
/*  8671 */     this.jTextField27.setText("");
/*  8672 */     this.jTextField28.setText("");
/*  8673 */     this.jTextField29.setText("");
/*  8674 */     this.jTextField30.setText("");
/*  8675 */     this.jTextField31.setText("");
/*  8676 */     this.jTextField32.setText("");
/*  8677 */     this.jTextField33.setText("");
/*  8678 */     this.jTextField34.setText("");
/*  8679 */     this.jTextField35.setText("");
/*  8680 */     this.jTextField36.setText("");
/*  8681 */     this.jTextField37.setText("");
/*  8682 */     this.jTextField38.setText("");
/*  8683 */     this.jTextField39.setText("");
/*  8684 */     this.jTextField40.setText("");
/*       */     
/*  8686 */     this.jTextField50.setText("");
/*  8687 */     this.jTextField51.setText("");
/*  8688 */     this.jTextField52.setText("");
/*  8689 */     this.jTextField53.setText("<Por Timbrar>");
/*  8690 */     this.jTextField54.setText("");
/*  8691 */     this.jTextField55.setText("");
/*  8692 */     this.jTextField56.setText("");
/*  8693 */     this.jTextField57.setText("");
/*  8694 */     this.jTextField58.setText("");
/*  8695 */     this.jComboBox50.setSelectedIndex(0);
/*  8696 */     this.jEditorPane1.setText("");
/*       */     
/*  8698 */     LocalDateTime fecha = LocalDateTime.now().plusHours(8L);
/*  8699 */     this.jDateChooser31.setDate(Timestamp.valueOf(fecha));
/*       */     
/*  8701 */     int hh = fecha.getHour();
/*  8702 */     int mm = fecha.getMinute();
/*  8703 */     int ss = fecha.getSecond();
/*       */     
/*  8705 */     String Shh = "" + hh;
/*  8706 */     String Smm = "" + mm;
/*  8707 */     String Sss = "" + ss;
/*  8708 */     if (mm < 10) {
/*  8709 */       Smm = "0" + mm;
/*       */     }
/*  8711 */     if (ss < 10) {
/*  8712 */       Sss = "0" + ss;
/*       */     }
/*  8714 */     if (hh < 10) {
/*  8715 */       Shh = "0" + hh;
/*       */     }
/*  8717 */     this.jSpinner1.setValue(Shh);
/*  8718 */     this.jSpinner2.setValue(Smm);
/*  8719 */     this.jSpinner3.setValue(Sss);
/*       */     
/*  8721 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro1, this.celda2);
/*  8722 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro2, this.celda3);
/*       */     
/*  8724 */     limpiarConcepto();
/*       */   }
/*       */   
/*       */   public void limpiarContenedor() {
/*  8728 */     this.jTextField122.setText("");
/*  8729 */     this.jTextField123.setText("");
/*  8730 */     this.jTextField124.setText("");
/*       */   }
/*       */   
/*       */   public void limpiarConcepto() {
/*  8734 */     this.jTextField101.setText("");
/*  8735 */     this.jTextField102.setText("");
/*  8736 */     this.jTextField103.setText("");
/*  8737 */     this.jTextField104.setText("");
/*  8738 */     this.jTextField105.setText("");
/*  8739 */     this.jTextField106.setText("");
/*  8740 */     this.jTextField107.setText("");
/*  8741 */     this.jFormattedTextField102.setValue(Integer.valueOf(0));
/*  8742 */     this.jFormattedTextField103.setValue(Integer.valueOf(0));
/*  8743 */     this.jTextField109.setText("MXN");
/*  8744 */     this.jTextField110.setText("");
/*  8745 */     this.jTextField111.setText("");
/*  8746 */     this.jTextField112.setText("");
/*  8747 */     this.jTextField113.setText("");
/*  8748 */     this.jTextField114.setText("");
/*  8749 */     this.jTextField115.setText("");
/*  8750 */     this.jTextField116.setText("");
/*       */     
/*  8752 */     this.jFormattedTextField100.setValue(Integer.valueOf(0));
/*  8753 */     this.jFormattedTextField101.setValue(Integer.valueOf(0));
/*  8754 */     this.jEditorPane100.setText("");
/*  8755 */     this.jCheckBox4.setSelected(false);
/*  8756 */     this.jCheckBox4.setEnabled(true);
/*  8757 */     this.jCheckBox5.setSelected(false);
/*  8758 */     this.jButton104.setEnabled(false);
/*  8759 */     this.jButton105.setEnabled(false);
/*  8760 */     this.jButton106.setEnabled(false);
/*       */   }
/*       */   
/*       */   public void llenarOrigenDestinoMercancias() {
/*  8764 */     this.jComboBox100.removeAllItems();
/*  8765 */     this.jComboBox101.removeAllItems();
/*       */     
/*  8767 */     this.ORIGENESDESTINOS.stream().filter(c -> c.getTipo().equals("ORIGEN")).map(c -> c.getId()).forEach(c -> this.jComboBox100.addItem(c));
/*  8768 */     this.ORIGENESDESTINOS.stream().filter(c -> c.getTipo().equals("DESTINO")).map(c -> c.getId()).forEach(c -> this.jComboBox101.addItem(c));
/*       */   }
/*       */   
/*       */   public void verDatos1(String guia) {
/*  8772 */     this.jLabel54.setText(guia);
/*  8773 */     this.jTextField1.setText(guia);
/*  8774 */     String[] cliente = this.con.regresaRegIndex("empresa, rfc, cp, calle, num, col, ciudad", "emp_generadora, llamadas_historicas", "where emp_generadora.clave_gene = llamadas_historicas.clave_gene and llamadas_historicas.num_guia = '" + guia + "'");
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  8780 */     String[] operador = this.con.regresaRegIndex("guias.servicio, guias.folio_imp, guias.operador, tras_cartaporte.op_rfc, tras_cartaporte.op_cp, tras_cartaporte.op_licencia, tras_cartaporte.op_calle, tras_cartaporte.op_num, tras_cartaporte.op_col, tras_cartaporte.op_ciudad, tras_cartaporte.op_estado, tras_cartaporte.op_c_colonia, tras_cartaporte.op_c_municipio, tras_cartaporte.op_c_estado, guias.fecha", "guias, tras_cartaporte", "where guias.num_guia = tras_cartaporte.guia and guias.num_guia = '" + guia + "'");
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  8790 */     this.VEROPERADOR = new String[] { operador[6], operador[7], operador[11], operador[12], operador[13], operador[4], operador[8], operador[9] };
/*       */     
/*  8792 */     this.jDateChooser1.setDate(this.utilerias.convertirFechaStringADate(operador[14]));
/*  8793 */     if (this.TIPO.equals("COPIAR")) {
/*  8794 */       this.jDateChooser1.setDate(new Date());
/*       */     }
/*  8796 */     if (this.materialButton1.getText().equals("Imprimir")) {
/*  8797 */       this.jComboBox1.addItem(cliente[0]);
/*  8798 */       this.jTextField3.setText(cliente[3] + ", " + cliente[3]);
/*  8799 */       this.jTextField4.setText(cliente[5] + ", C.P. " + cliente[5] + ", " + cliente[2]);
/*  8800 */       this.jTextField5.setText(cliente[1]);
/*       */       
/*  8802 */       this.jComboBox2.addItem(operador[0]);
/*  8803 */       this.jTextField2.setText(operador[1]);
/*       */       
/*  8805 */       this.jComboBox3.addItem(operador[2]);
/*  8806 */       this.jTextField6.setText(operador[3]);
/*  8807 */       this.jTextField7.setText(operador[5]);
/*  8808 */       this.jTextField8.setText(operador[6] + ", " + operador[6] + ", " + operador[7] + ", " + operador[8]);
/*  8809 */     } else if (this.materialButton1.getText().equals("Modificar") || this.TIPO.equals("COPIAR")) {
/*  8810 */       this.jComboBox1.setSelectedItem(cliente[0]);
/*  8811 */       this.jTextField3.setText(cliente[3] + ", " + cliente[3]);
/*  8812 */       this.jTextField4.setText(cliente[5] + ", C.P. " + cliente[5] + ", " + cliente[2]);
/*  8813 */       this.jTextField5.setText(cliente[1]);
/*       */       
/*  8815 */       this.jComboBox2.setSelectedItem(operador[0]);
/*  8816 */       this.jTextField2.setText(operador[1]);
/*       */       
/*  8818 */       this.jComboBox3.setSelectedItem(operador[2]);
/*  8819 */       this.jTextField6.setText(operador[3]);
/*  8820 */       this.jTextField7.setText(operador[5]);
/*  8821 */       this.jTextField8.setText(operador[6] + ", " + operador[6] + ", " + operador[7] + ", " + operador[8]);
/*       */     } 
/*       */   }
/*       */   
/*       */   public void verDatos2(String guia) {
/*  8826 */     if (!this.cargado2) {
/*  8827 */       this.cargado2 = true;
/*  8828 */       String[][] origenes = this.con.buscarDatos("clave_gene_desti, tipo_ubic, tipoEstacion, tipoEstacionDesc, id, nombre, rfc, cp, calle, num, col, ciudad, estado, pais, c_colonia, c_municipio, c_estado, fechaHora, distancia, monto, letra, c_localidad, localidad", "tras_cartaporte_ubic", "where guia = '" + guia + "' order by numUbic asc");
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  8833 */       for (String[] origen : origenes) {
/*  8834 */         this.ORIGENESDESTINOS.add(new OrigenesDestinos(origen[0], origen[1], origen[2], origen[3], origen[4], origen[5], origen[6], origen[7], origen[8], origen[9], origen[10], origen[11], origen[12], origen[13], origen[14], origen[15], origen[16], origen[17], origen[18], origen[19], origen[20], origen[21], origen[22]));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8841 */         String[] campos = { origen[1], origen[2] + ".- " + origen[2], origen[4], origen[5], origen[6], origen[7], origen[8], origen[9], origen[10], origen[11], origen[18], origen[17] };
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8855 */         this.utilerias.agregarCampoTablas(campos, (JTable)this.rSTableMetro1);
/*       */       } 
/*  8857 */       this.ORIGENESDESTINOS.stream().filter(x -> x.getTipo().equals("DESTINO")).map(c -> c.getDistancia()).forEach(c -> this.jTextField10.setText(c));
/*  8858 */       String[] equipo = this.con.regresaRegIndex("eq, plat, poz", "llamadas_historicas", "where num_guia ='" + guia + "'");
/*       */       
/*  8860 */       this.jTextField11.setText(equipo[0]);
/*  8861 */       this.jTextField12.setText(equipo[1]);
/*  8862 */       this.jTextField13.setText(equipo[2]);
/*  8863 */       if (!this.jTextField11.getText().equals("") || !this.jTextField12.getText().equals("") || !this.jTextField13.getText().equals("")) {
/*  8864 */         this.jCheckBox1.setSelected(true);
/*  8865 */         if (this.materialButton1.getText().equals("Modificar") || this.TIPO.equals("COPIAR")) {
/*  8866 */           this.jTextField11.setEnabled(true);
/*  8867 */           this.jTextField12.setEnabled(true);
/*  8868 */           this.jTextField13.setEnabled(true);
/*       */         } 
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   public void verDatos3(String guia) {
/*  8875 */     if (!this.cargado3) {
/*  8876 */       this.cargado3 = true;
/*  8877 */       String[][] mercancias = this.con.buscarDatos("cant, claveUnidadSat, claveUnidadSatDesc, claveSTCC, claveSTCCDesc, claveProdSat, claveProdSatDesc, descripcionInterna, dimensiones, peso, valor, moneda, origen, destino, materialPeligroso, claveMaterialPeligroso, descMaterialPeligroso, embalajeClave, embalajeDesc, fraccionArancelaria, fraccionArancelClave, fraccionArancelClaveDesc, uuid, cantTransportada, pesoBruto", "tras_cartaporte_mercancias", "where guia = '" + guia + "' order by num asc");
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  8893 */       for (String[] mercancia : mercancias) {
/*  8894 */         Mercancias m = new Mercancias();
/*       */         
/*  8896 */         m.setCantidad(mercancia[0]);
/*  8897 */         m.setClaveUnidad(mercancia[1]);
/*  8898 */         m.setClaveUnidadDesc(mercancia[2]);
/*  8899 */         m.setClaveSTCC(mercancia[3]);
/*  8900 */         m.setClaveSTCCDesc(mercancia[4]);
/*  8901 */         m.setClaveProd(mercancia[5]);
/*  8902 */         m.setClaveProdDesc(mercancia[6]);
/*  8903 */         m.setDescInterna(mercancia[7]);
/*  8904 */         m.setDimensiones(mercancia[8]);
/*  8905 */         m.setPeso(mercancia[9]);
/*  8906 */         m.setPesoBruto(mercancia[24]);
/*  8907 */         m.setValor(mercancia[10]);
/*  8908 */         m.setMoneda(mercancia[11]);
/*  8909 */         m.setOrigen(mercancia[12]);
/*  8910 */         m.setDestino(mercancia[13]);
/*  8911 */         m.setMatPeligroso(mercancia[14]);
/*  8912 */         m.setClaveMatPeligroso(mercancia[15]);
/*  8913 */         m.setClaveMatPeligrosoDesc(mercancia[16]);
/*  8914 */         m.setClaveEmbalaje(mercancia[17]);
/*  8915 */         m.setClaveEmbalajeDesc(mercancia[18]);
/*  8916 */         m.setArancel(mercancia[19]);
/*  8917 */         m.setClaveAranceles(mercancia[20]);
/*  8918 */         m.setClaveArancelesDesc(mercancia[21]);
/*  8919 */         m.setUUID(mercancia[22]);
/*       */         
/*  8921 */         this.MERCANCIAS.add(m);
/*  8922 */         this.utilerias.agregarCampoTablas(new String[] { m
/*       */               
/*  8924 */               .getCantidad(), m
/*  8925 */               .getClaveUnidad() + " - " + m.getClaveUnidad(), m.claveProd, m
/*       */               
/*  8927 */               .getDescInterna(), m
/*  8928 */               .getDimensiones(), m
/*  8929 */               .getPeso(), m
/*  8930 */               .getValor(), m
/*  8931 */               .getMoneda(), m
/*  8932 */               .getMatPeligroso() + "  " + m.getMatPeligroso(), m
/*  8933 */               .getOrigen(), m
/*  8934 */               .getDestino(), m
/*  8935 */               .getArancel() + "  " + m.getArancel() }, (JTable)this.rSTableMetro2);
/*       */ 
/*       */         
/*  8938 */         this.pesoBruto += Double.parseDouble(m.getPesoBruto());
/*  8939 */         this.pesoNeto += Double.parseDouble(m.getPeso());
/*       */       } 
/*       */       
/*  8942 */       if (!this.TIPO.equals("COPIAR")) {
/*  8943 */         String[][] contenedores = this.con.buscarDatos("matricula, tipo, descripcion, numprecinto", "tras_cartaporte_mercancias_contenedores", "where guia = '" + guia + "'");
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8949 */         int i = 0;
/*  8950 */         for (String[] contenedor : contenedores) {
/*  8951 */           i++;
/*  8952 */           this.LISTACONTENEDORES.put(
/*  8953 */               Integer.valueOf(i), new Contenedores(contenedor[0], contenedor[1], contenedor[3], contenedor[2]));
/*       */         } 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8962 */         if (this.LISTACONTENEDORES.containsKey(Integer.valueOf(1))) {
/*  8963 */           this.jButton110.setText(((Contenedores)this.LISTACONTENEDORES.get(Integer.valueOf(1))).getMatricula());
/*       */         } else {
/*  8965 */           this.jButton110.setEnabled(false);
/*  8966 */           this.materialButton6.setEnabled(false);
/*       */         } 
/*  8968 */         if (this.LISTACONTENEDORES.containsKey(Integer.valueOf(2))) {
/*  8969 */           this.jButton111.setText(((Contenedores)this.LISTACONTENEDORES.get(Integer.valueOf(2))).getMatricula());
/*       */         } else {
/*  8971 */           this.jButton111.setEnabled(false);
/*  8972 */           this.materialButton6.setEnabled(false);
/*       */         } 
/*  8974 */         if (this.LISTACONTENEDORES.containsKey(Integer.valueOf(3))) {
/*  8975 */           this.jButton112.setText(((Contenedores)this.LISTACONTENEDORES.get(Integer.valueOf(3))).getMatricula());
/*       */         } else {
/*  8977 */           this.jButton112.setEnabled(false);
/*  8978 */           this.materialButton6.setEnabled(false);
/*       */         } 
/*       */       } 
/*       */       
/*  8982 */       this.jTextField20.setText("" + this.rSTableMetro2.getRowCount());
/*  8983 */       String[] tipos = this.con.regresaRegIndex("tras_cartaporte.tipoVehiculoF, guias.tipo, pesoVehicular ", "tras_cartaporte, guias ", "where guias.num_guia = tras_cartaporte.guia and guias.num_guia = '" + guia + "'");
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  8988 */       this.jComboBox21.setSelectedItem(tipos[0]);
/*  8989 */       this.jComboBox22.setSelectedItem(tipos[1]);
/*  8990 */       this.jTextField14.setText(tipos[2]);
/*       */       
/*  8992 */       if (!this.TIPO.equals("COPIAR")) {
/*  8993 */         String[][] unidades = this.con.buscarDatos("tipoF, unidad, placa, modelo, poliza, claveSat", "tras_cartaporte_unidades", "where guia ='" + guia + "'");
/*       */         
/*  8995 */         for (String[] unidad : unidades) {
/*  8996 */           if (unidad[0].equals("TRACTO") || unidad[0].equals("UTILITARIO")) {
/*  8997 */             this.jTextField21.setText(unidad[1]);
/*  8998 */             this.jTextField22.setText(unidad[2]);
/*  8999 */             this.jTextField23.setText(unidad[3]);
/*  9000 */             this.jTextField24.setText(unidad[4]);
/*  9001 */             this.jTextField25.setText(unidad[5]);
/*       */           } 
/*  9003 */           if (unidad[0].equals("REMOLQUE1")) {
/*  9004 */             this.jTextField26.setText(unidad[1]);
/*  9005 */             this.jTextField27.setText(unidad[2]);
/*  9006 */             this.jTextField28.setText(unidad[3]);
/*  9007 */             this.jTextField29.setText(unidad[4]);
/*  9008 */             this.jTextField30.setText(unidad[5]);
/*       */           } 
/*  9010 */           if (unidad[0].equals("REMOLQUE2")) {
/*  9011 */             this.jTextField31.setText(unidad[1]);
/*  9012 */             this.jTextField32.setText(unidad[2]);
/*  9013 */             this.jTextField33.setText(unidad[3]);
/*  9014 */             this.jTextField34.setText(unidad[4]);
/*  9015 */             this.jTextField35.setText(unidad[5]);
/*       */           } 
/*       */           
/*  9018 */           if (unidad[0].equals("DOLLY")) {
/*  9019 */             this.jTextField36.setText(unidad[1]);
/*  9020 */             this.jTextField37.setText(unidad[2]);
/*  9021 */             this.jTextField38.setText(unidad[3]);
/*  9022 */             this.jTextField39.setText(unidad[4]);
/*  9023 */             this.jTextField40.setText(unidad[5]);
/*       */           } 
/*       */         } 
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   public void verDatos4(String guia) {
/*  9031 */     if (!this.cargado4) {
/*  9032 */       this.cargado4 = true;
/*  9033 */       String[] datos = this.con.regresaRegIndex("guias.num_vale, vales.ticket, guias.manifiesto, guias.estado, guias.estatus, guias.pedido, guias.factura, guias.prefactura, guias.factimpresa, guias.nombre, llamadas_historicas.descrip", "guias, llamadas_historicas, vales", "where guias.num_guia = llamadas_historicas.num_guia and guias.num_vale = vales.num_vale and guias.num_guia = '" + guia + "'");
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  9049 */       this.jTextField50.setText(datos[0]);
/*  9050 */       this.jTextField51.setText(datos[1]);
/*  9051 */       this.jTextField52.setText(datos[2]);
/*  9052 */       this.jComboBox50.setSelectedItem(datos[3]);
/*  9053 */       this.jTextField53.setText(datos[4]);
/*  9054 */       this.jTextField54.setText(datos[5]);
/*  9055 */       this.jTextField55.setText(datos[6]);
/*  9056 */       this.jTextField56.setText(datos[7]);
/*  9057 */       this.jTextField57.setText(datos[8]);
/*  9058 */       this.jTextField58.setText(datos[9]);
/*  9059 */       this.jEditorPane1.setText(datos[10]);
/*       */     } 
/*       */   }
/*       */   
/*       */   public void sacarMayor() {
/*  9064 */     this.con.consultar("max(num)", "guias", "");
/*  9065 */     String mayor = this.con.Campo;
/*  9066 */     int MAYOR = 0;
/*       */     try {
/*  9068 */       MAYOR = Integer.parseInt(mayor);
/*  9069 */     } catch (NumberFormatException e) {
/*  9070 */       MAYOR = 0;
/*       */     } 
/*  9072 */     MAYOR++;
/*  9073 */     if (MAYOR < 100) {
/*  9074 */       this.jTextField1.setText(this.DIRECTIVA + "-000" + this.DIRECTIVA);
/*  9075 */     } else if (MAYOR < 1000) {
/*  9076 */       this.jTextField1.setText(this.DIRECTIVA + "-00" + this.DIRECTIVA);
/*  9077 */     } else if (MAYOR < 10000) {
/*  9078 */       this.jTextField1.setText(this.DIRECTIVA + "-0" + this.DIRECTIVA);
/*       */     } else {
/*  9080 */       this.jTextField1.setText(this.DIRECTIVA + "-" + this.DIRECTIVA);
/*       */     } 
/*  9082 */     this.jLabel54.setText(this.jTextField1.getText());
/*       */   }
/*       */ 
/*       */   
/*       */   public class Clientes
/*       */   {
/*       */     private String clave_gene;
/*       */     private String nombre;
/*       */     private String rfc;
/*       */     private String cp;
/*       */     private String calle;
/*       */     private String num;
/*       */     private String col;
/*       */     private String ciudad;
/*       */     private String nombreCorto;
/*       */     private String c_localidad;
/*       */     private String localidad;
/*       */     private String sct;
/*       */     
/*       */     public Clientes(String clave_gene, String nombre, String rfc, String cp, String calle, String num, String col, String ciudad, String nombreCorto, String c_localidad, String localidad, String sct) {
/*  9102 */       this.clave_gene = clave_gene;
/*  9103 */       this.nombre = nombre;
/*  9104 */       this.rfc = rfc;
/*  9105 */       this.cp = cp;
/*  9106 */       this.calle = calle;
/*  9107 */       this.num = num;
/*  9108 */       this.col = col;
/*  9109 */       this.ciudad = ciudad;
/*  9110 */       this.nombreCorto = nombreCorto;
/*  9111 */       this.c_localidad = c_localidad;
/*  9112 */       this.localidad = localidad;
/*  9113 */       this.sct = sct;
/*       */     }
/*       */     
/*       */     public String getSct() {
/*  9117 */       return this.sct;
/*       */     }
/*       */     
/*       */     public void setSct(String sct) {
/*  9121 */       this.sct = sct;
/*       */     }
/*       */     
/*       */     public String getC_localidad() {
/*  9125 */       return this.c_localidad;
/*       */     }
/*       */     
/*       */     public void setC_localidad(String c_localidad) {
/*  9129 */       this.c_localidad = c_localidad;
/*       */     }
/*       */     
/*       */     public String getLocalidad() {
/*  9133 */       return this.localidad;
/*       */     }
/*       */     
/*       */     public void setLocalidad(String localidad) {
/*  9137 */       this.localidad = localidad;
/*       */     }
/*       */     
/*       */     public String getClave_gene() {
/*  9141 */       return this.clave_gene;
/*       */     }
/*       */     
/*       */     public void setClave_gene(String clave_gene) {
/*  9145 */       this.clave_gene = clave_gene;
/*       */     }
/*       */     
/*       */     public String getNombre() {
/*  9149 */       return this.nombre;
/*       */     }
/*       */     
/*       */     public void setNombre(String nombre) {
/*  9153 */       this.nombre = nombre;
/*       */     }
/*       */     
/*       */     public String getRfc() {
/*  9157 */       return this.rfc;
/*       */     }
/*       */     
/*       */     public void setRfc(String rfc) {
/*  9161 */       this.rfc = rfc;
/*       */     }
/*       */     
/*       */     public String getCp() {
/*  9165 */       return this.cp;
/*       */     }
/*       */     
/*       */     public void setCp(String cp) {
/*  9169 */       this.cp = cp;
/*       */     }
/*       */     
/*       */     public String getCalle() {
/*  9173 */       return this.calle;
/*       */     }
/*       */     
/*       */     public void setCalle(String calle) {
/*  9177 */       this.calle = calle;
/*       */     }
/*       */     
/*       */     public String getNum() {
/*  9181 */       return this.num;
/*       */     }
/*       */     
/*       */     public void setNum(String num) {
/*  9185 */       this.num = num;
/*       */     }
/*       */     
/*       */     public String getCol() {
/*  9189 */       return this.col;
/*       */     }
/*       */     
/*       */     public void setCol(String col) {
/*  9193 */       this.col = col;
/*       */     }
/*       */     
/*       */     public String getCiudad() {
/*  9197 */       return this.ciudad;
/*       */     }
/*       */     
/*       */     public void setCiudad(String ciudad) {
/*  9201 */       this.ciudad = ciudad;
/*       */     }
/*       */     
/*       */     public String getNombreCorto() {
/*  9205 */       return this.nombreCorto;
/*       */     }
/*       */     
/*       */     public void setNombreCorto(String nombreCorto) {
/*  9209 */       this.nombreCorto = nombreCorto;
/*       */     }
/*       */   }
/*       */   
/*       */   public class Operadores
/*       */   {
/*       */     private String num_ope;
/*       */     private String nombre;
/*       */     private String ap_pat;
/*       */     private String ap_mat;
/*       */     private String calle;
/*       */     private String num;
/*       */     private String col;
/*       */     private String cp;
/*       */     private String ciudad;
/*       */     private String estado;
/*       */     private String c_colonia;
/*       */     private String c_municipio;
/*       */     private String c_estado;
/*       */     private String rfc;
/*       */     private String num_Licen;
/*       */     private String c_localidad;
/*       */     private String localidad;
/*       */     
/*       */     public Operadores(String num_ope, String nombre, String ap_pat, String ap_mat, String calle, String num, String col, String cp, String ciudad, String estado, String c_colonia, String c_municipio, String c_estado, String rfc, String num_Licen, String c_localidad, String localidad) {
/*  9234 */       this.num_ope = num_ope;
/*  9235 */       this.nombre = nombre;
/*  9236 */       this.ap_pat = ap_pat;
/*  9237 */       this.ap_mat = ap_mat;
/*  9238 */       this.calle = calle;
/*  9239 */       this.num = num;
/*  9240 */       this.col = col;
/*  9241 */       this.cp = cp;
/*  9242 */       this.ciudad = ciudad;
/*  9243 */       this.estado = estado;
/*  9244 */       this.c_colonia = c_colonia;
/*  9245 */       this.c_municipio = c_municipio;
/*  9246 */       this.c_estado = c_estado;
/*  9247 */       this.rfc = rfc;
/*  9248 */       this.num_Licen = num_Licen;
/*  9249 */       this.c_localidad = c_localidad;
/*  9250 */       this.localidad = localidad;
/*       */     }
/*       */     
/*       */     public String getC_localidad() {
/*  9254 */       return this.c_localidad;
/*       */     }
/*       */     
/*       */     public void setC_localidad(String c_localidad) {
/*  9258 */       this.c_localidad = c_localidad;
/*       */     }
/*       */     
/*       */     public String getLocalidad() {
/*  9262 */       return this.localidad;
/*       */     }
/*       */     
/*       */     public void setLocalidad(String localidad) {
/*  9266 */       this.localidad = localidad;
/*       */     }
/*       */     
/*       */     public String getNum_ope() {
/*  9270 */       return this.num_ope;
/*       */     }
/*       */     
/*       */     public void setNum_ope(String num_ope) {
/*  9274 */       this.num_ope = num_ope;
/*       */     }
/*       */     
/*       */     public String getNombre() {
/*  9278 */       return this.nombre;
/*       */     }
/*       */     
/*       */     public void setNombre(String nombre) {
/*  9282 */       this.nombre = nombre;
/*       */     }
/*       */     
/*       */     public String getAp_pat() {
/*  9286 */       return this.ap_pat;
/*       */     }
/*       */     
/*       */     public void setAp_pat(String ap_pat) {
/*  9290 */       this.ap_pat = ap_pat;
/*       */     }
/*       */     
/*       */     public String getAp_mat() {
/*  9294 */       return this.ap_mat;
/*       */     }
/*       */     
/*       */     public void setAp_mat(String ap_mat) {
/*  9298 */       this.ap_mat = ap_mat;
/*       */     }
/*       */     
/*       */     public String getCalle() {
/*  9302 */       return this.calle;
/*       */     }
/*       */     
/*       */     public void setCalle(String calle) {
/*  9306 */       this.calle = calle;
/*       */     }
/*       */     
/*       */     public String getNum() {
/*  9310 */       return this.num;
/*       */     }
/*       */     
/*       */     public void setNum(String num) {
/*  9314 */       this.num = num;
/*       */     }
/*       */     
/*       */     public String getCol() {
/*  9318 */       return this.col;
/*       */     }
/*       */     
/*       */     public void setCol(String col) {
/*  9322 */       this.col = col;
/*       */     }
/*       */     
/*       */     public String getCp() {
/*  9326 */       return this.cp;
/*       */     }
/*       */     
/*       */     public void setCp(String cp) {
/*  9330 */       this.cp = cp;
/*       */     }
/*       */     
/*       */     public String getCiudad() {
/*  9334 */       return this.ciudad;
/*       */     }
/*       */     
/*       */     public void setCiudad(String ciudad) {
/*  9338 */       this.ciudad = ciudad;
/*       */     }
/*       */     
/*       */     public String getEstado() {
/*  9342 */       return this.estado;
/*       */     }
/*       */     
/*       */     public void setEstado(String estado) {
/*  9346 */       this.estado = estado;
/*       */     }
/*       */     
/*       */     public String getC_colonia() {
/*  9350 */       return this.c_colonia;
/*       */     }
/*       */     
/*       */     public void setC_colonia(String c_colonia) {
/*  9354 */       this.c_colonia = c_colonia;
/*       */     }
/*       */     
/*       */     public String getC_municipio() {
/*  9358 */       return this.c_municipio;
/*       */     }
/*       */     
/*       */     public void setC_municipio(String c_municipio) {
/*  9362 */       this.c_municipio = c_municipio;
/*       */     }
/*       */     
/*       */     public String getC_estado() {
/*  9366 */       return this.c_estado;
/*       */     }
/*       */     
/*       */     public void setC_estado(String c_estado) {
/*  9370 */       this.c_estado = c_estado;
/*       */     }
/*       */     
/*       */     public String getRfc() {
/*  9374 */       return this.rfc;
/*       */     }
/*       */     
/*       */     public void setRfc(String rfc) {
/*  9378 */       this.rfc = rfc;
/*       */     }
/*       */     
/*       */     public String getNum_Licen() {
/*  9382 */       return this.num_Licen;
/*       */     }
/*       */     
/*       */     public void setNum_Licen(String num_Licen) {
/*  9386 */       this.num_Licen = num_Licen;
/*       */     }
/*       */   }
/*       */   
/*       */   public class OrigenesDestinos
/*       */   {
/*       */     String clave_gene_desti;
/*       */     String tipo;
/*       */     String tipoEst;
/*       */     String tipoEstDesc;
/*       */     String id;
/*       */     String nombre;
/*       */     String rfc;
/*       */     String cp;
/*       */     String calle;
/*       */     String num;
/*       */     String col;
/*       */     String ciudad;
/*       */     String estado;
/*       */     String pais;
/*       */     String c_colonia;
/*       */     String c_municipio;
/*       */     String c_estado;
/*       */     String fechaHora;
/*       */     String distancia;
/*       */     String monto;
/*       */     String letra;
/*       */     String c_localidad;
/*       */     String localidad;
/*       */     
/*       */     public OrigenesDestinos(String clave_gene_desti, String tipo, String tipoEst, String tipoEstDesc, String id, String nombre, String rfc, String cp, String calle, String num, String col, String ciudad, String estado, String pais, String c_colonia, String c_municipio, String c_estado, String fechaHora, String distancia, String monto, String letra, String c_localidad, String localidad) {
/*  9417 */       this.clave_gene_desti = clave_gene_desti;
/*  9418 */       this.tipo = tipo;
/*  9419 */       this.tipoEst = tipoEst;
/*  9420 */       this.tipoEstDesc = tipoEstDesc;
/*  9421 */       this.id = id;
/*  9422 */       this.nombre = nombre;
/*  9423 */       this.rfc = rfc;
/*  9424 */       this.cp = cp;
/*  9425 */       this.calle = calle;
/*  9426 */       this.num = num;
/*  9427 */       this.col = col;
/*  9428 */       this.ciudad = ciudad;
/*  9429 */       this.estado = estado;
/*  9430 */       this.pais = pais;
/*  9431 */       this.c_colonia = c_colonia;
/*  9432 */       this.c_municipio = c_municipio;
/*  9433 */       this.c_estado = c_estado;
/*  9434 */       this.fechaHora = fechaHora;
/*  9435 */       this.distancia = distancia;
/*  9436 */       this.monto = monto;
/*  9437 */       this.letra = letra;
/*  9438 */       this.c_localidad = c_localidad;
/*  9439 */       this.localidad = localidad;
/*       */     }
/*       */     
/*       */     public String getC_localidad() {
/*  9443 */       return this.c_localidad;
/*       */     }
/*       */     
/*       */     public void setC_localidad(String c_localidad) {
/*  9447 */       this.c_localidad = c_localidad;
/*       */     }
/*       */     
/*       */     public String getLocalidad() {
/*  9451 */       return this.localidad;
/*       */     }
/*       */     
/*       */     public void setLocalidad(String localidad) {
/*  9455 */       this.localidad = localidad;
/*       */     }
/*       */     
/*       */     public String getClave_gene_desti() {
/*  9459 */       return this.clave_gene_desti;
/*       */     }
/*       */     
/*       */     public void setClave_gene_desti(String clave_gene_desti) {
/*  9463 */       this.clave_gene_desti = clave_gene_desti;
/*       */     }
/*       */     
/*       */     public String getTipo() {
/*  9467 */       return this.tipo;
/*       */     }
/*       */     
/*       */     public void setTipo(String tipo) {
/*  9471 */       this.tipo = tipo;
/*       */     }
/*       */     
/*       */     public String getTipoEst() {
/*  9475 */       return this.tipoEst;
/*       */     }
/*       */     
/*       */     public void setTipoEst(String tipoEst) {
/*  9479 */       this.tipoEst = tipoEst;
/*       */     }
/*       */     
/*       */     public String getTipoEstDesc() {
/*  9483 */       return this.tipoEstDesc;
/*       */     }
/*       */     
/*       */     public void setTipoEstDesc(String tipoEstDesc) {
/*  9487 */       this.tipoEstDesc = tipoEstDesc;
/*       */     }
/*       */     
/*       */     public String getId() {
/*  9491 */       return this.id;
/*       */     }
/*       */     
/*       */     public void setId(String id) {
/*  9495 */       this.id = id;
/*       */     }
/*       */     
/*       */     public String getNombre() {
/*  9499 */       return this.nombre;
/*       */     }
/*       */     
/*       */     public void setNombre(String nombre) {
/*  9503 */       this.nombre = nombre;
/*       */     }
/*       */     
/*       */     public String getRfc() {
/*  9507 */       return this.rfc;
/*       */     }
/*       */     
/*       */     public void setRfc(String rfc) {
/*  9511 */       this.rfc = rfc;
/*       */     }
/*       */     
/*       */     public String getCp() {
/*  9515 */       return this.cp;
/*       */     }
/*       */     
/*       */     public void setCp(String cp) {
/*  9519 */       this.cp = cp;
/*       */     }
/*       */     
/*       */     public String getCalle() {
/*  9523 */       return this.calle;
/*       */     }
/*       */     
/*       */     public void setCalle(String calle) {
/*  9527 */       this.calle = calle;
/*       */     }
/*       */     
/*       */     public String getNum() {
/*  9531 */       return this.num;
/*       */     }
/*       */     
/*       */     public void setNum(String num) {
/*  9535 */       this.num = num;
/*       */     }
/*       */     
/*       */     public String getCol() {
/*  9539 */       return this.col;
/*       */     }
/*       */     
/*       */     public void setCol(String col) {
/*  9543 */       this.col = col;
/*       */     }
/*       */     
/*       */     public String getCiudad() {
/*  9547 */       return this.ciudad;
/*       */     }
/*       */     
/*       */     public void setCiudad(String ciudad) {
/*  9551 */       this.ciudad = ciudad;
/*       */     }
/*       */     
/*       */     public String getEstado() {
/*  9555 */       return this.estado;
/*       */     }
/*       */     
/*       */     public void setEstado(String estado) {
/*  9559 */       this.estado = estado;
/*       */     }
/*       */     
/*       */     public String getPais() {
/*  9563 */       return this.pais;
/*       */     }
/*       */     
/*       */     public void setPais(String pais) {
/*  9567 */       this.pais = pais;
/*       */     }
/*       */     
/*       */     public String getC_colonia() {
/*  9571 */       return this.c_colonia;
/*       */     }
/*       */     
/*       */     public void setC_colonia(String c_colonia) {
/*  9575 */       this.c_colonia = c_colonia;
/*       */     }
/*       */     
/*       */     public String getC_municipio() {
/*  9579 */       return this.c_municipio;
/*       */     }
/*       */     
/*       */     public void setC_municipio(String c_municipio) {
/*  9583 */       this.c_municipio = c_municipio;
/*       */     }
/*       */     
/*       */     public String getC_estado() {
/*  9587 */       return this.c_estado;
/*       */     }
/*       */     
/*       */     public void setC_estado(String c_estado) {
/*  9591 */       this.c_estado = c_estado;
/*       */     }
/*       */     
/*       */     public String getFechaHora() {
/*  9595 */       return this.fechaHora;
/*       */     }
/*       */     
/*       */     public void setFechaHora(String fechaHora) {
/*  9599 */       this.fechaHora = fechaHora;
/*       */     }
/*       */     
/*       */     public String getDistancia() {
/*  9603 */       return this.distancia;
/*       */     }
/*       */     
/*       */     public void setDistancia(String distancia) {
/*  9607 */       this.distancia = distancia;
/*       */     }
/*       */     
/*       */     public String getMonto() {
/*  9611 */       return this.monto;
/*       */     }
/*       */     
/*       */     public void setMonto(String monto) {
/*  9615 */       this.monto = monto;
/*       */     }
/*       */     
/*       */     public String getLetra() {
/*  9619 */       return this.letra;
/*       */     }
/*       */     
/*       */     public void setLetra(String letra) {
/*  9623 */       this.letra = letra;
/*       */     }
/*       */   }
/*       */   
/*       */   class CeldaRender1
/*       */     extends DefaultTableCellRenderer {
/*  9629 */     int otro = -1;
/*       */     
/*       */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/*  9632 */       setEnabled((table == null || table.isEnabled()));
/*  9633 */       if (row % 2 == 0) {
/*  9634 */         setBackground(GuiasForm.this.lc.FONDOTABLA);
/*       */       } else {
/*  9636 */         setBackground((Color)null);
/*       */       } 
/*  9638 */       if (column == 0 || column == 1 || column == 4 || column == 9) {
/*  9639 */         setHorizontalAlignment(4);
/*       */       } else {
/*  9641 */         setHorizontalAlignment(2);
/*       */       } 
/*       */       
/*  9644 */       setForeground(GuiasForm.this.lc.SECUNDARIO1);
/*  9645 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/*  9646 */       return this;
/*       */     } }
/*       */   
/*       */   class CeldaRender2 extends DefaultTableCellRenderer { int otro;
/*       */     
/*       */     CeldaRender2() {
/*  9652 */       this.otro = -1;
/*       */     }
/*       */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/*  9655 */       setEnabled((table == null || table.isEnabled()));
/*  9656 */       if (row % 2 == 0) {
/*  9657 */         setBackground(GuiasForm.this.lc.FONDOTABLA);
/*       */       } else {
/*  9659 */         setBackground((Color)null);
/*       */       } 
/*  9661 */       if (column == 2 || column == 5 || column == 10) {
/*  9662 */         setHorizontalAlignment(4);
/*       */       } else {
/*  9664 */         setHorizontalAlignment(2);
/*       */       } 
/*       */       
/*  9667 */       setForeground(GuiasForm.this.lc.SECUNDARIO1);
/*  9668 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/*  9669 */       return this;
/*       */     } }
/*       */   
/*       */   class CeldaRender3 extends DefaultTableCellRenderer { int otro;
/*       */     
/*       */     CeldaRender3() {
/*  9675 */       this.otro = -1;
/*       */     }
/*       */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/*  9678 */       setEnabled((table == null || table.isEnabled()));
/*  9679 */       if (row % 2 == 0) {
/*  9680 */         setBackground(GuiasForm.this.lc.FONDOTABLA);
/*       */       } else {
/*  9682 */         setBackground((Color)null);
/*       */       } 
/*  9684 */       if (column == 0 || column == 4 || column == 5 || column == 6) {
/*  9685 */         setHorizontalAlignment(4);
/*       */       } else {
/*  9687 */         setHorizontalAlignment(2);
/*       */       } 
/*       */       
/*  9690 */       setForeground(GuiasForm.this.lc.SECUNDARIO1);
/*  9691 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/*  9692 */       return this;
/*       */     } }
/*       */ 
/*       */   
/*       */   public class Unidades
/*       */   {
/*       */     String tipo;
/*       */     String eco;
/*       */     String placa;
/*       */     String modelo;
/*       */     String poliza;
/*       */     String tipoSat;
/*       */     
/*       */     public Unidades(String tipo, String eco, String placa, String modelo, String poliza, String tipoSat) {
/*  9706 */       this.tipo = tipo;
/*  9707 */       this.eco = eco;
/*  9708 */       this.placa = placa;
/*  9709 */       this.modelo = modelo;
/*  9710 */       this.poliza = poliza;
/*  9711 */       this.tipoSat = tipoSat;
/*       */     }
/*       */     
/*       */     public String getTipo() {
/*  9715 */       return this.tipo;
/*       */     }
/*       */     
/*       */     public void setTipo(String tipo) {
/*  9719 */       this.tipo = tipo;
/*       */     }
/*       */     
/*       */     public String getEco() {
/*  9723 */       return this.eco;
/*       */     }
/*       */     
/*       */     public void setEco(String eco) {
/*  9727 */       this.eco = eco;
/*       */     }
/*       */     
/*       */     public String getPlaca() {
/*  9731 */       return this.placa;
/*       */     }
/*       */     
/*       */     public void setPlaca(String placa) {
/*  9735 */       this.placa = placa;
/*       */     }
/*       */     
/*       */     public String getModelo() {
/*  9739 */       return this.modelo;
/*       */     }
/*       */     
/*       */     public void setModelo(String modelo) {
/*  9743 */       this.modelo = modelo;
/*       */     }
/*       */     
/*       */     public String getPoliza() {
/*  9747 */       return this.poliza;
/*       */     }
/*       */     
/*       */     public void setPoliza(String poliza) {
/*  9751 */       this.poliza = poliza;
/*       */     }
/*       */     
/*       */     public String getTipoSat() {
/*  9755 */       return this.tipoSat;
/*       */     }
/*       */     
/*       */     public void setTipoSat(String tipoSat) {
/*  9759 */       this.tipoSat = tipoSat;
/*       */     }
/*       */   }
/*       */   
/*       */   public class Contenedores
/*       */   {
/*       */     String matricula;
/*       */     String tipo;
/*       */     String precinto;
/*       */     String otro;
/*       */     
/*       */     public Contenedores(String matricula, String tipo, String precinto, String otro) {
/*  9771 */       this.matricula = matricula;
/*  9772 */       this.tipo = tipo;
/*  9773 */       this.precinto = precinto;
/*  9774 */       this.otro = otro;
/*       */     }
/*       */     
/*       */     public String getMatricula() {
/*  9778 */       return this.matricula;
/*       */     }
/*       */     
/*       */     public void setMatricula(String matricula) {
/*  9782 */       this.matricula = matricula;
/*       */     }
/*       */     
/*       */     public String getTipo() {
/*  9786 */       return this.tipo;
/*       */     }
/*       */     
/*       */     public void setTipo(String tipo) {
/*  9790 */       this.tipo = tipo;
/*       */     }
/*       */     
/*       */     public String getPrecinto() {
/*  9794 */       return this.precinto;
/*       */     }
/*       */     
/*       */     public void setPrecinto(String precinto) {
/*  9798 */       this.precinto = precinto;
/*       */     }
/*       */     
/*       */     public String getOtro() {
/*  9802 */       return this.otro;
/*       */     }
/*       */     
/*       */     public void setOtro(String otro) {
/*  9806 */       this.otro = otro;
/*       */     }
/*       */   }
/*       */ 
/*       */   
/*       */   public class Mercancias
/*       */   {
/*       */     String cantidad;
/*       */     
/*       */     String claveUnidad;
/*       */     String claveUnidadDesc;
/*       */     String claveSTCC;
/*       */     String claveSTCCDesc;
/*       */     String claveProd;
/*       */     String claveProdDesc;
/*       */     String descInterna;
/*       */     String dimensiones;
/*       */     String peso;
/*       */     String pesoBruto;
/*       */     String valor;
/*       */     String moneda;
/*       */     String origen;
/*       */     String destino;
/*       */     String matPeligroso;
/*       */     String claveMatPeligroso;
/*       */     String claveMatPeligrosoDesc;
/*       */     String claveEmbalaje;
/*       */     String claveEmbalajeDesc;
/*       */     String arancel;
/*       */     String claveAranceles;
/*       */     String claveArancelesDesc;
/*       */     String UUID;
/*       */     
/*       */     public Mercancias() {}
/*       */     
/*       */     public Mercancias(String cantidad, String claveUnidad, String claveUnidadDesc, String claveSTCC, String claveSTCCDesc, String claveProd, String claveProdDesc, String descInterna, String dimensiones, String peso, String pesoBruto, String valor, String moneda, String origen, String destino, String matPeligroso, String claveMatPeligroso, String claveMatPeligrosoDesc, String claveEmbalaje, String claveEmbalajeDesc, String arancel, String claveAranceles, String claveArancelesDesc, String UUID) {
/*  9842 */       this.cantidad = cantidad;
/*  9843 */       this.claveUnidad = claveUnidad;
/*  9844 */       this.claveUnidadDesc = claveUnidadDesc;
/*  9845 */       this.claveSTCC = claveSTCC;
/*  9846 */       this.claveSTCCDesc = claveSTCCDesc;
/*  9847 */       this.claveProd = claveProd;
/*  9848 */       this.claveProdDesc = claveProdDesc;
/*  9849 */       this.descInterna = descInterna;
/*  9850 */       this.dimensiones = dimensiones;
/*  9851 */       this.peso = peso;
/*  9852 */       this.pesoBruto = pesoBruto;
/*  9853 */       this.valor = valor;
/*  9854 */       this.moneda = moneda;
/*  9855 */       this.origen = origen;
/*  9856 */       this.destino = destino;
/*  9857 */       this.matPeligroso = matPeligroso;
/*  9858 */       this.claveMatPeligroso = claveMatPeligroso;
/*  9859 */       this.claveMatPeligrosoDesc = claveMatPeligrosoDesc;
/*  9860 */       this.claveEmbalaje = claveEmbalaje;
/*  9861 */       this.claveEmbalajeDesc = claveEmbalajeDesc;
/*  9862 */       this.arancel = arancel;
/*  9863 */       this.claveAranceles = claveAranceles;
/*  9864 */       this.claveArancelesDesc = claveArancelesDesc;
/*  9865 */       this.UUID = UUID;
/*       */     }
/*       */     
/*       */     public String getCantidad() {
/*  9869 */       return this.cantidad;
/*       */     }
/*       */     
/*       */     public void setCantidad(String cantidad) {
/*  9873 */       this.cantidad = cantidad;
/*       */     }
/*       */     
/*       */     public String getClaveUnidad() {
/*  9877 */       return this.claveUnidad;
/*       */     }
/*       */     
/*       */     public void setClaveUnidad(String claveUnidad) {
/*  9881 */       this.claveUnidad = claveUnidad;
/*       */     }
/*       */     
/*       */     public String getClaveUnidadDesc() {
/*  9885 */       return this.claveUnidadDesc;
/*       */     }
/*       */     
/*       */     public void setClaveUnidadDesc(String claveUnidadDesc) {
/*  9889 */       this.claveUnidadDesc = claveUnidadDesc;
/*       */     }
/*       */     
/*       */     public String getClaveSTCC() {
/*  9893 */       return this.claveSTCC;
/*       */     }
/*       */     
/*       */     public void setClaveSTCC(String claveSTCC) {
/*  9897 */       this.claveSTCC = claveSTCC;
/*       */     }
/*       */     
/*       */     public String getClaveSTCCDesc() {
/*  9901 */       return this.claveSTCCDesc;
/*       */     }
/*       */     
/*       */     public void setClaveSTCCDesc(String claveSTCCDesc) {
/*  9905 */       this.claveSTCCDesc = claveSTCCDesc;
/*       */     }
/*       */     
/*       */     public String getClaveProd() {
/*  9909 */       return this.claveProd;
/*       */     }
/*       */     
/*       */     public void setClaveProd(String claveProd) {
/*  9913 */       this.claveProd = claveProd;
/*       */     }
/*       */     
/*       */     public String getClaveProdDesc() {
/*  9917 */       return this.claveProdDesc;
/*       */     }
/*       */     
/*       */     public void setClaveProdDesc(String claveProdDesc) {
/*  9921 */       this.claveProdDesc = claveProdDesc;
/*       */     }
/*       */     
/*       */     public String getDescInterna() {
/*  9925 */       return this.descInterna;
/*       */     }
/*       */     
/*       */     public void setDescInterna(String descInterna) {
/*  9929 */       this.descInterna = descInterna;
/*       */     }
/*       */     
/*       */     public String getDimensiones() {
/*  9933 */       return this.dimensiones;
/*       */     }
/*       */     
/*       */     public void setDimensiones(String dimensiones) {
/*  9937 */       this.dimensiones = dimensiones;
/*       */     }
/*       */     
/*       */     public String getPeso() {
/*  9941 */       return this.peso;
/*       */     }
/*       */     
/*       */     public void setPeso(String peso) {
/*  9945 */       this.peso = peso;
/*       */     }
/*       */     
/*       */     public String getPesoBruto() {
/*  9949 */       return this.pesoBruto;
/*       */     }
/*       */     
/*       */     public void setPesoBruto(String pesoBruto) {
/*  9953 */       this.pesoBruto = pesoBruto;
/*       */     }
/*       */     
/*       */     public String getValor() {
/*  9957 */       return this.valor;
/*       */     }
/*       */     
/*       */     public void setValor(String valor) {
/*  9961 */       this.valor = valor;
/*       */     }
/*       */     
/*       */     public String getMoneda() {
/*  9965 */       return this.moneda;
/*       */     }
/*       */     
/*       */     public void setMoneda(String moneda) {
/*  9969 */       this.moneda = moneda;
/*       */     }
/*       */     
/*       */     public String getOrigen() {
/*  9973 */       return this.origen;
/*       */     }
/*       */     
/*       */     public void setOrigen(String origen) {
/*  9977 */       this.origen = origen;
/*       */     }
/*       */     
/*       */     public String getDestino() {
/*  9981 */       return this.destino;
/*       */     }
/*       */     
/*       */     public void setDestino(String destino) {
/*  9985 */       this.destino = destino;
/*       */     }
/*       */     
/*       */     public String getMatPeligroso() {
/*  9989 */       return this.matPeligroso;
/*       */     }
/*       */     
/*       */     public void setMatPeligroso(String matPeligroso) {
/*  9993 */       this.matPeligroso = matPeligroso;
/*       */     }
/*       */     
/*       */     public String getClaveMatPeligroso() {
/*  9997 */       return this.claveMatPeligroso;
/*       */     }
/*       */     
/*       */     public void setClaveMatPeligroso(String claveMatPeligroso) {
/* 10001 */       this.claveMatPeligroso = claveMatPeligroso;
/*       */     }
/*       */     
/*       */     public String getClaveMatPeligrosoDesc() {
/* 10005 */       return this.claveMatPeligrosoDesc;
/*       */     }
/*       */     
/*       */     public void setClaveMatPeligrosoDesc(String claveMatPeligrosoDesc) {
/* 10009 */       this.claveMatPeligrosoDesc = claveMatPeligrosoDesc;
/*       */     }
/*       */     
/*       */     public String getClaveEmbalaje() {
/* 10013 */       return this.claveEmbalaje;
/*       */     }
/*       */     
/*       */     public void setClaveEmbalaje(String claveEmbalaje) {
/* 10017 */       this.claveEmbalaje = claveEmbalaje;
/*       */     }
/*       */     
/*       */     public String getClaveEmbalajeDesc() {
/* 10021 */       return this.claveEmbalajeDesc;
/*       */     }
/*       */     
/*       */     public void setClaveEmbalajeDesc(String claveEmbalajeDesc) {
/* 10025 */       this.claveEmbalajeDesc = claveEmbalajeDesc;
/*       */     }
/*       */     
/*       */     public String getArancel() {
/* 10029 */       return this.arancel;
/*       */     }
/*       */     
/*       */     public void setArancel(String arancel) {
/* 10033 */       this.arancel = arancel;
/*       */     }
/*       */     
/*       */     public String getClaveAranceles() {
/* 10037 */       return this.claveAranceles;
/*       */     }
/*       */     
/*       */     public void setClaveAranceles(String claveAranceles) {
/* 10041 */       this.claveAranceles = claveAranceles;
/*       */     }
/*       */     
/*       */     public String getClaveArancelesDesc() {
/* 10045 */       return this.claveArancelesDesc;
/*       */     }
/*       */     
/*       */     public void setClaveArancelesDesc(String claveArancelesDesc) {
/* 10049 */       this.claveArancelesDesc = claveArancelesDesc;
/*       */     }
/*       */     
/*       */     public String getUUID() {
/* 10053 */       return this.UUID;
/*       */     }
/*       */     
/*       */     public void setUUID(String UUID) {
/* 10057 */       this.UUID = UUID;
/*       */     }
/*       */   }
/*       */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/GuiasForm.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */