/*       */ package sicret;
/*       */ import com.itextpdf.text.Document;
/*       */ import com.placeholder.PlaceHolder;
/*       */ import com.toedter.calendar.JDateChooser;
/*       */ import java.awt.Color;
/*       */ import java.awt.Component;
/*       */ import java.awt.Cursor;
/*       */ import java.awt.Dimension;
/*       */ import java.awt.Font;
/*       */ import java.awt.FontMetrics;
/*       */ import java.awt.Graphics;
/*       */ import java.awt.Graphics2D;
/*       */ import java.awt.GridBagConstraints;
/*       */ import java.awt.GridLayout;
/*       */ import java.awt.Image;
/*       */ import java.awt.Point;
/*       */ import java.awt.event.ActionEvent;
/*       */ import java.awt.event.ActionListener;
/*       */ import java.awt.event.KeyAdapter;
/*       */ import java.awt.event.KeyEvent;
/*       */ import java.awt.event.MouseAdapter;
/*       */ import java.awt.event.MouseEvent;
/*       */ import java.awt.print.PageFormat;
/*       */ import java.awt.print.Paper;
/*       */ import java.awt.print.Printable;
/*       */ import java.awt.print.PrinterException;
/*       */ import java.awt.print.PrinterJob;
/*       */ import java.io.BufferedWriter;
/*       */ import java.io.IOException;
/*       */ import java.text.NumberFormat;
/*       */ import java.text.ParseException;
/*       */ import java.text.SimpleDateFormat;
/*       */ import java.time.ZoneId;
/*       */ import java.util.ArrayList;
/*       */ import java.util.Calendar;
/*       */ import java.util.Date;
/*       */ import java.util.Properties;
/*       */ import javax.mail.Address;
/*       */ import javax.mail.Session;
/*       */ import javax.mail.Transport;
/*       */ import javax.mail.internet.MimeBodyPart;
/*       */ import javax.mail.internet.MimeMessage;
/*       */ import javax.mail.internet.MimeMultipart;
/*       */ import javax.swing.BorderFactory;
/*       */ import javax.swing.DefaultComboBoxModel;
/*       */ import javax.swing.GroupLayout;
/*       */ import javax.swing.Icon;
/*       */ import javax.swing.ImageIcon;
/*       */ import javax.swing.JButton;
/*       */ import javax.swing.JCheckBox;
/*       */ import javax.swing.JComboBox;
/*       */ import javax.swing.JComponent;
/*       */ import javax.swing.JDialog;
/*       */ import javax.swing.JFileChooser;
/*       */ import javax.swing.JLabel;
/*       */ import javax.swing.JOptionPane;
/*       */ import javax.swing.JPanel;
/*       */ import javax.swing.JRadioButton;
/*       */ import javax.swing.JScrollPane;
/*       */ import javax.swing.JSeparator;
/*       */ import javax.swing.JTable;
/*       */ import javax.swing.JTextArea;
/*       */ import javax.swing.JTextField;
/*       */ import javax.swing.LayoutStyle;
/*       */ import javax.swing.table.DefaultTableModel;
/*       */ import javax.swing.text.MaskFormatter;
/*       */ import principal.MaterialButton;
/*       */ import rojerusan.RSTableMetro;
/*       */ 
/*       */ public class ModificarGuias extends JPanel {
/*       */   Border borde;
/*       */   Color color;
/*       */   JFrame padre;
/*       */   JScrollPane panel;
/*    75 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*    76 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*    77 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*    78 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*    79 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*    80 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*    81 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*    82 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*    83 */   Consultas con = new Consultas();
/*       */   boolean encontrado = false;
/*       */   MostrarTabla modelo;
/*       */   JTabbedPane fichas;
/*       */   String USUARIO;
/*       */   JTable tabla;
/*       */   EscribirReporte esc;
/*    90 */   Errores error = new Errores(false);
/*    91 */   Validaciones val = new Validaciones();
/*    92 */   String CLAVE = "";
/*    93 */   Date fechaActual = new Date();
/*    94 */   Date fecha = new Date();
/*       */   String[] CLAVES;
/*    96 */   Date fechaInicio = null;
/*    97 */   Date fechaTermino = null;
/*    98 */   Date fechaMinimo = null;
/*    99 */   String CLAVEO = "";
/*       */   
/*       */   String[] clavesDesti;
/*       */   String[] empresasDesti;
/*       */   String[] ciudadesDesti;
/*       */   String[] domicilioDesti;
/*       */   String[] numeroDesti;
/*       */   String[] coloniaDesti;
/*       */   String[] rfcDesti;
/*       */   String[] montoDesti;
/*       */   String[] letraDesti;
/*       */   String[] operadores;
/*       */   String[] EQUIPOS;
/*       */   String[] CLAVEOPERADOR;
/*       */   String[] CLAVEOPERADOR2;
/*       */   String[] CLAVEOP;
/*   115 */   CeldaRender celda = new CeldaRender();
/*   116 */   String TIPOTRACTOR = "";
/*   117 */   String DIRECTIVA = "";
/*       */   
/*   119 */   String DESCRIPCION = "";
/*   120 */   String[] LINEAS = null;
/*   121 */   String[][] REGIS = null;
/*   122 */   int[] LETRASMAX = null;
/*   123 */   String[] NOMBRECOL = null;
/*   124 */   int[] CANTTOTALES = new int[16];
/*   125 */   Esperando espera = null;
/*       */   
/*       */   boolean ENVIARCORREO = true;
/*   128 */   String ARCHIVO = "";
/*   129 */   String[] DIRECCIONES = null;
/*   130 */   String[] ORIGEN = null;
/*   131 */   String GUIA = "";
/*       */   
/*   133 */   String[] SERVICIOS = null;
/*   134 */   int OTROSRESIDUOS = 0;
/*   135 */   int OTROSSERVICIOS = 0;
/*   136 */   double TONS = 0.0D;
/*       */   
/*   138 */   String[] HOJASPAGADAS = null;
/*   139 */   String[] INFORMACION = null;
/*       */   
/*   141 */   int CONTADOR = 0;
/*   142 */   double seg = 0.0D;
/*   143 */   Presionado presionado = null;
/*   144 */   String DEPARTAMENTO = "";
/*   145 */   String SEMARNAT = "";
/*   146 */   String SUCURSAL = "";
/*       */   String[] LLAVESGENE;
/*   148 */   private MaskFormatter formaTel = null; private MaskFormatter formaTel2 = null;
/*       */   boolean PRIMERA = false;
/*   150 */   int contador = 0;
/*   151 */   String[] USUARIOSBLOQUEADOS = new String[] { "ALBERTO" };
/*   152 */   String CERTIFICADO = "";
/*   153 */   String CODIGOPOSTAL = "";
/*   154 */   String RUTA = "";
/*   155 */   SColores lc = new SColores();
/*   156 */   Fuentes fuentes = new Fuentes();
/*   157 */   PlaceHolder placeHolder = null;
/*   158 */   String holderGuia = "GUÍA";
/*   159 */   String holderOp = "OPERADOR";
/*   160 */   String holderEco = "ECONÓMICO";
/*   161 */   String holderRem = "REOLQUE";
/*   162 */   String holderTipoServ = "TIPO DE SERVICIO";
/*   163 */   String holderMercancia = "MERCANCÍA | RESIDUO | PRODUCTO";
/*   164 */   String holderVehiculo = "TIPO DE VEHÍCULO";
/*   165 */   String holderCliente = "CLIENTE";
/*   166 */   String holderOrigen = "ORIGEN";
/*   167 */   String holderDestino = "DESTINO";
/*       */   
/*   169 */   String holderDo = "BUSCAR D.O.";
/*   170 */   String holderLid = "BUSCAR .L.I.D.";
/*       */   
/*   172 */   pintarComponentes pintar = new pintarComponentes();
/*   173 */   Utilerias utilerias = new Utilerias();
/*   174 */   String RUTATEMP = "";
/*       */   boolean actualizado = false;
/*       */   Map<String, String> CAMPOSGENERALES;
/*   177 */   List<Tras_codigos> CODIGOSP = null;
/*   178 */   ArrayList LISTACODIGOS = null;
/*   179 */   ArrayList CLIENTESDOLID = new ArrayList(); private int xx; private int xy; private JDialog RecepAnteior; private ButtonGroup buttonGroup1; private JButton jButton1; private JButton jButton11; private JButton jButton12; private JButton jButton16; private JButton jButton18; private JButton jButton19; private JButton jButton2; private JButton jButton20; private JButton jButton21; private JButton jButton22; private JButton jButton23; private JButton jButton24; private JButton jButton25; private JButton jButton26; private JButton jButton27; private JButton jButton3; private JButton jButton4; private JButton jButton44; private JButton jButton45; private JButton jButton46; private JButton jButton47; private JButton jButton5; private JButton jButton6; private JButton jButton8; private JButton jButton9; private JCheckBox jCheckBox1; private JCheckBox jCheckBox10; private JCheckBox jCheckBox11; private JCheckBox jCheckBox12; private JCheckBox jCheckBox13; private JCheckBox jCheckBox14; private JCheckBox jCheckBox15; private JCheckBox jCheckBox16; private JCheckBox jCheckBox17; private JCheckBox jCheckBox18; private JCheckBox jCheckBox19; private JCheckBox jCheckBox2; private JCheckBox jCheckBox20; private JCheckBox jCheckBox21; private JCheckBox jCheckBox22; private JCheckBox jCheckBox23; private JCheckBox jCheckBox24; private JCheckBox jCheckBox25; private JCheckBox jCheckBox26; private JCheckBox jCheckBox27; private JCheckBox jCheckBox28; private JCheckBox jCheckBox29; private JCheckBox jCheckBox3; private JCheckBox jCheckBox30; private JCheckBox jCheckBox31; private JCheckBox jCheckBox4; private JCheckBox jCheckBox5; private JCheckBox jCheckBox6; private JCheckBox jCheckBox7; private JCheckBox jCheckBox8; private JCheckBox jCheckBox9; private JComboBox jComboBox1; private JComboBox jComboBox10; private JComboBox jComboBox11; private JComboBox jComboBox12; private JComboBox jComboBox13; private JComboBox jComboBox14; private JComboBox jComboBox15; private JComboBox jComboBox16; private JComboBox jComboBox17; private JComboBox jComboBox18; private JComboBox jComboBox19; private JComboBox jComboBox2; private JComboBox jComboBox20; private JComboBox jComboBox21; private JComboBox jComboBox22; private JComboBox jComboBox23; private JComboBox jComboBox24; private JComboBox jComboBox25; private JComboBox jComboBox26; private JComboBox jComboBox27; private JComboBox jComboBox28; private JComboBox jComboBox29; private JComboBox jComboBox3; private JComboBox jComboBox30; private JComboBox jComboBox31; private JComboBox jComboBox32; private JComboBox jComboBox33; private JComboBox jComboBox34; private JComboBox<String> jComboBox36; private JComboBox<String> jComboBox37; private JComboBox jComboBox4; private JComboBox jComboBox5; private JComboBox jComboBox6; private JComboBox jComboBox7; private JComboBox jComboBox8; private JComboBox jComboBox9; private JDateChooser jDateChooser1; private JDateChooser jDateChooser10; private JDateChooser jDateChooser2; private JDateChooser jDateChooser3; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDateChooser jDateChooser6; private JDateChooser jDateChooser9; private JDialog jDialog1; private JDialog jDialog10; private JDialog jDialog12; private JDialog jDialog18; private JDialog jDialog2; private JDialog jDialog3; private JDialog jDialog30; private JDialog jDialog4; private JDialog jDialog5; private JDialog jDialog6; private JDialog jDialog7; private JDialog jDialog8; private JDialog jDialog9; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel100; private JLabel jLabel101; private JLabel jLabel102; private JLabel jLabel103; private JLabel jLabel105; private JLabel jLabel107; private JLabel jLabel108; private JLabel jLabel109; private JLabel jLabel11; private JLabel jLabel110; private JLabel jLabel113; private JLabel jLabel114; private JLabel jLabel115; private JLabel jLabel116; private JLabel jLabel12; private JLabel jLabel124; private JLabel jLabel125; private JLabel jLabel126; private JLabel jLabel127; private JLabel jLabel128; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel172; private JLabel jLabel173; private JLabel jLabel18; private JLabel jLabel189; private JLabel jLabel19; private JLabel jLabel193; private JLabel jLabel194; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel235; private JLabel jLabel236; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel5; private JLabel jLabel50; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54; private JLabel jLabel55; private JLabel jLabel56; private JLabel jLabel57; private JLabel jLabel58; private JLabel jLabel59; private JLabel jLabel6; private JLabel jLabel60; private JLabel jLabel61; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65;
/*       */   private JLabel jLabel66;
/*       */   private JLabel jLabel67;
/*       */   private JLabel jLabel68;
/*       */   private JLabel jLabel69;
/*       */   private JLabel jLabel7;
/*       */   
/*       */   public ModificarGuias(JScrollPane panelito, String usua, JTabbedPane fichas, JTable Tabla, String num, JFrame padre, Map<String, String> CAMPOSGENERALES, ArrayList LISTACODIGOS, List<Tras_codigos> CODIGOSP) {
/*   187 */     String año = "2009";
/*   188 */     String mes = "11";
/*   189 */     String dia = "19";
/*   190 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*   191 */     String strFecha = dia + "-" + dia + "-" + mes;
/*       */     try {
/*   193 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*   194 */     } catch (ParseException ex) {
/*   195 */       ex.printStackTrace();
/*       */     } 
/*       */     
/*   198 */     Calendar ca = Calendar.getInstance();
/*   199 */     Calendar fecha = Calendar.getInstance();
/*   200 */     int aa = fecha.get(1);
/*   201 */     int mm = fecha.get(2);
/*   202 */     int dd = fecha.get(5);
/*   203 */     int diasTotal = diasDelMes(mm, aa);
/*   204 */     strFecha = "";
/*   205 */     this.USUARIO = usua;
/*   206 */     this.fichas = fichas;
/*   207 */     this.padre = padre;
/*   208 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*   209 */     this.LISTACODIGOS = LISTACODIGOS;
/*   210 */     this.CODIGOSP = CODIGOSP;
/*   211 */     initComponents();
/*   212 */     this.CLIENTESDOLID.add("SAMSUNG SDS USD");
/*       */ 
/*       */     
/*   215 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderGuia, false, "Century Gothic", 11);
/*   216 */     this.placeHolder = new PlaceHolder(this.jTextField2, new Color(189, 189, 189), Color.BLACK, this.holderOp, false, "Century Gothic", 11);
/*   217 */     this.placeHolder = new PlaceHolder(this.jTextField4, new Color(189, 189, 189), Color.BLACK, this.holderEco, false, "Century Gothic", 11);
/*   218 */     this.placeHolder = new PlaceHolder(this.jTextField3, new Color(189, 189, 189), Color.BLACK, this.holderRem, false, "Century Gothic", 11);
/*   219 */     this.placeHolder = new PlaceHolder(this.jTextField11, new Color(189, 189, 189), Color.BLACK, this.holderTipoServ, false, "Century Gothic", 11);
/*   220 */     this.placeHolder = new PlaceHolder(this.jTextField12, new Color(189, 189, 189), Color.BLACK, this.holderMercancia, false, "Century Gothic", 11);
/*   221 */     this.placeHolder = new PlaceHolder(this.jTextField37, new Color(189, 189, 189), Color.BLACK, this.holderVehiculo, false, "Century Gothic", 11);
/*   222 */     this.placeHolder = new PlaceHolder(this.jTextField38, new Color(189, 189, 189), Color.BLACK, this.holderCliente, false, "Century Gothic", 11);
/*   223 */     this.placeHolder = new PlaceHolder(this.jTextField39, new Color(189, 189, 189), Color.BLACK, this.holderOrigen, false, "Century Gothic", 11);
/*   224 */     this.placeHolder = new PlaceHolder(this.jTextField40, new Color(189, 189, 189), Color.BLACK, this.holderDestino, false, "Century Gothic", 11);
/*       */     
/*   226 */     this.placeHolder = new PlaceHolder(this.jTextField46, new Color(189, 189, 189), Color.BLACK, this.holderDo, false, "Century Gothic", 11);
/*   227 */     this.placeHolder = new PlaceHolder(this.jTextField47, new Color(189, 189, 189), Color.BLACK, this.holderLid, false, "Century Gothic", 11);
/*       */     
/*   229 */     panelito.setViewportView(this);
/*   230 */     this.panel = panelito;
/*   231 */     colorear();
/*   232 */     int w = this.tama.width;
/*   233 */     int h = this.tama.height;
/*   234 */     int rw = (w - 300) / 2;
/*   235 */     int rh = (h - 135) / 2;
/*       */     
/*   237 */     this.jDialog1.setLocation(rw, rh);
/*   238 */     this.jDialog1.setSize(300, 135);
/*   239 */     this.jDialog1.setVisible(false);
/*   240 */     this.jDialog1.setResizable(false);
/*       */     
/*   242 */     rw = (w - 780) / 2;
/*   243 */     rh = (h - 560) / 2;
/*   244 */     this.jDialog4.setLocation(rw, rh);
/*   245 */     this.jDialog4.setSize(780, 560);
/*   246 */     this.jDialog4.setVisible(false);
/*   247 */     this.jDialog4.setResizable(false);
/*       */     
/*   249 */     rw = (w - 510) / 2;
/*   250 */     rh = (h - 710) / 2;
/*   251 */     this.RecepAnteior.setLocation(rw, rh);
/*   252 */     this.RecepAnteior.setSize(510, 710);
/*   253 */     this.RecepAnteior.setVisible(false);
/*       */     
/*   255 */     rw = (w - 750) / 2;
/*   256 */     rh = (h - 510) / 2;
/*   257 */     this.jDialog3.setLocation(rw, rh);
/*   258 */     this.jDialog3.setSize(750, 520);
/*   259 */     this.jDialog3.setVisible(false);
/*   260 */     this.jDialog3.setResizable(false);
/*       */     
/*   262 */     rw = (w - 418) / 2;
/*   263 */     rh = (h - 230) / 2;
/*   264 */     this.jDialog5.setLocation(rw, rh);
/*   265 */     this.jDialog5.setSize(418, 230);
/*   266 */     this.jDialog5.setVisible(false);
/*   267 */     this.jDialog5.setResizable(false);
/*       */     
/*   269 */     rw = (w - 300) / 2;
/*   270 */     rh = (h - 650) / 2;
/*   271 */     this.jDialog6.setLocation(rw, rh);
/*   272 */     this.jDialog6.setSize(300, 650);
/*   273 */     this.jDialog6.setVisible(false);
/*   274 */     this.jDialog6.setResizable(false);
/*       */     
/*   276 */     rw = (w - 950) / 2;
/*   277 */     rh = (h - 550) / 2;
/*   278 */     this.jDialog7.setLocation(rw, rh);
/*   279 */     this.jDialog7.setSize(800, 550);
/*   280 */     this.jDialog7.setVisible(false);
/*   281 */     this.jDialog7.setResizable(false);
/*       */     
/*   283 */     this.jDialog8.setSize(180, 240);
/*   284 */     this.jDialog8.setVisible(false);
/*   285 */     this.jDialog8.setResizable(false);
/*       */     
/*   287 */     rw = (w - 260) / 2;
/*   288 */     rh = (h - 330) / 2;
/*   289 */     this.jDialog10.setLocation(rw, rh);
/*   290 */     this.jDialog10.setSize(260, 330);
/*   291 */     this.jDialog10.setVisible(false);
/*   292 */     this.jDialog10.setResizable(false);
/*       */     
/*   294 */     rw = (w - 920) / 2;
/*   295 */     rh = (h - 540) / 2;
/*   296 */     this.jDialog2.setLocation(rw, rh);
/*   297 */     this.jDialog2.setSize(920, 570);
/*   298 */     this.jDialog2.setVisible(false);
/*   299 */     this.jDialog2.setResizable(false);
/*       */     
/*   301 */     this.utilerias.activarVentanajDialog(this.jDialog30, 380, 125);
/*   302 */     this.utilerias.activarVentanajDialog(this.jDialog12, 690, 475);
/*       */     
/*   304 */     this.utilerias.activarVentanajDialog(this.jDialog18, 550, 220);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*   311 */     this.jLabel25.setVisible(false);
/*   312 */     llenarCombos();
/*   313 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*   314 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*   315 */     this.jLabel5.setCursor(micursor);
/*   316 */     this.jLabel6.setCursor(micursor);
/*   317 */     this.jLabel7.setCursor(micursor);
/*   318 */     this.jLabel51.setCursor(micursor);
/*   319 */     this.jLabel90.setCursor(micursor);
/*   320 */     this.jLabel12.setCursor(micursor);
/*   321 */     this.jLabel172.setCursor(micursor);
/*   322 */     this.jLabel103.setCursor(micursor);
/*   323 */     this.jLabel173.setCursor(micursor);
/*       */     
/*   325 */     Image imagen2 = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*   326 */     Cursor micursor2 = this.tk.createCustomCursor(imagen2, new Point(1, 1), null);
/*   327 */     this.RecepAnteior.setCursor(micursor2);
/*   328 */     this.jDialog1.setCursor(micursor2);
/*   329 */     this.jDialog3.setCursor(micursor2);
/*   330 */     this.jDialog4.setCursor(micursor2);
/*   331 */     this.jDialog6.setCursor(micursor2);
/*   332 */     this.jDialog7.setCursor(micursor2);
/*   333 */     this.jDialog8.setCursor(micursor2);
/*   334 */     this.jDialog2.setCursor(micursor2);
/*   335 */     this.jDialog30.setCursor(micursor2);
/*       */     
/*   337 */     this.con.consultar("directiva", "configuraciones", "");
/*   338 */     this.DIRECTIVA = this.con.Campo;
/*       */     
/*   340 */     this.buttonGroup1.add(this.jRadioButton1);
/*   341 */     this.buttonGroup1.add(this.jRadioButton2);
/*       */     
/*   343 */     this.jList1.setValueIsAdjusting(this.encontrado);
/*   344 */     this.jList1.setComponentPopupMenu(this.jPopupMenu1);
/*   345 */     privilegios();
/*   346 */     sacarDepa();
/*       */     
/*   348 */     this.con.consultar("semarnat", "configuraciones", "");
/*   349 */     this.SEMARNAT = this.con.Campo;
/*       */     
/*   351 */     this.con.consultar("sucursal", "configuraciones", "");
/*   352 */     this.SUCURSAL = this.con.Campo;
/*       */     
/*   354 */     String[] conf = this.con.regresaReg("directiva,semarnat,sucursal, numCertificado, codigoPostal, rutaCompTraslado", "configuraciones", "", 6);
/*   355 */     this.CERTIFICADO = conf[3];
/*   356 */     this.CODIGOPOSTAL = conf[4];
/*   357 */     this.SUCURSAL = conf[2];
/*   358 */     this.RUTA = conf[5];
/*   359 */     this.RUTATEMP = this.RUTA;
/*       */     
/*       */     try {
/*   362 */       this.formaTel = new MaskFormatter("hh:mm:ss a");
/*   363 */       this.formaTel2 = new MaskFormatter("hh:mm:ss a");
/*   364 */     } catch (Exception exception) {}
/*       */ 
/*       */     
/*   367 */     for (int i = 2010; i <= añoActual(); i++) {
/*   368 */       this.jComboBox36.addItem("" + i);
/*       */     }
/*   370 */     this.jComboBox37.setSelectedIndex(mesActual());
/*   371 */     this.jComboBox36.setSelectedItem("" + añoActual());
/*   372 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro1);
/*       */     
/*   374 */     consultar();
/*       */   }
/*       */   private JLabel jLabel70; private JLabel jLabel71; private JLabel jLabel72; private JLabel jLabel73; private JLabel jLabel74; private JLabel jLabel75; private JLabel jLabel76; private JLabel jLabel77; private JLabel jLabel78; private JLabel jLabel79; private JLabel jLabel8; private JLabel jLabel80; private JLabel jLabel81; private JLabel jLabel82; private JLabel jLabel83; private JLabel jLabel84; private JLabel jLabel85; private JLabel jLabel86; private JLabel jLabel87; private JLabel jLabel88; private JLabel jLabel89; private JLabel jLabel9; private JLabel jLabel90; private JLabel jLabel91; private JLabel jLabel92; private JLabel jLabel93; private JLabel jLabel94; private JLabel jLabel95; private JLabel jLabel96; private JLabel jLabel97; private JLabel jLabel98; private JLabel jLabel99; private JList jList1; private JMenuItem jMenuItem1; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel135; private JPanel jPanel14; private JPanel jPanel17; private JPanel jPanel172; private JPanel jPanel18; private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel23; private JPanel jPanel24; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel27; private JPanel jPanel28; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel30; private JPanel jPanel31; private JPanel jPanel32; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel35; private JPanel jPanel36; private JPanel jPanel37; private JPanel jPanel38; private JPanel jPanel39; private JPanel jPanel4; private JPanel jPanel40; private JPanel jPanel41; private JPanel jPanel42; private JPanel jPanel43; private JPanel jPanel44; private JPanel jPanel45; private JPanel jPanel46; private JPanel jPanel47; private JPanel jPanel48; private JPanel jPanel49; private JPanel jPanel5; private JPanel jPanel50; private JPanel jPanel51; private JPanel jPanel52; private JPanel jPanel53; private JPanel jPanel54; private JPanel jPanel55; private JPanel jPanel56; private JPanel jPanel57; private JPanel jPanel58; private JPanel jPanel59; private JPanel jPanel6; private JPanel jPanel60; private JPanel jPanel61; private JPanel jPanel62; private JPanel jPanel63; private JPanel jPanel64; private JPanel jPanel65; private JPanel jPanel66; private JPanel jPanel67; private JPanel jPanel68; private JPanel jPanel69; private JPanel jPanel7;
/*       */   private JPanel jPanel70;
/*       */   
/*       */   private void initComponents() {
/*   380 */     this.jDialog1 = new CerrarVentana(this.padre);
/*   381 */     this.jPanel8 = new JPanel();
/*   382 */     this.jLabel62 = new JLabel();
/*   383 */     this.jSeparator3 = new JSeparator();
/*   384 */     this.jLabel63 = new JLabel();
/*   385 */     this.jTextField14 = new JTextField();
/*   386 */     this.jButton11 = new JButton();
/*   387 */     this.jButton12 = new JButton();
/*   388 */     this.jDialog3 = new CerrarVentana(this.padre);
/*   389 */     this.jPanel12 = new JPanel();
/*   390 */     this.jLabel89 = new JLabel();
/*   391 */     this.jSeparator5 = new JSeparator();
/*   392 */     this.jLabel11 = new JLabel();
/*   393 */     this.jLabel13 = new JLabel();
/*   394 */     this.jLabel14 = new JLabel();
/*   395 */     this.jLabel18 = new JLabel();
/*   396 */     this.jLabel19 = new JLabel();
/*   397 */     this.jScrollPane1 = new JScrollPane();
/*   398 */     this.jTextArea1 = new JTextArea();
/*   399 */     this.jLabel52 = new JLabel();
/*   400 */     this.jLabel51 = new JLabel();
/*   401 */     this.jLabel53 = new JLabel();
/*   402 */     this.jLabel61 = new JLabel();
/*   403 */     this.jLabel90 = new JLabel();
/*   404 */     this.jLabel98 = new JLabel();
/*   405 */     this.jLabel99 = new JLabel();
/*   406 */     this.jDialog4 = new CerrarVentana(this.padre);
/*   407 */     this.jPanel73 = new JPanel();
/*   408 */     this.jPanel47 = new JPanel();
/*   409 */     this.jPanel4 = new JPanel();
/*   410 */     this.jLabel32 = new JLabel();
/*   411 */     this.jTextField15 = new JTextField();
/*   412 */     this.jLabel59 = new JLabel();
/*   413 */     this.jTextField43 = new JTextField();
/*   414 */     this.jLabel40 = new JLabel();
/*   415 */     this.jDateChooser2 = new JDateChooser("yyyy-MM-dd", "____-__-__", '_');
/*   416 */     this.jPanel74 = new JPanel();
/*   417 */     this.jLabel93 = new JLabel();
/*   418 */     this.jComboBox22 = new JComboBox();
/*   419 */     this.jLabel35 = new JLabel();
/*   420 */     this.jComboBox9 = new JComboBox();
/*   421 */     this.jLabel55 = new JLabel();
/*   422 */     this.jComboBox15 = new JComboBox();
/*   423 */     this.jLabel105 = new JLabel();
/*   424 */     this.jComboBox32 = new JComboBox();
/*   425 */     this.jLabel36 = new JLabel();
/*   426 */     this.jComboBox10 = new JComboBox();
/*   427 */     this.jLabel95 = new JLabel();
/*   428 */     this.jComboBox24 = new JComboBox();
/*   429 */     this.jLabel58 = new JLabel();
/*   430 */     this.jComboBox25 = new JComboBox();
/*   431 */     this.jLabel66 = new JLabel();
/*   432 */     this.jComboBox26 = new JComboBox();
/*   433 */     this.jLabel94 = new JLabel();
/*   434 */     this.jComboBox23 = new JComboBox();
/*   435 */     this.jLabel37 = new JLabel();
/*   436 */     this.jComboBox11 = new JComboBox();
/*   437 */     this.jLabel47 = new JLabel();
/*   438 */     this.jComboBox13 = new JComboBox();
/*   439 */     this.jLabel38 = new JLabel();
/*   440 */     this.jComboBox12 = new JComboBox();
/*   441 */     this.jLabel49 = new JLabel();
/*   442 */     this.jComboBox14 = new JComboBox();
/*   443 */     this.jLabel100 = new JLabel();
/*   444 */     this.jComboBox28 = new JComboBox();
/*   445 */     this.jSeparator11 = new JSeparator();
/*   446 */     this.jScrollPane4 = new JScrollPane();
/*   447 */     this.jTextArea2 = new JTextArea();
/*   448 */     this.jLabel91 = new JLabel();
/*   449 */     this.materialButton16 = new MaterialButton();
/*   450 */     this.materialButton17 = new MaterialButton();
/*   451 */     this.jDialog5 = new CerrarVentana(this.padre);
/*   452 */     this.jPanel29 = new JPanel();
/*   453 */     this.jLabel124 = new JLabel();
/*   454 */     this.jSeparator27 = new JSeparator();
/*   455 */     this.jLabel125 = new JLabel();
/*   456 */     this.jButton44 = new JButton();
/*   457 */     this.jButton45 = new JButton();
/*   458 */     this.jScrollPane18 = new JScrollPane();
/*   459 */     this.jTextArea5 = new JTextArea();
/*   460 */     this.jLabel126 = new JLabel();
/*   461 */     this.jDialog6 = new CerrarVentana(this.padre);
/*   462 */     this.jPanel13 = new JPanel();
/*   463 */     this.jLabel92 = new JLabel();
/*   464 */     this.jSeparator6 = new JSeparator();
/*   465 */     this.jButton20 = new JButton();
/*   466 */     this.jButton21 = new JButton();
/*   467 */     this.jCheckBox2 = new JCheckBox();
/*   468 */     this.jCheckBox3 = new JCheckBox();
/*   469 */     this.jCheckBox4 = new JCheckBox();
/*   470 */     this.jCheckBox5 = new JCheckBox();
/*   471 */     this.jCheckBox7 = new JCheckBox();
/*   472 */     this.jCheckBox9 = new JCheckBox();
/*   473 */     this.jCheckBox11 = new JCheckBox();
/*   474 */     this.jCheckBox13 = new JCheckBox();
/*   475 */     this.jCheckBox6 = new JCheckBox();
/*   476 */     this.jCheckBox8 = new JCheckBox();
/*   477 */     this.jCheckBox10 = new JCheckBox();
/*   478 */     this.jCheckBox12 = new JCheckBox();
/*   479 */     this.jCheckBox14 = new JCheckBox();
/*   480 */     this.jCheckBox15 = new JCheckBox();
/*   481 */     this.jCheckBox17 = new JCheckBox();
/*   482 */     this.jCheckBox16 = new JCheckBox();
/*   483 */     this.jCheckBox19 = new JCheckBox();
/*   484 */     this.jCheckBox21 = new JCheckBox();
/*   485 */     this.jCheckBox18 = new JCheckBox();
/*   486 */     this.jCheckBox20 = new JCheckBox();
/*   487 */     this.jCheckBox23 = new JCheckBox();
/*   488 */     this.jSeparator2 = new JSeparator();
/*   489 */     this.jRadioButton1 = new JRadioButton();
/*   490 */     this.jRadioButton2 = new JRadioButton();
/*   491 */     this.jCheckBox24 = new JCheckBox();
/*   492 */     this.jCheckBox25 = new JCheckBox();
/*   493 */     this.jCheckBox26 = new JCheckBox();
/*   494 */     this.jCheckBox27 = new JCheckBox();
/*   495 */     this.jCheckBox28 = new JCheckBox();
/*   496 */     this.jCheckBox29 = new JCheckBox();
/*   497 */     this.jCheckBox22 = new JCheckBox();
/*   498 */     this.jCheckBox30 = new JCheckBox();
/*   499 */     this.jCheckBox31 = new JCheckBox();
/*   500 */     this.jDialog7 = new CerrarVentana(this.padre);
/*   501 */     this.jPanel30 = new JPanel();
/*   502 */     this.jLabel127 = new JLabel();
/*   503 */     this.jSeparator28 = new JSeparator();
/*   504 */     this.jButton46 = new JButton();
/*   505 */     this.jButton47 = new JButton();
/*   506 */     this.jScrollPane19 = new JScrollPane();
/*   507 */     this.jTextArea6 = new JTextArea();
/*   508 */     this.jLabel21 = new JLabel();
/*   509 */     this.jTextField26 = new JTextField();
/*   510 */     this.jLabel22 = new JLabel();
/*   511 */     this.jTextField27 = new JTextField();
/*   512 */     this.jLabel23 = new JLabel();
/*   513 */     this.jLabel25 = new JLabel();
/*   514 */     this.jTextField28 = new JTextField();
/*   515 */     this.jLabel24 = new JLabel();
/*   516 */     this.jSeparator7 = new JSeparator();
/*   517 */     this.jButton3 = new JButton();
/*   518 */     this.jDialog2 = new CerrarVentana(this.padre);
/*   519 */     this.jPanel65 = new JPanel();
/*   520 */     this.jPanel66 = new JPanel();
/*   521 */     this.jLabel16 = new JLabel();
/*   522 */     this.jPanel3 = new JPanel();
/*   523 */     this.jPanel6 = new JPanel();
/*   524 */     this.jLabel77 = new JLabel();
/*   525 */     this.jComboBox18 = new JComboBox();
/*   526 */     this.jCheckBox1 = new JCheckBox();
/*   527 */     this.jPanel67 = new JPanel();
/*   528 */     this.jLabel71 = new JLabel();
/*   529 */     this.jTextField8 = new JTextField();
/*   530 */     this.jLabel67 = new JLabel();
/*   531 */     this.jTextField5 = new JTextField();
/*   532 */     this.jLabel70 = new JLabel();
/*   533 */     this.jTextField10 = new JTextField();
/*   534 */     this.jLabel113 = new JLabel();
/*   535 */     this.jTextField41 = new JTextField();
/*   536 */     this.jSeparator12 = new JSeparator();
/*   537 */     this.jPanel26 = new JPanel();
/*   538 */     this.jPanel28 = new JPanel();
/*   539 */     this.jPanel32 = new JPanel();
/*   540 */     this.jLabel68 = new JLabel();
/*   541 */     this.jTextField6 = new JTextField();
/*   542 */     this.jPanel33 = new JPanel();
/*   543 */     this.jLabel86 = new JLabel();
/*   544 */     this.jComboBox19 = new JComboBox();
/*   545 */     this.jPanel34 = new JPanel();
/*   546 */     this.jPanel35 = new JPanel();
/*   547 */     this.jLabel75 = new JLabel();
/*   548 */     this.jTextField19 = new JTextField();
/*   549 */     this.jPanel36 = new JPanel();
/*   550 */     this.jLabel76 = new JLabel();
/*   551 */     this.jTextField23 = new JTextField();
/*   552 */     this.jPanel31 = new JPanel();
/*   553 */     this.jPanel37 = new JPanel();
/*   554 */     this.jLabel72 = new JLabel();
/*   555 */     this.jLabel73 = new JLabel();
/*   556 */     this.jLabel88 = new JLabel();
/*   557 */     this.jLabel2 = new JLabel();
/*   558 */     this.jPanel38 = new JPanel();
/*   559 */     this.jDateChooser1 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*   560 */     this.jDateChooser6 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*   561 */     this.jDateChooser3 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*   562 */     this.jTextField32 = new JTextField();
/*   563 */     this.jPanel39 = new JPanel();
/*   564 */     this.jPanel40 = new JPanel();
/*   565 */     this.jPanel7 = new JPanel();
/*   566 */     this.jLabel65 = new JLabel();
/*   567 */     this.jTextField7 = new JTextField();
/*   568 */     this.jLabel69 = new JLabel();
/*   569 */     this.jTextField9 = new JTextField();
/*   570 */     this.jLabel74 = new JLabel();
/*   571 */     this.jComboBox17 = new JComboBox();
/*   572 */     this.jLabel101 = new JLabel();
/*   573 */     this.jComboBox29 = new JComboBox();
/*   574 */     this.jPanel41 = new JPanel();
/*   575 */     this.jPanel42 = new JPanel();
/*   576 */     this.jLabel80 = new JLabel();
/*   577 */     this.jTextField24 = new JTextField();
/*   578 */     this.jLabel85 = new JLabel();
/*   579 */     this.jTextField25 = new JTextField();
/*   580 */     this.jPanel43 = new JPanel();
/*   581 */     this.jLabel78 = new JLabel();
/*   582 */     this.jTextField17 = new JTextField();
/*   583 */     this.jLabel87 = new JLabel();
/*   584 */     this.jTextField13 = new JTextField();
/*   585 */     this.jPanel44 = new JPanel();
/*   586 */     this.jLabel115 = new JLabel();
/*   587 */     this.jTextField42 = new JTextField();
/*   588 */     this.jLabel79 = new JLabel();
/*   589 */     this.jTextField18 = new JTextField();
/*   590 */     this.jPanel71 = new JPanel();
/*   591 */     this.jLabel116 = new JLabel();
/*   592 */     this.jTextField44 = new JTextField();
/*   593 */     this.jLabel102 = new JLabel();
/*   594 */     this.jTextField45 = new JTextField();
/*   595 */     this.jPanel68 = new JPanel();
/*   596 */     this.jPanel69 = new JPanel();
/*   597 */     this.jLabel83 = new JLabel();
/*   598 */     this.jLabel84 = new JLabel();
/*   599 */     this.jPanel70 = new JPanel();
/*   600 */     this.jLabel9 = new JLabel();
/*   601 */     this.jLabel10 = new JLabel();
/*   602 */     this.jPanel72 = new JPanel();
/*   603 */     this.jLabel81 = new JLabel();
/*   604 */     this.jLabel82 = new JLabel();
/*   605 */     this.jPanel24 = new JPanel();
/*   606 */     this.jPanel25 = new JPanel();
/*   607 */     this.jPanel27 = new JPanel();
/*   608 */     this.jPanel45 = new JPanel();
/*   609 */     this.materialButton20 = new MaterialButton();
/*   610 */     this.materialButton19 = new MaterialButton();
/*   611 */     this.materialButton18 = new MaterialButton();
/*   612 */     this.jPanel46 = new JPanel();
/*   613 */     this.jLabel17 = new JLabel();
/*   614 */     this.buttonGroup1 = new ButtonGroup();
/*   615 */     this.jDialog8 = new CerrarVentana(this.padre);
/*   616 */     this.jScrollPane2 = new JScrollPane();
/*   617 */     this.jList1 = new JList();
/*   618 */     this.jPopupMenu1 = new JPopupMenu();
/*   619 */     this.jMenuItem1 = new JMenuItem();
/*   620 */     this.jDialog9 = new CerrarVentana(this.padre);
/*   621 */     this.jScrollPane5 = new JScrollPane();
/*   622 */     this.jTextPane2 = new JTextPane();
/*   623 */     this.jDialog10 = new CerrarVentana(this.padre);
/*   624 */     this.jPanel14 = new JPanel();
/*   625 */     this.jLabel26 = new JLabel();
/*   626 */     this.jSeparator8 = new JSeparator();
/*   627 */     this.jLabel27 = new JLabel();
/*   628 */     this.jLabel28 = new JLabel();
/*   629 */     this.jLabel29 = new JLabel();
/*   630 */     this.jLabel30 = new JLabel();
/*   631 */     this.jLabel31 = new JLabel();
/*   632 */     this.jSeparator9 = new JSeparator();
/*   633 */     this.jButton23 = new JButton();
/*   634 */     this.jTextField20 = new JTextField();
/*   635 */     this.jTextField21 = new JTextField();
/*   636 */     this.jTextField22 = new JTextField();
/*   637 */     this.jTextField29 = new JTextField();
/*   638 */     this.jTextField30 = new JTextField();
/*   639 */     this.jTextField31 = new JTextField();
/*   640 */     this.jLabel34 = new JLabel();
/*   641 */     this.jPanel21 = new JPanel();
/*   642 */     this.jLabel96 = new JLabel();
/*   643 */     this.jComboBox27 = new JComboBox();
/*   644 */     this.jLabel97 = new JLabel();
/*   645 */     this.jSeparator4 = new JSeparator();
/*   646 */     this.jTextField16 = new JTextField();
/*   647 */     this.jPanel18 = new JPanel();
/*   648 */     this.jLabel57 = new JLabel();
/*   649 */     this.jComboBox33 = new JComboBox();
/*   650 */     this.jPanel19 = new JPanel();
/*   651 */     this.jLabel107 = new JLabel();
/*   652 */     this.jSeparator10 = new JSeparator();
/*   653 */     this.jPanel20 = new JPanel();
/*   654 */     this.jPanel10 = new JPanel();
/*   655 */     this.jPanel23 = new JPanel();
/*   656 */     this.jPanel2 = new JPanel();
/*   657 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*   658 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*   659 */     this.jLabel5 = new JLabel();
/*   660 */     this.jLabel6 = new JLabel();
/*   661 */     this.jLabel7 = new JLabel();
/*   662 */     this.jLabel1 = new JLabel();
/*   663 */     this.jLabel4 = new JLabel();
/*   664 */     this.jComboBox21 = new JComboBox();
/*   665 */     this.jLabel20 = new JLabel();
/*   666 */     this.jButton1 = new JButton();
/*   667 */     this.jButton22 = new JButton();
/*   668 */     this.jLabel48 = new JLabel();
/*   669 */     this.jPanel49 = new JPanel();
/*   670 */     this.jComboBox16 = new JComboBox();
/*   671 */     this.jComboBox7 = new JComboBox();
/*   672 */     this.jComboBox6 = new JComboBox();
/*   673 */     this.jComboBox5 = new JComboBox();
/*   674 */     this.jLabel3 = new JLabel();
/*   675 */     this.jDialog30 = new CerrarVentana(this.padre);
/*   676 */     this.jPanel172 = new JPanel();
/*   677 */     this.materialButton40 = new MaterialButton();
/*   678 */     this.materialButton41 = new MaterialButton();
/*   679 */     this.jTextField36 = new JTextField();
/*   680 */     this.jScrollPane3 = new JScrollPane();
/*   681 */     this.jTable3 = new JTable();
/*   682 */     this.jPanel60 = new JPanel();
/*   683 */     this.jPanel61 = new JPanel();
/*   684 */     this.jLabel114 = new JLabel();
/*   685 */     this.jComboBox34 = new JComboBox();
/*   686 */     this.jComboBox20 = new JComboBox();
/*   687 */     this.jComboBox1 = new JComboBox();
/*   688 */     this.jComboBox2 = new JComboBox();
/*   689 */     this.jComboBox31 = new JComboBox();
/*   690 */     this.jComboBox3 = new JComboBox();
/*   691 */     this.jComboBox4 = new JComboBox();
/*   692 */     this.jDialog12 = new CerrarVentana(this.padre);
/*   693 */     this.jPanel62 = new JPanel();
/*   694 */     this.jPanel63 = new JPanel();
/*   695 */     this.jLabel33 = new JLabel();
/*   696 */     this.jPanel80 = new JPanel();
/*   697 */     this.jLabel128 = new JLabel();
/*   698 */     this.jLabel39 = new JLabel();
/*   699 */     this.jPanel79 = new JPanel();
/*   700 */     this.materialButton38 = new MaterialButton();
/*   701 */     this.jPanel64 = new JPanel();
/*   702 */     this.jScrollPane33 = new JScrollPane();
/*   703 */     this.rSTableMetro2 = new RSTableMetro();
/*   704 */     this.jLabel15 = new JLabel();
/*   705 */     this.RecepAnteior = new CerrarVentana(this.padre);
/*   706 */     this.jPanel9 = new JPanel();
/*   707 */     this.jLabel8 = new JLabel();
/*   708 */     this.jSeparator1 = new JSeparator();
/*   709 */     this.jLabel12 = new JLabel();
/*   710 */     this.jPanel22 = new JPanel();
/*   711 */     this.jLabel108 = new JLabel();
/*   712 */     this.jTextField33 = new JTextField();
/*   713 */     this.jLabel109 = new JLabel();
/*   714 */     this.jTextField34 = new JTextField();
/*   715 */     this.jLabel110 = new JLabel();
/*   716 */     this.jTextField35 = new JTextField();
/*   717 */     this.jDialog18 = new CerrarVentana(this.padre);
/*   718 */     this.jPanel135 = new JPanel();
/*   719 */     this.jLabel189 = new JLabel();
/*   720 */     this.jLabel193 = new JLabel();
/*   721 */     this.jTextField87 = new JTextField();
/*   722 */     this.jTextField88 = new JTextField();
/*   723 */     this.jSeparator13 = new JSeparator();
/*   724 */     this.materialButton24 = new MaterialButton();
/*   725 */     this.jTextField89 = new JTextField();
/*   726 */     this.jLabel194 = new JLabel();
/*   727 */     this.jPanel1 = new JPanel();
/*   728 */     this.jPanel5 = new JPanel();
/*   729 */     this.jPanel48 = new JPanel();
/*   730 */     this.jLabel60 = new JLabel();
/*   731 */     this.jLabel50 = new JLabel();
/*   732 */     this.jLabel64 = new JLabel();
/*   733 */     this.jLabel54 = new JLabel();
/*   734 */     this.jPanel50 = new JPanel();
/*   735 */     this.jButton24 = new JButton();
/*   736 */     this.jButton2 = new JButton();
/*   737 */     this.jButton26 = new JButton();
/*   738 */     this.jButton25 = new JButton();
/*   739 */     this.jButton8 = new JButton();
/*   740 */     this.jButton4 = new JButton();
/*   741 */     this.jButton5 = new JButton();
/*   742 */     this.jButton9 = new JButton();
/*   743 */     this.jButton18 = new JButton();
/*   744 */     this.jButton6 = new JButton();
/*   745 */     this.jButton19 = new JButton();
/*   746 */     this.jButton27 = new JButton();
/*   747 */     this.jScrollPane20 = new JScrollPane();
/*   748 */     this.rSTableMetro1 = new RSTableMetro();
/*   749 */     this.jPanel17 = new JPanel();
/*   750 */     this.jPanel51 = new JPanel();
/*   751 */     this.jComboBox30 = new JComboBox();
/*   752 */     this.jPanel56 = new JPanel();
/*   753 */     this.jComboBox8 = new JComboBox();
/*   754 */     this.jTextField1 = new JTextField();
/*   755 */     this.jTextField2 = new JTextField();
/*   756 */     this.jPanel59 = new JPanel();
/*   757 */     this.jTextField4 = new JTextField();
/*   758 */     this.jTextField3 = new JTextField();
/*   759 */     this.jPanel57 = new JPanel();
/*   760 */     this.jTextField11 = new JTextField();
/*   761 */     this.jTextField12 = new JTextField();
/*   762 */     this.jTextField37 = new JTextField();
/*   763 */     this.jPanel58 = new JPanel();
/*   764 */     this.jTextField38 = new JTextField();
/*   765 */     this.jTextField39 = new JTextField();
/*   766 */     this.jTextField40 = new JTextField();
/*   767 */     this.jTextField46 = new JTextField();
/*   768 */     this.jTextField47 = new JTextField();
/*   769 */     this.jLabel56 = new JLabel();
/*   770 */     this.jPanel52 = new JPanel();
/*   771 */     this.jPanel53 = new JPanel();
/*   772 */     this.jDateChooser9 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*   773 */     this.jLabel235 = new JLabel();
/*   774 */     this.jDateChooser10 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*   775 */     this.jComboBox36 = new JComboBox<>();
/*   776 */     this.jPanel54 = new JPanel();
/*   777 */     this.jButton16 = new JButton();
/*   778 */     this.jLabel172 = new JLabel();
/*   779 */     this.jLabel103 = new JLabel();
/*   780 */     this.jLabel173 = new JLabel();
/*   781 */     this.jPanel55 = new JPanel();
/*   782 */     this.jLabel236 = new JLabel();
/*   783 */     this.jComboBox37 = new JComboBox<>();
/*       */     
/*   785 */     this.jDialog1.setTitle("Cancelar Viaje");
/*   786 */     this.jDialog1.setModal(true);
/*       */     
/*   788 */     this.jPanel8.setBackground(new Color(146, 193, 134));
/*       */     
/*   790 */     this.jLabel62.setFont(new Font("Tahoma", 1, 14));
/*   791 */     this.jLabel62.setForeground(new Color(0, 102, 102));
/*   792 */     this.jLabel62.setHorizontalAlignment(0);
/*   793 */     this.jLabel62.setText("Motivo de la Cancelación");
/*       */     
/*   795 */     this.jLabel63.setFont(new Font("Tahoma", 3, 11));
/*   796 */     this.jLabel63.setForeground(new Color(15, 87, 51));
/*   797 */     this.jLabel63.setHorizontalAlignment(4);
/*   798 */     this.jLabel63.setText("Motivo");
/*       */     
/*   800 */     this.jTextField14.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*   802 */             ModificarGuias.this.jTextField14ActionPerformed(evt);
/*       */           }
/*       */         });
/*   805 */     this.jTextField14.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*   807 */             ModificarGuias.this.jTextField14KeyReleased(evt);
/*       */           }
/*       */         });
/*       */     
/*   811 */     this.jButton11.setText("Cancelar Guía");
/*   812 */     this.jButton11.setToolTipText("Cancelar Guía");
/*   813 */     this.jButton11.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*   815 */             ModificarGuias.this.jButton11ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*   819 */     this.jButton12.setMnemonic('C');
/*   820 */     this.jButton12.setText("Cerrar");
/*   821 */     this.jButton12.setToolTipText("Cerrar (Alt+C)");
/*   822 */     this.jButton12.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*   824 */             ModificarGuias.this.jButton12ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*   828 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*   829 */     this.jPanel8.setLayout(jPanel8Layout);
/*   830 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/*   831 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*   832 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*   833 */           .addContainerGap()
/*   834 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*   835 */             .addComponent(this.jLabel62, -1, 279, 32767)
/*   836 */             .addComponent(this.jSeparator3, -1, 279, 32767)
/*   837 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*   838 */               .addComponent(this.jLabel63, -2, 57, -2)
/*   839 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*   840 */               .addComponent(this.jTextField14, -1, 218, 32767))
/*   841 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/*   842 */               .addComponent(this.jButton11)
/*   843 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*   844 */               .addComponent(this.jButton12, -2, 84, -2)))
/*   845 */           .addContainerGap()));
/*       */     
/*   847 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/*   848 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*   849 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*   850 */           .addComponent(this.jLabel62)
/*   851 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*   852 */           .addComponent(this.jSeparator3, -2, 10, -2)
/*   853 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*   854 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*   855 */             .addComponent(this.jLabel63)
/*   856 */             .addComponent(this.jTextField14, -2, -1, -2))
/*   857 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*   858 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*   859 */             .addComponent(this.jButton12)
/*   860 */             .addComponent(this.jButton11))
/*   861 */           .addContainerGap(-1, 32767)));
/*       */ 
/*       */     
/*   864 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*   865 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*   866 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*   867 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*   868 */         .addComponent(this.jPanel8, -1, -1, 32767));
/*       */     
/*   870 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*   871 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*   872 */         .addComponent(this.jPanel8, -2, -1, -2));
/*       */ 
/*       */     
/*   875 */     this.jDialog3.setTitle("Detalles de Guías");
/*   876 */     this.jDialog3.setModal(true);
/*       */     
/*   878 */     this.jPanel12.setBackground(new Color(255, 255, 255));
/*       */     
/*   880 */     this.jLabel89.setFont(new Font("Times New Roman", 1, 25));
/*   881 */     this.jLabel89.setForeground(new Color(102, 102, 102));
/*   882 */     this.jLabel89.setHorizontalAlignment(0);
/*   883 */     this.jLabel89.setText("Detalles de la Guía");
/*       */     
/*   885 */     this.jLabel11.setText("Guía: ");
/*       */     
/*   887 */     this.jLabel13.setFont(new Font("Tahoma", 1, 11));
/*   888 */     this.jLabel13.setText("PR-00001");
/*       */     
/*   890 */     this.jLabel14.setText("Autorizó:");
/*       */     
/*   892 */     this.jLabel18.setFont(new Font("Tahoma", 1, 11));
/*   893 */     this.jLabel18.setText("PR-00001");
/*       */     
/*   895 */     this.jLabel19.setFont(new Font("Tahoma", 3, 11));
/*   896 */     this.jLabel19.setForeground(Color.red);
/*   897 */     this.jLabel19.setText("A continuación se muestra toda la información de la guía hasta el momento");
/*       */     
/*   899 */     this.jTextArea1.setEditable(false);
/*   900 */     this.jTextArea1.setColumns(20);
/*   901 */     this.jTextArea1.setFont(new Font("Tahoma", 0, 12));
/*   902 */     this.jTextArea1.setLineWrap(true);
/*   903 */     this.jTextArea1.setRows(5);
/*   904 */     this.jTextArea1.setText("Ejemplo del texto");
/*   905 */     this.jScrollPane1.setViewportView(this.jTextArea1);
/*       */     
/*   907 */     this.jLabel52.setFont(new Font("Tahoma", 1, 11));
/*   908 */     this.jLabel52.setText("|");
/*       */     
/*   910 */     this.jLabel51.setFont(new Font("Tahoma", 1, 11));
/*   911 */     this.jLabel51.setForeground(Color.red);
/*   912 */     this.jLabel51.setHorizontalAlignment(0);
/*   913 */     this.jLabel51.setText("<html><u>Cerrar</u></html>");
/*   914 */     this.jLabel51.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*   916 */             ModificarGuias.this.jLabel51MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*   919 */             ModificarGuias.this.jLabel51MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*   922 */             ModificarGuias.this.jLabel51MouseExited(evt);
/*       */           }
/*       */         });
/*       */     
/*   926 */     this.jLabel53.setFont(new Font("Tahoma", 1, 11));
/*   927 */     this.jLabel53.setText("|");
/*       */     
/*   929 */     this.jLabel61.setFont(new Font("Tahoma", 1, 11));
/*   930 */     this.jLabel61.setText("|");
/*       */     
/*   932 */     this.jLabel90.setFont(new Font("Tahoma", 1, 11));
/*   933 */     this.jLabel90.setForeground(Color.red);
/*   934 */     this.jLabel90.setHorizontalAlignment(0);
/*   935 */     this.jLabel90.setText("<html><u>Agregar Comentario a Descripción</u></html>");
/*   936 */     this.jLabel90.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*   938 */             ModificarGuias.this.jLabel90MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*   941 */             ModificarGuias.this.jLabel90MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*   944 */             ModificarGuias.this.jLabel90MouseExited(evt);
/*       */           }
/*       */         });
/*       */     
/*   948 */     this.jLabel98.setFont(new Font("Times New Roman", 1, 12));
/*   949 */     this.jLabel98.setText("ESTATUS:");
/*       */     
/*   951 */     this.jLabel99.setFont(new Font("Times New Roman", 1, 12));
/*   952 */     this.jLabel99.setForeground(new Color(0, 0, 102));
/*   953 */     this.jLabel99.setText("jLabel99");
/*       */     
/*   955 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/*   956 */     this.jPanel12.setLayout(jPanel12Layout);
/*   957 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/*   958 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*   959 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
/*   960 */           .addContainerGap()
/*   961 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*   962 */             .addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 660, 32767)
/*   963 */             .addComponent(this.jLabel19, GroupLayout.Alignment.LEADING, -1, 660, 32767)
/*   964 */             .addComponent(this.jLabel89, GroupLayout.Alignment.LEADING, -1, 660, 32767)
/*   965 */             .addComponent(this.jSeparator5, GroupLayout.Alignment.LEADING, -1, 660, 32767)
/*   966 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
/*   967 */               .addComponent(this.jLabel11, -2, 36, -2)
/*   968 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*   969 */               .addComponent(this.jLabel13, -2, 227, -2))
/*   970 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
/*   971 */               .addComponent(this.jLabel14, -2, 48, -2)
/*   972 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*   973 */               .addComponent(this.jLabel18, -1, 606, 32767))
/*   974 */             .addGroup(jPanel12Layout.createSequentialGroup()
/*   975 */               .addComponent(this.jLabel98, -2, 69, -2)
/*   976 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*   977 */               .addComponent(this.jLabel99, -1, 256, 32767)
/*   978 */               .addGap(18, 18, 18)
/*   979 */               .addComponent(this.jLabel61)
/*   980 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*   981 */               .addComponent(this.jLabel90, -2, 230, -2)
/*   982 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*   983 */               .addComponent(this.jLabel52)
/*   984 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*   985 */               .addComponent(this.jLabel51, -2, -1, -2)
/*   986 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*   987 */               .addComponent(this.jLabel53)))
/*   988 */           .addContainerGap()));
/*       */     
/*   990 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/*   991 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*   992 */         .addGroup(jPanel12Layout.createSequentialGroup()
/*   993 */           .addComponent(this.jLabel89)
/*   994 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*   995 */           .addComponent(this.jSeparator5, -2, 10, -2)
/*   996 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*   997 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*   998 */             .addComponent(this.jLabel11)
/*   999 */             .addComponent(this.jLabel13))
/*  1000 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1001 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  1002 */             .addComponent(this.jLabel14)
/*  1003 */             .addComponent(this.jLabel18))
/*  1004 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1005 */           .addComponent(this.jLabel19)
/*  1006 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1007 */           .addComponent(this.jScrollPane1, -2, 344, -2)
/*  1008 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1009 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  1010 */             .addComponent(this.jLabel53)
/*  1011 */             .addComponent(this.jLabel51, -2, -1, -2)
/*  1012 */             .addComponent(this.jLabel52)
/*  1013 */             .addComponent(this.jLabel90, -2, -1, -2)
/*  1014 */             .addComponent(this.jLabel61)
/*  1015 */             .addComponent(this.jLabel98)
/*  1016 */             .addComponent(this.jLabel99))
/*  1017 */           .addContainerGap(-1, 32767)));
/*       */ 
/*       */     
/*  1020 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/*  1021 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/*  1022 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/*  1023 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1024 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*       */     
/*  1026 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/*  1027 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1028 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*       */ 
/*       */     
/*  1031 */     this.jDialog4.setTitle("Modificar Guía");
/*  1032 */     this.jDialog4.setBackground(new Color(146, 193, 134));
/*  1033 */     this.jDialog4.setModal(true);
/*       */     
/*  1035 */     this.jPanel73.setBackground(new Color(146, 193, 134));
/*       */     
/*  1037 */     this.jPanel47.setBorder(BorderFactory.createTitledBorder("Información de la guía"));
/*       */     
/*  1039 */     this.jPanel4.setLayout(new GridLayout(1, 6, 6, 0));
/*       */     
/*  1041 */     this.jLabel32.setFont(new Font("Cantarell", 0, 11));
/*  1042 */     this.jLabel32.setHorizontalAlignment(4);
/*  1043 */     this.jLabel32.setText("Folio SICRET");
/*  1044 */     this.jPanel4.add(this.jLabel32);
/*       */     
/*  1046 */     this.jTextField15.setEditable(false);
/*  1047 */     this.jTextField15.setFont(new Font("Cantarell", 0, 13));
/*  1048 */     this.jTextField15.setForeground(this.lc.PRIMARIO1);
/*  1049 */     this.jTextField15.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1051 */             ModificarGuias.this.jTextField15ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1054 */     this.jPanel4.add(this.jTextField15);
/*       */     
/*  1056 */     this.jLabel59.setFont(new Font("Cantarell", 0, 11));
/*  1057 */     this.jLabel59.setHorizontalAlignment(4);
/*  1058 */     this.jLabel59.setText("Folio Impreso (Rojo)");
/*  1059 */     this.jPanel4.add(this.jLabel59);
/*  1060 */     this.jPanel4.add(this.jTextField43);
/*       */     
/*  1062 */     this.jLabel40.setFont(new Font("Cantarell", 0, 11));
/*  1063 */     this.jLabel40.setHorizontalAlignment(4);
/*  1064 */     this.jLabel40.setText("Fecha");
/*  1065 */     this.jPanel4.add(this.jLabel40);
/*       */     
/*  1067 */     this.jDateChooser2.setBackground(new Color(218, 231, 246));
/*  1068 */     this.jDateChooser2.setDate(this.fechaActual);
/*  1069 */     this.jDateChooser2.setDateFormatString("yyyy/MM/dd");
/*  1070 */     this.jDateChooser2.setIcon(this.icon);
/*  1071 */     this.jDateChooser2.setMaxSelectableDate(this.fechaActual);
/*  1072 */     this.jPanel4.add((Component)this.jDateChooser2);
/*       */     
/*  1074 */     this.jPanel74.setLayout(new GridLayout(7, 4, 6, 6));
/*       */     
/*  1076 */     this.jLabel93.setFont(new Font("Cantarell", 0, 11));
/*  1077 */     this.jLabel93.setHorizontalAlignment(4);
/*  1078 */     this.jLabel93.setText("Tipo de Servicio");
/*  1079 */     this.jPanel74.add(this.jLabel93);
/*       */     
/*  1081 */     this.jComboBox22.setBackground(new Color(244, 244, 244));
/*  1082 */     this.jComboBox22.setModel(new DefaultComboBoxModel<>(new String[] { "CARGADA LATERAL", "ESTADIA", "FLETE", "MANIOBRA", "MOVIMIENTO EN FALSO", "MOVIMIENTO INTERNO", "MOVIMIENTO LATERAL", "SERVICIO INTEGRAL", "SERVICIO DE RETRO", "RENTA" }));
/*  1083 */     this.jPanel74.add(this.jComboBox22);
/*       */     
/*  1085 */     this.jLabel35.setFont(new Font("Cantarell", 0, 11));
/*  1086 */     this.jLabel35.setHorizontalAlignment(4);
/*  1087 */     this.jLabel35.setText("Tipo de Carga");
/*  1088 */     this.jPanel74.add(this.jLabel35);
/*       */     
/*  1090 */     this.jComboBox9.setBackground(new Color(244, 244, 244));
/*  1091 */     this.jComboBox9.setModel(new DefaultComboBoxModel<>(new String[] { "ACEITE ESTABILIZADO", "ACIDO CLORHIDRICO", "ACIDOS VARIOS", "AGUA CONTAMINADA", "AGUA CONTAMINADA C/HIDROCARBUROS", "AGUA DE FRACTURA", "AGUA RESIDUAL", "AGUAS OLEOSAS", "ARENA SILICA", "AROMINA", "BASURA CONTAMINADA", "BARITA", "CAJAS DE RECORTE DE PERFORACION", "CEMENTO", "FLUIDO DE EMULSION INVERSA CONTAMINADO CON AGUA DE FORMACION", "FLUIDO RECUPERADO", "FLUIDO RECUPERADO C/TRAZAS DE ACEITE", "FLUIDO RECUPERADO SALMUERA CONTAMINADA CON HIDROCARBUROS", "HIDROCARBURO", "LODOS ACEITOSOS", "LODO BASE ACEITE", "LODO BASE AGUA", "LODOS CONTAMINADOS PROVENIENTES DEL SIAC TAJÍN 5", "LODOS RESIDUALES", "MATERIAL QUIMICO", "MINERAL HIERRO", "RECORTE DE PERFORACION BASE ACEITE", "RECORTE BASE AGUA", "RESIDUOS ADICIONALES A LA PERFORACION DE ACEITE", "RESIDUOS ADICIONALES A LA PERFORACION DE AGUA", "REMANENTE IMPREGNABLE", "REMANENTE", "PRODUCTO QUIMICO MA-2", "SALMUERA", "SANEAMIENTO", "SÓLIDOS CONTAMINADOS CON HIDROCARBUROS", "SÓLIDOS CONTAMINADOS CON FLUIDO BASE AGUA", "SOLVENTES", "SEDIMENTO", "SEDIMENTO DE LIMPIEZA DE PRESAS", "TIERRA IMPREGNADA CON HIDROCARBUROS", "TIERRA CONTAMINADA (SANEAMIENTO)", "FLETES - VARIOS" }));
/*  1092 */     this.jComboBox9.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1094 */             ModificarGuias.this.jComboBox9ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1097 */     this.jPanel74.add(this.jComboBox9);
/*       */     
/*  1099 */     this.jLabel55.setFont(new Font("Cantarell", 0, 11));
/*  1100 */     this.jLabel55.setHorizontalAlignment(4);
/*  1101 */     this.jLabel55.setText("Cliente u Origen");
/*  1102 */     this.jPanel74.add(this.jLabel55);
/*       */     
/*  1104 */     this.jComboBox15.setBackground(new Color(244, 244, 244));
/*  1105 */     this.jComboBox15.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1107 */             ModificarGuias.this.jComboBox15ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1110 */     this.jPanel74.add(this.jComboBox15);
/*       */     
/*  1112 */     this.jLabel105.setFont(new Font("Cantarell", 0, 11));
/*  1113 */     this.jLabel105.setHorizontalAlignment(4);
/*  1114 */     this.jLabel105.setText("Línea");
/*  1115 */     this.jPanel74.add(this.jLabel105);
/*       */     
/*  1117 */     this.jComboBox32.setBackground(new Color(244, 244, 244));
/*  1118 */     this.jPanel74.add(this.jComboBox32);
/*       */     
/*  1120 */     this.jLabel36.setFont(new Font("Cantarell", 0, 11));
/*  1121 */     this.jLabel36.setHorizontalAlignment(4);
/*  1122 */     this.jLabel36.setText("Destino");
/*  1123 */     this.jPanel74.add(this.jLabel36);
/*       */     
/*  1125 */     this.jComboBox10.setBackground(new Color(244, 244, 244));
/*  1126 */     this.jComboBox10.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1128 */             ModificarGuias.this.jComboBox10ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1131 */     this.jPanel74.add(this.jComboBox10);
/*       */     
/*  1133 */     this.jLabel95.setFont(new Font("Cantarell", 0, 11));
/*  1134 */     this.jLabel95.setHorizontalAlignment(4);
/*  1135 */     this.jLabel95.setText("Operador");
/*  1136 */     this.jPanel74.add(this.jLabel95);
/*       */     
/*  1138 */     this.jComboBox24.setBackground(new Color(244, 244, 244));
/*  1139 */     this.jComboBox24.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1141 */             ModificarGuias.this.jComboBox24ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1144 */     this.jPanel74.add(this.jComboBox24);
/*       */     
/*  1146 */     this.jLabel58.setFont(new Font("Cantarell", 0, 11));
/*  1147 */     this.jLabel58.setHorizontalAlignment(4);
/*  1148 */     this.jLabel58.setText("Núm. de Tractor ");
/*  1149 */     this.jPanel74.add(this.jLabel58);
/*       */     
/*  1151 */     this.jComboBox25.setBackground(new Color(244, 244, 244));
/*  1152 */     this.jPanel74.add(this.jComboBox25);
/*       */     
/*  1154 */     this.jLabel66.setFont(new Font("Cantarell", 0, 11));
/*  1155 */     this.jLabel66.setHorizontalAlignment(4);
/*  1156 */     this.jLabel66.setText("Núm de Remolque ");
/*  1157 */     this.jPanel74.add(this.jLabel66);
/*       */     
/*  1159 */     this.jComboBox26.setBackground(new Color(244, 244, 244));
/*  1160 */     this.jPanel74.add(this.jComboBox26);
/*       */     
/*  1162 */     this.jLabel94.setFont(new Font("Cantarell", 0, 11));
/*  1163 */     this.jLabel94.setHorizontalAlignment(4);
/*  1164 */     this.jLabel94.setText("Tipo de Remolque ");
/*  1165 */     this.jPanel74.add(this.jLabel94);
/*       */     
/*  1167 */     this.jComboBox23.setBackground(new Color(244, 244, 244));
/*  1168 */     this.jComboBox23.setModel(new DefaultComboBoxModel<>(new String[] { "BULLDOZER", "CAMA BAJA", "CAMIONETA 350", "CAMIONETA ESTAQUITA", "CAMIONETA PICK UP", "CAMIONETA PILOTO", "CONTENEDOR MARINO", "CUELLO DE GANZO", "EXCAVADORA ORUGA", "GÓNDOLA", "HIAB", "LOWBOY", "PIPA", "PLANA", "PLATAFORMA", "PRESAS METÁLICAS", "PRESIÓN Y VACÍO", "PORTA CONTENEDORES", "QUINTA SENCILLA", "QUINTA CON WINCHE", "QUINTA CON HIAB", "RABÓN", "RETROEXCAVADORA", "TIRO DIRECTO", "TOLVA GRANELERA", "TOLVA DE ALUMNIO", "TOLVA DE ACERO INOXIDABLE", "TOLVA PRESURIZADA", "TORTON", "OTRO" }));
/*  1169 */     this.jComboBox23.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1171 */             ModificarGuias.this.jComboBox23ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1174 */     this.jPanel74.add(this.jComboBox23);
/*       */     
/*  1176 */     this.jLabel37.setFont(new Font("Cantarell", 0, 11));
/*  1177 */     this.jLabel37.setHorizontalAlignment(4);
/*  1178 */     this.jLabel37.setText("Equipo ");
/*  1179 */     this.jPanel74.add(this.jLabel37);
/*       */     
/*  1181 */     this.jComboBox11.setBackground(new Color(244, 244, 244));
/*  1182 */     this.jPanel74.add(this.jComboBox11);
/*       */     
/*  1184 */     this.jLabel47.setFont(new Font("Cantarell", 0, 11));
/*  1185 */     this.jLabel47.setHorizontalAlignment(4);
/*  1186 */     this.jLabel47.setText("Plataforma ");
/*  1187 */     this.jPanel74.add(this.jLabel47);
/*       */     
/*  1189 */     this.jComboBox13.setBackground(new Color(244, 244, 244));
/*  1190 */     this.jComboBox13.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1192 */             ModificarGuias.this.jComboBox13ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1195 */     this.jPanel74.add(this.jComboBox13);
/*       */     
/*  1197 */     this.jLabel38.setFont(new Font("Cantarell", 0, 11));
/*  1198 */     this.jLabel38.setHorizontalAlignment(4);
/*  1199 */     this.jLabel38.setText("Pozo");
/*  1200 */     this.jPanel74.add(this.jLabel38);
/*       */     
/*  1202 */     this.jComboBox12.setBackground(new Color(244, 244, 244));
/*  1203 */     this.jComboBox12.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1205 */             ModificarGuias.this.jComboBox12ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1208 */     this.jPanel74.add(this.jComboBox12);
/*       */     
/*  1210 */     this.jLabel49.setFont(new Font("Cantarell", 0, 11));
/*  1211 */     this.jLabel49.setHorizontalAlignment(4);
/*  1212 */     this.jLabel49.setText("Estado ");
/*  1213 */     this.jPanel74.add(this.jLabel49);
/*       */     
/*  1215 */     this.jComboBox14.setBackground(new Color(244, 244, 244));
/*  1216 */     this.jComboBox14.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVA", "CANCELADA" }));
/*  1217 */     this.jComboBox14.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1219 */             ModificarGuias.this.jComboBox14ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1222 */     this.jPanel74.add(this.jComboBox14);
/*       */     
/*  1224 */     this.jLabel100.setFont(new Font("Cantarell", 0, 11));
/*  1225 */     this.jLabel100.setHorizontalAlignment(4);
/*  1226 */     this.jLabel100.setText("Estatus ");
/*  1227 */     this.jPanel74.add(this.jLabel100);
/*       */     
/*  1229 */     this.jComboBox28.setBackground(new Color(244, 244, 244));
/*  1230 */     this.jComboBox28.setModel(new DefaultComboBoxModel<>(new String[] { "<Asignada Al Operador>", "<En Prefactura Interna>", "<Facturada>", "<Sólo Cargada: En Patio>", "<Pagada Al Operador>" }));
/*  1231 */     this.jComboBox28.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1233 */             ModificarGuias.this.jComboBox28ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1236 */     this.jPanel74.add(this.jComboBox28);
/*       */     
/*  1238 */     this.jTextArea2.setColumns(20);
/*  1239 */     this.jTextArea2.setFont(new Font("Monospaced", 0, 10));
/*  1240 */     this.jTextArea2.setLineWrap(true);
/*  1241 */     this.jTextArea2.setRows(5);
/*  1242 */     this.jScrollPane4.setViewportView(this.jTextArea2);
/*       */     
/*  1244 */     this.jLabel91.setFont(new Font("Cantarell", 0, 11));
/*  1245 */     this.jLabel91.setText("Comentarios:");
/*       */     
/*  1247 */     this.materialButton16.setBackground(this.lc.SECUNDARIO1);
/*  1248 */     this.materialButton16.setForeground(new Color(255, 255, 255));
/*  1249 */     this.materialButton16.setMnemonic('C');
/*  1250 */     this.materialButton16.setText("Cerrar");
/*  1251 */     this.materialButton16.setToolTipText("Cerrar (Alt+C)");
/*  1252 */     this.materialButton16.setFont(new Font("Cantarell", 0, 12));
/*  1253 */     this.materialButton16.setHorizontalTextPosition(0);
/*  1254 */     this.materialButton16.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1256 */             ModificarGuias.this.materialButton16ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1260 */     this.materialButton17.setBackground(this.lc.PRIMARIO1);
/*  1261 */     this.materialButton17.setForeground(new Color(255, 255, 255));
/*  1262 */     this.materialButton17.setMnemonic('M');
/*  1263 */     this.materialButton17.setText("Modificar Guía");
/*  1264 */     this.materialButton17.setToolTipText("Modificar Guía (Alt+M)");
/*  1265 */     this.materialButton17.setFont(new Font("Cantarell", 0, 12));
/*  1266 */     this.materialButton17.setHorizontalTextPosition(0);
/*  1267 */     this.materialButton17.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1269 */             ModificarGuias.this.materialButton17ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1273 */     GroupLayout jPanel47Layout = new GroupLayout(this.jPanel47);
/*  1274 */     this.jPanel47.setLayout(jPanel47Layout);
/*  1275 */     jPanel47Layout.setHorizontalGroup(jPanel47Layout
/*  1276 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1277 */         .addComponent(this.jPanel4, -2, 0, 32767)
/*  1278 */         .addComponent(this.jPanel74, GroupLayout.Alignment.TRAILING, -2, 0, 32767)
/*  1279 */         .addComponent(this.jSeparator11)
/*  1280 */         .addComponent(this.jScrollPane4, -1, 694, 32767)
/*  1281 */         .addGroup(jPanel47Layout.createSequentialGroup()
/*  1282 */           .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1283 */             .addGroup(jPanel47Layout.createSequentialGroup()
/*  1284 */               .addComponent(this.jLabel91, -2, 110, -2)
/*  1285 */               .addGap(0, 0, 32767))
/*  1286 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
/*  1287 */               .addGap(0, 0, 32767)
/*  1288 */               .addComponent((Component)this.materialButton17, -2, 150, -2)
/*  1289 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1290 */               .addComponent((Component)this.materialButton16, -2, 105, -2)))
/*  1291 */           .addContainerGap()));
/*       */     
/*  1293 */     jPanel47Layout.setVerticalGroup(jPanel47Layout
/*  1294 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1295 */         .addGroup(jPanel47Layout.createSequentialGroup()
/*  1296 */           .addComponent(this.jPanel4, -2, -1, -2)
/*  1297 */           .addGap(9, 9, 9)
/*  1298 */           .addComponent(this.jSeparator11, -2, 12, -2)
/*  1299 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1300 */           .addComponent(this.jPanel74, -2, 229, -2)
/*  1301 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1302 */           .addComponent(this.jLabel91)
/*  1303 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1304 */           .addComponent(this.jScrollPane4, -1, 144, 32767)
/*  1305 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1306 */           .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  1307 */             .addComponent((Component)this.materialButton16, -2, 38, -2)
/*  1308 */             .addComponent((Component)this.materialButton17, -2, 38, -2))
/*  1309 */           .addContainerGap()));
/*       */ 
/*       */     
/*  1312 */     GroupLayout jPanel73Layout = new GroupLayout(this.jPanel73);
/*  1313 */     this.jPanel73.setLayout(jPanel73Layout);
/*  1314 */     jPanel73Layout.setHorizontalGroup(jPanel73Layout
/*  1315 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1316 */         .addComponent(this.jPanel47, -1, -1, 32767));
/*       */     
/*  1318 */     jPanel73Layout.setVerticalGroup(jPanel73Layout
/*  1319 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1320 */         .addGroup(jPanel73Layout.createSequentialGroup()
/*  1321 */           .addComponent(this.jPanel47, -1, -1, 32767)
/*  1322 */           .addGap(0, 0, 0)));
/*       */ 
/*       */     
/*  1325 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/*  1326 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/*  1327 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/*  1328 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1329 */         .addComponent(this.jPanel73, -1, -1, 32767));
/*       */     
/*  1331 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/*  1332 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1333 */         .addComponent(this.jPanel73, -1, -1, 32767));
/*       */ 
/*       */     
/*  1336 */     this.jDialog5.setTitle("Agregar Comentario a Guía");
/*  1337 */     this.jDialog5.setModal(true);
/*       */     
/*  1339 */     this.jPanel29.setBackground(new Color(146, 193, 134));
/*       */     
/*  1341 */     this.jLabel124.setFont(new Font("Tahoma", 1, 14));
/*  1342 */     this.jLabel124.setForeground(new Color(0, 102, 102));
/*  1343 */     this.jLabel124.setHorizontalAlignment(0);
/*  1344 */     this.jLabel124.setText("Agregar Comentario");
/*       */     
/*  1346 */     this.jLabel125.setFont(new Font("Tahoma", 3, 11));
/*  1347 */     this.jLabel125.setForeground(new Color(15, 87, 51));
/*  1348 */     this.jLabel125.setHorizontalAlignment(4);
/*  1349 */     this.jLabel125.setText("Comentario");
/*       */     
/*  1351 */     this.jButton44.setMnemonic('A');
/*  1352 */     this.jButton44.setText("Agregar");
/*  1353 */     this.jButton44.setToolTipText("Agregar Comentario a esta guía");
/*  1354 */     this.jButton44.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1356 */             ModificarGuias.this.jButton44ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1360 */     this.jButton45.setMnemonic('C');
/*  1361 */     this.jButton45.setText("Cerrar");
/*  1362 */     this.jButton45.setToolTipText("Cerrar (Alt+C)");
/*  1363 */     this.jButton45.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1365 */             ModificarGuias.this.jButton45ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1369 */     this.jTextArea5.setColumns(20);
/*  1370 */     this.jTextArea5.setLineWrap(true);
/*  1371 */     this.jTextArea5.setRows(5);
/*  1372 */     this.jScrollPane18.setViewportView(this.jTextArea5);
/*       */     
/*  1374 */     this.jLabel126.setText("Ingresa un nuevo comentario a la guía que seleccionaste:");
/*       */     
/*  1376 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/*  1377 */     this.jPanel29.setLayout(jPanel29Layout);
/*  1378 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/*  1379 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1380 */         .addGroup(jPanel29Layout.createSequentialGroup()
/*  1381 */           .addContainerGap()
/*  1382 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1383 */             .addComponent(this.jLabel126, -1, -1, 32767)
/*  1384 */             .addGroup(jPanel29Layout.createSequentialGroup()
/*  1385 */               .addComponent(this.jLabel125, -2, 79, -2)
/*  1386 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1387 */               .addComponent(this.jScrollPane18, -2, 302, -2))
/*  1388 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
/*  1389 */               .addComponent(this.jButton44, -2, 89, -2)
/*  1390 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1391 */               .addComponent(this.jButton45, -2, 84, -2))
/*  1392 */             .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  1393 */               .addComponent(this.jLabel124, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  1394 */               .addComponent(this.jSeparator27, GroupLayout.Alignment.LEADING, -1, 383, 32767)))
/*  1395 */           .addContainerGap()));
/*       */     
/*  1397 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/*  1398 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1399 */         .addGroup(jPanel29Layout.createSequentialGroup()
/*  1400 */           .addComponent(this.jLabel124)
/*  1401 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1402 */           .addComponent(this.jSeparator27, -2, 10, -2)
/*  1403 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1404 */           .addComponent(this.jLabel126)
/*  1405 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1406 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1407 */             .addComponent(this.jScrollPane18, -2, 96, -2)
/*  1408 */             .addComponent(this.jLabel125))
/*  1409 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1410 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  1411 */             .addComponent(this.jButton45)
/*  1412 */             .addComponent(this.jButton44))
/*  1413 */           .addContainerGap(-1, 32767)));
/*       */ 
/*       */     
/*  1416 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/*  1417 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/*  1418 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/*  1419 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1420 */         .addComponent(this.jPanel29, -2, -1, -2));
/*       */     
/*  1422 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/*  1423 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1424 */         .addComponent(this.jPanel29, -2, -1, -2));
/*       */ 
/*       */     
/*  1427 */     this.jDialog6.setTitle("Seleccionar Columnas");
/*  1428 */     this.jDialog6.setModal(true);
/*       */     
/*  1430 */     this.jPanel13.setBackground(new Color(146, 193, 134));
/*       */     
/*  1432 */     this.jLabel92.setFont(new Font("Tahoma", 1, 14));
/*  1433 */     this.jLabel92.setForeground(new Color(0, 102, 102));
/*  1434 */     this.jLabel92.setHorizontalAlignment(0);
/*  1435 */     this.jLabel92.setText("Columnas a Imprimir");
/*       */     
/*  1437 */     this.jButton20.setMnemonic('A');
/*  1438 */     this.jButton20.setText("Aceptar");
/*  1439 */     this.jButton20.setToolTipText("Aceptar (Alt+A)");
/*  1440 */     this.jButton20.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1442 */             ModificarGuias.this.jButton20ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1446 */     this.jButton21.setMnemonic('C');
/*  1447 */     this.jButton21.setText("Cerrar");
/*  1448 */     this.jButton21.setToolTipText("Cerrar (Alt+C)");
/*  1449 */     this.jButton21.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1451 */             ModificarGuias.this.jButton21ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1455 */     this.jCheckBox2.setSelected(true);
/*  1456 */     this.jCheckBox2.setText("Guía");
/*  1457 */     this.jCheckBox2.setEnabled(false);
/*       */     
/*  1459 */     this.jCheckBox3.setSelected(true);
/*  1460 */     this.jCheckBox3.setText("Fecha");
/*  1461 */     this.jCheckBox3.setEnabled(false);
/*       */     
/*  1463 */     this.jCheckBox4.setSelected(true);
/*  1464 */     this.jCheckBox4.setText("Servicio");
/*       */     
/*  1466 */     this.jCheckBox5.setSelected(true);
/*  1467 */     this.jCheckBox5.setText("Residuo");
/*       */     
/*  1469 */     this.jCheckBox7.setSelected(true);
/*  1470 */     this.jCheckBox7.setText("Destino");
/*       */     
/*  1472 */     this.jCheckBox9.setText("Placas");
/*       */     
/*  1474 */     this.jCheckBox11.setText("Placas");
/*       */     
/*  1476 */     this.jCheckBox13.setSelected(true);
/*  1477 */     this.jCheckBox13.setText("Origen");
/*       */     
/*  1479 */     this.jCheckBox6.setSelected(true);
/*  1480 */     this.jCheckBox6.setText("Cliente");
/*       */     
/*  1482 */     this.jCheckBox8.setSelected(true);
/*  1483 */     this.jCheckBox8.setText("Tractor");
/*       */     
/*  1485 */     this.jCheckBox10.setSelected(true);
/*  1486 */     this.jCheckBox10.setText("Remolque1");
/*       */     
/*  1488 */     this.jCheckBox12.setText("Equipo");
/*       */     
/*  1490 */     this.jCheckBox14.setText("Pozo");
/*       */     
/*  1492 */     this.jCheckBox15.setText("H.R.S.P.");
/*       */     
/*  1494 */     this.jCheckBox17.setText("Tons.");
/*       */     
/*  1496 */     this.jCheckBox16.setText("Ticket");
/*       */     
/*  1498 */     this.jCheckBox19.setText("Operador");
/*       */     
/*  1500 */     this.jCheckBox21.setText("Estado (Guía)");
/*       */     
/*  1502 */     this.jCheckBox18.setSelected(true);
/*  1503 */     this.jCheckBox18.setText("Tipo");
/*       */     
/*  1505 */     this.jCheckBox20.setText("Autorizó");
/*       */     
/*  1507 */     this.jCheckBox23.setText("Manifiesto");
/*       */     
/*  1509 */     this.jRadioButton1.setText("Vertical");
/*  1510 */     this.jRadioButton1.setToolTipText("Posición de Hoja Vertical");
/*       */     
/*  1512 */     this.jRadioButton2.setSelected(true);
/*  1513 */     this.jRadioButton2.setText("Horizontal");
/*  1514 */     this.jRadioButton2.setToolTipText("Posición de Hoja Horizontal");
/*       */     
/*  1516 */     this.jCheckBox24.setText("Comentario");
/*       */     
/*  1518 */     this.jCheckBox25.setText("Estatus Interno");
/*       */     
/*  1520 */     this.jCheckBox26.setText("Pedido");
/*       */     
/*  1522 */     this.jCheckBox27.setText("Factura");
/*       */     
/*  1524 */     this.jCheckBox28.setText("Rep Interno");
/*       */     
/*  1526 */     this.jCheckBox29.setText("Prefactura");
/*       */     
/*  1528 */     this.jCheckBox22.setSelected(true);
/*  1529 */     this.jCheckBox22.setText("Remolque2");
/*       */     
/*  1531 */     this.jCheckBox30.setText("Placas");
/*       */     
/*  1533 */     this.jCheckBox31.setText("Plataforma");
/*       */     
/*  1535 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/*  1536 */     this.jPanel13.setLayout(jPanel13Layout);
/*  1537 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/*  1538 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1539 */         .addGroup(jPanel13Layout.createSequentialGroup()
/*  1540 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1541 */             .addGroup(jPanel13Layout.createSequentialGroup()
/*  1542 */               .addGap(55, 55, 55)
/*  1543 */               .addComponent(this.jButton20, -2, 87, -2)
/*  1544 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1545 */               .addComponent(this.jButton21, -2, 84, -2)
/*  1546 */               .addGap(0, 78, 32767))
/*  1547 */             .addGroup(jPanel13Layout.createSequentialGroup()
/*  1548 */               .addContainerGap()
/*  1549 */               .addComponent(this.jSeparator2, -1, 300, 32767)))
/*  1550 */           .addContainerGap())
/*  1551 */         .addGroup(jPanel13Layout.createSequentialGroup()
/*  1552 */           .addContainerGap()
/*  1553 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1554 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
/*  1555 */               .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1556 */                 .addGroup(jPanel13Layout.createSequentialGroup()
/*  1557 */                   .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  1558 */                     .addComponent(this.jCheckBox16, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  1559 */                     .addComponent(this.jCheckBox18, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  1560 */                     .addComponent(this.jCheckBox20, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  1561 */                     .addComponent(this.jCheckBox27, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  1562 */                     .addComponent(this.jCheckBox23, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  1563 */                     .addComponent(this.jCheckBox28, GroupLayout.Alignment.LEADING, -1, 126, 32767)
/*  1564 */                     .addComponent(this.jCheckBox24, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/*  1565 */                   .addGap(0, 2, 32767))
/*  1566 */                 .addGroup(jPanel13Layout.createSequentialGroup()
/*  1567 */                   .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1568 */                     .addGroup(jPanel13Layout.createSequentialGroup()
/*  1569 */                       .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1570 */                         .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  1571 */                           .addComponent(this.jCheckBox4, -1, 126, 32767)
/*  1572 */                           .addComponent(this.jCheckBox2, -1, -1, 32767))
/*  1573 */                         .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  1574 */                           .addComponent(this.jCheckBox6, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  1575 */                           .addComponent(this.jCheckBox7, GroupLayout.Alignment.LEADING, -1, 126, 32767)
/*  1576 */                           .addComponent(this.jCheckBox9, GroupLayout.Alignment.LEADING, -1, 126, 32767)
/*  1577 */                           .addComponent(this.jCheckBox11, GroupLayout.Alignment.LEADING, -1, 126, 32767)
/*  1578 */                           .addComponent(this.jCheckBox30, GroupLayout.Alignment.LEADING, -1, 126, 32767)))
/*  1579 */                       .addGap(0, 0, 32767))
/*  1580 */                     .addComponent(this.jCheckBox31, GroupLayout.Alignment.TRAILING, -1, 126, 32767))
/*  1581 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
/*  1582 */               .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1583 */                 .addGroup(jPanel13Layout.createSequentialGroup()
/*  1584 */                   .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  1585 */                     .addComponent(this.jCheckBox8, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  1586 */                     .addComponent(this.jCheckBox10, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  1587 */                     .addComponent(this.jCheckBox22, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  1588 */                     .addComponent(this.jCheckBox5, GroupLayout.Alignment.LEADING, -1, 126, 32767)
/*  1589 */                     .addComponent(this.jCheckBox3, GroupLayout.Alignment.LEADING, -1, 126, 32767)
/*  1590 */                     .addComponent(this.jCheckBox12, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  1591 */                     .addComponent(this.jCheckBox13, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/*  1592 */                   .addGap(0, 56, 32767))
/*  1593 */                 .addGroup(jPanel13Layout.createSequentialGroup()
/*  1594 */                   .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1595 */                     .addComponent(this.jRadioButton2, -2, 126, -2)
/*  1596 */                     .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  1597 */                       .addComponent(this.jCheckBox29, GroupLayout.Alignment.LEADING, -2, 126, -2)
/*  1598 */                       .addComponent(this.jCheckBox19, -2, 126, -2)
/*  1599 */                       .addComponent(this.jCheckBox17, -2, 126, -2)
/*  1600 */                       .addComponent(this.jCheckBox15, -2, 126, -2)
/*  1601 */                       .addComponent(this.jCheckBox21, -2, 126, -2)
/*  1602 */                       .addComponent(this.jCheckBox25, -2, 126, -2)
/*  1603 */                       .addComponent(this.jCheckBox26, -2, 126, -2)
/*  1604 */                       .addComponent(this.jCheckBox14, -2, 126, -2)))
/*  1605 */                   .addGap(40, 40, 40))))
/*  1606 */             .addGroup(jPanel13Layout.createSequentialGroup()
/*  1607 */               .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  1608 */                 .addComponent(this.jLabel92, -1, 268, 32767)
/*  1609 */                 .addComponent(this.jSeparator6))
/*  1610 */               .addGap(0, 42, 32767))
/*  1611 */             .addGroup(jPanel13Layout.createSequentialGroup()
/*  1612 */               .addComponent(this.jRadioButton1, -2, 130, -2)
/*  1613 */               .addGap(24, 180, 32767)))));
/*       */     
/*  1615 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/*  1616 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1617 */         .addGroup(jPanel13Layout.createSequentialGroup()
/*  1618 */           .addComponent(this.jLabel92)
/*  1619 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1620 */           .addComponent(this.jSeparator6, -2, 10, -2)
/*  1621 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1622 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  1623 */             .addComponent(this.jCheckBox2)
/*  1624 */             .addComponent(this.jCheckBox3))
/*  1625 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1626 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  1627 */             .addComponent(this.jCheckBox4)
/*  1628 */             .addComponent(this.jCheckBox5))
/*  1629 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1630 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  1631 */             .addComponent(this.jCheckBox6)
/*  1632 */             .addComponent(this.jCheckBox13))
/*  1633 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1634 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  1635 */             .addGroup(jPanel13Layout.createSequentialGroup()
/*  1636 */               .addComponent(this.jCheckBox8)
/*  1637 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1638 */               .addComponent(this.jCheckBox10)
/*  1639 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1640 */               .addComponent(this.jCheckBox22)
/*  1641 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1642 */               .addComponent(this.jCheckBox12)
/*  1643 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1644 */               .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  1645 */                 .addComponent(this.jCheckBox14)
/*  1646 */                 .addComponent(this.jCheckBox31))
/*  1647 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  1648 */               .addComponent(this.jCheckBox15)
/*  1649 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1650 */               .addComponent(this.jCheckBox17)
/*  1651 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1652 */               .addComponent(this.jCheckBox19)
/*  1653 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1654 */               .addComponent(this.jCheckBox21)
/*  1655 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1656 */               .addComponent(this.jCheckBox25)
/*  1657 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1658 */               .addComponent(this.jCheckBox26)
/*  1659 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1660 */               .addComponent(this.jCheckBox29))
/*  1661 */             .addGroup(jPanel13Layout.createSequentialGroup()
/*  1662 */               .addComponent(this.jCheckBox7)
/*  1663 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1664 */               .addComponent(this.jCheckBox9)
/*  1665 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1666 */               .addComponent(this.jCheckBox11)
/*  1667 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1668 */               .addComponent(this.jCheckBox30)
/*  1669 */               .addGap(29, 29, 29)
/*  1670 */               .addComponent(this.jCheckBox16)
/*  1671 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1672 */               .addComponent(this.jCheckBox18)
/*  1673 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1674 */               .addComponent(this.jCheckBox20)
/*  1675 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1676 */               .addComponent(this.jCheckBox24)
/*  1677 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1678 */               .addComponent(this.jCheckBox23)
/*  1679 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1680 */               .addComponent(this.jCheckBox28)
/*  1681 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1682 */               .addComponent(this.jCheckBox27)))
/*  1683 */           .addGap(18, 31, 32767)
/*  1684 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  1685 */             .addComponent(this.jRadioButton2)
/*  1686 */             .addComponent(this.jRadioButton1))
/*  1687 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1688 */           .addComponent(this.jSeparator2, -2, 10, -2)
/*  1689 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1690 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  1691 */             .addComponent(this.jButton21)
/*  1692 */             .addComponent(this.jButton20))
/*  1693 */           .addContainerGap()));
/*       */ 
/*       */     
/*  1696 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/*  1697 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/*  1698 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/*  1699 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1700 */         .addComponent(this.jPanel13, -1, -1, 32767));
/*       */     
/*  1702 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/*  1703 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1704 */         .addGroup(jDialog6Layout.createSequentialGroup()
/*  1705 */           .addComponent(this.jPanel13, -1, -1, 32767)
/*  1706 */           .addContainerGap()));
/*       */ 
/*       */     
/*  1709 */     this.jDialog7.setTitle("Enviar Correo");
/*  1710 */     this.jDialog7.setModal(true);
/*       */     
/*  1712 */     this.jPanel30.setBackground(new Color(255, 255, 255));
/*       */     
/*  1714 */     this.jLabel127.setFont(new Font("Tahoma", 1, 14));
/*  1715 */     this.jLabel127.setForeground(new Color(0, 102, 102));
/*  1716 */     this.jLabel127.setHorizontalAlignment(0);
/*  1717 */     this.jLabel127.setText("ENVIAR INFORME POR CORREO");
/*       */     
/*  1719 */     this.jButton46.setMnemonic('E');
/*  1720 */     this.jButton46.setText("Enviar");
/*  1721 */     this.jButton46.setToolTipText("Enviar Correo (Alt+E)");
/*  1722 */     this.jButton46.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1724 */             ModificarGuias.this.jButton46ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1728 */     this.jButton47.setMnemonic('C');
/*  1729 */     this.jButton47.setText("Cerrar");
/*  1730 */     this.jButton47.setToolTipText("Cerrar (Alt+C)");
/*  1731 */     this.jButton47.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1733 */             ModificarGuias.this.jButton47ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1737 */     this.jTextArea6.setColumns(20);
/*  1738 */     this.jTextArea6.setLineWrap(true);
/*  1739 */     this.jTextArea6.setRows(5);
/*  1740 */     this.jScrollPane19.setViewportView(this.jTextArea6);
/*       */     
/*  1742 */     this.jLabel21.setFont(new Font("Tahoma", 1, 11));
/*  1743 */     this.jLabel21.setText("Para:");
/*       */     
/*  1745 */     this.jLabel22.setFont(new Font("Tahoma", 1, 11));
/*  1746 */     this.jLabel22.setText("Asunto:");
/*       */     
/*  1748 */     this.jLabel23.setFont(new Font("Tahoma", 1, 11));
/*  1749 */     this.jLabel23.setText("Adjunto:");
/*       */     
/*  1751 */     this.jLabel25.setFont(new Font("Tahoma", 3, 11));
/*  1752 */     this.jLabel25.setForeground(new Color(102, 102, 102));
/*  1753 */     this.jLabel25.setText("Enviando correo electrónico espere....");
/*       */     
/*  1755 */     this.jTextField28.setEditable(false);
/*  1756 */     this.jTextField28.setForeground(Color.blue);
/*  1757 */     this.jTextField28.setToolTipText("Archivos Adjuntos");
/*       */     
/*  1759 */     this.jLabel24.setHorizontalAlignment(0);
/*  1760 */     this.jLabel24.setText("Aquí puede agregar algún otro comentario a los datos adjuntos");
/*       */     
/*  1762 */     this.jButton3.setText("Lib de Dir");
/*  1763 */     this.jButton3.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1765 */             ModificarGuias.this.jButton3ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  1769 */     GroupLayout jPanel30Layout = new GroupLayout(this.jPanel30);
/*  1770 */     this.jPanel30.setLayout(jPanel30Layout);
/*  1771 */     jPanel30Layout.setHorizontalGroup(jPanel30Layout
/*  1772 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1773 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
/*  1774 */           .addContainerGap()
/*  1775 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  1776 */             .addComponent(this.jScrollPane19, GroupLayout.Alignment.LEADING, -1, 567, 32767)
/*  1777 */             .addGroup(jPanel30Layout.createSequentialGroup()
/*  1778 */               .addComponent(this.jLabel25, -2, 320, -2)
/*  1779 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 68, 32767)
/*  1780 */               .addComponent(this.jButton46, -2, 89, -2)
/*  1781 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1782 */               .addComponent(this.jButton47, -2, 84, -2))
/*  1783 */             .addComponent(this.jSeparator28, GroupLayout.Alignment.LEADING, -1, 567, 32767)
/*  1784 */             .addComponent(this.jLabel127, GroupLayout.Alignment.LEADING, -1, 567, 32767)
/*  1785 */             .addGroup(jPanel30Layout.createSequentialGroup()
/*  1786 */               .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  1787 */                 .addComponent(this.jLabel21, -1, -1, 32767)
/*  1788 */                 .addComponent(this.jLabel22, -1, -1, 32767)
/*  1789 */                 .addComponent(this.jLabel23, -1, -1, 32767))
/*  1790 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1791 */               .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1792 */                 .addComponent(this.jTextField28, -1, 426, 32767)
/*  1793 */                 .addComponent(this.jTextField27, -1, 426, 32767)
/*  1794 */                 .addComponent(this.jTextField26, GroupLayout.Alignment.TRAILING, -1, 426, 32767))
/*  1795 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1796 */               .addComponent(this.jButton3))
/*  1797 */             .addComponent(this.jSeparator7, GroupLayout.Alignment.LEADING, -1, 567, 32767)
/*  1798 */             .addComponent(this.jLabel24, GroupLayout.Alignment.LEADING, -1, 567, 32767))
/*  1799 */           .addContainerGap()));
/*       */     
/*  1801 */     jPanel30Layout.setVerticalGroup(jPanel30Layout
/*  1802 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1803 */         .addGroup(jPanel30Layout.createSequentialGroup()
/*  1804 */           .addComponent(this.jLabel127)
/*  1805 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1806 */           .addComponent(this.jSeparator28, -2, 10, -2)
/*  1807 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1808 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  1809 */             .addComponent(this.jLabel21)
/*  1810 */             .addComponent(this.jTextField26, -2, -1, -2)
/*  1811 */             .addComponent(this.jButton3))
/*  1812 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1813 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  1814 */             .addComponent(this.jLabel22)
/*  1815 */             .addComponent(this.jTextField27, -2, -1, -2))
/*  1816 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1817 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  1818 */             .addComponent(this.jLabel23)
/*  1819 */             .addComponent(this.jTextField28, -2, -1, -2))
/*  1820 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  1821 */           .addComponent(this.jSeparator7, -2, 10, -2)
/*  1822 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1823 */           .addComponent(this.jLabel24)
/*  1824 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1825 */           .addComponent(this.jScrollPane19, -1, 190, 32767)
/*  1826 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1827 */           .addGroup(jPanel30Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  1828 */             .addComponent(this.jButton47)
/*  1829 */             .addComponent(this.jButton46)
/*  1830 */             .addComponent(this.jLabel25))
/*  1831 */           .addContainerGap()));
/*       */ 
/*       */     
/*  1834 */     GroupLayout jDialog7Layout = new GroupLayout(this.jDialog7.getContentPane());
/*  1835 */     this.jDialog7.getContentPane().setLayout(jDialog7Layout);
/*  1836 */     jDialog7Layout.setHorizontalGroup(jDialog7Layout
/*  1837 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1838 */         .addComponent(this.jPanel30, -1, -1, 32767));
/*       */     
/*  1840 */     jDialog7Layout.setVerticalGroup(jDialog7Layout
/*  1841 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1842 */         .addComponent(this.jPanel30, -1, -1, 32767));
/*       */ 
/*       */     
/*  1845 */     this.jDialog2.setTitle("Recepción de Documentos");
/*  1846 */     this.jDialog2.setModal(true);
/*       */     
/*  1848 */     this.jLabel16.setHorizontalAlignment(0);
/*  1849 */     this.jLabel16.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis75.png")));
/*       */     
/*  1851 */     this.jPanel3.setLayout(new GridLayout(3, 0, 0, 6));
/*       */     
/*  1853 */     this.jPanel6.setLayout(new GridLayout(1, 3, 12, 0));
/*       */     
/*  1855 */     this.jLabel77.setFont(new Font("Cantarell", 0, 11));
/*  1856 */     this.jLabel77.setHorizontalAlignment(4);
/*  1857 */     this.jLabel77.setText("Tipo de Recepción");
/*  1858 */     this.jPanel6.add(this.jLabel77);
/*       */     
/*  1860 */     this.jComboBox18.setBackground(new Color(244, 244, 244));
/*  1861 */     this.jComboBox18.setFont(new Font("Tahoma", 1, 11));
/*  1862 */     this.jComboBox18.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "CARGADA Y TIRADA", "SÓLO CARGADA", "SÓLO TIRADA", "MOVIMIENTO EN FALSO", "MOVIMIENTO INTERNO", "MOVIMIENTO LATERAL", "ESTADIA", "CARGADA LATERAL", "MANIOBRA" }));
/*  1863 */     this.jComboBox18.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1865 */             ModificarGuias.this.jComboBox18ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1868 */     this.jPanel6.add(this.jComboBox18);
/*       */     
/*  1870 */     this.jCheckBox1.setText(" FULL");
/*  1871 */     this.jPanel6.add(this.jCheckBox1);
/*       */     
/*  1873 */     this.jPanel3.add(this.jPanel6);
/*       */     
/*  1875 */     this.jPanel67.setLayout(new GridLayout(1, 8, 12, 0));
/*       */     
/*  1877 */     this.jLabel71.setFont(new Font("Cantarell", 0, 11));
/*  1878 */     this.jLabel71.setHorizontalAlignment(4);
/*  1879 */     this.jLabel71.setText("Folio");
/*  1880 */     this.jPanel67.add(this.jLabel71);
/*       */     
/*  1882 */     this.jTextField8.setEditable(false);
/*  1883 */     this.jTextField8.setFont(new Font("Cantarell", 1, 13));
/*  1884 */     this.jTextField8.setForeground(this.lc.PRIMARIO1);
/*  1885 */     this.jTextField8.setHorizontalAlignment(0);
/*  1886 */     this.jPanel67.add(this.jTextField8);
/*       */     
/*  1888 */     this.jLabel67.setFont(new Font("Cantarell", 0, 11));
/*  1889 */     this.jLabel67.setHorizontalAlignment(4);
/*  1890 */     this.jLabel67.setText("Guía");
/*  1891 */     this.jPanel67.add(this.jLabel67);
/*       */     
/*  1893 */     this.jTextField5.setEditable(false);
/*  1894 */     this.jTextField5.setFont(new Font("Cantarell", 1, 13));
/*  1895 */     this.jTextField5.setForeground(this.lc.PRIMARIO1);
/*  1896 */     this.jTextField5.setHorizontalAlignment(0);
/*  1897 */     this.jPanel67.add(this.jTextField5);
/*       */     
/*  1899 */     this.jLabel70.setFont(new Font("Cantarell", 0, 11));
/*  1900 */     this.jLabel70.setHorizontalAlignment(4);
/*  1901 */     this.jLabel70.setText("Fecha");
/*  1902 */     this.jPanel67.add(this.jLabel70);
/*       */     
/*  1904 */     this.jTextField10.setEditable(false);
/*  1905 */     this.jTextField10.setFont(new Font("Cantarell", 1, 13));
/*  1906 */     this.jTextField10.setForeground(this.lc.PRIMARIO1);
/*  1907 */     this.jPanel67.add(this.jTextField10);
/*       */     
/*  1909 */     this.jLabel113.setFont(new Font("Cantarell", 0, 11));
/*  1910 */     this.jLabel113.setHorizontalAlignment(4);
/*  1911 */     this.jLabel113.setText("Folio Impreso");
/*  1912 */     this.jPanel67.add(this.jLabel113);
/*       */     
/*  1914 */     this.jTextField41.setFont(new Font("Cantarell", 1, 13));
/*  1915 */     this.jTextField41.setForeground(this.lc.PRIMARIO1);
/*  1916 */     this.jTextField41.setHorizontalAlignment(0);
/*  1917 */     this.jPanel67.add(this.jTextField41);
/*       */     
/*  1919 */     this.jPanel3.add(this.jPanel67);
/*  1920 */     this.jPanel3.add(this.jSeparator12);
/*       */     
/*  1922 */     GroupLayout jPanel66Layout = new GroupLayout(this.jPanel66);
/*  1923 */     this.jPanel66.setLayout(jPanel66Layout);
/*  1924 */     jPanel66Layout.setHorizontalGroup(jPanel66Layout
/*  1925 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1926 */         .addGroup(jPanel66Layout.createSequentialGroup()
/*  1927 */           .addComponent(this.jLabel16)
/*  1928 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  1929 */           .addComponent(this.jPanel3, -2, 0, 32767)
/*  1930 */           .addContainerGap()));
/*       */     
/*  1932 */     jPanel66Layout.setVerticalGroup(jPanel66Layout
/*  1933 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  1934 */         .addGroup(jPanel66Layout.createSequentialGroup()
/*  1935 */           .addComponent(this.jLabel16, -2, 87, -2)
/*  1936 */           .addGap(0, 0, 32767))
/*  1937 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel66Layout.createSequentialGroup()
/*  1938 */           .addComponent(this.jPanel3, -1, -1, 32767)
/*  1939 */           .addContainerGap()));
/*       */ 
/*       */     
/*  1942 */     this.jPanel26.setMinimumSize(new Dimension(0, 0));
/*  1943 */     this.jPanel26.setPreferredSize(new Dimension(866, 113));
/*  1944 */     this.jPanel26.setLayout(new GridLayout(1, 2, 12, 0));
/*       */     
/*  1946 */     this.jPanel28.setBorder(BorderFactory.createTitledBorder(null, "Datos personales", 0, 0, new Font("Cantarell", 0, 11)));
/*  1947 */     this.jPanel28.setLayout(new GridLayout(3, 2, 0, 6));
/*       */     
/*  1949 */     this.jPanel32.setLayout(new GridLayout(1, 2, 8, 0));
/*       */     
/*  1951 */     this.jLabel68.setFont(new Font("Cantarell", 0, 11));
/*  1952 */     this.jLabel68.setText("Cargada por ");
/*  1953 */     this.jPanel32.add(this.jLabel68);
/*       */     
/*  1955 */     this.jTextField6.setEnabled(false);
/*  1956 */     this.jPanel32.add(this.jTextField6);
/*       */     
/*  1958 */     this.jPanel28.add(this.jPanel32);
/*       */     
/*  1960 */     this.jPanel33.setLayout(new GridLayout(1, 2, 8, 0));
/*       */     
/*  1962 */     this.jLabel86.setFont(new Font("Cantarell", 0, 11));
/*  1963 */     this.jLabel86.setText("Tirada por ");
/*  1964 */     this.jPanel33.add(this.jLabel86);
/*       */     
/*  1966 */     this.jComboBox19.setBackground(new Color(244, 244, 244));
/*  1967 */     this.jComboBox19.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno..." }));
/*  1968 */     this.jComboBox19.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  1970 */             ModificarGuias.this.jComboBox19ActionPerformed(evt);
/*       */           }
/*       */         });
/*  1973 */     this.jPanel33.add(this.jComboBox19);
/*       */     
/*  1975 */     this.jPanel28.add(this.jPanel33);
/*       */     
/*  1977 */     this.jPanel34.setLayout(new GridLayout(1, 2));
/*       */     
/*  1979 */     this.jPanel35.setLayout(new GridLayout(1, 2, 8, 0));
/*       */     
/*  1981 */     this.jLabel75.setFont(new Font("Cantarell", 0, 11));
/*  1982 */     this.jLabel75.setText("Económico ");
/*  1983 */     this.jPanel35.add(this.jLabel75);
/*       */     
/*  1985 */     this.jTextField19.setEnabled(false);
/*  1986 */     this.jPanel35.add(this.jTextField19);
/*       */     
/*  1988 */     this.jPanel34.add(this.jPanel35);
/*       */     
/*  1990 */     this.jPanel36.setLayout(new GridLayout(1, 2, 8, 0));
/*       */     
/*  1992 */     this.jLabel76.setFont(new Font("Cantarell", 0, 11));
/*  1993 */     this.jLabel76.setHorizontalAlignment(4);
/*  1994 */     this.jLabel76.setText("Remolque ");
/*  1995 */     this.jPanel36.add(this.jLabel76);
/*       */     
/*  1997 */     this.jTextField23.setEnabled(false);
/*  1998 */     this.jPanel36.add(this.jTextField23);
/*       */     
/*  2000 */     this.jPanel34.add(this.jPanel36);
/*       */     
/*  2002 */     this.jPanel28.add(this.jPanel34);
/*       */     
/*  2004 */     this.jPanel26.add(this.jPanel28);
/*       */     
/*  2006 */     this.jPanel31.setBorder(BorderFactory.createTitledBorder("Fechas"));
/*  2007 */     this.jPanel31.setLayout(new GridLayout(3, 0, 0, 6));
/*       */     
/*  2009 */     this.jPanel37.setLayout(new GridLayout(1, 4, 6, 0));
/*       */     
/*  2011 */     this.jLabel72.setFont(new Font("Cantarell", 0, 11));
/*  2012 */     this.jLabel72.setHorizontalAlignment(0);
/*  2013 */     this.jLabel72.setText("F. de Llegada");
/*  2014 */     this.jPanel37.add(this.jLabel72);
/*       */     
/*  2016 */     this.jLabel73.setFont(new Font("Cantarell", 0, 11));
/*  2017 */     this.jLabel73.setHorizontalAlignment(0);
/*  2018 */     this.jLabel73.setText("F. de Carga");
/*  2019 */     this.jPanel37.add(this.jLabel73);
/*       */     
/*  2021 */     this.jLabel88.setFont(new Font("Cantarell", 0, 11));
/*  2022 */     this.jLabel88.setHorizontalAlignment(0);
/*  2023 */     this.jLabel88.setText("F. de Salida");
/*  2024 */     this.jPanel37.add(this.jLabel88);
/*       */     
/*  2026 */     this.jLabel2.setFont(new Font("Cantarell", 0, 11));
/*  2027 */     this.jLabel2.setHorizontalAlignment(0);
/*  2028 */     this.jLabel2.setText("Manifiesto");
/*  2029 */     this.jPanel37.add(this.jLabel2);
/*       */     
/*  2031 */     this.jPanel31.add(this.jPanel37);
/*       */     
/*  2033 */     this.jPanel38.setLayout(new GridLayout(1, 4, 6, 0));
/*       */     
/*  2035 */     this.jDateChooser1.setDate(this.fechaActual);
/*  2036 */     this.jDateChooser1.setDateFormatString("dd-MM-yyyy");
/*  2037 */     this.jDateChooser1.setIcon(this.icon);
/*  2038 */     this.jDateChooser1.setMaxSelectableDate(this.fechaActual);
/*  2039 */     this.jDateChooser1.setMinSelectableDate(this.fechaInicio);
/*  2040 */     this.jPanel38.add((Component)this.jDateChooser1);
/*       */     
/*  2042 */     this.jDateChooser6.setDate(this.fechaActual);
/*  2043 */     this.jDateChooser6.setDateFormatString("dd-MM-yyyy");
/*  2044 */     this.jDateChooser6.setIcon(this.icon);
/*  2045 */     this.jDateChooser6.setMaxSelectableDate(this.fechaActual);
/*  2046 */     this.jPanel38.add((Component)this.jDateChooser6);
/*       */     
/*  2048 */     this.jDateChooser3.setDate(this.fechaActual);
/*  2049 */     this.jDateChooser3.setDateFormatString("dd-MM-yyyy");
/*  2050 */     this.jDateChooser3.setIcon(this.icon);
/*  2051 */     this.jDateChooser3.setMaxSelectableDate(this.fechaActual);
/*  2052 */     this.jPanel38.add((Component)this.jDateChooser3);
/*       */     
/*  2054 */     this.jTextField32.setEnabled(false);
/*  2055 */     this.jPanel38.add(this.jTextField32);
/*       */     
/*  2057 */     this.jPanel31.add(this.jPanel38);
/*       */     
/*  2059 */     GroupLayout jPanel39Layout = new GroupLayout(this.jPanel39);
/*  2060 */     this.jPanel39.setLayout(jPanel39Layout);
/*  2061 */     jPanel39Layout.setHorizontalGroup(jPanel39Layout
/*  2062 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2063 */         .addGap(0, 417, 32767));
/*       */     
/*  2065 */     jPanel39Layout.setVerticalGroup(jPanel39Layout
/*  2066 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2067 */         .addGap(0, 26, 32767));
/*       */ 
/*       */     
/*  2070 */     this.jPanel31.add(this.jPanel39);
/*       */     
/*  2072 */     this.jPanel26.add(this.jPanel31);
/*       */     
/*  2074 */     this.jPanel40.setLayout(new GridLayout(1, 2, 12, 0));
/*       */     
/*  2076 */     this.jPanel7.setBorder(BorderFactory.createTitledBorder(null, "Origen y Destino", 0, 0, new Font("Cantarell", 0, 11)));
/*  2077 */     this.jPanel7.setLayout(new GridLayout(5, 2, 0, 6));
/*       */     
/*  2079 */     this.jLabel65.setFont(new Font("Cantarell", 0, 11));
/*  2080 */     this.jLabel65.setText("Origen  (Plat)");
/*  2081 */     this.jPanel7.add(this.jLabel65);
/*       */     
/*  2083 */     this.jTextField7.setText("plat");
/*  2084 */     this.jTextField7.setEnabled(false);
/*  2085 */     this.jPanel7.add(this.jTextField7);
/*       */     
/*  2087 */     this.jLabel69.setFont(new Font("Cantarell", 0, 11));
/*  2088 */     this.jLabel69.setText("Cliente ");
/*  2089 */     this.jPanel7.add(this.jLabel69);
/*       */     
/*  2091 */     this.jTextField9.setText("clie");
/*  2092 */     this.jTextField9.setEnabled(false);
/*  2093 */     this.jPanel7.add(this.jTextField9);
/*       */     
/*  2095 */     this.jLabel74.setFont(new Font("Cantarell", 0, 11));
/*  2096 */     this.jLabel74.setText("Destino ");
/*  2097 */     this.jPanel7.add(this.jLabel74);
/*       */     
/*  2099 */     this.jComboBox17.setBackground(new Color(244, 244, 244));
/*  2100 */     this.jPanel7.add(this.jComboBox17);
/*       */     
/*  2102 */     this.jLabel101.setFont(new Font("Cantarell", 0, 11));
/*  2103 */     this.jLabel101.setText("Pozo");
/*  2104 */     this.jPanel7.add(this.jLabel101);
/*       */     
/*  2106 */     this.jComboBox29.setBackground(new Color(244, 244, 244));
/*  2107 */     this.jPanel7.add(this.jComboBox29);
/*       */     
/*  2109 */     this.jPanel40.add(this.jPanel7);
/*       */     
/*  2111 */     this.jPanel41.setBorder(BorderFactory.createTitledBorder(null, "Otros datos", 0, 0, new Font("Cantarell", 0, 11)));
/*  2112 */     this.jPanel41.setLayout(new GridLayout(5, 0, 0, 6));
/*       */     
/*  2114 */     this.jPanel42.setLayout(new GridLayout(1, 4, 8, 0));
/*       */     
/*  2116 */     this.jLabel80.setFont(new Font("Cantarell", 0, 11));
/*  2117 */     this.jLabel80.setText("No. RSP ");
/*  2118 */     this.jPanel42.add(this.jLabel80);
/*  2119 */     this.jPanel42.add(this.jTextField24);
/*       */     
/*  2121 */     this.jLabel85.setFont(new Font("Cantarell", 0, 11));
/*  2122 */     this.jLabel85.setText("Estadías");
/*  2123 */     this.jPanel42.add(this.jLabel85);
/*  2124 */     this.jPanel42.add(this.jTextField25);
/*       */     
/*  2126 */     this.jPanel41.add(this.jPanel42);
/*       */     
/*  2128 */     this.jPanel43.setLayout(new GridLayout(1, 4, 8, 0));
/*       */     
/*  2130 */     this.jLabel78.setFont(new Font("Cantarell", 0, 11));
/*  2131 */     this.jLabel78.setText("Ticket ");
/*  2132 */     this.jPanel43.add(this.jLabel78);
/*  2133 */     this.jPanel43.add(this.jTextField17);
/*       */     
/*  2135 */     this.jLabel87.setFont(new Font("Cantarell", 0, 11));
/*  2136 */     this.jLabel87.setText("Mov. Inter.");
/*  2137 */     this.jPanel43.add(this.jLabel87);
/*  2138 */     this.jPanel43.add(this.jTextField13);
/*       */     
/*  2140 */     this.jPanel41.add(this.jPanel43);
/*       */     
/*  2142 */     this.jPanel44.setLayout(new GridLayout(1, 4, 8, 0));
/*       */     
/*  2144 */     this.jLabel115.setFont(new Font("Cantarell", 0, 11));
/*  2145 */     this.jLabel115.setText("Km");
/*  2146 */     this.jPanel44.add(this.jLabel115);
/*  2147 */     this.jPanel44.add(this.jTextField42);
/*       */     
/*  2149 */     this.jLabel79.setFont(new Font("Cantarell", 0, 11));
/*  2150 */     this.jLabel79.setText("Peso Neto");
/*  2151 */     this.jPanel44.add(this.jLabel79);
/*  2152 */     this.jPanel44.add(this.jTextField18);
/*       */     
/*  2154 */     this.jPanel41.add(this.jPanel44);
/*       */     
/*  2156 */     this.jPanel71.setLayout(new GridLayout(1, 4, 8, 0));
/*       */     
/*  2158 */     this.jLabel116.setFont(new Font("Cantarell", 0, 11));
/*  2159 */     this.jLabel116.setText("D.O.");
/*  2160 */     this.jPanel71.add(this.jLabel116);
/*  2161 */     this.jPanel71.add(this.jTextField44);
/*       */     
/*  2163 */     this.jLabel102.setFont(new Font("Cantarell", 0, 11));
/*  2164 */     this.jLabel102.setText("LID");
/*  2165 */     this.jPanel71.add(this.jLabel102);
/*  2166 */     this.jPanel71.add(this.jTextField45);
/*       */     
/*  2168 */     this.jPanel41.add(this.jPanel71);
/*       */     
/*  2170 */     this.jPanel40.add(this.jPanel41);
/*       */     
/*  2172 */     this.jPanel68.setLayout(new GridLayout(3, 0, 0, 6));
/*       */     
/*  2174 */     this.jPanel69.setLayout(new GridLayout(1, 2));
/*       */     
/*  2176 */     this.jLabel83.setFont(new Font("Cantarell", 0, 11));
/*  2177 */     this.jLabel83.setHorizontalAlignment(0);
/*  2178 */     this.jLabel83.setText("Este es otro Ejemplo");
/*  2179 */     this.jPanel69.add(this.jLabel83);
/*       */     
/*  2181 */     this.jLabel84.setFont(new Font("Cantarell", 0, 11));
/*  2182 */     this.jLabel84.setHorizontalAlignment(0);
/*  2183 */     this.jLabel84.setText("Operador que Recibe");
/*  2184 */     this.jPanel69.add(this.jLabel84);
/*       */     
/*  2186 */     this.jPanel68.add(this.jPanel69);
/*       */     
/*  2188 */     this.jPanel70.setLayout(new GridLayout(1, 2));
/*       */     
/*  2190 */     this.jLabel9.setHorizontalAlignment(0);
/*  2191 */     this.jLabel9.setText("___________________________");
/*  2192 */     this.jPanel70.add(this.jLabel9);
/*       */     
/*  2194 */     this.jLabel10.setHorizontalAlignment(0);
/*  2195 */     this.jLabel10.setText("___________________________");
/*  2196 */     this.jPanel70.add(this.jLabel10);
/*       */     
/*  2198 */     this.jPanel68.add(this.jPanel70);
/*       */     
/*  2200 */     this.jPanel72.setLayout(new GridLayout(1, 2));
/*       */     
/*  2202 */     this.jLabel81.setFont(new Font("Cantarell", 0, 11));
/*  2203 */     this.jLabel81.setHorizontalAlignment(0);
/*  2204 */     this.jLabel81.setText("Entrega");
/*  2205 */     this.jPanel72.add(this.jLabel81);
/*       */     
/*  2207 */     this.jLabel82.setFont(new Font("Cantarell", 0, 11));
/*  2208 */     this.jLabel82.setHorizontalAlignment(0);
/*  2209 */     this.jLabel82.setText("Recibe");
/*  2210 */     this.jPanel72.add(this.jLabel82);
/*       */     
/*  2212 */     this.jPanel68.add(this.jPanel72);
/*       */     
/*  2214 */     this.jPanel24.setBackground(new Color(146, 193, 134));
/*  2215 */     this.jPanel24.setLayout(new GridLayout(1, 0));
/*       */     
/*  2217 */     this.jPanel25.setLayout(new GridLayout(1, 3));
/*       */     
/*  2219 */     GroupLayout jPanel27Layout = new GroupLayout(this.jPanel27);
/*  2220 */     this.jPanel27.setLayout(jPanel27Layout);
/*  2221 */     jPanel27Layout.setHorizontalGroup(jPanel27Layout
/*  2222 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2223 */         .addGap(0, 288, 32767));
/*       */     
/*  2225 */     jPanel27Layout.setVerticalGroup(jPanel27Layout
/*  2226 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2227 */         .addGap(0, 37, 32767));
/*       */ 
/*       */     
/*  2230 */     this.jPanel25.add(this.jPanel27);
/*       */     
/*  2232 */     this.jPanel45.setLayout(new GridLayout(1, 3, 6, 0));
/*       */     
/*  2234 */     this.materialButton20.setBackground(this.lc.PRIMARIO1);
/*  2235 */     this.materialButton20.setForeground(new Color(255, 255, 255));
/*  2236 */     this.materialButton20.setMnemonic('I');
/*  2237 */     this.materialButton20.setText("Imprimir");
/*  2238 */     this.materialButton20.setToolTipText("Imprimir (Alt+I)");
/*  2239 */     this.materialButton20.setFont(new Font("Cantarell", 0, 12));
/*  2240 */     this.materialButton20.setHorizontalTextPosition(0);
/*  2241 */     this.materialButton20.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2243 */             ModificarGuias.this.materialButton20ActionPerformed(evt);
/*       */           }
/*       */         });
/*  2246 */     this.jPanel45.add((Component)this.materialButton20);
/*       */     
/*  2248 */     this.materialButton19.setBackground(this.lc.SECUNDARIO1);
/*  2249 */     this.materialButton19.setForeground(new Color(255, 255, 255));
/*  2250 */     this.materialButton19.setMnemonic('L');
/*  2251 */     this.materialButton19.setText("Limpiar");
/*  2252 */     this.materialButton19.setToolTipText("Limpiar (Alt+L)");
/*  2253 */     this.materialButton19.setFont(new Font("Cantarell", 0, 12));
/*  2254 */     this.materialButton19.setHorizontalTextPosition(0);
/*  2255 */     this.materialButton19.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2257 */             ModificarGuias.this.materialButton19ActionPerformed(evt);
/*       */           }
/*       */         });
/*  2260 */     this.jPanel45.add((Component)this.materialButton19);
/*       */     
/*  2262 */     this.materialButton18.setBackground(this.lc.SECUNDARIO1);
/*  2263 */     this.materialButton18.setForeground(new Color(255, 255, 255));
/*  2264 */     this.materialButton18.setMnemonic('C');
/*  2265 */     this.materialButton18.setText("Cerrar");
/*  2266 */     this.materialButton18.setToolTipText("Cerrar (Alt+C)");
/*  2267 */     this.materialButton18.setFont(new Font("Cantarell", 0, 12));
/*  2268 */     this.materialButton18.setHorizontalTextPosition(0);
/*  2269 */     this.materialButton18.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2271 */             ModificarGuias.this.materialButton18ActionPerformed(evt);
/*       */           }
/*       */         });
/*  2274 */     this.jPanel45.add((Component)this.materialButton18);
/*       */     
/*  2276 */     this.jPanel25.add(this.jPanel45);
/*       */     
/*  2278 */     this.jPanel46.setLayout(new GridLayout(1, 0));
/*       */     
/*  2280 */     this.jLabel17.setFont(new Font("Cantarell", 0, 11));
/*  2281 */     this.jLabel17.setText("<html><U>Saldar</u></html>");
/*  2282 */     this.jLabel17.setToolTipText("Clic aquí para saldar la guía con una hoja de recepción ya pagada.");
/*  2283 */     this.jLabel17.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  2285 */             ModificarGuias.this.jLabel17MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  2288 */             ModificarGuias.this.jLabel17MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  2291 */             ModificarGuias.this.jLabel17MouseExited(evt);
/*       */           }
/*       */         });
/*  2294 */     this.jPanel46.add(this.jLabel17);
/*       */     
/*  2296 */     this.jPanel25.add(this.jPanel46);
/*       */     
/*  2298 */     this.jPanel24.add(this.jPanel25);
/*       */     
/*  2300 */     GroupLayout jPanel65Layout = new GroupLayout(this.jPanel65);
/*  2301 */     this.jPanel65.setLayout(jPanel65Layout);
/*  2302 */     jPanel65Layout.setHorizontalGroup(jPanel65Layout
/*  2303 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2304 */         .addComponent(this.jPanel66, -1, -1, 32767)
/*  2305 */         .addComponent(this.jPanel24, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/*  2306 */         .addComponent(this.jPanel68, -2, 866, -2)
/*  2307 */         .addComponent(this.jPanel26, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/*  2308 */         .addComponent(this.jPanel40, GroupLayout.Alignment.TRAILING, -2, 0, 32767));
/*       */     
/*  2310 */     jPanel65Layout.setVerticalGroup(jPanel65Layout
/*  2311 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2312 */         .addGroup(jPanel65Layout.createSequentialGroup()
/*  2313 */           .addComponent(this.jPanel66, -2, -1, -2)
/*  2314 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2315 */           .addComponent(this.jPanel26, -2, -1, -2)
/*  2316 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2317 */           .addComponent(this.jPanel40, -2, 183, -2)
/*  2318 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2319 */           .addComponent(this.jPanel68, -2, 70, -2)
/*  2320 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2321 */           .addComponent(this.jPanel24, -2, 37, -2)
/*  2322 */           .addContainerGap(49, 32767)));
/*       */ 
/*       */     
/*  2325 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*  2326 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*  2327 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*  2328 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2329 */         .addGroup(jDialog2Layout.createSequentialGroup()
/*  2330 */           .addComponent(this.jPanel65, -1, -1, 32767)
/*  2331 */           .addGap(0, 0, 0)));
/*       */     
/*  2333 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/*  2334 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2335 */         .addGroup(jDialog2Layout.createSequentialGroup()
/*  2336 */           .addComponent(this.jPanel65, -1, -1, 32767)
/*  2337 */           .addGap(0, 0, 0)));
/*       */ 
/*       */     
/*  2340 */     this.jDialog8.setAlwaysOnTop(true);
/*       */     
/*  2342 */     this.jList1.setModel(new AbstractListModel() {
/*  2343 */           String[] strings = new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
/*  2344 */           public int getSize() { return this.strings.length; }
/*  2345 */           public Object getElementAt(int i) { return this.strings[i]; }
/*       */         });
/*  2347 */     this.jList1.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  2349 */             ModificarGuias.this.jList1MouseClicked(evt);
/*       */           }
/*       */         });
/*  2352 */     this.jScrollPane2.setViewportView(this.jList1);
/*       */     
/*  2354 */     GroupLayout jDialog8Layout = new GroupLayout(this.jDialog8.getContentPane());
/*  2355 */     this.jDialog8.getContentPane().setLayout(jDialog8Layout);
/*  2356 */     jDialog8Layout.setHorizontalGroup(jDialog8Layout
/*  2357 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2358 */         .addComponent(this.jScrollPane2, -1, 175, 32767));
/*       */     
/*  2360 */     jDialog8Layout.setVerticalGroup(jDialog8Layout
/*  2361 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2362 */         .addComponent(this.jScrollPane2));
/*       */ 
/*       */     
/*  2365 */     this.jMenuItem1.setText("Eliminar Correo");
/*  2366 */     this.jMenuItem1.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2368 */             ModificarGuias.this.jMenuItem1ActionPerformed(evt);
/*       */           }
/*       */         });
/*  2371 */     this.jPopupMenu1.add(this.jMenuItem1);
/*       */     
/*  2373 */     this.jDialog9.setTitle("Seleccionar Columnas");
/*  2374 */     this.jDialog9.setModal(true);
/*       */     
/*  2376 */     this.jScrollPane5.setViewportView(this.jTextPane2);
/*       */     
/*  2378 */     GroupLayout jDialog9Layout = new GroupLayout(this.jDialog9.getContentPane());
/*  2379 */     this.jDialog9.getContentPane().setLayout(jDialog9Layout);
/*  2380 */     jDialog9Layout.setHorizontalGroup(jDialog9Layout
/*  2381 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2382 */         .addComponent(this.jScrollPane5, -1, 299, 32767));
/*       */     
/*  2384 */     jDialog9Layout.setVerticalGroup(jDialog9Layout
/*  2385 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2386 */         .addGroup(jDialog9Layout.createSequentialGroup()
/*  2387 */           .addGap(54, 54, 54)
/*  2388 */           .addComponent(this.jScrollPane5, -1, 370, 32767)
/*  2389 */           .addContainerGap()));
/*       */ 
/*       */     
/*  2392 */     this.jDialog10.setTitle("Colores Identificadores");
/*  2393 */     this.jDialog10.setModal(true);
/*       */     
/*  2395 */     this.jPanel14.setBackground(new Color(146, 193, 134));
/*       */     
/*  2397 */     this.jLabel26.setFont(new Font("Times New Roman", 1, 18));
/*  2398 */     this.jLabel26.setHorizontalAlignment(0);
/*  2399 */     this.jLabel26.setText("Estatus de Colores");
/*       */     
/*  2401 */     this.jLabel27.setText("En patio (Se expidió Sólo Cargada)");
/*       */     
/*  2403 */     this.jLabel28.setText("Expedido (Totalmente Vivo)");
/*       */     
/*  2405 */     this.jLabel29.setText("Pagado al Operador");
/*       */     
/*  2407 */     this.jLabel30.setText("En Prefactura Interna");
/*       */     
/*  2409 */     this.jLabel31.setText("Facturado");
/*       */     
/*  2411 */     this.jButton23.setText("Cerrar");
/*  2412 */     this.jButton23.setToolTipText("Cerrar (Alt+C)");
/*  2413 */     this.jButton23.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2415 */             ModificarGuias.this.jButton23ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2419 */     this.jTextField20.setBackground(new Color(102, 153, 255));
/*  2420 */     this.jTextField20.setFont(new Font("Tahoma", 1, 12));
/*  2421 */     this.jTextField20.setForeground(Color.blue);
/*  2422 */     this.jTextField20.setHorizontalAlignment(0);
/*  2423 */     this.jTextField20.setText("F");
/*  2424 */     this.jTextField20.setFocusable(false);
/*       */     
/*  2426 */     this.jTextField21.setBackground(Color.lightGray);
/*  2427 */     this.jTextField21.setFont(new Font("Tahoma", 1, 12));
/*  2428 */     this.jTextField21.setForeground(Color.red);
/*  2429 */     this.jTextField21.setHorizontalAlignment(0);
/*  2430 */     this.jTextField21.setText("F");
/*  2431 */     this.jTextField21.setFocusable(false);
/*       */     
/*  2433 */     this.jTextField22.setBackground(new Color(153, 153, 153));
/*  2434 */     this.jTextField22.setFont(new Font("Tahoma", 1, 12));
/*  2435 */     this.jTextField22.setHorizontalAlignment(0);
/*  2436 */     this.jTextField22.setText("F");
/*  2437 */     this.jTextField22.setFocusable(false);
/*       */     
/*  2439 */     this.jTextField29.setBackground(new Color(153, 102, 0));
/*  2440 */     this.jTextField29.setFont(new Font("Tahoma", 1, 12));
/*  2441 */     this.jTextField29.setForeground(Color.white);
/*  2442 */     this.jTextField29.setHorizontalAlignment(0);
/*  2443 */     this.jTextField29.setText("F");
/*  2444 */     this.jTextField29.setFocusable(false);
/*       */     
/*  2446 */     this.jTextField30.setFont(new Font("Tahoma", 1, 12));
/*  2447 */     this.jTextField30.setHorizontalAlignment(0);
/*  2448 */     this.jTextField30.setText("F");
/*  2449 */     this.jTextField30.setFocusable(false);
/*       */     
/*  2451 */     this.jTextField31.setBackground(Color.red);
/*  2452 */     this.jTextField31.setFont(new Font("Tahoma", 1, 12));
/*  2453 */     this.jTextField31.setForeground(Color.white);
/*  2454 */     this.jTextField31.setHorizontalAlignment(0);
/*  2455 */     this.jTextField31.setText("F");
/*  2456 */     this.jTextField31.setFocusable(false);
/*       */     
/*  2458 */     this.jLabel34.setText("Cancelado");
/*       */     
/*  2460 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/*  2461 */     this.jPanel14.setLayout(jPanel14Layout);
/*  2462 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/*  2463 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2464 */         .addGroup(jPanel14Layout.createSequentialGroup()
/*  2465 */           .addContainerGap()
/*  2466 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2467 */             .addGroup(jPanel14Layout.createSequentialGroup()
/*  2468 */               .addComponent(this.jTextField20, -2, 32, -2)
/*  2469 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2470 */               .addComponent(this.jLabel28, -2, 212, -2))
/*  2471 */             .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  2472 */               .addComponent(this.jLabel26, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  2473 */               .addComponent(this.jSeparator8, GroupLayout.Alignment.LEADING, -1, 236, 32767))
/*  2474 */             .addGroup(jPanel14Layout.createSequentialGroup()
/*  2475 */               .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  2476 */                 .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2477 */                   .addGroup(jPanel14Layout.createSequentialGroup()
/*  2478 */                     .addGap(1, 1, 1)
/*  2479 */                     .addComponent(this.jTextField22, -2, 32, -2))
/*  2480 */                   .addComponent(this.jTextField29, -2, 32, -2))
/*  2481 */                 .addComponent(this.jTextField30, -2, 32, -2))
/*  2482 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2483 */               .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2484 */                 .addComponent(this.jLabel31, -2, 121, -2)
/*  2485 */                 .addComponent(this.jLabel29, -2, 118, -2)
/*  2486 */                 .addComponent(this.jLabel30, -2, 153, -2)))
/*  2487 */             .addGroup(jPanel14Layout.createSequentialGroup()
/*  2488 */               .addComponent(this.jTextField31, -2, 32, -2)
/*  2489 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2490 */               .addComponent(this.jLabel34, -2, 121, -2))
/*  2491 */             .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  2492 */               .addGroup(GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
/*  2493 */                 .addComponent(this.jTextField21, -2, 32, -2)
/*  2494 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2495 */                 .addComponent(this.jLabel27, -1, -1, 32767))
/*  2496 */               .addGroup(GroupLayout.Alignment.LEADING, jPanel14Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  2497 */                 .addComponent(this.jButton23, -2, 93, -2)
/*  2498 */                 .addComponent(this.jSeparator9, -2, 232, -2))))
/*  2499 */           .addContainerGap(-1, 32767)));
/*       */     
/*  2501 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/*  2502 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2503 */         .addGroup(jPanel14Layout.createSequentialGroup()
/*  2504 */           .addGap(17, 17, 17)
/*  2505 */           .addComponent(this.jLabel26, -2, 17, -2)
/*  2506 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2507 */           .addComponent(this.jSeparator8, -2, 10, -2)
/*  2508 */           .addGap(14, 14, 14)
/*  2509 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2510 */             .addComponent(this.jLabel28)
/*  2511 */             .addComponent(this.jTextField20, -2, -1, -2))
/*  2512 */           .addGap(7, 7, 7)
/*  2513 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2514 */             .addComponent(this.jTextField21, -2, -1, -2)
/*  2515 */             .addComponent(this.jLabel27))
/*  2516 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2517 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2518 */             .addComponent(this.jTextField22, -2, -1, -2)
/*  2519 */             .addComponent(this.jLabel29))
/*  2520 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2521 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2522 */             .addComponent(this.jTextField29, -2, -1, -2)
/*  2523 */             .addComponent(this.jLabel30))
/*  2524 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2525 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2526 */             .addComponent(this.jTextField30, -2, -1, -2)
/*  2527 */             .addComponent(this.jLabel31))
/*  2528 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2529 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2530 */             .addComponent(this.jTextField31, -2, -1, -2)
/*  2531 */             .addComponent(this.jLabel34))
/*  2532 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2533 */           .addComponent(this.jSeparator9, -2, 10, -2)
/*  2534 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2535 */           .addComponent(this.jButton23)
/*  2536 */           .addContainerGap(-1, 32767)));
/*       */ 
/*       */     
/*  2539 */     GroupLayout jDialog10Layout = new GroupLayout(this.jDialog10.getContentPane());
/*  2540 */     this.jDialog10.getContentPane().setLayout(jDialog10Layout);
/*  2541 */     jDialog10Layout.setHorizontalGroup(jDialog10Layout
/*  2542 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2543 */         .addComponent(this.jPanel14, -2, 253, -2));
/*       */     
/*  2545 */     jDialog10Layout.setVerticalGroup(jDialog10Layout
/*  2546 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2547 */         .addComponent(this.jPanel14, -2, -1, -2));
/*       */ 
/*       */     
/*  2550 */     this.jLabel96.setFont(new Font("Tahoma", 3, 11));
/*  2551 */     this.jLabel96.setForeground(new Color(15, 87, 51));
/*  2552 */     this.jLabel96.setHorizontalAlignment(4);
/*  2553 */     this.jLabel96.setText("Selecciona la hoja de Recepción ");
/*       */     
/*  2555 */     this.jComboBox27.setBackground(new Color(244, 244, 244));
/*  2556 */     this.jComboBox27.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2558 */             ModificarGuias.this.jComboBox27ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2562 */     this.jLabel97.setFont(new Font("Tahoma", 0, 10));
/*  2563 */     this.jLabel97.setText("jLabel97");
/*       */     
/*  2565 */     GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
/*  2566 */     this.jPanel21.setLayout(jPanel21Layout);
/*  2567 */     jPanel21Layout.setHorizontalGroup(jPanel21Layout
/*  2568 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2569 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
/*  2570 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  2571 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel21Layout.createSequentialGroup()
/*  2572 */               .addContainerGap()
/*  2573 */               .addComponent(this.jSeparator4, -1, 410, 32767))
/*  2574 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel21Layout.createSequentialGroup()
/*  2575 */               .addComponent(this.jLabel96, -2, 196, -2)
/*  2576 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 56, 32767)
/*  2577 */               .addComponent(this.jComboBox27, -2, 168, -2))
/*  2578 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel21Layout.createSequentialGroup()
/*  2579 */               .addGap(10, 10, 10)
/*  2580 */               .addComponent(this.jLabel97, -1, 410, 32767)))
/*  2581 */           .addContainerGap()));
/*       */     
/*  2583 */     jPanel21Layout.setVerticalGroup(jPanel21Layout
/*  2584 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2585 */         .addGroup(jPanel21Layout.createSequentialGroup()
/*  2586 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2587 */             .addComponent(this.jLabel96)
/*  2588 */             .addComponent(this.jComboBox27, -2, -1, -2))
/*  2589 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2590 */           .addComponent(this.jLabel97)
/*  2591 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2592 */           .addComponent(this.jSeparator4, -1, 14, 32767)));
/*       */ 
/*       */     
/*  2595 */     this.jTextField16.setText("jTextField16");
/*       */     
/*  2597 */     this.jLabel57.setFont(new Font("Tahoma", 3, 11));
/*  2598 */     this.jLabel57.setForeground(new Color(15, 87, 51));
/*  2599 */     this.jLabel57.setHorizontalAlignment(4);
/*  2600 */     this.jLabel57.setText("Selecciona el origen");
/*       */     
/*  2602 */     this.jComboBox33.setBackground(new Color(244, 244, 244));
/*       */     
/*  2604 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/*  2605 */     this.jPanel18.setLayout(jPanel18Layout);
/*  2606 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/*  2607 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2608 */         .addGroup(jPanel18Layout.createSequentialGroup()
/*  2609 */           .addComponent(this.jLabel57, -2, 121, -2)
/*  2610 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2611 */           .addComponent(this.jComboBox33, 0, 249, 32767)
/*  2612 */           .addContainerGap()));
/*       */     
/*  2614 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/*  2615 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2616 */         .addGroup(jPanel18Layout.createSequentialGroup()
/*  2617 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2618 */             .addComponent(this.jLabel57)
/*  2619 */             .addComponent(this.jComboBox33, -2, -1, -2))
/*  2620 */           .addContainerGap(-1, 32767)));
/*       */ 
/*       */     
/*  2623 */     this.jPanel19.setBackground(new Color(146, 193, 134));
/*       */     
/*  2625 */     this.jLabel107.setFont(new Font("Tahoma", 1, 18));
/*  2626 */     this.jLabel107.setForeground(new Color(0, 102, 102));
/*  2627 */     this.jLabel107.setHorizontalAlignment(0);
/*  2628 */     this.jLabel107.setText("RECEPCIÓN DE DOCUMENTOS");
/*       */     
/*  2630 */     this.jPanel20.setBackground(new Color(146, 193, 134));
/*       */     
/*  2632 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/*  2633 */     this.jPanel20.setLayout(jPanel20Layout);
/*  2634 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/*  2635 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2636 */         .addGap(0, 1016, 32767));
/*       */     
/*  2638 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/*  2639 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2640 */         .addGap(0, 41, 32767));
/*       */ 
/*       */     
/*  2643 */     this.jPanel10.setBackground(new Color(146, 193, 134));
/*  2644 */     this.jPanel10.setBorder(BorderFactory.createTitledBorder("Otros Datos"));
/*       */     
/*  2646 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/*  2647 */     this.jPanel10.setLayout(jPanel10Layout);
/*  2648 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/*  2649 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2650 */         .addGap(0, 563, 32767));
/*       */     
/*  2652 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/*  2653 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2654 */         .addGap(0, 97, 32767));
/*       */ 
/*       */     
/*  2657 */     this.jPanel23.setBackground(new Color(146, 193, 134));
/*  2658 */     this.jPanel23.setBorder(BorderFactory.createTitledBorder("Tonelaje"));
/*       */     
/*  2660 */     GroupLayout jPanel23Layout = new GroupLayout(this.jPanel23);
/*  2661 */     this.jPanel23.setLayout(jPanel23Layout);
/*  2662 */     jPanel23Layout.setHorizontalGroup(jPanel23Layout
/*  2663 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2664 */         .addGap(0, 421, 32767));
/*       */     
/*  2666 */     jPanel23Layout.setVerticalGroup(jPanel23Layout
/*  2667 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2668 */         .addGap(0, 41, 32767));
/*       */ 
/*       */     
/*  2671 */     GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
/*  2672 */     this.jPanel19.setLayout(jPanel19Layout);
/*  2673 */     jPanel19Layout.setHorizontalGroup(jPanel19Layout
/*  2674 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2675 */         .addComponent(this.jLabel107, -1, -1, 32767)
/*  2676 */         .addGroup(jPanel19Layout.createSequentialGroup()
/*  2677 */           .addContainerGap()
/*  2678 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2679 */             .addGroup(jPanel19Layout.createSequentialGroup()
/*  2680 */               .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2681 */                 .addComponent(this.jSeparator10)
/*  2682 */                 .addComponent(this.jPanel20, -1, -1, 32767))
/*  2683 */               .addContainerGap())
/*  2684 */             .addGroup(jPanel19Layout.createSequentialGroup()
/*  2685 */               .addComponent(this.jPanel23, -2, -1, -2)
/*  2686 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2687 */               .addComponent(this.jPanel10, -1, -1, 32767)
/*  2688 */               .addGap(18, 18, 18)))));
/*       */     
/*  2690 */     jPanel19Layout.setVerticalGroup(jPanel19Layout
/*  2691 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2692 */         .addGroup(jPanel19Layout.createSequentialGroup()
/*  2693 */           .addComponent(this.jLabel107)
/*  2694 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2695 */           .addComponent(this.jSeparator10, -2, 10, -2)
/*  2696 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2697 */           .addComponent(this.jPanel20, -2, -1, -2)
/*  2698 */           .addGap(80, 80, 80)
/*  2699 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2700 */             .addComponent(this.jPanel23, -2, -1, -2)
/*  2701 */             .addComponent(this.jPanel10, -2, -1, -2))
/*  2702 */           .addContainerGap(392, 32767)));
/*       */ 
/*       */     
/*  2705 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/*  2706 */     this.jPanel2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
/*       */     
/*  2708 */     this.jDateChooser4.setDate(this.fechaActual);
/*  2709 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/*  2710 */     this.jDateChooser4.setIcon(this.icon);
/*  2711 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/*  2712 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/*       */     
/*  2714 */     this.jDateChooser5.setDate(this.fechaActual);
/*  2715 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/*  2716 */     this.jDateChooser5.setIcon(this.icon);
/*  2717 */     this.jDateChooser5.setMaxSelectableDate(this.fechaActual);
/*  2718 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/*       */     
/*  2720 */     this.jLabel5.setFont(new Font("Tahoma", 2, 12));
/*  2721 */     this.jLabel5.setForeground(new Color(15, 87, 51));
/*  2722 */     this.jLabel5.setText("<html><u>Todos </u></html>");
/*  2723 */     this.jLabel5.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  2725 */             ModificarGuias.this.jLabel5MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  2728 */             ModificarGuias.this.jLabel5MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  2731 */             ModificarGuias.this.jLabel5MouseExited(evt);
/*       */           }
/*       */         });
/*       */     
/*  2735 */     this.jLabel6.setFont(new Font("Tahoma", 2, 12));
/*  2736 */     this.jLabel6.setForeground(new Color(15, 87, 51));
/*  2737 */     this.jLabel6.setHorizontalAlignment(0);
/*  2738 */     this.jLabel6.setText("<html><u>Hoy</u></html>");
/*  2739 */     this.jLabel6.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  2741 */             ModificarGuias.this.jLabel6MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  2744 */             ModificarGuias.this.jLabel6MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  2747 */             ModificarGuias.this.jLabel6MouseExited(evt);
/*       */           }
/*       */         });
/*       */     
/*  2751 */     this.jLabel7.setFont(new Font("Tahoma", 2, 12));
/*  2752 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/*  2753 */     this.jLabel7.setText("<html><u>Ayer</u></html>");
/*  2754 */     this.jLabel7.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  2756 */             ModificarGuias.this.jLabel7MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  2759 */             ModificarGuias.this.jLabel7MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  2762 */             ModificarGuias.this.jLabel7MouseExited(evt);
/*       */           }
/*       */         });
/*       */     
/*  2766 */     this.jLabel1.setFont(new Font("Tahoma", 1, 15));
/*  2767 */     this.jLabel1.setForeground(Color.red);
/*  2768 */     this.jLabel1.setHorizontalAlignment(4);
/*  2769 */     this.jLabel1.setText("REPORTE DEL");
/*       */     
/*  2771 */     this.jLabel4.setFont(new Font("Tahoma", 1, 15));
/*  2772 */     this.jLabel4.setForeground(Color.red);
/*  2773 */     this.jLabel4.setHorizontalAlignment(0);
/*  2774 */     this.jLabel4.setText("AL");
/*       */     
/*  2776 */     this.jComboBox21.setBackground(new Color(244, 244, 244));
/*  2777 */     this.jComboBox21.setModel(new DefaultComboBoxModel<>(new String[] { "Turno Natural (24 hrs)", "Turno Diurno (9am - 9pm)", "Turno Nocturno (9pm - 9am)" }));
/*  2778 */     this.jComboBox21.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2780 */             ModificarGuias.this.jComboBox21ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2784 */     this.jLabel20.setHorizontalAlignment(0);
/*       */     
/*  2786 */     this.jButton1.setMnemonic('F');
/*  2787 */     this.jButton1.setText("Filtrar");
/*  2788 */     this.jButton1.setToolTipText("Filtrar información (Alt+F)");
/*  2789 */     this.jButton1.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2791 */             ModificarGuias.this.jButton1ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2795 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  2796 */     this.jPanel2.setLayout(jPanel2Layout);
/*  2797 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  2798 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2799 */         .addGroup(jPanel2Layout.createSequentialGroup()
/*  2800 */           .addContainerGap()
/*  2801 */           .addComponent(this.jLabel1, -2, 130, -2)
/*  2802 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2803 */           .addComponent((Component)this.jDateChooser4, -2, 108, -2)
/*  2804 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2805 */           .addComponent(this.jLabel4)
/*  2806 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  2807 */           .addComponent((Component)this.jDateChooser5, -2, 108, -2)
/*  2808 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2809 */           .addComponent(this.jButton1)
/*  2810 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2811 */           .addComponent(this.jLabel5, -2, -1, -2)
/*  2812 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2813 */           .addComponent(this.jLabel6, -2, 31, -2)
/*  2814 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2815 */           .addComponent(this.jLabel7, -2, 31, -2)
/*  2816 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  2817 */           .addComponent(this.jComboBox21, 0, 186, 32767)
/*  2818 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  2819 */           .addComponent(this.jLabel20, -2, 52, -2)
/*  2820 */           .addContainerGap()));
/*       */     
/*  2822 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  2823 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2824 */         .addGroup(jPanel2Layout.createSequentialGroup()
/*  2825 */           .addContainerGap()
/*  2826 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2827 */             .addComponent(this.jLabel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/*  2828 */             .addComponent((Component)this.jDateChooser4, GroupLayout.Alignment.TRAILING, -2, -1, -2)
/*  2829 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2830 */               .addComponent(this.jLabel5, -2, 19, -2)
/*  2831 */               .addComponent(this.jLabel6, -2, 15, -2)
/*  2832 */               .addComponent(this.jLabel7, -2, -1, -2)
/*  2833 */               .addComponent(this.jComboBox21, -2, -1, -2)
/*  2834 */               .addComponent(this.jButton1))
/*  2835 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/*  2836 */               .addComponent(this.jLabel4, -2, 19, -2)
/*  2837 */               .addGap(1, 1, 1))
/*  2838 */             .addComponent((Component)this.jDateChooser5, GroupLayout.Alignment.TRAILING, -2, -1, -2)))
/*  2839 */         .addComponent(this.jLabel20, -1, -1, 32767));
/*       */ 
/*       */     
/*  2842 */     this.jButton22.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/colores.png")));
/*  2843 */     this.jButton22.setMnemonic('V');
/*  2844 */     this.jButton22.setText("Ver Colores");
/*  2845 */     this.jButton22.setToolTipText("Ver Significados de los Colores (Alt+V)");
/*  2846 */     this.jButton22.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2848 */             ModificarGuias.this.jButton22ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2852 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/*  2853 */     this.jLabel48.setForeground(Color.red);
/*  2854 */     this.jLabel48.setText("t");
/*  2855 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*       */     
/*  2857 */     this.jComboBox16.setBackground(new Color(244, 244, 244));
/*  2858 */     this.jComboBox16.setModel(new DefaultComboBoxModel<>(new String[] { "CD ORIGEN", "Altamira", "Latinaja", "Poza Rica", "Veracruz", "Villahermosa" }));
/*  2859 */     this.jComboBox16.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2861 */             ModificarGuias.this.jComboBox16ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2865 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/*  2866 */     this.jComboBox7.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/*  2867 */     this.jComboBox7.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2869 */             ModificarGuias.this.jComboBox7ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2873 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/*  2874 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/*  2875 */     this.jComboBox6.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2877 */             ModificarGuias.this.jComboBox6ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2881 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/*  2882 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/*  2883 */     this.jComboBox5.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2885 */             ModificarGuias.this.jComboBox5ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2889 */     this.jLabel3.setFont(new Font("Tahoma", 1, 11));
/*  2890 */     this.jLabel3.setForeground(Color.red);
/*  2891 */     this.jLabel3.setText("jLabel1");
/*  2892 */     this.jLabel3.setBorder(BorderFactory.createBevelBorder(1));
/*       */     
/*  2894 */     GroupLayout jPanel49Layout = new GroupLayout(this.jPanel49);
/*  2895 */     this.jPanel49.setLayout(jPanel49Layout);
/*  2896 */     jPanel49Layout.setHorizontalGroup(jPanel49Layout
/*  2897 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2898 */         .addGroup(jPanel49Layout.createSequentialGroup()
/*  2899 */           .addContainerGap()
/*  2900 */           .addGroup(jPanel49Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2901 */             .addGroup(jPanel49Layout.createSequentialGroup()
/*  2902 */               .addGap(482, 482, 482)
/*  2903 */               .addComponent(this.jComboBox7, -2, 163, -2))
/*  2904 */             .addGroup(jPanel49Layout.createSequentialGroup()
/*  2905 */               .addComponent(this.jComboBox16, -2, -1, -2)
/*  2906 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2907 */               .addComponent(this.jComboBox5, -2, 132, -2)
/*  2908 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2909 */               .addComponent(this.jComboBox6, -2, 168, -2))
/*  2910 */             .addComponent(this.jLabel3, -2, 229, -2))
/*  2911 */           .addContainerGap(18, 32767)));
/*       */     
/*  2913 */     jPanel49Layout.setVerticalGroup(jPanel49Layout
/*  2914 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2915 */         .addGroup(jPanel49Layout.createSequentialGroup()
/*  2916 */           .addContainerGap()
/*  2917 */           .addGroup(jPanel49Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2918 */             .addComponent(this.jComboBox16, -2, -1, -2)
/*  2919 */             .addComponent(this.jComboBox5, -2, -1, -2)
/*  2920 */             .addComponent(this.jComboBox6, -2, -1, -2))
/*  2921 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2922 */           .addComponent(this.jComboBox7, -2, -1, -2)
/*  2923 */           .addGap(26, 26, 26)
/*  2924 */           .addComponent(this.jLabel3)
/*  2925 */           .addContainerGap(265, 32767)));
/*       */ 
/*       */     
/*  2928 */     this.jDialog30.setTitle("Ruta del Timbrado");
/*       */     
/*  2930 */     this.materialButton40.setBackground(this.lc.PRIMARIO1);
/*  2931 */     this.materialButton40.setForeground(new Color(255, 255, 255));
/*  2932 */     this.materialButton40.setMnemonic('T');
/*  2933 */     this.materialButton40.setText("Predeterminada");
/*  2934 */     this.materialButton40.setToolTipText("Timbrar CFDI (Alt+T)");
/*  2935 */     this.materialButton40.setFont(new Font("Cantarell", 0, 12));
/*  2936 */     this.materialButton40.setHorizontalTextPosition(0);
/*  2937 */     this.materialButton40.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2939 */             ModificarGuias.this.materialButton40ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2943 */     this.materialButton41.setBackground(this.lc.PRIMARIO1);
/*  2944 */     this.materialButton41.setForeground(new Color(255, 255, 255));
/*  2945 */     this.materialButton41.setMnemonic('T');
/*  2946 */     this.materialButton41.setText("Nueva");
/*  2947 */     this.materialButton41.setToolTipText("Timbrar CFDI (Alt+T)");
/*  2948 */     this.materialButton41.setFont(new Font("Cantarell", 0, 12));
/*  2949 */     this.materialButton41.setHorizontalTextPosition(0);
/*  2950 */     this.materialButton41.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  2952 */             ModificarGuias.this.materialButton41ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  2956 */     this.jTextField36.setEditable(false);
/*       */     
/*  2958 */     GroupLayout jPanel172Layout = new GroupLayout(this.jPanel172);
/*  2959 */     this.jPanel172.setLayout(jPanel172Layout);
/*  2960 */     jPanel172Layout.setHorizontalGroup(jPanel172Layout
/*  2961 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2962 */         .addGroup(jPanel172Layout.createSequentialGroup()
/*  2963 */           .addContainerGap()
/*  2964 */           .addGroup(jPanel172Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2965 */             .addGroup(jPanel172Layout.createSequentialGroup()
/*  2966 */               .addComponent((Component)this.materialButton40, -2, 150, -2)
/*  2967 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2968 */               .addComponent(this.jTextField36, -1, 256, 32767))
/*  2969 */             .addGroup(jPanel172Layout.createSequentialGroup()
/*  2970 */               .addComponent((Component)this.materialButton41, -2, 150, -2)
/*  2971 */               .addGap(0, 0, 32767)))
/*  2972 */           .addContainerGap()));
/*       */     
/*  2974 */     jPanel172Layout.setVerticalGroup(jPanel172Layout
/*  2975 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2976 */         .addGroup(jPanel172Layout.createSequentialGroup()
/*  2977 */           .addContainerGap()
/*  2978 */           .addGroup(jPanel172Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  2979 */             .addComponent((Component)this.materialButton40, -2, 38, -2)
/*  2980 */             .addComponent(this.jTextField36, -2, -1, -2))
/*  2981 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  2982 */           .addComponent((Component)this.materialButton41, -2, 38, -2)
/*  2983 */           .addContainerGap(-1, 32767)));
/*       */ 
/*       */     
/*  2986 */     GroupLayout jDialog30Layout = new GroupLayout(this.jDialog30.getContentPane());
/*  2987 */     this.jDialog30.getContentPane().setLayout(jDialog30Layout);
/*  2988 */     jDialog30Layout.setHorizontalGroup(jDialog30Layout
/*  2989 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2990 */         .addComponent(this.jPanel172, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*       */     
/*  2992 */     jDialog30Layout.setVerticalGroup(jDialog30Layout
/*  2993 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  2994 */         .addComponent(this.jPanel172, -2, -1, -2));
/*       */ 
/*       */     
/*  2997 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/*  2998 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Fecha", "Residuo", "Cliente", "Destino", "Descripcion", "Colonia", "C.P.", "Ciudad", "Estado", "Sexo", "Teléfono 1", "Teléfono 2", "Correo", "Abogado" }));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  3006 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3008 */             ModificarGuias.this.jTable3MouseClicked(evt);
/*       */           }
/*       */         });
/*  3011 */     this.jTable3.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  3013 */             ModificarGuias.this.jTable3KeyReleased(evt);
/*       */           }
/*       */         });
/*  3016 */     this.jScrollPane3.setViewportView(this.jTable3);
/*  3017 */     if (this.jTable3.getColumnModel().getColumnCount() > 0) {
/*  3018 */       this.jTable3.getColumnModel().getColumn(0).setMinWidth(50);
/*  3019 */       this.jTable3.getColumnModel().getColumn(0).setMaxWidth(50);
/*  3020 */       this.jTable3.getColumnModel().getColumn(1).setMinWidth(100);
/*  3021 */       this.jTable3.getColumnModel().getColumn(1).setMaxWidth(100);
/*       */     } 
/*       */     
/*  3024 */     GroupLayout jPanel60Layout = new GroupLayout(this.jPanel60);
/*  3025 */     this.jPanel60.setLayout(jPanel60Layout);
/*  3026 */     jPanel60Layout.setHorizontalGroup(jPanel60Layout
/*  3027 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3028 */         .addGap(0, 801, 32767));
/*       */     
/*  3030 */     jPanel60Layout.setVerticalGroup(jPanel60Layout
/*  3031 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3032 */         .addGap(0, 489, 32767));
/*       */ 
/*       */     
/*  3035 */     this.jLabel114.setFont(new Font("Cantarell", 0, 11));
/*  3036 */     this.jLabel114.setText("Línea");
/*       */     
/*  3038 */     this.jComboBox34.setBackground(new Color(244, 244, 244));
/*       */     
/*  3040 */     GroupLayout jPanel61Layout = new GroupLayout(this.jPanel61);
/*  3041 */     this.jPanel61.setLayout(jPanel61Layout);
/*  3042 */     jPanel61Layout.setHorizontalGroup(jPanel61Layout
/*  3043 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3044 */         .addGroup(jPanel61Layout.createSequentialGroup()
/*  3045 */           .addGap(96, 96, 96)
/*  3046 */           .addComponent(this.jLabel114)
/*  3047 */           .addGap(41, 41, 41)
/*  3048 */           .addComponent(this.jComboBox34, -2, -1, -2)
/*  3049 */           .addContainerGap(333, 32767)));
/*       */     
/*  3051 */     jPanel61Layout.setVerticalGroup(jPanel61Layout
/*  3052 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3053 */         .addGroup(jPanel61Layout.createSequentialGroup()
/*  3054 */           .addGap(14, 14, 14)
/*  3055 */           .addGroup(jPanel61Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  3056 */             .addComponent(this.jComboBox34, -2, -1, -2)
/*  3057 */             .addComponent(this.jLabel114))
/*  3058 */           .addContainerGap(384, 32767)));
/*       */ 
/*       */     
/*  3061 */     this.jComboBox20.setBackground(new Color(244, 244, 244));
/*  3062 */     this.jComboBox20.setModel(new DefaultComboBoxModel<>(new String[] { "TIPO DE SERVICIO", "Flete", "Posicionamiento de Equipo", "Moniobra", "Movimiento en Falso", "Movimiento Lateral", "Movimiento Interno", "Servicio Integral", "Servicio de Retro", "Renta", "Estadia" }));
/*  3063 */     this.jComboBox20.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3065 */             ModificarGuias.this.jComboBox20ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3069 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/*  3070 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "TIPO DE CARGA", "Agua de Fractura", "Agua Residual", "Fluido de Baja", "Fluido Recuperado", "Fluido Recuperado C/Trazas de Aceite", "Lodo Base Aceite", "Lodo Base Agua", "Lodos contaminados provenientes del SIAC tajín 5", "Mineral Hierro", "Recorte Base Aceite", "Recorte Base Agua", "Residuos Adicionales a la Perforación de Aceite", "Residuos Adicionales a la Perforación de Agua", "Salmuera", "Saneamiento", "Sólidos Contaminados con Hidrocarburos", "Sedimento", "Fletes - Varios" }));
/*  3071 */     this.jComboBox1.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3073 */             ModificarGuias.this.jComboBox1ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3077 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/*  3078 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "TIPO DE VEHÍCULO", "Bulldozer", "Caja Seca", "Cama Baja", "Camioneta", "Contenedor Marino", "Cuello de Ganzo", "Excavadora Oruga", "Góndola", "Hiab", "Iso Tank Container", "LowBoy", "Pipa", "Plana", "Plataforma", "Presas Metálicas", "Presión y Vacío", "Porta Contenedores", "Retroexcavadora", "Tiro Directo", "Tolva Granelera", "Tolva De Alumnio", "Tolva De Acero Inoxidable", "Tolva Presurizada", "Utilitario", "Otro" }));
/*  3079 */     this.jComboBox2.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3081 */             ModificarGuias.this.jComboBox2ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3085 */     this.jComboBox31.setBackground(new Color(244, 244, 244));
/*  3086 */     this.jComboBox31.setModel(new DefaultComboBoxModel<>(new String[] { "CLIENTE", "Bulldozer", "Cama Baja", "Camioneta", "Contenedor Marino", "Cuello de Ganzo", "Excavadora Oruga", "Góndola", "Hiab", "LowBoy", "Pipa", "Plana", "Plataforma", "Presas Metálicas", "Presión y Vacío", "Porta Contenedores", "Retroexcavadora", "Tiro Directo", "Tolva Granelera", "Tolva De Alumnio", "Tolva De Acero Inoxidable", "Tolva Presurizada", "Utilitario", "Otro" }));
/*  3087 */     this.jComboBox31.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3089 */             ModificarGuias.this.jComboBox31ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3093 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/*  3094 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "Origen" }));
/*  3095 */     this.jComboBox3.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3097 */             ModificarGuias.this.jComboBox3ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3101 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/*  3102 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Destino" }));
/*  3103 */     this.jComboBox4.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3105 */             ModificarGuias.this.jComboBox4ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3109 */     this.jDialog12.setTitle("Licencias Vencidas");
/*  3110 */     this.jDialog12.setUndecorated(true);
/*       */     
/*  3112 */     this.jPanel62.setBorder(BorderFactory.createLineBorder(this.lc.PRIMARIO2));
/*       */     
/*  3114 */     this.jPanel63.setBackground(this.lc.SECUNDARIO1);
/*       */     
/*  3116 */     this.jLabel33.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 13.0F));
/*  3117 */     this.jLabel33.setForeground(new Color(255, 255, 255));
/*  3118 */     this.jLabel33.setHorizontalAlignment(0);
/*  3119 */     this.jLabel33.setText("Guia");
/*  3120 */     this.jLabel33.addMouseMotionListener(new MouseMotionAdapter() {
/*       */           public void mouseDragged(MouseEvent evt) {
/*  3122 */             ModificarGuias.this.jLabel33MouseDragged(evt);
/*       */           }
/*       */         });
/*  3125 */     this.jLabel33.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3127 */             ModificarGuias.this.jLabel33MouseClicked(evt);
/*       */           }
/*       */         });
/*       */     
/*  3131 */     this.jPanel80.setBackground(this.lc.PRIMARIO1);
/*  3132 */     this.jPanel80.setLayout(new GridLayout(1, 0));
/*       */     
/*  3134 */     this.jLabel128.setHorizontalAlignment(0);
/*  3135 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*  3136 */     this.jLabel128.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3138 */             ModificarGuias.this.jLabel128MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3141 */             ModificarGuias.this.jLabel128MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3144 */             ModificarGuias.this.jLabel128MouseExited(evt);
/*       */           }
/*       */         });
/*  3147 */     this.jPanel80.add(this.jLabel128);
/*       */     
/*  3149 */     this.jLabel39.setHorizontalAlignment(0);
/*       */     
/*  3151 */     GroupLayout jPanel63Layout = new GroupLayout(this.jPanel63);
/*  3152 */     this.jPanel63.setLayout(jPanel63Layout);
/*  3153 */     jPanel63Layout.setHorizontalGroup(jPanel63Layout
/*  3154 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3155 */         .addGroup(jPanel63Layout.createSequentialGroup()
/*  3156 */           .addGap(1, 1, 1)
/*  3157 */           .addComponent(this.jLabel39, -2, 36, -2)
/*  3158 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3159 */           .addComponent(this.jLabel33, -1, -1, 32767)
/*  3160 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3161 */           .addComponent(this.jPanel80, -2, 34, -2)));
/*       */     
/*  3163 */     jPanel63Layout.setVerticalGroup(jPanel63Layout
/*  3164 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3165 */         .addComponent(this.jPanel80, -1, -1, 32767)
/*  3166 */         .addGroup(jPanel63Layout.createSequentialGroup()
/*  3167 */           .addGroup(jPanel63Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  3168 */             .addComponent(this.jLabel39, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  3169 */             .addComponent(this.jLabel33, -2, 30, -2))
/*  3170 */           .addGap(0, 0, 32767)));
/*       */ 
/*       */     
/*  3173 */     this.jPanel79.setLayout(new GridLayout(1, 3, 6, 0));
/*       */     
/*  3175 */     this.materialButton38.setBackground(this.lc.SECUNDARIO1);
/*  3176 */     this.materialButton38.setForeground(new Color(255, 255, 255));
/*  3177 */     this.materialButton38.setMnemonic('R');
/*  3178 */     this.materialButton38.setText("Cerrar");
/*  3179 */     this.materialButton38.setToolTipText("Cerrar (Alt+R)");
/*  3180 */     this.materialButton38.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 12.0F));
/*  3181 */     this.materialButton38.setHorizontalTextPosition(0);
/*  3182 */     this.materialButton38.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3184 */             ModificarGuias.this.materialButton38ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3187 */     this.jPanel79.add((Component)this.materialButton38);
/*       */     
/*  3189 */     this.rSTableMetro2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Dato", "Información" })
/*       */         {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*  3197 */           boolean[] canEdit = new boolean[] { false, false };
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  3202 */             return this.canEdit[columnIndex];
/*       */           }
/*       */         });
/*  3205 */     this.rSTableMetro2.setAltoHead(25);
/*  3206 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  3207 */     this.rSTableMetro2.setColorBordeFilas(new Color(200, 200, 200));
/*  3208 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/*  3209 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/*  3210 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/*  3211 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/*  3212 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/*  3213 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 11));
/*  3214 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  3215 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/*  3216 */     this.rSTableMetro2.setGrosorBordeFilas(0);
/*  3217 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/*  3218 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/*  3219 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/*  3220 */     this.jScrollPane33.setViewportView((Component)this.rSTableMetro2);
/*  3221 */     if (this.rSTableMetro2.getColumnModel().getColumnCount() > 0) {
/*  3222 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMinWidth(250);
/*  3223 */       this.rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(250);
/*  3224 */       this.rSTableMetro2.getColumnModel().getColumn(0).setMaxWidth(250);
/*       */     } 
/*       */     
/*  3227 */     this.jLabel15.setText(" Información completa de la guía");
/*       */     
/*  3229 */     GroupLayout jPanel64Layout = new GroupLayout(this.jPanel64);
/*  3230 */     this.jPanel64.setLayout(jPanel64Layout);
/*  3231 */     jPanel64Layout.setHorizontalGroup(jPanel64Layout
/*  3232 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3233 */         .addComponent(this.jScrollPane33, -1, 729, 32767)
/*  3234 */         .addComponent(this.jLabel15, -1, -1, 32767));
/*       */     
/*  3236 */     jPanel64Layout.setVerticalGroup(jPanel64Layout
/*  3237 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3238 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel64Layout.createSequentialGroup()
/*  3239 */           .addComponent(this.jLabel15)
/*  3240 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3241 */           .addComponent(this.jScrollPane33, -1, 274, 32767)));
/*       */ 
/*       */     
/*  3244 */     GroupLayout jPanel62Layout = new GroupLayout(this.jPanel62);
/*  3245 */     this.jPanel62.setLayout(jPanel62Layout);
/*  3246 */     jPanel62Layout.setHorizontalGroup(jPanel62Layout
/*  3247 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3248 */         .addComponent(this.jPanel63, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/*  3249 */         .addComponent(this.jPanel64, -1, -1, 32767)
/*  3250 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel62Layout.createSequentialGroup()
/*  3251 */           .addGap(0, 0, 32767)
/*  3252 */           .addComponent(this.jPanel79, -2, 127, -2)));
/*       */     
/*  3254 */     jPanel62Layout.setVerticalGroup(jPanel62Layout
/*  3255 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3256 */         .addGroup(jPanel62Layout.createSequentialGroup()
/*  3257 */           .addComponent(this.jPanel63, -2, -1, -2)
/*  3258 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3259 */           .addComponent(this.jPanel64, -1, -1, 32767)
/*  3260 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3261 */           .addComponent(this.jPanel79, -2, 41, -2)));
/*       */ 
/*       */     
/*  3264 */     GroupLayout jDialog12Layout = new GroupLayout(this.jDialog12.getContentPane());
/*  3265 */     this.jDialog12.getContentPane().setLayout(jDialog12Layout);
/*  3266 */     jDialog12Layout.setHorizontalGroup(jDialog12Layout
/*  3267 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3268 */         .addComponent(this.jPanel62, -1, -1, 32767));
/*       */     
/*  3270 */     jDialog12Layout.setVerticalGroup(jDialog12Layout
/*  3271 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3272 */         .addGroup(jDialog12Layout.createSequentialGroup()
/*  3273 */           .addComponent(this.jPanel62, -1, -1, 32767)
/*  3274 */           .addGap(0, 0, 0)));
/*       */ 
/*       */     
/*  3277 */     this.RecepAnteior.setTitle("Recepción de Documentos");
/*  3278 */     this.RecepAnteior.setModal(true);
/*       */     
/*  3280 */     this.jPanel9.setBackground(new Color(146, 193, 134));
/*       */     
/*  3282 */     this.jLabel8.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis75.png")));
/*       */     
/*  3284 */     this.jLabel12.setForeground(Color.blue);
/*  3285 */     this.jLabel12.setHorizontalAlignment(0);
/*  3286 */     this.jLabel12.setText("<html><U>Saldar</u></html>");
/*  3287 */     this.jLabel12.setToolTipText("Clic aquí para saldar la guía con una hoja de recepción ya pagada.");
/*  3288 */     this.jLabel12.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3290 */             ModificarGuias.this.jLabel12MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3293 */             ModificarGuias.this.jLabel12MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3296 */             ModificarGuias.this.jLabel12MouseExited(evt);
/*       */           }
/*       */         });
/*       */     
/*  3300 */     this.jLabel108.setText("Remolque 2");
/*       */     
/*  3302 */     this.jTextField33.setEnabled(false);
/*       */     
/*  3304 */     GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
/*  3305 */     this.jPanel22.setLayout(jPanel22Layout);
/*  3306 */     jPanel22Layout.setHorizontalGroup(jPanel22Layout
/*  3307 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3308 */         .addGroup(jPanel22Layout.createSequentialGroup()
/*  3309 */           .addComponent(this.jLabel108, -2, 81, -2)
/*  3310 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  3311 */           .addComponent(this.jTextField33, -2, 115, -2)
/*  3312 */           .addGap(0, 20, 32767)));
/*       */     
/*  3314 */     jPanel22Layout.setVerticalGroup(jPanel22Layout
/*  3315 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3316 */         .addGroup(jPanel22Layout.createSequentialGroup()
/*  3317 */           .addGap(60, 60, 60)
/*  3318 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  3319 */             .addComponent(this.jLabel108)
/*  3320 */             .addComponent(this.jTextField33, -2, -1, -2))
/*  3321 */           .addContainerGap(37, 32767)));
/*       */ 
/*       */     
/*  3324 */     this.jLabel109.setFont(new Font("Tahoma", 2, 11));
/*  3325 */     this.jLabel109.setForeground(new Color(15, 87, 51));
/*  3326 */     this.jLabel109.setText("Ticket 2");
/*       */     
/*  3328 */     this.jLabel110.setFont(new Font("Tahoma", 2, 11));
/*  3329 */     this.jLabel110.setForeground(new Color(15, 87, 51));
/*  3330 */     this.jLabel110.setText("Peso Neto 2");
/*       */     
/*  3332 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  3333 */     this.jPanel9.setLayout(jPanel9Layout);
/*  3334 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/*  3335 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3336 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/*  3337 */           .addContainerGap(376, 32767)
/*  3338 */           .addComponent(this.jLabel12, -2, 69, -2)
/*  3339 */           .addGap(42, 42, 42))
/*  3340 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/*  3341 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  3342 */             .addComponent(this.jLabel8, GroupLayout.Alignment.LEADING)
/*  3343 */             .addComponent(this.jSeparator1, GroupLayout.Alignment.LEADING, -2, 450, -2))
/*  3344 */           .addContainerGap(37, 32767))
/*  3345 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  3346 */           .addGap(40, 40, 40)
/*  3347 */           .addComponent(this.jLabel109, -2, 63, -2)
/*  3348 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3349 */           .addComponent(this.jTextField34, -2, 113, -2)
/*  3350 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  3351 */           .addComponent(this.jLabel110, -2, 61, -2)
/*  3352 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3353 */           .addComponent(this.jTextField35, -2, 111, -2)
/*  3354 */           .addContainerGap())
/*  3355 */         .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3356 */           .addGroup(jPanel9Layout.createSequentialGroup()
/*  3357 */             .addGap(130, 130, 130)
/*  3358 */             .addComponent(this.jPanel22, -2, -1, -2)
/*  3359 */             .addContainerGap(131, 32767))));
/*       */     
/*  3361 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/*  3362 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3363 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  3364 */           .addComponent(this.jLabel8)
/*  3365 */           .addGap(10, 10, 10)
/*  3366 */           .addComponent(this.jSeparator1, -2, -1, -2)
/*  3367 */           .addGap(49, 49, 49)
/*  3368 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  3369 */             .addComponent(this.jLabel109)
/*  3370 */             .addComponent(this.jTextField34, -2, -1, -2)
/*  3371 */             .addComponent(this.jLabel110)
/*  3372 */             .addComponent(this.jTextField35, -2, -1, -2))
/*  3373 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 443, 32767)
/*  3374 */           .addComponent(this.jLabel12, -2, -1, -2)
/*  3375 */           .addContainerGap())
/*  3376 */         .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3377 */           .addGroup(jPanel9Layout.createSequentialGroup()
/*  3378 */             .addGap(251, 251, 251)
/*  3379 */             .addComponent(this.jPanel22, -2, -1, -2)
/*  3380 */             .addContainerGap(251, 32767))));
/*       */ 
/*       */     
/*  3383 */     GroupLayout RecepAnteiorLayout = new GroupLayout(this.RecepAnteior.getContentPane());
/*  3384 */     this.RecepAnteior.getContentPane().setLayout(RecepAnteiorLayout);
/*  3385 */     RecepAnteiorLayout.setHorizontalGroup(RecepAnteiorLayout
/*  3386 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3387 */         .addComponent(this.jPanel9, -1, -1, 32767));
/*       */     
/*  3389 */     RecepAnteiorLayout.setVerticalGroup(RecepAnteiorLayout
/*  3390 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3391 */         .addComponent(this.jPanel9, -1, -1, 32767));
/*       */ 
/*       */     
/*  3394 */     this.jDialog18.setTitle("Confirmar DO y LID");
/*       */     
/*  3396 */     this.jLabel189.setText("DO");
/*       */     
/*  3398 */     this.jLabel193.setText("LID");
/*       */     
/*  3400 */     this.jTextField87.setText("jTextField87");
/*  3401 */     this.jTextField87.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3403 */             ModificarGuias.this.jTextField87ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3407 */     this.jTextField88.setText("jTextField88");
/*  3408 */     this.jTextField88.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3410 */             ModificarGuias.this.jTextField88ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3414 */     this.materialButton24.setBackground(this.lc.PRIMARIO1);
/*  3415 */     this.materialButton24.setForeground(new Color(255, 255, 255));
/*  3416 */     this.materialButton24.setMnemonic('C');
/*  3417 */     this.materialButton24.setText("Confirmar");
/*  3418 */     this.materialButton24.setToolTipText("Confirmar (Alt+C)");
/*  3419 */     this.materialButton24.setFont(new Font("Cantarell", 0, 12));
/*  3420 */     this.materialButton24.setHorizontalTextPosition(0);
/*  3421 */     this.materialButton24.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3423 */             ModificarGuias.this.materialButton24ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3427 */     this.jTextField89.setEditable(false);
/*  3428 */     this.jTextField89.setText("jTextField89");
/*  3429 */     this.jTextField89.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3431 */             ModificarGuias.this.jTextField89ActionPerformed(evt);
/*       */           }
/*       */         });
/*       */     
/*  3435 */     this.jLabel194.setText("Actualización");
/*       */     
/*  3437 */     GroupLayout jPanel135Layout = new GroupLayout(this.jPanel135);
/*  3438 */     this.jPanel135.setLayout(jPanel135Layout);
/*  3439 */     jPanel135Layout.setHorizontalGroup(jPanel135Layout
/*  3440 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3441 */         .addGroup(jPanel135Layout.createSequentialGroup()
/*  3442 */           .addContainerGap()
/*  3443 */           .addGroup(jPanel135Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3444 */             .addComponent(this.jSeparator13, GroupLayout.Alignment.TRAILING)
/*  3445 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel135Layout.createSequentialGroup()
/*  3446 */               .addGap(0, 347, 32767)
/*  3447 */               .addComponent((Component)this.materialButton24, -2, 150, -2))
/*  3448 */             .addGroup(jPanel135Layout.createSequentialGroup()
/*  3449 */               .addGroup(jPanel135Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  3450 */                 .addComponent(this.jLabel189, -1, -1, 32767)
/*  3451 */                 .addComponent(this.jLabel193, -1, 120, 32767)
/*  3452 */                 .addComponent(this.jLabel194, -1, -1, 32767))
/*  3453 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3454 */               .addGroup(jPanel135Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3455 */                 .addComponent(this.jTextField89, GroupLayout.Alignment.TRAILING)
/*  3456 */                 .addComponent(this.jTextField87)
/*  3457 */                 .addComponent(this.jTextField88))))
/*  3458 */           .addContainerGap()));
/*       */     
/*  3460 */     jPanel135Layout.setVerticalGroup(jPanel135Layout
/*  3461 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3462 */         .addGroup(jPanel135Layout.createSequentialGroup()
/*  3463 */           .addContainerGap()
/*  3464 */           .addGroup(jPanel135Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  3465 */             .addComponent(this.jLabel189)
/*  3466 */             .addComponent(this.jTextField87, -2, -1, -2))
/*  3467 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3468 */           .addGroup(jPanel135Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  3469 */             .addComponent(this.jLabel193)
/*  3470 */             .addComponent(this.jTextField88, -2, -1, -2))
/*  3471 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3472 */           .addGroup(jPanel135Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  3473 */             .addComponent(this.jTextField89, -2, -1, -2)
/*  3474 */             .addComponent(this.jLabel194))
/*  3475 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  3476 */           .addComponent(this.jSeparator13, -2, 18, -2)
/*  3477 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  3478 */           .addComponent((Component)this.materialButton24, -2, 38, -2)
/*  3479 */           .addContainerGap()));
/*       */ 
/*       */     
/*  3482 */     GroupLayout jDialog18Layout = new GroupLayout(this.jDialog18.getContentPane());
/*  3483 */     this.jDialog18.getContentPane().setLayout(jDialog18Layout);
/*  3484 */     jDialog18Layout.setHorizontalGroup(jDialog18Layout
/*  3485 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3486 */         .addComponent(this.jPanel135, -1, -1, 32767));
/*       */     
/*  3488 */     jDialog18Layout.setVerticalGroup(jDialog18Layout
/*  3489 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3490 */         .addComponent(this.jPanel135, -2, -1, -2));
/*       */ 
/*       */     
/*  3493 */     this.jPanel1.setBackground(this.lc.SECUNDARIO2);
/*  3494 */     this.jPanel1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
/*       */     
/*  3496 */     this.jPanel5.setBackground(this.lc.SECUNDARIO1);
/*       */     
/*  3498 */     this.jPanel48.setBackground(this.lc.SECUNDARIO1);
/*  3499 */     this.jPanel48.setLayout(new GridLayout(1, 4, 6, 0));
/*       */     
/*  3501 */     this.jLabel60.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/*  3502 */     this.jLabel60.setForeground(this.lc.SECUNDARIO2);
/*  3503 */     this.jLabel60.setHorizontalAlignment(4);
/*  3504 */     this.jLabel60.setText("Viajes");
/*  3505 */     this.jPanel48.add(this.jLabel60);
/*       */     
/*  3507 */     this.jLabel50.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/*  3508 */     this.jLabel50.setForeground(this.lc.PRIMARIO1);
/*  3509 */     this.jLabel50.setHorizontalAlignment(2);
/*  3510 */     this.jLabel50.setText("0");
/*  3511 */     this.jPanel48.add(this.jLabel50);
/*       */     
/*  3513 */     this.jLabel64.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/*  3514 */     this.jLabel64.setForeground(this.lc.SECUNDARIO2);
/*  3515 */     this.jLabel64.setHorizontalAlignment(4);
/*  3516 */     this.jLabel64.setText("Tons");
/*  3517 */     this.jPanel48.add(this.jLabel64);
/*       */     
/*  3519 */     this.jLabel54.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/*  3520 */     this.jLabel54.setForeground(this.lc.PRIMARIO1);
/*  3521 */     this.jLabel54.setHorizontalAlignment(2);
/*  3522 */     this.jLabel54.setText("0");
/*  3523 */     this.jPanel48.add(this.jLabel54);
/*       */     
/*  3525 */     this.jPanel50.setBackground(this.lc.SECUNDARIO2);
/*  3526 */     this.jPanel50.setLayout(new GridLayout(1, 12, 6, 0));
/*       */     
/*  3528 */     this.jButton24.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/*  3529 */     this.jButton24.setMnemonic('N');
/*  3530 */     this.jButton24.setText("Nueva");
/*  3531 */     this.jButton24.setToolTipText("Nueva (Alt+N)");
/*  3532 */     this.jButton24.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3534 */             ModificarGuias.this.jButton24ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3537 */     this.jPanel50.add(this.jButton24);
/*       */     
/*  3539 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Modify.png")));
/*  3540 */     this.jButton2.setMnemonic('M');
/*  3541 */     this.jButton2.setText("Modificar");
/*  3542 */     this.jButton2.setToolTipText("Modificar Guía (Alt+M)");
/*  3543 */     this.jButton2.setEnabled(false);
/*  3544 */     this.jButton2.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3546 */             ModificarGuias.this.jButton2ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3549 */     this.jPanel50.add(this.jButton2);
/*       */     
/*  3551 */     this.jButton26.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/exchange.png")));
/*  3552 */     this.jButton26.setMnemonic('L');
/*  3553 */     this.jButton26.setText("Liberar");
/*  3554 */     this.jButton26.setToolTipText("Liberar (Alt+L)");
/*  3555 */     this.jButton26.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3557 */             ModificarGuias.this.jButton26ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3560 */     this.jPanel50.add(this.jButton26);
/*       */     
/*  3562 */     this.jButton25.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/documentos.png")));
/*  3563 */     this.jButton25.setText("Copiar");
/*  3564 */     this.jButton25.setToolTipText("Copiar y crear una nueva");
/*  3565 */     this.jButton25.setEnabled(false);
/*  3566 */     this.jButton25.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3568 */             ModificarGuias.this.jButton25ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3571 */     this.jPanel50.add(this.jButton25);
/*       */     
/*  3573 */     this.jButton8.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/google-docs.png")));
/*  3574 */     this.jButton8.setMnemonic('P');
/*  3575 */     this.jButton8.setText("Complementar Guía");
/*  3576 */     this.jButton8.setToolTipText("Complementar Guía (Alt+ P)");
/*  3577 */     this.jButton8.setEnabled(false);
/*  3578 */     this.jButton8.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3580 */             ModificarGuias.this.jButton8ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3583 */     this.jPanel50.add(this.jButton8);
/*       */     
/*  3585 */     this.jButton4.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/printing.png")));
/*  3586 */     this.jButton4.setMnemonic('R');
/*  3587 */     this.jButton4.setText("Reimprimir Guía");
/*  3588 */     this.jButton4.setToolTipText("Reimprimir Guía (Alt+R)");
/*  3589 */     this.jButton4.setEnabled(false);
/*  3590 */     this.jButton4.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3592 */             ModificarGuias.this.jButton4ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3595 */     this.jPanel50.add(this.jButton4);
/*       */     
/*  3597 */     this.jButton5.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/*  3598 */     this.jButton5.setMnemonic('C');
/*  3599 */     this.jButton5.setText("Cancelar");
/*  3600 */     this.jButton5.setToolTipText("Cancelar Guía (Alt+C)");
/*  3601 */     this.jButton5.setEnabled(false);
/*  3602 */     this.jButton5.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3604 */             ModificarGuias.this.jButton5ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3607 */     this.jPanel50.add(this.jButton5);
/*       */     
/*  3609 */     this.jButton9.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Things_34164.png")));
/*  3610 */     this.jButton9.setMnemonic('G');
/*  3611 */     this.jButton9.setText("Comprobante de traslado");
/*  3612 */     this.jButton9.setToolTipText("Guardar Reporte (Alt+G)");
/*  3613 */     this.jButton9.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3615 */             ModificarGuias.this.jButton9ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3618 */     this.jPanel50.add(this.jButton9);
/*       */     
/*  3620 */     this.jButton18.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/*  3621 */     this.jButton18.setMnemonic('I');
/*  3622 */     this.jButton18.setText("Imprimir");
/*  3623 */     this.jButton18.setToolTipText("Imprimir Reporte (Alt+I)");
/*  3624 */     this.jButton18.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3626 */             ModificarGuias.this.jButton18ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3629 */     this.jPanel50.add(this.jButton18);
/*       */     
/*  3631 */     this.jButton6.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/*  3632 */     this.jButton6.setMnemonic('G');
/*  3633 */     this.jButton6.setText("Guardar");
/*  3634 */     this.jButton6.setToolTipText("Guardar Reporte (Alt+G)");
/*  3635 */     this.jButton6.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3637 */             ModificarGuias.this.jButton6ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3640 */     this.jPanel50.add(this.jButton6);
/*       */     
/*  3642 */     this.jButton19.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Email.png")));
/*  3643 */     this.jButton19.setMnemonic('E');
/*  3644 */     this.jButton19.setText("Enviar Correo");
/*  3645 */     this.jButton19.setToolTipText("Enviar Correo (Alt+E)");
/*  3646 */     this.jButton19.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3648 */             ModificarGuias.this.jButton19ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3651 */     this.jPanel50.add(this.jButton19);
/*       */     
/*  3653 */     this.jButton27.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/agregar (2).png")));
/*  3654 */     this.jButton27.setText("DO y LID");
/*  3655 */     this.jButton27.setToolTipText("Confirmar DO y LID");
/*  3656 */     this.jButton27.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3658 */             ModificarGuias.this.jButton27ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3661 */     this.jPanel50.add(this.jButton27);
/*       */     
/*  3663 */     this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Col1", "Col2" })
/*       */         {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*  3671 */           boolean[] canEdit = new boolean[] { false, false };
/*       */ 
/*       */ 
/*       */           
/*       */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  3676 */             return this.canEdit[columnIndex];
/*       */           }
/*       */         });
/*  3679 */     this.rSTableMetro1.setAltoHead(40);
/*  3680 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/*  3681 */     this.rSTableMetro1.setColorBordeFilas(new Color(200, 200, 200));
/*  3682 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/*  3683 */     this.rSTableMetro1.setColorFilasBackgound2(new Color(239, 239, 239));
/*  3684 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/*  3685 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/*  3686 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/*  3687 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 11));
/*  3688 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 9));
/*  3689 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/*  3690 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/*  3691 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/*  3692 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/*  3693 */     this.rSTableMetro1.setSelectionForeground(new Color(255, 255, 255));
/*  3694 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/*  3695 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/*  3696 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3698 */             ModificarGuias.this.rSTableMetro1MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3701 */             ModificarGuias.this.rSTableMetro1MouseEntered(evt);
/*       */           }
/*       */         });
/*  3704 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  3706 */             ModificarGuias.this.rSTableMetro1KeyReleased(evt);
/*       */           }
/*       */         });
/*  3709 */     this.jScrollPane20.setViewportView((Component)this.rSTableMetro1);
/*       */     
/*  3711 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*  3712 */     this.jPanel5.setLayout(jPanel5Layout);
/*  3713 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/*  3714 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3715 */         .addGroup(jPanel5Layout.createSequentialGroup()
/*  3716 */           .addComponent(this.jPanel48, -2, 293, -2)
/*  3717 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  3718 */           .addComponent(this.jPanel50, -2, 1670, -2)
/*  3719 */           .addContainerGap(-1, 32767))
/*  3720 */         .addComponent(this.jScrollPane20, -1, 3208, 32767));
/*       */     
/*  3722 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/*  3723 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3724 */         .addGroup(jPanel5Layout.createSequentialGroup()
/*  3725 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  3726 */             .addComponent(this.jPanel48, -1, -1, 32767)
/*  3727 */             .addComponent(this.jPanel50, -1, -1, 32767))
/*  3728 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3729 */           .addComponent(this.jScrollPane20, -1, 275, 32767)));
/*       */ 
/*       */     
/*  3732 */     this.jPanel17.setBackground(this.lc.SECUNDARIO2);
/*  3733 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Guías ", 0, 0, new Font("Tahoma", 1, 11)));
/*       */     
/*  3735 */     this.jPanel51.setBackground(this.lc.SECUNDARIO2);
/*  3736 */     this.jPanel51.setLayout(new GridLayout(1, 4, 6, 0));
/*       */     
/*  3738 */     this.jComboBox30.setBackground(new Color(244, 244, 244));
/*  3739 */     this.jComboBox30.setFont(new Font("SF UI Display Light", 1, 12));
/*  3740 */     this.jComboBox30.setModel(new DefaultComboBoxModel<>(new String[] { "ESTATUS", "<Por Timbrar>", "<Asignada Al Operador>", "<En patio>", "<Pagada Al Operador>", "<En prefactura Interna>", "<Facturada>" }));
/*  3741 */     this.jComboBox30.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3743 */             ModificarGuias.this.jComboBox30ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3746 */     this.jPanel51.add(this.jComboBox30);
/*       */     
/*  3748 */     this.jPanel56.setBackground(this.lc.SECUNDARIO2);
/*  3749 */     this.jPanel56.setLayout(new GridLayout(1, 3, 6, 0));
/*       */     
/*  3751 */     this.jComboBox8.setBackground(new Color(244, 244, 244));
/*  3752 */     this.jComboBox8.setFont(new Font("SF UI Display Light", 1, 12));
/*  3753 */     this.jComboBox8.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVA", "CANCELADA", "TODOS" }));
/*  3754 */     this.jComboBox8.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3756 */             ModificarGuias.this.jComboBox8ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3759 */     this.jPanel56.add(this.jComboBox8);
/*       */     
/*  3761 */     this.jTextField1.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3763 */             ModificarGuias.this.jTextField1ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3766 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  3768 */             ModificarGuias.this.jTextField1KeyReleased(evt);
/*       */           }
/*       */         });
/*  3771 */     this.jPanel56.add(this.jTextField1);
/*       */     
/*  3773 */     this.jPanel51.add(this.jPanel56);
/*       */     
/*  3775 */     this.jTextField2.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3777 */             ModificarGuias.this.jTextField2ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3780 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  3782 */             ModificarGuias.this.jTextField2KeyReleased(evt);
/*       */           }
/*       */         });
/*  3785 */     this.jPanel51.add(this.jTextField2);
/*       */     
/*  3787 */     this.jPanel59.setBackground(this.lc.SECUNDARIO2);
/*  3788 */     this.jPanel59.setLayout(new GridLayout(1, 2, 6, 0));
/*       */     
/*  3790 */     this.jTextField4.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3792 */             ModificarGuias.this.jTextField4ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3795 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  3797 */             ModificarGuias.this.jTextField4KeyReleased(evt);
/*       */           }
/*       */         });
/*  3800 */     this.jPanel59.add(this.jTextField4);
/*       */     
/*  3802 */     this.jTextField3.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3804 */             ModificarGuias.this.jTextField3ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3807 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  3809 */             ModificarGuias.this.jTextField3KeyReleased(evt);
/*       */           }
/*       */         });
/*  3812 */     this.jPanel59.add(this.jTextField3);
/*       */     
/*  3814 */     this.jPanel51.add(this.jPanel59);
/*       */     
/*  3816 */     this.jPanel57.setBackground(this.lc.SECUNDARIO2);
/*  3817 */     this.jPanel57.setLayout(new GridLayout(1, 3, 6, 0));
/*       */     
/*  3819 */     this.jTextField11.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3821 */             ModificarGuias.this.jTextField11ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3824 */     this.jTextField11.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  3826 */             ModificarGuias.this.jTextField11KeyReleased(evt);
/*       */           }
/*       */         });
/*  3829 */     this.jPanel57.add(this.jTextField11);
/*       */     
/*  3831 */     this.jTextField12.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  3833 */             ModificarGuias.this.jTextField12KeyReleased(evt);
/*       */           }
/*       */         });
/*  3836 */     this.jPanel57.add(this.jTextField12);
/*       */     
/*  3838 */     this.jTextField37.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  3840 */             ModificarGuias.this.jTextField37KeyReleased(evt);
/*       */           }
/*       */         });
/*  3843 */     this.jPanel57.add(this.jTextField37);
/*       */     
/*  3845 */     this.jPanel58.setBackground(this.lc.SECUNDARIO2);
/*  3846 */     this.jPanel58.setLayout(new GridLayout(1, 5, 6, 0));
/*       */     
/*  3848 */     this.jTextField38.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  3850 */             ModificarGuias.this.jTextField38KeyReleased(evt);
/*       */           }
/*       */         });
/*  3853 */     this.jPanel58.add(this.jTextField38);
/*       */     
/*  3855 */     this.jTextField39.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  3857 */             ModificarGuias.this.jTextField39KeyReleased(evt);
/*       */           }
/*       */         });
/*  3860 */     this.jPanel58.add(this.jTextField39);
/*       */     
/*  3862 */     this.jTextField40.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  3864 */             ModificarGuias.this.jTextField40KeyReleased(evt);
/*       */           }
/*       */         });
/*  3867 */     this.jPanel58.add(this.jTextField40);
/*       */     
/*  3869 */     this.jTextField46.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  3871 */             ModificarGuias.this.jTextField46KeyReleased(evt);
/*       */           }
/*       */         });
/*  3874 */     this.jPanel58.add(this.jTextField46);
/*       */     
/*  3876 */     this.jTextField47.addKeyListener(new KeyAdapter() {
/*       */           public void keyReleased(KeyEvent evt) {
/*  3878 */             ModificarGuias.this.jTextField47KeyReleased(evt);
/*       */           }
/*       */         });
/*  3881 */     this.jPanel58.add(this.jTextField47);
/*       */     
/*  3883 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/*  3884 */     this.jPanel17.setLayout(jPanel17Layout);
/*  3885 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/*  3886 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3887 */         .addGroup(jPanel17Layout.createSequentialGroup()
/*  3888 */           .addComponent(this.jPanel51, -2, 840, -2)
/*  3889 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3890 */           .addComponent(this.jPanel57, -2, 557, -2)
/*  3891 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  3892 */           .addComponent(this.jPanel58, -2, 1012, -2)
/*  3893 */           .addContainerGap(-1, 32767)));
/*       */     
/*  3895 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/*  3896 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3897 */         .addGroup(jPanel17Layout.createSequentialGroup()
/*  3898 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  3899 */             .addComponent(this.jPanel51, -2, -1, -2)
/*  3900 */             .addComponent(this.jPanel57, -2, -1, -2)
/*  3901 */             .addComponent(this.jPanel58, -2, -1, -2))
/*  3902 */           .addContainerGap(7, 32767)));
/*       */ 
/*       */     
/*  3905 */     this.jLabel56.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 22.0F));
/*  3906 */     this.jLabel56.setForeground(this.lc.PRIMARIO2);
/*  3907 */     this.jLabel56.setText("Guias");
/*       */     
/*  3909 */     this.jPanel52.setBackground(this.lc.SECUNDARIO2);
/*       */     
/*  3911 */     this.jPanel53.setBackground(this.lc.SECUNDARIO2);
/*  3912 */     this.jPanel53.setLayout(new GridBagLayout());
/*       */     
/*  3914 */     this.jDateChooser9.setDate(this.fechaActual);
/*  3915 */     this.jDateChooser9.setDateFormatString("dd/MM/yyyy");
/*  3916 */     this.jDateChooser9.setIcon(this.icon);
/*  3917 */     this.jDateChooser9.setMinSelectableDate(this.fechaInicio);
/*  3918 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  3919 */     gridBagConstraints.gridx = 2;
/*  3920 */     gridBagConstraints.gridy = 0;
/*  3921 */     gridBagConstraints.fill = 2;
/*  3922 */     gridBagConstraints.weightx = 1.0D;
/*  3923 */     this.jPanel53.add((Component)this.jDateChooser9, gridBagConstraints);
/*       */     
/*  3925 */     this.jLabel235.setFont(new Font("Cantarell", 0, 11));
/*  3926 */     this.jLabel235.setHorizontalAlignment(0);
/*  3927 */     this.jLabel235.setText("     al     ");
/*  3928 */     gridBagConstraints = new GridBagConstraints();
/*  3929 */     gridBagConstraints.gridx = 4;
/*  3930 */     gridBagConstraints.gridy = 0;
/*  3931 */     gridBagConstraints.fill = 2;
/*  3932 */     this.jPanel53.add(this.jLabel235, gridBagConstraints);
/*       */     
/*  3934 */     this.jDateChooser10.setDate(this.fechaActual);
/*  3935 */     this.jDateChooser10.setDateFormatString("dd/MM/yyyy");
/*  3936 */     this.jDateChooser10.setIcon(this.icon);
/*  3937 */     this.jDateChooser10.setMinSelectableDate(this.fechaInicio);
/*  3938 */     gridBagConstraints = new GridBagConstraints();
/*  3939 */     gridBagConstraints.gridx = 6;
/*  3940 */     gridBagConstraints.gridy = 0;
/*  3941 */     gridBagConstraints.fill = 2;
/*  3942 */     gridBagConstraints.weightx = 1.0D;
/*  3943 */     this.jPanel53.add((Component)this.jDateChooser10, gridBagConstraints);
/*       */     
/*  3945 */     this.jComboBox36.setBackground(new Color(255, 255, 255));
/*  3946 */     this.jComboBox36.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3948 */             ModificarGuias.this.jComboBox36ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3951 */     gridBagConstraints = new GridBagConstraints();
/*  3952 */     gridBagConstraints.gridx = 0;
/*  3953 */     gridBagConstraints.gridy = 0;
/*  3954 */     this.jPanel53.add(this.jComboBox36, gridBagConstraints);
/*       */     
/*  3956 */     this.jPanel54.setBackground(this.lc.SECUNDARIO2);
/*  3957 */     this.jPanel54.setLayout(new GridLayout(1, 4, 6, 0));
/*       */     
/*  3959 */     this.jButton16.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/search.png")));
/*  3960 */     this.jButton16.setMnemonic('F');
/*  3961 */     this.jButton16.setToolTipText("Filtrar información (Alt+F)");
/*  3962 */     this.jButton16.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  3964 */             ModificarGuias.this.jButton16ActionPerformed(evt);
/*       */           }
/*       */         });
/*  3967 */     this.jPanel54.add(this.jButton16);
/*       */     
/*  3969 */     this.jLabel172.setFont(new Font("Ubuntu Semi-Light", 2, 12));
/*  3970 */     this.jLabel172.setForeground(new Color(15, 87, 51));
/*  3971 */     this.jLabel172.setHorizontalAlignment(0);
/*  3972 */     this.jLabel172.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-otra.png")));
/*  3973 */     this.jLabel172.setToolTipText("Retroceder un día en la búsqueda");
/*  3974 */     this.jLabel172.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3976 */             ModificarGuias.this.jLabel172MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3979 */             ModificarGuias.this.jLabel172MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  3982 */             ModificarGuias.this.jLabel172MouseExited(evt);
/*       */           }
/*       */         });
/*  3985 */     this.jPanel54.add(this.jLabel172);
/*       */     
/*  3987 */     this.jLabel103.setFont(new Font("Tahoma", 2, 12));
/*  3988 */     this.jLabel103.setForeground(new Color(15, 87, 51));
/*  3989 */     this.jLabel103.setHorizontalAlignment(0);
/*  3990 */     this.jLabel103.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked.png")));
/*  3991 */     this.jLabel103.setToolTipText("Clic para filtrar los datos de HOY");
/*  3992 */     this.jLabel103.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  3994 */             ModificarGuias.this.jLabel103MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  3997 */             ModificarGuias.this.jLabel103MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4000 */             ModificarGuias.this.jLabel103MouseExited(evt);
/*       */           }
/*       */         });
/*  4003 */     this.jPanel54.add(this.jLabel103);
/*       */     
/*  4005 */     this.jLabel173.setHorizontalAlignment(0);
/*  4006 */     this.jLabel173.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-otra.png")));
/*  4007 */     this.jLabel173.setToolTipText("Aumentar un día en la búsqueda");
/*  4008 */     this.jLabel173.addMouseListener(new MouseAdapter() {
/*       */           public void mouseClicked(MouseEvent evt) {
/*  4010 */             ModificarGuias.this.jLabel173MouseClicked(evt);
/*       */           }
/*       */           public void mouseEntered(MouseEvent evt) {
/*  4013 */             ModificarGuias.this.jLabel173MouseEntered(evt);
/*       */           }
/*       */           public void mouseExited(MouseEvent evt) {
/*  4016 */             ModificarGuias.this.jLabel173MouseExited(evt);
/*       */           }
/*       */         });
/*  4019 */     this.jPanel54.add(this.jLabel173);
/*       */     
/*  4021 */     this.jPanel55.setBackground(this.lc.SECUNDARIO2);
/*  4022 */     this.jPanel55.setLayout(new GridLayout(1, 2, 6, 0));
/*       */     
/*  4024 */     this.jLabel236.setFont(new Font("Cantarell", 0, 11));
/*  4025 */     this.jLabel236.setHorizontalAlignment(4);
/*  4026 */     this.jLabel236.setText("Visualizando información de ");
/*  4027 */     this.jPanel55.add(this.jLabel236);
/*       */     
/*  4029 */     this.jComboBox37.setBackground(new Color(255, 255, 255));
/*  4030 */     this.jComboBox37.setModel(new DefaultComboBoxModel<>(new String[] { "PERIODO LIBRE", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));
/*  4031 */     this.jComboBox37.addActionListener(new ActionListener() {
/*       */           public void actionPerformed(ActionEvent evt) {
/*  4033 */             ModificarGuias.this.jComboBox37ActionPerformed(evt);
/*       */           }
/*       */         });
/*  4036 */     this.jPanel55.add(this.jComboBox37);
/*       */     
/*  4038 */     GroupLayout jPanel52Layout = new GroupLayout(this.jPanel52);
/*  4039 */     this.jPanel52.setLayout(jPanel52Layout);
/*  4040 */     jPanel52Layout.setHorizontalGroup(jPanel52Layout
/*  4041 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4042 */         .addGroup(jPanel52Layout.createSequentialGroup()
/*  4043 */           .addComponent(this.jPanel55, -2, -1, -2)
/*  4044 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4045 */           .addComponent(this.jPanel53, -1, 383, 32767)
/*  4046 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4047 */           .addComponent(this.jPanel54, -2, 132, -2)
/*  4048 */           .addGap(18, 18, 18)));
/*       */     
/*  4050 */     jPanel52Layout.setVerticalGroup(jPanel52Layout
/*  4051 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4052 */         .addGroup(jPanel52Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  4053 */           .addComponent(this.jPanel54, -1, -1, 32767)
/*  4054 */           .addComponent(this.jPanel53, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/*  4055 */         .addComponent(this.jPanel55, -1, -1, 32767));
/*       */ 
/*       */     
/*  4058 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  4059 */     this.jPanel1.setLayout(jPanel1Layout);
/*  4060 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/*  4061 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4062 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  4063 */           .addContainerGap()
/*  4064 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4065 */             .addComponent(this.jPanel17, -1, -1, 32767)
/*  4066 */             .addComponent(this.jPanel5, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/*  4067 */             .addGroup(jPanel1Layout.createSequentialGroup()
/*  4068 */               .addComponent(this.jLabel56, -2, 95, -2)
/*  4069 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4070 */               .addComponent(this.jPanel52, -2, -1, -2)
/*  4071 */               .addGap(0, 0, 32767)))
/*  4072 */           .addContainerGap()));
/*       */     
/*  4074 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/*  4075 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4076 */         .addGroup(jPanel1Layout.createSequentialGroup()
/*  4077 */           .addContainerGap()
/*  4078 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4079 */             .addComponent(this.jLabel56, -2, 26, -2)
/*  4080 */             .addComponent(this.jPanel52, -2, -1, -2))
/*  4081 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  4082 */           .addComponent(this.jPanel17, -2, -1, -2)
/*  4083 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  4084 */           .addComponent(this.jPanel5, -1, -1, 32767)));
/*       */ 
/*       */     
/*  4087 */     GroupLayout layout = new GroupLayout(this);
/*  4088 */     setLayout(layout);
/*  4089 */     layout.setHorizontalGroup(layout
/*  4090 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4091 */         .addGap(0, 3224, 32767)
/*  4092 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4093 */           .addComponent(this.jPanel1, -1, -1, 32767)));
/*       */     
/*  4095 */     layout.setVerticalGroup(layout
/*  4096 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4097 */         .addGap(0, 416, 32767)
/*  4098 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  4099 */           .addComponent(this.jPanel1, -1, -1, 32767)));
/*       */   }
/*       */   private JPanel jPanel71; private JPanel jPanel72; private JPanel jPanel73; private JPanel jPanel74; private JPanel jPanel79; private JPanel jPanel8; private JPanel jPanel80; private JPanel jPanel9; private JPopupMenu jPopupMenu1; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JScrollPane jScrollPane1; private JScrollPane jScrollPane18; private JScrollPane jScrollPane19; private JScrollPane jScrollPane2; private JScrollPane jScrollPane20; private JScrollPane jScrollPane3; private JScrollPane jScrollPane33; private JScrollPane jScrollPane4; private JScrollPane jScrollPane5; private JSeparator jSeparator1; private JSeparator jSeparator10; private JSeparator jSeparator11; private JSeparator jSeparator12; private JSeparator jSeparator13; private JSeparator jSeparator2; private JSeparator jSeparator27; private JSeparator jSeparator28; private JSeparator jSeparator3; private JSeparator jSeparator4; private JSeparator jSeparator5; private JSeparator jSeparator6; private JSeparator jSeparator7; private JSeparator jSeparator8; private JSeparator jSeparator9; private JTable jTable3; private JTextArea jTextArea1; private JTextArea jTextArea2; private JTextArea jTextArea5; private JTextArea jTextArea6; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField13; private JTextField jTextField14; private JTextField jTextField15; private JTextField jTextField16; private JTextField jTextField17; private JTextField jTextField18; private JTextField jTextField19; private JTextField jTextField2; private JTextField jTextField20; private JTextField jTextField21; private JTextField jTextField22; private JTextField jTextField23; private JTextField jTextField24; private JTextField jTextField25; private JTextField jTextField26; private JTextField jTextField27; private JTextField jTextField28; private JTextField jTextField29; private JTextField jTextField3; private JTextField jTextField30; private JTextField jTextField31; private JTextField jTextField32; private JTextField jTextField33; private JTextField jTextField34; private JTextField jTextField35; private JTextField jTextField36; private JTextField jTextField37; private JTextField jTextField38; private JTextField jTextField39; private JTextField jTextField4; private JTextField jTextField40; private JTextField jTextField41; private JTextField jTextField42; private JTextField jTextField43; private JTextField jTextField44; private JTextField jTextField45; private JTextField jTextField46; private JTextField jTextField47; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8; private JTextField jTextField87; private JTextField jTextField88; private JTextField jTextField89; private JTextField jTextField9; private JTextPane jTextPane2; private MaterialButton materialButton16; private MaterialButton materialButton17; private MaterialButton materialButton18; private MaterialButton materialButton19; private MaterialButton materialButton20; private MaterialButton materialButton24; private MaterialButton materialButton38; private MaterialButton materialButton40; private MaterialButton materialButton41; private RSTableMetro rSTableMetro1; private RSTableMetro rSTableMetro2;
/*       */   
/*       */   private void jTextField1KeyReleased(KeyEvent evt) {
/*  4104 */     String cadena = this.jTextField1.getText();
/*  4105 */     if (!cadena.equals("")) {
/*  4106 */       if (this.presionado == null) {
/*  4107 */         this.presionado = new Presionado();
/*  4108 */         this.presionado.start();
/*       */       } else {
/*  4110 */         this.presionado.detenerFuera();
/*  4111 */         this.presionado = new Presionado();
/*  4112 */         this.presionado.start();
/*       */       } 
/*       */     }
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/*  4123 */     if (this.jComboBox1.getItemCount() > 0 && this.PRIMERA == true)
/*  4124 */       consultar(); 
/*       */   }
/*       */   
/*       */   private void jButton5ActionPerformed(ActionEvent evt) {
/*  4128 */     this.error.pasarModal(true);
/*  4129 */     this.val.pasarModal(Boolean.valueOf(true));
/*  4130 */     String num = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0));
/*  4131 */     this.CLAVE = num;
/*  4132 */     String estado = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 19));
/*  4133 */     if (estado.equals("ACTIVA")) {
/*  4134 */       this.jDialog1.setVisible(true);
/*       */     } else {
/*  4136 */       JOptionPane.showMessageDialog(this.padre, "No puedes cancelar esta guía porque no se encuentra activa", "Guía Cancelada", 0, this.ERROR);
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jTextField14ActionPerformed(ActionEvent evt) {
/*  4141 */     cancelar();
/*       */   }
/*       */ 
/*       */   
/*       */   private void jTextField14KeyReleased(KeyEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jButton11ActionPerformed(ActionEvent evt) {
/*  4149 */     cancelar();
/*       */   }
/*       */   
/*       */   private void jButton12ActionPerformed(ActionEvent evt) {
/*  4153 */     this.jTextField14.setText("");
/*  4154 */     this.jDialog1.setVisible(false);
/*       */   }
/*       */   
/*       */   private void jTable3MouseClicked(MouseEvent evt) {
/*  4158 */     if (evt.getClickCount() == 2) {
/*  4159 */       verDatos();
/*       */     }
/*  4161 */     if (this.jComboBox8.getSelectedIndex() == 0) {
/*  4162 */       privilegios();
/*  4163 */       if (this.DEPARTAMENTO.equals("SUPER USUARIO") || this.DEPARTAMENTO.equals("GERENTE DE OPERACIONES")) {
/*  4164 */         this.jButton4.setEnabled(true);
/*  4165 */         this.jButton8.setEnabled(true);
/*  4166 */         this.jButton2.setEnabled(true);
/*  4167 */         this.jButton9.setEnabled(true);
/*  4168 */         this.jButton24.setEnabled(true);
/*  4169 */         int indice = this.rSTableMetro1.getSelectedRow();
/*  4170 */         String rsp = String.valueOf(this.rSTableMetro1.getValueAt(indice, 13));
/*  4171 */         String ticket = String.valueOf(this.rSTableMetro1.getValueAt(indice, 14));
/*       */         
/*  4173 */         String tipo = String.valueOf(this.rSTableMetro1.getValueAt(indice, 2));
/*  4174 */         if (!rsp.equals("")) {
/*  4175 */           this.jButton8.setEnabled(false);
/*  4176 */           this.jButton5.setEnabled(false);
/*       */         } 
/*  4178 */         if (!rsp.equals("") && ticket.equals("0") && !tipo.contains("MOVIMIENTO EN FALSO") && !tipo.contains("MOVIMIENTO LATERAL")) {
/*  4179 */           this.jButton8.setEnabled(true);
/*  4180 */           this.jButton5.setEnabled(false);
/*       */         } 
/*  4182 */         if (this.jComboBox8.getSelectedIndex() != 0) {
/*  4183 */           this.jButton8.setEnabled(false);
/*  4184 */           this.jButton5.setEnabled(false);
/*       */         } 
/*       */         
/*  4187 */         if (this.USUARIO.equals("ALBERTO") || this.USUARIO.equals("PMARIO") || this.USUARIO.equals("JQUIROZ") || this.USUARIO.equals("TOMAS") || this.USUARIO.equals("JROBERTO") || this.USUARIO.equals("SRAMON") || this.USUARIO.equals("SRAMON1")) {
/*  4188 */           this.jButton5.setEnabled(false);
/*  4189 */           this.jComboBox14.setEnabled(false);
/*  4190 */           this.jComboBox28.setEnabled(false);
/*       */         } 
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/*  4197 */     if (this.jComboBox2.getItemCount() > 0 && this.PRIMERA == true) {
/*  4198 */       consultar();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/*  4203 */     if (this.jComboBox3.getItemCount() > 0 && this.PRIMERA == true) {
/*  4204 */       consultar();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jComboBox4ActionPerformed(ActionEvent evt) {
/*  4209 */     if (this.jComboBox4.getItemCount() > 0 && this.PRIMERA == true) {
/*  4210 */       consultar();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jComboBox5ActionPerformed(ActionEvent evt) {
/*  4215 */     if (this.jComboBox5.getItemCount() > 0 && this.PRIMERA == true) {
/*  4216 */       consultar();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jComboBox6ActionPerformed(ActionEvent evt) {
/*  4221 */     if (this.jComboBox6.getItemCount() > 0 && this.PRIMERA == true) {
/*  4222 */       consultar();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jComboBox7ActionPerformed(ActionEvent evt) {
/*  4227 */     if (this.jComboBox7.getItemCount() > 0 && this.PRIMERA == true) {
/*  4228 */       consultar();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jComboBox8ActionPerformed(ActionEvent evt) {
/*  4233 */     if (this.jComboBox8.getSelectedIndex() != 0) {
/*  4234 */       this.jButton8.setEnabled(false);
/*  4235 */       this.jButton5.setEnabled(false);
/*       */     } else {
/*  4237 */       this.jButton8.setEnabled(true);
/*  4238 */       this.jButton5.setEnabled(true);
/*       */     } 
/*  4240 */     if (this.jComboBox8.getItemCount() > 0) {
/*  4241 */       consultar();
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
/*       */   private void jButton6ActionPerformed(ActionEvent evt) {
/*  4274 */     this.utilerias.guardarTableAExcel((JTable)this.rSTableMetro1, this.USUARIO, "GUIAS");
/*       */   }
/*       */   
/*       */   private void jButton2ActionPerformed(ActionEvent evt) {
/*  4278 */     int reg = this.rSTableMetro1.getSelectedRow();
/*  4279 */     boolean entro = false;
/*  4280 */     if (reg >= 0) {
/*  4281 */       String estatus = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 21).toString();
/*  4282 */       if (this.DEPARTAMENTO.equals("SUPER USUARIO")) {
/*  4283 */         String guia = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString();
/*  4284 */         this.con.consultar("claveUnidadSat", "guias", "where num_guia= '" + guia + "'");
/*  4285 */         if (this.con.Campo.equals("")) {
/*  4286 */           GuiasForm form = new GuiasForm(this.USUARIO, this.padre, this.CAMPOSGENERALES, "MODIFICAR", this.actualizado, this.LISTACODIGOS, this.CODIGOSP, guia);
/*  4287 */           this.actualizado = form.actualizado;
/*  4288 */           entro = true;
/*  4289 */           if (this.actualizado) {
/*  4290 */             consultar();
/*       */             return;
/*       */           } 
/*       */         } else {
/*  4294 */           modificarGuiaAnterior();
/*       */         } 
/*       */       } else {
/*  4297 */         if (!estatus.equals("<Por Timbrar>") && !estatus.equals("<Asignada Al Operador>")) {
/*  4298 */           JOptionPane.showMessageDialog(this.padre, "La guía que seleccionaste ya no se puede modificar porque se encuentra en otro estatus: " + estatus, "Guía Aplicada", 0, this.ERROR);
/*  4299 */           liberarGuia();
/*       */           
/*       */           return;
/*       */         } 
/*  4303 */         String guia = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString();
/*  4304 */         this.con.consultar("claveUnidadSat", "guias", "where num_guia= '" + guia + "'");
/*       */         
/*  4306 */         if (this.con.Campo.equals("")) {
/*  4307 */           GuiasForm form = new GuiasForm(this.USUARIO, this.padre, this.CAMPOSGENERALES, "MODIFICAR", this.actualizado, this.LISTACODIGOS, this.CODIGOSP, guia);
/*  4308 */           this.actualizado = form.actualizado;
/*  4309 */           if (this.actualizado) {
/*  4310 */             consultar();
/*       */           }
/*       */         } else {
/*  4313 */           modificarGuiaAnterior();
/*       */         } 
/*       */       } 
/*       */     } else {
/*  4317 */       JOptionPane.showMessageDialog(this.padre, "Selecciona una guía para poder modificar los datos", "Selecciona una Guía", 0, this.ADVER);
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jTextField2KeyReleased(KeyEvent evt) {
/*  4322 */     String cadena = this.jTextField2.getText();
/*  4323 */     if (!cadena.equals("")) {
/*  4324 */       if (this.presionado == null) {
/*  4325 */         this.presionado = new Presionado();
/*  4326 */         this.presionado.start();
/*       */       } else {
/*  4328 */         this.presionado.detenerFuera();
/*  4329 */         this.presionado = new Presionado();
/*  4330 */         this.presionado.start();
/*       */       } 
/*       */     } else {
/*  4333 */       this.jTextField2.setBackground(new Color(153, 255, 153));
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jButton4ActionPerformed(ActionEvent evt) {
/*  4338 */     int indice = this.rSTableMetro1.getSelectedRow();
/*  4339 */     String GUIA = String.valueOf(this.rSTableMetro1.getValueAt(indice, 0));
/*       */     
/*  4341 */     this.con.consultar("claveUnidadSat", "guias", "where num_guia= '" + GUIA + "'");
/*  4342 */     if (this.con.Campo.equals("")) {
/*  4343 */       JOptionPane.showMessageDialog(this.padre, "Estás tratando de imprimir una Guía con las nuevas modalidades, necesitas entrar al modulo de la guía e imprimir", "Entrando a la guía", 0, this.ADVER);
/*  4344 */       verNuevaGuia(GUIA);
/*       */     } else {
/*  4346 */       String fecha = String.valueOf(this.rSTableMetro1.getValueAt(indice, 1));
/*  4347 */       String fechaCorta = fecha.substring(0, 10);
/*  4348 */       String FechaNormal = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/*  4349 */       String[] datos = this.con.regresaReg("residuo,clave_gene,clave_desti,num_equipo,num_plata,num_pozo,num_tracto,num_rem,num_ope,descrip", "llamadas_historicas", "where num_guia = '" + GUIA + "'", 10);
/*  4350 */       String[] clientes = this.con.regresaReg("empresa,calle,num,col,cp,ciudad,rfc,origen", "emp_generadora", "where clave_gene = " + datos[1], 8);
/*  4351 */       String[] destinos = { "", "", "", "", "", "", "", "", "" };
/*  4352 */       String tons = "20.0 TONS.";
/*  4353 */       String sub = "";
/*  4354 */       String iva = "";
/*  4355 */       String total = "";
/*  4356 */       String cantidad = "";
/*  4357 */       if (datos[2].equals("0")) {
/*  4358 */         destinos = new String[] { "", "", "", "", "", "", "", "", "" };
/*  4359 */         tons = "";
/*  4360 */         sub = "";
/*  4361 */         iva = "";
/*  4362 */         total = "";
/*  4363 */         cantidad = "";
/*  4364 */       } else if (!datos[2].equals("0")) {
/*  4365 */         destinos = this.con.regresaReg("empresa,calle,num,col,cp,ciudad,rfc,monto,letra", "emp_destinataria", "where clave_desti = " + datos[2], 9);
/*  4366 */         cantidad = destinos[8];
/*  4367 */         tons = "20.72 TONS.";
/*  4368 */         float totalC = Float.parseFloat(destinos[7]);
/*  4369 */         double subtotalC = totalC / 1.16D;
/*  4370 */         double ivaC = totalC - subtotalC;
/*       */         
/*  4372 */         iva = "" + ivaC;
/*       */         
/*  4374 */         String cant = "" + subtotalC;
/*  4375 */         String SUB = "";
/*  4376 */         boolean punto = false; int i;
/*  4377 */         for (i = 0; i < cant.length() && 
/*  4378 */           cant.charAt(i) != '.'; i++) {
/*  4379 */           punto = true;
/*  4380 */           SUB = SUB + SUB;
/*       */         } 
/*       */ 
/*       */ 
/*       */         
/*  4385 */         sub = SUB + ".00";
/*  4386 */         cant = iva;
/*  4387 */         SUB = "";
/*  4388 */         punto = false;
/*  4389 */         for (i = 0; i < cant.length() && 
/*  4390 */           cant.charAt(i) != '.'; i++) {
/*  4391 */           punto = true;
/*  4392 */           SUB = SUB + SUB;
/*       */         } 
/*       */ 
/*       */ 
/*       */         
/*  4397 */         iva = SUB + ".00";
/*  4398 */         total = "" + totalC + "0";
/*       */         
/*  4400 */         if (datos[1].equals("8") || datos[1].equals("18")) {
/*  4401 */           tons = "0";
/*  4402 */           tons = "";
/*  4403 */           sub = "";
/*  4404 */           iva = "";
/*  4405 */           total = "";
/*  4406 */           cantidad = "";
/*       */         } 
/*       */       } 
/*  4409 */       String pozo = String.valueOf(this.rSTableMetro1.getValueAt(indice, 14));
/*  4410 */       if (!pozo.equals("")) {
/*  4411 */         pozo = "POZO: " + String.valueOf(this.rSTableMetro1.getValueAt(indice, 17));
/*       */       }
/*  4413 */       String rem2 = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 13));
/*  4414 */       if (!rem2.equals("")) {
/*  4415 */         tons = "43.87 TONS";
/*       */       }
/*       */       
/*  4418 */       this.con.consultar("placas", "tracto", "where num_tracto = " + datos[6]);
/*  4419 */       String placasT = this.con.Campo;
/*  4420 */       this.con.consultar("placas", "remolque", "where num_rem = " + datos[7]);
/*  4421 */       String placasR = this.con.Campo;
/*  4422 */       String[] usuario = this.con.regresaReg("nombre,ap_pat,ap_mat", "empleados,usuarios", "where empleados.clave_emp = usuarios.num_emp and nombre_usu = '" + this.USUARIO + "'", 3);
/*  4423 */       String residuo = String.valueOf(this.rSTableMetro1.getValueAt(indice, 5));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  4451 */       String[] enviar = { FechaNormal, clientes[7], clientes[0], clientes[1] + " " + clientes[1], clientes[3], clientes[6], destinos[5], destinos[0], destinos[1] + " " + destinos[1], destinos[3], destinos[6], String.valueOf(this.rSTableMetro1.getValueAt(indice, 21)), residuo.toUpperCase(), String.valueOf(this.rSTableMetro1.getValueAt(indice, 15)), String.valueOf(this.rSTableMetro1.getValueAt(indice, 16)), tons, sub, iva, total, String.valueOf(this.rSTableMetro1.getValueAt(indice, 22)), pozo, datos[6], placasT, datos[7], placasR, cantidad, "Copia: " + usuario[0] + " " + usuario[1] + " " + usuario[2], String.valueOf(this.rSTableMetro1.getValueAt(indice, 0)), String.valueOf(this.rSTableMetro1.getValueAt(indice, 4)), datos[9], this.SEMARNAT, String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 13)), String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 14)), clientes[0] };
/*  4452 */       Imprimir im = new Imprimir();
/*  4453 */       im.recibeDatos(enviar);
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   private void jTextField3KeyReleased(KeyEvent evt) {
/*  4459 */     String cadena = this.jTextField3.getText();
/*  4460 */     if (!cadena.equals("")) {
/*  4461 */       if (this.presionado == null) {
/*  4462 */         this.presionado = new Presionado();
/*  4463 */         this.presionado.start();
/*       */       } else {
/*  4465 */         this.presionado.detenerFuera();
/*  4466 */         this.presionado = new Presionado();
/*  4467 */         this.presionado.start();
/*       */       } 
/*       */     } else {
/*  4470 */       this.jTextField3.setBackground(new Color(153, 255, 153));
/*       */     } 
/*       */   }
/*       */   private void jTextField4KeyReleased(KeyEvent evt) {
/*  4474 */     String cadena = this.jTextField4.getText();
/*  4475 */     if (!cadena.equals("")) {
/*  4476 */       if (this.presionado == null) {
/*  4477 */         this.presionado = new Presionado();
/*  4478 */         this.presionado.start();
/*       */       } else {
/*  4480 */         this.presionado.detenerFuera();
/*  4481 */         this.presionado = new Presionado();
/*  4482 */         this.presionado.start();
/*       */       } 
/*       */     } else {
/*  4485 */       this.jTextField4.setBackground(new Color(153, 255, 153));
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jLabel5MouseClicked(MouseEvent evt) {
/*  4490 */     this.jDateChooser4.setDate(this.fechaInicio);
/*  4491 */     this.jDateChooser5.setDate(this.fechaActual);
/*  4492 */     consultar();
/*       */   }
/*       */   
/*       */   private void jLabel5MouseEntered(MouseEvent evt) {
/*  4496 */     this.jLabel5.setForeground(new Color(153, 255, 153));
/*       */   }
/*       */   
/*       */   private void jLabel5MouseExited(MouseEvent evt) {
/*  4500 */     this.jLabel5.setForeground(new Color(15, 87, 51));
/*       */   }
/*       */   private void jLabel6MouseClicked(MouseEvent evt) {
/*  4503 */     this.jDateChooser4.setDate(this.fechaActual);
/*  4504 */     this.jDateChooser5.setDate(this.fechaActual);
/*  4505 */     consultar();
/*       */   }
/*       */   
/*       */   private void jLabel6MouseEntered(MouseEvent evt) {
/*  4509 */     this.jLabel6.setForeground(new Color(153, 255, 153));
/*       */   }
/*       */   
/*       */   private void jLabel6MouseExited(MouseEvent evt) {
/*  4513 */     this.jLabel6.setForeground(new Color(15, 87, 51));
/*       */   }
/*       */   
/*       */   private void jLabel7MouseClicked(MouseEvent evt) {
/*  4517 */     Calendar ca = Calendar.getInstance();
/*  4518 */     Calendar fecha = Calendar.getInstance();
/*  4519 */     int aa = fecha.get(1);
/*  4520 */     int mm = fecha.get(2);
/*  4521 */     int dd = fecha.get(5);
/*  4522 */     if (dd == 1) {
/*  4523 */       if (mm == 0) {
/*  4524 */         mm = 11;
/*  4525 */         aa--;
/*       */       } else {
/*  4527 */         mm--;
/*       */       } 
/*  4529 */       int diasTotal = diasDelMes(mm, aa);
/*  4530 */       dd = diasTotal;
/*       */     } else {
/*  4532 */       dd--;
/*       */     } 
/*  4534 */     mm++;
/*  4535 */     String año = "" + aa;
/*  4536 */     String mes = "" + mm;
/*  4537 */     String dia = "" + dd;
/*  4538 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/*  4539 */     String strFecha = año + "-" + año + "-" + mes;
/*       */     try {
/*  4541 */       this.jDateChooser4.setDate(formatoDelTexto.parse(strFecha));
/*  4542 */       this.jDateChooser5.setDate(formatoDelTexto.parse(strFecha));
/*  4543 */     } catch (ParseException ex) {
/*  4544 */       ex.printStackTrace();
/*       */     } 
/*  4546 */     consultar();
/*       */   }
/*       */   
/*       */   private void jLabel7MouseEntered(MouseEvent evt) {
/*  4550 */     this.jLabel7.setForeground(new Color(153, 255, 153));
/*       */   }
/*       */   
/*       */   private void jLabel7MouseExited(MouseEvent evt) {
/*  4554 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/*       */   }
/*       */   
/*       */   private void jComboBox16ActionPerformed(ActionEvent evt) {
/*  4558 */     if (this.jComboBox16.getItemCount() > 0 && this.PRIMERA == true) {
/*  4559 */       consultar();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jButton8ActionPerformed(ActionEvent evt) {
/*  4564 */     this.jCheckBox1.setSelected(false);
/*  4565 */     this.TIPOTRACTOR = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 16));
/*  4566 */     String fecha = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1));
/*  4567 */     String fechaCorta = fecha.substring(0, 10);
/*  4568 */     String FechaNormal = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/*       */     
/*  4570 */     String año = fechaCorta.substring(0, 4);
/*  4571 */     String mes = fechaCorta.substring(5, 7);
/*  4572 */     String dia = fechaCorta.substring(8, 10);
/*  4573 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  4574 */     String strFecha = dia + "-" + dia + "-" + mes;
/*  4575 */     Date fechaT = null;
/*  4576 */     Date fechaC = null;
/*  4577 */     String pago = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 21));
/*       */     try {
/*  4579 */       fechaT = formatoDelTexto.parse(strFecha);
/*  4580 */       this.jDateChooser1.setDate(fechaT);
/*  4581 */       this.jDateChooser6.setDate(fechaT);
/*  4582 */       this.jDateChooser3.setDate(fechaT);
/*  4583 */       fechaC = formatoDelTexto.parse("01-04-2010");
/*  4584 */     } catch (ParseException ex) {
/*  4585 */       ex.printStackTrace();
/*       */     } 
/*  4587 */     if (this.jDateChooser1.getDate().before(fechaC)) {
/*  4588 */       JOptionPane.showMessageDialog(this.padre, "No puedes complementar la guía porque es menor al 1° de Abril de 2010\n<html><b><font color=blue>Necesitas seleccionar otra guía para saldar.</font></html>", "Guía Saldada", 0, this.ADVER);
/*  4589 */     } else if (!pago.contains("Asignada Al Operador") && !pago.contains("Sólo Cargada") && !pago.contains("Por Timbrar")) {
/*  4590 */       JOptionPane.showMessageDialog(this.padre, "La guía que seleccionaste ya se encuentra en un estatus que no puedes modificar\nSólo puedes complementar guías con estatus <Asignada Al Operador>, <Sólo Cargada> ó <Por Timbrar>", "Guía Saldada", 0, this.ADVER);
/*       */     } else {
/*  4592 */       cargarVale();
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jTable3KeyReleased(KeyEvent evt) {
/*  4597 */     if (this.jComboBox8.getSelectedIndex() == 0) {
/*  4598 */       privilegios();
/*  4599 */       this.con.Campo = this.CAMPOSGENERALES.get("priv");
/*  4600 */       if (this.con.Campo.equals("SUPER USUARIO") || this.con.Campo.equals("JEFE DE TRÁFICO") || this.con.Campo.equals("TRÁFICO")) {
/*  4601 */         this.jButton4.setEnabled(true);
/*  4602 */         this.jButton8.setEnabled(true);
/*  4603 */         this.jButton2.setEnabled(true);
/*  4604 */         int indice = this.rSTableMetro1.getSelectedRow();
/*  4605 */         String rsp = String.valueOf(this.rSTableMetro1.getValueAt(indice, 18));
/*  4606 */         String ticket = String.valueOf(this.rSTableMetro1.getValueAt(indice, 19));
/*  4607 */         String ton = String.valueOf(this.rSTableMetro1.getValueAt(indice, 20));
/*  4608 */         String tipo = String.valueOf(this.rSTableMetro1.getValueAt(indice, 4));
/*  4609 */         if (!rsp.equals("")) {
/*  4610 */           this.jButton8.setEnabled(false);
/*  4611 */           this.jButton5.setEnabled(false);
/*       */         } 
/*  4613 */         if (!rsp.equals("") && ticket.equals("0") && ton.equals("0") && !tipo.contains("MOVIMIENTO EN FALSO") && !tipo.contains("MOVIMIENTO LATERAL")) {
/*  4614 */           this.jButton8.setEnabled(true);
/*  4615 */           this.jButton5.setEnabled(false);
/*       */         } 
/*  4617 */         if (this.jComboBox8.getSelectedIndex() != 0) {
/*  4618 */           this.jButton8.setEnabled(false);
/*  4619 */           this.jButton5.setEnabled(false);
/*       */         } 
/*       */         
/*  4622 */         if (this.USUARIO.equals("ALBERTO") || this.USUARIO.equals("PMARIO") || this.USUARIO.equals("JQUIROZ") || this.USUARIO.equals("TOMAS") || this.USUARIO.equals("JROBERTO")) {
/*  4623 */           this.jButton5.setEnabled(false);
/*  4624 */           this.jComboBox14.setEnabled(false);
/*  4625 */           this.jComboBox28.setEnabled(false);
/*       */         } 
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jLabel51MouseClicked(MouseEvent evt) {
/*  4632 */     this.jDialog3.setVisible(false);
/*       */   }
/*       */   
/*       */   private void jLabel90MouseClicked(MouseEvent evt) {
/*  4636 */     this.jTextArea5.setText("");
/*  4637 */     this.jDialog5.setVisible(true);
/*       */   }
/*       */   
/*       */   private void jLabel51MouseEntered(MouseEvent evt) {
/*  4641 */     this.jLabel51.setForeground(new Color(153, 255, 153));
/*       */   }
/*       */   
/*       */   private void jLabel51MouseExited(MouseEvent evt) {
/*  4645 */     this.jLabel51.setForeground(Color.RED);
/*       */   }
/*       */   
/*       */   private void jLabel90MouseEntered(MouseEvent evt) {
/*  4649 */     this.jLabel90.setForeground(new Color(153, 255, 153));
/*       */   }
/*       */   
/*       */   private void jLabel90MouseExited(MouseEvent evt) {
/*  4653 */     this.jLabel90.setForeground(Color.RED);
/*       */   }
/*       */   
/*       */   private void jButton44ActionPerformed(ActionEvent evt) {
/*  4657 */     int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas agregar el comentario?", "Agregar Comentario", 0, 3, this.PREG);
/*  4658 */     if (res == 0) {
/*  4659 */       String campo = this.DESCRIPCION + " - " + this.DESCRIPCION;
/*  4660 */       this.con.inserSinMsj("update llamadas_historicas set descrip = '" + campo.toUpperCase() + "' where num_guia = '" + this.jLabel13.getText() + "'");
/*  4661 */       this.jDialog5.setVisible(false);
/*  4662 */       verDatos();
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jButton45ActionPerformed(ActionEvent evt) {
/*  4667 */     this.jDialog5.setVisible(false);
/*       */   }
/*       */   
/*       */   private void jComboBox20ActionPerformed(ActionEvent evt) {
/*  4671 */     if (this.jComboBox1.getItemCount() > 0 && this.PRIMERA == true) {
/*  4672 */       consultar();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jComboBox21ActionPerformed(ActionEvent evt) {
/*  4677 */     if (this.jComboBox21.getSelectedIndex() == 0) {
/*  4678 */       this.jLabel20.setIcon((Icon)null);
/*  4679 */     } else if (this.jComboBox21.getSelectedIndex() == 1) {
/*  4680 */       this.jLabel20.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/matutino.png")));
/*  4681 */     } else if (this.jComboBox21.getSelectedIndex() == 2) {
/*  4682 */       this.jLabel20.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/nocturno.png")));
/*       */     } 
/*  4684 */     consultar();
/*       */   }
/*       */   
/*       */   private void jButton1ActionPerformed(ActionEvent evt) {
/*  4688 */     consultar();
/*       */   }
/*       */   
/*       */   private void jButton18ActionPerformed(ActionEvent evt) {
/*  4692 */     ImprimirViajes imprimir = new ImprimirViajes();
/*  4693 */     imprimir.recibeDatos();
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   private void jButton19ActionPerformed(ActionEvent evt) {
/*  4703 */     this.jButton46.setEnabled(true);
/*  4704 */     this.jLabel92.setText("Columnas a Agregar");
/*  4705 */     this.jRadioButton1.setVisible(true);
/*  4706 */     this.jRadioButton2.setVisible(true);
/*       */     
/*  4708 */     Date fecha1 = this.jDateChooser4.getDate();
/*  4709 */     Date fecha2 = this.jDateChooser5.getDate();
/*       */     
/*  4711 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  4712 */     String cadenaFecha = "";
/*  4713 */     cadenaFecha = formato.format(fecha1);
/*  4714 */     String AÑO = cadenaFecha.substring(0, 4);
/*  4715 */     String MES = cadenaFecha.substring(4, 6);
/*  4716 */     String DIA = cadenaFecha.substring(6, 8);
/*  4717 */     String fechaCompleta1 = DIA + "-" + DIA + "-" + MES;
/*       */     
/*  4719 */     cadenaFecha = formato.format(fecha2);
/*  4720 */     AÑO = cadenaFecha.substring(0, 4);
/*  4721 */     MES = cadenaFecha.substring(4, 6);
/*  4722 */     DIA = cadenaFecha.substring(6, 8);
/*  4723 */     this.ARCHIVO = "Rep " + fechaCompleta1 + " al " + DIA + "-" + MES + "-" + AÑO + ".pdf";
/*       */     
/*  4725 */     CrearPDF crear = new CrearPDF();
/*  4726 */     this.jTextField28.setText("Archivos/" + this.ARCHIVO);
/*  4727 */     this.jDialog7.setVisible(true);
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   private void jButton20ActionPerformed(ActionEvent evt) {
/*  4738 */     this.jDialog6.setVisible(false);
/*  4739 */     this.CANTTOTALES = new int[18];
/*  4740 */     JCheckBox[] colum = { this.jCheckBox2, this.jCheckBox3, this.jCheckBox4, this.jCheckBox5, this.jCheckBox6, this.jCheckBox13, this.jCheckBox7, this.jCheckBox8, this.jCheckBox9, this.jCheckBox10, this.jCheckBox11, this.jCheckBox22, this.jCheckBox30, this.jCheckBox12, this.jCheckBox31, this.jCheckBox14, this.jCheckBox15, this.jCheckBox16, this.jCheckBox17, this.jCheckBox18, this.jCheckBox19, this.jCheckBox20, this.jCheckBox21, this.jCheckBox24, this.jCheckBox25, this.jCheckBox23, this.jCheckBox26, this.jCheckBox28, this.jCheckBox29, this.jCheckBox27 };
/*       */     
/*  4742 */     for (int i = 0; i < colum.length; i++) {
/*  4743 */       System.out.println("columnas " + i + " " + colum[i].getText());
/*       */     }
/*       */     
/*  4746 */     String[] nombres = { "GUÍA", "FECHA", "SERV", "RESIDUO", "CLIE", "ORIGEN", "DESTINO", "T", "PLAC", "R1", "PLAC1", "R2", "PLAC2", "EQUIPO", "PLATAFORMA", "POZO", "HRSP", "TICKET", "TON", "TIPO", "OPE", "AUT", "EST", "COMEN", "ESTATUS", "MANIF", "PED", "REP", "PRE", "FACTURA" };
/*  4747 */     this.LINEAS = new String[this.rSTableMetro1.getRowCount()];
/*  4748 */     int columnas = 0; int j;
/*  4749 */     for (j = 0; j < colum.length; j++) {
/*  4750 */       if (colum[j].isSelected()) {
/*  4751 */         columnas++;
/*       */       }
/*       */     } 
/*  4754 */     this.LETRASMAX = new int[columnas];
/*  4755 */     this.NOMBRECOL = new String[columnas];
/*       */     
/*  4757 */     this.REGIS = new String[this.rSTableMetro1.getRowCount()][columnas];
/*  4758 */     for (j = 0; j < this.rSTableMetro1.getRowCount(); j++) {
/*  4759 */       int cuenta = 0;
/*  4760 */       for (int k = 0; k < this.rSTableMetro1.getColumnCount(); k++) {
/*  4761 */         String tipo = String.valueOf(this.rSTableMetro1.getValueAt(j, k));
/*  4762 */         if (tipo.equals("GÓNDOLA") || tipo.equals("GONDOLA")) {
/*  4763 */           this.CANTTOTALES[2] = this.CANTTOTALES[2] + 1;
/*  4764 */         } else if (tipo.equals("PIPA")) {
/*  4765 */           this.CANTTOTALES[3] = this.CANTTOTALES[3] + 1;
/*       */         } 
/*  4767 */         if (colum[k].isSelected()) {
/*  4768 */           String col = String.valueOf(this.rSTableMetro1.getValueAt(j, k));
/*  4769 */           if (k == 1) {
/*  4770 */             String fecha = col;
/*  4771 */             String fechaCorta = fecha.substring(0, 10);
/*  4772 */             col = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/*       */           } 
/*       */           
/*  4775 */           if (col.equals("FLETE")) {
/*  4776 */             this.CANTTOTALES[0] = this.CANTTOTALES[0] + 1;
/*  4777 */           } else if (col.equals("RENTA")) {
/*  4778 */             this.CANTTOTALES[1] = this.CANTTOTALES[1] + 1;
/*  4779 */           } else if (col.equals("SERVICIO INTEGRAL")) {
/*  4780 */             col = "SERV INT";
/*  4781 */             this.CANTTOTALES[14] = this.CANTTOTALES[14] + 1;
/*  4782 */           } else if (col.equals("SERVICIO DE RETRO")) {
/*  4783 */             col = "RETRO";
/*  4784 */             this.CANTTOTALES[4] = this.CANTTOTALES[4] + 1;
/*       */           } 
/*       */ 
/*       */           
/*  4788 */           if (k == 3) {
/*  4789 */             if (col.equals("REBABA")) {
/*  4790 */               this.CANTTOTALES[13] = this.CANTTOTALES[13] + 1;
/*  4791 */             } else if (col.equals("ESCAMA DE LA LAMINACION")) {
/*  4792 */               col = "ESCAMA";
/*  4793 */               this.CANTTOTALES[9] = this.CANTTOTALES[9] + 1;
/*  4794 */             } else if (col.equals("PUZOLANA")) {
/*  4795 */               col = "PUZOLANA";
/*  4796 */               this.CANTTOTALES[10] = this.CANTTOTALES[10] + 1;
/*  4797 */             } else if (col.equals("CAL VIVA")) {
/*  4798 */               col = "CAL VIVA";
/*  4799 */               this.CANTTOTALES[6] = this.CANTTOTALES[6] + 1;
/*  4800 */             } else if (col.equals("RECORTE DE PERFORACION")) {
/*  4801 */               col = "R DE PERFORACION";
/*  4802 */               this.CANTTOTALES[11] = this.CANTTOTALES[11] + 1;
/*  4803 */             } else if (col.contains("CHATARRA")) {
/*  4804 */               col = "CHATARRA";
/*  4805 */               this.CANTTOTALES[7] = this.CANTTOTALES[7] + 1;
/*  4806 */             } else if (col.equals("COKE DE PETROLEO")) {
/*  4807 */               col = "COKE";
/*  4808 */               this.CANTTOTALES[8] = this.CANTTOTALES[8] + 1;
/*  4809 */             } else if (col.equals("FLUORITA")) {
/*       */               
/*  4811 */               this.CANTTOTALES[13] = this.CANTTOTALES[13] + 1;
/*       */             
/*       */             }
/*       */             else {
/*       */ 
/*       */               
/*  4817 */               this.CANTTOTALES[15] = this.CANTTOTALES[15] + 1;
/*       */             } 
/*  4819 */           } else if (col.equals("FLUIDO RECUPERADO")) {
/*  4820 */             col = "FLUID RECUP";
/*  4821 */           } else if (col.equals("FLUIDO RECUPERADO C/TRAZAS DE ACEITE")) {
/*  4822 */             col = "FLUID RECUP/TRAZAS";
/*  4823 */           } else if (col.equals("MOVIMIENTO EN FALSO")) {
/*  4824 */             col = "MOV FALSO";
/*  4825 */           } else if (col.equals("MOVIMIENTO INTERNO")) {
/*  4826 */             col = "MOV INTER";
/*  4827 */           } else if (col.equals("MOVIMIENTO LATERAL")) {
/*  4828 */             col = "MOV LATERAL";
/*  4829 */           } else if (col.equals("TOLVA PRESURIZADA")) {
/*  4830 */             col = "TOLVA PRESU";
/*  4831 */           } else if (col.equals("CUELLO DE GANZO")) {
/*  4832 */             col = "C GANZO";
/*  4833 */           } else if (col.equals("CONTENEDOR MARINO")) {
/*  4834 */             col = "C MARINO";
/*  4835 */           } else if (col.equals("EXCAVADORA ORUGA")) {
/*  4836 */             col = "E ORUGA";
/*  4837 */           } else if (col.equals("PRESAS METÁLICAS")) {
/*  4838 */             col = "P METÁLICAS";
/*  4839 */           } else if (col.equals("PRESIÓN Y VACÍO")) {
/*  4840 */             col = "PYV";
/*  4841 */           } else if (col.equals("PLATAFORMA")) {
/*  4842 */             col = "PLAT";
/*  4843 */           } else if (col.equals("PORTA CONTENEDORES")) {
/*  4844 */             col = "PORTA CONTE";
/*  4845 */           } else if (col.equals("TIRO DIRECTO")) {
/*  4846 */             col = "T DIREC";
/*  4847 */           } else if (col.equals("TOLVA GRANELERA")) {
/*  4848 */             col = "T GRANELERA";
/*  4849 */           } else if (col.equals("TOLVA DE ALUMINIO")) {
/*  4850 */             col = "T ALUMNIO";
/*  4851 */           } else if (col.equals("TOLVA DE ACERO INOXIDABLE")) {
/*  4852 */             col = "T DE ACE INOX";
/*  4853 */           } else if (col.equals("CUELLO DE GANZO")) {
/*  4854 */             col = "C GANZO";
/*       */           } 
/*       */           
/*  4857 */           this.REGIS[j][cuenta] = col;
/*  4858 */           this.LINEAS[j] = this.LINEAS[j] + this.LINEAS[j] + " ";
/*  4859 */           int conLetra = this.LETRASMAX[cuenta];
/*  4860 */           this.NOMBRECOL[cuenta] = nombres[k];
/*  4861 */           if (conLetra < col.length() + 2) {
/*  4862 */             this.LETRASMAX[cuenta] = col.length() + 2;
/*       */           }
/*  4864 */           cuenta++;
/*       */         } 
/*       */       } 
/*       */     } 
/*  4868 */     for (j = 0; j < this.LETRASMAX.length; j++) {
/*  4869 */       if (this.LETRASMAX[j] == 3) {
/*  4870 */         this.LETRASMAX[j] = 14;
/*       */       }
/*  4872 */       if (this.LETRASMAX[j] == 6) {
/*  4873 */         this.LETRASMAX[j] = 7;
/*       */       }
/*       */     } 
/*  4876 */     if (!this.ENVIARCORREO) {
/*  4877 */       ImprimirGuias imp = new ImprimirGuias();
/*  4878 */       imp.recibeDatos();
/*       */     } else {
/*  4880 */       CrearPDF crear = new CrearPDF();
/*  4881 */       this.jTextField28.setText("Archivos/" + this.ARCHIVO);
/*  4882 */       this.jDialog7.setVisible(true);
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   private void jButton21ActionPerformed(ActionEvent evt) {
/*  4888 */     this.jDialog6.setVisible(false);
/*       */   }
/*       */   
/*       */   private void jButton46ActionPerformed(ActionEvent evt) {
/*  4892 */     if (this.jTextField26.getText().equals("")) {
/*  4893 */       JOptionPane.showMessageDialog(this.jDialog7, "Necesitas agregar una cuenta de correo para poder enviar la información", "Falta Correo", 0, this.ADVER);
/*       */     } else {
/*  4895 */       if (this.jTextField26.getText().charAt(this.jTextField26.getText().length() - 1) != ';') {
/*  4896 */         this.jTextField26.setText(this.jTextField26.getText() + ";");
/*       */       }
/*  4898 */       this.jButton46.setEnabled(false);
/*  4899 */       String cad = this.jTextField26.getText();
/*  4900 */       int dir = 0;
/*  4901 */       for (int i = 0; i < cad.length(); i++) {
/*  4902 */         if (cad.charAt(i) == ';') {
/*  4903 */           dir++;
/*       */         }
/*       */       } 
/*  4906 */       this.DIRECCIONES = new String[dir];
/*  4907 */       int cont = 0;
/*  4908 */       String correo = ""; int j;
/*  4909 */       for (j = 0; j < cad.length(); j++) {
/*  4910 */         char valor = cad.charAt(j);
/*  4911 */         if (valor != ';') {
/*  4912 */           correo = correo + correo;
/*       */         } else {
/*  4914 */           this.DIRECCIONES[cont] = correo;
/*  4915 */           cont++;
/*  4916 */           correo = "";
/*       */         } 
/*       */       } 
/*  4919 */       this.jLabel25.setVisible(true);
/*  4920 */       this.espera = new Esperando();
/*  4921 */       for (j = 0; j < this.DIRECCIONES.length; j++) {
/*  4922 */         this.encontrado = this.con.consultar("correo", "direcciones", "where nombre_usu = '" + this.USUARIO + "' and correo = '" + this.DIRECCIONES[j] + "'");
/*  4923 */         if (!this.encontrado) {
/*  4924 */           this.con.inserSinMsj("insert into direcciones(nombre_usu,correo)values('" + this.USUARIO + "','" + this.DIRECCIONES[j] + "')");
/*       */         }
/*       */       } 
/*  4927 */       this.espera.start();
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jButton47ActionPerformed(ActionEvent evt) {
/*  4932 */     this.jDialog7.setVisible(false);
/*       */   }
/*       */   
/*       */   private void jButton3ActionPerformed(ActionEvent evt) {
/*  4936 */     Point punto = this.jDialog7.getLocation();
/*  4937 */     this.jDialog8.setLocation(punto.x + 830, punto.y);
/*  4938 */     consultarDir();
/*  4939 */     this.jDialog8.setVisible(true);
/*       */   }
/*       */   
/*       */   private void jList1MouseClicked(MouseEvent evt) {
/*  4943 */     if (evt.getClickCount() == 2) {
/*  4944 */       String dir = String.valueOf(this.jList1.getSelectedValue());
/*  4945 */       this.jTextField26.setText(this.jTextField26.getText() + this.jTextField26.getText() + ";");
/*  4946 */       this.jDialog8.setVisible(false);
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jMenuItem1ActionPerformed(ActionEvent evt) {
/*  4951 */     String correo = this.jList1.getSelectedValue().toString();
/*  4952 */     this.con.eliminar2("direcciones", "where nombre_usu = '" + this.USUARIO + "' and correo = '" + correo + "'");
/*  4953 */     this.jDialog8.setVisible(false);
/*       */   }
/*       */   
/*       */   private void jButton23ActionPerformed(ActionEvent evt) {
/*  4957 */     this.jDialog10.setVisible(false);
/*       */   }
/*       */   
/*       */   private void jButton22ActionPerformed(ActionEvent evt) {
/*  4961 */     this.jDialog10.setVisible(true);
/*       */   }
/*       */   
/*       */   private void jLabel12MouseEntered(MouseEvent evt) {
/*  4965 */     this.jLabel12.setForeground(Color.RED);
/*       */   }
/*       */   
/*       */   private void jLabel12MouseExited(MouseEvent evt) {
/*  4969 */     this.jLabel12.setForeground(Color.BLUE);
/*       */   }
/*       */   
/*       */   private void jLabel12MouseClicked(MouseEvent evt) {
/*  4973 */     int res = JOptionPane.showConfirmDialog(this.padre, this.jPanel21, "Saldar Guía", 0, 3, this.PREG);
/*  4974 */     if (res == 0) {
/*  4975 */       this.con.inserSinMsj("update guias set num_vale='" + String.valueOf(this.jComboBox27.getSelectedItem()) + "', estatus ='<Pagada Al Operador>' where num_guia = '" + this.jTextField5.getText() + "'");
/*  4976 */       this.jDialog2.setVisible(false);
/*  4977 */       consultar();
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jComboBox27ActionPerformed(ActionEvent evt) {
/*  4982 */     if (this.jComboBox27.getItemCount() > 0 && 
/*  4983 */       this.INFORMACION != null) {
/*  4984 */       this.jLabel97.setText(this.INFORMACION[this.jComboBox27.getSelectedIndex()]);
/*       */     }
/*       */   }
/*       */ 
/*       */   
/*       */   private void jTextField1ActionPerformed(ActionEvent evt) {
/*  4990 */     consultar();
/*       */   }
/*       */   
/*       */   private void jTextField2ActionPerformed(ActionEvent evt) {
/*  4994 */     consultar();
/*       */   }
/*       */   
/*       */   private void jTextField3ActionPerformed(ActionEvent evt) {
/*  4998 */     consultar();
/*       */   }
/*       */   
/*       */   private void jTextField4ActionPerformed(ActionEvent evt) {
/*  5002 */     consultar();
/*       */   }
/*       */   
/*       */   private void jComboBox30ActionPerformed(ActionEvent evt) {
/*  5006 */     consultar();
/*       */   }
/*       */   
/*       */   private void jComboBox31ActionPerformed(ActionEvent evt) {
/*  5010 */     if (this.PRIMERA == true) {
/*  5011 */       consultar();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jButton9ActionPerformed(ActionEvent evt) {
/*  5016 */     int ind = this.rSTableMetro1.getSelectedRow();
/*  5017 */     if (ind < 0) {
/*  5018 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una guía para poder generar el comprobante fiscal", "Selecciona una guía", 0, this.ADVER);
/*       */     } else {
/*  5020 */       activarComplemento();
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   private void jComboBox36ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jButton16ActionPerformed(ActionEvent evt) {
/*  5029 */     consultar();
/*       */   }
/*       */   
/*       */   private void jLabel172MouseClicked(MouseEvent evt) {
/*  5033 */     Calendar fecha = this.jDateChooser9.getCalendar();
/*  5034 */     int aa = fecha.get(1);
/*  5035 */     int mm = fecha.get(2);
/*  5036 */     int dd = fecha.get(5);
/*  5037 */     if (dd == 1) {
/*  5038 */       if (mm == 0) {
/*  5039 */         mm = 11;
/*  5040 */         aa--;
/*       */       } else {
/*  5042 */         mm--;
/*       */       } 
/*  5044 */       int diasTotal = diasDelMes(mm, aa);
/*  5045 */       dd = diasTotal;
/*       */     } else {
/*  5047 */       dd--;
/*       */     } 
/*  5049 */     mm++;
/*  5050 */     String año = "" + aa;
/*  5051 */     String mes = "" + mm;
/*  5052 */     String dia = "" + dd;
/*  5053 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/*  5054 */     String strFecha = año + "-" + año + "-" + mes;
/*       */     try {
/*  5056 */       this.jDateChooser9.setDate(formatoDelTexto.parse(strFecha));
/*  5057 */       this.jDateChooser10.setDate(formatoDelTexto.parse(strFecha));
/*  5058 */     } catch (ParseException ex) {
/*  5059 */       ex.printStackTrace();
/*       */     } 
/*  5061 */     consultar();
/*       */   }
/*       */   
/*       */   private void jLabel172MouseEntered(MouseEvent evt) {
/*  5065 */     this.jLabel172.setForeground(new Color(153, 255, 153));
/*  5066 */     this.jLabel172.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-gris.png")));
/*       */   }
/*       */   
/*       */   private void jLabel172MouseExited(MouseEvent evt) {
/*  5070 */     this.jLabel172.setForeground(new Color(15, 87, 51));
/*  5071 */     this.jLabel172.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-left-otra.png")));
/*       */   }
/*       */   
/*       */   private void jLabel103MouseClicked(MouseEvent evt) {
/*  5075 */     this.jDateChooser9.setDate(this.fechaActual);
/*  5076 */     this.jDateChooser10.setDate(this.fechaActual);
/*  5077 */     consultar();
/*       */   }
/*       */   
/*       */   private void jLabel103MouseEntered(MouseEvent evt) {
/*  5081 */     this.jLabel103.setForeground(new Color(153, 255, 153));
/*  5082 */     this.jLabel103.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked-gris.png")));
/*       */   }
/*       */   
/*       */   private void jLabel103MouseExited(MouseEvent evt) {
/*  5086 */     this.jLabel103.setForeground(new Color(15, 87, 51));
/*  5087 */     this.jLabel103.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/radio-checked.png")));
/*       */   }
/*       */   
/*       */   private void jLabel173MouseClicked(MouseEvent evt) {
/*  5091 */     Calendar calendar = this.jDateChooser9.getCalendar();
/*  5092 */     calendar.setTime(this.jDateChooser4.getDate());
/*  5093 */     calendar.add(6, 1);
/*  5094 */     this.jDateChooser9.setCalendar(calendar);
/*  5095 */     this.jDateChooser10.setCalendar(calendar);
/*  5096 */     consultar();
/*       */   }
/*       */   
/*       */   private void jLabel173MouseEntered(MouseEvent evt) {
/*  5100 */     this.jLabel173.setForeground(new Color(153, 255, 153));
/*  5101 */     this.jLabel173.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-gris.png")));
/*       */   }
/*       */   
/*       */   private void jLabel173MouseExited(MouseEvent evt) {
/*  5105 */     this.jLabel173.setForeground(new Color(15, 87, 51));
/*  5106 */     this.jLabel173.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-otra.png")));
/*       */   }
/*       */   
/*       */   private void jComboBox37ActionPerformed(ActionEvent evt) {
/*  5110 */     int v = this.jComboBox37.getSelectedIndex();
/*  5111 */     if (v == 0) {
/*  5112 */       this.jDateChooser9.setEnabled(true);
/*  5113 */       this.jDateChooser10.setEnabled(true);
/*  5114 */       this.jComboBox36.setEnabled(false);
/*       */     } else {
/*  5116 */       this.jDateChooser9.setEnabled(false);
/*  5117 */       this.jDateChooser10.setEnabled(false);
/*  5118 */       this.jComboBox36.setEnabled(true);
/*       */     } 
/*  5120 */     if (this.PRIMERA) {
/*  5121 */       consultar();
/*       */     }
/*       */   }
/*       */   
/*       */   private void materialButton40ActionPerformed(ActionEvent evt) {
/*  5126 */     int ind = this.rSTableMetro1.getSelectedRow();
/*       */     try {
/*  5128 */       crearGuia(this.rSTableMetro1.getValueAt(ind, 0).toString());
/*  5129 */     } catch (IOException ex) {
/*  5130 */       Logger.getLogger(ModificarGuias.class.getName()).log(Level.SEVERE, (String)null, ex);
/*       */     } 
/*  5132 */     JOptionPane.showMessageDialog(this.jDialog2, "El comprobante de traslado se ha generado correctamente.", "Comprobante generado", 0, this.INFO);
/*  5133 */     this.jDialog30.setVisible(false);
/*       */   }
/*       */   
/*       */   private void materialButton41ActionPerformed(ActionEvent evt) {
/*  5137 */     String dir = direccion();
/*  5138 */     System.out.println(dir);
/*  5139 */     this.RUTA = dir;
/*       */     
/*  5141 */     int ind = this.rSTableMetro1.getSelectedRow();
/*       */     try {
/*  5143 */       crearGuia(this.rSTableMetro1.getValueAt(ind, 0).toString());
/*  5144 */     } catch (IOException ex) {
/*  5145 */       Logger.getLogger(ModificarGuias.class.getName()).log(Level.SEVERE, (String)null, ex);
/*       */     } 
/*  5147 */     JOptionPane.showMessageDialog(this.jDialog2, "El comprobante de traslado se ha generado correctamente.", "Comprobante generado", 0, this.INFO);
/*       */     
/*  5149 */     this.jDialog30.setVisible(false);
/*  5150 */     this.RUTA = this.RUTATEMP;
/*       */   }
/*       */   
/*       */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/*  5154 */     if (evt.getClickCount() == 2) {
/*  5155 */       String guia = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString();
/*  5156 */       this.con.consultar("claveUnidadSat", "guias", "where num_guia= '" + guia + "'");
/*  5157 */       if (this.con.Campo.equals("")) {
/*  5158 */         verNuevaGuia(guia);
/*       */       } else {
/*  5160 */         verDatos();
/*       */       } 
/*       */     } 
/*  5163 */     if (this.jComboBox8.getSelectedIndex() == 0) {
/*  5164 */       privilegios();
/*  5165 */       if (this.DEPARTAMENTO.equals("SUPER USUARIO") || this.DEPARTAMENTO.equals("JEFE DE TRÁFICO") || this.DEPARTAMENTO.equals("TRÁFICO") || this.DEPARTAMENTO.equals("GERENTE DE OPERACIONES") || this.DEPARTAMENTO.equals("LIQUIDACIONES")) {
/*  5166 */         this.jButton4.setEnabled(true);
/*  5167 */         this.jButton8.setEnabled(true);
/*  5168 */         this.jButton2.setEnabled(true);
/*  5169 */         this.jButton9.setEnabled(true);
/*  5170 */         this.jButton24.setEnabled(true);
/*  5171 */         this.jButton25.setEnabled(true);
/*  5172 */         this.jButton26.setEnabled(true);
/*  5173 */         int indice = this.rSTableMetro1.getSelectedRow();
/*  5174 */         String rsp = String.valueOf(this.rSTableMetro1.getValueAt(indice, 13));
/*  5175 */         String ticket = String.valueOf(this.rSTableMetro1.getValueAt(indice, 14));
/*       */         
/*  5177 */         String tipo = String.valueOf(this.rSTableMetro1.getValueAt(indice, 2));
/*  5178 */         if (!rsp.equals("")) {
/*  5179 */           this.jButton8.setEnabled(false);
/*  5180 */           this.jButton5.setEnabled(false);
/*       */         } 
/*  5182 */         if (!rsp.equals("") && ticket.equals("0") && !tipo.contains("MOVIMIENTO EN FALSO") && !tipo.contains("MOVIMIENTO LATERAL")) {
/*  5183 */           this.jButton8.setEnabled(true);
/*  5184 */           this.jButton5.setEnabled(false);
/*       */         } 
/*  5186 */         if (this.jComboBox8.getSelectedIndex() != 0) {
/*  5187 */           this.jButton8.setEnabled(false);
/*  5188 */           this.jButton5.setEnabled(false);
/*       */         } 
/*       */         
/*  5191 */         if (this.USUARIO.equals("ALBERTO") || this.USUARIO.equals("PMARIO") || this.USUARIO.equals("JQUIROZ") || this.USUARIO.equals("RTOMAS") || this.USUARIO.equals("JROBERTO") || this.USUARIO.equals("SRAMON") || this.USUARIO.equals("SRAMON1") || this.USUARIO.equals("CESAR01")) {
/*  5192 */           this.jButton5.setEnabled(false);
/*  5193 */           this.jComboBox14.setEnabled(false);
/*  5194 */           this.jComboBox28.setEnabled(false);
/*  5195 */           this.jButton26.setEnabled(true);
/*       */         } 
/*       */         
/*  5198 */         if (this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 21).toString().contains("Sólo Cargada")) {
/*  5199 */           this.jButton8.setEnabled(true);
/*       */         }
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   private void rSTableMetro1KeyReleased(KeyEvent evt) {
/*  5206 */     if (this.jComboBox8.getSelectedIndex() == 0) {
/*  5207 */       privilegios();
/*  5208 */       this.con.consultar("priv", "usuarios", "where nombre_usu = '" + this.USUARIO + "'");
/*  5209 */       if (this.con.Campo.equals("SUPER USUARIO") || this.con.Campo.equals("JEFE DE TRÁFICO") || this.con.Campo.equals("TRÁFICO")) {
/*  5210 */         this.jButton4.setEnabled(true);
/*  5211 */         this.jButton8.setEnabled(true);
/*  5212 */         this.jButton2.setEnabled(true);
/*  5213 */         int indice = this.rSTableMetro1.getSelectedRow();
/*  5214 */         String rsp = String.valueOf(this.rSTableMetro1.getValueAt(indice, 18));
/*  5215 */         String ticket = String.valueOf(this.rSTableMetro1.getValueAt(indice, 19));
/*  5216 */         String ton = String.valueOf(this.rSTableMetro1.getValueAt(indice, 20));
/*  5217 */         String tipo = String.valueOf(this.rSTableMetro1.getValueAt(indice, 4));
/*  5218 */         if (!rsp.equals("")) {
/*  5219 */           this.jButton8.setEnabled(false);
/*  5220 */           this.jButton5.setEnabled(false);
/*       */         } 
/*  5222 */         if (!rsp.equals("") && ticket.equals("0") && ton.equals("0") && !tipo.contains("MOVIMIENTO EN FALSO") && !tipo.contains("MOVIMIENTO LATERAL")) {
/*  5223 */           this.jButton8.setEnabled(true);
/*  5224 */           this.jButton5.setEnabled(false);
/*       */         } 
/*  5226 */         if (this.jComboBox8.getSelectedIndex() != 0) {
/*  5227 */           this.jButton8.setEnabled(false);
/*  5228 */           this.jButton5.setEnabled(false);
/*       */         } 
/*       */         
/*  5231 */         if (this.USUARIO.equals("ALBERTO") || this.USUARIO.equals("PMARIO") || this.USUARIO.equals("JQUIROZ") || this.USUARIO.equals("TOMAS") || this.USUARIO.equals("JROBERTO")) {
/*  5232 */           this.jButton5.setEnabled(false);
/*  5233 */           this.jComboBox14.setEnabled(false);
/*  5234 */           this.jComboBox28.setEnabled(false);
/*       */         } 
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jButton24ActionPerformed(ActionEvent evt) {
/*  5241 */     this.actualizado = false;
/*  5242 */     GuiasForm form = new GuiasForm(this.USUARIO, this.padre, this.CAMPOSGENERALES, "NUEVA", this.actualizado, this.LISTACODIGOS, this.CODIGOSP, "");
/*  5243 */     this.actualizado = form.actualizado;
/*  5244 */     if (this.actualizado) {
/*  5245 */       consultar();
/*       */     }
/*       */   }
/*       */   
/*       */   private void jTextField11KeyReleased(KeyEvent evt) {
/*  5250 */     String cadena = this.jTextField11.getText();
/*  5251 */     if (!cadena.equals("")) {
/*  5252 */       if (this.presionado == null) {
/*  5253 */         this.presionado = new Presionado();
/*  5254 */         this.presionado.start();
/*       */       } else {
/*  5256 */         this.presionado.detenerFuera();
/*  5257 */         this.presionado = new Presionado();
/*  5258 */         this.presionado.start();
/*       */       } 
/*       */     } else {
/*  5261 */       this.jTextField11.setBackground(new Color(153, 255, 153));
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jTextField12KeyReleased(KeyEvent evt) {
/*  5266 */     String cadena = this.jTextField12.getText();
/*  5267 */     if (!cadena.equals("")) {
/*  5268 */       if (this.presionado == null) {
/*  5269 */         this.presionado = new Presionado();
/*  5270 */         this.presionado.start();
/*       */       } else {
/*  5272 */         this.presionado.detenerFuera();
/*  5273 */         this.presionado = new Presionado();
/*  5274 */         this.presionado.start();
/*       */       } 
/*       */     } else {
/*  5277 */       this.jTextField12.setBackground(new Color(153, 255, 153));
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jTextField37KeyReleased(KeyEvent evt) {
/*  5282 */     String cadena = this.jTextField37.getText();
/*  5283 */     if (!cadena.equals("")) {
/*  5284 */       if (this.presionado == null) {
/*  5285 */         this.presionado = new Presionado();
/*  5286 */         this.presionado.start();
/*       */       } else {
/*  5288 */         this.presionado.detenerFuera();
/*  5289 */         this.presionado = new Presionado();
/*  5290 */         this.presionado.start();
/*       */       } 
/*       */     } else {
/*  5293 */       this.jTextField37.setBackground(new Color(153, 255, 153));
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jTextField38KeyReleased(KeyEvent evt) {
/*  5298 */     String cadena = this.jTextField38.getText();
/*  5299 */     if (!cadena.equals("")) {
/*  5300 */       if (this.presionado == null) {
/*  5301 */         this.presionado = new Presionado();
/*  5302 */         this.presionado.start();
/*       */       } else {
/*  5304 */         this.presionado.detenerFuera();
/*  5305 */         this.presionado = new Presionado();
/*  5306 */         this.presionado.start();
/*       */       } 
/*       */     } else {
/*  5309 */       this.jTextField38.setBackground(new Color(153, 255, 153));
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jTextField39KeyReleased(KeyEvent evt) {
/*  5314 */     String cadena = this.jTextField39.getText();
/*  5315 */     if (!cadena.equals("")) {
/*  5316 */       if (this.presionado == null) {
/*  5317 */         this.presionado = new Presionado();
/*  5318 */         this.presionado.start();
/*       */       } else {
/*  5320 */         this.presionado.detenerFuera();
/*  5321 */         this.presionado = new Presionado();
/*  5322 */         this.presionado.start();
/*       */       } 
/*       */     } else {
/*  5325 */       this.jTextField39.setBackground(new Color(153, 255, 153));
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jTextField40KeyReleased(KeyEvent evt) {
/*  5330 */     String cadena = this.jTextField40.getText();
/*  5331 */     if (!cadena.equals("")) {
/*  5332 */       if (this.presionado == null) {
/*  5333 */         this.presionado = new Presionado();
/*  5334 */         this.presionado.start();
/*       */       } else {
/*  5336 */         this.presionado.detenerFuera();
/*  5337 */         this.presionado = new Presionado();
/*  5338 */         this.presionado.start();
/*       */       } 
/*       */     } else {
/*  5341 */       this.jTextField40.setBackground(new Color(153, 255, 153));
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jLabel33MouseDragged(MouseEvent evt) {
/*  5346 */     int x = evt.getXOnScreen();
/*  5347 */     int y = evt.getYOnScreen();
/*  5348 */     this.jDialog12.setLocation(x - this.xx, y - this.xy);
/*       */   }
/*       */   
/*       */   private void jLabel33MouseClicked(MouseEvent evt) {
/*  5352 */     this.xx = evt.getX();
/*  5353 */     this.xy = evt.getY();
/*       */   }
/*       */   
/*       */   private void jLabel128MouseClicked(MouseEvent evt) {
/*  5357 */     this.jDialog12.setVisible(false);
/*       */   }
/*       */   
/*       */   private void jLabel128MouseEntered(MouseEvent evt) {
/*  5361 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-2-close.png")));
/*       */   }
/*       */   
/*       */   private void jLabel128MouseExited(MouseEvent evt) {
/*  5365 */     this.jLabel128.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/2017/Prueba/001-close.png")));
/*       */   }
/*       */   
/*       */   private void materialButton38ActionPerformed(ActionEvent evt) {
/*  5369 */     this.jDialog12.setVisible(false);
/*       */   }
/*       */   
/*       */   private void jComboBox18ActionPerformed(ActionEvent evt) {
/*  5373 */     this.jTextField32.setEnabled(true);
/*  5374 */     this.jTextField44.setText(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 25).toString());
/*  5375 */     this.jTextField45.setText(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 26).toString());
/*  5376 */     if (this.jComboBox18.getSelectedIndex() == 0) {
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  5411 */       this.jComboBox19.setSelectedIndex(0);
/*  5412 */       this.jTextField7.setText(String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 5)));
/*       */       
/*  5414 */       this.jComboBox19.setEnabled(false);
/*  5415 */       this.jTextField24.setEnabled(false);
/*  5416 */       this.jTextField17.setEnabled(false);
/*  5417 */       this.jTextField18.setEnabled(false);
/*  5418 */       this.jComboBox17.setEnabled(false);
/*  5419 */       this.jTextField25.setEnabled(false);
/*  5420 */       this.jTextField13.setEnabled(false);
/*  5421 */       this.jTextField32.setEnabled(false);
/*  5422 */       this.jComboBox29.setEnabled(false);
/*  5423 */       this.jTextField44.setEnabled(false);
/*  5424 */       this.jTextField45.setEnabled(false);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  5445 */       this.jTextField34.setEnabled(false);
/*  5446 */       this.jTextField35.setEnabled(false);
/*       */       
/*  5448 */       this.jTextField34.setText("");
/*  5449 */       this.jTextField35.setText("");
/*       */       
/*  5451 */       this.jComboBox17.setSelectedIndex(0);
/*  5452 */       this.jComboBox19.setSelectedIndex(0);
/*  5453 */       this.jTextField24.setText("");
/*  5454 */       this.jTextField13.setText("");
/*  5455 */       this.jTextField18.setText("");
/*  5456 */       this.jTextField17.setText("");
/*  5457 */       this.jTextField25.setText("");
/*       */ 
/*       */       
/*  5460 */       this.jDateChooser1.setEnabled(false);
/*  5461 */       this.jDateChooser6.setEnabled(false);
/*  5462 */       this.jDateChooser3.setEnabled(false);
/*  5463 */       this.jTextField44.setText("");
/*  5464 */       this.jTextField45.setText("");
/*       */     }
/*  5466 */     else if (this.jComboBox18.getSelectedIndex() == 1) {
/*  5467 */       this.jTextField44.setEnabled(true);
/*  5468 */       this.jTextField45.setEnabled(true);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  5505 */       String[] campos = (new Consultas2()).regresaRegIndex("nombreCorto, poz", "llamadas_historicas, emp_destinataria", "where llamadas_historicas.clave_desti = emp_destinataria.clave_desti and num_guia = '" + this.jTextField5
/*       */ 
/*       */           
/*  5508 */           .getText() + "'");
/*       */       
/*  5510 */       String nombreCorto = campos[0];
/*  5511 */       String pozo = this.con.Campo;
/*       */       
/*  5513 */       this.jLabel84.setText(this.jTextField6.getText());
/*  5514 */       this.jTextField7.setText(String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 5)));
/*  5515 */       this.jComboBox19.setSelectedItem(this.jTextField6.getText());
/*  5516 */       this.jComboBox17.setSelectedItem(nombreCorto);
/*       */       
/*  5518 */       this.jComboBox19.setEnabled(true);
/*  5519 */       this.jTextField24.setEnabled(true);
/*  5520 */       this.jTextField17.setEnabled(true);
/*  5521 */       this.jTextField18.setEnabled(true);
/*  5522 */       this.jTextField25.setEnabled(true);
/*  5523 */       this.jTextField13.setEnabled(true);
/*       */       
/*  5525 */       this.jTextField32.setEnabled(true);
/*       */       
/*  5527 */       this.jTextField34.setEnabled(true);
/*  5528 */       this.jTextField35.setEnabled(true);
/*       */       
/*  5530 */       this.jTextField24.setText("");
/*  5531 */       this.jTextField13.setText("");
/*  5532 */       this.jTextField17.setText(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 14).toString());
/*  5533 */       this.jTextField18.setText(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 15).toString());
/*  5534 */       this.jTextField25.setText("");
/*       */       
/*  5536 */       this.jDateChooser1.setEnabled(true);
/*  5537 */       this.jDateChooser3.setEnabled(true);
/*  5538 */       this.jDateChooser6.setEnabled(true);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  5549 */       this.jDateChooser1.setEnabled(true);
/*  5550 */       this.jDateChooser3.setEnabled(true);
/*  5551 */       this.jDateChooser6.setEnabled(true);
/*       */       
/*  5553 */       String fecha1 = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1));
/*  5554 */       String fecha2 = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1));
/*  5555 */       String fecha3 = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1));
/*       */       
/*  5557 */       String año = fecha1.substring(0, 4);
/*  5558 */       String mes = fecha1.substring(5, 7);
/*  5559 */       String dia = fecha1.substring(8, 10);
/*  5560 */       SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/*  5561 */       String strFecha = año + "-" + año + "-" + mes;
/*  5562 */       Date fecha = null;
/*       */       try {
/*  5564 */         fecha = formatoDelTexto.parse(strFecha);
/*  5565 */       } catch (ParseException ex) {
/*  5566 */         ex.printStackTrace();
/*       */       } 
/*  5568 */       this.jDateChooser1.setDate(fecha);
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  5573 */       año = fecha2.substring(0, 4);
/*  5574 */       mes = fecha2.substring(5, 7);
/*  5575 */       dia = fecha2.substring(8, 10);
/*  5576 */       formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/*  5577 */       strFecha = año + "-" + año + "-" + mes;
/*  5578 */       fecha = null;
/*       */       try {
/*  5580 */         fecha = formatoDelTexto.parse(strFecha);
/*  5581 */       } catch (ParseException ex) {
/*  5582 */         ex.printStackTrace();
/*       */       } 
/*  5584 */       this.jDateChooser6.setDate(fecha);
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  5589 */       año = fecha3.substring(0, 4);
/*  5590 */       mes = fecha3.substring(5, 7);
/*  5591 */       dia = fecha3.substring(8, 10);
/*  5592 */       formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/*  5593 */       strFecha = año + "-" + año + "-" + mes;
/*  5594 */       fecha = null;
/*       */       try {
/*  5596 */         fecha = formatoDelTexto.parse(strFecha);
/*  5597 */       } catch (ParseException ex) {
/*  5598 */         ex.printStackTrace();
/*       */       } 
/*  5600 */       this.jDateChooser3.setDate(fecha);
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  5605 */       if (this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 13).toString().equals("")) {
/*  5606 */         this.jTextField34.setText("");
/*  5607 */         this.jTextField34.setEnabled(false);
/*  5608 */         this.jTextField35.setText("");
/*  5609 */         this.jTextField35.setEnabled(false);
/*       */       } else {
/*  5611 */         this.jTextField34.setEnabled(true);
/*  5612 */         this.jTextField35.setEnabled(true);
/*       */       } 
/*  5614 */       this.jComboBox29.setSelectedItem(campos[1]);
/*  5615 */       if (!this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 11).toString().equals("")) {
/*  5616 */         this.jCheckBox1.setSelected(true);
/*       */       }
/*  5618 */     } else if (this.jComboBox18.getSelectedIndex() == 2) {
/*  5619 */       this.jTextField44.setEnabled(true);
/*  5620 */       this.jTextField45.setEnabled(true);
/*  5621 */       this.jLabel84.setText(this.jTextField6.getText());
/*  5622 */       this.jDateChooser1.setEnabled(true);
/*  5623 */       this.jDateChooser6.setEnabled(true);
/*  5624 */       this.jDateChooser3.setEnabled(true);
/*  5625 */       this.jTextField34.setEnabled(true);
/*  5626 */       this.jTextField7.setText(String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 5)));
/*       */       
/*  5628 */       if (this.jComboBox31.getSelectedIndex() != -1) {
/*  5629 */         this.jComboBox31.setSelectedItem(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 6));
/*  5630 */         this.jComboBox31.setEnabled(true);
/*       */       } else {
/*  5632 */         this.jComboBox31.setEnabled(false);
/*       */       } 
/*  5634 */       this.jComboBox17.setEnabled(false);
/*  5635 */       this.jTextField17.setEnabled(false);
/*  5636 */       this.jTextField18.setEnabled(false);
/*  5637 */       this.jTextField24.setEnabled(true);
/*  5638 */       this.jTextField25.setEnabled(true);
/*  5639 */       this.jTextField32.setEnabled(true);
/*  5640 */       this.jTextField13.setEnabled(true);
/*       */       
/*  5642 */       this.jTextField33.setEnabled(true);
/*       */       
/*  5644 */       this.jTextField24.setText("");
/*  5645 */       this.jTextField13.setText("");
/*  5646 */       this.jTextField18.setText("");
/*  5647 */       this.jTextField17.setText("");
/*  5648 */       this.jTextField25.setText("");
/*  5649 */       this.jTextField33.setText("");
/*  5650 */       this.jComboBox17.setSelectedIndex(0);
/*  5651 */       this.jComboBox19.setSelectedIndex(0);
/*  5652 */       this.jComboBox19.setEnabled(false);
/*       */       
/*  5654 */       this.jDateChooser1.setEnabled(true);
/*  5655 */       this.jDateChooser3.setEnabled(true);
/*  5656 */       this.jDateChooser6.setEnabled(true);
/*  5657 */     } else if (this.jComboBox18.getSelectedIndex() == 3) {
/*       */       
/*  5659 */       if (this.jComboBox31.getSelectedIndex() != -1) {
/*  5660 */         this.jComboBox31.setSelectedItem(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 6));
/*       */       }
/*  5662 */       if (this.jComboBox31.getSelectedIndex() != -1) {
/*  5663 */         this.jComboBox31.setSelectedItem(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 6));
/*  5664 */         this.jComboBox31.setEnabled(true);
/*       */       } else {
/*  5666 */         this.jComboBox31.setEnabled(false);
/*       */       } 
/*  5668 */       this.jComboBox19.setEnabled(true);
/*  5669 */       this.jTextField18.setEnabled(true);
/*  5670 */       this.jTextField24.setEnabled(true);
/*  5671 */       this.jTextField32.setEnabled(true);
/*  5672 */       this.jDateChooser1.setEnabled(false);
/*  5673 */       this.jDateChooser3.setEnabled(false);
/*  5674 */       this.jDateChooser6.setEnabled(false);
/*       */       
/*  5676 */       this.jLabel84.setText(String.valueOf(this.jComboBox18.getSelectedItem()));
/*  5677 */       this.jLabel84.setText(String.valueOf(this.jComboBox19.getSelectedItem()));
/*       */ 
/*       */       
/*  5680 */       this.jTextField18.setEnabled(true);
/*  5681 */       this.jTextField17.setEnabled(true);
/*  5682 */       this.jTextField24.setEnabled(false);
/*  5683 */       this.jTextField13.setEnabled(false);
/*  5684 */       this.jTextField25.setEnabled(false);
/*  5685 */       this.jTextField33.setEnabled(true);
/*  5686 */       this.jTextField24.setText("");
/*  5687 */       this.jTextField13.setText("");
/*  5688 */       this.jTextField18.setText("");
/*  5689 */       this.jTextField17.setText("");
/*  5690 */       this.jTextField25.setText("");
/*  5691 */       this.jTextField7.setText("PATIO");
/*       */       
/*  5693 */       String[] campos = (new Consultas2()).regresaRegIndex("nombreCorto, poz", "llamadas_historicas, emp_destinataria", "where llamadas_historicas.clave_desti = emp_destinataria.clave_desti and num_guia = '" + this.jTextField5
/*       */ 
/*       */           
/*  5696 */           .getText() + "'");
/*       */       
/*  5698 */       String nombreCorto = campos[0];
/*  5699 */       String pozo = this.con.Campo;
/*  5700 */       this.jComboBox17.setSelectedItem(nombreCorto);
/*  5701 */       this.jTextField33.setText("");
/*  5702 */       this.jTextField34.setText("");
/*  5703 */       this.jTextField34.setEnabled(false);
/*  5704 */     } else if (this.jComboBox18.getSelectedIndex() == 4) {
/*  5705 */       this.jTextField44.setEnabled(true);
/*  5706 */       this.jTextField45.setEnabled(true);
/*  5707 */       this.jLabel84.setText(this.jTextField6.getText());
/*  5708 */       this.jDateChooser1.setEnabled(true);
/*  5709 */       this.jDateChooser6.setEnabled(true);
/*  5710 */       this.jDateChooser3.setEnabled(true);
/*  5711 */       this.jTextField34.setEnabled(true);
/*  5712 */       this.jTextField7.setText(String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 5)));
/*  5713 */       this.jComboBox19.setSelectedItem(this.jTextField6.getText());
/*       */       
/*  5715 */       if (this.jComboBox31.getSelectedIndex() != -1) {
/*  5716 */         this.jComboBox31.setSelectedItem(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 6));
/*  5717 */         this.jComboBox31.setEnabled(true);
/*       */       } else {
/*  5719 */         this.jComboBox31.setEnabled(false);
/*       */       } 
/*  5721 */       this.jComboBox17.setEnabled(false);
/*  5722 */       this.jComboBox19.setEnabled(false);
/*  5723 */       this.jTextField25.setEnabled(true);
/*  5724 */       this.jTextField13.setEnabled(true);
/*       */ 
/*       */       
/*  5727 */       this.jTextField13.setText("");
/*  5728 */       this.jTextField18.setText("");
/*  5729 */       this.jTextField17.setText("");
/*  5730 */       this.jTextField25.setText("");
/*  5731 */       this.jTextField33.setText("");
/*  5732 */       this.jTextField17.setEnabled(false);
/*  5733 */       this.jTextField18.setEnabled(false);
/*  5734 */       this.jTextField24.setEnabled(false);
/*       */       
/*  5736 */       this.jDateChooser1.setEnabled(true);
/*  5737 */       this.jDateChooser3.setEnabled(true);
/*  5738 */       this.jDateChooser6.setEnabled(true);
/*  5739 */       this.jTextField33.setEnabled(true);
/*  5740 */     } else if (this.jComboBox18.getSelectedIndex() == 5) {
/*  5741 */       this.jTextField44.setEnabled(true);
/*  5742 */       this.jTextField45.setEnabled(true);
/*  5743 */       this.jLabel84.setText(this.jTextField6.getText());
/*  5744 */       this.jDateChooser1.setEnabled(true);
/*  5745 */       this.jDateChooser6.setEnabled(true);
/*  5746 */       this.jDateChooser3.setEnabled(true);
/*  5747 */       this.jTextField34.setEnabled(true);
/*  5748 */       this.jTextField7.setText(String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 5)));
/*  5749 */       this.jComboBox19.setSelectedItem(this.jTextField6.getText());
/*       */       
/*  5751 */       if (this.jComboBox31.getSelectedIndex() != -1) {
/*  5752 */         this.jComboBox31.setSelectedItem(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 6));
/*  5753 */         this.jComboBox31.setEnabled(true);
/*       */       } else {
/*  5755 */         this.jComboBox31.setEnabled(false);
/*       */       } 
/*       */       
/*  5758 */       this.jComboBox19.setEnabled(false);
/*  5759 */       this.jTextField25.setEnabled(true);
/*  5760 */       this.jTextField13.setEnabled(true);
/*       */       
/*  5762 */       this.jTextField33.setEnabled(true);
/*       */       
/*  5764 */       this.jTextField13.setText("");
/*  5765 */       this.jTextField18.setText("");
/*  5766 */       this.jTextField17.setText("");
/*  5767 */       this.jTextField25.setText("");
/*  5768 */       this.jTextField24.setText("");
/*  5769 */       this.jTextField33.setText("");
/*  5770 */       this.jTextField17.setEnabled(false);
/*  5771 */       this.jTextField18.setEnabled(false);
/*  5772 */       this.jTextField24.setEnabled(true);
/*       */       
/*  5774 */       this.jDateChooser1.setEnabled(true);
/*  5775 */       this.jDateChooser3.setEnabled(true);
/*  5776 */       this.jDateChooser6.setEnabled(true);
/*  5777 */     } else if (this.jComboBox18.getSelectedIndex() == 6 || this.jComboBox18.getSelectedIndex() == 9) {
/*  5778 */       this.jTextField44.setEnabled(true);
/*  5779 */       this.jTextField45.setEnabled(true);
/*  5780 */       this.jLabel84.setText(this.jTextField6.getText());
/*  5781 */       this.jDateChooser1.setEnabled(true);
/*  5782 */       this.jDateChooser6.setEnabled(true);
/*  5783 */       this.jDateChooser3.setEnabled(true);
/*  5784 */       this.jTextField34.setEnabled(true);
/*  5785 */       this.jTextField7.setText(String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 5)));
/*  5786 */       this.jComboBox19.setSelectedItem(this.jTextField6.getText());
/*       */       
/*  5788 */       if (this.jComboBox31.getSelectedIndex() != -1) {
/*  5789 */         this.jComboBox31.setSelectedItem(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 6));
/*  5790 */         this.jComboBox31.setEnabled(true);
/*       */       } else {
/*  5792 */         this.jComboBox31.setEnabled(false);
/*       */       } 
/*       */       
/*  5795 */       this.jComboBox19.setEnabled(false);
/*  5796 */       this.jTextField25.setEnabled(true);
/*  5797 */       this.jTextField13.setEnabled(true);
/*       */ 
/*       */       
/*  5800 */       this.jTextField13.setText("");
/*  5801 */       this.jTextField18.setText("");
/*  5802 */       this.jTextField17.setText("");
/*  5803 */       this.jTextField25.setText("");
/*  5804 */       this.jTextField24.setText("");
/*  5805 */       this.jTextField33.setText("");
/*  5806 */       this.jTextField17.setEnabled(true);
/*  5807 */       this.jTextField18.setEnabled(true);
/*  5808 */       this.jTextField24.setEnabled(true);
/*  5809 */       this.jTextField33.setEnabled(true);
/*       */       
/*  5811 */       this.jDateChooser1.setEnabled(true);
/*  5812 */       this.jDateChooser3.setEnabled(true);
/*  5813 */       this.jDateChooser6.setEnabled(true);
/*  5814 */     } else if (this.jComboBox18.getSelectedIndex() == 7) {
/*  5815 */       this.jTextField44.setEnabled(true);
/*  5816 */       this.jTextField45.setEnabled(true);
/*  5817 */       this.jDateChooser1.setEnabled(true);
/*  5818 */       this.jDateChooser6.setEnabled(true);
/*  5819 */       this.jDateChooser3.setEnabled(true);
/*  5820 */       this.jTextField34.setEnabled(true);
/*  5821 */       this.jLabel84.setText(this.jTextField6.getText());
/*  5822 */       this.jTextField7.setText(String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 5)));
/*  5823 */       this.jComboBox19.setSelectedItem(this.jTextField6.getText());
/*       */       
/*  5825 */       if (this.jComboBox31.getSelectedIndex() != -1) {
/*  5826 */         this.jComboBox31.setSelectedItem(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 6));
/*  5827 */         this.jComboBox31.setEnabled(true);
/*       */       } else {
/*  5829 */         this.jComboBox31.setEnabled(false);
/*       */       } 
/*       */       
/*  5832 */       this.jComboBox19.setEnabled(false);
/*  5833 */       this.jTextField25.setEnabled(true);
/*  5834 */       this.jTextField13.setEnabled(true);
/*  5835 */       this.jTextField18.setEnabled(false);
/*       */ 
/*       */       
/*  5838 */       this.jTextField13.setText("");
/*  5839 */       this.jTextField18.setText("");
/*  5840 */       this.jTextField17.setText("");
/*  5841 */       this.jTextField25.setText("");
/*  5842 */       this.jTextField24.setText("");
/*  5843 */       this.jTextField33.setText("");
/*  5844 */       this.jTextField17.setEnabled(true);
/*  5845 */       this.jTextField24.setEnabled(true);
/*  5846 */       this.jTextField33.setEnabled(true);
/*       */       
/*  5848 */       this.jDateChooser1.setEnabled(true);
/*  5849 */       this.jDateChooser3.setEnabled(true);
/*  5850 */       this.jDateChooser6.setEnabled(true);
/*  5851 */     } else if (this.jComboBox18.getSelectedIndex() == 8) {
/*  5852 */       this.jTextField44.setEnabled(true);
/*  5853 */       this.jTextField45.setEnabled(true);
/*  5854 */       this.jLabel84.setText(this.jTextField6.getText());
/*  5855 */       this.jDateChooser1.setEnabled(true);
/*  5856 */       this.jDateChooser6.setEnabled(true);
/*  5857 */       this.jDateChooser3.setEnabled(true);
/*  5858 */       this.jTextField34.setEnabled(true);
/*  5859 */       this.jTextField7.setText(String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 5)));
/*       */       
/*  5861 */       if (this.jComboBox31.getSelectedIndex() != -1) {
/*  5862 */         this.jComboBox31.setSelectedItem(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 6));
/*  5863 */         this.jComboBox31.setEnabled(true);
/*       */       } else {
/*  5865 */         this.jComboBox31.setEnabled(false);
/*       */       } 
/*       */       
/*  5868 */       this.jTextField24.setEnabled(true);
/*  5869 */       this.jTextField17.setEnabled(true);
/*  5870 */       this.jTextField18.setEnabled(true);
/*  5871 */       this.jTextField25.setEnabled(true);
/*  5872 */       this.jTextField13.setEnabled(true);
/*       */       
/*  5874 */       this.jTextField32.setEnabled(true);
/*  5875 */       this.jTextField33.setEnabled(true);
/*       */       
/*  5877 */       this.jTextField24.setText("");
/*  5878 */       this.jTextField13.setText("");
/*  5879 */       this.jTextField18.setText("");
/*  5880 */       this.jTextField17.setText("");
/*  5881 */       this.jTextField25.setText("");
/*  5882 */       this.jTextField33.setText("");
/*       */       
/*  5884 */       this.jDateChooser1.setEnabled(true);
/*  5885 */       this.jDateChooser3.setEnabled(true);
/*  5886 */       this.jDateChooser6.setEnabled(true);
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jComboBox19ActionPerformed(ActionEvent evt) {
/*  5891 */     if (this.jComboBox18.getSelectedIndex() == 1) {
/*  5892 */       this.jLabel84.setText(String.valueOf(this.jComboBox19.getSelectedItem()));
/*  5893 */     } else if (this.jComboBox18.getSelectedIndex() == 3) {
/*  5894 */       this.jLabel84.setText(String.valueOf(this.jComboBox19.getSelectedItem()));
/*       */     } else {
/*  5896 */       this.jLabel84.setText(this.jTextField6.getText());
/*       */     } 
/*       */   }
/*       */   
/*       */   private void materialButton20ActionPerformed(ActionEvent evt) {
/*  5901 */     int opc = this.jComboBox18.getSelectedIndex();
/*  5902 */     this.error.pasarModal(true);
/*       */     
/*  5904 */     String valor1 = this.jTextField6.getText();
/*  5905 */     String valor2 = String.valueOf(this.jComboBox19.getSelectedItem());
/*  5906 */     int selec = this.rSTableMetro1.getSelectedRow();
/*  5907 */     if (opc == 0) {
/*  5908 */       this.error.cargarError(this.jComboBox18, "050");
/*  5909 */     } else if (opc == 1) {
/*  5910 */       if (this.jComboBox19.getSelectedIndex() == 0) {
/*  5911 */         this.error.cargarError(this.jComboBox19, "050");
/*  5912 */       } else if (valor1.equals("valor2")) {
/*  5913 */         JOptionPane.showMessageDialog(this.jDialog2, "Si deseas generar la Hoja de Recepción por CARGADA y TIRADA necesitas seleccionar el mismo operador", "Operadores Distintos", 0, this.ADVER);
/*  5914 */       } else if (this.jDateChooser1.getDate() == null) {
/*  5915 */         JOptionPane.showMessageDialog(this.jDialog2, "<html>Necesitas colocar la <b>fecha de llegada</b>, el formato es el siguiente:</html>\ndd-mm-aaaa", "Falta Fecha Llegada", 0, this.ERROR);
/*  5916 */       } else if (this.jDateChooser6.getDate() == null) {
/*  5917 */         JOptionPane.showMessageDialog(this.jDialog2, "<html>Necesitas colocar la <b>fecha de carga</b>, el formato es el siguiente:</html>\ndd-mm-aaaa", "Falta Fecha Salida", 0, this.ERROR);
/*  5918 */       } else if (this.jDateChooser3.getDate() == null) {
/*  5919 */         JOptionPane.showMessageDialog(this.jDialog2, "<html>Necesitas colocar la <b>fecha de salida</b>, el formato es el siguiente:</html>\ndd-mm-aaaa", "Falta Fecha Salida", 0, this.ERROR);
/*  5920 */       } else if (this.jDateChooser1.getDate().after(this.jDateChooser6.getDate())) {
/*  5921 */         JOptionPane.showMessageDialog(this.padre, "<html><b>La fecha de carga</b> debe ser mayor o igual a la fecha de llegada</html>\nPor favor confirma las fechas.", "Fechas Erróneas", 0, this.ERROR);
/*  5922 */       } else if (this.jDateChooser1.getDate().after(this.jDateChooser3.getDate())) {
/*  5923 */         JOptionPane.showMessageDialog(this.padre, "<html><b>La fecha de salida</b> debe ser mayor o igual a la fecha de llegada.</html>\nPor favor confirma las fechas.", "Fechas Erróneas", 0, this.ERROR);
/*  5924 */       } else if (this.CLIENTESDOLID.contains(this.rSTableMetro1.getValueAt(selec, 4).toString()) && (this.jTextField44.getText().equals("") || this.jTextField45.getText().equals(""))) {
/*  5925 */         JOptionPane.showMessageDialog(this.padre, "El dato de D.O. y L.I.D. No pueden estar vacíos", "Faltan datos DO y/o LID", 0, this.ERROR);
/*  5926 */       } else if (this.jComboBox17.getSelectedIndex() == 0) {
/*  5927 */         this.error.cargarError(this.jComboBox17, "050");
/*  5928 */       } else if (!this.val.validarSoloNum(this.jTextField24, this.jTextField24.getText()) && 
/*  5929 */         !this.val.validarSoloNum(this.jTextField25, this.jTextField25.getText()) && 
/*  5930 */         !this.val.validarSoloNum(this.jTextField13, this.jTextField13.getText())) {
/*  5931 */         String linea = "";
/*  5932 */         if (this.jComboBox31.isEnabled() && this.jComboBox31.getSelectedIndex() != 0) {
/*  5933 */           linea = String.valueOf(this.jComboBox31.getSelectedItem());
/*       */         } else {
/*  5935 */           linea = "";
/*       */         } 
/*       */         
/*  5938 */         SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  5939 */         String cadenaFecha1 = formato.format(this.jDateChooser1.getDate());
/*  5940 */         String año = cadenaFecha1.substring(0, 4);
/*  5941 */         String mes = cadenaFecha1.substring(4, 6);
/*  5942 */         String dia = cadenaFecha1.substring(6, 8);
/*  5943 */         String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/*  5944 */         String fenviar1 = dia + "/" + dia + "/" + mes;
/*       */         
/*  5946 */         formato = new SimpleDateFormat("yyyyMMdd");
/*  5947 */         cadenaFecha1 = formato.format(this.jDateChooser3.getDate());
/*  5948 */         año = cadenaFecha1.substring(0, 4);
/*  5949 */         mes = cadenaFecha1.substring(4, 6);
/*  5950 */         dia = cadenaFecha1.substring(6, 8);
/*  5951 */         String fechaCompleta2 = "'" + año + "-" + mes + "-" + dia + "'";
/*  5952 */         String fenviar2 = dia + "/" + dia + "/" + mes;
/*       */         
/*  5954 */         formato = new SimpleDateFormat("yyyyMMdd");
/*  5955 */         cadenaFecha1 = formato.format(this.jDateChooser6.getDate());
/*  5956 */         año = cadenaFecha1.substring(0, 4);
/*  5957 */         mes = cadenaFecha1.substring(4, 6);
/*  5958 */         dia = cadenaFecha1.substring(6, 8);
/*  5959 */         String fechaCompleta3 = "'" + año + "-" + mes + "-" + dia + "'";
/*  5960 */         String fenviar3 = dia + "/" + dia + "/" + mes;
/*       */         
/*  5962 */         if (this.jTextField17.getText().equals("")) {
/*  5963 */           this.jTextField17.setText("0");
/*       */         }
/*  5965 */         if (this.jTextField18.getText().equals("")) {
/*  5966 */           this.jTextField18.setText("0");
/*       */         }
/*       */         
/*  5969 */         if (this.jTextField33.getText().equals("")) {
/*  5970 */           this.jTextField33.setText("0");
/*       */         }
/*       */         
/*  5973 */         float auxN = 0.0F;
/*       */         try {
/*  5975 */           auxN = Float.parseFloat(this.jTextField42.getText());
/*  5976 */         } catch (NumberFormatException n) {
/*  5977 */           this.jTextField42.setBackground(Color.RED);
/*  5978 */           JOptionPane.showMessageDialog(this.jDialog2, "El campo de KM necesita un valor sólo numérico", "Sólo número", 0, this.ERROR);
/*       */           
/*       */           return;
/*       */         } 
/*  5982 */         auxN = 0.0F;
/*       */         try {
/*  5984 */           auxN = Float.parseFloat(this.jTextField18.getText());
/*  5985 */         } catch (NumberFormatException n) {
/*  5986 */           this.jTextField18.setBackground(Color.RED);
/*  5987 */           JOptionPane.showMessageDialog(this.jDialog2, "El campo de PESO necesita un valor sólo numérico", "Sólo número", 0, this.ERROR);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           return;
/*       */         } 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  5999 */         if (buscarFolioImpreso(this.jTextField41.getText())) {
/*  6000 */           String[] dat = regDatosFolioImpreso(this.jTextField41.getText());
/*  6001 */           this.jTextField41.setBackground(Color.RED);
/*  6002 */           JOptionPane.showMessageDialog(this.jDialog2, "<html>El folio impreso que ingresaste ya corresponde una guía dentro de la base de datos.<p>Estos son los datos que ya están registrados:<p>Guía: <b>" + dat[0] + "</b><p>Fecha: <b>" + dat[1] + "</b><p>Tipo: <b>" + dat[2] + "</b></html>", "Folio impreso duplicado", 1, this.ADVER);
/*       */         } else {
/*  6004 */           double ton = redondear(Double.valueOf(Double.parseDouble(this.jTextField18.getText())));
/*  6005 */           this.con.consultar("clave_desti", "emp_destinataria", "where nombreCorto = '" + String.valueOf(this.jComboBox17.getSelectedItem()) + "'");
/*  6006 */           String clave_desti = this.con.Campo;
/*  6007 */           int res = JOptionPane.showConfirmDialog(this.padre, "Al complementar la guía quedará cerrada y no podrás cambiar su información de trámite\n¿Estás seguro que deseas complementar la guía?", "Complementar Guía", 0, 3, this.PREG);
/*  6008 */           if (res == 0) {
/*  6009 */             String rsp = this.jTextField24.getText();
/*  6010 */             String estadias = this.jTextField25.getText();
/*  6011 */             String mov = this.jTextField13.getText();
/*  6012 */             String tipo = "";
/*  6013 */             if (this.jCheckBox1.isSelected()) {
/*  6014 */               tipo = "FULL";
/*       */             } else {
/*  6016 */               tipo = "SENCILLO";
/*       */             } 
/*  6018 */             if (rsp.equals("")) {
/*  6019 */               rsp = "0";
/*       */             }
/*  6021 */             if (estadias.equals("")) {
/*  6022 */               estadias = "0";
/*       */             }
/*  6024 */             if (mov.equals("")) {
/*  6025 */               mov = "0";
/*       */             }
/*  6027 */             this.con.consultar("num_pozo", "pozos", "where nombre = '" + String.valueOf(this.jComboBox29.getSelectedItem()) + "'");
/*  6028 */             String clavePozo = this.con.Campo;
/*  6029 */             sacarMayor();
/*  6030 */             this.con.inserSinMsj("insert into vales(num_vale,ticket,f_expedicion1,f_expedicion2,f_llegada,f_cargada,f_salida,peso,rsp,estadias,mov,tipo,num_guia,nombre_usu,ope_carga,ope_tira,clave1,clave2,folio_liq1,folio_liq2,completa,estado) values('" + this.jTextField8.getText() + "','" + this.jTextField17.getText() + "',now(),now()," + fechaCompleta + "," + fechaCompleta3 + "," + fechaCompleta2 + "," + ton + "," + rsp + "," + estadias + "," + mov + ",'" + tipo + "','" + this.jTextField5.getText() + "','" + this.USUARIO + "','" + this.jTextField6.getText() + "','" + String.valueOf(this.jComboBox19.getSelectedItem()) + "'," + this.CLAVEO + "," + this.CLAVEO + ",'','',1,'ACTIVO')");
/*  6031 */             String status = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 21));
/*  6032 */             if (status.equals("<Asignada Al Operador>") || status.equals("<Por Timbrar>")) {
/*  6033 */               status = "<Pagada Al Operador: " + cargarFechaHoy() + ">";
/*       */             }
/*  6035 */             String act = this.USUARIO + ": INGRESADO " + this.USUARIO;
/*  6036 */             this.con.inserSinMsj("update guias set actualizacion ='" + act + "', do='" + this.jTextField44.getText().toUpperCase() + "', lid='" + this.jTextField45.getText().toUpperCase() + "', folio_imp = '" + this.jTextField41.getText() + "',manifiesto='" + this.jTextField32.getText().toUpperCase() + "', estatus='" + status + "',num_vale = '" + this.jTextField8.getText() + "', linea ='" + linea + "',km=" + this.jTextField42.getText() + " where num_guia = '" + this.jTextField5.getText() + "'");
/*  6037 */             this.con.inserSinMsj("update llamadas_historicas set clave_desti = " + clave_desti + ",num_pozo=" + clavePozo + " where num_guia = '" + this.jTextField5.getText() + "'");
/*  6038 */             ImprimirRSP im = new ImprimirRSP();
/*  6039 */             String[] datos = { this.jTextField8.getText(), this.jTextField5.getText(), this.jTextField10.getText(), String.valueOf(this.jComboBox18.getSelectedItem()), this.jTextField6.getText(), String.valueOf(this.jComboBox19.getSelectedItem()), this.jTextField19.getText(), this.jTextField23.getText(), fenviar1, fenviar2, this.jTextField7.getText(), this.jTextField9.getText(), String.valueOf(this.jComboBox17.getSelectedItem()), this.jTextField17.getText(), this.jTextField18.getText(), this.jTextField24.getText(), this.jTextField25.getText(), this.jTextField13.getText(), this.jLabel83.getText(), this.jLabel84.getText(), this.TIPOTRACTOR, tipo };
/*  6040 */             im.recibeDatos(datos);
/*  6041 */             consultar();
/*  6042 */             this.jDialog2.setVisible(false);
/*       */           
/*       */           }
/*       */ 
/*       */         
/*       */         }
/*       */       
/*       */       }
/*       */     
/*       */     }
/*  6052 */     else if (opc == 2) {
/*  6053 */       if (this.jDateChooser1.getDate() == null) {
/*  6054 */         JOptionPane.showMessageDialog(this.jDialog2, "<html>Necesitas colocar la <b>fecha de llegada</b>, el formato es el siguiente:</html>\ndd-mm-aaaa", "Falta Fecha Llegada", 0, this.ERROR);
/*  6055 */       } else if (this.jDateChooser6.getDate() == null) {
/*  6056 */         JOptionPane.showMessageDialog(this.jDialog2, "<html>Necesitas colocar la <b>fecha de carga</b>, el formato es el siguiente:</html>\ndd-mm-aaaa", "Falta Fecha Salida", 0, this.ERROR);
/*  6057 */       } else if (this.jDateChooser3.getDate() == null) {
/*  6058 */         JOptionPane.showMessageDialog(this.jDialog2, "<html>Necesitas colocar la <b>fecha de salida</b>, el formato es el siguiente:</html>\ndd-mm-aaaa", "Falta Fecha Salida", 0, this.ERROR);
/*  6059 */       } else if (this.jDateChooser1.getDate().after(this.jDateChooser6.getDate())) {
/*  6060 */         JOptionPane.showMessageDialog(this.padre, "<html><b>La fecha de carga</b> debe ser mayor o igual a la fecha de llegada</html>\nPor favor confirma las fechas.", "Fechas Erróneas", 0, this.ERROR);
/*  6061 */       } else if (this.jDateChooser1.getDate().after(this.jDateChooser3.getDate())) {
/*  6062 */         JOptionPane.showMessageDialog(this.padre, "<html><b>La fecha de salida</b> debe ser mayor o igual a la fecha de llegada.</html>\nPor favor confirma las fechas.", "Fechas Erróneas", 0, this.ERROR);
/*  6063 */       } else if (!this.val.validarSoloNum(this.jTextField24, this.jTextField24.getText()) && 
/*  6064 */         !this.val.validarSoloNum(this.jTextField25, this.jTextField25.getText()) && 
/*  6065 */         !this.val.validarSoloNum(this.jTextField13, this.jTextField13.getText())) {
/*  6066 */         SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  6067 */         String cadenaFecha1 = formato.format(this.jDateChooser1.getDate());
/*  6068 */         String año = cadenaFecha1.substring(0, 4);
/*  6069 */         String mes = cadenaFecha1.substring(4, 6);
/*  6070 */         String dia = cadenaFecha1.substring(6, 8);
/*  6071 */         String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/*  6072 */         String fenviar1 = dia + "/" + dia + "/" + mes;
/*       */         
/*  6074 */         formato = new SimpleDateFormat("yyyyMMdd");
/*  6075 */         cadenaFecha1 = formato.format(this.jDateChooser3.getDate());
/*  6076 */         año = cadenaFecha1.substring(0, 4);
/*  6077 */         mes = cadenaFecha1.substring(4, 6);
/*  6078 */         dia = cadenaFecha1.substring(6, 8);
/*  6079 */         String fechaCompleta2 = "'" + año + "-" + mes + "-" + dia + "'";
/*  6080 */         String fenviar2 = dia + "/" + dia + "/" + mes;
/*       */         
/*  6082 */         formato = new SimpleDateFormat("yyyyMMdd");
/*  6083 */         cadenaFecha1 = formato.format(this.jDateChooser6.getDate());
/*  6084 */         año = cadenaFecha1.substring(0, 4);
/*  6085 */         mes = cadenaFecha1.substring(4, 6);
/*  6086 */         dia = cadenaFecha1.substring(6, 8);
/*  6087 */         String fechaCompleta3 = "'" + año + "-" + mes + "-" + dia + "'";
/*  6088 */         String fenviar3 = dia + "/" + dia + "/" + mes;
/*       */         
/*  6090 */         String rsp = this.jTextField24.getText();
/*  6091 */         String estadias = this.jTextField25.getText();
/*  6092 */         String mov = this.jTextField13.getText();
/*  6093 */         String tipo = "";
/*       */         
/*  6095 */         if (rsp.equals("")) {
/*  6096 */           rsp = "0";
/*       */         }
/*  6098 */         if (estadias.equals("")) {
/*  6099 */           estadias = "0";
/*       */         }
/*  6101 */         if (mov.equals("")) {
/*  6102 */           mov = "0";
/*       */         }
/*       */         
/*  6105 */         if (this.jTextField33.getText().equals("")) {
/*  6106 */           this.jTextField33.setText("0");
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
/*  6117 */         if (buscarFolioImpreso(this.jTextField41.getText())) {
/*  6118 */           String[] dat = regDatosFolioImpreso(this.jTextField41.getText());
/*  6119 */           this.jTextField41.setBackground(Color.RED);
/*  6120 */           JOptionPane.showMessageDialog(this.jDialog2, "<html>El folio impreso que ingresaste ya corresponde una guía dentro de la base de datos.<p>Estos son los datos que ya están registrados:<p>Guía: <b>" + dat[0] + "</b><p>Fecha: <b>" + dat[1] + "</b><p>Tipo: <b>" + dat[2] + "</b></html>", "Folio impreso duplicado", 1, this.ADVER);
/*       */         } else {
/*  6122 */           float auxN = 0.0F;
/*       */           try {
/*  6124 */             auxN = Float.parseFloat(this.jTextField33.getText());
/*  6125 */           } catch (NumberFormatException n) {
/*  6126 */             this.jTextField33.setBackground(Color.RED);
/*  6127 */             JOptionPane.showMessageDialog(this.jDialog2, "El campo necesita un valor sólo numérico", "Sólo número", 0, this.ERROR);
/*       */             return;
/*       */           } 
/*  6130 */           int res = JOptionPane.showConfirmDialog(this.padre, "Ésta guía quedará activa hasta que se descargue el residuo\n¿Deseas generar recepción de SÓLO CARGADA?", "Guía Abierta", 0, 3, this.PREG);
/*  6131 */           if (res == 0) {
/*  6132 */             String linea = "";
/*  6133 */             if (this.jComboBox31.isEnabled() && this.jComboBox31.getSelectedIndex() != 0) {
/*  6134 */               linea = String.valueOf(this.jComboBox31.getSelectedItem());
/*       */             } else {
/*  6136 */               linea = "";
/*       */             } 
/*       */             
/*  6139 */             if (this.jCheckBox1.isSelected()) {
/*  6140 */               tipo = "FULL";
/*       */             } else {
/*  6142 */               tipo = "SENCILLO";
/*       */             } 
/*       */             
/*  6145 */             this.con.consultar("num_pozo", "pozos", "where nombre = '" + String.valueOf(this.jComboBox29.getSelectedItem()) + "'");
/*  6146 */             String clavePozo = this.con.Campo;
/*  6147 */             sacarMayor();
/*  6148 */             this.con.inserSinMsj("insert into vales(num_vale,ticket,f_expedicion1,f_expedicion2,f_llegada,f_cargada,f_salida,peso,rsp,estadias,mov,tipo,num_guia,nombre_usu,ope_carga,ope_tira,clave1,clave2,folio_liq1,folio_liq2,completa,estado) values('" + this.jTextField8.getText() + "','0',now(),NULL," + fechaCompleta + ", " + fechaCompleta3 + "," + fechaCompleta2 + ",0," + rsp + "," + estadias + "," + mov + ",'" + tipo + "','" + this.jTextField5.getText() + "','" + this.USUARIO + "','" + this.jTextField6.getText() + "','PENDIENTE DESCARGA'," + this.CLAVEO + ",0,'','',0,'ACTIVO')");
/*  6149 */             String status = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 21));
/*  6150 */             if (status.equals("<Asignada Al Operador>") || status.equals("<Por Timbrar>")) {
/*  6151 */               status = "<Sólo Cargada: En Patio " + cargarFechaHoy() + ">";
/*       */             }
/*  6153 */             this.con.inserSinMsj("update llamadas_historicas set num_pozo=" + clavePozo + " where num_guia = '" + this.jTextField5.getText() + "'");
/*  6154 */             this.con.inserSinMsj("update guias set folio_imp = '" + this.jTextField41.getText() + "', manifiesto='" + this.jTextField32.getText().toUpperCase() + "', estatus='" + status + "',num_vale = '" + this.jTextField8.getText() + "',km=" + this.jTextField42.getText() + ", linea ='" + linea + "' where num_guia = '" + this.jTextField5.getText() + "'");
/*  6155 */             ImprimirRSP im = new ImprimirRSP();
/*  6156 */             String[] datos = { this.jTextField8.getText(), this.jTextField5.getText(), this.jTextField10.getText(), String.valueOf(this.jComboBox18.getSelectedItem()), this.jTextField6.getText(), String.valueOf(this.jComboBox19.getSelectedItem()), this.jTextField19.getText(), this.jTextField23.getText(), fenviar1, fenviar2, this.jTextField7.getText(), this.jTextField9.getText(), String.valueOf(this.jComboBox17.getSelectedItem()), this.jTextField17.getText(), this.jTextField18.getText(), this.jTextField24.getText(), this.jTextField25.getText(), this.jTextField13.getText(), this.jLabel83.getText(), this.jLabel84.getText(), this.TIPOTRACTOR, tipo };
/*  6157 */             im.recibeDatos(datos);
/*  6158 */             consultar();
/*  6159 */             this.jDialog2.setVisible(false);
/*       */           }
/*       */         
/*       */         }
/*       */       
/*       */       }
/*       */     
/*  6166 */     } else if (opc == 3) {
/*  6167 */       this.encontrado = this.con.consultar("num_guia", "guias", "where num_vale = '" + this.jTextField8.getText() + "'");
/*  6168 */       if (!this.encontrado) {
/*  6169 */         JOptionPane.showMessageDialog(this.jDialog2, "No puedes asignar sólo tirada al viaje ya que este residuo no ha sido cargada desde patio.\nVerifica tu Información", "No está en Patio", 0, this.ERROR); return;
/*       */       } 
/*  6171 */       if (this.jComboBox19.getSelectedIndex() == 0)
/*  6172 */       { this.error.cargarError(this.jComboBox19, "050"); }
/*  6173 */       else { if (this.jComboBox17.getSelectedIndex() == 0) {
/*  6174 */           this.error.cargarError(this.jComboBox17, "050");
/*       */           return;
/*       */         } 
/*  6177 */         if (this.jTextField17.getText().equals("")) {
/*  6178 */           this.jTextField17.setText("0");
/*       */         }
/*  6180 */         if (this.jTextField33.getText().equals("")) {
/*  6181 */           this.jTextField33.setText("0");
/*       */         }
/*       */         
/*  6184 */         if (this.jTextField18.getText().equals("")) {
/*  6185 */           this.jTextField18.setText("0");
/*       */         }
/*       */         
/*  6188 */         float auxN = 0.0F;
/*       */         try {
/*  6190 */           auxN = Float.parseFloat(this.jTextField33.getText());
/*  6191 */         } catch (NumberFormatException n) {
/*  6192 */           this.jTextField33.setBackground(Color.RED);
/*  6193 */           JOptionPane.showMessageDialog(this.jDialog2, "El campo necesita un valor sólo numérico", "Sólo número", 0, this.ERROR);
/*       */           
/*       */           return;
/*       */         } 
/*  6197 */         auxN = 0.0F;
/*       */         try {
/*  6199 */           auxN = Float.parseFloat(this.jTextField18.getText());
/*  6200 */         } catch (NumberFormatException n) {
/*  6201 */           this.jTextField18.setBackground(Color.RED);
/*  6202 */           JOptionPane.showMessageDialog(this.jDialog2, "El campo necesita un valor sólo numérico", "Sólo número", 0, this.ERROR);
/*       */           
/*       */           return;
/*       */         } 
/*  6206 */         int res = JOptionPane.showConfirmDialog(this.padre, "Al generar la recepción de SÓLO TIRADA, quedará cerrada la guía\n¿Estás seguro que deseas complementar la guía?", "Complementar Guía", 0, 3, this.PREG);
/*  6207 */         if (res == 0) {
/*  6208 */           String linea = "";
/*  6209 */           if (this.jComboBox31.isEnabled() && this.jComboBox31.getSelectedIndex() != 0) {
/*  6210 */             linea = String.valueOf(this.jComboBox31.getSelectedItem());
/*       */           } else {
/*  6212 */             linea = "";
/*       */           } 
/*       */           
/*  6215 */           String tipo = "";
/*  6216 */           if (this.jCheckBox1.isSelected()) {
/*  6217 */             tipo = "FULL";
/*       */           } else {
/*  6219 */             tipo = "SENCILLO";
/*       */           } 
/*       */           
/*  6222 */           String status = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 21));
/*  6223 */           status = "<Pagada Al Operador: " + cargarFechaHoy() + ">";
/*       */           
/*  6225 */           this.con.consultar("num_pozo", "pozos", "where nombre = '" + String.valueOf(this.jComboBox29.getSelectedItem()) + "'");
/*  6226 */           String clavePozo = this.con.Campo;
/*  6227 */           double ton = redondear(Double.valueOf(Double.parseDouble(this.jTextField18.getText())));
/*       */ 
/*       */           
/*  6230 */           this.con.inserSinMsj("update guias set manifiesto='" + this.jTextField32.getText().toUpperCase() + "',estatus='" + status + "', linea = '" + linea + "', km =" + this.jTextField42.getText() + " where num_guia = '" + this.jTextField5.getText() + "'");
/*       */           
/*  6232 */           this.con.inserSinMsj("update vales set f_expedicion2 = now(), ticket = '" + this.jTextField17.getText() + "', peso = " + ton + ", ope_tira = '" + String.valueOf(this.jComboBox19.getSelectedItem()) + "',clave2 = " + this.CLAVEOPERADOR[this.jComboBox19.getSelectedIndex() - 1] + ",completa = 1 where num_vale = '" + this.jTextField8.getText() + "' ");
/*  6233 */           ImprimirRSP im = new ImprimirRSP();
/*  6234 */           String[] datos = { this.jTextField8.getText(), this.jTextField5.getText(), this.jTextField10.getText(), String.valueOf(this.jComboBox18.getSelectedItem()), this.jTextField6.getText(), String.valueOf(this.jComboBox19.getSelectedItem()), this.jTextField19.getText(), this.jTextField23.getText(), "-------", "-------", this.jTextField7.getText(), this.jTextField9.getText(), String.valueOf(this.jComboBox17.getSelectedItem()), this.jTextField17.getText(), this.jTextField18.getText(), this.jTextField24.getText(), this.jTextField25.getText(), this.jTextField13.getText(), this.jLabel83.getText(), this.jLabel84.getText(), this.TIPOTRACTOR, tipo };
/*  6235 */           im.recibeDatos(datos);
/*  6236 */           consultar();
/*  6237 */           this.jDialog2.setVisible(false);
/*       */         }
/*       */          }
/*       */ 
/*       */     
/*  6242 */     } else if (opc == 4) {
/*  6243 */       JOptionPane.showMessageDialog(this.padre, "<html>Para generar <B><font color = RED>MOVIMIENTO EN FALSO</font></B> la carta porte necesita <br>estar firmada y autorizada por el Company Man.</html>", "Generar Movimiento en Falso", 0, this.ADVER);
/*  6244 */       if (!this.val.validarSoloNum(this.jTextField25, this.jTextField25.getText()) && 
/*  6245 */         !this.val.validarSoloNum(this.jTextField13, this.jTextField13.getText())) {
/*  6246 */         String estadias = this.jTextField25.getText();
/*  6247 */         String mov = this.jTextField13.getText();
/*  6248 */         if (estadias.equals("")) {
/*  6249 */           estadias = "0";
/*       */         }
/*  6251 */         if (mov.equals("")) {
/*  6252 */           mov = "0";
/*       */         }
/*  6254 */         if (this.jTextField33.getText().equals("")) {
/*  6255 */           this.jTextField33.setText("0");
/*       */         }
/*       */         
/*  6258 */         float auxN = 0.0F;
/*       */         try {
/*  6260 */           auxN = Float.parseFloat(this.jTextField33.getText());
/*  6261 */         } catch (NumberFormatException n) {
/*  6262 */           this.jTextField33.setBackground(Color.RED);
/*  6263 */           JOptionPane.showMessageDialog(this.jDialog2, "El campo Kilometraje necesita un valor sólo numérico", "Sólo número", 0, this.ERROR);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           return;
/*       */         } 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  6275 */         if (buscarFolioImpreso(this.jTextField34.getText())) {
/*  6276 */           String[] dat = regDatosFolioImpreso(this.jTextField34.getText());
/*  6277 */           this.jTextField34.setBackground(Color.RED);
/*  6278 */           JOptionPane.showMessageDialog(this.jDialog2, "<html>El folio impreso que ingresaste ya corresponde una guía dentro de la base de datos.<p>Estos son los datos que ya están registrados:<p>Guía: <b>" + dat[0] + "</b><p>Fecha: <b>" + dat[1] + "</b><p>Tipo: <b>" + dat[2] + "</b></html>", "Folio impreso duplicado", 1, this.ADVER);
/*       */         } else {
/*  6280 */           int res = JOptionPane.showConfirmDialog(this.padre, "Al generar el Movimiento en Falso se cerrará la guía\n¿Estás seguro que deseas complementar la guía?", "Complementar Guía", 0, 3, this.PREG);
/*  6281 */           if (res == 0) {
/*  6282 */             String linea = "";
/*  6283 */             if (this.jComboBox31.isEnabled() && this.jComboBox31.getSelectedIndex() != 0) {
/*  6284 */               linea = String.valueOf(this.jComboBox31.getSelectedItem());
/*       */             } else {
/*  6286 */               linea = "";
/*       */             } 
/*  6288 */             String tipo = "";
/*  6289 */             if (this.jCheckBox1.isSelected()) {
/*  6290 */               tipo = "FULL";
/*       */             } else {
/*  6292 */               tipo = "SENCILLO";
/*       */             } 
/*  6294 */             sacarMayor();
/*  6295 */             String status = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 21));
/*  6296 */             if (status.equals("<Asignada Al Operador>") || status.equals("<Por Timbrar>")) {
/*  6297 */               status = "<Pagada Al Operador: " + cargarFechaHoy() + ">";
/*       */             }
/*  6299 */             this.con.consultar("num_pozo", "pozos", "where nombre = '" + String.valueOf(this.jComboBox29.getSelectedItem()) + "'");
/*  6300 */             String clavePozo = this.con.Campo;
/*       */ 
/*       */             
/*  6303 */             this.con.inserSinMsj("update guias set estatus = '" + status + "', folio_imp = '" + this.jTextField41.getText() + "', manifiesto='" + this.jTextField32.getText().toUpperCase() + "',servicio = 'MOVIMIENTO EN FALSO', num_vale = '" + this.jTextField8.getText() + "',linea='" + linea + "', km=" + this.jTextField42.getText() + " WHERE NUM_GUIA = '" + this.jTextField5.getText() + "'");
/*  6304 */             this.con.inserSinMsj("insert into vales(num_vale,ticket,f_expedicion1,f_expedicion2,f_llegada,f_cargada,f_salida,peso,rsp,estadias,mov,tipo,num_guia,nombre_usu,ope_carga,ope_tira,clave1,clave2,folio_liq1,folio_liq2,completa,estado) values('" + this.jTextField8
/*  6305 */                 .getText() + "','0',now(),now(),now(),now(),now(),0,0," + estadias + "," + mov + ",'SENCILLO','" + this.jTextField5.getText() + "','" + this.USUARIO + "','" + this.jTextField6.getText() + "','MOVIMIENTO EN FALSO'," + this.CLAVEO + "," + this.CLAVEO + ",'','',1,'ACTIVO')");
/*  6306 */             ImprimirRSP im = new ImprimirRSP();
/*  6307 */             String[] datos = { this.jTextField8.getText(), this.jTextField5.getText(), this.jTextField10.getText(), String.valueOf(this.jComboBox18.getSelectedItem()), this.jTextField6.getText(), "M0VIMIENTO EN FALSO", this.jTextField19.getText(), this.jTextField23.getText(), "-------", "-------", this.jTextField7.getText(), this.jTextField9.getText(), "MOVIMIENTO EN FALSO", "0", "0", this.jTextField24.getText(), this.jTextField25.getText(), this.jTextField13.getText(), this.jLabel83.getText(), this.jLabel84.getText(), this.TIPOTRACTOR, tipo };
/*  6308 */             im.recibeDatos(datos);
/*  6309 */             consultar();
/*  6310 */             this.jDialog2.setVisible(false);
/*       */           }
/*       */         
/*       */         }
/*       */       
/*       */       } 
/*  6316 */     } else if (opc == 5) {
/*  6317 */       JOptionPane.showMessageDialog(this.padre, "<html>Para generar <B><font color = RED>MOVIMIENTO INTERNO</font></B> la carta porte necesita <br>estar firmada y autorizada por el Company Man.</html>", "Generar Movimiento Interno", 0, this.ADVER);
/*  6318 */       if (this.jComboBox17.getSelectedIndex() == 0) {
/*  6319 */         this.error.cargarError(this.jComboBox17, "050");
/*  6320 */       } else if (!this.val.validarSoloNum(this.jTextField24, this.jTextField24.getText()) && 
/*  6321 */         !this.val.validarSoloNum(this.jTextField25, this.jTextField25.getText()) && 
/*  6322 */         !this.val.validarSoloNum(this.jTextField13, this.jTextField13.getText())) {
/*  6323 */         String estadias = this.jTextField25.getText();
/*  6324 */         String mov = this.jTextField13.getText();
/*  6325 */         String rsp = this.jTextField24.getText();
/*  6326 */         if (rsp.equals("")) {
/*  6327 */           rsp = "0";
/*       */         }
/*  6329 */         if (estadias.equals("")) {
/*  6330 */           estadias = "0";
/*       */         }
/*  6332 */         if (mov.equals("")) {
/*  6333 */           mov = "0";
/*       */         }
/*       */         
/*  6336 */         if (this.jTextField33.getText().equals("")) {
/*  6337 */           this.jTextField33.setText("0");
/*       */         }
/*       */         
/*  6340 */         float auxN = 0.0F;
/*       */         try {
/*  6342 */           auxN = Float.parseFloat(this.jTextField33.getText());
/*  6343 */         } catch (NumberFormatException n) {
/*  6344 */           this.jTextField33.setBackground(Color.RED);
/*  6345 */           JOptionPane.showMessageDialog(this.jDialog2, "El campo necesita un valor sólo numérico", "Sólo número", 0, this.ERROR);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           return;
/*       */         } 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  6357 */         if (buscarFolioImpreso(this.jTextField34.getText())) {
/*  6358 */           String[] dat = regDatosFolioImpreso(this.jTextField34.getText());
/*  6359 */           this.jTextField34.setBackground(Color.RED);
/*  6360 */           JOptionPane.showMessageDialog(this.jDialog2, "<html>El folio impreso que ingresaste ya corresponde una guía dentro de la base de datos.<p>Estos son los datos que ya están registrados:<p>Guía: <b>" + dat[0] + "</b><p>Fecha: <b>" + dat[1] + "</b><p>Tipo: <b>" + dat[2] + "</b></html>", "Folio impreso duplicado", 1, this.ADVER);
/*       */         } else {
/*  6362 */           int res = JOptionPane.showConfirmDialog(this.padre, "Al generar el Movimiento Interno se cerrará la guía\n¿Estás seguro que deseas complementar la guía?", "Complementar Guía", 0, 3, this.PREG);
/*  6363 */           if (res == 0) {
/*  6364 */             String linea = "";
/*  6365 */             if (this.jComboBox31.isEnabled() && this.jComboBox31.getSelectedIndex() != 0) {
/*  6366 */               linea = String.valueOf(this.jComboBox31.getSelectedItem());
/*       */             } else {
/*  6368 */               linea = "";
/*       */             } 
/*       */             
/*  6371 */             String tipo = "";
/*  6372 */             if (this.jCheckBox1.isSelected()) {
/*  6373 */               tipo = "FULL";
/*       */             } else {
/*  6375 */               tipo = "SENCILLO";
/*       */             } 
/*  6377 */             sacarMayor();
/*  6378 */             String status = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 21));
/*  6379 */             if (status.equals("<Asignada Al Operador>") || status.equals("<Por Timbrar>")) {
/*  6380 */               status = "<Pagada Al Operador: " + cargarFechaHoy() + ">";
/*       */             }
/*  6382 */             this.con.consultar("num_pozo", "pozos", "where nombre = '" + String.valueOf(this.jComboBox29.getSelectedItem()) + "'");
/*       */ 
/*       */ 
/*       */             
/*  6386 */             this.con.inserSinMsj("update guias set manifiesto='" + this.jTextField32.getText().toUpperCase() + "', folio_imp='" + this.jTextField41.getText() + "',estatus='" + status + "' where num_guia = '" + this.jTextField5.getText() + "'");
/*       */ 
/*       */             
/*  6389 */             this.con.inserSinMsj("insert into vales(num_vale,ticket,f_expedicion1,f_expedicion2,f_llegada,f_cargada,f_salida,peso,rsp,estadias,mov,tipo,num_guia,nombre_usu,ope_carga,ope_tira,CLAVE1,CLAVE2,FOLIO_LIQ1,FOLIO_LIQ2,completa,estado) values('" + this.jTextField8
/*  6390 */                 .getText() + "','0',now(),now(),now(),now(),now(),0," + rsp + "," + estadias + "," + mov + ",'SENCILLO','" + this.jTextField5.getText() + "','" + this.USUARIO + "','" + this.jTextField6.getText() + "','MOVIMIENTO INTERNO'," + this.CLAVEO + "," + this.CLAVEO + ",'','',1,'ACTIVO')");
/*  6391 */             ImprimirRSP im = new ImprimirRSP();
/*  6392 */             String[] datos = { this.jTextField8.getText(), this.jTextField5.getText(), this.jTextField10.getText(), String.valueOf(this.jComboBox18.getSelectedItem()), this.jTextField6.getText(), "M0VIMIENTO INTERNO", this.jTextField19.getText(), this.jTextField23.getText(), "-------", "-------", this.jTextField7.getText(), this.jTextField9.getText(), String.valueOf(this.jComboBox17.getSelectedItem()), "0", "0", this.jTextField24.getText(), this.jTextField25.getText(), this.jTextField13.getText(), this.jLabel83.getText(), this.jLabel84.getText(), this.TIPOTRACTOR, tipo };
/*  6393 */             im.recibeDatos(datos);
/*  6394 */             consultar();
/*  6395 */             this.jDialog2.setVisible(false);
/*       */           }
/*       */         
/*       */         }
/*       */       
/*       */       }
/*       */     
/*       */     }
/*  6403 */     else if (opc == 6 || opc == 9) {
/*  6404 */       String servicio = "MANIOBRA";
/*  6405 */       if (opc == 6) {
/*  6406 */         servicio = "MOVIMIENTO LATERAL";
/*  6407 */         JOptionPane.showMessageDialog(this.padre, "<html>Para generar <B><font color = RED>MOVIMIENTO LATERAL</font></B> la carta porte necesita <br>estar firmada y autorizada por el Company Man.</html>", "Generar Movimiento Lateral", 0, this.ADVER);
/*       */       } 
/*  6409 */       if (this.jComboBox17.getSelectedIndex() == 0) {
/*  6410 */         this.error.cargarError(this.jComboBox17, "050");
/*  6411 */       } else if (!this.val.validarSoloNum(this.jTextField24, this.jTextField24.getText()) && 
/*  6412 */         !this.val.validarSoloNum(this.jTextField25, this.jTextField25.getText()) && 
/*  6413 */         !this.val.validarSoloNum(this.jTextField13, this.jTextField13.getText())) {
/*  6414 */         String estadias = this.jTextField25.getText();
/*  6415 */         String mov = this.jTextField13.getText();
/*  6416 */         String rsp = this.jTextField24.getText();
/*  6417 */         if (rsp.equals("")) {
/*  6418 */           rsp = "0";
/*       */         }
/*  6420 */         if (estadias.equals("")) {
/*  6421 */           estadias = "0";
/*       */         }
/*  6423 */         if (mov.equals("")) {
/*  6424 */           mov = "0";
/*       */         }
/*       */         
/*  6427 */         if (this.jTextField33.getText().equals("")) {
/*  6428 */           this.jTextField33.setText("0");
/*       */         }
/*       */         
/*  6431 */         if (this.jTextField18.getText().equals("")) {
/*  6432 */           this.jTextField18.setText("0");
/*       */         }
/*       */         
/*  6435 */         float auxN = 0.0F;
/*       */         try {
/*  6437 */           auxN = Float.parseFloat(this.jTextField33.getText());
/*  6438 */         } catch (NumberFormatException n) {
/*  6439 */           this.jTextField33.setBackground(Color.RED);
/*  6440 */           JOptionPane.showMessageDialog(this.jDialog2, "El campo necesita un valor sólo numérico", "Sólo número", 0, this.ERROR);
/*       */           
/*       */           return;
/*       */         } 
/*  6444 */         auxN = 0.0F;
/*       */         try {
/*  6446 */           auxN = Float.parseFloat(this.jTextField18.getText());
/*  6447 */         } catch (NumberFormatException n) {
/*  6448 */           this.jTextField18.setBackground(Color.RED);
/*  6449 */           JOptionPane.showMessageDialog(this.jDialog2, "El campo necesita un valor sólo numérico", "Sólo número", 0, this.ERROR);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           return;
/*       */         } 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  6461 */         if (buscarFolioImpreso(this.jTextField34.getText())) {
/*  6462 */           String[] dat = regDatosFolioImpreso(this.jTextField34.getText());
/*  6463 */           this.jTextField34.setBackground(Color.RED);
/*  6464 */           JOptionPane.showMessageDialog(this.jDialog2, "<html>El folio impreso que ingresaste ya corresponde una guía dentro de la base de datos.<p>Estos son los datos que ya están registrados:<p>Guía: <b>" + dat[0] + "</b><p>Fecha: <b>" + dat[1] + "</b><p>Tipo: <b>" + dat[2] + "</b></html>", "Folio impreso duplicado", 1, this.ADVER);
/*       */         } else {
/*  6466 */           int res = JOptionPane.showConfirmDialog(this.padre, "Al generar " + servicio + " se cerrará la guía\n¿Estás seguro que deseas complementar la guía?", "Complementar Guía", 0, 3, this.PREG);
/*  6467 */           if (res == 0) {
/*  6468 */             String linea = "";
/*  6469 */             if (this.jComboBox31.isEnabled() && this.jComboBox31.getSelectedIndex() != 0) {
/*  6470 */               linea = String.valueOf(this.jComboBox31.getSelectedItem());
/*       */             } else {
/*  6472 */               linea = "";
/*       */             } 
/*       */             
/*  6475 */             String tipo = "";
/*  6476 */             if (this.jCheckBox1.isSelected()) {
/*  6477 */               tipo = "FULL";
/*       */             } else {
/*  6479 */               tipo = "SENCILLO";
/*       */             } 
/*  6481 */             if (this.jTextField17.getText().equals("")) {
/*  6482 */               this.jTextField17.setText("0");
/*       */             }
/*  6484 */             if (this.jTextField18.getText().equals("")) {
/*  6485 */               this.jTextField18.setText("0");
/*       */             }
/*  6487 */             this.con.consultar("num_pozo", "pozos", "where nombre = '" + String.valueOf(this.jComboBox29.getSelectedItem()) + "'");
/*  6488 */             String clavePozo = this.con.Campo;
/*  6489 */             sacarMayor();
/*  6490 */             String status = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 21));
/*  6491 */             if (status.equals("<Asignada Al Operador>") || status.equals("<Por Timbrar>")) {
/*  6492 */               status = "<Pagada Al Operador: " + cargarFechaHoy() + ">";
/*       */             }
/*       */ 
/*       */             
/*  6496 */             this.con.inserSinMsj("update guias set servicio ='" + servicio + "', folio_imp ='" + this.jTextField41.getText() + "', estatus='" + status + "' where num_guia = '" + this.jTextField5.getText() + "'");
/*       */ 
/*       */             
/*  6499 */             this.con.inserSinMsj("insert into vales(num_vale,ticket,f_expedicion1,f_expedicion2,f_llegada,f_cargada,f_salida,peso,rsp,estadias,mov,tipo,num_guia,nombre_usu,ope_carga,ope_tira,CLAVE1,CLAVE2,FOLIO_LIQ1,FOLIO_LIQ2,completa,estado) values('" + this.jTextField8
/*  6500 */                 .getText() + "','" + this.jTextField17.getText() + "',now(),now(),now(),now(),now()," + this.jTextField18.getText() + "," + rsp + "," + estadias + "," + mov + ",'SENCILLO','" + this.jTextField5.getText() + "','" + this.USUARIO + "','" + this.jTextField6.getText() + "','" + servicio + "'," + this.CLAVEO + "," + this.CLAVEO + ",'','',1,'ACTIVO')");
/*  6501 */             ImprimirRSP im = new ImprimirRSP();
/*  6502 */             String[] datos = { this.jTextField8.getText(), this.jTextField5.getText(), this.jTextField10.getText(), String.valueOf(this.jComboBox18.getSelectedItem()), this.jTextField6.getText(), servicio, this.jTextField19.getText(), this.jTextField23.getText(), "-------", "-------", this.jTextField7.getText(), this.jTextField9.getText(), String.valueOf(this.jComboBox17.getSelectedItem()), "0", "0", this.jTextField24.getText(), this.jTextField25.getText(), this.jTextField13.getText(), this.jLabel83.getText(), this.jLabel84.getText(), this.TIPOTRACTOR, tipo };
/*  6503 */             im.recibeDatos(datos);
/*  6504 */             consultar();
/*  6505 */             this.jDialog2.setVisible(false);
/*       */           }
/*       */         
/*       */         }
/*       */       
/*       */       }
/*       */     
/*  6512 */     } else if (opc == 7) {
/*  6513 */       JOptionPane.showMessageDialog(this.padre, "<html>Para generar <B><font color = RED>ESTADÍA</font></B> la carta porte necesita <br>estar firmada y autorizada por el Company Man.</html>", "Generar Estadía", 0, this.ADVER);
/*  6514 */       if (this.jComboBox17.getSelectedIndex() == 0) {
/*  6515 */         this.error.cargarError(this.jComboBox17, "050");
/*  6516 */       } else if (!this.val.validarSoloNum(this.jTextField24, this.jTextField24.getText()) && 
/*  6517 */         !this.val.validarSoloNum(this.jTextField25, this.jTextField25.getText()) && 
/*  6518 */         !this.val.validarSoloNum(this.jTextField13, this.jTextField13.getText())) {
/*  6519 */         String estadias = this.jTextField25.getText();
/*  6520 */         String mov = this.jTextField13.getText();
/*  6521 */         String rsp = this.jTextField24.getText();
/*  6522 */         if (rsp.equals("")) {
/*  6523 */           rsp = "0";
/*       */         }
/*  6525 */         if (estadias.equals("")) {
/*  6526 */           estadias = "0";
/*       */         }
/*  6528 */         if (mov.equals("")) {
/*  6529 */           mov = "0";
/*       */         }
/*  6531 */         if (this.jTextField33.getText().equals("")) {
/*  6532 */           this.jTextField33.setText("0");
/*       */         }
/*       */         
/*  6535 */         float auxN = 0.0F;
/*       */         try {
/*  6537 */           auxN = Float.parseFloat(this.jTextField33.getText());
/*  6538 */         } catch (NumberFormatException n) {
/*  6539 */           this.jTextField33.setBackground(Color.RED);
/*  6540 */           JOptionPane.showMessageDialog(this.jDialog2, "El campo necesita un valor sólo numérico", "Sólo número", 0, this.ERROR);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           return;
/*       */         } 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  6552 */         if (buscarFolioImpreso(this.jTextField34.getText())) {
/*  6553 */           String[] dat = regDatosFolioImpreso(this.jTextField34.getText());
/*  6554 */           this.jTextField34.setBackground(Color.RED);
/*  6555 */           JOptionPane.showMessageDialog(this.jDialog2, "<html>El folio impreso que ingresaste ya corresponde una guía dentro de la base de datos.<p>Estos son los datos que ya están registrados:<p>Guía: <b>" + dat[0] + "</b><p>Fecha: <b>" + dat[1] + "</b><p>Tipo: <b>" + dat[2] + "</b></html>", "Folio impreso duplicado", 1, this.ADVER);
/*       */         } else {
/*  6557 */           int res = JOptionPane.showConfirmDialog(this.padre, "Al generar la estadía se cerrará la guía\n¿Estás seguro que deseas complementar la guía?", "Complementar Guía", 0, 3, this.PREG);
/*  6558 */           if (res == 0) {
/*  6559 */             String linea = "";
/*  6560 */             if (this.jComboBox31.isEnabled() && this.jComboBox31.getSelectedIndex() != 0) {
/*  6561 */               linea = String.valueOf(this.jComboBox31.getSelectedItem());
/*       */             } else {
/*  6563 */               linea = "";
/*       */             } 
/*       */             
/*  6566 */             String tipo = "";
/*  6567 */             if (this.jCheckBox1.isSelected()) {
/*  6568 */               tipo = "FULL";
/*       */             } else {
/*  6570 */               tipo = "SENCILLO";
/*       */             } 
/*  6572 */             if (this.jTextField17.getText().equals("")) {
/*  6573 */               this.jTextField17.setText("0");
/*       */             }
/*  6575 */             if (this.jTextField18.getText().equals("")) {
/*  6576 */               this.jTextField18.setText("0");
/*       */             }
/*  6578 */             this.con.consultar("num_pozo", "pozos", "where nombre = '" + String.valueOf(this.jComboBox29.getSelectedItem()) + "'");
/*  6579 */             String clavePozo = this.con.Campo;
/*  6580 */             sacarMayor();
/*  6581 */             String status = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 21));
/*  6582 */             if (status.equals("<Asignada Al Operador>") || status.equals("<Por Timbrar>")) {
/*  6583 */               status = "<Pagada Al Operador: " + cargarFechaHoy() + ">";
/*       */             }
/*       */ 
/*       */             
/*  6587 */             this.con.inserSinMsj("update guias set folio_imp='" + this.jTextField41.getText() + "', estatus='" + status + "' where num_guia = '" + this.jTextField5.getText() + "'");
/*       */ 
/*       */             
/*  6590 */             this.con.inserSinMsj("insert into vales(num_vale,ticket,f_expedicion1,f_expedicion2,f_llegada,f_cargada,f_salida,peso,rsp,estadias,mov,tipo,num_guia,nombre_usu,ope_carga,ope_tira,CLAVE1,CLAVE2,FOLIO_LIQ1,FOLIO_LIQ2,completa,estado) values('" + this.jTextField8
/*  6591 */                 .getText() + "','" + this.jTextField17.getText() + "',now(),now(),now(),now(),now()," + this.jTextField18.getText() + "," + rsp + "," + estadias + "," + mov + ",'SENCILLO','" + this.jTextField5.getText() + "','" + this.USUARIO + "','" + this.jTextField6.getText() + "','ESTADIA'," + this.CLAVEO + "," + this.CLAVEO + ",'','',1,'ACTIVO')");
/*  6592 */             ImprimirRSP im = new ImprimirRSP();
/*  6593 */             String[] datos = { this.jTextField8.getText(), this.jTextField5.getText(), this.jTextField10.getText(), String.valueOf(this.jComboBox18.getSelectedItem()), this.jTextField6.getText(), "ESTADIA", this.jTextField19.getText(), this.jTextField23.getText(), "-------", "-------", this.jTextField7.getText(), this.jTextField9.getText(), String.valueOf(this.jComboBox17.getSelectedItem()), "0", "0", this.jTextField24.getText(), this.jTextField25.getText(), this.jTextField13.getText(), this.jLabel83.getText(), this.jLabel84.getText(), this.TIPOTRACTOR, tipo };
/*  6594 */             im.recibeDatos(datos);
/*  6595 */             consultar();
/*  6596 */             this.jDialog2.setVisible(false);
/*       */           }
/*       */         
/*       */         }
/*       */       
/*       */       }
/*       */     
/*  6603 */     } else if (opc == 8) {
/*  6604 */       if (this.jDateChooser1.getDate() == null) {
/*  6605 */         JOptionPane.showMessageDialog(this.jDialog2, "<html>Necesitas colocar la <b>fecha de llegada</b>, el formato es el siguiente:</html>\ndd-mm-aaaa", "Falta Fecha Llegada", 0, this.ERROR);
/*  6606 */       } else if (this.jDateChooser6.getDate() == null) {
/*  6607 */         JOptionPane.showMessageDialog(this.jDialog2, "<html>Necesitas colocar la <b>fecha de carga</b>, el formato es el siguiente:</html>\ndd-mm-aaaa", "Falta Fecha Salida", 0, this.ERROR);
/*  6608 */       } else if (this.jDateChooser3.getDate() == null) {
/*  6609 */         JOptionPane.showMessageDialog(this.jDialog2, "<html>Necesitas colocar la <b>fecha de salida</b>, el formato es el siguiente:</html>\ndd-mm-aaaa", "Falta Fecha Salida", 0, this.ERROR);
/*  6610 */       } else if (this.jDateChooser1.getDate().after(this.jDateChooser6.getDate())) {
/*  6611 */         JOptionPane.showMessageDialog(this.padre, "<html><b>La fecha de carga</b> debe ser mayor o igual a la fecha de llegada</html>\nPor favor confirma las fechas.", "Fechas Erróneas", 0, this.ERROR);
/*  6612 */       } else if (this.jDateChooser1.getDate().after(this.jDateChooser3.getDate())) {
/*  6613 */         JOptionPane.showMessageDialog(this.padre, "<html><b>La fecha de salida</b> debe ser mayor o igual a la fecha de llegada.</html>\nPor favor confirma las fechas.", "Fechas Erróneas", 0, this.ERROR);
/*  6614 */       } else if (this.jComboBox17.getSelectedIndex() == 0) {
/*  6615 */         this.error.cargarError(this.jComboBox17, "050");
/*  6616 */       } else if (!this.val.validarSoloNum(this.jTextField24, this.jTextField24.getText()) && 
/*  6617 */         !this.val.validarSoloNum(this.jTextField25, this.jTextField25.getText()) && 
/*  6618 */         !this.val.validarSoloNum(this.jTextField13, this.jTextField13.getText())) {
/*  6619 */         SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  6620 */         String cadenaFecha1 = formato.format(this.jDateChooser1.getDate());
/*  6621 */         String año = cadenaFecha1.substring(0, 4);
/*  6622 */         String mes = cadenaFecha1.substring(4, 6);
/*  6623 */         String dia = cadenaFecha1.substring(6, 8);
/*  6624 */         String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/*  6625 */         String fenviar1 = dia + "/" + dia + "/" + mes;
/*       */         
/*  6627 */         formato = new SimpleDateFormat("yyyyMMdd");
/*  6628 */         cadenaFecha1 = formato.format(this.jDateChooser3.getDate());
/*  6629 */         año = cadenaFecha1.substring(0, 4);
/*  6630 */         mes = cadenaFecha1.substring(4, 6);
/*  6631 */         dia = cadenaFecha1.substring(6, 8);
/*  6632 */         String fechaCompleta2 = "'" + año + "-" + mes + "-" + dia + "'";
/*  6633 */         String fenviar2 = dia + "/" + dia + "/" + mes;
/*       */         
/*  6635 */         formato = new SimpleDateFormat("yyyyMMdd");
/*  6636 */         cadenaFecha1 = formato.format(this.jDateChooser6.getDate());
/*  6637 */         año = cadenaFecha1.substring(0, 4);
/*  6638 */         mes = cadenaFecha1.substring(4, 6);
/*  6639 */         dia = cadenaFecha1.substring(6, 8);
/*  6640 */         String fechaCompleta3 = "'" + año + "-" + mes + "-" + dia + "'";
/*  6641 */         String fenviar3 = dia + "/" + dia + "/" + mes;
/*       */         
/*  6643 */         if (this.jTextField17.getText().equals("")) {
/*  6644 */           this.jTextField17.setText("0");
/*       */         }
/*  6646 */         if (this.jTextField18.getText().equals("")) {
/*  6647 */           this.jTextField18.setText("0");
/*       */         }
/*       */         
/*  6650 */         if (this.jTextField33.getText().equals("")) {
/*  6651 */           this.jTextField33.setText("0");
/*       */         }
/*       */         
/*  6654 */         if (this.jTextField18.getText().equals("")) {
/*  6655 */           this.jTextField18.setText("0");
/*       */         }
/*       */         
/*  6658 */         float auxN = 0.0F;
/*       */         try {
/*  6660 */           auxN = Float.parseFloat(this.jTextField33.getText());
/*  6661 */         } catch (NumberFormatException n) {
/*  6662 */           this.jTextField33.setBackground(Color.RED);
/*  6663 */           JOptionPane.showMessageDialog(this.jDialog2, "El campo necesita un valor sólo numérico", "Sólo número", 0, this.ERROR);
/*       */           
/*       */           return;
/*       */         } 
/*  6667 */         auxN = 0.0F;
/*       */         try {
/*  6669 */           auxN = Float.parseFloat(this.jTextField18.getText());
/*  6670 */         } catch (NumberFormatException n) {
/*  6671 */           this.jTextField18.setBackground(Color.RED);
/*  6672 */           JOptionPane.showMessageDialog(this.jDialog2, "El campo necesita un valor sólo numérico", "Sólo número", 0, this.ERROR);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*       */           return;
/*       */         } 
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  6684 */         if (buscarFolioImpreso(this.jTextField34.getText())) {
/*  6685 */           String[] dat = regDatosFolioImpreso(this.jTextField34.getText());
/*  6686 */           this.jTextField34.setBackground(Color.RED);
/*  6687 */           JOptionPane.showMessageDialog(this.jDialog2, "<html>El folio impreso que ingresaste ya corresponde una guía dentro de la base de datos.<p>Estos son los datos que ya están registrados:<p>Guía: <b>" + dat[0] + "</b><p>Fecha: <b>" + dat[1] + "</b><p>Tipo: <b>" + dat[2] + "</b></html>", "Folio impreso duplicado", 1, this.ADVER);
/*       */         } else {
/*  6689 */           double ton = redondear(Double.valueOf(Double.parseDouble(this.jTextField18.getText())));
/*  6690 */           this.con.consultar("clave_desti", "emp_destinataria", "where nombreCorto = '" + String.valueOf(this.jComboBox17.getSelectedItem()) + "'");
/*  6691 */           String clave_desti = this.con.Campo;
/*       */           
/*  6693 */           int res = JOptionPane.showConfirmDialog(this.padre, "Al complementar la guía quedará cerrada y no podrás cambiar su información de trámite\n¿Estás seguro que deseas complementar la guía?", "Complementar Guía", 0, 3, this.PREG);
/*  6694 */           if (res == 0) {
/*  6695 */             String linea = "";
/*  6696 */             if (this.jComboBox31.isEnabled() && this.jComboBox31.getSelectedIndex() != 0) {
/*  6697 */               linea = String.valueOf(this.jComboBox31.getSelectedItem());
/*       */             } else {
/*  6699 */               linea = "";
/*       */             } 
/*       */             
/*  6702 */             String rsp = this.jTextField24.getText();
/*  6703 */             String estadias = this.jTextField25.getText();
/*  6704 */             String mov = this.jTextField13.getText();
/*  6705 */             String tipo = "";
/*  6706 */             if (this.jCheckBox1.isSelected()) {
/*  6707 */               tipo = "FULL";
/*       */             } else {
/*  6709 */               tipo = "SENCILLO";
/*       */             } 
/*  6711 */             if (rsp.equals("")) {
/*  6712 */               rsp = "0";
/*       */             }
/*  6714 */             if (estadias.equals("")) {
/*  6715 */               estadias = "0";
/*       */             }
/*  6717 */             if (mov.equals("")) {
/*  6718 */               mov = "0";
/*       */             }
/*       */ 
/*       */             
/*  6722 */             sacarMayor();
/*  6723 */             this.con.inserSinMsj("insert into vales(num_vale,ticket,f_expedicion1,f_expedicion2,f_llegada,f_cargada,f_salida,peso,rsp,estadias,mov,tipo,num_guia,nombre_usu,ope_carga,ope_tira,clave1,clave2,folio_liq1,folio_liq2,completa,estado) values('" + this.jTextField8.getText() + "','" + this.jTextField17.getText() + "',now(),now()," + fechaCompleta + "," + fechaCompleta3 + "," + fechaCompleta2 + "," + ton + "," + rsp + "," + estadias + "," + mov + ",'" + tipo + "','" + this.jTextField5.getText() + "','" + this.USUARIO + "','" + this.jTextField6.getText() + "','" + String.valueOf(this.jComboBox19.getSelectedItem()) + "'," + this.CLAVEO + "," + this.CLAVEO + ",'','',1,'ACTIVO')");
/*  6724 */             String status = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 21));
/*  6725 */             if (status.equals("<Asignada Al Operador>") || status.equals("<Por Timbrar>")) {
/*  6726 */               status = "<Pagada Al Operador: " + cargarFechaHoy() + ">";
/*       */             }
/*  6728 */             this.con.inserSinMsj("update guias set folio_imp='" + this.jTextField41.getText() + "',manifiesto='" + this.jTextField32.getText().toUpperCase() + "', estatus='" + status + "',num_vale = '" + this.jTextField8.getText() + "', servicio='CARGADA LATERAL',linea='" + linea + "',km=" + this.jTextField33.getText() + " where num_guia = '" + this.jTextField5.getText() + "'");
/*       */             
/*  6730 */             ImprimirRSP im = new ImprimirRSP();
/*  6731 */             String[] datos = { this.jTextField8.getText(), this.jTextField5.getText(), this.jTextField10.getText(), String.valueOf(this.jComboBox18.getSelectedItem()), this.jTextField6.getText(), String.valueOf(this.jComboBox19.getSelectedItem()), this.jTextField19.getText(), this.jTextField23.getText(), fenviar1, fenviar2, this.jTextField7.getText(), this.jTextField9.getText(), String.valueOf(this.jComboBox17.getSelectedItem()), this.jTextField17.getText(), this.jTextField18.getText(), this.jTextField24.getText(), this.jTextField25.getText(), this.jTextField13.getText(), this.jLabel83.getText(), this.jLabel84.getText(), this.TIPOTRACTOR, tipo };
/*  6732 */             im.recibeDatos(datos);
/*  6733 */             consultar();
/*  6734 */             this.jDialog2.setVisible(false);
/*       */           } 
/*       */         } 
/*       */       } 
/*       */     } 
/*       */   }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   private void materialButton19ActionPerformed(ActionEvent evt) {
/*  6746 */     this.jComboBox18.setSelectedIndex(0);
/*  6747 */     this.jComboBox19.setSelectedIndex(0);
/*  6748 */     this.jDateChooser1.setDate(this.fechaActual);
/*  6749 */     this.jDateChooser3.setDate(this.fechaActual);
/*  6750 */     this.jComboBox17.setSelectedIndex(0);
/*  6751 */     this.jTextField17.setText("");
/*  6752 */     this.jTextField18.setText("");
/*  6753 */     this.jTextField24.setText("");
/*  6754 */     this.jTextField25.setText("");
/*  6755 */     this.jTextField34.setText("");
/*  6756 */     sacarMayor();
/*       */   }
/*       */   
/*       */   private void materialButton18ActionPerformed(ActionEvent evt) {
/*  6760 */     this.jDialog2.setVisible(false);
/*       */   }
/*       */   
/*       */   private void jLabel17MouseClicked(MouseEvent evt) {
/*  6764 */     int res = JOptionPane.showConfirmDialog(this.padre, this.jPanel21, "Saldar Guía", 0, 3, this.PREG);
/*  6765 */     if (res == 0) {
/*  6766 */       this.con.inserSinMsj("update guias set num_vale='" + String.valueOf(this.jComboBox27.getSelectedItem()) + "', estatus ='<Pagada Al Operador>' where num_guia = '" + this.jTextField5.getText() + "'");
/*  6767 */       this.jDialog2.setVisible(false);
/*  6768 */       consultar();
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jLabel17MouseEntered(MouseEvent evt) {
/*  6773 */     this.jLabel12.setForeground(Color.RED);
/*       */   }
/*       */   
/*       */   private void jLabel17MouseExited(MouseEvent evt) {
/*  6777 */     this.jLabel12.setForeground(Color.BLUE);
/*       */   }
/*       */   
/*       */   private void jTextField11ActionPerformed(ActionEvent evt) {
/*  6781 */     consultar();
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField15ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jComboBox9ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jComboBox15ActionPerformed(ActionEvent evt) {
/*  6793 */     if (this.contador > 0) {
/*  6794 */       String[] lineas = this.con.regresaColIndex("Linea", "lineas,emp_generadora", "where empresa = cliente and nombre_corto ='" + String.valueOf(this.jComboBox15.getSelectedItem()) + "' and estatus='ACTIVA'");
/*  6795 */       if (lineas.length > 0) {
/*  6796 */         this.jComboBox32.removeAllItems();
/*  6797 */         this.jComboBox32.addItem("<VACÍA>");
/*  6798 */         for (int i = 0; i < lineas.length; i++) {
/*  6799 */           this.jComboBox32.addItem(lineas[i]);
/*       */         }
/*  6801 */         this.jComboBox32.setEnabled(true);
/*       */       } else {
/*  6803 */         this.jComboBox32.setEnabled(false);
/*  6804 */         this.jComboBox32.removeAllItems();
/*       */       } 
/*       */     } 
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jComboBox10ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jComboBox24ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jComboBox23ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jComboBox13ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jComboBox12ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */ 
/*       */   
/*       */   private void jComboBox14ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jComboBox28ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void materialButton16ActionPerformed(ActionEvent evt) {
/*  6838 */     this.jDialog4.setVisible(false);
/*       */   }
/*       */   
/*       */   private void materialButton17ActionPerformed(ActionEvent evt) {
/*  6842 */     this.error.pasarModal(true);
/*  6843 */     this.val.pasarModal(Boolean.valueOf(true));
/*  6844 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  6845 */     String cadenaFecha1 = formato.format(this.jDateChooser2.getDate());
/*  6846 */     String año = cadenaFecha1.substring(0, 4);
/*  6847 */     String mes = cadenaFecha1.substring(4, 6);
/*  6848 */     String dia = cadenaFecha1.substring(6, 8);
/*  6849 */     String fechaCompleta = "'" + año + "-" + mes + "-" + dia + " " + this.jTextField16.getText() + "'";
/*       */ 
/*       */     
/*  6852 */     String FECHA = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1));
/*  6853 */     año = FECHA.substring(0, 4);
/*  6854 */     mes = FECHA.substring(5, 7);
/*  6855 */     dia = FECHA.substring(8, 10);
/*  6856 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/*  6857 */     String strFecha = año + "-" + año + "-" + mes;
/*  6858 */     Date fecha = null;
/*       */     try {
/*  6860 */       fecha = formatoDelTexto.parse(strFecha);
/*  6861 */     } catch (ParseException ex) {
/*  6862 */       ex.printStackTrace();
/*       */     } 
/*  6864 */     int dias = (int)((this.jDateChooser2.getDate().getTime() - fecha.getTime()) / 86400000L);
/*  6865 */     if (dias < -30 && !this.DEPARTAMENTO.equals("SUPER USUARIO")) {
/*  6866 */       JOptionPane.showMessageDialog(this.jDialog4, "¡LA FECHA DE LA GUÍA QUE INGREASTE ES MENOR DE 30 DÍAS!\nNecesita modificarla un usuario con privilegios superiores.", "Usuario sin privilegios", 0, this.ERROR);
/*       */       
/*       */       return;
/*       */     } 
/*  6870 */     if ((new Date()).before(this.jDateChooser2.getDate()) && !this.DEPARTAMENTO.equals("SUPER USUARIO")) {
/*  6871 */       JOptionPane.showMessageDialog(this.jDialog4, "La fecha de la guía, no puede ser mayor a la fecha actual, verifica la información.", "Verficia las fechas", 0, this.ERROR);
/*       */       
/*       */       return;
/*       */     } 
/*  6875 */     String[] campos = { "Folio Impreso", "Fecha y Hora", "Servicio", "Carga", "Cliente", "Destino", "Tractor", "Remolque", "Equipo", "Plataforma", "Pozo", "Vehículo", "Operador", "Estatus", "Comentario" };
/*  6876 */     String[] info = { this.jTextField11.getText().toUpperCase(), fechaCompleta, String.valueOf(this.jComboBox22.getSelectedItem()), String.valueOf(this.jComboBox9.getSelectedItem()), String.valueOf(this.jComboBox15.getSelectedItem()), String.valueOf(this.jComboBox10.getSelectedItem()), String.valueOf(this.jComboBox25.getSelectedItem()), String.valueOf(this.jComboBox26.getSelectedItem()), String.valueOf(this.jComboBox11.getSelectedItem()), String.valueOf(this.jComboBox13.getSelectedItem()), String.valueOf(this.jComboBox12.getSelectedItem()), String.valueOf(this.jComboBox23.getSelectedItem()), String.valueOf(this.jComboBox24.getSelectedItem()), String.valueOf(this.jComboBox14.getSelectedItem()), this.jTextArea2.getText().toUpperCase() };
/*  6877 */     int res = this.error.cargarDatos(campos, info);
/*  6878 */     if (res == 0) {
/*       */ 
/*       */       
/*  6881 */       this.con.consultar("clave_desti", "emp_destinataria", "where nombrecorto = '" + String.valueOf(this.jComboBox10.getSelectedItem()) + "'");
/*  6882 */       String destino = this.con.Campo;
/*  6883 */       this.con.consultar("num_equipo", "equipos", "where equipo = '" + String.valueOf(this.jComboBox11.getSelectedItem()) + "'");
/*  6884 */       String equipo = this.con.Campo;
/*  6885 */       this.con.consultar("num_plata", "plataformas", "where plataforma = '" + String.valueOf(this.jComboBox13.getSelectedItem()) + "'");
/*  6886 */       String plataforma = this.con.Campo;
/*  6887 */       this.con.consultar("num_pozo", "pozos", "where nombre = '" + String.valueOf(this.jComboBox12.getSelectedItem()) + "'");
/*  6888 */       String pozo = this.con.Campo;
/*       */       
/*  6890 */       String linea = "";
/*  6891 */       if (this.jComboBox32.isEnabled()) {
/*  6892 */         linea = String.valueOf(this.jComboBox32.getSelectedItem());
/*       */       }
/*  6894 */       if (this.jComboBox32.getSelectedIndex() == 0) {
/*  6895 */         linea = "";
/*       */       }
/*       */       
/*  6898 */       String[] datRem = this.con.regresaRegIndex("placas", "remolque", "where num_rem= " + String.valueOf(this.jComboBox26.getSelectedItem()));
/*       */       
/*  6900 */       this.con.inserSinMsj("update guias set rem1 ='" + String.valueOf(this.jComboBox26.getSelectedItem()) + "', placas1='" + datRem[0] + "', folio_imp = '" + this.jTextField43.getText().toUpperCase() + "', operador = '" + String.valueOf(this.jComboBox24.getSelectedItem()) + "', fecha =" + fechaCompleta + ", servicio = '" + String.valueOf(this.jComboBox22.getSelectedItem()) + "', tipo='" + String.valueOf(this.jComboBox23.getSelectedItem()) + "', estado ='" + String.valueOf(this.jComboBox14.getSelectedItem()) + "', estatus='" + String.valueOf(this.jComboBox28.getSelectedItem()) + "',linea='" + linea + "' where num_guia = '" + this.GUIA + "'");
/*  6901 */       this.con.inserSinMsj("update llamadas_historicas set residuo = '" + String.valueOf(this.jComboBox9.getSelectedItem()) + "', descrip = '" + this.jTextArea2.getText().toUpperCase() + "', num_equipo=" + equipo + ", num_plata = " + plataforma + ", num_pozo = " + pozo + ", num_ope = " + this.CLAVEOPERADOR[this.jComboBox24.getSelectedIndex()] + ", clave_gene = " + this.LLAVESGENE[this.jComboBox15.getSelectedIndex()] + ", clave_desti=" + destino + ",num_tracto=" + String.valueOf(this.jComboBox25.getSelectedItem()) + ", num_rem = " + String.valueOf(this.jComboBox26.getSelectedItem()) + " where num_guia = '" + this.GUIA + "'");
/*       */       
/*  6903 */       this.jDialog4.setVisible(false);
/*       */       
/*  6905 */       consultar();
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jButton25ActionPerformed(ActionEvent evt) {
/*  6910 */     int ind = this.rSTableMetro1.getSelectedRow();
/*  6911 */     if (ind < 0) {
/*  6912 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una guía para poder generar copiar los datos", "Selecciona una guía", 0, this.ADVER);
/*       */     } else {
/*  6914 */       String guia = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString();
/*  6915 */       GuiasForm form = new GuiasForm(this.USUARIO, this.padre, this.CAMPOSGENERALES, "COPIAR", this.actualizado, this.LISTACODIGOS, this.CODIGOSP, guia);
/*  6916 */       this.actualizado = form.actualizado;
/*  6917 */       if (this.actualizado) {
/*  6918 */         consultar();
/*       */         return;
/*       */       } 
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   private void rSTableMetro1MouseEntered(MouseEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jButton26ActionPerformed(ActionEvent evt) {
/*  6929 */     int reg = this.rSTableMetro1.getSelectedRow();
/*  6930 */     boolean entro = false;
/*  6931 */     if (reg >= 0) {
/*  6932 */       liberarGuia();
/*       */     } else {
/*  6934 */       JOptionPane.showMessageDialog(this.padre, "Selecciona una guía para poder LIBERAR los datos", "Selecciona una Guía", 0, this.ADVER);
/*       */     } 
/*       */   }
/*       */   
/*       */   private void jTextField46KeyReleased(KeyEvent evt) {
/*  6939 */     String cadena = this.jTextField46.getText();
/*  6940 */     if (!cadena.equals("")) {
/*  6941 */       if (this.presionado == null) {
/*  6942 */         this.presionado = new Presionado();
/*  6943 */         this.presionado.start();
/*       */       } else {
/*  6945 */         this.presionado.detenerFuera();
/*  6946 */         this.presionado = new Presionado();
/*  6947 */         this.presionado.start();
/*       */       } 
/*       */     }
/*       */   }
/*       */   
/*       */   private void jTextField47KeyReleased(KeyEvent evt) {
/*  6953 */     String cadena = this.jTextField47.getText();
/*  6954 */     if (!cadena.equals("")) {
/*  6955 */       if (this.presionado == null) {
/*  6956 */         this.presionado = new Presionado();
/*  6957 */         this.presionado.start();
/*       */       } else {
/*  6959 */         this.presionado.detenerFuera();
/*  6960 */         this.presionado = new Presionado();
/*  6961 */         this.presionado.start();
/*       */       } 
/*       */     }
/*       */   }
/*       */   
/*       */   private void jButton27ActionPerformed(ActionEvent evt) {
/*  6967 */     int reg = this.rSTableMetro1.getSelectedRow();
/*  6968 */     if (reg >= 0) {
/*  6969 */       this.jTextField87.setText(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 25).toString());
/*  6970 */       this.jTextField88.setText(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 26).toString());
/*  6971 */       this.con.consultar("actualizacion", "guias", "where num_guia = '" + String.valueOf(this.rSTableMetro1.getValueAt(reg, 0)) + "'");
/*  6972 */       this.jTextField89.setText(this.con.Campo);
/*  6973 */       this.jDialog18.setVisible(true);
/*       */     } else {
/*  6975 */       JOptionPane.showMessageDialog(this.padre, "Selecciona una guía para poder confirmar los datos de DO y LID", "Selecciona una Guía", 0, this.ADVER);
/*       */     } 
/*       */   }
/*       */ 
/*       */ 
/*       */   
/*       */   private void jTextField87ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void jTextField88ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   private void materialButton24ActionPerformed(ActionEvent evt) {
/*  6988 */     String datDO = this.jTextField87.getText();
/*  6989 */     String datLID = this.jTextField88.getText();
/*  6990 */     int selec = this.rSTableMetro1.getSelectedRow();
/*  6991 */     String guia1 = "";
/*  6992 */     String guia2 = "";
/*       */     
/*  6994 */     boolean encontrado1 = this.con.consultar("num_guia", "guias", "where do = '" + datDO + "' and num_guia != '" + String.valueOf(this.rSTableMetro1.getValueAt(selec, 0)) + "'");
/*  6995 */     guia1 = this.con.Campo;
/*  6996 */     boolean encontrado2 = this.con.consultar("num_guia", "guias", "where lid = '" + datLID + "' and num_guia != '" + String.valueOf(this.rSTableMetro1.getValueAt(selec, 0)) + "'");
/*  6997 */     guia2 = this.con.Campo;
/*  6998 */     boolean sigue = true;
/*       */     
/*  7000 */     if (this.jTextField87.getText().equals("")) {
/*  7001 */       this.jTextField87.setBackground(Color.RED);
/*  7002 */       JOptionPane.showMessageDialog(this.jDialog8, "No puedes dejar el campo del DO vacío", "Falta Información", 2, this.ERROR);
/*  7003 */     } else if (this.jTextField88.getText().equals("")) {
/*  7004 */       this.jTextField88.setBackground(Color.RED);
/*  7005 */       JOptionPane.showMessageDialog(this.jDialog8, "No puedes dejar el campo del LID vacío", "Falta Información", 2, this.ERROR);
/*       */     } else {
/*  7007 */       if (encontrado1) {
/*  7008 */         JOptionPane.showMessageDialog(this.jDialog8, "El D.O. ya se encuentra registrado en otra GUIA: " + guia1, "DO Duplicado", 2, this.ERROR);
/*  7009 */         sigue = false;
/*       */       } 
/*       */       
/*  7012 */       if (encontrado2) {
/*  7013 */         JOptionPane.showMessageDialog(this.jDialog8, "El L.I.D. ya se encuentra registrado en otra GUIA: " + guia2, "LID Duplicado", 2, this.ERROR);
/*  7014 */         sigue = false;
/*       */       } 
/*       */       
/*  7017 */       if (sigue) {
/*  7018 */         int res = JOptionPane.showConfirmDialog(this.jDialog8, "¿Estás seguro que deseas confirmar los datos?", "Confirmación", 0, 3, this.PREG);
/*  7019 */         if (res == 0) {
/*  7020 */           String act = this.USUARIO + ": CONFIRMADO " + this.USUARIO;
/*  7021 */           this.con.inserSinMsj("update guias set do ='" + this.jTextField87.getText().toUpperCase() + "', lid='" + this.jTextField88.getText().toUpperCase() + "', actualizacion='" + act + "' where num_guia = '" + String.valueOf(this.rSTableMetro1.getValueAt(selec, 0)) + "'");
/*  7022 */           this.jDialog18.setVisible(false);
/*  7023 */           consultar();
/*       */         } 
/*       */       } 
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   private void jTextField89ActionPerformed(ActionEvent evt) {}
/*       */ 
/*       */   
/*       */   public void liberarGuia() {
/*  7034 */     int res = JOptionPane.showConfirmDialog(this.padre, "<html><p><strong><center>¡¡¡ A D V E R T E N C I A !!!</center></strong><p><p>Al <strong>LIBERAR</strong> la guía; se le quitará la factura y el estatus volverá al original <strong> POR TIMBRAR</strong>,<p> los datos originales quedarán registrados en las observaciones.<p><p>¿Deseas seguir con la modificación?</p></html>", "Liberando la guia...", 0, 0, this.ADVER);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  7043 */     if (res == 0) {
/*  7044 */       String fact = "CFDI ANTERIOR: " + this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), this.rSTableMetro1.getColumnCount() - 3).toString();
/*  7045 */       String descripcion = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), this.rSTableMetro1.getColumnCount() - 5).toString();
/*  7046 */       this.con.inserSinMsj("update llamadas_historicas set descrip ='" + descripcion + " \n\n " + fact + "' where num_guia ='" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)) + "'");
/*  7047 */       this.con.inserSinMsj("update guias set estatus = '<Por Timbrar>', factImpresa = '' where num_guia ='" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)) + "'");
/*  7048 */       consultar();
/*       */     } 
/*       */   }
/*       */   
/*       */   public void modificarGuiaAnterior() {
/*  7053 */     int reg = this.rSTableMetro1.getSelectedRow();
/*  7054 */     cargarGuia();
/*  7055 */     if (this.DEPARTAMENTO.equals("SUPER USUARIO")) {
/*  7056 */       this.jDateChooser2.setEnabled(true);
/*  7057 */       this.jComboBox22.setEnabled(true);
/*       */       
/*  7059 */       this.jComboBox9.setEnabled(true);
/*  7060 */       this.jComboBox15.setEnabled(true);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  7069 */       this.jComboBox10.setEnabled(true);
/*  7070 */       this.jComboBox25.setEnabled(true);
/*  7071 */       this.jComboBox26.setEnabled(true);
/*  7072 */       this.jComboBox11.setEnabled(true);
/*  7073 */       this.jComboBox13.setEnabled(true);
/*  7074 */       this.jComboBox12.setEnabled(true);
/*  7075 */       this.jComboBox23.setEnabled(true);
/*  7076 */       this.jComboBox24.setEnabled(true);
/*  7077 */       this.jComboBox14.setEnabled(true);
/*  7078 */       this.jComboBox28.setEnabled(true);
/*  7079 */       this.jTextArea2.setEnabled(true);
/*  7080 */       if (this.USUARIO.equals("JQUIROZ")) {
/*  7081 */         this.jComboBox28.setEnabled(false);
/*  7082 */         this.jComboBox14.setEnabled(false);
/*       */       }
/*       */     
/*       */     } else {
/*       */       
/*  7087 */       this.jDateChooser2.setEnabled(false);
/*  7088 */       this.jComboBox22.setEnabled(true);
/*  7089 */       this.jComboBox9.setEnabled(true);
/*  7090 */       this.jComboBox15.setEnabled(true);
/*  7091 */       this.jComboBox32.setEnabled(true);
/*  7092 */       this.jComboBox10.setEnabled(true);
/*  7093 */       this.jComboBox25.setEnabled(true);
/*  7094 */       this.jComboBox26.setEnabled(true);
/*  7095 */       this.jComboBox11.setEnabled(false);
/*  7096 */       this.jComboBox13.setEnabled(false);
/*  7097 */       this.jComboBox12.setEnabled(false);
/*  7098 */       this.jComboBox23.setEnabled(true);
/*  7099 */       this.jComboBox24.setEnabled(true);
/*  7100 */       this.jComboBox14.setEnabled(false);
/*  7101 */       this.jComboBox28.setEnabled(false);
/*  7102 */       this.jTextArea2.setEnabled(true);
/*       */     } 
/*  7104 */     this.GUIA = String.valueOf(this.rSTableMetro1.getValueAt(reg, 0));
/*  7105 */     this.jDialog4.setTitle("GUÍA: " + String.valueOf(this.rSTableMetro1.getValueAt(reg, 0)));
/*  7106 */     this.jDialog4.setVisible(true);
/*       */   }
/*       */   
/*       */   public int dameInd(String[] campos, String contenido) {
/*  7110 */     int indice = -1;
/*  7111 */     for (int i = 0; i < campos.length; i++) {
/*  7112 */       if (campos[i].equals(contenido)) {
/*  7113 */         return i;
/*       */       }
/*       */     } 
/*  7116 */     return indice;
/*       */   }
/*       */   
/*       */   public void activarComplemento() {
/*  7120 */     this.jTextField36.setText(this.RUTA);
/*  7121 */     this.jDialog30.setVisible(true);
/*       */   }
/*       */   
/*       */   public String direccion() {
/*  7125 */     JFileChooser fileChooser = new JFileChooser();
/*  7126 */     fileChooser.setFileSelectionMode(1);
/*  7127 */     String fileName = "";
/*  7128 */     int retVal = fileChooser.showSaveDialog(null);
/*  7129 */     if (retVal == 0) {
/*  7130 */       fileName = fileChooser.getSelectedFile().getAbsolutePath();
/*  7131 */       return fileName;
/*       */     } 
/*  7133 */     return "no";
/*       */   }
/*       */   
/*       */   public boolean buscarFolioImpreso(String guia) {
/*  7137 */     boolean esta = false;
/*  7138 */     if (guia.equals("")) {
/*  7139 */       return false;
/*       */     }
/*  7141 */     esta = this.con.consultar("folio_imp", "guias", "where folio_imp = '" + guia + "' and num_guia <>'" + this.jTextField8.getText() + "'");
/*       */     
/*  7143 */     return esta;
/*       */   }
/*       */   
/*       */   public void cargarOrigenes() {
/*  7147 */     String[] guias = this.con.regresaColIndex("num_guia", "llamadas_historicas", "where fecha_ped>'2021-10-31'");
/*       */     
/*  7149 */     for (int i = 0; i < guias.length; i++) {
/*  7150 */       this.con.consultar("nombre", "tras_cartaporte_ubic", "where guia = '" + guias[i] + "' and tipo_ubic = 'ORIGEN'");
/*  7151 */       this.con.inserSinMsj("update llamadas_historicas set origen = '" + this.con.Campo + "' where num_guia = '" + guias[i] + "'");
/*       */     } 
/*       */   }
/*       */   
/*       */   public void crearGuia(String nombre) throws IOException {
/*  7156 */     String[] fact = nombre.split("-");
/*  7157 */     String folio = "T" + fact[0] + fact[1];
/*  7158 */     BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.RUTA + "/" + this.RUTA + ".yaml"), "utf-8"));
/*  7159 */     out.write("\n");
/*  7160 */     out.write("#Archivo propiedad de Fletes y Materiales Forsis, SA de CV\n");
/*  7161 */     out.write("#Desarrollador T.I. Uzziel Contreras Portilla - kofuz01@gmail.com\n");
/*  7162 */     out.write("#Este formato es compatible con YAML (http://www.yaml.org/spec/1.2/spec.html). \n");
/*  7163 */     out.write("\n");
/*  7164 */     out.write("--- !diverza.com/v2.0\n\n");
/*  7165 */     out.write("#DATOS GENERALES\n");
/*  7166 */     out.write("Comprobante:\n\n");
/*  7167 */     out.write("  NombreCfdi: \"" + folio + "\"\n");
/*  7168 */     out.write("  RefId: \"" + folio + "\"\n");
/*  7169 */     out.write("  Version: \"3.3\"\n");
/*  7170 */     out.write("  Serie: \"T" + fact[0] + "\"\n");
/*  7171 */     out.write("  Folio: \"" + fact[1] + "\"\n");
/*       */     
/*  7173 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  7174 */     String fecha = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 2).toString();
/*  7175 */     String año = fecha.substring(0, 4);
/*  7176 */     String mes = fecha.substring(5, 7);
/*  7177 */     String dia = fecha.substring(8, 10);
/*  7178 */     String hh = fecha.substring(11, 13);
/*  7179 */     String mm = fecha.substring(14, 16);
/*  7180 */     String ss = fecha.substring(17, 19);
/*  7181 */     out.write("  Fecha: \"" + año + "-" + mes + "-" + dia + "T" + hh + ":" + mm + ":" + ss + "\"\n");
/*  7182 */     out.write("  Sello: \"\"\n");
/*  7183 */     out.write("  NoCertificado: \"" + this.CERTIFICADO + "\"\n");
/*  7184 */     out.write("  Certificado: \"\"\n");
/*  7185 */     out.write("  SubTotal: \"0\"\n");
/*  7186 */     out.write("  Moneda: \"MXN\"\n");
/*  7187 */     out.write("  TipoCambio: \"1\"\n");
/*  7188 */     out.write("  Total: \"0\"\n");
/*  7189 */     out.write("  TipoDeComprobante: \"T\"\n");
/*  7190 */     out.write("  LugarExpedicion: \"" + this.CODIGOPOSTAL + "\"\n\n");
/*  7191 */     out.write("\n");
/*  7192 */     out.write("  Emisor:\n");
/*  7193 */     out.write("    Rfc: \"FMF901004UZ9\"\n");
/*  7194 */     out.write("    Nombre: \"FLETES Y MATERIALES FORSIS, S.A. DE C.V.\"\n");
/*  7195 */     out.write("    RegimenFiscal: \"624\"\n\n");
/*       */     
/*  7197 */     out.write("  Receptor: \n");
/*  7198 */     out.write("    Rfc: \"XAXX010101000\"\n");
/*  7199 */     out.write("    UsoCFDI: \"P01\"\n\n");
/*       */     
/*  7201 */     String[] datos = this.con.regresaReg("claveProdSat, claveUnidadSat, claveProdSatDesc", "tras_cartaporte_mercancias", "where guia ='" + 
/*       */ 
/*       */         
/*  7204 */         String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)) + "'", 3);
/*  7205 */     out.write("  Conceptos: \n");
/*  7206 */     out.write("    -\n");
/*  7207 */     out.write("      Concepto: \"\"\n");
/*  7208 */     out.write("      ClaveProdServ: \"" + datos[0] + "\"\n");
/*  7209 */     out.write("      NoIdentificacion: \"" + datos[1] + "\"\n");
/*  7210 */     out.write("      Cantidad: \"1\"\n");
/*  7211 */     out.write("      ClaveUnidad: \"" + datos[1] + "\"\n");
/*  7212 */     out.write("      Unidad: \"" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 4)) + "\"\n");
/*  7213 */     out.write("      Descripcion: \"" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 5)) + " - " + datos[2] + "\"\n");
/*  7214 */     out.write("      ValorUnitario: \"0\"\n");
/*  7215 */     out.write("      Importe: \"0\"\n");
/*       */     
/*  7217 */     out.write("\n");
/*  7218 */     out.write("  Addenda: \n");
/*  7219 */     out.write("    Diverza: \n");
/*  7220 */     out.write("      Version: \"1.1\"\n\n");
/*  7221 */     out.write("      Generales: \n");
/*       */     
/*  7223 */     out.write("      DatosContactoE: \n");
/*  7224 */     out.write("        Telefono: \"01 (229) 924-8600 al 03\"\n");
/*  7225 */     out.write("        Web: \"www.forsis.com.mx\"\n\n");
/*       */     
/*  7227 */     out.write("      Emisor: \n");
/*  7228 */     out.write("        DomicilioFiscalE: \n");
/*  7229 */     out.write("          Calle: \"AUTOPISTA CADEREYTA - MONTERREY\"\n");
/*  7230 */     out.write("          Numero: \"KM 32.5\"\n");
/*  7231 */     out.write("          Ciudad: \"CADEREYTA JIMENEZ\"\n");
/*  7232 */     out.write("          Municipio: \"CADEREYTA JIMENEZ\"\n");
/*  7233 */     out.write("          Estado: \"NUEVO LEON\"\n");
/*  7234 */     out.write("          Pais: \"MEXICO\"\n");
/*  7235 */     out.write("          CodigoPostal: \"67483\"\n");
/*  7236 */     out.write("        SucursalE: \n");
/*  7237 */     out.write("          Alias: \"" + this.SUCURSAL + "\"\n");
/*  7238 */     out.write("          DomicilioSucursal: \n");
/*  7239 */     out.write("            Calle: \"CARRETERA A CARDEL (NUEVA ERA) KM 5\"\n");
/*  7240 */     out.write("            Ciudad: \"VERACRUZ\"\n");
/*  7241 */     out.write("            Estado: \"VERACRUZ\"\n");
/*  7242 */     out.write("            Pais: \"MÉXICO\"\n");
/*  7243 */     out.write("            CodigoPostal: \"91809\"\n\n");
/*       */     
/*  7245 */     out.write("  LeyendasImpresion: \n");
/*  7246 */     out.write("    -\n");
/*  7247 */     out.write("      Atributo: \"SEMARNAT\"\n");
/*  7248 */     out.write("      Valor: \"PERMISO SEMARNAT 19-I-036D-10, PERMISO SCT CG20045\"\n");
/*       */     
/*  7250 */     out.write("      Atributo: \"IMPUESTO RETENIDO\"\n");
/*  7251 */     out.write("      Valor: \"IMPUESTO RETENIDO DE CONFORMIDAD CON LA LEY DEL IMPUESTO AL VALOR AGREGADO\"\n");
/*       */     
/*  7253 */     out.write("      Atributo: \"DEBEMOS\"\n");
/*  7254 */     out.write("      Valor: \"DEBO(MOS) Y PAGARE(MOS) INCONDICIONALMENTE EN ESTA CIUDAD A LA ORDEN DE FLETES Y MATERIALES FORSIS, S.A. DE C.V. LA CANTIDAD QUE SE INDICA COMO TOTAL EN ESTE DOCUMENTO, VALOR DEL SERCIVIO ARRIBA DESCRITO Y QUE HEMOS RECIBIDO DE CONFORMIDAD, SI ESTA CANTIDAD NO FUERE CUBIERTA A LA PRESENTACION DE ESTE PAGARE, CAUSARA INTERESES MORATORIOS A RAZON DE % ANUAL HASTA SU TOTAL SOLUCION\"\n");
/*  7255 */     out.write("---");
/*  7256 */     out.close();
/*       */   }
/*       */   
/*       */   public void consultarDir() {
/*  7260 */     this.encontrado = this.con.consultar("count(num)", "direcciones", "where nombre_usu = '" + this.USUARIO + "'");
/*  7261 */     int totreg = Integer.parseInt(this.con.Campo);
/*  7262 */     String[] direcciones = this.con.regresaCol("correo", "direcciones", "where nombre_usu = '" + this.USUARIO + "' order by correo", totreg);
/*       */     
/*  7264 */     for (int i = 0; i < direcciones.length; i++) {
/*  7265 */       direcciones[i] = direcciones[i].toLowerCase();
/*       */     }
/*  7267 */     this.jList1.setListData(direcciones);
/*       */   }
/*       */   
/*       */   public String[] regDatosFolioImpreso(String guia) {
/*  7271 */     String[] campos = this.con.regresaReg("num_guia, fecha, tipo", "guias", "where folio_imp like '%" + guia + "%'", 3);
/*  7272 */     return campos;
/*       */   }
/*       */   
/*       */   public int alinearDer(int x, int letras) {
/*  7276 */     int quitar = 1 * letras;
/*  7277 */     x -= quitar;
/*  7278 */     return x;
/*       */   }
/*       */   
/*       */   public void colorear() {
/*  7282 */     this.pintar.colorear(this.jComboBox37);
/*  7283 */     this.pintar.colorear(this.jComboBox36);
/*  7284 */     this.pintar.colorear(this.jTextField1);
/*  7285 */     this.pintar.colorear(this.jTextField1);
/*  7286 */     this.pintar.colorear(this.jTextField1);
/*  7287 */     this.pintar.colorear(this.jTextField26);
/*  7288 */     this.pintar.colorear(this.jTextField27);
/*  7289 */     this.pintar.colorear(this.jTextField32);
/*  7290 */     this.pintar.colorear(this.jTextField2);
/*  7291 */     this.pintar.colorear(this.jTextArea6);
/*  7292 */     this.pintar.colorear(this.jTextField3);
/*  7293 */     this.pintar.colorear(this.jTextField4);
/*  7294 */     this.pintar.colorear(this.jTextField14);
/*  7295 */     this.pintar.colorear(this.jTextField13);
/*  7296 */     this.pintar.colorear(this.jTextField17);
/*  7297 */     this.pintar.colorear(this.jTextField18);
/*  7298 */     this.pintar.colorear(this.jTextField24);
/*  7299 */     this.pintar.colorear(this.jTextField17);
/*  7300 */     this.pintar.colorear(this.jComboBox29);
/*  7301 */     this.pintar.colorear(this.jComboBox30);
/*  7302 */     this.pintar.colorear(this.jComboBox20);
/*  7303 */     this.pintar.colorear(this.jComboBox1);
/*  7304 */     this.pintar.colorear(this.jComboBox2);
/*  7305 */     this.pintar.colorear(this.jComboBox3);
/*  7306 */     this.pintar.colorear(this.jComboBox4);
/*  7307 */     this.pintar.colorear(this.jComboBox5);
/*  7308 */     this.pintar.colorear(this.jComboBox6);
/*  7309 */     this.pintar.colorear(this.jComboBox7);
/*  7310 */     this.pintar.colorear(this.jComboBox8);
/*  7311 */     this.pintar.colorear(this.jComboBox18);
/*  7312 */     this.pintar.colorear(this.jComboBox19);
/*  7313 */     this.pintar.colorear(this.jTextField25);
/*  7314 */     this.pintar.colorear(this.jTextField15);
/*  7315 */     this.pintar.colorear(this.jTextField16);
/*  7316 */     this.pintar.colorear(this.jTextField34);
/*  7317 */     this.pintar.colorear(this.jTextField35);
/*  7318 */     this.pintar.colorear(this.jTextField31);
/*  7319 */     this.pintar.colorear(this.jComboBox9);
/*  7320 */     this.pintar.colorear(this.jComboBox10);
/*  7321 */     this.pintar.colorear(this.jComboBox11);
/*  7322 */     this.pintar.colorear(this.jComboBox12);
/*  7323 */     this.pintar.colorear(this.jComboBox13);
/*  7324 */     this.pintar.colorear(this.jComboBox14);
/*  7325 */     this.pintar.colorear(this.jComboBox15);
/*  7326 */     this.pintar.colorear(this.jComboBox16);
/*  7327 */     this.pintar.colorear(this.jComboBox17);
/*  7328 */     this.pintar.colorear(this.jComboBox22);
/*  7329 */     this.pintar.colorear(this.jComboBox9);
/*  7330 */     this.pintar.colorear(this.jComboBox15);
/*  7331 */     this.pintar.colorear(this.jComboBox10);
/*  7332 */     this.pintar.colorear(this.jComboBox25);
/*  7333 */     this.pintar.colorear(this.jComboBox26);
/*  7334 */     this.pintar.colorear(this.jComboBox11);
/*  7335 */     this.pintar.colorear(this.jComboBox13);
/*  7336 */     this.pintar.colorear(this.jComboBox12);
/*  7337 */     this.pintar.colorear(this.jComboBox23);
/*  7338 */     this.pintar.colorear(this.jComboBox24);
/*  7339 */     this.pintar.colorear(this.jComboBox28);
/*  7340 */     this.pintar.colorear(this.jComboBox31);
/*  7341 */     this.pintar.colorear(this.jComboBox14);
/*  7342 */     this.pintar.colorear(this.jTextArea2);
/*  7343 */     this.pintar.colorear(this.jTextField11);
/*  7344 */     this.pintar.colorear(this.jTextField12);
/*  7345 */     this.pintar.colorear(this.jTextField37);
/*  7346 */     this.pintar.colorear(this.jTextField38);
/*  7347 */     this.pintar.colorear(this.jTextField39);
/*  7348 */     this.pintar.colorear(this.jTextField40);
/*       */   }
/*       */   
/*       */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/*  7352 */     campo.setBackground(new Color(153, 255, 153));
/*       */   }
/*       */   
/*       */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/*  7356 */     campo.setBackground(Color.white);
/*       */   }
/*       */   
/*       */   public void jPintarTexto(JComponent campo) {
/*  7360 */     campo.setBackground(Color.ORANGE);
/*       */   }
/*       */   
/*       */   public void tieneTexto() {
/*  7364 */     if (!this.jTextField1.getText().equals("")) {
/*  7365 */       jPintarTexto(this.jTextField1);
/*       */     }
/*  7367 */     if (!this.jTextField2.getText().equals("")) {
/*  7368 */       jPintarTexto(this.jTextField2);
/*       */     }
/*  7370 */     if (!this.jTextField3.getText().equals("")) {
/*  7371 */       jPintarTexto(this.jTextField3);
/*       */     }
/*  7373 */     if (!this.jTextField4.getText().equals("")) {
/*  7374 */       jPintarTexto(this.jTextField4);
/*       */     }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  7382 */     if (this.jComboBox8.getSelectedIndex() != 0) {
/*  7383 */       jPintarTexto(this.jComboBox8);
/*       */     }
/*  7385 */     if (this.jComboBox20.getSelectedIndex() != 0) {
/*  7386 */       jPintarTexto(this.jComboBox20);
/*       */     }
/*  7388 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/*  7389 */       jPintarTexto(this.jComboBox1);
/*       */     }
/*  7391 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/*  7392 */       jPintarTexto(this.jComboBox2);
/*       */     }
/*  7394 */     if (this.jComboBox16.getSelectedIndex() != 0) {
/*  7395 */       jPintarTexto(this.jComboBox16);
/*       */     }
/*  7397 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/*  7398 */       jPintarTexto(this.jComboBox3);
/*       */     }
/*  7400 */     if (this.jComboBox4.getSelectedIndex() != 0) {
/*  7401 */       jPintarTexto(this.jComboBox4);
/*       */     }
/*  7403 */     if (this.jComboBox5.getSelectedIndex() != 0) {
/*  7404 */       jPintarTexto(this.jComboBox5);
/*       */     }
/*  7406 */     if (this.jComboBox6.getSelectedIndex() != 0) {
/*  7407 */       jPintarTexto(this.jComboBox6);
/*       */     }
/*  7409 */     if (this.jComboBox7.getSelectedIndex() != 0) {
/*  7410 */       jPintarTexto(this.jComboBox7);
/*       */     }
/*       */   }
/*       */   
/*       */   public String[] regresaLineas() {
/*  7415 */     return this.LINEAS;
/*       */   }
/*       */   
/*       */   public void sacarDepa() {
/*  7419 */     this.con.consultar("priv", "usuarios", "where nombre_usu = '" + this.USUARIO + "'");
/*  7420 */     this.DEPARTAMENTO = this.con.Campo;
/*       */   }
/*       */ 
/*       */   
/*       */   public String cargarFechaHoy() {
/*  7425 */     Calendar ahoraCal = Calendar.getInstance();
/*  7426 */     ahoraCal.setTime(this.fecha);
/*  7427 */     String mesesito = "";
/*  7428 */     String hoy = "";
/*  7429 */     mesesito = "" + ahoraCal.get(2) + 1;
/*  7430 */     hoy = "" + ahoraCal.get(5);
/*       */     
/*  7432 */     if (ahoraCal.get(2) + 1 < 10) {
/*  7433 */       mesesito = "0" + mesesito;
/*       */     }
/*  7435 */     if (ahoraCal.get(5) < 10) {
/*  7436 */       hoy = "0" + hoy;
/*       */     }
/*  7438 */     return hoy + "/" + hoy + "/" + mesesito;
/*       */   }
/*       */   
/*       */   public void cancelar() {
/*  7442 */     String motivo = this.jTextField14.getText();
/*  7443 */     if (motivo.equals("")) {
/*  7444 */       this.error.cargarError(this.jTextField14, "050");
/*  7445 */     } else if (!this.val.validarApostrofe(this.jTextField14, motivo, "020")) {
/*  7446 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "¿Estás seguro que deseas cancelar la guía?", "Cancelar Guía", 0, 3, this.PREG);
/*  7447 */       if (res == 0) {
/*  7448 */         this.con.inserSinMsj("update guias set estado = 'CANCELADA/" + this.jTextField14.getText().toUpperCase() + "',estatus='<Cancelada: " + this.USUARIO + " " + cargarFechaHoy() + " >' where num_guia = '" + this.CLAVE + "'");
/*  7449 */         this.con.bitacora("insert into bitacora(fecha,usuario,concepto,datos)values(now(),'" + this.USUARIO + "','Canceló una Guía','Se ha cancelado la guía No: " + this.CLAVE + "')");
/*  7450 */         consultar();
/*  7451 */         this.jDialog1.setVisible(false);
/*  7452 */         this.jTextField14.setText("");
/*  7453 */         JOptionPane.showMessageDialog(this.padre, "La guía ha sido cancelada satisfactoriamente", "Guía Cancelada", 0, this.INFO);
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   public void guias(String usu) {
/*  7459 */     this.USUARIO = usu;
/*  7460 */     this.panel.setViewportView(this);
/*  7461 */     sacarDepa();
/*  7462 */     privilegios();
/*  7463 */     this.jComboBox21.setSelectedIndex(0);
/*  7464 */     this.fechaActual = new Date();
/*  7465 */     this.jDateChooser4.setDate(this.fechaActual);
/*  7466 */     this.jDateChooser4.setMaxSelectableDate(this.fechaActual);
/*  7467 */     this.jDateChooser1.setDate(this.fechaActual);
/*  7468 */     this.jDateChooser3.setDate(this.fechaActual);
/*  7469 */     this.jDateChooser5.setDate(this.fechaActual);
/*  7470 */     this.jDateChooser5.setMaxSelectableDate(this.fechaActual);
/*  7471 */     consultar();
/*       */   }
/*       */   
/*       */   public void llenarCombos() {
/*  7475 */     String[] datos = this.con.regresaColIndex("empresa", "emp_generadora", "where clave_gene<>0 order by empresa");
/*  7476 */     this.jComboBox3.removeAllItems();
/*  7477 */     this.jComboBox3.addItem("ORIGEN"); int i;
/*  7478 */     for (i = 0; i < datos.length; i++) {
/*  7479 */       this.jComboBox3.addItem(datos[i]);
/*       */     }
/*       */     
/*  7482 */     datos = this.con.regresaColIndex("distinct(nombre_corto)", "emp_generadora", "where clave_gene<>0 order by nombre_corto");
/*  7483 */     this.jComboBox31.removeAllItems();
/*  7484 */     this.jComboBox31.addItem("CLIENTE");
/*  7485 */     for (i = 0; i < datos.length; i++) {
/*  7486 */       this.jComboBox31.addItem(datos[i]);
/*       */     }
/*       */     
/*  7489 */     datos = this.con.regresaColIndex("empresa", "emp_destinataria", "where clave_desti<>0 order by empresa");
/*  7490 */     this.jComboBox4.removeAllItems();
/*  7491 */     this.jComboBox4.addItem("DESTINO");
/*  7492 */     for (i = 0; i < datos.length; i++) {
/*  7493 */       this.jComboBox4.addItem(datos[i]);
/*       */     }
/*       */     
/*  7496 */     datos = this.con.regresaColIndex("nombrecorto", "emp_destinataria", "where clave_desti<>0 order by empresa");
/*  7497 */     this.jComboBox10.removeAllItems();
/*  7498 */     this.jComboBox17.removeAllItems();
/*  7499 */     this.jComboBox17.addItem("PATIO");
/*  7500 */     for (i = 0; i < datos.length; i++) {
/*  7501 */       this.jComboBox17.addItem(datos[i]);
/*  7502 */       this.jComboBox10.addItem(datos[i]);
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
/*  7514 */     datos = this.con.regresaColIndex("equipo", "equipos", "where num_equipo<>0 order by equipo");
/*  7515 */     this.jComboBox5.removeAllItems();
/*  7516 */     this.jComboBox5.addItem("TODOS");
/*  7517 */     this.jComboBox11.removeAllItems();
/*  7518 */     for (i = 0; i < datos.length; i++) {
/*  7519 */       this.jComboBox5.addItem(datos[i]);
/*  7520 */       this.jComboBox11.addItem(datos[i]);
/*       */     } 
/*       */ 
/*       */ 
/*       */     
/*  7525 */     datos = this.con.regresaColIndex("plataforma", "plataformas", "order by plataforma");
/*  7526 */     this.jComboBox6.removeAllItems();
/*  7527 */     this.jComboBox13.removeAllItems();
/*  7528 */     this.jComboBox6.addItem("TODOS");
/*  7529 */     for (i = 0; i < datos.length; i++) {
/*  7530 */       this.jComboBox6.addItem(datos[i]);
/*  7531 */       this.jComboBox13.addItem(datos[i]);
/*       */     } 
/*       */ 
/*       */ 
/*       */     
/*  7536 */     datos = this.con.regresaColIndex("nombre", "pozos", "order by nombre");
/*  7537 */     this.jComboBox7.removeAllItems();
/*  7538 */     this.jComboBox12.removeAllItems();
/*  7539 */     this.jComboBox29.removeAllItems();
/*  7540 */     this.jComboBox7.addItem("TODOS");
/*  7541 */     for (i = 0; i < datos.length; i++) {
/*  7542 */       this.jComboBox7.addItem(datos[i]);
/*  7543 */       this.jComboBox12.addItem(datos[i]);
/*  7544 */       this.jComboBox29.addItem(datos[i]);
/*       */     } 
/*       */ 
/*       */     
/*  7548 */     datos = this.con.regresaColIndex("distinct(ciudad)", "emp_generadora", "where ciudad<>''");
/*  7549 */     this.jComboBox16.removeAllItems();
/*  7550 */     this.jComboBox16.addItem("TODOS");
/*  7551 */     for (i = 0; i < datos.length; i++) {
/*  7552 */       this.jComboBox16.addItem(datos[i]);
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
/*  7567 */     String[][] datosR = this.con.buscarDatos(4, "num_ope,nombre,ap_pat,ap_mat", "operadores", "where num_ope<>0 order by nombre");
/*  7568 */     this.CLAVEOPERADOR = new String[datosR.length];
/*  7569 */     String[] nombre = new String[datosR.length];
/*  7570 */     String[] paterno = new String[datosR.length];
/*  7571 */     String[] materno = new String[datosR.length];
/*       */     int j;
/*  7573 */     for (j = 0; j < datosR.length; j++) {
/*  7574 */       for (int m = 0; m < (datosR[j]).length; m++) {
/*  7575 */         if (m == 0) {
/*  7576 */           this.CLAVEOPERADOR[j] = datosR[j][m];
/*       */         }
/*  7578 */         if (m == 1) {
/*  7579 */           nombre[j] = datosR[j][m];
/*       */         }
/*  7581 */         if (m == 2) {
/*  7582 */           paterno[j] = datosR[j][m];
/*       */         }
/*  7584 */         if (m == 3) {
/*  7585 */           materno[j] = datosR[j][m];
/*       */         }
/*       */       } 
/*       */     } 
/*       */     
/*  7590 */     this.jComboBox19.removeAllItems();
/*  7591 */     this.jComboBox24.removeAllItems();
/*  7592 */     this.jComboBox19.addItem("PENDIENTE DESCARGA");
/*  7593 */     for (j = 0; j < nombre.length; j++) {
/*  7594 */       this.jComboBox19.addItem(nombre[j] + " " + nombre[j] + " " + paterno[j]);
/*  7595 */       this.jComboBox24.addItem(nombre[j] + " " + nombre[j] + " " + paterno[j]);
/*       */     } 
/*       */ 
/*       */ 
/*       */     
/*  7600 */     datos = this.con.regresaColIndex("num_tracto", "tracto", "where num_tracto<>0");
/*  7601 */     this.jComboBox25.removeAllItems();
/*  7602 */     for (j = 0; j < datos.length; j++) {
/*  7603 */       this.jComboBox25.addItem(datos[j]);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*  7608 */     datos = this.con.regresaColIndex("num_rem", "remolque", "where num_rem<>0");
/*  7609 */     this.jComboBox26.removeAllItems();
/*  7610 */     this.jComboBox32.removeAllItems();
/*  7611 */     this.jComboBox32.addItem("");
/*  7612 */     for (j = 0; j < datos.length; j++) {
/*  7613 */       this.jComboBox26.addItem(datos[j]);
/*  7614 */       this.jComboBox32.addItem(datos[j]);
/*       */     } 
/*       */     
/*  7617 */     this.con.consultar("count(nombre_corto)", "emp_generadora", "where clave_gene<>0");
/*  7618 */     datos = this.con.regresaCol("nombre_corto", "emp_generadora", "where clave_gene<>0 order by nombre_corto,empresa", Integer.parseInt(this.con.Campo));
/*  7619 */     this.LLAVESGENE = this.con.regresaCol("clave_gene", "emp_generadora", "where clave_gene<>0 order by nombre_corto,empresa", Integer.parseInt(this.con.Campo));
/*       */     
/*  7621 */     this.jComboBox15.removeAllItems();
/*  7622 */     for (j = 0; j < datos.length; j++) {
/*  7623 */       this.jComboBox15.addItem(this.LLAVESGENE[j] + ".- " + this.LLAVESGENE[j]);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*  7628 */     datos = this.con.regresaColIndex("nombrecorto", "emp_destinataria", " order by empresa");
/*  7629 */     this.jComboBox10.removeAllItems();
/*  7630 */     for (j = 0; j < datos.length; j++) {
/*  7631 */       this.jComboBox10.addItem(datos[j]);
/*       */     }
/*       */ 
/*       */ 
/*       */     
/*  7636 */     datos = this.con.regresaColIndex("distinct(residuo)", "residuos", " order by residuo");
/*  7637 */     this.jComboBox1.removeAllItems();
/*  7638 */     this.jComboBox1.addItem("TODOS");
/*  7639 */     for (j = 0; j < datos.length; j++) {
/*  7640 */       this.jComboBox1.addItem(datos[j]);
/*  7641 */       this.jComboBox9.addItem(datos[j]);
/*       */     } 
/*       */ 
/*       */     
/*  7645 */     Calendar ca = Calendar.getInstance();
/*  7646 */     Calendar fecha = Calendar.getInstance();
/*  7647 */     int aa = fecha.get(1);
/*  7648 */     int mm = fecha.get(2);
/*  7649 */     int dd = fecha.get(5);
/*  7650 */     mm++;
/*  7651 */     if (mm == 1) {
/*  7652 */       mm = 11;
/*  7653 */       aa--;
/*  7654 */     } else if (mm == 2) {
/*  7655 */       mm = 12;
/*  7656 */       aa--;
/*       */     } else {
/*  7658 */       mm--;
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
/*  7672 */     datosR = this.con.buscarDatos(5, "num_vale,ticket,peso,rsp,ope_tira", "vales", "where folio_liq1<>'' and folio_liq2<>'' and f_expedicion1>'" + aa + "-" + mm + "-01'");
/*  7673 */     datos = new String[datosR.length];
/*  7674 */     String[] datos1 = new String[datosR.length];
/*  7675 */     String[] datos2 = new String[datosR.length];
/*  7676 */     String[] datos3 = new String[datosR.length];
/*  7677 */     String[] datos4 = new String[datosR.length];
/*       */     int k;
/*  7679 */     for (k = 0; k < datosR.length; k++) {
/*  7680 */       for (int m = 0; m < (datosR[k]).length; m++) {
/*  7681 */         if (m == 0) {
/*  7682 */           datos[k] = datosR[k][m];
/*       */         }
/*  7684 */         if (m == 1) {
/*  7685 */           datos1[k] = datosR[k][m];
/*       */         }
/*  7687 */         if (m == 2) {
/*  7688 */           datos2[k] = datosR[k][m];
/*       */         }
/*  7690 */         if (m == 3) {
/*  7691 */           datos1[k] = datosR[k][m];
/*       */         }
/*  7693 */         if (m == 4) {
/*  7694 */           datos1[k] = datosR[k][m];
/*       */         }
/*       */       } 
/*       */     } 
/*       */     
/*  7699 */     this.INFORMACION = new String[datos4.length];
/*  7700 */     for (k = 0; k < datos.length; k++) {
/*  7701 */       this.jComboBox27.addItem(datos[k]);
/*  7702 */       this.INFORMACION[k] = "Ticket=" + datos1[k] + ", Peso=" + datos2[k] + ", rsp=" + datos3[k] + ", Tirada Por=" + datos4[k];
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   public void privilegios() {
/*  7708 */     this.jComboBox14.setEnabled(true);
/*  7709 */     this.jComboBox28.setEnabled(true);
/*  7710 */     if (!this.DEPARTAMENTO.equals("SUPER USUARIO")) {
/*  7711 */       this.jButton4.setEnabled(false);
/*  7712 */       this.jButton5.setEnabled(false);
/*  7713 */       this.jButton2.setEnabled(false);
/*       */       
/*  7715 */       this.jButton19.setEnabled(false);
/*  7716 */       this.jButton9.setEnabled(false);
/*  7717 */       this.jComboBox21.setEnabled(false);
/*  7718 */       this.jLabel12.setVisible(false);
/*  7719 */       this.jButton25.setEnabled(false);
/*  7720 */       this.jButton26.setEnabled(false);
/*       */     } else {
/*  7722 */       this.jLabel12.setVisible(true);
/*  7723 */       this.jButton5.setEnabled(true);
/*  7724 */       this.jButton6.setEnabled(true);
/*  7725 */       this.jButton2.setEnabled(true);
/*  7726 */       this.jButton8.setEnabled(true);
/*  7727 */       this.jButton18.setEnabled(true);
/*  7728 */       this.jButton19.setEnabled(true);
/*  7729 */       this.jButton24.setEnabled(true);
/*  7730 */       this.jButton25.setEnabled(true);
/*       */       
/*  7732 */       this.jComboBox21.setEnabled(true);
/*  7733 */       this.jButton9.setEnabled(true);
/*       */     } 
/*       */   }
/*       */   
/*       */   public Float redondear(float pasar) {
/*  7738 */     NumberFormat nf = NumberFormat.getInstance();
/*  7739 */     nf.setMaximumFractionDigits(2);
/*  7740 */     String st = nf.format(pasar);
/*  7741 */     return Float.valueOf(Float.parseFloat(st));
/*       */   }
/*       */   
/*       */   public void cargarGuia() {
/*  7745 */     int indice = this.rSTableMetro1.getSelectedRow();
/*  7746 */     String GUIA = String.valueOf(this.rSTableMetro1.getValueAt(indice, 0));
/*  7747 */     String[] TODOS = this.con.regresaReg("tracto.num_tracto, tracto.placas, remolque.num_rem, remolque.placas, clave_gene", "llamadas_historicas,tracto,remolque", "where llamadas_historicas.num_tracto = tracto.num_tracto and llamadas_historicas.num_rem = remolque.num_rem and num_guia = '" + GUIA + "'", 5);
/*       */     
/*  7749 */     int t = 0;
/*  7750 */     for (int i = 0; i < this.LLAVESGENE.length; i++) {
/*  7751 */       if (this.LLAVESGENE[i].equals(TODOS[4])) {
/*  7752 */         t = i;
/*       */         
/*       */         break;
/*       */       } 
/*       */     } 
/*  7757 */     String[] campos = (new Consultas2()).regresaRegIndex("nombreCorto, poz", "llamadas_historicas, emp_destinataria", "where llamadas_historicas.clave_desti = emp_destinataria.clave_desti and num_guia = '" + GUIA + "'");
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  7762 */     String nombreCorto = campos[0];
/*       */ 
/*       */     
/*  7765 */     String[] perforacion = this.con.regresaRegIndex("equipos.equipo, plataformas.plataforma, pozos.nombre", "llamadas_historicas, equipos, plataformas, pozos", "where llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata = plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.num_guia ='" + GUIA + "'");
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*  7772 */     this.jComboBox11.setSelectedItem(perforacion[0]);
/*  7773 */     this.jComboBox13.setSelectedItem(perforacion[1]);
/*  7774 */     this.jComboBox12.setSelectedItem(perforacion[2]);
/*       */     
/*  7776 */     String[] datGuias = this.con.regresaRegIndex("folio_imp", "guias", "where num_guia = '" + GUIA + "'");
/*  7777 */     this.jTextField43.setText(datGuias[0]);
/*       */ 
/*       */     
/*  7780 */     this.jComboBox32.setSelectedItem(this.rSTableMetro1.getValueAt(indice, 11));
/*  7781 */     this.jComboBox22.setSelectedItem(this.rSTableMetro1.getValueAt(indice, 2));
/*  7782 */     this.jComboBox9.setSelectedItem(this.rSTableMetro1.getValueAt(indice, 3));
/*       */     
/*  7784 */     this.jComboBox15.setSelectedIndex(t);
/*  7785 */     this.jComboBox10.setSelectedItem(nombreCorto);
/*  7786 */     this.jComboBox25.setSelectedItem(this.rSTableMetro1.getValueAt(indice, 7));
/*  7787 */     this.jComboBox26.setSelectedItem(this.rSTableMetro1.getValueAt(indice, 9));
/*       */     
/*  7789 */     this.jComboBox23.setSelectedItem(this.rSTableMetro1.getValueAt(indice, 16));
/*  7790 */     this.jComboBox24.setSelectedItem(this.rSTableMetro1.getValueAt(indice, 17));
/*  7791 */     String estado = String.valueOf(this.rSTableMetro1.getValueAt(indice, 19));
/*  7792 */     this.jTextArea2.setText(String.valueOf(this.rSTableMetro1.getValueAt(indice, 20)));
/*  7793 */     if (estado.equals("ACTIVA")) {
/*  7794 */       this.jComboBox14.setSelectedIndex(0);
/*       */     } else {
/*  7796 */       this.jComboBox14.setSelectedIndex(1);
/*       */     } 
/*  7798 */     this.jTextField15.setText(GUIA);
/*  7799 */     String FECHA = String.valueOf(this.rSTableMetro1.getValueAt(indice, 1));
/*       */     
/*  7801 */     String año = FECHA.substring(0, 4);
/*  7802 */     String mes = FECHA.substring(5, 7);
/*  7803 */     String dia = FECHA.substring(8, 10);
/*  7804 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/*  7805 */     String strFecha = año + "-" + año + "-" + mes;
/*  7806 */     Date fecha = null;
/*       */     try {
/*  7808 */       fecha = formatoDelTexto.parse(strFecha);
/*  7809 */     } catch (ParseException ex) {
/*  7810 */       ex.printStackTrace();
/*       */     } 
/*  7812 */     this.jDateChooser2.setDate(fecha);
/*  7813 */     this.jTextField16.setText(FECHA.substring(11, 19));
/*       */ 
/*       */     
/*  7816 */     this.jComboBox9.setSelectedItem(String.valueOf(this.rSTableMetro1.getValueAt(indice, 3)));
/*       */     
/*  7818 */     String estatus = String.valueOf(this.rSTableMetro1.getValueAt(indice, 21));
/*  7819 */     if (estatus.contains("Asignada")) {
/*  7820 */       this.jComboBox28.setSelectedIndex(0);
/*  7821 */     } else if (estatus.contains("Sólo Cargada")) {
/*  7822 */       this.jComboBox28.setSelectedIndex(3);
/*  7823 */     } else if (estatus.contains("Pagada Al Operador")) {
/*  7824 */       this.jComboBox28.setSelectedIndex(4);
/*  7825 */     } else if (estatus.contains("En Prefactura")) {
/*  7826 */       this.jComboBox28.setSelectedIndex(1);
/*  7827 */     } else if (estatus.contains("Facturada")) {
/*  7828 */       this.jComboBox28.setSelectedIndex(2);
/*       */     } 
/*       */   }
/*       */   
/*       */   public void desactivar() {
/*  7833 */     this.jComboBox13.removeAllItems();
/*  7834 */     this.jComboBox12.removeAllItems();
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
/*       */   public void llenarCombo2() {
/*  7849 */     String[][] datos = this.con.buscarDatos(9, "clave_desti,empresa,calle,num,col,ciudad,rfc,monto,letra", "emp_destinataria", "where clave_desti<>0 order by empresa");
/*  7850 */     this.clavesDesti = new String[datos.length];
/*  7851 */     this.empresasDesti = new String[datos.length];
/*  7852 */     this.domicilioDesti = new String[datos.length];
/*  7853 */     this.numeroDesti = new String[datos.length];
/*  7854 */     this.coloniaDesti = new String[datos.length];
/*  7855 */     this.ciudadesDesti = new String[datos.length];
/*  7856 */     this.rfcDesti = new String[datos.length];
/*  7857 */     this.montoDesti = new String[datos.length];
/*  7858 */     this.letraDesti = new String[datos.length];
/*       */     
/*  7860 */     String equipo = String.valueOf(this.jComboBox11.getSelectedItem());
/*  7861 */     String num_equipo = "";
/*  7862 */     this.encontrado = this.con.consultar("equipos.num_equipo", "equipos,equipo_plataforma", "where equipos.num_equipo = equipo_plataforma.num_equipo and equipo = '" + equipo + "'");
/*  7863 */     num_equipo = this.con.Campo;
/*  7864 */     if (equipo.equals("WEATHERFORD") || equipo.equals("PMX") || equipo.equals("Q-MAX")) {
/*  7865 */       this.encontrado = this.con.consultar("num_plata", "equipos,equipo_plataforma", "where equipos.num_equipo = equipo_plataforma.num_equipo and equipo = '" + equipo + "'");
/*  7866 */       if (this.encontrado) {
/*  7867 */         this.con.consultar("count(plataformas.num_plata)", "plataformas,equipo_plataforma,equipos", "where equipo_plataforma.num_plata = plataformas.num_plata and equipo_plataforma.num_equipo = equipos.num_equipo and equipo = '" + equipo + "'");
/*  7868 */         String[] totR = this.con.regresaCol("plataformas.num_plata", "plataformas,equipo_plataforma,equipos", "where equipo_plataforma.num_plata = plataformas.num_plata and equipo_plataforma.num_equipo = equipos.num_equipo and equipo = '" + equipo + "' order by plataforma", Integer.parseInt(this.con.Campo));
/*  7869 */         for (int i = 0; i < totR.length; i++) {
/*  7870 */           this.con.consultar("plataforma", "plataformas", "where num_plata = " + totR[i] + " order by plataforma");
/*  7871 */           this.jComboBox13.addItem(this.con.Campo);
/*       */         } 
/*  7873 */         this.jComboBox12.removeAllItems();
/*       */       } else {
/*  7875 */         desactivar();
/*       */       } 
/*       */     } else {
/*  7878 */       this.encontrado = this.con.consultar("num_plata", "equipos,equipo_plataforma", "where equipos.num_equipo = equipo_plataforma.num_equipo and equipo = '" + equipo + "'");
/*  7879 */       if (this.encontrado) {
/*  7880 */         this.con.consultar("plataforma", "plataformas", "where num_plata = " + this.con.Campo);
/*  7881 */         String plataforma = this.con.Campo;
/*  7882 */         this.jComboBox13.addItem(plataforma);
/*  7883 */         this.con.consultar("num_plata", "plataformas", "where plataforma = '" + plataforma + "'");
/*  7884 */         String num_plata = this.con.Campo;
/*  7885 */         this.encontrado = this.con.consultar("nombre", "pozos,equipo_plataforma", "where pozos.num = equipo_plataforma.num and estado ='EN PERFORACIÓN' and  num_plata = " + num_plata + " and num_equipo = " + num_equipo);
/*  7886 */         if (this.encontrado) {
/*  7887 */           this.jComboBox12.removeAllItems();
/*  7888 */           this.jComboBox12.addItem(this.con.Campo);
/*       */         } else {
/*  7890 */           desactivar();
/*       */         } 
/*       */       } else {
/*  7893 */         desactivar();
/*  7894 */         if (this.jComboBox11.getSelectedIndex() > 0) {
/*  7895 */           JOptionPane.showMessageDialog(this.padre, "El equipo aún no tiene ninguna plataforma asignada por favor verifica tu información", "Plataforma No Asignada", 0, this.ERROR);
/*       */         }
/*       */       } 
/*       */     } 
/*       */   }
/*       */   
/*       */   public void sacarMayor() {
/*  7902 */     this.con.consultar("max(num)", "vales", "");
/*  7903 */     String mayor = this.con.Campo;
/*  7904 */     int MAYOR = Integer.parseInt(mayor);
/*  7905 */     MAYOR++;
/*  7906 */     if (MAYOR < 100) {
/*  7907 */       this.jTextField8.setText(this.DIRECTIVA + "-000" + this.DIRECTIVA);
/*  7908 */     } else if (MAYOR < 1000) {
/*  7909 */       this.jTextField8.setText(this.DIRECTIVA + "-00" + this.DIRECTIVA);
/*  7910 */     } else if (MAYOR < 10000) {
/*  7911 */       this.jTextField8.setText(this.DIRECTIVA + "-0" + this.DIRECTIVA);
/*       */     } else {
/*  7913 */       this.jTextField8.setText(this.DIRECTIVA + "-" + this.DIRECTIVA);
/*       */     } 
/*       */   }
/*       */   
/*       */   public void cargarVale() {
/*  7918 */     int indice = this.rSTableMetro1.getSelectedRow();
/*  7919 */     String guia = String.valueOf(this.rSTableMetro1.getValueAt(indice, 0));
/*  7920 */     this.jTextField5.setText(guia);
/*  7921 */     this.con.consultar("num_ope", "llamadas_historicas", "where num_guia = '" + guia + "'");
/*  7922 */     this.CLAVEO = this.con.Campo;
/*  7923 */     this.encontrado = this.con.consultar("num_guia", "vales", "where num_guia = '" + guia + "'");
/*       */     
/*  7925 */     if (this.encontrado) {
/*  7926 */       String[] datos = this.con.regresaReg("num_vale,ticket,f_llegada,f_salida,peso,num_guia,nombre_usu,ope_carga,ope_tira,completa", "vales", "where num_guia = '" + guia + "'", 10);
/*  7927 */       if (datos[9].equals("1")) {
/*  7928 */         JOptionPane.showMessageDialog(this.padre, "La guía que seleccionaste ya está completa, por favor selecciona otra guía.", "Guía Completa", 0, this.ADVER);
/*       */       } else {
/*  7930 */         this.jTextField8.setText(String.valueOf(this.rSTableMetro1.getValueAt(indice, 13)));
/*  7931 */         this.jComboBox18.setSelectedIndex(3);
/*  7932 */         this.jComboBox18.setEnabled(false);
/*  7933 */         this.jComboBox29.setEnabled(false);
/*  7934 */         String[] campos = this.con.regresaReg("num_tracto,num_rem", "llamadas_historicas,guias", "where guias.num_guia = llamadas_historicas.num_guia and guias.num_guia = '" + guia + "'", 2);
/*  7935 */         Calendar ahoraCal = Calendar.getInstance();
/*  7936 */         ahoraCal.setTime(this.fechaActual);
/*  7937 */         String mesesito = "";
/*  7938 */         String hoy = "";
/*  7939 */         mesesito = "" + ahoraCal.get(2) + 1;
/*  7940 */         hoy = "" + ahoraCal.get(5);
/*  7941 */         if (ahoraCal.get(2) + 1 < 10) {
/*  7942 */           mesesito = "0" + mesesito;
/*       */         }
/*  7944 */         if (ahoraCal.get(5) < 10) {
/*  7945 */           hoy = "0" + hoy;
/*       */         }
/*       */         
/*  7948 */         String fecha1 = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1));
/*  7949 */         String fecha2 = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1));
/*  7950 */         String fecha3 = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1));
/*       */ 
/*       */ 
/*       */         
/*  7954 */         String año = fecha1.substring(0, 4);
/*  7955 */         String mes = fecha1.substring(5, 7);
/*  7956 */         String dia = fecha1.substring(8, 10);
/*  7957 */         SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/*  7958 */         String strFecha = año + "-" + año + "-" + mes;
/*  7959 */         Date fecha = null;
/*       */         try {
/*  7961 */           fecha = formatoDelTexto.parse(strFecha);
/*  7962 */         } catch (ParseException ex) {
/*  7963 */           ex.printStackTrace();
/*       */         } 
/*  7965 */         this.jDateChooser1.setDate(fecha);
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  7970 */         año = fecha2.substring(0, 4);
/*  7971 */         mes = fecha2.substring(5, 7);
/*  7972 */         dia = fecha2.substring(8, 10);
/*  7973 */         formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/*  7974 */         strFecha = año + "-" + año + "-" + mes;
/*  7975 */         fecha = null;
/*       */         try {
/*  7977 */           fecha = formatoDelTexto.parse(strFecha);
/*  7978 */         } catch (ParseException ex) {
/*  7979 */           ex.printStackTrace();
/*       */         } 
/*  7981 */         this.jDateChooser6.setDate(fecha);
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  7986 */         año = fecha3.substring(0, 4);
/*  7987 */         mes = fecha3.substring(5, 7);
/*  7988 */         dia = fecha3.substring(8, 10);
/*  7989 */         formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/*  7990 */         strFecha = año + "-" + año + "-" + mes;
/*  7991 */         fecha = null;
/*       */         try {
/*  7993 */           fecha = formatoDelTexto.parse(strFecha);
/*  7994 */         } catch (ParseException ex) {
/*  7995 */           ex.printStackTrace();
/*       */         } 
/*  7997 */         this.jDateChooser3.setDate(fecha);
/*       */ 
/*       */ 
/*       */ 
/*       */         
/*  8002 */         this.jTextField10.setText(hoy + "-" + hoy + "-" + mesesito);
/*  8003 */         this.jTextField6.setText(this.rSTableMetro1.getValueAt(indice, 17).toString());
/*  8004 */         this.jTextField19.setText(campos[0]);
/*  8005 */         this.jTextField23.setText(campos[1]);
/*       */         
/*  8007 */         String[] usuario = this.con.regresaReg("nombre,ap_pat,ap_mat", "empleados,usuarios", "where num_emp = clave_emp and nombre_usu = '" + this.USUARIO + "'", 3);
/*  8008 */         this.jLabel83.setText(usuario[0] + " " + usuario[0] + " " + usuario[1]);
/*  8009 */         this.jTextField9.setText(this.rSTableMetro1.getValueAt(indice, 4).toString());
/*  8010 */         this.jTextField7.setText(this.rSTableMetro1.getValueAt(indice, 5).toString());
/*  8011 */         if (this.rSTableMetro1.getValueAt(indice, 6).equals("")) {
/*  8012 */           this.jComboBox17.setSelectedIndex(0);
/*       */         } else {
/*  8014 */           this.jComboBox17.setSelectedItem(this.rSTableMetro1.getValueAt(indice, 8));
/*       */         } 
/*  8016 */         this.jTextField7.setText("PATIO");
/*  8017 */         this.jComboBox19.setSelectedItem(this.rSTableMetro1.getValueAt(indice, 17));
/*       */ 
/*       */       
/*       */       }
/*       */ 
/*       */     
/*       */     }
/*       */     else {
/*       */ 
/*       */       
/*  8027 */       this.jComboBox18.setSelectedIndex(0);
/*  8028 */       sacarMayor();
/*  8029 */       String[] campos = this.con.regresaReg("num_tracto,num_rem", "llamadas_historicas,guias", "where guias.num_guia = llamadas_historicas.num_guia and guias.num_guia = '" + guia + "'", 2);
/*  8030 */       Calendar ahoraCal = Calendar.getInstance();
/*  8031 */       ahoraCal.setTime(this.fechaActual);
/*  8032 */       String mesesito = "";
/*  8033 */       String hoy = "";
/*  8034 */       mesesito = "" + ahoraCal.get(2) + 1;
/*  8035 */       hoy = "" + ahoraCal.get(5);
/*  8036 */       if (ahoraCal.get(2) + 1 < 10) {
/*  8037 */         mesesito = "0" + mesesito;
/*       */       }
/*  8039 */       if (ahoraCal.get(5) < 10) {
/*  8040 */         hoy = "0" + hoy;
/*       */       }
/*  8042 */       this.jTextField10.setText(hoy + "-" + hoy + "-" + mesesito);
/*  8043 */       this.jTextField6.setText(this.rSTableMetro1.getValueAt(indice, 17).toString());
/*  8044 */       this.jTextField19.setText(campos[0]);
/*  8045 */       this.jTextField23.setText(campos[1]);
/*       */       
/*  8047 */       String[] usuario = this.con.regresaReg("nombre,ap_pat,ap_mat", "empleados,usuarios", "where num_emp = clave_emp and nombre_usu = '" + this.USUARIO + "'", 3);
/*  8048 */       this.jLabel83.setText(usuario[0] + " " + usuario[0] + " " + usuario[1]);
/*  8049 */       this.jTextField9.setText(this.rSTableMetro1.getValueAt(indice, 4).toString());
/*  8050 */       this.jTextField7.setText(this.rSTableMetro1.getValueAt(indice, 5).toString());
/*  8051 */       this.jComboBox17.setSelectedItem(this.rSTableMetro1.getValueAt(indice, 6));
/*  8052 */       System.out.println("Dest " + String.valueOf(this.rSTableMetro1.getValueAt(indice, 6)));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  8059 */       String valor = String.valueOf(this.rSTableMetro1.getValueAt(indice, 17));
/*  8060 */       if (!valor.equals("")) {
/*  8061 */         this.jComboBox29.setSelectedItem(this.rSTableMetro1.getValueAt(indice, 17));
/*       */       } else {
/*  8063 */         this.jComboBox29.setSelectedIndex(0);
/*       */       } 
/*  8065 */       this.jComboBox18.setEnabled(true);
/*  8066 */       this.jComboBox17.setEnabled(false);
/*       */     } 
/*       */     
/*  8069 */     String[] datGuias = this.con.regresaRegIndex("folio_imp, manifiesto, km", "guias", "where num_guia ='" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)) + "'");
/*  8070 */     this.jTextField41.setText(datGuias[0]);
/*  8071 */     this.jTextField32.setText(datGuias[1]);
/*  8072 */     this.jTextField42.setText(datGuias[2]);
/*  8073 */     this.jDialog2.setVisible(true);
/*       */   }
/*       */ 
/*       */   
/*       */   public double redondear(Double cant) {
/*  8078 */     NumberFormat nf1 = NumberFormat.getInstance(Locale.US);
/*  8079 */     nf1.setMaximumFractionDigits(2);
/*  8080 */     nf1.setMinimumFractionDigits(2);
/*       */ 
/*       */     
/*  8083 */     return Double.parseDouble(nf1.format(cant.doubleValue() / 1000.0D));
/*       */   }
/*       */   
/*       */   public void sacarFecha() {
/*  8087 */     String año = "";
/*  8088 */     String mes = "";
/*  8089 */     String dia = "";
/*  8090 */     Calendar ca = Calendar.getInstance();
/*  8091 */     Calendar fecha = Calendar.getInstance();
/*  8092 */     int aa = fecha.get(1);
/*  8093 */     int mm = fecha.get(2);
/*  8094 */     int dd = fecha.get(5);
/*  8095 */     int diasTotal = diasDelMes(mm, aa);
/*  8096 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  8097 */     String strFecha = "";
/*  8098 */     if (diasTotal == dd) {
/*  8099 */       dd = 1;
/*  8100 */       if (mm == 11) {
/*  8101 */         aa++;
/*  8102 */         mm = 0;
/*       */       } else {
/*  8104 */         mm++;
/*       */       } 
/*       */     } else {
/*  8107 */       dd++;
/*       */     } 
/*  8109 */     mm++;
/*  8110 */     año = "" + aa;
/*  8111 */     mes = "" + mm;
/*  8112 */     dia = "" + dd;
/*  8113 */     formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  8114 */     strFecha = dia + "-" + dia + "-" + mes;
/*       */     try {
/*  8116 */       this.fechaTermino = formatoDelTexto.parse(strFecha);
/*  8117 */     } catch (ParseException ex) {
/*  8118 */       ex.printStackTrace();
/*       */     } 
/*  8120 */     this.fechaActual = new Date();
/*  8121 */     this.jDateChooser5.setDate(this.fechaTermino);
/*  8122 */     this.jDateChooser5.setMaxSelectableDate(this.fechaTermino);
/*       */   }
/*       */   
/*       */   public int diasDelMes(int mes, int año) {
/*  8126 */     switch (mes) {
/*       */       case 0:
/*       */       case 2:
/*       */       case 4:
/*       */       case 6:
/*       */       case 7:
/*       */       case 9:
/*       */       case 11:
/*  8134 */         return 31;
/*       */       
/*       */       case 3:
/*       */       case 5:
/*       */       case 8:
/*       */       case 10:
/*  8140 */         return 30;
/*       */       
/*       */       case 1:
/*  8143 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*       */         {
/*  8145 */           return 29;
/*       */         }
/*  8147 */         return 28;
/*       */     } 
/*       */ 
/*       */     
/*  8151 */     return 0;
/*       */   }
/*       */ 
/*       */   
/*       */   public void verNuevaGuia(String guia) {
/*  8156 */     GuiasForm form = new GuiasForm(this.USUARIO, this.padre, this.CAMPOSGENERALES, "VER", this.actualizado, this.LISTACODIGOS, this.CODIGOSP, guia);
/*       */   }
/*       */   
/*       */   public void verDatos() {
/*  8160 */     this.utilerias.vaciarTabla((JTable)this.rSTableMetro2);
/*  8161 */     this.utilerias.pintarTablaReg((JTable)this.rSTableMetro2);
/*  8162 */     this.jLabel33.setText("GUIA: " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/*  8163 */     for (int i = 0; i < this.rSTableMetro1.getColumnCount(); i++) {
/*  8164 */       this.utilerias.agregarCampoTablas(new String[] { this.rSTableMetro1
/*  8165 */             .getColumnName(i).toUpperCase(), this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), i).toString() }(JTable)this.rSTableMetro2);
/*       */     } 
/*       */ 
/*       */ 
/*       */     
/*  8170 */     this.jDialog12.setVisible(true);
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
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   public int añoActual() {
/*  8236 */     ZoneId defaultZoneId = ZoneId.systemDefault();
/*  8237 */     Instant instant = (new Date()).toInstant();
/*  8238 */     LocalDate fechaTrans = instant.atZone(defaultZoneId).toLocalDate();
/*  8239 */     return fechaTrans.getYear();
/*       */   }
/*       */   
/*       */   public int mesActual() {
/*  8243 */     ZoneId defaultZoneId = ZoneId.systemDefault();
/*  8244 */     Instant instant = (new Date()).toInstant();
/*  8245 */     LocalDate fechaTrans = instant.atZone(defaultZoneId).toLocalDate();
/*  8246 */     return fechaTrans.getMonthValue();
/*       */   }
/*       */   
/*       */   public synchronized void consultar() {
/*  8250 */     this.PRIMERA = true;
/*  8251 */     this.contador++;
/*  8252 */     System.out.println("contador -->" + this.contador);
/*  8253 */     boolean correcto = true;
/*  8254 */     String hora1 = "";
/*  8255 */     String hora2 = "";
/*  8256 */     if (this.jComboBox21.getSelectedIndex() == 0) {
/*  8257 */       hora1 = "";
/*  8258 */       hora2 = "";
/*  8259 */     } else if (this.jComboBox21.getSelectedIndex() == 1) {
/*  8260 */       hora1 = "09:00:00";
/*  8261 */       hora2 = "21:00:00";
/*  8262 */     } else if (this.jComboBox21.getSelectedIndex() == 2) {
/*  8263 */       hora1 = "21:00:00";
/*  8264 */       hora2 = "09:00:00";
/*       */     } 
/*  8266 */     if (this.jDateChooser4.getDate() == null) {
/*  8267 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de inicio no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha actual en el campo?</html>", "FECHA DE INICIO VACÍA", 0, 3, this.PREG);
/*  8268 */       if (res == 0) {
/*  8269 */         this.jDateChooser4.setDate(this.fechaActual);
/*  8270 */         correcto = true;
/*       */       } else {
/*  8272 */         correcto = false;
/*       */       } 
/*  8274 */     } else if (this.jDateChooser5.getDate() == null) {
/*  8275 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de término no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha de ininio?</html>", "FECHA DE TÉRMINO VACÍA", 0, 3, this.PREG);
/*  8276 */       if (res == 0) {
/*  8277 */         Date fecha1 = this.jDateChooser4.getDate();
/*  8278 */         Date fecha2 = this.jDateChooser5.getDate();
/*  8279 */         this.jDateChooser5.setDate(this.fechaActual);
/*  8280 */         correcto = true;
/*       */       } else {
/*  8282 */         correcto = false;
/*       */       } 
/*  8284 */     } else if (correcto) {
/*  8285 */       String fechaCompleta1 = "";
/*  8286 */       String fechaCompleta2 = "";
/*  8287 */       System.out.println("comobo " + this.jComboBox37.getSelectedIndex());
/*  8288 */       String consultaFecha = "";
/*  8289 */       if (this.jComboBox37.getSelectedIndex() != 0) {
/*  8290 */         String[] mes = { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
/*       */         
/*  8292 */         int aa = Integer.parseInt(this.jComboBox36.getSelectedItem().toString());
/*  8293 */         consultaFecha = " and  date_format( guias.fecha, '%m-%Y') = '" + mes[this.jComboBox37.getSelectedIndex()] + "-" + aa + "' ";
/*       */       } else {
/*  8295 */         Date fecha1 = this.jDateChooser9.getDate();
/*  8296 */         Date fecha2 = this.jDateChooser10.getDate();
/*  8297 */         SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  8298 */         String cadenaFecha = "";
/*  8299 */         cadenaFecha = formato.format(fecha1);
/*  8300 */         String AÑO = cadenaFecha.substring(0, 4);
/*  8301 */         String MES = cadenaFecha.substring(4, 6);
/*  8302 */         String DIA = cadenaFecha.substring(6, 8);
/*  8303 */         fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*  8304 */         cadenaFecha = formato.format(fecha2);
/*  8305 */         int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/*  8306 */         int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/*  8307 */         int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/*  8308 */         fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + " 23:59:59 '";
/*  8309 */         consultaFecha = " and guias.fecha between " + fechaCompleta1 + " and " + fechaCompleta2;
/*       */       } 
/*       */       
/*  8312 */       this.jButton5.setEnabled(false);
/*  8313 */       this.jButton5.setEnabled(false);
/*  8314 */       this.jButton4.setEnabled(false);
/*  8315 */       this.jButton8.setEnabled(false);
/*  8316 */       String residuo = "";
/*  8317 */       String tipo = "";
/*  8318 */       String origen = "";
/*  8319 */       String destino = "";
/*  8320 */       String equipo = "";
/*  8321 */       String plataforma = "";
/*  8322 */       String pozo = "";
/*  8323 */       String estado = "";
/*  8324 */       String ciudad = "";
/*  8325 */       String pat = "";
/*  8326 */       String mat = "";
/*  8327 */       String servicio = "";
/*  8328 */       String estatus = "";
/*  8329 */       String cliente = "";
/*  8330 */       String facturada = "";
/*       */       
/*  8332 */       if (!this.jTextField12.getText().equals(this.holderMercancia)) {
/*  8333 */         residuo = this.jTextField12.getText();
/*       */       }
/*       */       
/*  8336 */       if (!this.jTextField37.getText().equals(this.holderVehiculo)) {
/*  8337 */         tipo = this.jTextField37.getText();
/*       */       }
/*       */       
/*  8340 */       if (!this.jTextField39.getText().equals(this.holderOrigen)) {
/*  8341 */         origen = this.jTextField39.getText();
/*       */       }
/*       */       
/*  8344 */       if (!this.jTextField40.getText().equals(this.holderDestino)) {
/*  8345 */         destino = this.jTextField40.getText();
/*       */       }
/*       */       
/*  8348 */       if (this.jComboBox8.getSelectedIndex() != 2) {
/*  8349 */         estado = String.valueOf(this.jComboBox8.getSelectedItem()) + String.valueOf(this.jComboBox8.getSelectedItem());
/*       */       }
/*  8351 */       if (this.jComboBox16.getSelectedIndex() != 0) {
/*  8352 */         ciudad = String.valueOf(this.jComboBox16.getSelectedItem());
/*       */       }
/*       */       
/*  8355 */       if (!this.jTextField11.getText().equals(this.holderTipoServ)) {
/*  8356 */         servicio = this.jTextField11.getText();
/*       */       }
/*       */       
/*  8359 */       if (!this.jTextField38.getText().equals(this.holderCliente)) {
/*  8360 */         cliente = this.jTextField38.getText();
/*       */       }
/*       */       
/*  8363 */       if (this.jComboBox30.getSelectedIndex() == 1) {
/*  8364 */         estatus = "<Por Timbrar>";
/*  8365 */       } else if (this.jComboBox30.getSelectedIndex() == 2) {
/*  8366 */         estatus = "<Asignada Al Operador";
/*  8367 */       } else if (this.jComboBox30.getSelectedIndex() == 3) {
/*  8368 */         estatus = "<Sólo Cargada: En patio";
/*  8369 */       } else if (this.jComboBox30.getSelectedIndex() == 4) {
/*  8370 */         estatus = "<Pagada Al Operador";
/*  8371 */       } else if (this.jComboBox30.getSelectedIndex() == 5) {
/*  8372 */         estatus = "<En Prefactura Interna";
/*  8373 */       } else if (this.jComboBox30.getSelectedIndex() == 6) {
/*       */         
/*  8375 */         facturada = " and factimpresa <> ''";
/*       */       } 
/*       */       
/*  8378 */       String guia = "";
/*  8379 */       if (!this.jTextField1.getText().equals(this.holderGuia)) {
/*  8380 */         guia = this.jTextField1.getText();
/*       */       }
/*       */       
/*  8383 */       String operador = "";
/*  8384 */       if (!this.jTextField2.getText().equals(this.holderOp)) {
/*  8385 */         operador = this.jTextField2.getText();
/*       */       }
/*       */       
/*  8388 */       String Eco = "";
/*  8389 */       if (!this.jTextField4.getText().equals(this.holderEco)) {
/*  8390 */         Eco = this.jTextField4.getText();
/*       */       }
/*       */       
/*  8393 */       String Rem = "";
/*  8394 */       if (!this.jTextField3.getText().equals(this.holderRem)) {
/*  8395 */         Rem = this.jTextField3.getText();
/*       */       }
/*       */       
/*  8398 */       String DO = "";
/*  8399 */       if (!this.jTextField46.getText().equals(this.holderDo)) {
/*  8400 */         DO = this.jTextField46.getText();
/*       */       }
/*       */       
/*  8403 */       String LID = "";
/*  8404 */       if (!this.jTextField47.getText().equals(this.holderLid)) {
/*  8405 */         LID = this.jTextField47.getText();
/*       */       }
/*       */       
/*  8408 */       this.utilerias.consultaGralTabla(new Consultas2(), (JTable)this.rSTableMetro1, new String[] { "Folio", "Fecha", "Servicio", "Mercancía | Residuo | Producto", "Cliente", "Origen", "Destino", "Tractor", "Placas", "Rem1", "Placas", "Rem2", "Placas", "Complemento", "Ticket", "Peso", "Tipo", "Nombre del Operador", "Autorizó", "Estado", "Descripción o Comentario", "Estatus", "Rep Interno", "Prefactura", "Factura", "D.O.", "LID" }, "guias.num_guia,guias.fecha,servicio,residuo,emp_generadora.nombre_corto,llamadas_historicas.origen,llamadas_historicas.destino,tracto.num_tracto,tracto.placas,rem1,guias.placas1,rem2,placas2,guias.num_vale,ticket1,tons1,guias.tipo,guias.operador,guias.nombre,guias.estado,descrip,estatus, factura,prefactura,factImpresa,DO, LID", "tracto,remolque,guias,llamadas_historicas,emp_generadora,emp_destinataria,vales", "where llamadas_historicas.num_rem=remolque.num_rem and llamadas_historicas.num_tracto=tracto.num_tracto and guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.clave_gene = emp_generadora.clave_gene and llamadas_historicas.clave_desti = emp_destinataria.clave_desti and guias.num_vale = vales.num_vale and guias.num_guia like '%" + guia + "%' and residuo like '%" + residuo + "%' and llamadas_historicas.origen like '%" + origen + "%' and llamadas_historicas.destino like '%" + destino + "%' and guias.estado like '%" + estado + "%' and guias.tipo like '%" + tipo + "%' and guias.operador like '%" + operador + "%' and llamadas_historicas.num_tracto like '%" + Eco + "%' and (rem1 like '%" + Rem + "%' || rem2 like '%" + Rem + "%') and emp_generadora.ciudad like '%" + ciudad + "%'" + consultaFecha + " and servicio like '%" + servicio + "%' and estatus like '%" + estatus + "%' and emp_generadora.nombre_corto like '%" + cliente + "%' " + facturada + " and guias.do like '%" + DO + "%' and guias.lid like '%" + LID + "%' order by guias.num desc");
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  8427 */       this.utilerias.imprimirEncabezadosTabla((JTable)this.rSTableMetro1);
/*       */       
/*  8429 */       if (this.jComboBox8.getSelectedIndex() == 2) {
/*  8430 */         this.celda.pasarInd(this.con.revisarCol((JTable)this.rSTableMetro1, "ACTIVA", 0, 19, 1));
/*       */       } else {
/*  8432 */         String[] arre = new String[0];
/*  8433 */         this.celda.pasarInd(arre);
/*       */       } 
/*       */ 
/*       */       
/*  8437 */       this.celda.pasarInd2(this.con.revisarCol((JTable)this.rSTableMetro1, "<En Prefactura", 0, 21, 2));
/*  8438 */       this.celda.pasarInd3(this.con.revisarCol((JTable)this.rSTableMetro1, "<Asignada Al Operador>", 0, 21, 0));
/*  8439 */       this.celda.pasarInd4(this.con.revisarCol((JTable)this.rSTableMetro1, "<Sólo Cargada: En Patio", 0, 21, 2));
/*  8440 */       this.celda.pasarInd5(this.con.revisarCol((JTable)this.rSTableMetro1, "<Pagada Al Operador", 0, 21, 2));
/*  8441 */       this.celda.pasarInd6(this.con.revisarCol((JTable)this.rSTableMetro1, "<Por Timbrar>", 0, 21, 2));
/*  8442 */       this.celda.pasarInd7(this.con.revisarCol2((JTable)this.rSTableMetro1));
/*       */ 
/*       */       
/*  8445 */       float tons = 0.0F;
/*  8446 */       float tons2 = 0.0F;
/*  8447 */       for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/*  8448 */         String valor = String.valueOf(this.rSTableMetro1.getValueAt(i, 15));
/*  8449 */         tons += Float.parseFloat(valor);
/*       */       } 
/*       */ 
/*       */ 
/*       */       
/*  8454 */       tons /= 1000.0F;
/*  8455 */       NumberFormat nf = NumberFormat.getInstance();
/*  8456 */       nf.setMaximumFractionDigits(2);
/*  8457 */       String st = nf.format(tons);
/*       */ 
/*       */ 
/*       */       
/*  8461 */       this.jLabel50.setText("" + this.rSTableMetro1.getRowCount());
/*  8462 */       this.jLabel54.setText(st);
/*       */       
/*  8464 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 0, 70);
/*  8465 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 1, 120);
/*  8466 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 2, 120);
/*  8467 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 7, 50);
/*  8468 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 8, 60);
/*  8469 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 9, 50);
/*  8470 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 10, 60);
/*  8471 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 11, 50);
/*  8472 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 12, 60);
/*  8473 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 13, 80);
/*  8474 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 14, 60);
/*  8475 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 15, 60);
/*  8476 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 16, 110);
/*  8477 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 17, 210);
/*  8478 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 18, 210);
/*  8479 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 19, 90);
/*  8480 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 21, 190);
/*  8481 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 22, 80);
/*  8482 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 23, 80);
/*  8483 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 24, 80);
/*  8484 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 25, 100);
/*  8485 */       this.utilerias.ajustarTamañoTabla((JTable)this.rSTableMetro1, 26, 100);
/*       */       
/*  8487 */       this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/*  8488 */       this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/*  8489 */       this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/*  8490 */       this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/*  8491 */       this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/*  8492 */       this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/*  8493 */       this.rSTableMetro1.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/*  8494 */       this.rSTableMetro1.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/*  8495 */       this.rSTableMetro1.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/*  8496 */       this.rSTableMetro1.getColumnModel().getColumn(9).setCellRenderer(this.celda);
/*  8497 */       this.rSTableMetro1.getColumnModel().getColumn(10).setCellRenderer(this.celda);
/*  8498 */       this.rSTableMetro1.getColumnModel().getColumn(11).setCellRenderer(this.celda);
/*  8499 */       this.rSTableMetro1.getColumnModel().getColumn(12).setCellRenderer(this.celda);
/*  8500 */       this.rSTableMetro1.getColumnModel().getColumn(13).setCellRenderer(this.celda);
/*  8501 */       this.rSTableMetro1.getColumnModel().getColumn(14).setCellRenderer(this.celda);
/*  8502 */       this.rSTableMetro1.getColumnModel().getColumn(15).setCellRenderer(this.celda);
/*  8503 */       this.rSTableMetro1.getColumnModel().getColumn(16).setCellRenderer(this.celda);
/*  8504 */       this.rSTableMetro1.getColumnModel().getColumn(17).setCellRenderer(this.celda);
/*  8505 */       this.rSTableMetro1.getColumnModel().getColumn(18).setCellRenderer(this.celda);
/*  8506 */       this.rSTableMetro1.getColumnModel().getColumn(19).setCellRenderer(this.celda);
/*  8507 */       this.rSTableMetro1.getColumnModel().getColumn(20).setCellRenderer(this.celda);
/*  8508 */       this.rSTableMetro1.getColumnModel().getColumn(21).setCellRenderer(this.celda);
/*  8509 */       this.rSTableMetro1.getColumnModel().getColumn(22).setCellRenderer(this.celda);
/*  8510 */       this.rSTableMetro1.getColumnModel().getColumn(23).setCellRenderer(this.celda);
/*  8511 */       this.rSTableMetro1.getColumnModel().getColumn(24).setCellRenderer(this.celda);
/*  8512 */       this.rSTableMetro1.getColumnModel().getColumn(25).setCellRenderer(this.celda);
/*  8513 */       this.rSTableMetro1.getColumnModel().getColumn(26).setCellRenderer(this.celda);
/*       */       
/*  8515 */       this.rSTableMetro1.setSelectionMode(0);
/*  8516 */       this.rSTableMetro1.setAutoCreateRowSorter(true);
/*  8517 */       this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/*       */       
/*  8519 */       this.rSTableMetro1.setShowVerticalLines(false);
/*  8520 */       this.rSTableMetro1.setShowHorizontalLines(false);
/*  8521 */       this.rSTableMetro1.setShowVerticalLines(false);
/*  8522 */       this.jScrollPane20.setViewportView((Component)this.rSTableMetro1);
/*       */     } 
/*       */   }
/*       */ 
/*       */   
/*       */   public synchronized void eliminarColumna(int origen, int destino, String nombreCol) {
/*  8528 */     int cont = this.rSTableMetro1.getRowCount();
/*  8529 */     String[] registros = new String[cont]; int i;
/*  8530 */     for (i = 0; i < cont; i++) {
/*  8531 */       registros[i] = this.rSTableMetro1.getValueAt(i, destino).toString();
/*       */     }
/*  8533 */     for (i = 0; i < cont; i++) {
/*  8534 */       registros[i] = registros[i] + " " + registros[i];
/*  8535 */       this.rSTableMetro1.setValueAt(registros[i], i, destino);
/*       */     } 
/*  8537 */     TableColumn columna = this.rSTableMetro1.getColumn(nombreCol);
/*  8538 */     this.rSTableMetro1.removeColumn(columna);
/*       */   }
/*       */   
/*       */   public class CeldaRender
/*       */     extends DefaultTableCellRenderer {
/*  8543 */     int otro = -1;
/*  8544 */     String[] indices = new String[0];
/*  8545 */     String[] indices2 = new String[0];
/*  8546 */     String[] indices3 = new String[0];
/*  8547 */     String[] indices4 = new String[0];
/*  8548 */     String[] indices5 = new String[0];
/*  8549 */     String[] indices6 = new String[0];
/*  8550 */     String[] indices7 = new String[0];
/*       */     
/*       */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/*  8553 */       setEnabled((table == null || table.isEnabled()));
/*  8554 */       String comp = String.valueOf(table.getValueAt(row, 0));
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */       
/*  8565 */       if (comparar7(comp)) {
/*  8566 */         setBackground(Color.WHITE);
/*  8567 */         setForeground(Color.BLACK);
/*  8568 */       } else if (comparar(comp)) {
/*  8569 */         setBackground(Color.red);
/*  8570 */         setForeground(Color.white);
/*  8571 */       } else if (comparar2(comp)) {
/*  8572 */         setBackground(new Color(153, 102, 0));
/*  8573 */         setForeground(Color.WHITE);
/*  8574 */       } else if (comparar3(comp)) {
/*  8575 */         setBackground(new Color(102, 153, 255));
/*  8576 */         setForeground(Color.BLUE);
/*  8577 */       } else if (comparar4(comp)) {
/*  8578 */         setBackground(Color.LIGHT_GRAY);
/*  8579 */         setForeground(Color.RED);
/*  8580 */       } else if (comparar5(comp)) {
/*  8581 */         setBackground(new Color(153, 153, 153));
/*  8582 */         setForeground(Color.BLACK);
/*  8583 */       } else if (comparar6(comp)) {
/*  8584 */         setBackground(Color.ORANGE);
/*  8585 */         setForeground(Color.RED);
/*       */       } else {
/*  8587 */         setBackground((Color)null);
/*  8588 */         setForeground(Color.black);
/*       */       } 
/*       */       
/*  8591 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/*  8592 */       return this;
/*       */     }
/*       */     
/*       */     public void pasarInd(String[] ind) {
/*  8596 */       this.indices = ind;
/*       */     }
/*       */     
/*       */     public void pasarInd2(String[] ind) {
/*  8600 */       this.indices2 = ind;
/*       */     }
/*       */     
/*       */     public void pasarInd3(String[] ind) {
/*  8604 */       this.indices3 = ind;
/*       */     }
/*       */     
/*       */     public void pasarInd4(String[] ind) {
/*  8608 */       this.indices4 = ind;
/*       */     }
/*       */     
/*       */     public void pasarInd5(String[] ind) {
/*  8612 */       this.indices5 = ind;
/*       */     }
/*       */     
/*       */     public void pasarInd6(String[] ind) {
/*  8616 */       this.indices6 = ind;
/*       */     }
/*       */     
/*       */     public void pasarInd7(String[] ind) {
/*  8620 */       this.indices7 = ind;
/*       */     }
/*       */     
/*       */     public boolean comparar(String reg) {
/*  8624 */       for (int i = 0; i < this.indices.length; i++) {
/*  8625 */         if (this.indices[i].equals(reg)) {
/*  8626 */           return true;
/*       */         }
/*       */       } 
/*  8629 */       return false;
/*       */     }
/*       */     
/*       */     public boolean comparar2(String reg) {
/*  8633 */       for (int i = 0; i < this.indices2.length; i++) {
/*  8634 */         if (this.indices2[i].equals(reg)) {
/*  8635 */           return true;
/*       */         }
/*       */       } 
/*  8638 */       return false;
/*       */     }
/*       */     
/*       */     public boolean comparar3(String reg) {
/*  8642 */       for (int i = 0; i < this.indices3.length; i++) {
/*  8643 */         if (this.indices3[i].equals(reg)) {
/*  8644 */           return true;
/*       */         }
/*       */       } 
/*  8647 */       return false;
/*       */     }
/*       */     
/*       */     public boolean comparar4(String reg) {
/*  8651 */       for (int i = 0; i < this.indices4.length; i++) {
/*  8652 */         if (this.indices4[i].equals(reg)) {
/*  8653 */           return true;
/*       */         }
/*       */       } 
/*  8656 */       return false;
/*       */     }
/*       */     
/*       */     public boolean comparar5(String reg) {
/*  8660 */       for (int i = 0; i < this.indices5.length; i++) {
/*  8661 */         if (this.indices5[i].equals(reg)) {
/*  8662 */           return true;
/*       */         }
/*       */       } 
/*  8665 */       return false;
/*       */     }
/*       */     
/*       */     public boolean comparar6(String reg) {
/*  8669 */       for (int i = 0; i < this.indices6.length; i++) {
/*  8670 */         if (this.indices6[i].equals(reg)) {
/*  8671 */           return true;
/*       */         }
/*       */       } 
/*  8674 */       return false;
/*       */     }
/*       */     
/*       */     public boolean comparar7(String reg) {
/*  8678 */       for (int i = 0; i < this.indices7.length; i++) {
/*  8679 */         if (this.indices7[i].equals(reg)) {
/*  8680 */           return true;
/*       */         }
/*       */       } 
/*  8683 */       return false;
/*       */     }
/*       */   }
/*       */   
/*       */   class ImprimirRSP
/*       */     implements Printable {
/*  8689 */     String[] DATOS = new String[] { "sdfsdf", "sdfsdf", "sdfsdf" };
/*  8690 */     int opc = 0; public int print(Graphics g, PageFormat f, int pageIndex) { Font fuente; int i; String nombre, nombres[]; int esp, j; String nombre1;
/*       */       int k;
/*       */       String tipo, viaje;
/*  8693 */       Graphics2D g2 = (Graphics2D)g;
/*  8694 */       switch (pageIndex) {
/*       */         case 0:
/*  8696 */           g.setColor(Color.black);
/*  8697 */           g2 = (Graphics2D)g;
/*  8698 */           fuente = new Font("ARIAL", 0, 11);
/*  8699 */           g.setFont(fuente);
/*       */           
/*  8701 */           for (i = 0; i < this.DATOS.length; i++) {
/*  8702 */             System.out.println("datos " + i + " " + this.DATOS[i]);
/*       */           }
/*       */           
/*  8705 */           g.drawString(this.DATOS[0], 113, 47);
/*  8706 */           g.drawString(this.DATOS[1], 185, 47);
/*  8707 */           g.drawString(this.DATOS[2], 270, 47);
/*  8708 */           g.drawString(this.DATOS[3], 160, 62);
/*  8709 */           fuente = new Font("ARIAL", 0, 10);
/*  8710 */           g.setFont(fuente);
/*  8711 */           if (this.DATOS[3].contains("SÓLO TIRADA")) {
/*  8712 */             this.DATOS[4] = "--------------------------------------------";
/*       */           }
/*       */           
/*  8715 */           g.drawString(this.DATOS[4], 115, 102);
/*  8716 */           g.drawString(this.DATOS[5], 115, 119);
/*       */           
/*  8718 */           fuente = new Font("ARIAL", 0, 12);
/*  8719 */           g.setFont(fuente);
/*  8720 */           g.drawString(this.DATOS[6], 122, 142);
/*  8721 */           g.drawString(this.DATOS[7], 260, 142);
/*       */           
/*  8723 */           fuente = new Font("ARIAL", 0, 10);
/*  8724 */           g.setFont(fuente);
/*  8725 */           g.drawString(this.DATOS[8], 125, 172);
/*  8726 */           g.drawString(this.DATOS[9], 265, 172);
/*       */           
/*  8728 */           g.drawString(this.DATOS[10], 115, 214);
/*  8729 */           g.drawString(this.DATOS[11], 115, 232);
/*  8730 */           g.drawString(this.DATOS[12], 115, 251);
/*       */           
/*  8732 */           fuente = new Font("ARIAL", 0, 11);
/*  8733 */           g.setFont(fuente);
/*       */           
/*  8735 */           if (this.DATOS[13].equals("")) {
/*  8736 */             this.DATOS[13] = "0";
/*       */           }
/*  8738 */           g.drawString(this.DATOS[13], 118, 282);
/*  8739 */           if (this.DATOS[14].equals("")) {
/*  8740 */             this.DATOS[14] = "0";
/*       */           }
/*  8742 */           g.drawString(this.DATOS[14], 238, 282);
/*  8743 */           if (this.DATOS[15].equals("")) {
/*  8744 */             this.DATOS[15] = "0";
/*       */           }
/*  8746 */           g.drawString(this.DATOS[15], 94, 317);
/*  8747 */           if (this.DATOS[16].equals("")) {
/*  8748 */             this.DATOS[16] = "0";
/*       */           }
/*  8750 */           g.drawString(this.DATOS[16], 192, 317);
/*  8751 */           if (this.DATOS[17].equals("")) {
/*  8752 */             this.DATOS[17] = "0";
/*       */           }
/*  8754 */           g.drawString(this.DATOS[17], 282, 317);
/*  8755 */           fuente = new Font("ARIAL", 0, 9);
/*  8756 */           g.setFont(fuente);
/*  8757 */           nombre = "";
/*       */           
/*  8759 */           esp = 0;
/*       */           
/*  8761 */           for (j = 0; j < this.DATOS[18].length(); j++) {
/*  8762 */             if (this.DATOS[18].charAt(j) == ' ') {
/*  8763 */               esp++;
/*       */             }
/*       */           } 
/*  8766 */           nombres = new String[esp + 1];
/*  8767 */           for (j = 0; j <= esp; j++) {
/*  8768 */             nombres[j] = "";
/*       */           }
/*  8770 */           esp = 0;
/*  8771 */           for (j = 0; j < this.DATOS[18].length(); j++) {
/*  8772 */             if (this.DATOS[18].charAt(j) == ' ') {
/*  8773 */               esp++;
/*       */             } else {
/*  8775 */               nombres[esp] = nombres[esp] + nombres[esp];
/*       */             } 
/*       */           } 
/*  8778 */           for (j = 0; j < nombres.length; j++) {
/*  8779 */             if (j == 0) {
/*  8780 */               nombre = nombres[j];
/*       */             }
/*  8782 */             else if (!nombres[j].equals("")) {
/*  8783 */               nombre = nombre + " " + nombre + ". ";
/*       */             } 
/*       */           } 
/*       */ 
/*       */ 
/*       */           
/*  8789 */           esp = 0;
/*  8790 */           nombre1 = "";
/*  8791 */           for (k = 0; k < this.DATOS[19].length(); k++) {
/*  8792 */             if (this.DATOS[19].charAt(k) == ' ') {
/*  8793 */               esp++;
/*       */             }
/*       */           } 
/*  8796 */           nombres = new String[esp + 1];
/*  8797 */           for (k = 0; k <= esp; k++) {
/*  8798 */             nombres[k] = "";
/*       */           }
/*  8800 */           esp = 0;
/*  8801 */           for (k = 0; k < this.DATOS[19].length(); k++) {
/*  8802 */             if (this.DATOS[19].charAt(k) == ' ') {
/*  8803 */               esp++;
/*       */             } else {
/*  8805 */               nombres[esp] = nombres[esp] + nombres[esp];
/*       */             } 
/*       */           } 
/*  8808 */           for (k = 0; k < nombres.length; k++) {
/*  8809 */             if (k == 0) {
/*  8810 */               nombre1 = nombres[k];
/*       */             }
/*  8812 */             else if (!nombres[k].equals("")) {
/*  8813 */               nombre1 = nombre1 + " " + nombre1 + ". ";
/*       */             } 
/*       */           } 
/*       */ 
/*       */           
/*  8818 */           fuente = new Font("ARIAL", 1, 14);
/*  8819 */           g.setFont(fuente);
/*  8820 */           tipo = "";
/*  8821 */           tipo = this.DATOS[20] = this.DATOS[20].substring(0, 4);
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */           
/*  8829 */           g.drawString(tipo, 280, 72);
/*  8830 */           fuente = new Font("ARIAL", 0, 10);
/*  8831 */           g.setFont(fuente);
/*  8832 */           viaje = "";
/*  8833 */           if (this.DATOS[21].equals("FULL")) {
/*  8834 */             viaje = "TIPO DE VIAJE: FULL";
/*       */           } else {
/*  8836 */             viaje = "TIPO DE VIAJE: SENCILLO";
/*       */           } 
/*  8838 */           g.drawString(viaje, 100, 385);
/*  8839 */           g.drawString(nombre, 80, 350);
/*  8840 */           g.drawString(nombre1, 230, 350);
/*  8841 */           return 0;
/*       */       } 
/*  8843 */       return 1; }
/*       */ 
/*       */ 
/*       */     
/*       */     public void recibeDatos(String[] datos) {
/*  8848 */       ImprimirRSP im = new ImprimirRSP();
/*  8849 */       im.DATOS = datos;
/*  8850 */       PrinterJob job = PrinterJob.getPrinterJob();
/*  8851 */       job.setPrintable(im);
/*  8852 */       if (job.printDialog())
/*       */         try {
/*  8854 */           job.print();
/*  8855 */         } catch (PrinterException e) {
/*  8856 */           JOptionPane.showMessageDialog(null, "Error al imprimir " + e.getMessage());
/*       */         }  
/*       */     }
/*       */   }
/*       */   
/*       */   public class ImprimirGuias
/*       */     implements Printable
/*       */   {
/*       */     int[] pageBreaks;
/*       */     String[] textLines;
/*  8866 */     Graphics g2 = null;
/*  8867 */     int Pag = 0;
/*       */     String[] Lineas;
/*  8869 */     int linesPerPage = 50;
/*  8870 */     int orientacion = 0;
/*  8871 */     double X = 0.0D;
/*  8872 */     double Y = 0.0D;
/*       */     
/*       */     private void initTextLines() {
/*  8875 */       if (this.textLines == null) {
/*  8876 */         this.Lineas = ModificarGuias.this.regresaLineas();
/*  8877 */         int numLines = this.Lineas.length;
/*  8878 */         this.textLines = new String[numLines];
/*  8879 */         for (int i = 0; i < numLines; i++) {
/*  8880 */           this.textLines[i] = this.Lineas[i];
/*       */         }
/*       */       } 
/*       */     }
/*       */     
/*       */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/*  8886 */       Font font = new Font("Serif", 0, 8);
/*  8887 */       FontMetrics metrics = g.getFontMetrics(font);
/*  8888 */       int lineHeight = metrics.getHeight();
/*  8889 */       if (this.pageBreaks == null) {
/*  8890 */         initTextLines();
/*  8891 */         this.orientacion = pf.getOrientation();
/*  8892 */         if (pf.getOrientation() == 1) {
/*  8893 */           this.linesPerPage = 45;
/*  8894 */           this.X = pf.getWidth();
/*  8895 */           this.Y = pf.getHeight();
/*       */         } else {
/*  8897 */           this.linesPerPage = 30;
/*  8898 */           this.X = pf.getWidth();
/*  8899 */           this.Y = pf.getHeight();
/*       */         } 
/*  8901 */         int numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/*  8902 */         this.Pag = numBreaks;
/*  8903 */         this.pageBreaks = new int[numBreaks];
/*  8904 */         for (int b = 0; b < numBreaks; b++) {
/*  8905 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*       */         }
/*       */       } 
/*  8908 */       if (pageIndex > this.pageBreaks.length) {
/*  8909 */         return 1;
/*       */       }
/*  8911 */       Graphics2D g2d = (Graphics2D)g;
/*       */       
/*  8913 */       this.g2 = g;
/*  8914 */       g2d.translate(pf.getImageableX(), 10.0D);
/*  8915 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/*  8916 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/*  8917 */       encabezado();
/*  8918 */       int y = 90;
/*  8919 */       int lineas = 0;
/*       */       
/*  8921 */       for (int line = start; line < end; line++) {
/*  8922 */         y += 12;
/*  8923 */         int Xempe = 35;
/*  8924 */         String valor = "";
/*  8925 */         if (line < 9) {
/*  8926 */           valor = "0" + line + 1;
/*       */         } else {
/*  8928 */           valor = "" + line + 1;
/*       */         } 
/*  8930 */         g.drawString(valor, 20, y);
/*  8931 */         for (int j = 0; j < ModificarGuias.this.LETRASMAX.length; j++) {
/*  8932 */           g.drawString(ModificarGuias.this.REGIS[line][j], Xempe, y);
/*  8933 */           Xempe += ModificarGuias.this.LETRASMAX[j] * 5;
/*  8934 */           if (j < ModificarGuias.this.LETRASMAX.length - 1) {
/*  8935 */             this.g2.drawLine(Xempe - 4, 92, Xempe - 4, y);
/*       */           }
/*       */         } 
/*  8938 */         y += 2;
/*  8939 */         this.g2.drawLine(18, y, (int)this.X - 47, y);
/*  8940 */         lineas = y;
/*       */       } 
/*  8942 */       this.g2.drawLine(34, 92, 34, lineas);
/*  8943 */       this.g2.drawLine(18, 92, 18, lineas);
/*  8944 */       this.g2.drawLine((int)this.X - 47, 92, (int)this.X - 47, lineas);
/*  8945 */       if (this.orientacion == 1) {
/*  8946 */         g.drawString("Página " + pageIndex + 1, 538, 760);
/*       */       } else {
/*  8948 */         g.drawString("Página " + pageIndex + 1, 717, 570);
/*       */       } 
/*  8950 */       Font fuente = new Font("Dialog", 1, 9);
/*  8951 */       this.g2.setFont(fuente);
/*  8952 */       if (this.Pag == pageIndex) {
/*  8953 */         this.g2.drawLine(18, lineas + 17, (int)this.X - 47, lineas + 17);
/*  8954 */         this.g2.drawLine(18, lineas + 19, (int)this.X - 47, lineas + 19);
/*       */         
/*  8956 */         this.g2.drawString("Servicios de Flete:", 20, lineas + 30);
/*  8957 */         this.g2.drawString("Pipas:", 20, lineas + 45);
/*  8958 */         this.g2.drawString("Puzolana:", 20, lineas + 60);
/*       */         
/*  8960 */         this.g2.drawString("Servicios de Renta:", 170, lineas + 30);
/*  8961 */         this.g2.drawString("Cal viva:", 170, lineas + 45);
/*  8962 */         this.g2.drawString("Recorte de Perf:", 170, lineas + 60);
/*       */         
/*  8964 */         this.g2.drawString("Servicios Integrales:", 320, lineas + 30);
/*  8965 */         this.g2.drawString("Chatarra:", 320, lineas + 45);
/*  8966 */         this.g2.drawString("Fluorita:", 320, lineas + 60);
/*       */         
/*  8968 */         this.g2.drawString("Servicios de Retro:", 470, lineas + 30);
/*  8969 */         this.g2.drawString("Coke de Petroleo:", 470, lineas + 45);
/*  8970 */         this.g2.drawString("Rebaba de Talón:", 470, lineas + 60);
/*       */         
/*  8972 */         this.g2.drawString("Góndolas:", 620, lineas + 30);
/*  8973 */         this.g2.drawString("Escama de Lam:", 620, lineas + 45);
/*  8974 */         this.g2.drawString("Otros:", 620, lineas + 60);
/*       */         
/*  8976 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[0], 120, lineas + 30);
/*  8977 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[3], 120, lineas + 45);
/*  8978 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[10], 120, lineas + 60);
/*       */         
/*  8980 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[1], 260, lineas + 30);
/*  8981 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[6], 260, lineas + 45);
/*  8982 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[11], 260, lineas + 60);
/*       */         
/*  8984 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[14], 420, lineas + 30);
/*  8985 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[7], 420, lineas + 45);
/*  8986 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[12], 420, lineas + 60);
/*       */         
/*  8988 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[4], 565, lineas + 30);
/*  8989 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[8], 565, lineas + 45);
/*  8990 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[13], 565, lineas + 60);
/*       */         
/*  8992 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[2], 705, lineas + 30);
/*  8993 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[9], 705, lineas + 45);
/*  8994 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[15], 705, lineas + 60);
/*       */       } 
/*       */ 
/*       */       
/*  8998 */       this.g2.setColor(Color.WHITE);
/*  8999 */       this.g2.fillRect((int)this.X - 46, 12, (int)this.X - 46, lineas);
/*  9000 */       return 0;
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
/*       */     public void encabezado() {
/*  9013 */       Font fuente = new Font("Dialog", 0, 8);
/*  9014 */       this.g2.setFont(fuente);
/*  9015 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/*  9016 */       Image img = imagen.getImage();
/*  9017 */       this.g2.drawImage(img, 16, 15, 62, 62, null);
/*  9018 */       fuente = new Font("Times New Roman", 1, 19);
/*  9019 */       this.g2.setFont(fuente);
/*  9020 */       this.g2.drawString("GRUPO FORSIS - " + ModificarGuias.this.SUCURSAL, 180, 20);
/*  9021 */       this.g2.drawRect(80, 30, 483, 17);
/*  9022 */       this.g2.drawRect(80, 47, 483, 17);
/*  9023 */       fuente = new Font("Dialog", 0, 10);
/*  9024 */       this.g2.setFont(fuente);
/*  9025 */       this.g2.drawString("CLIENTE", 90, 42);
/*  9026 */       this.g2.drawString("REPORTE TURNO", 90, 59);
/*  9027 */       this.g2.drawString("FECHA", 362, 59);
/*       */       
/*  9029 */       this.g2.drawLine(138, 31, 138, 47);
/*  9030 */       this.g2.drawLine(185, 48, 185, 64);
/*  9031 */       this.g2.drawLine(355, 48, 355, 64);
/*  9032 */       this.g2.drawLine(400, 48, 400, 64);
/*       */       
/*  9034 */       fuente = new Font("Dialog", 1, 11);
/*  9035 */       this.g2.setFont(fuente);
/*  9036 */       this.g2.drawString(String.valueOf(ModificarGuias.this.jComboBox3.getSelectedItem()), 145, 42);
/*  9037 */       String horario = "";
/*  9038 */       if (ModificarGuias.this.jComboBox21.getSelectedIndex() == 0) {
/*  9039 */         horario = "NATURAL (24 HRS.)";
/*       */       }
/*  9041 */       if (ModificarGuias.this.jComboBox21.getSelectedIndex() == 1) {
/*  9042 */         horario = "DIURNO (9am - 9pm)";
/*       */       }
/*  9044 */       if (ModificarGuias.this.jComboBox21.getSelectedIndex() == 2) {
/*  9045 */         horario = "NOCTURNO (9pm - 9am)";
/*       */       }
/*  9047 */       this.g2.drawString(horario, 190, 59);
/*       */       
/*  9049 */       Date fecha1 = ModificarGuias.this.jDateChooser4.getDate();
/*  9050 */       Date fecha2 = ModificarGuias.this.jDateChooser5.getDate();
/*       */       
/*  9052 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  9053 */       String cadenaFecha = "";
/*  9054 */       cadenaFecha = formato.format(fecha1);
/*  9055 */       String AÑO = cadenaFecha.substring(0, 4);
/*  9056 */       String MES = cadenaFecha.substring(4, 6);
/*  9057 */       String DIA = cadenaFecha.substring(6, 8);
/*  9058 */       String fechaCompleta1 = DIA + "/" + DIA + "/" + MES;
/*       */       
/*  9060 */       cadenaFecha = formato.format(fecha2);
/*  9061 */       AÑO = cadenaFecha.substring(0, 4);
/*  9062 */       MES = cadenaFecha.substring(4, 6);
/*  9063 */       DIA = cadenaFecha.substring(6, 8);
/*  9064 */       String fechaCompleta2 = fechaCompleta1 + "  AL  " + fechaCompleta1 + "/" + DIA + "/" + MES;
/*  9065 */       this.g2.drawString(fechaCompleta2, 405, 59);
/*       */       
/*  9067 */       fuente = new Font("Dialog", 1, 9);
/*  9068 */       this.g2.setFont(fuente);
/*  9069 */       int Xempe = 35;
/*       */       
/*  9071 */       for (int j = 0; j < ModificarGuias.this.LETRASMAX.length; j++) {
/*  9072 */         System.out.println("Valores: " + ModificarGuias.this.LETRASMAX[j] + " " + ModificarGuias.this.NOMBRECOL[j] + " " + j);
/*  9073 */         this.g2.drawString(ModificarGuias.this.NOMBRECOL[j], Xempe, 87);
/*  9074 */         Xempe += ModificarGuias.this.LETRASMAX[j] * 5;
/*       */       } 
/*  9076 */       fuente = new Font("Dialog", 0, 7);
/*  9077 */       this.g2.setFont(fuente);
/*       */       
/*  9079 */       this.g2.drawLine(18, 90, (int)this.X - 47, 90);
/*  9080 */       this.g2.drawLine(18, 92, (int)this.X - 47, 92);
/*       */     }
/*       */     
/*       */     public void recibeDatos() {
/*  9084 */       PrinterJob job = PrinterJob.getPrinterJob();
/*  9085 */       job.setPrintable(this);
/*       */       
/*  9087 */       PageFormat pf = job.defaultPage();
/*  9088 */       Paper papel = pf.getPaper();
/*  9089 */       papel.setSize(612.0D, 792.0D);
/*  9090 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/*  9091 */       pf.setPaper(papel);
/*       */       
/*  9093 */       pf.setOrientation(0);
/*  9094 */       job.setPrintable(new ImprimirGuias(), pf);
/*  9095 */       job.defaultPage(pf);
/*       */       
/*  9097 */       boolean ok = job.printDialog();
/*  9098 */       if (ok) {
/*       */         try {
/*  9100 */           job.print();
/*  9101 */         } catch (PrinterException printerException) {}
/*       */       }
/*       */     }
/*       */   }
/*       */ 
/*       */   
/*       */   class EnviarCorreo
/*       */   {
/*       */     public EnviarCorreo() {
/*       */       try {
/*  9111 */         Properties props = new Properties();
/*  9112 */         props.setProperty("mail.smtp.host", "smtp.gmail.com");
/*  9113 */         props.setProperty("mail.smtp.starttls.enable", "true");
/*  9114 */         props.setProperty("mail.smtp.port", "587");
/*  9115 */         props.setProperty("mail.smtp.user", "forsis4@gmail.com");
/*  9116 */         props.setProperty("mail.smtp.auth", "true");
/*       */         
/*  9118 */         MimeBodyPart mimeBodyPart1 = new MimeBodyPart();
/*  9119 */         mimeBodyPart1.setText(ModificarGuias.this.jTextArea6.getText() + "\n\n\n\nvisítanos en www.forsis.com.mx \n________________________________________________________________________________________\nFavor de no responder a la dirección remitente, ya que es enviado con el sistema FORSIS");
/*       */         
/*  9121 */         MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
/*       */         
/*  9123 */         mimeBodyPart2.setDataHandler(new DataHandler((DataSource)new FileDataSource("Archivos/" + ModificarGuias.this.ARCHIVO)));
/*  9124 */         mimeBodyPart2.setFileName(ModificarGuias.this.ARCHIVO);
/*       */ 
/*       */         
/*  9127 */         Session session = Session.getDefaultInstance(props);
/*       */ 
/*       */         
/*  9130 */         MimeMessage message = new MimeMessage(session);
/*  9131 */         message.setFrom((Address)new InternetAddress("forsis4@gmail.com"));
/*       */         
/*  9133 */         MimeMultipart multiParte = new MimeMultipart();
/*  9134 */         multiParte.addBodyPart((BodyPart)mimeBodyPart1);
/*  9135 */         multiParte.addBodyPart((BodyPart)mimeBodyPart2);
/*       */         
/*  9137 */         Address[] direccion = new Address[ModificarGuias.this.DIRECCIONES.length];
/*  9138 */         for (int i = 0; i < ModificarGuias.this.DIRECCIONES.length; i++) {
/*  9139 */           direccion[i] = (Address)new InternetAddress(ModificarGuias.this.DIRECCIONES[i]);
/*       */         }
/*  9141 */         message.addRecipients(Message.RecipientType.TO, direccion);
/*       */         
/*  9143 */         message.setSubject(ModificarGuias.this.jTextField27.getText());
/*  9144 */         message.setContent((Multipart)multiParte);
/*       */         
/*  9146 */         Transport t = session.getTransport("smtp");
/*       */         
/*  9148 */         t.connect("forsis4@gmail.com", "dpceabhsjgudkusm");
/*  9149 */         t.sendMessage((Message)message, message.getAllRecipients());
/*  9150 */         t.close();
/*  9151 */         ModificarGuias.this.jLabel25.setVisible(false);
/*  9152 */         JOptionPane.showMessageDialog(ModificarGuias.this.jDialog7, "El mensaje se ha enviado correctamente a todas las direcciones", "Mensaje Enviado", 0, ModificarGuias.this.INFO);
/*  9153 */         ModificarGuias.this.jDialog7.setVisible(false);
/*  9154 */       } catch (Exception e) {
/*  9155 */         e.printStackTrace();
/*  9156 */         ModificarGuias.this.jLabel25.setVisible(false);
/*  9157 */         JOptionPane.showMessageDialog(ModificarGuias.this.jDialog7, "Ha ocurrido un error al enviar el correo electrónico", "Mensaje no Enviado", 0, ModificarGuias.this.ERROR);
/*       */       } 
/*  9159 */       ModificarGuias.this.jButton46.setEnabled(true);
/*       */     }
/*       */   }
/*       */   
/*       */   class CrearPDF
/*       */   {
/*  9165 */     int w = 0; int h = 0;
/*       */     int[] pageBreaks;
/*       */     String[] textLines;
/*  9168 */     Graphics g2 = null;
/*  9169 */     int Pag = 0;
/*       */     String[] Lineas;
/*  9171 */     int linesPerPage = 0;
/*  9172 */     int orientacion = 0;
/*  9173 */     double X = 0.0D;
/*  9174 */     double Y = 0.0D;
/*  9175 */     int pageIndex = 0;
/*       */ 
/*       */     
/*       */     public CrearPDF() {
/*  9179 */       if (this.textLines == null) {
/*  9180 */         int numLines = ModificarGuias.this.rSTableMetro1.getRowCount();
/*  9181 */         this.textLines = new String[numLines];
/*  9182 */         this.X = (this.w = 612);
/*  9183 */         this.Y = (this.h = 792);
/*       */       } 
/*  9185 */       this.linesPerPage = 52;
/*  9186 */       int numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/*  9187 */       this.Pag = numBreaks;
/*  9188 */       this.pageBreaks = new int[numBreaks];
/*  9189 */       for (int b = 0; b < numBreaks; b++) {
/*  9190 */         this.pageBreaks[b] = (b + 1) * this.linesPerPage;
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
/*  9202 */       createPdf();
/*       */     }
/*       */     
/*       */     public void createPdf() {
/*  9206 */       Document document = new Document(new Rectangle(this.w, this.h));
/*       */       try {
/*  9208 */         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Archivos/" + ModificarGuias.this.ARCHIVO));
/*  9209 */         document.open();
/*  9210 */         PdfContentByte cb = writer.getDirectContent();
/*  9211 */         Graphics2D g2 = cb.createGraphics(this.w, this.h);
/*       */         
/*  9213 */         this.g2 = g2;
/*  9214 */         for (int i = 0; i <= this.pageBreaks.length; i++) {
/*  9215 */           this.pageIndex = i;
/*  9216 */           paint(g2);
/*  9217 */           g2.dispose();
/*  9218 */           document.newPage();
/*       */         } 
/*  9220 */       } catch (DocumentException de) {
/*  9221 */         System.err.println(de.getMessage());
/*  9222 */       } catch (IOException ioe) {
/*  9223 */         System.err.println(ioe.getMessage());
/*       */       } 
/*  9225 */       document.close();
/*       */     }
/*       */ 
/*       */     
/*       */     public void encabezado() {
/*  9230 */       Font fuente = new Font("Dialog", 0, 8);
/*  9231 */       this.g2.setFont(fuente);
/*  9232 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/*  9233 */       Image img = imagen.getImage();
/*  9234 */       this.g2.drawImage(img, 16, 15, 62, 62, null);
/*  9235 */       fuente = new Font("Times New Roman", 1, 19);
/*  9236 */       this.g2.setFont(fuente);
/*  9237 */       this.g2.drawString("GRUPO FORSIS - " + ModificarGuias.this.SUCURSAL, 180, 20);
/*  9238 */       this.g2.drawRect(80, 30, 483, 17);
/*  9239 */       this.g2.drawRect(80, 47, 483, 17);
/*  9240 */       fuente = new Font("Dialog", 0, 10);
/*  9241 */       this.g2.setFont(fuente);
/*  9242 */       this.g2.drawString("CLIENTE", 90, 42);
/*  9243 */       this.g2.drawString("REPORTE TURNO", 90, 59);
/*  9244 */       this.g2.drawString("FECHA", 362, 59);
/*       */       
/*  9246 */       this.g2.drawLine(138, 31, 138, 47);
/*  9247 */       this.g2.drawLine(185, 48, 185, 64);
/*  9248 */       this.g2.drawLine(355, 48, 355, 64);
/*  9249 */       this.g2.drawLine(400, 48, 400, 64);
/*       */       
/*  9251 */       fuente = new Font("Dialog", 1, 11);
/*  9252 */       this.g2.setFont(fuente);
/*  9253 */       this.g2.drawString(String.valueOf(ModificarGuias.this.jComboBox3.getSelectedItem()), 145, 42);
/*  9254 */       String horario = "";
/*  9255 */       if (ModificarGuias.this.jComboBox21.getSelectedIndex() == 0) {
/*  9256 */         horario = "NATURAL (24 HRS.)";
/*       */       }
/*  9258 */       if (ModificarGuias.this.jComboBox21.getSelectedIndex() == 1) {
/*  9259 */         horario = "DIURNO (9am - 9pm)";
/*       */       }
/*  9261 */       if (ModificarGuias.this.jComboBox21.getSelectedIndex() == 2) {
/*  9262 */         horario = "NOCTURNO (9pm - 9am)";
/*       */       }
/*  9264 */       this.g2.drawString(horario, 190, 59);
/*       */       
/*  9266 */       Date fecha1 = ModificarGuias.this.jDateChooser4.getDate();
/*  9267 */       Date fecha2 = ModificarGuias.this.jDateChooser5.getDate();
/*       */       
/*  9269 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  9270 */       String cadenaFecha = "";
/*  9271 */       cadenaFecha = formato.format(fecha1);
/*  9272 */       String AÑO = cadenaFecha.substring(0, 4);
/*  9273 */       String MES = cadenaFecha.substring(4, 6);
/*  9274 */       String DIA = cadenaFecha.substring(6, 8);
/*  9275 */       String fechaCompleta1 = DIA + "/" + DIA + "/" + MES;
/*       */       
/*  9277 */       cadenaFecha = formato.format(fecha2);
/*  9278 */       AÑO = cadenaFecha.substring(0, 4);
/*  9279 */       MES = cadenaFecha.substring(4, 6);
/*  9280 */       DIA = cadenaFecha.substring(6, 8);
/*  9281 */       String fechaCompleta2 = fechaCompleta1 + "  AL  " + fechaCompleta1 + "/" + DIA + "/" + MES;
/*  9282 */       this.g2.drawString(fechaCompleta2, 405, 59);
/*       */     }
/*       */     
/*       */     public void paint(Graphics g) {
/*  9286 */       Graphics2D g2d = (Graphics2D)g;
/*  9287 */       int start = (this.pageIndex == 0) ? 0 : this.pageBreaks[this.pageIndex - 1];
/*  9288 */       int end = (this.pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[this.pageIndex];
/*  9289 */       encabezado();
/*  9290 */       int y = 90;
/*  9291 */       int lineas = 0;
/*       */       
/*  9293 */       this.g2.drawRect(25, 80, 550, 12);
/*  9294 */       this.g2.setColor(new Color(204, 0, 0));
/*  9295 */       this.g2.fillRect(25, 81, 550, 10);
/*       */       
/*  9297 */       Font fuente = new Font("Dialog", 0, 7);
/*  9298 */       this.g2.setFont(fuente);
/*  9299 */       this.g2.setColor(Color.WHITE);
/*  9300 */       int[] valores = { 29, 65, 105, 170, 240, 325, 430, 520, 550 };
/*  9301 */       this.g2.drawString("FOLIO", valores[0], 89);
/*  9302 */       this.g2.drawString("FECHA", valores[1], 89);
/*  9303 */       this.g2.drawString("SERVICIO", valores[2], 89);
/*  9304 */       this.g2.drawString("RESIDUO", valores[3], 89);
/*  9305 */       this.g2.drawString("CLIENTE", valores[4], 89);
/*  9306 */       this.g2.drawString("ORIGEN", valores[5], 89);
/*  9307 */       this.g2.drawString("DESTINO", valores[6], 89);
/*  9308 */       this.g2.drawString("T 1", valores[7], 89);
/*  9309 */       this.g2.drawString("T 2", valores[8], 89);
/*       */       
/*  9311 */       this.g2.setColor(Color.BLACK);
/*  9312 */       y = 90;
/*  9313 */       for (int line = start; line < end; line++) {
/*  9314 */         y += 12;
/*       */         
/*  9316 */         String valor = "";
/*  9317 */         if (line < 9) {
/*  9318 */           valor = "0" + line + 1;
/*       */         } else {
/*  9320 */           valor = "" + line + 1;
/*       */         } 
/*  9322 */         fuente = new Font("Dialog", 1, 7);
/*  9323 */         this.g2.setFont(fuente);
/*  9324 */         this.g2.drawString(valor, ModificarGuias.this.alinearDer(20, valor.length()), y - 2);
/*       */         
/*  9326 */         fuente = new Font("Dialog", 0, 6);
/*  9327 */         this.g2.setFont(fuente);
/*       */         
/*  9329 */         this.g2.drawString(String.valueOf(ModificarGuias.this.rSTableMetro1.getValueAt(line, 0)), valores[0], y - 2);
/*  9330 */         String fecha = String.valueOf(ModificarGuias.this.rSTableMetro1.getValueAt(line, 1));
/*  9331 */         String col = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/*  9332 */         this.g2.drawString(col, valores[1], y - 2);
/*       */         
/*  9334 */         this.g2.drawString(String.valueOf(ModificarGuias.this.rSTableMetro1.getValueAt(line, 4)), valores[2], y - 2);
/*  9335 */         pintar(valores[2] + 50, y + 2);
/*  9336 */         this.g2.drawString(String.valueOf(ModificarGuias.this.rSTableMetro1.getValueAt(line, 5)), valores[3], y - 2);
/*  9337 */         pintar(valores[3] + 60, y + 2);
/*  9338 */         this.g2.drawString(String.valueOf(ModificarGuias.this.rSTableMetro1.getValueAt(line, 6)), valores[4], y - 2);
/*  9339 */         pintar(valores[4] + 70, y + 2);
/*  9340 */         this.g2.drawString(String.valueOf(ModificarGuias.this.rSTableMetro1.getValueAt(line, 7)), valores[5], y - 2);
/*  9341 */         pintar(valores[5] + 80, y + 2);
/*  9342 */         this.g2.drawString(String.valueOf(ModificarGuias.this.rSTableMetro1.getValueAt(line, 8)), valores[6], y - 2);
/*  9343 */         pintar(valores[6] + 75, y + 2);
/*  9344 */         this.g2.drawString(String.valueOf(ModificarGuias.this.rSTableMetro1.getValueAt(line, 9)), valores[7], y - 2);
/*  9345 */         this.g2.drawString(String.valueOf(ModificarGuias.this.rSTableMetro1.getValueAt(line, 11)), valores[8], y - 2);
/*       */       } 
/*       */       
/*  9348 */       g.drawString("Página " + this.pageIndex + 1, 540, 749);
/*  9349 */       if (this.Pag == this.pageIndex) {
/*       */         
/*  9351 */         fuente = new Font("Dialog", 1, 7);
/*  9352 */         this.g2.setFont(fuente);
/*  9353 */         this.g2.drawString("ELABORÓ", 190, 720);
/*  9354 */         this.g2.drawString("_____________________________________", 140, 752);
/*  9355 */         this.g2.drawString("NOMBRE Y FIRMA", 178, 765);
/*       */         
/*  9357 */         this.g2.drawString("RECIBE", 390, 720);
/*  9358 */         this.g2.drawString("_____________________________________", 340, 752);
/*  9359 */         this.g2.drawString("NOMBRE Y FIRMA", 378, 765);
/*       */       } 
/*       */       
/*  9362 */       this.g2.setColor(Color.white);
/*  9363 */       this.g2.fillRect((int)this.X - 46, 12, (int)this.X - 46, lineas);
/*       */     }
/*       */ 
/*       */     
/*       */     public void pintar(int x, int y) {
/*  9368 */       this.g2.setColor(Color.WHITE);
/*  9369 */       this.g2.fillRect(x, y - 10, 50, 12);
/*  9370 */       this.g2.setColor(Color.BLACK);
/*       */     }
/*       */   }
/*       */   
/*       */   class Esperando
/*       */     extends Thread {
/*       */     public void run() {
/*  9377 */       ModificarGuias.EnviarCorreo correo = new ModificarGuias.EnviarCorreo();
/*       */     }
/*       */   }
/*       */   
/*       */   class ImprimirFacturas
/*       */     implements Printable {
/*       */     int[] pageBreaks;
/*       */     String[] textLines;
/*  9385 */     Graphics g2 = null;
/*  9386 */     int Pag = 0;
/*       */     String[] Lineas;
/*  9388 */     int linesPerPage = 50;
/*  9389 */     int orientacion = 0;
/*  9390 */     double X = 0.0D;
/*  9391 */     double Y = 0.0D;
/*       */     
/*  9393 */     int[] PXCOL = new int[] { 38, 88, 140, 205, 275, 355, 435, 475, 515 };
/*       */     
/*       */     private void initTextLines() {
/*  9396 */       if (this.textLines == null) {
/*  9397 */         this.Lineas = ModificarGuias.this.regresaLineas();
/*  9398 */         int numLines = this.Lineas.length;
/*  9399 */         this.textLines = new String[numLines];
/*  9400 */         for (int i = 0; i < numLines; i++) {
/*  9401 */           this.textLines[i] = this.Lineas[i];
/*       */         }
/*       */       } 
/*       */     }
/*       */     
/*       */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/*  9407 */       Font font = new Font("Serif", 0, 8);
/*  9408 */       FontMetrics metrics = g.getFontMetrics(font);
/*  9409 */       int lineHeight = metrics.getHeight();
/*  9410 */       if (this.pageBreaks == null) {
/*  9411 */         initTextLines();
/*  9412 */         this.orientacion = pf.getOrientation();
/*  9413 */         if (pf.getOrientation() == 1) {
/*  9414 */           this.linesPerPage = 45;
/*  9415 */           this.X = pf.getWidth();
/*  9416 */           this.Y = pf.getHeight();
/*       */         } else {
/*  9418 */           this.linesPerPage = 30;
/*  9419 */           this.X = pf.getWidth();
/*  9420 */           this.Y = pf.getHeight();
/*       */         } 
/*  9422 */         int numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/*  9423 */         this.Pag = numBreaks;
/*  9424 */         this.pageBreaks = new int[numBreaks];
/*  9425 */         for (int b = 0; b < numBreaks; b++) {
/*  9426 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*       */         }
/*       */       } 
/*  9429 */       if (pageIndex > this.pageBreaks.length) {
/*  9430 */         return 1;
/*       */       }
/*  9432 */       Graphics2D g2d = (Graphics2D)g;
/*       */       
/*  9434 */       this.g2 = g;
/*  9435 */       g2d.translate(pf.getImageableX(), 10.0D);
/*  9436 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/*  9437 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/*  9438 */       encabezado();
/*  9439 */       int y = 90;
/*  9440 */       int lineas = 0;
/*       */       
/*  9442 */       for (int line = start; line < end; line++) {
/*  9443 */         y += 12;
/*  9444 */         int Xempe = 35;
/*  9445 */         String valor = "";
/*  9446 */         if (line < 9) {
/*  9447 */           valor = "0" + line + 1;
/*       */         } else {
/*  9449 */           valor = "" + line + 1;
/*       */         } 
/*  9451 */         g.drawString(valor, 20, y);
/*  9452 */         this.g2.drawString(ModificarGuias.this.REGIS[line][0], this.PXCOL[0], y);
/*  9453 */         this.g2.drawString(ModificarGuias.this.REGIS[line][1], this.PXCOL[1], y);
/*  9454 */         this.g2.drawString(ModificarGuias.this.REGIS[line][2], this.PXCOL[2], y);
/*  9455 */         this.g2.drawString(ModificarGuias.this.REGIS[line][3], this.PXCOL[3], y);
/*  9456 */         this.g2.drawString(ModificarGuias.this.REGIS[line][4], this.PXCOL[4], y);
/*  9457 */         this.g2.drawString(ModificarGuias.this.REGIS[line][5], this.PXCOL[5], y);
/*  9458 */         this.g2.drawString(ModificarGuias.this.REGIS[line][6], this.PXCOL[6], y);
/*  9459 */         this.g2.drawString(ModificarGuias.this.REGIS[line][7], this.PXCOL[7], y);
/*  9460 */         this.g2.drawString(ModificarGuias.this.REGIS[line][8], this.PXCOL[8], y);
/*  9461 */         y += 2;
/*  9462 */         lineas = y;
/*  9463 */         this.g2.drawLine(18, y, (int)this.X - 47, y);
/*  9464 */         this.g2.drawLine(this.PXCOL[1] - 3, 92, this.PXCOL[1] - 3, y);
/*  9465 */         this.g2.drawLine(this.PXCOL[2] - 3, 92, this.PXCOL[2] - 3, y);
/*  9466 */         this.g2.drawLine(this.PXCOL[3] - 3, 92, this.PXCOL[3] - 3, y);
/*  9467 */         this.g2.drawLine(this.PXCOL[4] - 3, 92, this.PXCOL[4] - 3, y);
/*  9468 */         this.g2.drawLine(this.PXCOL[5] - 3, 92, this.PXCOL[5] - 3, y);
/*  9469 */         this.g2.drawLine(this.PXCOL[6] - 3, 92, this.PXCOL[6] - 3, y);
/*  9470 */         this.g2.drawLine(this.PXCOL[7] - 3, 92, this.PXCOL[7] - 3, y);
/*  9471 */         this.g2.drawLine(this.PXCOL[8] - 3, 92, this.PXCOL[8] - 3, y);
/*       */       } 
/*  9473 */       this.g2.drawLine(34, 92, 34, lineas);
/*  9474 */       this.g2.drawLine(18, 92, 18, lineas);
/*  9475 */       this.g2.drawLine((int)this.X - 47, 92, (int)this.X - 47, lineas);
/*  9476 */       if (this.orientacion == 1) {
/*  9477 */         g.drawString("Página " + pageIndex + 1, 538, 760);
/*       */       } else {
/*  9479 */         g.drawString("Página " + pageIndex + 1, 717, 570);
/*       */       } 
/*  9481 */       Font fuente = new Font("Dialog", 1, 9);
/*  9482 */       this.g2.setFont(fuente);
/*  9483 */       if (this.Pag == pageIndex) {
/*  9484 */         this.g2.drawLine(18, lineas + 17, (int)this.X - 47, lineas + 17);
/*  9485 */         this.g2.drawLine(18, lineas + 19, (int)this.X - 47, lineas + 19);
/*       */         
/*  9487 */         this.g2.drawString("Fletes:                               Mov en Falso:                   Mov Internos:                         Rentas:                            Retros:                                Serv Int:                  Otros Serv:", 20, lineas + 30);
/*  9488 */         this.g2.drawString("A de Fractura:                  A Residual:                        Lodo B Aceite:                       Lodo B Agua:                  Recorte B Aceite:", 20, lineas + 45);
/*  9489 */         this.g2.drawString("Recorte B Agua:              Salmuera:                          Saneamiento:                         Sedimento:                      Fletes - Varios:                   Otros:", 20, lineas + 60);
/*       */         
/*  9491 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[0], 104, lineas + 30);
/*  9492 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[1], 215, lineas + 30);
/*  9493 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[2], 335, lineas + 30);
/*  9494 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[3], 427, lineas + 30);
/*  9495 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[4], 554, lineas + 30);
/*  9496 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[5], 625, lineas + 30);
/*  9497 */         this.g2.drawString("" + ModificarGuias.this.OTROSSERVICIOS, 710, lineas + 30);
/*  9498 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[6], 104, lineas + 45);
/*  9499 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[7], 215, lineas + 45);
/*  9500 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[8], 335, lineas + 45);
/*  9501 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[9], 427, lineas + 45);
/*  9502 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[10], 554, lineas + 45);
/*  9503 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[11], 104, lineas + 60);
/*  9504 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[12], 215, lineas + 60);
/*  9505 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[13], 335, lineas + 60);
/*  9506 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[14], 427, lineas + 60);
/*  9507 */         this.g2.drawString("" + ModificarGuias.this.CANTTOTALES[15], 554, lineas + 60);
/*  9508 */         this.g2.drawString("" + ModificarGuias.this.OTROSRESIDUOS, 625, lineas + 60);
/*       */       } 
/*  9510 */       this.g2.setColor(Color.WHITE);
/*  9511 */       this.g2.fillRect((int)this.X - 46, 12, (int)this.X - 46, lineas);
/*  9512 */       return 0;
/*       */     }
/*       */     
/*       */     public void encabezado() {
/*  9516 */       Font fuente = new Font("Dialog", 0, 8);
/*  9517 */       this.g2.setFont(fuente);
/*  9518 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/*  9519 */       Image img = imagen.getImage();
/*  9520 */       this.g2.drawImage(img, 16, 15, 62, 62, null);
/*  9521 */       fuente = new Font("Times New Roman", 1, 19);
/*  9522 */       this.g2.setFont(fuente);
/*  9523 */       this.g2.drawString("GRUPO FORSIS - " + ModificarGuias.this.SUCURSAL, 180, 20);
/*  9524 */       this.g2.drawRect(80, 47, 483, 17);
/*  9525 */       fuente = new Font("Dialog", 0, 16);
/*  9526 */       this.g2.setFont(fuente);
/*  9527 */       this.g2.drawString("REPORTE DE PREFACTURA", 203, 42);
/*  9528 */       fuente = new Font("Dialog", 0, 11);
/*  9529 */       this.g2.setFont(fuente);
/*       */       
/*  9531 */       this.g2.drawString("TONELADAS               " + Math.rint(ModificarGuias.this.TONS * 1000.0D) / 1000.0D, 100, 60);
/*  9532 */       this.g2.drawString("FECHA", 362, 60);
/*       */       
/*  9534 */       this.g2.drawLine(185, 48, 185, 64);
/*  9535 */       this.g2.drawLine(355, 48, 355, 64);
/*  9536 */       this.g2.drawLine(410, 48, 410, 64);
/*       */       
/*  9538 */       Date fecha1 = ModificarGuias.this.jDateChooser4.getDate();
/*  9539 */       Date fecha2 = ModificarGuias.this.jDateChooser5.getDate();
/*       */       
/*  9541 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  9542 */       String cadenaFecha = "";
/*  9543 */       cadenaFecha = formato.format(fecha1);
/*  9544 */       String AÑO = cadenaFecha.substring(0, 4);
/*  9545 */       String MES = cadenaFecha.substring(4, 6);
/*  9546 */       String DIA = cadenaFecha.substring(6, 8);
/*  9547 */       String fechaCompleta1 = DIA + "/" + DIA + "/" + MES;
/*       */       
/*  9549 */       cadenaFecha = formato.format(fecha2);
/*  9550 */       AÑO = cadenaFecha.substring(0, 4);
/*  9551 */       MES = cadenaFecha.substring(4, 6);
/*  9552 */       DIA = cadenaFecha.substring(6, 8);
/*  9553 */       String fechaCompleta2 = fechaCompleta1 + "  AL  " + fechaCompleta1 + "/" + DIA + "/" + MES;
/*  9554 */       this.g2.drawString(fechaCompleta2, 415, 59);
/*       */       
/*  9556 */       fuente = new Font("Dialog", 1, 9);
/*  9557 */       this.g2.setFont(fuente);
/*  9558 */       int Xempe = 35;
/*  9559 */       this.g2.drawString(ModificarGuias.this.NOMBRECOL[0], this.PXCOL[0] + 3, 87);
/*  9560 */       this.g2.drawString(ModificarGuias.this.NOMBRECOL[1], this.PXCOL[1] + 3, 87);
/*  9561 */       this.g2.drawString(ModificarGuias.this.NOMBRECOL[2], this.PXCOL[2] + 3, 87);
/*  9562 */       this.g2.drawString(ModificarGuias.this.NOMBRECOL[3], this.PXCOL[3] + 3, 87);
/*  9563 */       this.g2.drawString(ModificarGuias.this.NOMBRECOL[4], this.PXCOL[4] + 3, 87);
/*  9564 */       this.g2.drawString(ModificarGuias.this.NOMBRECOL[5], this.PXCOL[5] + 3, 87);
/*  9565 */       this.g2.drawString(ModificarGuias.this.NOMBRECOL[6], this.PXCOL[6] + 3, 87);
/*  9566 */       this.g2.drawString(ModificarGuias.this.NOMBRECOL[7], this.PXCOL[7] + 3, 87);
/*  9567 */       this.g2.drawString(ModificarGuias.this.NOMBRECOL[8], this.PXCOL[8] + 3, 87);
/*       */       
/*  9569 */       fuente = new Font("Dialog", 0, 7);
/*  9570 */       this.g2.setFont(fuente);
/*       */       
/*  9572 */       this.g2.drawLine(18, 90, (int)this.X - 47, 90);
/*  9573 */       this.g2.drawLine(18, 92, (int)this.X - 47, 92);
/*       */     }
/*       */     
/*       */     public void recibeDatos() {
/*  9577 */       PrinterJob job = PrinterJob.getPrinterJob();
/*  9578 */       job.setPrintable(this);
/*       */       
/*  9580 */       PageFormat pf = job.defaultPage();
/*  9581 */       Paper papel = pf.getPaper();
/*  9582 */       papel.setSize(612.0D, 792.0D);
/*  9583 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/*  9584 */       pf.setPaper(papel);
/*  9585 */       pf.setOrientation(1);
/*  9586 */       job.setPrintable(new ImprimirFacturas(), pf);
/*  9587 */       job.defaultPage(pf);
/*       */       
/*  9589 */       boolean ok = job.printDialog();
/*  9590 */       if (ok) {
/*       */         try {
/*  9592 */           job.print();
/*  9593 */         } catch (PrinterException printerException) {}
/*       */       }
/*       */     }
/*       */   }
/*       */   
/*       */   public class Presionado
/*       */     implements Runnable
/*       */   {
/*       */     Thread t;
/*  9602 */     int cont = 0;
/*       */     
/*       */     public Presionado() {
/*  9605 */       this.t = new Thread(this);
/*  9606 */       this.t.start();
/*       */     }
/*       */ 
/*       */     
/*       */     public void start() {}
/*       */     
/*       */     public void run() {
/*       */       try {
/*  9614 */         Thread.currentThread(); Thread.sleep(1000L);
/*  9615 */         detener();
/*  9616 */       } catch (InterruptedException interruptedException) {}
/*       */     }
/*       */ 
/*       */     
/*       */     public void detener() {
/*  9621 */       ModificarGuias.this.consultar();
/*  9622 */       this.t.stop();
/*       */     }
/*       */     
/*       */     public void detenerFuera() {
/*  9626 */       this.t.stop();
/*       */     } }
/*       */   public class ImprimirViajes implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[][] Lineas; int linesPerPage; int orientacion; double X; double Y; int YINICIA;
/*       */     int[] PXCOL;
/*       */     int NumLineas;
/*       */     int numBreaks;
/*       */     
/*       */     public ImprimirViajes() {
/*  9634 */       this.g2 = null;
/*  9635 */       this.Pag = 0;
/*       */       
/*  9637 */       this.linesPerPage = 50;
/*  9638 */       this.orientacion = 0;
/*  9639 */       this.X = 0.0D;
/*  9640 */       this.Y = 0.0D;
/*  9641 */       this.YINICIA = 35;
/*  9642 */       this.PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/*  9643 */       this.NumLineas = 0;
/*  9644 */       this.numBreaks = 0;
/*       */     }
/*       */ 
/*       */     
/*       */     private void initTextLines() {
/*  9649 */       if (this.textLines == null) {
/*       */ 
/*       */         
/*  9652 */         int numLines = ModificarGuias.this.rSTableMetro1.getRowCount();
/*       */         
/*  9654 */         this.textLines = new String[numLines];
/*       */       } 
/*       */     }
/*       */     
/*       */     public void pintar(int x, int y) {
/*  9659 */       this.g2.setColor(Color.WHITE);
/*  9660 */       this.g2.fillRect(x, y - 10, 50, 12);
/*  9661 */       this.g2.setColor(Color.BLACK);
/*       */     }
/*       */     
/*       */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/*  9665 */       Font font = new Font("Serif", 0, 8);
/*  9666 */       FontMetrics metrics = g.getFontMetrics(font);
/*  9667 */       int lineHeight = metrics.getHeight();
/*  9668 */       if (this.pageBreaks == null) {
/*  9669 */         initTextLines();
/*  9670 */         this.orientacion = pf.getOrientation();
/*  9671 */         if (pf.getOrientation() == 1) {
/*  9672 */           this.linesPerPage = 52;
/*  9673 */           this.X = pf.getWidth();
/*  9674 */           this.Y = pf.getHeight();
/*       */         } else {
/*  9676 */           this.linesPerPage = 38;
/*  9677 */           this.X = pf.getWidth();
/*  9678 */           this.Y = pf.getHeight();
/*       */         } 
/*  9680 */         this.numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/*  9681 */         this.Pag = this.numBreaks;
/*  9682 */         this.pageBreaks = new int[this.numBreaks];
/*  9683 */         for (int b = 0; b < this.numBreaks; b++) {
/*  9684 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*       */         }
/*       */       } 
/*  9687 */       if (pageIndex > this.pageBreaks.length) {
/*  9688 */         return 1;
/*       */       }
/*  9690 */       Graphics2D g2d = (Graphics2D)g;
/*  9691 */       this.g2 = g;
/*  9692 */       g2d.translate(pf.getImageableX(), 10.0D);
/*  9693 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/*  9694 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/*  9695 */       encabezado();
/*  9696 */       int y = this.YINICIA;
/*  9697 */       int lineas = 0;
/*       */       
/*  9699 */       this.g2.drawRect(25, 80, 550, 12);
/*  9700 */       this.g2.setColor(new Color(204, 0, 0));
/*  9701 */       this.g2.fillRect(25, 81, 550, 10);
/*       */       
/*  9703 */       Font fuente = new Font("Dialog", 0, 7);
/*  9704 */       this.g2.setFont(fuente);
/*  9705 */       this.g2.setColor(Color.WHITE);
/*  9706 */       int[] valores = { 29, 65, 105, 170, 240, 325, 430, 520, 550 };
/*  9707 */       this.g2.drawString("FOLIO", valores[0], 89);
/*  9708 */       this.g2.drawString("FECHA", valores[1], 89);
/*  9709 */       this.g2.drawString("SERVICIO", valores[2], 89);
/*  9710 */       this.g2.drawString("RESIDUO", valores[3], 89);
/*  9711 */       this.g2.drawString("CLIENTE", valores[4], 89);
/*  9712 */       this.g2.drawString("ORIGEN", valores[5], 89);
/*  9713 */       this.g2.drawString("DESTINO", valores[6], 89);
/*  9714 */       this.g2.drawString("T 1", valores[7], 89);
/*  9715 */       this.g2.drawString("T 2", valores[8], 89);
/*       */       
/*  9717 */       this.g2.setColor(Color.BLACK);
/*  9718 */       y = 90;
/*  9719 */       for (int line = start; line < end; line++) {
/*  9720 */         y += 12;
/*       */         
/*  9722 */         String valor = "";
/*  9723 */         if (line < 9) {
/*  9724 */           valor = "0" + line + 1;
/*       */         } else {
/*  9726 */           valor = "" + line + 1;
/*       */         } 
/*  9728 */         fuente = new Font("Dialog", 1, 7);
/*  9729 */         this.g2.setFont(fuente);
/*  9730 */         this.g2.drawString(valor, ModificarGuias.this.alinearDer(20, valor.length()), y - 2);
/*       */         
/*  9732 */         fuente = new Font("Dialog", 0, 6);
/*  9733 */         this.g2.setFont(fuente);
/*       */         
/*  9735 */         this.g2.drawString(String.valueOf(ModificarGuias.this.rSTableMetro1.getValueAt(line, 0)), valores[0], y - 2);
/*  9736 */         String fecha = String.valueOf(ModificarGuias.this.rSTableMetro1.getValueAt(line, 1));
/*  9737 */         String col = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/*  9738 */         this.g2.drawString(col, valores[1], y - 2);
/*       */         
/*  9740 */         this.g2.drawString(String.valueOf(ModificarGuias.this.rSTableMetro1.getValueAt(line, 2)), valores[2], y - 2);
/*  9741 */         pintar(valores[2] + 50, y + 2);
/*  9742 */         this.g2.drawString(String.valueOf(ModificarGuias.this.rSTableMetro1.getValueAt(line, 3)), valores[3], y - 2);
/*  9743 */         pintar(valores[3] + 60, y + 2);
/*  9744 */         this.g2.drawString(String.valueOf(ModificarGuias.this.rSTableMetro1.getValueAt(line, 4)), valores[4], y - 2);
/*  9745 */         pintar(valores[4] + 70, y + 2);
/*  9746 */         this.g2.drawString(String.valueOf(ModificarGuias.this.rSTableMetro1.getValueAt(line, 5)), valores[5], y - 2);
/*  9747 */         pintar(valores[5] + 80, y + 2);
/*  9748 */         this.g2.drawString(String.valueOf(ModificarGuias.this.rSTableMetro1.getValueAt(line, 6)), valores[6], y - 2);
/*  9749 */         pintar(valores[6] + 75, y + 2);
/*  9750 */         this.g2.drawString(String.valueOf(ModificarGuias.this.rSTableMetro1.getValueAt(line, 7)), valores[7], y - 2);
/*  9751 */         this.g2.drawString(String.valueOf(ModificarGuias.this.rSTableMetro1.getValueAt(line, 9)), valores[8], y - 2);
/*       */       } 
/*       */       
/*  9754 */       g.drawString("Página " + pageIndex + 1, 540, 749);
/*  9755 */       if (this.Pag == pageIndex) {
/*       */         
/*  9757 */         fuente = new Font("Dialog", 1, 7);
/*  9758 */         this.g2.setFont(fuente);
/*  9759 */         this.g2.drawString("ELABORÓ", 190, 720);
/*  9760 */         this.g2.drawString("_____________________________________", 140, 752);
/*  9761 */         this.g2.drawString("NOMBRE Y FIRMA", 178, 765);
/*       */         
/*  9763 */         this.g2.drawString("RECIBE", 390, 720);
/*  9764 */         this.g2.drawString("_____________________________________", 340, 752);
/*  9765 */         this.g2.drawString("NOMBRE Y FIRMA", 378, 765);
/*       */       } 
/*  9767 */       return 0;
/*       */     }
/*       */     
/*       */     public void encabezado() {
/*  9771 */       Font fuente = new Font("Dialog", 0, 8);
/*  9772 */       this.g2.setFont(fuente);
/*  9773 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/*  9774 */       Image img = imagen.getImage();
/*  9775 */       this.g2.drawImage(img, 16, 15, 62, 62, null);
/*  9776 */       fuente = new Font("Times New Roman", 1, 19);
/*  9777 */       this.g2.setFont(fuente);
/*  9778 */       this.g2.drawString("GRUPO FORSIS - " + ModificarGuias.this.SUCURSAL, 180, 20);
/*  9779 */       this.g2.drawRect(80, 30, 483, 17);
/*  9780 */       this.g2.drawRect(80, 47, 483, 17);
/*  9781 */       fuente = new Font("Dialog", 0, 10);
/*  9782 */       this.g2.setFont(fuente);
/*  9783 */       this.g2.drawString("CLIENTE", 90, 42);
/*  9784 */       this.g2.drawString("REPORTE TURNO", 90, 59);
/*  9785 */       this.g2.drawString("FECHA", 362, 59);
/*       */       
/*  9787 */       this.g2.drawLine(138, 31, 138, 47);
/*  9788 */       this.g2.drawLine(185, 48, 185, 64);
/*  9789 */       this.g2.drawLine(355, 48, 355, 64);
/*  9790 */       this.g2.drawLine(400, 48, 400, 64);
/*       */       
/*  9792 */       fuente = new Font("Dialog", 1, 11);
/*  9793 */       this.g2.setFont(fuente);
/*  9794 */       this.g2.drawString(String.valueOf(ModificarGuias.this.jComboBox3.getSelectedItem()), 145, 42);
/*  9795 */       String horario = "";
/*  9796 */       if (ModificarGuias.this.jComboBox21.getSelectedIndex() == 0) {
/*  9797 */         horario = "NATURAL (24 HRS.)";
/*       */       }
/*  9799 */       if (ModificarGuias.this.jComboBox21.getSelectedIndex() == 1) {
/*  9800 */         horario = "DIURNO (9am - 9pm)";
/*       */       }
/*  9802 */       if (ModificarGuias.this.jComboBox21.getSelectedIndex() == 2) {
/*  9803 */         horario = "NOCTURNO (9pm - 9am)";
/*       */       }
/*  9805 */       this.g2.drawString(horario, 190, 59);
/*       */       
/*  9807 */       Date fecha1 = ModificarGuias.this.jDateChooser4.getDate();
/*  9808 */       Date fecha2 = ModificarGuias.this.jDateChooser5.getDate();
/*       */       
/*  9810 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  9811 */       String cadenaFecha = "";
/*  9812 */       cadenaFecha = formato.format(fecha1);
/*  9813 */       String AÑO = cadenaFecha.substring(0, 4);
/*  9814 */       String MES = cadenaFecha.substring(4, 6);
/*  9815 */       String DIA = cadenaFecha.substring(6, 8);
/*  9816 */       String fechaCompleta1 = DIA + "/" + DIA + "/" + MES;
/*       */       
/*  9818 */       cadenaFecha = formato.format(fecha2);
/*  9819 */       AÑO = cadenaFecha.substring(0, 4);
/*  9820 */       MES = cadenaFecha.substring(4, 6);
/*  9821 */       DIA = cadenaFecha.substring(6, 8);
/*  9822 */       String fechaCompleta2 = fechaCompleta1 + "  AL  " + fechaCompleta1 + "/" + DIA + "/" + MES;
/*  9823 */       this.g2.drawString(fechaCompleta2, 405, 59);
/*       */     }
/*       */     
/*       */     public void recibeDatos() {
/*  9827 */       PrinterJob job = PrinterJob.getPrinterJob();
/*  9828 */       job.setPrintable(this);
/*       */       
/*  9830 */       PageFormat pf = job.defaultPage();
/*  9831 */       Paper papel = pf.getPaper();
/*  9832 */       papel.setSize(612.0D, 792.0D);
/*  9833 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/*  9834 */       pf.setPaper(papel);
/*  9835 */       pf.setOrientation(1);
/*  9836 */       job.setPrintable(new ImprimirViajes(), pf);
/*  9837 */       job.defaultPage(pf);
/*       */       
/*  9839 */       boolean ok = job.printDialog();
/*  9840 */       if (ok) {
/*       */         try {
/*  9842 */           job.print();
/*  9843 */         } catch (PrinterException printerException) {}
/*       */       }
/*       */     } }
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */   
/*       */   private class DefaultTableModelImpl
/*       */     extends DefaultTableModel
/*       */   {
/*       */     boolean[] canEdit;
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */ 
/*       */     
/*       */     public DefaultTableModelImpl(Object[][] data, Object[] columnNames)
/*       */     {
/* 10258 */       super(data, columnNames);
/*       */       
/* 10260 */       this.canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false, 
/*       */           false, false, false, false, false, false, false, false, false, false, 
/*       */           false, false, false, false, false, false, false, false, false, false, 
/* 10263 */           false, false, false, false }; } public boolean isCellEditable(int rowIndex, int columnIndex) { return this.canEdit[columnIndex]; }
/*       */   
/*       */   }
/*       */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/ModificarGuias.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */