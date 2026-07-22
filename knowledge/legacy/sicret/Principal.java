/*       */ package sicret;
/*       */ import java.awt.Color;
/*       */ import java.awt.Component;
/*       */ import java.awt.Cursor;
/*       */ import java.awt.Desktop;
/*       */ import java.awt.Font;
/*       */ import java.awt.Graphics;
/*       */ import java.awt.GridLayout;
/*       */ import java.awt.Image;
/*       */ import java.awt.LayoutManager;
/*       */ import java.awt.event.ActionEvent;
/*       */ import java.awt.event.ActionListener;
/*       */ import java.awt.event.FocusAdapter;
/*       */ import java.awt.event.FocusEvent;
/*       */ import java.awt.event.KeyAdapter;
/*       */ import java.awt.event.KeyEvent;
/*       */ import java.awt.event.MouseAdapter;
/*       */ import java.awt.event.MouseEvent;
/*       */ import java.awt.event.WindowEvent;
/*       */ import java.awt.print.PageFormat;
/*       */ import java.awt.print.PrinterJob;
/*       */ import java.io.BufferedWriter;
/*       */ import java.io.File;
/*       */ import java.io.FileNotFoundException;
/*       */ import java.io.IOException;
/*       */ import java.text.DateFormat;
/*       */ import java.text.SimpleDateFormat;
/*       */ import java.util.Calendar;
/*       */ import java.util.Date;
/*       */ import java.util.logging.Level;
/*       */ import java.util.logging.Logger;
/*       */ import javax.swing.BorderFactory;
/*       */ import javax.swing.ButtonGroup;
/*       */ import javax.swing.GroupLayout;
/*       */ import javax.swing.ImageIcon;
/*       */ import javax.swing.JComponent;
/*       */ import javax.swing.JDialog;
/*       */ import javax.swing.JFrame;
/*       */ import javax.swing.JLabel;
/*       */ import javax.swing.JMenu;
/*       */ import javax.swing.JMenuItem;
/*       */ import javax.swing.JOptionPane;
/*       */ import javax.swing.JPanel;
/*       */ import javax.swing.JPopupMenu;
/*       */ import javax.swing.JRadioButton;
/*       */ import javax.swing.JRadioButtonMenuItem;
/*       */ import javax.swing.JScrollPane;
/*       */ import javax.swing.JSeparator;
/*       */ import javax.swing.JTable;
/*       */ import javax.swing.JTextArea;
/*       */ import javax.swing.JTextField;
/*       */ import javax.swing.LayoutStyle;
/*       */ import javax.swing.event.CaretEvent;
/*       */ import javax.swing.table.DefaultTableModel;
/*       */ import principal.MaterialButton;
/*       */ import rojerusan.RSTableMetro;
/*       */ 
/*       */ public class Principal extends JFrame {
/*    59 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*    60 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*    61 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*    62 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*    63 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*    64 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*    65 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*    66 */   Utilerias utilerias = new Utilerias();
/*    67 */   AltaOperador OperadorA = null;
/*    68 */   OperadoresModifi operadorModifi = null;
/*    69 */   OperadoresBuscar operadorB = null;
/*    70 */   OperadoresEliminar operadorE = null;
/*       */   
/*    72 */   EmpleadosAgregar EmpleadoA = null;
/*    73 */   EmpleadosModifi EmpleadoM = null;
/*    74 */   EmpleadosEliminar EmpleadoE = null;
/*    75 */   EmpleadosBuscar EmpleadoB = null;
/*       */   
/*    77 */   GeneradoraAlta GeneradoraA = null;
/*    78 */   GeneradoraModifi GeneradoraM = null;
/*    79 */   GeneradoraEliminar GeneradoraE = null;
/*    80 */   GeneradoraBuscar GeneradoraB = null;
/*       */   
/*    82 */   DestinatarioAlta DestinatarioA = null;
/*    83 */   DestinatarioModifi DestinatarioM = null;
/*    84 */   DestinatarioEliminar DestinatarioE = null;
/*    85 */   DestinatarioBuscar DestinatarioB = null;
/*       */   
/*    87 */   TractoAgregar TractoA = null;
/*    88 */   TractoModificar TractoM = null;
/*    89 */   TractoEliminar TractoE = null;
/*    90 */   TractoBuscar TractoB = null;
/*       */ 
/*       */   
/*    93 */   UnidadesRemolques unidadesR = null;
/*    94 */   UnidadesTractos unidadesT = null;
/*    95 */   UnidadesDollys unidadesD = null;
/*    96 */   UnidadesUtilitarios unidadesU = null;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*   103 */   AgregarUsuarios UsuarioA = null;
/*   104 */   UsuariosBuscar usuBuscar = null;
/*   105 */   UsuariosEliminar usuEliminar = null;
/*   106 */   bitacora bitacora = null;
/*       */   
/*   108 */   Equipos Equipo = null;
/*   109 */   Plataformas plataforma = null;
/*   110 */   Pozos pozo = null;
/*       */   
/*   112 */   Datos llamada = null;
/*   113 */   ModificarGuias guiasM = null;
/*   114 */   buscarManifiestos manifiestosB = null;
/*   115 */   LlamadasBuscar llamadasB = null;
/*       */   
/*   117 */   weatherford we = null;
/*   118 */   dowell dow = null;
/*       */ 
/*       */   
/*   121 */   qhse reqhse = null;
/*   122 */   Estadisticos estadis = null;
/*   123 */   ValesSeguridad vSeg = null;
/*   124 */   ServiciosRealizados serv = null;
/*   125 */   Prefacturas prefac = null;
/*   126 */   PrefacturaCliente preCliente = null;
/*   127 */   Facturas33 facturas33 = null;
/*       */   
/*   129 */   valesDiesel valeD = null;
/*   130 */   RSP rsp = null;
/*   131 */   Liquidaciones liquidaciones = null;
/*   132 */   TarjetasDeudoras tarDeu = null;
/*   133 */   cajaChica cajaCh = null;
/*   134 */   DieselCompletado dieselComp = null;
/*   135 */   Reseteos reseteos = null;
/*       */   
/*   137 */   Vacaciones vaca = null;
/*   138 */   Aguinaldos aguinaldos = null;
/*   139 */   Finiquitos fini = null;
/*   140 */   Nominas nominas = null;
/*   141 */   NominasComplementos nominasComplementos = null;
/*       */   
/*   143 */   Configuracion config = null;
/*   144 */   TarifaViaje tarifa = null;
/*   145 */   Recepcion recepcion = null;
/*   146 */   Facturas facturas = null;
/*   147 */   TarjetaCliente tarjetaClie = null;
/*   148 */   DepositosClientes depositoC = null;
/*   149 */   ampararFacturas amparar = null;
/*   150 */   Cotizaciones coti = null;
/*   151 */   complementoPagos pagos = null;
/*       */   
/*   153 */   FacturacionPendiente factPen = null;
/*   154 */   Lineas lineas = null;
/*       */   
/*   156 */   ProvCuentasBancarias provCuentasBancarias = null;
/*   157 */   Proveedores proveedores = null;
/*   158 */   ProvTarjetaDeudor provTarjetaDeudor = null;
/*   159 */   ProvFacturas provFacturas = null;
/*   160 */   ProvCheques cheques = null;
/*   161 */   ProvTransferencias transferencias = null;
/*       */ 
/*       */   
/*   164 */   tras_Origenes origenes = null;
/*   165 */   tras_Destinos destinos = null;
/*   166 */   Clientes clientes = null;
/*       */ 
/*       */   
/*   169 */   Compras compras = null;
/*   170 */   AlmCategorias categorias = null;
/*   171 */   AlmProductos productos = null;
/*   172 */   AlmAlmacen almacen = null;
/*       */ 
/*       */ 
/*       */   
/*   176 */   String USUARIO = "kofuz01";
/*   177 */   cargarDatos datos = new cargarDatos("");
/*   178 */   Errores error = new Errores(true);
/*   179 */   Validaciones val = new Validaciones();
/*   180 */   Consultas2 con = new Consultas2();
/*   181 */   int vecesMal = 0;
/*   182 */   String DEPA = "";
/*   183 */   Date fecha = new Date();
/*   184 */   JFrame PADRE = null;
/*   185 */   CargarModulos cargar = null;
/*   186 */   String AvisosComp = "";
/*   187 */   String[] AVISOS = null;
/*       */   boolean encontrado = false;
/*   189 */   CeldaRender celda = new CeldaRender();
/*   190 */   CeldaRender2 celda2 = new CeldaRender2();
/*   191 */   CeldaRender2 celda3 = new CeldaRender2();
/*   192 */   CeldaRender4 celda4 = new CeldaRender4();
/*   193 */   CeldaRender5 celda5 = new CeldaRender5();
/*       */   
/*   195 */   fotoIndividual ind = null;
/*   196 */   String[] DIRECTIVA = null;
/*   197 */   String FOTO = "";
/*       */   
/*   199 */   int DIASVENCIDOS = 0;
/*       */   boolean BLOQUEADO = false;
/*   201 */   MensajePop mensajeTry = null;
/*       */   
/*   203 */   Color colorOriginal = new Color(102, 153, 255);
/*   204 */   Color colorPintar = null;
/*   205 */   Color[] colores = new Color[] { this.colorOriginal, this.colorOriginal, this.colorOriginal, this.colorOriginal, this.colorOriginal, this.colorOriginal, this.colorOriginal, this.colorOriginal, this.colorOriginal, this.colorOriginal, this.colorOriginal, this.colorOriginal, this.colorOriginal, this.colorOriginal, this.colorOriginal, this.colorOriginal, this.colorOriginal, this.colorOriginal, this.colorOriginal, this.colorOriginal };
/*       */   
/*   207 */   String[] estatus = new String[] { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };
/*       */ 
/*       */   
/*   210 */   int contColores = 0; int xy;
/*       */   int xx;
/*   212 */   int ultimoClic = 1;
/*       */   SColores lc;
/*   214 */   Fuentes fuentes = new Fuentes();
/*   215 */   Map<String, String> CAMPOSGENERALES = new TreeMap<>();
/*   216 */   String[] camposTemp = new String[] { "num", "directiva", "folioFacturas", "iva", "retencion", "gastosletra", "gastos", "dieselLetra", "diesel", "dia_info", "renta", "semarnat", "rentaLetra", "fotosOperadores", "fotosEmpleados", "capacitadorQHSE", "nombreCapacitador", "mensaje", "sucursal", "codigoPostal", "contraloria", "factEntrada", "factSalida", "factEntrada33", "diasRepPendientes", "rutaCompTraslado", "aceite", "agua", "rutaAvisos", "rutaAvisos2", "servidorPuerto", "numCertificado", "telefonos", "diasAvisos", "complementoTraslado", "soloFact40", "factEntrada40", "dolar", "tiempoSubirXML", "tiempoSubirXMLComplemento" };
/*       */   
/*       */   EscribirReporte esc;
/*       */   
/*   220 */   Map<String, String> PRIVILEGIOS = new TreeMap<>();
/*   221 */   ArrayList LISTACODIGOS = new ArrayList(); boolean PRIMERAGASTOS = false; private ButtonGroup buttonGroup1; private ButtonGroup buttonGroup2; private ButtonGroup buttonGroup3; private ButtonGroup buttonGroup4; private ButtonGroup buttonGroup5; private CLabel cLabel1; private JButton jButton1; private JComboBox jComboBox2; private JDateChooser jDateChooser1; private JDialog jDialog1; private JDialog jDialog10; private JDialog jDialog11; private JDialog jDialog2; private JDialog jDialog4; private JDialog jDialog5; private JDialog jDialog6; private JDialog jDialog7; private JDialog jDialog8; private JDialog jDialog9; private JFrame jFrame1; private JFrame jFrame2; private JFrame jFrame3; private JFrame jFrame4; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel100; private JLabel jLabel101; private JLabel jLabel102; private JLabel jLabel103; private JLabel jLabel104; private JLabel jLabel105; private JLabel jLabel106; private JLabel jLabel107; private JLabel jLabel108; private JLabel jLabel109; private JLabel jLabel11; private JLabel jLabel110; private JLabel jLabel111; private JLabel jLabel112; private JLabel jLabel113; private JLabel jLabel114; private JLabel jLabel115; private JLabel jLabel116; private JLabel jLabel117; private JLabel jLabel118; private JLabel jLabel119; private JLabel jLabel12; private JLabel jLabel120; private JLabel jLabel121; private JLabel jLabel122; private JLabel jLabel123; private JLabel jLabel124; private JLabel jLabel125; private JLabel jLabel126; private JLabel jLabel127; private JLabel jLabel128; private JLabel jLabel129; private JLabel jLabel13; private JLabel jLabel130; private JLabel jLabel131; private JLabel jLabel132; private JLabel jLabel133; private JLabel jLabel134; private JLabel jLabel135; private JLabel jLabel136; private JLabel jLabel137; private JLabel jLabel138; private JLabel jLabel139; private JLabel jLabel14; private JLabel jLabel140; private JLabel jLabel141; private JLabel jLabel142; private JLabel jLabel143; private JLabel jLabel144; private JLabel jLabel145; private JLabel jLabel146; private JLabel jLabel147; private JLabel jLabel148; private JLabel jLabel149; private JLabel jLabel15; private JLabel jLabel150; private JLabel jLabel151; private JLabel jLabel152; private JLabel jLabel153; private JLabel jLabel154; private JLabel jLabel155; private JLabel jLabel156; private JLabel jLabel157; private JLabel jLabel158; private JLabel jLabel159; private JLabel jLabel16; private JLabel jLabel160; private JLabel jLabel161; private JLabel jLabel163; private JLabel jLabel17; private JLabel jLabel172; private JLabel jLabel173; private JLabel jLabel177; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel45; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel5; private JLabel jLabel50; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54; private JLabel jLabel55; private JLabel jLabel56; private JLabel jLabel57;
/*   222 */   List<Tras_codigos> CODIGOSP = new ArrayList<>(); private JLabel jLabel58; private JLabel jLabel59; private JLabel jLabel6; private JLabel jLabel60; private JLabel jLabel61; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel68; private JLabel jLabel69; private JLabel jLabel7; private JLabel jLabel70; private JLabel jLabel71; private JLabel jLabel72; private JLabel jLabel73; private JLabel jLabel74; private JLabel jLabel75; private JLabel jLabel76; private JLabel jLabel77; private JLabel jLabel78; private JLabel jLabel79; private JLabel jLabel8; private JLabel jLabel80; private JLabel jLabel81; private JLabel jLabel82; private JLabel jLabel83; private JLabel jLabel84; private JLabel jLabel85; private JLabel jLabel86; private JLabel jLabel87; private JLabel jLabel88; private JLabel jLabel89; private JLabel jLabel9; private JLabel jLabel90; private JLabel jLabel91; private JLabel jLabel92; private JLabel jLabel93; private JLabel jLabel94; private JLabel jLabel95; private JLabel jLabel96; private JLabel jLabel97; private JLabel jLabel98; private JLabel jLabel99; private JMenu jMenu1; private JMenu jMenu10; private JMenu jMenu11; private JMenu jMenu12; private JMenu jMenu13; private JMenu jMenu14; private JMenu jMenu15; private JMenu jMenu16; private JMenu jMenu17; private JMenu jMenu18; private JMenu jMenu19; private JMenu jMenu2; private JMenu jMenu3; private JMenu jMenu4; private JMenu jMenu5; private JMenu jMenu6; private JMenu jMenu7; private JMenu jMenu8; private JMenu jMenu9; private JMenuBar jMenuBar1; private JMenuItem jMenuItem1; private JMenuItem jMenuItem10; private JMenuItem jMenuItem11; private JMenuItem jMenuItem12; private JMenuItem jMenuItem13; private JMenuItem jMenuItem14; private JMenuItem jMenuItem15; private JMenuItem jMenuItem16; private JMenuItem jMenuItem17; private JMenuItem jMenuItem18; private JMenuItem jMenuItem19; private JMenuItem jMenuItem2; private JMenuItem jMenuItem20; private JMenuItem jMenuItem21; private JMenuItem jMenuItem22; private JMenuItem jMenuItem23; private JMenuItem jMenuItem24; private JMenuItem jMenuItem25; private JMenuItem jMenuItem26; private JMenuItem jMenuItem27; private JMenuItem jMenuItem28; private JMenuItem jMenuItem29; private JMenuItem jMenuItem3; private JMenuItem jMenuItem30; private JMenuItem jMenuItem31; private JMenuItem jMenuItem32; private JMenuItem jMenuItem33; private JMenuItem jMenuItem34; private JMenuItem jMenuItem35; private JMenuItem jMenuItem36; private JMenuItem jMenuItem37; private JMenuItem jMenuItem38; private JMenuItem jMenuItem39; private JMenuItem jMenuItem4; private JMenuItem jMenuItem40; private JMenuItem jMenuItem41; private JMenuItem jMenuItem42; private JMenuItem jMenuItem43; private JMenuItem jMenuItem44; private JMenuItem jMenuItem45; private JMenuItem jMenuItem46; private JMenuItem jMenuItem47; private JMenuItem jMenuItem48; private JMenuItem jMenuItem49; private JMenuItem jMenuItem5; private JMenuItem jMenuItem50; private JMenuItem jMenuItem51; private JMenuItem jMenuItem52; private JMenuItem jMenuItem53; private JMenuItem jMenuItem54; private JMenuItem jMenuItem55; private JMenuItem jMenuItem56; private JMenuItem jMenuItem57; private JMenuItem jMenuItem58; private JMenuItem jMenuItem59; private JMenuItem jMenuItem6; private JMenuItem jMenuItem60; private JMenuItem jMenuItem61; private JMenuItem jMenuItem62; private JMenuItem jMenuItem63; private JMenuItem jMenuItem64; private JMenuItem jMenuItem65; private JMenuItem jMenuItem66; private JMenuItem jMenuItem67; private JMenuItem jMenuItem68; private JMenuItem jMenuItem69; private JMenuItem jMenuItem7; private JMenuItem jMenuItem70; private JMenuItem jMenuItem71; private JMenuItem jMenuItem72; private JMenuItem jMenuItem74; private JMenuItem jMenuItem76; private JMenuItem jMenuItem8; private JMenuItem jMenuItem9; private JPanel jPanel1; private JPanel jPanel10;
/*       */   private JPanel jPanel100;
/*       */   
/*       */   public Principal() {
/*   226 */     this.PRIVILEGIOS.put("1", "SUPER USUARIO");
/*   227 */     this.PRIVILEGIOS.put("2", "QHSE");
/*   228 */     this.PRIVILEGIOS.put("3", "TRÁFICO");
/*   229 */     this.PRIVILEGIOS.put("4", "ADMINISTRADOR");
/*   230 */     this.lc = new SColores();
/*   231 */     initComponents();
/*       */     
/*   233 */     this.jPanel68.setBounds(0, 35, this.tama.width, 90);
/*   234 */     this.jPanel115.setBounds(0, 30, this.tama.width + 5, 5);
/*   235 */     this.jScrollPane13.getVerticalScrollBar().setUI((ScrollBarUI)new RSScrollBar());
/*   236 */     this.jScrollPane15.getVerticalScrollBar().setUI((ScrollBarUI)new RSScrollBar());
/*   237 */     this.jScrollPane16.getVerticalScrollBar().setUI((ScrollBarUI)new RSScrollBar());
/*   238 */     this.jSplitPane2.setDividerLocation(this.tama.width / 2);
/*   239 */     this.jLabel36.setVisible(false);
/*   240 */     this.mensajeTry = new MensajePop(this);
/*   241 */     this.mensajeTry.actReloj();
/*       */     
/*   243 */     this.AvisosComp = this.con.avisos();
/*       */     
/*   245 */     this.DIRECTIVA = this.con.regresaReg("num, directiva,folioFacturas,iva,retencion,gastosletra,gastos,dieselLetra,diesel,dia_info,renta,semarnat,rentaLetra,fotosOperadores,fotosEmpleados,capacitadorQHSE,nombreCapacitador,mensaje,sucursal,codigoPostal,contraloria,factEntrada,factSalida,factEntrada33,diasRepPendientes,rutaCompTraslado,aceite,agua,rutaAvisos,rutaAvisos2,ServidorPuerto,numCertificado, telefonos, diasAvisos, complementoTraslado, soloFact40, factEntrada40, dolar, tiempoSubirXML, tiempoSubirXMLComplemento", "configuraciones", "where num=1", this.camposTemp.length);
/*   246 */     for (int i = 0; i < this.DIRECTIVA.length; i++) {
/*   247 */       this.CAMPOSGENERALES.put(this.camposTemp[i], this.DIRECTIVA[i]);
/*       */     }
/*       */     
/*   250 */     this.jPanel14.setVisible(false);
/*   251 */     this.jLabel142.setText(this.CAMPOSGENERALES.get("sucursal"));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*   257 */     this.mensajeTry.ruta(this.CAMPOSGENERALES.get("rutaAvisos"), this.CAMPOSGENERALES.get("rutaAvisos2"));
/*   258 */     this.mensajeTry.departamentos(this.AvisosComp);
/*       */     
/*   260 */     (new Esperando()).start();
/*   261 */     (new Reloj()).start();
/*   262 */     this.PADRE = this;
/*   263 */     Image icono = this.tk.getImage(getClass().getResource("LOGO.png"));
/*   264 */     setIconImage(icono);
/*   265 */     icono = this.tk.getImage(getClass().getResource("entrada.png"));
/*       */     
/*   267 */     this.jFrame1.setIconImage(icono);
/*   268 */     int w = this.tama.width;
/*   269 */     int h = this.tama.height;
/*   270 */     int rw = (w - 360) / 2;
/*   271 */     int rh = (h - 400) / 2;
/*   272 */     if (rw > 1100) {
/*   273 */       rw = 800;
/*       */     }
/*   275 */     this.jTextField1.setText(this.con.ultimoUsuario());
/*   276 */     this.jFrame1.setLocation(rw, rh);
/*   277 */     this.jFrame1.setSize(380, 420);
/*   278 */     this.jFrame1.setResizable(false);
/*   279 */     this.jFrame1.setVisible(true);
/*       */     
/*   281 */     rw = (w - 350) / 2;
/*   282 */     rh = (h - 235) / 2;
/*   283 */     this.jDialog1.setLocation(rw, rh);
/*   284 */     this.jDialog1.setSize(370, 225);
/*       */     
/*   286 */     rw = (w - 765) / 2;
/*   287 */     rh = (h - 315) / 2;
/*   288 */     this.jDialog4.setLocation(rw, rh);
/*   289 */     this.jDialog4.setResizable(false);
/*   290 */     this.jDialog4.setSize(765, 315);
/*       */     
/*   292 */     rw = (w - 400) / 2;
/*   293 */     rh = (h - 470) / 2;
/*   294 */     this.jDialog5.setLocation(rw, rh);
/*   295 */     this.jDialog5.setSize(400, 370);
/*   296 */     this.jDialog5.setVisible(false);
/*   297 */     this.jDialog5.setResizable(false);
/*       */     
/*   299 */     rw = (w - 410) / 2;
/*   300 */     rh = (h - 310) / 2;
/*   301 */     this.jDialog6.setLocation(rw, rh);
/*   302 */     this.jDialog6.setSize(410, 310);
/*   303 */     this.jDialog6.setVisible(false);
/*   304 */     this.jDialog6.setResizable(false);
/*       */     
/*   306 */     rw = (w - 680) / 2;
/*   307 */     rh = (h - 252) / 2;
/*   308 */     this.jDialog8.setLocation(rw, rh);
/*   309 */     this.jDialog8.setSize(680, 252);
/*   310 */     this.jDialog8.setVisible(false);
/*   311 */     this.jDialog8.setResizable(false);
/*       */     
/*   313 */     rw = (w - 500) / 2;
/*   314 */     rh = (h - 120) / 2;
/*   315 */     this.jDialog7.setLocation(rw, rh);
/*   316 */     this.jDialog7.setSize(500, 110);
/*   317 */     this.jDialog7.setVisible(false);
/*   318 */     this.jDialog7.setResizable(false);
/*       */     
/*   320 */     rw = (w - 750) / 2;
/*   321 */     rh = (h - 390) / 2;
/*   322 */     this.jDialog9.setLocation(rw, rh);
/*   323 */     this.jDialog9.setSize(750, 390);
/*   324 */     this.jDialog9.setVisible(false);
/*   325 */     this.jDialog9.setResizable(false);
/*       */     
/*   327 */     rw = (w - 600) / 2;
/*   328 */     rh = (h - 300) / 2;
/*   329 */     this.jDialog2.setLocation(rw, rh);
/*   330 */     this.jDialog2.setSize(600, 280);
/*   331 */     this.jDialog2.setVisible(false);
/*       */     
/*   333 */     rw = (w - 750) / 2;
/*   334 */     rh = (h - 510) / 2;
/*   335 */     this.jDialog10.setLocation(rw, rh);
/*   336 */     this.jDialog10.setSize(750, 500);
/*   337 */     this.jDialog10.setVisible(false);
/*   338 */     this.jDialog10.setResizable(false);
/*       */     
/*   340 */     this.utilerias.activarVentanajDialog(this.jDialog11, 790, 375);
/*       */     
/*   342 */     colorear();
/*   343 */     cargarMouse();
/*   344 */     setExtendedState(6);
/*       */     
/*   346 */     this.cargar = new CargarModulos();
/*   347 */     this.cargar.start();
/*       */     
/*   349 */     this.buttonGroup1.add(this.jRadioButton1);
/*   350 */     this.buttonGroup1.add(this.jRadioButton2);
/*       */     
/*   352 */     this.buttonGroup2.add(this.jRadioButton3);
/*   353 */     this.buttonGroup2.add(this.jRadioButton4);
/*       */     
/*   355 */     this.buttonGroup5.add(this.jRadioButtonMenuItem1);
/*   356 */     this.buttonGroup5.add(this.jRadioButtonMenuItem2);
/*   357 */     this.buttonGroup5.add(this.jRadioButtonMenuItem3);
/*   358 */     if (this.lc.TIPOCOLOR.equals("ROJO")) {
/*   359 */       this.jRadioButtonMenuItem1.setSelected(true);
/*   360 */     } else if (this.lc.TIPOCOLOR.equals("VERDE")) {
/*   361 */       this.jRadioButtonMenuItem2.setSelected(true);
/*   362 */     } else if (this.lc.TIPOCOLOR.equals("AZUL")) {
/*   363 */       this.jRadioButtonMenuItem3.setSelected(true);
/*       */     } 
/*       */     
/*   366 */     this.jPanel113.setComponentPopupMenu(this.jPopupMenu1);
/*   367 */     this.jMenuBar1.setVisible(false);
/*       */     
/*   369 */     this.jMenuBar1.setComponentPopupMenu(this.jPopupMenu2);
/*   370 */     this.jLabel57.setText("<html>Sucursal: <b>" + (String)this.CAMPOSGENERALES.get("sucursal") + " </b></html>");
/*       */     
/*   372 */     String sDirectorio = "Archivos";
/*   373 */     File f = new File(sDirectorio);
/*       */     
/*   375 */     File[] ficheros = f.listFiles();
/*   376 */     for (File imagen : ficheros) {
/*       */       try {
/*   378 */         if (imagen.getAbsolutePath().contains(".png")) {
/*   379 */           boolean bool = imagen.delete();
/*       */         }
/*   381 */       } catch (Exception e) {
/*   382 */         System.out.println(e);
/*       */       } 
/*       */     } 
/*       */     
/*   386 */     this.jButton1.setVisible(false);
/*       */   }
/*       */   private JPanel jPanel101; private JPanel jPanel102; private JPanel jPanel103; private JPanel jPanel104; private JPanel jPanel105; private JPanel jPanel106; private JPanel jPanel107; private JPanel jPanel108; private JPanel jPanel109; private JPanel jPanel11; private JPanel jPanel110; private JPanel jPanel111; private JPanel jPanel112; private JPanel jPanel113; private JPanel jPanel114; private JPanel jPanel115; private JPanel jPanel116; private JPanel jPanel117; private JPanel jPanel118; private JPanel jPanel119; private JPanel jPanel12; private JPanel jPanel120; private JPanel jPanel121; private JPanel jPanel122; private JPanel jPanel123; private JPanel jPanel124; private JPanel jPanel125; private JPanel jPanel126; private JPanel jPanel127; private JPanel jPanel128; private JPanel jPanel129; private JPanel jPanel13; private JPanel jPanel130; private JPanel jPanel131; private JPanel jPanel132; private JPanel jPanel133; private JPanel jPanel134; private JPanel jPanel135; private JPanel jPanel136; private JPanel jPanel137; private JPanel jPanel138; private JPanel jPanel139; private JPanel jPanel14; private JPanel jPanel140; private JPanel jPanel141; private JPanel jPanel142; private JPanel jPanel143; private JPanel jPanel144; private JPanel jPanel145; private JPanel jPanel146; private JPanel jPanel147; private JPanel jPanel148; private JPanel jPanel149; private JPanel jPanel15; private JPanel jPanel150; private JPanel jPanel151; private JPanel jPanel152; private JPanel jPanel153; private JPanel jPanel154; private JPanel jPanel155; private JPanel jPanel156; private JPanel jPanel157; private JPanel jPanel158; private JPanel jPanel159; private JPanel jPanel16; private JPanel jPanel160; private JPanel jPanel161; private JPanel jPanel162; private JPanel jPanel163; private JPanel jPanel164; private JPanel jPanel165; private JPanel jPanel166; private JPanel jPanel167; private JPanel jPanel168; private JPanel jPanel169; private JPanel jPanel17; private JPanel jPanel170; private JPanel jPanel171; private JPanel jPanel172; private JPanel jPanel173; private JPanel jPanel174; private JPanel jPanel175; private JPanel jPanel176; private JPanel jPanel177; private JPanel jPanel178; private JPanel jPanel179; private JPanel jPanel18; private JPanel jPanel180; private JPanel jPanel181; private JPanel jPanel182; private JPanel jPanel183; private JPanel jPanel184; private JPanel jPanel185; private JPanel jPanel186; private JPanel jPanel187; private JPanel jPanel188; private JPanel jPanel189; private JPanel jPanel19; private JPanel jPanel190; private JPanel jPanel191; private JPanel jPanel192; private JPanel jPanel193; private JPanel jPanel194; private JPanel jPanel195; private JPanel jPanel196; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel200; private JPanel jPanel202; private JPanel jPanel204; private JPanel jPanel205; private JPanel jPanel206; private JPanel jPanel207; private JPanel jPanel208; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel23; private JPanel jPanel24; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel27; private JPanel jPanel28; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel30; private JPanel jPanel31; private JPanel jPanel32; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel35; private JPanel jPanel36; private JPanel jPanel37; private JPanel jPanel38; private JPanel jPanel39; private JPanel jPanel4; private JPanel jPanel40; private JPanel jPanel41; private JPanel jPanel42; private JPanel jPanel43; private JPanel jPanel44; private JPanel jPanel45; private JPanel jPanel46; private JPanel jPanel47; private JPanel jPanel48; private JPanel jPanel49; private JPanel jPanel5; private JPanel jPanel50; private JPanel jPanel51; private JPanel jPanel52; private JPanel jPanel53; private JPanel jPanel54; private JPanel jPanel55; private JPanel jPanel56; private JPanel jPanel57; private JPanel jPanel58; private JPanel jPanel59; private JPanel jPanel6; private JPanel jPanel60; private JPanel jPanel61; private JPanel jPanel62; private JPanel jPanel63; private JPanel jPanel64; private JPanel jPanel65; private JPanel jPanel66; private JPanel jPanel67; private JPanel jPanel68; private JPanel jPanel69; private JPanel jPanel7; private JPanel jPanel70; private JPanel jPanel71; private JPanel jPanel72; private JPanel jPanel73; private JPanel jPanel74; private JPanel jPanel75; private JPanel jPanel76; private JPanel jPanel77; private JPanel jPanel78; private JPanel jPanel79; private JPanel jPanel8; private JPanel jPanel80; private JPanel jPanel81; private JPanel jPanel82; private JPanel jPanel83; private JPanel jPanel84; private JPanel jPanel85; private JPanel jPanel86; private JPanel jPanel87; private JPanel jPanel88; private JPanel jPanel89; private JPanel jPanel9; private JPanel jPanel90; private JPanel jPanel91; private JPanel jPanel92; private JPanel jPanel93; private JPanel jPanel94; private JPanel jPanel95; private JPanel jPanel96; private JPanel jPanel97; private JPanel jPanel98; private JPanel jPanel99; private JPasswordField jPasswordField1; private JPasswordField jPasswordField2; private JPasswordField jPasswordField3; private JPopupMenu jPopupMenu1; private JPopupMenu jPopupMenu2; private JProgressBar jProgressBar1; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JRadioButton jRadioButton3; private JRadioButton jRadioButton4; private JRadioButtonMenuItem jRadioButtonMenuItem1; private JRadioButtonMenuItem jRadioButtonMenuItem2; private JRadioButtonMenuItem jRadioButtonMenuItem3; private JScrollPane jScrollPane1; private JScrollPane jScrollPane10; private JScrollPane jScrollPane11; private JScrollPane jScrollPane12; private JScrollPane jScrollPane13; private JScrollPane jScrollPane14; private JScrollPane jScrollPane15; private JScrollPane jScrollPane16; private JScrollPane jScrollPane33; private JScrollPane jScrollPane7; private JScrollPane jScrollPane9; private JSeparator jSeparator10; private JSeparator jSeparator11; private JSeparator jSeparator12; private JPopupMenu.Separator jSeparator13; private JSeparator jSeparator14; private JPopupMenu.Separator jSeparator15; private JPopupMenu.Separator jSeparator16; private JPopupMenu.Separator jSeparator17; private JPopupMenu.Separator jSeparator18; private JPopupMenu.Separator jSeparator19; private JPopupMenu.Separator jSeparator20; private JSeparator jSeparator21; private JSeparator jSeparator22; private JSeparator jSeparator5; private JSeparator jSeparator7; private JSeparator jSeparator9; private JSplitPane jSplitPane2; private JTabbedPane jTabbedPane2; private JTextArea jTextArea2; private JTextArea jTextArea3; private JTextArea jTextArea4; private JTextArea jTextArea5; private JTextField jTextField1; private JTextField jTextField2; private JTextField jTextField3; private MaterialButton materialButton1; private MaterialButton materialButton10; private MaterialButton materialButton11; private MaterialButton materialButton12; private MaterialButton materialButton13; private MaterialButton materialButton14; private MaterialButton materialButton15; private MaterialButton materialButton16; private MaterialButton materialButton17; private MaterialButton materialButton18; private MaterialButton materialButton19; private MaterialButton materialButton2; private MaterialButton materialButton20; private MaterialButton materialButton3; private MaterialButton materialButton38; private MaterialButton materialButton39; private MaterialButton materialButton4; private MaterialButton materialButton40; private MaterialButton materialButton5; private MaterialButton materialButton6; private MaterialButton materialButton7; private MaterialButton materialButton8; private MaterialButton materialButton9; private MaterialComboBox materialComboBox1; private MaterialFormattedTextField materialFormattedTextField1;
/*       */   private MaterialPasswordField materialPasswordField1;
/*       */   private MaterialProgressSpinner materialProgressSpinner1;
/*       */   private MaterialTextField materialTextField1;
/*       */   private MetroTextBox metroTextBox1;
/*       */   private MetroTextBox metroTextBox2;
/*       */   private RSTableMetro rSTableMetro1;
/*       */   private RSTableMetro rSTableMetro2;
/*       */   private RSTableMetro rSTableMetro3;
/*       */   private RSTableMetro rSTableMetro4;
/*       */   private RSTableMetro rSTableMetro5;
/*       */   private RSTableMetro rSTableMetro6;
/*       */   private ToastBar toastBar1;
/*       */   
/*       */   private void initComponents() {
/*   403 */     this.jFrame1 = new JFrame();
/*   404 */     this.jPanel48 = new JPanel();
/*   405 */     this.jPanel49 = new JPanel();
/*   406 */     this.jLabel41 = new JLabel();
/*   407 */     this.jLabel42 = new JLabel();
/*   408 */     this.jLabel43 = new JLabel();
/*   409 */     this.jLabel15 = new JLabel();
/*   410 */     this.jPanel50 = new JPanel();
/*   411 */     this.jPanel51 = new JPanel();
/*   412 */     this.jLabel44 = new JLabel();
/*   413 */     this.jLabel45 = new JLabel();
/*   414 */     this.jLabel46 = new JLabel();
/*   415 */     this.jPasswordField1 = new JPasswordField();
/*   416 */     this.jTextField1 = new JTextField();
/*   417 */     this.materialButton5 = new MaterialButton();
/*   418 */     this.jProgressBar1 = new JProgressBar();
/*   419 */     this.jLabel8 = new JLabel();
/*   420 */     this.jFrame2 = new JFrame();
/*   421 */     this.jPanel30 = new JPanel();
/*   422 */     this.jSeparator5 = new JSeparator();
/*   423 */     this.jPanel31 = new JPanel();
/*   424 */     this.jRadioButton1 = new JRadioButton();
/*   425 */     this.jRadioButton2 = new JRadioButton();
/*   426 */     this.materialButton3 = new MaterialButton();
/*   427 */     this.materialButton4 = new MaterialButton();
/*   428 */     this.materialButton7 = new MaterialButton();
/*   429 */     this.materialButton6 = new MaterialButton();
/*   430 */     this.materialButton8 = new MaterialButton();
/*   431 */     this.materialButton9 = new MaterialButton();
/*   432 */     this.jSplitPane2 = new JSplitPane();
/*   433 */     this.jScrollPane15 = new JScrollPane();
/*   434 */     this.rSTableMetro5 = new RSTableMetro();
/*   435 */     this.jScrollPane16 = new JScrollPane();
/*   436 */     this.rSTableMetro6 = new RSTableMetro();
/*   437 */     this.jLabel23 = new JLabel();
/*   438 */     this.jLabel24 = new JLabel();
/*   439 */     this.jLabel25 = new JLabel();
/*   440 */     this.materialButton2 = new MaterialButton();
/*   441 */     this.jFrame3 = new JFrame();
/*   442 */     this.jPanel166 = new JPanel();
/*   443 */     this.materialButton1 = new MaterialButton();
/*   444 */     this.materialComboBox1 = new MaterialComboBox();
/*   445 */     this.materialFormattedTextField1 = new MaterialFormattedTextField();
/*   446 */     this.materialTextField1 = new MaterialTextField();
/*   447 */     this.toastBar1 = new ToastBar();
/*   448 */     this.materialProgressSpinner1 = new MaterialProgressSpinner();
/*   449 */     this.materialPasswordField1 = new MaterialPasswordField();
/*   450 */     this.jFrame4 = new JFrame();
/*   451 */     this.jPanel29 = new JPanel();
/*   452 */     this.jPanel39 = new JPanel();
/*   453 */     this.jPanel40 = new JPanel();
/*   454 */     this.jPanel41 = new JPanel();
/*   455 */     this.jPanel47 = new JPanel();
/*   456 */     this.jPanel52 = new JPanel();
/*   457 */     this.jPanel56 = new JPanel();
/*   458 */     this.jPanel153 = new JPanel();
/*   459 */     this.jPanel157 = new JPanel();
/*   460 */     this.jPanel158 = new JPanel();
/*   461 */     this.jPanel159 = new JPanel();
/*   462 */     this.jPanel160 = new JPanel();
/*   463 */     this.jPanel161 = new JPanel();
/*   464 */     this.jPanel162 = new JPanel();
/*   465 */     this.jPanel163 = new JPanel();
/*   466 */     this.jPanel164 = new JPanel();
/*   467 */     this.jPanel165 = new JPanel();
/*   468 */     this.jDialog1 = new JDialog(this.jFrame1);
/*   469 */     this.jPanel23 = new JPanel();
/*   470 */     this.jLabel19 = new JLabel();
/*   471 */     this.jPanel11 = new JPanel();
/*   472 */     this.jLabel20 = new JLabel();
/*   473 */     this.jPasswordField2 = new JPasswordField();
/*   474 */     this.jLabel21 = new JLabel();
/*   475 */     this.jPasswordField3 = new JPasswordField();
/*   476 */     this.materialButton10 = new MaterialButton();
/*   477 */     this.materialButton11 = new MaterialButton();
/*   478 */     this.jLabel10 = new JLabel();
/*   479 */     this.jDialog2 = new CerrarVentana(this.jFrame2);
/*   480 */     this.jPanel42 = new JPanel();
/*   481 */     this.jPanel46 = new JPanel();
/*   482 */     this.jLabel33 = new JLabel();
/*   483 */     this.jLabel35 = new JLabel();
/*   484 */     this.jSeparator14 = new JSeparator();
/*   485 */     this.jLabel37 = new JLabel();
/*   486 */     this.jLabel32 = new JLabel();
/*   487 */     this.jLabel38 = new JLabel();
/*   488 */     this.jLabel39 = new JLabel();
/*   489 */     this.jLabel40 = new JLabel();
/*   490 */     this.jDialog4 = new CerrarVentana(this);
/*   491 */     this.jPanel28 = new JPanel();
/*   492 */     this.jPanel13 = new JPanel();
/*   493 */     this.jScrollPane12 = new JScrollPane();
/*   494 */     this.rSTableMetro2 = new RSTableMetro();
/*   495 */     this.jPanel20 = new JPanel();
/*   496 */     this.jLabel16 = new JLabel();
/*   497 */     this.jPanel21 = new JPanel();
/*   498 */     this.jPanel22 = new JPanel();
/*   499 */     this.jPanel24 = new JPanel();
/*   500 */     this.jLabel17 = new JLabel();
/*   501 */     this.jPanel26 = new JPanel();
/*   502 */     this.cLabel1 = new CLabel();
/*   503 */     this.jPanel18 = new JPanel();
/*   504 */     this.jLabel22 = new JLabel();
/*   505 */     this.jLabel7 = new JLabel();
/*   506 */     this.materialButton12 = new MaterialButton();
/*   507 */     this.materialButton13 = new MaterialButton();
/*   508 */     this.jDialog5 = new CerrarVentana(this.jFrame2);
/*   509 */     this.jPanel32 = new JPanel();
/*   510 */     this.jLabel58 = new JLabel();
/*   511 */     this.jLabel61 = new JLabel();
/*   512 */     this.materialButton14 = new MaterialButton();
/*   513 */     this.materialButton15 = new MaterialButton();
/*   514 */     this.jScrollPane13 = new JScrollPane();
/*   515 */     this.rSTableMetro3 = new RSTableMetro();
/*   516 */     this.metroTextBox1 = new MetroTextBox();
/*   517 */     this.metroTextBox2 = new MetroTextBox();
/*   518 */     this.jDialog8 = new CerrarVentana(this.jFrame2);
/*   519 */     this.jPanel33 = new JPanel();
/*   520 */     this.jLabel97 = new JLabel();
/*   521 */     this.jSeparator9 = new JSeparator();
/*   522 */     this.jLabel98 = new JLabel();
/*   523 */     this.jLabel99 = new JLabel();
/*   524 */     this.jLabel100 = new JLabel();
/*   525 */     this.jSeparator10 = new JSeparator();
/*   526 */     this.materialButton16 = new MaterialButton();
/*   527 */     this.jDialog6 = new CerrarVentana(this.jFrame2);
/*   528 */     this.jPanel34 = new JPanel();
/*   529 */     this.jScrollPane7 = new JScrollPane();
/*   530 */     this.jTextArea2 = new JTextArea();
/*   531 */     this.jLabel26 = new JLabel();
/*   532 */     this.jComboBox2 = new JComboBox();
/*   533 */     this.jLabel29 = new JLabel();
/*   534 */     this.jScrollPane10 = new JScrollPane();
/*   535 */     this.jTextArea4 = new JTextArea();
/*   536 */     this.jSeparator11 = new JSeparator();
/*   537 */     this.materialButton17 = new MaterialButton();
/*   538 */     this.materialButton18 = new MaterialButton();
/*   539 */     this.jDialog7 = new CerrarVentana(this.jFrame2);
/*   540 */     this.jPanel35 = new JPanel();
/*   541 */     this.jRadioButton3 = new JRadioButton();
/*   542 */     this.jTextField2 = new JTextField();
/*   543 */     this.jTextField3 = new JTextField();
/*   544 */     this.jSeparator7 = new JSeparator();
/*   545 */     this.jRadioButton4 = new JRadioButton();
/*   546 */     this.materialButton19 = new MaterialButton();
/*   547 */     this.jDialog9 = new CerrarVentana(this.jFrame2);
/*   548 */     this.jPanel37 = new JPanel();
/*   549 */     this.jPanel1 = new JPanel();
/*   550 */     this.jScrollPane14 = new JScrollPane();
/*   551 */     this.rSTableMetro4 = new RSTableMetro();
/*   552 */     this.jPanel9 = new JPanel();
/*   553 */     this.jLabel27 = new JLabel();
/*   554 */     this.jPanel7 = new JPanel();
/*   555 */     this.jPanel12 = new JPanel();
/*   556 */     this.jScrollPane9 = new JScrollPane();
/*   557 */     this.jTextArea3 = new JTextArea();
/*   558 */     this.materialButton20 = new MaterialButton();
/*   559 */     this.jDialog10 = new CerrarVentana(this.jFrame2);
/*   560 */     this.jPanel38 = new JPanel();
/*   561 */     this.jLabel89 = new JLabel();
/*   562 */     this.jSeparator12 = new JSeparator();
/*   563 */     this.jLabel30 = new JLabel();
/*   564 */     this.jLabel31 = new JLabel();
/*   565 */     this.jLabel34 = new JLabel();
/*   566 */     this.jScrollPane11 = new JScrollPane();
/*   567 */     this.jTextArea5 = new JTextArea();
/*   568 */     this.jLabel52 = new JLabel();
/*   569 */     this.jLabel51 = new JLabel();
/*   570 */     this.jLabel53 = new JLabel();
/*   571 */     this.jLabel104 = new JLabel();
/*   572 */     this.jLabel105 = new JLabel();
/*   573 */     this.jPanel57 = new JPanel();
/*   574 */     this.jPanel66 = new JPanel();
/*   575 */     this.jPanel139 = new JPanel();
/*   576 */     this.jPanel142 = new JPanel();
/*   577 */     this.jPanel140 = new JPanel();
/*   578 */     this.jLabel135 = new JLabel();
/*   579 */     this.jPanel141 = new JPanel();
/*   580 */     this.jLabel136 = new JLabel();
/*   581 */     this.jPanel143 = new JPanel();
/*   582 */     this.jPanel146 = new JPanel();
/*   583 */     this.jLabel138 = new JLabel();
/*   584 */     this.jPanel145 = new JPanel();
/*   585 */     this.jLabel137 = new JLabel();
/*   586 */     this.jPanel144 = new JPanel();
/*   587 */     this.jPanel148 = new JPanel();
/*   588 */     this.jLabel139 = new JLabel();
/*   589 */     this.jPanel149 = new JPanel();
/*   590 */     this.jLabel140 = new JLabel();
/*   591 */     this.jPanel147 = new JPanel();
/*   592 */     this.jPanel150 = new JPanel();
/*   593 */     this.jLabel141 = new JLabel();
/*   594 */     this.jPanel151 = new JPanel();
/*   595 */     this.jPanel154 = new JPanel();
/*   596 */     this.jLabel144 = new JLabel();
/*   597 */     this.jPanel155 = new JPanel();
/*   598 */     this.jLabel145 = new JLabel();
/*   599 */     this.jPanel156 = new JPanel();
/*   600 */     this.jLabel146 = new JLabel();
/*   601 */     this.jPanel5 = new JPanel();
/*   602 */     this.jPanel77 = new JPanel();
/*   603 */     this.jLabel69 = new JLabel();
/*   604 */     this.jPanel78 = new JPanel();
/*   605 */     this.jLabel70 = new JLabel();
/*   606 */     this.jPanel79 = new JPanel();
/*   607 */     this.jLabel71 = new JLabel();
/*   608 */     this.jPanel80 = new JPanel();
/*   609 */     this.jLabel72 = new JLabel();
/*   610 */     this.jPanel4 = new JPanel();
/*   611 */     this.jPanel60 = new JPanel();
/*   612 */     this.jLabel65 = new JLabel();
/*   613 */     this.jPanel61 = new JPanel();
/*   614 */     this.jLabel66 = new JLabel();
/*   615 */     this.jPanel62 = new JPanel();
/*   616 */     this.jLabel67 = new JLabel();
/*   617 */     this.jPanel67 = new JPanel();
/*   618 */     this.jLabel68 = new JLabel();
/*   619 */     this.jPanel69 = new JPanel();
/*   620 */     this.jPanel110 = new JPanel();
/*   621 */     this.jPanel117 = new JPanel();
/*   622 */     this.jLabel119 = new JLabel();
/*   623 */     this.jPanel119 = new JPanel();
/*   624 */     this.jLabel120 = new JLabel();
/*   625 */     this.jPanel123 = new JPanel();
/*   626 */     this.jPanel124 = new JPanel();
/*   627 */     this.jLabel121 = new JLabel();
/*   628 */     this.jPanel125 = new JPanel();
/*   629 */     this.jLabel122 = new JLabel();
/*   630 */     this.jPanel126 = new JPanel();
/*   631 */     this.jPanel127 = new JPanel();
/*   632 */     this.jLabel123 = new JLabel();
/*   633 */     this.jPanel128 = new JPanel();
/*   634 */     this.jLabel124 = new JLabel();
/*   635 */     this.jPanel129 = new JPanel();
/*   636 */     this.jLabel125 = new JLabel();
/*   637 */     this.jPanel130 = new JPanel();
/*   638 */     this.jLabel126 = new JLabel();
/*   639 */     this.jPanel131 = new JPanel();
/*   640 */     this.jLabel127 = new JLabel();
/*   641 */     this.jPanel132 = new JPanel();
/*   642 */     this.jLabel128 = new JLabel();
/*   643 */     this.jPanel133 = new JPanel();
/*   644 */     this.jLabel129 = new JLabel();
/*   645 */     this.jPanel134 = new JPanel();
/*   646 */     this.jLabel130 = new JLabel();
/*   647 */     this.jPanel135 = new JPanel();
/*   648 */     this.jLabel131 = new JLabel();
/*   649 */     this.jPanel136 = new JPanel();
/*   650 */     this.jLabel132 = new JLabel();
/*   651 */     this.jPanel137 = new JPanel();
/*   652 */     this.jLabel133 = new JLabel();
/*   653 */     this.jPanel138 = new JPanel();
/*   654 */     this.jLabel134 = new JLabel();
/*   655 */     this.jPanel167 = new JPanel();
/*   656 */     this.jPanel168 = new JPanel();
/*   657 */     this.jPanel169 = new JPanel();
/*   658 */     this.jLabel147 = new JLabel();
/*   659 */     this.jPanel170 = new JPanel();
/*   660 */     this.jLabel148 = new JLabel();
/*   661 */     this.jPanel171 = new JPanel();
/*   662 */     this.jPanel172 = new JPanel();
/*   663 */     this.jLabel149 = new JLabel();
/*   664 */     this.jPanel175 = new JPanel();
/*   665 */     this.jLabel151 = new JLabel();
/*   666 */     this.jPanel174 = new JPanel();
/*   667 */     this.jPanel173 = new JPanel();
/*   668 */     this.jLabel150 = new JLabel();
/*   669 */     this.jPanel204 = new JPanel();
/*   670 */     this.jPanel200 = new JPanel();
/*   671 */     this.jPanel205 = new JPanel();
/*   672 */     this.jLabel163 = new JLabel();
/*   673 */     this.jPanel202 = new JPanel();
/*   674 */     this.jLabel177 = new JLabel();
/*   675 */     this.jPanel206 = new JPanel();
/*   676 */     this.jPanel207 = new JPanel();
/*   677 */     this.jLabel172 = new JLabel();
/*   678 */     this.jPanel208 = new JPanel();
/*   679 */     this.jLabel173 = new JLabel();
/*   680 */     this.jPanel71 = new JPanel();
/*   681 */     this.jPanel93 = new JPanel();
/*   682 */     this.jLabel82 = new JLabel();
/*   683 */     this.jPanel94 = new JPanel();
/*   684 */     this.jLabel84 = new JLabel();
/*   685 */     this.jPanel95 = new JPanel();
/*   686 */     this.jLabel87 = new JLabel();
/*   687 */     this.jPanel96 = new JPanel();
/*   688 */     this.jLabel88 = new JLabel();
/*   689 */     this.jPanel16 = new JPanel();
/*   690 */     this.jPanel89 = new JPanel();
/*   691 */     this.jLabel81 = new JLabel();
/*   692 */     this.jPanel92 = new JPanel();
/*   693 */     this.jLabel86 = new JLabel();
/*   694 */     this.jPanel91 = new JPanel();
/*   695 */     this.jLabel85 = new JLabel();
/*   696 */     this.jPanel90 = new JPanel();
/*   697 */     this.jLabel83 = new JLabel();
/*   698 */     this.jPanel19 = new JPanel();
/*   699 */     this.jPanel85 = new JPanel();
/*   700 */     this.jLabel77 = new JLabel();
/*   701 */     this.jPanel86 = new JPanel();
/*   702 */     this.jLabel78 = new JLabel();
/*   703 */     this.jPanel87 = new JPanel();
/*   704 */     this.jLabel79 = new JLabel();
/*   705 */     this.jPanel88 = new JPanel();
/*   706 */     this.jLabel80 = new JLabel();
/*   707 */     this.jPanel10 = new JPanel();
/*   708 */     this.jPanel81 = new JPanel();
/*   709 */     this.jLabel73 = new JLabel();
/*   710 */     this.jPanel82 = new JPanel();
/*   711 */     this.jLabel74 = new JLabel();
/*   712 */     this.jPanel83 = new JPanel();
/*   713 */     this.jLabel75 = new JLabel();
/*   714 */     this.jPanel84 = new JPanel();
/*   715 */     this.jLabel76 = new JLabel();
/*   716 */     this.jPanel54 = new JPanel();
/*   717 */     this.jLabel47 = new JLabel();
/*   718 */     this.jPanel14 = new JPanel();
/*   719 */     this.jPanel25 = new JPanel();
/*   720 */     this.jLabel5 = new JLabel();
/*   721 */     this.jLabel6 = new JLabel();
/*   722 */     this.jPanel27 = new JPanel();
/*   723 */     this.jLabel18 = new JLabel();
/*   724 */     this.jLabel161 = new JLabel();
/*   725 */     this.jPanel179 = new JPanel();
/*   726 */     this.jPanel15 = new JPanel();
/*   727 */     this.jPanel180 = new JPanel();
/*   728 */     this.jPanel181 = new JPanel();
/*   729 */     this.jLabel12 = new JLabel();
/*   730 */     this.jLabel13 = new JLabel();
/*   731 */     this.jPanel182 = new JPanel();
/*   732 */     this.jLabel59 = new JLabel();
/*   733 */     this.jLabel60 = new JLabel();
/*   734 */     this.jPanel43 = new JPanel();
/*   735 */     this.jPanel194 = new JPanel();
/*   736 */     this.jPanel36 = new JPanel();
/*   737 */     this.jPanel195 = new JPanel();
/*   738 */     this.jLabel64 = new JLabel();
/*   739 */     this.jLabel159 = new JLabel();
/*   740 */     this.jPanel196 = new JPanel();
/*   741 */     this.jLabel160 = new JLabel();
/*   742 */     this.jLabel50 = new JLabel();
/*   743 */     this.jDateChooser1 = new JDateChooser(this.fecha);
/*   744 */     this.buttonGroup1 = new ButtonGroup();
/*   745 */     this.buttonGroup2 = new ButtonGroup();
/*   746 */     this.buttonGroup3 = new ButtonGroup();
/*   747 */     this.buttonGroup4 = new ButtonGroup();
/*   748 */     this.buttonGroup5 = new ButtonGroup();
/*   749 */     this.jPopupMenu1 = new JPopupMenu();
/*   750 */     this.jMenuItem5 = new JMenuItem();
/*   751 */     this.jMenu18 = new JMenu();
/*   752 */     this.jRadioButtonMenuItem1 = new JRadioButtonMenuItem();
/*   753 */     this.jRadioButtonMenuItem2 = new JRadioButtonMenuItem();
/*   754 */     this.jRadioButtonMenuItem3 = new JRadioButtonMenuItem();
/*   755 */     this.jSeparator15 = new JPopupMenu.Separator();
/*   756 */     this.jMenuItem4 = new JMenuItem();
/*   757 */     this.jPopupMenu2 = new JPopupMenu();
/*   758 */     this.jMenuItem67 = new JMenuItem();
/*   759 */     this.jSeparator20 = new JPopupMenu.Separator();
/*   760 */     this.jMenuItem68 = new JMenuItem();
/*   761 */     this.jDialog11 = new CerrarVentana(this);
/*   762 */     this.jPanel177 = new JPanel();
/*   763 */     this.jPanel178 = new JPanel();
/*   764 */     this.jLabel62 = new JLabel();
/*   765 */     this.jPanel183 = new JPanel();
/*   766 */     this.jLabel152 = new JLabel();
/*   767 */     this.jLabel63 = new JLabel();
/*   768 */     this.jPanel184 = new JPanel();
/*   769 */     this.materialButton39 = new MaterialButton();
/*   770 */     this.materialButton40 = new MaterialButton();
/*   771 */     this.materialButton38 = new MaterialButton();
/*   772 */     this.jPanel185 = new JPanel();
/*   773 */     this.jScrollPane33 = new JScrollPane();
/*   774 */     this.rSTableMetro1 = new RSTableMetro();
/*   775 */     this.jLabel14 = new JLabel();
/*   776 */     this.jPanel186 = new JPanel();
/*   777 */     this.jLabel102 = new JLabel();
/*   778 */     this.jLabel103 = new JLabel();
/*   779 */     this.jPanel17 = new JPanel();
/*   780 */     this.jPanel8 = new JPanel();
/*   781 */     this.jPanel6 = new JPanel();
/*   782 */     this.jLabel1 = new JLabel();
/*   783 */     this.jLabel2 = new JLabel();
/*   784 */     this.jLabel9 = new JLabel();
/*   785 */     this.jLabel11 = new JLabel();
/*   786 */     this.jLabel28 = new JLabel();
/*   787 */     this.jSeparator21 = new JSeparator();
/*   788 */     this.jLabel36 = new JLabel();
/*   789 */     this.jSeparator22 = new JSeparator();
/*   790 */     this.jLabel56 = new JLabel();
/*   791 */     this.jLabel57 = new JLabel();
/*   792 */     this.jTabbedPane2 = new JTabbedPane();
/*   793 */     this.jScrollPane1 = new JScrollPane();
/*   794 */     this.jPanel2 = new JPanel();
/*   795 */     this.jPanel111 = new JPanel();
/*   796 */     this.jLabel4 = new JLabel();
/*   797 */     this.jPanel107 = new JPanel();
/*   798 */     this.jLabel3 = new JLabel();
/*   799 */     this.jPanel108 = new JPanel();
/*   800 */     this.jLabel110 = new JLabel();
/*   801 */     this.jLabel111 = new JLabel();
/*   802 */     this.jPanel109 = new JPanel();
/*   803 */     this.jLabel112 = new JLabel();
/*   804 */     this.jLabel113 = new JLabel();
/*   805 */     this.jLabel118 = new JLabel();
/*   806 */     this.jPanel152 = new JPanel();
/*   807 */     this.jLabel142 = new JLabel();
/*   808 */     this.jLabel143 = new JLabel();
/*   809 */     this.jPanel112 = new JPanel();
/*   810 */     this.jLabel114 = new JLabel();
/*   811 */     this.jPanel113 = new JPanel();
/*   812 */     this.jPanel114 = new JPanel();
/*   813 */     this.jLabel115 = new JLabel();
/*   814 */     this.jPanel116 = new JPanel();
/*   815 */     this.jLabel116 = new JLabel();
/*   816 */     this.jPanel118 = new JPanel();
/*   817 */     this.jLabel117 = new JLabel();
/*   818 */     this.jPanel115 = new JPanel();
/*   819 */     this.jPanel68 = new JPanel();
/*   820 */     this.jPanel3 = new JPanel();
/*   821 */     this.jPanel63 = new JPanel();
/*   822 */     this.jPanel55 = new JPanel();
/*   823 */     this.jLabel49 = new JLabel();
/*   824 */     this.jPanel64 = new JPanel();
/*   825 */     this.jPanel58 = new JPanel();
/*   826 */     this.jLabel54 = new JLabel();
/*   827 */     this.jPanel53 = new JPanel();
/*   828 */     this.jLabel48 = new JLabel();
/*   829 */     this.jPanel65 = new JPanel();
/*   830 */     this.jPanel59 = new JPanel();
/*   831 */     this.jLabel55 = new JLabel();
/*   832 */     this.jPanel72 = new JPanel();
/*   833 */     this.jPanel73 = new JPanel();
/*   834 */     this.jPanel97 = new JPanel();
/*   835 */     this.jLabel90 = new JLabel();
/*   836 */     this.jPanel98 = new JPanel();
/*   837 */     this.jLabel91 = new JLabel();
/*   838 */     this.jPanel99 = new JPanel();
/*   839 */     this.jLabel92 = new JLabel();
/*   840 */     this.jPanel70 = new JPanel();
/*   841 */     this.jPanel187 = new JPanel();
/*   842 */     this.jLabel153 = new JLabel();
/*   843 */     this.jPanel176 = new JPanel();
/*   844 */     this.jLabel101 = new JLabel();
/*   845 */     this.jPanel188 = new JPanel();
/*   846 */     this.jLabel154 = new JLabel();
/*   847 */     this.jPanel189 = new JPanel();
/*   848 */     this.jLabel155 = new JLabel();
/*   849 */     this.jPanel76 = new JPanel();
/*   850 */     this.jPanel44 = new JPanel();
/*   851 */     this.jPanel105 = new JPanel();
/*   852 */     this.jLabel107 = new JLabel();
/*   853 */     this.jPanel106 = new JPanel();
/*   854 */     this.jLabel108 = new JLabel();
/*   855 */     this.jPanel45 = new JPanel();
/*   856 */     this.jLabel109 = new JLabel();
/*   857 */     this.jPanel75 = new JPanel();
/*   858 */     this.jPanel74 = new JPanel();
/*   859 */     this.jPanel100 = new JPanel();
/*   860 */     this.jLabel93 = new JLabel();
/*   861 */     this.jPanel101 = new JPanel();
/*   862 */     this.jLabel94 = new JLabel();
/*   863 */     this.jPanel102 = new JPanel();
/*   864 */     this.jLabel95 = new JLabel();
/*   865 */     this.jPanel103 = new JPanel();
/*   866 */     this.jLabel96 = new JLabel();
/*   867 */     this.jPanel104 = new JPanel();
/*   868 */     this.jLabel106 = new JLabel();
/*   869 */     this.jPanel190 = new JPanel();
/*   870 */     this.jPanel191 = new JPanel();
/*   871 */     this.jLabel156 = new JLabel();
/*   872 */     this.jPanel192 = new JPanel();
/*   873 */     this.jLabel157 = new JLabel();
/*   874 */     this.jPanel193 = new JPanel();
/*   875 */     this.jLabel158 = new JLabel();
/*   876 */     this.jButton1 = new JButton();
/*   877 */     this.jPanel121 = new JPanel();
/*   878 */     this.jPanel120 = new JPanel();
/*   879 */     this.jPanel122 = new JPanel();
/*   880 */     this.jMenuBar1 = new JMenuBar();
/*   881 */     this.jMenu1 = new JMenu();
/*   882 */     this.jMenu4 = new JMenu();
/*   883 */     this.jMenuItem11 = new JMenuItem();
/*   884 */     this.jMenuItem12 = new JMenuItem();
/*   885 */     this.jMenuItem13 = new JMenuItem();
/*   886 */     this.jMenuItem6 = new JMenuItem();
/*   887 */     this.jSeparator13 = new JPopupMenu.Separator();
/*   888 */     this.jMenuItem14 = new JMenuItem();
/*   889 */     this.jMenuItem1 = new JMenuItem();
/*   890 */     this.jMenu19 = new JMenu();
/*   891 */     this.jMenuItem70 = new JMenuItem();
/*   892 */     this.jMenuItem71 = new JMenuItem();
/*   893 */     this.jMenuItem72 = new JMenuItem();
/*   894 */     this.jMenuItem74 = new JMenuItem();
/*   895 */     this.jMenuItem76 = new JMenuItem();
/*   896 */     this.jMenu10 = new JMenu();
/*   897 */     this.jMenuItem30 = new JMenuItem();
/*   898 */     this.jMenuItem31 = new JMenuItem();
/*   899 */     this.jMenuItem32 = new JMenuItem();
/*   900 */     this.jMenuItem39 = new JMenuItem();
/*   901 */     this.jSeparator16 = new JPopupMenu.Separator();
/*   902 */     this.jMenuItem33 = new JMenuItem();
/*   903 */     this.jMenuItem34 = new JMenuItem();
/*   904 */     this.jSeparator18 = new JPopupMenu.Separator();
/*   905 */     this.jMenu11 = new JMenu();
/*   906 */     this.jMenuItem35 = new JMenuItem();
/*   907 */     this.jMenuItem36 = new JMenuItem();
/*   908 */     this.jMenuItem69 = new JMenuItem();
/*   909 */     this.jMenuItem37 = new JMenuItem();
/*   910 */     this.jMenuItem38 = new JMenuItem();
/*   911 */     this.jMenuItem66 = new JMenuItem();
/*   912 */     this.jMenu2 = new JMenu();
/*   913 */     this.jMenu3 = new JMenu();
/*   914 */     this.jMenuItem2 = new JMenuItem();
/*   915 */     this.jMenuItem3 = new JMenuItem();
/*   916 */     this.jMenuItem7 = new JMenuItem();
/*   917 */     this.jMenuItem8 = new JMenuItem();
/*   918 */     this.jMenuItem10 = new JMenuItem();
/*   919 */     this.jMenu5 = new JMenu();
/*   920 */     this.jMenuItem16 = new JMenuItem();
/*   921 */     this.jMenuItem17 = new JMenuItem();
/*   922 */     this.jMenuItem18 = new JMenuItem();
/*   923 */     this.jSeparator17 = new JPopupMenu.Separator();
/*   924 */     this.jMenuItem15 = new JMenuItem();
/*   925 */     this.jMenuItem19 = new JMenuItem();
/*   926 */     this.jMenuItem20 = new JMenuItem();
/*   927 */     this.jMenuItem21 = new JMenuItem();
/*   928 */     this.jMenu6 = new JMenu();
/*   929 */     this.jMenu7 = new JMenu();
/*   930 */     this.jMenuItem9 = new JMenuItem();
/*   931 */     this.jMenuItem22 = new JMenuItem();
/*   932 */     this.jMenuItem23 = new JMenuItem();
/*   933 */     this.jMenuItem24 = new JMenuItem();
/*   934 */     this.jMenu8 = new JMenu();
/*   935 */     this.jMenuItem25 = new JMenuItem();
/*   936 */     this.jMenuItem26 = new JMenuItem();
/*   937 */     this.jMenuItem27 = new JMenuItem();
/*   938 */     this.jMenuItem28 = new JMenuItem();
/*   939 */     this.jMenu12 = new JMenu();
/*   940 */     this.jMenuItem40 = new JMenuItem();
/*   941 */     this.jMenuItem41 = new JMenuItem();
/*   942 */     this.jMenuItem42 = new JMenuItem();
/*   943 */     this.jMenuItem43 = new JMenuItem();
/*   944 */     this.jMenu13 = new JMenu();
/*   945 */     this.jMenuItem44 = new JMenuItem();
/*   946 */     this.jMenuItem45 = new JMenuItem();
/*   947 */     this.jMenuItem46 = new JMenuItem();
/*   948 */     this.jMenuItem47 = new JMenuItem();
/*   949 */     this.jMenu17 = new JMenu();
/*   950 */     this.jMenuItem63 = new JMenuItem();
/*   951 */     this.jMenuItem64 = new JMenuItem();
/*   952 */     this.jMenuItem65 = new JMenuItem();
/*   953 */     this.jMenuItem29 = new JMenuItem();
/*   954 */     this.jMenuItem56 = new JMenuItem();
/*   955 */     this.jMenu9 = new JMenu();
/*   956 */     this.jMenu14 = new JMenu();
/*   957 */     this.jMenuItem48 = new JMenuItem();
/*   958 */     this.jMenuItem49 = new JMenuItem();
/*   959 */     this.jMenuItem50 = new JMenuItem();
/*   960 */     this.jMenuItem51 = new JMenuItem();
/*   961 */     this.jMenu15 = new JMenu();
/*   962 */     this.jMenuItem52 = new JMenuItem();
/*   963 */     this.jMenuItem53 = new JMenuItem();
/*   964 */     this.jMenuItem54 = new JMenuItem();
/*   965 */     this.jMenuItem55 = new JMenuItem();
/*   966 */     this.jSeparator19 = new JPopupMenu.Separator();
/*   967 */     this.jMenuItem57 = new JMenuItem();
/*   968 */     this.jMenuItem58 = new JMenuItem();
/*   969 */     this.jMenuItem59 = new JMenuItem();
/*   970 */     this.jMenu16 = new JMenu();
/*   971 */     this.jMenuItem60 = new JMenuItem();
/*   972 */     this.jMenuItem61 = new JMenuItem();
/*   973 */     this.jMenuItem62 = new JMenuItem();
/*       */     
/*   975 */     this.jFrame1.setUndecorated(true);
/*       */     
/*   977 */     this.jPanel48.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO1));
/*   978 */     this.jPanel48.setLayout(new GridLayout(1, 2));
/*       */     
/*   980 */     this.jPanel49.setBackground(this.lc.PRIMARIO1);
/*   981 */     this.jPanel49.addMouseMotionListener(new MouseMotionAdapter() {
/*       */           public void mouseDragged(MouseEvent evt) {
/*   983 */             Principal.this.jPanel49MouseDragged(evt);
/*       */           }
/*       */         });
/*   986 */     this.jPanel49.addMouseListener(new MouseAdapter() {
/*       */           public void mousePressed(MouseEvent evt) {
/*   988 */             Principal.this.jPanel49MousePressed(evt);
/*       */           }
/*       */           public void mouseClicked(MouseEvent evt) {
/*   991 */             Principal.this.jPanel49MouseClicked(evt);
/*       */           }
/*       */         });
/*       */     
/*   995 */     this.jLabel41.setHorizontalAlignment(0);
/*   996 */     this.jLabel41.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Contact.png")));
/*       */     
/*   998 */     this.jLabel42.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/*   999 */     this.jLabel42.setForeground(this.lc.TERCERO1);
/*  1000 */     this.jLabel42.setHorizontalAlignment(0);
/*  1001 */     this.jLabel42.setText("<html><center>Sistema Integral para el Control de Residuos y Empleados Transportistas</center></html>");
/*       */     
/*  1003 */     this.jLabel43.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 22.0F));
/*  1004 */     this.jLabel43.setForeground(this.lc.TERCERO1);
/*  1005 */     this.jLabel43.setHorizontalAlignment(0);
/*  1006 */     this.jLabel43.setText("SICRET");
/*       */     
/*  1008 */     this.jLabel15.setFont(new Font("Segoe UI", 0, 10));
/*  1009 */     this.jLabel15.setForeground(this.lc.TERCERO1);
/*  1010 */     this.jLabel15.setHorizontalAlignment(4);
/*  1011 */     this.jLabel15.setText("Cargando catálogos...Espere");
/*  1012 */     this.jLabel15.setToolTipText("<html><b>Generación de Módulos Automáticos</b><br> Para agilizar las búsquedas hasta 40% más rápidas</html>");
/*       */     
/*  1014 */     GroupLayout jPanel49Layout = new GroupLayout(this.jPanel49);
/*  1015 */     this.jPanel49.setLayout(jPanel49Layout);
/*  1016 */     jPanel49Layout.setHorizontalGroup(jPanel49Layout
/*  1017 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1018 */         .addComponent(this.jLabel42, -2, 0, 32767)
/*  1019 */         .addGroup(jPanel49Layout.createSequentialGroup()
/*  1020 */           .addGroup(jPanel49Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1021 */             .addGroup(jPanel49Layout.createSequentialGroup()
/*  1022 */               .addContainerGap()
/*  1023 */               .addGroup(jPanel49Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1024 */                 .addComponent(this.jLabel43, -1, 167, 32767)
/*  1025 */                 .addComponent(this.jLabel41, -1, 167, 32767)))
/*  1026 */             .addComponent(this.jLabel15, -1, -1, 32767))
/*  1027 */           .addContainerGap()));
/*       */     
/*  1029 */     jPanel49Layout.setVerticalGroup(jPanel49Layout
/*  1030 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1031 */         .addGroup(jPanel49Layout.createSequentialGroup()
/*  1032 */           .addGap(39, 39, 39)
/*  1033 */           .addComponent(this.jLabel41)
/*  1034 */           .addGap(33, 33, 33)
/*  1035 */           .addComponent(this.jLabel43)
/*  1036 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1037 */           .addComponent(this.jLabel42, -2, -1, -2)
/*  1038 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 182, 32767)
/*  1039 */           .addComponent(this.jLabel15)));
/*       */ 
/*       */     
/*  1042 */     this.jPanel48.add(this.jPanel49);
/*       */     
/*  1044 */     this.jPanel50.setBackground(this.lc.TERCERO1);
/*  1045 */     this.jPanel50.addMouseMotionListener(new MouseMotionAdapter() {
/*       */           public void mouseDragged(MouseEvent evt) {
/*  1047 */             Principal.this.jPanel50MouseDragged(evt);
/*       */           }
/*       */         });
/*  1050 */     this.jPanel50.addMouseListener(new MouseAdapter() {
/*       */           public void mousePressed(MouseEvent evt) {
/*  1052 */             Principal.this.jPanel50MousePressed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1056 */     this.jPanel51.setBackground(this.lc.PRIMARIO1);
/*  1057 */     this.jPanel51.setLayout(new GridLayout(1, 0));
/*       */     
/*  1059 */     this.jLabel44.setHorizontalAlignment(0);
/*  1060 */     this.jLabel44.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*  1061 */     this.jLabel44.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  1063 */             Principal.this.jLabel44MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  1066 */             Principal.this.jLabel44MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  1069 */             Principal.this.jLabel44MouseEntered(evt);
/*       */           }
/*       */         });
/*  1072 */     this.jPanel51.add(this.jLabel44);
/*       */     
/*  1074 */     this.jLabel45.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/*       */     
/*  1076 */     this.jLabel45.setForeground(new Color(102, 102, 102));
/*  1077 */     this.jLabel45.setText("Usuario");
/*       */     
/*  1079 */     this.jLabel46.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/*  1080 */     this.jLabel46.setForeground(new Color(102, 102, 102));
/*  1081 */     this.jLabel46.setText("Contraseña");
/*       */     
/*  1083 */     this.jPasswordField1.setFont(new Font("Dialog", 0, 14));
/*  1084 */     this.jPasswordField1.setToolTipText("Contraseña");
/*  1085 */     this.jPasswordField1.addFocusListener(new FocusAdapter() {
/*       */           public void focusGained(FocusEvent evt) {
/*  1087 */             Principal.this.jPasswordField1FocusGained(evt);
/*       */           }
/*       */         });
/*  1090 */     this.jPasswordField1.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1092 */             Principal.this.jPasswordField1ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1095 */     this.jPasswordField1.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  1097 */             Principal.this.jPasswordField1KeyReleased(evt);
/*       */           }
/*       */         });
/*       */     
/*  1101 */     this.jTextField1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/*  1102 */     this.jTextField1.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1104 */             Principal.this.jTextField1ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1108 */     this.materialButton5.setBackground(this.lc.PRIMARIO1);
/*  1109 */     this.materialButton5.setForeground(new Color(255, 255, 255));
/*  1110 */     this.materialButton5.setText("Aceptar");
/*  1111 */     this.materialButton5.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/*       */     
/*  1113 */     this.materialButton5.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1115 */             Principal.this.materialButton5ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1119 */     this.jLabel8.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.ITALIC, 11.0F));
/*  1120 */     this.jLabel8.setForeground(this.lc.PRIMARIO1);
/*  1121 */     this.jLabel8.setText(" ");
/*       */     
/*  1123 */     GroupLayout jPanel50Layout = new GroupLayout(this.jPanel50);
/*  1124 */     this.jPanel50.setLayout(jPanel50Layout);
/*  1125 */     jPanel50Layout.setHorizontalGroup(jPanel50Layout
/*  1126 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1127 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
/*  1128 */           .addContainerGap(-1, 32767)
/*  1129 */           .addComponent((Component)this.materialButton5, -2, 135, -2)
/*  1130 */           .addGap(21, 21, 21))
/*  1131 */         .addComponent(this.jProgressBar1, -1, -1, 32767)
/*  1132 */         .addGroup(jPanel50Layout.createSequentialGroup()
/*  1133 */           .addContainerGap()
/*  1134 */           .addGroup(jPanel50Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1135 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
/*  1136 */               .addGap(0, 145, 32767)
/*  1137 */               .addComponent(this.jPanel51, -2, 28, -2))
/*  1138 */             .addGroup(jPanel50Layout.createSequentialGroup()
/*  1139 */               .addGroup(jPanel50Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1140 */                 .addComponent(this.jTextField1, -1, 167, 32767)
/*  1141 */                 .addComponent(this.jLabel45, -1, -1, 32767)
/*  1142 */                 .addComponent(this.jLabel46, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/*  1143 */                 .addComponent(this.jPasswordField1)
/*  1144 */                 .addComponent(this.jLabel8, -1, -1, 32767))
/*  1145 */               .addContainerGap()))));
/*       */     
/*  1147 */     jPanel50Layout.setVerticalGroup(jPanel50Layout
/*  1148 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1149 */         .addGroup(jPanel50Layout.createSequentialGroup()
/*  1150 */           .addComponent(this.jPanel51, -2, 31, -2)
/*  1151 */           .addGap(80, 80, 80)
/*  1152 */           .addComponent(this.jLabel45)
/*  1153 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1154 */           .addComponent(this.jTextField1, -2, 28, -2)
/*  1155 */           .addGap(18, 18, 18)
/*  1156 */           .addComponent(this.jLabel46)
/*  1157 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1158 */           .addComponent(this.jPasswordField1, -2, 28, -2)
/*  1159 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1160 */           .addComponent(this.jLabel8)
/*  1161 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1162 */           .addComponent((Component)this.materialButton5, -2, 39, -2)
/*  1163 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 170, 32767)
/*  1164 */           .addComponent(this.jProgressBar1, -2, 8, -2)));
/*       */ 
/*       */     
/*  1167 */     this.jPanel48.add(this.jPanel50);
/*       */     
/*  1169 */     GroupLayout jFrame1Layout = new GroupLayout(this.jFrame1.getContentPane());
/*  1170 */     this.jFrame1.getContentPane().setLayout(jFrame1Layout);
/*  1171 */     jFrame1Layout.setHorizontalGroup(jFrame1Layout
/*  1172 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1173 */         .addComponent(this.jPanel48, -1, -1, 32767));
/*       */     
/*  1175 */     jFrame1Layout.setVerticalGroup(jFrame1Layout
/*  1176 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1177 */         .addComponent(this.jPanel48, -1, -1, 32767));
/*       */ 
/*       */     
/*  1180 */     this.jFrame2.setTitle("Formación de operadores");
/*       */     
/*  1182 */     this.jRadioButton1.setSelected(true);
/*  1183 */     this.jRadioButton1.setText("Pipas");
/*       */     
/*  1185 */     this.jRadioButton2.setText("Góndolas");
/*       */     
/*  1187 */     this.materialButton3.setBackground(this.lc.SECUNDARIO1);
/*  1188 */     this.materialButton3.setForeground(new Color(255, 255, 255));
/*  1189 */     this.materialButton3.setMnemonic('C');
/*  1190 */     this.materialButton3.setText("Cerrar");
/*  1191 */     this.materialButton3.setToolTipText("Cerrar (Alt+C)");
/*  1192 */     this.materialButton3.setFont(new Font("Cantarell", 0, 12));
/*  1193 */     this.materialButton3.setHorizontalTextPosition(0);
/*  1194 */     this.materialButton3.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1196 */             Principal.this.materialButton3ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1200 */     this.materialButton4.setBackground(this.lc.SECUNDARIO1);
/*  1201 */     this.materialButton4.setForeground(new Color(255, 255, 255));
/*  1202 */     this.materialButton4.setMnemonic('E');
/*  1203 */     this.materialButton4.setText(" Estatus");
/*  1204 */     this.materialButton4.setToolTipText("Estatus (Alt+E)");
/*  1205 */     this.materialButton4.setFont(new Font("Cantarell", 0, 12));
/*  1206 */     this.materialButton4.setHorizontalTextPosition(0);
/*  1207 */     this.materialButton4.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1209 */             Principal.this.materialButton4ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1213 */     this.materialButton7.setBackground(this.lc.SECUNDARIO1);
/*  1214 */     this.materialButton7.setForeground(new Color(255, 255, 255));
/*  1215 */     this.materialButton7.setMnemonic('A');
/*  1216 */     this.materialButton7.setText("Actualizar");
/*  1217 */     this.materialButton7.setToolTipText("Actualizar (Alt+A)");
/*  1218 */     this.materialButton7.setFont(new Font("Cantarell", 0, 12));
/*  1219 */     this.materialButton7.setHorizontalTextPosition(0);
/*  1220 */     this.materialButton7.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1222 */             Principal.this.materialButton7ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1226 */     this.materialButton6.setBackground(this.lc.SECUNDARIO1);
/*  1227 */     this.materialButton6.setForeground(new Color(255, 255, 255));
/*  1228 */     this.materialButton6.setMnemonic('Q');
/*  1229 */     this.materialButton6.setText("Quitar");
/*  1230 */     this.materialButton6.setToolTipText("Quitar (Alt+Q)");
/*  1231 */     this.materialButton6.setFont(new Font("Cantarell", 0, 12));
/*  1232 */     this.materialButton6.setHorizontalTextPosition(0);
/*  1233 */     this.materialButton6.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1235 */             Principal.this.materialButton6ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1239 */     this.materialButton8.setBackground(this.lc.SECUNDARIO1);
/*  1240 */     this.materialButton8.setForeground(new Color(255, 255, 255));
/*  1241 */     this.materialButton8.setMnemonic('M');
/*  1242 */     this.materialButton8.setText("Mover");
/*  1243 */     this.materialButton8.setToolTipText("Mover (Alt+M)");
/*  1244 */     this.materialButton8.setFont(new Font("Cantarell", 0, 12));
/*  1245 */     this.materialButton8.setHorizontalTextPosition(0);
/*  1246 */     this.materialButton8.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1248 */             Principal.this.materialButton8ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1252 */     this.materialButton9.setBackground(this.lc.PRIMARIO1);
/*  1253 */     this.materialButton9.setForeground(new Color(255, 255, 255));
/*  1254 */     this.materialButton9.setMnemonic('A');
/*  1255 */     this.materialButton9.setText("Agregar Nuevo");
/*  1256 */     this.materialButton9.setToolTipText("Agregar Nuevo (Alt+A)");
/*  1257 */     this.materialButton9.setFont(new Font("Cantarell", 0, 12));
/*  1258 */     this.materialButton9.setHorizontalTextPosition(0);
/*  1259 */     this.materialButton9.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1261 */             Principal.this.materialButton9ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1265 */     GroupLayout jPanel31Layout = new GroupLayout(this.jPanel31);
/*  1266 */     this.jPanel31.setLayout(jPanel31Layout);
/*  1267 */     jPanel31Layout.setHorizontalGroup(jPanel31Layout
/*  1268 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1269 */         .addGroup(jPanel31Layout.createSequentialGroup()
/*  1270 */           .addComponent(this.jRadioButton1, -2, 100, -2)
/*  1271 */           .addGap(18, 18, 18)
/*  1272 */           .addComponent(this.jRadioButton2, -2, 100, -2)
/*  1273 */           .addGap(29, 29, 29)
/*  1274 */           .addComponent((Component)this.materialButton9, -2, 150, -2)
/*  1275 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1276 */           .addComponent((Component)this.materialButton8, -2, 105, -2)
/*  1277 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1278 */           .addComponent((Component)this.materialButton6, -2, 105, -2)
/*  1279 */           .addGap(3, 3, 3)
/*  1280 */           .addComponent((Component)this.materialButton7, -2, 105, -2)
/*  1281 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1282 */           .addComponent((Component)this.materialButton4, -2, 105, -2)
/*  1283 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  1284 */           .addComponent((Component)this.materialButton3, -2, 105, -2)));
/*       */     
/*  1286 */     jPanel31Layout.setVerticalGroup(jPanel31Layout
/*  1287 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1288 */         .addGroup(jPanel31Layout.createSequentialGroup()
/*  1289 */           .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1290 */             .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  1291 */               .addComponent((Component)this.materialButton3, -2, 38, -2)
/*  1292 */               .addComponent((Component)this.materialButton4, -2, 38, -2)
/*  1293 */               .addComponent((Component)this.materialButton7, -2, 38, -2)
/*  1294 */               .addComponent((Component)this.materialButton6, -2, 38, -2)
/*  1295 */               .addComponent((Component)this.materialButton8, -2, 38, -2)
/*  1296 */               .addComponent((Component)this.materialButton9, -2, 38, -2))
/*  1297 */             .addGroup(jPanel31Layout.createSequentialGroup()
/*  1298 */               .addContainerGap()
/*  1299 */               .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  1300 */                 .addComponent(this.jRadioButton1)
/*  1301 */                 .addComponent(this.jRadioButton2))))
/*  1302 */           .addGap(12, 12, 12)));
/*       */ 
/*       */     
/*  1305 */     this.jSplitPane2.setDividerLocation(500);
/*  1306 */     this.jSplitPane2.setDividerSize(4);
/*       */     
/*  1308 */     this.rSTableMetro5.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*       */         {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*  1316 */           boolean[] canEdit = new boolean[] { false, false };
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  1321 */             return this.canEdit[columnIndex];
/*       */           }
/*       */         });
/*  1324 */     this.rSTableMetro5.setAltoHead(40);
/*  1325 */     this.rSTableMetro5.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  1326 */     this.rSTableMetro5.setColorBordeFilas(new Color(200, 200, 200));
/*  1327 */     this.rSTableMetro5.setColorBordeHead(this.lc.PRIMARIO1);
/*  1328 */     this.rSTableMetro5.setColorFilasBackgound2(new Color(239, 239, 239));
/*  1329 */     this.rSTableMetro5.setColorFilasForeground1(new Color(102, 102, 102));
/*  1330 */     this.rSTableMetro5.setColorFilasForeground2(new Color(102, 102, 102));
/*  1331 */     this.rSTableMetro5.setColorSelBackgound(new Color(237, 107, 107));
/*  1332 */     this.rSTableMetro5.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  1333 */     this.rSTableMetro5.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  1334 */     this.rSTableMetro5.setFuenteHead(new Font("Cantarell", 1, 12));
/*  1335 */     this.rSTableMetro5.setGrosorBordeFilas(0);
/*  1336 */     this.rSTableMetro5.setSelectionBackground(this.lc.PRIMARIO2);
/*  1337 */     this.rSTableMetro5.getTableHeader().setResizingAllowed(false);
/*  1338 */     this.rSTableMetro5.getTableHeader().setReorderingAllowed(false);
/*  1339 */     this.rSTableMetro5.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  1341 */             Principal.this.rSTableMetro5MouseClicked(evt);
/*       */           }
/*       */         });
/*  1344 */     this.rSTableMetro5.addKeyListener(new KeyAdapter() {
/*       */           public void keyPressed(KeyEvent evt) {
/*  1346 */             Principal.this.rSTableMetro5KeyPressed(evt);
/*       */           }
/*       */           public void keyReleased(KeyEvent evt) {
/*  1349 */             Principal.this.rSTableMetro5KeyReleased(evt);
/*       */           }
/*       */         });
/*  1352 */     this.jScrollPane15.setViewportView((Component)this.rSTableMetro5);
/*  1353 */     if (this.rSTableMetro5.getColumnModel().getColumnCount() > 0) {
/*  1354 */       this.rSTableMetro5.getColumnModel().getColumn(0).setMinWidth(80);
/*  1355 */       this.rSTableMetro5.getColumnModel().getColumn(0).setPreferredWidth(80);
/*  1356 */       this.rSTableMetro5.getColumnModel().getColumn(0).setMaxWidth(80);
/*  1357 */       this.rSTableMetro5.getColumnModel().getColumn(1).setResizable(false);
/*       */     } 
/*       */     
/*  1360 */     this.jSplitPane2.setLeftComponent(this.jScrollPane15);
/*       */     
/*  1362 */     this.rSTableMetro6.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*       */         {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*  1370 */           boolean[] canEdit = new boolean[] { false, false };
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  1375 */             return this.canEdit[columnIndex];
/*       */           }
/*       */         });
/*  1378 */     this.rSTableMetro6.setAltoHead(40);
/*  1379 */     this.rSTableMetro6.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  1380 */     this.rSTableMetro6.setColorBordeFilas(new Color(200, 200, 200));
/*  1381 */     this.rSTableMetro6.setColorBordeHead(this.lc.PRIMARIO1);
/*  1382 */     this.rSTableMetro6.setColorFilasBackgound2(new Color(239, 239, 239));
/*  1383 */     this.rSTableMetro6.setColorFilasForeground1(new Color(102, 102, 102));
/*  1384 */     this.rSTableMetro6.setColorFilasForeground2(new Color(102, 102, 102));
/*  1385 */     this.rSTableMetro6.setColorSelBackgound(new Color(237, 107, 107));
/*  1386 */     this.rSTableMetro6.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  1387 */     this.rSTableMetro6.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  1388 */     this.rSTableMetro6.setFuenteHead(new Font("Cantarell", 1, 12));
/*  1389 */     this.rSTableMetro6.setGrosorBordeFilas(0);
/*  1390 */     this.rSTableMetro6.setSelectionBackground(this.lc.PRIMARIO2);
/*  1391 */     this.rSTableMetro6.getTableHeader().setResizingAllowed(false);
/*  1392 */     this.rSTableMetro6.getTableHeader().setReorderingAllowed(false);
/*  1393 */     this.rSTableMetro6.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  1395 */             Principal.this.rSTableMetro6MouseClicked(evt);
/*       */           }
/*       */         });
/*  1398 */     this.rSTableMetro6.addKeyListener(new KeyAdapter() {
/*       */           public void keyPressed(KeyEvent evt) {
/*  1400 */             Principal.this.rSTableMetro6KeyPressed(evt);
/*       */           }
/*       */           public void keyReleased(KeyEvent evt) {
/*  1403 */             Principal.this.rSTableMetro6KeyReleased(evt);
/*       */           }
/*       */         });
/*  1406 */     this.jScrollPane16.setViewportView((Component)this.rSTableMetro6);
/*  1407 */     if (this.rSTableMetro6.getColumnModel().getColumnCount() > 0) {
/*  1408 */       this.rSTableMetro6.getColumnModel().getColumn(0).setMinWidth(80);
/*  1409 */       this.rSTableMetro6.getColumnModel().getColumn(0).setPreferredWidth(80);
/*  1410 */       this.rSTableMetro6.getColumnModel().getColumn(0).setMaxWidth(80);
/*  1411 */       this.rSTableMetro6.getColumnModel().getColumn(1).setResizable(false);
/*       */     } 
/*       */     
/*  1414 */     this.jSplitPane2.setRightComponent(this.jScrollPane16);
/*       */     
/*  1416 */     this.jLabel23.setFont(new Font("Cantarell", 1, 13));
/*  1417 */     this.jLabel23.setForeground(this.lc.PRIMARIO1);
/*  1418 */     this.jLabel23.setHorizontalAlignment(0);
/*  1419 */     this.jLabel23.setText("PIPAS                                                                                                                                                                                                           GÓNDOLAS");
/*       */     
/*  1421 */     this.jLabel24.setFont(new Font("Tahoma", 1, 16));
/*  1422 */     this.jLabel24.setForeground(this.lc.SECUNDARIO1);
/*  1423 */     this.jLabel24.setHorizontalAlignment(4);
/*  1424 */     this.jLabel24.setText("jLabel24");
/*       */     
/*  1426 */     this.jLabel25.setForeground(this.lc.SECUNDARIO2);
/*  1427 */     this.jLabel25.setHorizontalAlignment(4);
/*  1428 */     this.jLabel25.setText("PRÓXIMA ACTUALIZACIÓN:");
/*       */     
/*  1430 */     this.materialButton2.setBackground(this.lc.SECUNDARIO1);
/*  1431 */     this.materialButton2.setForeground(new Color(255, 255, 255));
/*  1432 */     this.materialButton2.setMnemonic('H');
/*  1433 */     this.materialButton2.setText("Historial");
/*  1434 */     this.materialButton2.setToolTipText("Historial (Alt+H)");
/*  1435 */     this.materialButton2.setFont(new Font("Cantarell", 0, 12));
/*  1436 */     this.materialButton2.setHorizontalTextPosition(0);
/*  1437 */     this.materialButton2.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1439 */             Principal.this.materialButton2ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1443 */     GroupLayout jPanel30Layout = new GroupLayout(this.jPanel30);
/*  1444 */     this.jPanel30.setLayout(jPanel30Layout);
/*  1445 */     jPanel30Layout.setHorizontalGroup(jPanel30Layout
/*  1446 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1447 */         .addComponent(this.jSeparator5, GroupLayout.Alignment.TRAILING)
/*  1448 */         .addComponent(this.jPanel31, -1, -1, 32767)
/*  1449 */         .addGroup(jPanel30Layout.createSequentialGroup()
/*  1450 */           .addComponent((Component)this.materialButton2, -2, 105, -2)
/*  1451 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  1452 */           .addComponent(this.jLabel25, -2, 192, -2)
/*  1453 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1454 */           .addComponent(this.jLabel24, -2, 168, -2))
/*  1455 */         .addComponent(this.jLabel23, -1, -1, 32767)
/*  1456 */         .addComponent(this.jSplitPane2));
/*       */     
/*  1458 */     jPanel30Layout.setVerticalGroup(jPanel30Layout
/*  1459 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1460 */         .addGroup(jPanel30Layout.createSequentialGroup()
/*  1461 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  1462 */             .addComponent(this.jLabel24, -2, 21, -2)
/*  1463 */             .addComponent(this.jLabel25)
/*  1464 */             .addComponent((Component)this.materialButton2, -2, 38, -2))
/*  1465 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1466 */           .addComponent(this.jSeparator5, -2, 10, -2)
/*  1467 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1468 */           .addComponent(this.jLabel23)
/*  1469 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1470 */           .addComponent(this.jSplitPane2, -1, 212, 32767)
/*  1471 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1472 */           .addComponent(this.jPanel31, -2, 38, -2)));
/*       */ 
/*       */     
/*  1475 */     GroupLayout jFrame2Layout = new GroupLayout(this.jFrame2.getContentPane());
/*  1476 */     this.jFrame2.getContentPane().setLayout(jFrame2Layout);
/*  1477 */     jFrame2Layout.setHorizontalGroup(jFrame2Layout
/*  1478 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1479 */         .addComponent(this.jPanel30, -1, -1, 32767));
/*       */     
/*  1481 */     jFrame2Layout.setVerticalGroup(jFrame2Layout
/*  1482 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1483 */         .addComponent(this.jPanel30, -1, -1, 32767));
/*       */ 
/*       */     
/*  1486 */     this.materialButton1.setText("materialButton1");
/*       */     
/*  1488 */     this.materialComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Prueba 1", "Prueba 1", "Prueba 1" }));
/*       */     
/*  1490 */     this.materialFormattedTextField1.setText("materialFormattedTextField1");
/*       */     
/*  1492 */     this.materialTextField1.setText("materialTextField1");
/*       */     
/*  1494 */     this.materialProgressSpinner1.setForeground(new Color(255, 51, 51));
/*       */     
/*  1496 */     this.materialPasswordField1.setText("materialPasswordField1");
/*       */     
/*  1498 */     GroupLayout jPanel166Layout = new GroupLayout(this.jPanel166);
/*  1499 */     this.jPanel166.setLayout(jPanel166Layout);
/*  1500 */     jPanel166Layout.setHorizontalGroup(jPanel166Layout
/*  1501 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1502 */         .addGroup(jPanel166Layout.createSequentialGroup()
/*  1503 */           .addComponent((Component)this.toastBar1, -1, -1, 32767)
/*  1504 */           .addGap(27, 27, 27)
/*  1505 */           .addComponent((Component)this.materialProgressSpinner1, -2, 29, -2))
/*  1506 */         .addGroup(jPanel166Layout.createSequentialGroup()
/*  1507 */           .addContainerGap()
/*  1508 */           .addGroup(jPanel166Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1509 */             .addComponent((Component)this.materialPasswordField1, -2, 298, -2)
/*  1510 */             .addComponent((Component)this.materialTextField1, -2, 298, -2)
/*  1511 */             .addGroup(jPanel166Layout.createSequentialGroup()
/*  1512 */               .addComponent((Component)this.materialButton1, -2, -1, -2)
/*  1513 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1514 */               .addGroup(jPanel166Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1515 */                 .addGroup(jPanel166Layout.createSequentialGroup()
/*  1516 */                   .addGap(6, 6, 6)
/*  1517 */                   .addComponent((Component)this.materialFormattedTextField1, -2, -1, -2))
/*  1518 */                 .addComponent((Component)this.materialComboBox1, -2, 188, -2))))
/*  1519 */           .addContainerGap(220, 32767)));
/*       */     
/*  1521 */     jPanel166Layout.setVerticalGroup(jPanel166Layout
/*  1522 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1523 */         .addGroup(jPanel166Layout.createSequentialGroup()
/*  1524 */           .addContainerGap()
/*  1525 */           .addGroup(jPanel166Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  1526 */             .addComponent((Component)this.materialButton1, -1, -1, 32767)
/*  1527 */             .addComponent((Component)this.materialComboBox1, -1, -1, 32767))
/*  1528 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1529 */           .addComponent((Component)this.materialFormattedTextField1, -2, 55, -2)
/*  1530 */           .addGap(18, 18, 18)
/*  1531 */           .addComponent((Component)this.materialTextField1, -2, 73, -2)
/*  1532 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1533 */           .addComponent((Component)this.materialPasswordField1, -2, 56, -2)
/*  1534 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 168, 32767)
/*  1535 */           .addComponent((Component)this.toastBar1, -2, 100, -2))
/*  1536 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel166Layout.createSequentialGroup()
/*  1537 */           .addContainerGap(-1, 32767)
/*  1538 */           .addComponent((Component)this.materialProgressSpinner1, -2, 32, -2)
/*  1539 */           .addContainerGap()));
/*       */ 
/*       */     
/*  1542 */     GroupLayout jFrame3Layout = new GroupLayout(this.jFrame3.getContentPane());
/*  1543 */     this.jFrame3.getContentPane().setLayout(jFrame3Layout);
/*  1544 */     jFrame3Layout.setHorizontalGroup(jFrame3Layout
/*  1545 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1546 */         .addComponent(this.jPanel166, -1, -1, 32767));
/*       */     
/*  1548 */     jFrame3Layout.setVerticalGroup(jFrame3Layout
/*  1549 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1550 */         .addComponent(this.jPanel166, -1, -1, 32767));
/*       */ 
/*       */     
/*  1553 */     this.jPanel29.setLayout(new GridLayout(1, 2, 40, 0));
/*       */     
/*  1555 */     this.jPanel39.setBackground(new Color(255, 255, 255));
/*  1556 */     this.jPanel39.setLayout(new GridLayout(7, 1, 0, 10));
/*       */     
/*  1558 */     this.jPanel40.setBackground(this.lc.PRIMARIO1);
/*       */     
/*  1560 */     GroupLayout jPanel40Layout = new GroupLayout(this.jPanel40);
/*  1561 */     this.jPanel40.setLayout(jPanel40Layout);
/*  1562 */     jPanel40Layout.setHorizontalGroup(jPanel40Layout
/*  1563 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1564 */         .addGap(0, 324, 32767));
/*       */     
/*  1566 */     jPanel40Layout.setVerticalGroup(jPanel40Layout
/*  1567 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1568 */         .addGap(0, 51, 32767));
/*       */ 
/*       */     
/*  1571 */     this.jPanel39.add(this.jPanel40);
/*       */     
/*  1573 */     this.jPanel41.setBackground(this.lc.PRIMARIO2);
/*       */     
/*  1575 */     GroupLayout jPanel41Layout = new GroupLayout(this.jPanel41);
/*  1576 */     this.jPanel41.setLayout(jPanel41Layout);
/*  1577 */     jPanel41Layout.setHorizontalGroup(jPanel41Layout
/*  1578 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1579 */         .addGap(0, 324, 32767));
/*       */     
/*  1581 */     jPanel41Layout.setVerticalGroup(jPanel41Layout
/*  1582 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1583 */         .addGap(0, 51, 32767));
/*       */ 
/*       */     
/*  1586 */     this.jPanel39.add(this.jPanel41);
/*       */     
/*  1588 */     this.jPanel47.setBackground(this.lc.SECUNDARIO1);
/*       */     
/*  1590 */     GroupLayout jPanel47Layout = new GroupLayout(this.jPanel47);
/*  1591 */     this.jPanel47.setLayout(jPanel47Layout);
/*  1592 */     jPanel47Layout.setHorizontalGroup(jPanel47Layout
/*  1593 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1594 */         .addGap(0, 324, 32767));
/*       */     
/*  1596 */     jPanel47Layout.setVerticalGroup(jPanel47Layout
/*  1597 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1598 */         .addGap(0, 51, 32767));
/*       */ 
/*       */     
/*  1601 */     this.jPanel39.add(this.jPanel47);
/*       */     
/*  1603 */     this.jPanel52.setBackground(this.lc.SECUNDARIO2);
/*       */     
/*  1605 */     GroupLayout jPanel52Layout = new GroupLayout(this.jPanel52);
/*  1606 */     this.jPanel52.setLayout(jPanel52Layout);
/*  1607 */     jPanel52Layout.setHorizontalGroup(jPanel52Layout
/*  1608 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1609 */         .addGap(0, 324, 32767));
/*       */     
/*  1611 */     jPanel52Layout.setVerticalGroup(jPanel52Layout
/*  1612 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1613 */         .addGap(0, 51, 32767));
/*       */ 
/*       */     
/*  1616 */     this.jPanel39.add(this.jPanel52);
/*       */     
/*  1618 */     this.jPanel56.setBackground(this.lc.FONDOCAMPOSELEC);
/*       */     
/*  1620 */     GroupLayout jPanel56Layout = new GroupLayout(this.jPanel56);
/*  1621 */     this.jPanel56.setLayout(jPanel56Layout);
/*  1622 */     jPanel56Layout.setHorizontalGroup(jPanel56Layout
/*  1623 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1624 */         .addGap(0, 324, 32767));
/*       */     
/*  1626 */     jPanel56Layout.setVerticalGroup(jPanel56Layout
/*  1627 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1628 */         .addGap(0, 51, 32767));
/*       */ 
/*       */     
/*  1631 */     this.jPanel39.add(this.jPanel56);
/*       */     
/*  1633 */     this.jPanel153.setBackground(this.lc.FONDOTABLA);
/*       */     
/*  1635 */     GroupLayout jPanel153Layout = new GroupLayout(this.jPanel153);
/*  1636 */     this.jPanel153.setLayout(jPanel153Layout);
/*  1637 */     jPanel153Layout.setHorizontalGroup(jPanel153Layout
/*  1638 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1639 */         .addGap(0, 324, 32767));
/*       */     
/*  1641 */     jPanel153Layout.setVerticalGroup(jPanel153Layout
/*  1642 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1643 */         .addGap(0, 51, 32767));
/*       */ 
/*       */     
/*  1646 */     this.jPanel39.add(this.jPanel153);
/*       */     
/*  1648 */     this.jPanel157.setBackground(this.lc.REJILLATABLA);
/*       */     
/*  1650 */     GroupLayout jPanel157Layout = new GroupLayout(this.jPanel157);
/*  1651 */     this.jPanel157.setLayout(jPanel157Layout);
/*  1652 */     jPanel157Layout.setHorizontalGroup(jPanel157Layout
/*  1653 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1654 */         .addGap(0, 324, 32767));
/*       */     
/*  1656 */     jPanel157Layout.setVerticalGroup(jPanel157Layout
/*  1657 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1658 */         .addGap(0, 51, 32767));
/*       */ 
/*       */     
/*  1661 */     this.jPanel39.add(this.jPanel157);
/*       */     
/*  1663 */     this.jPanel29.add(this.jPanel39);
/*       */     
/*  1665 */     this.jPanel158.setBackground(new Color(255, 255, 255));
/*  1666 */     this.jPanel158.setLayout(new GridLayout(7, 1, 0, 10));
/*       */     
/*  1668 */     this.jPanel159.setBackground(new Color(51, 102, 255));
/*       */     
/*  1670 */     GroupLayout jPanel159Layout = new GroupLayout(this.jPanel159);
/*  1671 */     this.jPanel159.setLayout(jPanel159Layout);
/*  1672 */     jPanel159Layout.setHorizontalGroup(jPanel159Layout
/*  1673 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1674 */         .addGap(0, 324, 32767));
/*       */     
/*  1676 */     jPanel159Layout.setVerticalGroup(jPanel159Layout
/*  1677 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1678 */         .addGap(0, 51, 32767));
/*       */ 
/*       */     
/*  1681 */     this.jPanel158.add(this.jPanel159);
/*       */     
/*  1683 */     this.jPanel160.setBackground(new Color(153, 204, 255));
/*       */     
/*  1685 */     GroupLayout jPanel160Layout = new GroupLayout(this.jPanel160);
/*  1686 */     this.jPanel160.setLayout(jPanel160Layout);
/*  1687 */     jPanel160Layout.setHorizontalGroup(jPanel160Layout
/*  1688 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1689 */         .addGap(0, 324, 32767));
/*       */     
/*  1691 */     jPanel160Layout.setVerticalGroup(jPanel160Layout
/*  1692 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1693 */         .addGap(0, 51, 32767));
/*       */ 
/*       */     
/*  1696 */     this.jPanel158.add(this.jPanel160);
/*       */     
/*  1698 */     this.jPanel161.setBackground(new Color(102, 153, 255));
/*       */     
/*  1700 */     GroupLayout jPanel161Layout = new GroupLayout(this.jPanel161);
/*  1701 */     this.jPanel161.setLayout(jPanel161Layout);
/*  1702 */     jPanel161Layout.setHorizontalGroup(jPanel161Layout
/*  1703 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1704 */         .addGap(0, 324, 32767));
/*       */     
/*  1706 */     jPanel161Layout.setVerticalGroup(jPanel161Layout
/*  1707 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1708 */         .addGap(0, 51, 32767));
/*       */ 
/*       */     
/*  1711 */     this.jPanel158.add(this.jPanel161);
/*       */     
/*  1713 */     this.jPanel162.setBackground(new Color(0, 102, 153));
/*       */     
/*  1715 */     GroupLayout jPanel162Layout = new GroupLayout(this.jPanel162);
/*  1716 */     this.jPanel162.setLayout(jPanel162Layout);
/*  1717 */     jPanel162Layout.setHorizontalGroup(jPanel162Layout
/*  1718 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1719 */         .addGap(0, 324, 32767));
/*       */     
/*  1721 */     jPanel162Layout.setVerticalGroup(jPanel162Layout
/*  1722 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1723 */         .addGap(0, 51, 32767));
/*       */ 
/*       */     
/*  1726 */     this.jPanel158.add(this.jPanel162);
/*       */     
/*  1728 */     this.jPanel163.setBackground(new Color(102, 51, 255));
/*       */     
/*  1730 */     GroupLayout jPanel163Layout = new GroupLayout(this.jPanel163);
/*  1731 */     this.jPanel163.setLayout(jPanel163Layout);
/*  1732 */     jPanel163Layout.setHorizontalGroup(jPanel163Layout
/*  1733 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1734 */         .addGap(0, 324, 32767));
/*       */     
/*  1736 */     jPanel163Layout.setVerticalGroup(jPanel163Layout
/*  1737 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1738 */         .addGap(0, 51, 32767));
/*       */ 
/*       */     
/*  1741 */     this.jPanel158.add(this.jPanel163);
/*       */     
/*  1743 */     this.jPanel164.setBackground(new Color(194, 229, 237));
/*       */     
/*  1745 */     GroupLayout jPanel164Layout = new GroupLayout(this.jPanel164);
/*  1746 */     this.jPanel164.setLayout(jPanel164Layout);
/*  1747 */     jPanel164Layout.setHorizontalGroup(jPanel164Layout
/*  1748 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1749 */         .addGap(0, 324, 32767));
/*       */     
/*  1751 */     jPanel164Layout.setVerticalGroup(jPanel164Layout
/*  1752 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1753 */         .addGap(0, 51, 32767));
/*       */ 
/*       */     
/*  1756 */     this.jPanel158.add(this.jPanel164);
/*       */     
/*  1758 */     this.jPanel165.setBackground(new Color(204, 204, 255));
/*       */     
/*  1760 */     GroupLayout jPanel165Layout = new GroupLayout(this.jPanel165);
/*  1761 */     this.jPanel165.setLayout(jPanel165Layout);
/*  1762 */     jPanel165Layout.setHorizontalGroup(jPanel165Layout
/*  1763 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1764 */         .addGap(0, 324, 32767));
/*       */     
/*  1766 */     jPanel165Layout.setVerticalGroup(jPanel165Layout
/*  1767 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1768 */         .addGap(0, 51, 32767));
/*       */ 
/*       */     
/*  1771 */     this.jPanel158.add(this.jPanel165);
/*       */     
/*  1773 */     this.jPanel29.add(this.jPanel158);
/*       */     
/*  1775 */     GroupLayout jFrame4Layout = new GroupLayout(this.jFrame4.getContentPane());
/*  1776 */     this.jFrame4.getContentPane().setLayout(jFrame4Layout);
/*  1777 */     jFrame4Layout.setHorizontalGroup(jFrame4Layout
/*  1778 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1779 */         .addComponent(this.jPanel29, -1, 689, 32767));
/*       */     
/*  1781 */     jFrame4Layout.setVerticalGroup(jFrame4Layout
/*  1782 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1783 */         .addComponent(this.jPanel29, -1, -1, 32767));
/*       */ 
/*       */     
/*  1786 */     this.jDialog1.setDefaultCloseOperation(0);
/*  1787 */     this.jDialog1.setTitle("Cambiando Contraseña...");
/*  1788 */     this.jDialog1.setModal(true);
/*  1789 */     this.jDialog1.setResizable(false);
/*  1790 */     this.jDialog1.addWindowListener(new WindowAdapter() {
/*       */           public void windowClosing(WindowEvent evt) {
/*  1792 */             Principal.this.jDialog1WindowClosing(evt);
/*       */           }
/*       */         });
/*       */     
/*  1796 */     this.jLabel19.setFont(new Font("Cantarell", 0, 11));
/*  1797 */     this.jLabel19.setForeground(new Color(102, 102, 102));
/*  1798 */     this.jLabel19.setText("<html>Como es la primera ocasión que entras al sistema es necesario que cambies tu contraseña.<br>Mínimo debes agregar 6 caracteres y máximo 30.</html>");
/*       */     
/*  1800 */     this.jPanel11.setLayout(new GridLayout(2, 2, 6, 6));
/*       */     
/*  1802 */     this.jLabel20.setText("Contraseña");
/*  1803 */     this.jPanel11.add(this.jLabel20);
/*       */     
/*  1805 */     this.jPasswordField2.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1807 */             Principal.this.jPasswordField2ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1810 */     this.jPasswordField2.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  1812 */             Principal.this.jPasswordField2KeyReleased(evt);
/*       */           }
/*       */         });
/*  1815 */     this.jPanel11.add(this.jPasswordField2);
/*       */     
/*  1817 */     this.jLabel21.setText("Confirmar Contraseña");
/*  1818 */     this.jPanel11.add(this.jLabel21);
/*       */     
/*  1820 */     this.jPasswordField3.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1822 */             Principal.this.jPasswordField3ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1825 */     this.jPasswordField3.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  1827 */             Principal.this.jPasswordField3KeyReleased(evt);
/*       */           }
/*       */         });
/*  1830 */     this.jPanel11.add(this.jPasswordField3);
/*       */     
/*  1832 */     this.materialButton10.setBackground(this.lc.SECUNDARIO1);
/*  1833 */     this.materialButton10.setForeground(new Color(255, 255, 255));
/*  1834 */     this.materialButton10.setMnemonic('S');
/*  1835 */     this.materialButton10.setText("Salir");
/*  1836 */     this.materialButton10.setToolTipText("Salir (Alt+S)");
/*  1837 */     this.materialButton10.setFont(new Font("Cantarell", 0, 12));
/*  1838 */     this.materialButton10.setHorizontalTextPosition(0);
/*  1839 */     this.materialButton10.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1841 */             Principal.this.materialButton10ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1845 */     this.materialButton11.setBackground(this.lc.PRIMARIO1);
/*  1846 */     this.materialButton11.setForeground(new Color(255, 255, 255));
/*  1847 */     this.materialButton11.setMnemonic('A');
/*  1848 */     this.materialButton11.setText("Cambiar");
/*  1849 */     this.materialButton11.setToolTipText("Cambiar (Alt+A)");
/*  1850 */     this.materialButton11.setFont(new Font("Cantarell", 0, 12));
/*  1851 */     this.materialButton11.setHorizontalTextPosition(0);
/*  1852 */     this.materialButton11.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1854 */             Principal.this.materialButton11ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1858 */     this.jLabel10.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.ITALIC, 11.0F));
/*  1859 */     this.jLabel10.setForeground(this.lc.PRIMARIO1);
/*  1860 */     this.jLabel10.setText(" ");
/*       */     
/*  1862 */     GroupLayout jPanel23Layout = new GroupLayout(this.jPanel23);
/*  1863 */     this.jPanel23.setLayout(jPanel23Layout);
/*  1864 */     jPanel23Layout.setHorizontalGroup(jPanel23Layout
/*  1865 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1866 */         .addComponent(this.jLabel19)
/*  1867 */         .addGroup(jPanel23Layout.createSequentialGroup()
/*  1868 */           .addContainerGap()
/*  1869 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1870 */             .addComponent(this.jPanel11, -1, -1, 32767)
/*  1871 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
/*  1872 */               .addGap(0, 0, 32767)
/*  1873 */               .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1874 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
/*  1875 */                   .addComponent((Component)this.materialButton11, -2, 150, -2)
/*  1876 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1877 */                   .addComponent((Component)this.materialButton10, -2, 105, -2))
/*  1878 */                 .addComponent(this.jLabel10, GroupLayout.Alignment.TRAILING, -2, 162, -2))))
/*  1879 */           .addContainerGap()));
/*       */     
/*  1881 */     jPanel23Layout.setVerticalGroup(jPanel23Layout
/*  1882 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1883 */         .addGroup(jPanel23Layout.createSequentialGroup()
/*  1884 */           .addComponent(this.jLabel19, -2, 74, -2)
/*  1885 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1886 */           .addComponent(this.jPanel11, -2, 56, -2)
/*  1887 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1888 */           .addComponent(this.jLabel10)
/*  1889 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1890 */           .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  1891 */             .addComponent((Component)this.materialButton10, -2, 38, -2)
/*  1892 */             .addComponent((Component)this.materialButton11, -2, 38, -2))
/*  1893 */           .addContainerGap(-1, 32767)));
/*       */ 
/*       */     
/*  1896 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  1897 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  1898 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  1899 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1900 */         .addComponent(this.jPanel23, -1, -1, 32767));
/*       */     
/*  1902 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  1903 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1904 */         .addComponent(this.jPanel23, -2, -1, -2));
/*       */ 
/*       */     
/*  1907 */     this.jDialog2.setTitle("Créditos");
/*  1908 */     this.jDialog2.setResizable(false);
/*       */     
/*  1910 */     this.jLabel33.setFont(new Font("Cantarell", 1, 22));
/*  1911 */     this.jLabel33.setForeground(this.lc.PRIMARIO1);
/*  1912 */     this.jLabel33.setHorizontalAlignment(0);
/*  1913 */     this.jLabel33.setText("SICRET");
/*       */     
/*  1915 */     this.jLabel35.setFont(new Font("Cantarell", 1, 13));
/*  1916 */     this.jLabel35.setForeground(this.lc.SECUNDARIO1);
/*  1917 */     this.jLabel35.setHorizontalAlignment(0);
/*  1918 */     this.jLabel35.setText("<html><font size=4><center><b>S</b>istema <b>I</b>ntegral para el <b>C</b>ontrol de <b>R</b>esiduos y <b>E</b>mpleados <b>T</b>ransportistas</center></font></html>");
/*       */     
/*  1920 */     this.jLabel37.setFont(new Font("Cantarell", 0, 11));
/*  1921 */     this.jLabel37.setForeground(this.lc.PRIMARIO2);
/*  1922 */     this.jLabel37.setText("<html>SICRET está diseñado por Uzziel Contreras Portilla - kofuz01@hotmail.com, kofuz01@gmail.com, en la ciudad de Poza Rica Veracruz. Se prohibe su distribución parcial o total así como la  modificación del código sin los permisos del autor.</html>");
/*       */     
/*  1924 */     GroupLayout jPanel46Layout = new GroupLayout(this.jPanel46);
/*  1925 */     this.jPanel46.setLayout(jPanel46Layout);
/*  1926 */     jPanel46Layout.setHorizontalGroup(jPanel46Layout
/*  1927 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1928 */         .addComponent(this.jLabel33, -1, -1, 32767)
/*  1929 */         .addComponent(this.jLabel35)
/*  1930 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
/*  1931 */           .addContainerGap()
/*  1932 */           .addGroup(jPanel46Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  1933 */             .addComponent(this.jLabel37, -2, 0, 32767)
/*  1934 */             .addComponent(this.jSeparator14))
/*  1935 */           .addContainerGap()));
/*       */     
/*  1937 */     jPanel46Layout.setVerticalGroup(jPanel46Layout
/*  1938 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1939 */         .addGroup(jPanel46Layout.createSequentialGroup()
/*  1940 */           .addComponent(this.jLabel33, -2, 34, -2)
/*  1941 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1942 */           .addComponent(this.jLabel35, -2, 38, -2)
/*  1943 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1944 */           .addComponent(this.jSeparator14, -2, 10, -2)
/*  1945 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1946 */           .addComponent(this.jLabel37, -1, 97, 32767)
/*  1947 */           .addContainerGap()));
/*       */ 
/*       */     
/*  1950 */     this.jLabel32.setHorizontalAlignment(0);
/*  1951 */     this.jLabel32.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/sicret2.png")));
/*       */     
/*  1953 */     this.jLabel38.setFont(new Font("Ubuntu Semi-Light", 2, 11));
/*  1954 */     this.jLabel38.setForeground(Color.darkGray);
/*  1955 */     this.jLabel38.setHorizontalAlignment(4);
/*  1956 */     this.jLabel38.setText("Todos los derechos reservados por Copyrigth ");
/*       */     
/*  1958 */     this.jLabel39.setFont(new Font("Cantarell", 1, 12));
/*  1959 */     this.jLabel39.setHorizontalAlignment(0);
/*  1960 */     this.jLabel39.setText("Versión 1.5");
/*       */     
/*  1962 */     this.jLabel40.setFont(new Font("Cantarell", 2, 10));
/*  1963 */     this.jLabel40.setHorizontalAlignment(0);
/*  1964 */     this.jLabel40.setText("Fecha: 4 de Enero de 2018");
/*       */     
/*  1966 */     GroupLayout jPanel42Layout = new GroupLayout(this.jPanel42);
/*  1967 */     this.jPanel42.setLayout(jPanel42Layout);
/*  1968 */     jPanel42Layout.setHorizontalGroup(jPanel42Layout
/*  1969 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1970 */         .addGroup(jPanel42Layout.createSequentialGroup()
/*  1971 */           .addGroup(jPanel42Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  1972 */             .addComponent(this.jLabel32, -1, 207, 32767)
/*  1973 */             .addComponent(this.jLabel39, -1, -1, 32767)
/*  1974 */             .addComponent(this.jLabel40, -1, -1, 32767))
/*  1975 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1976 */           .addComponent(this.jPanel46, -1, -1, 32767))
/*  1977 */         .addComponent(this.jLabel38, -1, -1, 32767));
/*       */     
/*  1979 */     jPanel42Layout.setVerticalGroup(jPanel42Layout
/*  1980 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1981 */         .addGroup(jPanel42Layout.createSequentialGroup()
/*  1982 */           .addGroup(jPanel42Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1983 */             .addGroup(jPanel42Layout.createSequentialGroup()
/*  1984 */               .addComponent(this.jLabel32, -2, 149, -2)
/*  1985 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1986 */               .addComponent(this.jLabel39)
/*  1987 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1988 */               .addComponent(this.jLabel40))
/*  1989 */             .addComponent(this.jPanel46, -2, -1, -2))
/*  1990 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1991 */           .addComponent(this.jLabel38, -2, 26, -2)));
/*       */ 
/*       */     
/*  1994 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*  1995 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*  1996 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*  1997 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1998 */         .addComponent(this.jPanel42, -1, -1, 32767));
/*       */     
/*  2000 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/*  2001 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2002 */         .addComponent(this.jPanel42, -1, -1, 32767));
/*       */ 
/*       */     
/*  2005 */     this.jDialog4.setTitle("Licencias Vencidas");
/*       */     
/*  2007 */     this.rSTableMetro2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*       */         {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*  2015 */           boolean[] canEdit = new boolean[] { false, false };
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  2020 */             return this.canEdit[columnIndex];
/*       */           }
/*       */         });
/*  2023 */     this.rSTableMetro2.setAltoHead(25);
/*  2024 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  2025 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/*  2026 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/*  2027 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/*  2028 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/*  2029 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/*  2030 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/*  2031 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  2032 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  2033 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/*  2034 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/*  2035 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/*  2036 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/*  2037 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/*  2038 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  2040 */             Principal.this.rSTableMetro2MouseClicked(evt);
/*       */           }
/*       */         });
/*  2043 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  2045 */             Principal.this.rSTableMetro2KeyReleased(evt);
/*       */           }
/*       */         });
/*  2048 */     this.jScrollPane12.setViewportView((Component)this.rSTableMetro2);
/*  2049 */     if (this.rSTableMetro2.getColumnModel().getColumnCount() > 0) {
/*  2050 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMinWidth(80);
/*  2051 */       this.rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(80);
/*  2052 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMaxWidth(80);
/*  2053 */       this.rSTableMetro2.getColumnModel().getColumn(1).setResizable(false);
/*       */     } 
/*       */     
/*  2056 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/*  2057 */     this.jPanel13.setLayout(jPanel13Layout);
/*  2058 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/*  2059 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2060 */         .addComponent(this.jScrollPane12));
/*       */     
/*  2062 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/*  2063 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2064 */         .addComponent(this.jScrollPane12, -1, 196, 32767));
/*       */ 
/*       */     
/*  2067 */     this.jPanel20.setBackground(this.lc.SECUNDARIO1);
/*       */     
/*  2069 */     this.jLabel16.setFont(new Font("Cantarell", 1, 13));
/*  2070 */     this.jLabel16.setForeground(new Color(255, 255, 255));
/*  2071 */     this.jLabel16.setText(" En la siguiente lista se muestran los vencimientos de las licencias:");
/*       */     
/*  2073 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/*  2074 */     this.jPanel20.setLayout(jPanel20Layout);
/*  2075 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/*  2076 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2077 */         .addGroup(jPanel20Layout.createSequentialGroup()
/*  2078 */           .addComponent(this.jLabel16, -2, 465, -2)
/*  2079 */           .addGap(0, 24, 32767)));
/*       */     
/*  2081 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/*  2082 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2083 */         .addComponent(this.jLabel16, -1, 27, 32767));
/*       */ 
/*       */     
/*  2086 */     GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
/*  2087 */     this.jPanel21.setLayout(jPanel21Layout);
/*  2088 */     jPanel21Layout.setHorizontalGroup(jPanel21Layout
/*  2089 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2090 */         .addGap(0, 0, 32767));
/*       */     
/*  2092 */     jPanel21Layout.setVerticalGroup(jPanel21Layout
/*  2093 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2094 */         .addGap(0, 100, 32767));
/*       */ 
/*       */     
/*  2097 */     GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
/*  2098 */     this.jPanel22.setLayout(jPanel22Layout);
/*  2099 */     jPanel22Layout.setHorizontalGroup(jPanel22Layout
/*  2100 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2101 */         .addGap(0, 289, 32767));
/*       */     
/*  2103 */     jPanel22Layout.setVerticalGroup(jPanel22Layout
/*  2104 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2105 */         .addGap(0, 40, 32767));
/*       */ 
/*       */     
/*  2108 */     this.jPanel24.setBackground(this.lc.PRIMARIO1);
/*       */     
/*  2110 */     this.jLabel17.setFont(new Font("Cantarell", 1, 13));
/*  2111 */     this.jLabel17.setForeground(new Color(255, 255, 255));
/*  2112 */     this.jLabel17.setHorizontalAlignment(0);
/*  2113 */     this.jLabel17.setText("Fotografía");
/*       */     
/*  2115 */     GroupLayout jPanel24Layout = new GroupLayout(this.jPanel24);
/*  2116 */     this.jPanel24.setLayout(jPanel24Layout);
/*  2117 */     jPanel24Layout.setHorizontalGroup(jPanel24Layout
/*  2118 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2119 */         .addComponent(this.jLabel17, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*       */     
/*  2121 */     jPanel24Layout.setVerticalGroup(jPanel24Layout
/*  2122 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2123 */         .addComponent(this.jLabel17, -1, -1, 32767));
/*       */ 
/*       */     
/*  2126 */     this.cLabel1.setText("");
/*  2127 */     this.cLabel1.setHorizontalTextPosition(0);
/*  2128 */     this.cLabel1.setLineColor(null);
/*       */     
/*  2130 */     GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
/*  2131 */     this.jPanel26.setLayout(jPanel26Layout);
/*  2132 */     jPanel26Layout.setHorizontalGroup(jPanel26Layout
/*  2133 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2134 */         .addGroup(jPanel26Layout.createSequentialGroup()
/*  2135 */           .addGap(42, 42, 42)
/*  2136 */           .addComponent((Component)this.cLabel1, -2, 174, -2)
/*  2137 */           .addContainerGap(-1, 32767)));
/*       */     
/*  2139 */     jPanel26Layout.setVerticalGroup(jPanel26Layout
/*  2140 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2141 */         .addGroup(jPanel26Layout.createSequentialGroup()
/*  2142 */           .addContainerGap()
/*  2143 */           .addComponent((Component)this.cLabel1, -2, 177, -2)
/*  2144 */           .addContainerGap(-1, 32767)));
/*       */ 
/*       */     
/*  2147 */     this.jPanel18.setBackground(this.lc.PRIMARIO1);
/*  2148 */     this.jPanel18.setLayout(new GridLayout(1, 0));
/*       */     
/*  2150 */     this.jLabel22.setFont(new Font("Cantarell", 1, 13));
/*  2151 */     this.jLabel22.setForeground(new Color(255, 255, 255));
/*  2152 */     this.jLabel22.setHorizontalAlignment(0);
/*  2153 */     this.jLabel22.setText("jLabel22");
/*  2154 */     this.jPanel18.add(this.jLabel22);
/*       */     
/*  2156 */     this.jLabel7.setFont(new Font("Cantarell", 0, 10));
/*  2157 */     this.jLabel7.setText(" Total");
/*       */     
/*  2159 */     this.materialButton12.setBackground(new Color(102, 102, 102));
/*  2160 */     this.materialButton12.setForeground(new Color(255, 255, 255));
/*  2161 */     this.materialButton12.setMnemonic('C');
/*  2162 */     this.materialButton12.setText("Cerrar");
/*  2163 */     this.materialButton12.setToolTipText("Cerrar (Alt+C)");
/*  2164 */     this.materialButton12.setFont(new Font("Cantarell", 0, 12));
/*  2165 */     this.materialButton12.setHorizontalTextPosition(0);
/*  2166 */     this.materialButton12.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2168 */             Principal.this.materialButton12ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2172 */     this.materialButton13.setBackground(this.lc.PRIMARIO1);
/*  2173 */     this.materialButton13.setForeground(new Color(255, 255, 255));
/*  2174 */     this.materialButton13.setMnemonic('I');
/*  2175 */     this.materialButton13.setText("Imprimir");
/*  2176 */     this.materialButton13.setToolTipText("Imprimir (Alt+I)");
/*  2177 */     this.materialButton13.setFont(new Font("Cantarell", 0, 12));
/*  2178 */     this.materialButton13.setHorizontalTextPosition(0);
/*  2179 */     this.materialButton13.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2181 */             Principal.this.materialButton13ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2185 */     GroupLayout jPanel28Layout = new GroupLayout(this.jPanel28);
/*  2186 */     this.jPanel28.setLayout(jPanel28Layout);
/*  2187 */     jPanel28Layout.setHorizontalGroup(jPanel28Layout
/*  2188 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2189 */         .addGroup(jPanel28Layout.createSequentialGroup()
/*  2190 */           .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  2191 */             .addComponent(this.jPanel20, -1, -1, 32767)
/*  2192 */             .addComponent(this.jPanel13, -1, -1, 32767)
/*  2193 */             .addGroup(jPanel28Layout.createSequentialGroup()
/*  2194 */               .addComponent(this.jLabel7, -2, 63, -2)
/*  2195 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2196 */               .addComponent(this.jPanel18, -2, 122, -2)))
/*  2197 */           .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2198 */             .addGroup(jPanel28Layout.createSequentialGroup()
/*  2199 */               .addGap(0, 0, 32767)
/*  2200 */               .addComponent(this.jPanel21, -2, -1, -2)
/*  2201 */               .addGap(733, 733, 733))
/*  2202 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
/*  2203 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2204 */               .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  2205 */                 .addComponent(this.jPanel24, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  2206 */                 .addComponent(this.jPanel26, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  2207 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel28Layout.createSequentialGroup()
/*  2208 */                   .addComponent((Component)this.materialButton13, -2, 150, -2)
/*  2209 */                   .addGap(1, 1, 1)
/*  2210 */                   .addComponent((Component)this.materialButton12, -2, 105, -2)
/*  2211 */                   .addGap(0, 0, 32767)))
/*  2212 */               .addGap(178, 178, 178)
/*  2213 */               .addComponent(this.jPanel22, -2, -1, -2)))
/*  2214 */           .addContainerGap()));
/*       */     
/*  2216 */     jPanel28Layout.setVerticalGroup(jPanel28Layout
/*  2217 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2218 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
/*  2219 */           .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  2220 */             .addComponent(this.jPanel20, -1, -1, 32767)
/*  2221 */             .addComponent(this.jPanel24, -1, -1, 32767))
/*  2222 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2223 */           .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2224 */             .addGroup(jPanel28Layout.createSequentialGroup()
/*  2225 */               .addComponent(this.jPanel13, -2, -1, -2)
/*  2226 */               .addGap(18, 18, 18)
/*  2227 */               .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  2228 */                 .addComponent(this.jLabel7, -1, -1, 32767)
/*  2229 */                 .addComponent(this.jPanel18, -2, 21, -2))
/*  2230 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  2231 */               .addComponent(this.jPanel21, -2, -1, -2)
/*  2232 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2233 */               .addComponent(this.jPanel22, -2, -1, -2))
/*  2234 */             .addGroup(jPanel28Layout.createSequentialGroup()
/*  2235 */               .addComponent(this.jPanel26, -2, -1, -2)
/*  2236 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2237 */               .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2238 */                 .addComponent((Component)this.materialButton12, -2, 38, -2)
/*  2239 */                 .addComponent((Component)this.materialButton13, -2, 38, -2))
/*  2240 */               .addGap(0, 0, 32767)))
/*  2241 */           .addContainerGap()));
/*       */ 
/*       */     
/*  2244 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/*  2245 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/*  2246 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/*  2247 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2248 */         .addComponent(this.jPanel28, -2, 763, -2));
/*       */     
/*  2250 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/*  2251 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2252 */         .addComponent(this.jPanel28, -2, 273, -2));
/*       */ 
/*       */     
/*  2255 */     this.jDialog5.setTitle("Búsqueda de Operadores");
/*  2256 */     this.jDialog5.setModal(true);
/*       */     
/*  2258 */     this.jLabel58.setFont(new Font("Cantarell", 0, 11));
/*  2259 */     this.jLabel58.setHorizontalAlignment(4);
/*  2260 */     this.jLabel58.setText("Clave");
/*       */     
/*  2262 */     this.jLabel61.setFont(new Font("Cantarell", 0, 11));
/*  2263 */     this.jLabel61.setHorizontalAlignment(4);
/*  2264 */     this.jLabel61.setText("Nombre");
/*       */     
/*  2266 */     this.materialButton14.setBackground(this.lc.SECUNDARIO1);
/*  2267 */     this.materialButton14.setForeground(new Color(255, 255, 255));
/*  2268 */     this.materialButton14.setMnemonic('C');
/*  2269 */     this.materialButton14.setText("Cerrar");
/*  2270 */     this.materialButton14.setToolTipText("Cerrar (Alt+C)");
/*  2271 */     this.materialButton14.setFont(new Font("Cantarell", 0, 12));
/*  2272 */     this.materialButton14.setHorizontalTextPosition(0);
/*  2273 */     this.materialButton14.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2275 */             Principal.this.materialButton14ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2279 */     this.materialButton15.setBackground(this.lc.PRIMARIO1);
/*  2280 */     this.materialButton15.setForeground(new Color(255, 255, 255));
/*  2281 */     this.materialButton15.setMnemonic('A');
/*  2282 */     this.materialButton15.setText("Agregar");
/*  2283 */     this.materialButton15.setToolTipText("Agregar (Alt+A)");
/*  2284 */     this.materialButton15.setEnabled(false);
/*  2285 */     this.materialButton15.setFont(new Font("Cantarell", 0, 12));
/*  2286 */     this.materialButton15.setHorizontalTextPosition(0);
/*  2287 */     this.materialButton15.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2289 */             Principal.this.materialButton15ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2293 */     this.rSTableMetro3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*       */         {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*  2301 */           boolean[] canEdit = new boolean[] { false, false };
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  2306 */             return this.canEdit[columnIndex];
/*       */           }
/*       */         });
/*  2309 */     this.rSTableMetro3.setAltoHead(25);
/*  2310 */     this.rSTableMetro3.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  2311 */     this.rSTableMetro3.setColorBordeFilas(new Color(200, 200, 200));
/*  2312 */     this.rSTableMetro3.setColorBordeHead(this.lc.PRIMARIO1);
/*  2313 */     this.rSTableMetro3.setColorFilasBackgound2(new Color(239, 239, 239));
/*  2314 */     this.rSTableMetro3.setColorFilasForeground1(new Color(102, 102, 102));
/*  2315 */     this.rSTableMetro3.setColorFilasForeground2(new Color(102, 102, 102));
/*  2316 */     this.rSTableMetro3.setColorSelBackgound(new Color(237, 107, 107));
/*  2317 */     this.rSTableMetro3.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  2318 */     this.rSTableMetro3.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  2319 */     this.rSTableMetro3.setFuenteHead(new Font("Cantarell", 1, 12));
/*  2320 */     this.rSTableMetro3.setGrosorBordeFilas(0);
/*  2321 */     this.rSTableMetro3.setSelectionBackground(this.lc.PRIMARIO2);
/*  2322 */     this.rSTableMetro3.getTableHeader().setResizingAllowed(false);
/*  2323 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/*  2324 */     this.rSTableMetro3.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  2326 */             Principal.this.rSTableMetro3MouseClicked(evt);
/*       */           }
/*       */         });
/*  2329 */     this.rSTableMetro3.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  2331 */             Principal.this.rSTableMetro3KeyReleased(evt);
/*       */           }
/*       */         });
/*  2334 */     this.jScrollPane13.setViewportView((Component)this.rSTableMetro3);
/*  2335 */     if (this.rSTableMetro3.getColumnModel().getColumnCount() > 0) {
/*  2336 */       this.rSTableMetro3.getColumnModel().getColumn(0).setMinWidth(80);
/*  2337 */       this.rSTableMetro3.getColumnModel().getColumn(0).setPreferredWidth(80);
/*  2338 */       this.rSTableMetro3.getColumnModel().getColumn(0).setMaxWidth(80);
/*  2339 */       this.rSTableMetro3.getColumnModel().getColumn(1).setResizable(false);
/*       */     } 
/*       */     
/*  2342 */     this.metroTextBox1.setSelectionColor(new Color(237, 107, 107));
/*  2343 */     this.metroTextBox1.addCaretListener(new CaretListener() {
/*       */           public void caretUpdate(CaretEvent evt) {
/*  2345 */             Principal.this.metroTextBox1CaretUpdate(evt);
/*       */           }
/*       */         });
/*  2348 */     this.metroTextBox1.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  2350 */             Principal.this.metroTextBox1KeyReleased(evt);
/*       */           }
/*       */         });
/*       */     
/*  2354 */     this.metroTextBox2.addCaretListener(new CaretListener() {
/*       */           public void caretUpdate(CaretEvent evt) {
/*  2356 */             Principal.this.metroTextBox2CaretUpdate(evt);
/*       */           }
/*       */         });
/*  2359 */     this.metroTextBox2.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  2361 */             Principal.this.metroTextBox2KeyReleased(evt);
/*       */           }
/*       */         });
/*       */     
/*  2365 */     GroupLayout jPanel32Layout = new GroupLayout(this.jPanel32);
/*  2366 */     this.jPanel32.setLayout(jPanel32Layout);
/*  2367 */     jPanel32Layout.setHorizontalGroup(jPanel32Layout
/*  2368 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2369 */         .addGroup(jPanel32Layout.createSequentialGroup()
/*  2370 */           .addContainerGap()
/*  2371 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2372 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
/*  2373 */               .addGap(0, 0, 32767)
/*  2374 */               .addComponent((Component)this.materialButton15, -2, 150, -2)
/*  2375 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2376 */               .addComponent((Component)this.materialButton14, -2, 105, -2))
/*  2377 */             .addComponent(this.jScrollPane13, -1, 416, 32767)
/*  2378 */             .addGroup(jPanel32Layout.createSequentialGroup()
/*  2379 */               .addComponent(this.jLabel58, -2, 40, -2)
/*  2380 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2381 */               .addComponent((Component)this.metroTextBox1, -2, 67, -2)
/*  2382 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  2383 */               .addComponent(this.jLabel61, -2, 57, -2)
/*  2384 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2385 */               .addComponent((Component)this.metroTextBox2, -2, 139, -2)
/*  2386 */               .addGap(33, 33, 33)))
/*  2387 */           .addContainerGap()));
/*       */     
/*  2389 */     jPanel32Layout.setVerticalGroup(jPanel32Layout
/*  2390 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2391 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
/*  2392 */           .addContainerGap()
/*  2393 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2394 */             .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2395 */               .addComponent((Component)this.metroTextBox1, -2, 25, -2)
/*  2396 */               .addComponent(this.jLabel58))
/*  2397 */             .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2398 */               .addComponent(this.jLabel61)
/*  2399 */               .addComponent((Component)this.metroTextBox2, -2, 25, -2)))
/*  2400 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2401 */           .addComponent(this.jScrollPane13, -1, 186, 32767)
/*  2402 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2403 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2404 */             .addComponent((Component)this.materialButton14, -2, 38, -2)
/*  2405 */             .addComponent((Component)this.materialButton15, -2, 38, -2))
/*  2406 */           .addGap(2, 2, 2)));
/*       */ 
/*       */     
/*  2409 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/*  2410 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/*  2411 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/*  2412 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2413 */         .addComponent(this.jPanel32, -1, -1, 32767));
/*       */     
/*  2415 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/*  2416 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2417 */         .addComponent(this.jPanel32, -1, -1, 32767));
/*       */ 
/*       */     
/*  2420 */     this.jDialog8.setTitle("Licencia Vencida");
/*  2421 */     this.jDialog8.setModal(true);
/*       */     
/*  2423 */     this.jPanel33.setBackground(new Color(255, 255, 255));
/*       */     
/*  2425 */     this.jLabel97.setFont(new Font("Cantarell", 1, 22));
/*  2426 */     this.jLabel97.setForeground(this.lc.PRIMARIO1);
/*  2427 */     this.jLabel97.setHorizontalAlignment(0);
/*  2428 */     this.jLabel97.setText("Próximo Vencimiento de Licencia");
/*       */     
/*  2430 */     this.jLabel98.setFont(new Font("Cantarell", 1, 13));
/*  2431 */     this.jLabel98.setForeground(this.lc.PRIMARIO2);
/*  2432 */     this.jLabel98.setHorizontalAlignment(0);
/*  2433 */     this.jLabel98.setText("<html><center>LA LICENCIA DEL OPERADOR QUE SELECCIONASTE ESTÁ PRÓXIMA A VENCER</center></html>");
/*       */     
/*  2435 */     this.jLabel99.setFont(new Font("Cantarell", 3, 13));
/*  2436 */     this.jLabel99.setHorizontalAlignment(0);
/*  2437 */     this.jLabel99.setText("<html><center>La vigencia de la licencia se vencerá en menos de un mes, si no se renueva no se podrá dar viajes en éste módulo.</center></html>");
/*       */     
/*  2439 */     this.jLabel100.setHorizontalAlignment(0);
/*  2440 */     this.jLabel100.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/escudo.png")));
/*       */     
/*  2442 */     this.materialButton16.setBackground(this.lc.SECUNDARIO1);
/*  2443 */     this.materialButton16.setForeground(new Color(255, 255, 255));
/*  2444 */     this.materialButton16.setMnemonic('C');
/*  2445 */     this.materialButton16.setText("Cerrar");
/*  2446 */     this.materialButton16.setToolTipText("Cerrar (Alt+C)");
/*  2447 */     this.materialButton16.setFont(new Font("Cantarell", 0, 12));
/*  2448 */     this.materialButton16.setHorizontalTextPosition(0);
/*  2449 */     this.materialButton16.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2451 */             Principal.this.materialButton16ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2455 */     GroupLayout jPanel33Layout = new GroupLayout(this.jPanel33);
/*  2456 */     this.jPanel33.setLayout(jPanel33Layout);
/*  2457 */     jPanel33Layout.setHorizontalGroup(jPanel33Layout
/*  2458 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2459 */         .addGroup(jPanel33Layout.createSequentialGroup()
/*  2460 */           .addContainerGap()
/*  2461 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  2462 */             .addComponent(this.jSeparator9, GroupLayout.Alignment.LEADING, -1, 626, 32767)
/*  2463 */             .addComponent(this.jLabel97, GroupLayout.Alignment.LEADING, -1, 628, 32767)
/*  2464 */             .addGroup(jPanel33Layout.createSequentialGroup()
/*  2465 */               .addComponent(this.jLabel100, -1, 155, 32767)
/*  2466 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2467 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2468 */                 .addComponent(this.jSeparator10, -1, 467, 32767)
/*  2469 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
/*  2470 */                   .addGap(0, 0, 32767)
/*  2471 */                   .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2472 */                     .addGroup(GroupLayout.Alignment.TRAILING, jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  2473 */                       .addComponent(this.jLabel99, GroupLayout.Alignment.TRAILING, 0, 0, 32767)
/*  2474 */                       .addComponent(this.jLabel98, GroupLayout.Alignment.TRAILING, -1, 466, 32767))
/*  2475 */                     .addComponent((Component)this.materialButton16, GroupLayout.Alignment.TRAILING, -2, 105, -2))))))
/*  2476 */           .addContainerGap()));
/*       */     
/*  2478 */     jPanel33Layout.setVerticalGroup(jPanel33Layout
/*  2479 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2480 */         .addGroup(jPanel33Layout.createSequentialGroup()
/*  2481 */           .addComponent(this.jLabel97)
/*  2482 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2483 */           .addComponent(this.jSeparator9, -2, 10, -2)
/*  2484 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2485 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2486 */             .addGroup(jPanel33Layout.createSequentialGroup()
/*  2487 */               .addComponent(this.jLabel100, -2, 167, -2)
/*  2488 */               .addContainerGap(14, 32767))
/*  2489 */             .addGroup(jPanel33Layout.createSequentialGroup()
/*  2490 */               .addComponent(this.jLabel98, -2, 57, -2)
/*  2491 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2492 */               .addComponent(this.jLabel99, -2, 56, -2)
/*  2493 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2494 */               .addComponent(this.jSeparator10, -2, 10, -2)
/*  2495 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  2496 */               .addComponent((Component)this.materialButton16, -2, 38, -2)))));
/*       */ 
/*       */     
/*  2499 */     GroupLayout jDialog8Layout = new GroupLayout(this.jDialog8.getContentPane());
/*  2500 */     this.jDialog8.getContentPane().setLayout(jDialog8Layout);
/*  2501 */     jDialog8Layout.setHorizontalGroup(jDialog8Layout
/*  2502 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2503 */         .addComponent(this.jPanel33, -1, -1, 32767));
/*       */     
/*  2505 */     jDialog8Layout.setVerticalGroup(jDialog8Layout
/*  2506 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2507 */         .addComponent(this.jPanel33, -1, -1, 32767));
/*       */ 
/*       */     
/*  2510 */     this.jDialog6.setTitle("Cambiar de estatus");
/*       */     
/*  2512 */     this.jTextArea2.setEditable(false);
/*  2513 */     this.jTextArea2.setColumns(20);
/*  2514 */     this.jTextArea2.setRows(5);
/*  2515 */     this.jScrollPane7.setViewportView(this.jTextArea2);
/*       */     
/*  2517 */     this.jLabel26.setText("Cambiar a:");
/*       */     
/*  2519 */     this.jComboBox2.setEditable(true);
/*  2520 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "EN ESPERA", "EN TALLER", "EN LA TALACHERA", "EN DESCANSO", "SE NEGÓ AL VIAJE" }));
/*       */     
/*  2522 */     this.jLabel29.setText("Comentario");
/*       */     
/*  2524 */     this.jTextArea4.setColumns(20);
/*  2525 */     this.jTextArea4.setRows(4);
/*  2526 */     this.jScrollPane10.setViewportView(this.jTextArea4);
/*       */     
/*  2528 */     this.materialButton17.setBackground(this.lc.SECUNDARIO1);
/*  2529 */     this.materialButton17.setForeground(new Color(255, 255, 255));
/*  2530 */     this.materialButton17.setMnemonic('C');
/*  2531 */     this.materialButton17.setText("Cerrar");
/*  2532 */     this.materialButton17.setToolTipText("Cerrar (Alt+C)");
/*  2533 */     this.materialButton17.setFont(new Font("Cantarell", 0, 12));
/*  2534 */     this.materialButton17.setHorizontalTextPosition(0);
/*  2535 */     this.materialButton17.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2537 */             Principal.this.materialButton17ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2541 */     this.materialButton18.setBackground(this.lc.PRIMARIO1);
/*  2542 */     this.materialButton18.setForeground(new Color(255, 255, 255));
/*  2543 */     this.materialButton18.setMnemonic('A');
/*  2544 */     this.materialButton18.setText("Aceptar");
/*  2545 */     this.materialButton18.setToolTipText("Aceptar (Alt+A)");
/*  2546 */     this.materialButton18.setFont(new Font("Cantarell", 0, 12));
/*  2547 */     this.materialButton18.setHorizontalTextPosition(0);
/*  2548 */     this.materialButton18.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2550 */             Principal.this.materialButton18ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2554 */     GroupLayout jPanel34Layout = new GroupLayout(this.jPanel34);
/*  2555 */     this.jPanel34.setLayout(jPanel34Layout);
/*  2556 */     jPanel34Layout.setHorizontalGroup(jPanel34Layout
/*  2557 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2558 */         .addGroup(jPanel34Layout.createSequentialGroup()
/*  2559 */           .addContainerGap()
/*  2560 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2561 */             .addComponent(this.jSeparator11)
/*  2562 */             .addComponent(this.jScrollPane7, GroupLayout.Alignment.TRAILING)
/*  2563 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
/*  2564 */               .addGap(0, 0, 32767)
/*  2565 */               .addComponent((Component)this.materialButton18, -2, 150, -2)
/*  2566 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2567 */               .addComponent((Component)this.materialButton17, -2, 105, -2))
/*  2568 */             .addGroup(jPanel34Layout.createSequentialGroup()
/*  2569 */               .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  2570 */                 .addComponent(this.jLabel29, GroupLayout.Alignment.LEADING, -1, 78, 32767)
/*  2571 */                 .addComponent(this.jLabel26, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/*  2572 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2573 */               .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2574 */                 .addComponent(this.jComboBox2, 0, -1, 32767)
/*  2575 */                 .addComponent(this.jScrollPane10, -1, 349, 32767))))
/*  2576 */           .addContainerGap()));
/*       */     
/*  2578 */     jPanel34Layout.setVerticalGroup(jPanel34Layout
/*  2579 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2580 */         .addGroup(jPanel34Layout.createSequentialGroup()
/*  2581 */           .addComponent(this.jScrollPane7, -2, -1, -2)
/*  2582 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2583 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2584 */             .addComponent(this.jLabel26)
/*  2585 */             .addComponent(this.jComboBox2, -2, -1, -2))
/*  2586 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2587 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2588 */             .addComponent(this.jLabel29)
/*  2589 */             .addComponent(this.jScrollPane10, -2, 73, -2))
/*  2590 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2591 */           .addComponent(this.jSeparator11, -2, 10, -2)
/*  2592 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  2593 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2594 */             .addComponent((Component)this.materialButton17, -2, 38, -2)
/*  2595 */             .addComponent((Component)this.materialButton18, -2, 38, -2))
/*  2596 */           .addContainerGap()));
/*       */ 
/*       */     
/*  2599 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/*  2600 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/*  2601 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/*  2602 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2603 */         .addComponent(this.jPanel34, -1, -1, 32767));
/*       */     
/*  2605 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/*  2606 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2607 */         .addComponent(this.jPanel34, -1, 250, 32767));
/*       */ 
/*       */     
/*  2610 */     this.jDialog7.setTitle("Mover registro");
/*       */     
/*  2612 */     this.jRadioButton3.setSelected(true);
/*  2613 */     this.jRadioButton3.setText("Arriba");
/*       */     
/*  2615 */     this.jTextField2.setEnabled(false);
/*       */     
/*  2617 */     this.jTextField3.setEnabled(false);
/*       */     
/*  2619 */     this.jRadioButton4.setText("Abajo");
/*       */     
/*  2621 */     this.materialButton19.setBackground(this.lc.PRIMARIO1);
/*  2622 */     this.materialButton19.setForeground(new Color(255, 255, 255));
/*  2623 */     this.materialButton19.setMnemonic('M');
/*  2624 */     this.materialButton19.setText("Mover");
/*  2625 */     this.materialButton19.setToolTipText("Mover (Alt+M)");
/*  2626 */     this.materialButton19.setFont(new Font("Cantarell", 0, 12));
/*  2627 */     this.materialButton19.setHorizontalTextPosition(0);
/*  2628 */     this.materialButton19.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2630 */             Principal.this.materialButton19ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2634 */     GroupLayout jPanel35Layout = new GroupLayout(this.jPanel35);
/*  2635 */     this.jPanel35.setLayout(jPanel35Layout);
/*  2636 */     jPanel35Layout.setHorizontalGroup(jPanel35Layout
/*  2637 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2638 */         .addGroup(jPanel35Layout.createSequentialGroup()
/*  2639 */           .addComponent(this.jTextField2, -2, 122, -2)
/*  2640 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2641 */           .addComponent(this.jTextField3))
/*  2642 */         .addComponent(this.jSeparator7)
/*  2643 */         .addGroup(jPanel35Layout.createSequentialGroup()
/*  2644 */           .addContainerGap()
/*  2645 */           .addComponent(this.jRadioButton3, -2, 119, -2)
/*  2646 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  2647 */           .addComponent(this.jRadioButton4, -2, 119, -2)
/*  2648 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 74, 32767)
/*  2649 */           .addComponent((Component)this.materialButton19, -2, 150, -2)
/*  2650 */           .addContainerGap()));
/*       */     
/*  2652 */     jPanel35Layout.setVerticalGroup(jPanel35Layout
/*  2653 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2654 */         .addGroup(jPanel35Layout.createSequentialGroup()
/*  2655 */           .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2656 */             .addComponent(this.jTextField2, -2, -1, -2)
/*  2657 */             .addComponent(this.jTextField3, -2, -1, -2))
/*  2658 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2659 */           .addComponent(this.jSeparator7, -2, 10, -2)
/*  2660 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2661 */           .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2662 */             .addComponent(this.jRadioButton3)
/*  2663 */             .addComponent(this.jRadioButton4)
/*  2664 */             .addComponent((Component)this.materialButton19, -2, 38, -2))
/*  2665 */           .addContainerGap(8, 32767)));
/*       */ 
/*       */     
/*  2668 */     GroupLayout jDialog7Layout = new GroupLayout(this.jDialog7.getContentPane());
/*  2669 */     this.jDialog7.getContentPane().setLayout(jDialog7Layout);
/*  2670 */     jDialog7Layout.setHorizontalGroup(jDialog7Layout
/*  2671 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2672 */         .addGroup(jDialog7Layout.createSequentialGroup()
/*  2673 */           .addComponent(this.jPanel35, -1, -1, 32767)
/*  2674 */           .addGap(0, 0, 0)));
/*       */     
/*  2676 */     jDialog7Layout.setVerticalGroup(jDialog7Layout
/*  2677 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2678 */         .addGroup(jDialog7Layout.createSequentialGroup()
/*  2679 */           .addComponent(this.jPanel35, -1, -1, 32767)
/*  2680 */           .addGap(0, 0, 0)));
/*       */ 
/*       */     
/*  2683 */     this.jDialog9.setTitle("Historial de movimientos");
/*       */     
/*  2685 */     this.jPanel1.setBackground(this.lc.SECUNDARIO1);
/*       */     
/*  2687 */     this.rSTableMetro4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Clave", "Nombre Completo" })
/*       */         {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*  2695 */           boolean[] canEdit = new boolean[] { false, false };
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  2700 */             return this.canEdit[columnIndex];
/*       */           }
/*       */         });
/*  2703 */     this.rSTableMetro4.setAltoHead(25);
/*  2704 */     this.rSTableMetro4.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  2705 */     this.rSTableMetro4.setColorBordeFilas(new Color(200, 200, 200));
/*  2706 */     this.rSTableMetro4.setColorBordeHead(this.lc.PRIMARIO1);
/*  2707 */     this.rSTableMetro4.setColorFilasBackgound2(new Color(239, 239, 239));
/*  2708 */     this.rSTableMetro4.setColorFilasForeground1(new Color(102, 102, 102));
/*  2709 */     this.rSTableMetro4.setColorFilasForeground2(new Color(102, 102, 102));
/*  2710 */     this.rSTableMetro4.setColorSelBackgound(new Color(237, 107, 107));
/*  2711 */     this.rSTableMetro4.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  2712 */     this.rSTableMetro4.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  2713 */     this.rSTableMetro4.setFuenteHead(new Font("Cantarell", 1, 12));
/*  2714 */     this.rSTableMetro4.setGrosorBordeFilas(0);
/*  2715 */     this.rSTableMetro4.setSelectionBackground(this.lc.PRIMARIO2);
/*  2716 */     this.rSTableMetro4.getTableHeader().setResizingAllowed(false);
/*  2717 */     this.rSTableMetro4.getTableHeader().setReorderingAllowed(false);
/*  2718 */     this.rSTableMetro4.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  2720 */             Principal.this.rSTableMetro4MouseClicked(evt);
/*       */           }
/*       */         });
/*  2723 */     this.rSTableMetro4.addKeyListener(new KeyAdapter() {
/*       */           public void keyPressed(KeyEvent evt) {
/*  2725 */             Principal.this.rSTableMetro4KeyPressed(evt);
/*       */           }
/*       */           public void keyReleased(KeyEvent evt) {
/*  2728 */             Principal.this.rSTableMetro4KeyReleased(evt);
/*       */           }
/*       */         });
/*  2731 */     this.jScrollPane14.setViewportView((Component)this.rSTableMetro4);
/*  2732 */     if (this.rSTableMetro4.getColumnModel().getColumnCount() > 0) {
/*  2733 */       this.rSTableMetro4.getColumnModel().getColumn(0).setMinWidth(80);
/*  2734 */       this.rSTableMetro4.getColumnModel().getColumn(0).setPreferredWidth(80);
/*  2735 */       this.rSTableMetro4.getColumnModel().getColumn(0).setMaxWidth(80);
/*  2736 */       this.rSTableMetro4.getColumnModel().getColumn(1).setResizable(false);
/*       */     } 
/*       */     
/*  2739 */     this.jPanel9.setBackground(this.lc.SECUNDARIO1);
/*       */     
/*  2741 */     this.jLabel27.setFont(new Font("Cantarell", 1, 13));
/*  2742 */     this.jLabel27.setForeground(new Color(255, 255, 255));
/*  2743 */     this.jLabel27.setText("Observaciones");
/*       */     
/*  2745 */     this.jPanel7.setBackground(this.lc.SECUNDARIO1);
/*  2746 */     this.jPanel7.setLayout((LayoutManager)null);
/*       */     
/*  2748 */     this.jPanel12.setBackground(this.lc.PRIMARIO1);
/*       */     
/*  2750 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/*  2751 */     this.jPanel12.setLayout(jPanel12Layout);
/*  2752 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/*  2753 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2754 */         .addGap(0, 272, 32767));
/*       */     
/*  2756 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/*  2757 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2758 */         .addGap(0, 5, 32767));
/*       */ 
/*       */     
/*  2761 */     this.jPanel7.add(this.jPanel12);
/*  2762 */     this.jPanel12.setBounds(0, 4, 272, 5);
/*       */     
/*  2764 */     this.jTextArea3.setEditable(false);
/*  2765 */     this.jTextArea3.setBackground(this.lc.SECUNDARIO1);
/*  2766 */     this.jTextArea3.setColumns(20);
/*  2767 */     this.jTextArea3.setFont(new Font("Cantarell", 0, 11));
/*  2768 */     this.jTextArea3.setForeground(new Color(255, 255, 255));
/*  2769 */     this.jTextArea3.setLineWrap(true);
/*  2770 */     this.jTextArea3.setRows(5);
/*  2771 */     this.jScrollPane9.setViewportView(this.jTextArea3);
/*       */     
/*  2773 */     this.jPanel7.add(this.jScrollPane9);
/*  2774 */     this.jScrollPane9.setBounds(0, 8, 272, 280);
/*       */     
/*  2776 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  2777 */     this.jPanel9.setLayout(jPanel9Layout);
/*  2778 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/*  2779 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2780 */         .addComponent(this.jLabel27, -1, -1, 32767)
/*  2781 */         .addComponent(this.jPanel7, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*       */     
/*  2783 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/*  2784 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2785 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/*  2786 */           .addGap(22, 22, 22)
/*  2787 */           .addComponent(this.jLabel27)
/*  2788 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2789 */           .addComponent(this.jPanel7, -1, -1, 32767)));
/*       */ 
/*       */     
/*  2792 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  2793 */     this.jPanel1.setLayout(jPanel1Layout);
/*  2794 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  2795 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2796 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  2797 */           .addComponent(this.jScrollPane14, -2, -1, -2)
/*  2798 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2799 */           .addComponent(this.jPanel9, -1, -1, 32767)));
/*       */     
/*  2801 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/*  2802 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2803 */         .addComponent(this.jScrollPane14, -1, 352, 32767)
/*  2804 */         .addComponent(this.jPanel9, -1, -1, 32767));
/*       */ 
/*       */     
/*  2807 */     this.materialButton20.setBackground(this.lc.SECUNDARIO1);
/*  2808 */     this.materialButton20.setForeground(new Color(255, 255, 255));
/*  2809 */     this.materialButton20.setMnemonic('C');
/*  2810 */     this.materialButton20.setText("Cerrar");
/*  2811 */     this.materialButton20.setToolTipText("Cerrar (Alt+C)");
/*  2812 */     this.materialButton20.setFont(new Font("Cantarell", 0, 12));
/*  2813 */     this.materialButton20.setHorizontalTextPosition(0);
/*  2814 */     this.materialButton20.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2816 */             Principal.this.materialButton20ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2820 */     GroupLayout jPanel37Layout = new GroupLayout(this.jPanel37);
/*  2821 */     this.jPanel37.setLayout(jPanel37Layout);
/*  2822 */     jPanel37Layout.setHorizontalGroup(jPanel37Layout
/*  2823 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2824 */         .addGroup(jPanel37Layout.createSequentialGroup()
/*  2825 */           .addGap(0, 645, 32767)
/*  2826 */           .addComponent((Component)this.materialButton20, -2, 105, -2))
/*  2827 */         .addComponent(this.jPanel1, -1, -1, 32767));
/*       */     
/*  2829 */     jPanel37Layout.setVerticalGroup(jPanel37Layout
/*  2830 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2831 */         .addGroup(jPanel37Layout.createSequentialGroup()
/*  2832 */           .addComponent(this.jPanel1, -1, -1, 32767)
/*  2833 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2834 */           .addComponent((Component)this.materialButton20, -2, 38, -2)));
/*       */ 
/*       */     
/*  2837 */     GroupLayout jDialog9Layout = new GroupLayout(this.jDialog9.getContentPane());
/*  2838 */     this.jDialog9.getContentPane().setLayout(jDialog9Layout);
/*  2839 */     jDialog9Layout.setHorizontalGroup(jDialog9Layout
/*  2840 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2841 */         .addComponent(this.jPanel37, -1, -1, 32767));
/*       */     
/*  2843 */     jDialog9Layout.setVerticalGroup(jDialog9Layout
/*  2844 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2845 */         .addComponent(this.jPanel37, -1, -1, 32767));
/*       */ 
/*       */     
/*  2848 */     this.jDialog10.setTitle("Detalles del Movimiento");
/*  2849 */     this.jDialog10.setModal(true);
/*       */     
/*  2851 */     this.jPanel38.setBackground(new Color(255, 255, 255));
/*       */     
/*  2853 */     this.jLabel89.setFont(new Font("Times New Roman", 1, 25));
/*  2854 */     this.jLabel89.setForeground(new Color(102, 102, 102));
/*  2855 */     this.jLabel89.setHorizontalAlignment(0);
/*  2856 */     this.jLabel89.setText("Detalles del movimiento");
/*       */     
/*  2858 */     this.jLabel30.setText("Operador:");
/*       */     
/*  2860 */     this.jLabel31.setFont(new Font("Tahoma", 1, 11));
/*  2861 */     this.jLabel31.setText("PR-00001");
/*       */     
/*  2863 */     this.jLabel34.setFont(new Font("Tahoma", 3, 11));
/*  2864 */     this.jLabel34.setForeground(Color.red);
/*  2865 */     this.jLabel34.setText("A continuación se muestra todo el historial del registro.");
/*       */     
/*  2867 */     this.jTextArea5.setEditable(false);
/*  2868 */     this.jTextArea5.setColumns(20);
/*  2869 */     this.jTextArea5.setFont(new Font("Tahoma", 0, 12));
/*  2870 */     this.jTextArea5.setLineWrap(true);
/*  2871 */     this.jTextArea5.setRows(5);
/*  2872 */     this.jTextArea5.setText("Ejemplo del texto");
/*  2873 */     this.jScrollPane11.setViewportView(this.jTextArea5);
/*       */     
/*  2875 */     this.jLabel52.setFont(new Font("Tahoma", 1, 11));
/*  2876 */     this.jLabel52.setText("|");
/*       */     
/*  2878 */     this.jLabel51.setFont(new Font("Tahoma", 1, 11));
/*  2879 */     this.jLabel51.setForeground(Color.red);
/*  2880 */     this.jLabel51.setHorizontalAlignment(0);
/*  2881 */     this.jLabel51.setText("<html><u>Cerrar</u></html>");
/*  2882 */     this.jLabel51.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  2884 */             Principal.this.jLabel51MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  2887 */             Principal.this.jLabel51MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  2890 */             Principal.this.jLabel51MouseEntered(evt);
/*       */           }
/*       */         });
/*       */     
/*  2894 */     this.jLabel53.setFont(new Font("Tahoma", 1, 11));
/*  2895 */     this.jLabel53.setText("|");
/*       */     
/*  2897 */     this.jLabel104.setFont(new Font("Times New Roman", 1, 12));
/*  2898 */     this.jLabel104.setText("ESTATUS:");
/*       */     
/*  2900 */     this.jLabel105.setFont(new Font("Times New Roman", 1, 12));
/*  2901 */     this.jLabel105.setForeground(new Color(0, 0, 102));
/*  2902 */     this.jLabel105.setText("jLabel99");
/*       */     
/*  2904 */     GroupLayout jPanel38Layout = new GroupLayout(this.jPanel38);
/*  2905 */     this.jPanel38.setLayout(jPanel38Layout);
/*  2906 */     jPanel38Layout.setHorizontalGroup(jPanel38Layout
/*  2907 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2908 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
/*  2909 */           .addContainerGap()
/*  2910 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  2911 */             .addComponent(this.jScrollPane11, GroupLayout.Alignment.LEADING, -1, 660, 32767)
/*  2912 */             .addComponent(this.jLabel34, GroupLayout.Alignment.LEADING, -1, 660, 32767)
/*  2913 */             .addComponent(this.jLabel89, GroupLayout.Alignment.LEADING, -1, 660, 32767)
/*  2914 */             .addComponent(this.jSeparator12, GroupLayout.Alignment.LEADING, -1, 660, 32767)
/*  2915 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel38Layout.createSequentialGroup()
/*  2916 */               .addComponent(this.jLabel30, -2, 73, -2)
/*  2917 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2918 */               .addComponent(this.jLabel31, -2, 227, -2))
/*  2919 */             .addGroup(jPanel38Layout.createSequentialGroup()
/*  2920 */               .addComponent(this.jLabel104, -2, 69, -2)
/*  2921 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2922 */               .addComponent(this.jLabel105, -1, 256, 32767)
/*  2923 */               .addGap(267, 267, 267)
/*  2924 */               .addComponent(this.jLabel52)
/*  2925 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2926 */               .addComponent(this.jLabel51, -2, -1, -2)
/*  2927 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2928 */               .addComponent(this.jLabel53)))
/*  2929 */           .addContainerGap()));
/*       */     
/*  2931 */     jPanel38Layout.setVerticalGroup(jPanel38Layout
/*  2932 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2933 */         .addGroup(jPanel38Layout.createSequentialGroup()
/*  2934 */           .addComponent(this.jLabel89)
/*  2935 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2936 */           .addComponent(this.jSeparator12, -2, 10, -2)
/*  2937 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2938 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2939 */             .addComponent(this.jLabel30)
/*  2940 */             .addComponent(this.jLabel31))
/*  2941 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2942 */           .addComponent(this.jLabel34)
/*  2943 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2944 */           .addComponent(this.jScrollPane11, -2, 344, -2)
/*  2945 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2946 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2947 */             .addComponent(this.jLabel53)
/*  2948 */             .addComponent(this.jLabel51, -2, -1, -2)
/*  2949 */             .addComponent(this.jLabel52)
/*  2950 */             .addComponent(this.jLabel104)
/*  2951 */             .addComponent(this.jLabel105))
/*  2952 */           .addContainerGap(-1, 32767)));
/*       */ 
/*       */     
/*  2955 */     GroupLayout jDialog10Layout = new GroupLayout(this.jDialog10.getContentPane());
/*  2956 */     this.jDialog10.getContentPane().setLayout(jDialog10Layout);
/*  2957 */     jDialog10Layout.setHorizontalGroup(jDialog10Layout
/*  2958 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2959 */         .addComponent(this.jPanel38, -1, -1, 32767));
/*       */     
/*  2961 */     jDialog10Layout.setVerticalGroup(jDialog10Layout
/*  2962 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2963 */         .addComponent(this.jPanel38, -1, -1, 32767));
/*       */ 
/*       */     
/*  2966 */     this.jPanel66.setBackground(this.lc.PRIMARIO1);
/*       */     
/*  2968 */     this.jPanel139.setBackground(this.lc.PRIMARIO1);
/*  2969 */     this.jPanel139.setBorder(BorderFactory.createTitledBorder(null, "Liquidaciones", 2, 6, new Font("Cantarell", 0, 11), new Color(255, 255, 255)));
/*  2970 */     this.jPanel139.setLayout(new GridLayout(1, 4, 4, 4));
/*       */     
/*  2972 */     this.jPanel142.setBackground(this.lc.PRIMARIO1);
/*  2973 */     this.jPanel142.setLayout(new GridLayout(2, 0, 0, 4));
/*       */     
/*  2975 */     this.jPanel140.setBackground(this.lc.PRIMARIO1);
/*  2976 */     this.jPanel140.setLayout(new GridLayout(1, 0));
/*       */     
/*  2978 */     this.jLabel135.setHorizontalAlignment(0);
/*  2979 */     this.jLabel135.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/hojasRSP.png")));
/*  2980 */     this.jLabel135.setToolTipText("Recepción de guías");
/*  2981 */     this.jLabel135.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  2983 */             Principal.this.jLabel135MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  2986 */             Principal.this.jLabel135MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  2989 */             Principal.this.jLabel135MouseExited(evt);
/*       */           }
/*       */         });
/*  2992 */     this.jPanel140.add(this.jLabel135);
/*       */     
/*  2994 */     this.jPanel142.add(this.jPanel140);
/*       */     
/*  2996 */     this.jPanel141.setBackground(this.lc.PRIMARIO1);
/*  2997 */     this.jPanel141.setLayout(new GridLayout(1, 0));
/*       */     
/*  2999 */     this.jLabel136.setHorizontalAlignment(0);
/*  3000 */     this.jLabel136.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/barra.png")));
/*  3001 */     this.jLabel136.setToolTipText("Gestionar vales de diesel");
/*  3002 */     this.jLabel136.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3004 */             Principal.this.jLabel136MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3007 */             Principal.this.jLabel136MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3010 */             Principal.this.jLabel136MouseExited(evt);
/*       */           }
/*       */         });
/*  3013 */     this.jPanel141.add(this.jLabel136);
/*       */     
/*  3015 */     this.jPanel142.add(this.jPanel141);
/*       */     
/*  3017 */     this.jPanel139.add(this.jPanel142);
/*       */     
/*  3019 */     this.jPanel143.setBackground(this.lc.PRIMARIO1);
/*  3020 */     this.jPanel143.setLayout(new GridLayout(2, 0, 0, 4));
/*       */     
/*  3022 */     this.jPanel146.setBackground(this.lc.PRIMARIO1);
/*  3023 */     this.jPanel146.setLayout(new GridLayout(1, 0));
/*       */     
/*  3025 */     this.jLabel138.setHorizontalAlignment(0);
/*  3026 */     this.jLabel138.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/cajaChica.png")));
/*  3027 */     this.jLabel138.setToolTipText("Caja chica");
/*  3028 */     this.jLabel138.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3030 */             Principal.this.jLabel138MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3033 */             Principal.this.jLabel138MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3036 */             Principal.this.jLabel138MouseEntered(evt);
/*       */           }
/*       */         });
/*  3039 */     this.jPanel146.add(this.jLabel138);
/*       */     
/*  3041 */     this.jPanel143.add(this.jPanel146);
/*       */     
/*  3043 */     this.jPanel145.setBackground(this.lc.PRIMARIO1);
/*  3044 */     this.jPanel145.setLayout(new GridLayout(1, 0));
/*       */     
/*  3046 */     this.jLabel137.setHorizontalAlignment(0);
/*  3047 */     this.jLabel137.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/listaliqui.png")));
/*  3048 */     this.jLabel137.setToolTipText("Tarjetas deudor");
/*  3049 */     this.jLabel137.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3051 */             Principal.this.jLabel137MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3054 */             Principal.this.jLabel137MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3057 */             Principal.this.jLabel137MouseExited(evt);
/*       */           }
/*       */         });
/*  3060 */     this.jPanel145.add(this.jLabel137);
/*       */     
/*  3062 */     this.jPanel143.add(this.jPanel145);
/*       */     
/*  3064 */     this.jPanel139.add(this.jPanel143);
/*       */     
/*  3066 */     this.jPanel144.setBackground(this.lc.PRIMARIO1);
/*  3067 */     this.jPanel144.setLayout(new GridLayout(2, 0, 0, 4));
/*       */     
/*  3069 */     this.jPanel148.setBackground(this.lc.PRIMARIO1);
/*  3070 */     this.jPanel148.setLayout(new GridLayout(1, 0));
/*       */     
/*  3072 */     this.jLabel139.setHorizontalAlignment(0);
/*  3073 */     this.jLabel139.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/dinero.png")));
/*  3074 */     this.jLabel139.setToolTipText("Liquidaciones");
/*  3075 */     this.jLabel139.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3077 */             Principal.this.jLabel139MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3080 */             Principal.this.jLabel139MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3083 */             Principal.this.jLabel139MouseExited(evt);
/*       */           }
/*       */         });
/*  3086 */     this.jPanel148.add(this.jLabel139);
/*       */     
/*  3088 */     this.jPanel144.add(this.jPanel148);
/*       */     
/*  3090 */     this.jPanel149.setBackground(this.lc.PRIMARIO1);
/*  3091 */     this.jPanel149.setLayout(new GridLayout(1, 0));
/*       */     
/*  3093 */     this.jLabel140.setHorizontalAlignment(0);
/*  3094 */     this.jLabel140.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/diesel.png")));
/*  3095 */     this.jLabel140.setToolTipText("Diesel completado");
/*  3096 */     this.jLabel140.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3098 */             Principal.this.jLabel140MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3101 */             Principal.this.jLabel140MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3104 */             Principal.this.jLabel140MouseEntered(evt);
/*       */           }
/*       */         });
/*  3107 */     this.jPanel149.add(this.jLabel140);
/*       */     
/*  3109 */     this.jPanel144.add(this.jPanel149);
/*       */     
/*  3111 */     this.jPanel139.add(this.jPanel144);
/*       */     
/*  3113 */     this.jPanel147.setBackground(this.lc.PRIMARIO1);
/*       */     
/*  3115 */     this.jPanel150.setBackground(this.lc.PRIMARIO1);
/*       */     
/*  3117 */     this.jLabel141.setHorizontalAlignment(0);
/*  3118 */     this.jLabel141.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Bar Chart.png")));
/*  3119 */     this.jLabel141.setToolTipText("Reseteos");
/*  3120 */     this.jLabel141.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3122 */             Principal.this.jLabel141MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3125 */             Principal.this.jLabel141MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3128 */             Principal.this.jLabel141MouseEntered(evt);
/*       */           }
/*       */         });
/*       */     
/*  3132 */     GroupLayout jPanel150Layout = new GroupLayout(this.jPanel150);
/*  3133 */     this.jPanel150.setLayout(jPanel150Layout);
/*  3134 */     jPanel150Layout.setHorizontalGroup(jPanel150Layout
/*  3135 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3136 */         .addComponent(this.jLabel141, -1, 32, 32767));
/*       */     
/*  3138 */     jPanel150Layout.setVerticalGroup(jPanel150Layout
/*  3139 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3140 */         .addComponent(this.jLabel141, -1, 48, 32767));
/*       */ 
/*       */     
/*  3143 */     GroupLayout jPanel147Layout = new GroupLayout(this.jPanel147);
/*  3144 */     this.jPanel147.setLayout(jPanel147Layout);
/*  3145 */     jPanel147Layout.setHorizontalGroup(jPanel147Layout
/*  3146 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3147 */         .addGap(0, 66, 32767)
/*  3148 */         .addGroup(jPanel147Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3149 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel147Layout.createSequentialGroup()
/*  3150 */             .addContainerGap(-1, 32767)
/*  3151 */             .addComponent(this.jPanel150, -2, -1, -2)
/*  3152 */             .addGap(28, 28, 28))));
/*       */     
/*  3154 */     jPanel147Layout.setVerticalGroup(jPanel147Layout
/*  3155 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3156 */         .addGap(0, 60, 32767)
/*  3157 */         .addGroup(jPanel147Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3158 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel147Layout.createSequentialGroup()
/*  3159 */             .addContainerGap()
/*  3160 */             .addComponent(this.jPanel150, -1, -1, 32767)
/*  3161 */             .addContainerGap())));
/*       */ 
/*       */     
/*  3164 */     this.jPanel139.add(this.jPanel147);
/*       */     
/*  3166 */     this.jPanel151.setBackground(this.lc.PRIMARIO1);
/*  3167 */     this.jPanel151.setBorder(BorderFactory.createTitledBorder(null, "Recursos Humanos", 2, 6, new Font("Cantarell", 0, 11), new Color(255, 255, 255)));
/*  3168 */     this.jPanel151.setLayout(new GridLayout(2, 2, 4, 4));
/*       */     
/*  3170 */     this.jPanel154.setBackground(this.lc.PRIMARIO1);
/*  3171 */     this.jPanel154.setLayout(new GridLayout(1, 0));
/*       */     
/*  3173 */     this.jLabel144.setHorizontalAlignment(0);
/*  3174 */     this.jLabel144.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/vacaciones.png")));
/*  3175 */     this.jLabel144.setToolTipText("Vacaciones");
/*  3176 */     this.jLabel144.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3178 */             Principal.this.jLabel144MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3181 */             Principal.this.jLabel144MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3184 */             Principal.this.jLabel144MouseEntered(evt);
/*       */           }
/*       */         });
/*  3187 */     this.jPanel154.add(this.jLabel144);
/*       */     
/*  3189 */     this.jPanel151.add(this.jPanel154);
/*       */     
/*  3191 */     this.jPanel155.setBackground(this.lc.PRIMARIO1);
/*  3192 */     this.jPanel155.setLayout(new GridLayout(1, 0));
/*       */     
/*  3194 */     this.jLabel145.setHorizontalAlignment(0);
/*  3195 */     this.jLabel145.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Finiquitos.png")));
/*  3196 */     this.jLabel145.setToolTipText("Finiquitos");
/*  3197 */     this.jLabel145.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3199 */             Principal.this.jLabel145MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3202 */             Principal.this.jLabel145MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3205 */             Principal.this.jLabel145MouseEntered(evt);
/*       */           }
/*       */         });
/*  3208 */     this.jPanel155.add(this.jLabel145);
/*       */     
/*  3210 */     this.jPanel151.add(this.jPanel155);
/*       */     
/*  3212 */     this.jPanel156.setBackground(this.lc.PRIMARIO1);
/*  3213 */     this.jPanel156.setLayout(new GridLayout(1, 0));
/*       */     
/*  3215 */     this.jLabel146.setHorizontalAlignment(0);
/*  3216 */     this.jLabel146.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Aguinaldo.png")));
/*  3217 */     this.jLabel146.setToolTipText("Aguinaldos");
/*  3218 */     this.jLabel146.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3220 */             Principal.this.jLabel146MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3223 */             Principal.this.jLabel146MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3226 */             Principal.this.jLabel146MouseEntered(evt);
/*       */           }
/*       */         });
/*  3229 */     this.jPanel156.add(this.jLabel146);
/*       */     
/*  3231 */     this.jPanel151.add(this.jPanel156);
/*       */     
/*  3233 */     this.jPanel5.setBackground(this.lc.PRIMARIO1);
/*  3234 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, "Empleados", 2, 6, new Font("Cantarell", 0, 11), new Color(255, 255, 255)));
/*  3235 */     this.jPanel5.setLayout(new GridLayout(1, 0, 5, 0));
/*       */     
/*  3237 */     this.jPanel77.setBackground(this.lc.PRIMARIO1);
/*  3238 */     this.jPanel77.setLayout(new GridLayout(1, 0));
/*       */     
/*  3240 */     this.jLabel69.setHorizontalAlignment(0);
/*  3241 */     this.jLabel69.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/AgregarEmpleado.png")));
/*  3242 */     this.jLabel69.setToolTipText("Agregar empleados");
/*  3243 */     this.jLabel69.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3245 */             Principal.this.jLabel69MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3248 */             Principal.this.jLabel69MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3251 */             Principal.this.jLabel69MouseExited(evt);
/*       */           }
/*       */         });
/*  3254 */     this.jPanel77.add(this.jLabel69);
/*       */     
/*  3256 */     this.jPanel5.add(this.jPanel77);
/*       */     
/*  3258 */     this.jPanel78.setBackground(this.lc.PRIMARIO1);
/*  3259 */     this.jPanel78.setLayout(new GridLayout(1, 0));
/*       */     
/*  3261 */     this.jLabel70.setHorizontalAlignment(0);
/*  3262 */     this.jLabel70.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/modificarEmpleado.png")));
/*  3263 */     this.jLabel70.setToolTipText("Modificar empleados");
/*  3264 */     this.jLabel70.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3266 */             Principal.this.jLabel70MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3269 */             Principal.this.jLabel70MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3272 */             Principal.this.jLabel70MouseEntered(evt);
/*       */           }
/*       */         });
/*  3275 */     this.jPanel78.add(this.jLabel70);
/*       */     
/*  3277 */     this.jPanel5.add(this.jPanel78);
/*       */     
/*  3279 */     this.jPanel79.setBackground(this.lc.PRIMARIO1);
/*  3280 */     this.jPanel79.setLayout(new GridLayout(1, 0));
/*       */     
/*  3282 */     this.jLabel71.setHorizontalAlignment(0);
/*  3283 */     this.jLabel71.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/EliminarEmpleado.png")));
/*  3284 */     this.jLabel71.setToolTipText("Eliminar empleados");
/*  3285 */     this.jLabel71.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3287 */             Principal.this.jLabel71MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3290 */             Principal.this.jLabel71MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3293 */             Principal.this.jLabel71MouseEntered(evt);
/*       */           }
/*       */         });
/*  3296 */     this.jPanel79.add(this.jLabel71);
/*       */     
/*  3298 */     this.jPanel5.add(this.jPanel79);
/*       */     
/*  3300 */     this.jPanel80.setBackground(this.lc.PRIMARIO1);
/*  3301 */     this.jPanel80.setLayout(new GridLayout(1, 0));
/*       */     
/*  3303 */     this.jLabel72.setHorizontalAlignment(0);
/*  3304 */     this.jLabel72.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/buscarEmpleado.png")));
/*  3305 */     this.jLabel72.setToolTipText("Buscar empleados");
/*  3306 */     this.jLabel72.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3308 */             Principal.this.jLabel72MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3311 */             Principal.this.jLabel72MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3314 */             Principal.this.jLabel72MouseExited(evt);
/*       */           }
/*       */         });
/*  3317 */     this.jPanel80.add(this.jLabel72);
/*       */     
/*  3319 */     this.jPanel5.add(this.jPanel80);
/*       */     
/*  3321 */     this.jPanel4.setBackground(this.lc.PRIMARIO1);
/*  3322 */     this.jPanel4.setBorder(BorderFactory.createTitledBorder(null, "Operadores", 2, 6, new Font("Cantarell", 0, 11), new Color(255, 255, 255)));
/*  3323 */     this.jPanel4.setLayout(new GridLayout(1, 0, 5, 6));
/*       */     
/*  3325 */     this.jPanel60.setBackground(this.lc.PRIMARIO1);
/*  3326 */     this.jPanel60.setLayout(new GridLayout(1, 0));
/*       */     
/*  3328 */     this.jLabel65.setHorizontalAlignment(0);
/*  3329 */     this.jLabel65.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/AgregarOperador.png")));
/*  3330 */     this.jLabel65.setToolTipText("Agregar operadores");
/*  3331 */     this.jLabel65.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3333 */             Principal.this.jLabel65MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3336 */             Principal.this.jLabel65MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3339 */             Principal.this.jLabel65MouseExited(evt);
/*       */           }
/*       */         });
/*  3342 */     this.jPanel60.add(this.jLabel65);
/*       */     
/*  3344 */     this.jPanel4.add(this.jPanel60);
/*       */     
/*  3346 */     this.jPanel61.setBackground(this.lc.PRIMARIO1);
/*  3347 */     this.jPanel61.setLayout(new GridLayout(1, 0));
/*       */     
/*  3349 */     this.jLabel66.setHorizontalAlignment(0);
/*  3350 */     this.jLabel66.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/modificarOperador.png")));
/*  3351 */     this.jLabel66.setToolTipText("Modificar operadores");
/*  3352 */     this.jLabel66.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3354 */             Principal.this.jLabel66MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3357 */             Principal.this.jLabel66MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3360 */             Principal.this.jLabel66MouseExited(evt);
/*       */           }
/*       */         });
/*  3363 */     this.jPanel61.add(this.jLabel66);
/*       */     
/*  3365 */     this.jPanel4.add(this.jPanel61);
/*       */     
/*  3367 */     this.jPanel62.setBackground(this.lc.PRIMARIO1);
/*  3368 */     this.jPanel62.setLayout(new GridLayout(1, 0));
/*       */     
/*  3370 */     this.jLabel67.setHorizontalAlignment(0);
/*  3371 */     this.jLabel67.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/eliminarOperador.png")));
/*  3372 */     this.jLabel67.setToolTipText("Eliminar operadores");
/*  3373 */     this.jLabel67.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3375 */             Principal.this.jLabel67MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3378 */             Principal.this.jLabel67MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3381 */             Principal.this.jLabel67MouseEntered(evt);
/*       */           }
/*       */         });
/*  3384 */     this.jPanel62.add(this.jLabel67);
/*       */     
/*  3386 */     this.jPanel4.add(this.jPanel62);
/*       */     
/*  3388 */     this.jPanel67.setBackground(this.lc.PRIMARIO1);
/*  3389 */     this.jPanel67.setLayout(new GridLayout(1, 0));
/*       */     
/*  3391 */     this.jLabel68.setHorizontalAlignment(0);
/*  3392 */     this.jLabel68.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/buscarOperador.png")));
/*  3393 */     this.jLabel68.setToolTipText("Buscar operadores");
/*  3394 */     this.jLabel68.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3396 */             Principal.this.jLabel68MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3399 */             Principal.this.jLabel68MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3402 */             Principal.this.jLabel68MouseExited(evt);
/*       */           }
/*       */         });
/*  3405 */     this.jPanel67.add(this.jLabel68);
/*       */     
/*  3407 */     this.jPanel4.add(this.jPanel67);
/*       */     
/*  3409 */     GroupLayout jPanel66Layout = new GroupLayout(this.jPanel66);
/*  3410 */     this.jPanel66.setLayout(jPanel66Layout);
/*  3411 */     jPanel66Layout.setHorizontalGroup(jPanel66Layout
/*  3412 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3413 */         .addGroup(jPanel66Layout.createSequentialGroup()
/*  3414 */           .addComponent(this.jPanel139, -2, 211, -2)
/*  3415 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3416 */           .addComponent(this.jPanel151, -2, 132, -2)
/*  3417 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3418 */           .addComponent(this.jPanel5, -2, 150, -2)
/*  3419 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3420 */           .addComponent(this.jPanel4, -2, 150, -2)
/*  3421 */           .addGap(0, 608, 32767)));
/*       */     
/*  3423 */     jPanel66Layout.setVerticalGroup(jPanel66Layout
/*  3424 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3425 */         .addComponent(this.jPanel139, -1, -1, 32767)
/*  3426 */         .addComponent(this.jPanel151, -1, -1, 32767)
/*  3427 */         .addComponent(this.jPanel5, -1, -1, 32767)
/*  3428 */         .addComponent(this.jPanel4, -1, -1, 32767));
/*       */ 
/*       */     
/*  3431 */     this.jPanel69.setBackground(this.lc.PRIMARIO1);
/*       */     
/*  3433 */     this.jPanel110.setBackground(this.lc.PRIMARIO1);
/*  3434 */     this.jPanel110.setBorder(BorderFactory.createTitledBorder(null, "QHSE", 2, 6, new Font("Cantarell", 0, 11), new Color(255, 255, 255)));
/*  3435 */     this.jPanel110.setLayout(new GridLayout(1, 2, 5, 6));
/*       */     
/*  3437 */     this.jPanel117.setBackground(this.lc.PRIMARIO1);
/*  3438 */     this.jPanel117.setLayout(new GridLayout(1, 0));
/*       */     
/*  3440 */     this.jLabel119.setHorizontalAlignment(0);
/*  3441 */     this.jLabel119.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/QHSE.png")));
/*  3442 */     this.jLabel119.setToolTipText("Reporte de calidad");
/*  3443 */     this.jLabel119.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3445 */             Principal.this.jLabel119MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3448 */             Principal.this.jLabel119MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3451 */             Principal.this.jLabel119MouseEntered(evt);
/*       */           }
/*       */         });
/*  3454 */     this.jPanel117.add(this.jLabel119);
/*       */     
/*  3456 */     this.jPanel110.add(this.jPanel117);
/*       */     
/*  3458 */     this.jPanel119.setBackground(this.lc.PRIMARIO1);
/*  3459 */     this.jPanel119.setLayout(new GridLayout(1, 0));
/*       */     
/*  3461 */     this.jLabel120.setHorizontalAlignment(0);
/*  3462 */     this.jLabel120.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/seg1.png")));
/*  3463 */     this.jLabel120.setToolTipText("Vales");
/*  3464 */     this.jLabel120.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3466 */             Principal.this.jLabel120MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3469 */             Principal.this.jLabel120MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3472 */             Principal.this.jLabel120MouseEntered(evt);
/*       */           }
/*       */         });
/*  3475 */     this.jPanel119.add(this.jLabel120);
/*       */     
/*  3477 */     this.jPanel110.add(this.jPanel119);
/*       */     
/*  3479 */     this.jPanel123.setBackground(this.lc.PRIMARIO1);
/*  3480 */     this.jPanel123.setBorder(BorderFactory.createTitledBorder(null, "Estadísticos", 2, 6, new Font("Cantarell", 0, 11), new Color(255, 255, 255)));
/*  3481 */     this.jPanel123.setLayout(new GridLayout(1, 0, 5, 6));
/*       */     
/*  3483 */     this.jPanel124.setBackground(this.lc.PRIMARIO1);
/*  3484 */     this.jPanel124.setLayout(new GridLayout(1, 0));
/*       */     
/*  3486 */     this.jLabel121.setHorizontalAlignment(0);
/*  3487 */     this.jLabel121.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/grafica.png")));
/*  3488 */     this.jLabel121.setToolTipText("Indicadores de desempeño");
/*  3489 */     this.jLabel121.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3491 */             Principal.this.jLabel121MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3494 */             Principal.this.jLabel121MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3497 */             Principal.this.jLabel121MouseEntered(evt);
/*       */           }
/*       */         });
/*  3500 */     this.jPanel124.add(this.jLabel121);
/*       */     
/*  3502 */     this.jPanel123.add(this.jPanel124);
/*       */     
/*  3504 */     this.jPanel125.setBackground(this.lc.PRIMARIO1);
/*  3505 */     this.jPanel125.setLayout(new GridLayout(1, 0));
/*       */     
/*  3507 */     this.jLabel122.setHorizontalAlignment(0);
/*  3508 */     this.jLabel122.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/BuscarDemandas.png")));
/*  3509 */     this.jLabel122.setToolTipText("Servicios realizados");
/*  3510 */     this.jLabel122.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3512 */             Principal.this.jLabel122MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3515 */             Principal.this.jLabel122MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3518 */             Principal.this.jLabel122MouseEntered(evt);
/*       */           }
/*       */         });
/*  3521 */     this.jPanel125.add(this.jLabel122);
/*       */     
/*  3523 */     this.jPanel123.add(this.jPanel125);
/*       */     
/*  3525 */     this.jPanel126.setBackground(this.lc.PRIMARIO1);
/*  3526 */     this.jPanel126.setBorder(BorderFactory.createTitledBorder(null, "Facturación", 2, 6, new Font("Cantarell", 0, 11), new Color(255, 255, 255)));
/*  3527 */     this.jPanel126.setLayout(new GridLayout(2, 6, 3, 3));
/*       */     
/*  3529 */     this.jPanel127.setBackground(this.lc.PRIMARIO1);
/*  3530 */     this.jPanel127.setLayout(new GridLayout(1, 0));
/*       */     
/*  3532 */     this.jLabel123.setHorizontalAlignment(0);
/*  3533 */     this.jLabel123.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/cash_register.png")));
/*  3534 */     this.jLabel123.setToolTipText("Reportes Interno");
/*  3535 */     this.jLabel123.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3537 */             Principal.this.jLabel123MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3540 */             Principal.this.jLabel123MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3543 */             Principal.this.jLabel123MouseEntered(evt);
/*       */           }
/*       */         });
/*  3546 */     this.jPanel127.add(this.jLabel123);
/*       */     
/*  3548 */     this.jPanel126.add(this.jPanel127);
/*       */     
/*  3550 */     this.jPanel128.setBackground(this.lc.PRIMARIO1);
/*  3551 */     this.jPanel128.setLayout(new GridLayout(1, 0));
/*       */     
/*  3553 */     this.jLabel124.setHorizontalAlignment(0);
/*  3554 */     this.jLabel124.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/tarificador.png")));
/*  3555 */     this.jLabel124.setToolTipText("Tarifas");
/*  3556 */     this.jLabel124.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3558 */             Principal.this.jLabel124MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3561 */             Principal.this.jLabel124MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3564 */             Principal.this.jLabel124MouseEntered(evt);
/*       */           }
/*       */         });
/*  3567 */     this.jPanel128.add(this.jLabel124);
/*       */     
/*  3569 */     this.jPanel126.add(this.jPanel128);
/*       */     
/*  3571 */     this.jPanel129.setBackground(this.lc.PRIMARIO1);
/*  3572 */     this.jPanel129.setLayout(new GridLayout(1, 0));
/*       */     
/*  3574 */     this.jLabel125.setHorizontalAlignment(0);
/*  3575 */     this.jLabel125.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Facturas.png")));
/*  3576 */     this.jLabel125.setToolTipText("Facturas");
/*  3577 */     this.jLabel125.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3579 */             Principal.this.jLabel125MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3582 */             Principal.this.jLabel125MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3585 */             Principal.this.jLabel125MouseExited(evt);
/*       */           }
/*       */         });
/*  3588 */     this.jPanel129.add(this.jLabel125);
/*       */     
/*  3590 */     this.jPanel126.add(this.jPanel129);
/*       */     
/*  3592 */     this.jPanel130.setBackground(this.lc.PRIMARIO1);
/*  3593 */     this.jPanel130.setLayout(new GridLayout(1, 0));
/*       */     
/*  3595 */     this.jLabel126.setHorizontalAlignment(0);
/*  3596 */     this.jLabel126.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/folder_invoices.png")));
/*  3597 */     this.jLabel126.setToolTipText("Complementos de pago");
/*  3598 */     this.jLabel126.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3600 */             Principal.this.jLabel126MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3603 */             Principal.this.jLabel126MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3606 */             Principal.this.jLabel126MouseEntered(evt);
/*       */           }
/*       */         });
/*  3609 */     this.jPanel130.add(this.jLabel126);
/*       */     
/*  3611 */     this.jPanel126.add(this.jPanel130);
/*       */     
/*  3613 */     this.jPanel131.setBackground(this.lc.PRIMARIO1);
/*  3614 */     this.jPanel131.setLayout(new GridLayout(1, 0));
/*       */     
/*  3616 */     this.jLabel127.setHorizontalAlignment(0);
/*  3617 */     this.jLabel127.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/abonos.png")));
/*  3618 */     this.jLabel127.setToolTipText("Depósitos");
/*  3619 */     this.jLabel127.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3621 */             Principal.this.jLabel127MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3624 */             Principal.this.jLabel127MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3627 */             Principal.this.jLabel127MouseEntered(evt);
/*       */           }
/*       */         });
/*  3630 */     this.jPanel131.add(this.jLabel127);
/*       */     
/*  3632 */     this.jPanel126.add(this.jPanel131);
/*       */     
/*  3634 */     this.jPanel132.setBackground(this.lc.PRIMARIO1);
/*  3635 */     this.jPanel132.setLayout(new GridLayout(1, 0));
/*       */     
/*  3637 */     this.jLabel128.setHorizontalAlignment(0);
/*  3638 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Lineas.png")));
/*  3639 */     this.jLabel128.setToolTipText("Lineas");
/*  3640 */     this.jLabel128.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3642 */             Principal.this.jLabel128MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3645 */             Principal.this.jLabel128MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3648 */             Principal.this.jLabel128MouseExited(evt);
/*       */           }
/*       */         });
/*  3651 */     this.jPanel132.add(this.jLabel128);
/*       */     
/*  3653 */     this.jPanel126.add(this.jPanel132);
/*       */     
/*  3655 */     this.jPanel133.setBackground(this.lc.PRIMARIO1);
/*  3656 */     this.jPanel133.setLayout(new GridLayout(1, 0));
/*       */     
/*  3658 */     this.jLabel129.setHorizontalAlignment(0);
/*  3659 */     this.jLabel129.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Cotizaciones.png")));
/*  3660 */     this.jLabel129.setToolTipText("Cotizaciones");
/*  3661 */     this.jLabel129.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3663 */             Principal.this.jLabel129MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3666 */             Principal.this.jLabel129MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3669 */             Principal.this.jLabel129MouseEntered(evt);
/*       */           }
/*       */         });
/*  3672 */     this.jPanel133.add(this.jLabel129);
/*       */     
/*  3674 */     this.jPanel126.add(this.jPanel133);
/*       */     
/*  3676 */     this.jPanel134.setBackground(this.lc.PRIMARIO1);
/*  3677 */     this.jPanel134.setLayout(new GridLayout(1, 0));
/*       */     
/*  3679 */     this.jLabel130.setHorizontalAlignment(0);
/*  3680 */     this.jLabel130.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/calculator.png")));
/*  3681 */     this.jLabel130.setToolTipText("Prefacturas");
/*  3682 */     this.jLabel130.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3684 */             Principal.this.jLabel130MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3687 */             Principal.this.jLabel130MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3690 */             Principal.this.jLabel130MouseEntered(evt);
/*       */           }
/*       */         });
/*  3693 */     this.jPanel134.add(this.jLabel130);
/*       */     
/*  3695 */     this.jPanel126.add(this.jPanel134);
/*       */     
/*  3697 */     this.jPanel135.setBackground(this.lc.PRIMARIO1);
/*  3698 */     this.jPanel135.setLayout(new GridLayout(1, 0));
/*       */     
/*  3700 */     this.jLabel131.setHorizontalAlignment(0);
/*  3701 */     this.jLabel131.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/listaliqui.png")));
/*  3702 */     this.jLabel131.setToolTipText("Tarjetas deudor");
/*  3703 */     this.jLabel131.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3705 */             Principal.this.jLabel131MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3708 */             Principal.this.jLabel131MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3711 */             Principal.this.jLabel131MouseExited(evt);
/*       */           }
/*       */         });
/*  3714 */     this.jPanel135.add(this.jLabel131);
/*       */     
/*  3716 */     this.jPanel126.add(this.jPanel135);
/*       */     
/*  3718 */     this.jPanel136.setBackground(this.lc.PRIMARIO1);
/*  3719 */     this.jPanel136.setLayout(new GridLayout(1, 0));
/*       */     
/*  3721 */     this.jLabel132.setHorizontalAlignment(0);
/*  3722 */     this.jLabel132.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/recepcion.png")));
/*  3723 */     this.jLabel132.setToolTipText("Recepción de documentos");
/*  3724 */     this.jLabel132.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3726 */             Principal.this.jLabel132MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3729 */             Principal.this.jLabel132MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3732 */             Principal.this.jLabel132MouseEntered(evt);
/*       */           }
/*       */         });
/*  3735 */     this.jPanel136.add(this.jLabel132);
/*       */     
/*  3737 */     this.jPanel126.add(this.jPanel136);
/*       */     
/*  3739 */     this.jPanel137.setBackground(this.lc.PRIMARIO1);
/*  3740 */     this.jPanel137.setLayout(new GridLayout(1, 0));
/*       */     
/*  3742 */     this.jLabel133.setHorizontalAlignment(0);
/*  3743 */     this.jLabel133.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/depositos2.png")));
/*  3744 */     this.jLabel133.setToolTipText("Reportes de entrega de depósitos");
/*  3745 */     this.jLabel133.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3747 */             Principal.this.jLabel133MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3750 */             Principal.this.jLabel133MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3753 */             Principal.this.jLabel133MouseEntered(evt);
/*       */           }
/*       */         });
/*  3756 */     this.jPanel137.add(this.jLabel133);
/*       */     
/*  3758 */     this.jPanel126.add(this.jPanel137);
/*       */     
/*  3760 */     this.jPanel138.setBackground(this.lc.PRIMARIO1);
/*  3761 */     this.jPanel138.setLayout(new GridLayout(1, 0));
/*       */     
/*  3763 */     this.jLabel134.setHorizontalAlignment(0);
/*  3764 */     this.jLabel134.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Facturación  Pendiente.png")));
/*  3765 */     this.jLabel134.setToolTipText("Cuentas por cobrar");
/*  3766 */     this.jLabel134.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3768 */             Principal.this.jLabel134MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3771 */             Principal.this.jLabel134MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3774 */             Principal.this.jLabel134MouseEntered(evt);
/*       */           }
/*       */         });
/*  3777 */     this.jPanel138.add(this.jLabel134);
/*       */     
/*  3779 */     this.jPanel126.add(this.jPanel138);
/*       */     
/*  3781 */     this.jPanel167.setBackground(this.lc.PRIMARIO1);
/*  3782 */     this.jPanel167.setBorder(BorderFactory.createTitledBorder(null, "Cuentas por pagar", 2, 6, new Font("Cantarell", 0, 11), new Color(255, 255, 255)));
/*  3783 */     this.jPanel167.setLayout(new GridLayout(1, 4, 4, 4));
/*       */     
/*  3785 */     this.jPanel168.setBackground(this.lc.PRIMARIO1);
/*  3786 */     this.jPanel168.setLayout(new GridLayout(2, 0, 0, 4));
/*       */     
/*  3788 */     this.jPanel169.setBackground(this.lc.PRIMARIO1);
/*  3789 */     this.jPanel169.setLayout(new GridLayout(1, 0));
/*       */     
/*  3791 */     this.jLabel147.setHorizontalAlignment(0);
/*  3792 */     this.jLabel147.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/payment-method.png")));
/*  3793 */     this.jLabel147.setToolTipText("Cuentas Bancarias");
/*  3794 */     this.jLabel147.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3796 */             Principal.this.jLabel147MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3799 */             Principal.this.jLabel147MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3802 */             Principal.this.jLabel147MouseExited(evt);
/*       */           }
/*       */         });
/*  3805 */     this.jPanel169.add(this.jLabel147);
/*       */     
/*  3807 */     this.jPanel168.add(this.jPanel169);
/*       */     
/*  3809 */     this.jPanel170.setBackground(this.lc.PRIMARIO1);
/*  3810 */     this.jPanel170.setLayout(new GridLayout(1, 0));
/*       */     
/*  3812 */     this.jLabel148.setHorizontalAlignment(0);
/*  3813 */     this.jLabel148.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/proveedores.png")));
/*  3814 */     this.jLabel148.setToolTipText("Proveedores");
/*  3815 */     this.jLabel148.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3817 */             Principal.this.jLabel148MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3820 */             Principal.this.jLabel148MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3823 */             Principal.this.jLabel148MouseExited(evt);
/*       */           }
/*       */         });
/*  3826 */     this.jPanel170.add(this.jLabel148);
/*       */     
/*  3828 */     this.jPanel168.add(this.jPanel170);
/*       */     
/*  3830 */     this.jPanel167.add(this.jPanel168);
/*       */     
/*  3832 */     this.jPanel171.setBackground(this.lc.PRIMARIO1);
/*  3833 */     this.jPanel171.setLayout(new GridLayout(2, 0, 0, 4));
/*       */     
/*  3835 */     this.jPanel172.setBackground(this.lc.PRIMARIO1);
/*  3836 */     this.jPanel172.setLayout(new GridLayout(1, 0));
/*       */     
/*  3838 */     this.jLabel149.setHorizontalAlignment(0);
/*  3839 */     this.jLabel149.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/prov_facturas.png")));
/*  3840 */     this.jLabel149.setToolTipText("Facturas");
/*  3841 */     this.jLabel149.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3843 */             Principal.this.jLabel149MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3846 */             Principal.this.jLabel149MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3849 */             Principal.this.jLabel149MouseExited(evt);
/*       */           }
/*       */         });
/*  3852 */     this.jPanel172.add(this.jLabel149);
/*       */     
/*  3854 */     this.jPanel171.add(this.jPanel172);
/*       */     
/*  3856 */     this.jPanel175.setBackground(this.lc.PRIMARIO1);
/*  3857 */     this.jPanel175.setLayout(new GridLayout(1, 0));
/*       */     
/*  3859 */     this.jLabel151.setHorizontalAlignment(0);
/*  3860 */     this.jLabel151.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/cash.png")));
/*  3861 */     this.jLabel151.setToolTipText("Pagos");
/*  3862 */     this.jLabel151.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3864 */             Principal.this.jLabel151MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3867 */             Principal.this.jLabel151MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3870 */             Principal.this.jLabel151MouseExited(evt);
/*       */           }
/*       */         });
/*  3873 */     this.jPanel175.add(this.jLabel151);
/*       */     
/*  3875 */     this.jPanel171.add(this.jPanel175);
/*       */     
/*  3877 */     this.jPanel167.add(this.jPanel171);
/*       */     
/*  3879 */     this.jPanel174.setBackground(this.lc.PRIMARIO1);
/*  3880 */     this.jPanel174.setLayout(new GridLayout(1, 0, 0, 4));
/*       */     
/*  3882 */     this.jPanel173.setBackground(this.lc.PRIMARIO1);
/*  3883 */     this.jPanel173.setLayout(new GridLayout(1, 0));
/*       */     
/*  3885 */     this.jLabel150.setHorizontalAlignment(0);
/*  3886 */     this.jLabel150.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/group.png")));
/*  3887 */     this.jLabel150.setToolTipText("Tarjetas deudor");
/*  3888 */     this.jLabel150.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3890 */             Principal.this.jLabel150MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3893 */             Principal.this.jLabel150MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3896 */             Principal.this.jLabel150MouseExited(evt);
/*       */           }
/*       */         });
/*  3899 */     this.jPanel173.add(this.jLabel150);
/*       */     
/*  3901 */     this.jPanel174.add(this.jPanel173);
/*       */     
/*  3903 */     this.jPanel167.add(this.jPanel174);
/*       */     
/*  3905 */     this.jPanel204.setBackground(this.lc.PRIMARIO1);
/*  3906 */     this.jPanel204.setBorder(BorderFactory.createTitledBorder(null, "Almacén", 2, 6, new Font("Cantarell", 0, 11), new Color(255, 255, 255)));
/*  3907 */     this.jPanel204.setLayout(new GridLayout(1, 4, 4, 4));
/*       */     
/*  3909 */     this.jPanel200.setBackground(this.lc.PRIMARIO1);
/*  3910 */     this.jPanel200.setLayout(new GridLayout(2, 0, 0, 4));
/*       */     
/*  3912 */     this.jPanel205.setBackground(this.lc.PRIMARIO1);
/*  3913 */     this.jPanel205.setLayout(new GridLayout(1, 0));
/*       */     
/*  3915 */     this.jLabel163.setHorizontalAlignment(0);
/*  3916 */     this.jLabel163.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/checkout.png")));
/*  3917 */     this.jLabel163.setToolTipText("Compras - Requisiciones");
/*  3918 */     this.jLabel163.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3920 */             Principal.this.jLabel163MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3923 */             Principal.this.jLabel163MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3926 */             Principal.this.jLabel163MouseExited(evt);
/*       */           }
/*       */         });
/*  3929 */     this.jPanel205.add(this.jLabel163);
/*       */     
/*  3931 */     this.jPanel200.add(this.jPanel205);
/*       */     
/*  3933 */     this.jPanel202.setBackground(this.lc.PRIMARIO1);
/*  3934 */     this.jPanel202.setLayout(new GridLayout(1, 0));
/*       */     
/*  3936 */     this.jLabel177.setHorizontalAlignment(0);
/*  3937 */     this.jLabel177.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/products.png")));
/*  3938 */     this.jLabel177.setToolTipText("Artículos y productos");
/*  3939 */     this.jLabel177.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3941 */             Principal.this.jLabel177MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3944 */             Principal.this.jLabel177MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3947 */             Principal.this.jLabel177MouseExited(evt);
/*       */           }
/*       */         });
/*  3950 */     this.jPanel202.add(this.jLabel177);
/*       */     
/*  3952 */     this.jPanel200.add(this.jPanel202);
/*       */     
/*  3954 */     this.jPanel204.add(this.jPanel200);
/*       */     
/*  3956 */     this.jPanel206.setBackground(this.lc.PRIMARIO1);
/*  3957 */     this.jPanel206.setLayout(new GridLayout(2, 0, 0, 4));
/*       */     
/*  3959 */     this.jPanel207.setBackground(this.lc.PRIMARIO1);
/*  3960 */     this.jPanel207.setLayout(new GridLayout(1, 0));
/*       */     
/*  3962 */     this.jLabel172.setHorizontalAlignment(0);
/*  3963 */     this.jLabel172.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/classification.png")));
/*  3964 */     this.jLabel172.setToolTipText("Categorías de productos");
/*  3965 */     this.jLabel172.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3967 */             Principal.this.jLabel172MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3970 */             Principal.this.jLabel172MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3973 */             Principal.this.jLabel172MouseExited(evt);
/*       */           }
/*       */         });
/*  3976 */     this.jPanel207.add(this.jLabel172);
/*       */     
/*  3978 */     this.jPanel206.add(this.jPanel207);
/*       */     
/*  3980 */     this.jPanel208.setBackground(this.lc.PRIMARIO1);
/*  3981 */     this.jPanel208.setLayout(new GridLayout(1, 0));
/*       */     
/*  3983 */     this.jLabel173.setHorizontalAlignment(0);
/*  3984 */     this.jLabel173.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/warehouse.png")));
/*  3985 */     this.jLabel173.setToolTipText("Almacén: Entradas y Salidas");
/*  3986 */     this.jLabel173.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3988 */             Principal.this.jLabel173MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3991 */             Principal.this.jLabel173MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3994 */             Principal.this.jLabel173MouseExited(evt);
/*       */           }
/*       */         });
/*  3997 */     this.jPanel208.add(this.jLabel173);
/*       */     
/*  3999 */     this.jPanel206.add(this.jPanel208);
/*       */     
/*  4001 */     this.jPanel204.add(this.jPanel206);
/*       */     
/*  4003 */     GroupLayout jPanel69Layout = new GroupLayout(this.jPanel69);
/*  4004 */     this.jPanel69.setLayout(jPanel69Layout);
/*  4005 */     jPanel69Layout.setHorizontalGroup(jPanel69Layout
/*  4006 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4007 */         .addGroup(jPanel69Layout.createSequentialGroup()
/*  4008 */           .addComponent(this.jPanel110, -2, 93, -2)
/*  4009 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4010 */           .addComponent(this.jPanel123, -2, 93, -2)
/*  4011 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4012 */           .addComponent(this.jPanel126, -2, 297, -2)
/*  4013 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4014 */           .addComponent(this.jPanel167, -2, 146, -2)
/*  4015 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4016 */           .addComponent(this.jPanel204, -2, 152, -2)
/*  4017 */           .addGap(0, 0, 32767)));
/*       */     
/*  4019 */     jPanel69Layout.setVerticalGroup(jPanel69Layout
/*  4020 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4021 */         .addComponent(this.jPanel110, -1, -1, 32767)
/*  4022 */         .addComponent(this.jPanel123, -1, -1, 32767)
/*  4023 */         .addComponent(this.jPanel126, -1, -1, 32767)
/*  4024 */         .addComponent(this.jPanel167, -1, -1, 32767)
/*  4025 */         .addComponent(this.jPanel204, GroupLayout.Alignment.TRAILING, -2, 0, 32767));
/*       */ 
/*       */     
/*  4028 */     this.jPanel71.setBackground(this.lc.PRIMARIO1);
/*  4029 */     this.jPanel71.setBorder(BorderFactory.createTitledBorder(null, "Remolques", 2, 6, new Font("Cantarell", 0, 11), new Color(255, 255, 255)));
/*  4030 */     this.jPanel71.setLayout(new GridLayout(2, 2, 5, 5));
/*       */     
/*  4032 */     this.jPanel93.setBackground(this.lc.PRIMARIO1);
/*  4033 */     this.jPanel93.setLayout(new GridLayout(1, 0));
/*       */     
/*  4035 */     this.jLabel82.setHorizontalAlignment(0);
/*  4036 */     this.jLabel82.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/AgregarCaja.png")));
/*  4037 */     this.jLabel82.setToolTipText("Agregar remolques");
/*  4038 */     this.jLabel82.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4040 */             Principal.this.jLabel82MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4043 */             Principal.this.jLabel82MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4046 */             Principal.this.jLabel82MouseEntered(evt);
/*       */           }
/*       */         });
/*  4049 */     this.jPanel93.add(this.jLabel82);
/*       */     
/*  4051 */     this.jPanel71.add(this.jPanel93);
/*       */     
/*  4053 */     this.jPanel94.setBackground(this.lc.PRIMARIO1);
/*  4054 */     this.jPanel94.setLayout(new GridLayout(1, 0));
/*       */     
/*  4056 */     this.jLabel84.setHorizontalAlignment(0);
/*  4057 */     this.jLabel84.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/BuscarCaja.png")));
/*  4058 */     this.jLabel84.setToolTipText("Buscar remolques");
/*  4059 */     this.jLabel84.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4061 */             Principal.this.jLabel84MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4064 */             Principal.this.jLabel84MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4067 */             Principal.this.jLabel84MouseEntered(evt);
/*       */           }
/*       */         });
/*  4070 */     this.jPanel94.add(this.jLabel84);
/*       */     
/*  4072 */     this.jPanel71.add(this.jPanel94);
/*       */     
/*  4074 */     this.jPanel95.setBackground(this.lc.PRIMARIO1);
/*  4075 */     this.jPanel95.setLayout(new GridLayout(1, 0));
/*       */     
/*  4077 */     this.jLabel87.setHorizontalAlignment(0);
/*  4078 */     this.jLabel87.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/modificarCaja.png")));
/*  4079 */     this.jLabel87.setToolTipText("Modificar remolques");
/*  4080 */     this.jLabel87.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4082 */             Principal.this.jLabel87MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4085 */             Principal.this.jLabel87MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4088 */             Principal.this.jLabel87MouseEntered(evt);
/*       */           }
/*       */         });
/*  4091 */     this.jPanel95.add(this.jLabel87);
/*       */     
/*  4093 */     this.jPanel71.add(this.jPanel95);
/*       */     
/*  4095 */     this.jPanel96.setBackground(this.lc.PRIMARIO1);
/*  4096 */     this.jPanel96.setLayout(new GridLayout(1, 0));
/*       */     
/*  4098 */     this.jLabel88.setHorizontalAlignment(0);
/*  4099 */     this.jLabel88.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/eliminarCaja.png")));
/*  4100 */     this.jLabel88.setToolTipText("Eliminar remolques");
/*  4101 */     this.jLabel88.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4103 */             Principal.this.jLabel88MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4106 */             Principal.this.jLabel88MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4109 */             Principal.this.jLabel88MouseEntered(evt);
/*       */           }
/*       */         });
/*  4112 */     this.jPanel96.add(this.jLabel88);
/*       */     
/*  4114 */     this.jPanel71.add(this.jPanel96);
/*       */     
/*  4116 */     this.jPanel16.setLayout(new GridLayout(2, 2, 6, 6));
/*       */     
/*  4118 */     this.jPanel89.setBackground(this.lc.PRIMARIO1);
/*  4119 */     this.jPanel89.setLayout(new GridLayout(1, 0));
/*       */     
/*  4121 */     this.jLabel81.setHorizontalAlignment(0);
/*  4122 */     this.jLabel81.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/AgregarTracto.png")));
/*  4123 */     this.jLabel81.setToolTipText("Agregar unidades");
/*  4124 */     this.jLabel81.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4126 */             Principal.this.jLabel81MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4129 */             Principal.this.jLabel81MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4132 */             Principal.this.jLabel81MouseEntered(evt);
/*       */           }
/*       */         });
/*  4135 */     this.jPanel89.add(this.jLabel81);
/*       */     
/*  4137 */     this.jPanel16.add(this.jPanel89);
/*       */     
/*  4139 */     this.jPanel92.setBackground(this.lc.PRIMARIO1);
/*  4140 */     this.jPanel92.setLayout(new GridLayout(1, 0));
/*       */     
/*  4142 */     this.jLabel86.setHorizontalAlignment(0);
/*  4143 */     this.jLabel86.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/BuscarTracto.png")));
/*  4144 */     this.jLabel86.setToolTipText("Buscar unidades");
/*  4145 */     this.jLabel86.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4147 */             Principal.this.jLabel86MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4150 */             Principal.this.jLabel86MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4153 */             Principal.this.jLabel86MouseExited(evt);
/*       */           }
/*       */         });
/*  4156 */     this.jPanel92.add(this.jLabel86);
/*       */     
/*  4158 */     this.jPanel16.add(this.jPanel92);
/*       */     
/*  4160 */     this.jPanel91.setBackground(this.lc.PRIMARIO1);
/*  4161 */     this.jPanel91.setLayout(new GridLayout(1, 0));
/*       */     
/*  4163 */     this.jLabel85.setHorizontalAlignment(0);
/*  4164 */     this.jLabel85.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/ModificarTracto.png")));
/*  4165 */     this.jLabel85.setToolTipText("Modificar unidades");
/*  4166 */     this.jLabel85.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4168 */             Principal.this.jLabel85MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4171 */             Principal.this.jLabel85MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4174 */             Principal.this.jLabel85MouseEntered(evt);
/*       */           }
/*       */         });
/*  4177 */     this.jPanel91.add(this.jLabel85);
/*       */     
/*  4179 */     this.jPanel16.add(this.jPanel91);
/*       */     
/*  4181 */     this.jPanel90.setBackground(this.lc.PRIMARIO1);
/*  4182 */     this.jPanel90.setLayout(new GridLayout(1, 0));
/*       */     
/*  4184 */     this.jLabel83.setHorizontalAlignment(0);
/*  4185 */     this.jLabel83.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/eliminarTracto.png")));
/*  4186 */     this.jLabel83.setToolTipText("Eliminar unidades");
/*  4187 */     this.jLabel83.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4189 */             Principal.this.jLabel83MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4192 */             Principal.this.jLabel83MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4195 */             Principal.this.jLabel83MouseEntered(evt);
/*       */           }
/*       */         });
/*  4198 */     this.jPanel90.add(this.jLabel83);
/*       */     
/*  4200 */     this.jPanel16.add(this.jPanel90);
/*       */     
/*  4202 */     this.jPanel19.setBackground(this.lc.PRIMARIO1);
/*  4203 */     this.jPanel19.setBorder(BorderFactory.createTitledBorder(null, "Destinatarios", 2, 6, new Font("Cantarell", 0, 11), new Color(255, 255, 255)));
/*  4204 */     this.jPanel19.setLayout(new GridLayout(1, 0, 5, 0));
/*       */     
/*  4206 */     this.jPanel85.setBackground(this.lc.PRIMARIO1);
/*  4207 */     this.jPanel85.setLayout(new GridLayout(1, 0));
/*       */     
/*  4209 */     this.jLabel77.setHorizontalAlignment(0);
/*  4210 */     this.jLabel77.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/agregarDesti.png")));
/*  4211 */     this.jLabel77.setToolTipText("Agregar destinos o confinamientos");
/*  4212 */     this.jLabel77.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4214 */             Principal.this.jLabel77MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4217 */             Principal.this.jLabel77MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4220 */             Principal.this.jLabel77MouseEntered(evt);
/*       */           }
/*       */         });
/*  4223 */     this.jPanel85.add(this.jLabel77);
/*       */     
/*  4225 */     this.jPanel19.add(this.jPanel85);
/*       */     
/*  4227 */     this.jPanel86.setBackground(this.lc.PRIMARIO1);
/*  4228 */     this.jPanel86.setLayout(new GridLayout(1, 0));
/*       */     
/*  4230 */     this.jLabel78.setHorizontalAlignment(0);
/*  4231 */     this.jLabel78.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/ModifiDesti.png")));
/*  4232 */     this.jLabel78.setToolTipText("Modificar destinos o confinamientos");
/*  4233 */     this.jLabel78.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4235 */             Principal.this.jLabel78MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4238 */             Principal.this.jLabel78MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4241 */             Principal.this.jLabel78MouseEntered(evt);
/*       */           }
/*       */         });
/*  4244 */     this.jPanel86.add(this.jLabel78);
/*       */     
/*  4246 */     this.jPanel19.add(this.jPanel86);
/*       */     
/*  4248 */     this.jPanel87.setBackground(this.lc.PRIMARIO1);
/*  4249 */     this.jPanel87.setLayout(new GridLayout(1, 0));
/*       */     
/*  4251 */     this.jLabel79.setHorizontalAlignment(0);
/*  4252 */     this.jLabel79.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/EliminarDesti.png")));
/*  4253 */     this.jLabel79.setToolTipText("Eliminar destinos o confinamientos");
/*  4254 */     this.jLabel79.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4256 */             Principal.this.jLabel79MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4259 */             Principal.this.jLabel79MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4262 */             Principal.this.jLabel79MouseEntered(evt);
/*       */           }
/*       */         });
/*  4265 */     this.jPanel87.add(this.jLabel79);
/*       */     
/*  4267 */     this.jPanel19.add(this.jPanel87);
/*       */     
/*  4269 */     this.jPanel88.setBackground(this.lc.PRIMARIO1);
/*  4270 */     this.jPanel88.setLayout(new GridLayout(1, 0));
/*       */     
/*  4272 */     this.jLabel80.setHorizontalAlignment(0);
/*  4273 */     this.jLabel80.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/buscarDesti.png")));
/*  4274 */     this.jLabel80.setToolTipText("Buscar destinos o confinamientos");
/*  4275 */     this.jLabel80.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4277 */             Principal.this.jLabel80MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4280 */             Principal.this.jLabel80MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4283 */             Principal.this.jLabel80MouseExited(evt);
/*       */           }
/*       */         });
/*  4286 */     this.jPanel88.add(this.jLabel80);
/*       */     
/*  4288 */     this.jPanel19.add(this.jPanel88);
/*       */     
/*  4290 */     this.jPanel10.setBackground(this.lc.PRIMARIO1);
/*  4291 */     this.jPanel10.setBorder(BorderFactory.createTitledBorder(null, "Clientes, Origenes y Destinos", 2, 6, new Font("Cantarell", 0, 11), new Color(255, 255, 255)));
/*  4292 */     this.jPanel10.setLayout(new GridLayout(1, 0, 5, 0));
/*       */     
/*  4294 */     this.jPanel81.setBackground(this.lc.PRIMARIO1);
/*  4295 */     this.jPanel81.setLayout(new GridLayout(1, 0));
/*       */     
/*  4297 */     this.jLabel73.setHorizontalAlignment(0);
/*  4298 */     this.jLabel73.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/AgregarOrigen.png")));
/*  4299 */     this.jLabel73.setToolTipText("Agregar clientes");
/*  4300 */     this.jLabel73.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4302 */             Principal.this.jLabel73MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4305 */             Principal.this.jLabel73MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4308 */             Principal.this.jLabel73MouseExited(evt);
/*       */           }
/*       */         });
/*  4311 */     this.jPanel81.add(this.jLabel73);
/*       */     
/*  4313 */     this.jPanel10.add(this.jPanel81);
/*       */     
/*  4315 */     this.jPanel82.setBackground(this.lc.PRIMARIO1);
/*  4316 */     this.jPanel82.setLayout(new GridLayout(1, 0));
/*       */     
/*  4318 */     this.jLabel74.setHorizontalAlignment(0);
/*  4319 */     this.jLabel74.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/modificarOrigen.png")));
/*  4320 */     this.jLabel74.setToolTipText("Modificar clientes");
/*  4321 */     this.jLabel74.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4323 */             Principal.this.jLabel74MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4326 */             Principal.this.jLabel74MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4329 */             Principal.this.jLabel74MouseExited(evt);
/*       */           }
/*       */         });
/*  4332 */     this.jPanel82.add(this.jLabel74);
/*       */     
/*  4334 */     this.jPanel10.add(this.jPanel82);
/*       */     
/*  4336 */     this.jPanel83.setBackground(this.lc.PRIMARIO1);
/*  4337 */     this.jPanel83.setLayout(new GridLayout(1, 0));
/*       */     
/*  4339 */     this.jLabel75.setHorizontalAlignment(0);
/*  4340 */     this.jLabel75.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/eliminarOrigen.png")));
/*  4341 */     this.jLabel75.setToolTipText("Eliminar clientes");
/*  4342 */     this.jLabel75.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4344 */             Principal.this.jLabel75MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4347 */             Principal.this.jLabel75MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4350 */             Principal.this.jLabel75MouseExited(evt);
/*       */           }
/*       */         });
/*  4353 */     this.jPanel83.add(this.jLabel75);
/*       */     
/*  4355 */     this.jPanel10.add(this.jPanel83);
/*       */     
/*  4357 */     this.jPanel84.setBackground(this.lc.PRIMARIO1);
/*  4358 */     this.jPanel84.setLayout(new GridLayout(1, 0));
/*       */     
/*  4360 */     this.jLabel76.setHorizontalAlignment(0);
/*  4361 */     this.jLabel76.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/buscarOrigen.png")));
/*  4362 */     this.jLabel76.setToolTipText("Buscar clientes");
/*  4363 */     this.jLabel76.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4365 */             Principal.this.jLabel76MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4368 */             Principal.this.jLabel76MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4371 */             Principal.this.jLabel76MouseExited(evt);
/*       */           }
/*       */         });
/*  4374 */     this.jPanel84.add(this.jLabel76);
/*       */     
/*  4376 */     this.jPanel10.add(this.jPanel84);
/*       */     
/*  4378 */     this.jPanel54.setBackground(this.lc.PRIMARIO1);
/*  4379 */     this.jPanel54.setLayout(new GridLayout(1, 0));
/*       */     
/*  4381 */     this.jLabel47.setHorizontalAlignment(0);
/*  4382 */     this.jLabel47.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/pedidos.png")));
/*  4383 */     this.jLabel47.setToolTipText("Agregar nuevos pedidos");
/*  4384 */     this.jLabel47.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4386 */             Principal.this.jLabel47MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4389 */             Principal.this.jLabel47MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4392 */             Principal.this.jLabel47MouseEntered(evt);
/*       */           }
/*       */         });
/*  4395 */     this.jPanel54.add(this.jLabel47);
/*       */     
/*  4397 */     this.jPanel14.setBackground(this.lc.SECUNDARIO2);
/*  4398 */     this.jPanel14.setLayout(new GridLayout(1, 2, 12, 0));
/*       */     
/*  4400 */     this.jPanel25.setBackground(this.lc.SECUNDARIO2);
/*  4401 */     this.jPanel25.setLayout(new GridLayout(1, 2, 6, 0));
/*       */     
/*  4403 */     this.jLabel5.setHorizontalAlignment(4);
/*  4404 */     this.jLabel5.setText("Tipo de cambio vigente: ");
/*  4405 */     this.jPanel25.add(this.jLabel5);
/*       */     
/*  4407 */     this.jLabel6.setFont(new Font("Cantarell", 1, 15));
/*  4408 */     this.jLabel6.setText("?");
/*  4409 */     this.jPanel25.add(this.jLabel6);
/*       */     
/*  4411 */     this.jPanel14.add(this.jPanel25);
/*       */     
/*  4413 */     this.jPanel27.setBackground(this.lc.SECUNDARIO2);
/*  4414 */     this.jPanel27.setLayout(new GridLayout(1, 2, 6, 0));
/*       */     
/*  4416 */     this.jLabel18.setHorizontalAlignment(4);
/*  4417 */     this.jLabel18.setText("Tipo de cambio dia anterior: ");
/*  4418 */     this.jPanel27.add(this.jLabel18);
/*       */     
/*  4420 */     this.jLabel161.setFont(new Font("Cantarell", 1, 15));
/*  4421 */     this.jLabel161.setText("$0.00");
/*  4422 */     this.jPanel27.add(this.jLabel161);
/*       */     
/*  4424 */     this.jPanel14.add(this.jPanel27);
/*       */     
/*  4426 */     GroupLayout jPanel57Layout = new GroupLayout(this.jPanel57);
/*  4427 */     this.jPanel57.setLayout(jPanel57Layout);
/*  4428 */     jPanel57Layout.setHorizontalGroup(jPanel57Layout
/*  4429 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4430 */         .addGroup(jPanel57Layout.createSequentialGroup()
/*  4431 */           .addGroup(jPanel57Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  4432 */             .addComponent(this.jPanel69, -1, -1, 32767)
/*  4433 */             .addComponent(this.jPanel66, -1, -1, 32767))
/*  4434 */           .addGap(0, 0, 32767))
/*  4435 */         .addGroup(jPanel57Layout.createSequentialGroup()
/*  4436 */           .addContainerGap()
/*  4437 */           .addComponent(this.jPanel71, -2, 114, -2)
/*  4438 */           .addGap(42, 42, 42)
/*  4439 */           .addComponent(this.jPanel16, -2, 97, -2)
/*  4440 */           .addGap(18, 18, 18)
/*  4441 */           .addComponent(this.jPanel19, -2, 163, -2)
/*  4442 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4443 */           .addComponent(this.jPanel10, -2, 162, -2)
/*  4444 */           .addContainerGap(-1, 32767))
/*  4445 */         .addGroup(jPanel57Layout.createSequentialGroup()
/*  4446 */           .addGap(92, 92, 92)
/*  4447 */           .addComponent(this.jPanel14, -1, 1240, 32767)
/*  4448 */           .addContainerGap())
/*  4449 */         .addGroup(jPanel57Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4450 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel57Layout.createSequentialGroup()
/*  4451 */             .addContainerGap(618, 32767)
/*  4452 */             .addComponent(this.jPanel54, -2, 55, -2)
/*  4453 */             .addContainerGap(665, 32767))));
/*       */     
/*  4455 */     jPanel57Layout.setVerticalGroup(jPanel57Layout
/*  4456 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4457 */         .addGroup(jPanel57Layout.createSequentialGroup()
/*  4458 */           .addGap(44, 44, 44)
/*  4459 */           .addComponent(this.jPanel69, -2, -1, -2)
/*  4460 */           .addGap(63, 63, 63)
/*  4461 */           .addComponent(this.jPanel66, -2, -1, -2)
/*  4462 */           .addGap(52, 52, 52)
/*  4463 */           .addGroup(jPanel57Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4464 */             .addComponent(this.jPanel71, -1, 380, 32767)
/*  4465 */             .addComponent(this.jPanel16, -1, -1, 32767)
/*  4466 */             .addComponent(this.jPanel19, -1, -1, 32767)
/*  4467 */             .addComponent(this.jPanel10, -1, -1, 32767))
/*  4468 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4469 */           .addComponent(this.jPanel14, -1, -1, 32767)
/*  4470 */           .addGap(64, 64, 64))
/*  4471 */         .addGroup(jPanel57Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4472 */           .addGroup(GroupLayout.Alignment.TRAILING, jPanel57Layout.createSequentialGroup()
/*  4473 */             .addContainerGap(454, 32767)
/*  4474 */             .addComponent(this.jPanel54, -2, 85, -2)
/*  4475 */             .addContainerGap(254, 32767))));
/*       */ 
/*       */     
/*  4478 */     this.jPanel179.setForeground(new Color(146, 193, 134));
/*       */     
/*  4480 */     this.jPanel180.setLayout(new GridLayout(1, 2, 40, 0));
/*       */     
/*  4482 */     this.jPanel181.setBackground(this.lc.SECUNDARIO2);
/*  4483 */     this.jPanel181.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/*  4484 */     this.jPanel181.addMouseListener(new MouseAdapter() {
/*       */           public void mouseExited(MouseEvent evt) {
/*  4486 */             Principal.this.jPanel181MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4489 */             Principal.this.jPanel181MouseEntered(evt);
/*       */           }
/*       */         });
/*       */     
/*  4493 */     this.jLabel12.setHorizontalAlignment(0);
/*  4494 */     this.jLabel12.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/cheque.png")));
/*  4495 */     this.jLabel12.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4497 */             Principal.this.jLabel12MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4500 */             Principal.this.jLabel12MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4503 */             Principal.this.jLabel12MouseExited(evt);
/*       */           }
/*       */         });
/*       */     
/*  4507 */     this.jLabel13.setFont(new Font("Cantarell", 1, 13));
/*  4508 */     this.jLabel13.setForeground(this.lc.PRIMARIO1);
/*  4509 */     this.jLabel13.setHorizontalAlignment(0);
/*  4510 */     this.jLabel13.setText("<html><center>CHEQUES</center></html>");
/*       */     
/*  4512 */     GroupLayout jPanel181Layout = new GroupLayout(this.jPanel181);
/*  4513 */     this.jPanel181.setLayout(jPanel181Layout);
/*  4514 */     jPanel181Layout.setHorizontalGroup(jPanel181Layout
/*  4515 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4516 */         .addGroup(jPanel181Layout.createSequentialGroup()
/*  4517 */           .addContainerGap()
/*  4518 */           .addGroup(jPanel181Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4519 */             .addComponent(this.jLabel12, -1, -1, 32767)
/*  4520 */             .addComponent(this.jLabel13, -1, 147, 32767))
/*  4521 */           .addContainerGap()));
/*       */     
/*  4523 */     jPanel181Layout.setVerticalGroup(jPanel181Layout
/*  4524 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4525 */         .addGroup(jPanel181Layout.createSequentialGroup()
/*  4526 */           .addContainerGap()
/*  4527 */           .addComponent(this.jLabel12, -2, 89, -2)
/*  4528 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4529 */           .addComponent(this.jLabel13)
/*  4530 */           .addContainerGap()));
/*       */ 
/*       */     
/*  4533 */     this.jPanel180.add(this.jPanel181);
/*       */     
/*  4535 */     this.jPanel182.setBackground(this.lc.SECUNDARIO2);
/*  4536 */     this.jPanel182.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/*       */     
/*  4538 */     this.jLabel59.setHorizontalAlignment(0);
/*  4539 */     this.jLabel59.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/money-transfer.png")));
/*  4540 */     this.jLabel59.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4542 */             Principal.this.jLabel59MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4545 */             Principal.this.jLabel59MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4548 */             Principal.this.jLabel59MouseExited(evt);
/*       */           }
/*       */         });
/*       */     
/*  4552 */     this.jLabel60.setFont(new Font("Cantarell", 1, 13));
/*  4553 */     this.jLabel60.setForeground(this.lc.PRIMARIO1);
/*  4554 */     this.jLabel60.setHorizontalAlignment(0);
/*  4555 */     this.jLabel60.setText("<html><center>TRANSFERENCIAS</center></html>");
/*       */     
/*  4557 */     GroupLayout jPanel182Layout = new GroupLayout(this.jPanel182);
/*  4558 */     this.jPanel182.setLayout(jPanel182Layout);
/*  4559 */     jPanel182Layout.setHorizontalGroup(jPanel182Layout
/*  4560 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4561 */         .addGroup(jPanel182Layout.createSequentialGroup()
/*  4562 */           .addContainerGap()
/*  4563 */           .addGroup(jPanel182Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4564 */             .addComponent(this.jLabel59, -1, -1, 32767)
/*  4565 */             .addComponent(this.jLabel60))
/*  4566 */           .addContainerGap()));
/*       */     
/*  4568 */     jPanel182Layout.setVerticalGroup(jPanel182Layout
/*  4569 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4570 */         .addGroup(jPanel182Layout.createSequentialGroup()
/*  4571 */           .addContainerGap()
/*  4572 */           .addComponent(this.jLabel59, -2, 89, -2)
/*  4573 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4574 */           .addComponent(this.jLabel60)
/*  4575 */           .addContainerGap()));
/*       */ 
/*       */     
/*  4578 */     this.jPanel180.add(this.jPanel182);
/*       */     
/*  4580 */     GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
/*  4581 */     this.jPanel15.setLayout(jPanel15Layout);
/*  4582 */     jPanel15Layout.setHorizontalGroup(jPanel15Layout
/*  4583 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4584 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
/*  4585 */           .addContainerGap(40, 32767)
/*  4586 */           .addComponent(this.jPanel180, -2, 363, -2)
/*  4587 */           .addGap(37, 37, 37)));
/*       */     
/*  4589 */     jPanel15Layout.setVerticalGroup(jPanel15Layout
/*  4590 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4591 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
/*  4592 */           .addContainerGap(117, 32767)
/*  4593 */           .addComponent(this.jPanel180, -2, 150, -2)
/*  4594 */           .addGap(143, 143, 143)));
/*       */ 
/*       */     
/*  4597 */     GroupLayout jPanel179Layout = new GroupLayout(this.jPanel179);
/*  4598 */     this.jPanel179.setLayout(jPanel179Layout);
/*  4599 */     jPanel179Layout.setHorizontalGroup(jPanel179Layout
/*  4600 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4601 */         .addGroup(jPanel179Layout.createSequentialGroup()
/*  4602 */           .addGap(0, 254, 32767)
/*  4603 */           .addComponent(this.jPanel15, -2, -1, -2)
/*  4604 */           .addGap(0, 255, 32767)));
/*       */     
/*  4606 */     jPanel179Layout.setVerticalGroup(jPanel179Layout
/*  4607 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4608 */         .addGroup(jPanel179Layout.createSequentialGroup()
/*  4609 */           .addGap(0, 11, 32767)
/*  4610 */           .addComponent(this.jPanel15, -2, -1, -2)
/*  4611 */           .addGap(0, 11, 32767)));
/*       */ 
/*       */     
/*  4614 */     this.jPanel43.setForeground(new Color(146, 193, 134));
/*       */     
/*  4616 */     this.jPanel36.setLayout(new GridLayout(1, 3, 40, 0));
/*       */     
/*  4618 */     this.jPanel195.setBackground(this.lc.SECUNDARIO2);
/*  4619 */     this.jPanel195.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/*  4620 */     this.jPanel195.addMouseListener(new MouseAdapter() {
/*       */           public void mouseExited(MouseEvent evt) {
/*  4622 */             Principal.this.jPanel195MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4625 */             Principal.this.jPanel195MouseEntered(evt);
/*       */           }
/*       */         });
/*       */     
/*  4629 */     this.jLabel64.setHorizontalAlignment(0);
/*  4630 */     this.jLabel64.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bill.png")));
/*  4631 */     this.jLabel64.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4633 */             Principal.this.jLabel64MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4636 */             Principal.this.jLabel64MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4639 */             Principal.this.jLabel64MouseExited(evt);
/*       */           }
/*       */         });
/*       */     
/*  4643 */     this.jLabel159.setFont(new Font("Cantarell", 1, 13));
/*  4644 */     this.jLabel159.setForeground(this.lc.PRIMARIO1);
/*  4645 */     this.jLabel159.setHorizontalAlignment(0);
/*  4646 */     this.jLabel159.setText("<html><center>Facturación<p> 3.2</center></html>");
/*       */     
/*  4648 */     GroupLayout jPanel195Layout = new GroupLayout(this.jPanel195);
/*  4649 */     this.jPanel195.setLayout(jPanel195Layout);
/*  4650 */     jPanel195Layout.setHorizontalGroup(jPanel195Layout
/*  4651 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4652 */         .addGroup(jPanel195Layout.createSequentialGroup()
/*  4653 */           .addContainerGap()
/*  4654 */           .addGroup(jPanel195Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4655 */             .addComponent(this.jLabel64, -1, -1, 32767)
/*  4656 */             .addComponent(this.jLabel159, -1, 151, 32767))
/*  4657 */           .addContainerGap()));
/*       */     
/*  4659 */     jPanel195Layout.setVerticalGroup(jPanel195Layout
/*  4660 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4661 */         .addGroup(jPanel195Layout.createSequentialGroup()
/*  4662 */           .addContainerGap()
/*  4663 */           .addComponent(this.jLabel64, -2, 89, -2)
/*  4664 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4665 */           .addComponent(this.jLabel159)
/*  4666 */           .addContainerGap()));
/*       */ 
/*       */     
/*  4669 */     this.jPanel36.add(this.jPanel195);
/*       */     
/*  4671 */     this.jPanel196.setBackground(this.lc.SECUNDARIO2);
/*  4672 */     this.jPanel196.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/*       */     
/*  4674 */     this.jLabel160.setHorizontalAlignment(0);
/*  4675 */     this.jLabel160.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/invoice.png")));
/*  4676 */     this.jLabel160.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4678 */             Principal.this.jLabel160MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4681 */             Principal.this.jLabel160MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4684 */             Principal.this.jLabel160MouseExited(evt);
/*       */           }
/*       */         });
/*       */     
/*  4688 */     this.jLabel50.setFont(new Font("Cantarell", 1, 13));
/*  4689 */     this.jLabel50.setForeground(this.lc.PRIMARIO1);
/*  4690 */     this.jLabel50.setHorizontalAlignment(0);
/*  4691 */     this.jLabel50.setText("<html><center>Nueva<p> Facturación</center></html>");
/*       */     
/*  4693 */     GroupLayout jPanel196Layout = new GroupLayout(this.jPanel196);
/*  4694 */     this.jPanel196.setLayout(jPanel196Layout);
/*  4695 */     jPanel196Layout.setHorizontalGroup(jPanel196Layout
/*  4696 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4697 */         .addGroup(jPanel196Layout.createSequentialGroup()
/*  4698 */           .addContainerGap()
/*  4699 */           .addGroup(jPanel196Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4700 */             .addComponent(this.jLabel160, -1, -1, 32767)
/*  4701 */             .addComponent(this.jLabel50, -1, 151, 32767))
/*  4702 */           .addContainerGap()));
/*       */     
/*  4704 */     jPanel196Layout.setVerticalGroup(jPanel196Layout
/*  4705 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4706 */         .addGroup(jPanel196Layout.createSequentialGroup()
/*  4707 */           .addContainerGap()
/*  4708 */           .addComponent(this.jLabel160, -2, 89, -2)
/*  4709 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4710 */           .addComponent(this.jLabel50)
/*  4711 */           .addContainerGap()));
/*       */ 
/*       */     
/*  4714 */     this.jPanel36.add(this.jPanel196);
/*       */     
/*  4716 */     GroupLayout jPanel194Layout = new GroupLayout(this.jPanel194);
/*  4717 */     this.jPanel194.setLayout(jPanel194Layout);
/*  4718 */     jPanel194Layout.setHorizontalGroup(jPanel194Layout
/*  4719 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4720 */         .addGap(0, 881, 32767)
/*  4721 */         .addGroup(jPanel194Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4722 */           .addGroup(jPanel194Layout.createSequentialGroup()
/*  4723 */             .addGap(0, 0, 32767)
/*  4724 */             .addComponent(this.jPanel36, -2, -1, -2)
/*  4725 */             .addGap(0, 0, 32767))));
/*       */     
/*  4727 */     jPanel194Layout.setVerticalGroup(jPanel194Layout
/*  4728 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4729 */         .addGap(0, 421, 32767)
/*  4730 */         .addGroup(jPanel194Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4731 */           .addGroup(jPanel194Layout.createSequentialGroup()
/*  4732 */             .addGap(0, 0, 32767)
/*  4733 */             .addComponent(this.jPanel36, -2, -1, -2)
/*  4734 */             .addGap(0, 0, 32767))));
/*       */ 
/*       */     
/*  4737 */     GroupLayout jPanel43Layout = new GroupLayout(this.jPanel43);
/*  4738 */     this.jPanel43.setLayout(jPanel43Layout);
/*  4739 */     jPanel43Layout.setHorizontalGroup(jPanel43Layout
/*  4740 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4741 */         .addGap(0, 881, 32767)
/*  4742 */         .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4743 */           .addComponent(this.jPanel194, -1, -1, 32767)));
/*       */     
/*  4745 */     jPanel43Layout.setVerticalGroup(jPanel43Layout
/*  4746 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4747 */         .addGap(0, 433, 32767)
/*  4748 */         .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4749 */           .addGroup(jPanel43Layout.createSequentialGroup()
/*  4750 */             .addContainerGap()
/*  4751 */             .addComponent(this.jPanel194, -1, -1, 32767)
/*  4752 */             .addContainerGap())));
/*       */ 
/*       */     
/*  4755 */     this.jMenuItem5.setText("Modo menús");
/*  4756 */     this.jMenuItem5.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4758 */             Principal.this.jMenuItem5ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4761 */     this.jPopupMenu1.add(this.jMenuItem5);
/*       */     
/*  4763 */     this.jMenu18.setText("Cambiar de tema");
/*       */     
/*  4765 */     this.jRadioButtonMenuItem1.setSelected(true);
/*  4766 */     this.jRadioButtonMenuItem1.setText("Rojo (Predeterminado)");
/*  4767 */     this.jRadioButtonMenuItem1.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4769 */             Principal.this.jRadioButtonMenuItem1ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4772 */     this.jMenu18.add(this.jRadioButtonMenuItem1);
/*       */     
/*  4774 */     this.jRadioButtonMenuItem2.setSelected(true);
/*  4775 */     this.jRadioButtonMenuItem2.setText("Verde");
/*  4776 */     this.jRadioButtonMenuItem2.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4778 */             Principal.this.jRadioButtonMenuItem2ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4781 */     this.jMenu18.add(this.jRadioButtonMenuItem2);
/*       */     
/*  4783 */     this.jRadioButtonMenuItem3.setSelected(true);
/*  4784 */     this.jRadioButtonMenuItem3.setText("Azul");
/*  4785 */     this.jRadioButtonMenuItem3.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4787 */             Principal.this.jRadioButtonMenuItem3ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4790 */     this.jMenu18.add(this.jRadioButtonMenuItem3);
/*       */     
/*  4792 */     this.jPopupMenu1.add(this.jMenu18);
/*  4793 */     this.jPopupMenu1.add(this.jSeparator15);
/*       */     
/*  4795 */     this.jMenuItem4.setText("Salir");
/*  4796 */     this.jMenuItem4.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4798 */             Principal.this.jMenuItem4ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4801 */     this.jPopupMenu1.add(this.jMenuItem4);
/*       */     
/*  4803 */     this.jMenuItem67.setText("Modo barra de herramientas");
/*  4804 */     this.jMenuItem67.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4806 */             Principal.this.jMenuItem67ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4809 */     this.jPopupMenu2.add(this.jMenuItem67);
/*  4810 */     this.jPopupMenu2.add(this.jSeparator20);
/*       */     
/*  4812 */     this.jMenuItem68.setText("Salir");
/*  4813 */     this.jMenuItem68.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4815 */             Principal.this.jMenuItem68ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4818 */     this.jPopupMenu2.add(this.jMenuItem68);
/*       */     
/*  4820 */     this.jDialog11.setTitle("Licencias Vencidas");
/*  4821 */     this.jDialog11.setUndecorated(true);
/*       */     
/*  4823 */     this.jPanel177.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO2));
/*       */     
/*  4825 */     this.jPanel178.setBackground(this.lc.SECUNDARIO1);
/*       */     
/*  4827 */     this.jLabel62.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/*  4828 */     this.jLabel62.setForeground(new Color(255, 255, 255));
/*  4829 */     this.jLabel62.setHorizontalAlignment(0);
/*  4830 */     this.jLabel62.setText("Documentación por vencer");
/*  4831 */     this.jLabel62.addMouseMotionListener(new MouseMotionAdapter() {
/*       */           public void mouseDragged(MouseEvent evt) {
/*  4833 */             Principal.this.jLabel62MouseDragged(evt);
/*       */           }
/*       */         });
/*  4836 */     this.jLabel62.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4838 */             Principal.this.jLabel62MouseClicked(evt);
/*       */           }
/*       */         });
/*       */     
/*  4842 */     this.jPanel183.setBackground(this.lc.PRIMARIO1);
/*  4843 */     this.jPanel183.setLayout(new GridLayout(1, 0));
/*       */     
/*  4845 */     this.jLabel152.setHorizontalAlignment(0);
/*  4846 */     this.jLabel152.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*  4847 */     this.jLabel152.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4849 */             Principal.this.jLabel152MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4852 */             Principal.this.jLabel152MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4855 */             Principal.this.jLabel152MouseExited(evt);
/*       */           }
/*       */         });
/*  4858 */     this.jPanel183.add(this.jLabel152);
/*       */     
/*  4860 */     this.jLabel63.setHorizontalAlignment(0);
/*       */     
/*  4862 */     GroupLayout jPanel178Layout = new GroupLayout(this.jPanel178);
/*  4863 */     this.jPanel178.setLayout(jPanel178Layout);
/*  4864 */     jPanel178Layout.setHorizontalGroup(jPanel178Layout
/*  4865 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4866 */         .addGroup(jPanel178Layout.createSequentialGroup()
/*  4867 */           .addGap(1, 1, 1)
/*  4868 */           .addComponent(this.jLabel63, -2, 36, -2)
/*  4869 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4870 */           .addComponent(this.jLabel62, -1, -1, 32767)
/*  4871 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4872 */           .addComponent(this.jPanel183, -2, 34, -2)));
/*       */     
/*  4874 */     jPanel178Layout.setVerticalGroup(jPanel178Layout
/*  4875 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4876 */         .addComponent(this.jPanel183, -1, -1, 32767)
/*  4877 */         .addGroup(jPanel178Layout.createSequentialGroup()
/*  4878 */           .addGroup(jPanel178Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  4879 */             .addComponent(this.jLabel63, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  4880 */             .addComponent(this.jLabel62, -2, 30, -2))
/*  4881 */           .addGap(0, 0, 32767)));
/*       */ 
/*       */     
/*  4884 */     this.jPanel184.setLayout(new GridLayout(1, 3, 6, 0));
/*       */     
/*  4886 */     this.materialButton39.setBackground(this.lc.PRIMARIO1);
/*  4887 */     this.materialButton39.setForeground(new Color(255, 255, 255));
/*  4888 */     this.materialButton39.setMnemonic('I');
/*  4889 */     this.materialButton39.setText("Correo");
/*  4890 */     this.materialButton39.setToolTipText("Imprimir (Alt+L)");
/*  4891 */     this.materialButton39.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/*  4892 */     this.materialButton39.setHorizontalTextPosition(0);
/*  4893 */     this.materialButton39.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4895 */             Principal.this.materialButton39ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4898 */     this.jPanel184.add((Component)this.materialButton39);
/*       */     
/*  4900 */     this.materialButton40.setBackground(this.lc.PRIMARIO1);
/*  4901 */     this.materialButton40.setForeground(new Color(255, 255, 255));
/*  4902 */     this.materialButton40.setMnemonic('G');
/*  4903 */     this.materialButton40.setText("Guardar");
/*  4904 */     this.materialButton40.setToolTipText("Guardar (Alt+G)");
/*  4905 */     this.materialButton40.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/*  4906 */     this.materialButton40.setHorizontalTextPosition(0);
/*  4907 */     this.materialButton40.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4909 */             Principal.this.materialButton40ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4912 */     this.jPanel184.add((Component)this.materialButton40);
/*       */     
/*  4914 */     this.materialButton38.setBackground(this.lc.SECUNDARIO1);
/*  4915 */     this.materialButton38.setForeground(new Color(255, 255, 255));
/*  4916 */     this.materialButton38.setMnemonic('R');
/*  4917 */     this.materialButton38.setText("Cerrar");
/*  4918 */     this.materialButton38.setToolTipText("Cerrar (Alt+R)");
/*  4919 */     this.materialButton38.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/*  4920 */     this.materialButton38.setHorizontalTextPosition(0);
/*  4921 */     this.materialButton38.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4923 */             Principal.this.materialButton38ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4926 */     this.jPanel184.add((Component)this.materialButton38);
/*       */     
/*  4928 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Num", "Tipo" })
/*       */         {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*  4936 */           boolean[] canEdit = new boolean[] { false, false };
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  4941 */             return this.canEdit[columnIndex];
/*       */           }
/*       */         });
/*  4944 */     this.rSTableMetro1.setAltoHead(25);
/*  4945 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  4946 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/*  4947 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/*  4948 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/*  4949 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/*  4950 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/*  4951 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/*  4952 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  4953 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  4954 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/*  4955 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/*  4956 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/*  4957 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/*  4958 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/*  4959 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4961 */             Principal.this.rSTableMetro1MouseClicked(evt);
/*       */           }
/*       */         });
/*  4964 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  4966 */             Principal.this.rSTableMetro1KeyReleased(evt);
/*       */           }
/*       */         });
/*  4969 */     this.jScrollPane33.setViewportView((Component)this.rSTableMetro1);
/*       */     
/*  4971 */     this.jLabel14.setText(" Listado de documentos próximos a vencer en días:");
/*       */     
/*  4973 */     GroupLayout jPanel185Layout = new GroupLayout(this.jPanel185);
/*  4974 */     this.jPanel185.setLayout(jPanel185Layout);
/*  4975 */     jPanel185Layout.setHorizontalGroup(jPanel185Layout
/*  4976 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4977 */         .addComponent(this.jScrollPane33, -1, 729, 32767)
/*  4978 */         .addComponent(this.jLabel14, -1, -1, 32767));
/*       */     
/*  4980 */     jPanel185Layout.setVerticalGroup(jPanel185Layout
/*  4981 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4982 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel185Layout.createSequentialGroup()
/*  4983 */           .addComponent(this.jLabel14)
/*  4984 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4985 */           .addComponent(this.jScrollPane33, -1, 274, 32767)));
/*       */ 
/*       */     
/*  4988 */     this.jPanel186.setLayout(new GridLayout(1, 2, 6, 0));
/*       */     
/*  4990 */     this.jLabel102.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/*  4991 */     this.jLabel102.setForeground(this.lc.SECUNDARIO1);
/*  4992 */     this.jLabel102.setHorizontalAlignment(4);
/*  4993 */     this.jLabel102.setText("Total");
/*  4994 */     this.jPanel186.add(this.jLabel102);
/*       */     
/*  4996 */     this.jLabel103.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/*  4997 */     this.jLabel103.setForeground(this.lc.PRIMARIO1);
/*  4998 */     this.jLabel103.setHorizontalAlignment(2);
/*  4999 */     this.jLabel103.setText("t");
/*  5000 */     this.jPanel186.add(this.jLabel103);
/*       */     
/*  5002 */     GroupLayout jPanel177Layout = new GroupLayout(this.jPanel177);
/*  5003 */     this.jPanel177.setLayout(jPanel177Layout);
/*  5004 */     jPanel177Layout.setHorizontalGroup(jPanel177Layout
/*  5005 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5006 */         .addComponent(this.jPanel178, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/*  5007 */         .addComponent(this.jPanel185, -1, -1, 32767)
/*  5008 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel177Layout.createSequentialGroup()
/*  5009 */           .addContainerGap()
/*  5010 */           .addComponent(this.jPanel186, -2, 80, -2)
/*  5011 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  5012 */           .addComponent(this.jPanel184, -2, 367, -2)));
/*       */     
/*  5014 */     jPanel177Layout.setVerticalGroup(jPanel177Layout
/*  5015 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5016 */         .addGroup(jPanel177Layout.createSequentialGroup()
/*  5017 */           .addComponent(this.jPanel178, -2, -1, -2)
/*  5018 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  5019 */           .addComponent(this.jPanel185, -1, -1, 32767)
/*  5020 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  5021 */           .addGroup(jPanel177Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5022 */             .addComponent(this.jPanel184, -2, 41, -2)
/*  5023 */             .addComponent(this.jPanel186, -2, 37, -2))));
/*       */ 
/*       */     
/*  5026 */     GroupLayout jDialog11Layout = new GroupLayout(this.jDialog11.getContentPane());
/*  5027 */     this.jDialog11.getContentPane().setLayout(jDialog11Layout);
/*  5028 */     jDialog11Layout.setHorizontalGroup(jDialog11Layout
/*  5029 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5030 */         .addComponent(this.jPanel177, -1, -1, 32767));
/*       */     
/*  5032 */     jDialog11Layout.setVerticalGroup(jDialog11Layout
/*  5033 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5034 */         .addGroup(jDialog11Layout.createSequentialGroup()
/*  5035 */           .addComponent(this.jPanel177, -1, -1, 32767)
/*  5036 */           .addGap(0, 0, 0)));
/*       */ 
/*       */     
/*  5039 */     setDefaultCloseOperation(0);
/*  5040 */     setTitle("SICRET - Sistema Integral para el Control de Residuos, Empleados Transportistas");
/*  5041 */     addWindowListener(new WindowAdapter() {
/*       */           public void windowClosing(WindowEvent evt) {
/*  5043 */             Principal.this.formWindowClosing(evt);
/*       */           }
/*       */         });
/*       */     
/*  5047 */     this.jPanel8.setBackground(new Color(255, 255, 255));
/*       */     
/*  5049 */     this.jPanel6.setBackground(this.lc.SECUNDARIO2);
/*  5050 */     this.jPanel6.setBorder(BorderFactory.createEtchedBorder());
/*       */     
/*  5052 */     this.jLabel1.setFont(new Font("Tahoma", 0, 10));
/*  5053 */     this.jLabel1.setForeground(new Color(0, 51, 204));
/*  5054 */     this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/user.png")));
/*  5055 */     this.jLabel1.setToolTipText("<html><b><font color= \"4F4F4F\">Usuario Activado</font></b><hr width=\"40%\" align=\"left\"><p><font color= \"4F4F4F\">Muestra el nombre del usuario <br>que actualmente está activado.</font></html>");
/*       */     
/*  5057 */     this.jLabel2.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 11.0F));
/*  5058 */     this.jLabel2.setForeground(this.lc.PRIMARIO1);
/*  5059 */     this.jLabel2.setText("nombre134");
/*  5060 */     this.jLabel2.setToolTipText("<html><b><font color= \"4F4F4F\">Usuario Activado</font></b><hr width=\"40%\" align=\"left\"><p><font color= \"4F4F4F\">Muestra el nombre del usuario <br>que actualmente está activado.</font></html>");
/*  5061 */     this.jLabel2.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5063 */             Principal.this.jLabel2MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5066 */             Principal.this.jLabel2MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5069 */             Principal.this.jLabel2MouseEntered(evt);
/*       */           }
/*       */         });
/*       */     
/*  5073 */     this.jLabel9.setFont(new Font("Tahoma", 0, 14));
/*  5074 */     this.jLabel9.setForeground(new Color(153, 153, 153));
/*  5075 */     this.jLabel9.setText("|");
/*       */     
/*  5077 */     this.jLabel11.setFont(new Font("Tahoma", 0, 10));
/*  5078 */     this.jLabel11.setForeground(new Color(0, 51, 255));
/*  5079 */     this.jLabel11.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/exit.png")));
/*  5080 */     this.jLabel11.setText(" ");
/*  5081 */     this.jLabel11.setToolTipText("<html><b><font color= \"4F4F4F\">Ocultar Panel</font></b><hr width=\"30%\" align=\"left\"><p><font color= \"4F4F4F\">Oculta todos los paneles que tengas abiertos <br>y se posiciona desde el inicio.</font></html>");
/*  5082 */     this.jLabel11.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5084 */             Principal.this.jLabel11MouseClicked(evt);
/*       */           }
/*       */         });
/*       */     
/*  5088 */     this.jLabel28.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*  5089 */     this.jLabel28.setForeground(this.lc.PRIMARIO1);
/*  5090 */     this.jLabel28.setHorizontalAlignment(4);
/*  5091 */     this.jLabel28.setText("Minimizar ventana");
/*  5092 */     this.jLabel28.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5094 */             Principal.this.jLabel28MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5097 */             Principal.this.jLabel28MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5100 */             Principal.this.jLabel28MouseEntered(evt);
/*       */           }
/*       */         });
/*       */     
/*  5104 */     this.jSeparator21.setOrientation(1);
/*       */     
/*  5106 */     this.jLabel36.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/*  5107 */     this.jLabel36.setForeground(this.lc.PRIMARIO1);
/*  5108 */     this.jLabel36.setText("Cargando datos...");
/*       */     
/*  5110 */     this.jSeparator22.setOrientation(1);
/*       */     
/*  5112 */     this.jLabel56.setHorizontalAlignment(4);
/*  5113 */     this.jLabel56.setText("<html>Versión: <b>1.260507</b></html>");
/*       */     
/*  5115 */     this.jLabel57.setHorizontalAlignment(4);
/*  5116 */     this.jLabel57.setText("Sucursal:");
/*       */     
/*  5118 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  5119 */     this.jPanel6.setLayout(jPanel6Layout);
/*  5120 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/*  5121 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5122 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  5123 */           .addComponent(this.jLabel1)
/*  5124 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  5125 */           .addComponent(this.jLabel2, -2, 170, -2)
/*  5126 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  5127 */           .addComponent(this.jSeparator21, -2, 12, -2)
/*  5128 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  5129 */           .addComponent(this.jLabel36, -2, 337, -2)
/*  5130 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  5131 */           .addComponent(this.jLabel57, -2, 150, -2)
/*  5132 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  5133 */           .addComponent(this.jLabel56, -2, 246, -2)
/*  5134 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  5135 */           .addComponent(this.jLabel9, -2, 14, -2)
/*  5136 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  5137 */           .addComponent(this.jLabel28, -2, 108, -2)
/*  5138 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  5139 */           .addComponent(this.jSeparator22, -2, -1, -2)
/*  5140 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  5141 */           .addComponent(this.jLabel11)));
/*       */     
/*  5143 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/*  5144 */         .createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  5145 */         .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  5146 */           .addComponent(this.jLabel1)
/*  5147 */           .addComponent(this.jLabel2)
/*  5148 */           .addComponent(this.jLabel9)
/*  5149 */           .addComponent(this.jLabel11)
/*  5150 */           .addComponent(this.jLabel28)
/*  5151 */           .addComponent(this.jLabel36, -1, -1, 32767)
/*  5152 */           .addComponent(this.jLabel56, -2, -1, -2)
/*  5153 */           .addComponent(this.jLabel57))
/*  5154 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  5155 */           .addGap(0, 0, 32767)
/*  5156 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  5157 */             .addComponent(this.jSeparator21, -2, 20, -2)
/*  5158 */             .addComponent(this.jSeparator22, -2, 20, -2))));
/*       */ 
/*       */     
/*  5161 */     this.jTabbedPane2.setBackground(new Color(102, 102, 255));
/*  5162 */     this.jTabbedPane2.setTabPlacement(3);
/*       */     
/*  5164 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/*       */     
/*  5166 */     this.jPanel111.setBackground(new Color(255, 255, 255));
/*       */     
/*  5168 */     this.jLabel4.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 22.0F));
/*       */     
/*  5170 */     this.jLabel4.setForeground(this.lc.SECUNDARIO1);
/*  5171 */     this.jLabel4.setHorizontalAlignment(4);
/*  5172 */     this.jLabel4.setText("Sistema Integral para el Control de Residuos y Empleados Transportistas   ");
/*       */     
/*  5174 */     GroupLayout jPanel111Layout = new GroupLayout(this.jPanel111);
/*  5175 */     this.jPanel111.setLayout(jPanel111Layout);
/*  5176 */     jPanel111Layout.setHorizontalGroup(jPanel111Layout
/*  5177 */         .createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  5178 */         .addGroup(jPanel111Layout.createSequentialGroup()
/*  5179 */           .addContainerGap(1017, 32767)
/*  5180 */           .addComponent(this.jLabel4, -2, 878, -2)
/*  5181 */           .addGap(20, 20, 20)));
/*       */     
/*  5183 */     jPanel111Layout.setVerticalGroup(jPanel111Layout
/*  5184 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5185 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel111Layout.createSequentialGroup()
/*  5186 */           .addGap(0, 28, 32767)
/*  5187 */           .addComponent(this.jLabel4)));
/*       */ 
/*       */     
/*  5190 */     this.jPanel107.setBackground(new Color(255, 255, 255));
/*  5191 */     this.jPanel107.setLayout((LayoutManager)null);
/*       */     
/*  5193 */     this.jLabel3.setHorizontalAlignment(0);
/*  5194 */     this.jLabel3.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis100x.png")));
/*  5195 */     this.jPanel107.add(this.jLabel3);
/*  5196 */     this.jLabel3.setBounds(20, 10, 120, 120);
/*       */     
/*  5198 */     this.jPanel108.setBackground(this.lc.SECUNDARIO2);
/*       */     
/*  5200 */     this.jLabel110.setFont(this.fuentes.setFuente(this.fuentes.FCentury, 0, 22.0F));
/*  5201 */     this.jLabel110.setForeground(this.lc.PRIMARIO1);
/*  5202 */     this.jLabel110.setText("Fletes y Materiales Forsis, S.A. de C.V.");
/*  5203 */     this.jLabel110.setVerticalAlignment(1);
/*       */     
/*  5205 */     this.jLabel111.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/*  5206 */     this.jLabel111.setForeground(this.lc.PRIMARIO1);
/*  5207 */     this.jLabel111.setHorizontalAlignment(4);
/*  5208 */     this.jLabel111.setText("<html><u>www.forsis.com.mx<u></html>");
/*  5209 */     this.jLabel111.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5211 */             Principal.this.jLabel111MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5214 */             Principal.this.jLabel111MouseEntered(evt);
/*       */           }
/*       */         });
/*       */     
/*  5218 */     GroupLayout jPanel108Layout = new GroupLayout(this.jPanel108);
/*  5219 */     this.jPanel108.setLayout(jPanel108Layout);
/*  5220 */     jPanel108Layout.setHorizontalGroup(jPanel108Layout
/*  5221 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5222 */         .addGroup(jPanel108Layout.createSequentialGroup()
/*  5223 */           .addGap(139, 139, 139)
/*  5224 */           .addComponent(this.jLabel110, -2, 490, -2)
/*  5225 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 2478, 32767)
/*  5226 */           .addComponent(this.jLabel111, -2, 175, -2)
/*  5227 */           .addGap(28, 28, 28)));
/*       */     
/*  5229 */     jPanel108Layout.setVerticalGroup(jPanel108Layout
/*  5230 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5231 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel108Layout.createSequentialGroup()
/*  5232 */           .addContainerGap(49, 32767)
/*  5233 */           .addGroup(jPanel108Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  5234 */             .addComponent(this.jLabel110)
/*  5235 */             .addComponent(this.jLabel111, -2, -1, -2))
/*  5236 */           .addContainerGap()));
/*       */ 
/*       */     
/*  5239 */     this.jPanel107.add(this.jPanel108);
/*  5240 */     this.jPanel108.setBounds(20, 0, 3310, 70);
/*       */     
/*  5242 */     this.jPanel109.setBackground(this.lc.PRIMARIO1);
/*       */     
/*  5244 */     GroupLayout jPanel109Layout = new GroupLayout(this.jPanel109);
/*  5245 */     this.jPanel109.setLayout(jPanel109Layout);
/*  5246 */     jPanel109Layout.setHorizontalGroup(jPanel109Layout
/*  5247 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5248 */         .addGap(0, 10, 32767));
/*       */     
/*  5250 */     jPanel109Layout.setVerticalGroup(jPanel109Layout
/*  5251 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5252 */         .addGap(0, 70, 32767));
/*       */ 
/*       */     
/*  5255 */     this.jPanel107.add(this.jPanel109);
/*  5256 */     this.jPanel109.setBounds(10, 0, 10, 70);
/*       */     
/*  5258 */     this.jLabel112.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/*  5259 */     this.jLabel112.setForeground(this.lc.SECUNDARIO1);
/*  5260 */     this.jLabel112.setText("FMF901004UZ9");
/*  5261 */     this.jPanel107.add(this.jLabel112);
/*  5262 */     this.jLabel112.setBounds(160, 80, 430, 19);
/*       */     
/*  5264 */     this.jLabel113.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/*  5265 */     this.jLabel113.setForeground(this.lc.PRIMARIO2);
/*  5266 */     this.jLabel113.setText("Autopista Monterrey Cadereyta, km. 32.5");
/*  5267 */     this.jPanel107.add(this.jLabel113);
/*  5268 */     this.jLabel113.setBounds(160, 100, 430, 19);
/*       */     
/*  5270 */     this.jLabel118.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/*  5271 */     this.jLabel118.setForeground(this.lc.PRIMARIO1);
/*  5272 */     this.jLabel118.setText("Sucursal:");
/*  5273 */     this.jPanel107.add(this.jLabel118);
/*  5274 */     this.jLabel118.setBounds(160, 150, 68, 15);
/*       */     
/*  5276 */     this.jPanel152.setBackground(this.lc.PRIMARIO1);
/*       */     
/*  5278 */     this.jLabel142.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/*  5279 */     this.jLabel142.setForeground(new Color(255, 255, 255));
/*  5280 */     this.jLabel142.setHorizontalAlignment(0);
/*  5281 */     this.jLabel142.setText("directiva[6]");
/*       */     
/*  5283 */     GroupLayout jPanel152Layout = new GroupLayout(this.jPanel152);
/*  5284 */     this.jPanel152.setLayout(jPanel152Layout);
/*  5285 */     jPanel152Layout.setHorizontalGroup(jPanel152Layout
/*  5286 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5287 */         .addComponent(this.jLabel142, -1, 100, 32767));
/*       */     
/*  5289 */     jPanel152Layout.setVerticalGroup(jPanel152Layout
/*  5290 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5291 */         .addComponent(this.jLabel142, -1, 20, 32767));
/*       */ 
/*       */     
/*  5294 */     this.jPanel107.add(this.jPanel152);
/*  5295 */     this.jPanel152.setBounds(240, 150, 100, 20);
/*       */     
/*  5297 */     this.jLabel143.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 13.0F));
/*  5298 */     this.jLabel143.setForeground(this.lc.PRIMARIO2);
/*  5299 */     this.jLabel143.setText("Cadereyta Jiménez, Nuevo Leon, CP 57483");
/*  5300 */     this.jPanel107.add(this.jLabel143);
/*  5301 */     this.jLabel143.setBounds(160, 120, 430, 19);
/*       */     
/*  5303 */     this.jPanel112.setBackground(this.lc.PRIMARIO1);
/*       */     
/*  5305 */     GroupLayout jPanel112Layout = new GroupLayout(this.jPanel112);
/*  5306 */     this.jPanel112.setLayout(jPanel112Layout);
/*  5307 */     jPanel112Layout.setHorizontalGroup(jPanel112Layout
/*  5308 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5309 */         .addGap(0, 0, 32767));
/*       */     
/*  5311 */     jPanel112Layout.setVerticalGroup(jPanel112Layout
/*  5312 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5313 */         .addGap(0, 11, 32767));
/*       */ 
/*       */     
/*  5316 */     this.jLabel114.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 11.0F));
/*  5317 */     this.jLabel114.setForeground(this.lc.PRIMARIO2);
/*  5318 */     this.jLabel114.setHorizontalAlignment(0);
/*  5319 */     this.jLabel114.setText("ESPECIALISTAS EN TRANSPORTE DE RESIDUO PELIGROSO");
/*       */     
/*  5321 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  5322 */     this.jPanel2.setLayout(jPanel2Layout);
/*  5323 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  5324 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5325 */         .addComponent(this.jPanel111, -1, -1, 32767)
/*  5326 */         .addComponent(this.jPanel107, -1, -1, 32767)
/*  5327 */         .addGroup(jPanel2Layout.createSequentialGroup()
/*  5328 */           .addContainerGap()
/*  5329 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5330 */             .addComponent(this.jPanel112, -1, -1, 32767)
/*  5331 */             .addComponent(this.jLabel114, -1, -1, 32767))
/*  5332 */           .addContainerGap()));
/*       */     
/*  5334 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  5335 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5336 */         .addGroup(jPanel2Layout.createSequentialGroup()
/*  5337 */           .addComponent(this.jPanel111, -2, -1, -2)
/*  5338 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  5339 */           .addComponent(this.jPanel107, -1, 355, 32767)
/*  5340 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  5341 */           .addComponent(this.jPanel112, -2, -1, -2)
/*  5342 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  5343 */           .addComponent(this.jLabel114, -2, 23, -2)
/*  5344 */           .addGap(9, 9, 9)));
/*       */ 
/*       */     
/*  5347 */     this.jScrollPane1.setViewportView(this.jPanel2);
/*       */     
/*  5349 */     this.jTabbedPane2.addTab("", this.jScrollPane1);
/*       */     
/*  5351 */     this.jPanel113.setBackground(this.lc.PRIMARIO2);
/*  5352 */     this.jPanel113.setLayout((LayoutManager)null);
/*       */     
/*  5354 */     this.jPanel114.setBackground(this.lc.SECUNDARIO2);
/*  5355 */     this.jPanel114.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO1));
/*  5356 */     this.jPanel114.setLayout((LayoutManager)null);
/*       */     
/*  5358 */     this.jLabel115.setFont(new Font("Cantarell", 1, 11));
/*  5359 */     this.jLabel115.setForeground(new Color(255, 255, 255));
/*  5360 */     this.jLabel115.setHorizontalAlignment(0);
/*  5361 */     this.jLabel115.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/home.png")));
/*  5362 */     this.jLabel115.setText("Inicio");
/*  5363 */     this.jLabel115.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5365 */             Principal.this.jLabel115MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5368 */             Principal.this.jLabel115MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5371 */             Principal.this.jLabel115MouseEntered(evt);
/*       */           }
/*       */         });
/*  5374 */     this.jPanel114.add(this.jLabel115);
/*  5375 */     this.jLabel115.setBounds(0, 0, 160, 20);
/*       */     
/*  5377 */     this.jPanel113.add(this.jPanel114);
/*  5378 */     this.jPanel114.setBounds(0, 0, 167, 25);
/*       */     
/*  5380 */     this.jPanel116.setBackground(this.lc.PRIMARIO1);
/*  5381 */     this.jPanel116.setLayout((LayoutManager)null);
/*       */     
/*  5383 */     this.jLabel116.setFont(new Font("Cantarell", 1, 11));
/*  5384 */     this.jLabel116.setForeground(new Color(255, 255, 255));
/*  5385 */     this.jLabel116.setHorizontalAlignment(0);
/*  5386 */     this.jLabel116.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/report.png")));
/*  5387 */     this.jLabel116.setText("Reportes Especiales");
/*  5388 */     this.jLabel116.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5390 */             Principal.this.jLabel116MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5393 */             Principal.this.jLabel116MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5396 */             Principal.this.jLabel116MouseEntered(evt);
/*       */           }
/*       */         });
/*  5399 */     this.jPanel116.add(this.jLabel116);
/*  5400 */     this.jLabel116.setBounds(0, 0, 170, 20);
/*       */     
/*  5402 */     this.jPanel113.add(this.jPanel116);
/*  5403 */     this.jPanel116.setBounds(173, 0, 167, 25);
/*       */     
/*  5405 */     this.jPanel118.setBackground(this.lc.PRIMARIO1);
/*  5406 */     this.jPanel118.setLayout((LayoutManager)null);
/*       */     
/*  5408 */     this.jLabel117.setFont(new Font("Cantarell", 1, 11));
/*  5409 */     this.jLabel117.setForeground(new Color(255, 255, 255));
/*  5410 */     this.jLabel117.setHorizontalAlignment(0);
/*  5411 */     this.jLabel117.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/businessman-with-dollar-coin.png")));
/*  5412 */     this.jLabel117.setText("Liquidaciones");
/*  5413 */     this.jLabel117.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5415 */             Principal.this.jLabel117MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5418 */             Principal.this.jLabel117MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5421 */             Principal.this.jLabel117MouseEntered(evt);
/*       */           }
/*       */         });
/*  5424 */     this.jPanel118.add(this.jLabel117);
/*  5425 */     this.jLabel117.setBounds(0, 0, 160, 20);
/*       */     
/*  5427 */     this.jPanel113.add(this.jPanel118);
/*  5428 */     this.jPanel118.setBounds(346, 0, 167, 25);
/*       */     
/*  5430 */     this.jPanel115.setBackground(this.lc.SECUNDARIO1);
/*  5431 */     this.jPanel115.setLayout((LayoutManager)null);
/*  5432 */     this.jPanel113.add(this.jPanel115);
/*  5433 */     this.jPanel115.setBounds(0, 30, 1400, 5);
/*       */     
/*  5435 */     this.jPanel68.setBackground(this.lc.PRIMARIO1);
/*       */     
/*  5437 */     this.jPanel3.setBackground(this.lc.PRIMARIO1);
/*  5438 */     this.jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Pedidos", 2, 6, new Font("Cantarell", 0, 11), new Color(255, 255, 255)));
/*  5439 */     this.jPanel3.setLayout(new GridLayout(1, 3, 3, 0));
/*       */     
/*  5441 */     this.jPanel63.setBackground(this.lc.PRIMARIO1);
/*  5442 */     this.jPanel63.setLayout(new GridLayout(1, 0));
/*       */     
/*  5444 */     this.jPanel55.setBackground(this.lc.PRIMARIO1);
/*  5445 */     this.jPanel55.setLayout(new GridLayout(1, 0));
/*       */     
/*  5447 */     this.jLabel49.setHorizontalAlignment(0);
/*  5448 */     this.jLabel49.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/guia.png")));
/*  5449 */     this.jLabel49.setToolTipText("Gestionar las guías");
/*  5450 */     this.jLabel49.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5452 */             Principal.this.jLabel49MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5455 */             Principal.this.jLabel49MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5458 */             Principal.this.jLabel49MouseExited(evt);
/*       */           }
/*       */         });
/*  5461 */     this.jPanel55.add(this.jLabel49);
/*       */     
/*  5463 */     this.jPanel63.add(this.jPanel55);
/*       */     
/*  5465 */     this.jPanel3.add(this.jPanel63);
/*       */     
/*  5467 */     this.jPanel64.setBackground(new Color(246, 60, 60));
/*  5468 */     this.jPanel64.setLayout(new GridLayout(2, 0, 6, 0));
/*       */     
/*  5470 */     this.jPanel58.setBackground(this.lc.PRIMARIO1);
/*  5471 */     this.jPanel58.setLayout(new GridLayout(1, 0));
/*       */     
/*  5473 */     this.jLabel54.setHorizontalAlignment(0);
/*  5474 */     this.jLabel54.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/barra.png")));
/*  5475 */     this.jLabel54.setToolTipText("Gestionar vales de diesel");
/*  5476 */     this.jLabel54.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5478 */             Principal.this.jLabel54MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5481 */             Principal.this.jLabel54MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5484 */             Principal.this.jLabel54MouseExited(evt);
/*       */           }
/*       */         });
/*  5487 */     this.jPanel58.add(this.jLabel54);
/*       */     
/*  5489 */     this.jPanel64.add(this.jPanel58);
/*       */     
/*  5491 */     this.jPanel53.setBackground(this.lc.PRIMARIO1);
/*  5492 */     this.jPanel53.setLayout(new GridLayout(1, 0));
/*       */     
/*  5494 */     this.jLabel48.setHorizontalAlignment(0);
/*  5495 */     this.jLabel48.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Manifiesto1.png")));
/*  5496 */     this.jLabel48.setToolTipText("Buscar manifiestos");
/*  5497 */     this.jLabel48.addMouseListener(new MouseAdapter() {
/*       */           public void mousePressed(MouseEvent evt) {
/*  5499 */             Principal.this.jLabel48MousePressed(evt);
/*       */           }
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5502 */             Principal.this.jLabel48MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5505 */             Principal.this.jLabel48MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5508 */             Principal.this.jLabel48MouseEntered(evt);
/*       */           }
/*       */         });
/*  5511 */     this.jPanel53.add(this.jLabel48);
/*       */     
/*  5513 */     this.jPanel64.add(this.jPanel53);
/*       */     
/*  5515 */     this.jPanel3.add(this.jPanel64);
/*       */     
/*  5517 */     this.jPanel65.setBackground(new Color(246, 60, 60));
/*  5518 */     this.jPanel65.setLayout(new GridLayout(1, 0, 6, 10));
/*       */     
/*  5520 */     this.jPanel59.setBackground(this.lc.PRIMARIO1);
/*  5521 */     this.jPanel59.setLayout(new GridLayout(1, 0));
/*       */     
/*  5523 */     this.jLabel55.setBackground(new Color(246, 60, 60));
/*  5524 */     this.jLabel55.setHorizontalAlignment(0);
/*  5525 */     this.jLabel55.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/table_48.png")));
/*  5526 */     this.jLabel55.setToolTipText("Formación de operadores");
/*  5527 */     this.jLabel55.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5529 */             Principal.this.jLabel55MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5532 */             Principal.this.jLabel55MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5535 */             Principal.this.jLabel55MouseExited(evt);
/*       */           }
/*       */         });
/*  5538 */     this.jPanel59.add(this.jLabel55);
/*       */     
/*  5540 */     this.jPanel65.add(this.jPanel59);
/*       */     
/*  5542 */     this.jPanel3.add(this.jPanel65);
/*       */     
/*  5544 */     this.jPanel72.setBackground(this.lc.PRIMARIO1);
/*  5545 */     this.jPanel72.setBorder(BorderFactory.createTitledBorder(null, "Perforación", 2, 6, new Font("Cantarell", 0, 11), new Color(255, 255, 255)));
/*  5546 */     this.jPanel72.setLayout(new GridLayout(2, 1, 0, 4));
/*       */     
/*  5548 */     this.jPanel73.setBackground(this.lc.PRIMARIO1);
/*  5549 */     this.jPanel73.setLayout(new GridLayout(1, 0, 4, 4));
/*       */     
/*  5551 */     this.jPanel97.setBackground(this.lc.PRIMARIO1);
/*  5552 */     this.jPanel97.setLayout(new GridLayout(1, 0));
/*       */     
/*  5554 */     this.jLabel90.setHorizontalAlignment(0);
/*  5555 */     this.jLabel90.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/equipo.png")));
/*  5556 */     this.jLabel90.setToolTipText("Equipos");
/*  5557 */     this.jLabel90.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5559 */             Principal.this.jLabel90MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5562 */             Principal.this.jLabel90MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5565 */             Principal.this.jLabel90MouseEntered(evt);
/*       */           }
/*       */         });
/*  5568 */     this.jPanel97.add(this.jLabel90);
/*       */     
/*  5570 */     this.jPanel73.add(this.jPanel97);
/*       */     
/*  5572 */     this.jPanel98.setBackground(this.lc.PRIMARIO1);
/*  5573 */     this.jPanel98.setLayout(new GridLayout(1, 0));
/*       */     
/*  5575 */     this.jLabel91.setHorizontalAlignment(0);
/*  5576 */     this.jLabel91.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/plataforma.png")));
/*  5577 */     this.jLabel91.setToolTipText("Plataformas");
/*  5578 */     this.jLabel91.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5580 */             Principal.this.jLabel91MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5583 */             Principal.this.jLabel91MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5586 */             Principal.this.jLabel91MouseEntered(evt);
/*       */           }
/*       */         });
/*  5589 */     this.jPanel98.add(this.jLabel91);
/*       */     
/*  5591 */     this.jPanel73.add(this.jPanel98);
/*       */     
/*  5593 */     this.jPanel72.add(this.jPanel73);
/*       */     
/*  5595 */     this.jPanel99.setBackground(this.lc.PRIMARIO1);
/*  5596 */     this.jPanel99.setLayout(new GridLayout(1, 0));
/*       */     
/*  5598 */     this.jLabel92.setHorizontalAlignment(0);
/*  5599 */     this.jLabel92.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/pozos.png")));
/*  5600 */     this.jLabel92.setToolTipText("Pozos");
/*  5601 */     this.jLabel92.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5603 */             Principal.this.jLabel92MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5606 */             Principal.this.jLabel92MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5609 */             Principal.this.jLabel92MouseEntered(evt);
/*       */           }
/*       */         });
/*  5612 */     this.jPanel99.add(this.jLabel92);
/*       */     
/*  5614 */     this.jPanel72.add(this.jPanel99);
/*       */     
/*  5616 */     this.jPanel70.setBackground(this.lc.PRIMARIO1);
/*  5617 */     this.jPanel70.setBorder(BorderFactory.createTitledBorder(null, "Unidades", 2, 6, new Font("Cantarell", 0, 11), new Color(255, 255, 255)));
/*  5618 */     this.jPanel70.setLayout(new GridLayout(2, 3, 5, 5));
/*       */     
/*  5620 */     this.jPanel187.setBackground(this.lc.PRIMARIO1);
/*  5621 */     this.jPanel187.setLayout(new GridLayout(1, 0));
/*       */     
/*  5623 */     this.jLabel153.setHorizontalAlignment(0);
/*  5624 */     this.jLabel153.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/trailer(3).png")));
/*  5625 */     this.jLabel153.setToolTipText("Administrar Tractores");
/*  5626 */     this.jLabel153.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5628 */             Principal.this.jLabel153MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5631 */             Principal.this.jLabel153MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5634 */             Principal.this.jLabel153MouseExited(evt);
/*       */           }
/*       */         });
/*  5637 */     this.jPanel187.add(this.jLabel153);
/*       */     
/*  5639 */     this.jPanel70.add(this.jPanel187);
/*       */     
/*  5641 */     this.jPanel176.setBackground(this.lc.PRIMARIO1);
/*  5642 */     this.jPanel176.setLayout(new GridLayout(1, 0));
/*       */     
/*  5644 */     this.jLabel101.setHorizontalAlignment(0);
/*  5645 */     this.jLabel101.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/trailer(2).png")));
/*  5646 */     this.jLabel101.setToolTipText("Administrar Remolques");
/*  5647 */     this.jLabel101.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5649 */             Principal.this.jLabel101MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5652 */             Principal.this.jLabel101MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5655 */             Principal.this.jLabel101MouseExited(evt);
/*       */           }
/*       */         });
/*  5658 */     this.jPanel176.add(this.jLabel101);
/*       */     
/*  5660 */     this.jPanel70.add(this.jPanel176);
/*       */     
/*  5662 */     this.jPanel188.setBackground(this.lc.PRIMARIO1);
/*  5663 */     this.jPanel188.setLayout(new GridLayout(1, 0));
/*       */     
/*  5665 */     this.jLabel154.setHorizontalAlignment(0);
/*  5666 */     this.jLabel154.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/dolly.png")));
/*  5667 */     this.jLabel154.setToolTipText("Administrar Dollys");
/*  5668 */     this.jLabel154.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5670 */             Principal.this.jLabel154MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5673 */             Principal.this.jLabel154MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5676 */             Principal.this.jLabel154MouseExited(evt);
/*       */           }
/*       */         });
/*  5679 */     this.jPanel188.add(this.jLabel154);
/*       */     
/*  5681 */     this.jPanel70.add(this.jPanel188);
/*       */     
/*  5683 */     this.jPanel189.setBackground(this.lc.PRIMARIO1);
/*  5684 */     this.jPanel189.setLayout(new GridLayout(1, 0));
/*       */     
/*  5686 */     this.jLabel155.setHorizontalAlignment(0);
/*  5687 */     this.jLabel155.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/delivery-truck.png")));
/*  5688 */     this.jLabel155.setToolTipText("Administrar Utilitarios");
/*  5689 */     this.jLabel155.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5691 */             Principal.this.jLabel155MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5694 */             Principal.this.jLabel155MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5697 */             Principal.this.jLabel155MouseExited(evt);
/*       */           }
/*       */         });
/*  5700 */     this.jPanel189.add(this.jLabel155);
/*       */     
/*  5702 */     this.jPanel70.add(this.jPanel189);
/*       */     
/*  5704 */     this.jPanel76.setBackground(this.lc.PRIMARIO1);
/*  5705 */     this.jPanel76.setBorder(BorderFactory.createTitledBorder(null, "Configuraciones", 2, 6, new Font("Cantarell", 0, 11), new Color(255, 255, 255)));
/*  5706 */     this.jPanel76.setLayout(new GridLayout(2, 0, 0, 6));
/*       */     
/*  5708 */     this.jPanel44.setBackground(this.lc.PRIMARIO1);
/*  5709 */     this.jPanel44.setLayout(new GridLayout(1, 2, 6, 0));
/*       */     
/*  5711 */     this.jPanel105.setBackground(this.lc.PRIMARIO1);
/*  5712 */     this.jPanel105.setLayout(new GridLayout(1, 0));
/*       */     
/*  5714 */     this.jLabel107.setHorizontalAlignment(0);
/*  5715 */     this.jLabel107.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/configurar.png")));
/*  5716 */     this.jLabel107.setToolTipText("Configuraciones");
/*  5717 */     this.jLabel107.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5719 */             Principal.this.jLabel107MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5722 */             Principal.this.jLabel107MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5725 */             Principal.this.jLabel107MouseExited(evt);
/*       */           }
/*       */         });
/*  5728 */     this.jPanel105.add(this.jLabel107);
/*       */     
/*  5730 */     this.jPanel44.add(this.jPanel105);
/*       */     
/*  5732 */     this.jPanel106.setBackground(this.lc.PRIMARIO1);
/*  5733 */     this.jPanel106.setLayout(new GridLayout(1, 0));
/*       */     
/*  5735 */     this.jLabel108.setHorizontalAlignment(0);
/*  5736 */     this.jLabel108.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/BuscarUsuario.png")));
/*  5737 */     this.jLabel108.setToolTipText("Bitácora");
/*  5738 */     this.jLabel108.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5740 */             Principal.this.jLabel108MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5743 */             Principal.this.jLabel108MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5746 */             Principal.this.jLabel108MouseEntered(evt);
/*       */           }
/*       */         });
/*  5749 */     this.jPanel106.add(this.jLabel108);
/*       */     
/*  5751 */     this.jPanel44.add(this.jPanel106);
/*       */     
/*  5753 */     this.jPanel76.add(this.jPanel44);
/*       */     
/*  5755 */     this.jPanel45.setBackground(this.lc.PRIMARIO1);
/*  5756 */     this.jPanel45.setLayout(new GridLayout(1, 0));
/*       */     
/*  5758 */     this.jLabel109.setHorizontalAlignment(0);
/*  5759 */     this.jLabel109.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/*  5760 */     this.jLabel109.setToolTipText("Acerca de");
/*  5761 */     this.jLabel109.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5763 */             Principal.this.jLabel109MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5766 */             Principal.this.jLabel109MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5769 */             Principal.this.jLabel109MouseEntered(evt);
/*       */           }
/*       */         });
/*  5772 */     this.jPanel45.add(this.jLabel109);
/*       */     
/*  5774 */     this.jPanel76.add(this.jPanel45);
/*       */     
/*  5776 */     this.jPanel75.setBackground(this.lc.PRIMARIO1);
/*  5777 */     this.jPanel75.setBorder(BorderFactory.createTitledBorder(null, "Usuarios", 2, 6, new Font("Cantarell", 0, 11), new Color(255, 255, 255)));
/*       */     
/*  5779 */     this.jPanel74.setBackground(this.lc.PRIMARIO1);
/*  5780 */     this.jPanel74.setLayout(new GridLayout(2, 2, 5, 5));
/*       */     
/*  5782 */     this.jPanel100.setBackground(this.lc.PRIMARIO1);
/*  5783 */     this.jPanel100.setLayout(new GridLayout(1, 0));
/*       */     
/*  5785 */     this.jLabel93.setHorizontalAlignment(0);
/*  5786 */     this.jLabel93.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/AgregarUsuario.png")));
/*  5787 */     this.jLabel93.setToolTipText("Agregar usuarios");
/*  5788 */     this.jLabel93.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5790 */             Principal.this.jLabel93MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5793 */             Principal.this.jLabel93MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5796 */             Principal.this.jLabel93MouseEntered(evt);
/*       */           }
/*       */         });
/*  5799 */     this.jPanel100.add(this.jLabel93);
/*       */     
/*  5801 */     this.jPanel74.add(this.jPanel100);
/*       */     
/*  5803 */     this.jPanel101.setBackground(this.lc.PRIMARIO1);
/*  5804 */     this.jPanel101.setLayout(new GridLayout(1, 0));
/*       */     
/*  5806 */     this.jLabel94.setHorizontalAlignment(0);
/*  5807 */     this.jLabel94.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/BuscarUsuario.png")));
/*  5808 */     this.jLabel94.setToolTipText("Buscar usuarios");
/*  5809 */     this.jLabel94.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5811 */             Principal.this.jLabel94MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5814 */             Principal.this.jLabel94MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5817 */             Principal.this.jLabel94MouseEntered(evt);
/*       */           }
/*       */         });
/*  5820 */     this.jPanel101.add(this.jLabel94);
/*       */     
/*  5822 */     this.jPanel74.add(this.jPanel101);
/*       */     
/*  5824 */     this.jPanel102.setBackground(this.lc.PRIMARIO1);
/*  5825 */     this.jPanel102.setLayout(new GridLayout(1, 0));
/*       */     
/*  5827 */     this.jLabel95.setHorizontalAlignment(0);
/*  5828 */     this.jLabel95.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/ModificarUsuarios.png")));
/*  5829 */     this.jLabel95.setToolTipText("Modificar usuarios");
/*  5830 */     this.jLabel95.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5832 */             Principal.this.jLabel95MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5835 */             Principal.this.jLabel95MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5838 */             Principal.this.jLabel95MouseEntered(evt);
/*       */           }
/*       */         });
/*  5841 */     this.jPanel102.add(this.jLabel95);
/*       */     
/*  5843 */     this.jPanel74.add(this.jPanel102);
/*       */     
/*  5845 */     this.jPanel103.setBackground(this.lc.PRIMARIO1);
/*  5846 */     this.jPanel103.setLayout(new GridLayout(1, 0));
/*       */     
/*  5848 */     this.jLabel96.setHorizontalAlignment(0);
/*  5849 */     this.jLabel96.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/EliminarUsu.png")));
/*  5850 */     this.jLabel96.setToolTipText("Eliminar usuarios");
/*  5851 */     this.jLabel96.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5853 */             Principal.this.jLabel96MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5856 */             Principal.this.jLabel96MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5859 */             Principal.this.jLabel96MouseEntered(evt);
/*       */           }
/*       */         });
/*  5862 */     this.jPanel103.add(this.jLabel96);
/*       */     
/*  5864 */     this.jPanel74.add(this.jPanel103);
/*       */     
/*  5866 */     this.jPanel104.setBackground(this.lc.PRIMARIO1);
/*       */     
/*  5868 */     this.jLabel106.setHorizontalAlignment(0);
/*  5869 */     this.jLabel106.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/otro.png")));
/*  5870 */     this.jLabel106.setToolTipText("Cerrar sesión");
/*  5871 */     this.jLabel106.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5873 */             Principal.this.jLabel106MouseClicked(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5876 */             Principal.this.jLabel106MouseExited(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5879 */             Principal.this.jLabel106MouseEntered(evt);
/*       */           }
/*       */         });
/*       */     
/*  5883 */     GroupLayout jPanel104Layout = new GroupLayout(this.jPanel104);
/*  5884 */     this.jPanel104.setLayout(jPanel104Layout);
/*  5885 */     jPanel104Layout.setHorizontalGroup(jPanel104Layout
/*  5886 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5887 */         .addComponent(this.jLabel106, -1, 33, 32767));
/*       */     
/*  5889 */     jPanel104Layout.setVerticalGroup(jPanel104Layout
/*  5890 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5891 */         .addComponent(this.jLabel106, -1, -1, 32767));
/*       */ 
/*       */     
/*  5894 */     GroupLayout jPanel75Layout = new GroupLayout(this.jPanel75);
/*  5895 */     this.jPanel75.setLayout(jPanel75Layout);
/*  5896 */     jPanel75Layout.setHorizontalGroup(jPanel75Layout
/*  5897 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5898 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel75Layout.createSequentialGroup()
/*  5899 */           .addContainerGap()
/*  5900 */           .addComponent(this.jPanel104, -1, -1, 32767)
/*  5901 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  5902 */           .addComponent(this.jPanel74, -1, 77, 32767)));
/*       */     
/*  5904 */     jPanel75Layout.setVerticalGroup(jPanel75Layout
/*  5905 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5906 */         .addComponent(this.jPanel74, -1, -1, 32767)
/*  5907 */         .addGroup(jPanel75Layout.createSequentialGroup()
/*  5908 */           .addContainerGap()
/*  5909 */           .addComponent(this.jPanel104, -1, -1, 32767)
/*  5910 */           .addContainerGap()));
/*       */ 
/*       */     
/*  5913 */     this.jPanel190.setBackground(this.lc.PRIMARIO1);
/*  5914 */     this.jPanel190.setBorder(BorderFactory.createTitledBorder(null, "Clientes, Origenes y Destinos", 2, 6, new Font("Cantarell", 0, 11), new Color(255, 255, 255)));
/*  5915 */     this.jPanel190.setLayout(new GridLayout(1, 0, 5, 0));
/*       */     
/*  5917 */     this.jPanel191.setBackground(this.lc.PRIMARIO1);
/*  5918 */     this.jPanel191.setLayout(new GridLayout(1, 0));
/*       */     
/*  5920 */     this.jLabel156.setHorizontalAlignment(0);
/*  5921 */     this.jLabel156.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/priority(1).png")));
/*  5922 */     this.jLabel156.setToolTipText("Administrar Clientes");
/*  5923 */     this.jLabel156.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5925 */             Principal.this.jLabel156MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5928 */             Principal.this.jLabel156MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5931 */             Principal.this.jLabel156MouseExited(evt);
/*       */           }
/*       */         });
/*  5934 */     this.jPanel191.add(this.jLabel156);
/*       */     
/*  5936 */     this.jPanel190.add(this.jPanel191);
/*       */     
/*  5938 */     this.jPanel192.setBackground(this.lc.PRIMARIO1);
/*  5939 */     this.jPanel192.setLayout(new GridLayout(1, 0));
/*       */     
/*  5941 */     this.jLabel157.setHorizontalAlignment(0);
/*  5942 */     this.jLabel157.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/house(1).png")));
/*  5943 */     this.jLabel157.setToolTipText("Origenes");
/*  5944 */     this.jLabel157.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5946 */             Principal.this.jLabel157MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5949 */             Principal.this.jLabel157MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5952 */             Principal.this.jLabel157MouseExited(evt);
/*       */           }
/*       */         });
/*  5955 */     this.jPanel192.add(this.jLabel157);
/*       */     
/*  5957 */     this.jPanel190.add(this.jPanel192);
/*       */     
/*  5959 */     this.jPanel193.setBackground(this.lc.PRIMARIO1);
/*  5960 */     this.jPanel193.setLayout(new GridLayout(1, 0));
/*       */     
/*  5962 */     this.jLabel158.setHorizontalAlignment(0);
/*  5963 */     this.jLabel158.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/destination(1).png")));
/*  5964 */     this.jLabel158.setToolTipText("Destinos");
/*  5965 */     this.jLabel158.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  5967 */             Principal.this.jLabel158MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  5970 */             Principal.this.jLabel158MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  5973 */             Principal.this.jLabel158MouseExited(evt);
/*       */           }
/*       */         });
/*  5976 */     this.jPanel193.add(this.jLabel158);
/*       */     
/*  5978 */     this.jPanel190.add(this.jPanel193);
/*       */     
/*  5980 */     this.jButton1.setText("Tipo Cambio");
/*  5981 */     this.jButton1.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  5983 */             Principal.this.jButton1ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  5987 */     GroupLayout jPanel68Layout = new GroupLayout(this.jPanel68);
/*  5988 */     this.jPanel68.setLayout(jPanel68Layout);
/*  5989 */     jPanel68Layout.setHorizontalGroup(jPanel68Layout
/*  5990 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  5991 */         .addGroup(jPanel68Layout.createSequentialGroup()
/*  5992 */           .addComponent(this.jPanel3, -2, 132, -2)
/*  5993 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  5994 */           .addComponent(this.jPanel190, -2, 162, -2)
/*  5995 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  5996 */           .addComponent(this.jPanel70, -2, 168, -2)
/*  5997 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  5998 */           .addComponent(this.jPanel72, -2, 115, -2)
/*  5999 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  6000 */           .addComponent(this.jPanel75, -2, -1, -2)
/*  6001 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  6002 */           .addComponent(this.jPanel76, -2, 116, -2)
/*  6003 */           .addGap(18, 18, 18)
/*  6004 */           .addComponent(this.jButton1)
/*  6005 */           .addContainerGap(416, 32767)));
/*       */     
/*  6007 */     jPanel68Layout.setVerticalGroup(jPanel68Layout
/*  6008 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  6009 */         .addComponent(this.jPanel75, -1, -1, 32767)
/*  6010 */         .addComponent(this.jPanel76, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/*  6011 */         .addComponent(this.jPanel70, -1, -1, 32767)
/*  6012 */         .addComponent(this.jPanel72, -1, 90, 32767)
/*  6013 */         .addComponent(this.jPanel3, -1, -1, 32767)
/*  6014 */         .addComponent(this.jPanel190, -1, -1, 32767)
/*  6015 */         .addGroup(jPanel68Layout.createSequentialGroup()
/*  6016 */           .addGap(24, 24, 24)
/*  6017 */           .addComponent(this.jButton1)
/*  6018 */           .addContainerGap(-1, 32767)));
/*       */ 
/*       */     
/*  6021 */     this.jPanel113.add(this.jPanel68);
/*  6022 */     this.jPanel68.setBounds(0, 35, 1400, 90);
/*       */     
/*  6024 */     this.jPanel121.setBackground(this.lc.SECUNDARIO1);
/*  6025 */     this.jPanel121.setLayout((LayoutManager)null);
/*  6026 */     this.jPanel113.add(this.jPanel121);
/*  6027 */     this.jPanel121.setBounds(0, 20, 167, 10);
/*       */     
/*  6029 */     this.jPanel120.setBackground(this.lc.PRIMARIO1);
/*  6030 */     this.jPanel120.setLayout((LayoutManager)null);
/*  6031 */     this.jPanel113.add(this.jPanel120);
/*  6032 */     this.jPanel120.setBounds(173, 20, 167, 10);
/*       */     
/*  6034 */     this.jPanel122.setBackground(this.lc.PRIMARIO1);
/*  6035 */     this.jPanel122.setLayout((LayoutManager)null);
/*  6036 */     this.jPanel113.add(this.jPanel122);
/*  6037 */     this.jPanel122.setBounds(346, 20, 167, 10);
/*       */     
/*  6039 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  6040 */     this.jPanel8.setLayout(jPanel8Layout);
/*  6041 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/*  6042 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  6043 */         .addComponent(this.jPanel6, -1, -1, 32767)
/*  6044 */         .addComponent(this.jTabbedPane2, -1, 1186, 32767)
/*  6045 */         .addComponent(this.jPanel113, -1, -1, 32767));
/*       */     
/*  6047 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/*  6048 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  6049 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  6050 */           .addComponent(this.jPanel113, -2, 128, -2)
/*  6051 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  6052 */           .addComponent(this.jTabbedPane2)
/*  6053 */           .addGap(11, 11, 11)
/*  6054 */           .addComponent(this.jPanel6, -2, 24, -2)));
/*       */ 
/*       */     
/*  6057 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/*  6058 */     this.jPanel17.setLayout(jPanel17Layout);
/*  6059 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/*  6060 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  6061 */         .addComponent(this.jPanel8, -1, -1, 32767));
/*       */     
/*  6063 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/*  6064 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  6065 */         .addComponent(this.jPanel8, -1, -1, 32767));
/*       */ 
/*       */     
/*  6068 */     this.jMenu1.setText("Archivo");
/*       */     
/*  6070 */     this.jMenu4.setText("Usuarios");
/*       */     
/*  6072 */     this.jMenuItem11.setText("Agregar usuario");
/*  6073 */     this.jMenuItem11.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6075 */             Principal.this.jMenuItem11ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6078 */     this.jMenu4.add(this.jMenuItem11);
/*       */     
/*  6080 */     this.jMenuItem12.setText("Eliminar usuario");
/*  6081 */     this.jMenuItem12.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6083 */             Principal.this.jMenuItem12ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6086 */     this.jMenu4.add(this.jMenuItem12);
/*       */     
/*  6088 */     this.jMenuItem13.setText("Buscar usuario");
/*  6089 */     this.jMenuItem13.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6091 */             Principal.this.jMenuItem13ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6094 */     this.jMenu4.add(this.jMenuItem13);
/*       */     
/*  6096 */     this.jMenu1.add(this.jMenu4);
/*       */     
/*  6098 */     this.jMenuItem6.setText("Modo barra de herramientas");
/*  6099 */     this.jMenuItem6.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6101 */             Principal.this.jMenuItem6ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6104 */     this.jMenu1.add(this.jMenuItem6);
/*  6105 */     this.jMenu1.add(this.jSeparator13);
/*       */     
/*  6107 */     this.jMenuItem14.setText("Cerrar sesión");
/*  6108 */     this.jMenuItem14.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6110 */             Principal.this.jMenuItem14ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6113 */     this.jMenu1.add(this.jMenuItem14);
/*       */     
/*  6115 */     this.jMenuItem1.setText("Salir");
/*  6116 */     this.jMenuItem1.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6118 */             Principal.this.jMenuItem1ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6121 */     this.jMenu1.add(this.jMenuItem1);
/*       */     
/*  6123 */     this.jMenuBar1.add(this.jMenu1);
/*       */     
/*  6125 */     this.jMenu19.setText("Cuentas por pagar");
/*       */     
/*  6127 */     this.jMenuItem70.setText("Cuentas bancarias");
/*  6128 */     this.jMenuItem70.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6130 */             Principal.this.jMenuItem70ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6133 */     this.jMenu19.add(this.jMenuItem70);
/*       */     
/*  6135 */     this.jMenuItem71.setText("Proveedores");
/*  6136 */     this.jMenuItem71.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6138 */             Principal.this.jMenuItem71ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6141 */     this.jMenu19.add(this.jMenuItem71);
/*       */     
/*  6143 */     this.jMenuItem72.setText("Facturas");
/*  6144 */     this.jMenuItem72.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6146 */             Principal.this.jMenuItem72ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6149 */     this.jMenu19.add(this.jMenuItem72);
/*       */     
/*  6151 */     this.jMenuItem74.setText("Pagos");
/*  6152 */     this.jMenuItem74.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6154 */             Principal.this.jMenuItem74ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6157 */     this.jMenu19.add(this.jMenuItem74);
/*       */     
/*  6159 */     this.jMenuItem76.setText("Tarjetas deudor");
/*  6160 */     this.jMenuItem76.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6162 */             Principal.this.jMenuItem76ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6165 */     this.jMenu19.add(this.jMenuItem76);
/*       */     
/*  6167 */     this.jMenuBar1.add(this.jMenu19);
/*       */     
/*  6169 */     this.jMenu10.setText("Facturación");
/*       */     
/*  6171 */     this.jMenuItem30.setText("Reporte interno");
/*  6172 */     this.jMenuItem30.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6174 */             Principal.this.jMenuItem30ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6177 */     this.jMenu10.add(this.jMenuItem30);
/*       */     
/*  6179 */     this.jMenuItem31.setText("Prefacturas");
/*  6180 */     this.jMenuItem31.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6182 */             Principal.this.jMenuItem31ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6185 */     this.jMenu10.add(this.jMenuItem31);
/*       */     
/*  6187 */     this.jMenuItem32.setText("Facturas");
/*  6188 */     this.jMenuItem32.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6190 */             Principal.this.jMenuItem32ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6193 */     this.jMenu10.add(this.jMenuItem32);
/*       */     
/*  6195 */     this.jMenuItem39.setText("Tarjetas deudor");
/*  6196 */     this.jMenuItem39.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6198 */             Principal.this.jMenuItem39ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6201 */     this.jMenu10.add(this.jMenuItem39);
/*  6202 */     this.jMenu10.add(this.jSeparator16);
/*       */     
/*  6204 */     this.jMenuItem33.setText("Recepción de documentos internos");
/*  6205 */     this.jMenuItem33.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6207 */             Principal.this.jMenuItem33ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6210 */     this.jMenu10.add(this.jMenuItem33);
/*       */     
/*  6212 */     this.jMenuItem34.setText("Tarifas");
/*  6213 */     this.jMenuItem34.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6215 */             Principal.this.jMenuItem34ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6218 */     this.jMenu10.add(this.jMenuItem34);
/*  6219 */     this.jMenu10.add(this.jSeparator18);
/*       */     
/*  6221 */     this.jMenu11.setText("Depósitos");
/*       */     
/*  6223 */     this.jMenuItem35.setText("Entregar depósitos");
/*  6224 */     this.jMenuItem35.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6226 */             Principal.this.jMenuItem35ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6229 */     this.jMenu11.add(this.jMenuItem35);
/*       */     
/*  6231 */     this.jMenuItem36.setText("Depósitos");
/*  6232 */     this.jMenuItem36.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6234 */             Principal.this.jMenuItem36ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6237 */     this.jMenu11.add(this.jMenuItem36);
/*       */     
/*  6239 */     this.jMenuItem69.setText("Complemento de pagos");
/*  6240 */     this.jMenuItem69.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6242 */             Principal.this.jMenuItem69ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6245 */     this.jMenu11.add(this.jMenuItem69);
/*       */     
/*  6247 */     this.jMenu10.add(this.jMenu11);
/*       */     
/*  6249 */     this.jMenuItem37.setText("Líneas");
/*  6250 */     this.jMenuItem37.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6252 */             Principal.this.jMenuItem37ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6255 */     this.jMenu10.add(this.jMenuItem37);
/*       */     
/*  6257 */     this.jMenuItem38.setText("Cartera vencida");
/*  6258 */     this.jMenuItem38.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6260 */             Principal.this.jMenuItem38ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6263 */     this.jMenu10.add(this.jMenuItem38);
/*       */     
/*  6265 */     this.jMenuItem66.setText("Cotizaciones");
/*  6266 */     this.jMenuItem66.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6268 */             Principal.this.jMenuItem66ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6271 */     this.jMenu10.add(this.jMenuItem66);
/*       */     
/*  6273 */     this.jMenuBar1.add(this.jMenu10);
/*       */     
/*  6275 */     this.jMenu2.setText("Operaciones");
/*       */     
/*  6277 */     this.jMenu3.setText("Tráfico");
/*       */     
/*  6279 */     this.jMenuItem2.setText("Agregar pedidos");
/*  6280 */     this.jMenuItem2.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6282 */             Principal.this.jMenuItem2ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6285 */     this.jMenu3.add(this.jMenuItem2);
/*       */     
/*  6287 */     this.jMenuItem3.setText("Guías");
/*  6288 */     this.jMenuItem3.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6290 */             Principal.this.jMenuItem3ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6293 */     this.jMenu3.add(this.jMenuItem3);
/*       */     
/*  6295 */     this.jMenuItem7.setText("Manifiestos");
/*  6296 */     this.jMenuItem7.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6298 */             Principal.this.jMenuItem7ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6301 */     this.jMenu3.add(this.jMenuItem7);
/*       */     
/*  6303 */     this.jMenuItem8.setText("Historial de llamadas");
/*  6304 */     this.jMenuItem8.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6306 */             Principal.this.jMenuItem8ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6309 */     this.jMenu3.add(this.jMenuItem8);
/*       */     
/*  6311 */     this.jMenuItem10.setText("Formación de operadores");
/*  6312 */     this.jMenuItem10.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6314 */             Principal.this.jMenuItem10ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6317 */     this.jMenu3.add(this.jMenuItem10);
/*       */     
/*  6319 */     this.jMenu2.add(this.jMenu3);
/*       */     
/*  6321 */     this.jMenu5.setText("Liquidaciones");
/*       */     
/*  6323 */     this.jMenuItem16.setText("Liquidaciones");
/*  6324 */     this.jMenuItem16.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6326 */             Principal.this.jMenuItem16ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6329 */     this.jMenu5.add(this.jMenuItem16);
/*       */     
/*  6331 */     this.jMenuItem17.setText("Caja chica");
/*  6332 */     this.jMenuItem17.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6334 */             Principal.this.jMenuItem17ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6337 */     this.jMenu5.add(this.jMenuItem17);
/*       */     
/*  6339 */     this.jMenuItem18.setText("Tarjetas deudor");
/*  6340 */     this.jMenuItem18.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6342 */             Principal.this.jMenuItem18ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6345 */     this.jMenu5.add(this.jMenuItem18);
/*  6346 */     this.jMenu5.add(this.jSeparator17);
/*       */     
/*  6348 */     this.jMenuItem15.setText("Hojas de recepción");
/*  6349 */     this.jMenuItem15.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6351 */             Principal.this.jMenuItem15ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6354 */     this.jMenu5.add(this.jMenuItem15);
/*       */     
/*  6356 */     this.jMenuItem19.setText("Vales de diesel");
/*  6357 */     this.jMenuItem19.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6359 */             Principal.this.jMenuItem19ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6362 */     this.jMenu5.add(this.jMenuItem19);
/*       */     
/*  6364 */     this.jMenuItem20.setText("Diesel completado");
/*  6365 */     this.jMenuItem20.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6367 */             Principal.this.jMenuItem20ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6370 */     this.jMenu5.add(this.jMenuItem20);
/*       */     
/*  6372 */     this.jMenuItem21.setText("Reseteos");
/*  6373 */     this.jMenuItem21.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6375 */             Principal.this.jMenuItem21ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6378 */     this.jMenu5.add(this.jMenuItem21);
/*       */     
/*  6380 */     this.jMenu2.add(this.jMenu5);
/*       */     
/*  6382 */     this.jMenu6.setText("Qhse");
/*       */     
/*  6384 */     this.jMenu7.setText("Tractores");
/*       */     
/*  6386 */     this.jMenuItem9.setText("Agregar unidad");
/*  6387 */     this.jMenuItem9.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6389 */             Principal.this.jMenuItem9ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6392 */     this.jMenu7.add(this.jMenuItem9);
/*       */     
/*  6394 */     this.jMenuItem22.setText("Modificar unidad");
/*  6395 */     this.jMenuItem22.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6397 */             Principal.this.jMenuItem22ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6400 */     this.jMenu7.add(this.jMenuItem22);
/*       */     
/*  6402 */     this.jMenuItem23.setText("Eliminar unidad");
/*  6403 */     this.jMenuItem23.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6405 */             Principal.this.jMenuItem23ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6408 */     this.jMenu7.add(this.jMenuItem23);
/*       */     
/*  6410 */     this.jMenuItem24.setText("Buscar unidad");
/*  6411 */     this.jMenuItem24.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6413 */             Principal.this.jMenuItem24ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6416 */     this.jMenu7.add(this.jMenuItem24);
/*       */     
/*  6418 */     this.jMenu6.add(this.jMenu7);
/*       */     
/*  6420 */     this.jMenu8.setText("Remolques");
/*       */     
/*  6422 */     this.jMenuItem25.setText("Agregar remolque");
/*  6423 */     this.jMenuItem25.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6425 */             Principal.this.jMenuItem25ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6428 */     this.jMenu8.add(this.jMenuItem25);
/*       */     
/*  6430 */     this.jMenuItem26.setText("Modificar remolque");
/*  6431 */     this.jMenuItem26.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6433 */             Principal.this.jMenuItem26ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6436 */     this.jMenu8.add(this.jMenuItem26);
/*       */     
/*  6438 */     this.jMenuItem27.setText("Eliminar remolque");
/*  6439 */     this.jMenuItem27.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6441 */             Principal.this.jMenuItem27ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6444 */     this.jMenu8.add(this.jMenuItem27);
/*       */     
/*  6446 */     this.jMenuItem28.setText("Buscar remolque");
/*  6447 */     this.jMenuItem28.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6449 */             Principal.this.jMenuItem28ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6452 */     this.jMenu8.add(this.jMenuItem28);
/*       */     
/*  6454 */     this.jMenu6.add(this.jMenu8);
/*       */     
/*  6456 */     this.jMenu12.setText("Origenes o clientes");
/*       */     
/*  6458 */     this.jMenuItem40.setText("Agregar cliente");
/*  6459 */     this.jMenuItem40.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6461 */             Principal.this.jMenuItem40ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6464 */     this.jMenu12.add(this.jMenuItem40);
/*       */     
/*  6466 */     this.jMenuItem41.setText("Modificar cliente");
/*  6467 */     this.jMenuItem41.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6469 */             Principal.this.jMenuItem41ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6472 */     this.jMenu12.add(this.jMenuItem41);
/*       */     
/*  6474 */     this.jMenuItem42.setText("Eliminar cliente");
/*  6475 */     this.jMenuItem42.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6477 */             Principal.this.jMenuItem42ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6480 */     this.jMenu12.add(this.jMenuItem42);
/*       */     
/*  6482 */     this.jMenuItem43.setText("Buscar cliente");
/*  6483 */     this.jMenuItem43.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6485 */             Principal.this.jMenuItem43ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6488 */     this.jMenu12.add(this.jMenuItem43);
/*       */     
/*  6490 */     this.jMenu6.add(this.jMenu12);
/*       */     
/*  6492 */     this.jMenu13.setText("Destinos o confinamientos");
/*       */     
/*  6494 */     this.jMenuItem44.setText("Agregar destino");
/*  6495 */     this.jMenuItem44.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6497 */             Principal.this.jMenuItem44ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6500 */     this.jMenu13.add(this.jMenuItem44);
/*       */     
/*  6502 */     this.jMenuItem45.setText("Modificar destino");
/*  6503 */     this.jMenuItem45.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6505 */             Principal.this.jMenuItem45ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6508 */     this.jMenu13.add(this.jMenuItem45);
/*       */     
/*  6510 */     this.jMenuItem46.setText("Eliminar destino");
/*  6511 */     this.jMenuItem46.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6513 */             Principal.this.jMenuItem46ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6516 */     this.jMenu13.add(this.jMenuItem46);
/*       */     
/*  6518 */     this.jMenuItem47.setText("Buscar destino");
/*  6519 */     this.jMenuItem47.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6521 */             Principal.this.jMenuItem47ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6524 */     this.jMenu13.add(this.jMenuItem47);
/*       */     
/*  6526 */     this.jMenu6.add(this.jMenu13);
/*       */     
/*  6528 */     this.jMenu17.setText("Perforación");
/*       */     
/*  6530 */     this.jMenuItem63.setText("Pozos");
/*  6531 */     this.jMenuItem63.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6533 */             Principal.this.jMenuItem63ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6536 */     this.jMenu17.add(this.jMenuItem63);
/*       */     
/*  6538 */     this.jMenuItem64.setText("Plataformas");
/*  6539 */     this.jMenuItem64.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6541 */             Principal.this.jMenuItem64ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6544 */     this.jMenu17.add(this.jMenuItem64);
/*       */     
/*  6546 */     this.jMenuItem65.setText("Equipos");
/*  6547 */     this.jMenuItem65.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6549 */             Principal.this.jMenuItem65ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6552 */     this.jMenu17.add(this.jMenuItem65);
/*       */     
/*  6554 */     this.jMenu6.add(this.jMenu17);
/*       */     
/*  6556 */     this.jMenuItem29.setText("Reporte de manifiestos");
/*  6557 */     this.jMenuItem29.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6559 */             Principal.this.jMenuItem29ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6562 */     this.jMenu6.add(this.jMenuItem29);
/*       */     
/*  6564 */     this.jMenu2.add(this.jMenu6);
/*       */     
/*  6566 */     this.jMenuItem56.setText("Indicadores de desempeño");
/*  6567 */     this.jMenuItem56.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6569 */             Principal.this.jMenuItem56ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6572 */     this.jMenu2.add(this.jMenuItem56);
/*       */     
/*  6574 */     this.jMenuBar1.add(this.jMenu2);
/*       */     
/*  6576 */     this.jMenu9.setText("Recursos Humanos");
/*       */     
/*  6578 */     this.jMenu14.setText("Empleados");
/*       */     
/*  6580 */     this.jMenuItem48.setText("Agregar empleado");
/*  6581 */     this.jMenuItem48.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6583 */             Principal.this.jMenuItem48ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6586 */     this.jMenu14.add(this.jMenuItem48);
/*       */     
/*  6588 */     this.jMenuItem49.setText("Modificar empleado");
/*  6589 */     this.jMenuItem49.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6591 */             Principal.this.jMenuItem49ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6594 */     this.jMenu14.add(this.jMenuItem49);
/*       */     
/*  6596 */     this.jMenuItem50.setText("Eliminar empleado");
/*  6597 */     this.jMenuItem50.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6599 */             Principal.this.jMenuItem50ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6602 */     this.jMenu14.add(this.jMenuItem50);
/*       */     
/*  6604 */     this.jMenuItem51.setText("Buscar empleado");
/*  6605 */     this.jMenuItem51.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6607 */             Principal.this.jMenuItem51ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6610 */     this.jMenu14.add(this.jMenuItem51);
/*       */     
/*  6612 */     this.jMenu9.add(this.jMenu14);
/*       */     
/*  6614 */     this.jMenu15.setText("Operadores");
/*       */     
/*  6616 */     this.jMenuItem52.setText("Agregar operador");
/*  6617 */     this.jMenuItem52.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6619 */             Principal.this.jMenuItem52ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6622 */     this.jMenu15.add(this.jMenuItem52);
/*       */     
/*  6624 */     this.jMenuItem53.setText("Modificar operador");
/*  6625 */     this.jMenuItem53.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6627 */             Principal.this.jMenuItem53ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6630 */     this.jMenu15.add(this.jMenuItem53);
/*       */     
/*  6632 */     this.jMenuItem54.setText("Eliminar operador");
/*  6633 */     this.jMenuItem54.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6635 */             Principal.this.jMenuItem54ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6638 */     this.jMenu15.add(this.jMenuItem54);
/*       */     
/*  6640 */     this.jMenuItem55.setText("Buscar operador");
/*  6641 */     this.jMenuItem55.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6643 */             Principal.this.jMenuItem55ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6646 */     this.jMenu15.add(this.jMenuItem55);
/*       */     
/*  6648 */     this.jMenu9.add(this.jMenu15);
/*  6649 */     this.jMenu9.add(this.jSeparator19);
/*       */     
/*  6651 */     this.jMenuItem57.setText("Vacaciones");
/*  6652 */     this.jMenuItem57.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6654 */             Principal.this.jMenuItem57ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6657 */     this.jMenu9.add(this.jMenuItem57);
/*       */     
/*  6659 */     this.jMenuItem58.setText("Finiquitos");
/*  6660 */     this.jMenuItem58.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6662 */             Principal.this.jMenuItem58ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6665 */     this.jMenu9.add(this.jMenuItem58);
/*       */     
/*  6667 */     this.jMenuItem59.setText("Aguinaldos");
/*  6668 */     this.jMenuItem59.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6670 */             Principal.this.jMenuItem59ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6673 */     this.jMenu9.add(this.jMenuItem59);
/*       */     
/*  6675 */     this.jMenuBar1.add(this.jMenu9);
/*       */     
/*  6677 */     this.jMenu16.setText("Ayuda");
/*       */     
/*  6679 */     this.jMenuItem60.setText("Configuracion");
/*  6680 */     this.jMenuItem60.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6682 */             Principal.this.jMenuItem60ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6685 */     this.jMenu16.add(this.jMenuItem60);
/*       */     
/*  6687 */     this.jMenuItem61.setText("Bitácora del sistema");
/*  6688 */     this.jMenuItem61.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6690 */             Principal.this.jMenuItem61ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6693 */     this.jMenu16.add(this.jMenuItem61);
/*       */     
/*  6695 */     this.jMenuItem62.setText("Acerca de");
/*  6696 */     this.jMenuItem62.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  6698 */             Principal.this.jMenuItem62ActionPerformed(evt);
/*       */           }
/*       */         });
/*  6701 */     this.jMenu16.add(this.jMenuItem62);
/*       */     
/*  6703 */     this.jMenuBar1.add(this.jMenu16);
/*       */     
/*  6705 */     setJMenuBar(this.jMenuBar1);
/*       */     
/*  6707 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  6708 */     getContentPane().setLayout(layout);
/*  6709 */     layout.setHorizontalGroup(layout
/*  6710 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  6711 */         .addComponent(this.jPanel17, -1, -1, 32767));
/*       */     
/*  6713 */     layout.setVerticalGroup(layout
/*  6714 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  6715 */         .addComponent(this.jPanel17, -1, -1, 32767));
/*       */ 
/*       */     
/*  6718 */     pack();
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   private void jLabel2MouseClicked(MouseEvent evt) {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   private void jLabel2MouseEntered(MouseEvent evt) {
/*  6734 */     this.jLabel2.setForeground(new Color(255, 102, 0));
/*       */   }
/*       */   private void jLabel2MouseExited(MouseEvent evt) {
/*  6737 */     this.jLabel2.setForeground(this.lc.PRIMARIO1);
/*       */   }
/*       */   private void jLabel11MouseClicked(MouseEvent evt) {
/*  6740 */     if (existenDatos()) {
/*  6741 */       desactivarPanel();
/*       */     }
/*       */   }
/*       */   
/*       */   private void formWindowClosing(WindowEvent evt) {
/*  6746 */     salir();
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   private void jPasswordField2ActionPerformed(ActionEvent evt) {
/*  6755 */     this.error.pasarModal(true);
/*  6756 */     if (this.jPasswordField2.getText().isEmpty()) {
/*  6757 */       this.error.cargarError(this.jPasswordField2, "050");
/*  6758 */     } else if (this.jPasswordField2.getText().isEmpty()) {
/*  6759 */       this.error.cargarError(this.jPasswordField3, "050");
/*       */     } else {
/*  6761 */       cambiarContra();
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jPasswordField3ActionPerformed(ActionEvent evt) {
/*  6766 */     this.error.pasarModal(true);
/*  6767 */     if (this.jPasswordField2.getText().isEmpty()) {
/*  6768 */       this.error.cargarError(this.jPasswordField2, "050");
/*  6769 */     } else if (this.jPasswordField2.getText().isEmpty()) {
/*  6770 */       this.error.cargarError(this.jPasswordField3, "050");
/*       */     } else {
/*  6772 */       cambiarContra();
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jDialog1WindowClosing(WindowEvent evt) {
/*  6777 */     int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas salir de SICRE?", "Saliendo...", 0, 3, this.PREG);
/*  6778 */     if (res == 0) {
/*  6779 */       System.exit(0);
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel28MouseEntered(MouseEvent evt) {
/*  6784 */     this.jLabel28.setForeground(new Color(255, 102, 0));
/*       */   }
/*       */   
/*       */   private void jLabel28MouseExited(MouseEvent evt) {
/*  6788 */     this.jLabel28.setForeground(this.lc.PRIMARIO1);
/*       */   }
/*       */   
/*       */   private void jLabel28MouseClicked(MouseEvent evt) {
/*  6792 */     setVisible(false);
/*       */   }
/*       */   
/*       */   private void jLabel51MouseClicked(MouseEvent evt) {
/*  6796 */     this.jDialog10.setVisible(false);
/*       */   }
/*       */   
/*       */   private void jLabel51MouseEntered(MouseEvent evt) {
/*  6800 */     this.jLabel51.setForeground(new Color(153, 255, 153));
/*       */   }
/*       */   
/*       */   private void jLabel51MouseExited(MouseEvent evt) {
/*  6804 */     this.jLabel51.setForeground(Color.RED);
/*       */   }
/*       */   
/*       */   private void jPasswordField1ActionPerformed(ActionEvent evt) {
/*  6808 */     entrada();
/*       */   }
/*       */   
/*       */   private void jPasswordField1FocusGained(FocusEvent evt) {
/*  6812 */     if (this.jPasswordField1.getText().equals("Contraseña")) {
/*  6813 */       this.jPasswordField1.setText("");
/*  6814 */       this.jPasswordField1.setFont(new Font("Tahoma", 1, 12));
/*  6815 */       this.jPasswordField1.setForeground(Color.BLACK);
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jMenuItem1ActionPerformed(ActionEvent evt) {
/*  6820 */     salir();
/*       */   }
/*       */   
/*       */   private void jMenuItem2ActionPerformed(ActionEvent evt) {
/*  6824 */     llamada();
/*       */   }
/*       */   
/*       */   private void jMenuItem3ActionPerformed(ActionEvent evt) {
/*  6828 */     modificarGuias();
/*       */   }
/*       */   
/*       */   private void jMenuItem4ActionPerformed(ActionEvent evt) {
/*  6832 */     salir();
/*       */   }
/*       */   
/*       */   private void jMenuItem5ActionPerformed(ActionEvent evt) {
/*  6836 */     this.encontrado = this.con.consultar("interfaz", "perfiles", "where usuario='" + this.USUARIO + "'");
/*  6837 */     if (this.encontrado) {
/*  6838 */       this.con.inserSinMsj("update perfiles set interfaz='menus' where usuario = '" + this.USUARIO + "'");
/*       */     } else {
/*  6840 */       this.con.inserSinMsj("insert perfiles(usuario, interfaz) values('" + this.USUARIO + "','menus')");
/*       */     } 
/*  6842 */     activarMenus();
/*       */   }
/*       */   
/*       */   private void jMenuItem6ActionPerformed(ActionEvent evt) {
/*  6846 */     this.con.inserSinMsj("update perfiles set interfaz='barra' where usuario = '" + this.USUARIO + "'");
/*  6847 */     activarBarra();
/*       */   }
/*       */   
/*       */   private void jMenuItem7ActionPerformed(ActionEvent evt) {
/*  6851 */     buscarManifiestos();
/*       */   }
/*       */   
/*       */   private void jMenuItem8ActionPerformed(ActionEvent evt) {
/*  6855 */     llamadasBuscar();
/*       */   }
/*       */   
/*       */   private void jMenuItem10ActionPerformed(ActionEvent evt) {
/*  6859 */     formacion();
/*       */   }
/*       */   
/*       */   private void jMenuItem14ActionPerformed(ActionEvent evt) {
/*  6863 */     this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Salió del Sistema','' )");
/*  6864 */     this.jProgressBar1.setValue(100);
/*  6865 */     this.jLabel15.setText("SICRET cargado ....100% ");
/*  6866 */     this.mensajeTry.ocultar();
/*  6867 */     cambiar();
/*       */   }
/*       */   
/*       */   private void jMenuItem11ActionPerformed(ActionEvent evt) {
/*  6871 */     agregarUsuarios();
/*       */   }
/*       */   
/*       */   private void jMenuItem12ActionPerformed(ActionEvent evt) {
/*  6875 */     UsuariosEliminar();
/*       */   }
/*       */   
/*       */   private void jMenuItem13ActionPerformed(ActionEvent evt) {
/*  6879 */     buscarUsuarios();
/*       */   }
/*       */   
/*       */   private void jMenuItem16ActionPerformed(ActionEvent evt) {
/*  6883 */     liquidaciones();
/*       */   }
/*       */   
/*       */   private void jMenuItem17ActionPerformed(ActionEvent evt) {
/*  6887 */     cajaChica();
/*       */   }
/*       */   
/*       */   private void jMenuItem18ActionPerformed(ActionEvent evt) {
/*  6891 */     tarjetasDeudor();
/*       */   }
/*       */   
/*       */   private void jMenuItem15ActionPerformed(ActionEvent evt) {
/*  6895 */     verRSP();
/*       */   }
/*       */   
/*       */   private void jMenuItem19ActionPerformed(ActionEvent evt) {
/*  6899 */     valeDiesel();
/*       */   }
/*       */   
/*       */   private void jMenuItem20ActionPerformed(ActionEvent evt) {
/*  6903 */     dieselCompletado();
/*       */   }
/*       */   
/*       */   private void jMenuItem21ActionPerformed(ActionEvent evt) {
/*  6907 */     reseteos();
/*       */   }
/*       */   
/*       */   private void jMenuItem9ActionPerformed(ActionEvent evt) {
/*  6911 */     agregarTracto();
/*       */   }
/*       */   
/*       */   private void jMenuItem22ActionPerformed(ActionEvent evt) {
/*  6915 */     modificarTractos();
/*       */   }
/*       */   
/*       */   private void jMenuItem23ActionPerformed(ActionEvent evt) {
/*  6919 */     eliminarTractos();
/*       */   }
/*       */   
/*       */   private void jMenuItem24ActionPerformed(ActionEvent evt) {
/*  6923 */     buscarTractos();
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jMenuItem25ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jMenuItem26ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jMenuItem27ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jMenuItem28ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jMenuItem29ActionPerformed(ActionEvent evt) {
/*  6943 */     reporteQHSE();
/*       */   }
/*       */   
/*       */   private void jMenuItem30ActionPerformed(ActionEvent evt) {
/*  6947 */     Prefacturacion();
/*       */   }
/*       */   
/*       */   private void jMenuItem31ActionPerformed(ActionEvent evt) {
/*  6951 */     prefacturacionCliente();
/*       */   }
/*       */   
/*       */   private void jMenuItem32ActionPerformed(ActionEvent evt) {
/*  6955 */     facturas();
/*       */   }
/*       */   
/*       */   private void jMenuItem33ActionPerformed(ActionEvent evt) {
/*  6959 */     recepcion();
/*       */   }
/*       */   
/*       */   private void jMenuItem34ActionPerformed(ActionEvent evt) {
/*  6963 */     tarifas();
/*       */   }
/*       */   
/*       */   private void jMenuItem35ActionPerformed(ActionEvent evt) {
/*  6967 */     ampararFacturas();
/*       */   }
/*       */   
/*       */   private void jMenuItem36ActionPerformed(ActionEvent evt) {
/*  6971 */     depositosClientes();
/*       */   }
/*       */   
/*       */   private void jMenuItem37ActionPerformed(ActionEvent evt) {
/*  6975 */     lineas();
/*       */   }
/*       */   
/*       */   private void jMenuItem38ActionPerformed(ActionEvent evt) {
/*  6979 */     facturacionPendiente();
/*       */   }
/*       */   
/*       */   private void jMenuItem39ActionPerformed(ActionEvent evt) {
/*  6983 */     TarjetaCliente();
/*       */   }
/*       */   
/*       */   private void jMenuItem40ActionPerformed(ActionEvent evt) {
/*  6987 */     agregarGeneradora();
/*       */   }
/*       */   
/*       */   private void jMenuItem41ActionPerformed(ActionEvent evt) {
/*  6991 */     modificarGeneradora();
/*       */   }
/*       */   
/*       */   private void jMenuItem42ActionPerformed(ActionEvent evt) {
/*  6995 */     eliminarGeneradora();
/*       */   }
/*       */   
/*       */   private void jMenuItem43ActionPerformed(ActionEvent evt) {
/*  6999 */     buscarGeneradora();
/*       */   }
/*       */   
/*       */   private void jMenuItem44ActionPerformed(ActionEvent evt) {
/*  7003 */     agregarDestinatario();
/*       */   }
/*       */   
/*       */   private void jMenuItem45ActionPerformed(ActionEvent evt) {
/*  7007 */     modificarDestinatario();
/*       */   }
/*       */   
/*       */   private void jMenuItem46ActionPerformed(ActionEvent evt) {
/*  7011 */     eliminarDestinatario();
/*       */   }
/*       */   
/*       */   private void jMenuItem47ActionPerformed(ActionEvent evt) {
/*  7015 */     buscarDestinatario();
/*       */   }
/*       */   
/*       */   private void jMenuItem48ActionPerformed(ActionEvent evt) {
/*  7019 */     agregarEmpleados();
/*       */   }
/*       */   
/*       */   private void jMenuItem49ActionPerformed(ActionEvent evt) {
/*  7023 */     modificarEmpleados();
/*       */   }
/*       */   
/*       */   private void jMenuItem50ActionPerformed(ActionEvent evt) {
/*  7027 */     eliminarEmpleados();
/*       */   }
/*       */   
/*       */   private void jMenuItem51ActionPerformed(ActionEvent evt) {
/*  7031 */     buscarEmpleados();
/*       */   }
/*       */   
/*       */   private void jMenuItem52ActionPerformed(ActionEvent evt) {
/*  7035 */     agregarOperadores();
/*       */   }
/*       */   
/*       */   private void jMenuItem53ActionPerformed(ActionEvent evt) {
/*  7039 */     operadorModifi();
/*       */   }
/*       */   
/*       */   private void jMenuItem54ActionPerformed(ActionEvent evt) {
/*  7043 */     eliminarOperadores();
/*       */   }
/*       */   
/*       */   private void jMenuItem55ActionPerformed(ActionEvent evt) {
/*  7047 */     buscarOperadores();
/*       */   }
/*       */   
/*       */   private void jMenuItem56ActionPerformed(ActionEvent evt) {
/*       */     try {
/*  7052 */       Estadisticos();
/*  7053 */     } catch (IOException ex) {
/*  7054 */       Logger.getLogger(Principal.class
/*  7055 */           .getName()).log(Level.SEVERE, (String)null, ex);
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jMenuItem57ActionPerformed(ActionEvent evt) {
/*  7060 */     vacaciones();
/*       */   }
/*       */   
/*       */   private void jMenuItem59ActionPerformed(ActionEvent evt) {
/*  7064 */     aguinaldos();
/*       */   }
/*       */   
/*       */   private void jMenuItem58ActionPerformed(ActionEvent evt) {
/*  7068 */     finiquitos();
/*       */   }
/*       */   
/*       */   private void jMenuItem60ActionPerformed(ActionEvent evt) {
/*  7072 */     Configuracion();
/*       */   }
/*       */   
/*       */   private void jMenuItem61ActionPerformed(ActionEvent evt) {
/*  7076 */     this.con.eliminar2("bitacora", "where usuario = 'usuarioAdmin1'");
/*  7077 */     bitacora();
/*       */   }
/*       */   
/*       */   private void jMenuItem62ActionPerformed(ActionEvent evt) {
/*  7081 */     this.jDialog2.setVisible(true);
/*       */   }
/*       */   
/*       */   private void jMenuItem63ActionPerformed(ActionEvent evt) {
/*  7085 */     Pozos();
/*       */   }
/*       */   
/*       */   private void jMenuItem64ActionPerformed(ActionEvent evt) {
/*  7089 */     Plataforma();
/*       */   }
/*       */   
/*       */   private void jMenuItem65ActionPerformed(ActionEvent evt) {
/*  7093 */     equipo();
/*       */   }
/*       */   
/*       */   private void jMenuItem66ActionPerformed(ActionEvent evt) {
/*  7097 */     cotizaciones();
/*       */   }
/*       */   
/*       */   private void jMenuItem68ActionPerformed(ActionEvent evt) {
/*  7101 */     salir();
/*       */   }
/*       */   
/*       */   private void jMenuItem67ActionPerformed(ActionEvent evt) {
/*  7105 */     this.con.inserSinMsj("update perfiles set interfaz='barra' where usuario = '" + this.USUARIO + "'");
/*  7106 */     activarBarra();
/*       */   }
/*       */   
/*       */   private void jMenuItem69ActionPerformed(ActionEvent evt) {
/*  7110 */     pagos();
/*       */   }
/*       */   
/*       */   private void jLabel44MouseClicked(MouseEvent evt) {
/*  7114 */     System.exit(0);
/*       */   }
/*       */   
/*       */   private void jLabel44MouseEntered(MouseEvent evt) {
/*  7118 */     this.jLabel44.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*       */   }
/*       */   
/*       */   private void jLabel44MouseExited(MouseEvent evt) {
/*  7122 */     this.jLabel44.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*       */   }
/*       */   
/*       */   private void jTextField1ActionPerformed(ActionEvent evt) {
/*  7126 */     entrada();
/*       */   }
/*       */   
/*       */   private void jLabel47MouseEntered(MouseEvent evt) {
/*  7130 */     ingresaMouse(this.jLabel47, this.jPanel54);
/*       */   }
/*       */   
/*       */   private void jLabel47MouseExited(MouseEvent evt) {
/*  7134 */     saleMouse(this.jLabel47, this.jPanel54);
/*       */   }
/*       */ 
/*       */   
/*       */   private void jPanel49MouseClicked(MouseEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jPanel49MousePressed(MouseEvent evt) {
/*  7142 */     this.xx = evt.getX();
/*  7143 */     this.xy = evt.getY();
/*       */   }
/*       */   
/*       */   private void jPanel49MouseDragged(MouseEvent evt) {
/*  7147 */     int x = evt.getXOnScreen();
/*  7148 */     int y = evt.getYOnScreen();
/*  7149 */     this.jFrame1.setLocation(x - this.xx, y - this.xy);
/*       */   }
/*       */   
/*       */   private void jPanel50MousePressed(MouseEvent evt) {
/*  7153 */     this.xx = evt.getX();
/*  7154 */     this.xy = evt.getY();
/*       */   }
/*       */   
/*       */   private void jPanel50MouseDragged(MouseEvent evt) {
/*  7158 */     int x = evt.getXOnScreen();
/*  7159 */     int y = evt.getYOnScreen();
/*  7160 */     this.jFrame1.setLocation(x - this.xx, y - this.xy);
/*       */   }
/*       */   
/*       */   private void jLabel48MouseEntered(MouseEvent evt) {
/*  7164 */     ingresaMouse(this.jLabel48, this.jPanel53);
/*       */   }
/*       */ 
/*       */   
/*       */   private void jLabel48MousePressed(MouseEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jLabel48MouseExited(MouseEvent evt) {
/*  7172 */     saleMouse(this.jLabel48, this.jPanel53);
/*       */   }
/*       */   
/*       */   private void jLabel49MouseEntered(MouseEvent evt) {
/*  7176 */     ingresaMouse(this.jLabel49, this.jPanel55);
/*       */   }
/*       */   
/*       */   private void jLabel49MouseExited(MouseEvent evt) {
/*  7180 */     saleMouse(this.jLabel49, this.jPanel55);
/*       */   }
/*       */   
/*       */   private void jLabel54MouseEntered(MouseEvent evt) {
/*  7184 */     ingresaMouse(this.jLabel54, this.jPanel58);
/*       */   }
/*       */   
/*       */   private void jLabel54MouseExited(MouseEvent evt) {
/*  7188 */     saleMouse(this.jLabel54, this.jPanel58);
/*       */   }
/*       */   
/*       */   private void jLabel55MouseExited(MouseEvent evt) {
/*  7192 */     saleMouse(this.jLabel55, this.jPanel59);
/*       */   }
/*       */   
/*       */   private void jLabel55MouseEntered(MouseEvent evt) {
/*  7196 */     ingresaMouse(this.jLabel55, this.jPanel59);
/*       */   }
/*       */   
/*       */   private void jLabel65MouseEntered(MouseEvent evt) {
/*  7200 */     ingresaMouse(this.jLabel65, this.jPanel60);
/*       */   }
/*       */   
/*       */   private void jLabel65MouseExited(MouseEvent evt) {
/*  7204 */     saleMouse(this.jLabel65, this.jPanel60);
/*       */   }
/*       */   
/*       */   private void jLabel66MouseEntered(MouseEvent evt) {
/*  7208 */     ingresaMouse(this.jLabel66, this.jPanel61);
/*       */   }
/*       */   
/*       */   private void jLabel66MouseExited(MouseEvent evt) {
/*  7212 */     saleMouse(this.jLabel66, this.jPanel61);
/*       */   }
/*       */   
/*       */   private void jLabel67MouseEntered(MouseEvent evt) {
/*  7216 */     ingresaMouse(this.jLabel67, this.jPanel62);
/*       */   }
/*       */   
/*       */   private void jLabel67MouseExited(MouseEvent evt) {
/*  7220 */     saleMouse(this.jLabel67, this.jPanel62);
/*       */   }
/*       */   
/*       */   private void jLabel68MouseEntered(MouseEvent evt) {
/*  7224 */     ingresaMouse(this.jLabel68, this.jPanel67);
/*       */   }
/*       */   
/*       */   private void jLabel68MouseExited(MouseEvent evt) {
/*  7228 */     saleMouse(this.jLabel68, this.jPanel67);
/*       */   }
/*       */   
/*       */   private void jLabel69MouseEntered(MouseEvent evt) {
/*  7232 */     ingresaMouse(this.jLabel69, this.jPanel77);
/*       */   }
/*       */   
/*       */   private void jLabel69MouseExited(MouseEvent evt) {
/*  7236 */     saleMouse(this.jLabel69, this.jPanel77);
/*       */   }
/*       */   
/*       */   private void jLabel70MouseEntered(MouseEvent evt) {
/*  7240 */     ingresaMouse(this.jLabel70, this.jPanel78);
/*       */   }
/*       */   
/*       */   private void jLabel70MouseExited(MouseEvent evt) {
/*  7244 */     saleMouse(this.jLabel70, this.jPanel78);
/*       */   }
/*       */   
/*       */   private void jLabel71MouseEntered(MouseEvent evt) {
/*  7248 */     ingresaMouse(this.jLabel71, this.jPanel79);
/*       */   }
/*       */   
/*       */   private void jLabel71MouseExited(MouseEvent evt) {
/*  7252 */     saleMouse(this.jLabel71, this.jPanel79);
/*       */   }
/*       */   
/*       */   private void jLabel72MouseEntered(MouseEvent evt) {
/*  7256 */     ingresaMouse(this.jLabel72, this.jPanel80);
/*       */   }
/*       */   
/*       */   private void jLabel72MouseExited(MouseEvent evt) {
/*  7260 */     saleMouse(this.jLabel72, this.jPanel80);
/*       */   }
/*       */   
/*       */   private void jLabel73MouseEntered(MouseEvent evt) {
/*  7264 */     ingresaMouse(this.jLabel73, this.jPanel81);
/*       */   }
/*       */   
/*       */   private void jLabel73MouseExited(MouseEvent evt) {
/*  7268 */     saleMouse(this.jLabel73, this.jPanel81);
/*       */   }
/*       */   
/*       */   private void jLabel74MouseEntered(MouseEvent evt) {
/*  7272 */     ingresaMouse(this.jLabel74, this.jPanel82);
/*       */   }
/*       */   
/*       */   private void jLabel74MouseExited(MouseEvent evt) {
/*  7276 */     saleMouse(this.jLabel74, this.jPanel82);
/*       */   }
/*       */   
/*       */   private void jLabel75MouseEntered(MouseEvent evt) {
/*  7280 */     ingresaMouse(this.jLabel75, this.jPanel83);
/*       */   }
/*       */   
/*       */   private void jLabel75MouseExited(MouseEvent evt) {
/*  7284 */     saleMouse(this.jLabel75, this.jPanel83);
/*       */   }
/*       */   
/*       */   private void jLabel76MouseEntered(MouseEvent evt) {
/*  7288 */     ingresaMouse(this.jLabel76, this.jPanel84);
/*       */   }
/*       */   
/*       */   private void jLabel76MouseExited(MouseEvent evt) {
/*  7292 */     saleMouse(this.jLabel76, this.jPanel84);
/*       */   }
/*       */   
/*       */   private void jLabel77MouseEntered(MouseEvent evt) {
/*  7296 */     ingresaMouse(this.jLabel77, this.jPanel85);
/*       */   }
/*       */   
/*       */   private void jLabel77MouseExited(MouseEvent evt) {
/*  7300 */     saleMouse(this.jLabel77, this.jPanel85);
/*       */   }
/*       */   
/*       */   private void jLabel78MouseEntered(MouseEvent evt) {
/*  7304 */     ingresaMouse(this.jLabel78, this.jPanel86);
/*       */   }
/*       */   
/*       */   private void jLabel78MouseExited(MouseEvent evt) {
/*  7308 */     saleMouse(this.jLabel78, this.jPanel86);
/*       */   }
/*       */   
/*       */   private void jLabel79MouseEntered(MouseEvent evt) {
/*  7312 */     ingresaMouse(this.jLabel79, this.jPanel87);
/*       */   }
/*       */   
/*       */   private void jLabel79MouseExited(MouseEvent evt) {
/*  7316 */     saleMouse(this.jLabel79, this.jPanel87);
/*       */   }
/*       */   
/*       */   private void jLabel80MouseEntered(MouseEvent evt) {
/*  7320 */     ingresaMouse(this.jLabel80, this.jPanel88);
/*       */   }
/*       */   
/*       */   private void jLabel80MouseExited(MouseEvent evt) {
/*  7324 */     saleMouse(this.jLabel80, this.jPanel88);
/*       */   }
/*       */   
/*       */   private void jLabel81MouseEntered(MouseEvent evt) {
/*  7328 */     ingresaMouse(this.jLabel81, this.jPanel89);
/*       */   }
/*       */   
/*       */   private void jLabel81MouseExited(MouseEvent evt) {
/*  7332 */     saleMouse(this.jLabel81, this.jPanel89);
/*       */   }
/*       */   
/*       */   private void jLabel85MouseEntered(MouseEvent evt) {
/*  7336 */     ingresaMouse(this.jLabel85, this.jPanel91);
/*       */   }
/*       */   
/*       */   private void jLabel85MouseExited(MouseEvent evt) {
/*  7340 */     saleMouse(this.jLabel85, this.jPanel91);
/*       */   }
/*       */   
/*       */   private void jLabel86MouseEntered(MouseEvent evt) {
/*  7344 */     ingresaMouse(this.jLabel86, this.jPanel92);
/*       */   }
/*       */   
/*       */   private void jLabel86MouseExited(MouseEvent evt) {
/*  7348 */     saleMouse(this.jLabel86, this.jPanel92);
/*       */   }
/*       */   
/*       */   private void jLabel83MouseEntered(MouseEvent evt) {
/*  7352 */     ingresaMouse(this.jLabel83, this.jPanel90);
/*       */   }
/*       */   
/*       */   private void jLabel83MouseExited(MouseEvent evt) {
/*  7356 */     saleMouse(this.jLabel83, this.jPanel90);
/*       */   }
/*       */   
/*       */   private void jLabel82MouseEntered(MouseEvent evt) {
/*  7360 */     ingresaMouse(this.jLabel82, this.jPanel93);
/*       */   }
/*       */   
/*       */   private void jLabel82MouseExited(MouseEvent evt) {
/*  7364 */     saleMouse(this.jLabel82, this.jPanel93);
/*       */   }
/*       */   
/*       */   private void jLabel84MouseEntered(MouseEvent evt) {
/*  7368 */     ingresaMouse(this.jLabel84, this.jPanel94);
/*       */   }
/*       */   
/*       */   private void jLabel84MouseExited(MouseEvent evt) {
/*  7372 */     saleMouse(this.jLabel84, this.jPanel94);
/*       */   }
/*       */   
/*       */   private void jLabel87MouseEntered(MouseEvent evt) {
/*  7376 */     ingresaMouse(this.jLabel87, this.jPanel95);
/*       */   }
/*       */   
/*       */   private void jLabel87MouseExited(MouseEvent evt) {
/*  7380 */     saleMouse(this.jLabel87, this.jPanel95);
/*       */   }
/*       */   
/*       */   private void jLabel88MouseEntered(MouseEvent evt) {
/*  7384 */     ingresaMouse(this.jLabel88, this.jPanel96);
/*       */   }
/*       */   
/*       */   private void jLabel88MouseExited(MouseEvent evt) {
/*  7388 */     saleMouse(this.jLabel88, this.jPanel96);
/*       */   }
/*       */   
/*       */   private void jLabel90MouseEntered(MouseEvent evt) {
/*  7392 */     ingresaMouse(this.jLabel90, this.jPanel97);
/*       */   }
/*       */   
/*       */   private void jLabel90MouseExited(MouseEvent evt) {
/*  7396 */     saleMouse(this.jLabel90, this.jPanel97);
/*       */   }
/*       */   
/*       */   private void jLabel91MouseEntered(MouseEvent evt) {
/*  7400 */     ingresaMouse(this.jLabel91, this.jPanel98);
/*       */   }
/*       */   
/*       */   private void jLabel91MouseExited(MouseEvent evt) {
/*  7404 */     saleMouse(this.jLabel91, this.jPanel98);
/*       */   }
/*       */   
/*       */   private void jLabel92MouseEntered(MouseEvent evt) {
/*  7408 */     ingresaMouse(this.jLabel92, this.jPanel99);
/*       */   }
/*       */   
/*       */   private void jLabel92MouseExited(MouseEvent evt) {
/*  7412 */     saleMouse(this.jLabel92, this.jPanel99);
/*       */   }
/*       */   
/*       */   private void jLabel93MouseEntered(MouseEvent evt) {
/*  7416 */     ingresaMouse(this.jLabel93, this.jPanel100);
/*       */   }
/*       */   
/*       */   private void jLabel93MouseExited(MouseEvent evt) {
/*  7420 */     saleMouse(this.jLabel93, this.jPanel100);
/*       */   }
/*       */   
/*       */   private void jLabel94MouseEntered(MouseEvent evt) {
/*  7424 */     ingresaMouse(this.jLabel94, this.jPanel101);
/*       */   }
/*       */   
/*       */   private void jLabel94MouseExited(MouseEvent evt) {
/*  7428 */     saleMouse(this.jLabel94, this.jPanel101);
/*       */   }
/*       */   
/*       */   private void jLabel95MouseEntered(MouseEvent evt) {
/*  7432 */     ingresaMouse(this.jLabel95, this.jPanel102);
/*       */   }
/*       */   
/*       */   private void jLabel95MouseExited(MouseEvent evt) {
/*  7436 */     saleMouse(this.jLabel95, this.jPanel102);
/*       */   }
/*       */   
/*       */   private void jLabel96MouseEntered(MouseEvent evt) {
/*  7440 */     ingresaMouse(this.jLabel96, this.jPanel103);
/*       */   }
/*       */   
/*       */   private void jLabel96MouseExited(MouseEvent evt) {
/*  7444 */     saleMouse(this.jLabel96, this.jPanel103);
/*       */   }
/*       */   
/*       */   private void jLabel106MouseEntered(MouseEvent evt) {
/*  7448 */     ingresaMouse(this.jLabel106, this.jPanel104);
/*       */   }
/*       */   
/*       */   private void jLabel106MouseExited(MouseEvent evt) {
/*  7452 */     saleMouse(this.jLabel106, this.jPanel104);
/*       */   }
/*       */   
/*       */   private void jLabel107MouseEntered(MouseEvent evt) {
/*  7456 */     ingresaMouse(this.jLabel107, this.jPanel105);
/*       */   }
/*       */   
/*       */   private void jLabel107MouseExited(MouseEvent evt) {
/*  7460 */     saleMouse(this.jLabel107, this.jPanel105);
/*       */   }
/*       */   
/*       */   private void jLabel108MouseEntered(MouseEvent evt) {
/*  7464 */     ingresaMouse(this.jLabel108, this.jPanel106);
/*       */   }
/*       */   
/*       */   private void jLabel108MouseExited(MouseEvent evt) {
/*  7468 */     saleMouse(this.jLabel108, this.jPanel106);
/*       */   }
/*       */   
/*       */   private void jLabel109MouseEntered(MouseEvent evt) {
/*  7472 */     ingresaMouse(this.jLabel109, this.jPanel45);
/*       */   }
/*       */   
/*       */   private void jLabel109MouseExited(MouseEvent evt) {
/*  7476 */     saleMouse(this.jLabel109, this.jPanel45);
/*       */   }
/*       */   
/*       */   private void jLabel115MouseEntered(MouseEvent evt) {
/*  7480 */     ingresaMouse2(this.jPanel114, this.jPanel121);
/*       */   }
/*       */   
/*       */   private void jLabel115MouseExited(MouseEvent evt) {
/*  7484 */     if (this.ultimoClic != 1) {
/*  7485 */       saleMouse2(this.jPanel114, this.jPanel121);
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel116MouseEntered(MouseEvent evt) {
/*  7490 */     ingresaMouse2(this.jPanel116, this.jPanel120);
/*       */   }
/*       */   
/*       */   private void jLabel116MouseExited(MouseEvent evt) {
/*  7494 */     if (this.ultimoClic != 2) {
/*  7495 */       saleMouse2(this.jPanel116, this.jPanel120);
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel117MouseEntered(MouseEvent evt) {
/*  7500 */     ingresaMouse2(this.jPanel118, this.jPanel122);
/*       */   }
/*       */   
/*       */   private void jLabel117MouseExited(MouseEvent evt) {
/*  7504 */     if (this.ultimoClic != 3) {
/*  7505 */       saleMouse2(this.jPanel118, this.jPanel122);
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel115MouseClicked(MouseEvent evt) {
/*  7510 */     this.ultimoClic = 1;
/*  7511 */     saleMouse2(this.jPanel116, this.jPanel120);
/*  7512 */     saleMouse2(this.jPanel118, this.jPanel122);
/*       */     
/*  7514 */     this.jPanel113.removeAll();
/*       */     
/*  7516 */     this.jPanel113.add(this.jPanel114);
/*  7517 */     this.jPanel114.setBounds(0, 0, 167, 25);
/*  7518 */     this.jPanel113.add(this.jPanel116);
/*  7519 */     this.jPanel116.setBounds(173, 0, 167, 25);
/*  7520 */     this.jPanel113.add(this.jPanel118);
/*  7521 */     this.jPanel118.setBounds(346, 0, 167, 25);
/*  7522 */     this.jPanel113.add(this.jPanel115);
/*  7523 */     this.jPanel115.setBounds(0, 30, 3380, 5);
/*  7524 */     this.jPanel113.add(this.jPanel68);
/*  7525 */     this.jPanel68.setBounds(0, 35, 3400, 90);
/*  7526 */     this.jPanel113.add(this.jPanel121);
/*  7527 */     this.jPanel121.setBounds(0, 20, 167, 10);
/*  7528 */     this.jPanel113.add(this.jPanel120);
/*  7529 */     this.jPanel120.setBounds(173, 20, 167, 10);
/*  7530 */     this.jPanel113.add(this.jPanel122);
/*  7531 */     this.jPanel122.setBounds(346, 20, 167, 10);
/*  7532 */     repaint();
/*       */   }
/*       */   
/*       */   private void jLabel116MouseClicked(MouseEvent evt) {
/*  7536 */     this.ultimoClic = 2;
/*  7537 */     saleMouse2(this.jPanel114, this.jPanel121);
/*  7538 */     saleMouse2(this.jPanel118, this.jPanel122);
/*       */     
/*  7540 */     this.jPanel113.removeAll();
/*       */     
/*  7542 */     this.jPanel113.add(this.jPanel114);
/*  7543 */     this.jPanel114.setBounds(0, 0, 167, 25);
/*  7544 */     this.jPanel113.add(this.jPanel116);
/*  7545 */     this.jPanel116.setBounds(173, 0, 167, 25);
/*  7546 */     this.jPanel113.add(this.jPanel118);
/*  7547 */     this.jPanel118.setBounds(346, 0, 167, 25);
/*  7548 */     this.jPanel113.add(this.jPanel115);
/*  7549 */     this.jPanel115.setBounds(0, 30, 3380, 5);
/*  7550 */     this.jPanel113.add(this.jPanel69);
/*  7551 */     this.jPanel69.setBounds(0, 35, 3400, 90);
/*  7552 */     this.jPanel113.add(this.jPanel121);
/*  7553 */     this.jPanel121.setBounds(0, 20, 167, 10);
/*  7554 */     this.jPanel113.add(this.jPanel120);
/*  7555 */     this.jPanel120.setBounds(173, 20, 167, 10);
/*  7556 */     this.jPanel113.add(this.jPanel122);
/*  7557 */     this.jPanel122.setBounds(346, 20, 167, 10);
/*  7558 */     repaint();
/*       */   }
/*       */   
/*       */   private void jLabel117MouseClicked(MouseEvent evt) {
/*  7562 */     this.ultimoClic = 3;
/*  7563 */     saleMouse2(this.jPanel114, this.jPanel121);
/*  7564 */     saleMouse2(this.jPanel116, this.jPanel120);
/*       */     
/*  7566 */     this.jPanel113.removeAll();
/*       */     
/*  7568 */     this.jPanel113.add(this.jPanel114);
/*  7569 */     this.jPanel114.setBounds(0, 0, 167, 25);
/*  7570 */     this.jPanel113.add(this.jPanel116);
/*  7571 */     this.jPanel116.setBounds(173, 0, 167, 25);
/*  7572 */     this.jPanel113.add(this.jPanel118);
/*  7573 */     this.jPanel118.setBounds(346, 0, 167, 25);
/*  7574 */     this.jPanel113.add(this.jPanel115);
/*  7575 */     this.jPanel115.setBounds(0, 30, 3380, 5);
/*  7576 */     this.jPanel113.add(this.jPanel66);
/*  7577 */     this.jPanel66.setBounds(0, 35, 3400, 90);
/*  7578 */     this.jPanel113.add(this.jPanel121);
/*  7579 */     this.jPanel121.setBounds(0, 20, 167, 10);
/*  7580 */     this.jPanel113.add(this.jPanel120);
/*  7581 */     this.jPanel120.setBounds(173, 20, 167, 10);
/*  7582 */     this.jPanel113.add(this.jPanel122);
/*  7583 */     this.jPanel122.setBounds(346, 20, 167, 10);
/*  7584 */     repaint();
/*       */   }
/*       */   
/*       */   private void jLabel123MouseEntered(MouseEvent evt) {
/*  7588 */     ingresaMouse(this.jLabel123, this.jPanel127);
/*       */   }
/*       */   
/*       */   private void jLabel123MouseExited(MouseEvent evt) {
/*  7592 */     saleMouse(this.jLabel123, this.jPanel127);
/*       */   }
/*       */   
/*       */   private void jLabel119MouseEntered(MouseEvent evt) {
/*  7596 */     ingresaMouse(this.jLabel119, this.jPanel117);
/*       */   }
/*       */   
/*       */   private void jLabel119MouseExited(MouseEvent evt) {
/*  7600 */     saleMouse(this.jLabel119, this.jPanel117);
/*       */   }
/*       */   
/*       */   private void jLabel120MouseEntered(MouseEvent evt) {
/*  7604 */     ingresaMouse(this.jLabel120, this.jPanel119);
/*       */   }
/*       */   
/*       */   private void jLabel120MouseExited(MouseEvent evt) {
/*  7608 */     saleMouse(this.jLabel120, this.jPanel119);
/*       */   }
/*       */   
/*       */   private void jLabel121MouseEntered(MouseEvent evt) {
/*  7612 */     ingresaMouse(this.jLabel121, this.jPanel124);
/*       */   }
/*       */   
/*       */   private void jLabel121MouseExited(MouseEvent evt) {
/*  7616 */     saleMouse(this.jLabel121, this.jPanel124);
/*       */   }
/*       */   
/*       */   private void jLabel122MouseEntered(MouseEvent evt) {
/*  7620 */     ingresaMouse(this.jLabel122, this.jPanel125);
/*       */   }
/*       */   
/*       */   private void jLabel122MouseExited(MouseEvent evt) {
/*  7624 */     saleMouse(this.jLabel122, this.jPanel125);
/*       */   }
/*       */   
/*       */   private void jLabel124MouseEntered(MouseEvent evt) {
/*  7628 */     ingresaMouse(this.jLabel124, this.jPanel128);
/*       */   }
/*       */   
/*       */   private void jLabel124MouseExited(MouseEvent evt) {
/*  7632 */     saleMouse(this.jLabel124, this.jPanel128);
/*       */   }
/*       */   
/*       */   private void jLabel125MouseEntered(MouseEvent evt) {
/*  7636 */     ingresaMouse(this.jLabel125, this.jPanel129);
/*       */   }
/*       */   
/*       */   private void jLabel125MouseExited(MouseEvent evt) {
/*  7640 */     saleMouse(this.jLabel125, this.jPanel129);
/*       */   }
/*       */   
/*       */   private void jLabel126MouseEntered(MouseEvent evt) {
/*  7644 */     ingresaMouse(this.jLabel126, this.jPanel130);
/*       */   }
/*       */   
/*       */   private void jLabel126MouseExited(MouseEvent evt) {
/*  7648 */     saleMouse(this.jLabel126, this.jPanel130);
/*       */   }
/*       */   
/*       */   private void jLabel127MouseEntered(MouseEvent evt) {
/*  7652 */     ingresaMouse(this.jLabel127, this.jPanel131);
/*       */   }
/*       */   
/*       */   private void jLabel127MouseExited(MouseEvent evt) {
/*  7656 */     saleMouse(this.jLabel127, this.jPanel131);
/*       */   }
/*       */   
/*       */   private void jLabel128MouseEntered(MouseEvent evt) {
/*  7660 */     ingresaMouse(this.jLabel128, this.jPanel132);
/*       */   }
/*       */   
/*       */   private void jLabel128MouseExited(MouseEvent evt) {
/*  7664 */     saleMouse(this.jLabel128, this.jPanel132);
/*       */   }
/*       */   
/*       */   private void jLabel129MouseEntered(MouseEvent evt) {
/*  7668 */     ingresaMouse(this.jLabel129, this.jPanel133);
/*       */   }
/*       */   
/*       */   private void jLabel129MouseExited(MouseEvent evt) {
/*  7672 */     saleMouse(this.jLabel129, this.jPanel133);
/*       */   }
/*       */   
/*       */   private void jLabel130MouseEntered(MouseEvent evt) {
/*  7676 */     ingresaMouse(this.jLabel130, this.jPanel134);
/*       */   }
/*       */   
/*       */   private void jLabel130MouseExited(MouseEvent evt) {
/*  7680 */     saleMouse(this.jLabel130, this.jPanel134);
/*       */   }
/*       */   
/*       */   private void jLabel131MouseEntered(MouseEvent evt) {
/*  7684 */     ingresaMouse(this.jLabel131, this.jPanel135);
/*       */   }
/*       */   
/*       */   private void jLabel131MouseExited(MouseEvent evt) {
/*  7688 */     saleMouse(this.jLabel131, this.jPanel135);
/*       */   }
/*       */   
/*       */   private void jLabel132MouseEntered(MouseEvent evt) {
/*  7692 */     ingresaMouse(this.jLabel132, this.jPanel136);
/*       */   }
/*       */   
/*       */   private void jLabel132MouseExited(MouseEvent evt) {
/*  7696 */     saleMouse(this.jLabel132, this.jPanel136);
/*       */   }
/*       */   
/*       */   private void jLabel133MouseEntered(MouseEvent evt) {
/*  7700 */     ingresaMouse(this.jLabel133, this.jPanel137);
/*       */   }
/*       */   
/*       */   private void jLabel133MouseExited(MouseEvent evt) {
/*  7704 */     saleMouse(this.jLabel133, this.jPanel137);
/*       */   }
/*       */   
/*       */   private void jLabel134MouseEntered(MouseEvent evt) {
/*  7708 */     ingresaMouse(this.jLabel134, this.jPanel138);
/*       */   }
/*       */   
/*       */   private void jLabel134MouseExited(MouseEvent evt) {
/*  7712 */     saleMouse(this.jLabel134, this.jPanel138);
/*       */   }
/*       */   
/*       */   private void jLabel135MouseExited(MouseEvent evt) {
/*  7716 */     saleMouse(this.jLabel135, this.jPanel140);
/*       */   }
/*       */   
/*       */   private void jLabel135MouseEntered(MouseEvent evt) {
/*  7720 */     ingresaMouse(this.jLabel135, this.jPanel140);
/*       */   }
/*       */   
/*       */   private void jLabel136MouseExited(MouseEvent evt) {
/*  7724 */     saleMouse(this.jLabel136, this.jPanel141);
/*       */   }
/*       */   
/*       */   private void jLabel136MouseEntered(MouseEvent evt) {
/*  7728 */     ingresaMouse(this.jLabel136, this.jPanel141);
/*       */   }
/*       */   
/*       */   private void jLabel137MouseExited(MouseEvent evt) {
/*  7732 */     saleMouse(this.jLabel137, this.jPanel145);
/*       */   }
/*       */   
/*       */   private void jLabel137MouseEntered(MouseEvent evt) {
/*  7736 */     ingresaMouse(this.jLabel137, this.jPanel145);
/*       */   }
/*       */   
/*       */   private void jLabel138MouseExited(MouseEvent evt) {
/*  7740 */     saleMouse(this.jLabel138, this.jPanel146);
/*       */   }
/*       */   
/*       */   private void jLabel138MouseEntered(MouseEvent evt) {
/*  7744 */     ingresaMouse(this.jLabel138, this.jPanel146);
/*       */   }
/*       */   
/*       */   private void jLabel139MouseExited(MouseEvent evt) {
/*  7748 */     saleMouse(this.jLabel139, this.jPanel148);
/*       */   }
/*       */   
/*       */   private void jLabel139MouseEntered(MouseEvent evt) {
/*  7752 */     ingresaMouse(this.jLabel139, this.jPanel148);
/*       */   }
/*       */   
/*       */   private void jLabel140MouseExited(MouseEvent evt) {
/*  7756 */     saleMouse(this.jLabel140, this.jPanel149);
/*       */   }
/*       */   
/*       */   private void jLabel140MouseEntered(MouseEvent evt) {
/*  7760 */     ingresaMouse(this.jLabel140, this.jPanel149);
/*       */   }
/*       */   
/*       */   private void jLabel141MouseExited(MouseEvent evt) {
/*  7764 */     saleMouse(this.jLabel141, this.jPanel150);
/*       */   }
/*       */   
/*       */   private void jLabel141MouseEntered(MouseEvent evt) {
/*  7768 */     ingresaMouse(this.jLabel141, this.jPanel150);
/*       */   }
/*       */   
/*       */   private void jLabel144MouseExited(MouseEvent evt) {
/*  7772 */     saleMouse(this.jLabel144, this.jPanel154);
/*       */   }
/*       */   
/*       */   private void jLabel144MouseEntered(MouseEvent evt) {
/*  7776 */     ingresaMouse(this.jLabel144, this.jPanel154);
/*       */   }
/*       */   
/*       */   private void jLabel145MouseExited(MouseEvent evt) {
/*  7780 */     saleMouse(this.jLabel145, this.jPanel155);
/*       */   }
/*       */   
/*       */   private void jLabel145MouseEntered(MouseEvent evt) {
/*  7784 */     ingresaMouse(this.jLabel145, this.jPanel155);
/*       */   }
/*       */   
/*       */   private void jLabel146MouseExited(MouseEvent evt) {
/*  7788 */     saleMouse(this.jLabel146, this.jPanel156);
/*       */   }
/*       */   
/*       */   private void jLabel146MouseEntered(MouseEvent evt) {
/*  7792 */     ingresaMouse(this.jLabel146, this.jPanel156);
/*       */   }
/*       */   
/*       */   private void jLabel106MouseClicked(MouseEvent evt) {
/*  7796 */     this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Salió del Sistema','' )");
/*  7797 */     this.jProgressBar1.setValue(100);
/*  7798 */     this.jLabel15.setText("SICRET cargado ....100% ");
/*  7799 */     this.mensajeTry.ocultar();
/*  7800 */     cambiar();
/*       */   }
/*       */   
/*       */   private void jLabel47MouseClicked(MouseEvent evt) {
/*  7804 */     if (this.jLabel47.isEnabled()) {
/*  7805 */       llamada();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel48MouseClicked(MouseEvent evt) {
/*  7810 */     if (this.jLabel48.isEnabled()) {
/*  7811 */       buscarManifiestos();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel49MouseClicked(MouseEvent evt) {
/*  7816 */     if (this.jLabel49.isEnabled()) {
/*  7817 */       modificarGuias();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel54MouseClicked(MouseEvent evt) {
/*  7822 */     if (this.jLabel54.isEnabled()) {
/*  7823 */       valeDiesel();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel55MouseClicked(MouseEvent evt) {
/*  7828 */     if (this.jLabel55.isEnabled()) {
/*  7829 */       formacion();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel73MouseClicked(MouseEvent evt) {
/*  7834 */     if (this.jLabel73.isEnabled()) {
/*  7835 */       agregarGeneradora();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel74MouseClicked(MouseEvent evt) {
/*  7840 */     if (this.jLabel74.isEnabled()) {
/*  7841 */       modificarGeneradora();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel75MouseClicked(MouseEvent evt) {
/*  7846 */     if (this.jLabel75.isEnabled()) {
/*  7847 */       eliminarGeneradora();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel76MouseClicked(MouseEvent evt) {
/*  7852 */     if (this.jLabel76.isEnabled()) {
/*  7853 */       buscarGeneradora();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel77MouseClicked(MouseEvent evt) {
/*  7858 */     if (this.jLabel77.isEnabled()) {
/*  7859 */       agregarDestinatario();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel78MouseClicked(MouseEvent evt) {
/*  7864 */     if (this.jLabel78.isEnabled()) {
/*  7865 */       modificarDestinatario();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel79MouseClicked(MouseEvent evt) {
/*  7870 */     if (this.jLabel79.isEnabled()) {
/*  7871 */       eliminarDestinatario();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel80MouseClicked(MouseEvent evt) {
/*  7876 */     if (this.jLabel80.isEnabled()) {
/*  7877 */       buscarDestinatario();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel81MouseClicked(MouseEvent evt) {
/*  7882 */     if (this.jLabel81.isEnabled()) {
/*  7883 */       agregarTracto();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel85MouseClicked(MouseEvent evt) {
/*  7888 */     if (this.jLabel85.isEnabled()) {
/*  7889 */       modificarTractos();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel86MouseClicked(MouseEvent evt) {
/*  7894 */     if (this.jLabel86.isEnabled()) {
/*  7895 */       buscarTractos();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel83MouseClicked(MouseEvent evt) {
/*  7900 */     if (this.jLabel83.isEnabled()) {
/*  7901 */       eliminarTractos();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel82MouseClicked(MouseEvent evt) {
/*  7906 */     if (this.jLabel82.isEnabled());
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jLabel87MouseClicked(MouseEvent evt) {
/*  7912 */     if (this.jLabel87.isEnabled());
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jLabel88MouseClicked(MouseEvent evt) {
/*  7918 */     if (this.jLabel88.isEnabled());
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jLabel84MouseClicked(MouseEvent evt) {
/*  7924 */     if (this.jLabel84.isEnabled());
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jLabel90MouseClicked(MouseEvent evt) {
/*  7930 */     if (this.jLabel90.isEnabled()) {
/*  7931 */       equipo();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel91MouseClicked(MouseEvent evt) {
/*  7936 */     if (this.jLabel91.isEnabled()) {
/*  7937 */       Plataforma();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel92MouseClicked(MouseEvent evt) {
/*  7942 */     if (this.jLabel92.isEnabled()) {
/*  7943 */       Pozos();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel93MouseClicked(MouseEvent evt) {
/*  7948 */     if (this.jLabel93.isEnabled()) {
/*  7949 */       agregarUsuarios();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel94MouseClicked(MouseEvent evt) {
/*  7954 */     if (this.jLabel94.isEnabled()) {
/*  7955 */       buscarUsuarios();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel96MouseClicked(MouseEvent evt) {
/*  7960 */     if (this.jLabel96.isEnabled()) {
/*  7961 */       UsuariosEliminar();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel107MouseClicked(MouseEvent evt) {
/*  7966 */     if (this.jLabel107.isEnabled()) {
/*  7967 */       Configuracion();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel108MouseClicked(MouseEvent evt) {
/*  7972 */     if (this.jLabel108.isEnabled()) {
/*  7973 */       bitacora();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel109MouseClicked(MouseEvent evt) {
/*  7978 */     this.jDialog2.setVisible(true);
/*       */   }
/*       */   
/*       */   private void jLabel119MouseClicked(MouseEvent evt) {
/*  7982 */     if (this.jLabel119.isEnabled()) {
/*  7983 */       reporteQHSE();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel120MouseClicked(MouseEvent evt) {
/*  7988 */     if (this.jLabel120.isEnabled()) {
/*  7989 */       ValesSeg();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel121MouseClicked(MouseEvent evt) {
/*  7994 */     if (this.jLabel121.isEnabled()) {
/*       */       
/*       */       try {
/*  7997 */         Estadisticos();
/*       */       }
/*  7999 */       catch (IOException ex) {
/*  8000 */         Logger.getLogger(Principal.class
/*  8001 */             .getName()).log(Level.SEVERE, (String)null, ex);
/*       */       } 
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel122MouseClicked(MouseEvent evt) {
/*  8007 */     if (this.jLabel122.isEnabled()) {
/*  8008 */       servicios();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel123MouseClicked(MouseEvent evt) {
/*  8013 */     if (this.jLabel123.isEnabled()) {
/*  8014 */       Prefacturacion();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel129MouseClicked(MouseEvent evt) {
/*  8019 */     if (this.jLabel129.isEnabled()) {
/*  8020 */       cotizaciones();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel124MouseClicked(MouseEvent evt) {
/*  8025 */     if (this.jLabel124.isEnabled()) {
/*  8026 */       tarifas();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel130MouseClicked(MouseEvent evt) {
/*  8031 */     if (this.jLabel130.isEnabled()) {
/*  8032 */       prefacturacionCliente();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel125MouseClicked(MouseEvent evt) {
/*  8037 */     if (this.jLabel125.isEnabled()) {
/*  8038 */       facturas();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel131MouseClicked(MouseEvent evt) {
/*  8043 */     if (this.jLabel131.isEnabled()) {
/*  8044 */       TarjetaCliente();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel126MouseClicked(MouseEvent evt) {
/*  8049 */     if (this.jLabel126.isEnabled()) {
/*  8050 */       pagos();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel132MouseClicked(MouseEvent evt) {
/*  8055 */     if (this.jLabel132.isEnabled()) {
/*  8056 */       recepcion();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel127MouseClicked(MouseEvent evt) {
/*  8061 */     if (this.jLabel127.isEnabled()) {
/*  8062 */       depositosClientes();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel133MouseClicked(MouseEvent evt) {
/*  8067 */     if (this.jLabel133.isEnabled()) {
/*  8068 */       ampararFacturas();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel128MouseClicked(MouseEvent evt) {
/*  8073 */     if (this.jLabel128.isEnabled()) {
/*  8074 */       lineas();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel134MouseClicked(MouseEvent evt) {
/*  8079 */     if (this.jLabel134.isEnabled()) {
/*  8080 */       facturacionPendiente();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel135MouseClicked(MouseEvent evt) {
/*  8085 */     if (this.jLabel135.isEnabled()) {
/*  8086 */       verRSP();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel136MouseClicked(MouseEvent evt) {
/*  8091 */     if (this.jLabel136.isEnabled()) {
/*  8092 */       valeDiesel();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel138MouseClicked(MouseEvent evt) {
/*  8097 */     if (this.jLabel138.isEnabled()) {
/*  8098 */       cajaChica();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel137MouseClicked(MouseEvent evt) {
/*  8103 */     if (this.jLabel137.isEnabled()) {
/*  8104 */       tarjetasDeudor();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel139MouseClicked(MouseEvent evt) {
/*  8109 */     if (this.jLabel139.isEnabled()) {
/*  8110 */       liquidaciones();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel140MouseClicked(MouseEvent evt) {
/*  8115 */     if (this.jLabel140.isEnabled()) {
/*  8116 */       dieselCompletado();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel141MouseClicked(MouseEvent evt) {
/*  8121 */     if (this.jLabel141.isEnabled()) {
/*  8122 */       reseteos();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel144MouseClicked(MouseEvent evt) {
/*  8127 */     if (this.jLabel144.isEnabled()) {
/*  8128 */       vacaciones();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel146MouseClicked(MouseEvent evt) {
/*  8133 */     if (this.jLabel146.isEnabled()) {
/*  8134 */       aguinaldos();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel145MouseClicked(MouseEvent evt) {
/*  8139 */     if (this.jLabel145.isEnabled()) {
/*  8140 */       finiquitos();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel69MouseClicked(MouseEvent evt) {
/*  8145 */     if (this.jLabel69.isEnabled()) {
/*  8146 */       agregarEmpleados();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel70MouseClicked(MouseEvent evt) {
/*  8151 */     if (this.jLabel70.isEnabled()) {
/*  8152 */       modificarEmpleados();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel71MouseClicked(MouseEvent evt) {
/*  8157 */     if (this.jLabel71.isEnabled()) {
/*  8158 */       eliminarEmpleados();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel72MouseClicked(MouseEvent evt) {
/*  8163 */     if (this.jLabel72.isEnabled()) {
/*  8164 */       buscarEmpleados();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel65MouseClicked(MouseEvent evt) {
/*  8169 */     if (this.jLabel65.isEnabled()) {
/*  8170 */       agregarOperadores();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel66MouseClicked(MouseEvent evt) {
/*  8175 */     if (this.jLabel66.isEnabled()) {
/*  8176 */       operadorModifi();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel67MouseClicked(MouseEvent evt) {
/*  8181 */     if (this.jLabel67.isEnabled()) {
/*  8182 */       eliminarOperadores();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel68MouseClicked(MouseEvent evt) {
/*  8187 */     if (this.jLabel68.isEnabled()) {
/*  8188 */       buscarOperadores();
/*       */     }
/*       */   }
/*       */ 
/*       */   
/*       */   private void jLabel95MouseClicked(MouseEvent evt) {}
/*       */ 
/*       */   
/*       */   private void materialButton5ActionPerformed(ActionEvent evt) {
/*  8197 */     entrada();
/*       */   }
/*       */   
/*       */   private void materialButton2ActionPerformed(ActionEvent evt) {
/*  8201 */     consultarHistorialForma();
/*  8202 */     this.jDialog9.setVisible(true);
/*       */   }
/*       */   
/*       */   private void materialButton3ActionPerformed(ActionEvent evt) {
/*  8206 */     this.jFrame2.setVisible(false);
/*       */   }
/*       */   
/*       */   private void materialButton4ActionPerformed(ActionEvent evt) {
/*  8210 */     if (this.jRadioButton1.isSelected()) {
/*  8211 */       int cont = this.rSTableMetro5.getSelectedRow();
/*  8212 */       if (cont < 0) {
/*  8213 */         JOptionPane.showMessageDialog(this.jFrame2, "Necesitas seleccionar un operador de la lista de PIPAS", "Selecciona el operador", 0, this.ERROR);
/*       */       } else {
/*  8215 */         this.jTextArea2.setText("OPERADOR: " + String.valueOf(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 1)) + "\n");
/*  8216 */         this.jTextArea2.setText(this.jTextArea2.getText() + "ECO: " + this.jTextArea2.getText() + "\n");
/*  8217 */         this.jTextArea2.setText(this.jTextArea2.getText() + "ESTATUS: " + this.jTextArea2.getText());
/*  8218 */         this.jComboBox2.setSelectedItem(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 4));
/*  8219 */         this.jDialog6.setVisible(true);
/*       */       } 
/*       */     } else {
/*  8222 */       int cont = this.rSTableMetro6.getSelectedRow();
/*  8223 */       if (cont < 0) {
/*  8224 */         JOptionPane.showMessageDialog(this.jFrame2, "Necesitas seleccionar un operador de la lista de PIPAS", "Selecciona el operador", 0, this.ERROR);
/*       */       } else {
/*  8226 */         this.jTextArea2.setText("OPERADOR: " + String.valueOf(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 1)) + "\n");
/*  8227 */         this.jTextArea2.setText(this.jTextArea2.getText() + "ECO: " + this.jTextArea2.getText() + "\n");
/*  8228 */         this.jTextArea2.setText(this.jTextArea2.getText() + "ESTATUS: " + this.jTextArea2.getText());
/*  8229 */         this.jComboBox2.setSelectedItem(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 4));
/*  8230 */         this.jDialog6.setVisible(true);
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   private void materialButton6ActionPerformed(ActionEvent evt) {
/*  8236 */     if (this.jRadioButton1.isSelected()) {
/*  8237 */       int cont = this.rSTableMetro5.getSelectedRow();
/*  8238 */       if (cont < 0) {
/*  8239 */         JOptionPane.showMessageDialog(this.jFrame2, "Necesitas seleccionar un operador de la lista de PIPAS", "Selecciona el operador", 0, this.ERROR);
/*       */       } else {
/*  8241 */         int r = JOptionPane.showConfirmDialog(this.jFrame2, "¿Estás seguro que deseas quitar el operador que seleccionaste?\n" + String.valueOf(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 1)), "Quitar Operador", 0, 3, this.PREG);
/*  8242 */         if (r == 0) {
/*  8243 */           this.con.consultar("comentario", "formacion", "where num = " + String.valueOf(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 5)));
/*  8244 */           this.con.inserSinMsj("update formacion set activo=0, estatus ='ELIMINADO', comentario='" + this.con.Campo + "\nRegistro Eliminado (" + cargarFechaHoy() + "); Por " + this.USUARIO + "' where num=" + String.valueOf(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 5)));
/*  8245 */           consultarForma();
/*       */         } 
/*       */       } 
/*       */     } else {
/*  8249 */       int cont = this.rSTableMetro6.getSelectedRow();
/*  8250 */       if (cont < 0) {
/*  8251 */         JOptionPane.showMessageDialog(this.jFrame2, "Necesitas seleccionar un operador de la lista de GONDOLAS", "Selecciona el operador", 0, this.ERROR);
/*       */       } else {
/*  8253 */         int r = JOptionPane.showConfirmDialog(this.jFrame2, "¿Estás seguro que deseas quitar el operador que seleccionaste?\n" + String.valueOf(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 1)), "Quitar Operador", 0, 3, this.PREG);
/*  8254 */         if (r == 0) {
/*  8255 */           this.con.consultar("comentario", "formacion", "where num = " + String.valueOf(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 5)));
/*  8256 */           this.con.inserSinMsj("update formacion set activo=0, estatus ='ELIMINADO', comentario='" + this.con.Campo + "\nRegistro Eliminado (" + cargarFechaHoy() + "); Por " + this.USUARIO + "' where num=" + String.valueOf(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 5)));
/*  8257 */           consultarForma();
/*       */         } 
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   private void materialButton7ActionPerformed(ActionEvent evt) {
/*  8264 */     consultarForma();
/*       */   }
/*       */   
/*       */   private void materialButton8ActionPerformed(ActionEvent evt) {
/*  8268 */     if (this.jRadioButton1.isSelected()) {
/*  8269 */       int cont = this.rSTableMetro5.getSelectedRow();
/*  8270 */       if (cont < 0) {
/*  8271 */         JOptionPane.showMessageDialog(this.jFrame2, "Necesitas seleccionar un operador de la lista de PIPAS", "Selecciona el operador", 0, this.ERROR);
/*       */       } else {
/*  8273 */         this.jTextField2.setText("PIPA");
/*  8274 */         this.jTextField3.setText(String.valueOf(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 1)));
/*  8275 */         this.jDialog7.setVisible(true);
/*       */       } 
/*       */     } else {
/*  8278 */       int cont = this.rSTableMetro6.getSelectedRow();
/*  8279 */       if (cont < 0) {
/*  8280 */         JOptionPane.showMessageDialog(this.jFrame2, "Necesitas seleccionar un operador de la lista de GONDOLAS", "Selecciona el operador", 0, this.ERROR);
/*       */       } else {
/*  8282 */         this.jTextField2.setText("GONDOLA");
/*  8283 */         this.jTextField3.setText(String.valueOf(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 1)));
/*  8284 */         this.jDialog7.setVisible(true);
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   private void materialButton9ActionPerformed(ActionEvent evt) {
/*  8290 */     consultar2();
/*  8291 */     this.jDialog5.setVisible(true);
/*       */   }
/*       */   
/*       */   private void materialButton10ActionPerformed(ActionEvent evt) {
/*  8295 */     int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas salir de SICRE?", "Saliendo...", 0, 3, this.PREG);
/*  8296 */     if (res == 0) {
/*  8297 */       this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Salió del Sistema','' )");
/*  8298 */       System.exit(0);
/*       */     } 
/*       */   }
/*       */   
/*       */   private void materialButton11ActionPerformed(ActionEvent evt) {
/*  8303 */     this.error.pasarModal(true);
/*  8304 */     if (this.jPasswordField2.getText().isEmpty()) {
/*  8305 */       this.error.cargarError(this.jPasswordField2, "050");
/*  8306 */     } else if (this.jPasswordField2.getText().isEmpty()) {
/*  8307 */       this.error.cargarError(this.jPasswordField3, "050");
/*       */     } else {
/*  8309 */       cambiarContra();
/*       */     } 
/*       */   }
/*       */   
/*       */   private void materialButton12ActionPerformed(ActionEvent evt) {
/*  8314 */     this.jDialog4.setVisible(false);
/*       */   }
/*       */   
/*       */   private void materialButton13ActionPerformed(ActionEvent evt) {
/*  8318 */     ImprimirDocumento impAbono = new ImprimirDocumento();
/*  8319 */     impAbono.recibeDatos();
/*       */   }
/*       */   
/*       */   private void materialButton14ActionPerformed(ActionEvent evt) {
/*  8323 */     this.jDialog5.setVisible(false);
/*       */   }
/*       */   
/*       */   private void materialButton15ActionPerformed(ActionEvent evt) {
/*  8327 */     cargarOperador();
/*       */   }
/*       */   
/*       */   private void materialButton16ActionPerformed(ActionEvent evt) {
/*  8331 */     this.jDialog8.setVisible(false);
/*       */   }
/*       */   
/*       */   private void materialButton17ActionPerformed(ActionEvent evt) {
/*  8335 */     this.jDialog6.setVisible(false);
/*       */   }
/*       */   
/*       */   private void materialButton18ActionPerformed(ActionEvent evt) {
/*  8339 */     String tipo = "";
/*  8340 */     if (this.jRadioButton1.isSelected()) {
/*  8341 */       String justi = this.jTextArea4.getText().toUpperCase();
/*  8342 */       if (justi.equals("")) {
/*  8343 */         this.jTextArea4.setBackground(Color.RED);
/*  8344 */         JOptionPane.showMessageDialog(this.jDialog6, "Necesitas ingresar la justificación por el cual se cambiará de estatus", "Ingresa la justificación", 0, this.ERROR);
/*       */       } else {
/*  8346 */         int res = JOptionPane.showConfirmDialog(this.jFrame2, "¿Estás seguro que deseas cambiar de estatus al operador que seleccionaste?", "Cambiar de estatus", 0, 3, this.PREG);
/*  8347 */         if (res == 0) {
/*  8348 */           this.con.consultar("comentario", "formacion", "where num = " + String.valueOf(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 5)));
/*  8349 */           this.con.inserSinMsj("update formacion set estatus ='" + this.jComboBox2.getSelectedItem().toString().toUpperCase() + "', comentario='" + this.con.Campo + "\nEstatus cambiado (" + cargarFechaHoy() + ") --> Anterior:" + String.valueOf(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 4)) + "; Por " + this.USUARIO + "\nJUSTIFICACION: " + justi + "' where operador = '" + String.valueOf(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 1)) + "' and eco=" + String.valueOf(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 3)) + " and activo=1 and tipo ='PIPA'");
/*  8350 */           consultarForma();
/*  8351 */           this.jDialog6.setVisible(false);
/*       */         } 
/*       */       } 
/*       */     } else {
/*  8355 */       String justi = this.jTextArea4.getText().toUpperCase();
/*  8356 */       if (justi.equals("")) {
/*  8357 */         this.jTextArea4.setBackground(Color.RED);
/*  8358 */         JOptionPane.showMessageDialog(this.jDialog6, "Necesitas ingresar la justificación por el cual se cambiará de estatus", "Ingresa la justificación", 0, this.ERROR);
/*       */       } else {
/*  8360 */         int res = JOptionPane.showConfirmDialog(this.jFrame2, "¿Estás seguro que deseas cambiar de estatus al operador que seleccionaste?", "Cambiar de estatus", 0, 3, this.PREG);
/*  8361 */         if (res == 0) {
/*  8362 */           this.con.consultar("comentario", "formacion", "where num = " + String.valueOf(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 5)));
/*  8363 */           this.con.inserSinMsj("update formacion set estatus ='" + String.valueOf(this.jComboBox2.getSelectedItem()) + "', comentario='" + this.con.Campo + "\nEstatus cambiado (" + cargarFechaHoy() + ") --> Anterior:" + String.valueOf(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 4)) + "; Por " + this.USUARIO + "\nJUSTIFICACION: " + justi + "' where operador = '" + String.valueOf(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 1)) + "' and eco=" + String.valueOf(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 3)) + " and activo=1 and tipo='GONDOLA'");
/*  8364 */           consultarForma();
/*  8365 */           this.jDialog6.setVisible(false);
/*       */         } 
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   private void materialButton19ActionPerformed(ActionEvent evt) {
/*  8372 */     if (this.jRadioButton1.isSelected()) {
/*  8373 */       if (this.jRadioButton3.isSelected()) {
/*  8374 */         int indice1 = this.rSTableMetro5.getSelectedRow();
/*  8375 */         int indice2 = indice1 - 1;
/*  8376 */         if (indice2 < 0) {
/*  8377 */           JOptionPane.showMessageDialog(this.jDialog7, "El registro que has seleccionado ya se encuentra al inicio", "Registro en el inicio", 0, this.ERROR);
/*       */         } else {
/*  8379 */           int res = JOptionPane.showConfirmDialog(this.jDialog7, "¿Estás seguro que deseas mover al operador una registro ARRIBA?", "Mover", 0, 3, this.PREG);
/*  8380 */           if (res == 0) {
/*  8381 */             this.con.consultar("comentario", "formacion", "where num = " + String.valueOf(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 5)));
/*  8382 */             this.con.inserSinMsj("update formacion set num = 0 where num= " + String.valueOf(this.rSTableMetro5.getValueAt(indice2, 5)));
/*  8383 */             this.con.inserSinMsj("update formacion set num = " + String.valueOf(this.rSTableMetro5.getValueAt(indice2, 5)) + ", comentario='" + this.con.Campo + "\nMovido Arriba: (" + cargarFechaHoy() + ")--> Lugar Anterior:" + this.rSTableMetro5.getSelectedRow() + 1 + "; Por " + this.USUARIO + "' where num= " + String.valueOf(this.rSTableMetro5.getValueAt(indice1, 5)));
/*  8384 */             this.con.inserSinMsj("update formacion set num = " + String.valueOf(this.rSTableMetro5.getValueAt(indice1, 5)) + " where num= 0");
/*  8385 */             consultarForma();
/*  8386 */             this.rSTableMetro5.changeSelection(indice2, 0, false, false);
/*       */           } 
/*       */         } 
/*       */       } else {
/*  8390 */         int indice1 = this.rSTableMetro5.getSelectedRow();
/*  8391 */         int indice2 = indice1 + 1;
/*  8392 */         if (indice2 == this.rSTableMetro5.getRowCount()) {
/*  8393 */           JOptionPane.showMessageDialog(this.jDialog7, "El registro que has seleccionado ya se encuentra al final", "Registro al final", 0, this.ERROR);
/*       */         } else {
/*  8395 */           int res = JOptionPane.showConfirmDialog(this.jDialog7, "¿Estás seguro que deseas mover al operador una registro ABAJO?", "Mover", 0, 3, this.PREG);
/*  8396 */           if (res == 0) {
/*  8397 */             this.con.consultar("comentario", "formacion", "where num = " + String.valueOf(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 5)));
/*  8398 */             this.con.inserSinMsj("update formacion set num = 0 where num= " + String.valueOf(this.rSTableMetro5.getValueAt(indice2, 5)));
/*  8399 */             this.con.inserSinMsj("update formacion set num = " + String.valueOf(this.rSTableMetro5.getValueAt(indice2, 5)) + ", comentario='" + this.con.Campo + "\nMovido Abajo: (" + cargarFechaHoy() + ")--> Lugar Anterior:" + this.rSTableMetro5.getSelectedRow() + 1 + "; Por " + this.USUARIO + "' where num= " + String.valueOf(this.rSTableMetro5.getValueAt(indice1, 5)));
/*  8400 */             this.con.inserSinMsj("update formacion set num = " + String.valueOf(this.rSTableMetro5.getValueAt(indice1, 5)) + " where num= 0");
/*  8401 */             consultarForma();
/*  8402 */             this.rSTableMetro5.changeSelection(indice2, 0, false, false);
/*       */           }
/*       */         
/*       */         }
/*       */       
/*       */       } 
/*  8408 */     } else if (this.jRadioButton3.isSelected()) {
/*  8409 */       int indice1 = this.rSTableMetro6.getSelectedRow();
/*  8410 */       int indice2 = indice1 - 1;
/*  8411 */       if (indice2 < 0) {
/*  8412 */         JOptionPane.showMessageDialog(this.jDialog7, "El registro que has seleccionado ya se encuentra al inicio", "Registro en el inicio", 0, this.ERROR);
/*       */       } else {
/*  8414 */         int res = JOptionPane.showConfirmDialog(this.jDialog7, "¿Estás seguro que deseas mover al operador una registro ARRIBA?", "Mover", 0, 3, this.PREG);
/*  8415 */         if (res == 0) {
/*  8416 */           this.con.consultar("comentario", "formacion", "where num = " + String.valueOf(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 5)));
/*  8417 */           this.con.inserSinMsj("update formacion set num = 0 where num= " + String.valueOf(this.rSTableMetro6.getValueAt(indice2, 5)));
/*  8418 */           this.con.inserSinMsj("update formacion set num = " + String.valueOf(this.rSTableMetro6.getValueAt(indice2, 5)) + ", comentario='" + this.con.Campo + "\nMovido Arriba: (" + cargarFechaHoy() + ")--> Lugar Anterior:" + this.rSTableMetro6.getSelectedRow() + 1 + "; Por " + this.USUARIO + "' where num= " + String.valueOf(this.rSTableMetro6.getValueAt(indice1, 5)));
/*  8419 */           this.con.inserSinMsj("update formacion set num = " + String.valueOf(this.rSTableMetro6.getValueAt(indice1, 5)) + " where num= 0");
/*  8420 */           consultarForma();
/*  8421 */           this.rSTableMetro6.changeSelection(indice2, 0, false, false);
/*       */         } 
/*       */       } 
/*       */     } else {
/*  8425 */       int indice1 = this.rSTableMetro6.getSelectedRow();
/*  8426 */       int indice2 = indice1 + 1;
/*  8427 */       if (indice2 == this.rSTableMetro6.getRowCount()) {
/*  8428 */         JOptionPane.showMessageDialog(this.jDialog7, "El registro que has seleccionado ya se encuentra al final", "Registro al final", 0, this.ERROR);
/*       */       } else {
/*  8430 */         int res = JOptionPane.showConfirmDialog(this.jDialog7, "¿Estás seguro que deseas mover al operador una registro ABAJO?", "Mover", 0, 3, this.PREG);
/*  8431 */         if (res == 0) {
/*  8432 */           this.con.consultar("comentario", "formacion", "where num = " + String.valueOf(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 5)));
/*  8433 */           this.con.inserSinMsj("update formacion set num = 0 where num= " + String.valueOf(this.rSTableMetro6.getValueAt(indice2, 5)));
/*  8434 */           this.con.inserSinMsj("update formacion set num = " + String.valueOf(this.rSTableMetro6.getValueAt(indice2, 5)) + ", comentario='" + this.con.Campo + "\nMovido Abajo: (" + cargarFechaHoy() + ")--> Lugar Anterior:" + this.rSTableMetro6.getSelectedRow() + 1 + "; Por " + this.USUARIO + "' where num= " + String.valueOf(this.rSTableMetro6.getValueAt(indice1, 5)));
/*  8435 */           this.con.inserSinMsj("update formacion set num = " + String.valueOf(this.rSTableMetro6.getValueAt(indice1, 5)) + " where num= 0");
/*  8436 */           consultarForma();
/*  8437 */           this.rSTableMetro6.changeSelection(indice2, 0, false, false);
/*       */         } 
/*       */       } 
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   private void materialButton20ActionPerformed(ActionEvent evt) {
/*  8445 */     this.jDialog9.setVisible(false);
/*       */   }
/*       */   
/*       */   private void rSTableMetro2KeyReleased(KeyEvent evt) {
/*  8449 */     int ind = this.rSTableMetro2.getSelectedRow();
/*  8450 */     if (ind >= 0) {
/*  8451 */       String nombre = String.valueOf(this.rSTableMetro2.getValueAt(ind, 0));
/*  8452 */       String ap = String.valueOf(this.rSTableMetro2.getValueAt(ind, 1));
/*       */       
/*  8454 */       String num = String.valueOf(this.rSTableMetro2.getValueAt(this.rSTableMetro2.getSelectedRow(), 0));
/*       */       
/*  8456 */       this.cLabel1.setText("Cargando...");
/*  8457 */       this.cLabel1.setIcon(null);
/*  8458 */       this.ind = new fotoIndividual(num);
/*       */     } 
/*       */   }
/*       */   
/*       */   private void rSTableMetro2MouseClicked(MouseEvent evt) {
/*  8463 */     int ind = this.rSTableMetro2.getSelectedRow();
/*  8464 */     String nombre = String.valueOf(this.rSTableMetro2.getValueAt(ind, 0));
/*  8465 */     String ap = String.valueOf(this.rSTableMetro2.getValueAt(ind, 1));
/*       */     
/*  8467 */     String num = String.valueOf(this.rSTableMetro2.getValueAt(this.rSTableMetro2.getSelectedRow(), 0));
/*       */     
/*  8469 */     this.cLabel1.setText("Cargando...");
/*  8470 */     this.cLabel1.setIcon(null);
/*  8471 */     this.ind = new fotoIndividual(num);
/*       */   }
/*       */   
/*       */   private void rSTableMetro3MouseClicked(MouseEvent evt) {
/*  8475 */     if (evt.getClickCount() == 2) {
/*  8476 */       cargarOperador();
/*       */     } else {
/*  8478 */       int ind = this.rSTableMetro3.getSelectedRow();
/*  8479 */       String nombre = String.valueOf(this.rSTableMetro3.getValueAt(ind, 0));
/*  8480 */       String ap = String.valueOf(this.rSTableMetro3.getValueAt(ind, 1));
/*  8481 */       this.materialButton15.setEnabled(true);
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   private void rSTableMetro3KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void rSTableMetro4MouseClicked(MouseEvent evt) {
/*  8490 */     String num = String.valueOf(this.rSTableMetro4.getValueAt(this.rSTableMetro4.getSelectedRow(), 0));
/*  8491 */     String[] datos = this.con.regresaReg("tipo,estatus,comentario,guias", "formacion", "where num=" + num, 4);
/*  8492 */     this.jTextArea3.setText("-Estas son las observaciones-\n");
/*  8493 */     this.jTextArea3.setText(this.jTextArea3.getText() + this.jTextArea3.getText() + "\n");
/*  8494 */     this.jTextArea3.setText(this.jTextArea3.getText() + this.jTextArea3.getText() + "\n");
/*  8495 */     this.jTextArea3.setText(this.jTextArea3.getText() + "Guia: " + this.jTextArea3.getText() + "\n");
/*  8496 */     this.jTextArea3.setText(this.jTextArea3.getText() + this.jTextArea3.getText() + "\n");
/*       */   }
/*       */ 
/*       */   
/*       */   private void rSTableMetro4KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void rSTableMetro4KeyPressed(KeyEvent evt) {
/*  8504 */     String num = String.valueOf(this.rSTableMetro4.getValueAt(this.rSTableMetro4.getSelectedRow(), 0));
/*  8505 */     String[] datos = this.con.regresaReg("tipo,estatus,comentario,guias", "formacion", "where num=" + num, 4);
/*  8506 */     this.jTextArea3.setText("-Estas son las observaciones-\n");
/*  8507 */     this.jTextArea3.setText(this.jTextArea3.getText() + this.jTextArea3.getText() + "\n");
/*  8508 */     this.jTextArea3.setText(this.jTextArea3.getText() + this.jTextArea3.getText() + "\n");
/*  8509 */     this.jTextArea3.setText(this.jTextArea3.getText() + "Guia: " + this.jTextArea3.getText() + "\n");
/*  8510 */     this.jTextArea3.setText(this.jTextArea3.getText() + this.jTextArea3.getText() + "\n");
/*       */   }
/*       */   
/*       */   private void rSTableMetro5MouseClicked(MouseEvent evt) {
/*  8514 */     if (evt.getClickCount() == 2) {
/*  8515 */       String id = String.valueOf(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 5));
/*  8516 */       this.con.consultar("comentario", "formacion", "where num= " + id);
/*  8517 */       this.jTextArea5.setText(this.con.Campo);
/*  8518 */       this.jLabel105.setText(String.valueOf(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 4)));
/*  8519 */       this.jLabel31.setText(String.valueOf(this.rSTableMetro5.getValueAt(this.rSTableMetro5.getSelectedRow(), 1)));
/*  8520 */       this.jDialog10.setVisible(true);
/*       */     } 
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void rSTableMetro5KeyPressed(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void rSTableMetro5KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void rSTableMetro6MouseClicked(MouseEvent evt) {
/*  8533 */     if (evt.getClickCount() == 2) {
/*  8534 */       String id = String.valueOf(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 5));
/*  8535 */       this.con.consultar("comentario", "formacion", "where num= " + id);
/*  8536 */       this.jTextArea5.setText(this.con.Campo);
/*  8537 */       this.jLabel105.setText(String.valueOf(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 4)));
/*  8538 */       this.jLabel31.setText(String.valueOf(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 1)));
/*  8539 */       this.jDialog10.setVisible(true);
/*       */     } 
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void rSTableMetro6KeyPressed(KeyEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void rSTableMetro6KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void metroTextBox1KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void metroTextBox1CaretUpdate(CaretEvent evt) {
/*  8556 */     consultar2();
/*       */   }
/*       */   
/*       */   private void metroTextBox2CaretUpdate(CaretEvent evt) {
/*  8560 */     consultar2();
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void metroTextBox2KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jLabel111MouseEntered(MouseEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jLabel111MouseClicked(MouseEvent evt) {
/*  8572 */     if (Desktop.isDesktopSupported()) {
/*  8573 */       Desktop desktop = Desktop.getDesktop();
/*  8574 */       if (desktop.isSupported(Desktop.Action.BROWSE)) {
/*       */         try {
/*  8576 */           URI uri = new URI("http://www.forsis.com.mx");
/*  8577 */           desktop.browse(uri);
/*  8578 */         } catch (URISyntaxException|IOException ex) {
/*  8579 */           Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, (String)null, ex);
/*       */         } 
/*       */       }
/*       */     } 
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jRadioButtonMenuItem1ActionPerformed(ActionEvent evt) {
/*       */     try {
/*  8589 */       BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Layout.color"), "utf-8"));
/*  8590 */       out.write("ROJO\n");
/*  8591 */       out.write("246,60,60\n");
/*  8592 */       out.write("237,107,107\n");
/*  8593 */       out.write("102,102,102\n");
/*  8594 */       out.write("189,189,189\n");
/*  8595 */       out.write("255,255,255\n");
/*  8596 */       out.write("255,200,0\n");
/*  8597 */       out.write("239,239,239\n");
/*  8598 */       out.write("200,200,200\n");
/*  8599 */       out.close();
/*  8600 */     } catch (FileNotFoundException ex) {
/*  8601 */       Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, (String)null, ex);
/*  8602 */     } catch (UnsupportedEncodingException ex) {
/*  8603 */       Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, (String)null, ex);
/*  8604 */     } catch (IOException ex) {
/*  8605 */       Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, (String)null, ex);
/*       */     } 
/*  8607 */     JOptionPane.showMessageDialog(this, "Los datos han sido actualizados, el tema será aplicado después de reiniciar el sistema.", "Tema cambiado", 0, this.INFO);
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jRadioButtonMenuItem2ActionPerformed(ActionEvent evt) {
/*       */     try {
/*  8614 */       BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Layout.color"), "utf-8"));
/*  8615 */       out.write("VERDE\n");
/*  8616 */       out.write("0,177,101\n");
/*  8617 */       out.write("133,219,91\n");
/*  8618 */       out.write("0,118,75\n");
/*  8619 */       out.write("124,230,153\n");
/*  8620 */       out.write("255,255,255\n");
/*  8621 */       out.write("136,241,0\n");
/*  8622 */       out.write("211,255,200\n");
/*  8623 */       out.write("141,241,255\n");
/*  8624 */       out.close();
/*  8625 */     } catch (FileNotFoundException ex) {
/*  8626 */       Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, (String)null, ex);
/*  8627 */     } catch (UnsupportedEncodingException ex) {
/*  8628 */       Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, (String)null, ex);
/*  8629 */     } catch (IOException ex) {
/*  8630 */       Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, (String)null, ex);
/*       */     } 
/*  8632 */     JOptionPane.showMessageDialog(this, "Los datos han sido actualizados, el tema será aplicado después de reiniciar el sistema.", "Tema cambiado", 0, this.INFO);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   private void jRadioButtonMenuItem3ActionPerformed(ActionEvent evt) {
/*       */     try {
/*  8655 */       BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Layout.color"), "utf-8"));
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
/*  8666 */       out.write("AZUL\n");
/*  8667 */       out.write("0,102,153\n");
/*  8668 */       out.write("119,194,185\n");
/*  8669 */       out.write("3,143,244\n");
/*  8670 */       out.write("153,204,255\n");
/*  8671 */       out.write("255,255,255\n");
/*  8672 */       out.write("87,248,144\n");
/*  8673 */       out.write("194,229,237\n");
/*  8674 */       out.write("204,204,255\n");
/*  8675 */       out.close();
/*  8676 */     } catch (FileNotFoundException ex) {
/*  8677 */       Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, (String)null, ex);
/*  8678 */     } catch (UnsupportedEncodingException ex) {
/*  8679 */       Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, (String)null, ex);
/*  8680 */     } catch (IOException ex) {
/*  8681 */       Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, (String)null, ex);
/*       */     } 
/*  8683 */     JOptionPane.showMessageDialog(this, "Los datos han sido actualizados, el tema será aplicado después de reiniciar el sistema.", "Tema cambiado", 0, this.INFO);
/*       */   }
/*       */   
/*       */   private void jPasswordField1KeyReleased(KeyEvent evt) {
/*  8687 */     boolean capsActivo = Toolkit.getDefaultToolkit().getLockingKeyState(20);
/*  8688 */     if (capsActivo) {
/*  8689 */       this.jLabel8.setText("Mayúsculas activadas");
/*       */     } else {
/*  8691 */       this.jLabel8.setText(" ");
/*       */     } 
/*  8693 */     this.jFrame1.repaint();
/*       */   }
/*       */   
/*       */   private void jPasswordField2KeyReleased(KeyEvent evt) {
/*  8697 */     boolean capsActivo = Toolkit.getDefaultToolkit().getLockingKeyState(20);
/*  8698 */     if (capsActivo) {
/*  8699 */       this.jLabel10.setText("Mayúsculas activadas");
/*       */     } else {
/*  8701 */       this.jLabel10.setText(" ");
/*       */     } 
/*  8703 */     this.jDialog1.repaint();
/*       */   }
/*       */   
/*       */   private void jPasswordField3KeyReleased(KeyEvent evt) {
/*  8707 */     boolean capsActivo = Toolkit.getDefaultToolkit().getLockingKeyState(20);
/*  8708 */     if (capsActivo) {
/*  8709 */       this.jLabel10.setText("Mayúsculas activadas");
/*       */     } else {
/*  8711 */       this.jLabel10.setText(" ");
/*       */     } 
/*  8713 */     this.jDialog1.repaint();
/*       */   }
/*       */   
/*       */   private void jLabel147MouseClicked(MouseEvent evt) {
/*  8717 */     provCuentasBancarias();
/*       */   }
/*       */   
/*       */   private void jLabel147MouseEntered(MouseEvent evt) {
/*  8721 */     ingresaMouse(this.jLabel147, this.jPanel169);
/*       */   }
/*       */   
/*       */   private void jLabel147MouseExited(MouseEvent evt) {
/*  8725 */     saleMouse(this.jLabel147, this.jPanel169);
/*       */   }
/*       */   
/*       */   private void jLabel148MouseClicked(MouseEvent evt) {
/*  8729 */     Proveedores();
/*       */   }
/*       */   
/*       */   private void jLabel148MouseEntered(MouseEvent evt) {
/*  8733 */     ingresaMouse(this.jLabel148, this.jPanel170);
/*       */   }
/*       */   
/*       */   private void jLabel148MouseExited(MouseEvent evt) {
/*  8737 */     saleMouse(this.jLabel148, this.jPanel170);
/*       */   }
/*       */   
/*       */   private void jLabel149MouseClicked(MouseEvent evt) {
/*  8741 */     provFacturas();
/*       */   }
/*       */   
/*       */   private void jLabel149MouseExited(MouseEvent evt) {
/*  8745 */     saleMouse(this.jLabel149, this.jPanel172);
/*       */   }
/*       */   
/*       */   private void jLabel149MouseEntered(MouseEvent evt) {
/*  8749 */     ingresaMouse(this.jLabel149, this.jPanel172);
/*       */   }
/*       */   
/*       */   private void jLabel150MouseClicked(MouseEvent evt) {
/*  8753 */     provTarjetaDeudor();
/*       */   }
/*       */   
/*       */   private void jLabel150MouseExited(MouseEvent evt) {
/*  8757 */     saleMouse(this.jLabel150, this.jPanel173);
/*       */   }
/*       */   
/*       */   private void jLabel150MouseEntered(MouseEvent evt) {
/*  8761 */     ingresaMouse(this.jLabel150, this.jPanel173);
/*       */   }
/*       */   
/*       */   private void jLabel151MouseClicked(MouseEvent evt) {
/*  8765 */     if (existenDatos()) {
/*  8766 */       this.jTabbedPane2.removeAll();
/*  8767 */       this.jTabbedPane2.addTab("Pago a Proveedores", this.jPanel179);
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jLabel151MouseExited(MouseEvent evt) {
/*  8772 */     saleMouse(this.jLabel151, this.jPanel175);
/*       */   }
/*       */   
/*       */   private void jLabel151MouseEntered(MouseEvent evt) {
/*  8776 */     ingresaMouse(this.jLabel151, this.jPanel175);
/*       */   }
/*       */   
/*       */   private void jMenuItem70ActionPerformed(ActionEvent evt) {
/*  8780 */     provCuentasBancarias();
/*       */   }
/*       */   
/*       */   private void jMenuItem71ActionPerformed(ActionEvent evt) {
/*  8784 */     Proveedores();
/*       */   }
/*       */   
/*       */   private void jLabel12MouseClicked(MouseEvent evt) {
/*  8788 */     setCursor(new Cursor(3));
/*  8789 */     if (this.cheques == null) {
/*  8790 */       this.cheques = new ProvCheques(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry, this.jLabel36, this.CAMPOSGENERALES, false);
/*       */     } else {
/*  8792 */       this.cheques.cheques(this.USUARIO);
/*       */     } 
/*  8794 */     this.jTabbedPane2.addTab("Póliza de Cheques", this.jScrollPane1);
/*  8795 */     cargarMouse();
/*  8796 */     this.jTabbedPane2.setSelectedIndex(1);
/*       */   }
/*       */   
/*       */   private void jLabel12MouseExited(MouseEvent evt) {
/*  8800 */     this.jPanel181.setBackground(this.lc.SECUNDARIO2);
/*  8801 */     this.jPanel181.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/*  8802 */     this.jLabel13.setForeground(this.lc.PRIMARIO1);
/*       */   }
/*       */   
/*       */   private void jLabel12MouseEntered(MouseEvent evt) {
/*  8806 */     this.jPanel181.setBackground(this.lc.PRIMARIO2);
/*  8807 */     this.jPanel181.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO1));
/*  8808 */     this.jLabel13.setForeground(Color.WHITE);
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jPanel181MouseExited(MouseEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jPanel181MouseEntered(MouseEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jLabel59MouseClicked(MouseEvent evt) {
/*  8820 */     setCursor(new Cursor(3));
/*  8821 */     if (this.transferencias == null) {
/*  8822 */       this.transferencias = new ProvTransferencias(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry, this.jLabel36, this.CAMPOSGENERALES, false);
/*       */     } else {
/*  8824 */       this.transferencias.transferencias(this.USUARIO);
/*       */     } 
/*  8826 */     this.jTabbedPane2.addTab("Transferencias", this.jScrollPane1);
/*  8827 */     cargarMouse();
/*  8828 */     this.jTabbedPane2.setSelectedIndex(1);
/*       */   }
/*       */   
/*       */   private void jLabel59MouseEntered(MouseEvent evt) {
/*  8832 */     this.jPanel182.setBackground(this.lc.PRIMARIO2);
/*  8833 */     this.jPanel182.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO1));
/*  8834 */     this.jLabel60.setForeground(Color.WHITE);
/*       */   }
/*       */   
/*       */   private void jLabel59MouseExited(MouseEvent evt) {
/*  8838 */     this.jPanel182.setBackground(this.lc.SECUNDARIO2);
/*  8839 */     this.jPanel182.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/*  8840 */     this.jLabel60.setForeground(this.lc.PRIMARIO1);
/*       */   }
/*       */   
/*       */   private void jMenuItem72ActionPerformed(ActionEvent evt) {
/*  8844 */     provFacturas();
/*       */   }
/*       */   
/*       */   private void jMenuItem76ActionPerformed(ActionEvent evt) {
/*  8848 */     provTarjetaDeudor();
/*       */   }
/*       */   
/*       */   private void jMenuItem74ActionPerformed(ActionEvent evt) {
/*  8852 */     if (existenDatos()) {
/*  8853 */       this.jTabbedPane2.removeAll();
/*  8854 */       this.jTabbedPane2.addTab("Pago a Proveedores", this.jPanel179);
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jLabel101MouseClicked(MouseEvent evt) {
/*  8859 */     if (existenDatos()) {
/*  8860 */       setCursor(new Cursor(3));
/*  8861 */       this.jTabbedPane2.removeAll();
/*  8862 */       if (this.unidadesR == null) {
/*  8863 */         this.unidadesR = new UnidadesRemolques(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry, this.jLabel36, this.CAMPOSGENERALES, false);
/*       */       } else {
/*  8865 */         this.unidadesR.remolque(this.USUARIO);
/*       */       } 
/*  8867 */       this.jTabbedPane2.addTab("Remolques", this.jScrollPane1);
/*  8868 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jLabel101MouseExited(MouseEvent evt) {
/*  8873 */     saleMouse(this.jLabel101, this.jPanel176);
/*       */   }
/*       */   
/*       */   private void jLabel101MouseEntered(MouseEvent evt) {
/*  8877 */     ingresaMouse(this.jLabel101, this.jPanel176);
/*       */   }
/*       */   
/*       */   private void jLabel62MouseDragged(MouseEvent evt) {
/*  8881 */     int x = evt.getXOnScreen();
/*  8882 */     int y = evt.getYOnScreen();
/*  8883 */     this.jDialog11.setLocation(x - this.xx, y - this.xy);
/*       */   }
/*       */   
/*       */   private void jLabel62MouseClicked(MouseEvent evt) {
/*  8887 */     this.xx = evt.getX();
/*  8888 */     this.xy = evt.getY();
/*       */   }
/*       */   
/*       */   private void jLabel152MouseClicked(MouseEvent evt) {
/*  8892 */     this.jDialog5.setVisible(false);
/*       */   }
/*       */   
/*       */   private void jLabel152MouseEntered(MouseEvent evt) {
/*  8896 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*       */   }
/*       */   
/*       */   private void jLabel152MouseExited(MouseEvent evt) {
/*  8900 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*       */   }
/*       */   
/*       */   private void materialButton39ActionPerformed(ActionEvent evt) {
/*  8904 */     String contenido = "";
/*  8905 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++)
/*       */     {
/*       */ 
/*       */ 
/*       */       
/*  8910 */       contenido = contenido + "ECO " + contenido + " - " + String.valueOf(this.rSTableMetro1.getValueAt(i, 1)) + " - " + String.valueOf(this.rSTableMetro1.getValueAt(i, 2)) + "\n";
/*       */     }
/*  8912 */     String asunto = "Documentación por vencer";
/*  8913 */     String textoDesc = "Se adjunta la información completa de los documentos vencidos o por vencer: \n\n" + contenido;
/*  8914 */     String archivo = "DocVencidos_" + LocalDate.now().toString() + ".png";
/*  8915 */     this.utilerias.capturarImagen(this.jDialog11, archivo);
/*  8916 */     EnviarCorreo correo = new EnviarCorreo(this, asunto, textoDesc, this.USUARIO, archivo);
/*       */   }
/*       */   
/*       */   private void materialButton40ActionPerformed(ActionEvent evt) {
/*  8920 */     String[] datos = { "ID", "TIPO", "ECO", "DOCUMENTO", "TRÁMITE", "NÚMERO", "PERIODO", "VENCIIENTO" };
/*       */ 
/*       */     
/*  8923 */     this.esc = new EscribirReporte("DOCUMENTOS POR VENCER", (JTable)this.rSTableMetro1, datos, this.USUARIO);
/*       */   }
/*       */   
/*       */   private void materialButton38ActionPerformed(ActionEvent evt) {
/*  8927 */     this.jDialog11.setVisible(false);
/*       */   }
/*       */   
/*       */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/*  8931 */     int ind = this.rSTableMetro1.getSelectedRow();
/*  8932 */     if (evt.getClickCount() == 2) {
/*  8933 */       String valor = this.rSTableMetro1.getValueAt(ind, 0).toString();
/*  8934 */       if (!valor.contains("FACTURA") || this.PRIVILEGIOS.containsValue(this.CAMPOSGENERALES.get("priv"))) {
/*  8935 */         UnidadesTractosDoc unidad = new UnidadesTractosDoc(this, true, this.rSTableMetro1, this.CAMPOSGENERALES, null, this.rSTableMetro1.getValueAt(ind, 3).toString(), "VISUALIZAR");
/*  8936 */         unidad.recibeTipoV(this.rSTableMetro1.getValueAt(ind, 1).toString());
/*  8937 */         unidad.consultarDoc(this.rSTableMetro1.getValueAt(ind, 0).toString());
/*  8938 */         unidad.desabilitar();
/*  8939 */         unidad.activarVentana();
/*       */       } 
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jLabel153MouseClicked(MouseEvent evt) {
/*  8949 */     clicTractos();
/*       */   }
/*       */   
/*       */   private void jLabel153MouseEntered(MouseEvent evt) {
/*  8953 */     ingresaMouse(this.jLabel153, this.jPanel187);
/*       */   }
/*       */   
/*       */   private void jLabel153MouseExited(MouseEvent evt) {
/*  8957 */     saleMouse(this.jLabel153, this.jPanel187);
/*       */   }
/*       */   
/*       */   private void jLabel154MouseClicked(MouseEvent evt) {
/*  8961 */     clicDollys();
/*       */   }
/*       */   
/*       */   private void jLabel154MouseEntered(MouseEvent evt) {
/*  8965 */     ingresaMouse(this.jLabel154, this.jPanel188);
/*       */   }
/*       */   
/*       */   private void jLabel154MouseExited(MouseEvent evt) {
/*  8969 */     saleMouse(this.jLabel154, this.jPanel188);
/*       */   }
/*       */   
/*       */   private void jLabel155MouseClicked(MouseEvent evt) {
/*  8973 */     clicUtilitarios();
/*       */   }
/*       */   
/*       */   private void jLabel155MouseEntered(MouseEvent evt) {
/*  8977 */     ingresaMouse(this.jLabel155, this.jPanel189);
/*       */   }
/*       */   
/*       */   private void jLabel155MouseExited(MouseEvent evt) {
/*  8981 */     saleMouse(this.jLabel155, this.jPanel189);
/*       */   }
/*       */   
/*       */   private void jLabel156MouseClicked(MouseEvent evt) {
/*  8985 */     clientes();
/*       */   }
/*       */   
/*       */   private void jLabel156MouseEntered(MouseEvent evt) {
/*  8989 */     ingresaMouse(this.jLabel156, this.jPanel191);
/*       */   }
/*       */   
/*       */   private void jLabel156MouseExited(MouseEvent evt) {
/*  8993 */     saleMouse(this.jLabel156, this.jPanel191);
/*       */   }
/*       */   
/*       */   private void jLabel157MouseClicked(MouseEvent evt) {
/*  8997 */     if (this.jLabel157.isEnabled()) {
/*  8998 */       agregarGeneradora();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jLabel157MouseEntered(MouseEvent evt) {
/*  9003 */     ingresaMouse(this.jLabel157, this.jPanel192);
/*       */   }
/*       */   
/*       */   private void jLabel157MouseExited(MouseEvent evt) {
/*  9007 */     saleMouse(this.jLabel157, this.jPanel192);
/*       */   }
/*       */   
/*       */   private void jLabel158MouseClicked(MouseEvent evt) {
/*  9011 */     if (existenDatos()) {
/*  9012 */       setCursor(new Cursor(3));
/*  9013 */       this.jTabbedPane2.removeAll();
/*  9014 */       if (this.destinos == null) {
/*  9015 */         this.destinos = new tras_Destinos(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry, this.jLabel36, this.CAMPOSGENERALES, false, this.LISTACODIGOS, this.CODIGOSP);
/*       */       } else {
/*  9017 */         this.destinos.destinos(this.USUARIO);
/*       */       } 
/*  9019 */       this.jTabbedPane2.addTab("Destinos", this.jScrollPane1);
/*  9020 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jLabel158MouseEntered(MouseEvent evt) {
/*  9025 */     ingresaMouse(this.jLabel158, this.jPanel193);
/*       */   }
/*       */   
/*       */   private void jLabel158MouseExited(MouseEvent evt) {
/*  9029 */     saleMouse(this.jLabel158, this.jPanel193);
/*       */   }
/*       */   
/*       */   private void jLabel64MouseClicked(MouseEvent evt) {
/*  9033 */     if (this.facturas == null) {
/*  9034 */       this.facturas = new Facturas(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry);
/*       */     } else {
/*  9036 */       this.facturas.Facturas(this.USUARIO);
/*       */     } 
/*  9038 */     this.jTabbedPane2.addTab("Facturas versión 3.2", this.jScrollPane1);
/*  9039 */     this.jTabbedPane2.setSelectedIndex(1);
/*       */   }
/*       */   
/*       */   private void jLabel64MouseEntered(MouseEvent evt) {
/*  9043 */     this.jPanel195.setBackground(this.lc.PRIMARIO2);
/*  9044 */     this.jPanel195.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO1));
/*  9045 */     this.jLabel64.setForeground(Color.WHITE);
/*       */   }
/*       */   
/*       */   private void jLabel64MouseExited(MouseEvent evt) {
/*  9049 */     this.jPanel195.setBackground(this.lc.SECUNDARIO2);
/*  9050 */     this.jPanel195.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/*  9051 */     this.jLabel64.setForeground(this.lc.PRIMARIO1);
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jPanel195MouseExited(MouseEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jPanel195MouseEntered(MouseEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jLabel160MouseClicked(MouseEvent evt) {
/*  9063 */     setCursor(new Cursor(3));
/*  9064 */     if (this.facturas33 == null) {
/*  9065 */       this.facturas33 = new Facturas33(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.CAMPOSGENERALES, false);
/*       */     } else {
/*  9067 */       this.facturas33.Facturas33(this.USUARIO);
/*       */     } 
/*  9069 */     this.jTabbedPane2.addTab("Facturas versión 3.3", this.jScrollPane1);
/*  9070 */     cargarMouse();
/*  9071 */     this.jTabbedPane2.setSelectedIndex(1);
/*       */   }
/*       */   
/*       */   private void jLabel160MouseEntered(MouseEvent evt) {
/*  9075 */     this.jPanel196.setBackground(this.lc.PRIMARIO2);
/*  9076 */     this.jPanel196.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO1));
/*  9077 */     this.jLabel160.setForeground(Color.WHITE);
/*       */   }
/*       */   
/*       */   private void jLabel160MouseExited(MouseEvent evt) {
/*  9081 */     this.jPanel196.setBackground(this.lc.SECUNDARIO2);
/*  9082 */     this.jPanel196.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/*  9083 */     this.jLabel160.setForeground(this.lc.PRIMARIO1);
/*       */   }
/*       */ 
/*       */   
/*       */   private void jButton1ActionPerformed(ActionEvent evt) {
/*  9088 */     String serie = JOptionPane.showInputDialog("Serie");
/*  9089 */     String dir = "https://www.banxico.org.mx/SieAPIRest/service/v1/series/" + serie + "/datos/2024-10-25/2024-10-25";
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
/*       */   private void jLabel163MouseClicked(MouseEvent evt) {
/*  9103 */     if (this.jLabel152.isEnabled()) {
/*  9104 */       setCursor(new Cursor(3));
/*  9105 */       if (this.compras == null) {
/*  9106 */         this.jTabbedPane2.removeAll();
/*  9107 */         this.compras = new Compras(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.CAMPOSGENERALES, false);
/*       */       } else {
/*  9109 */         this.jTabbedPane2.removeAll();
/*  9110 */         this.compras.compras(this.USUARIO);
/*       */       } 
/*  9112 */       this.jTabbedPane2.addTab("Compras", this.jScrollPane1);
/*  9113 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jLabel163MouseEntered(MouseEvent evt) {
/*  9118 */     ingresaMouse(this.jLabel163, this.jPanel205);
/*       */   }
/*       */   
/*       */   private void jLabel163MouseExited(MouseEvent evt) {
/*  9122 */     saleMouse(this.jLabel163, this.jPanel205);
/*       */   }
/*       */   
/*       */   private void jLabel177MouseClicked(MouseEvent evt) {
/*  9126 */     if (this.jLabel177.isEnabled()) {
/*  9127 */       setCursor(new Cursor(3));
/*  9128 */       if (this.productos == null) {
/*  9129 */         this.jTabbedPane2.removeAll();
/*  9130 */         this.productos = new AlmProductos(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.CAMPOSGENERALES, false);
/*       */       } else {
/*  9132 */         this.jTabbedPane2.removeAll();
/*  9133 */         this.productos.productos(this.USUARIO);
/*       */       } 
/*  9135 */       this.jTabbedPane2.addTab("Productos", this.jScrollPane1);
/*  9136 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jLabel177MouseEntered(MouseEvent evt) {
/*  9141 */     ingresaMouse(this.jLabel177, this.jPanel202);
/*       */   }
/*       */   
/*       */   private void jLabel177MouseExited(MouseEvent evt) {
/*  9145 */     saleMouse(this.jLabel177, this.jPanel202);
/*       */   }
/*       */   
/*       */   private void jLabel172MouseClicked(MouseEvent evt) {
/*  9149 */     if (this.jLabel172.isEnabled()) {
/*  9150 */       setCursor(new Cursor(3));
/*  9151 */       if (this.categorias == null) {
/*  9152 */         this.jTabbedPane2.removeAll();
/*  9153 */         this.categorias = new AlmCategorias(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.CAMPOSGENERALES, false);
/*       */       } else {
/*  9155 */         this.jTabbedPane2.removeAll();
/*  9156 */         this.categorias.categorias(this.USUARIO);
/*       */       } 
/*  9158 */       this.jTabbedPane2.addTab("Categorías", this.jScrollPane1);
/*  9159 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jLabel172MouseEntered(MouseEvent evt) {
/*  9164 */     ingresaMouse(this.jLabel172, this.jPanel185);
/*       */   }
/*       */   
/*       */   private void jLabel172MouseExited(MouseEvent evt) {
/*  9168 */     saleMouse(this.jLabel172, this.jPanel185);
/*       */   }
/*       */   
/*       */   private void jLabel173MouseClicked(MouseEvent evt) {
/*  9172 */     if (this.jLabel152.isEnabled()) {
/*  9173 */       setCursor(new Cursor(3));
/*  9174 */       if (this.almacen == null) {
/*  9175 */         this.jTabbedPane2.removeAll();
/*  9176 */         this.almacen = new AlmAlmacen(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.CAMPOSGENERALES, false);
/*       */       } else {
/*  9178 */         this.jTabbedPane2.removeAll();
/*  9179 */         this.almacen.almacen(this.USUARIO);
/*       */       } 
/*  9181 */       this.jTabbedPane2.addTab("Almacén", this.jScrollPane1);
/*  9182 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jLabel173MouseEntered(MouseEvent evt) {
/*  9187 */     ingresaMouse(this.jLabel173, this.jPanel186);
/*       */   }
/*       */   
/*       */   private void jLabel173MouseExited(MouseEvent evt) {
/*  9191 */     saleMouse(this.jLabel173, this.jPanel186);
/*       */   }
/*       */   
/*       */   public void ingresaMouse2(JPanel Fondo, JPanel Identificador) {
/*  9195 */     Fondo.setBackground(this.lc.SECUNDARIO2);
/*  9196 */     Fondo.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO1));
/*  9197 */     Identificador.setBackground(this.lc.SECUNDARIO1);
/*       */   }
/*       */   
/*       */   public void saleMouse2(JPanel Fondo, JPanel Identificador) {
/*  9201 */     Fondo.setBackground(this.lc.PRIMARIO1);
/*  9202 */     Fondo.setBorder((Border)null);
/*  9203 */     Identificador.setBackground(this.lc.PRIMARIO1);
/*       */   }
/*       */   
/*       */   public void ingresaMouse(JLabel Etiqueta, JPanel Fondo) {
/*  9207 */     Fondo.setBackground(this.lc.PRIMARIO2);
/*  9208 */     Etiqueta.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO2));
/*       */   }
/*       */   
/*       */   public void saleMouse(JLabel Etiqueta, JPanel Fondo) {
/*  9212 */     Fondo.setBackground(this.lc.PRIMARIO1);
/*  9213 */     Etiqueta.setBorder((Border)null);
/*       */   }
/*       */   
/*       */   public void clientes() {
/*  9217 */     if (existenDatos()) {
/*  9218 */       setCursor(new Cursor(3));
/*  9219 */       this.jTabbedPane2.removeAll();
/*  9220 */       if (this.clientes == null) {
/*  9221 */         this.clientes = new Clientes(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry, this.jLabel36, this.CAMPOSGENERALES, false, this.LISTACODIGOS, this.CODIGOSP);
/*       */       } else {
/*  9223 */         this.clientes.clientes(this.USUARIO);
/*       */       } 
/*  9225 */       this.jTabbedPane2.addTab("Clientes", this.jScrollPane1);
/*  9226 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void formacion() {
/*  9231 */     if (this.DEPA.equals("SUPER USUARIO") || this.DEPA.equals("GERENTE DE OPERACIONES")) {
/*  9232 */       this.materialButton6.setEnabled(true);
/*  9233 */       this.materialButton7.setEnabled(true);
/*       */     } else {
/*  9235 */       this.materialButton6.setEnabled(false);
/*  9236 */       this.materialButton7.setEnabled(false);
/*       */     } 
/*       */     
/*  9239 */     cambiarColor();
/*  9240 */     consultarForma();
/*  9241 */     this.jFrame2.setSize(700, 400);
/*  9242 */     this.jFrame2.setExtendedState(6);
/*  9243 */     this.jFrame2.setVisible(true);
/*       */   }
/*       */ 
/*       */   
/*       */   public void activarMenus() {
/*  9248 */     this.jPanel113.setVisible(false);
/*  9249 */     this.jMenuBar1.setVisible(true);
/*       */     
/*  9251 */     this.jTabbedPane2.setTabPlacement(1);
/*       */   }
/*       */   
/*       */   public void lineas() {
/*  9255 */     if (existenDatos()) {
/*  9256 */       setCursor(new Cursor(3));
/*  9257 */       this.jTabbedPane2.removeAll();
/*  9258 */       if (this.lineas == null) {
/*  9259 */         this.lineas = new Lineas(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this);
/*       */       } else {
/*  9261 */         this.lineas.Lineas(this.USUARIO);
/*       */       } 
/*  9263 */       this.jTabbedPane2.addTab("Líneas por cliente", this.jScrollPane1);
/*  9264 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   public void activarBarra() {
/*  9270 */     this.jPanel113.setVisible(true);
/*  9271 */     this.jMenuBar1.setVisible(false);
/*       */     
/*  9273 */     this.jTabbedPane2.setTabPlacement(3);
/*       */   }
/*       */   
/*       */   public void consultarHistorialForma() {
/*  9277 */     this.rSTableMetro4.setModel(new DefaultTableModel((Object[][])this.con
/*  9278 */           .buscarDatos(4, "num,operador,fecha,eco", "formacion", " order by num desc"), (Object[])new String[] { "ID", "Operador", "Fecha", "Eco" })
/*       */         {
/*       */ 
/*       */ 
/*       */           
/*  9283 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  9288 */             return this.canEdit[columnIndex];
/*       */           }
/*       */         });
/*       */     
/*  9292 */     this.rSTableMetro4.setShowVerticalLines(false);
/*  9293 */     this.rSTableMetro4.getColumnModel().getColumn(0).setMinWidth(50);
/*  9294 */     this.rSTableMetro4.getColumnModel().getColumn(0).setMaxWidth(50);
/*       */     
/*  9296 */     this.rSTableMetro4.getColumnModel().getColumn(2).setMinWidth(120);
/*  9297 */     this.rSTableMetro4.getColumnModel().getColumn(2).setMaxWidth(120);
/*       */     
/*  9299 */     this.rSTableMetro4.getColumnModel().getColumn(3).setMinWidth(50);
/*  9300 */     this.rSTableMetro4.getColumnModel().getColumn(3).setMaxWidth(50);
/*       */     
/*  9302 */     this.rSTableMetro4.setSelectionMode(0);
/*  9303 */     this.rSTableMetro4.setAutoCreateRowSorter(true);
/*  9304 */     this.rSTableMetro4.getTableHeader().setReorderingAllowed(false);
/*  9305 */     this.rSTableMetro4.getColumnModel().getColumn(0).setCellRenderer(this.celda4);
/*  9306 */     this.rSTableMetro4.getColumnModel().getColumn(1).setCellRenderer(this.celda4);
/*  9307 */     this.rSTableMetro4.getColumnModel().getColumn(2).setCellRenderer(this.celda4);
/*  9308 */     this.rSTableMetro4.getColumnModel().getColumn(3).setCellRenderer(this.celda4);
/*  9309 */     this.rSTableMetro4.setFont(new Font("Cantarell", 0, 10));
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public void consultarForma() {
/*  9316 */     this.rSTableMetro5.setModel(new DefaultTableModel((Object[][])this.con
/*  9317 */           .buscarDatos(5, "operador,fecha,eco,estatus,num", "formacion", "where activo=1 and tipo ='pipa' order by num asc"), (Object[])new String[] { "Operador", "Fecha", "Eco", "Estatus", "ID", "Num" })
/*       */         {
/*       */ 
/*       */ 
/*       */           
/*  9322 */           boolean[] canEdit = new boolean[] { 
/*       */               false, false, false, false, false, false, false, false, false, false, 
/*       */               false, false, false, false, false, false, false, false, false, false, 
/*       */               false };
/*       */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  9327 */             return this.canEdit[columnIndex];
/*       */           }
/*       */         });
/*       */     
/*  9331 */     this.rSTableMetro5.moveColumn(5, 0);
/*  9332 */     this.rSTableMetro5.setShowVerticalLines(false);
/*  9333 */     this.jScrollPane15.setViewportView((Component)this.rSTableMetro5);
/*  9334 */     cambiarColor();
/*  9335 */     this.rSTableMetro5.getColumnModel().getColumn(0).setMinWidth(50);
/*  9336 */     this.rSTableMetro5.getColumnModel().getColumn(0).setMaxWidth(50);
/*       */     
/*  9338 */     this.rSTableMetro5.getColumnModel().getColumn(3).setMinWidth(70);
/*  9339 */     this.rSTableMetro5.getColumnModel().getColumn(3).setMaxWidth(70);
/*       */     
/*  9341 */     this.rSTableMetro5.getColumnModel().getColumn(5).setMinWidth(50);
/*  9342 */     this.rSTableMetro5.getColumnModel().getColumn(5).setMaxWidth(50);
/*       */     
/*  9344 */     this.rSTableMetro5.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/*  9345 */     this.rSTableMetro5.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/*  9346 */     this.rSTableMetro5.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/*  9347 */     this.rSTableMetro5.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/*  9348 */     this.rSTableMetro5.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/*  9349 */     this.rSTableMetro5.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/*       */     
/*  9351 */     this.rSTableMetro5.setSelectionMode(0);
/*  9352 */     this.rSTableMetro5.setAutoCreateRowSorter(true);
/*  9353 */     this.rSTableMetro5.getTableHeader().setReorderingAllowed(false);
/*       */     int i;
/*  9355 */     for (i = 0; i < this.rSTableMetro5.getRowCount(); i++) {
/*  9356 */       this.rSTableMetro5.setValueAt(Integer.valueOf(i + 1), i, 0);
/*       */     }
/*       */     
/*  9359 */     this.rSTableMetro6.setModel(new DefaultTableModel((Object[][])this.con
/*  9360 */           .buscarDatos(5, "operador,fecha,eco,estatus,num", "formacion", "where activo=1 and tipo='gondola' order by num asc"), (Object[])new String[] { "Operador", "Fecha", "Eco", "Estatus", "ID", "Num" })
/*       */         {
/*       */ 
/*       */ 
/*       */           
/*  9365 */           boolean[] canEdit = new boolean[] { 
/*       */               false, false, false, false, false, false, false, false, false, false, 
/*       */               false, false, false, false, false, false, false, false, false, false, 
/*       */               false };
/*       */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  9370 */             return this.canEdit[columnIndex];
/*       */           }
/*       */         });
/*       */     
/*  9374 */     this.rSTableMetro6.moveColumn(5, 0);
/*  9375 */     this.rSTableMetro6.setShowVerticalLines(false);
/*  9376 */     this.jScrollPane16.setViewportView((Component)this.rSTableMetro6);
/*       */     
/*  9378 */     cambiarColor();
/*  9379 */     this.rSTableMetro6.getColumnModel().getColumn(0).setMinWidth(50);
/*  9380 */     this.rSTableMetro6.getColumnModel().getColumn(0).setMaxWidth(50);
/*       */     
/*  9382 */     this.rSTableMetro6.getColumnModel().getColumn(3).setMinWidth(70);
/*  9383 */     this.rSTableMetro6.getColumnModel().getColumn(3).setMaxWidth(70);
/*       */     
/*  9385 */     this.rSTableMetro6.getColumnModel().getColumn(5).setMinWidth(50);
/*  9386 */     this.rSTableMetro6.getColumnModel().getColumn(5).setMaxWidth(50);
/*       */     
/*  9388 */     this.rSTableMetro6.getColumnModel().getColumn(0).setCellRenderer(this.celda3);
/*  9389 */     this.rSTableMetro6.getColumnModel().getColumn(1).setCellRenderer(this.celda3);
/*  9390 */     this.rSTableMetro6.getColumnModel().getColumn(2).setCellRenderer(this.celda3);
/*  9391 */     this.rSTableMetro6.getColumnModel().getColumn(3).setCellRenderer(this.celda3);
/*  9392 */     this.rSTableMetro6.getColumnModel().getColumn(4).setCellRenderer(this.celda3);
/*  9393 */     this.rSTableMetro6.getColumnModel().getColumn(5).setCellRenderer(this.celda3);
/*       */     
/*  9395 */     this.rSTableMetro6.setSelectionMode(0);
/*  9396 */     this.rSTableMetro6.setAutoCreateRowSorter(true);
/*  9397 */     this.rSTableMetro6.getTableHeader().setReorderingAllowed(false);
/*       */     
/*  9399 */     for (i = 0; i < this.rSTableMetro6.getRowCount(); i++) {
/*  9400 */       this.rSTableMetro6.setValueAt(Integer.valueOf(i + 1), i, 0);
/*       */     }
/*       */     
/*  9403 */     this.rSTableMetro5.repaint();
/*  9404 */     this.rSTableMetro5.setRowHeight(50);
/*  9405 */     this.rSTableMetro6.repaint();
/*  9406 */     this.rSTableMetro6.setRowHeight(50);
/*       */   }
/*       */   
/*       */   public void clicTractos() {
/*  9410 */     if (existenDatos()) {
/*  9411 */       setCursor(new Cursor(3));
/*  9412 */       this.jTabbedPane2.removeAll();
/*  9413 */       if (this.unidadesT == null) {
/*  9414 */         this.unidadesT = new UnidadesTractos(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry, this.jLabel36, this.CAMPOSGENERALES, false);
/*       */       } else {
/*  9416 */         this.unidadesT.tracto(this.USUARIO);
/*       */       } 
/*  9418 */       this.jTabbedPane2.addTab("Tractos", this.jScrollPane1);
/*  9419 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void clicUtilitarios() {
/*  9424 */     if (existenDatos()) {
/*  9425 */       setCursor(new Cursor(3));
/*  9426 */       this.jTabbedPane2.removeAll();
/*  9427 */       if (this.unidadesU == null) {
/*  9428 */         this.unidadesU = new UnidadesUtilitarios(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry, this.jLabel36, this.CAMPOSGENERALES, false);
/*       */       } else {
/*  9430 */         this.unidadesU.utilitarios(this.USUARIO);
/*       */       } 
/*  9432 */       this.jTabbedPane2.addTab("Utilitarios", this.jScrollPane1);
/*  9433 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void clicDollys() {
/*  9438 */     if (existenDatos()) {
/*  9439 */       setCursor(new Cursor(3));
/*  9440 */       this.jTabbedPane2.removeAll();
/*  9441 */       if (this.unidadesD == null) {
/*  9442 */         this.unidadesD = new UnidadesDollys(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry, this.jLabel36, this.CAMPOSGENERALES, false);
/*       */       } else {
/*  9444 */         this.unidadesD.dollys(this.USUARIO);
/*       */       } 
/*  9446 */       this.jTabbedPane2.addTab("Dollys", this.jScrollPane1);
/*  9447 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public static int restarFechas(Date fechaInicial, Date fechaFinal) {
/*  9452 */     DateFormat df = DateFormat.getDateInstance(2);
/*  9453 */     String fechaInicioString = df.format(fechaInicial);
/*       */     try {
/*  9455 */       fechaInicial = df.parse(fechaInicioString);
/*  9456 */     } catch (ParseException parseException) {}
/*       */     
/*  9458 */     String fechaFinalString = df.format(fechaFinal);
/*       */     try {
/*  9460 */       fechaFinal = df.parse(fechaFinalString);
/*  9461 */     } catch (ParseException parseException) {}
/*       */     
/*  9463 */     long fechaInicialMs = fechaInicial.getTime();
/*  9464 */     long fechaFinalMs = fechaFinal.getTime();
/*  9465 */     long diferencia = fechaFinalMs - fechaInicialMs;
/*  9466 */     double dias = Math.floor((diferencia / 86400000L));
/*  9467 */     return (int)dias;
/*       */   }
/*       */   
/*       */   public void validarFecha(String fecha) {
/*  9471 */     this.BLOQUEADO = false;
/*  9472 */     String fechita = fecha;
/*  9473 */     String año = fechita.substring(0, 4);
/*  9474 */     String mes = fechita.substring(5, 7);
/*  9475 */     String dia = fechita.substring(8, 10);
/*       */     
/*  9477 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  9478 */     String strFecha = dia + "-" + dia + "-" + mes;
/*  9479 */     Date fechaLicen = null;
/*       */     try {
/*  9481 */       fechaLicen = formatoDelTexto.parse(strFecha);
/*  9482 */     } catch (ParseException ex) {
/*  9483 */       ex.printStackTrace();
/*       */     } 
/*  9485 */     Date fechaAc = new Date();
/*  9486 */     this.DIASVENCIDOS = restarFechas(fechaLicen, fechaAc);
/*  9487 */     int DD = -1 * this.DIASVENCIDOS;
/*  9488 */     if (this.DIASVENCIDOS < 0 && this.DIASVENCIDOS > -31) {
/*  9489 */       this.jDialog8.setTitle("Licencia está por vencerse");
/*  9490 */       this.jLabel97.setText("Próximo Vencimiento de Licencia");
/*  9491 */       this.jLabel98.setText("<html><center>LA LICENCIA DEL OPERADOR QUE SELECCIONASTE ESTÁ PRÓXIMA A VENCER.</center></html>");
/*  9492 */       this.jLabel99.setText("<html><center>La vigencia de la licencia caducará en " + DD + " días, si no se renueva no se podrá dar viajes en éste módulo.</center></html>");
/*  9493 */       this.jDialog8.setVisible(true);
/*  9494 */     } else if (this.DIASVENCIDOS > 0 && this.DIASVENCIDOS < 15) {
/*  9495 */       this.jDialog8.setTitle("Licencia Vencida");
/*  9496 */       this.jLabel97.setText("Actualizar Licencia");
/*  9497 */       this.jLabel98.setText("<html><center>LA LICENCIA ESTÁ VENCIDA Y NECESITA ACTUALIZARLA.</center></html>");
/*  9498 */       this.jLabel99.setText("<html><center>El operador que seleccionaste cuenta con una licencia vencida, necesita actualizarla ya que sino lo hace, quedará bloquedo dentro de " + 15 - this.DIASVENCIDOS + " días.</center></html>");
/*  9499 */       this.jDialog8.setVisible(true);
/*  9500 */       this.BLOQUEADO = true;
/*  9501 */     } else if (this.DIASVENCIDOS > 15) {
/*  9502 */       this.jDialog8.setTitle("Licencia Vencida");
/*  9503 */       this.jLabel97.setText("Operador Bloqueado");
/*  9504 */       this.jLabel98.setText("<html><center>LICENCIA VENCIDA.</center></html>");
/*  9505 */       this.jLabel99.setText("<html><center>El operador ha sido bloqueado por no actualizar su licencia, no se podrá dar viajes hasta que refrende éste documento.</center></html>");
/*  9506 */       this.jDialog8.setVisible(true);
/*  9507 */       this.BLOQUEADO = true;
/*       */     } 
/*       */   }
/*       */   
/*       */   public void cargarOperador() {
/*  9512 */     String tipo = "GONDOLA";
/*  9513 */     if (this.jRadioButton1.isSelected()) {
/*  9514 */       tipo = "PIPA";
/*       */     }
/*  9516 */     boolean agregar = false;
/*       */     
/*  9518 */     String clave = String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 0));
/*  9519 */     if (this.jRadioButton1.isSelected()) {
/*  9520 */       this.encontrado = this.con.consultar("claveOP", "formacion", "where claveOP =" + clave + " and activo = 1 and tipo='PIPA'");
/*  9521 */       if (this.encontrado) {
/*  9522 */         JOptionPane.showMessageDialog(this.jDialog5, "El operador que deseas agregar ya se encuentra almacenado en PIPAS", "Operador en formación", 0, this.ERROR);
/*       */       } else {
/*  9524 */         this.encontrado = this.con.consultar("claveOP", "formacion", "where claveOP =" + clave + " and activo = 1 and tipo='GONDOLA'");
/*  9525 */         if (this.encontrado) {
/*  9526 */           int res = JOptionPane.showConfirmDialog(this.jDialog5, "El operador que deseas agregar ya se encuentra almacenado en GONDOLAS\n¿Deseas quitarlo de la lista de GÓNDOLAS y agregarlo a la lista de PIPAS?", "Mover operador de lista", 0, 3, this.PREG);
/*  9527 */           if (res == 0) {
/*  9528 */             res = JOptionPane.showConfirmDialog(this.jDialog5, "¿Deseas respetar su horario de formación?\nSi seleccionar SI, el operador será agregado en el horario que le corresponde, selecciona NO para moverlo al final de la lista.", "Ubicación del operador", 0, 3, this.PREG);
/*  9529 */             if (res == 0) {
/*  9530 */               this.con.consultar("fecha_licen", "operadores", "where num_ope = " + this.con.Campo);
/*  9531 */               String fecha = this.con.Campo;
/*  9532 */               validarFecha(fecha);
/*  9533 */               if (!this.BLOQUEADO) {
/*  9534 */                 this.con.inserSinMsj("update formacion set tipo='PIPA' where claveOP= " + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 0)) + " and activo=1");
/*  9535 */                 consultarForma();
/*  9536 */                 this.jDialog5.setVisible(false);
/*       */               } 
/*       */             } else {
/*  9539 */               this.con.consultar("fecha_licen", "operadores", "where num_ope = " + this.con.Campo);
/*  9540 */               String fecha = this.con.Campo;
/*  9541 */               validarFecha(fecha);
/*       */               
/*  9543 */               if (!this.BLOQUEADO) {
/*  9544 */                 this.con.inserSinMsj("update formacion set tipo='PIPA', fecha=now() where claveOP= " + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 0)) + " and activo=1");
/*  9545 */                 consultarForma();
/*  9546 */                 this.jDialog5.setVisible(false);
/*       */               } 
/*       */             } 
/*       */           } 
/*       */         } else {
/*  9551 */           agregar = true;
/*       */         } 
/*       */       } 
/*       */     } else {
/*  9555 */       this.encontrado = this.con.consultar("claveOP", "formacion", "where claveOP =" + clave + " and activo = 1 and tipo='GONDOLA'");
/*  9556 */       if (this.encontrado) {
/*  9557 */         JOptionPane.showMessageDialog(this.jDialog5, "El operador que deseas agregar ya se encuentra almacenado en GONDOLAS", "Operador en formación", 0, this.ERROR);
/*       */       } else {
/*  9559 */         this.encontrado = this.con.consultar("claveOP", "formacion", "where claveOP =" + clave + " and activo = 1 and tipo='PIPA'");
/*  9560 */         if (this.encontrado) {
/*  9561 */           int res = JOptionPane.showConfirmDialog(this.jDialog5, "El operador que deseas agregar ya se encuentra almacenado en GONGOLAS\n¿Deseas quitarlo de la lista de PIPAS y agregarlo a la lista de GÓNDOLAS?", "Mover operador de lista", 0, 3, this.PREG);
/*  9562 */           if (res == 0) {
/*  9563 */             res = JOptionPane.showConfirmDialog(this.jDialog5, "¿Deseas respetar su horario de formación?\nSi seleccionar SI, el operador será agregado en el horario que le corresponde, selecciona NO, para moverlo al final de la lista.", "Ubicación del operador", 0, 3, this.PREG);
/*  9564 */             if (res == 0) {
/*  9565 */               this.con.consultar("fecha_licen", "operadores", "where num_ope = " + this.con.Campo);
/*  9566 */               String fecha = this.con.Campo;
/*  9567 */               validarFecha(fecha);
/*       */               
/*  9569 */               if (!this.BLOQUEADO) {
/*  9570 */                 this.con.inserSinMsj("update formacion set tipo='GONDOLA' where claveOP= " + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 0)) + " and activo=1");
/*  9571 */                 consultarForma();
/*  9572 */                 this.jDialog5.setVisible(false);
/*       */               } 
/*       */             } else {
/*  9575 */               this.con.consultar("fecha_licen", "operadores", "where num_ope = " + this.con.Campo);
/*  9576 */               String fecha = this.con.Campo;
/*  9577 */               validarFecha(fecha);
/*       */               
/*  9579 */               if (!this.BLOQUEADO) {
/*  9580 */                 this.con.inserSinMsj("update formacion set tipo='GONDOLA',fecha=now() where claveOP= " + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 0)) + " and activo=1");
/*  9581 */                 consultarForma();
/*  9582 */                 this.jDialog5.setVisible(false);
/*       */               } 
/*       */             } 
/*       */           } 
/*       */         } else {
/*  9587 */           agregar = true;
/*       */         } 
/*       */       } 
/*       */     } 
/*       */     
/*  9592 */     if (agregar) {
/*  9593 */       this.con.consultar("fecha_licen", "operadores", "where num_ope = " + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 0)));
/*  9594 */       String fecha = this.con.Campo;
/*  9595 */       validarFecha(fecha);
/*       */       
/*  9597 */       if (!this.BLOQUEADO) {
/*  9598 */         String eco = "0";
/*  9599 */         this.encontrado = this.con.consultar("num_tracto", "llamadas_historicas", "where num_ope = " + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 0)) + " order by num_llama desc");
/*  9600 */         if (this.encontrado) {
/*  9601 */           eco = this.con.Campo;
/*       */         }
/*  9603 */         this.con.inserSinMsj("insert into formacion(claveop,operador,fecha,tipo,eco,estatus,activo,fechaViaje,guias,comentario,justificacion)values(" + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 0)) + ",'" + String.valueOf(this.rSTableMetro3.getValueAt(this.rSTableMetro3.getSelectedRow(), 1)) + "',now(),'" + tipo + "'," + eco + ",'EN ESPERA',1,now(),'','','')");
/*  9604 */         cambiarColor();
/*  9605 */         consultarForma();
/*  9606 */         this.jDialog5.setVisible(false);
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   public void cambiarColor() {
/*  9612 */     boolean esta = false;
/*  9613 */     boolean entra = false;
/*  9614 */     String estado = "";
/*  9615 */     int indice = 0; int i;
/*  9616 */     for (i = 0; i < this.rSTableMetro5.getRowCount(); i++) {
/*  9617 */       estado = String.valueOf(this.rSTableMetro5.getValueAt(i, 4));
/*  9618 */       for (int j = 0; j < this.estatus.length; j++) {
/*  9619 */         if (!this.estatus[j].equals("")) {
/*  9620 */           if (estado.equals(this.estatus[j])) {
/*  9621 */             esta = true;
/*  9622 */             entra = true;
/*       */             break;
/*       */           } 
/*       */         } else {
/*  9626 */           entra = false;
/*  9627 */           indice = j;
/*  9628 */           j = this.estatus.length;
/*       */         } 
/*       */       } 
/*       */       
/*  9632 */       if (!entra) {
/*  9633 */         this.estatus[indice] = estado;
/*  9634 */         if (estado.equals("EN ESPERA")) {
/*  9635 */           this.colores[indice] = this.colorOriginal;
/*  9636 */         } else if (estado.equals("EN TALLER")) {
/*  9637 */           this.colores[indice] = Color.YELLOW;
/*  9638 */         } else if (estado.equals("EN LA TALACHERA")) {
/*  9639 */           this.colores[indice] = Color.ORANGE;
/*  9640 */         } else if (estado.equals("EN DESCANSO")) {
/*  9641 */           this.colores[indice] = Color.cyan;
/*  9642 */         } else if (estado.equals("SE NEGÓ AL VIAJE")) {
/*  9643 */           this.colores[indice] = Color.RED;
/*       */         } else {
/*  9645 */           this.colores[indice] = Color.WHITE;
/*       */         } 
/*       */       } 
/*       */     } 
/*       */     
/*  9650 */     esta = false;
/*  9651 */     entra = false;
/*  9652 */     estado = "";
/*  9653 */     indice = 0;
/*       */     
/*  9655 */     for (i = 0; i < this.rSTableMetro6.getRowCount(); i++) {
/*  9656 */       estado = String.valueOf(this.rSTableMetro6.getValueAt(i, 4));
/*  9657 */       for (int j = 0; j < this.estatus.length; j++) {
/*  9658 */         if (!this.estatus[j].equals("")) {
/*  9659 */           if (estado.equals(this.estatus[j])) {
/*  9660 */             esta = true;
/*  9661 */             entra = true;
/*       */             break;
/*       */           } 
/*       */         } else {
/*  9665 */           entra = false;
/*  9666 */           indice = j;
/*  9667 */           j = this.estatus.length;
/*       */         } 
/*       */       } 
/*  9670 */       if (!entra) {
/*  9671 */         this.estatus[indice] = estado;
/*  9672 */         if (estado.equals("EN ESPERA")) {
/*  9673 */           this.colores[indice] = this.colorOriginal;
/*  9674 */         } else if (estado.equals("EN TALLER")) {
/*  9675 */           this.colores[indice] = Color.YELLOW;
/*  9676 */         } else if (estado.equals("EN LA TALACHERA")) {
/*  9677 */           this.colores[indice] = Color.ORANGE;
/*  9678 */         } else if (estado.equals("EN DESCANSO")) {
/*  9679 */           this.colores[indice] = Color.cyan;
/*  9680 */         } else if (estado.equals("SE NEGÓ AL VIAJE")) {
/*  9681 */           this.colores[indice] = Color.RED;
/*       */         } else {
/*  9683 */           this.colores[indice] = Color.WHITE;
/*       */         } 
/*       */       } 
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   public void consultar2() {
/*  9691 */     String num_ope = this.metroTextBox1.getText();
/*  9692 */     this.materialButton15.setEnabled(false);
/*  9693 */     this.rSTableMetro3.setModel(new DefaultTableModel((Object[][])this.con
/*  9694 */           .buscarDatos(4, "num_ope,nombre,ap_pat,ap_mat", "operadores", "where num_ope<>0 and num_ope like '%" + num_ope + "%' and nombre like '%" + this.metroTextBox2.getText() + "%' and actual = 0 order by nombre"), (Object[])new String[] { "Núm", "Nombre", "Apellido Paterno", "Apellido Materno" })
/*       */         {
/*       */ 
/*       */ 
/*       */           
/*  9699 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  9704 */             return this.canEdit[columnIndex];
/*       */           }
/*       */         });
/*  9707 */     eliminarColumna2(2, 1, "Apellido Paterno");
/*  9708 */     eliminarColumna2(2, 1, "Apellido Materno");
/*       */     
/*  9710 */     this.rSTableMetro3.setSelectionMode(0);
/*  9711 */     this.rSTableMetro3.setAutoCreateRowSorter(true);
/*  9712 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  9719 */     this.rSTableMetro3.getColumnModel().getColumn(0).setPreferredWidth(40);
/*  9720 */     this.rSTableMetro3.getColumnModel().getColumn(0).setMaxWidth(40);
/*  9721 */     this.rSTableMetro3.getColumnModel().getColumn(0).setCellRenderer(this.celda4);
/*  9722 */     this.rSTableMetro3.getColumnModel().getColumn(1).setCellRenderer(this.celda4);
/*  9723 */     this.rSTableMetro3.setFont(new Font("Cantarell", 0, 10));
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
/*       */   public int alinearDer(int x, int letras) {
/*  9784 */     int quitar = 4 * letras;
/*  9785 */     x -= quitar;
/*  9786 */     return x;
/*       */   }
/*       */   
/*       */   public static void main(String[] args) {
/*  9790 */     EventQueue.invokeLater(new Runnable() {
/*       */           public void run() {
/*  9792 */             (new Principal()).setVisible(true);
/*       */           }
/*       */         });
/*       */   }
/*       */   
/*       */   public void colorear() {
/*  9798 */     this.metroTextBox1.addFocusListener(new FocusAdapter() {
/*       */           public void focusGained(FocusEvent evt) {
/*  9800 */             Principal.this.jTextGanado((JComponent)Principal.this.metroTextBox1, evt);
/*       */           }
/*       */           
/*       */           public void focusLost(FocusEvent evt) {
/*  9804 */             Principal.this.jTextPerdido((JComponent)Principal.this.metroTextBox1, evt);
/*       */           }
/*       */         });
/*       */     
/*  9808 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*       */           public void focusGained(FocusEvent evt) {
/*  9810 */             Principal.this.jTextGanado(Principal.this.jTextField1, evt);
/*       */           }
/*       */           
/*       */           public void focusLost(FocusEvent evt) {
/*  9814 */             Principal.this.jTextPerdido(Principal.this.jTextField1, evt);
/*       */           }
/*       */         });
/*  9817 */     this.metroTextBox2.addFocusListener(new FocusAdapter() {
/*       */           public void focusGained(FocusEvent evt) {
/*  9819 */             Principal.this.jTextGanado((JComponent)Principal.this.metroTextBox2, evt);
/*       */           }
/*       */           
/*       */           public void focusLost(FocusEvent evt) {
/*  9823 */             Principal.this.jTextPerdido((JComponent)Principal.this.metroTextBox2, evt);
/*       */           }
/*       */         });
/*       */     
/*  9827 */     this.jTextArea4.addFocusListener(new FocusAdapter() {
/*       */           public void focusGained(FocusEvent evt) {
/*  9829 */             Principal.this.jTextGanado(Principal.this.jTextArea4, evt);
/*       */           }
/*       */           
/*       */           public void focusLost(FocusEvent evt) {
/*  9833 */             Principal.this.jTextPerdido(Principal.this.jTextArea4, evt);
/*       */           }
/*       */         });
/*       */     
/*  9837 */     this.jPasswordField1.addFocusListener(new FocusAdapter() {
/*       */           public void focusGained(FocusEvent evt) {
/*  9839 */             Principal.this.jTextGanado(Principal.this.jPasswordField1, evt);
/*       */           }
/*       */           
/*       */           public void focusLost(FocusEvent evt) {
/*  9843 */             Principal.this.jTextPerdido(Principal.this.jPasswordField1, evt);
/*       */           }
/*       */         });
/*  9846 */     this.jPasswordField2.addFocusListener(new FocusAdapter() {
/*       */           public void focusGained(FocusEvent evt) {
/*  9848 */             Principal.this.jTextGanado(Principal.this.jPasswordField2, evt);
/*       */           }
/*       */           
/*       */           public void focusLost(FocusEvent evt) {
/*  9852 */             Principal.this.jTextPerdido(Principal.this.jPasswordField2, evt);
/*       */           }
/*       */         });
/*  9855 */     this.jPasswordField3.addFocusListener(new FocusAdapter() {
/*       */           public void focusGained(FocusEvent evt) {
/*  9857 */             Principal.this.jTextGanado(Principal.this.jPasswordField3, evt);
/*       */           }
/*       */           
/*       */           public void focusLost(FocusEvent evt) {
/*  9861 */             Principal.this.jTextPerdido(Principal.this.jPasswordField3, evt);
/*       */           }
/*       */         });
/*       */   }
/*       */ 
/*       */   
/*       */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/*  9868 */     campo.setBackground(this.lc.FONDOCAMPOSELEC);
/*       */   }
/*       */ 
/*       */   
/*       */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/*  9873 */     campo.setBackground(Color.white);
/*       */   }
/*       */   
/*       */   public void agregarOperadores() {
/*  9877 */     if (existenDatos()) {
/*  9878 */       setCursor(new Cursor(3));
/*  9879 */       this.jTabbedPane2.removeAll();
/*  9880 */       if (this.OperadorA == null) {
/*       */         
/*  9882 */         this.OperadorA = new AltaOperador(this.jScrollPane1, this.USUARIO, null, new JTable(), "", this, this.mensajeTry, this.CAMPOSGENERALES, this.LISTACODIGOS, this.CODIGOSP);
/*       */       } else {
/*  9884 */         this.OperadorA.operadores(this.USUARIO, "");
/*       */       } 
/*  9886 */       this.jTabbedPane2.addTab("Agregar Operador", this.jScrollPane1);
/*  9887 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void operadorModifi() {
/*  9892 */     if (existenDatos()) {
/*  9893 */       setCursor(new Cursor(3));
/*  9894 */       this.jTabbedPane2.removeAll();
/*  9895 */       if (this.operadorModifi == null) {
/*       */         
/*  9897 */         this.operadorModifi = new OperadoresModifi(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry, this.CAMPOSGENERALES, this.LISTACODIGOS, this.CODIGOSP);
/*       */       } else {
/*  9899 */         this.operadorModifi.operadores(this.USUARIO);
/*       */       } 
/*  9901 */       this.jTabbedPane2.addTab("Modificar Operadores", this.jScrollPane1);
/*  9902 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void modificarEmpleados() {
/*  9907 */     if (existenDatos()) {
/*  9908 */       setCursor(new Cursor(3));
/*  9909 */       this.jTabbedPane2.removeAll();
/*  9910 */       if (this.EmpleadoM == null) {
/*  9911 */         this.EmpleadoM = new EmpleadosModifi(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry, this.CAMPOSGENERALES);
/*       */       } else {
/*  9913 */         this.EmpleadoM.empleados(this.USUARIO);
/*       */       } 
/*  9915 */       this.jTabbedPane2.addTab("Modificar Empleados", this.jScrollPane1);
/*  9916 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void buscarOperadores() {
/*  9921 */     if (existenDatos()) {
/*  9922 */       setCursor(new Cursor(3));
/*  9923 */       this.jTabbedPane2.removeAll();
/*  9924 */       if (this.operadorB == null) {
/*  9925 */         this.operadorB = new OperadoresBuscar(this, this.jScrollPane1, this.USUARIO, null, this.CAMPOSGENERALES, false);
/*       */       } else {
/*  9927 */         this.operadorB.operadores(this.USUARIO);
/*       */       } 
/*  9929 */       this.jTabbedPane2.addTab("Búsqueda de Operadores", this.jScrollPane1);
/*  9930 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void eliminarOperadores() {
/*  9935 */     if (existenDatos()) {
/*  9936 */       setCursor(new Cursor(3));
/*  9937 */       this.jTabbedPane2.removeAll();
/*  9938 */       if (this.operadorE == null) {
/*  9939 */         this.operadorE = new OperadoresEliminar(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry);
/*       */       } else {
/*  9941 */         this.operadorE.operadores(this.USUARIO);
/*       */       } 
/*  9943 */       this.jTabbedPane2.addTab("Eliminar Operadores", this.jScrollPane1);
/*  9944 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void agregarEmpleados() {
/*  9949 */     if (existenDatos()) {
/*  9950 */       setCursor(new Cursor(3));
/*  9951 */       this.jTabbedPane2.removeAll();
/*  9952 */       if (this.EmpleadoA == null) {
/*  9953 */         this.EmpleadoA = new EmpleadosAgregar(this.jScrollPane1, this.USUARIO, null, new JTable(), "", this, this.mensajeTry, this.CAMPOSGENERALES);
/*       */       } else {
/*  9955 */         this.EmpleadoA.empleados(this.USUARIO, "");
/*       */       } 
/*  9957 */       this.jTabbedPane2.addTab("Agregar Empleados", this.jScrollPane1);
/*  9958 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void eliminarEmpleados() {
/*  9963 */     if (existenDatos()) {
/*  9964 */       setCursor(new Cursor(3));
/*  9965 */       this.jTabbedPane2.removeAll();
/*  9966 */       if (this.EmpleadoE == null) {
/*  9967 */         this.EmpleadoE = new EmpleadosEliminar(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry);
/*       */       } else {
/*  9969 */         this.EmpleadoE.empleados(this.USUARIO);
/*       */       } 
/*  9971 */       this.jTabbedPane2.addTab("Eliminar Empleados", this.jScrollPane1);
/*  9972 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void buscarEmpleados() {
/*  9977 */     if (existenDatos()) {
/*  9978 */       setCursor(new Cursor(3));
/*  9979 */       this.jTabbedPane2.removeAll();
/*  9980 */       if (this.EmpleadoB == null) {
/*  9981 */         this.EmpleadoB = new EmpleadosBuscar(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.CAMPOSGENERALES, false);
/*       */       } else {
/*  9983 */         this.EmpleadoB.empleados(this.USUARIO);
/*       */       } 
/*  9985 */       this.jTabbedPane2.addTab("Buscar Empleados", this.jScrollPane1);
/*  9986 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void agregarGeneradora() {
/*  9991 */     if (existenDatos()) {
/*  9992 */       setCursor(new Cursor(3));
/*  9993 */       this.jTabbedPane2.removeAll();
/*  9994 */       if (this.origenes == null) {
/*  9995 */         this.origenes = new tras_Origenes(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry, this.jLabel36, this.CAMPOSGENERALES, false, this.LISTACODIGOS, this.CODIGOSP);
/*       */       } else {
/*  9997 */         this.origenes.orgienes(this.USUARIO);
/*       */       } 
/*  9999 */       this.jTabbedPane2.addTab("Origenes", this.jScrollPane1);
/* 10000 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void modificarGeneradora() {
/* 10005 */     if (existenDatos()) {
/* 10006 */       setCursor(new Cursor(3));
/* 10007 */       this.jTabbedPane2.removeAll();
/* 10008 */       if (this.GeneradoraM == null) {
/* 10009 */         this.GeneradoraM = new GeneradoraModifi(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry);
/*       */       } else {
/* 10011 */         this.GeneradoraM.generadora(this.USUARIO);
/*       */       } 
/* 10013 */       this.jTabbedPane2.addTab("Modificar Empresa Origen", this.jScrollPane1);
/* 10014 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void eliminarGeneradora() {
/* 10019 */     if (existenDatos()) {
/* 10020 */       setCursor(new Cursor(3));
/* 10021 */       this.jTabbedPane2.removeAll();
/* 10022 */       if (this.GeneradoraE == null) {
/* 10023 */         this.GeneradoraE = new GeneradoraEliminar(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry);
/*       */       } else {
/* 10025 */         this.GeneradoraE.generadora(this.USUARIO);
/*       */       } 
/* 10027 */       this.jTabbedPane2.addTab("Eliminar Empresa Origen", this.jScrollPane1);
/* 10028 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void buscarGeneradora() {
/* 10033 */     if (existenDatos()) {
/* 10034 */       setCursor(new Cursor(3));
/* 10035 */       this.jTabbedPane2.removeAll();
/* 10036 */       if (this.GeneradoraB == null) {
/* 10037 */         this.GeneradoraB = new GeneradoraBuscar(this, this.jScrollPane1, this.USUARIO, null);
/*       */       } else {
/* 10039 */         this.GeneradoraB.generadora(this.USUARIO);
/*       */       } 
/* 10041 */       this.jTabbedPane2.addTab("Buscar Empresa Origen", this.jScrollPane1);
/* 10042 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void agregarDestinatario() {
/* 10047 */     if (existenDatos()) {
/* 10048 */       setCursor(new Cursor(3));
/* 10049 */       this.jTabbedPane2.removeAll();
/* 10050 */       if (this.DestinatarioA == null) {
/* 10051 */         this.DestinatarioA = new DestinatarioAlta(this.jScrollPane1, this.USUARIO, null, new JTable(), "", this, this.mensajeTry);
/*       */       } else {
/* 10053 */         this.DestinatarioA.destinatario(this.USUARIO, "");
/*       */       } 
/* 10055 */       this.jTabbedPane2.addTab("Agregar Empresa Destinatario", this.jScrollPane1);
/* 10056 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void modificarDestinatario() {
/* 10061 */     if (existenDatos()) {
/* 10062 */       setCursor(new Cursor(3));
/* 10063 */       this.jTabbedPane2.removeAll();
/* 10064 */       if (this.DestinatarioM == null) {
/* 10065 */         this.DestinatarioM = new DestinatarioModifi(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry);
/*       */       } else {
/* 10067 */         this.DestinatarioM.destinatario(this.USUARIO);
/*       */       } 
/* 10069 */       this.jTabbedPane2.addTab("Modificar Empresa Destino", this.jScrollPane1);
/* 10070 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void eliminarDestinatario() {
/* 10075 */     if (existenDatos()) {
/* 10076 */       setCursor(new Cursor(3));
/* 10077 */       this.jTabbedPane2.removeAll();
/* 10078 */       if (this.DestinatarioE == null) {
/* 10079 */         this.DestinatarioE = new DestinatarioEliminar(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry);
/*       */       } else {
/* 10081 */         this.DestinatarioE.destinatario(this.USUARIO);
/*       */       } 
/* 10083 */       this.jTabbedPane2.addTab("Eliminar Empresa Destino", this.jScrollPane1);
/* 10084 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void buscarDestinatario() {
/* 10089 */     if (existenDatos()) {
/* 10090 */       setCursor(new Cursor(3));
/* 10091 */       this.jTabbedPane2.removeAll();
/* 10092 */       if (this.DestinatarioB == null) {
/* 10093 */         this.DestinatarioB = new DestinatarioBuscar(this, this.jScrollPane1, this.USUARIO, null);
/*       */       } else {
/* 10095 */         this.DestinatarioB.destinatario(this.USUARIO);
/*       */       } 
/* 10097 */       this.jTabbedPane2.addTab("Buscar Empresa Destino", this.jScrollPane1);
/* 10098 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void agregarTracto() {
/* 10103 */     if (existenDatos()) {
/* 10104 */       setCursor(new Cursor(3));
/* 10105 */       this.jTabbedPane2.removeAll();
/* 10106 */       if (this.TractoA == null) {
/* 10107 */         this.TractoA = new TractoAgregar(this.jScrollPane1, this.USUARIO, null, new JTable(), "", this, this.mensajeTry);
/*       */       } else {
/* 10109 */         this.TractoA.tracto(this.USUARIO, "");
/*       */       } 
/* 10111 */       this.jTabbedPane2.addTab("Agregar Tractos", this.jScrollPane1);
/* 10112 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void modificarTractos() {
/* 10117 */     if (existenDatos()) {
/* 10118 */       setCursor(new Cursor(3));
/* 10119 */       this.jTabbedPane2.removeAll();
/* 10120 */       if (this.TractoM == null) {
/* 10121 */         this.TractoM = new TractoModificar(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry);
/*       */       } else {
/* 10123 */         this.TractoM.tracto(this.USUARIO);
/*       */       } 
/* 10125 */       this.jTabbedPane2.addTab("Modificar Tractos", this.jScrollPane1);
/* 10126 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void eliminarTractos() {
/* 10131 */     if (existenDatos()) {
/* 10132 */       setCursor(new Cursor(3));
/* 10133 */       this.jTabbedPane2.removeAll();
/* 10134 */       if (this.TractoE == null) {
/* 10135 */         this.TractoE = new TractoEliminar(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry);
/*       */       } else {
/* 10137 */         this.TractoE.tracto(this.USUARIO);
/*       */       } 
/* 10139 */       this.jTabbedPane2.addTab("Eliminar Tractos", this.jScrollPane1);
/* 10140 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void buscarTractos() {
/* 10145 */     if (existenDatos()) {
/* 10146 */       setCursor(new Cursor(3));
/* 10147 */       this.jTabbedPane2.removeAll();
/* 10148 */       if (this.TractoB == null) {
/* 10149 */         this.TractoB = new TractoBuscar(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this);
/*       */       } else {
/* 10151 */         this.TractoB.tracto(this.USUARIO);
/*       */       } 
/* 10153 */       this.jTabbedPane2.addTab("Buscar Tractos", this.jScrollPane1);
/* 10154 */       cargarMouse();
/*       */     } 
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
/*       */   public void UsuariosEliminar() {
/* 10214 */     if (existenDatos()) {
/* 10215 */       setCursor(new Cursor(3));
/* 10216 */       this.jTabbedPane2.removeAll();
/* 10217 */       if (this.usuEliminar == null) {
/* 10218 */         this.usuEliminar = new UsuariosEliminar(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this);
/*       */       } else {
/* 10220 */         this.usuEliminar.usuarios(this.USUARIO);
/*       */       } 
/* 10222 */       this.jTabbedPane2.addTab("Eliminar Usuarios", this.jScrollPane1);
/* 10223 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void buscarUsuarios() {
/* 10228 */     if (existenDatos()) {
/* 10229 */       setCursor(new Cursor(3));
/* 10230 */       this.jTabbedPane2.removeAll();
/* 10231 */       if (this.usuBuscar == null) {
/* 10232 */         this.usuBuscar = new UsuariosBuscar(this, this.jScrollPane1, this.USUARIO, null);
/*       */       } else {
/* 10234 */         this.usuBuscar.Usuarios(this.USUARIO);
/*       */       } 
/* 10236 */       this.jTabbedPane2.addTab("Búsqueda de Usuarios", this.jScrollPane1);
/* 10237 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void reseteos() {
/* 10242 */     if (existenDatos()) {
/* 10243 */       setCursor(new Cursor(3));
/* 10244 */       this.jTabbedPane2.removeAll();
/* 10245 */       if (this.reseteos == null) {
/* 10246 */         this.reseteos = new Reseteos(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this);
/*       */       } else {
/* 10248 */         this.reseteos.reseteos(this.USUARIO);
/*       */       } 
/* 10250 */       this.jTabbedPane2.addTab("Reseteos", this.jScrollPane1);
/* 10251 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void agregarUsuarios() {
/* 10256 */     if (existenDatos()) {
/* 10257 */       setCursor(new Cursor(3));
/* 10258 */       this.jTabbedPane2.removeAll();
/* 10259 */       if (this.UsuarioA == null) {
/* 10260 */         this.UsuarioA = new AgregarUsuarios(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this);
/*       */       } else {
/* 10262 */         this.UsuarioA.usuarios(this.USUARIO);
/*       */       } 
/* 10264 */       this.jTabbedPane2.addTab("Agregar Usuarios", this.jScrollPane1);
/* 10265 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void bitacora() {
/* 10270 */     if (existenDatos()) {
/* 10271 */       setCursor(new Cursor(3));
/* 10272 */       this.jTabbedPane2.removeAll();
/* 10273 */       if (this.bitacora == null) {
/* 10274 */         this.bitacora = new bitacora(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this);
/*       */       } else {
/* 10276 */         this.bitacora.bita(this.USUARIO);
/*       */       } 
/* 10278 */       this.jTabbedPane2.addTab("Bitacora", this.jScrollPane1);
/* 10279 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void equipo() {
/* 10284 */     if (existenDatos()) {
/* 10285 */       setCursor(new Cursor(3));
/* 10286 */       this.jTabbedPane2.removeAll();
/* 10287 */       if (this.Equipo == null) {
/* 10288 */         this.Equipo = new Equipos(this.jScrollPane1, this.USUARIO, null, new JTable(), "", this, this.mensajeTry);
/*       */       } else {
/* 10290 */         this.Equipo.equipos(this.USUARIO);
/*       */       } 
/* 10292 */       this.jTabbedPane2.addTab("Equipos", this.jScrollPane1);
/* 10293 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void Plataforma() {
/* 10298 */     if (existenDatos()) {
/* 10299 */       setCursor(new Cursor(3));
/* 10300 */       this.jTabbedPane2.removeAll();
/* 10301 */       if (this.plataforma == null) {
/* 10302 */         this.plataforma = new Plataformas(this.jScrollPane1, this.USUARIO, null, new JTable(), "", this, this.mensajeTry);
/*       */       } else {
/* 10304 */         this.plataforma.equipos(this.USUARIO);
/*       */       } 
/* 10306 */       this.jTabbedPane2.addTab("Plataformas", this.jScrollPane1);
/* 10307 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void Pozos() {
/* 10312 */     if (existenDatos()) {
/* 10313 */       setCursor(new Cursor(3));
/* 10314 */       this.jTabbedPane2.removeAll();
/* 10315 */       if (this.pozo == null) {
/* 10316 */         this.pozo = new Pozos(this.jScrollPane1, this.USUARIO, null, new JTable(), "", this);
/*       */       } else {
/* 10318 */         this.pozo.pozos(this.USUARIO);
/*       */       } 
/* 10320 */       this.jTabbedPane2.addTab("Pozos", this.jScrollPane1);
/* 10321 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void llamada() {
/* 10326 */     if (existenDatos()) {
/* 10327 */       setCursor(new Cursor(3));
/* 10328 */       this.jTabbedPane2.removeAll();
/* 10329 */       if (this.llamada == null) {
/* 10330 */         this.llamada = new Datos(this.jScrollPane1, this.USUARIO, null, new JTable(), "", this, this.mensajeTry, this.CAMPOSGENERALES, false);
/*       */       } else {
/* 10332 */         this.llamada.datos(this.USUARIO, "", this.CAMPOSGENERALES);
/*       */       } 
/* 10334 */       this.jTabbedPane2.addTab("Recopilar Datos", this.jScrollPane1);
/* 10335 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void modificarGuias() {
/* 10340 */     if (existenDatos()) {
/* 10341 */       setCursor(new Cursor(3));
/* 10342 */       this.jTabbedPane2.removeAll();
/* 10343 */       if (this.guiasM == null) {
/*       */         
/* 10345 */         this.guiasM = new ModificarGuias(this.jScrollPane1, this.USUARIO, null, new JTable(), "", this, this.CAMPOSGENERALES, this.LISTACODIGOS, this.CODIGOSP);
/*       */       } else {
/* 10347 */         this.guiasM.guias(this.USUARIO);
/*       */       } 
/* 10349 */       this.jTabbedPane2.addTab("Consultar Guías", this.jScrollPane1);
/* 10350 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void buscarManifiestos() {
/* 10355 */     if (existenDatos()) {
/* 10356 */       setCursor(new Cursor(3));
/* 10357 */       this.jTabbedPane2.removeAll();
/* 10358 */       if (this.manifiestosB == null) {
/* 10359 */         this.manifiestosB = new buscarManifiestos(this.jScrollPane1, this.USUARIO, null, new JTable(), "", this);
/*       */       } else {
/* 10361 */         this.manifiestosB.manifiestos(this.USUARIO);
/*       */       } 
/* 10363 */       this.jTabbedPane2.addTab("Buscar Manifiestos", this.jScrollPane1);
/* 10364 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void llamadasBuscar() {
/* 10369 */     if (existenDatos()) {
/* 10370 */       setCursor(new Cursor(3));
/* 10371 */       this.jTabbedPane2.removeAll();
/* 10372 */       if (this.llamadasB == null) {
/* 10373 */         this.llamadasB = new LlamadasBuscar(this.jScrollPane1, this.USUARIO, null, new JTable(), "", this);
/*       */       } else {
/* 10375 */         this.llamadasB.llamadas(this.USUARIO);
/*       */       } 
/* 10377 */       this.jTabbedPane2.addTab("Historial de Pedidos", this.jScrollPane1);
/* 10378 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void cargarMouse() {
/*       */     try {
/* 10384 */       Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/* 10385 */       Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/* 10386 */       setCursor(micursor);
/* 10387 */       this.jFrame2.setCursor(micursor);
/* 10388 */       this.jFrame1.setCursor(micursor);
/* 10389 */       this.jDialog1.setCursor(micursor);
/* 10390 */       this.jDialog4.setCursor(micursor);
/* 10391 */       this.jDialog5.setCursor(micursor);
/* 10392 */       this.jDialog6.setCursor(micursor);
/* 10393 */       this.jDialog7.setCursor(micursor);
/* 10394 */       this.jDialog8.setCursor(micursor);
/* 10395 */       this.jDialog9.setCursor(micursor);
/* 10396 */       this.jDialog10.setCursor(micursor);
/* 10397 */       this.rSTableMetro2.setCursor(micursor);
/* 10398 */       this.rSTableMetro3.setCursor(micursor);
/* 10399 */       this.rSTableMetro4.setCursor(micursor);
/* 10400 */       this.rSTableMetro5.setCursor(micursor);
/* 10401 */       this.rSTableMetro6.setCursor(micursor);
/*       */ 
/*       */       
/* 10404 */       imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/* 10405 */       micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/* 10406 */       this.jLabel11.setCursor(micursor);
/*       */       
/* 10408 */       this.jLabel28.setCursor(micursor);
/* 10409 */       this.jLabel51.setCursor(micursor);
/* 10410 */       this.jLabel111.setCursor(micursor);
/* 10411 */     } catch (Exception e) {
/* 10412 */       JOptionPane.showMessageDialog(this, e, "Depura", -1);
/*       */     } 
/*       */   }
/*       */   
/*       */   public void consultarDocVencidos() {
/* 10417 */     this.con.consultar("diasAvisos", "configuraciones", "");
/* 10418 */     int dias = Integer.parseInt(this.con.Campo);
/* 10419 */     LocalDate fecha = LocalDate.now();
/* 10420 */     fecha = fecha.plusDays(dias);
/* 10421 */     this.jLabel9.setText(" Listado de documentos vencidos o próximos a vencer en " + dias + " días:");
/* 10422 */     this.CAMPOSGENERALES.put("diasAvisos", "" + dias);
/* 10423 */     this.utilerias.consultaGralTabla(new Consultas2(), (JTable)this.rSTableMetro1, new String[] { "ID", "Tipo", "Eco", "Documento", "Trámite", "Número", "Periodo", "Vencimiento" }, "unidadesdocumentos.numDoc, unidadesdoctractos.tipo, num_Tracto, unidadesdocumentos.tipo, fechaTramite, numeroUnico, periodoVencimiento, fechaVencimiento", "unidadesdocumentos,unidadesdoctractos", "where unidadesdocumentos.estado='ACTIVO' and unidadesdocumentos.numDoc= unidadesdoctractos.numDoc and periodoVencimiento<>'ÚNICO' and fechaVencimiento<'" + this.utilerias
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 10430 */         .convertirFechaDateString(Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant())) + "' order by num_tracto, fechaVencimiento");
/* 10431 */     this.jLabel100.setText("" + this.rSTableMetro1.getRowCount());
/* 10432 */     this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 0, 50);
/* 10433 */     if (this.rSTableMetro1.getRowCount() > 0) {
/* 10434 */       this.jDialog11.setVisible(true);
/*       */     }
/*       */   }
/*       */   
/*       */   public boolean existenDatos() {
/* 10439 */     boolean si = false;
/* 10440 */     String linea = "";
/* 10441 */     String conte = "";
/*       */     try {
/* 10443 */       File f = new File("datos.tmp");
/* 10444 */       Reader archivo = new FileReader(f);
/* 10445 */       BufferedReader filtro = new BufferedReader(archivo);
/* 10446 */       while ((linea = filtro.readLine()) != null) {
/* 10447 */         si = true;
/* 10448 */         conte = conte + conte;
/*       */       } 
/* 10450 */       filtro.close();
/* 10451 */       archivo.close();
/* 10452 */     } catch (IOException iOException) {}
/*       */     
/* 10454 */     if (si) {
/* 10455 */       int r = JOptionPane.showConfirmDialog(this, "Existen datos cargados en el formulario actual, si continuas se perderá la información.\n¿Estás seguro que deseas continuar y perder los datos?", "Datos Cargados", 0, 3, this.PREG);
/* 10456 */       if (r == 0) {
/* 10457 */         this.datos.eliminar();
/* 10458 */         if (conte.equals("EmpleadoAgregar")) {
/* 10459 */           if (this.EmpleadoA != null) {
/* 10460 */             this.EmpleadoA.limpiar();
/*       */           }
/* 10462 */         } else if (conte.equals("OperadorAgregar")) {
/* 10463 */           if (this.OperadorA != null) {
/* 10464 */             this.OperadorA.limpiar();
/*       */           }
/* 10466 */         } else if (conte.equals("GeneradoraAlta") && 
/* 10467 */           this.GeneradoraA != null) {
/* 10468 */           this.GeneradoraA.limpiar();
/*       */         } 
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
/*       */ 
/*       */ 
/*       */ 
/*       */         
/* 10506 */         return true;
/*       */       } 
/* 10508 */       return false;
/*       */     } 
/*       */     
/* 10511 */     return true;
/*       */   }
/*       */   
/*       */   public void actiVencimientos() {
/* 10515 */     Date fecha1 = new Date();
/* 10516 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 10517 */     String cadenaFecha = "";
/* 10518 */     cadenaFecha = formato.format(fecha1);
/* 10519 */     String AÑO = cadenaFecha.substring(0, 4);
/* 10520 */     String MES = cadenaFecha.substring(4, 6);
/* 10521 */     String DIA = cadenaFecha.substring(6, 8);
/* 10522 */     String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*       */ 
/*       */ 
/*       */     
/* 10526 */     this.rSTableMetro2.setModel(new DefaultTableModel((Object[][])this.con
/* 10527 */           .buscarDatos(7, "num_ope,ap_pat,ap_mat,NOMBRE,fecha_licen,num_licen,tipo_licen", "operadores", "where fecha_licen<" + fechaCompleta1 + " and actual=0 and tipoTrabajador = 'OPERADOR' order by fecha_licen asc"), (Object[])new String[] { "Núm", "Nombre Completo", "Apellido Materno", "Nombre", "Vencimiento", "Número", "Tipo" })
/*       */         {
/*       */ 
/*       */           
/* 10531 */           boolean[] canEdit = new boolean[] { 
/*       */               false, false, false, false, false, false, false, false, false, false, 
/*       */               false, false };
/*       */           
/*       */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 10536 */             return this.canEdit[columnIndex];
/*       */           }
/*       */         });
/*       */     
/* 10540 */     this.jLabel22.setText("" + this.rSTableMetro2.getRowCount());
/* 10541 */     this.rSTableMetro2.setShowVerticalLines(false);
/* 10542 */     eliminarColumna(2, 1, "Apellido Materno");
/* 10543 */     eliminarColumna(2, 1, "Nombre");
/*       */     
/* 10545 */     this.rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 10546 */     this.rSTableMetro2.getColumnModel().getColumn(0).setMaxWidth(40);
/* 10547 */     this.rSTableMetro2.getColumnModel().getColumn(2).setPreferredWidth(75);
/* 10548 */     this.rSTableMetro2.getColumnModel().getColumn(2).setMaxWidth(75);
/* 10549 */     this.rSTableMetro2.getColumnModel().getColumn(3).setPreferredWidth(85);
/* 10550 */     this.rSTableMetro2.getColumnModel().getColumn(3).setMaxWidth(85);
/* 10551 */     this.rSTableMetro2.getColumnModel().getColumn(4).setPreferredWidth(50);
/* 10552 */     this.rSTableMetro2.getColumnModel().getColumn(4).setMaxWidth(50);
/*       */     
/* 10554 */     this.rSTableMetro2.setSelectionMode(0);
/* 10555 */     this.rSTableMetro2.setAutoCreateRowSorter(true);
/* 10556 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/* 10564 */     if (this.rSTableMetro2.getRowCount() > 0) {
/* 10565 */       this.jDialog4.setVisible(true);
/*       */     }
/*       */   }
/*       */   
/*       */   public void eliminarColumna(int origen, int destino, String nombreCol) {
/* 10570 */     int cont = this.rSTableMetro2.getRowCount();
/* 10571 */     String[] registros = new String[cont]; int i;
/* 10572 */     for (i = 0; i < cont; i++) {
/* 10573 */       registros[i] = this.rSTableMetro2.getValueAt(i, destino).toString();
/*       */     }
/* 10575 */     for (i = 0; i < cont; i++) {
/* 10576 */       registros[i] = registros[i] + " " + registros[i];
/* 10577 */       this.rSTableMetro2.setValueAt(registros[i], i, destino);
/*       */     } 
/* 10579 */     TableColumn columna = this.rSTableMetro2.getColumn(nombreCol);
/* 10580 */     this.rSTableMetro2.removeColumn(columna);
/*       */   }
/*       */   
/*       */   public void eliminarColumna2(int origen, int destino, String nombreCol) {
/* 10584 */     int cont = this.rSTableMetro3.getRowCount();
/* 10585 */     String[] registros = new String[cont]; int i;
/* 10586 */     for (i = 0; i < cont; i++) {
/* 10587 */       registros[i] = this.rSTableMetro3.getValueAt(i, destino).toString();
/*       */     }
/* 10589 */     for (i = 0; i < cont; i++) {
/* 10590 */       registros[i] = registros[i] + " " + registros[i];
/* 10591 */       this.rSTableMetro3.setValueAt(registros[i], i, destino);
/*       */     } 
/* 10593 */     TableColumn columna = this.rSTableMetro3.getColumn(nombreCol);
/* 10594 */     this.rSTableMetro3.removeColumn(columna);
/*       */   }
/*       */   
/*       */   public void salir() {
/* 10598 */     if (existenDatos()) {
/* 10599 */       int res = JOptionPane.showConfirmDialog(this, "<html>¿Estás seguro que deseas salir de SICRET?<br><b>Sistema Integral para el Control de Residuos y Empleados Transportistas</b></html>", "Saliendo...", 0, 3, this.PREG);
/* 10600 */       if (res == 0) {
/* 10601 */         cargarDatos datos = new cargarDatos("");
/* 10602 */         datos.eliminar();
/* 10603 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Salió del Sistema','' )");
/* 10604 */         System.exit(0);
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   public void cargarInfonavit() {
/* 10610 */     Calendar hoy = Calendar.getInstance();
/* 10611 */     Date dia = hoy.getTime();
/* 10612 */     Calendar c = GregorianCalendar.getInstance();
/* 10613 */     hoy.setTime(this.jDateChooser1.getDate());
/*       */   }
/*       */   
/*       */   public String cargarFechaHoy() {
/* 10617 */     this.fecha = new Date();
/*       */     
/* 10619 */     Calendar ahoraCal = Calendar.getInstance();
/* 10620 */     ahoraCal.setTime(this.fecha);
/* 10621 */     String mesesito = "";
/* 10622 */     String hoy = "";
/* 10623 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 10624 */     hoy = "" + ahoraCal.get(5);
/*       */     
/* 10626 */     int hora = ahoraCal.get(11);
/* 10627 */     int minutos = ahoraCal.get(12);
/* 10628 */     int segundos = ahoraCal.get(13);
/*       */     
/* 10630 */     if (ahoraCal.get(2) + 1 < 10) {
/* 10631 */       mesesito = "0" + mesesito;
/*       */     }
/* 10633 */     if (ahoraCal.get(5) < 10) {
/* 10634 */       hoy = "0" + hoy;
/*       */     }
/* 10636 */     return hoy + "/" + hoy + "/" + mesesito + " " + ahoraCal.get(1) + ":" + hora + ":" + minutos;
/*       */   }
/*       */   
/*       */   public void entrada() {
/* 10640 */     cargarInfonavit();
/* 10641 */     boolean encontrado = false;
/* 10642 */     this.error.pasarModal(false);
/* 10643 */     String nombre = this.jTextField1.getText().toUpperCase();
/* 10644 */     String contraSinCod = this.jPasswordField1.getText().toUpperCase();
/* 10645 */     String contra = DigestUtils.md5Hex(this.jPasswordField1.getText());
/*       */     
/* 10647 */     if (nombre.equals("") || contra.equals("")) {
/* 10648 */       JOptionPane.showMessageDialog(this, "Dejaste información sin contestar, por favor verifícala.", "Información Incompleta", 2, this.ADVER);
/*       */     } else {
/* 10650 */       boolean n1 = false;
/* 10651 */       boolean n2 = false;
/* 10652 */       this.con.Campo = "";
/* 10653 */       encontrado = this.con.consultar("num_emp", "usuarios", " where nombre_usu = '" + nombre + "' and contrasena = '" + contra + "'");
/* 10654 */       if (this.con.Campo.equals("0")) {
/* 10655 */         String depa = "SUPER USUARIO";
/* 10656 */         String priv = "";
/* 10657 */         setEnabled(true);
/* 10658 */         this.jFrame1.setVisible(false);
/* 10659 */         this.PRIMERAGASTOS = true;
/* 10660 */         setEnabled(true);
/* 10661 */         setVisible(true);
/* 10662 */         privilegios(depa);
/* 10663 */         setEnabled(true);
/* 10664 */       } else if (encontrado == true) {
/* 10665 */         String[] datos1 = this.con.regresaRegIndex("empleados.nombre, empleados.ap_pat, empleados.ap_mat,usuarios.priv, usuarios.num_emp, usuarios.correo", "usuarios,empleados", "where empleados.clave_emp = usuarios.num_emp and nombre_usu = '" + nombre + "'");
/*       */         
/* 10667 */         this.DEPA = datos1[3];
/* 10668 */         this.CAMPOSGENERALES.put("priv", this.DEPA);
/* 10669 */         this.CAMPOSGENERALES.put("empleados.nombre", datos1[0]);
/* 10670 */         this.CAMPOSGENERALES.put("empleados.ap_pat", datos1[1]);
/* 10671 */         this.CAMPOSGENERALES.put("empleados.ap_mat", datos1[2]);
/* 10672 */         this.CAMPOSGENERALES.put("empleados.num_emp", datos1[4]);
/* 10673 */         this.USUARIO = nombre;
/* 10674 */         this.CAMPOSGENERALES.put("usuario", this.USUARIO);
/* 10675 */         this.CAMPOSGENERALES.put("usuarios.correo", datos1[5]);
/* 10676 */         if (nombre.equals(contraSinCod)) {
/* 10677 */           this.jDialog1.setVisible(true);
/*       */         }
/* 10679 */         this.cargar.detener();
/* 10680 */         setVisible(true);
/* 10681 */         this.jFrame1.setVisible(false);
/* 10682 */         setVisible(true);
/* 10683 */         privilegios(this.DEPA);
/* 10684 */         this.PRIMERAGASTOS = true;
/* 10685 */         this.jPasswordField1.setText("");
/* 10686 */         this.jTextField1.setText("");
/*       */         
/* 10688 */         this.jLabel2.setText(this.USUARIO.toUpperCase() + " : " + this.USUARIO.toUpperCase());
/* 10689 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Entró al sistema','' )");
/* 10690 */         setEnabled(true);
/* 10691 */         setVisible(true);
/* 10692 */         setEnabled(true);
/* 10693 */         this.con.escribirUltimoUsuario(this.USUARIO);
/* 10694 */         if (this.AvisosComp.contains("Venc Licencias")) {
/* 10695 */           actiVencimientos();
/*       */         }
/* 10697 */         this.CAMPOSGENERALES.forEach((k, v) -> System.out.println("Key: " + k + " -> " + v));
/*       */       } else {
/* 10699 */         n1 = this.con.consultar("nombre_usu", "usuarios", "where nombre_usu='" + nombre + "'");
/* 10700 */         n2 = this.con.consultar("nombre_usu", "usuarios", "where nombre_usu = '" + nombre + "' and contrasena='" + contra + "'");
/* 10701 */         if (!n1) {
/* 10702 */           this.error.cargarError(this.jTextField1, "003");
/* 10703 */           this.jTextField1.setText("");
/* 10704 */           this.vecesMal++;
/* 10705 */           if (this.vecesMal >= 4) {
/* 10706 */             JOptionPane.showMessageDialog(this, "Has intentado entrar al sistema con una información incorrecta en más de tres\nocasiones, el sistema se cerrará por seguridad.", "El sistema se cerrará", 0, this.ERROR);
/* 10707 */             System.exit(0);
/*       */           } 
/* 10709 */         } else if (!n2) {
/* 10710 */           this.error.cargarError(this.jPasswordField1, "002");
/* 10711 */           this.jPasswordField1.setText("");
/* 10712 */           this.vecesMal++;
/* 10713 */           if (this.vecesMal >= 4) {
/* 10714 */             JOptionPane.showMessageDialog(this, "Has intentado entrar al sistema con una información incorrecta en más de tres\nocasiones, el sistema se cerrará por seguridad.", "El sistema se cerrará", 0, this.ERROR);
/* 10715 */             System.exit(0);
/*       */           } 
/*       */         } 
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   public void perfiles(String usua) {
/* 10723 */     this.encontrado = this.con.consultar("interfaz", "perfiles", "where usuario= '" + usua + "'");
/* 10724 */     if (this.encontrado) {
/* 10725 */       if (this.con.Campo.equals("menus")) {
/* 10726 */         activarMenus();
/*       */       } else {
/* 10728 */         activarBarra();
/*       */       } 
/*       */     } else {
/* 10731 */       activarBarra();
/*       */     } 
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public void weatherford() {}
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public void dowell() {
/* 10751 */     if (existenDatos()) {
/* 10752 */       setCursor(new Cursor(3));
/* 10753 */       this.jTabbedPane2.removeAll();
/* 10754 */       if (this.dow == null) {
/* 10755 */         this.dow = new dowell(this.jScrollPane1, this.USUARIO, null, new JTable(), "", this);
/*       */       } else {
/* 10757 */         this.dow.dowell(this.USUARIO);
/*       */       } 
/* 10759 */       this.jTabbedPane2.addTab("Facturación - SCHULEMBERGER", this.jScrollPane1);
/* 10760 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void reporteQHSE() {
/* 10765 */     if (existenDatos()) {
/* 10766 */       setCursor(new Cursor(3));
/* 10767 */       this.jTabbedPane2.removeAll();
/* 10768 */       if (this.reqhse == null) {
/* 10769 */         this.reqhse = new qhse(this.jScrollPane1, this.USUARIO, null, new JTable(), "", this);
/*       */       } else {
/* 10771 */         this.reqhse.qhse(this.USUARIO);
/*       */       } 
/* 10773 */       this.jTabbedPane2.addTab("Reporte QHSE", this.jScrollPane1);
/* 10774 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void Estadisticos() throws IOException {
/* 10779 */     if (existenDatos()) {
/* 10780 */       setCursor(new Cursor(3));
/* 10781 */       this.jTabbedPane2.removeAll();
/* 10782 */       if (this.estadis == null) {
/* 10783 */         this.estadis = new Estadisticos(this.jScrollPane1, this.USUARIO, null, new JTable(), "", this);
/*       */       } else {
/* 10785 */         this.estadis.estadis(this.USUARIO);
/*       */       } 
/* 10787 */       this.jTabbedPane2.addTab("Reporte QHSE", this.jScrollPane1);
/* 10788 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void servicios() {
/* 10793 */     if (existenDatos()) {
/* 10794 */       setCursor(new Cursor(3));
/* 10795 */       this.jTabbedPane2.removeAll();
/* 10796 */       if (this.serv == null) {
/* 10797 */         this.serv = new ServiciosRealizados(this.jScrollPane1, this.USUARIO, null, new JTable(), "", this);
/*       */       } else {
/* 10799 */         this.serv.servicios(this.USUARIO);
/*       */       } 
/* 10801 */       this.jTabbedPane2.addTab("Servicios Realizados", this.jScrollPane1);
/* 10802 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void Prefacturacion() {
/* 10807 */     if (existenDatos()) {
/* 10808 */       setCursor(new Cursor(3));
/* 10809 */       this.jTabbedPane2.removeAll();
/* 10810 */       if (this.prefac == null) {
/* 10811 */         this.prefac = new Prefacturas(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry);
/*       */       } else {
/* 10813 */         this.prefac.prefacturas(this.USUARIO);
/*       */       } 
/* 10815 */       this.jTabbedPane2.addTab("Prefacturas Internas", this.jScrollPane1);
/* 10816 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void prefacturacionCliente() {
/* 10821 */     if (existenDatos()) {
/* 10822 */       setCursor(new Cursor(3));
/* 10823 */       this.jTabbedPane2.removeAll();
/* 10824 */       if (this.preCliente == null) {
/* 10825 */         this.preCliente = new PrefacturaCliente(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry);
/*       */       } else {
/* 10827 */         this.preCliente.prefacturaCliente(this.USUARIO);
/*       */       } 
/* 10829 */       this.jTabbedPane2.addTab("Prefacturas de Clientes", this.jScrollPane1);
/* 10830 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void recepcion() {
/* 10835 */     if (existenDatos()) {
/* 10836 */       setCursor(new Cursor(3));
/* 10837 */       this.jTabbedPane2.removeAll();
/* 10838 */       if (this.recepcion == null) {
/* 10839 */         this.recepcion = new Recepcion(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry);
/*       */       } else {
/* 10841 */         this.recepcion.recepcion(this.USUARIO);
/*       */       } 
/* 10843 */       this.jTabbedPane2.addTab("Recepción de Guías", this.jScrollPane1);
/* 10844 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void facturas() {
/* 10849 */     if (existenDatos()) {
/* 10850 */       this.jTabbedPane2.removeAll();
/* 10851 */       this.jTabbedPane2.addTab("Tipo de facturas", this.jPanel43);
/*       */     } 
/*       */   }
/*       */   
/*       */   public void cotizaciones() {
/* 10856 */     if (existenDatos()) {
/* 10857 */       setCursor(new Cursor(3));
/* 10858 */       this.jTabbedPane2.removeAll();
/* 10859 */       if (this.coti == null) {
/* 10860 */         this.coti = new Cotizaciones(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry, this.CAMPOSGENERALES);
/*       */       } else {
/* 10862 */         this.coti.Cotizaciones(this.USUARIO);
/*       */       } 
/* 10864 */       this.jTabbedPane2.addTab("Cotizaciones", this.jScrollPane1);
/* 10865 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void TarjetaCliente() {
/* 10870 */     if (existenDatos()) {
/* 10871 */       setCursor(new Cursor(3));
/* 10872 */       this.jTabbedPane2.removeAll();
/* 10873 */       if (this.tarjetaClie == null) {
/* 10874 */         this.tarjetaClie = new TarjetaCliente(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.CAMPOSGENERALES);
/*       */       } else {
/* 10876 */         this.tarjetaClie.TarjetaCliente(this.USUARIO);
/*       */       } 
/* 10878 */       this.jTabbedPane2.addTab("Tarjetas Deudor", this.jScrollPane1);
/* 10879 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void facturacionPendiente() {
/* 10884 */     if (existenDatos()) {
/* 10885 */       setCursor(new Cursor(3));
/* 10886 */       this.jTabbedPane2.removeAll();
/* 10887 */       if (this.factPen == null) {
/* 10888 */         this.factPen = new FacturacionPendiente(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this);
/*       */       } else {
/* 10890 */         this.factPen.pendiente(this.USUARIO);
/*       */       } 
/* 10892 */       this.jTabbedPane2.addTab("Facturas Pendientes", this.jScrollPane1);
/* 10893 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void ampararFacturas() {
/* 10898 */     if (existenDatos()) {
/* 10899 */       setCursor(new Cursor(3));
/* 10900 */       this.jTabbedPane2.removeAll();
/* 10901 */       if (this.amparar == null) {
/* 10902 */         this.amparar = new ampararFacturas(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry);
/*       */       } else {
/* 10904 */         this.amparar.AmpararFacturas(this.USUARIO);
/*       */       } 
/* 10906 */       this.jTabbedPane2.addTab("Entregar Depósitos", this.jScrollPane1);
/* 10907 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void pagos() {
/* 10912 */     if (existenDatos()) {
/* 10913 */       setCursor(new Cursor(3));
/* 10914 */       this.jTabbedPane2.removeAll();
/* 10915 */       if (this.pagos == null) {
/* 10916 */         this.pagos = new complementoPagos(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.CAMPOSGENERALES);
/*       */       } else {
/*       */         
/* 10919 */         this.pagos.Pagos(this.USUARIO);
/*       */       } 
/* 10921 */       this.jTabbedPane2.addTab("Complemento para Pagos", this.jScrollPane1);
/* 10922 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void depositosClientes() {
/* 10927 */     if (existenDatos()) {
/* 10928 */       setCursor(new Cursor(3));
/* 10929 */       this.jTabbedPane2.removeAll();
/* 10930 */       if (this.depositoC == null) {
/* 10931 */         this.depositoC = new DepositosClientes(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this);
/*       */       } else {
/* 10933 */         this.depositoC.DepositosClientes(this.USUARIO);
/*       */       } 
/* 10935 */       this.jTabbedPane2.addTab("Abonos a Facturas", this.jScrollPane1);
/* 10936 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void valeDiesel() {
/* 10941 */     if (existenDatos()) {
/* 10942 */       setCursor(new Cursor(3));
/* 10943 */       this.jTabbedPane2.removeAll();
/* 10944 */       if (this.valeD == null) {
/* 10945 */         this.valeD = new valesDiesel(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry, this.CAMPOSGENERALES, false);
/*       */       } else {
/* 10947 */         this.valeD.vales(this.USUARIO);
/*       */       } 
/* 10949 */       this.jTabbedPane2.addTab("Vales Diesel", this.jScrollPane1);
/* 10950 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void verRSP() {
/* 10955 */     if (existenDatos()) {
/* 10956 */       setCursor(new Cursor(3));
/* 10957 */       this.jTabbedPane2.removeAll();
/* 10958 */       if (this.rsp == null) {
/* 10959 */         this.rsp = new RSP(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this);
/*       */       } else {
/* 10961 */         this.rsp.RSP(this.USUARIO);
/*       */       } 
/* 10963 */       this.jTabbedPane2.addTab("Hojas de Recepción", this.jScrollPane1);
/* 10964 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void liquidaciones() {
/* 10969 */     if (existenDatos()) {
/* 10970 */       setCursor(new Cursor(3));
/* 10971 */       this.jTabbedPane2.removeAll();
/* 10972 */       if (this.liquidaciones == null) {
/* 10973 */         this.liquidaciones = new Liquidaciones(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry, this.CAMPOSGENERALES, false);
/*       */       } else {
/* 10975 */         this.liquidaciones.liquidaciones(this.USUARIO);
/*       */       } 
/* 10977 */       this.jTabbedPane2.addTab("Liquidaciones", this.jScrollPane1);
/* 10978 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void tarjetasDeudor() {
/* 10983 */     if (existenDatos()) {
/* 10984 */       setCursor(new Cursor(3));
/* 10985 */       this.jTabbedPane2.removeAll();
/* 10986 */       if (this.tarDeu == null) {
/* 10987 */         this.tarDeu = new TarjetasDeudoras(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry, this.CAMPOSGENERALES, false);
/*       */       } else {
/* 10989 */         this.tarDeu.tarjetas(this.USUARIO);
/*       */       } 
/* 10991 */       this.jTabbedPane2.addTab("Tarjetas de Deudor", this.jScrollPane1);
/* 10992 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void ValesSeg() {
/* 10997 */     if (existenDatos()) {
/* 10998 */       setCursor(new Cursor(3));
/* 10999 */       this.jTabbedPane2.removeAll();
/* 11000 */       if (this.vSeg == null) {
/* 11001 */         this.vSeg = new ValesSeguridad(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this);
/*       */       }
/* 11003 */       this.jTabbedPane2.addTab("Vales de Seguridad", this.jScrollPane1);
/* 11004 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void cajaChica() {
/* 11009 */     if (existenDatos()) {
/* 11010 */       setCursor(new Cursor(3));
/* 11011 */       this.jTabbedPane2.removeAll();
/* 11012 */       if (this.cajaCh == null) {
/* 11013 */         this.cajaCh = new cajaChica(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry);
/*       */       } else {
/* 11015 */         this.cajaCh.cajaChica(this.USUARIO);
/*       */       } 
/* 11017 */       this.jTabbedPane2.addTab("Caja Chica", this.jScrollPane1);
/* 11018 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void dieselCompletado() {
/* 11023 */     if (existenDatos()) {
/* 11024 */       setCursor(new Cursor(3));
/* 11025 */       this.jTabbedPane2.removeAll();
/* 11026 */       if (this.dieselComp == null) {
/* 11027 */         this.dieselComp = new DieselCompletado(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this);
/*       */       } else {
/* 11029 */         this.dieselComp.dieselCompletado(this.USUARIO);
/*       */       } 
/* 11031 */       this.jTabbedPane2.addTab("Diesel Completado", this.jScrollPane1);
/* 11032 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void provCuentasBancarias() {
/* 11037 */     if (existenDatos()) {
/* 11038 */       setCursor(new Cursor(3));
/* 11039 */       this.jTabbedPane2.removeAll();
/*       */       
/* 11041 */       if (this.provCuentasBancarias == null) {
/* 11042 */         this.provCuentasBancarias = new ProvCuentasBancarias(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry, this.jLabel36, this.CAMPOSGENERALES);
/*       */       } else {
/* 11044 */         this.provCuentasBancarias.cuentasBancarias(this.USUARIO);
/*       */       } 
/*       */       
/* 11047 */       this.jTabbedPane2.addTab("Cuentas Bancarias", this.jScrollPane1);
/* 11048 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void provTarjetaDeudor() {
/* 11053 */     if (existenDatos()) {
/* 11054 */       setCursor(new Cursor(3));
/* 11055 */       this.jTabbedPane2.removeAll();
/*       */       
/* 11057 */       if (this.provTarjetaDeudor == null) {
/* 11058 */         this.provTarjetaDeudor = new ProvTarjetaDeudor(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry, this.jLabel36, this.CAMPOSGENERALES);
/*       */       } else {
/* 11060 */         this.provTarjetaDeudor.tarjetaDeudor(this.USUARIO);
/*       */       } 
/* 11062 */       this.jTabbedPane2.addTab("Tarjeta Deudor", this.jScrollPane1);
/* 11063 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void provFacturas() {
/* 11068 */     if (existenDatos()) {
/* 11069 */       setCursor(new Cursor(3));
/* 11070 */       this.jTabbedPane2.removeAll();
/*       */       
/* 11072 */       if (this.provFacturas == null) {
/* 11073 */         this.provFacturas = new ProvFacturas(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry, this.jLabel36, this.CAMPOSGENERALES);
/*       */       } else {
/* 11075 */         this.provFacturas.facturas(this.USUARIO);
/*       */       } 
/* 11077 */       this.jTabbedPane2.addTab("Ingresar Facturas", this.jScrollPane1);
/* 11078 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void Proveedores() {
/* 11083 */     if (existenDatos()) {
/* 11084 */       setCursor(new Cursor(3));
/* 11085 */       this.jTabbedPane2.removeAll();
/*       */       
/* 11087 */       if (this.proveedores == null) {
/* 11088 */         this.proveedores = new Proveedores(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry, this.jLabel36, this.CAMPOSGENERALES);
/*       */       } else {
/* 11090 */         this.proveedores.proveedores(this.USUARIO);
/*       */       } 
/* 11092 */       this.jTabbedPane2.addTab("Proveedores", this.jScrollPane1);
/* 11093 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void Configuracion() {
/* 11098 */     if (existenDatos()) {
/* 11099 */       setCursor(new Cursor(3));
/* 11100 */       this.jTabbedPane2.removeAll();
/* 11101 */       if (this.config == null) {
/* 11102 */         this.config = new Configuracion(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.CAMPOSGENERALES);
/*       */       } else {
/* 11104 */         this.config.configuracion(this.USUARIO);
/*       */       } 
/* 11106 */       this.jTabbedPane2.addTab("Configuración", this.jScrollPane1);
/* 11107 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void cargarTipoCambio() {
/* 11112 */     this.utilerias.cargarTipoCambio(this.con, this.jLabel6, this.jLabel161);
/*       */   }
/*       */   
/*       */   public void cambiarContra() {
/* 11116 */     this.con.consultar("num_emp", "usuarios", "where nombre_usu = '" + this.USUARIO + "'");
/* 11117 */     String clave = this.con.Campo;
/* 11118 */     String[] campos = this.con.regresaReg("nombre,ap_pat,ap_mat", "empleados", "where CLAVE_emp = " + clave, 3);
/* 11119 */     this.error.pasarModal(true);
/* 11120 */     String contra = this.jPasswordField2.getText().toUpperCase();
/*       */     
/* 11122 */     if (!contra.matches("[a-zA-ZÑÁÉÍÓÚáéíóúñ0-9_,.!$%&/()=+{}]*")) {
/* 11123 */       this.error.cargarError(this.jPasswordField2, "004");
/* 11124 */     } else if (!contra.equals(this.jPasswordField3.getText().toUpperCase())) {
/* 11125 */       this.error.cargarError(this.jPasswordField2, "006");
/* 11126 */       this.jPasswordField3.setBackground(new Color(255, 51, 51));
/* 11127 */     } else if (contra.equals(this.USUARIO.toUpperCase())) {
/* 11128 */       this.error.cargarError(this.jPasswordField2, "008");
/* 11129 */     } else if (contra.equals(campos[0].toUpperCase())) {
/* 11130 */       this.error.cargarError(this.jPasswordField2, "025");
/* 11131 */     } else if (contra.equals(campos[1].toUpperCase())) {
/* 11132 */       this.error.cargarError(this.jPasswordField2, "011");
/* 11133 */     } else if (contra.equals(campos[2].toUpperCase())) {
/* 11134 */       this.error.cargarError(this.jPasswordField2, "012");
/* 11135 */     } else if (contra.length() < 6 || contra.length() > 30) {
/* 11136 */       this.error.cargarError(this.jPasswordField1, "009");
/*       */     } else {
/* 11138 */       contra = DigestUtils.md5Hex(this.jPasswordField2.getText());
/* 11139 */       this.con.insertar("update usuarios set contrasena='" + contra + "' where nombre_usu='" + this.USUARIO + "'");
/* 11140 */       this.con.bitacora("insert into bitacora(fecha,usuario,concepto)values(now(),'" + this.USUARIO + "','Cambió su contraseña' )");
/* 11141 */       this.jPasswordField2.setText("");
/* 11142 */       this.jPasswordField3.setText("");
/* 11143 */       this.jDialog1.setVisible(false);
/* 11144 */       this.con.consultar("priv", "usuarios", "where nombre_usu = '" + this.USUARIO + "'");
/* 11145 */       privilegios(this.con.Campo);
/*       */     } 
/*       */   }
/*       */   
/*       */   public void cambiar() {
/* 11150 */     if (existenDatos()) {
/* 11151 */       setVisible(false);
/* 11152 */       setEnabled(false);
/* 11153 */       this.jTextField1.setText("");
/* 11154 */       this.jPasswordField1.setText("");
/* 11155 */       this.jFrame1.setVisible(true);
/* 11156 */       desactivarPanel();
/* 11157 */       this.vecesMal = 0;
/*       */     } 
/*       */   }
/*       */   
/*       */   public void tarifas() {
/* 11162 */     if (existenDatos()) {
/* 11163 */       setCursor(new Cursor(3));
/* 11164 */       this.jTabbedPane2.removeAll();
/* 11165 */       if (this.tarifa == null) {
/* 11166 */         this.tarifa = new TarifaViaje(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this);
/*       */       } else {
/* 11168 */         this.tarifa.TarifaViaje(this.USUARIO);
/*       */       } 
/* 11170 */       this.jTabbedPane2.addTab("Tarificador de Viajes", this.jScrollPane1);
/* 11171 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void vacaciones() {
/* 11176 */     if (existenDatos()) {
/* 11177 */       setCursor(new Cursor(3));
/* 11178 */       this.jTabbedPane2.removeAll();
/* 11179 */       if (this.vaca == null) {
/* 11180 */         this.vaca = new Vacaciones(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this);
/*       */       } else {
/* 11182 */         this.vaca.Vacaciones(this.USUARIO);
/*       */       } 
/* 11184 */       this.jTabbedPane2.addTab("Vacaciones", this.jScrollPane1);
/* 11185 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void aguinaldos() {
/* 11190 */     if (existenDatos()) {
/* 11191 */       setCursor(new Cursor(3));
/* 11192 */       this.jTabbedPane2.removeAll();
/* 11193 */       if (this.aguinaldos == null) {
/* 11194 */         this.aguinaldos = new Aguinaldos(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this);
/*       */       } else {
/* 11196 */         this.aguinaldos.Aguinaldos(this.USUARIO);
/*       */       } 
/* 11198 */       this.jTabbedPane2.addTab("Aguinaldos", this.jScrollPane1);
/* 11199 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void finiquitos() {
/* 11204 */     if (existenDatos()) {
/* 11205 */       setCursor(new Cursor(3));
/* 11206 */       this.jTabbedPane2.removeAll();
/* 11207 */       if (this.fini == null) {
/* 11208 */         this.fini = new Finiquitos(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this);
/*       */       } else {
/* 11210 */         this.fini.finiquitos(this.USUARIO);
/*       */       } 
/* 11212 */       this.jTabbedPane2.addTab("Finiquitos", this.jScrollPane1);
/* 11213 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void nominas() {
/* 11218 */     if (existenDatos()) {
/* 11219 */       setCursor(new Cursor(3));
/* 11220 */       this.jTabbedPane2.removeAll();
/* 11221 */       if (this.nominas == null) {
/* 11222 */         this.nominas = new Nominas(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this);
/*       */       } else {
/* 11224 */         this.nominas.Nominas(this.USUARIO);
/*       */       } 
/* 11226 */       this.jTabbedPane2.addTab("Nóminas", this.jScrollPane1);
/* 11227 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   public void llenarCodigosPostales() {
/* 11233 */     Consultas con3 = new Consultas();
/* 11234 */     con3.setBaseDatos("sicre2PR");
/* 11235 */     String[][] cod = con3.buscarDatos(6, "num, codigo, c_Municipio, ciudad, c_estado, estado ", "tras_codigos_postales", "order by codigo");
/* 11236 */     for (String[] c : cod) {
/* 11237 */       this.CODIGOSP.add(new Tras_codigos(c[0], c[1], c[2], c[3], c[4], c[5]));
/* 11238 */       agregarCampo(this.LISTACODIGOS, c[1]);
/*       */     } 
/*       */   }
/*       */   
/*       */   public void agregarCampo(ArrayList<String> datos, String valor) {
/* 11243 */     if (!datos.contains(valor)) {
/* 11244 */       datos.add(valor);
/*       */     }
/*       */   }
/*       */   
/*       */   public void nominasComplementos() {
/* 11249 */     if (existenDatos()) {
/* 11250 */       setCursor(new Cursor(3));
/* 11251 */       this.jTabbedPane2.removeAll();
/* 11252 */       if (this.nominasComplementos == null) {
/* 11253 */         this.nominasComplementos = new NominasComplementos(this.jScrollPane1, this.jTabbedPane2, this.USUARIO, this, this.mensajeTry);
/*       */       } else {
/* 11255 */         this.nominasComplementos.Nominas(this.USUARIO);
/*       */       } 
/* 11257 */       this.jTabbedPane2.addTab("Nóminas Complementos", this.jScrollPane1);
/* 11258 */       cargarMouse();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void desactivarPanel() {
/* 11263 */     this.jTabbedPane2.removeAll();
/* 11264 */     this.jScrollPane1.setViewportView(this.jPanel2);
/* 11265 */     this.jTabbedPane2.addTab("Bienvenido", this.jScrollPane1);
/*       */   }
/*       */   
/*       */   public void privilegios(String depa) {
/* 11269 */     this.jLabel47.setEnabled(false);
/* 11270 */     this.jLabel48.setEnabled(false);
/* 11271 */     this.jLabel49.setEnabled(false);
/* 11272 */     this.jLabel54.setEnabled(false);
/* 11273 */     this.jLabel55.setEnabled(false);
/*       */     
/* 11275 */     this.jLabel73.setEnabled(false);
/* 11276 */     this.jLabel74.setEnabled(false);
/* 11277 */     this.jLabel75.setEnabled(false);
/* 11278 */     this.jLabel76.setEnabled(false);
/*       */     
/* 11280 */     this.jLabel77.setEnabled(false);
/* 11281 */     this.jLabel78.setEnabled(false);
/* 11282 */     this.jLabel79.setEnabled(false);
/* 11283 */     this.jLabel80.setEnabled(false);
/*       */     
/* 11285 */     this.jLabel81.setEnabled(false);
/* 11286 */     this.jLabel85.setEnabled(false);
/* 11287 */     this.jLabel86.setEnabled(false);
/* 11288 */     this.jLabel83.setEnabled(false);
/*       */     
/* 11290 */     this.jLabel82.setEnabled(false);
/* 11291 */     this.jLabel87.setEnabled(false);
/* 11292 */     this.jLabel84.setEnabled(false);
/* 11293 */     this.jLabel88.setEnabled(false);
/*       */     
/* 11295 */     this.jLabel90.setEnabled(false);
/* 11296 */     this.jLabel91.setEnabled(false);
/* 11297 */     this.jLabel92.setEnabled(false);
/*       */     
/* 11299 */     this.jLabel93.setEnabled(false);
/* 11300 */     this.jLabel94.setEnabled(false);
/* 11301 */     this.jLabel95.setEnabled(false);
/* 11302 */     this.jLabel96.setEnabled(false);
/*       */     
/* 11304 */     this.jLabel107.setEnabled(false);
/* 11305 */     this.jLabel108.setEnabled(false);
/*       */     
/* 11307 */     this.jLabel119.setEnabled(false);
/* 11308 */     this.jLabel120.setEnabled(false);
/*       */     
/* 11310 */     this.jLabel121.setEnabled(false);
/* 11311 */     this.jLabel122.setEnabled(false);
/*       */     
/* 11313 */     this.jLabel123.setEnabled(false);
/* 11314 */     this.jLabel124.setEnabled(false);
/* 11315 */     this.jLabel125.setEnabled(false);
/* 11316 */     this.jLabel126.setEnabled(false);
/* 11317 */     this.jLabel127.setEnabled(false);
/* 11318 */     this.jLabel128.setEnabled(false);
/* 11319 */     this.jLabel129.setEnabled(false);
/* 11320 */     this.jLabel130.setEnabled(false);
/* 11321 */     this.jLabel131.setEnabled(false);
/* 11322 */     this.jLabel132.setEnabled(false);
/* 11323 */     this.jLabel133.setEnabled(false);
/* 11324 */     this.jLabel134.setEnabled(false);
/*       */     
/* 11326 */     this.jLabel135.setEnabled(false);
/* 11327 */     this.jLabel136.setEnabled(false);
/* 11328 */     this.jLabel137.setEnabled(false);
/* 11329 */     this.jLabel138.setEnabled(false);
/* 11330 */     this.jLabel139.setEnabled(false);
/* 11331 */     this.jLabel140.setEnabled(false);
/* 11332 */     this.jLabel141.setEnabled(false);
/*       */     
/* 11334 */     this.jLabel144.setEnabled(false);
/* 11335 */     this.jLabel145.setEnabled(false);
/* 11336 */     this.jLabel146.setEnabled(false);
/*       */     
/* 11338 */     this.jLabel69.setEnabled(false);
/* 11339 */     this.jLabel70.setEnabled(false);
/* 11340 */     this.jLabel71.setEnabled(false);
/* 11341 */     this.jLabel72.setEnabled(false);
/* 11342 */     this.jLabel73.setEnabled(false);
/*       */     
/* 11344 */     this.jLabel65.setEnabled(false);
/* 11345 */     this.jLabel66.setEnabled(false);
/* 11346 */     this.jLabel67.setEnabled(false);
/* 11347 */     this.jLabel68.setEnabled(false);
/*       */     
/* 11349 */     this.jLabel147.setEnabled(false);
/* 11350 */     this.jLabel148.setEnabled(false);
/* 11351 */     this.jLabel149.setEnabled(false);
/* 11352 */     this.jLabel150.setEnabled(false);
/* 11353 */     this.jLabel151.setEnabled(false);
/*       */     
/* 11355 */     this.jLabel153.setEnabled(false);
/* 11356 */     this.jLabel101.setEnabled(false);
/* 11357 */     this.jLabel154.setEnabled(false);
/* 11358 */     this.jLabel155.setEnabled(false);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/* 11365 */     this.jMenu4.setEnabled(false);
/* 11366 */     this.jMenuItem2.setEnabled(false);
/* 11367 */     this.jMenuItem3.setEnabled(false);
/* 11368 */     this.jMenuItem7.setEnabled(false);
/* 11369 */     this.jMenuItem8.setEnabled(false);
/* 11370 */     this.jMenuItem10.setEnabled(false);
/*       */     
/* 11372 */     this.jMenuItem15.setEnabled(false);
/* 11373 */     this.jMenuItem16.setEnabled(false);
/* 11374 */     this.jMenuItem17.setEnabled(false);
/* 11375 */     this.jMenuItem18.setEnabled(false);
/* 11376 */     this.jMenuItem19.setEnabled(false);
/* 11377 */     this.jMenuItem20.setEnabled(false);
/* 11378 */     this.jMenuItem21.setEnabled(false);
/*       */     
/* 11380 */     this.jMenuItem9.setEnabled(false);
/* 11381 */     this.jMenuItem22.setEnabled(false);
/* 11382 */     this.jMenuItem23.setEnabled(false);
/* 11383 */     this.jMenuItem24.setEnabled(false);
/*       */     
/* 11385 */     this.jMenuItem25.setEnabled(false);
/* 11386 */     this.jMenuItem26.setEnabled(false);
/* 11387 */     this.jMenuItem27.setEnabled(false);
/* 11388 */     this.jMenuItem28.setEnabled(false);
/*       */     
/* 11390 */     this.jMenuItem40.setEnabled(false);
/* 11391 */     this.jMenuItem41.setEnabled(false);
/* 11392 */     this.jMenuItem42.setEnabled(false);
/* 11393 */     this.jMenuItem43.setEnabled(false);
/*       */     
/* 11395 */     this.jMenuItem44.setEnabled(false);
/* 11396 */     this.jMenuItem45.setEnabled(false);
/* 11397 */     this.jMenuItem46.setEnabled(false);
/* 11398 */     this.jMenuItem47.setEnabled(false);
/*       */     
/* 11400 */     this.jMenuItem29.setEnabled(false);
/* 11401 */     this.jMenuItem56.setEnabled(false);
/*       */     
/* 11403 */     this.jMenuItem30.setEnabled(false);
/* 11404 */     this.jMenuItem31.setEnabled(false);
/* 11405 */     this.jMenuItem32.setEnabled(false);
/* 11406 */     this.jMenuItem39.setEnabled(false);
/*       */     
/* 11408 */     this.jMenuItem33.setEnabled(false);
/* 11409 */     this.jMenuItem34.setEnabled(false);
/* 11410 */     this.jMenuItem35.setEnabled(false);
/* 11411 */     this.jMenuItem36.setEnabled(false);
/* 11412 */     this.jMenuItem37.setEnabled(false);
/* 11413 */     this.jMenuItem38.setEnabled(false);
/*       */     
/* 11415 */     this.jMenuItem48.setEnabled(false);
/* 11416 */     this.jMenuItem49.setEnabled(false);
/* 11417 */     this.jMenuItem50.setEnabled(false);
/* 11418 */     this.jMenuItem51.setEnabled(false);
/*       */     
/* 11420 */     this.jMenuItem52.setEnabled(false);
/* 11421 */     this.jMenuItem53.setEnabled(false);
/* 11422 */     this.jMenuItem54.setEnabled(false);
/* 11423 */     this.jMenuItem55.setEnabled(false);
/*       */     
/* 11425 */     this.jMenuItem57.setEnabled(false);
/* 11426 */     this.jMenuItem58.setEnabled(false);
/* 11427 */     this.jMenuItem59.setEnabled(false);
/*       */     
/* 11429 */     this.jMenuItem60.setEnabled(false);
/* 11430 */     this.jMenuItem61.setEnabled(false);
/*       */     
/* 11432 */     this.jMenuItem63.setEnabled(false);
/* 11433 */     this.jMenuItem64.setEnabled(false);
/* 11434 */     this.jMenuItem65.setEnabled(false);
/*       */     
/* 11436 */     this.jMenuItem66.setEnabled(false);
/* 11437 */     this.jMenuItem69.setEnabled(false);
/*       */     
/* 11439 */     this.jMenuItem70.setEnabled(false);
/* 11440 */     this.jMenuItem71.setEnabled(false);
/* 11441 */     this.jMenuItem72.setEnabled(false);
/* 11442 */     this.jMenuItem74.setEnabled(false);
/* 11443 */     this.jMenuItem76.setEnabled(false);
/*       */     
/* 11445 */     if (depa.equals("SUPER USUARIO")) {
/* 11446 */       this.jMenuItem63.setEnabled(true);
/* 11447 */       this.jMenuItem64.setEnabled(true);
/* 11448 */       this.jMenuItem65.setEnabled(true);
/*       */ 
/*       */       
/* 11451 */       this.jLabel47.setEnabled(true);
/* 11452 */       this.jLabel48.setEnabled(true);
/* 11453 */       this.jLabel49.setEnabled(true);
/* 11454 */       this.jLabel54.setEnabled(true);
/* 11455 */       this.jLabel55.setEnabled(true);
/*       */       
/* 11457 */       this.jLabel73.setEnabled(true);
/* 11458 */       this.jLabel74.setEnabled(true);
/* 11459 */       this.jLabel75.setEnabled(true);
/* 11460 */       this.jLabel76.setEnabled(true);
/*       */       
/* 11462 */       this.jLabel77.setEnabled(true);
/* 11463 */       this.jLabel78.setEnabled(true);
/* 11464 */       this.jLabel79.setEnabled(true);
/* 11465 */       this.jLabel80.setEnabled(true);
/*       */       
/* 11467 */       this.jLabel81.setEnabled(true);
/* 11468 */       this.jLabel85.setEnabled(true);
/* 11469 */       this.jLabel86.setEnabled(true);
/* 11470 */       this.jLabel83.setEnabled(true);
/*       */       
/* 11472 */       this.jLabel82.setEnabled(true);
/* 11473 */       this.jLabel87.setEnabled(true);
/* 11474 */       this.jLabel84.setEnabled(true);
/* 11475 */       this.jLabel88.setEnabled(true);
/*       */       
/* 11477 */       this.jLabel90.setEnabled(true);
/* 11478 */       this.jLabel91.setEnabled(true);
/* 11479 */       this.jLabel92.setEnabled(true);
/*       */       
/* 11481 */       this.jLabel93.setEnabled(true);
/* 11482 */       this.jLabel94.setEnabled(true);
/* 11483 */       this.jLabel95.setEnabled(true);
/* 11484 */       this.jLabel96.setEnabled(true);
/*       */       
/* 11486 */       this.jLabel107.setEnabled(true);
/* 11487 */       this.jLabel108.setEnabled(true);
/*       */       
/* 11489 */       this.jLabel119.setEnabled(true);
/* 11490 */       this.jLabel120.setEnabled(true);
/*       */       
/* 11492 */       this.jLabel121.setEnabled(true);
/* 11493 */       this.jLabel122.setEnabled(true);
/*       */       
/* 11495 */       this.jLabel123.setEnabled(true);
/* 11496 */       this.jLabel124.setEnabled(true);
/* 11497 */       this.jLabel125.setEnabled(true);
/* 11498 */       this.jLabel126.setEnabled(true);
/* 11499 */       this.jLabel127.setEnabled(true);
/* 11500 */       this.jLabel128.setEnabled(true);
/* 11501 */       this.jLabel129.setEnabled(true);
/* 11502 */       this.jLabel130.setEnabled(true);
/* 11503 */       this.jLabel131.setEnabled(true);
/* 11504 */       this.jLabel132.setEnabled(true);
/* 11505 */       this.jLabel133.setEnabled(true);
/* 11506 */       this.jLabel134.setEnabled(true);
/*       */       
/* 11508 */       this.jLabel135.setEnabled(true);
/* 11509 */       this.jLabel136.setEnabled(true);
/* 11510 */       this.jLabel137.setEnabled(true);
/* 11511 */       this.jLabel138.setEnabled(true);
/* 11512 */       this.jLabel139.setEnabled(true);
/* 11513 */       this.jLabel140.setEnabled(true);
/* 11514 */       this.jLabel141.setEnabled(true);
/*       */       
/* 11516 */       this.jLabel144.setEnabled(true);
/* 11517 */       this.jLabel145.setEnabled(true);
/* 11518 */       this.jLabel146.setEnabled(true);
/*       */       
/* 11520 */       this.jLabel69.setEnabled(true);
/* 11521 */       this.jLabel70.setEnabled(true);
/* 11522 */       this.jLabel71.setEnabled(true);
/* 11523 */       this.jLabel72.setEnabled(true);
/* 11524 */       this.jLabel73.setEnabled(true);
/*       */       
/* 11526 */       this.jLabel65.setEnabled(true);
/* 11527 */       this.jLabel66.setEnabled(true);
/* 11528 */       this.jLabel67.setEnabled(true);
/* 11529 */       this.jLabel68.setEnabled(true);
/*       */       
/* 11531 */       this.jLabel147.setEnabled(true);
/* 11532 */       this.jLabel148.setEnabled(true);
/* 11533 */       this.jLabel149.setEnabled(true);
/* 11534 */       this.jLabel150.setEnabled(true);
/* 11535 */       this.jLabel151.setEnabled(true);
/*       */       
/* 11537 */       this.jLabel153.setEnabled(true);
/* 11538 */       this.jLabel101.setEnabled(true);
/* 11539 */       this.jLabel154.setEnabled(true);
/* 11540 */       this.jLabel155.setEnabled(true);
/*       */ 
/*       */       
/* 11543 */       this.jMenu4.setEnabled(true);
/* 11544 */       this.jMenuItem2.setEnabled(true);
/* 11545 */       this.jMenuItem3.setEnabled(true);
/* 11546 */       this.jMenuItem7.setEnabled(true);
/* 11547 */       this.jMenuItem8.setEnabled(true);
/* 11548 */       this.jMenuItem10.setEnabled(true);
/*       */       
/* 11550 */       this.jMenuItem15.setEnabled(true);
/* 11551 */       this.jMenuItem16.setEnabled(true);
/* 11552 */       this.jMenuItem17.setEnabled(true);
/* 11553 */       this.jMenuItem18.setEnabled(true);
/* 11554 */       this.jMenuItem19.setEnabled(true);
/* 11555 */       this.jMenuItem20.setEnabled(true);
/* 11556 */       this.jMenuItem21.setEnabled(true);
/*       */       
/* 11558 */       this.jMenuItem9.setEnabled(true);
/* 11559 */       this.jMenuItem22.setEnabled(true);
/* 11560 */       this.jMenuItem23.setEnabled(true);
/* 11561 */       this.jMenuItem24.setEnabled(true);
/*       */       
/* 11563 */       this.jMenuItem25.setEnabled(true);
/* 11564 */       this.jMenuItem26.setEnabled(true);
/* 11565 */       this.jMenuItem27.setEnabled(true);
/* 11566 */       this.jMenuItem28.setEnabled(true);
/*       */       
/* 11568 */       this.jMenuItem40.setEnabled(true);
/* 11569 */       this.jMenuItem41.setEnabled(true);
/* 11570 */       this.jMenuItem42.setEnabled(true);
/* 11571 */       this.jMenuItem43.setEnabled(true);
/*       */       
/* 11573 */       this.jMenuItem44.setEnabled(true);
/* 11574 */       this.jMenuItem45.setEnabled(true);
/* 11575 */       this.jMenuItem46.setEnabled(true);
/* 11576 */       this.jMenuItem47.setEnabled(true);
/*       */       
/* 11578 */       this.jMenuItem29.setEnabled(true);
/* 11579 */       this.jMenuItem56.setEnabled(true);
/*       */       
/* 11581 */       this.jMenuItem30.setEnabled(true);
/* 11582 */       this.jMenuItem31.setEnabled(true);
/* 11583 */       this.jMenuItem32.setEnabled(true);
/* 11584 */       this.jMenuItem39.setEnabled(true);
/*       */       
/* 11586 */       this.jMenuItem33.setEnabled(true);
/* 11587 */       this.jMenuItem34.setEnabled(true);
/* 11588 */       this.jMenuItem35.setEnabled(true);
/* 11589 */       this.jMenuItem36.setEnabled(true);
/* 11590 */       this.jMenuItem37.setEnabled(true);
/* 11591 */       this.jMenuItem38.setEnabled(true);
/*       */       
/* 11593 */       this.jMenuItem48.setEnabled(true);
/* 11594 */       this.jMenuItem49.setEnabled(true);
/* 11595 */       this.jMenuItem50.setEnabled(true);
/* 11596 */       this.jMenuItem51.setEnabled(true);
/*       */       
/* 11598 */       this.jMenuItem52.setEnabled(true);
/* 11599 */       this.jMenuItem53.setEnabled(true);
/* 11600 */       this.jMenuItem54.setEnabled(true);
/* 11601 */       this.jMenuItem55.setEnabled(true);
/*       */       
/* 11603 */       this.jMenuItem57.setEnabled(true);
/* 11604 */       this.jMenuItem58.setEnabled(true);
/* 11605 */       this.jMenuItem59.setEnabled(true);
/*       */       
/* 11607 */       this.jMenuItem60.setEnabled(true);
/* 11608 */       this.jMenuItem61.setEnabled(true);
/*       */       
/* 11610 */       this.jMenuItem66.setEnabled(true);
/* 11611 */       this.jMenuItem69.setEnabled(true);
/*       */       
/* 11613 */       this.jMenuItem70.setEnabled(true);
/* 11614 */       this.jMenuItem71.setEnabled(true);
/* 11615 */       this.jMenuItem72.setEnabled(true);
/* 11616 */       this.jMenuItem74.setEnabled(true);
/* 11617 */       this.jMenuItem76.setEnabled(true);
/*       */     }
/* 11619 */     else if (depa.equals("JEFE DE LIQUIDACIONES")) {
/* 11620 */       this.jLabel47.setEnabled(true);
/* 11621 */       this.jLabel49.setEnabled(true);
/* 11622 */       this.jLabel48.setEnabled(true);
/* 11623 */       this.jLabel73.setEnabled(true);
/* 11624 */       this.jLabel74.setEnabled(true);
/* 11625 */       this.jLabel76.setEnabled(true);
/* 11626 */       this.jLabel77.setEnabled(true);
/* 11627 */       this.jLabel78.setEnabled(true);
/* 11628 */       this.jLabel80.setEnabled(true);
/* 11629 */       this.jLabel81.setEnabled(true);
/* 11630 */       this.jLabel85.setEnabled(true);
/* 11631 */       this.jLabel86.setEnabled(true);
/* 11632 */       this.jLabel82.setEnabled(true);
/* 11633 */       this.jLabel87.setEnabled(true);
/* 11634 */       this.jLabel84.setEnabled(true);
/* 11635 */       this.jLabel90.setEnabled(true);
/* 11636 */       this.jLabel91.setEnabled(true);
/* 11637 */       this.jLabel92.setEnabled(true);
/* 11638 */       this.jLabel119.setEnabled(true);
/* 11639 */       this.jLabel132.setEnabled(true);
/* 11640 */       this.jLabel72.setEnabled(true);
/* 11641 */       this.jLabel68.setEnabled(true);
/*       */       
/* 11643 */       this.jMenuItem3.setEnabled(true);
/* 11644 */       this.jMenuItem7.setEnabled(true);
/* 11645 */       this.jMenuItem8.setEnabled(true);
/*       */       
/* 11647 */       this.jMenuItem52.setEnabled(true);
/* 11648 */       this.jMenuItem53.setEnabled(true);
/* 11649 */       this.jMenuItem54.setEnabled(true);
/* 11650 */       this.jMenuItem55.setEnabled(true);
/*       */       
/* 11652 */       this.jMenuItem40.setEnabled(true);
/* 11653 */       this.jMenuItem41.setEnabled(true);
/* 11654 */       this.jMenuItem42.setEnabled(true);
/* 11655 */       this.jMenuItem43.setEnabled(true);
/*       */       
/* 11657 */       this.jMenuItem9.setEnabled(true);
/* 11658 */       this.jMenuItem22.setEnabled(true);
/* 11659 */       this.jMenuItem23.setEnabled(true);
/* 11660 */       this.jMenuItem24.setEnabled(true);
/* 11661 */       this.jMenuItem25.setEnabled(true);
/*       */       
/* 11663 */       this.jMenuItem44.setEnabled(true);
/* 11664 */       this.jMenuItem45.setEnabled(true);
/* 11665 */       this.jMenuItem46.setEnabled(true);
/* 11666 */       this.jMenuItem47.setEnabled(true);
/*       */       
/* 11668 */       this.jMenuItem25.setEnabled(true);
/* 11669 */       this.jMenuItem26.setEnabled(true);
/* 11670 */       this.jMenuItem27.setEnabled(true);
/* 11671 */       this.jMenuItem28.setEnabled(true);
/*       */       
/* 11673 */       this.jMenuItem15.setEnabled(true);
/*       */       
/* 11675 */       this.jMenuItem33.setEnabled(true);
/*       */       
/* 11677 */       this.jMenuItem40.setEnabled(true);
/*       */       
/* 11679 */       this.jMenuItem18.setEnabled(true);
/* 11680 */       this.jMenuItem17.setEnabled(true);
/*       */       
/* 11682 */       this.jMenuItem20.setEnabled(true);
/* 11683 */     } else if (depa.equals("RECURSOS HUMANOS")) {
/* 11684 */       this.jLabel54.setEnabled(true);
/* 11685 */       this.jLabel86.setEnabled(true);
/* 11686 */       this.jLabel84.setEnabled(true);
/* 11687 */       this.jLabel132.setEnabled(true);
/* 11688 */       this.jLabel136.setEnabled(true);
/* 11689 */       this.jLabel137.setEnabled(true);
/* 11690 */       this.jLabel140.setEnabled(true);
/* 11691 */       this.jLabel144.setEnabled(true);
/* 11692 */       this.jLabel145.setEnabled(true);
/* 11693 */       this.jLabel146.setEnabled(true);
/* 11694 */       this.jLabel69.setEnabled(true);
/* 11695 */       this.jLabel70.setEnabled(true);
/* 11696 */       this.jLabel71.setEnabled(true);
/* 11697 */       this.jLabel72.setEnabled(true);
/* 11698 */       this.jLabel65.setEnabled(true);
/* 11699 */       this.jLabel66.setEnabled(true);
/* 11700 */       this.jLabel67.setEnabled(true);
/* 11701 */       this.jLabel68.setEnabled(true);
/*       */       
/* 11703 */       this.jLabel147.setEnabled(true);
/* 11704 */       this.jLabel148.setEnabled(true);
/* 11705 */       this.jLabel149.setEnabled(true);
/* 11706 */       this.jLabel150.setEnabled(true);
/* 11707 */       this.jLabel151.setEnabled(true);
/*       */       
/* 11709 */       this.jMenuItem52.setEnabled(true);
/* 11710 */       this.jMenuItem53.setEnabled(true);
/* 11711 */       this.jMenuItem54.setEnabled(true);
/* 11712 */       this.jMenuItem55.setEnabled(true);
/*       */       
/* 11714 */       this.jMenuItem48.setEnabled(true);
/* 11715 */       this.jMenuItem49.setEnabled(true);
/* 11716 */       this.jMenuItem50.setEnabled(true);
/* 11717 */       this.jMenuItem51.setEnabled(true);
/*       */       
/* 11719 */       this.jMenuItem19.setEnabled(true);
/*       */       
/* 11721 */       this.jMenuItem18.setEnabled(true);
/*       */       
/* 11723 */       this.jMenuItem43.setEnabled(true);
/* 11724 */       this.jMenuItem47.setEnabled(true);
/* 11725 */       this.jMenuItem24.setEnabled(true);
/* 11726 */       this.jMenuItem28.setEnabled(true);
/*       */       
/* 11728 */       this.jMenuItem20.setEnabled(true);
/* 11729 */       this.jMenuItem33.setEnabled(true);
/* 11730 */       this.jMenuItem57.setEnabled(true);
/* 11731 */       this.jMenuItem59.setEnabled(true);
/* 11732 */       this.jMenuItem58.setEnabled(true);
/*       */       
/* 11734 */       this.jMenuItem70.setEnabled(true);
/* 11735 */       this.jMenuItem71.setEnabled(true);
/* 11736 */       this.jMenuItem72.setEnabled(true);
/* 11737 */       this.jMenuItem74.setEnabled(true);
/* 11738 */       this.jMenuItem76.setEnabled(true);
/*       */     }
/* 11740 */     else if (depa.equals("TRÁFICO")) {
/* 11741 */       this.jLabel47.setEnabled(true);
/* 11742 */       this.jLabel48.setEnabled(true);
/* 11743 */       this.jLabel49.setEnabled(true);
/* 11744 */       this.jLabel55.setEnabled(true);
/*       */       
/* 11746 */       this.jLabel153.setEnabled(true);
/* 11747 */       this.jLabel101.setEnabled(true);
/* 11748 */       this.jLabel154.setEnabled(true);
/* 11749 */       this.jLabel155.setEnabled(true);
/*       */       
/* 11751 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 11752 */       String ahora = "2020-11-02 12:00:23";
/* 11753 */       Date fechaConHora = null;
/*       */       try {
/* 11755 */         fechaConHora = sdf.parse(ahora);
/* 11756 */       } catch (ParseException ex) {
/* 11757 */         Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, (String)null, ex);
/*       */       } 
/*       */       
/* 11760 */       if (getNTPDate().after(fechaConHora)) {
/* 11761 */         this.jLabel68.setEnabled(false);
/*       */       } else {
/* 11763 */         this.jLabel68.setEnabled(true);
/*       */       } 
/*       */       
/* 11766 */       this.jLabel76.setEnabled(true);
/* 11767 */       this.jLabel80.setEnabled(true);
/* 11768 */       this.jLabel81.setEnabled(true);
/* 11769 */       this.jLabel86.setEnabled(true);
/* 11770 */       this.jLabel82.setEnabled(true);
/* 11771 */       this.jLabel84.setEnabled(true);
/* 11772 */       this.jLabel132.setEnabled(true);
/*       */       
/* 11774 */       this.jMenuItem55.setEnabled(true);
/* 11775 */       this.jMenuItem2.setEnabled(true);
/* 11776 */       this.jMenuItem3.setEnabled(true);
/* 11777 */       this.jMenuItem7.setEnabled(true);
/* 11778 */       this.jMenuItem8.setEnabled(true);
/* 11779 */       this.jMenuItem24.setEnabled(true);
/* 11780 */       this.jMenuItem28.setEnabled(true);
/* 11781 */       this.jMenuItem9.setEnabled(true);
/* 11782 */       this.jMenuItem33.setEnabled(true);
/* 11783 */       this.jMenuItem25.setEnabled(true);
/* 11784 */       this.jMenuItem43.setEnabled(true);
/* 11785 */       this.jMenuItem47.setEnabled(true);
/* 11786 */       this.jMenuItem10.setEnabled(true);
/* 11787 */     } else if (depa.equals("JEFE DE TRÁFICO")) {
/* 11788 */       this.jLabel47.setEnabled(true);
/* 11789 */       this.jLabel48.setEnabled(true);
/* 11790 */       this.jLabel49.setEnabled(true);
/* 11791 */       this.jLabel55.setEnabled(true);
/* 11792 */       this.jLabel76.setEnabled(true);
/* 11793 */       this.jLabel80.setEnabled(true);
/* 11794 */       this.jLabel81.setEnabled(true);
/* 11795 */       this.jLabel83.setEnabled(true);
/* 11796 */       this.jLabel85.setEnabled(true);
/* 11797 */       this.jLabel86.setEnabled(true);
/* 11798 */       this.jLabel82.setEnabled(true);
/* 11799 */       this.jLabel84.setEnabled(true);
/* 11800 */       this.jLabel87.setEnabled(true);
/* 11801 */       this.jLabel88.setEnabled(true);
/* 11802 */       this.jLabel132.setEnabled(true);
/* 11803 */       this.jLabel140.setEnabled(true);
/* 11804 */       this.jLabel68.setEnabled(true);
/*       */       
/* 11806 */       this.jMenuItem55.setEnabled(true);
/* 11807 */       this.jMenuItem2.setEnabled(true);
/* 11808 */       this.jMenuItem3.setEnabled(true);
/* 11809 */       this.jMenuItem7.setEnabled(true);
/* 11810 */       this.jMenuItem8.setEnabled(true);
/* 11811 */       this.jMenuItem24.setEnabled(true);
/* 11812 */       this.jMenuItem28.setEnabled(true);
/* 11813 */       this.jMenuItem9.setEnabled(true);
/* 11814 */       this.jMenuItem22.setEnabled(true);
/* 11815 */       this.jMenuItem23.setEnabled(true);
/* 11816 */       this.jMenuItem25.setEnabled(true);
/* 11817 */       this.jMenuItem47.setEnabled(true);
/* 11818 */       this.jMenuItem33.setEnabled(true);
/*       */       
/* 11820 */       this.jMenuItem27.setEnabled(true);
/* 11821 */       this.jMenuItem26.setEnabled(true);
/* 11822 */       this.jMenuItem43.setEnabled(true);
/* 11823 */       this.jMenuItem20.setEnabled(true);
/* 11824 */       this.jMenuItem10.setEnabled(true);
/* 11825 */       this.jMenuItem55.setEnabled(true);
/* 11826 */     } else if (depa.equals("FACTURACIÓN")) {
/* 11827 */       this.jLabel49.setEnabled(true);
/* 11828 */       this.jLabel48.setEnabled(true);
/* 11829 */       this.jLabel73.setEnabled(true);
/* 11830 */       this.jLabel76.setEnabled(true);
/* 11831 */       this.jLabel77.setEnabled(true);
/* 11832 */       this.jLabel80.setEnabled(true);
/* 11833 */       this.jLabel86.setEnabled(true);
/* 11834 */       this.jLabel84.setEnabled(true);
/* 11835 */       this.jLabel92.setEnabled(true);
/* 11836 */       this.jLabel119.setEnabled(true);
/* 11837 */       this.jLabel121.setEnabled(true);
/* 11838 */       this.jLabel123.setEnabled(true);
/* 11839 */       this.jLabel124.setEnabled(true);
/* 11840 */       this.jLabel125.setEnabled(true);
/* 11841 */       this.jLabel126.setEnabled(true);
/* 11842 */       this.jLabel127.setEnabled(true);
/* 11843 */       this.jLabel128.setEnabled(true);
/* 11844 */       this.jLabel129.setEnabled(true);
/* 11845 */       this.jLabel130.setEnabled(true);
/* 11846 */       this.jLabel131.setEnabled(true);
/* 11847 */       this.jLabel132.setEnabled(true);
/* 11848 */       this.jLabel133.setEnabled(true);
/* 11849 */       this.jLabel134.setEnabled(true);
/*       */       
/* 11851 */       this.jMenuItem3.setEnabled(true);
/* 11852 */       this.jMenuItem7.setEnabled(true);
/* 11853 */       this.jMenuItem30.setEnabled(true);
/* 11854 */       this.jMenuItem40.setEnabled(true);
/* 11855 */       this.jMenuItem43.setEnabled(true);
/* 11856 */       this.jMenuItem24.setEnabled(true);
/*       */       
/* 11858 */       this.jMenuItem28.setEnabled(true);
/* 11859 */       this.jMenuItem47.setEnabled(true);
/* 11860 */       this.jMenuItem40.setEnabled(true);
/* 11861 */       this.jMenuItem63.setEnabled(true);
/* 11862 */       this.jMenuItem55.setEnabled(true);
/* 11863 */       this.jMenuItem29.setEnabled(true);
/* 11864 */       this.jMenuItem56.setEnabled(true);
/* 11865 */       this.jMenuItem34.setEnabled(true);
/* 11866 */       this.jMenuItem31.setEnabled(true);
/*       */       
/* 11868 */       this.jMenuItem32.setEnabled(true);
/* 11869 */       this.jMenuItem39.setEnabled(true);
/* 11870 */       this.jMenuItem36.setEnabled(true);
/* 11871 */       this.jMenuItem35.setEnabled(true);
/*       */       
/* 11873 */       this.jMenuItem33.setEnabled(true);
/* 11874 */       this.jMenuItem38.setEnabled(true);
/* 11875 */       this.jMenuItem37.setEnabled(true);
/* 11876 */       this.jMenuItem66.setEnabled(true);
/* 11877 */       this.jMenuItem69.setEnabled(true);
/*       */       
/* 11879 */       if (this.USUARIO.equals("REPORTES")) {
/* 11880 */         this.jLabel49.setEnabled(false);
/*       */         
/* 11882 */         this.jLabel147.setEnabled(true);
/* 11883 */         this.jLabel149.setEnabled(true);
/* 11884 */         this.jLabel148.setEnabled(true);
/* 11885 */         this.jLabel151.setEnabled(true);
/* 11886 */         this.jLabel150.setEnabled(true);
/*       */         
/* 11888 */         this.jLabel153.setEnabled(true);
/* 11889 */         this.jLabel101.setEnabled(true);
/* 11890 */         this.jLabel154.setEnabled(true);
/*       */       }
/*       */     
/* 11893 */     } else if (depa.equals("LIQUIDACIONES")) {
/* 11894 */       this.jLabel49.setEnabled(true);
/* 11895 */       this.jLabel54.setEnabled(true);
/* 11896 */       this.jLabel76.setEnabled(true);
/* 11897 */       this.jLabel80.setEnabled(true);
/* 11898 */       this.jLabel86.setEnabled(true);
/* 11899 */       this.jLabel84.setEnabled(true);
/* 11900 */       this.jLabel132.setEnabled(true);
/* 11901 */       this.jLabel135.setEnabled(true);
/* 11902 */       this.jLabel136.setEnabled(true);
/* 11903 */       this.jLabel137.setEnabled(true);
/* 11904 */       this.jLabel138.setEnabled(true);
/* 11905 */       this.jLabel139.setEnabled(true);
/* 11906 */       this.jLabel140.setEnabled(true);
/* 11907 */       this.jLabel68.setEnabled(true);
/* 11908 */       this.jLabel155.setEnabled(true);
/*       */       
/* 11910 */       this.jMenuItem3.setEnabled(true);
/* 11911 */       this.jMenuItem55.setEnabled(true);
/* 11912 */       this.jMenuItem19.setEnabled(true);
/* 11913 */       this.jMenuItem15.setEnabled(true);
/* 11914 */       this.jMenuItem17.setEnabled(true);
/* 11915 */       this.jMenuItem18.setEnabled(true);
/* 11916 */       this.jMenuItem43.setEnabled(true);
/* 11917 */       this.jMenuItem47.setEnabled(true);
/* 11918 */       this.jMenuItem24.setEnabled(true);
/* 11919 */       this.jMenuItem28.setEnabled(true);
/* 11920 */       this.jMenuItem16.setEnabled(true);
/* 11921 */       this.jMenuItem20.setEnabled(true);
/* 11922 */       this.jMenuItem33.setEnabled(true);
/* 11923 */     } else if (depa.equals("GERENTE DE OPERACIONES")) {
/* 11924 */       this.jLabel47.setEnabled(true);
/* 11925 */       this.jLabel49.setEnabled(true);
/* 11926 */       this.jLabel48.setEnabled(true);
/* 11927 */       this.jLabel55.setEnabled(true);
/* 11928 */       this.jLabel73.setEnabled(true);
/* 11929 */       this.jLabel76.setEnabled(true);
/* 11930 */       this.jLabel77.setEnabled(true);
/* 11931 */       this.jLabel78.setEnabled(true);
/* 11932 */       this.jLabel80.setEnabled(true);
/* 11933 */       this.jLabel81.setEnabled(true);
/* 11934 */       this.jLabel85.setEnabled(true);
/* 11935 */       this.jLabel86.setEnabled(true);
/* 11936 */       this.jLabel82.setEnabled(true);
/* 11937 */       this.jLabel84.setEnabled(true);
/* 11938 */       this.jLabel87.setEnabled(true);
/* 11939 */       this.jLabel90.setEnabled(true);
/* 11940 */       this.jLabel91.setEnabled(true);
/* 11941 */       this.jLabel92.setEnabled(true);
/* 11942 */       this.jLabel119.setEnabled(true);
/* 11943 */       this.jLabel121.setEnabled(true);
/* 11944 */       this.jLabel132.setEnabled(true);
/* 11945 */       this.jLabel54.setEnabled(true);
/* 11946 */       this.jLabel136.setEnabled(true);
/* 11947 */       this.jLabel141.setEnabled(true);
/* 11948 */       this.jLabel68.setEnabled(true);
/*       */       
/* 11950 */       this.jLabel153.setEnabled(true);
/* 11951 */       this.jLabel101.setEnabled(true);
/* 11952 */       this.jLabel154.setEnabled(true);
/* 11953 */       this.jLabel155.setEnabled(true);
/*       */       
/* 11955 */       this.jMenuItem2.setEnabled(true);
/* 11956 */       this.jMenuItem3.setEnabled(true);
/* 11957 */       this.jMenuItem7.setEnabled(true);
/* 11958 */       this.jMenuItem8.setEnabled(true);
/* 11959 */       this.jMenuItem52.setEnabled(true);
/* 11960 */       this.jMenuItem55.setEnabled(true);
/*       */       
/* 11962 */       this.jMenuItem41.setEnabled(true);
/* 11963 */       this.jMenuItem40.setEnabled(true);
/* 11964 */       this.jMenuItem43.setEnabled(true);
/*       */       
/* 11966 */       this.jMenuItem9.setEnabled(true);
/* 11967 */       this.jMenuItem24.setEnabled(true);
/* 11968 */       this.jMenuItem22.setEnabled(true);
/* 11969 */       this.jMenuItem19.setEnabled(true);
/*       */       
/* 11971 */       this.jMenuItem47.setEnabled(true);
/* 11972 */       this.jMenuItem44.setEnabled(true);
/* 11973 */       this.jMenuItem45.setEnabled(true);
/*       */       
/* 11975 */       this.jMenuItem25.setEnabled(true);
/* 11976 */       this.jMenuItem28.setEnabled(true);
/* 11977 */       this.jMenuItem26.setEnabled(true);
/*       */       
/* 11979 */       this.jMenuItem65.setEnabled(true);
/* 11980 */       this.jMenuItem64.setEnabled(true);
/* 11981 */       this.jMenuItem63.setEnabled(true);
/*       */       
/* 11983 */       this.jMenuItem56.setEnabled(true);
/* 11984 */       this.jMenuItem29.setEnabled(true);
/* 11985 */       this.jMenuItem33.setEnabled(true);
/* 11986 */       this.jMenuItem21.setEnabled(true);
/* 11987 */       this.jMenuItem10.setEnabled(true);
/* 11988 */     } else if (depa.equals("ADMINISTRADOR")) {
/* 11989 */       this.jLabel47.setEnabled(true);
/* 11990 */       this.jLabel48.setEnabled(true);
/* 11991 */       this.jLabel49.setEnabled(true);
/* 11992 */       this.jLabel73.setEnabled(true);
/* 11993 */       this.jLabel74.setEnabled(true);
/* 11994 */       this.jLabel76.setEnabled(true);
/* 11995 */       this.jLabel77.setEnabled(true);
/* 11996 */       this.jLabel78.setEnabled(true);
/* 11997 */       this.jLabel80.setEnabled(true);
/* 11998 */       this.jLabel81.setEnabled(true);
/* 11999 */       this.jLabel85.setEnabled(true);
/* 12000 */       this.jLabel86.setEnabled(true);
/* 12001 */       this.jLabel82.setEnabled(true);
/* 12002 */       this.jLabel84.setEnabled(true);
/* 12003 */       this.jLabel87.setEnabled(true);
/* 12004 */       this.jLabel90.setEnabled(true);
/* 12005 */       this.jLabel91.setEnabled(true);
/* 12006 */       this.jLabel92.setEnabled(true);
/* 12007 */       this.jLabel119.setEnabled(true);
/* 12008 */       this.jLabel121.setEnabled(true);
/* 12009 */       this.jLabel132.setEnabled(true);
/* 12010 */       this.jLabel72.setEnabled(true);
/* 12011 */       this.jLabel68.setEnabled(true);
/*       */       
/* 12013 */       this.jLabel153.setEnabled(true);
/* 12014 */       this.jLabel101.setEnabled(true);
/* 12015 */       this.jLabel154.setEnabled(true);
/* 12016 */       this.jLabel155.setEnabled(true);
/*       */       
/* 12018 */       this.jMenuItem2.setEnabled(true);
/* 12019 */       this.jMenuItem3.setEnabled(true);
/* 12020 */       this.jMenuItem7.setEnabled(true);
/* 12021 */       this.jMenuItem8.setEnabled(true);
/* 12022 */       this.jMenuItem55.setEnabled(true);
/*       */       
/* 12024 */       this.jMenuItem41.setEnabled(true);
/* 12025 */       this.jMenuItem40.setEnabled(true);
/* 12026 */       this.jMenuItem43.setEnabled(true);
/*       */       
/* 12028 */       this.jMenuItem9.setEnabled(true);
/* 12029 */       this.jMenuItem24.setEnabled(true);
/* 12030 */       this.jMenuItem22.setEnabled(true);
/*       */       
/* 12032 */       this.jMenuItem47.setEnabled(true);
/* 12033 */       this.jMenuItem44.setEnabled(true);
/* 12034 */       this.jMenuItem45.setEnabled(true);
/*       */       
/* 12036 */       this.jMenuItem25.setEnabled(true);
/* 12037 */       this.jMenuItem28.setEnabled(true);
/* 12038 */       this.jMenuItem26.setEnabled(true);
/*       */       
/* 12040 */       this.jMenuItem65.setEnabled(true);
/* 12041 */       this.jMenuItem64.setEnabled(true);
/* 12042 */       this.jMenuItem63.setEnabled(true);
/*       */       
/* 12044 */       this.jMenuItem56.setEnabled(true);
/* 12045 */       this.jMenuItem30.setEnabled(true);
/* 12046 */       this.jMenuItem29.setEnabled(true);
/*       */       
/* 12048 */       this.jMenuItem34.setEnabled(true);
/* 12049 */       this.jMenuItem31.setEnabled(true);
/*       */       
/* 12051 */       this.jMenuItem32.setEnabled(true);
/* 12052 */       this.jMenuItem39.setEnabled(true);
/* 12053 */       this.jMenuItem36.setEnabled(true);
/* 12054 */       this.jMenuItem35.setEnabled(true);
/*       */       
/* 12056 */       this.jMenuItem33.setEnabled(true);
/*       */       
/* 12058 */       this.jMenuItem51.setEnabled(true);
/* 12059 */     } else if (depa.equals("CAPTURISTA")) {
/* 12060 */       this.jLabel54.setEnabled(true);
/* 12061 */       this.jLabel76.setEnabled(true);
/* 12062 */       this.jLabel80.setEnabled(true);
/* 12063 */       this.jLabel132.setEnabled(true);
/* 12064 */       this.jLabel136.setEnabled(true);
/* 12065 */       this.jLabel140.setEnabled(true);
/* 12066 */       this.jLabel69.setEnabled(true);
/* 12067 */       this.jLabel70.setEnabled(true);
/* 12068 */       this.jLabel71.setEnabled(true);
/* 12069 */       this.jLabel72.setEnabled(true);
/* 12070 */       this.jLabel65.setEnabled(true);
/* 12071 */       this.jLabel66.setEnabled(true);
/* 12072 */       this.jLabel67.setEnabled(true);
/* 12073 */       this.jLabel68.setEnabled(true);
/*       */       
/* 12075 */       this.jMenuItem52.setEnabled(true);
/* 12076 */       this.jMenuItem53.setEnabled(true);
/* 12077 */       this.jMenuItem54.setEnabled(true);
/* 12078 */       this.jMenuItem55.setEnabled(true);
/*       */       
/* 12080 */       this.jMenuItem51.setEnabled(true);
/* 12081 */       this.jMenuItem48.setEnabled(true);
/* 12082 */       this.jMenuItem50.setEnabled(true);
/* 12083 */       this.jMenuItem49.setEnabled(true);
/*       */       
/* 12085 */       this.jMenuItem19.setEnabled(true);
/* 12086 */       this.jMenuItem18.setEnabled(true);
/* 12087 */       this.jMenuItem43.setEnabled(true);
/* 12088 */       this.jMenuItem47.setEnabled(true);
/* 12089 */       this.jMenuItem24.setEnabled(true);
/* 12090 */       this.jMenuItem28.setEnabled(true);
/* 12091 */       this.jMenuItem20.setEnabled(true);
/* 12092 */       this.jMenuItem33.setEnabled(true);
/* 12093 */     } else if (depa.equals("RESETEOS")) {
/* 12094 */       this.jMenuItem21.setEnabled(true);
/* 12095 */       this.jMenuItem55.setEnabled(true);
/* 12096 */       this.jMenuItem3.setEnabled(true);
/* 12097 */     } else if (depa.equals("CUENTAS POR PAGAR")) {
/* 12098 */       this.jLabel147.setEnabled(true);
/* 12099 */       this.jLabel148.setEnabled(true);
/* 12100 */       this.jLabel149.setEnabled(true);
/* 12101 */       this.jLabel150.setEnabled(true);
/* 12102 */       this.jLabel151.setEnabled(true);
/* 12103 */       this.jMenuItem70.setEnabled(true);
/* 12104 */       this.jMenuItem71.setEnabled(true);
/* 12105 */       this.jMenuItem72.setEnabled(true);
/* 12106 */       this.jMenuItem74.setEnabled(true);
/* 12107 */       this.jMenuItem76.setEnabled(true);
/*       */     
/*       */     }
/* 12110 */     else if (depa.equals("SUPERVISOR DE CUENTAS POR PAGAR")) {
/* 12111 */       this.jLabel147.setEnabled(true);
/* 12112 */       this.jLabel148.setEnabled(true);
/* 12113 */       this.jLabel149.setEnabled(true);
/* 12114 */       this.jLabel150.setEnabled(true);
/* 12115 */       this.jLabel151.setEnabled(true);
/* 12116 */       this.jLabel68.setEnabled(true);
/* 12117 */       this.jMenuItem70.setEnabled(true);
/* 12118 */       this.jMenuItem71.setEnabled(true);
/* 12119 */       this.jMenuItem72.setEnabled(true);
/* 12120 */       this.jMenuItem74.setEnabled(true);
/* 12121 */       this.jMenuItem76.setEnabled(true);
/*       */     } else {
/*       */       
/* 12124 */       JOptionPane.showMessageDialog(this, "Todavía no están habilitados los privilegios para este departamento", "Privilegios No Cargados", 0, this.ERROR);
/*       */     } 
/*       */ 
/*       */     
/* 12128 */     if (this.PRIVILEGIOS.containsValue(depa)) {
/* 12129 */       consultarDocVencidos();
/*       */     }
/*       */   }
/*       */ 
/*       */   
/*       */   public Date getNTPDate() {
/* 12135 */     String servidor = "0.north-america.pool.ntp.org";
/*       */     
/* 12137 */     Date fechaRecibida = null;
/*       */ 
/*       */     
/* 12140 */     NTPUDPClient cliente = new NTPUDPClient();
/*       */ 
/*       */     
/* 12143 */     cliente.setDefaultTimeout(5000);
/*       */ 
/*       */     
/*       */     try {
/* 12147 */       InetAddress hostAddr = InetAddress.getByName(servidor);
/*       */ 
/*       */       
/* 12150 */       TimeInfo fecha = cliente.getTime(hostAddr);
/*       */ 
/*       */       
/* 12153 */       fechaRecibida = new Date(fecha.getMessage().getTransmitTimeStamp().getTime());
/* 12154 */     } catch (Exception e) {
/* 12155 */       System.err.println("Error " + e.getMessage());
/*       */     } 
/*       */ 
/*       */     
/* 12159 */     cliente.close();
/*       */ 
/*       */     
/* 12162 */     return (fechaRecibida == null) ? new Date() : fechaRecibida;
/*       */   }
/*       */   
/*       */   public class Esperando
/*       */     implements Runnable {
/*       */     Thread t;
/* 12168 */     int cont = 0;
/*       */     
/*       */     Esperando() {
/* 12171 */       this.t = new Thread(this);
/* 12172 */       this.t.start();
/*       */     }
/*       */ 
/*       */     
/*       */     public void start() {}
/*       */     
/*       */     public void run() {
/*       */       
/*       */       try { while (true) {
/* 12181 */           Thread.currentThread(); Thread.sleep(240000L);
/* 12182 */           Principal.this.con.matarProcesos();
/*       */         }  }
/* 12184 */       catch (InterruptedException interruptedException) {  }
/* 12185 */       catch (SQLException ex)
/* 12186 */       { Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, (String)null, ex); }
/*       */     
/*       */     }
/*       */   }
/*       */   
/*       */   public class Reloj
/*       */     implements Runnable
/*       */   {
/*       */     Thread t;
/* 12195 */     int cont = 0;
/* 12196 */     int min = 1;
/* 12197 */     int seg = 59;
/*       */     
/*       */     Reloj() {
/* 12200 */       this.t = new Thread(this);
/* 12201 */       this.t.start();
/*       */     }
/*       */ 
/*       */     
/*       */     public void start() {}
/*       */     
/*       */     public void run() {
/*       */       try {
/*       */         while (true) {
/* 12210 */           Thread.currentThread(); Thread.sleep(1000L);
/* 12211 */           if (this.seg < 1) {
/* 12212 */             this.seg = 59;
/* 12213 */             if (this.min <= 0) {
/* 12214 */               if (Principal.this.jFrame2.isVisible()) {
/* 12215 */                 Principal.this.consultarForma();
/*       */               }
/* 12217 */               this.min = 2;
/*       */             } 
/* 12219 */             this.min--;
/*       */           } 
/* 12221 */           this.seg--;
/* 12222 */           if (this.seg < 10) {
/* 12223 */             Principal.this.jLabel24.setText("" + this.min + ":0" + this.min + "  "); continue;
/*       */           } 
/* 12225 */           Principal.this.jLabel24.setText("" + this.min + ":" + this.min + "  ");
/*       */         }
/*       */       
/* 12228 */       } catch (InterruptedException interruptedException) {
/*       */         return;
/*       */       } 
/*       */     }
/*       */   }
/*       */   
/*       */   public class CargarModulos
/*       */     implements Runnable {
/*       */     Thread t;
/* 12237 */     int cont = 0;
/*       */     
/*       */     public CargarModulos() {
/* 12240 */       this.t = new Thread(this);
/* 12241 */       this.t.start();
/*       */     }
/*       */ 
/*       */     
/*       */     public void start() {}
/*       */     
/*       */     public void run() {
/* 12248 */       Principal.this.jTextField1.setEnabled(false);
/* 12249 */       Principal.this.jPasswordField1.setEnabled(false);
/* 12250 */       Principal.this.materialButton5.setEnabled(false);
/* 12251 */       Principal.this.llenarCodigosPostales();
/* 12252 */       Principal.this.jTextField1.setEnabled(true);
/* 12253 */       Principal.this.jPasswordField1.setEnabled(true);
/* 12254 */       Principal.this.materialButton5.setEnabled(true);
/* 12255 */       Principal.this.jLabel15.setText("Cargando tipos de cambio");
/* 12256 */       Principal.this.jProgressBar1.setValue(5);
/* 12257 */       Principal.this.cargarTipoCambio();
/* 12258 */       Principal.this.jLabel15.setText("Cargando Módulo de Guías");
/*       */       
/* 12260 */       Principal.this.guiasM = new ModificarGuias(Principal.this.jScrollPane1, Principal.this.USUARIO, null, new JTable(), "", Principal.this.PADRE, Principal.this.CAMPOSGENERALES, Principal.this.LISTACODIGOS, Principal.this.CODIGOSP);
/* 12261 */       Principal.this.jProgressBar1.setValue(10);
/* 12262 */       Principal.this.jLabel15.setText("Cargando Módulo de Facturas");
/*       */       
/* 12264 */       Principal.this.jProgressBar1.setValue(15);
/*       */ 
/*       */       
/* 12267 */       Principal.this.jProgressBar1.setValue(30);
/* 12268 */       Principal.this.jLabel15.setText("Cargando Módulo de Vales de Diesel");
/* 12269 */       Principal.this.valeD = new valesDiesel(Principal.this.jScrollPane1, Principal.this.jTabbedPane2, Principal.this.USUARIO, Principal.this.PADRE, Principal.this.mensajeTry, Principal.this.CAMPOSGENERALES, true);
/* 12270 */       Principal.this.jProgressBar1.setValue(35);
/* 12271 */       Principal.this.jLabel15.setText("Cargando Módulo de Manifiestos");
/* 12272 */       Principal.this.manifiestosB = new buscarManifiestos(Principal.this.jScrollPane1, Principal.this.USUARIO, null, new JTable(), "", Principal.this.PADRE);
/* 12273 */       Principal.this.jProgressBar1.setValue(40);
/* 12274 */       Principal.this.jLabel15.setText("Cargando Módulo de Liquidaciones");
/* 12275 */       Principal.this.liquidaciones = new Liquidaciones(Principal.this.jScrollPane1, Principal.this.jTabbedPane2, Principal.this.USUARIO, Principal.this.PADRE, Principal.this.mensajeTry, Principal.this.CAMPOSGENERALES, true);
/* 12276 */       Principal.this.jProgressBar1.setValue(50);
/* 12277 */       Principal.this.jLabel15.setText("Cargando Módulo de Caja Chica");
/* 12278 */       Principal.this.cajaCh = new cajaChica(Principal.this.jScrollPane1, Principal.this.jTabbedPane2, Principal.this.USUARIO, Principal.this.PADRE, Principal.this.mensajeTry);
/* 12279 */       Principal.this.jProgressBar1.setValue(60);
/* 12280 */       Principal.this.jLabel15.setText("Cargando Módulo de Tarjeta Deudor");
/* 12281 */       Principal.this.tarDeu = new TarjetasDeudoras(Principal.this.jScrollPane1, Principal.this.jTabbedPane2, Principal.this.USUARIO, Principal.this.PADRE, Principal.this.mensajeTry, Principal.this.CAMPOSGENERALES, true);
/* 12282 */       Principal.this.jProgressBar1.setValue(70);
/* 12283 */       Principal.this.jLabel15.setText("Cargando Módulo de Operadores");
/* 12284 */       Principal.this.operadorB = new OperadoresBuscar(Principal.this.PADRE, Principal.this.jScrollPane1, Principal.this.USUARIO, null, Principal.this.CAMPOSGENERALES, true);
/* 12285 */       Principal.this.jProgressBar1.setValue(80);
/* 12286 */       Principal.this.jLabel15.setText("Cargando Módulo de Empleados");
/* 12287 */       Principal.this.EmpleadoB = new EmpleadosBuscar(Principal.this.jScrollPane1, Principal.this.jTabbedPane2, Principal.this.USUARIO, Principal.this.PADRE, Principal.this.CAMPOSGENERALES, true);
/* 12288 */       Principal.this.jProgressBar1.setValue(90);
/* 12289 */       Principal.this.jLabel15.setText("Cargando Módulo de Pozos");
/* 12290 */       Principal.this.pozo = new Pozos(Principal.this.jScrollPane1, Principal.this.USUARIO, null, new JTable(), "", Principal.this.PADRE);
/* 12291 */       Principal.this.jLabel15.setText("Cargando Módulo Prefacturación");
/* 12292 */       Principal.this.jProgressBar1.setValue(95);
/* 12293 */       Principal.this.prefac = new Prefacturas(Principal.this.jScrollPane1, Principal.this.jTabbedPane2, Principal.this.USUARIO, Principal.this.PADRE, Principal.this.mensajeTry);
/* 12294 */       Principal.this.jProgressBar1.setValue(100);
/* 12295 */       Principal.this.jLabel15.setText("SICRET cargado ....100% ");
/* 12296 */       detener();
/*       */     }
/*       */     
/*       */     public void detener() {
/* 12300 */       this.t.stop();
/* 12301 */       Principal.this.desactivarPanel();
/*       */     } }
/*       */   public class CeldaRender extends DefaultTableCellRenderer { int otro;
/*       */     String[] indices;
/*       */     
/*       */     public CeldaRender() {
/* 12307 */       this.otro = -1;
/* 12308 */       this.indices = new String[0];
/*       */     }
/*       */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 12311 */       setEnabled((table == null || table.isEnabled()));
/* 12312 */       String valor = String.valueOf(value);
/* 12313 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 12314 */       if (row % 2 == 0) {
/* 12315 */         setBackground(new Color(239, 239, 239));
/* 12316 */         setForeground(Color.black);
/*       */       } else {
/* 12318 */         setBackground((Color)null);
/* 12319 */         setForeground(Color.black);
/*       */       } 
/* 12321 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 12322 */       return this;
/*       */     }
/*       */     
/*       */     public void pasarInd(String[] ind) {
/* 12326 */       this.indices = ind;
/*       */     }
/*       */     
/*       */     public boolean comparar(String reg) {
/* 12330 */       for (int i = 0; i < this.indices.length; i++) {
/* 12331 */         if (this.indices[i].equals(reg)) {
/* 12332 */           return true;
/*       */         }
/*       */       } 
/* 12335 */       return false;
/*       */     } }
/*       */ 
/*       */   
/*       */   class fotoIndividual
/*       */     implements Runnable {
/*       */     Thread t;
/* 12342 */     String num = "";
/*       */     
/*       */     fotoIndividual(String valor) {
/* 12345 */       this.t = new Thread(this);
/* 12346 */       this.num = valor;
/* 12347 */       this.t.start();
/*       */     }
/*       */ 
/*       */     
/*       */     public void start() {}
/*       */     
/*       */     public void run() {
/* 12354 */       ImageIcon tmpIcon = new ImageIcon(Principal.this.DIRECTIVA[0] + "/" + Principal.this.DIRECTIVA[0] + ".png");
/*       */       
/* 12356 */       ImageIcon temporal = new ImageIcon(tmpIcon.getImage().getScaledInstance(170, -1, 1));
/* 12357 */       Principal.this.cLabel1.setText("");
/* 12358 */       if (temporal.getImageLoadStatus() == 4) {
/* 12359 */         Principal.this.cLabel1.setText("Sin Fotogafía");
/*       */       } else {
/* 12361 */         Principal.this.cLabel1.setText("");
/* 12362 */         Principal.this.cLabel1.setIcon(temporal);
/*       */       } 
/*       */     } }
/*       */   public class ImprimirDocumento implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[][] Lineas; int linesPerPage; int orientacion; double X; double Y; int YINICIA;
/*       */     int[] PXCOL;
/*       */     int NumLineas;
/*       */     int numBreaks;
/*       */     
/*       */     public ImprimirDocumento() {
/* 12371 */       this.g2 = null;
/* 12372 */       this.Pag = 0;
/*       */       
/* 12374 */       this.linesPerPage = 50;
/* 12375 */       this.orientacion = 0;
/* 12376 */       this.X = 0.0D;
/* 12377 */       this.Y = 0.0D;
/* 12378 */       this.YINICIA = 75;
/* 12379 */       this.PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/* 12380 */       this.NumLineas = 0;
/* 12381 */       this.numBreaks = 0;
/*       */     }
/*       */     private void initTextLines() {
/* 12384 */       if (this.textLines == null) {
/* 12385 */         int numLines = Principal.this.rSTableMetro2.getRowCount();
/* 12386 */         this.textLines = new String[numLines];
/*       */       } 
/*       */     }
/*       */     
/*       */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 12391 */       Font font = new Font("Serif", 0, 8);
/* 12392 */       FontMetrics metrics = g.getFontMetrics(font);
/* 12393 */       int lineHeight = metrics.getHeight();
/* 12394 */       if (this.pageBreaks == null) {
/* 12395 */         initTextLines();
/* 12396 */         this.orientacion = pf.getOrientation();
/* 12397 */         if (pf.getOrientation() == 1) {
/* 12398 */           this.linesPerPage = 50;
/* 12399 */           this.X = pf.getWidth();
/* 12400 */           this.Y = pf.getHeight();
/*       */         } else {
/* 12402 */           this.linesPerPage = 38;
/* 12403 */           this.X = pf.getWidth();
/* 12404 */           this.Y = pf.getHeight();
/*       */         } 
/* 12406 */         this.numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 12407 */         this.Pag = this.numBreaks;
/* 12408 */         this.pageBreaks = new int[this.numBreaks];
/* 12409 */         for (int b = 0; b < this.numBreaks; b++) {
/* 12410 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*       */         }
/*       */       } 
/* 12413 */       if (pageIndex > this.pageBreaks.length) {
/* 12414 */         return 1;
/*       */       }
/* 12416 */       Graphics2D g2d = (Graphics2D)g;
/* 12417 */       this.g2 = g;
/* 12418 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 12419 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 12420 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 12421 */       encabezado();
/* 12422 */       int y = this.YINICIA;
/* 12423 */       int lineas = 0;
/*       */       
/* 12425 */       this.g2.drawRect(25, 80, 550, 12);
/* 12426 */       this.g2.setColor(new Color(255, 0, 0));
/* 12427 */       this.g2.fillRect(25, 81, 550, 10);
/*       */       
/* 12429 */       Font fuente = new Font("Dialog", 1, 8);
/* 12430 */       this.g2.setFont(fuente);
/* 12431 */       this.g2.setColor(Color.WHITE);
/* 12432 */       this.g2.drawString("NÚM", 29, 89);
/* 12433 */       this.g2.drawString("CLAVE", 70, 89);
/* 12434 */       this.g2.drawString("OPERADOR", 150, 89);
/* 12435 */       this.g2.drawString("VENCIMIENTO", 350, 89);
/* 12436 */       this.g2.drawString("NÚMERO", 430, 89);
/* 12437 */       this.g2.drawString("TIPO", 515, 89);
/*       */       
/* 12439 */       this.g2.setColor(Color.BLACK);
/* 12440 */       y = 90;
/* 12441 */       for (int line = start; line < end; line++) {
/* 12442 */         y += 12;
/* 12443 */         this.g2.drawLine(25, y, 575, y);
/*       */         
/* 12445 */         String valor = "";
/* 12446 */         if (line < 9) {
/* 12447 */           valor = "0" + line + 1;
/*       */         } else {
/* 12449 */           valor = "" + line + 1;
/*       */         } 
/* 12451 */         fuente = new Font("Dialog", 1, 7);
/* 12452 */         this.g2.setFont(fuente);
/* 12453 */         this.g2.drawString(valor, 27, y - 2);
/*       */         
/* 12455 */         fuente = new Font("Dialog", 0, 7);
/* 12456 */         this.g2.setFont(fuente);
/*       */         
/* 12458 */         this.g2.drawString(String.valueOf(Principal.this.rSTableMetro2.getValueAt(line, 0)), Principal.this.alinearDer(85, Principal.this.rSTableMetro2.getValueAt(line, 0).toString().length()), y - 2);
/* 12459 */         this.g2.drawString(String.valueOf(Principal.this.rSTableMetro2.getValueAt(line, 1)), 120, y - 2);
/* 12460 */         this.g2.drawString(String.valueOf(Principal.this.rSTableMetro2.getValueAt(line, 2)), 360, y - 2);
/* 12461 */         this.g2.drawString(String.valueOf(Principal.this.rSTableMetro2.getValueAt(line, 3)), 430, y - 2);
/* 12462 */         this.g2.drawString(String.valueOf(Principal.this.rSTableMetro2.getValueAt(line, 4)), 525, y - 2);
/*       */       } 
/* 12464 */       this.g2.drawLine(25, 81, 25, y);
/* 12465 */       this.g2.drawLine(575, 81, 575, y);
/* 12466 */       fuente = new Font("Dialog", 0, 7);
/* 12467 */       this.g2.setFont(fuente);
/* 12468 */       g.drawString("Página " + pageIndex + 1, 548, 755);
/* 12469 */       this.g2.setColor(Color.WHITE);
/* 12470 */       this.g2.fillRect((int)this.X - 46, 0, (int)this.X - 46, lineas);
/*       */       
/* 12472 */       if (this.Pag == pageIndex) {
/* 12473 */         fuente = new Font("Dialog", 1, 7);
/* 12474 */         this.g2.setFont(fuente);
/* 12475 */         this.g2.setColor(Color.BLACK);
/* 12476 */         this.g2.drawString("ELABORÓ", 300, 720);
/* 12477 */         this.g2.drawString("_____________________________________", 250, 752);
/* 12478 */         this.g2.drawString("NOMBRE Y FIRMA", 288, 765);
/*       */       } 
/* 12480 */       return 0;
/*       */     }
/*       */     
/*       */     public void encabezado() {
/* 12484 */       Font fuente = new Font("Dialog", 0, 8);
/* 12485 */       this.g2.setFont(fuente);
/* 12486 */       this.g2.setColor(Color.BLACK);
/* 12487 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 12488 */       Image img = imagen.getImage();
/* 12489 */       this.g2.drawImage(img, 518, 15, 60, 60, null);
/*       */       
/* 12491 */       imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/sicret2.png"));
/* 12492 */       img = imagen.getImage();
/* 12493 */       this.g2.drawImage(img, 27, 15, 60, 50, null);
/*       */       
/* 12495 */       fuente = new Font("Times New Roman", 1, 16);
/* 12496 */       this.g2.setFont(fuente);
/* 12497 */       this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 135, 30);
/* 12498 */       fuente = new Font("Dialog", 0, 12);
/* 12499 */       this.g2.setFont(fuente);
/* 12500 */       this.g2.drawString("REPORTE DE OPERADORES CON LICENCIA VENCIDA", 150, 47);
/* 12501 */       this.g2.drawString("_______________________________________________", 147, 48);
/*       */       
/* 12503 */       fuente = new Font("Dialog", 1, 8);
/* 12504 */       this.g2.setFont(fuente);
/* 12505 */       this.g2.drawString("SUCURSAL: ", 100, 75);
/* 12506 */       this.g2.drawString("FECHA:", 425, 75);
/*       */       
/* 12508 */       fuente = new Font("Dialog", 0, 8);
/* 12509 */       this.g2.setFont(fuente);
/* 12510 */       Principal.this.con.consultar("sucursal", "configuraciones", "");
/* 12511 */       this.g2.drawString(Principal.this.con.Campo, 150, 75);
/*       */       
/* 12513 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 12514 */       String cadenaFecha1 = formato.format(new Date());
/* 12515 */       String año = cadenaFecha1.substring(0, 4);
/* 12516 */       String mes = cadenaFecha1.substring(4, 6);
/* 12517 */       String dia = cadenaFecha1.substring(6, 8);
/* 12518 */       this.g2.drawString(dia + "/" + dia + "/" + mes, 458, 75);
/*       */     }
/*       */     
/*       */     public void recibeDatos() {
/* 12522 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 12523 */       job.setPrintable(this);
/*       */       
/* 12525 */       PageFormat pf = job.defaultPage();
/* 12526 */       Paper papel = pf.getPaper();
/* 12527 */       papel.setSize(612.0D, 792.0D);
/* 12528 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 12529 */       pf.setPaper(papel);
/* 12530 */       pf.setOrientation(1);
/* 12531 */       job.setPrintable(new ImprimirDocumento(), pf);
/* 12532 */       job.defaultPage(pf);
/*       */       
/* 12534 */       boolean ok = job.printDialog();
/* 12535 */       if (ok)
/*       */         try {
/* 12537 */           job.print();
/* 12538 */         } catch (PrinterException printerException) {} 
/*       */     } }
/*       */   
/*       */   public class CeldaRender2 extends DefaultTableCellRenderer { int otro;
/*       */     String[] indices;
/*       */     Color colorsito;
/*       */     
/*       */     public CeldaRender2() {
/* 12546 */       this.otro = -1;
/* 12547 */       this.indices = new String[0];
/* 12548 */       this.colorsito = null;
/*       */     }
/*       */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 12551 */       setEnabled((table == null || table.isEnabled()));
/* 12552 */       String comp = String.valueOf(table.getValueAt(row, 4));
/* 12553 */       for (int i = 0; i < Principal.this.estatus.length; i++) {
/* 12554 */         if (comp.equals(Principal.this.estatus[i])) {
/* 12555 */           setBackground(Principal.this.colores[i]);
/*       */           break;
/*       */         } 
/*       */       } 
/* 12559 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 12560 */       return this;
/*       */     } }
/*       */   
/*       */   public class CeldaRender4 extends DefaultTableCellRenderer { int otro;
/*       */     
/*       */     public CeldaRender4() {
/* 12566 */       this.otro = -1;
/*       */     }
/*       */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 12569 */       setEnabled((table == null || table.isEnabled()));
/* 12570 */       if (row % 2 == 0) {
/*       */         
/* 12572 */         setBackground(Principal.this.lc.FONDOTABLA);
/* 12573 */         setForeground(Principal.this.lc.SECUNDARIO1);
/*       */       } else {
/*       */         
/* 12576 */         setBackground((Color)null);
/* 12577 */         setForeground(Principal.this.lc.SECUNDARIO1);
/*       */       } 
/*       */ 
/*       */       
/* 12581 */       if (selected) {
/* 12582 */         setBackground(Color.YELLOW);
/*       */       }
/* 12584 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 12585 */       return this;
/*       */     } }
/*       */   public class CeldaRender5 extends DefaultTableCellRenderer { int otro; String[] indices; String[] indices2; String[] indices3; String[] indices4;
/*       */     String[] indices5;
/*       */     
/*       */     public CeldaRender5() {
/* 12591 */       this.otro = -1;
/* 12592 */       this.indices = new String[0];
/* 12593 */       this.indices2 = new String[0];
/* 12594 */       this.indices3 = new String[0];
/* 12595 */       this.indices4 = new String[0];
/* 12596 */       this.indices5 = new String[0];
/*       */     }
/*       */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 12599 */       setEnabled((table == null || table.isEnabled()));
/*       */       
/* 12601 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 12602 */       if (comparar(comp)) {
/* 12603 */         setBackground(Color.red);
/* 12604 */         setForeground(Color.white);
/* 12605 */       } else if (comparar2(comp)) {
/* 12606 */         setBackground(new Color(153, 102, 0));
/* 12607 */         setForeground(Color.WHITE);
/* 12608 */       } else if (comparar3(comp)) {
/* 12609 */         setBackground(new Color(102, 153, 255));
/* 12610 */         setForeground(Color.BLUE);
/* 12611 */       } else if (comparar4(comp)) {
/* 12612 */         setBackground(Color.LIGHT_GRAY);
/* 12613 */         setForeground(Color.RED);
/* 12614 */       } else if (comparar5(comp)) {
/* 12615 */         setBackground(new Color(153, 153, 153));
/* 12616 */         setForeground(Color.BLACK);
/*       */       } else {
/* 12618 */         setBackground((Color)null);
/* 12619 */         setForeground(Principal.this.lc.SECUNDARIO1);
/*       */       } 
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
/* 12636 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 12637 */       return this;
/*       */     }
/*       */     
/*       */     public void pasarInd(String[] ind) {
/* 12641 */       this.indices = ind;
/*       */     }
/*       */     
/*       */     public void pasarInd2(String[] ind) {
/* 12645 */       this.indices2 = ind;
/*       */     }
/*       */     
/*       */     public void pasarInd3(String[] ind) {
/* 12649 */       this.indices3 = ind;
/*       */     }
/*       */     
/*       */     public void pasarInd4(String[] ind) {
/* 12653 */       this.indices4 = ind;
/*       */     }
/*       */     
/*       */     public void pasarInd5(String[] ind) {
/* 12657 */       this.indices5 = ind;
/*       */     }
/*       */     
/*       */     public boolean comparar(String reg) {
/* 12661 */       for (int i = 0; i < this.indices.length; i++) {
/* 12662 */         if (this.indices[i].equals(reg)) {
/* 12663 */           return true;
/*       */         }
/*       */       } 
/* 12666 */       return false;
/*       */     }
/*       */     
/*       */     public boolean comparar2(String reg) {
/* 12670 */       for (int i = 0; i < this.indices2.length; i++) {
/* 12671 */         if (this.indices2[i].equals(reg)) {
/* 12672 */           return true;
/*       */         }
/*       */       } 
/* 12675 */       return false;
/*       */     }
/*       */     
/*       */     public boolean comparar3(String reg) {
/* 12679 */       for (int i = 0; i < this.indices3.length; i++) {
/* 12680 */         if (this.indices3[i].equals(reg)) {
/* 12681 */           return true;
/*       */         }
/*       */       } 
/* 12684 */       return false;
/*       */     }
/*       */     
/*       */     public boolean comparar4(String reg) {
/* 12688 */       for (int i = 0; i < this.indices4.length; i++) {
/* 12689 */         if (this.indices4[i].equals(reg)) {
/* 12690 */           return true;
/*       */         }
/*       */       } 
/* 12693 */       return false;
/*       */     }
/*       */     
/*       */     public boolean comparar5(String reg) {
/* 12697 */       for (int i = 0; i < this.indices5.length; i++) {
/* 12698 */         if (this.indices5[i].equals(reg)) {
/* 12699 */           return true;
/*       */         }
/*       */       } 
/* 12702 */       return false;
/*       */     } }
/*       */ 
/*       */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Principal.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */