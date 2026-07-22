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
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.Insets;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.print.PageFormat;
/*      */ import java.awt.print.PrinterJob;
/*      */ import java.io.PrintWriter;
/*      */ import java.text.ParseException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import javax.swing.BorderFactory;
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
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.text.DefaultFormatterFactory;
/*      */ import javax.swing.text.SimpleAttributeSet;
/*      */ 
/*      */ public class Facturas extends JPanel {
/*      */   String USUARIO;
/*      */   JScrollPane panel;
/*   51 */   Date fechaActual = new Date();
/*   52 */   Date fechaInicio = null;
/*   53 */   Date fecha = new Date();
/*   54 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   55 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   56 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   57 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   58 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   59 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*   60 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   61 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   62 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   63 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   64 */   JFrame padre = null;
/*   65 */   JTabbedPane fichas = null;
/*   66 */   String[] CLAVES = null;
/*   67 */   Consultas con = new Consultas();
/*      */   boolean encontrado = false;
/*   69 */   DefaultTableModel modelo = new DefaultTableModel();
/*   70 */   double SUBTOTALD = 0.0D;
/*   71 */   double IVAD = 0.0D;
/*   72 */   double IVA = 0.0D;
/*   73 */   double TONELADASTOTALES = 0.0D;
/*   74 */   double RETENCIOND = 0.0D;
/*   75 */   double RETENCION = 0.0D;
/*   76 */   double TOTALD = 0.0D;
/*   77 */   double[] TONSRES = null;
/*      */   boolean TIENERETENCION = true;
/*   79 */   String[] CONFIGURACIONES = null;
/*   80 */   String[] RESIDUOS = null;
/*   81 */   String[] CAMPOSTABLA = null;
/*   82 */   String[] COLUMNASTABLA = null;
/*   83 */   NumerosALetras numLetra = null;
/*   84 */   CeldaRender celda = new CeldaRender();
/*   85 */   CeldaRender2 celda2 = new CeldaRender2();
/*   86 */   CeldaRender3 celda3 = new CeldaRender3();
/*   87 */   String TARJETA = "";
/*   88 */   String DEPARTAMENTO = "";
/*   89 */   String TONS = "";
/*   90 */   double TOTALPREFACTURA = 0.0D;
/*      */   EscribirReporte esc;
/*      */   boolean TONELADA = false;
/*      */   boolean PRIMERA = false;
/*      */   boolean PRIMERACONCEPTOS = false;
/*   95 */   double RET = 0.0D;
/*      */   boolean REFACTURAR = false;
/*   97 */   String PREFACTURAINTERNA = "";
/*   98 */   String[] RESABREV = null;
/*   99 */   String[] CONTRESI = null;
/*  100 */   int colResi = 0;
/*  101 */   int colTon = 0;
/*  102 */   int[] tamañosCol = null;
/*  103 */   int INDICE = 0;
/*  104 */   String[] COLNOMBRES = null;
/*  105 */   int colExtra = 0;
/*  106 */   int colOtros = 0;
/*  107 */   String CAMPOSCON = "";
/*  108 */   public int[] COLSELEC = null;
/*  109 */   int[] COLIMPRESION = new int[] { 35, 35, 35, 65, 55, 68, 120, 60, 55, 60, 40, 40, 50, 45, 30, 30, 25, 25, 40, 50, 60, 60, 60, 60 };
/*  110 */   String[] IMPRESION = new String[] { "Guia", "Fecha", "Servicio", "Residuo", "Cliente", "Destino", "Operador", "Equipo", "Plataforma", "Pozo", "F Carga", "F Desc", "Pedido", "Tipo", "Ticket", "Peso", "Tra", "Rem", "Rsp", "Manif", "P Unit", "Sub", "Otros $", "Subtotal2", "" };
/*  111 */   String[] CAMPOS = new String[] { "guia", "fecha", "servicio", "residuo", "cliente", "destino", "operador", "equipo", "plataforma", "pozo", "F_Carga", "F_Descarga", "pedido", "tipo", "ticket", "tons", "tractor", "rem", "rsp", "Manifiesto", "preciou", "subTotal", "otrosConcep", "subTotal2" };
/*  112 */   int[] TAMAÑOS = new int[] { 60, 110, 120, 0, 0, 0, 0, 0, 0, 0, 70, 70, 0, 0, 50, 50, 50, 50, 50, 75, 80, 80, 80, 80 };
/*  113 */   String RUTAENTRADA = "";
/*  114 */   String RUTASALIDA = "";
/*  115 */   String ALIAS = "";
/*  116 */   String CLAVETARJETA = "";
/*  117 */   String INICIAL = "";
/*  118 */   String NUMFOLIO = "";
/*  119 */   String CLAVECONCEP = "";
/*  120 */   Presionado presionado = null;
/*  121 */   MensajePop mensajeTry = null;
/*  122 */   int DESC_PORCENTAJE = 0;
/*  123 */   String DESC_MOTIVO = "";
/*  124 */   ArrayList TODAS_CLAVES = new ArrayList();
/*  125 */   TextAutoCompleter com_Claves = null;
/*      */   
/*  127 */   ArrayList TODOS_CONCEPTOS = new ArrayList();
/*  128 */   TextAutoCompleter com_Conceptos = null;
/*      */   
/*  130 */   ArrayList TODOS_UNIDADES = new ArrayList();
/*  131 */   TextAutoCompleter com_Unidades = null; private ButtonGroup buttonGroup1; private ButtonGroup buttonGroup2; private JFormattedTextField cantidad; private JButton jButton1; private JButton jButton10; private JButton jButton11; private JButton jButton12; private JButton jButton13; private JButton jButton14; private JButton jButton15; private JButton jButton16; private JButton jButton17; private JButton jButton18; private JButton jButton19; private JButton jButton2; private JButton jButton20; private JButton jButton21; private JButton jButton22; private JButton jButton23; private JButton jButton24; private JButton jButton25; private JButton jButton26; private JButton jButton27; private JButton jButton28; private JButton jButton29; private JButton jButton3; private JButton jButton30; private JButton jButton31; private JButton jButton32; private JButton jButton33; private JButton jButton34; private JButton jButton35; private JButton jButton36; private JButton jButton37; private JButton jButton38; private JButton jButton39; private JButton jButton4; private JButton jButton40; private JButton jButton41; private JButton jButton42; private JButton jButton43; private JButton jButton44; private JButton jButton45; private JButton jButton46; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JCheckBox jCheckBox1; private JComboBox jComboBox1; private JComboBox jComboBox10; private JComboBox jComboBox11; private JComboBox jComboBox12; private JComboBox jComboBox13; private JComboBox jComboBox14; private JComboBox jComboBox15; private JComboBox jComboBox16; private JComboBox jComboBox17; private JComboBox jComboBox18; private JComboBox jComboBox19; private JComboBox jComboBox2; private JComboBox jComboBox20; private JComboBox jComboBox21; private JComboBox jComboBox22; private JComboBox jComboBox3; private JComboBox jComboBox4; private JComboBox jComboBox5; private JComboBox jComboBox6; private JComboBox jComboBox7; private JComboBox jComboBox8; private JComboBox jComboBox9; private JDateChooser jDateChooser10; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDateChooser jDateChooser6; private JDateChooser jDateChooser7; private JDateChooser jDateChooser8; private JDateChooser jDateChooser9; private JDialog jDialog1; private JDialog jDialog10; private JDialog jDialog11; private JDialog jDialog12; private JDialog jDialog13; private JDialog jDialog14; private JDialog jDialog15; private JDialog jDialog16; private JDialog jDialog3; private JDialog jDialog4; private JDialog jDialog5; private JDialog jDialog6; private JDialog jDialog7; private JDialog jDialog8; private JDialog jDialog9; private JFormattedTextField jFormattedTextField1; private JFormattedTextField jFormattedTextField10; private JFormattedTextField jFormattedTextField2; private JFormattedTextField jFormattedTextField3; private JFormattedTextField jFormattedTextField4; private JFormattedTextField jFormattedTextField5; private JFormattedTextField jFormattedTextField6; private JFormattedTextField jFormattedTextField7; private JFormattedTextField jFormattedTextField8; private JFormattedTextField jFormattedTextField9; private JLabel jLabel1; private JLabel jLabel10; private JLabel jLabel100; private JLabel jLabel102; private JLabel jLabel103; private JLabel jLabel104; private JLabel jLabel105; private JLabel jLabel106; private JLabel jLabel107; private JLabel jLabel108; private JLabel jLabel109; private JLabel jLabel11; private JLabel jLabel110; private JLabel jLabel111; private JLabel jLabel112; private JLabel jLabel113; private JLabel jLabel114; private JLabel jLabel115; private JLabel jLabel116; private JLabel jLabel117; private JLabel jLabel118; private JLabel jLabel119; private JLabel jLabel12; private JLabel jLabel120; private JLabel jLabel121; private JLabel jLabel122; private JLabel jLabel123; private JLabel jLabel124; private JLabel jLabel125; private JLabel jLabel126; private JLabel jLabel127; private JLabel jLabel128; private JLabel jLabel129; private JLabel jLabel13; private JLabel jLabel130; private JLabel jLabel131; private JLabel jLabel132; private JLabel jLabel133; private JLabel jLabel134; private JLabel jLabel135; private JLabel jLabel136; private JLabel jLabel137; private JLabel jLabel138; private JLabel jLabel139; private JLabel jLabel14; private JLabel jLabel140; private JLabel jLabel141; private JLabel jLabel142; private JLabel jLabel143; private JLabel jLabel144; private JLabel jLabel145; private JLabel jLabel146; private JLabel jLabel147; private JLabel jLabel148; private JLabel jLabel149; private JLabel jLabel15; private JLabel jLabel150; private JLabel jLabel151; private JLabel jLabel152; private JLabel jLabel153; private JLabel jLabel154; private JLabel jLabel155; private JLabel jLabel156; private JLabel jLabel157; private JLabel jLabel158; private JLabel jLabel159; private JLabel jLabel16; private JLabel jLabel160; private JLabel jLabel161; private JLabel jLabel162; private JLabel jLabel163; private JLabel jLabel164; private JLabel jLabel165; private JLabel jLabel166; private JLabel jLabel167; private JLabel jLabel168; private JLabel jLabel169; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel28; private JLabel jLabel29; private JLabel jLabel3; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel38; private JLabel jLabel39; private JLabel jLabel4; private JLabel jLabel40; private JLabel jLabel41; private JLabel jLabel42; private JLabel jLabel43; private JLabel jLabel44; private JLabel jLabel45; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel5; private JLabel jLabel50; private JLabel jLabel51; private JLabel jLabel52; private JLabel jLabel53; private JLabel jLabel54; private JLabel jLabel55; private JLabel jLabel56; private JLabel jLabel57; private JLabel jLabel58; private JLabel jLabel59; private JLabel jLabel6; private JLabel jLabel60; private JLabel jLabel61; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel68; private JLabel jLabel69; private JLabel jLabel7; private JLabel jLabel70; private JLabel jLabel71; private JLabel jLabel72; private JLabel jLabel73; private JLabel jLabel74;
/*      */   private JLabel jLabel75;
/*      */   private JLabel jLabel76;
/*      */   private JLabel jLabel77;
/*      */   
/*      */   public Facturas(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry) {
/*  137 */     this.mensajeTry = mensajeTry;
/*  138 */     String año = "2009";
/*  139 */     String mes = "10";
/*      */     
/*  141 */     String dia = "10";
/*  142 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  143 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*  145 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*  146 */     } catch (ParseException ex) {
/*  147 */       ex.printStackTrace();
/*      */     } 
/*  149 */     this.padre = padre;
/*  150 */     fichas = fichas;
/*  151 */     initComponents();
/*      */     
/*  153 */     this.jPanel65.setSize(900, 100);
/*  154 */     this.USUARIO = USUARIO;
/*  155 */     panelito.setViewportView(this);
/*  156 */     this.panel = panelito;
/*  157 */     colorear();
/*      */     
/*  159 */     int w = this.tama.width;
/*  160 */     int h = this.tama.height;
/*  161 */     int rw = (w - 870) / 2;
/*  162 */     int rh = (h - 10) / 2;
/*      */     
/*  164 */     rw = (w - 825) / 2;
/*  165 */     rh = (h - 270) / 2;
/*  166 */     this.jDialog3.setLocation(rw, rh);
/*  167 */     this.jDialog3.setSize(675, 270);
/*  168 */     this.jDialog3.setVisible(false);
/*  169 */     this.jDialog3.setResizable(false);
/*      */     
/*  171 */     rw = (w - 330) / 2;
/*  172 */     rh = (h - 230) / 2;
/*  173 */     this.jDialog4.setLocation(rw, rh);
/*  174 */     this.jDialog4.setSize(370, 230);
/*  175 */     this.jDialog4.setVisible(false);
/*  176 */     this.jDialog4.setResizable(false);
/*      */     
/*  178 */     rw = (w - 400) / 2;
/*  179 */     rh = (h - 400) / 2;
/*  180 */     this.jDialog5.setLocation(rw, rh);
/*  181 */     this.jDialog5.setSize(400, 400);
/*  182 */     this.jDialog5.setVisible(false);
/*  183 */     this.jDialog5.setResizable(false);
/*      */     
/*  185 */     rw = (w - 500) / 2;
/*  186 */     rh = (h - 320) / 2;
/*  187 */     this.jDialog6.setLocation(rw, rh);
/*  188 */     this.jDialog6.setSize(500, 320);
/*  189 */     this.jDialog6.setVisible(false);
/*  190 */     this.jDialog6.setResizable(false);
/*      */     
/*  192 */     rw = (w - 310) / 2;
/*  193 */     rh = (h - 180) / 2;
/*  194 */     this.jDialog7.setLocation(rw, rh);
/*  195 */     this.jDialog7.setSize(310, 180);
/*  196 */     this.jDialog7.setVisible(false);
/*  197 */     this.jDialog7.setResizable(false);
/*      */     
/*  199 */     rw = (w - 390) / 2;
/*  200 */     rh = (h - 230) / 2;
/*  201 */     this.jDialog8.setLocation(rw, rh);
/*  202 */     this.jDialog8.setSize(390, 230);
/*  203 */     this.jDialog8.setVisible(false);
/*  204 */     this.jDialog8.setResizable(false);
/*      */     
/*  206 */     w = this.tama.width;
/*  207 */     h = this.tama.height;
/*  208 */     rw = (w - 1145) / 2;
/*  209 */     rh = (h - 600) / 2;
/*  210 */     this.jDialog9.setSize(w - 160, h - 110);
/*  211 */     this.jDialog9.setLocation(40, 40);
/*  212 */     this.jDialog9.setResizable(false);
/*      */     
/*  214 */     w = this.tama.width;
/*  215 */     h = this.tama.height;
/*  216 */     rw = (w - 800) / 2;
/*  217 */     rh = (h - 450) / 2;
/*  218 */     this.jDialog10.setSize(800, 500);
/*  219 */     this.jDialog10.setLocation(rw, rh);
/*  220 */     this.jDialog10.setResizable(false);
/*      */     
/*  222 */     rw = (w - 940) / 2;
/*  223 */     rh = (h - this.tama.height + 10) / 2;
/*  224 */     this.jDialog11.setSize(940, this.tama.height - 50);
/*  225 */     this.jDialog11.setResizable(false);
/*  226 */     this.jDialog11.setLocation(rw, rh);
/*  227 */     this.jDialog11.setVisible(false);
/*      */     
/*  229 */     rw = (w - 650) / 2;
/*  230 */     rh = (h - 370) / 2;
/*  231 */     this.jDialog12.setLocation(rw, rh);
/*  232 */     this.jDialog12.setSize(650, 370);
/*  233 */     this.jDialog12.setResizable(false);
/*      */     
/*  235 */     rw = (w - 950) / 2;
/*  236 */     rh = (h - 600) / 2;
/*  237 */     this.jDialog13.setLocation(rw, rh);
/*  238 */     this.jDialog13.setSize(950, 600);
/*  239 */     this.jDialog13.setResizable(false);
/*      */     
/*  241 */     rw = (w - 380) / 2;
/*  242 */     rh = (h - 200) / 2;
/*  243 */     this.jDialog14.setLocation(rw, rh);
/*  244 */     this.jDialog14.setSize(380, 200);
/*  245 */     this.jDialog14.setVisible(false);
/*  246 */     this.jDialog14.setResizable(false);
/*      */     
/*  248 */     rw = (w - 617) / 2;
/*  249 */     rh = (h - 340) / 2;
/*  250 */     this.jDialog15.setLocation(rw, rh);
/*  251 */     this.jDialog15.setSize(617, 340);
/*  252 */     this.jDialog15.setVisible(false);
/*  253 */     this.jDialog15.setResizable(false);
/*      */     
/*  255 */     rw = (w - 617) / 2;
/*  256 */     rh = (h - 340) / 2;
/*  257 */     this.jDialog16.setLocation(rw, rh);
/*  258 */     this.jDialog16.setSize(800, 350);
/*  259 */     this.jDialog16.setVisible(false);
/*  260 */     this.jDialog16.setResizable(false);
/*      */     
/*  262 */     rw = (w - 680) / 2;
/*  263 */     rh = (h - 280) / 2;
/*  264 */     this.jDialog1.setLocation(rw, rh);
/*  265 */     this.jDialog1.setSize(680, 280);
/*  266 */     this.jDialog1.setResizable(false);
/*      */     
/*  268 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  269 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  270 */     this.jLabel5.setCursor(micursor);
/*  271 */     this.jLabel6.setCursor(micursor);
/*  272 */     this.jLabel7.setCursor(micursor);
/*  273 */     this.jLabel149.setCursor(micursor);
/*  274 */     this.jLabel158.setCursor(micursor);
/*      */     
/*  276 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  277 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  278 */     this.jDialog1.setCursor(micursor);
/*  279 */     this.jDialog3.setCursor(micursor);
/*  280 */     this.jDialog4.setCursor(micursor);
/*  281 */     this.jDialog5.setCursor(micursor);
/*  282 */     this.jDialog6.setCursor(micursor);
/*  283 */     this.jDialog8.setCursor(micursor);
/*  284 */     this.jDialog9.setCursor(micursor);
/*  285 */     this.jDialog10.setCursor(micursor);
/*  286 */     this.jDialog11.setCursor(micursor);
/*  287 */     this.jDialog12.setCursor(micursor);
/*  288 */     this.jDialog13.setCursor(micursor);
/*  289 */     this.jDialog14.setCursor(micursor);
/*  290 */     this.jDialog15.setCursor(micursor);
/*  291 */     this.jDialog16.setCursor(micursor);
/*      */     
/*  293 */     this.jTable2.setModel(this.modelo);
/*  294 */     this.modelo.addColumn("Folio");
/*  295 */     this.modelo.addColumn("Ref");
/*  296 */     this.modelo.addColumn("Subtotal");
/*  297 */     this.modelo.addColumn("Iva");
/*  298 */     this.modelo.addColumn("Retención");
/*  299 */     this.modelo.addColumn("Total");
/*  300 */     this.jTable2.setSelectionMode(0);
/*  301 */     this.jTable2.setAutoCreateRowSorter(true);
/*  302 */     this.jTable2.getTableHeader().setReorderingAllowed(false);
/*  303 */     this.jTable2.getColumnModel().getColumn(0).setPreferredWidth(50);
/*  304 */     this.jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
/*      */     
/*  306 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance(Locale.US);
/*  307 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  308 */     editFormat.setGroupingUsed(false);
/*  309 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  310 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  311 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  312 */     enFormat.setAllowsInvalid(true);
/*  313 */     this.cantidad.setFormatterFactory(currFactory);
/*  314 */     this.jFormattedTextField1.setFormatterFactory(currFactory);
/*  315 */     this.jFormattedTextField3.setFormatterFactory(currFactory);
/*  316 */     this.jFormattedTextField4.setFormatterFactory(currFactory);
/*  317 */     this.jFormattedTextField5.setFormatterFactory(currFactory);
/*  318 */     this.jFormattedTextField6.setFormatterFactory(currFactory);
/*  319 */     this.jFormattedTextField10.setFormatterFactory(currFactory);
/*  320 */     this.cantidad.setValue(Integer.valueOf(0));
/*  321 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/*  322 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/*  323 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/*  324 */     this.jFormattedTextField4.setValue(Integer.valueOf(0));
/*  325 */     this.jFormattedTextField5.setValue(Integer.valueOf(0));
/*  326 */     this.jFormattedTextField6.setValue(Integer.valueOf(0));
/*  327 */     this.jFormattedTextField10.setValue(Integer.valueOf(0));
/*  328 */     this.jTextField71.setEnabled(false);
/*      */     
/*  330 */     this.CONFIGURACIONES = this.con.regresaReg("iva, retencion, factEntrada, sucursal, directiva", "configuraciones", "", 5);
/*  331 */     this.IVA = Double.parseDouble(this.CONFIGURACIONES[0]);
/*  332 */     this.RETENCION = Double.parseDouble(this.CONFIGURACIONES[1]);
/*  333 */     this.jLabel110.setText("Iva " + this.IVA + "%");
/*  334 */     this.jLabel111.setText("Retención " + this.RETENCION + "%");
/*  335 */     this.RETENCIOND = this.RETENCION;
/*  336 */     llenarCombos();
/*  337 */     consultar();
/*  338 */     sacarDepa();
/*  339 */     sacarPrivilegios();
/*      */     
/*  341 */     this.buttonGroup2.add(this.jRadioButton1);
/*  342 */     this.buttonGroup2.add(this.jRadioButton2);
/*      */     
/*  344 */     this.RUTAENTRADA = this.CONFIGURACIONES[2];
/*  345 */     this.ALIAS = this.CONFIGURACIONES[3];
/*  346 */     this.jTable8.setSelectionMode(0);
/*      */     
/*  348 */     this.jButton40.setVisible(false);
/*  349 */     this.jTable8.getColumnModel().getColumn(0).setCellRenderer(this.celda3);
/*  350 */     this.jTable8.getColumnModel().getColumn(1).setCellRenderer(this.celda3);
/*  351 */     this.jTextField22.setEnabled(false);
/*      */   }
/*      */   private JLabel jLabel78; private JLabel jLabel79; private JLabel jLabel8; private JLabel jLabel80; private JLabel jLabel81; private JLabel jLabel82; private JLabel jLabel83; private JLabel jLabel84; private JLabel jLabel85; private JLabel jLabel86; private JLabel jLabel87; private JLabel jLabel88; private JLabel jLabel89; private JLabel jLabel9; private JLabel jLabel90; private JLabel jLabel91; private JLabel jLabel92; private JLabel jLabel93; private JLabel jLabel94; private JLabel jLabel95; private JLabel jLabel96; private JLabel jLabel97; private JLabel jLabel98; private JLabel jLabel99; private JPanel jPanel1; private JPanel jPanel10; private JPanel jPanel100; private JPanel jPanel101; private JPanel jPanel102; private JPanel jPanel103; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel16; private JPanel jPanel17; private JPanel jPanel18; private JPanel jPanel19; private JPanel jPanel2; private JPanel jPanel20; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel23; private JPanel jPanel24; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel27; private JPanel jPanel28; private JPanel jPanel29; private JPanel jPanel3; private JPanel jPanel30; private JPanel jPanel31; private JPanel jPanel32; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel35; private JPanel jPanel36; private JPanel jPanel37; private JPanel jPanel38; private JPanel jPanel39; private JPanel jPanel4; private JPanel jPanel40; private JPanel jPanel41; private JPanel jPanel42; private JPanel jPanel43; private JPanel jPanel44; private JPanel jPanel45; private JPanel jPanel46; private JPanel jPanel47; private JPanel jPanel48; private JPanel jPanel49; private JPanel jPanel5; private JPanel jPanel50; private JPanel jPanel51; private JPanel jPanel52; private JPanel jPanel53; private JPanel jPanel54; private JPanel jPanel55; private JPanel jPanel56; private JPanel jPanel57; private JPanel jPanel58; private JPanel jPanel59; private JPanel jPanel6; private JPanel jPanel60; private JPanel jPanel61; private JPanel jPanel62; private JPanel jPanel63; private JPanel jPanel64; private JPanel jPanel65; private JPanel jPanel66; private JPanel jPanel67; private JPanel jPanel68; private JPanel jPanel69; private JPanel jPanel7; private JPanel jPanel70; private JPanel jPanel71; private JPanel jPanel72; private JPanel jPanel73; private JPanel jPanel74; private JPanel jPanel75; private JPanel jPanel76; private JPanel jPanel77; private JPanel jPanel78; private JPanel jPanel79; private JPanel jPanel8; private JPanel jPanel80; private JPanel jPanel81; private JPanel jPanel82; private JPanel jPanel83; private JPanel jPanel84; private JPanel jPanel85; private JPanel jPanel86; private JPanel jPanel87; private JPanel jPanel88; private JPanel jPanel89; private JPanel jPanel9; private JPanel jPanel90; private JPanel jPanel91; private JPanel jPanel92; private JPanel jPanel93; private JPanel jPanel94; private JPanel jPanel95;
/*      */   private JPanel jPanel96;
/*      */   
/*      */   private void initComponents() {
/*  357 */     this.buttonGroup1 = new ButtonGroup();
/*  358 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  359 */     this.jPanel32 = new JPanel();
/*  360 */     this.jLabel121 = new JLabel();
/*  361 */     this.jSeparator26 = new JSeparator();
/*  362 */     this.jSeparator28 = new JSeparator();
/*  363 */     this.jButton35 = new JButton();
/*  364 */     this.jButton36 = new JButton();
/*  365 */     this.jPanel27 = new JPanel();
/*  366 */     this.jLabel132 = new JLabel();
/*  367 */     this.jTextField31 = new JTextField();
/*  368 */     this.jLabel134 = new JLabel();
/*  369 */     this.jFormattedTextField8 = new JFormattedTextField();
/*  370 */     this.jFormattedTextField9 = new JFormattedTextField();
/*  371 */     this.jLabel135 = new JLabel();
/*  372 */     this.jTextField33 = new JTextField();
/*  373 */     this.jLabel136 = new JLabel();
/*  374 */     this.jLabel127 = new JLabel();
/*  375 */     this.jFormattedTextField6 = new JFormattedTextField();
/*  376 */     this.jPanel33 = new JPanel();
/*  377 */     this.jLabel133 = new JLabel();
/*  378 */     this.jTextField32 = new JTextField();
/*  379 */     this.jLabel137 = new JLabel();
/*  380 */     this.jLabel138 = new JLabel();
/*  381 */     this.jTextField34 = new JTextField();
/*  382 */     this.jLabel139 = new JLabel();
/*  383 */     this.jLabel129 = new JLabel();
/*  384 */     this.jTextField35 = new JTextField();
/*  385 */     this.jTextField36 = new JTextField();
/*  386 */     this.jDateChooser7 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  387 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  388 */     this.jPanel26 = new JPanel();
/*  389 */     this.jLabel94 = new JLabel();
/*  390 */     this.jTextField39 = new JTextField();
/*  391 */     this.jLabel95 = new JLabel();
/*  392 */     this.jTextField40 = new JTextField();
/*  393 */     this.jLabel96 = new JLabel();
/*  394 */     this.jTextField41 = new JTextField();
/*  395 */     this.jLabel97 = new JLabel();
/*  396 */     this.jTextField42 = new JTextField();
/*  397 */     this.jButton39 = new JButton();
/*  398 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  399 */     this.jPanel3 = new JPanel();
/*  400 */     this.jLabel122 = new JLabel();
/*  401 */     this.jSeparator27 = new JSeparator();
/*  402 */     this.jLabel9 = new JLabel();
/*  403 */     this.jTextField6 = new JTextField();
/*  404 */     this.jLabel10 = new JLabel();
/*  405 */     this.jTextField7 = new JTextField();
/*  406 */     this.jScrollPane1 = new JScrollPane();
/*  407 */     this.jTable1 = new JTable();
/*  408 */     this.jButton3 = new JButton();
/*  409 */     this.jButton4 = new JButton();
/*  410 */     this.jScrollPane2 = new JScrollPane();
/*  411 */     this.jTable2 = new JTable();
/*  412 */     this.jButton5 = new JButton();
/*  413 */     this.jButton6 = new JButton();
/*  414 */     this.cantidad = new JFormattedTextField();
/*  415 */     this.jDialog6 = new CerrarVentana(this.padre);
/*  416 */     this.jPanel4 = new JPanel();
/*  417 */     this.jLabel123 = new JLabel();
/*  418 */     this.jSeparator1 = new JSeparator();
/*  419 */     this.jLabel11 = new JLabel();
/*  420 */     this.jScrollPane4 = new JScrollPane();
/*  421 */     this.jTable4 = new JTable();
/*  422 */     this.jButton7 = new JButton();
/*  423 */     this.jButton8 = new JButton();
/*  424 */     this.jPanel6 = new JPanel();
/*  425 */     this.jLabel12 = new JLabel();
/*  426 */     this.jLabel13 = new JLabel();
/*  427 */     this.jLabel14 = new JLabel();
/*  428 */     this.jLabel17 = new JLabel();
/*  429 */     this.jLabel18 = new JLabel();
/*  430 */     this.jSeparator2 = new JSeparator();
/*  431 */     this.jDialog7 = new CerrarVentana(this.padre);
/*  432 */     this.jPanel11 = new JPanel();
/*  433 */     this.jLabel36 = new JLabel();
/*  434 */     this.jSeparator10 = new JSeparator();
/*  435 */     this.jLabel40 = new JLabel();
/*  436 */     this.jTextField5 = new JTextField();
/*  437 */     this.jSeparator11 = new JSeparator();
/*  438 */     this.jButton16 = new JButton();
/*  439 */     this.jButton17 = new JButton();
/*  440 */     this.jDialog8 = new CerrarVentana(this.padre);
/*  441 */     this.jPanel29 = new JPanel();
/*  442 */     this.jLabel124 = new JLabel();
/*  443 */     this.jSeparator29 = new JSeparator();
/*  444 */     this.jLabel125 = new JLabel();
/*  445 */     this.jButton44 = new JButton();
/*  446 */     this.jButton45 = new JButton();
/*  447 */     this.jScrollPane18 = new JScrollPane();
/*  448 */     this.jTextArea5 = new JTextArea();
/*  449 */     this.jLabel126 = new JLabel();
/*  450 */     this.jDialog9 = new CerrarVentana(this.padre);
/*  451 */     this.jPanel7 = new JPanel();
/*  452 */     this.jPanel38 = new JPanel();
/*  453 */     this.jLabel19 = new JLabel();
/*  454 */     this.jSeparator5 = new JSeparator();
/*  455 */     this.jLabel20 = new JLabel();
/*  456 */     this.jLabel21 = new JLabel();
/*  457 */     this.jTextField11 = new JTextField();
/*  458 */     this.jLabel22 = new JLabel();
/*  459 */     this.jTextField12 = new JTextField();
/*  460 */     this.jLabel23 = new JLabel();
/*  461 */     this.jTextField4 = new JTextField();
/*  462 */     this.jPanel35 = new JPanel();
/*  463 */     this.jLabel24 = new JLabel();
/*  464 */     this.jDateChooser8 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  465 */     this.jLabel25 = new JLabel();
/*  466 */     this.jTextField3 = new JTextField();
/*  467 */     this.jLabel57 = new JLabel();
/*  468 */     this.jTextField8 = new JTextField();
/*  469 */     this.jScrollPane5 = new JScrollPane();
/*  470 */     this.jTable5 = new JTable();
/*  471 */     this.jPanel40 = new JPanel();
/*  472 */     this.jPanel39 = new JPanel();
/*  473 */     this.jLabel63 = new JLabel();
/*  474 */     this.jPanel8 = new JPanel();
/*  475 */     this.jLabel26 = new JLabel();
/*  476 */     this.jLabel27 = new JLabel();
/*  477 */     this.jLabel28 = new JLabel();
/*  478 */     this.jLabel29 = new JLabel();
/*  479 */     this.jLabel30 = new JLabel();
/*  480 */     this.jLabel31 = new JLabel();
/*  481 */     this.jSeparator6 = new JSeparator();
/*  482 */     this.jLabel32 = new JLabel();
/*  483 */     this.jLabel33 = new JLabel();
/*  484 */     this.jScrollPane6 = new JScrollPane();
/*  485 */     this.jTextArea1 = new JTextArea();
/*  486 */     this.jPanel9 = new JPanel();
/*  487 */     this.jScrollPane7 = new JScrollPane();
/*  488 */     this.jTextPane1 = new JTextPane();
/*  489 */     this.jPanel41 = new JPanel();
/*  490 */     this.jScrollPane14 = new JScrollPane();
/*  491 */     this.jTable12 = new JTable();
/*  492 */     this.jLabel91 = new JLabel();
/*  493 */     this.jDialog10 = new CerrarVentana(this.padre);
/*  494 */     this.jPanel48 = new JPanel();
/*  495 */     this.jPanel49 = new JPanel();
/*  496 */     this.jPanel50 = new JPanel();
/*  497 */     this.jLabel50 = new JLabel();
/*  498 */     this.jComboBox18 = new JComboBox();
/*  499 */     this.jPanel51 = new JPanel();
/*  500 */     this.jPanel58 = new JPanel();
/*  501 */     this.jLabel56 = new JLabel();
/*  502 */     this.jTextField9 = new JTextField();
/*  503 */     this.jLabel53 = new JLabel();
/*  504 */     this.jTextField46 = new JTextField();
/*  505 */     this.jPanel95 = new JPanel();
/*  506 */     this.jLabel49 = new JLabel();
/*  507 */     this.jTextField29 = new JTextField();
/*  508 */     this.jPanel52 = new JPanel();
/*  509 */     this.jLabel55 = new JLabel();
/*  510 */     this.jFormattedTextField5 = new JFormattedTextField();
/*  511 */     this.jButton12 = new JButton();
/*  512 */     this.jPanel97 = new JPanel();
/*  513 */     this.jScrollPane8 = new JScrollPane();
/*  514 */     this.jTable6 = new JTable();
/*  515 */     this.jLabel128 = new JLabel();
/*  516 */     this.jTextField54 = new JTextField();
/*  517 */     this.jButton14 = new JButton();
/*  518 */     this.jButton20 = new JButton();
/*  519 */     this.jButton13 = new JButton();
/*  520 */     this.jLabel153 = new JLabel();
/*  521 */     this.jTextField55 = new JTextField();
/*  522 */     this.jButton11 = new JButton();
/*  523 */     this.jDialog11 = new CerrarVentana(this.padre);
/*  524 */     this.jScrollPane13 = new JScrollPane();
/*  525 */     this.jPanel90 = new JPanel();
/*  526 */     this.jPanel59 = new JPanel();
/*  527 */     this.jLabel78 = new JLabel();
/*  528 */     this.jTextField18 = new JTextField();
/*  529 */     this.jLabel85 = new JLabel();
/*  530 */     this.jDateChooser6 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  531 */     this.jLabel88 = new JLabel();
/*  532 */     this.jTextField19 = new JTextField();
/*  533 */     this.jPanel56 = new JPanel();
/*  534 */     this.jPanel57 = new JPanel();
/*  535 */     this.jComboBox1 = new JComboBox();
/*  536 */     this.jLabel93 = new JLabel();
/*  537 */     this.jTextField17 = new JTextField();
/*  538 */     this.jLabel16 = new JLabel();
/*  539 */     this.jPanel60 = new JPanel();
/*  540 */     this.jLabel71 = new JLabel();
/*  541 */     this.jTextField10 = new JTextField();
/*  542 */     this.jLabel89 = new JLabel();
/*  543 */     this.jTextField13 = new JTextField();
/*  544 */     this.jLabel90 = new JLabel();
/*  545 */     this.jTextField14 = new JTextField();
/*  546 */     this.jLabel74 = new JLabel();
/*  547 */     this.jTextField16 = new JTextField();
/*  548 */     this.jLabel73 = new JLabel();
/*  549 */     this.jTextField15 = new JTextField();
/*  550 */     this.jLabel92 = new JLabel();
/*  551 */     this.jComboBox9 = new JComboBox();
/*  552 */     this.jLabel76 = new JLabel();
/*  553 */     this.jTextField20 = new JTextField();
/*  554 */     this.jPanel63 = new JPanel();
/*  555 */     this.jPanel62 = new JPanel();
/*  556 */     this.jPanel61 = new JPanel();
/*  557 */     this.jLabel72 = new JLabel();
/*  558 */     this.jComboBox20 = new JComboBox();
/*  559 */     this.jLabel98 = new JLabel();
/*  560 */     this.jTextField22 = new JTextField();
/*  561 */     this.jLabel99 = new JLabel();
/*  562 */     this.jComboBox13 = new JComboBox();
/*  563 */     this.jLabel75 = new JLabel();
/*  564 */     this.jComboBox14 = new JComboBox();
/*  565 */     this.jLabel80 = new JLabel();
/*  566 */     this.jPanel55 = new JPanel();
/*  567 */     this.jRadioButton1 = new JRadioButton();
/*  568 */     this.jRadioButton2 = new JRadioButton();
/*  569 */     this.jLabel100 = new JLabel();
/*  570 */     this.jSpinner1 = new JSpinner();
/*  571 */     this.jLabel77 = new JLabel();
/*  572 */     this.jComboBox17 = new JComboBox();
/*  573 */     this.jLabel81 = new JLabel();
/*  574 */     this.jComboBox19 = new JComboBox();
/*  575 */     this.jLabel102 = new JLabel();
/*  576 */     this.jComboBox15 = new JComboBox();
/*  577 */     this.jPanel87 = new JPanel();
/*  578 */     this.jPanel89 = new JPanel();
/*  579 */     this.jLabel143 = new JLabel();
/*  580 */     this.jTextField24 = new JTextField();
/*  581 */     this.jLabel144 = new JLabel();
/*  582 */     this.jTextField26 = new JTextField();
/*  583 */     this.jPanel65 = new JPanel();
/*  584 */     this.jLabel169 = new JLabel();
/*  585 */     this.jPanel103 = new JPanel();
/*  586 */     this.jTextField71 = new JTextField();
/*  587 */     this.jButton34 = new JButton();
/*  588 */     this.jLabel105 = new JLabel();
/*  589 */     this.jComboBox4 = new JComboBox();
/*  590 */     this.jLabel140 = new JLabel();
/*  591 */     this.jComboBox12 = new JComboBox();
/*  592 */     this.jPanel67 = new JPanel();
/*  593 */     this.jPanel12 = new JPanel();
/*  594 */     this.jLabel103 = new JLabel();
/*  595 */     this.jTextField23 = new JTextField();
/*  596 */     this.jButton18 = new JButton();
/*  597 */     this.jPanel15 = new JPanel();
/*  598 */     this.jLabel104 = new JLabel();
/*  599 */     this.jTextField37 = new JTextField();
/*  600 */     this.jLabel141 = new JLabel();
/*  601 */     this.jTextField38 = new JTextField();
/*  602 */     this.jLabel146 = new JLabel();
/*  603 */     this.jTextField44 = new JTextField();
/*  604 */     this.jLabel106 = new JLabel();
/*  605 */     this.jTextField45 = new JTextField();
/*  606 */     this.jLabel142 = new JLabel();
/*  607 */     this.jTextField43 = new JTextField();
/*  608 */     this.jPanel16 = new JPanel();
/*  609 */     this.jPanel19 = new JPanel();
/*  610 */     this.jPanel20 = new JPanel();
/*  611 */     this.jPanel42 = new JPanel();
/*  612 */     this.jLabel131 = new JLabel();
/*  613 */     this.jPanel44 = new JPanel();
/*  614 */     this.jPanel45 = new JPanel();
/*  615 */     this.jLabel130 = new JLabel();
/*  616 */     this.jLabel117 = new JLabel();
/*  617 */     this.jLabel145 = new JLabel();
/*  618 */     this.jPanel30 = new JPanel();
/*  619 */     this.jLabel118 = new JLabel();
/*  620 */     this.jPanel43 = new JPanel();
/*  621 */     this.jLabel119 = new JLabel();
/*  622 */     this.jLabel120 = new JLabel();
/*  623 */     this.jPanel37 = new JPanel();
/*  624 */     this.jPanel46 = new JPanel();
/*  625 */     this.jTextField30 = new JTextField();
/*  626 */     this.jFormattedTextField2 = new JFormattedTextField();
/*  627 */     this.jComboBox16 = new JComboBox();
/*  628 */     this.jPanel47 = new JPanel();
/*  629 */     this.jTextField27 = new JTextField();
/*  630 */     this.jPanel77 = new JPanel();
/*  631 */     this.jFormattedTextField3 = new JFormattedTextField();
/*  632 */     this.jFormattedTextField4 = new JFormattedTextField();
/*  633 */     this.jPanel78 = new JPanel();
/*  634 */     this.jScrollPane12 = new JScrollPane();
/*  635 */     this.jTable10 = new JTable();
/*  636 */     this.jPanel79 = new JPanel();
/*  637 */     this.jPanel80 = new JPanel();
/*  638 */     this.jPanel81 = new JPanel();
/*  639 */     this.jLabel109 = new JLabel();
/*  640 */     this.jLabel107 = new JLabel();
/*  641 */     this.jPanel82 = new JPanel();
/*  642 */     this.jLabel110 = new JLabel();
/*  643 */     this.jLabel108 = new JLabel();
/*  644 */     this.jPanel83 = new JPanel();
/*  645 */     this.jLabel111 = new JLabel();
/*  646 */     this.jFormattedTextField1 = new JFormattedTextField();
/*  647 */     this.jPanel84 = new JPanel();
/*  648 */     this.jLabel149 = new JLabel();
/*  649 */     this.jFormattedTextField10 = new JFormattedTextField();
/*  650 */     this.jPanel85 = new JPanel();
/*  651 */     this.jSeparator23 = new JSeparator();
/*  652 */     this.jPanel86 = new JPanel();
/*  653 */     this.jLabel113 = new JLabel();
/*  654 */     this.jLabel114 = new JLabel();
/*  655 */     this.jPanel64 = new JPanel();
/*  656 */     this.jPanel13 = new JPanel();
/*  657 */     this.jPanel18 = new JPanel();
/*  658 */     this.jButton41 = new JButton();
/*  659 */     this.jButton31 = new JButton();
/*  660 */     this.jPanel66 = new JPanel();
/*  661 */     this.jPanel68 = new JPanel();
/*  662 */     this.jPanel69 = new JPanel();
/*  663 */     this.jPanel70 = new JPanel();
/*  664 */     this.jLabel87 = new JLabel();
/*  665 */     this.jPanel71 = new JPanel();
/*  666 */     this.jTextField25 = new JTextField();
/*  667 */     this.jPanel72 = new JPanel();
/*  668 */     this.jPanel74 = new JPanel();
/*  669 */     this.jCheckBox1 = new JCheckBox();
/*  670 */     this.jComboBox10 = new JComboBox();
/*  671 */     this.jPanel75 = new JPanel();
/*  672 */     this.jPanel73 = new JPanel();
/*  673 */     this.jTextField28 = new JTextField();
/*  674 */     this.jPanel76 = new JPanel();
/*  675 */     this.jPanel88 = new JPanel();
/*  676 */     this.jButton9 = new JButton();
/*  677 */     this.jPanel91 = new JPanel();
/*  678 */     this.jPanel93 = new JPanel();
/*  679 */     this.jPanel94 = new JPanel();
/*  680 */     this.jPanel92 = new JPanel();
/*  681 */     this.jButton40 = new JButton();
/*  682 */     this.jButton38 = new JButton();
/*  683 */     this.jButton32 = new JButton();
/*  684 */     this.jButton37 = new JButton();
/*  685 */     this.jPanel99 = new JPanel();
/*  686 */     this.jPanel100 = new JPanel();
/*  687 */     this.jLabel167 = new JLabel();
/*  688 */     this.jPanel101 = new JPanel();
/*  689 */     this.jLabel168 = new JLabel();
/*  690 */     this.jDialog12 = new CerrarVentana(this.padre);
/*  691 */     this.jPanel34 = new JPanel();
/*  692 */     this.jButton21 = new JButton();
/*  693 */     this.jButton19 = new JButton();
/*  694 */     this.jPanel10 = new JPanel();
/*  695 */     this.jLabel147 = new JLabel();
/*  696 */     this.jLabel59 = new JLabel();
/*  697 */     this.jTextField47 = new JTextField();
/*  698 */     this.jLabel60 = new JLabel();
/*  699 */     this.jDateChooser9 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  700 */     this.jLabel61 = new JLabel();
/*  701 */     this.jTextField48 = new JTextField();
/*  702 */     this.jLabel62 = new JLabel();
/*  703 */     this.jTextField49 = new JTextField();
/*  704 */     this.jLabel64 = new JLabel();
/*  705 */     this.jTextField50 = new JTextField();
/*  706 */     this.jLabel65 = new JLabel();
/*  707 */     this.jScrollPane10 = new JScrollPane();
/*  708 */     this.jTextArea2 = new JTextArea();
/*  709 */     this.jLabel66 = new JLabel();
/*  710 */     this.jTextField51 = new JTextField();
/*  711 */     this.jSeparator35 = new JSeparator();
/*  712 */     this.jLabel67 = new JLabel();
/*  713 */     this.jDateChooser10 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  714 */     this.buttonGroup2 = new ButtonGroup();
/*  715 */     this.jDialog13 = new CerrarVentana(this.padre);
/*  716 */     this.jPanel53 = new JPanel();
/*  717 */     this.jLabel148 = new JLabel();
/*  718 */     this.jSeparator36 = new JSeparator();
/*  719 */     this.jLabel68 = new JLabel();
/*  720 */     this.jTextField52 = new JTextField();
/*  721 */     this.jScrollPane11 = new JScrollPane();
/*  722 */     this.jTable7 = new JTable();
/*  723 */     this.jLabel70 = new JLabel();
/*  724 */     this.jLabel79 = new JLabel();
/*  725 */     this.jLabel112 = new JLabel();
/*  726 */     this.jSeparator3 = new JSeparator();
/*  727 */     this.jButton22 = new JButton();
/*  728 */     this.jButton29 = new JButton();
/*  729 */     this.jButton30 = new JButton();
/*  730 */     this.jLabel69 = new JLabel();
/*  731 */     this.jFormattedTextField7 = new JFormattedTextField();
/*  732 */     this.jDialog14 = new CerrarVentana(this.padre);
/*  733 */     this.jPanel54 = new JPanel();
/*  734 */     this.jLabel150 = new JLabel();
/*  735 */     this.jSeparator37 = new JSeparator();
/*  736 */     this.jSeparator38 = new JSeparator();
/*  737 */     this.jButton42 = new JButton();
/*  738 */     this.jButton43 = new JButton();
/*  739 */     this.jLabel151 = new JLabel();
/*  740 */     this.jSlider1 = new JSlider();
/*  741 */     this.jLabel152 = new JLabel();
/*  742 */     this.jTextField53 = new JTextField();
/*  743 */     this.jDialog15 = new CerrarVentana(this.padre);
/*  744 */     this.jPanel14 = new JPanel();
/*  745 */     this.jLabel157 = new JLabel();
/*  746 */     this.jLabel158 = new JLabel();
/*  747 */     this.jLabel159 = new JLabel();
/*  748 */     this.jScrollPane9 = new JScrollPane();
/*  749 */     this.jTextPane2 = new JTextPane();
/*  750 */     this.jLabel162 = new JLabel();
/*  751 */     this.jDialog16 = new CerrarVentana(this.padre);
/*  752 */     this.jPanel21 = new JPanel();
/*  753 */     this.jLabel2 = new JLabel();
/*  754 */     this.jPanel22 = new JPanel();
/*  755 */     this.jButton27 = new JButton();
/*  756 */     this.jButton33 = new JButton();
/*  757 */     this.jPanel23 = new JPanel();
/*  758 */     this.jPanel24 = new JPanel();
/*  759 */     this.jTextField21 = new JTextField();
/*  760 */     this.jTextField56 = new JTextField();
/*  761 */     this.jTextField57 = new JTextField();
/*  762 */     this.jTextField58 = new JTextField();
/*  763 */     this.jTextField59 = new JTextField();
/*  764 */     this.jTextField60 = new JTextField();
/*  765 */     this.jTextField61 = new JTextField();
/*  766 */     this.jTextField62 = new JTextField();
/*  767 */     this.jPanel31 = new JPanel();
/*  768 */     this.jTextField63 = new JTextField();
/*  769 */     this.jTextField64 = new JTextField();
/*  770 */     this.jTextField65 = new JTextField();
/*  771 */     this.jTextField66 = new JTextField();
/*  772 */     this.jTextField67 = new JTextField();
/*  773 */     this.jTextField68 = new JTextField();
/*  774 */     this.jTextField69 = new JTextField();
/*  775 */     this.jTextField70 = new JTextField();
/*  776 */     this.jPanel96 = new JPanel();
/*  777 */     this.jLabel51 = new JLabel();
/*  778 */     this.jLabel52 = new JLabel();
/*  779 */     this.jPanel25 = new JPanel();
/*  780 */     this.jLabel3 = new JLabel();
/*  781 */     this.jLabel154 = new JLabel();
/*  782 */     this.jLabel8 = new JLabel();
/*  783 */     this.jLabel155 = new JLabel();
/*  784 */     this.jLabel82 = new JLabel();
/*  785 */     this.jLabel156 = new JLabel();
/*  786 */     this.jLabel83 = new JLabel();
/*  787 */     this.jLabel160 = new JLabel();
/*  788 */     this.jLabel84 = new JLabel();
/*  789 */     this.jLabel161 = new JLabel();
/*  790 */     this.jLabel86 = new JLabel();
/*  791 */     this.jLabel163 = new JLabel();
/*  792 */     this.jLabel115 = new JLabel();
/*  793 */     this.jLabel164 = new JLabel();
/*  794 */     this.jLabel116 = new JLabel();
/*  795 */     this.jLabel165 = new JLabel();
/*  796 */     this.jPanel98 = new JPanel();
/*  797 */     this.jComboBox21 = new JComboBox();
/*  798 */     this.jLabel58 = new JLabel();
/*  799 */     this.jLabel43 = new JLabel();
/*  800 */     this.jComboBox5 = new JComboBox();
/*  801 */     this.jComboBox6 = new JComboBox();
/*  802 */     this.jLabel44 = new JLabel();
/*  803 */     this.jLabel45 = new JLabel();
/*  804 */     this.jComboBox7 = new JComboBox();
/*  805 */     this.jComboBox2 = new JComboBox();
/*  806 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  807 */     this.jPanel102 = new JPanel();
/*  808 */     this.jScrollPane15 = new JScrollPane();
/*  809 */     this.jTable8 = new JTable();
/*  810 */     this.jPanel1 = new JPanel();
/*  811 */     this.jLabel54 = new JLabel();
/*  812 */     this.jPanel5 = new JPanel();
/*  813 */     this.jScrollPane3 = new JScrollPane();
/*  814 */     this.jTable3 = new JTable();
/*  815 */     this.jLabel35 = new JLabel();
/*  816 */     this.jLabel37 = new JLabel();
/*  817 */     this.jLabel38 = new JLabel();
/*  818 */     this.jLabel39 = new JLabel();
/*  819 */     this.jLabel42 = new JLabel();
/*  820 */     this.jPanel28 = new JPanel();
/*  821 */     this.jPanel36 = new JPanel();
/*  822 */     this.jLabel48 = new JLabel();
/*  823 */     this.jButton24 = new JButton();
/*  824 */     this.jButton46 = new JButton();
/*  825 */     this.jButton23 = new JButton();
/*  826 */     this.jButton25 = new JButton();
/*  827 */     this.jButton26 = new JButton();
/*  828 */     this.jButton15 = new JButton();
/*  829 */     this.jButton28 = new JButton();
/*  830 */     this.jButton10 = new JButton();
/*  831 */     this.jButton2 = new JButton();
/*  832 */     this.jPanel17 = new JPanel();
/*  833 */     this.jTextField1 = new JTextField();
/*  834 */     this.jTextField2 = new JTextField();
/*  835 */     this.jComboBox22 = new JComboBox();
/*  836 */     this.jComboBox8 = new JComboBox();
/*  837 */     this.jComboBox3 = new JComboBox();
/*  838 */     this.jComboBox11 = new JComboBox();
/*  839 */     this.jLabel15 = new JLabel();
/*  840 */     this.jLabel34 = new JLabel();
/*  841 */     this.jLabel166 = new JLabel();
/*  842 */     this.jLabel46 = new JLabel();
/*  843 */     this.jLabel41 = new JLabel();
/*  844 */     this.jLabel47 = new JLabel();
/*  845 */     this.jPanel2 = new JPanel();
/*  846 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  847 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  848 */     this.jLabel5 = new JLabel();
/*  849 */     this.jLabel6 = new JLabel();
/*  850 */     this.jLabel7 = new JLabel();
/*  851 */     this.jLabel1 = new JLabel();
/*  852 */     this.jLabel4 = new JLabel();
/*  853 */     this.jButton1 = new JButton();
/*      */     
/*  855 */     this.jDialog3.setTitle("Agrega detalles de los viajes");
/*      */     
/*  857 */     this.jPanel32.setBackground(new Color(255, 255, 255));
/*      */     
/*  859 */     this.jLabel121.setFont(new Font("Times New Roman", 1, 14));
/*  860 */     this.jLabel121.setHorizontalAlignment(0);
/*  861 */     this.jLabel121.setText("Coloca los datos que deseas instertar");
/*      */     
/*  863 */     this.jButton35.setMnemonic('C');
/*  864 */     this.jButton35.setText("Cerrar");
/*  865 */     this.jButton35.setToolTipText("Cerrar (Alt+C)");
/*  866 */     this.jButton35.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  868 */             Facturas.this.jButton35ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  872 */     this.jButton36.setMnemonic('A');
/*  873 */     this.jButton36.setText("Agregar");
/*  874 */     this.jButton36.setToolTipText("Agregar (Alt+A)");
/*  875 */     this.jButton36.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  877 */             Facturas.this.jButton36ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  881 */     this.jPanel27.setBackground(new Color(255, 255, 255));
/*      */     
/*  883 */     this.jLabel132.setHorizontalAlignment(0);
/*  884 */     this.jLabel132.setText("No Doc");
/*      */     
/*  886 */     this.jLabel134.setHorizontalAlignment(0);
/*  887 */     this.jLabel134.setText("M3");
/*      */     
/*  889 */     this.jFormattedTextField8.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*  890 */     this.jFormattedTextField8.setHorizontalAlignment(4);
/*      */     
/*  892 */     this.jFormattedTextField9.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*  893 */     this.jFormattedTextField9.setHorizontalAlignment(4);
/*      */     
/*  895 */     this.jLabel135.setHorizontalAlignment(0);
/*  896 */     this.jLabel135.setText("Peso");
/*      */     
/*  898 */     this.jLabel136.setHorizontalAlignment(0);
/*  899 */     this.jLabel136.setText("Manifiesto");
/*      */     
/*  901 */     this.jLabel127.setFont(new Font("Tahoma", 1, 11));
/*  902 */     this.jLabel127.setHorizontalAlignment(0);
/*  903 */     this.jLabel127.setText("P Unitario");
/*      */     
/*  905 */     this.jFormattedTextField6.setHorizontalAlignment(4);
/*      */     
/*  907 */     GroupLayout jPanel27Layout = new GroupLayout(this.jPanel27);
/*  908 */     this.jPanel27.setLayout(jPanel27Layout);
/*  909 */     jPanel27Layout.setHorizontalGroup(jPanel27Layout
/*  910 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  911 */         .addGroup(jPanel27Layout.createSequentialGroup()
/*  912 */           .addContainerGap()
/*  913 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  914 */             .addComponent(this.jLabel132, -1, -1, 32767)
/*  915 */             .addComponent(this.jTextField31, -2, 117, -2))
/*  916 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  917 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  918 */             .addComponent(this.jLabel134, -1, -1, 32767)
/*  919 */             .addComponent(this.jFormattedTextField8, -2, 111, -2))
/*  920 */           .addGap(8, 8, 8)
/*  921 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  922 */             .addComponent(this.jFormattedTextField9, -2, 120, -2)
/*  923 */             .addGroup(jPanel27Layout.createSequentialGroup()
/*  924 */               .addGap(1, 1, 1)
/*  925 */               .addComponent(this.jLabel135, -2, 119, -2)))
/*  926 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  927 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  928 */             .addComponent(this.jLabel136, -1, -1, 32767)
/*  929 */             .addComponent(this.jTextField33, -2, 114, -2))
/*  930 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  931 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  932 */             .addComponent(this.jLabel127, -1, 116, 32767)
/*  933 */             .addComponent(this.jFormattedTextField6, -1, 116, 32767))
/*  934 */           .addGap(440, 440, 440)));
/*      */     
/*  936 */     jPanel27Layout.setVerticalGroup(jPanel27Layout
/*  937 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  938 */         .addGroup(jPanel27Layout.createSequentialGroup()
/*  939 */           .addContainerGap()
/*  940 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  941 */             .addGroup(jPanel27Layout.createSequentialGroup()
/*  942 */               .addComponent(this.jLabel134)
/*  943 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  944 */               .addComponent(this.jFormattedTextField8, -2, -1, -2))
/*  945 */             .addGroup(jPanel27Layout.createSequentialGroup()
/*  946 */               .addComponent(this.jLabel135)
/*  947 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  948 */               .addComponent(this.jFormattedTextField9, -2, -1, -2))
/*  949 */             .addGroup(jPanel27Layout.createSequentialGroup()
/*  950 */               .addComponent(this.jLabel136)
/*  951 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  952 */               .addComponent(this.jTextField33, -2, -1, -2))
/*  953 */             .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  954 */               .addGroup(jPanel27Layout.createSequentialGroup()
/*  955 */                 .addComponent(this.jLabel132)
/*  956 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  957 */                 .addComponent(this.jTextField31, -2, -1, -2))
/*  958 */               .addGroup(jPanel27Layout.createSequentialGroup()
/*  959 */                 .addComponent(this.jLabel127)
/*  960 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  961 */                 .addComponent(this.jFormattedTextField6, -2, -1, -2))))
/*  962 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  965 */     this.jPanel33.setBackground(new Color(255, 255, 255));
/*      */     
/*  967 */     this.jLabel133.setFont(new Font("Tahoma", 1, 11));
/*  968 */     this.jLabel133.setHorizontalAlignment(0);
/*  969 */     this.jLabel133.setText("Guía");
/*      */     
/*  971 */     this.jTextField32.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  973 */             Facturas.this.jTextField32FocusLost(evt);
/*      */           }
/*      */         });
/*      */     
/*  977 */     this.jLabel137.setFont(new Font("Tahoma", 1, 11));
/*  978 */     this.jLabel137.setHorizontalAlignment(0);
/*  979 */     this.jLabel137.setText("F Serv");
/*      */     
/*  981 */     this.jLabel138.setHorizontalAlignment(0);
/*  982 */     this.jLabel138.setText("Rspr");
/*      */     
/*  984 */     this.jLabel139.setHorizontalAlignment(0);
/*  985 */     this.jLabel139.setText("Origen");
/*      */     
/*  987 */     this.jLabel129.setHorizontalAlignment(0);
/*  988 */     this.jLabel129.setText("Destino");
/*      */     
/*  990 */     this.jDateChooser7.setDate(this.fechaActual);
/*  991 */     this.jDateChooser7.setDateFormatString("dd/MM/yyyy");
/*  992 */     this.jDateChooser7.setIcon(this.icon);
/*  993 */     this.jDateChooser7.setMaxSelectableDate(this.fecha);
/*  994 */     this.jDateChooser7.setMinSelectableDate(new Date(1257058862000L));
/*      */     
/*  996 */     GroupLayout jPanel33Layout = new GroupLayout(this.jPanel33);
/*  997 */     this.jPanel33.setLayout(jPanel33Layout);
/*  998 */     jPanel33Layout.setHorizontalGroup(jPanel33Layout
/*  999 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1000 */         .addGroup(jPanel33Layout.createSequentialGroup()
/* 1001 */           .addContainerGap()
/* 1002 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1003 */             .addComponent(this.jLabel133, -1, -1, 32767)
/* 1004 */             .addComponent(this.jTextField32, -1, 117, 32767))
/* 1005 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1006 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1007 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 1008 */               .addComponent(this.jLabel137, -1, -1, 32767)
/* 1009 */               .addGap(9, 9, 9))
/* 1010 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 1011 */               .addComponent((Component)this.jDateChooser7, -2, 112, -2)
/* 1012 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)))
/* 1013 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1014 */             .addComponent(this.jLabel138, -2, 119, -2)
/* 1015 */             .addComponent(this.jTextField35, GroupLayout.Alignment.LEADING, -2, 119, -2))
/* 1016 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1017 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1018 */             .addComponent(this.jLabel139, -1, -1, 32767)
/* 1019 */             .addComponent(this.jTextField34, -2, 114, -2))
/* 1020 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1021 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1022 */             .addComponent(this.jLabel129, -2, 122, -2)
/* 1023 */             .addComponent(this.jTextField36, -2, 113, -2))
/* 1024 */           .addGap(10, 10, 10)));
/*      */     
/* 1026 */     jPanel33Layout.setVerticalGroup(jPanel33Layout
/* 1027 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1028 */         .addGroup(jPanel33Layout.createSequentialGroup()
/* 1029 */           .addContainerGap()
/* 1030 */           .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1031 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
/* 1032 */               .addComponent(this.jLabel138)
/* 1033 */               .addGap(26, 26, 26))
/* 1034 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
/* 1035 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1036 */                 .addComponent(this.jLabel139)
/* 1037 */                 .addComponent(this.jLabel129))
/* 1038 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1039 */               .addGroup(jPanel33Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1040 */                 .addComponent(this.jTextField34, -2, -1, -2)
/* 1041 */                 .addComponent(this.jTextField35, -2, -1, -2)
/* 1042 */                 .addComponent(this.jTextField36, -2, -1, -2)))
/* 1043 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 1044 */               .addComponent(this.jLabel137)
/* 1045 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1046 */               .addComponent((Component)this.jDateChooser7, -1, -1, 32767))
/* 1047 */             .addGroup(jPanel33Layout.createSequentialGroup()
/* 1048 */               .addComponent(this.jLabel133)
/* 1049 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1050 */               .addComponent(this.jTextField32, -2, -1, -2)))
/* 1051 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1054 */     GroupLayout jPanel32Layout = new GroupLayout(this.jPanel32);
/* 1055 */     this.jPanel32.setLayout(jPanel32Layout);
/* 1056 */     jPanel32Layout.setHorizontalGroup(jPanel32Layout
/* 1057 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1058 */         .addGroup(jPanel32Layout.createSequentialGroup()
/* 1059 */           .addContainerGap()
/* 1060 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1061 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
/* 1062 */               .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1063 */                 .addGroup(jPanel32Layout.createSequentialGroup()
/* 1064 */                   .addComponent(this.jPanel33, -1, -1, 32767)
/* 1065 */                   .addGap(1308, 1308, 1308))
/* 1066 */                 .addComponent(this.jPanel27, -2, -1, -2))
/* 1067 */               .addGap(97, 97, 97))
/* 1068 */             .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1069 */               .addGroup(jPanel32Layout.createSequentialGroup()
/* 1070 */                 .addComponent(this.jButton36, -2, 83, -2)
/* 1071 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1072 */                 .addComponent(this.jButton35, -2, 83, -2))
/* 1073 */               .addComponent(this.jSeparator28, -2, 615, -2))
/* 1074 */             .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1075 */               .addComponent(this.jLabel121, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1076 */               .addComponent(this.jSeparator26, GroupLayout.Alignment.LEADING, -1, 617, 32767)))
/* 1077 */           .addContainerGap()));
/*      */     
/* 1079 */     jPanel32Layout.setVerticalGroup(jPanel32Layout
/* 1080 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1081 */         .addGroup(jPanel32Layout.createSequentialGroup()
/* 1082 */           .addComponent(this.jLabel121)
/* 1083 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1084 */           .addComponent(this.jSeparator26, -2, 10, -2)
/* 1085 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1086 */           .addComponent(this.jPanel33, -2, -1, -2)
/* 1087 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1088 */           .addComponent(this.jPanel27, -2, -1, -2)
/* 1089 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1090 */           .addComponent(this.jSeparator28, -2, 10, -2)
/* 1091 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1092 */           .addGroup(jPanel32Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1093 */             .addComponent(this.jButton35)
/* 1094 */             .addComponent(this.jButton36))
/* 1095 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1098 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1099 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1100 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1101 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1102 */         .addComponent(this.jPanel32, -1, 671, 32767));
/*      */     
/* 1104 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1105 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1106 */         .addGroup(jDialog3Layout.createSequentialGroup()
/* 1107 */           .addComponent(this.jPanel32, -2, -1, -2)
/* 1108 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1111 */     this.jDialog4.setTitle("Cobrar a");
/*      */     
/* 1113 */     this.jPanel26.setBackground(new Color(255, 255, 255));
/* 1114 */     this.jPanel26.setBorder(BorderFactory.createTitledBorder("Cobrar a"));
/*      */     
/* 1116 */     this.jLabel94.setText("Linea1:");
/*      */     
/* 1118 */     this.jLabel95.setText("Linea2:");
/*      */     
/* 1120 */     this.jLabel96.setText("Linea3:");
/*      */     
/* 1122 */     this.jLabel97.setText("Linea4:");
/*      */     
/* 1124 */     this.jButton39.setMnemonic('C');
/* 1125 */     this.jButton39.setText("Cerrar");
/* 1126 */     this.jButton39.setToolTipText("Cerrar (Alt+C)");
/* 1127 */     this.jButton39.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1129 */             Facturas.this.jButton39ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1133 */     GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
/* 1134 */     this.jPanel26.setLayout(jPanel26Layout);
/* 1135 */     jPanel26Layout.setHorizontalGroup(jPanel26Layout
/* 1136 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1137 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
/* 1138 */           .addContainerGap()
/* 1139 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1140 */             .addComponent(this.jButton39, -2, 98, -2)
/* 1141 */             .addGroup(jPanel26Layout.createSequentialGroup()
/* 1142 */               .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1143 */                 .addComponent(this.jLabel97, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1144 */                 .addComponent(this.jLabel96, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1145 */                 .addComponent(this.jLabel95, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1146 */                 .addComponent(this.jLabel94, -2, 43, -2))
/* 1147 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1148 */               .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1149 */                 .addComponent(this.jTextField41)
/* 1150 */                 .addComponent(this.jTextField42)
/* 1151 */                 .addComponent(this.jTextField39)
/* 1152 */                 .addComponent(this.jTextField40, -2, 275, -2))))
/* 1153 */           .addContainerGap()));
/*      */     
/* 1155 */     jPanel26Layout.setVerticalGroup(jPanel26Layout
/* 1156 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1157 */         .addGroup(jPanel26Layout.createSequentialGroup()
/* 1158 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1159 */             .addComponent(this.jLabel94)
/* 1160 */             .addComponent(this.jTextField39))
/* 1161 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1162 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1163 */             .addComponent(this.jLabel95)
/* 1164 */             .addComponent(this.jTextField40))
/* 1165 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1166 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1167 */             .addComponent(this.jLabel96)
/* 1168 */             .addComponent(this.jTextField41))
/* 1169 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1170 */           .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1171 */             .addComponent(this.jLabel97)
/* 1172 */             .addComponent(this.jTextField42))
/* 1173 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1174 */           .addComponent(this.jButton39)
/* 1175 */           .addGap(18, 18, 18)));
/*      */ 
/*      */     
/* 1178 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1179 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1180 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1181 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1182 */         .addComponent(this.jPanel26, -2, -1, -2));
/*      */     
/* 1184 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1185 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1186 */         .addComponent(this.jPanel26, -2, -1, -2));
/*      */ 
/*      */     
/* 1189 */     this.jDialog5.setTitle("Amparar Prefacturas");
/*      */     
/* 1191 */     this.jPanel3.setBackground(Color.white);
/*      */     
/* 1193 */     this.jLabel122.setFont(new Font("Times New Roman", 1, 14));
/* 1194 */     this.jLabel122.setHorizontalAlignment(0);
/* 1195 */     this.jLabel122.setText("Selecciona la prefactura");
/*      */     
/* 1197 */     this.jLabel9.setText("Folio Interno:");
/*      */     
/* 1199 */     this.jTextField6.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1201 */             Facturas.this.jTextField6KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1205 */     this.jLabel10.setHorizontalAlignment(4);
/* 1206 */     this.jLabel10.setText("Referencia");
/*      */     
/* 1208 */     this.jTextField7.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1210 */             Facturas.this.jTextField7KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1214 */     this.jTable1.setFont(new Font("Tahoma", 0, 10));
/* 1215 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { {}, {}, {}, {} }, (Object[])new String[0]));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1226 */     this.jTable1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1228 */             Facturas.this.jTable1MouseClicked(evt);
/*      */           }
/*      */         });
/* 1231 */     this.jScrollPane1.setViewportView(this.jTable1);
/*      */     
/* 1233 */     this.jButton3.setMnemonic('Q');
/* 1234 */     this.jButton3.setText("Quitar");
/* 1235 */     this.jButton3.setToolTipText("Quitar (Alt+Q)");
/* 1236 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1238 */             Facturas.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1242 */     this.jButton4.setMnemonic('P');
/* 1243 */     this.jButton4.setText("Amparar Prefactura");
/* 1244 */     this.jButton4.setToolTipText("Amparar Prefactura(Alt+P)");
/* 1245 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1247 */             Facturas.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1251 */     this.jTable2.setFont(new Font("Tahoma", 0, 10));
/* 1252 */     this.jTable2.setModel(new DefaultTableModel(new Object[][] { {}, {}, {}, {} }, (Object[])new String[0]));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1263 */     this.jTable2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1265 */             Facturas.this.jTable2MouseClicked(evt);
/*      */           }
/*      */         });
/* 1268 */     this.jScrollPane2.setViewportView(this.jTable2);
/*      */     
/* 1270 */     this.jButton5.setMnemonic('C');
/* 1271 */     this.jButton5.setText("Cancelar");
/* 1272 */     this.jButton5.setToolTipText("Cancelar (Alt+C)");
/* 1273 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1275 */             Facturas.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1279 */     this.jButton6.setMnemonic('A');
/* 1280 */     this.jButton6.setText("Aceptar");
/* 1281 */     this.jButton6.setToolTipText("Aceptar (Alt+A)");
/* 1282 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1284 */             Facturas.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1288 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 1289 */     this.jPanel3.setLayout(jPanel3Layout);
/* 1290 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 1291 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1292 */         .addComponent(this.jSeparator27, -1, 377, 32767)
/* 1293 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 1294 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1295 */             .addComponent(this.jLabel122, -1, 367, 32767)
/* 1296 */             .addGroup(jPanel3Layout.createSequentialGroup()
/* 1297 */               .addContainerGap()
/* 1298 */               .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1299 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/* 1300 */                   .addComponent(this.jLabel9, -2, 90, 32767)
/* 1301 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1302 */                   .addComponent(this.jTextField6, -2, 84, -2)
/* 1303 */                   .addGap(21, 21, 21)
/* 1304 */                   .addComponent(this.jLabel10, -2, 70, -2)
/* 1305 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1306 */                   .addComponent(this.jTextField7, -2, 84, -2))
/* 1307 */                 .addComponent(this.jScrollPane2, -1, 357, 32767)
/* 1308 */                 .addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -1, 357, 32767)
/* 1309 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/* 1310 */                   .addGap(0, 0, 32767)
/* 1311 */                   .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1312 */                     .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/* 1313 */                       .addComponent(this.jButton6, -2, 95, -2)
/* 1314 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1315 */                       .addComponent(this.jButton5, -2, 95, -2))
/* 1316 */                     .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
/* 1317 */                       .addComponent(this.jButton4, -2, 136, -2)
/* 1318 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1319 */                       .addComponent(this.jButton3, -2, 111, -2)))))))
/* 1320 */           .addContainerGap()));
/*      */     
/* 1322 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 1323 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1324 */         .addGroup(jPanel3Layout.createSequentialGroup()
/* 1325 */           .addComponent(this.jLabel122)
/* 1326 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1327 */           .addComponent(this.jSeparator27, -2, 10, -2)
/* 1328 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1329 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1330 */             .addComponent(this.jLabel9)
/* 1331 */             .addComponent(this.jLabel10)
/* 1332 */             .addComponent(this.jTextField7, -2, -1, -2)
/* 1333 */             .addComponent(this.jTextField6, -2, -1, -2))
/* 1334 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1335 */           .addComponent(this.jScrollPane1, -2, 131, -2)
/* 1336 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1337 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1338 */             .addComponent(this.jButton3)
/* 1339 */             .addComponent(this.jButton4))
/* 1340 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1341 */           .addComponent(this.jScrollPane2, -2, 92, -2)
/* 1342 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1343 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1344 */             .addComponent(this.jButton5)
/* 1345 */             .addComponent(this.jButton6))
/* 1346 */           .addContainerGap(12, 32767)));
/*      */ 
/*      */     
/* 1349 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1350 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1351 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1352 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1353 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */     
/* 1355 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1356 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1357 */         .addComponent(this.jPanel3, -1, -1, 32767));
/*      */ 
/*      */     
/* 1360 */     this.cantidad.setText("jFormattedTextField1");
/*      */     
/* 1362 */     this.jDialog6.setTitle("Prefacturas amparadas para esta factura");
/*      */     
/* 1364 */     this.jPanel4.setBackground(new Color(146, 193, 134));
/*      */     
/* 1366 */     this.jLabel123.setFont(new Font("Tahoma", 1, 14));
/* 1367 */     this.jLabel123.setForeground(new Color(0, 102, 102));
/* 1368 */     this.jLabel123.setHorizontalAlignment(0);
/* 1369 */     this.jLabel123.setText("Prefacturas");
/*      */     
/* 1371 */     this.jLabel11.setText("Éstas son las prefacturas que se emparan para esta factura");
/*      */     
/* 1373 */     this.jTable4.setFont(new Font("Tahoma", 0, 10));
/* 1374 */     this.jTable4.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, , { null, null, null, null, null, null }, , { null, null, null, null, null, null }, , { null, null, null, null, null, null },  }, (Object[])new String[] { "Folio", "Ref", "Subtotal", "Iva", "Retención", "Total" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1385 */     this.jTable4.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1387 */             Facturas.this.jTable4MouseClicked(evt);
/*      */           }
/*      */         });
/* 1390 */     this.jScrollPane4.setViewportView(this.jTable4);
/*      */     
/* 1392 */     this.jButton7.setMnemonic('C');
/* 1393 */     this.jButton7.setText("Cerrar");
/* 1394 */     this.jButton7.setToolTipText("Cerrar (Alt+C)");
/* 1395 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1397 */             Facturas.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1401 */     this.jButton8.setMnemonic('V');
/* 1402 */     this.jButton8.setText("Ver");
/* 1403 */     this.jButton8.setToolTipText("Ver Prefactura (Alt+V)");
/* 1404 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1406 */             Facturas.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1410 */     this.jPanel6.setBackground(new Color(146, 193, 134));
/*      */     
/* 1412 */     this.jLabel12.setFont(new Font("Tahoma", 1, 11));
/* 1413 */     this.jLabel12.setText("Totales");
/*      */     
/* 1415 */     this.jLabel13.setFont(new Font("Tahoma", 1, 11));
/* 1416 */     this.jLabel13.setHorizontalAlignment(4);
/* 1417 */     this.jLabel13.setText("jLabel13");
/*      */     
/* 1419 */     this.jLabel14.setFont(new Font("Tahoma", 1, 11));
/* 1420 */     this.jLabel14.setHorizontalAlignment(4);
/* 1421 */     this.jLabel14.setText("jLabel13");
/*      */     
/* 1423 */     this.jLabel17.setFont(new Font("Tahoma", 1, 11));
/* 1424 */     this.jLabel17.setHorizontalAlignment(4);
/* 1425 */     this.jLabel17.setText("jLabel13");
/*      */     
/* 1427 */     this.jLabel18.setFont(new Font("Tahoma", 1, 11));
/* 1428 */     this.jLabel18.setHorizontalAlignment(4);
/* 1429 */     this.jLabel18.setText("jLabel13");
/*      */     
/* 1431 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 1432 */     this.jPanel6.setLayout(jPanel6Layout);
/* 1433 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 1434 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1435 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1436 */           .addComponent(this.jLabel12, -2, 69, -2)
/* 1437 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 54, 32767)
/* 1438 */           .addComponent(this.jLabel18, -2, 82, -2)
/* 1439 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1440 */           .addComponent(this.jLabel17, -2, 82, -2)
/* 1441 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1442 */           .addComponent(this.jLabel14, -2, 82, -2)
/* 1443 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1444 */           .addComponent(this.jLabel13, -2, 82, -2)));
/*      */     
/* 1446 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 1447 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1448 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1449 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1450 */             .addComponent(this.jLabel12)
/* 1451 */             .addComponent(this.jLabel13)
/* 1452 */             .addComponent(this.jLabel14, -1, -1, 32767)
/* 1453 */             .addComponent(this.jLabel17, -1, -1, 32767)
/* 1454 */             .addComponent(this.jLabel18, -1, -1, 32767))
/* 1455 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1458 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 1459 */     this.jPanel4.setLayout(jPanel4Layout);
/* 1460 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 1461 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1462 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 1463 */           .addContainerGap()
/* 1464 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1465 */             .addComponent(this.jPanel6, -1, -1, 32767)
/* 1466 */             .addComponent(this.jScrollPane4, -1, 469, 32767)
/* 1467 */             .addComponent(this.jLabel11)
/* 1468 */             .addComponent(this.jLabel123, -1, 469, 32767)
/* 1469 */             .addComponent(this.jSeparator1, -1, 469, 32767)
/* 1470 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
/* 1471 */               .addComponent(this.jButton8, -2, 97, -2)
/* 1472 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1473 */               .addComponent(this.jButton7, -2, 97, -2))
/* 1474 */             .addComponent(this.jSeparator2, GroupLayout.Alignment.TRAILING, -1, 469, 32767))
/* 1475 */           .addGap(21, 21, 21)));
/*      */     
/* 1477 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 1478 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1479 */         .addGroup(jPanel4Layout.createSequentialGroup()
/* 1480 */           .addComponent(this.jLabel123)
/* 1481 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1482 */           .addComponent(this.jSeparator1, -2, 10, -2)
/* 1483 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1484 */           .addComponent(this.jLabel11)
/* 1485 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1486 */           .addComponent(this.jScrollPane4, -2, 141, -2)
/* 1487 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1488 */           .addComponent(this.jPanel6, -2, -1, -2)
/* 1489 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1490 */           .addComponent(this.jSeparator2, -2, 10, -2)
/* 1491 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1492 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1493 */             .addComponent(this.jButton7)
/* 1494 */             .addComponent(this.jButton8))
/* 1495 */           .addContainerGap(20, 32767)));
/*      */ 
/*      */     
/* 1498 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/* 1499 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/* 1500 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/* 1501 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1502 */         .addComponent(this.jPanel4, -1, -1, 32767));
/*      */     
/* 1504 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/* 1505 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1506 */         .addComponent(this.jPanel4, -1, -1, 32767));
/*      */ 
/*      */     
/* 1509 */     this.jDialog7.setTitle("Coloca el comentario");
/*      */     
/* 1511 */     this.jPanel11.setBackground(Color.white);
/*      */     
/* 1513 */     this.jLabel36.setFont(new Font("Times New Roman", 1, 14));
/* 1514 */     this.jLabel36.setHorizontalAlignment(0);
/* 1515 */     this.jLabel36.setText("Coloca un comentario corto");
/*      */     
/* 1517 */     this.jLabel40.setText("Comentario");
/*      */     
/* 1519 */     this.jTextField5.setFont(new Font("Tahoma", 1, 14));
/* 1520 */     this.jTextField5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1522 */             Facturas.this.jTextField5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1526 */     this.jButton16.setMnemonic('C');
/* 1527 */     this.jButton16.setText("Cancelar");
/* 1528 */     this.jButton16.setToolTipText("Cancelar (Alt+C)");
/* 1529 */     this.jButton16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1531 */             Facturas.this.jButton16ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1535 */     this.jButton17.setMnemonic('A');
/* 1536 */     this.jButton17.setText("Aceptar");
/* 1537 */     this.jButton17.setToolTipText("Aceptar (Alt+A)");
/* 1538 */     this.jButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1540 */             Facturas.this.jButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1544 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 1545 */     this.jPanel11.setLayout(jPanel11Layout);
/* 1546 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/* 1547 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1548 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 1549 */           .addContainerGap()
/* 1550 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1551 */             .addComponent(this.jSeparator10, -1, 328, 32767)
/* 1552 */             .addGroup(jPanel11Layout.createSequentialGroup()
/* 1553 */               .addComponent(this.jLabel40, -2, 74, -2)
/* 1554 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1555 */               .addComponent(this.jTextField5, -1, 250, 32767))
/* 1556 */             .addComponent(this.jSeparator11, GroupLayout.Alignment.TRAILING, -1, 328, 32767)
/* 1557 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
/* 1558 */               .addComponent(this.jButton17, -2, 83, -2)
/* 1559 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1560 */               .addComponent(this.jButton16, -2, 83, -2))
/* 1561 */             .addComponent(this.jLabel36, -1, 328, 32767))
/* 1562 */           .addContainerGap()));
/*      */     
/* 1564 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/* 1565 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1566 */         .addGroup(jPanel11Layout.createSequentialGroup()
/* 1567 */           .addComponent(this.jLabel36)
/* 1568 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1569 */           .addComponent(this.jSeparator10, -2, 10, -2)
/* 1570 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1571 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1572 */             .addComponent(this.jLabel40, -2, 26, -2)
/* 1573 */             .addComponent(this.jTextField5, -2, 25, -2))
/* 1574 */           .addGap(33, 33, 33)
/* 1575 */           .addComponent(this.jSeparator11, -2, 10, -2)
/* 1576 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1577 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1578 */             .addComponent(this.jButton16)
/* 1579 */             .addComponent(this.jButton17))
/* 1580 */           .addContainerGap(22, 32767)));
/*      */ 
/*      */     
/* 1583 */     GroupLayout jDialog7Layout = new GroupLayout(this.jDialog7.getContentPane());
/* 1584 */     this.jDialog7.getContentPane().setLayout(jDialog7Layout);
/* 1585 */     jDialog7Layout.setHorizontalGroup(jDialog7Layout
/* 1586 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1587 */         .addComponent(this.jPanel11, -1, -1, 32767));
/*      */     
/* 1589 */     jDialog7Layout.setVerticalGroup(jDialog7Layout
/* 1590 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1591 */         .addComponent(this.jPanel11, -2, -1, -2));
/*      */ 
/*      */     
/* 1594 */     this.jDialog8.setTitle("Cancelar Factura");
/* 1595 */     this.jDialog8.setModal(true);
/*      */     
/* 1597 */     this.jPanel29.setBackground(new Color(146, 193, 134));
/*      */     
/* 1599 */     this.jLabel124.setFont(new Font("Tahoma", 1, 14));
/* 1600 */     this.jLabel124.setForeground(new Color(0, 102, 102));
/* 1601 */     this.jLabel124.setHorizontalAlignment(0);
/* 1602 */     this.jLabel124.setText("Motivo de la Cancelación");
/*      */     
/* 1604 */     this.jLabel125.setFont(new Font("Tahoma", 3, 11));
/* 1605 */     this.jLabel125.setForeground(new Color(15, 87, 51));
/* 1606 */     this.jLabel125.setHorizontalAlignment(4);
/* 1607 */     this.jLabel125.setText("Motivo");
/*      */     
/* 1609 */     this.jButton44.setMnemonic('A');
/* 1610 */     this.jButton44.setText("Cancelar Factura");
/* 1611 */     this.jButton44.setToolTipText("Cancelar Factura (Alt+A)");
/* 1612 */     this.jButton44.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1614 */             Facturas.this.jButton44ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1618 */     this.jButton45.setMnemonic('C');
/* 1619 */     this.jButton45.setText("Cerrar");
/* 1620 */     this.jButton45.setToolTipText("Cerrar (Alt+C)");
/* 1621 */     this.jButton45.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1623 */             Facturas.this.jButton45ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1627 */     this.jTextArea5.setColumns(20);
/* 1628 */     this.jTextArea5.setLineWrap(true);
/* 1629 */     this.jTextArea5.setRows(5);
/* 1630 */     this.jScrollPane18.setViewportView(this.jTextArea5);
/*      */     
/* 1632 */     this.jLabel126.setText("Ingresa el motivo por el cual deseas cancelar la factura");
/*      */     
/* 1634 */     GroupLayout jPanel29Layout = new GroupLayout(this.jPanel29);
/* 1635 */     this.jPanel29.setLayout(jPanel29Layout);
/* 1636 */     jPanel29Layout.setHorizontalGroup(jPanel29Layout
/* 1637 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1638 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1639 */           .addContainerGap()
/* 1640 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1641 */             .addComponent(this.jLabel126, -1, -1, 32767)
/* 1642 */             .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1643 */               .addGroup(jPanel29Layout.createSequentialGroup()
/* 1644 */                 .addComponent(this.jButton44, -2, 137, -2)
/* 1645 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1646 */                 .addComponent(this.jButton45, -2, 84, -2))
/* 1647 */               .addGroup(jPanel29Layout.createSequentialGroup()
/* 1648 */                 .addComponent(this.jLabel125, -2, 43, -2)
/* 1649 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1650 */                 .addComponent(this.jScrollPane18, -2, 302, -2)))
/* 1651 */             .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1652 */               .addComponent(this.jLabel124, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1653 */               .addComponent(this.jSeparator29, GroupLayout.Alignment.LEADING, -1, 346, 32767)))
/* 1654 */           .addContainerGap()));
/*      */     
/* 1656 */     jPanel29Layout.setVerticalGroup(jPanel29Layout
/* 1657 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1658 */         .addGroup(jPanel29Layout.createSequentialGroup()
/* 1659 */           .addComponent(this.jLabel124)
/* 1660 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1661 */           .addComponent(this.jSeparator29, -2, 10, -2)
/* 1662 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1663 */           .addComponent(this.jLabel126)
/* 1664 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1665 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1666 */             .addComponent(this.jLabel125)
/* 1667 */             .addComponent(this.jScrollPane18, -2, 96, -2))
/* 1668 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1669 */           .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1670 */             .addComponent(this.jButton45)
/* 1671 */             .addComponent(this.jButton44))
/* 1672 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1675 */     GroupLayout jDialog8Layout = new GroupLayout(this.jDialog8.getContentPane());
/* 1676 */     this.jDialog8.getContentPane().setLayout(jDialog8Layout);
/* 1677 */     jDialog8Layout.setHorizontalGroup(jDialog8Layout
/* 1678 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1679 */         .addComponent(this.jPanel29, -1, -1, 32767));
/*      */     
/* 1681 */     jDialog8Layout.setVerticalGroup(jDialog8Layout
/* 1682 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1683 */         .addComponent(this.jPanel29, -1, -1, 32767));
/*      */ 
/*      */     
/* 1686 */     this.jDialog9.setTitle("Datos de la prefactura");
/*      */     
/* 1688 */     this.jPanel7.setBackground(Color.white);
/*      */     
/* 1690 */     this.jPanel38.setBackground(Color.white);
/*      */     
/* 1692 */     this.jLabel19.setFont(new Font("Times New Roman", 1, 14));
/* 1693 */     this.jLabel19.setForeground(Color.blue);
/* 1694 */     this.jLabel19.setHorizontalAlignment(0);
/* 1695 */     this.jLabel19.setText("LISTADO DE VIAJES");
/*      */     
/* 1697 */     this.jLabel20.setFont(new Font("Tahoma", 1, 11));
/* 1698 */     this.jLabel20.setText("Cliente:");
/*      */     
/* 1700 */     this.jLabel21.setHorizontalAlignment(4);
/* 1701 */     this.jLabel21.setText("Equipo:");
/*      */     
/* 1703 */     this.jTextField11.setEnabled(false);
/*      */     
/* 1705 */     this.jLabel22.setHorizontalAlignment(4);
/* 1706 */     this.jLabel22.setText("Pozo:");
/*      */     
/* 1708 */     this.jTextField12.setEnabled(false);
/*      */     
/* 1710 */     this.jLabel23.setFont(new Font("Tahoma", 2, 11));
/* 1711 */     this.jLabel23.setText("/*Ésta es la lista de todos los viajes con precios.*/       ");
/*      */     
/* 1713 */     this.jTextField4.setEnabled(false);
/*      */     
/* 1715 */     GroupLayout jPanel38Layout = new GroupLayout(this.jPanel38);
/* 1716 */     this.jPanel38.setLayout(jPanel38Layout);
/* 1717 */     jPanel38Layout.setHorizontalGroup(jPanel38Layout
/* 1718 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1719 */         .addGroup(jPanel38Layout.createSequentialGroup()
/* 1720 */           .addContainerGap()
/* 1721 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1722 */             .addGroup(jPanel38Layout.createSequentialGroup()
/* 1723 */               .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1724 */                 .addComponent(this.jLabel23, -2, 680, -2)
/* 1725 */                 .addGroup(jPanel38Layout.createSequentialGroup()
/* 1726 */                   .addComponent(this.jLabel20, -2, 49, -2)
/* 1727 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1728 */                   .addComponent(this.jTextField4, -2, 125, -2)
/* 1729 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1730 */                   .addComponent(this.jLabel21, -2, 49, -2)
/* 1731 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1732 */                   .addComponent(this.jTextField11, -2, 125, -2)
/* 1733 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1734 */                   .addComponent(this.jLabel22, -2, 43, -2)
/* 1735 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1736 */                   .addComponent(this.jTextField12, -2, 125, -2)))
/* 1737 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 273, 32767))
/* 1738 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
/* 1739 */               .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1740 */                 .addComponent(this.jSeparator5, GroupLayout.Alignment.LEADING, -1, 953, 32767)
/* 1741 */                 .addComponent(this.jLabel19, -2, 851, -2))
/* 1742 */               .addGap(25, 25, 25)))
/* 1743 */           .addContainerGap(-1, 32767)));
/*      */     
/* 1745 */     jPanel38Layout.setVerticalGroup(jPanel38Layout
/* 1746 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1747 */         .addGroup(jPanel38Layout.createSequentialGroup()
/* 1748 */           .addComponent(this.jLabel19)
/* 1749 */           .addGap(23, 23, 23)
/* 1750 */           .addComponent(this.jSeparator5, -2, 10, -2)
/* 1751 */           .addGap(5, 5, 5)
/* 1752 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1753 */             .addComponent(this.jLabel20)
/* 1754 */             .addComponent(this.jLabel21)
/* 1755 */             .addComponent(this.jTextField11, -2, -1, -2)
/* 1756 */             .addComponent(this.jLabel22)
/* 1757 */             .addComponent(this.jTextField12, -2, -1, -2)
/* 1758 */             .addComponent(this.jTextField4, -2, -1, -2))
/* 1759 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1760 */           .addComponent(this.jLabel23)));
/*      */ 
/*      */     
/* 1763 */     this.jPanel35.setBackground(Color.white);
/*      */     
/* 1765 */     this.jLabel24.setHorizontalAlignment(4);
/* 1766 */     this.jLabel24.setText("Fecha:");
/*      */     
/* 1768 */     this.jDateChooser8.setDate(this.fechaActual);
/* 1769 */     this.jDateChooser8.setDateFormatString("dd/MM/yyyy");
/* 1770 */     this.jDateChooser8.setEnabled(false);
/* 1771 */     this.jDateChooser8.setIcon(this.icon);
/* 1772 */     this.jDateChooser8.setMaxSelectableDate(this.fecha);
/* 1773 */     this.jDateChooser8.setMinSelectableDate(new Date(1257058862000L));
/*      */     
/* 1775 */     this.jLabel25.setHorizontalAlignment(4);
/* 1776 */     this.jLabel25.setText("Ref:");
/*      */     
/* 1778 */     this.jTextField3.setEnabled(false);
/*      */     
/* 1780 */     this.jLabel57.setHorizontalAlignment(4);
/* 1781 */     this.jLabel57.setText("Factura:");
/*      */     
/* 1783 */     this.jTextField8.setEnabled(false);
/*      */     
/* 1785 */     GroupLayout jPanel35Layout = new GroupLayout(this.jPanel35);
/* 1786 */     this.jPanel35.setLayout(jPanel35Layout);
/* 1787 */     jPanel35Layout.setHorizontalGroup(jPanel35Layout
/* 1788 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1789 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
/* 1790 */           .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1791 */             .addComponent(this.jLabel25, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1792 */             .addComponent(this.jLabel24, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1793 */             .addComponent(this.jLabel57, -2, 59, -2))
/* 1794 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1795 */           .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1796 */             .addComponent((Component)this.jDateChooser8, -2, 108, -2)
/* 1797 */             .addComponent(this.jTextField3, -2, 94, -2)
/* 1798 */             .addComponent(this.jTextField8, -2, 94, -2))
/* 1799 */           .addContainerGap()));
/*      */     
/* 1801 */     jPanel35Layout.setVerticalGroup(jPanel35Layout
/* 1802 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1803 */         .addGroup(jPanel35Layout.createSequentialGroup()
/* 1804 */           .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1805 */             .addComponent(this.jLabel24, -1, -1, 32767)
/* 1806 */             .addComponent((Component)this.jDateChooser8, -2, -1, -2))
/* 1807 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1808 */           .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1809 */             .addComponent(this.jLabel25)
/* 1810 */             .addComponent(this.jTextField3, -2, -1, -2))
/* 1811 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1812 */           .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1813 */             .addComponent(this.jLabel57)
/* 1814 */             .addComponent(this.jTextField8, -2, -1, -2))
/* 1815 */           .addContainerGap(33, 32767)));
/*      */ 
/*      */     
/* 1818 */     this.jTable5.setFont(new Font("Tahoma", 0, 10));
/* 1819 */     this.jTable5.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[0]));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1827 */     this.jTable5.setColumnSelectionAllowed(true);
/* 1828 */     this.jTable5.setShowHorizontalLines(false);
/* 1829 */     this.jTable5.setShowVerticalLines(false);
/* 1830 */     this.jTable5.getTableHeader().setReorderingAllowed(false);
/* 1831 */     this.jScrollPane5.setViewportView(this.jTable5);
/* 1832 */     this.jTable5.getColumnModel().getSelectionModel().setSelectionMode(1);
/*      */     
/* 1834 */     this.jPanel40.setBackground(Color.white);
/*      */     
/* 1836 */     this.jPanel39.setBackground(Color.white);
/*      */     
/* 1838 */     this.jLabel63.setText("Comentario para esta prefactura:");
/*      */     
/* 1840 */     this.jPanel8.setBackground(new Color(255, 255, 255));
/* 1841 */     this.jPanel8.setBorder(BorderFactory.createEtchedBorder(new Color(0, 0, 0), null));
/*      */     
/* 1843 */     this.jLabel26.setHorizontalAlignment(4);
/* 1844 */     this.jLabel26.setText("Subtotal");
/*      */     
/* 1846 */     this.jLabel27.setFont(new Font("Tahoma", 1, 12));
/* 1847 */     this.jLabel27.setHorizontalAlignment(4);
/* 1848 */     this.jLabel27.setText("jLabel21");
/*      */     
/* 1850 */     this.jLabel28.setFont(new Font("Tahoma", 1, 12));
/* 1851 */     this.jLabel28.setHorizontalAlignment(4);
/* 1852 */     this.jLabel28.setText("jLabel21");
/*      */     
/* 1854 */     this.jLabel29.setHorizontalAlignment(4);
/* 1855 */     this.jLabel29.setText("Iva");
/*      */     
/* 1857 */     this.jLabel30.setHorizontalAlignment(4);
/* 1858 */     this.jLabel30.setText("Retencion");
/* 1859 */     this.jLabel30.setToolTipText("Cambiar retención");
/*      */     
/* 1861 */     this.jLabel31.setFont(new Font("Tahoma", 1, 12));
/* 1862 */     this.jLabel31.setHorizontalAlignment(4);
/* 1863 */     this.jLabel31.setText("jLabel21");
/*      */     
/* 1865 */     this.jLabel32.setHorizontalAlignment(4);
/* 1866 */     this.jLabel32.setText("Total");
/*      */     
/* 1868 */     this.jLabel33.setFont(new Font("Tahoma", 1, 12));
/* 1869 */     this.jLabel33.setHorizontalAlignment(4);
/* 1870 */     this.jLabel33.setText("jLabel21");
/*      */     
/* 1872 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 1873 */     this.jPanel8.setLayout(jPanel8Layout);
/* 1874 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/* 1875 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1876 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/* 1877 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1878 */             .addComponent(this.jSeparator6)
/* 1879 */             .addGroup(jPanel8Layout.createSequentialGroup()
/* 1880 */               .addContainerGap()
/* 1881 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1882 */                 .addGroup(jPanel8Layout.createSequentialGroup()
/* 1883 */                   .addComponent(this.jLabel26, -2, 80, -2)
/* 1884 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1885 */                   .addComponent(this.jLabel27, -2, 147, -2))
/* 1886 */                 .addGroup(jPanel8Layout.createSequentialGroup()
/* 1887 */                   .addComponent(this.jLabel29, -2, 80, -2)
/* 1888 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1889 */                   .addComponent(this.jLabel28, -2, 147, -2))
/* 1890 */                 .addGroup(jPanel8Layout.createSequentialGroup()
/* 1891 */                   .addComponent(this.jLabel30, -1, -1, 32767)
/* 1892 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1893 */                   .addComponent(this.jLabel31, -2, 147, -2))
/* 1894 */                 .addGroup(jPanel8Layout.createSequentialGroup()
/* 1895 */                   .addComponent(this.jLabel32, -2, 80, -2)
/* 1896 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1897 */                   .addComponent(this.jLabel33, -2, 147, -2)))))
/* 1898 */           .addContainerGap()));
/*      */     
/* 1900 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/* 1901 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1902 */         .addGroup(jPanel8Layout.createSequentialGroup()
/* 1903 */           .addContainerGap()
/* 1904 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1905 */             .addGroup(jPanel8Layout.createSequentialGroup()
/* 1906 */               .addGap(1, 1, 1)
/* 1907 */               .addComponent(this.jLabel26))
/* 1908 */             .addComponent(this.jLabel27))
/* 1909 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1910 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1911 */             .addGroup(jPanel8Layout.createSequentialGroup()
/* 1912 */               .addGap(1, 1, 1)
/* 1913 */               .addComponent(this.jLabel29))
/* 1914 */             .addComponent(this.jLabel28))
/* 1915 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1916 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1917 */             .addComponent(this.jLabel31)
/* 1918 */             .addGroup(jPanel8Layout.createSequentialGroup()
/* 1919 */               .addGap(1, 1, 1)
/* 1920 */               .addComponent(this.jLabel30)))
/* 1921 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1922 */           .addComponent(this.jSeparator6, -2, 5, -2)
/* 1923 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1924 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1925 */             .addComponent(this.jLabel33, -1, -1, 32767)
/* 1926 */             .addComponent(this.jLabel32, -1, 20, 32767))
/* 1927 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1930 */     this.jTextArea1.setColumns(20);
/* 1931 */     this.jTextArea1.setEditable(false);
/* 1932 */     this.jTextArea1.setFont(new Font("Monospaced", 0, 11));
/* 1933 */     this.jTextArea1.setLineWrap(true);
/* 1934 */     this.jTextArea1.setRows(5);
/* 1935 */     this.jScrollPane6.setViewportView(this.jTextArea1);
/*      */     
/* 1937 */     GroupLayout jPanel39Layout = new GroupLayout(this.jPanel39);
/* 1938 */     this.jPanel39.setLayout(jPanel39Layout);
/* 1939 */     jPanel39Layout.setHorizontalGroup(jPanel39Layout
/* 1940 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1941 */         .addGroup(jPanel39Layout.createSequentialGroup()
/* 1942 */           .addContainerGap()
/* 1943 */           .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1944 */             .addComponent(this.jLabel63, -2, 196, -2)
/* 1945 */             .addComponent(this.jScrollPane6, -2, 423, -2))
/* 1946 */           .addGap(112, 112, 112)
/* 1947 */           .addComponent(this.jPanel8, -2, -1, -2)));
/*      */     
/* 1949 */     jPanel39Layout.setVerticalGroup(jPanel39Layout
/* 1950 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1951 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
/* 1952 */           .addContainerGap()
/* 1953 */           .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1954 */             .addGroup(jPanel39Layout.createSequentialGroup()
/* 1955 */               .addComponent(this.jLabel63)
/* 1956 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1957 */               .addComponent(this.jScrollPane6)
/* 1958 */               .addContainerGap())
/* 1959 */             .addComponent(this.jPanel8, -2, -1, -2))));
/*      */ 
/*      */     
/* 1962 */     this.jPanel9.setBackground(Color.white);
/*      */     
/* 1964 */     this.jTextPane1.setEditable(false);
/* 1965 */     this.jTextPane1.setFont(new Font("Times New Roman", 0, 11));
/* 1966 */     this.jScrollPane7.setViewportView(this.jTextPane1);
/*      */     
/* 1968 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 1969 */     this.jPanel9.setLayout(jPanel9Layout);
/* 1970 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 1971 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1972 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 1973 */           .addComponent(this.jScrollPane7, -2, 353, -2)
/* 1974 */           .addContainerGap(-1, 32767)));
/*      */     
/* 1976 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 1977 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1978 */         .addComponent(this.jScrollPane7, -1, 121, 32767));
/*      */ 
/*      */     
/* 1981 */     GroupLayout jPanel40Layout = new GroupLayout(this.jPanel40);
/* 1982 */     this.jPanel40.setLayout(jPanel40Layout);
/* 1983 */     jPanel40Layout.setHorizontalGroup(jPanel40Layout
/* 1984 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1985 */         .addGroup(jPanel40Layout.createSequentialGroup()
/* 1986 */           .addComponent(this.jPanel9, -2, -1, -2)
/* 1987 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1988 */           .addComponent(this.jPanel39, -2, -1, -2)
/* 1989 */           .addContainerGap(-1, 32767)));
/*      */     
/* 1991 */     jPanel40Layout.setVerticalGroup(jPanel40Layout
/* 1992 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1993 */         .addGroup(jPanel40Layout.createSequentialGroup()
/* 1994 */           .addGroup(jPanel40Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1995 */             .addComponent(this.jPanel9, -2, -1, -2)
/* 1996 */             .addComponent(this.jPanel39, -2, -1, -2))
/* 1997 */           .addContainerGap(18, 32767)));
/*      */ 
/*      */     
/* 2000 */     this.jPanel41.setBackground(Color.white);
/*      */     
/* 2002 */     this.jTable12.setFont(new Font("Tahoma", 0, 10));
/* 2003 */     this.jTable12.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Cant", "Concepto", "P Unitario", "Importe" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2011 */           boolean[] canEdit = new boolean[] { false, false, false, true };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2016 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2019 */     this.jTable12.setShowVerticalLines(false);
/* 2020 */     this.jScrollPane14.setViewportView(this.jTable12);
/*      */     
/* 2022 */     this.jLabel91.setFont(new Font("Tahoma", 2, 11));
/* 2023 */     this.jLabel91.setText("/*A continuación se despliegan otros conceptos como tiempos de espera, movimientos laterales, movimientos internos, entre otros.*/");
/*      */     
/* 2025 */     GroupLayout jPanel41Layout = new GroupLayout(this.jPanel41);
/* 2026 */     this.jPanel41.setLayout(jPanel41Layout);
/* 2027 */     jPanel41Layout.setHorizontalGroup(jPanel41Layout
/* 2028 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2029 */         .addGroup(jPanel41Layout.createSequentialGroup()
/* 2030 */           .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2031 */             .addComponent(this.jLabel91, -2, 668, -2)
/* 2032 */             .addComponent(this.jScrollPane14))
/* 2033 */           .addContainerGap()));
/*      */     
/* 2035 */     jPanel41Layout.setVerticalGroup(jPanel41Layout
/* 2036 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2037 */         .addGroup(jPanel41Layout.createSequentialGroup()
/* 2038 */           .addContainerGap()
/* 2039 */           .addComponent(this.jLabel91)
/* 2040 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2041 */           .addComponent(this.jScrollPane14, -1, 155, 32767)));
/*      */ 
/*      */     
/* 2044 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 2045 */     this.jPanel7.setLayout(jPanel7Layout);
/* 2046 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/* 2047 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2048 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 2049 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2050 */             .addGroup(jPanel7Layout.createSequentialGroup()
/* 2051 */               .addContainerGap()
/* 2052 */               .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2053 */                 .addComponent(this.jPanel41, -1, -1, 32767)
/* 2054 */                 .addComponent(this.jPanel40, -2, -1, -2)))
/* 2055 */             .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2056 */               .addGroup(GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
/* 2057 */                 .addComponent(this.jPanel38, -2, 976, -2)
/* 2058 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2059 */                 .addComponent(this.jPanel35, -2, -1, -2))
/* 2060 */               .addGroup(GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
/* 2061 */                 .addContainerGap()
/* 2062 */                 .addComponent(this.jScrollPane5, -2, 1179, -2))))
/* 2063 */           .addGap(273, 273, 273)));
/*      */     
/* 2065 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/* 2066 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2067 */         .addGroup(jPanel7Layout.createSequentialGroup()
/* 2068 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2069 */             .addComponent(this.jPanel38, -2, -1, -2)
/* 2070 */             .addComponent(this.jPanel35, -2, -1, -2))
/* 2071 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2072 */           .addComponent(this.jScrollPane5, -1, 157, 32767)
/* 2073 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2074 */           .addComponent(this.jPanel41, -2, -1, -2)
/* 2075 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2076 */           .addComponent(this.jPanel40, -2, -1, -2)));
/*      */ 
/*      */     
/* 2079 */     GroupLayout jDialog9Layout = new GroupLayout(this.jDialog9.getContentPane());
/* 2080 */     this.jDialog9.getContentPane().setLayout(jDialog9Layout);
/* 2081 */     jDialog9Layout.setHorizontalGroup(jDialog9Layout
/* 2082 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2083 */         .addComponent(this.jPanel7, -1, 1201, 32767));
/*      */     
/* 2085 */     jDialog9Layout.setVerticalGroup(jDialog9Layout
/* 2086 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2087 */         .addComponent(this.jPanel7, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/*      */ 
/*      */     
/* 2090 */     this.jDialog10.setTitle("Catálogo conceptos");
/*      */     
/* 2092 */     this.jPanel48.setBackground(Color.white);
/*      */     
/* 2094 */     this.jPanel49.setBackground(Color.white);
/* 2095 */     this.jPanel49.setBorder(BorderFactory.createTitledBorder("Crear nuevo concepto"));
/* 2096 */     this.jPanel49.setLayout(new GridLayout(3, 0, 0, 6));
/*      */     
/* 2098 */     this.jPanel50.setBackground(Color.white);
/*      */     
/* 2100 */     this.jLabel50.setText("Cliente");
/*      */     
/* 2102 */     this.jComboBox18.setBackground(new Color(244, 244, 244));
/* 2103 */     this.jComboBox18.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/* 2104 */     this.jComboBox18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2106 */             Facturas.this.jComboBox18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2110 */     GroupLayout jPanel50Layout = new GroupLayout(this.jPanel50);
/* 2111 */     this.jPanel50.setLayout(jPanel50Layout);
/* 2112 */     jPanel50Layout.setHorizontalGroup(jPanel50Layout
/* 2113 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2114 */         .addGroup(jPanel50Layout.createSequentialGroup()
/* 2115 */           .addComponent(this.jLabel50, -2, 85, -2)
/* 2116 */           .addGap(18, 18, 18)
/* 2117 */           .addComponent(this.jComboBox18, 0, 663, 32767)));
/*      */     
/* 2119 */     jPanel50Layout.setVerticalGroup(jPanel50Layout
/* 2120 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2121 */         .addGroup(jPanel50Layout.createSequentialGroup()
/* 2122 */           .addGroup(jPanel50Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2123 */             .addComponent(this.jLabel50, -2, 26, -2)
/* 2124 */             .addComponent(this.jComboBox18, -2, -1, -2))
/* 2125 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/* 2128 */     this.jPanel49.add(this.jPanel50);
/*      */     
/* 2130 */     this.jPanel51.setLayout(new GridLayout(1, 0));
/*      */     
/* 2132 */     this.jPanel58.setBackground(Color.white);
/* 2133 */     this.jPanel58.setLayout(new GridLayout(1, 4, 6, 6));
/*      */     
/* 2135 */     this.jLabel56.setText("Clave");
/* 2136 */     this.jPanel58.add(this.jLabel56);
/*      */     
/* 2138 */     this.jTextField9.setHorizontalAlignment(4);
/* 2139 */     this.jPanel58.add(this.jTextField9);
/*      */     
/* 2141 */     this.jLabel53.setHorizontalAlignment(4);
/* 2142 */     this.jLabel53.setText("Unidad");
/* 2143 */     this.jPanel58.add(this.jLabel53);
/* 2144 */     this.jPanel58.add(this.jTextField46);
/*      */     
/* 2146 */     this.jPanel51.add(this.jPanel58);
/*      */     
/* 2148 */     this.jPanel95.setBackground(Color.white);
/*      */     
/* 2150 */     this.jLabel49.setHorizontalAlignment(4);
/* 2151 */     this.jLabel49.setText("Concepto");
/*      */     
/* 2153 */     this.jTextField29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2155 */             Facturas.this.jTextField29ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2159 */     GroupLayout jPanel95Layout = new GroupLayout(this.jPanel95);
/* 2160 */     this.jPanel95.setLayout(jPanel95Layout);
/* 2161 */     jPanel95Layout.setHorizontalGroup(jPanel95Layout
/* 2162 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2163 */         .addGroup(jPanel95Layout.createSequentialGroup()
/* 2164 */           .addGap(21, 21, 21)
/* 2165 */           .addComponent(this.jLabel49, -2, 75, -2)
/* 2166 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2167 */           .addComponent(this.jTextField29, -1, 275, 32767)));
/*      */     
/* 2169 */     jPanel95Layout.setVerticalGroup(jPanel95Layout
/* 2170 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2171 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel95Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2172 */           .addComponent(this.jLabel49, -1, -1, 32767)
/* 2173 */           .addComponent(this.jTextField29, -2, -1, -2)));
/*      */ 
/*      */     
/* 2176 */     this.jPanel51.add(this.jPanel95);
/*      */     
/* 2178 */     this.jPanel49.add(this.jPanel51);
/*      */     
/* 2180 */     this.jPanel52.setBackground(Color.white);
/*      */     
/* 2182 */     this.jLabel55.setText("Cantidad");
/*      */     
/* 2184 */     this.jFormattedTextField5.setHorizontalAlignment(4);
/*      */     
/* 2186 */     this.jButton12.setMnemonic('A');
/* 2187 */     this.jButton12.setText("Agregar");
/* 2188 */     this.jButton12.setToolTipText("Agregar (Alt+A)");
/* 2189 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2191 */             Facturas.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2195 */     GroupLayout jPanel52Layout = new GroupLayout(this.jPanel52);
/* 2196 */     this.jPanel52.setLayout(jPanel52Layout);
/* 2197 */     jPanel52Layout.setHorizontalGroup(jPanel52Layout
/* 2198 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2199 */         .addGroup(jPanel52Layout.createSequentialGroup()
/* 2200 */           .addComponent(this.jLabel55, -2, 64, -2)
/* 2201 */           .addGap(37, 37, 37)
/* 2202 */           .addComponent(this.jFormattedTextField5, -2, 96, -2)
/* 2203 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 459, 32767)
/* 2204 */           .addComponent(this.jButton12, -2, 110, -2)));
/*      */     
/* 2206 */     jPanel52Layout.setVerticalGroup(jPanel52Layout
/* 2207 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2208 */         .addGroup(jPanel52Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2209 */           .addComponent(this.jLabel55, -1, -1, 32767)
/* 2210 */           .addComponent(this.jFormattedTextField5, -2, -1, -2)
/* 2211 */           .addComponent(this.jButton12)));
/*      */ 
/*      */     
/* 2214 */     this.jPanel49.add(this.jPanel52);
/*      */     
/* 2216 */     this.jPanel97.setBackground(Color.white);
/* 2217 */     this.jPanel97.setBorder(BorderFactory.createTitledBorder("Lista de conceptos"));
/*      */     
/* 2219 */     this.jTable6.setFont(new Font("Tahoma", 0, 10));
/* 2220 */     this.jTable6.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2228 */     this.jTable6.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2230 */             Facturas.this.jTable6MouseClicked(evt);
/*      */           }
/*      */         });
/* 2233 */     this.jScrollPane8.setViewportView(this.jTable6);
/*      */     
/* 2235 */     this.jLabel128.setText("Clave");
/*      */     
/* 2237 */     this.jTextField54.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2239 */             Facturas.this.jTextField54KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2243 */     this.jButton14.setMnemonic('G');
/* 2244 */     this.jButton14.setText("Guardar en archivo");
/* 2245 */     this.jButton14.setToolTipText("Guardar (Alt+G)");
/* 2246 */     this.jButton14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2248 */             Facturas.this.jButton14ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2252 */     this.jButton20.setMnemonic('M');
/* 2253 */     this.jButton20.setText("Modificar");
/* 2254 */     this.jButton20.setToolTipText("Modificar (Alt+M)");
/* 2255 */     this.jButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2257 */             Facturas.this.jButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2261 */     this.jButton13.setMnemonic('E');
/* 2262 */     this.jButton13.setText("Eliminar");
/* 2263 */     this.jButton13.setToolTipText("Eliminar (Alt+E)");
/* 2264 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2266 */             Facturas.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2270 */     this.jLabel153.setHorizontalAlignment(4);
/* 2271 */     this.jLabel153.setText("Concepto");
/*      */     
/* 2273 */     this.jTextField55.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2275 */             Facturas.this.jTextField55KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 2279 */     GroupLayout jPanel97Layout = new GroupLayout(this.jPanel97);
/* 2280 */     this.jPanel97.setLayout(jPanel97Layout);
/* 2281 */     jPanel97Layout.setHorizontalGroup(jPanel97Layout
/* 2282 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2283 */         .addComponent(this.jScrollPane8)
/* 2284 */         .addGroup(jPanel97Layout.createSequentialGroup()
/* 2285 */           .addComponent(this.jLabel128, -2, 64, -2)
/* 2286 */           .addGap(38, 38, 38)
/* 2287 */           .addComponent(this.jTextField54, -2, 94, -2)
/* 2288 */           .addGap(29, 29, 29)
/* 2289 */           .addComponent(this.jLabel153, -2, 64, -2)
/* 2290 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2291 */           .addComponent(this.jTextField55))
/* 2292 */         .addGroup(jPanel97Layout.createSequentialGroup()
/* 2293 */           .addComponent(this.jButton14, -2, 114, -2)
/* 2294 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2295 */           .addComponent(this.jButton13, -2, 112, -2)
/* 2296 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2297 */           .addComponent(this.jButton20, -2, 112, -2)));
/*      */     
/* 2299 */     jPanel97Layout.setVerticalGroup(jPanel97Layout
/* 2300 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2301 */         .addGroup(jPanel97Layout.createSequentialGroup()
/* 2302 */           .addGroup(jPanel97Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2303 */             .addComponent(this.jLabel128, -1, -1, 32767)
/* 2304 */             .addComponent(this.jTextField54, -2, -1, -2)
/* 2305 */             .addComponent(this.jLabel153, -1, -1, 32767)
/* 2306 */             .addComponent(this.jTextField55, -2, -1, -2))
/* 2307 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2308 */           .addComponent(this.jScrollPane8, -2, 212, -2)
/* 2309 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2310 */           .addGroup(jPanel97Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2311 */             .addGroup(jPanel97Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2312 */               .addComponent(this.jButton20)
/* 2313 */               .addComponent(this.jButton13))
/* 2314 */             .addComponent(this.jButton14, GroupLayout.Alignment.TRAILING))
/* 2315 */           .addGap(8, 8, 8)));
/*      */ 
/*      */     
/* 2318 */     this.jButton11.setMnemonic('C');
/* 2319 */     this.jButton11.setText("Cerrar");
/* 2320 */     this.jButton11.setToolTipText("Cerrar (Alt+C)");
/* 2321 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2323 */             Facturas.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2327 */     GroupLayout jPanel48Layout = new GroupLayout(this.jPanel48);
/* 2328 */     this.jPanel48.setLayout(jPanel48Layout);
/* 2329 */     jPanel48Layout.setHorizontalGroup(jPanel48Layout
/* 2330 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2331 */         .addComponent(this.jPanel49, -1, -1, 32767)
/* 2332 */         .addComponent(this.jPanel97, -1, -1, 32767)
/* 2333 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
/* 2334 */           .addGap(0, 0, 32767)
/* 2335 */           .addComponent(this.jButton11, -2, 112, -2)));
/*      */     
/* 2337 */     jPanel48Layout.setVerticalGroup(jPanel48Layout
/* 2338 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2339 */         .addGroup(jPanel48Layout.createSequentialGroup()
/* 2340 */           .addComponent(this.jPanel49, -2, -1, -2)
/* 2341 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2342 */           .addComponent(this.jPanel97, -1, -1, 32767)
/* 2343 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2344 */           .addComponent(this.jButton11)
/* 2345 */           .addContainerGap()));
/*      */ 
/*      */     
/* 2348 */     GroupLayout jDialog10Layout = new GroupLayout(this.jDialog10.getContentPane());
/* 2349 */     this.jDialog10.getContentPane().setLayout(jDialog10Layout);
/* 2350 */     jDialog10Layout.setHorizontalGroup(jDialog10Layout
/* 2351 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2352 */         .addComponent(this.jPanel48, -1, -1, 32767));
/*      */     
/* 2354 */     jDialog10Layout.setVerticalGroup(jDialog10Layout
/* 2355 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2356 */         .addComponent(this.jPanel48, -1, -1, 32767));
/*      */ 
/*      */     
/* 2359 */     this.jDialog11.setTitle("Factura");
/*      */     
/* 2361 */     this.jPanel90.setBackground(Color.white);
/* 2362 */     this.jPanel90.setPreferredSize(new Dimension(920, 1600));
/*      */     
/* 2364 */     this.jPanel59.setBackground(Color.white);
/* 2365 */     this.jPanel59.setBorder(BorderFactory.createTitledBorder("Datos de la factura"));
/* 2366 */     this.jPanel59.setMaximumSize(new Dimension(920, 51));
/* 2367 */     this.jPanel59.setPreferredSize(new Dimension(920, 51));
/* 2368 */     this.jPanel59.setLayout(new GridLayout(1, 6, 6, 0));
/*      */     
/* 2370 */     this.jLabel78.setFont(new Font("Tahoma", 1, 11));
/* 2371 */     this.jLabel78.setText("Folio:");
/* 2372 */     this.jPanel59.add(this.jLabel78);
/* 2373 */     this.jPanel59.add(this.jTextField18);
/*      */     
/* 2375 */     this.jLabel85.setFont(new Font("Tahoma", 1, 11));
/* 2376 */     this.jLabel85.setText("Fecha:");
/* 2377 */     this.jPanel59.add(this.jLabel85);
/*      */     
/* 2379 */     this.jDateChooser6.setDate(this.fechaActual);
/* 2380 */     this.jDateChooser6.setDateFormatString("dd/MM/yyyy");
/* 2381 */     this.jDateChooser6.setEnabled(false);
/* 2382 */     this.jDateChooser6.setIcon(this.icon);
/* 2383 */     this.jDateChooser6.setMinSelectableDate(new Date(1257058862000L));
/* 2384 */     this.jPanel59.add((Component)this.jDateChooser6);
/*      */     
/* 2386 */     this.jLabel88.setFont(new Font("Tahoma", 1, 11));
/* 2387 */     this.jLabel88.setText("Sucursal:");
/* 2388 */     this.jPanel59.add(this.jLabel88);
/* 2389 */     this.jPanel59.add(this.jTextField19);
/*      */     
/* 2391 */     this.jPanel56.setBackground(Color.white);
/* 2392 */     this.jPanel56.setBorder(BorderFactory.createTitledBorder("Datos del cliente"));
/* 2393 */     this.jPanel56.setMaximumSize(new Dimension(920, 152));
/* 2394 */     this.jPanel56.setPreferredSize(new Dimension(920, 152));
/*      */     
/* 2396 */     this.jPanel57.setBackground(Color.white);
/*      */     
/* 2398 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 2399 */     this.jComboBox1.setEnabled(false);
/* 2400 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2402 */             Facturas.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2406 */     this.jLabel93.setFont(new Font("Tahoma", 1, 11));
/* 2407 */     this.jLabel93.setText("RFC:");
/*      */     
/* 2409 */     this.jTextField17.setText("rfc");
/*      */     
/* 2411 */     this.jLabel16.setFont(new Font("Tahoma", 1, 11));
/* 2412 */     this.jLabel16.setText("Cliente:");
/*      */     
/* 2414 */     GroupLayout jPanel57Layout = new GroupLayout(this.jPanel57);
/* 2415 */     this.jPanel57.setLayout(jPanel57Layout);
/* 2416 */     jPanel57Layout.setHorizontalGroup(jPanel57Layout
/* 2417 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2418 */         .addGroup(jPanel57Layout.createSequentialGroup()
/* 2419 */           .addComponent(this.jLabel16, -2, 82, -2)
/* 2420 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2421 */           .addComponent(this.jComboBox1, 0, -1, 32767)
/* 2422 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2423 */           .addComponent(this.jLabel93, -2, 72, -2)
/* 2424 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2425 */           .addComponent(this.jTextField17, -2, 133, -2)
/* 2426 */           .addContainerGap()));
/*      */     
/* 2428 */     jPanel57Layout.setVerticalGroup(jPanel57Layout
/* 2429 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2430 */         .addGroup(jPanel57Layout.createSequentialGroup()
/* 2431 */           .addGroup(jPanel57Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2432 */             .addComponent(this.jComboBox1, -2, -1, -2)
/* 2433 */             .addComponent(this.jLabel93)
/* 2434 */             .addComponent(this.jTextField17, -2, -1, -2)
/* 2435 */             .addComponent(this.jLabel16))
/* 2436 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/* 2439 */     this.jPanel60.setBackground(Color.white);
/* 2440 */     this.jPanel60.setLayout(new GridLayout(3, 6, 6, 6));
/*      */     
/* 2442 */     this.jLabel71.setText("Calle:");
/* 2443 */     this.jPanel60.add(this.jLabel71);
/*      */     
/* 2445 */     this.jTextField10.setText("cal");
/* 2446 */     this.jPanel60.add(this.jTextField10);
/*      */     
/* 2448 */     this.jLabel89.setText("Num:");
/* 2449 */     this.jPanel60.add(this.jLabel89);
/*      */     
/* 2451 */     this.jTextField13.setText("num");
/* 2452 */     this.jPanel60.add(this.jTextField13);
/*      */     
/* 2454 */     this.jLabel90.setText("Colonia:");
/* 2455 */     this.jPanel60.add(this.jLabel90);
/*      */     
/* 2457 */     this.jTextField14.setText("col");
/* 2458 */     this.jPanel60.add(this.jTextField14);
/*      */     
/* 2460 */     this.jLabel74.setText("Ciudad:");
/* 2461 */     this.jPanel60.add(this.jLabel74);
/*      */     
/* 2463 */     this.jTextField16.setText("cd");
/* 2464 */     this.jPanel60.add(this.jTextField16);
/*      */     
/* 2466 */     this.jLabel73.setText("C.P.:");
/* 2467 */     this.jPanel60.add(this.jLabel73);
/*      */     
/* 2469 */     this.jTextField15.setText("cp");
/* 2470 */     this.jPanel60.add(this.jTextField15);
/*      */     
/* 2472 */     this.jLabel92.setFont(new Font("Tahoma", 1, 11));
/* 2473 */     this.jLabel92.setText("Estado:");
/* 2474 */     this.jPanel60.add(this.jLabel92);
/*      */     
/* 2476 */     this.jComboBox9.setBackground(new Color(244, 244, 244));
/* 2477 */     this.jComboBox9.setFont(new Font("Tahoma", 0, 10));
/* 2478 */     this.jComboBox9.setModel(new DefaultComboBoxModel<>(new String[] { "AGUAS CALIENTES", "BAJA CALIFORNIA NORTE", "BAJA CALIFORNIA SUR", "CAMPECHE", "COAHUILA", "COLIMA", "CHIAPAS", "CHIHUAHUA", "DISTRITO FEDERAL", "DURANGO", "GUANAJUATO", "GUERRERO", "HIDALGO", "JALISCO", "MÉXICO", "MICHOACÁN", "MORELOS", "NAYARIT", "NUEVO LEÓN", "OAXACA", "PUEBLA", "QUERETARO", "QUINTANA ROO", "SAN LUIS POTOSÍ", "SINALOA", "SONORA", "TABASCO", "TAMAULIPAS", "TLAXCALA", "VERACRUZ", "YUCATÁN", "ZACATECAS", "CIUDAD DE MEXICO" }));
/* 2479 */     this.jPanel60.add(this.jComboBox9);
/*      */     
/* 2481 */     this.jLabel76.setText("Su pedido:");
/* 2482 */     this.jPanel60.add(this.jLabel76);
/*      */     
/* 2484 */     this.jTextField20.setText("pedi");
/* 2485 */     this.jPanel60.add(this.jTextField20);
/*      */     
/* 2487 */     this.jPanel63.setBackground(Color.white);
/*      */     
/* 2489 */     GroupLayout jPanel63Layout = new GroupLayout(this.jPanel63);
/* 2490 */     this.jPanel63.setLayout(jPanel63Layout);
/* 2491 */     jPanel63Layout.setHorizontalGroup(jPanel63Layout
/* 2492 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2493 */         .addGap(0, 146, 32767));
/*      */     
/* 2495 */     jPanel63Layout.setVerticalGroup(jPanel63Layout
/* 2496 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2497 */         .addGap(0, 29, 32767));
/*      */ 
/*      */     
/* 2500 */     this.jPanel60.add(this.jPanel63);
/*      */     
/* 2502 */     this.jPanel62.setBackground(Color.white);
/*      */     
/* 2504 */     GroupLayout jPanel62Layout = new GroupLayout(this.jPanel62);
/* 2505 */     this.jPanel62.setLayout(jPanel62Layout);
/* 2506 */     jPanel62Layout.setHorizontalGroup(jPanel62Layout
/* 2507 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2508 */         .addGap(0, 146, 32767));
/*      */     
/* 2510 */     jPanel62Layout.setVerticalGroup(jPanel62Layout
/* 2511 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2512 */         .addGap(0, 29, 32767));
/*      */ 
/*      */     
/* 2515 */     this.jPanel60.add(this.jPanel62);
/*      */     
/* 2517 */     GroupLayout jPanel56Layout = new GroupLayout(this.jPanel56);
/* 2518 */     this.jPanel56.setLayout(jPanel56Layout);
/* 2519 */     jPanel56Layout.setHorizontalGroup(jPanel56Layout
/* 2520 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2521 */         .addComponent(this.jPanel57, -1, -1, 32767)
/* 2522 */         .addComponent(this.jPanel60, -2, 910, 32767));
/*      */     
/* 2524 */     jPanel56Layout.setVerticalGroup(jPanel56Layout
/* 2525 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2526 */         .addGroup(jPanel56Layout.createSequentialGroup()
/* 2527 */           .addComponent(this.jPanel57, -2, -1, -2)
/* 2528 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2529 */           .addComponent(this.jPanel60, -1, -1, 32767)));
/*      */ 
/*      */     
/* 2532 */     this.jPanel61.setBackground(Color.white);
/* 2533 */     this.jPanel61.setBorder(BorderFactory.createTitledBorder("Datos de la factura"));
/* 2534 */     this.jPanel61.setMaximumSize(new Dimension(920, 118));
/* 2535 */     this.jPanel61.setPreferredSize(new Dimension(920, 118));
/* 2536 */     this.jPanel61.setLayout(new GridLayout(3, 6, 6, 6));
/*      */     
/* 2538 */     this.jLabel72.setText("Nuestro ped:");
/* 2539 */     this.jPanel61.add(this.jLabel72);
/*      */     
/* 2541 */     this.jComboBox20.setEditable(true);
/* 2542 */     this.jPanel61.add(this.jComboBox20);
/*      */     
/* 2544 */     this.jLabel98.setFont(new Font("Tahoma", 1, 11));
/* 2545 */     this.jLabel98.setText("Zona:");
/* 2546 */     this.jPanel61.add(this.jLabel98);
/* 2547 */     this.jPanel61.add(this.jTextField22);
/*      */     
/* 2549 */     this.jLabel99.setFont(new Font("Tahoma", 1, 11));
/* 2550 */     this.jLabel99.setText("Condiciones:");
/* 2551 */     this.jPanel61.add(this.jLabel99);
/*      */     
/* 2553 */     this.jComboBox13.setEditable(true);
/* 2554 */     this.jComboBox13.setModel(new DefaultComboBoxModel<>(new String[] { "CREDITO A 30 DIAS", "CREDITO A 45 DIAS", "CREDITO A 60 DIAS" }));
/* 2555 */     this.jPanel61.add(this.jComboBox13);
/*      */     
/* 2557 */     this.jLabel75.setFont(new Font("Tahoma", 1, 11));
/* 2558 */     this.jLabel75.setText("F. de pago:");
/* 2559 */     this.jPanel61.add(this.jLabel75);
/*      */     
/* 2561 */     this.jComboBox14.setBackground(new Color(244, 244, 244));
/* 2562 */     this.jComboBox14.setModel(new DefaultComboBoxModel<>(new String[] { "PUE-PAGO EN UNA SOLA EXHIBICION", "PPD-PAGO EN PARCIALIDADES" }));
/* 2563 */     this.jComboBox14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2565 */             Facturas.this.jComboBox14ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2568 */     this.jPanel61.add(this.jComboBox14);
/*      */     
/* 2570 */     this.jLabel80.setText("¿Es principal?");
/* 2571 */     this.jPanel61.add(this.jLabel80);
/*      */     
/* 2573 */     this.jPanel55.setBackground(Color.white);
/* 2574 */     this.jPanel55.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 2576 */     this.jRadioButton1.setSelected(true);
/* 2577 */     this.jRadioButton1.setText("Si");
/* 2578 */     this.jPanel55.add(this.jRadioButton1);
/*      */     
/* 2580 */     this.jRadioButton2.setText("No");
/* 2581 */     this.jPanel55.add(this.jRadioButton2);
/*      */     
/* 2583 */     this.jPanel61.add(this.jPanel55);
/*      */     
/* 2585 */     this.jLabel100.setText("No de partes:");
/* 2586 */     this.jPanel61.add(this.jLabel100);
/*      */     
/* 2588 */     this.jSpinner1.setModel(new SpinnerNumberModel(0, 0, 100, 1));
/* 2589 */     this.jPanel61.add(this.jSpinner1);
/*      */     
/* 2591 */     this.jLabel77.setFont(new Font("Tahoma", 1, 11));
/* 2592 */     this.jLabel77.setText("M. de pago:");
/* 2593 */     this.jPanel61.add(this.jLabel77);
/*      */     
/* 2595 */     this.jComboBox17.setBackground(new Color(244, 244, 244));
/* 2596 */     this.jComboBox17.setModel(new DefaultComboBoxModel<>(new String[] { "01.- EFECTIVO", "02.- CHEQUE NOMINATIVO", "03.- TRANSFERENCIA ELECTRONICA DE FONDOS", "04.- TARJETA DE CREDITO", "05.- MONEDERO ELECTRONICO", "06.- DINERO ELECTRONICO", "08.- VALES DE DESPENSA", "28.- TARJETA DE DEBITO", "29.- TARJETA DE SERVICIO", "98.- NA", "99.- OTROS" }));
/* 2597 */     this.jPanel61.add(this.jComboBox17);
/*      */     
/* 2599 */     this.jLabel81.setFont(new Font("Tahoma", 1, 11));
/* 2600 */     this.jLabel81.setText("Banco:");
/* 2601 */     this.jPanel61.add(this.jLabel81);
/*      */     
/* 2603 */     this.jComboBox19.setEditable(true);
/* 2604 */     this.jPanel61.add(this.jComboBox19);
/*      */     
/* 2606 */     this.jLabel102.setFont(new Font("Tahoma", 1, 11));
/* 2607 */     this.jLabel102.setText("Cuenta");
/* 2608 */     this.jPanel61.add(this.jLabel102);
/*      */     
/* 2610 */     this.jComboBox15.setEditable(true);
/* 2611 */     this.jPanel61.add(this.jComboBox15);
/*      */     
/* 2613 */     this.jPanel87.setBackground(Color.white);
/* 2614 */     this.jPanel87.setBorder(BorderFactory.createTitledBorder("Otros datos"));
/* 2615 */     this.jPanel87.setMaximumSize(new Dimension(920, 111));
/* 2616 */     this.jPanel87.setMinimumSize(new Dimension(920, 0));
/* 2617 */     this.jPanel87.setPreferredSize(new Dimension(920, 111));
/*      */     
/* 2619 */     this.jPanel89.setBackground(Color.white);
/* 2620 */     GridBagLayout jPanel89Layout = new GridBagLayout();
/* 2621 */     jPanel89Layout.columnWidths = new int[] { 0, 5, 0, 5, 0, 5, 0 };
/* 2622 */     jPanel89Layout.rowHeights = new int[] { 0, 5, 0 };
/* 2623 */     this.jPanel89.setLayout(jPanel89Layout);
/*      */     
/* 2625 */     this.jLabel143.setText("Leyenda 1:");
/* 2626 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/* 2627 */     gridBagConstraints.gridx = 0;
/* 2628 */     gridBagConstraints.gridy = 0;
/* 2629 */     this.jPanel89.add(this.jLabel143, gridBagConstraints);
/* 2630 */     gridBagConstraints = new GridBagConstraints();
/* 2631 */     gridBagConstraints.gridx = 2;
/* 2632 */     gridBagConstraints.gridy = 0;
/* 2633 */     gridBagConstraints.gridwidth = 5;
/* 2634 */     gridBagConstraints.fill = 2;
/* 2635 */     gridBagConstraints.weightx = 1.0D;
/* 2636 */     this.jPanel89.add(this.jTextField24, gridBagConstraints);
/*      */     
/* 2638 */     this.jLabel144.setText("Leyenda 2:");
/* 2639 */     gridBagConstraints = new GridBagConstraints();
/* 2640 */     gridBagConstraints.gridx = 0;
/* 2641 */     gridBagConstraints.gridy = 2;
/* 2642 */     this.jPanel89.add(this.jLabel144, gridBagConstraints);
/* 2643 */     gridBagConstraints = new GridBagConstraints();
/* 2644 */     gridBagConstraints.gridx = 2;
/* 2645 */     gridBagConstraints.gridy = 2;
/* 2646 */     gridBagConstraints.gridwidth = 5;
/* 2647 */     gridBagConstraints.fill = 2;
/* 2648 */     gridBagConstraints.weightx = 1.0D;
/* 2649 */     this.jPanel89.add(this.jTextField26, gridBagConstraints);
/*      */     
/* 2651 */     this.jPanel65.setBackground(Color.white);
/* 2652 */     this.jPanel65.setMaximumSize(new Dimension(500, 20));
/* 2653 */     this.jPanel65.setPreferredSize(new Dimension(500, 26));
/* 2654 */     this.jPanel65.setLayout(new GridLayout(1, 6, 6, 0));
/*      */     
/* 2656 */     this.jLabel169.setFont(new Font("Tahoma", 1, 11));
/* 2657 */     this.jLabel169.setText("Uso del CFDI:");
/* 2658 */     this.jPanel65.add(this.jLabel169);
/*      */     
/* 2660 */     this.jPanel103.setBackground(new Color(255, 255, 255));
/*      */     
/* 2662 */     this.jButton34.setBackground(new Color(255, 255, 255));
/* 2663 */     this.jButton34.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/arrow-right-otra (copia).png")));
/* 2664 */     this.jButton34.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2666 */             Facturas.this.jButton34ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 2670 */     GroupLayout jPanel103Layout = new GroupLayout(this.jPanel103);
/* 2671 */     this.jPanel103.setLayout(jPanel103Layout);
/* 2672 */     jPanel103Layout.setHorizontalGroup(jPanel103Layout
/* 2673 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2674 */         .addGroup(jPanel103Layout.createSequentialGroup()
/* 2675 */           .addComponent(this.jTextField71, -1, 117, 32767)
/* 2676 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2677 */           .addComponent(this.jButton34, -2, 23, -2)));
/*      */     
/* 2679 */     jPanel103Layout.setVerticalGroup(jPanel103Layout
/* 2680 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2681 */         .addComponent(this.jTextField71, -1, 26, 32767)
/* 2682 */         .addComponent(this.jButton34, -1, -1, 32767));
/*      */ 
/*      */     
/* 2685 */     this.jPanel65.add(this.jPanel103);
/*      */     
/* 2687 */     this.jLabel105.setText("Plataforma:");
/* 2688 */     this.jPanel65.add(this.jLabel105);
/*      */     
/* 2690 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/* 2691 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/* 2692 */     this.jPanel65.add(this.jComboBox4);
/*      */     
/* 2694 */     this.jLabel140.setText("Pozo:");
/* 2695 */     this.jPanel65.add(this.jLabel140);
/*      */     
/* 2697 */     this.jComboBox12.setBackground(new Color(244, 244, 244));
/* 2698 */     this.jComboBox12.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/* 2699 */     this.jPanel65.add(this.jComboBox12);
/*      */     
/* 2701 */     GroupLayout jPanel87Layout = new GroupLayout(this.jPanel87);
/* 2702 */     this.jPanel87.setLayout(jPanel87Layout);
/* 2703 */     jPanel87Layout.setHorizontalGroup(jPanel87Layout
/* 2704 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2705 */         .addComponent(this.jPanel89, -1, -1, 32767)
/* 2706 */         .addComponent(this.jPanel65, -2, 910, -2));
/*      */     
/* 2708 */     jPanel87Layout.setVerticalGroup(jPanel87Layout
/* 2709 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2710 */         .addGroup(jPanel87Layout.createSequentialGroup()
/* 2711 */           .addComponent(this.jPanel65, -2, -1, -2)
/* 2712 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2713 */           .addComponent(this.jPanel89, -2, -1, -2)
/* 2714 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 2717 */     this.jPanel67.setBackground(Color.white);
/* 2718 */     this.jPanel67.setBorder(BorderFactory.createTitledBorder("Parcialidades"));
/* 2719 */     this.jPanel67.setMaximumSize(new Dimension(920, 135));
/* 2720 */     this.jPanel67.setMinimumSize(new Dimension(920, 0));
/* 2721 */     this.jPanel67.setName("");
/* 2722 */     this.jPanel67.setPreferredSize(new Dimension(920, 135));
/*      */     
/* 2724 */     this.jPanel12.setBackground(Color.white);
/* 2725 */     GridBagLayout jPanel12Layout = new GridBagLayout();
/* 2726 */     jPanel12Layout.columnWidths = new int[] { 0, 5, 0, 5, 0 };
/* 2727 */     jPanel12Layout.rowHeights = new int[] { 0 };
/* 2728 */     this.jPanel12.setLayout(jPanel12Layout);
/*      */     
/* 2730 */     this.jLabel103.setText("Archivo XML Original:");
/* 2731 */     gridBagConstraints = new GridBagConstraints();
/* 2732 */     gridBagConstraints.gridx = 0;
/* 2733 */     gridBagConstraints.gridy = 0;
/* 2734 */     this.jPanel12.add(this.jLabel103, gridBagConstraints);
/*      */     
/* 2736 */     this.jTextField23.setEditable(false);
/* 2737 */     gridBagConstraints = new GridBagConstraints();
/* 2738 */     gridBagConstraints.gridx = 2;
/* 2739 */     gridBagConstraints.gridy = 0;
/* 2740 */     gridBagConstraints.fill = 2;
/* 2741 */     gridBagConstraints.weightx = 1.0D;
/* 2742 */     this.jPanel12.add(this.jTextField23, gridBagConstraints);
/*      */     
/* 2744 */     this.jButton18.setText("Cargar");
/* 2745 */     gridBagConstraints = new GridBagConstraints();
/* 2746 */     gridBagConstraints.gridx = 4;
/* 2747 */     gridBagConstraints.gridy = 0;
/* 2748 */     this.jPanel12.add(this.jButton18, gridBagConstraints);
/*      */     
/* 2750 */     this.jPanel15.setBackground(Color.white);
/* 2751 */     this.jPanel15.setLayout(new GridLayout(2, 6, 6, 6));
/*      */     
/* 2753 */     this.jLabel104.setText("Folio:");
/* 2754 */     this.jPanel15.add(this.jLabel104);
/* 2755 */     this.jPanel15.add(this.jTextField37);
/*      */     
/* 2757 */     this.jLabel141.setText("Fecha:");
/* 2758 */     this.jPanel15.add(this.jLabel141);
/* 2759 */     this.jPanel15.add(this.jTextField38);
/*      */     
/* 2761 */     this.jLabel146.setText("Serie:");
/* 2762 */     this.jPanel15.add(this.jLabel146);
/* 2763 */     this.jPanel15.add(this.jTextField44);
/*      */     
/* 2765 */     this.jLabel106.setText("Interno:");
/* 2766 */     this.jPanel15.add(this.jLabel106);
/* 2767 */     this.jPanel15.add(this.jTextField45);
/*      */     
/* 2769 */     this.jLabel142.setText("Núm de parcialidad");
/* 2770 */     this.jPanel15.add(this.jLabel142);
/* 2771 */     this.jPanel15.add(this.jTextField43);
/*      */     
/* 2773 */     this.jPanel16.setBackground(Color.white);
/*      */     
/* 2775 */     GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
/* 2776 */     this.jPanel16.setLayout(jPanel16Layout);
/* 2777 */     jPanel16Layout.setHorizontalGroup(jPanel16Layout
/* 2778 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2779 */         .addGap(0, 146, 32767));
/*      */     
/* 2781 */     jPanel16Layout.setVerticalGroup(jPanel16Layout
/* 2782 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2783 */         .addGap(0, 29, 32767));
/*      */ 
/*      */     
/* 2786 */     this.jPanel15.add(this.jPanel16);
/*      */     
/* 2788 */     GroupLayout jPanel67Layout = new GroupLayout(this.jPanel67);
/* 2789 */     this.jPanel67.setLayout(jPanel67Layout);
/* 2790 */     jPanel67Layout.setHorizontalGroup(jPanel67Layout
/* 2791 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2792 */         .addComponent(this.jPanel15, -1, 910, 32767)
/* 2793 */         .addComponent(this.jPanel12, -1, -1, 32767));
/*      */     
/* 2795 */     jPanel67Layout.setVerticalGroup(jPanel67Layout
/* 2796 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2797 */         .addGroup(jPanel67Layout.createSequentialGroup()
/* 2798 */           .addComponent(this.jPanel12, -2, 43, -2)
/* 2799 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2800 */           .addComponent(this.jPanel15, -1, -1, 32767)));
/*      */ 
/*      */     
/* 2803 */     this.jPanel19.setBackground(Color.white);
/* 2804 */     this.jPanel19.setBorder(BorderFactory.createTitledBorder("Conceptos"));
/* 2805 */     this.jPanel19.setMaximumSize(new Dimension(920, 32767));
/* 2806 */     this.jPanel19.setPreferredSize(new Dimension(920, 441));
/*      */     
/* 2808 */     this.jPanel20.setBackground(Color.white);
/* 2809 */     this.jPanel20.setLayout(new GridLayout(3, 0));
/*      */     
/* 2811 */     this.jPanel42.setBackground(Color.white);
/* 2812 */     this.jPanel42.setLayout(new GridLayout(1, 0));
/*      */     
/* 2814 */     this.jLabel131.setFont(new Font("Ubuntu Semi-Light", 2, 11));
/* 2815 */     this.jLabel131.setText("A continuación ingresa la clave y una vez que los conceptos estén listos, presiona 'ENTER'");
/* 2816 */     this.jPanel42.add(this.jLabel131);
/*      */     
/* 2818 */     this.jPanel20.add(this.jPanel42);
/*      */     
/* 2820 */     this.jPanel44.setBackground(Color.white);
/* 2821 */     this.jPanel44.setLayout(new GridLayout(1, 3, 12, 0));
/*      */     
/* 2823 */     this.jPanel45.setBackground(Color.white);
/* 2824 */     this.jPanel45.setLayout(new GridLayout(1, 3, 12, 0));
/*      */     
/* 2826 */     this.jLabel130.setFont(new Font("Tahoma", 1, 11));
/* 2827 */     this.jLabel130.setHorizontalAlignment(0);
/* 2828 */     this.jLabel130.setText("Clave");
/* 2829 */     this.jPanel45.add(this.jLabel130);
/*      */     
/* 2831 */     this.jLabel117.setFont(new Font("Tahoma", 1, 11));
/* 2832 */     this.jLabel117.setHorizontalAlignment(0);
/* 2833 */     this.jLabel117.setText("Cantidad");
/* 2834 */     this.jPanel45.add(this.jLabel117);
/*      */     
/* 2836 */     this.jLabel145.setFont(new Font("Tahoma", 1, 11));
/* 2837 */     this.jLabel145.setHorizontalAlignment(0);
/* 2838 */     this.jLabel145.setText("Unidad");
/* 2839 */     this.jPanel45.add(this.jLabel145);
/*      */     
/* 2841 */     this.jPanel44.add(this.jPanel45);
/*      */     
/* 2843 */     this.jPanel30.setBackground(Color.white);
/* 2844 */     this.jPanel30.setLayout(new GridLayout(1, 0));
/*      */     
/* 2846 */     this.jLabel118.setFont(new Font("Tahoma", 1, 11));
/* 2847 */     this.jLabel118.setHorizontalAlignment(0);
/* 2848 */     this.jLabel118.setText("Descripción");
/* 2849 */     this.jPanel30.add(this.jLabel118);
/*      */     
/* 2851 */     this.jPanel44.add(this.jPanel30);
/*      */     
/* 2853 */     this.jPanel43.setBackground(Color.white);
/* 2854 */     this.jPanel43.setLayout(new GridLayout(1, 2, 12, 0));
/*      */     
/* 2856 */     this.jLabel119.setFont(new Font("Tahoma", 1, 11));
/* 2857 */     this.jLabel119.setHorizontalAlignment(0);
/* 2858 */     this.jLabel119.setText("P Unitario");
/* 2859 */     this.jPanel43.add(this.jLabel119);
/*      */     
/* 2861 */     this.jLabel120.setFont(new Font("Tahoma", 1, 11));
/* 2862 */     this.jLabel120.setHorizontalAlignment(0);
/* 2863 */     this.jLabel120.setText("Importe");
/* 2864 */     this.jPanel43.add(this.jLabel120);
/*      */     
/* 2866 */     this.jPanel44.add(this.jPanel43);
/*      */     
/* 2868 */     this.jPanel20.add(this.jPanel44);
/*      */     
/* 2870 */     this.jPanel37.setBackground(Color.white);
/* 2871 */     this.jPanel37.setLayout(new GridLayout(1, 3, 12, 0));
/*      */     
/* 2873 */     this.jPanel46.setBackground(Color.white);
/* 2874 */     this.jPanel46.setLayout(new GridLayout(1, 3, 12, 0));
/*      */     
/* 2876 */     this.jTextField30.setHorizontalAlignment(4);
/* 2877 */     this.jTextField30.setToolTipText("Enter para capturar la clave o Doble clic para desplegar el catálogo");
/* 2878 */     this.jTextField30.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2880 */             Facturas.this.jTextField30MouseClicked(evt);
/*      */           }
/*      */         });
/* 2883 */     this.jTextField30.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2885 */             Facturas.this.jTextField30ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2888 */     this.jPanel46.add(this.jTextField30);
/*      */     
/* 2890 */     this.jFormattedTextField2.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/* 2891 */     this.jFormattedTextField2.setHorizontalAlignment(4);
/* 2892 */     this.jFormattedTextField2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2894 */             Facturas.this.jFormattedTextField2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2897 */     this.jPanel46.add(this.jFormattedTextField2);
/*      */     
/* 2899 */     this.jComboBox16.setEditable(true);
/* 2900 */     this.jComboBox16.setEnabled(false);
/* 2901 */     this.jPanel46.add(this.jComboBox16);
/*      */     
/* 2903 */     this.jPanel37.add(this.jPanel46);
/*      */     
/* 2905 */     this.jPanel47.setBackground(Color.white);
/* 2906 */     this.jPanel47.setLayout(new GridLayout(1, 0));
/*      */     
/* 2908 */     this.jTextField27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2910 */             Facturas.this.jTextField27ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2913 */     this.jPanel47.add(this.jTextField27);
/*      */     
/* 2915 */     this.jPanel37.add(this.jPanel47);
/*      */     
/* 2917 */     this.jPanel77.setBackground(Color.white);
/* 2918 */     this.jPanel77.setLayout(new GridLayout(1, 2, 12, 0));
/*      */     
/* 2920 */     this.jFormattedTextField3.setEditable(false);
/* 2921 */     this.jFormattedTextField3.setHorizontalAlignment(4);
/* 2922 */     this.jPanel77.add(this.jFormattedTextField3);
/*      */     
/* 2924 */     this.jFormattedTextField4.setEditable(false);
/* 2925 */     this.jFormattedTextField4.setHorizontalAlignment(4);
/* 2926 */     this.jPanel77.add(this.jFormattedTextField4);
/*      */     
/* 2928 */     this.jPanel37.add(this.jPanel77);
/*      */     
/* 2930 */     this.jPanel20.add(this.jPanel37);
/*      */     
/* 2932 */     this.jTable10.setFont(new Font("Tahoma", 0, 10));
/* 2933 */     this.jTable10.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Cant", "Descripción", "P Unitario", "Importe" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2941 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2946 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2949 */     this.jScrollPane12.setViewportView(this.jTable10);
/*      */     
/* 2951 */     this.jPanel79.setBackground(Color.white);
/*      */     
/* 2953 */     this.jPanel80.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 2954 */     this.jPanel80.setLayout(new GridLayout(6, 0, 0, 6));
/*      */     
/* 2956 */     this.jPanel81.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 2958 */     this.jLabel109.setText("Subtotal");
/* 2959 */     this.jPanel81.add(this.jLabel109);
/*      */     
/* 2961 */     this.jLabel107.setFont(new Font("Tahoma", 1, 13));
/* 2962 */     this.jLabel107.setHorizontalAlignment(4);
/* 2963 */     this.jLabel107.setText("jLabel107");
/* 2964 */     this.jPanel81.add(this.jLabel107);
/*      */     
/* 2966 */     this.jPanel80.add(this.jPanel81);
/*      */     
/* 2968 */     this.jPanel82.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 2970 */     this.jLabel110.setText("Iva");
/* 2971 */     this.jPanel82.add(this.jLabel110);
/*      */     
/* 2973 */     this.jLabel108.setFont(new Font("Tahoma", 1, 13));
/* 2974 */     this.jLabel108.setHorizontalAlignment(4);
/* 2975 */     this.jLabel108.setText("jLabel107");
/* 2976 */     this.jPanel82.add(this.jLabel108);
/*      */     
/* 2978 */     this.jPanel80.add(this.jPanel82);
/*      */     
/* 2980 */     this.jPanel83.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 2982 */     this.jLabel111.setText("Retención");
/* 2983 */     this.jPanel83.add(this.jLabel111);
/*      */     
/* 2985 */     this.jFormattedTextField1.setHorizontalAlignment(4);
/* 2986 */     this.jFormattedTextField1.setEnabled(false);
/* 2987 */     this.jFormattedTextField1.setFont(new Font("Tahoma", 1, 11));
/* 2988 */     this.jFormattedTextField1.addCaretListener(new CaretListener() {
/*      */           public void caretUpdate(CaretEvent evt) {
/* 2990 */             Facturas.this.jFormattedTextField1CaretUpdate(evt);
/*      */           }
/*      */         });
/* 2993 */     this.jPanel83.add(this.jFormattedTextField1);
/*      */     
/* 2995 */     this.jPanel80.add(this.jPanel83);
/*      */     
/* 2997 */     this.jPanel84.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 2999 */     this.jLabel149.setText("<html><u>Descuento</u></html>");
/* 3000 */     this.jLabel149.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3002 */             Facturas.this.jLabel149MouseClicked(evt);
/*      */           }
/*      */         });
/* 3005 */     this.jPanel84.add(this.jLabel149);
/*      */     
/* 3007 */     this.jFormattedTextField10.setHorizontalAlignment(4);
/* 3008 */     this.jFormattedTextField10.setFont(new Font("Tahoma", 1, 11));
/* 3009 */     this.jFormattedTextField10.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3011 */             Facturas.this.jFormattedTextField10KeyReleased(evt);
/*      */           }
/*      */         });
/* 3014 */     this.jPanel84.add(this.jFormattedTextField10);
/*      */     
/* 3016 */     this.jPanel80.add(this.jPanel84);
/*      */     
/* 3018 */     this.jPanel85.setLayout(new GridLayout(1, 0));
/* 3019 */     this.jPanel85.add(this.jSeparator23);
/*      */     
/* 3021 */     this.jPanel80.add(this.jPanel85);
/*      */     
/* 3023 */     this.jPanel86.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 3025 */     this.jLabel113.setText("Total");
/* 3026 */     this.jPanel86.add(this.jLabel113);
/*      */     
/* 3028 */     this.jLabel114.setFont(new Font("Tahoma", 1, 13));
/* 3029 */     this.jLabel114.setHorizontalAlignment(4);
/* 3030 */     this.jLabel114.setText("jLabel107");
/* 3031 */     this.jPanel86.add(this.jLabel114);
/*      */     
/* 3033 */     this.jPanel80.add(this.jPanel86);
/*      */     
/* 3035 */     this.jPanel64.setBackground(Color.white);
/* 3036 */     this.jPanel64.setLayout(new GridLayout(5, 4, 6, 6));
/*      */     
/* 3038 */     this.jPanel13.setBackground(Color.white);
/* 3039 */     this.jPanel13.setLayout(new GridLayout(1, 4));
/*      */     
/* 3041 */     this.jPanel18.setBackground(Color.white);
/* 3042 */     this.jPanel18.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 3044 */     this.jButton41.setMnemonic('M');
/* 3045 */     this.jButton41.setText("Modificar");
/* 3046 */     this.jButton41.setToolTipText("Modificar (Alt+M)");
/* 3047 */     this.jButton41.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3049 */             Facturas.this.jButton41ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3052 */     this.jPanel18.add(this.jButton41);
/*      */     
/* 3054 */     this.jButton31.setMnemonic('Q');
/* 3055 */     this.jButton31.setText("Quitar");
/* 3056 */     this.jButton31.setToolTipText("Quitar (Alt+Q)");
/* 3057 */     this.jButton31.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3059 */             Facturas.this.jButton31ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3062 */     this.jPanel18.add(this.jButton31);
/*      */     
/* 3064 */     this.jPanel13.add(this.jPanel18);
/*      */     
/* 3066 */     this.jPanel66.setBackground(Color.white);
/*      */     
/* 3068 */     GroupLayout jPanel66Layout = new GroupLayout(this.jPanel66);
/* 3069 */     this.jPanel66.setLayout(jPanel66Layout);
/* 3070 */     jPanel66Layout.setHorizontalGroup(jPanel66Layout
/* 3071 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3072 */         .addGap(0, 172, 32767));
/*      */     
/* 3074 */     jPanel66Layout.setVerticalGroup(jPanel66Layout
/* 3075 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3076 */         .addGap(0, 29, 32767));
/*      */ 
/*      */     
/* 3079 */     this.jPanel13.add(this.jPanel66);
/*      */     
/* 3081 */     this.jPanel68.setBackground(Color.white);
/*      */     
/* 3083 */     GroupLayout jPanel68Layout = new GroupLayout(this.jPanel68);
/* 3084 */     this.jPanel68.setLayout(jPanel68Layout);
/* 3085 */     jPanel68Layout.setHorizontalGroup(jPanel68Layout
/* 3086 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3087 */         .addGap(0, 172, 32767));
/*      */     
/* 3089 */     jPanel68Layout.setVerticalGroup(jPanel68Layout
/* 3090 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3091 */         .addGap(0, 29, 32767));
/*      */ 
/*      */     
/* 3094 */     this.jPanel13.add(this.jPanel68);
/*      */     
/* 3096 */     this.jPanel69.setBackground(Color.white);
/*      */     
/* 3098 */     GroupLayout jPanel69Layout = new GroupLayout(this.jPanel69);
/* 3099 */     this.jPanel69.setLayout(jPanel69Layout);
/* 3100 */     jPanel69Layout.setHorizontalGroup(jPanel69Layout
/* 3101 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3102 */         .addGap(0, 172, 32767));
/*      */     
/* 3104 */     jPanel69Layout.setVerticalGroup(jPanel69Layout
/* 3105 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3106 */         .addGap(0, 29, 32767));
/*      */ 
/*      */     
/* 3109 */     this.jPanel13.add(this.jPanel69);
/*      */     
/* 3111 */     this.jPanel64.add(this.jPanel13);
/*      */     
/* 3113 */     this.jPanel70.setBackground(Color.white);
/* 3114 */     this.jPanel70.setLayout(new GridLayout(1, 0));
/*      */     
/* 3116 */     this.jLabel87.setText("Cantidad con letra:");
/* 3117 */     this.jPanel70.add(this.jLabel87);
/*      */     
/* 3119 */     this.jPanel64.add(this.jPanel70);
/*      */     
/* 3121 */     this.jPanel71.setBackground(Color.white);
/* 3122 */     this.jPanel71.setLayout(new GridLayout(1, 0));
/*      */     
/* 3124 */     this.jTextField25.setEditable(false);
/* 3125 */     this.jPanel71.add(this.jTextField25);
/*      */     
/* 3127 */     this.jPanel64.add(this.jPanel71);
/*      */     
/* 3129 */     this.jPanel72.setBackground(Color.white);
/* 3130 */     this.jPanel72.setLayout(new GridLayout(1, 2));
/*      */     
/* 3132 */     this.jPanel74.setBackground(Color.white);
/* 3133 */     this.jPanel74.setLayout(new GridLayout(1, 2));
/*      */     
/* 3135 */     this.jCheckBox1.setText("Leyendas Fiscales");
/* 3136 */     this.jCheckBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3138 */             Facturas.this.jCheckBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3141 */     this.jPanel74.add(this.jCheckBox1);
/*      */     
/* 3143 */     this.jComboBox10.setBackground(new Color(244, 244, 244));
/* 3144 */     this.jComboBox10.setModel(new DefaultComboBoxModel<>(new String[] { "Personalizado", "Impuesto Retenido", "Efectos Fiscales" }));
/* 3145 */     this.jComboBox10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3147 */             Facturas.this.jComboBox10ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3150 */     this.jPanel74.add(this.jComboBox10);
/*      */     
/* 3152 */     this.jPanel72.add(this.jPanel74);
/*      */     
/* 3154 */     this.jPanel75.setBackground(Color.white);
/*      */     
/* 3156 */     GroupLayout jPanel75Layout = new GroupLayout(this.jPanel75);
/* 3157 */     this.jPanel75.setLayout(jPanel75Layout);
/* 3158 */     jPanel75Layout.setHorizontalGroup(jPanel75Layout
/* 3159 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3160 */         .addGap(0, 344, 32767));
/*      */     
/* 3162 */     jPanel75Layout.setVerticalGroup(jPanel75Layout
/* 3163 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3164 */         .addGap(0, 29, 32767));
/*      */ 
/*      */     
/* 3167 */     this.jPanel72.add(this.jPanel75);
/*      */     
/* 3169 */     this.jPanel64.add(this.jPanel72);
/*      */     
/* 3171 */     this.jPanel73.setBackground(Color.white);
/* 3172 */     this.jPanel73.setLayout(new GridLayout(1, 0));
/*      */     
/* 3174 */     this.jTextField28.setBackground(new Color(244, 244, 244));
/* 3175 */     this.jTextField28.setEnabled(false);
/* 3176 */     this.jPanel73.add(this.jTextField28);
/*      */     
/* 3178 */     this.jPanel64.add(this.jPanel73);
/*      */     
/* 3180 */     GroupLayout jPanel79Layout = new GroupLayout(this.jPanel79);
/* 3181 */     this.jPanel79.setLayout(jPanel79Layout);
/* 3182 */     jPanel79Layout.setHorizontalGroup(jPanel79Layout
/* 3183 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3184 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel79Layout.createSequentialGroup()
/* 3185 */           .addComponent(this.jPanel64, -2, 0, 32767)
/* 3186 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3187 */           .addComponent(this.jPanel80, -2, 216, -2)));
/*      */     
/* 3189 */     jPanel79Layout.setVerticalGroup(jPanel79Layout
/* 3190 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3191 */         .addComponent(this.jPanel80, -2, -1, -2)
/* 3192 */         .addComponent(this.jPanel64, -2, 170, -2));
/*      */ 
/*      */     
/* 3195 */     GroupLayout jPanel78Layout = new GroupLayout(this.jPanel78);
/* 3196 */     this.jPanel78.setLayout(jPanel78Layout);
/* 3197 */     jPanel78Layout.setHorizontalGroup(jPanel78Layout
/* 3198 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3199 */         .addComponent(this.jPanel79, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 3200 */         .addComponent(this.jScrollPane12));
/*      */     
/* 3202 */     jPanel78Layout.setVerticalGroup(jPanel78Layout
/* 3203 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3204 */         .addGroup(jPanel78Layout.createSequentialGroup()
/* 3205 */           .addComponent(this.jScrollPane12, -1, 162, 32767)
/* 3206 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3207 */           .addComponent(this.jPanel79, -2, -1, -2)));
/*      */ 
/*      */     
/* 3210 */     GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
/* 3211 */     this.jPanel19.setLayout(jPanel19Layout);
/* 3212 */     jPanel19Layout.setHorizontalGroup(jPanel19Layout
/* 3213 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3214 */         .addComponent(this.jPanel20, -2, 0, 32767)
/* 3215 */         .addComponent(this.jPanel78, -1, -1, 32767));
/*      */     
/* 3217 */     jPanel19Layout.setVerticalGroup(jPanel19Layout
/* 3218 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3219 */         .addGroup(jPanel19Layout.createSequentialGroup()
/* 3220 */           .addComponent(this.jPanel20, -2, 75, -2)
/* 3221 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3222 */           .addComponent(this.jPanel78, -1, -1, 32767)));
/*      */ 
/*      */     
/* 3225 */     this.jPanel76.setBackground(Color.white);
/* 3226 */     this.jPanel76.setMaximumSize(new Dimension(920, 32767));
/* 3227 */     this.jPanel76.setMinimumSize(new Dimension(920, 31));
/* 3228 */     this.jPanel76.setPreferredSize(new Dimension(920, 31));
/* 3229 */     this.jPanel76.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 3231 */     this.jPanel88.setBackground(Color.white);
/* 3232 */     this.jPanel88.setLayout(new GridLayout(1, 4, 6, 0));
/*      */     
/* 3234 */     this.jButton9.setMnemonic('N');
/* 3235 */     this.jButton9.setText("Generar");
/* 3236 */     this.jButton9.setToolTipText("Generar (Alt+G)");
/* 3237 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3239 */             Facturas.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3242 */     this.jPanel88.add(this.jButton9);
/*      */     
/* 3244 */     this.jPanel91.setBackground(Color.white);
/*      */     
/* 3246 */     GroupLayout jPanel91Layout = new GroupLayout(this.jPanel91);
/* 3247 */     this.jPanel91.setLayout(jPanel91Layout);
/* 3248 */     jPanel91Layout.setHorizontalGroup(jPanel91Layout
/* 3249 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3250 */         .addGap(0, 109, 32767));
/*      */     
/* 3252 */     jPanel91Layout.setVerticalGroup(jPanel91Layout
/* 3253 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3254 */         .addGap(0, 31, 32767));
/*      */ 
/*      */     
/* 3257 */     this.jPanel88.add(this.jPanel91);
/*      */     
/* 3259 */     this.jPanel93.setBackground(Color.white);
/*      */     
/* 3261 */     GroupLayout jPanel93Layout = new GroupLayout(this.jPanel93);
/* 3262 */     this.jPanel93.setLayout(jPanel93Layout);
/* 3263 */     jPanel93Layout.setHorizontalGroup(jPanel93Layout
/* 3264 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3265 */         .addGap(0, 109, 32767));
/*      */     
/* 3267 */     jPanel93Layout.setVerticalGroup(jPanel93Layout
/* 3268 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3269 */         .addGap(0, 31, 32767));
/*      */ 
/*      */     
/* 3272 */     this.jPanel88.add(this.jPanel93);
/*      */     
/* 3274 */     this.jPanel94.setBackground(Color.white);
/*      */     
/* 3276 */     GroupLayout jPanel94Layout = new GroupLayout(this.jPanel94);
/* 3277 */     this.jPanel94.setLayout(jPanel94Layout);
/* 3278 */     jPanel94Layout.setHorizontalGroup(jPanel94Layout
/* 3279 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3280 */         .addGap(0, 109, 32767));
/*      */     
/* 3282 */     jPanel94Layout.setVerticalGroup(jPanel94Layout
/* 3283 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3284 */         .addGap(0, 31, 32767));
/*      */ 
/*      */     
/* 3287 */     this.jPanel88.add(this.jPanel94);
/*      */     
/* 3289 */     this.jPanel76.add(this.jPanel88);
/*      */     
/* 3291 */     this.jPanel92.setBackground(Color.white);
/* 3292 */     this.jPanel92.setLayout(new GridLayout(1, 4, 6, 0));
/*      */     
/* 3294 */     this.jButton40.setText("Cobrar a...");
/* 3295 */     this.jButton40.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3297 */             Facturas.this.jButton40ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3300 */     this.jPanel92.add(this.jButton40);
/*      */     
/* 3302 */     this.jButton38.setMnemonic('I');
/* 3303 */     this.jButton38.setText("Prefacturas");
/* 3304 */     this.jButton38.setToolTipText("Imprimir (Alt+I)");
/* 3305 */     this.jButton38.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3307 */             Facturas.this.jButton38ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3310 */     this.jPanel92.add(this.jButton38);
/*      */     
/* 3312 */     this.jButton32.setMnemonic('I');
/* 3313 */     this.jButton32.setText("Expedir CFDI");
/* 3314 */     this.jButton32.setToolTipText("Imprimir (Alt+I)");
/* 3315 */     this.jButton32.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3317 */             Facturas.this.jButton32ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3320 */     this.jPanel92.add(this.jButton32);
/*      */     
/* 3322 */     this.jButton37.setMnemonic('C');
/* 3323 */     this.jButton37.setText("Cerrar");
/* 3324 */     this.jButton37.setToolTipText("Cerrar (Alt+C)");
/* 3325 */     this.jButton37.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3327 */             Facturas.this.jButton37ActionPerformed(evt);
/*      */           }
/*      */         });
/* 3330 */     this.jPanel92.add(this.jButton37);
/*      */     
/* 3332 */     this.jPanel76.add(this.jPanel92);
/*      */     
/* 3334 */     this.jPanel99.setForeground(new Color(255, 255, 255));
/* 3335 */     this.jPanel99.setLayout(new GridLayout(0, 2, 6, 0));
/*      */     
/* 3337 */     this.jPanel100.setLayout(new GridLayout(1, 0));
/*      */     
/* 3339 */     this.jLabel167.setFont(new Font("Dialog", 1, 13));
/* 3340 */     this.jLabel167.setForeground(new Color(255, 255, 255));
/* 3341 */     this.jLabel167.setHorizontalAlignment(0);
/* 3342 */     this.jLabel167.setText("jLabel167");
/* 3343 */     this.jPanel100.add(this.jLabel167);
/*      */     
/* 3345 */     this.jPanel99.add(this.jPanel100);
/*      */     
/* 3347 */     this.jPanel101.setLayout(new GridLayout(1, 0));
/*      */     
/* 3349 */     this.jLabel168.setFont(new Font("Dialog", 1, 13));
/* 3350 */     this.jLabel168.setForeground(new Color(255, 255, 255));
/* 3351 */     this.jLabel168.setHorizontalAlignment(0);
/* 3352 */     this.jLabel168.setText("jLabel168");
/* 3353 */     this.jPanel101.add(this.jLabel168);
/*      */     
/* 3355 */     this.jPanel99.add(this.jPanel101);
/*      */     
/* 3357 */     GroupLayout jPanel90Layout = new GroupLayout(this.jPanel90);
/* 3358 */     this.jPanel90.setLayout(jPanel90Layout);
/* 3359 */     jPanel90Layout.setHorizontalGroup(jPanel90Layout
/* 3360 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3361 */         .addComponent(this.jPanel19, -1, -1, 32767)
/* 3362 */         .addComponent(this.jPanel76, -2, 0, 32767)
/* 3363 */         .addComponent(this.jPanel99, -1, -1, 32767)
/* 3364 */         .addComponent(this.jPanel67, -2, -1, -2)
/* 3365 */         .addComponent(this.jPanel59, -2, -1, -2)
/* 3366 */         .addComponent(this.jPanel56, -2, -1, -2)
/* 3367 */         .addComponent(this.jPanel61, -2, 920, -2)
/* 3368 */         .addComponent(this.jPanel87, -2, -1, -2));
/*      */     
/* 3370 */     jPanel90Layout.setVerticalGroup(jPanel90Layout
/* 3371 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3372 */         .addGroup(jPanel90Layout.createSequentialGroup()
/* 3373 */           .addComponent(this.jPanel99, -2, 33, -2)
/* 3374 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3375 */           .addComponent(this.jPanel59, -2, -1, -2)
/* 3376 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3377 */           .addComponent(this.jPanel56, -2, -1, -2)
/* 3378 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3379 */           .addComponent(this.jPanel61, -2, -1, -2)
/* 3380 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3381 */           .addComponent(this.jPanel87, -2, -1, -2)
/* 3382 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3383 */           .addComponent(this.jPanel67, -2, -1, -2)
/* 3384 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3385 */           .addComponent(this.jPanel19, -2, -1, -2)
/* 3386 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3387 */           .addComponent(this.jPanel76, -2, 28, -2)
/* 3388 */           .addGap(0, 489, 32767)));
/*      */ 
/*      */     
/* 3391 */     this.jScrollPane13.setViewportView(this.jPanel90);
/*      */     
/* 3393 */     GroupLayout jDialog11Layout = new GroupLayout(this.jDialog11.getContentPane());
/* 3394 */     this.jDialog11.getContentPane().setLayout(jDialog11Layout);
/* 3395 */     jDialog11Layout.setHorizontalGroup(jDialog11Layout
/* 3396 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3397 */         .addGroup(jDialog11Layout.createSequentialGroup()
/* 3398 */           .addComponent(this.jScrollPane13)
/* 3399 */           .addGap(0, 0, 0)));
/*      */     
/* 3401 */     jDialog11Layout.setVerticalGroup(jDialog11Layout
/* 3402 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3403 */         .addGroup(jDialog11Layout.createSequentialGroup()
/* 3404 */           .addComponent(this.jScrollPane13, -2, 1190, -2)
/* 3405 */           .addGap(0, 0, 32767)));
/*      */ 
/*      */     
/* 3408 */     this.jDialog12.setTitle("Recepción de facturas");
/*      */     
/* 3410 */     this.jPanel34.setBackground(Color.white);
/*      */     
/* 3412 */     this.jButton21.setMnemonic('A');
/* 3413 */     this.jButton21.setText("Aceptar");
/* 3414 */     this.jButton21.setToolTipText("Aceptar (Alt+A)");
/* 3415 */     this.jButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3417 */             Facturas.this.jButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3421 */     this.jButton19.setMnemonic('C');
/* 3422 */     this.jButton19.setText("Cerrar");
/* 3423 */     this.jButton19.setToolTipText("Cerrar (Alt+C)");
/* 3424 */     this.jButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3426 */             Facturas.this.jButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3430 */     this.jPanel10.setBackground(Color.white);
/* 3431 */     this.jPanel10.setLayout(new GridBagLayout());
/*      */     
/* 3433 */     this.jLabel147.setFont(new Font("Times New Roman", 1, 14));
/* 3434 */     this.jLabel147.setHorizontalAlignment(0);
/* 3435 */     this.jLabel147.setText(" RECEPCIÓN");
/* 3436 */     gridBagConstraints = new GridBagConstraints();
/* 3437 */     gridBagConstraints.gridx = 0;
/* 3438 */     gridBagConstraints.gridy = 0;
/* 3439 */     gridBagConstraints.gridwidth = 4;
/* 3440 */     gridBagConstraints.ipadx = 527;
/* 3441 */     gridBagConstraints.insets = new Insets(0, 12, 0, 12);
/* 3442 */     this.jPanel10.add(this.jLabel147, gridBagConstraints);
/*      */     
/* 3444 */     this.jLabel59.setFont(new Font("Tahoma", 1, 11));
/* 3445 */     this.jLabel59.setText("Factura:");
/* 3446 */     gridBagConstraints = new GridBagConstraints();
/* 3447 */     gridBagConstraints.gridx = 0;
/* 3448 */     gridBagConstraints.gridy = 1;
/* 3449 */     gridBagConstraints.ipadx = 42;
/* 3450 */     gridBagConstraints.anchor = 18;
/* 3451 */     gridBagConstraints.insets = new Insets(14, 12, 0, 0);
/* 3452 */     this.jPanel10.add(this.jLabel59, gridBagConstraints);
/*      */     
/* 3454 */     this.jTextField47.setEnabled(false);
/* 3455 */     gridBagConstraints = new GridBagConstraints();
/* 3456 */     gridBagConstraints.gridx = 1;
/* 3457 */     gridBagConstraints.gridy = 1;
/* 3458 */     gridBagConstraints.fill = 2;
/* 3459 */     gridBagConstraints.ipadx = 141;
/* 3460 */     gridBagConstraints.anchor = 18;
/* 3461 */     gridBagConstraints.weightx = 0.1D;
/* 3462 */     gridBagConstraints.insets = new Insets(6, 12, 0, 0);
/* 3463 */     this.jPanel10.add(this.jTextField47, gridBagConstraints);
/*      */     
/* 3465 */     this.jLabel60.setFont(new Font("Tahoma", 1, 11));
/* 3466 */     this.jLabel60.setText("F. de Recepción:");
/* 3467 */     gridBagConstraints = new GridBagConstraints();
/* 3468 */     gridBagConstraints.gridx = 2;
/* 3469 */     gridBagConstraints.gridy = 1;
/* 3470 */     gridBagConstraints.ipadx = 6;
/* 3471 */     gridBagConstraints.anchor = 18;
/* 3472 */     gridBagConstraints.insets = new Insets(14, 55, 0, 0);
/* 3473 */     this.jPanel10.add(this.jLabel60, gridBagConstraints);
/*      */     
/* 3475 */     this.jDateChooser9.setDate(this.fechaActual);
/* 3476 */     this.jDateChooser9.setDateFormatString("dd/MM/yyyy");
/* 3477 */     this.jDateChooser9.setIcon(this.icon);
/* 3478 */     this.jDateChooser9.setMinSelectableDate(new Date(1257058862000L));
/* 3479 */     gridBagConstraints = new GridBagConstraints();
/* 3480 */     gridBagConstraints.gridx = 3;
/* 3481 */     gridBagConstraints.gridy = 1;
/* 3482 */     gridBagConstraints.fill = 2;
/* 3483 */     gridBagConstraints.ipadx = 130;
/* 3484 */     gridBagConstraints.anchor = 18;
/* 3485 */     gridBagConstraints.weightx = 0.1D;
/* 3486 */     gridBagConstraints.insets = new Insets(6, 12, 0, 12);
/* 3487 */     this.jPanel10.add((Component)this.jDateChooser9, gridBagConstraints);
/*      */     
/* 3489 */     this.jLabel61.setFont(new Font("Tahoma", 1, 11));
/* 3490 */     this.jLabel61.setText("Recibió:");
/* 3491 */     gridBagConstraints = new GridBagConstraints();
/* 3492 */     gridBagConstraints.gridx = 0;
/* 3493 */     gridBagConstraints.gridy = 2;
/* 3494 */     gridBagConstraints.ipadx = 44;
/* 3495 */     gridBagConstraints.anchor = 18;
/* 3496 */     gridBagConstraints.insets = new Insets(14, 12, 0, 0);
/* 3497 */     this.jPanel10.add(this.jLabel61, gridBagConstraints);
/* 3498 */     gridBagConstraints = new GridBagConstraints();
/* 3499 */     gridBagConstraints.gridx = 1;
/* 3500 */     gridBagConstraints.gridy = 2;
/* 3501 */     gridBagConstraints.fill = 2;
/* 3502 */     gridBagConstraints.ipadx = 141;
/* 3503 */     gridBagConstraints.anchor = 18;
/* 3504 */     gridBagConstraints.weightx = 0.1D;
/* 3505 */     gridBagConstraints.insets = new Insets(6, 12, 0, 0);
/* 3506 */     this.jPanel10.add(this.jTextField48, gridBagConstraints);
/*      */     
/* 3508 */     this.jLabel62.setFont(new Font("Tahoma", 1, 11));
/* 3509 */     this.jLabel62.setText("Entregó:");
/* 3510 */     gridBagConstraints = new GridBagConstraints();
/* 3511 */     gridBagConstraints.gridx = 2;
/* 3512 */     gridBagConstraints.gridy = 2;
/* 3513 */     gridBagConstraints.ipadx = 58;
/* 3514 */     gridBagConstraints.anchor = 18;
/* 3515 */     gridBagConstraints.insets = new Insets(14, 55, 0, 0);
/* 3516 */     this.jPanel10.add(this.jLabel62, gridBagConstraints);
/* 3517 */     gridBagConstraints = new GridBagConstraints();
/* 3518 */     gridBagConstraints.gridx = 3;
/* 3519 */     gridBagConstraints.gridy = 2;
/* 3520 */     gridBagConstraints.fill = 2;
/* 3521 */     gridBagConstraints.ipadx = 133;
/* 3522 */     gridBagConstraints.anchor = 18;
/* 3523 */     gridBagConstraints.weightx = 0.1D;
/* 3524 */     gridBagConstraints.insets = new Insets(6, 12, 0, 0);
/* 3525 */     this.jPanel10.add(this.jTextField49, gridBagConstraints);
/*      */     
/* 3527 */     this.jLabel64.setText("Lugar:");
/* 3528 */     gridBagConstraints = new GridBagConstraints();
/* 3529 */     gridBagConstraints.gridx = 0;
/* 3530 */     gridBagConstraints.gridy = 3;
/* 3531 */     gridBagConstraints.ipadx = 55;
/* 3532 */     gridBagConstraints.anchor = 18;
/* 3533 */     gridBagConstraints.insets = new Insets(12, 12, 0, 0);
/* 3534 */     this.jPanel10.add(this.jLabel64, gridBagConstraints);
/* 3535 */     gridBagConstraints = new GridBagConstraints();
/* 3536 */     gridBagConstraints.gridx = 1;
/* 3537 */     gridBagConstraints.gridy = 3;
/* 3538 */     gridBagConstraints.gridwidth = 3;
/* 3539 */     gridBagConstraints.fill = 2;
/* 3540 */     gridBagConstraints.ipadx = 469;
/* 3541 */     gridBagConstraints.anchor = 18;
/* 3542 */     gridBagConstraints.insets = new Insets(6, 12, 0, 0);
/* 3543 */     this.jPanel10.add(this.jTextField50, gridBagConstraints);
/*      */     
/* 3545 */     this.jLabel65.setText("Comentario:");
/* 3546 */     gridBagConstraints = new GridBagConstraints();
/* 3547 */     gridBagConstraints.gridx = 0;
/* 3548 */     gridBagConstraints.gridy = 4;
/* 3549 */     gridBagConstraints.ipadx = 16;
/* 3550 */     gridBagConstraints.anchor = 18;
/* 3551 */     gridBagConstraints.insets = new Insets(6, 12, 0, 0);
/* 3552 */     this.jPanel10.add(this.jLabel65, gridBagConstraints);
/*      */     
/* 3554 */     this.jTextArea2.setColumns(20);
/* 3555 */     this.jTextArea2.setRows(5);
/* 3556 */     this.jScrollPane10.setViewportView(this.jTextArea2);
/*      */     
/* 3558 */     gridBagConstraints = new GridBagConstraints();
/* 3559 */     gridBagConstraints.gridx = 1;
/* 3560 */     gridBagConstraints.gridy = 4;
/* 3561 */     gridBagConstraints.gridwidth = 3;
/* 3562 */     gridBagConstraints.gridheight = 2;
/* 3563 */     gridBagConstraints.fill = 1;
/* 3564 */     gridBagConstraints.ipadx = 466;
/* 3565 */     gridBagConstraints.ipady = 99;
/* 3566 */     gridBagConstraints.weightx = 1.0D;
/* 3567 */     gridBagConstraints.weighty = 1.0D;
/* 3568 */     gridBagConstraints.insets = new Insets(6, 12, 0, 0);
/* 3569 */     this.jPanel10.add(this.jScrollPane10, gridBagConstraints);
/*      */     
/* 3571 */     this.jLabel66.setFont(new Font("Tahoma", 1, 11));
/* 3572 */     this.jLabel66.setText("Usuario:");
/* 3573 */     gridBagConstraints = new GridBagConstraints();
/* 3574 */     gridBagConstraints.gridx = 0;
/* 3575 */     gridBagConstraints.gridy = 6;
/* 3576 */     gridBagConstraints.ipadx = 42;
/* 3577 */     gridBagConstraints.ipady = 15;
/* 3578 */     gridBagConstraints.anchor = 18;
/* 3579 */     gridBagConstraints.insets = new Insets(6, 12, 0, 0);
/* 3580 */     this.jPanel10.add(this.jLabel66, gridBagConstraints);
/*      */     
/* 3582 */     this.jTextField51.setEnabled(false);
/* 3583 */     gridBagConstraints = new GridBagConstraints();
/* 3584 */     gridBagConstraints.gridx = 1;
/* 3585 */     gridBagConstraints.gridy = 6;
/* 3586 */     gridBagConstraints.fill = 2;
/* 3587 */     gridBagConstraints.ipadx = 141;
/* 3588 */     gridBagConstraints.anchor = 18;
/* 3589 */     gridBagConstraints.weightx = 0.1D;
/* 3590 */     gridBagConstraints.insets = new Insets(6, 12, 0, 0);
/* 3591 */     this.jPanel10.add(this.jTextField51, gridBagConstraints);
/* 3592 */     gridBagConstraints = new GridBagConstraints();
/* 3593 */     gridBagConstraints.gridx = 0;
/* 3594 */     gridBagConstraints.gridy = 7;
/* 3595 */     gridBagConstraints.gridwidth = 4;
/* 3596 */     gridBagConstraints.fill = 2;
/* 3597 */     gridBagConstraints.ipadx = 617;
/* 3598 */     gridBagConstraints.ipady = 7;
/* 3599 */     gridBagConstraints.anchor = 18;
/* 3600 */     gridBagConstraints.insets = new Insets(6, 12, 0, 12);
/* 3601 */     this.jPanel10.add(this.jSeparator35, gridBagConstraints);
/*      */     
/* 3603 */     this.jLabel67.setFont(new Font("Tahoma", 1, 11));
/* 3604 */     this.jLabel67.setText("Fecha de cierre");
/* 3605 */     gridBagConstraints = new GridBagConstraints();
/* 3606 */     gridBagConstraints.gridx = 2;
/* 3607 */     gridBagConstraints.gridy = 6;
/* 3608 */     gridBagConstraints.ipadx = 12;
/* 3609 */     gridBagConstraints.ipady = 15;
/* 3610 */     gridBagConstraints.anchor = 18;
/* 3611 */     gridBagConstraints.insets = new Insets(6, 55, 0, 0);
/* 3612 */     this.jPanel10.add(this.jLabel67, gridBagConstraints);
/*      */     
/* 3614 */     this.jDateChooser10.setDate(this.fechaActual);
/* 3615 */     this.jDateChooser10.setDateFormatString("dd/MM/yyyy");
/* 3616 */     this.jDateChooser10.setEnabled(false);
/* 3617 */     this.jDateChooser10.setIcon(this.icon);
/* 3618 */     this.jDateChooser10.setMinSelectableDate(new Date(1257058862000L));
/* 3619 */     gridBagConstraints = new GridBagConstraints();
/* 3620 */     gridBagConstraints.gridx = 3;
/* 3621 */     gridBagConstraints.gridy = 6;
/* 3622 */     gridBagConstraints.fill = 2;
/* 3623 */     gridBagConstraints.ipadx = 130;
/* 3624 */     gridBagConstraints.anchor = 18;
/* 3625 */     gridBagConstraints.weightx = 0.1D;
/* 3626 */     gridBagConstraints.insets = new Insets(6, 12, 0, 12);
/* 3627 */     this.jPanel10.add((Component)this.jDateChooser10, gridBagConstraints);
/*      */     
/* 3629 */     GroupLayout jPanel34Layout = new GroupLayout(this.jPanel34);
/* 3630 */     this.jPanel34.setLayout(jPanel34Layout);
/* 3631 */     jPanel34Layout.setHorizontalGroup(jPanel34Layout
/* 3632 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3633 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
/* 3634 */           .addComponent(this.jButton21, -2, 97, -2)
/* 3635 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3636 */           .addComponent(this.jButton19, -2, 97, -2))
/* 3637 */         .addComponent(this.jPanel10, GroupLayout.Alignment.TRAILING, -2, 565, 32767));
/*      */     
/* 3639 */     jPanel34Layout.setVerticalGroup(jPanel34Layout
/* 3640 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3641 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
/* 3642 */           .addComponent(this.jPanel10, -2, 272, 32767)
/* 3643 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3644 */           .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3645 */             .addComponent(this.jButton19)
/* 3646 */             .addComponent(this.jButton21))
/* 3647 */           .addContainerGap()));
/*      */ 
/*      */     
/* 3650 */     GroupLayout jDialog12Layout = new GroupLayout(this.jDialog12.getContentPane());
/* 3651 */     this.jDialog12.getContentPane().setLayout(jDialog12Layout);
/* 3652 */     jDialog12Layout.setHorizontalGroup(jDialog12Layout
/* 3653 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3654 */         .addComponent(this.jPanel34, -1, -1, 32767));
/*      */     
/* 3656 */     jDialog12Layout.setVerticalGroup(jDialog12Layout
/* 3657 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3658 */         .addGroup(jDialog12Layout.createSequentialGroup()
/* 3659 */           .addComponent(this.jPanel34, -1, -1, 32767)
/* 3660 */           .addGap(0, 0, 0)));
/*      */ 
/*      */     
/* 3663 */     this.jDialog13.setTitle("Búsqueda por conceptos");
/*      */     
/* 3665 */     this.jPanel53.setBackground(new Color(255, 255, 255));
/*      */     
/* 3667 */     this.jLabel148.setFont(new Font("Times New Roman", 1, 14));
/* 3668 */     this.jLabel148.setHorizontalAlignment(0);
/* 3669 */     this.jLabel148.setText("BÚSQUEDA POR CONCEPTO");
/*      */     
/* 3671 */     this.jLabel68.setText("Coloca el concepto: ");
/*      */     
/* 3673 */     this.jTextField52.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 3675 */             Facturas.this.jTextField52KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 3679 */     this.jTable7.setFont(new Font("Tahoma", 0, 10));
/* 3680 */     this.jTable7.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3691 */     this.jScrollPane11.setViewportView(this.jTable7);
/*      */     
/* 3693 */     this.jLabel70.setFont(new Font("Tahoma", 0, 10));
/* 3694 */     this.jLabel70.setHorizontalAlignment(4);
/* 3695 */     this.jLabel70.setText("$0.00");
/*      */     
/* 3697 */     this.jLabel79.setFont(new Font("Tahoma", 0, 10));
/* 3698 */     this.jLabel79.setHorizontalAlignment(4);
/* 3699 */     this.jLabel79.setText("$0.00");
/*      */     
/* 3701 */     this.jLabel112.setFont(new Font("Tahoma", 0, 10));
/* 3702 */     this.jLabel112.setHorizontalAlignment(4);
/* 3703 */     this.jLabel112.setText("$0.00");
/*      */     
/* 3705 */     this.jButton22.setText("Cerrar");
/* 3706 */     this.jButton22.setToolTipText("Cerrar (Alt+C)");
/* 3707 */     this.jButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3709 */             Facturas.this.jButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3713 */     this.jButton29.setText("Guardar");
/* 3714 */     this.jButton29.setToolTipText("Cerrar (Alt+C)");
/* 3715 */     this.jButton29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3717 */             Facturas.this.jButton29ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3721 */     this.jButton30.setText("Imprimir");
/* 3722 */     this.jButton30.setToolTipText("Cerrar (Alt+C)");
/* 3723 */     this.jButton30.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3725 */             Facturas.this.jButton30ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3729 */     this.jLabel69.setFont(new Font("Tahoma", 1, 11));
/* 3730 */     this.jLabel69.setForeground(Color.red);
/* 3731 */     this.jLabel69.setHorizontalAlignment(0);
/* 3732 */     this.jLabel69.setText("t");
/* 3733 */     this.jLabel69.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 3735 */     GroupLayout jPanel53Layout = new GroupLayout(this.jPanel53);
/* 3736 */     this.jPanel53.setLayout(jPanel53Layout);
/* 3737 */     jPanel53Layout.setHorizontalGroup(jPanel53Layout
/* 3738 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3739 */         .addComponent(this.jSeparator36)
/* 3740 */         .addComponent(this.jLabel148, -1, -1, 32767)
/* 3741 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
/* 3742 */           .addGroup(jPanel53Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 3743 */             .addGroup(jPanel53Layout.createSequentialGroup()
/* 3744 */               .addContainerGap()
/* 3745 */               .addGroup(jPanel53Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3746 */                 .addComponent(this.jSeparator3, GroupLayout.Alignment.TRAILING)
/* 3747 */                 .addComponent(this.jScrollPane11)
/* 3748 */                 .addGroup(jPanel53Layout.createSequentialGroup()
/* 3749 */                   .addComponent(this.jLabel68, -2, 163, -2)
/* 3750 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3751 */                   .addComponent(this.jTextField52, -2, 362, -2)
/* 3752 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 147, 32767)
/* 3753 */                   .addComponent(this.jLabel69, -2, 176, -2))
/* 3754 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
/* 3755 */                   .addGap(0, 0, 32767)
/* 3756 */                   .addComponent(this.jButton30, -2, 105, -2)
/* 3757 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3758 */                   .addComponent(this.jButton29, -2, 105, -2)
/* 3759 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3760 */                   .addComponent(this.jButton22, -2, 105, -2))))
/* 3761 */             .addGroup(jPanel53Layout.createSequentialGroup()
/* 3762 */               .addGap(95, 95, 95)
/* 3763 */               .addComponent(this.jLabel112, -2, 77, -2)
/* 3764 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 3765 */               .addComponent(this.jLabel70, -2, 77, -2)
/* 3766 */               .addGap(48, 48, 48)
/* 3767 */               .addComponent(this.jLabel79, -2, 77, -2)
/* 3768 */               .addGap(15, 15, 15)))
/* 3769 */           .addContainerGap()));
/*      */     
/* 3771 */     jPanel53Layout.setVerticalGroup(jPanel53Layout
/* 3772 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3773 */         .addGroup(jPanel53Layout.createSequentialGroup()
/* 3774 */           .addComponent(this.jLabel148)
/* 3775 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3776 */           .addComponent(this.jSeparator36, -2, 10, -2)
/* 3777 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3778 */           .addGroup(jPanel53Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3779 */             .addComponent(this.jLabel68)
/* 3780 */             .addComponent(this.jTextField52, -2, -1, -2)
/* 3781 */             .addComponent(this.jLabel69))
/* 3782 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3783 */           .addComponent(this.jScrollPane11, -1, 329, 32767)
/* 3784 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3785 */           .addGroup(jPanel53Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3786 */             .addComponent(this.jLabel79)
/* 3787 */             .addComponent(this.jLabel70)
/* 3788 */             .addComponent(this.jLabel112))
/* 3789 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3790 */           .addComponent(this.jSeparator3, -2, 10, -2)
/* 3791 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3792 */           .addGroup(jPanel53Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3793 */             .addComponent(this.jButton22)
/* 3794 */             .addComponent(this.jButton29)
/* 3795 */             .addComponent(this.jButton30, -1, -1, 32767))
/* 3796 */           .addGap(11, 11, 11)));
/*      */ 
/*      */     
/* 3799 */     GroupLayout jDialog13Layout = new GroupLayout(this.jDialog13.getContentPane());
/* 3800 */     this.jDialog13.getContentPane().setLayout(jDialog13Layout);
/* 3801 */     jDialog13Layout.setHorizontalGroup(jDialog13Layout
/* 3802 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3803 */         .addGroup(jDialog13Layout.createSequentialGroup()
/* 3804 */           .addComponent(this.jPanel53, -1, -1, 32767)
/* 3805 */           .addGap(0, 0, 0)));
/*      */     
/* 3807 */     jDialog13Layout.setVerticalGroup(jDialog13Layout
/* 3808 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3809 */         .addComponent(this.jPanel53, -1, -1, 32767));
/*      */ 
/*      */     
/* 3812 */     this.jFormattedTextField7.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
/*      */     
/* 3814 */     this.jDialog14.setTitle("Descuento");
/*      */     
/* 3816 */     this.jPanel54.setBackground(new Color(255, 255, 255));
/*      */     
/* 3818 */     this.jLabel150.setFont(new Font("Times New Roman", 1, 14));
/* 3819 */     this.jLabel150.setHorizontalAlignment(0);
/* 3820 */     this.jLabel150.setText("Ingresa los datos del descuento");
/*      */     
/* 3822 */     this.jButton42.setMnemonic('C');
/* 3823 */     this.jButton42.setText("Cerrar");
/* 3824 */     this.jButton42.setToolTipText("Cerrar (Alt+C)");
/* 3825 */     this.jButton42.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3827 */             Facturas.this.jButton42ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3831 */     this.jButton43.setMnemonic('A');
/* 3832 */     this.jButton43.setText("Aceptar");
/* 3833 */     this.jButton43.setToolTipText("Aceptar (Alt+A)");
/* 3834 */     this.jButton43.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3836 */             Facturas.this.jButton43ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3840 */     this.jLabel151.setText("Descuento: ");
/*      */     
/* 3842 */     this.jSlider1.addChangeListener(new ChangeListener() {
/*      */           public void stateChanged(ChangeEvent evt) {
/* 3844 */             Facturas.this.jSlider1StateChanged(evt);
/*      */           }
/*      */         });
/*      */     
/* 3848 */     this.jLabel152.setText("Motivo: ");
/*      */     
/* 3850 */     this.jTextField53.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 3852 */             Facturas.this.jTextField53ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 3856 */     GroupLayout jPanel54Layout = new GroupLayout(this.jPanel54);
/* 3857 */     this.jPanel54.setLayout(jPanel54Layout);
/* 3858 */     jPanel54Layout.setHorizontalGroup(jPanel54Layout
/* 3859 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3860 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
/* 3861 */           .addContainerGap()
/* 3862 */           .addGroup(jPanel54Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 3863 */             .addComponent(this.jLabel150, -1, -1, 32767)
/* 3864 */             .addGroup(jPanel54Layout.createSequentialGroup()
/* 3865 */               .addGap(0, 0, 32767)
/* 3866 */               .addComponent(this.jButton43, -2, 83, -2)
/* 3867 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3868 */               .addComponent(this.jButton42, -2, 83, -2))
/* 3869 */             .addComponent(this.jSeparator38, GroupLayout.Alignment.LEADING)
/* 3870 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel54Layout.createSequentialGroup()
/* 3871 */               .addGroup(jPanel54Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 3872 */                 .addComponent(this.jLabel152, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 3873 */                 .addComponent(this.jLabel151, GroupLayout.Alignment.LEADING, -1, 103, 32767))
/* 3874 */               .addGap(18, 18, 18)
/* 3875 */               .addGroup(jPanel54Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3876 */                 .addComponent(this.jTextField53)
/* 3877 */                 .addComponent(this.jSlider1, -1, 233, 32767)))
/* 3878 */             .addComponent(this.jSeparator37, GroupLayout.Alignment.LEADING))
/* 3879 */           .addGap(26, 26, 26)));
/*      */     
/* 3881 */     jPanel54Layout.setVerticalGroup(jPanel54Layout
/* 3882 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3883 */         .addGroup(jPanel54Layout.createSequentialGroup()
/* 3884 */           .addComponent(this.jLabel150)
/* 3885 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3886 */           .addComponent(this.jSeparator37, -2, 10, -2)
/* 3887 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3888 */           .addGroup(jPanel54Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 3889 */             .addComponent(this.jSlider1, -2, 44, -2)
/* 3890 */             .addComponent(this.jLabel151, -1, -1, 32767))
/* 3891 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3892 */           .addGroup(jPanel54Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3893 */             .addComponent(this.jLabel152)
/* 3894 */             .addComponent(this.jTextField53, -2, -1, -2))
/* 3895 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3896 */           .addComponent(this.jSeparator38, -2, 15, -2)
/* 3897 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3898 */           .addGroup(jPanel54Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3899 */             .addComponent(this.jButton42)
/* 3900 */             .addComponent(this.jButton43))
/* 3901 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 3904 */     GroupLayout jDialog14Layout = new GroupLayout(this.jDialog14.getContentPane());
/* 3905 */     this.jDialog14.getContentPane().setLayout(jDialog14Layout);
/* 3906 */     jDialog14Layout.setHorizontalGroup(jDialog14Layout
/* 3907 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3908 */         .addGroup(jDialog14Layout.createSequentialGroup()
/* 3909 */           .addComponent(this.jPanel54, -2, -1, -2)
/* 3910 */           .addGap(0, 0, 32767)));
/*      */     
/* 3912 */     jDialog14Layout.setVerticalGroup(jDialog14Layout
/* 3913 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3914 */         .addComponent(this.jPanel54, -1, -1, 32767));
/*      */ 
/*      */     
/* 3917 */     this.jDialog15.setTitle("Detalles del Concepto");
/* 3918 */     this.jDialog15.setModal(true);
/*      */     
/* 3920 */     this.jPanel14.setBackground(new Color(255, 255, 255));
/*      */     
/* 3922 */     this.jLabel157.setFont(new Font("Tahoma", 3, 11));
/* 3923 */     this.jLabel157.setForeground(Color.red);
/* 3924 */     this.jLabel157.setText("A continuación se muestra toda la información del concepto seleccionado");
/*      */     
/* 3926 */     this.jLabel158.setFont(new Font("Tahoma", 1, 11));
/* 3927 */     this.jLabel158.setForeground(Color.red);
/* 3928 */     this.jLabel158.setHorizontalAlignment(0);
/* 3929 */     this.jLabel158.setText("<html><u>Cerrar</u></html>");
/* 3930 */     this.jLabel158.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 3932 */             Facturas.this.jLabel158MouseClicked(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 3935 */             Facturas.this.jLabel158MouseExited(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 3938 */             Facturas.this.jLabel158MouseEntered(evt);
/*      */           }
/*      */         });
/*      */     
/* 3942 */     this.jLabel159.setFont(new Font("Tahoma", 1, 11));
/* 3943 */     this.jLabel159.setText("|");
/*      */     
/* 3945 */     this.jScrollPane9.setViewportView(this.jTextPane2);
/*      */     
/* 3947 */     this.jLabel162.setFont(new Font("Tahoma", 1, 11));
/* 3948 */     this.jLabel162.setText("|");
/*      */     
/* 3950 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 3951 */     this.jPanel14.setLayout(jPanel14Layout);
/* 3952 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 3953 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3954 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 3955 */           .addContainerGap()
/* 3956 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3957 */             .addComponent(this.jScrollPane9)
/* 3958 */             .addComponent(this.jLabel157, -1, 584, 32767)
/* 3959 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
/* 3960 */               .addComponent(this.jLabel162)
/* 3961 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3962 */               .addComponent(this.jLabel158, -2, -1, -2)
/* 3963 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3964 */               .addComponent(this.jLabel159)))
/* 3965 */           .addContainerGap()));
/*      */     
/* 3967 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 3968 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3969 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 3970 */           .addComponent(this.jLabel157)
/* 3971 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3972 */           .addComponent(this.jScrollPane9, -2, 258, -2)
/* 3973 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 3974 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 3975 */             .addComponent(this.jLabel159)
/* 3976 */             .addComponent(this.jLabel158, -2, -1, -2)
/* 3977 */             .addComponent(this.jLabel162))
/* 3978 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 3981 */     GroupLayout jDialog15Layout = new GroupLayout(this.jDialog15.getContentPane());
/* 3982 */     this.jDialog15.getContentPane().setLayout(jDialog15Layout);
/* 3983 */     jDialog15Layout.setHorizontalGroup(jDialog15Layout
/* 3984 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3985 */         .addComponent(this.jPanel14, -1, -1, 32767));
/*      */     
/* 3987 */     jDialog15Layout.setVerticalGroup(jDialog15Layout
/* 3988 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 3989 */         .addComponent(this.jPanel14, -1, -1, 32767));
/*      */ 
/*      */     
/* 3992 */     this.jDialog16.setTitle("Datos fiscales diferentes");
/* 3993 */     this.jDialog16.setModal(true);
/*      */     
/* 3995 */     this.jPanel21.setBackground(new Color(255, 255, 255));
/*      */     
/* 3997 */     this.jLabel2.setText("<html> Los datos fiscales del cliente ya han cambiado, selecciona cuales son los datos con los que deseas refacturar</html>");
/*      */     
/* 3999 */     this.jPanel22.setBackground(new Color(255, 255, 255));
/* 4000 */     this.jPanel22.setForeground(new Color(255, 255, 255));
/* 4001 */     this.jPanel22.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 4003 */     this.jButton27.setText("Refacturar con datos anteriores");
/* 4004 */     this.jButton27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4006 */             Facturas.this.jButton27ActionPerformed(evt);
/*      */           }
/*      */         });
/* 4009 */     this.jPanel22.add(this.jButton27);
/*      */     
/* 4011 */     this.jButton33.setText("Refacturar con datos nuevos");
/* 4012 */     this.jButton33.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4014 */             Facturas.this.jButton33ActionPerformed(evt);
/*      */           }
/*      */         });
/* 4017 */     this.jPanel22.add(this.jButton33);
/*      */     
/* 4019 */     this.jPanel23.setBackground(new Color(255, 255, 255));
/* 4020 */     this.jPanel23.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 4022 */     this.jPanel24.setBackground(new Color(255, 255, 255));
/* 4023 */     this.jPanel24.setForeground(new Color(255, 255, 255));
/* 4024 */     this.jPanel24.setLayout(new GridLayout(8, 1, 0, 6));
/*      */     
/* 4026 */     this.jTextField21.setEditable(false);
/* 4027 */     this.jPanel24.add(this.jTextField21);
/*      */     
/* 4029 */     this.jTextField56.setEditable(false);
/* 4030 */     this.jPanel24.add(this.jTextField56);
/*      */     
/* 4032 */     this.jTextField57.setEditable(false);
/* 4033 */     this.jPanel24.add(this.jTextField57);
/*      */     
/* 4035 */     this.jTextField58.setEditable(false);
/* 4036 */     this.jPanel24.add(this.jTextField58);
/*      */     
/* 4038 */     this.jTextField59.setEditable(false);
/* 4039 */     this.jPanel24.add(this.jTextField59);
/*      */     
/* 4041 */     this.jTextField60.setEditable(false);
/* 4042 */     this.jPanel24.add(this.jTextField60);
/*      */     
/* 4044 */     this.jTextField61.setEditable(false);
/* 4045 */     this.jPanel24.add(this.jTextField61);
/*      */     
/* 4047 */     this.jTextField62.setEditable(false);
/* 4048 */     this.jPanel24.add(this.jTextField62);
/*      */     
/* 4050 */     this.jPanel23.add(this.jPanel24);
/*      */     
/* 4052 */     this.jPanel31.setBackground(new Color(255, 255, 255));
/* 4053 */     this.jPanel31.setForeground(new Color(255, 255, 255));
/* 4054 */     this.jPanel31.setLayout(new GridLayout(8, 1, 0, 6));
/*      */     
/* 4056 */     this.jTextField63.setEditable(false);
/* 4057 */     this.jPanel31.add(this.jTextField63);
/*      */     
/* 4059 */     this.jTextField64.setEditable(false);
/* 4060 */     this.jPanel31.add(this.jTextField64);
/*      */     
/* 4062 */     this.jTextField65.setEditable(false);
/* 4063 */     this.jPanel31.add(this.jTextField65);
/*      */     
/* 4065 */     this.jTextField66.setEditable(false);
/* 4066 */     this.jPanel31.add(this.jTextField66);
/*      */     
/* 4068 */     this.jTextField67.setEditable(false);
/* 4069 */     this.jPanel31.add(this.jTextField67);
/*      */     
/* 4071 */     this.jTextField68.setEditable(false);
/* 4072 */     this.jPanel31.add(this.jTextField68);
/*      */     
/* 4074 */     this.jTextField69.setEditable(false);
/* 4075 */     this.jPanel31.add(this.jTextField69);
/*      */     
/* 4077 */     this.jTextField70.setEditable(false);
/* 4078 */     this.jPanel31.add(this.jTextField70);
/*      */     
/* 4080 */     this.jPanel23.add(this.jPanel31);
/*      */     
/* 4082 */     this.jPanel96.setBackground(new Color(255, 255, 255));
/* 4083 */     this.jPanel96.setLayout(new GridLayout(1, 2, 6, 0));
/*      */     
/* 4085 */     this.jLabel51.setHorizontalAlignment(0);
/* 4086 */     this.jLabel51.setText("Datos fiscales anteriores");
/* 4087 */     this.jLabel51.setBorder(BorderFactory.createBevelBorder(1));
/* 4088 */     this.jPanel96.add(this.jLabel51);
/*      */     
/* 4090 */     this.jLabel52.setHorizontalAlignment(0);
/* 4091 */     this.jLabel52.setText("Nuevos datos fiscales");
/* 4092 */     this.jLabel52.setBorder(BorderFactory.createBevelBorder(1));
/* 4093 */     this.jPanel96.add(this.jLabel52);
/*      */     
/* 4095 */     this.jPanel25.setBackground(new Color(255, 255, 255));
/* 4096 */     this.jPanel25.setLayout(new GridLayout(8, 2, 6, 6));
/*      */     
/* 4098 */     this.jLabel3.setText(" Cliente");
/* 4099 */     this.jPanel25.add(this.jLabel3);
/*      */     
/* 4101 */     this.jLabel154.setHorizontalAlignment(4);
/* 4102 */     this.jLabel154.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Things_34164.png")));
/* 4103 */     this.jPanel25.add(this.jLabel154);
/*      */     
/* 4105 */     this.jLabel8.setText(" R.F.C.");
/* 4106 */     this.jPanel25.add(this.jLabel8);
/*      */     
/* 4108 */     this.jLabel155.setHorizontalAlignment(4);
/* 4109 */     this.jLabel155.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/* 4110 */     this.jPanel25.add(this.jLabel155);
/*      */     
/* 4112 */     this.jLabel82.setText(" Calle");
/* 4113 */     this.jPanel25.add(this.jLabel82);
/*      */     
/* 4115 */     this.jLabel156.setHorizontalAlignment(4);
/* 4116 */     this.jPanel25.add(this.jLabel156);
/*      */     
/* 4118 */     this.jLabel83.setText(" Número");
/* 4119 */     this.jPanel25.add(this.jLabel83);
/*      */     
/* 4121 */     this.jLabel160.setHorizontalAlignment(4);
/* 4122 */     this.jPanel25.add(this.jLabel160);
/*      */     
/* 4124 */     this.jLabel84.setText(" Colonia");
/* 4125 */     this.jPanel25.add(this.jLabel84);
/*      */     
/* 4127 */     this.jLabel161.setHorizontalAlignment(4);
/* 4128 */     this.jPanel25.add(this.jLabel161);
/*      */     
/* 4130 */     this.jLabel86.setText(" C.P.");
/* 4131 */     this.jPanel25.add(this.jLabel86);
/*      */     
/* 4133 */     this.jLabel163.setHorizontalAlignment(4);
/* 4134 */     this.jPanel25.add(this.jLabel163);
/*      */     
/* 4136 */     this.jLabel115.setText(" Ciudad");
/* 4137 */     this.jPanel25.add(this.jLabel115);
/*      */     
/* 4139 */     this.jLabel164.setHorizontalAlignment(4);
/* 4140 */     this.jPanel25.add(this.jLabel164);
/*      */     
/* 4142 */     this.jLabel116.setText(" Estado");
/* 4143 */     this.jPanel25.add(this.jLabel116);
/*      */     
/* 4145 */     this.jLabel165.setHorizontalAlignment(4);
/* 4146 */     this.jPanel25.add(this.jLabel165);
/*      */     
/* 4148 */     GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
/* 4149 */     this.jPanel21.setLayout(jPanel21Layout);
/* 4150 */     jPanel21Layout.setHorizontalGroup(jPanel21Layout
/* 4151 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4152 */         .addComponent(this.jLabel2, -1, 954, 32767)
/* 4153 */         .addGroup(jPanel21Layout.createSequentialGroup()
/* 4154 */           .addComponent(this.jPanel25, -2, 171, -2)
/* 4155 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4156 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4157 */             .addComponent(this.jPanel96, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 4158 */             .addComponent(this.jPanel23, -1, -1, 32767)
/* 4159 */             .addComponent(this.jPanel22, GroupLayout.Alignment.TRAILING, -1, -1, 32767))));
/*      */     
/* 4161 */     jPanel21Layout.setVerticalGroup(jPanel21Layout
/* 4162 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4163 */         .addGroup(jPanel21Layout.createSequentialGroup()
/* 4164 */           .addComponent(this.jLabel2, -2, -1, -2)
/* 4165 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4166 */           .addComponent(this.jPanel96, -2, 22, -2)
/* 4167 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4168 */           .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4169 */             .addComponent(this.jPanel25, -1, -1, 32767)
/* 4170 */             .addComponent(this.jPanel23, -1, -1, 32767))
/* 4171 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4172 */           .addComponent(this.jPanel22, -2, -1, -2)
/* 4173 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 4176 */     GroupLayout jDialog16Layout = new GroupLayout(this.jDialog16.getContentPane());
/* 4177 */     this.jDialog16.getContentPane().setLayout(jDialog16Layout);
/* 4178 */     jDialog16Layout.setHorizontalGroup(jDialog16Layout
/* 4179 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4180 */         .addGroup(jDialog16Layout.createSequentialGroup()
/* 4181 */           .addComponent(this.jPanel21, -1, -1, 32767)
/* 4182 */           .addGap(0, 0, 0)));
/*      */     
/* 4184 */     jDialog16Layout.setVerticalGroup(jDialog16Layout
/* 4185 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4186 */         .addComponent(this.jPanel21, -1, -1, 32767));
/*      */ 
/*      */     
/* 4189 */     this.jComboBox21.setBackground(new Color(244, 244, 244));
/* 4190 */     this.jComboBox21.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVAS", "TODAS", "<Por Pagar>", "<Pagada>", "<Abono>", "<Cancelada>" }));
/* 4191 */     this.jComboBox21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4193 */             Facturas.this.jComboBox21ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4197 */     this.jLabel58.setFont(new Font("Tahoma", 3, 12));
/* 4198 */     this.jLabel58.setForeground(new Color(15, 87, 51));
/* 4199 */     this.jLabel58.setHorizontalAlignment(0);
/* 4200 */     this.jLabel58.setText("Nuestro Pedido");
/*      */     
/* 4202 */     this.jLabel43.setFont(new Font("Tahoma", 3, 12));
/* 4203 */     this.jLabel43.setForeground(new Color(15, 87, 51));
/* 4204 */     this.jLabel43.setHorizontalAlignment(0);
/* 4205 */     this.jLabel43.setText("Equipo");
/*      */     
/* 4207 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/* 4208 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/* 4209 */     this.jComboBox5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4211 */             Facturas.this.jComboBox5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4215 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/* 4216 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/* 4217 */     this.jComboBox6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4219 */             Facturas.this.jComboBox6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4223 */     this.jLabel44.setFont(new Font("Tahoma", 3, 12));
/* 4224 */     this.jLabel44.setForeground(new Color(15, 87, 51));
/* 4225 */     this.jLabel44.setHorizontalAlignment(0);
/* 4226 */     this.jLabel44.setText("Plataforma");
/*      */     
/* 4228 */     this.jLabel45.setFont(new Font("Tahoma", 3, 12));
/* 4229 */     this.jLabel45.setForeground(new Color(15, 87, 51));
/* 4230 */     this.jLabel45.setHorizontalAlignment(0);
/* 4231 */     this.jLabel45.setText("Pozo");
/*      */     
/* 4233 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/* 4234 */     this.jComboBox7.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/* 4235 */     this.jComboBox7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4237 */             Facturas.this.jComboBox7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4241 */     GroupLayout jPanel98Layout = new GroupLayout(this.jPanel98);
/* 4242 */     this.jPanel98.setLayout(jPanel98Layout);
/* 4243 */     jPanel98Layout.setHorizontalGroup(jPanel98Layout
/* 4244 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4245 */         .addGroup(jPanel98Layout.createSequentialGroup()
/* 4246 */           .addContainerGap()
/* 4247 */           .addGroup(jPanel98Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4248 */             .addComponent(this.jComboBox5, -2, -1, -2)
/* 4249 */             .addComponent(this.jLabel43))
/* 4250 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4251 */           .addGroup(jPanel98Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4252 */             .addComponent(this.jComboBox21, -2, -1, -2)
/* 4253 */             .addComponent(this.jLabel58))
/* 4254 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4255 */           .addGroup(jPanel98Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4256 */             .addComponent(this.jComboBox6, -2, -1, -2)
/* 4257 */             .addComponent(this.jLabel45))
/* 4258 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4259 */           .addGroup(jPanel98Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4260 */             .addComponent(this.jLabel44)
/* 4261 */             .addComponent(this.jComboBox7, -2, -1, -2))
/* 4262 */           .addContainerGap(83, 32767)));
/*      */     
/* 4264 */     jPanel98Layout.setVerticalGroup(jPanel98Layout
/* 4265 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4266 */         .addGroup(jPanel98Layout.createSequentialGroup()
/* 4267 */           .addContainerGap()
/* 4268 */           .addGroup(jPanel98Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4269 */             .addComponent(this.jComboBox5, -2, -1, -2)
/* 4270 */             .addComponent(this.jComboBox21, -2, -1, -2)
/* 4271 */             .addComponent(this.jComboBox6, -2, -1, -2)
/* 4272 */             .addComponent(this.jComboBox7, -2, -1, -2))
/* 4273 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4274 */           .addGroup(jPanel98Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4275 */             .addComponent(this.jLabel43)
/* 4276 */             .addComponent(this.jLabel58)
/* 4277 */             .addComponent(this.jLabel45)
/* 4278 */             .addComponent(this.jLabel44))
/* 4279 */           .addContainerGap(136, 32767)));
/*      */ 
/*      */     
/* 4282 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 4283 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
/*      */     
/* 4285 */     this.jDialog1.setTitle("Catálogo de uso de comprobantes");
/*      */     
/* 4287 */     this.jTable8.setFont(new Font("Dialog", 0, 11));
/* 4288 */     this.jTable8.setModel(new DefaultTableModel(new Object[][] { { "G01", "ADQUISICIÓN DE MERCANCÍAS" }, , { "D06", "APORTACIONES VOLUNTARIAS AL SAR" }, , { "I07", "COMUNICACIONES SATELITALES" }, , { "I06", "COMUNICACIONES TELEFÓNICAS" }, , { "I01", "CONSTRUCCIONES" }, , { "I05", "DADOS, TROQUELES, MOLDES Y HERRAMENTAL" }, , { "D09", "DEPÓSITOS EN CUENTAS PARA EL AHORRO, PRIMAS QUE TENGAN COMO BASE PLANES DE PENSIONES" }, , { "G02", "DEVOLUCIONES, DESCUENTOS O BONIFICACIONES" }, , { "D04", "DONATIVOS" }, , { "I04", "EQUIPO DE CÓMPUTO Y ACCESORIOS" }, , { "I03", "EQUIPO DE TRANSPORTE" }, , { "D08", "GASTOS DE TRANSPORTACIÓN ESCOLAR OBLIGATORIA" }, , { "G03", "GASTOS EN GENERAL" }, , { "D03", "GASTOS FUNERALES" }, , { "D02", "GASTOS MÉDICOS POR INCAPACIDAD O DISCAPACIDAD" }, , { "D01", "HONORARIOS MEDICOS, DENTALES Y GASTOS HOSPITALARIOS" }, , { "D05", "INTERESES REALES EFECTIVAMENTE PAGADOS POR CRÉDITOS HIPOTECARIOS (CASA HABITACIÓN)" }, , { "I02", "MOBILIARIO Y EQUIPO DE OFICINA POR INVERSIONES" }, , { "I08", "OTRA MAQUINARIA Y EQUIPO" }, , { "D10", "PAGOS POR SERVICIOS EDUCATIVOS (COLEGIATURAS)" }, , { "P01", "POR DEFINIR" }, , { "D07", "PRIMAS POR SEGUROS DE GASTOS MEDICOS" },  }, (Object[])new String[] { "Clave", "Descripción" })
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
/* 4317 */           boolean[] canEdit = new boolean[] { false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4322 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4325 */     this.jTable8.setShowVerticalLines(false);
/* 4326 */     this.jTable8.getTableHeader().setReorderingAllowed(false);
/* 4327 */     this.jTable8.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 4329 */             Facturas.this.jTable8MouseClicked(evt);
/*      */           }
/*      */         });
/* 4332 */     this.jScrollPane15.setViewportView(this.jTable8);
/* 4333 */     if (this.jTable8.getColumnModel().getColumnCount() > 0) {
/* 4334 */       this.jTable8.getColumnModel().getColumn(0).setMinWidth(50);
/* 4335 */       this.jTable8.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 4336 */       this.jTable8.getColumnModel().getColumn(0).setMaxWidth(50);
/* 4337 */       this.jTable8.getColumnModel().getColumn(1).setResizable(false);
/*      */     } 
/*      */     
/* 4340 */     GroupLayout jPanel102Layout = new GroupLayout(this.jPanel102);
/* 4341 */     this.jPanel102.setLayout(jPanel102Layout);
/* 4342 */     jPanel102Layout.setHorizontalGroup(jPanel102Layout
/* 4343 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4344 */         .addComponent(this.jScrollPane15, -1, 543, 32767));
/*      */     
/* 4346 */     jPanel102Layout.setVerticalGroup(jPanel102Layout
/* 4347 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4348 */         .addComponent(this.jScrollPane15, GroupLayout.Alignment.TRAILING, -1, 223, 32767));
/*      */ 
/*      */     
/* 4351 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/* 4352 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/* 4353 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/* 4354 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4355 */         .addGap(0, 543, 32767)
/* 4356 */         .addGroup(jDialog1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4357 */           .addComponent(this.jPanel102, -1, -1, 32767)));
/*      */     
/* 4359 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/* 4360 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4361 */         .addGap(0, 223, 32767)
/* 4362 */         .addGroup(jDialog1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4363 */           .addComponent(this.jPanel102, -1, -1, 32767)));
/*      */ 
/*      */     
/* 4366 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/* 4367 */     this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 4369 */     this.jLabel54.setFont(new Font("Times New Roman", 1, 24));
/* 4370 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/* 4371 */     this.jLabel54.setText("Facturas");
/*      */     
/* 4373 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/* 4374 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 4376 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 4377 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Fecha", "Cliente", "Equipo", "Plataforma", "Pozo", "Subtotal", "Iva", "Ret", "Total", "Estatus" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4385 */     this.jTable3.setShowVerticalLines(false);
/* 4386 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 4388 */             Facturas.this.jTable3MouseClicked(evt);
/*      */           }
/*      */         });
/* 4391 */     this.jTable3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 4393 */             Facturas.this.jTable3KeyReleased(evt);
/*      */           }
/*      */         });
/* 4396 */     this.jScrollPane3.setViewportView(this.jTable3);
/*      */     
/* 4398 */     this.jLabel35.setFont(new Font("Tahoma", 1, 11));
/* 4399 */     this.jLabel35.setHorizontalAlignment(4);
/* 4400 */     this.jLabel35.setText("SUMAS:");
/*      */     
/* 4402 */     this.jLabel37.setFont(new Font("Tahoma", 0, 10));
/* 4403 */     this.jLabel37.setHorizontalAlignment(4);
/* 4404 */     this.jLabel37.setText("$0.00");
/*      */     
/* 4406 */     this.jLabel38.setFont(new Font("Tahoma", 0, 10));
/* 4407 */     this.jLabel38.setHorizontalAlignment(4);
/* 4408 */     this.jLabel38.setText("$0.00");
/*      */     
/* 4410 */     this.jLabel39.setFont(new Font("Tahoma", 0, 10));
/* 4411 */     this.jLabel39.setHorizontalAlignment(4);
/* 4412 */     this.jLabel39.setText("$0.00");
/*      */     
/* 4414 */     this.jLabel42.setFont(new Font("Tahoma", 0, 10));
/* 4415 */     this.jLabel42.setHorizontalAlignment(4);
/* 4416 */     this.jLabel42.setText("$0.00");
/*      */     
/* 4418 */     this.jPanel28.setBackground(new Color(146, 193, 134));
/* 4419 */     this.jPanel28.setLayout(new GridLayout(1, 9, 6, 6));
/*      */     
/* 4421 */     this.jPanel36.setBackground(new Color(146, 193, 134));
/* 4422 */     this.jPanel36.setLayout(new GridBagLayout());
/*      */     
/* 4424 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 4425 */     this.jLabel48.setForeground(Color.red);
/* 4426 */     this.jLabel48.setHorizontalAlignment(0);
/* 4427 */     this.jLabel48.setText("t");
/* 4428 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/* 4429 */     gridBagConstraints = new GridBagConstraints();
/* 4430 */     gridBagConstraints.fill = 2;
/* 4431 */     gridBagConstraints.anchor = 21;
/* 4432 */     gridBagConstraints.weightx = 1.0D;
/* 4433 */     this.jPanel36.add(this.jLabel48, gridBagConstraints);
/*      */     
/* 4435 */     this.jPanel28.add(this.jPanel36);
/*      */     
/* 4437 */     this.jButton24.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 4438 */     this.jButton24.setMnemonic('N');
/* 4439 */     this.jButton24.setText("Nueva");
/* 4440 */     this.jButton24.setToolTipText("Crear nuevas facturas (Alt+N)");
/* 4441 */     this.jButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4443 */             Facturas.this.jButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/* 4446 */     this.jPanel28.add(this.jButton24);
/*      */     
/* 4448 */     this.jButton46.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 4449 */     this.jButton46.setMnemonic('R');
/* 4450 */     this.jButton46.setText("Refacturar");
/* 4451 */     this.jButton46.setToolTipText("Refacturar (Alt+E)");
/* 4452 */     this.jButton46.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4454 */             Facturas.this.jButton46ActionPerformed(evt);
/*      */           }
/*      */         });
/* 4457 */     this.jPanel28.add(this.jButton46);
/*      */     
/* 4459 */     this.jButton23.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/* 4460 */     this.jButton23.setMnemonic('V');
/* 4461 */     this.jButton23.setText("Ver");
/* 4462 */     this.jButton23.setToolTipText("Ver detalles de la factura (Alt+V)");
/* 4463 */     this.jButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4465 */             Facturas.this.jButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/* 4468 */     this.jPanel28.add(this.jButton23);
/*      */     
/* 4470 */     this.jButton25.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 4471 */     this.jButton25.setMnemonic('C');
/* 4472 */     this.jButton25.setText("Cancelar");
/* 4473 */     this.jButton25.setToolTipText("Cancelar facturas (Alt+C)");
/* 4474 */     this.jButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4476 */             Facturas.this.jButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/* 4479 */     this.jPanel28.add(this.jButton25);
/*      */     
/* 4481 */     this.jButton26.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 4482 */     this.jButton26.setMnemonic('G');
/* 4483 */     this.jButton26.setText("Guardar Reporte");
/* 4484 */     this.jButton26.setToolTipText("Guardar reportes en hojas de cálculo (Alt+G)");
/* 4485 */     this.jButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4487 */             Facturas.this.jButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/* 4490 */     this.jPanel28.add(this.jButton26);
/*      */     
/* 4492 */     this.jButton15.setMnemonic('R');
/* 4493 */     this.jButton15.setText("Recepción");
/* 4494 */     this.jButton15.setToolTipText("Organiza quien recepcionó las facturas (Alt+R)");
/* 4495 */     this.jButton15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4497 */             Facturas.this.jButton15ActionPerformed(evt);
/*      */           }
/*      */         });
/* 4500 */     this.jPanel28.add(this.jButton15);
/*      */     
/* 4502 */     this.jButton28.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Comment.png")));
/* 4503 */     this.jButton28.setMnemonic('B');
/* 4504 */     this.jButton28.setText("Busq por conceptos");
/* 4505 */     this.jButton28.setToolTipText("Realiza una búsqueda personalizada por concepto");
/* 4506 */     this.jButton28.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4508 */             Facturas.this.jButton28ActionPerformed(evt);
/*      */           }
/*      */         });
/* 4511 */     this.jPanel28.add(this.jButton28);
/*      */     
/* 4513 */     this.jButton10.setMnemonic('O');
/* 4514 */     this.jButton10.setText("Conceptos");
/* 4515 */     this.jButton10.setToolTipText("Organiza los conceptos de las facturas (Alt+O)");
/* 4516 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4518 */             Facturas.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/* 4521 */     this.jPanel28.add(this.jButton10);
/*      */     
/* 4523 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 4524 */     this.jButton2.setMnemonic('I');
/* 4525 */     this.jButton2.setText("Imprimir");
/* 4526 */     this.jButton2.setToolTipText("Imprimir (Alt+I)");
/* 4527 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4529 */             Facturas.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 4532 */     this.jPanel28.add(this.jButton2);
/*      */     
/* 4534 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 4535 */     this.jPanel5.setLayout(jPanel5Layout);
/* 4536 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 4537 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4538 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
/* 4539 */           .addContainerGap(-1, 32767)
/* 4540 */           .addComponent(this.jLabel35, -2, 68, -2)
/* 4541 */           .addGap(33, 33, 33)
/* 4542 */           .addComponent(this.jLabel42, -2, 105, -2)
/* 4543 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4544 */           .addComponent(this.jLabel39, -2, 104, -2)
/* 4545 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4546 */           .addComponent(this.jLabel38, -2, 113, -2)
/* 4547 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4548 */           .addComponent(this.jLabel37, -2, 104, -2)
/* 4549 */           .addGap(252, 252, 252))
/* 4550 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
/* 4551 */           .addComponent(this.jPanel28, -2, 0, 32767)
/* 4552 */           .addContainerGap())
/* 4553 */         .addComponent(this.jScrollPane3));
/*      */     
/* 4555 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 4556 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4557 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 4558 */           .addGap(1, 1, 1)
/* 4559 */           .addComponent(this.jPanel28, -2, -1, -2)
/* 4560 */           .addGap(5, 5, 5)
/* 4561 */           .addComponent(this.jScrollPane3, -1, 195, 32767)
/* 4562 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4563 */           .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4564 */             .addComponent(this.jLabel37)
/* 4565 */             .addComponent(this.jLabel38)
/* 4566 */             .addComponent(this.jLabel39)
/* 4567 */             .addComponent(this.jLabel42)
/* 4568 */             .addComponent(this.jLabel35))));
/*      */ 
/*      */     
/* 4571 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 4572 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Facturas", 0, 0, new Font("Tahoma", 1, 11)));
/* 4573 */     this.jPanel17.setPreferredSize(new Dimension(826, 71));
/* 4574 */     this.jPanel17.setLayout(new GridLayout(2, 10, 6, 0));
/*      */     
/* 4576 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 4578 */             Facturas.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/* 4581 */     this.jPanel17.add(this.jTextField1);
/*      */     
/* 4583 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 4585 */             Facturas.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/* 4588 */     this.jPanel17.add(this.jTextField2);
/*      */     
/* 4590 */     this.jComboBox22.setBackground(new Color(244, 244, 244));
/* 4591 */     this.jComboBox22.setModel(new DefaultComboBoxModel<>(new String[] { "TODAS", "<Sustituidas>", "<Sustituyen>" }));
/* 4592 */     this.jComboBox22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4594 */             Facturas.this.jComboBox22ActionPerformed(evt);
/*      */           }
/*      */         });
/* 4597 */     this.jPanel17.add(this.jComboBox22);
/*      */     
/* 4599 */     this.jComboBox8.setBackground(new Color(244, 244, 244));
/* 4600 */     this.jComboBox8.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVAS", "TODAS", "<Por Pagar>", "<Pagada>", "<Abono>", "<Cancelada>" }));
/* 4601 */     this.jComboBox8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4603 */             Facturas.this.jComboBox8ActionPerformed(evt);
/*      */           }
/*      */         });
/* 4606 */     this.jPanel17.add(this.jComboBox8);
/*      */     
/* 4608 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/* 4609 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/* 4610 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4612 */             Facturas.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 4615 */     this.jPanel17.add(this.jComboBox3);
/*      */     
/* 4617 */     this.jComboBox11.setBackground(new Color(244, 244, 244));
/* 4618 */     this.jComboBox11.setModel(new DefaultComboBoxModel<>(new String[] { "Cualquiera" }));
/* 4619 */     this.jComboBox11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4621 */             Facturas.this.jComboBox11ActionPerformed(evt);
/*      */           }
/*      */         });
/* 4624 */     this.jPanel17.add(this.jComboBox11);
/*      */     
/* 4626 */     this.jLabel15.setFont(new Font("Tahoma", 3, 12));
/* 4627 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 4628 */     this.jLabel15.setHorizontalAlignment(0);
/* 4629 */     this.jLabel15.setText("Folio");
/* 4630 */     this.jPanel17.add(this.jLabel15);
/*      */     
/* 4632 */     this.jLabel34.setFont(new Font("Tahoma", 3, 12));
/* 4633 */     this.jLabel34.setForeground(new Color(15, 87, 51));
/* 4634 */     this.jLabel34.setHorizontalAlignment(0);
/* 4635 */     this.jLabel34.setText("Su pedido");
/* 4636 */     this.jPanel17.add(this.jLabel34);
/*      */     
/* 4638 */     this.jLabel166.setFont(new Font("Tahoma", 3, 12));
/* 4639 */     this.jLabel166.setForeground(new Color(15, 87, 51));
/* 4640 */     this.jLabel166.setHorizontalAlignment(0);
/* 4641 */     this.jLabel166.setText("Refacturadas");
/* 4642 */     this.jPanel17.add(this.jLabel166);
/*      */     
/* 4644 */     this.jLabel46.setFont(new Font("Tahoma", 3, 12));
/* 4645 */     this.jLabel46.setForeground(new Color(15, 87, 51));
/* 4646 */     this.jLabel46.setHorizontalAlignment(0);
/* 4647 */     this.jLabel46.setText("Estatus");
/* 4648 */     this.jPanel17.add(this.jLabel46);
/*      */     
/* 4650 */     this.jLabel41.setFont(new Font("Tahoma", 3, 12));
/* 4651 */     this.jLabel41.setForeground(new Color(15, 87, 51));
/* 4652 */     this.jLabel41.setHorizontalAlignment(0);
/* 4653 */     this.jLabel41.setText("Cliente");
/* 4654 */     this.jPanel17.add(this.jLabel41);
/*      */     
/* 4656 */     this.jLabel47.setFont(new Font("Tahoma", 3, 12));
/* 4657 */     this.jLabel47.setForeground(new Color(15, 87, 51));
/* 4658 */     this.jLabel47.setHorizontalAlignment(0);
/* 4659 */     this.jLabel47.setText("Usuario");
/* 4660 */     this.jPanel17.add(this.jLabel47);
/*      */     
/* 4662 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/* 4663 */     this.jPanel2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
/*      */     
/* 4665 */     this.jDateChooser4.setDate(this.fechaActual);
/* 4666 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/* 4667 */     this.jDateChooser4.setIcon(this.icon);
/* 4668 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/* 4669 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 4671 */     this.jDateChooser5.setDate(this.fechaActual);
/* 4672 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 4673 */     this.jDateChooser5.setIcon(this.icon);
/* 4674 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 4676 */     this.jLabel5.setFont(new Font("Tahoma", 2, 12));
/* 4677 */     this.jLabel5.setForeground(new Color(15, 87, 51));
/* 4678 */     this.jLabel5.setText("<html><u>Todos </u></html>");
/* 4679 */     this.jLabel5.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 4681 */             Facturas.this.jLabel5MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 4684 */             Facturas.this.jLabel5MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 4687 */             Facturas.this.jLabel5MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 4691 */     this.jLabel6.setFont(new Font("Tahoma", 2, 12));
/* 4692 */     this.jLabel6.setForeground(new Color(15, 87, 51));
/* 4693 */     this.jLabel6.setHorizontalAlignment(0);
/* 4694 */     this.jLabel6.setText("<html><u>Hoy</u></html>");
/* 4695 */     this.jLabel6.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 4697 */             Facturas.this.jLabel6MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 4700 */             Facturas.this.jLabel6MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 4703 */             Facturas.this.jLabel6MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 4707 */     this.jLabel7.setFont(new Font("Tahoma", 2, 12));
/* 4708 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/* 4709 */     this.jLabel7.setText("<html><u>Ayer</u></html>");
/* 4710 */     this.jLabel7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 4712 */             Facturas.this.jLabel7MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 4715 */             Facturas.this.jLabel7MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 4718 */             Facturas.this.jLabel7MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 4722 */     this.jLabel1.setFont(new Font("Tahoma", 1, 15));
/* 4723 */     this.jLabel1.setForeground(Color.red);
/* 4724 */     this.jLabel1.setHorizontalAlignment(4);
/* 4725 */     this.jLabel1.setText("REPORTE DEL");
/*      */     
/* 4727 */     this.jLabel4.setFont(new Font("Tahoma", 1, 15));
/* 4728 */     this.jLabel4.setForeground(Color.red);
/* 4729 */     this.jLabel4.setHorizontalAlignment(0);
/* 4730 */     this.jLabel4.setText("AL");
/*      */     
/* 4732 */     this.jButton1.setMnemonic('F');
/* 4733 */     this.jButton1.setText("Filtrar");
/* 4734 */     this.jButton1.setToolTipText("Filtrar información (Alt+F)");
/* 4735 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 4737 */             Facturas.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 4741 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 4742 */     this.jPanel2.setLayout(jPanel2Layout);
/* 4743 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 4744 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4745 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 4746 */           .addContainerGap()
/* 4747 */           .addComponent(this.jLabel1, -2, 130, -2)
/* 4748 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4749 */           .addComponent((Component)this.jDateChooser4, -2, 108, -2)
/* 4750 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4751 */           .addComponent(this.jLabel4)
/* 4752 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 4753 */           .addComponent((Component)this.jDateChooser5, -2, 108, -2)
/* 4754 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4755 */           .addComponent(this.jButton1)
/* 4756 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4757 */           .addComponent(this.jLabel5, -2, -1, -2)
/* 4758 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4759 */           .addComponent(this.jLabel6, -2, 31, -2)
/* 4760 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4761 */           .addComponent(this.jLabel7, -2, 31, -2)
/* 4762 */           .addContainerGap(21, 32767)));
/*      */     
/* 4764 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 4765 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4766 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 4767 */           .addContainerGap()
/* 4768 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4769 */             .addComponent(this.jLabel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 4770 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 4771 */               .addGap(1, 1, 1)
/* 4772 */               .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4773 */                 .addComponent((Component)this.jDateChooser4, GroupLayout.Alignment.TRAILING, -2, -1, -2)
/* 4774 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 4775 */                   .addComponent(this.jLabel5, -2, 19, -2)
/* 4776 */                   .addComponent(this.jLabel6, -2, 15, -2)
/* 4777 */                   .addComponent(this.jLabel7, -2, -1, -2)
/* 4778 */                   .addComponent(this.jButton1))
/* 4779 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
/* 4780 */                   .addComponent(this.jLabel4, -2, 19, -2)
/* 4781 */                   .addGap(1, 1, 1))
/* 4782 */                 .addComponent((Component)this.jDateChooser5, GroupLayout.Alignment.TRAILING, -2, -1, -2))))));
/*      */ 
/*      */     
/* 4785 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 4786 */     this.jPanel1.setLayout(jPanel1Layout);
/* 4787 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 4788 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4789 */         .addComponent(this.jPanel5, -1, -1, 32767)
/* 4790 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 4791 */           .addContainerGap()
/* 4792 */           .addComponent(this.jPanel2, -2, -1, -2)
/* 4793 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4794 */           .addComponent(this.jLabel54, -1, -1, 32767)
/* 4795 */           .addGap(6, 6, 6))
/* 4796 */         .addComponent(this.jPanel17, -2, 0, 32767));
/*      */     
/* 4798 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 4799 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4800 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 4801 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 4802 */             .addComponent(this.jLabel54, -1, -1, 32767)
/* 4803 */             .addComponent(this.jPanel2, -1, -1, 32767))
/* 4804 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4805 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 4806 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 4807 */           .addComponent(this.jPanel5, -1, -1, 32767)
/* 4808 */           .addContainerGap()));
/*      */ 
/*      */     
/* 4811 */     GroupLayout layout = new GroupLayout(this);
/* 4812 */     setLayout(layout);
/* 4813 */     layout.setHorizontalGroup(layout
/* 4814 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4815 */         .addGap(0, 1029, 32767)
/* 4816 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4817 */           .addComponent(this.jPanel1, -1, -1, 32767)));
/*      */     
/* 4819 */     layout.setVerticalGroup(layout
/* 4820 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4821 */         .addGap(0, 426, 32767)
/* 4822 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 4823 */           .addGroup(layout.createSequentialGroup()
/* 4824 */             .addContainerGap()
/* 4825 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 4826 */             .addContainerGap())));
/*      */   }
/*      */   private JPanel jPanel97; private JPanel jPanel98; private JPanel jPanel99; private JRadioButton jRadioButton1; private JRadioButton jRadioButton2; private JScrollPane jScrollPane1; private JScrollPane jScrollPane10; private JScrollPane jScrollPane11; private JScrollPane jScrollPane12; private JScrollPane jScrollPane13; private JScrollPane jScrollPane14; private JScrollPane jScrollPane15; private JScrollPane jScrollPane18; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4; private JScrollPane jScrollPane5; private JScrollPane jScrollPane6; private JScrollPane jScrollPane7; private JScrollPane jScrollPane8; private JScrollPane jScrollPane9; private JSeparator jSeparator1; private JSeparator jSeparator10; private JSeparator jSeparator11; private JSeparator jSeparator2; private JSeparator jSeparator23; private JSeparator jSeparator26; private JSeparator jSeparator27; private JSeparator jSeparator28; private JSeparator jSeparator29; private JSeparator jSeparator3; private JSeparator jSeparator35; private JSeparator jSeparator36; private JSeparator jSeparator37; private JSeparator jSeparator38; private JSeparator jSeparator5; private JSeparator jSeparator6; private JSlider jSlider1; private JSpinner jSpinner1; private JTable jTable1; private JTable jTable10; private JTable jTable12; private JTable jTable2; private JTable jTable3; private JTable jTable4; private JTable jTable5; private JTable jTable6; private JTable jTable7; private JTable jTable8; private JTextArea jTextArea1; private JTextArea jTextArea2; private JTextArea jTextArea5; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField13; private JTextField jTextField14; private JTextField jTextField15; private JTextField jTextField16; private JTextField jTextField17; private JTextField jTextField18; private JTextField jTextField19; private JTextField jTextField2; private JTextField jTextField20; private JTextField jTextField21; private JTextField jTextField22; private JTextField jTextField23; private JTextField jTextField24; private JTextField jTextField25; private JTextField jTextField26; private JTextField jTextField27; private JTextField jTextField28; private JTextField jTextField29; private JTextField jTextField3; private JTextField jTextField30; private JTextField jTextField31; private JTextField jTextField32; private JTextField jTextField33; private JTextField jTextField34; private JTextField jTextField35; private JTextField jTextField36; private JTextField jTextField37; private JTextField jTextField38; private JTextField jTextField39; private JTextField jTextField4; private JTextField jTextField40; private JTextField jTextField41; private JTextField jTextField42; private JTextField jTextField43; private JTextField jTextField44; private JTextField jTextField45; private JTextField jTextField46; private JTextField jTextField47; private JTextField jTextField48; private JTextField jTextField49; private JTextField jTextField5; private JTextField jTextField50; private JTextField jTextField51; private JTextField jTextField52; private JTextField jTextField53; private JTextField jTextField54; private JTextField jTextField55; private JTextField jTextField56; private JTextField jTextField57; private JTextField jTextField58; private JTextField jTextField59; private JTextField jTextField6; private JTextField jTextField60; private JTextField jTextField61; private JTextField jTextField62; private JTextField jTextField63; private JTextField jTextField64; private JTextField jTextField65; private JTextField jTextField66; private JTextField jTextField67; private JTextField jTextField68; private JTextField jTextField69; private JTextField jTextField7; private JTextField jTextField70; private JTextField jTextField71; private JTextField jTextField8; private JTextField jTextField9; private JTextPane jTextPane1; private JTextPane jTextPane2;
/*      */   
/*      */   private void jTable3MouseClicked(MouseEvent evt) {
/* 4831 */     if (evt.getClickCount() == 2) {
/* 4832 */       this.REFACTURAR = false;
/* 4833 */       this.jPanel99.setVisible(false);
/* 4834 */       this.jDialog11.setTitle("Factura");
/* 4835 */       verFactura();
/*      */     } else {
/* 4837 */       sacarPrivilegios();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTable3KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 4846 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 4850 */     if (this.jComboBox3.getItemCount() > 0 && this.PRIMERA == true) {
/* 4851 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox5ActionPerformed(ActionEvent evt) {
/* 4856 */     if (this.jComboBox5.getItemCount() > 0 && this.PRIMERA == true) {
/* 4857 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox6ActionPerformed(ActionEvent evt) {
/* 4862 */     if (this.jComboBox6.getItemCount() > 0 && this.PRIMERA == true) {
/* 4863 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox7ActionPerformed(ActionEvent evt) {
/* 4868 */     if (this.jComboBox7.getItemCount() > 0 && this.PRIMERA == true) {
/* 4869 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox8ActionPerformed(ActionEvent evt) {
/* 4874 */     if (this.jComboBox8.getItemCount() > 0 && this.PRIMERA == true) {
/* 4875 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabel5MouseClicked(MouseEvent evt) {
/* 4880 */     this.jDateChooser4.setDate(this.fechaInicio);
/* 4881 */     this.jDateChooser5.setDate(this.fechaActual);
/* 4882 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel5MouseEntered(MouseEvent evt) {
/* 4886 */     this.jLabel5.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel5MouseExited(MouseEvent evt) {
/* 4890 */     this.jLabel5.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel6MouseClicked(MouseEvent evt) {
/* 4894 */     this.jDateChooser5.setDate(this.fechaActual);
/* 4895 */     this.jDateChooser4.setDate(this.fechaActual);
/* 4896 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel6MouseEntered(MouseEvent evt) {
/* 4900 */     this.jLabel6.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel6MouseExited(MouseEvent evt) {
/* 4904 */     this.jLabel6.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel7MouseClicked(MouseEvent evt) {
/* 4908 */     Calendar ca = Calendar.getInstance();
/* 4909 */     Calendar fecha = Calendar.getInstance();
/* 4910 */     int aa = fecha.get(1);
/* 4911 */     int mm = fecha.get(2);
/* 4912 */     int dd = fecha.get(5);
/* 4913 */     if (dd == 1) {
/* 4914 */       if (mm == 0) {
/* 4915 */         mm = 11;
/* 4916 */         aa--;
/*      */       } else {
/* 4918 */         mm--;
/*      */       } 
/* 4920 */       int diasTotal = diasDelMes(mm, aa);
/* 4921 */       dd = diasTotal;
/*      */     } else {
/* 4923 */       dd--;
/*      */     } 
/* 4925 */     mm++;
/* 4926 */     String año = "" + aa;
/* 4927 */     String mes = "" + mm;
/* 4928 */     String dia = "" + dd;
/* 4929 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4930 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 4932 */       this.jDateChooser4.setDate(formatoDelTexto.parse(strFecha));
/* 4933 */       this.jDateChooser5.setDate(formatoDelTexto.parse(strFecha));
/* 4934 */     } catch (ParseException ex) {
/* 4935 */       ex.printStackTrace();
/*      */     } 
/* 4937 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel7MouseEntered(MouseEvent evt) {
/* 4941 */     this.jLabel7.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel7MouseExited(MouseEvent evt) {
/* 4945 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 4949 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton23ActionPerformed(ActionEvent evt) {
/* 4953 */     int ind = this.jTable3.getSelectedRow();
/* 4954 */     if (ind < 0) {
/* 4955 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una factura para ver los datos", "Selecciona una factura", 0, this.ADVER);
/*      */     } else {
/* 4957 */       this.REFACTURAR = false;
/* 4958 */       this.jDialog11.setTitle("Factura");
/* 4959 */       verFactura();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton24ActionPerformed(ActionEvent evt) {
/* 4964 */     this.jPanel99.setVisible(false);
/* 4965 */     this.DESC_MOTIVO = "";
/* 4966 */     this.DESC_PORCENTAJE = 0;
/* 4967 */     this.jFormattedTextField10.setValue(Integer.valueOf(0));
/* 4968 */     this.modelo = new DefaultTableModel();
/* 4969 */     this.jTable2.setModel(this.modelo);
/* 4970 */     this.modelo.addColumn("Folio");
/* 4971 */     this.modelo.addColumn("Ref");
/* 4972 */     this.modelo.addColumn("Subtotal");
/* 4973 */     this.modelo.addColumn("Iva");
/* 4974 */     this.modelo.addColumn("Retención");
/* 4975 */     this.modelo.addColumn("Total");
/* 4976 */     this.jTable2.setSelectionMode(0);
/* 4977 */     this.jTable2.setAutoCreateRowSorter(true);
/* 4978 */     this.jTable2.getTableHeader().setReorderingAllowed(false);
/* 4979 */     this.jTable2.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 4980 */     this.jTable2.getColumnModel().getColumn(0).setMaxWidth(50);
/* 4981 */     limpiarTablaConcep();
/* 4982 */     consultarPre();
/* 4983 */     this.jDialog5.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton25ActionPerformed(ActionEvent evt) {
/* 4987 */     this.jTextArea5.setText("");
/* 4988 */     int ind = this.jTable3.getSelectedRow();
/* 4989 */     if (ind < 0) {
/* 4990 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una factura para poder cancelar el documento", "Selecciona una factura", 0, this.ERROR);
/*      */     } else {
/* 4992 */       String estatus = String.valueOf(this.jTable3.getValueAt(ind, 12));
/* 4993 */       if (!estatus.contains("Por Pagar")) {
/* 4994 */         JOptionPane.showMessageDialog(this.padre, "No puedes cancelar la factura porque su estatus no es '<Por Pagar>'", "No se puede cancelar", 0, this.ERROR);
/*      */       } else {
/* 4996 */         this.con.consultar("tarjeta", "facturas", "where folio='" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1)) + "'");
/* 4997 */         this.TARJETA = this.con.Campo;
/* 4998 */         this.jDialog8.setVisible(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton35ActionPerformed(ActionEvent evt) {
/* 5004 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton36ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField32FocusLost(FocusEvent evt) {
/* 5012 */     String guia = this.jTextField32.getText();
/* 5013 */     this.jDateChooser7.setDate(new Date());
/* 5014 */     this.jTextField35.setText("");
/* 5015 */     this.jTextField34.setText("");
/* 5016 */     this.jTextField36.setText("");
/* 5017 */     this.jFormattedTextField9.setValue(Integer.valueOf(0));
/* 5018 */     this.jTextField33.setText("");
/*      */     
/* 5020 */     if (!guia.equals("")) {
/* 5021 */       this.encontrado = this.con.consultar("guias.fecha", "llamadas_historicas,guias,vales,pozos,emp_destinataria", "where llamadas_historicas.num_guia = guias.num_guia and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_desti = emp_destinataria.clave_desti and guias.num_vale = vales.num_vale and guias.num_guia like '%" + guia + "%'");
/* 5022 */       if (this.encontrado) {
/* 5023 */         String[] datos = this.con.regresaReg("guias.fecha,rsp,pozos.nombre,nombreCorto,peso,guias.servicio", "llamadas_historicas,guias,vales,pozos,emp_destinataria", "where llamadas_historicas.num_guia = guias.num_guia and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_desti = emp_destinataria.clave_desti and guias.num_vale = vales.num_vale and guias.num_guia like '%" + guia + "%'", 6);
/* 5024 */         String año = datos[0].substring(0, 4);
/* 5025 */         String mes = datos[0].substring(5, 7);
/* 5026 */         String dia = datos[0].substring(8, 10);
/* 5027 */         SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 5028 */         String strFecha = dia + "-" + dia + "-" + mes;
/* 5029 */         Date fechaG = null;
/*      */         try {
/* 5031 */           fechaG = formatoDelTexto.parse(strFecha);
/* 5032 */           this.jDateChooser7.setDate(fechaG);
/* 5033 */         } catch (ParseException ex) {
/* 5034 */           ex.printStackTrace();
/*      */         } 
/*      */         
/* 5037 */         if (datos[5].equals("SERVICIO INTEGRAL")) {
/* 5038 */           this.encontrado = this.con.consultar("manifiesto", "manifiestos_recorteaceite", "where num_guia like '%" + guia + "%'");
/* 5039 */           if (this.encontrado) {
/* 5040 */             this.jTextField33.setText(this.con.Campo);
/*      */           } else {
/* 5042 */             this.con.consultar("manifiesto", "manifiestos_lodoagua", "where num_guia like '%" + guia + "%'");
/* 5043 */             this.jTextField33.setText(this.con.Campo);
/*      */           } 
/*      */         } else {
/* 5046 */           this.jTextField33.setText("");
/*      */         } 
/* 5048 */         this.jTextField35.setText(datos[1]);
/* 5049 */         this.jTextField34.setText(datos[2]);
/* 5050 */         this.jTextField36.setText(datos[3]);
/* 5051 */         this.jFormattedTextField9.setValue(Double.valueOf(Double.parseDouble(datos[4])));
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton39ActionPerformed(ActionEvent evt) {
/* 5057 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 5065 */     if (this.jTable1.getSelectedRow() < 0) {
/* 5066 */       JOptionPane.showMessageDialog(this.jDialog5, "Necesitas seleccionar una prefactura", "Selecciona una prefactura", 0, this.ADVER);
/*      */     } else {
/* 5068 */       String clave1 = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0));
/* 5069 */       for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/* 5070 */         String clave2 = String.valueOf(this.jTable2.getValueAt(i, 0));
/* 5071 */         if (clave1.equals(clave2)) {
/* 5072 */           JOptionPane.showMessageDialog(this.jDialog5, "La prefactura que deseas agregar ya se encuentra almacenada\nVerifica tuinformaicón", "Prefactura duplicada", 0, this.ADVER);
/*      */           return;
/*      */         } 
/*      */       } 
/* 5076 */       Object[] reg = { this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0), this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1), this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2), this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3), this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4), this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 5) };
/* 5077 */       this.modelo.addRow(reg);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField6KeyReleased(KeyEvent evt) {
/* 5082 */     consultarPre();
/*      */   }
/*      */   
/*      */   private void jTextField7KeyReleased(KeyEvent evt) {
/* 5086 */     consultarPre();
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 5090 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 5094 */     if (this.jTable2.getRowCount() > 0) {
/* 5095 */       this.modelo.removeRow(this.jTable2.getSelectedRow());
/*      */     } else {
/* 5097 */       JOptionPane.showMessageDialog(this, "No existe ningún registro para quitarlo", "No hay Registros", 0, this.ERROR);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 5102 */     if (this.jTable2.getRowCount() == 0) {
/* 5103 */       JOptionPane.showMessageDialog(this.jDialog5, "Por lo menos necesitas seleccionar una prefactura para comenzar", "Selecciona una prefactura", 0, this.ADVER);
/*      */     } else {
/* 5105 */       this.REFACTURAR = false;
/* 5106 */       this.jDialog11.setTitle("Factura");
/* 5107 */       this.jButton41.setText("Modificar");
/* 5108 */       this.jTable4.setModel(this.jTable2.getModel());
/* 5109 */       sacarSumas();
/* 5110 */       limpiar();
/* 5111 */       cargarPre();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTable1MouseClicked(MouseEvent evt) {
/* 5116 */     if (evt.getClickCount() == 2) {
/* 5117 */       String clave1 = String.valueOf(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0));
/* 5118 */       for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/* 5119 */         String clave2 = String.valueOf(this.jTable2.getValueAt(i, 0));
/* 5120 */         if (clave1.equals(clave2)) {
/* 5121 */           JOptionPane.showMessageDialog(this.jDialog5, "La prefactura que deseas agregar ya se encuentra almacenada\nVerifica tuinformaicón", "Prefactura duplicada", 0, this.ADVER);
/*      */           return;
/*      */         } 
/*      */       } 
/* 5125 */       Object[] reg = { this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0), this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1), this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2), this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 3), this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 4), this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 5) };
/* 5126 */       this.modelo.addRow(reg);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTable2MouseClicked(MouseEvent evt) {
/* 5131 */     if (evt.getClickCount() == 2) {
/* 5132 */       this.modelo.removeRow(this.jTable2.getSelectedRow());
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox11ActionPerformed(ActionEvent evt) {
/* 5137 */     if (this.jComboBox11.getItemCount() > 0 && this.PRIMERA == true) {
/* 5138 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTextField5ActionPerformed(ActionEvent evt) {
/* 5143 */     int res = JOptionPane.showConfirmDialog(this.jDialog7, "¿Estás seguro que deseas modificar el comentario?", "Modificar comentario", 0, 3, this.PREG);
/* 5144 */     if (res == 0) {
/* 5145 */       this.jTable10.setValueAt(this.jTextField5.getText().toUpperCase(), this.jTable10.getSelectedRow(), 7);
/* 5146 */       this.jDialog7.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton16ActionPerformed(ActionEvent evt) {
/* 5151 */     this.jDialog7.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton17ActionPerformed(ActionEvent evt) {
/* 5155 */     if (this.jTextField5.getText().length() > 10) {
/* 5156 */       JOptionPane.showMessageDialog(this.jDialog7, "No puedes colocar un comentario mayor a 10 caracteres", "Tamaño muy grande", 0, this.ERROR);
/*      */     } else {
/* 5158 */       int res = JOptionPane.showConfirmDialog(this.jDialog7, "¿Estás seguro que deseas modificar el comentario?", "Modificar comentario", 0, 3, this.PREG);
/* 5159 */       if (res == 0) {
/* 5160 */         this.jTable10.setValueAt(this.jTextField5.getText().toUpperCase(), this.jTable10.getSelectedRow(), 7);
/* 5161 */         this.jDialog7.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton44ActionPerformed(ActionEvent evt) {
/* 5167 */     cancelar();
/*      */   }
/*      */   
/*      */   private void jButton45ActionPerformed(ActionEvent evt) {
/* 5171 */     this.jDialog8.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton26ActionPerformed(ActionEvent evt) {
/* 5175 */     String[] datos = { "CONSECUTIVO", "FOLIO", "FECHA", "CLIENTE", "RECEPCIÓN", "SU PEDIDO", "SUSTITUIDA POR", "SUSTITUYE A", "SUBTOTAL", "IVA", "RETENCIÓN", "TOTAL", "ESTATUS", "DOCUMENTÓ" };
/* 5176 */     this.esc = new EscribirReporte("FACTURAS", this.jTable3, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 5180 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 5184 */     int ind = this.jTable4.getSelectedRow();
/* 5185 */     if (ind < 0) {
/* 5186 */       JOptionPane.showMessageDialog(this.jDialog6, "Necesitas seleccionar una prefactura para ver los datos", "Selecciona una prefactura", 0, this.ADVER);
/*      */     } else {
/* 5188 */       verPrefactura(String.valueOf(this.jTable4.getValueAt(ind, 0)));
/* 5189 */       this.jDialog9.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 5194 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTable4MouseClicked(MouseEvent evt) {
/* 5198 */     if (evt.getClickCount() == 2) {
/* 5199 */       verPrefactura(String.valueOf(this.jTable4.getValueAt(this.jTable4.getSelectedRow(), 0)));
/* 5200 */       this.jDialog9.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 5205 */     ImprimirFacturas imprimir = new ImprimirFacturas();
/* 5206 */     imprimir.recibeDatos();
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 5210 */     sacarMayor();
/* 5211 */     this.jTextField46.setText("");
/* 5212 */     this.jTextField29.setText("");
/* 5213 */     this.jFormattedTextField5.setValue(Integer.valueOf(0));
/* 5214 */     this.jTextField9.setEnabled(true);
/* 5215 */     this.jButton12.setText("Agregar");
/* 5216 */     consultarConceptos();
/* 5217 */     this.jDialog10.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 5221 */     this.jDialog10.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 5225 */     int indice = this.jTable6.getSelectedRow();
/* 5226 */     if (indice < 0) {
/* 5227 */       JOptionPane.showMessageDialog(this.jDialog10, "Necesitas seleccionar un concepto para poder quitarlo", "Selecciona un concepto", 0, this.ADVER);
/*      */     } else {
/* 5229 */       int res = JOptionPane.showConfirmDialog(this.jDialog10, "Estás seguro que deseas eliminar el concepto que seleccionaste?", "Eliminar Concepto", 0, 3, this.ELIMINAR);
/* 5230 */       if (res == 0) {
/* 5231 */         this.con.eliminar2("conceptosfact", "where num=" + String.valueOf(this.jTable6.getValueAt(indice, 0)));
/* 5232 */         consultarConceptos();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 5238 */     if (this.jButton12.getText().equals("Agregar")) {
/* 5239 */       agregarConceptos();
/*      */     } else {
/* 5241 */       String clave = this.jTextField9.getText();
/* 5242 */       String concepto = this.jTextField29.getText();
/* 5243 */       Double valor = Double.valueOf(Double.parseDouble(String.valueOf(this.jFormattedTextField5.getValue())));
/* 5244 */       if (this.jComboBox18.getSelectedIndex() == 0) {
/* 5245 */         this.jComboBox18.setBackground(Color.RED);
/* 5246 */         JOptionPane.showMessageDialog(this.jDialog10, "No puedes dejar vacío el dato para colocar el cliente", "Coloca el cliente", 0, this.ERROR);
/* 5247 */       } else if (this.jTextField46.getText().equals("")) {
/* 5248 */         this.jTextField46.setBackground(Color.RED);
/* 5249 */         JOptionPane.showMessageDialog(this.jDialog10, "No puedes dejar vacío el dato para colocar la unidad", "Unidad Vacía", 0, this.ERROR);
/* 5250 */       } else if (concepto.equals("")) {
/* 5251 */         this.jTextField29.setBackground(Color.RED);
/* 5252 */         JOptionPane.showMessageDialog(this.jDialog10, "No puedes dejar vacío el dato para colocar el concepto", "Sin concepto", 0, this.ERROR);
/* 5253 */       } else if (valor.doubleValue() <= 0.0D) {
/* 5254 */         this.jFormattedTextField5.setBackground(Color.RED);
/* 5255 */         JOptionPane.showMessageDialog(this.jDialog10, "No puedes agregar cantidades menores a un peso", "Revisa la cantidad", 0, this.ERROR);
/*      */       } else {
/* 5257 */         int res = JOptionPane.showConfirmDialog(this, "¿Estás seguro que deseas modificar los datos?", "Modificar datos", 0, 3, this.PREG);
/* 5258 */         if (res == 0) {
/* 5259 */           this.con.inserSinMsj("update conceptosfact set unidad = '" + this.jTextField46.getText().toUpperCase() + "', concepto = '" + this.jTextField29.getText().toUpperCase() + "', cantidad = " + String.valueOf(this.jFormattedTextField5.getValue()) + ", cantidadLetra = '" + this.jFormattedTextField5.getText() + "',cliente='" + String.valueOf(this.jComboBox18.getSelectedItem()) + "' where clave = '" + this.jTextField9.getText() + "'");
/* 5260 */           this.jTextField9.setText("");
/* 5261 */           this.jTextField46.setText("");
/* 5262 */           this.jTextField29.setText("");
/* 5263 */           this.jFormattedTextField5.setValue(Integer.valueOf(0));
/* 5264 */           this.jTextField9.setEnabled(true);
/*      */           
/* 5266 */           this.jButton12.setText("Agregar");
/* 5267 */           consultarConceptos();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField29ActionPerformed(ActionEvent evt) {
/* 5274 */     agregarConceptos();
/*      */   }
/*      */   
/*      */   private void jButton14ActionPerformed(ActionEvent evt) {
/* 5278 */     String[] datos = { "NÚM", "CLIENTE", "CLAVE", "UNIDAD", "CONCEPTO", "CANTIDAD" };
/* 5279 */     this.esc = new EscribirReporte("CONCEPTOS", this.jTable6, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jComboBox14ActionPerformed(ActionEvent evt) {
/* 5283 */     if (this.jComboBox14.getSelectedIndex() == 0) {
/* 5284 */       this.jRadioButton1.setSelected(true);
/* 5285 */       this.jRadioButton1.setEnabled(false);
/* 5286 */       this.jRadioButton2.setEnabled(false);
/* 5287 */       this.jSpinner1.setEnabled(false);
/* 5288 */       this.jButton18.setEnabled(false);
/* 5289 */       this.jTextField37.setEnabled(false);
/* 5290 */       this.jTextField38.setEnabled(false);
/* 5291 */       this.jTextField44.setEnabled(false);
/* 5292 */       this.jTextField45.setEnabled(false);
/* 5293 */       this.jTextField43.setEnabled(false);
/*      */     } else {
/* 5295 */       this.jRadioButton1.setSelected(true);
/* 5296 */       this.jRadioButton1.setEnabled(true);
/* 5297 */       this.jRadioButton2.setEnabled(true);
/* 5298 */       this.jSpinner1.setEnabled(true);
/* 5299 */       this.jButton18.setEnabled(true);
/* 5300 */       this.jTextField37.setEnabled(true);
/* 5301 */       this.jTextField38.setEnabled(true);
/* 5302 */       this.jTextField44.setEnabled(true);
/* 5303 */       this.jTextField45.setEnabled(true);
/* 5304 */       this.jTextField43.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton20ActionPerformed(ActionEvent evt) {
/* 5309 */     int indice = this.jTable6.getSelectedRow();
/* 5310 */     if (indice < 0) {
/* 5311 */       JOptionPane.showMessageDialog(this.jDialog10, "Necesitas seleccionar un concepto para poder modificarlo", "Selecciona un concepto", 0, this.ADVER);
/*      */     } else {
/* 5313 */       this.jButton12.setText("Cambiar");
/* 5314 */       String[] datos = this.con.regresaReg("num,clave,unidad,concepto,cantidad,cliente", "conceptosfact", "where num=" + String.valueOf(this.jTable6.getValueAt(this.jTable6.getSelectedRow(), 0)), 6);
/* 5315 */       this.jTextField9.setText(datos[1]);
/* 5316 */       this.jTextField46.setText(datos[2]);
/* 5317 */       this.jTextField29.setText(datos[3]);
/* 5318 */       this.jFormattedTextField5.setValue(Double.valueOf(Double.parseDouble(datos[4])));
/* 5319 */       this.CLAVECONCEP = datos[0];
/* 5320 */       this.jTextField9.setEnabled(false);
/* 5321 */       this.jComboBox18.setSelectedItem(datos[5]);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox18ActionPerformed(ActionEvent evt) {
/* 5326 */     if (this.jComboBox18.getItemCount() > 0) {
/* 5327 */       consultarConceptos();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox21ActionPerformed(ActionEvent evt) {
/* 5332 */     if (this.jComboBox21.getItemCount() > 0 && this.PRIMERA == true) {
/* 5333 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 5338 */     int ind = this.jTable3.getSelectedRow();
/* 5339 */     if (ind < 0) {
/* 5340 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una factura para ver los datos de recepción", "Selecciona una factura", 0, this.ERROR);
/*      */     } else {
/* 5342 */       cargarRecepcion();
/* 5343 */       this.jDialog12.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton19ActionPerformed(ActionEvent evt) {
/* 5348 */     this.jDialog12.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton21ActionPerformed(ActionEvent evt) {
/* 5352 */     Date fechaFact = null;
/* 5353 */     Date fechaAhora = new Date();
/* 5354 */     Date fechaRecep = this.jDateChooser9.getDate();
/*      */     
/* 5356 */     String fecha = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2));
/* 5357 */     String fechaCorta = fecha.substring(0, 10);
/*      */     
/* 5359 */     String año = fechaCorta.substring(0, 4);
/* 5360 */     String mes = fechaCorta.substring(5, 7);
/* 5361 */     String dia = fechaCorta.substring(8, 10);
/* 5362 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 5363 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/* 5365 */       fechaFact = formatoDelTexto.parse(strFecha);
/*      */     }
/* 5367 */     catch (ParseException ex) {
/* 5368 */       ex.printStackTrace();
/*      */     } 
/* 5370 */     if (this.jDateChooser9.getDate() == null) {
/* 5371 */       JOptionPane.showMessageDialog(this.jDialog12, "La fecha de recepción no la puedes dejar vacía", "Falta fecha de recepción", 0, this.ERROR);
/* 5372 */     } else if (fechaRecep.before(fechaFact)) {
/* 5373 */       JOptionPane.showMessageDialog(this.jDialog12, "La fecha de recepción no puede ser menor a la fecha de la factura\nVerifica tu información", "Fecha incorrecta", 0, this.ERROR);
/* 5374 */     } else if (fechaRecep.after(fechaAhora)) {
/* 5375 */       JOptionPane.showMessageDialog(this.jDialog12, "La fecha de recepción no puede ser mayor a la fecha de hoy\nVerifica tu información", "Fecha incorrecta", 0, this.ERROR);
/* 5376 */     } else if (this.jTextField48.getText().equals("")) {
/* 5377 */       this.jTextField48.setBackground(Color.RED);
/* 5378 */       JOptionPane.showMessageDialog(this.jDialog12, "Falta agregar el nombre de la persona que recibió la documentación", "Falta la información 'Recibió'", 0, this.ERROR);
/* 5379 */     } else if (this.jTextField49.getText().equals("")) {
/* 5380 */       this.jTextField49.setBackground(Color.RED);
/* 5381 */       JOptionPane.showMessageDialog(this.jDialog12, "Falta agregar el nombre de la persona que entregó la documentación", "Falta la información 'Entregó'", 0, this.ERROR);
/*      */     } else {
/* 5383 */       int res = JOptionPane.showConfirmDialog(this.jDialog12, "¿Estás seguro que deseas completar los datos de la recepción?", "Completar recepción", 0, 3, this.PREG);
/* 5384 */       if (res == 0) {
/* 5385 */         SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 5386 */         String cadenaFecha1 = formato.format(this.jDateChooser9.getDate());
/* 5387 */         año = cadenaFecha1.substring(0, 4);
/* 5388 */         mes = cadenaFecha1.substring(4, 6);
/* 5389 */         dia = cadenaFecha1.substring(6, 8);
/* 5390 */         String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/*      */         
/* 5392 */         formato = new SimpleDateFormat("yyyyMMdd");
/* 5393 */         cadenaFecha1 = formato.format(this.jDateChooser10.getDate());
/* 5394 */         año = cadenaFecha1.substring(0, 4);
/* 5395 */         mes = cadenaFecha1.substring(4, 6);
/* 5396 */         dia = cadenaFecha1.substring(6, 8);
/* 5397 */         String fechaCompleta2 = "'" + año + "-" + mes + "-" + dia + "'";
/*      */         
/* 5399 */         this.con.inserSinMsj("update facturas set fechaRecepcion=" + fechaCompleta + ", fechaRecepCompleta= " + fechaCompleta2 + ", usuarioRecep='" + this.USUARIO + "',recibio='" + this.jTextField48.getText().toUpperCase() + "',entrego='" + this.jTextField49.getText().toUpperCase() + "',lugarRecep='" + this.jTextField50.getText().toUpperCase() + "',comentarioRecep='" + this.jTextArea2.getText().toUpperCase() + "',completa='COMPLETA' where folio='" + this.jTextField47.getText() + "'");
/* 5400 */         consultar();
/* 5401 */         this.jDialog12.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton28ActionPerformed(ActionEvent evt) {
/* 5407 */     consultarPartidas();
/* 5408 */     this.jDialog13.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton22ActionPerformed(ActionEvent evt) {
/* 5412 */     this.jDialog13.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jTextField52KeyReleased(KeyEvent evt) {
/* 5416 */     String cadena = this.jTextField52.getText();
/* 5417 */     if (!cadena.equals("")) {
/* 5418 */       if (this.presionado == null) {
/* 5419 */         this.presionado = new Presionado();
/*      */       } else {
/* 5421 */         this.presionado.detenerFuera();
/* 5422 */         this.presionado = new Presionado();
/* 5423 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 5426 */       this.jTextField52.setBackground(new Color(153, 255, 153));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton29ActionPerformed(ActionEvent evt) {
/* 5431 */     String[] datos = { "FACTURA", "CANT", "UNIDAD", "DESCRIPCION", "P UNIT", "IMPORTE" };
/* 5432 */     this.esc = new EscribirReporte("BÚSQUEDA POR CONCEPTOS", this.jTable7, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jButton30ActionPerformed(ActionEvent evt) {
/* 5436 */     ImprimirConceptos imprimir = new ImprimirConceptos();
/* 5437 */     imprimir.recibeDatos();
/*      */   }
/*      */   
/*      */   private void jButton42ActionPerformed(ActionEvent evt) {
/* 5441 */     this.jDialog14.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton43ActionPerformed(ActionEvent evt) {
/* 5445 */     this.DESC_PORCENTAJE = this.jSlider1.getValue();
/* 5446 */     this.DESC_MOTIVO = this.jTextField53.getText().toUpperCase();
/* 5447 */     this.jLabel149.setText("<html><u>Descuento " + this.DESC_PORCENTAJE + "%</u></html>");
/* 5448 */     this.jLabel149.setToolTipText("Descuento por: " + this.DESC_MOTIVO);
/* 5449 */     this.jDialog14.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jSlider1StateChanged(ChangeEvent evt) {
/* 5453 */     this.jLabel151.setText("Descuento: " + this.jSlider1.getValue() + "%");
/*      */   }
/*      */   
/*      */   private void jTextField53ActionPerformed(ActionEvent evt) {
/* 5457 */     this.DESC_PORCENTAJE = this.jSlider1.getValue();
/* 5458 */     this.DESC_MOTIVO = this.jTextField53.getText().toUpperCase();
/* 5459 */     this.jLabel149.setText("<html><u>Descuento " + this.DESC_PORCENTAJE + "%</u></html>");
/* 5460 */     this.jLabel149.setToolTipText("Descuento por: " + this.DESC_MOTIVO);
/* 5461 */     this.jDialog14.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton40ActionPerformed(ActionEvent evt) {
/* 5465 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton37ActionPerformed(ActionEvent evt) {
/* 5469 */     this.jDialog11.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton32ActionPerformed(ActionEvent evt) {
/* 5473 */     if (this.jDialog11.getTitle().equals("Refactura")) {
/* 5474 */       this.TOTALPREFACTURA = 0.0D;
/* 5475 */       for (int i = 0; i < this.jTable4.getRowCount(); i++) {
/* 5476 */         String canti = String.valueOf(this.jTable4.getValueAt(i, 5));
/* 5477 */         String valorP = "";
/* 5478 */         for (int j = 0; j < canti.length(); j++) {
/* 5479 */           if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 5480 */             valorP = valorP + valorP;
/*      */           }
/*      */         } 
/* 5483 */         this.TOTALPREFACTURA += Double.parseDouble(valorP);
/*      */       } 
/*      */     } 
/*      */     
/* 5487 */     double RESTA = this.TOTALD - this.TOTALPREFACTURA;
/* 5488 */     if (!this.jTextField18.isEnabled()) {
/* 5489 */       ImprimirFactura1 imp = new ImprimirFactura1();
/* 5490 */       imp.recibeDatos();
/*      */     } else {
/* 5492 */       String[] metodos = { "01", "02", "03", "04", "05", "06", "08", "28", "29", "NA", "99" };
/* 5493 */       String bancoStr = String.valueOf(this.jComboBox19.getSelectedItem());
/* 5494 */       String cuentaStr = String.valueOf(this.jComboBox15.getSelectedItem());
/* 5495 */       int ind = this.jTable10.getRowCount();
/* 5496 */       this.encontrado = this.con.consultar("folio", "facturas", "where folio ='" + this.jTextField18.getText() + "'");
/* 5497 */       if (this.jTextField18.getText().equals("")) {
/* 5498 */         this.jTextField18.setBackground(Color.RED);
/* 5499 */         JOptionPane.showMessageDialog(this.jDialog11, "Te falta agregar el FOLIO de la factura", "Coloca el folio", 0, this.ADVER);
/* 5500 */       } else if (this.encontrado) {
/* 5501 */         this.jTextField18.setBackground(Color.ORANGE);
/* 5502 */         JOptionPane.showMessageDialog(this.jDialog11, "El folio que deseas insertar ya se encuentra almacenado en la base de datos", "Folio Duplicado", 0, this.ADVER);
/* 5503 */       } else if (this.jTextField19.getText().equals("")) {
/* 5504 */         this.jTextField19.setBackground(Color.RED);
/* 5505 */         JOptionPane.showMessageDialog(this.jDialog11, "Te falta agregar el LUGAR DE EXPEDICIÓN de la factura", "Coloca el lugar", 0, this.ADVER);
/* 5506 */       } else if (bancoStr.equals("null")) {
/* 5507 */         this.jComboBox19.setBackground(Color.RED);
/* 5508 */         JOptionPane.showMessageDialog(this.jDialog11, "Te falta agregar el BANCO para el depósito de la factura", "Coloca el banco", 0, this.ADVER);
/* 5509 */       } else if (cuentaStr.equals("null")) {
/* 5510 */         this.jComboBox15.setBackground(Color.RED);
/* 5511 */         JOptionPane.showMessageDialog(this.jDialog11, "Te falta agregar la CUENTA para el depósito de la factura", "Coloca el cuenta", 0, this.ADVER);
/* 5512 */       } else if (ind == 0) {
/* 5513 */         JOptionPane.showMessageDialog(this.jDialog11, "No puedes generar la factura porque te falta agregar conceptos", "Ningún Concepto", 0, this.ADVER);
/* 5514 */       } else if ((RESTA > 5.0D || RESTA < -5.0D) && !this.jLabel149.isEnabled()) {
/* 5515 */         this.cantidad.setValue(Double.valueOf(this.TOTALPREFACTURA));
/* 5516 */         JOptionPane.showMessageDialog(this.jDialog11, "Los saldos en las prefacturas no coinciden el total elaborado por la factura\nSaldo en factura: " + this.jLabel114.getText() + "\nSaldo en prefacturas: " + this.cantidad.getText(), "Saldos no coinciden", 0, this.ERROR);
/*      */       } else {
/* 5518 */         int res = JOptionPane.showConfirmDialog(this.jDialog11, "¿Estás seguro que deseas guardar e imprimir la factura?", "Guardar Factura", 0, 3, this.PREG);
/* 5519 */         if (res == 0) {
/* 5520 */           String estado = String.valueOf(this.jComboBox9.getSelectedItem());
/* 5521 */           String cliente = String.valueOf(this.jComboBox1.getSelectedItem());
/*      */           
/* 5523 */           SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 5524 */           String cadenaFecha1 = formato.format(this.jDateChooser6.getDate());
/* 5525 */           String año = cadenaFecha1.substring(0, 4);
/* 5526 */           String mes = cadenaFecha1.substring(4, 6);
/* 5527 */           String dia = cadenaFecha1.substring(6, 8);
/* 5528 */           String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/* 5529 */           String auxFecha = año + "-" + año + "-" + mes;
/*      */           
/* 5531 */           int tieneLeyenda = 0;
/* 5532 */           if (this.jCheckBox1.isSelected()) {
/* 5533 */             tieneLeyenda = 1;
/*      */           }
/* 5535 */           int tipoDiseno = 1;
/* 5536 */           this.encontrado = this.con.consultar("folio", "facturas", "where folio = '" + this.jTextField18.getText() + "'");
/* 5537 */           if (this.encontrado) {
/* 5538 */             JOptionPane.showMessageDialog(this.jDialog11, "La factura que deseas colocar ya se encuentra creada, por favor verifica los folios", "Folio Duplicado", 0, this.ADVER);
/*      */             return;
/*      */           } 
/* 5541 */           if (this.jComboBox14.getSelectedIndex() == 0) {
/* 5542 */             if (this.jDialog11.getTitle().equals("Refactura")) {
/* 5543 */               this.con.inserSinMsj("update facturas set leyendaSustituida='SUSTITUIDA POR LA FACTURA #" + this.jTextField18.getText().toUpperCase() + "', facturaSustituida ='" + this.jTextField18.getText().toUpperCase() + "' where folio='" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1)) + "'");
/* 5544 */               this.con.inserSinMsj("insert into facturas(folio,                                    cliente,          calle,                                         num,                                     colonia,                               cp,                                          ciudad,                                 estado,                rfc,                          fecha,                     lugar,                                supedido,                                         nuestropedido,                     zona,                                           condiciones,                                          equipo,                                  plataforma,                             pozo,            tipodiseno,        encabezado,                            pie,                                       linea1,                                    linea2,                                       linea3,                                 linea4,                             tieneLeyenda,         tipoLeyenda,                        contenidoLeyenda,                                subtotal                ,iva,                         retencion,                               total,             tarjeta,    usuario, motivo, estatus, fechaRecepcion,referencia , pagoForma,                                                                  PagoMetodo,                                    numCuenta,                    banco,                                         lugarExpedicion, folioInterno, folioFiscal, serieFolio, FechaFolio, montoFolio, montoFolioLetra, EsOriginal, numPartes, fechaRecepCompleta, usuarioRecep, recibio, entrego, lugarRecep, comentarioRecep, completa, descMonto, descPorcen, descMotivo, leyendaSustituida, facturaSustituida, leyendaSustituye, facturaSustituye)values('" + this.jTextField18
/* 5545 */                   .getText().toUpperCase() + "','" + cliente + "','" + this.jTextField10.getText().toUpperCase() + "','" + this.jTextField13.getText().toUpperCase() + "','" + this.jTextField14.getText().toUpperCase() + "','" + this.jTextField15.getText().toUpperCase() + "','" + this.jTextField16.getText().toUpperCase() + "','" + estado + "','" + this.jTextField17.getText().toUpperCase() + "'," + fechaCompleta + ",'" + this.jTextField19.getText().toUpperCase() + "','" + this.jTextField20.getText().toUpperCase() + "','" + String.valueOf(this.jComboBox20.getSelectedItem()) + "".toUpperCase() + "','" + this.jTextField22.getText().toUpperCase() + "','" + this.jComboBox13.getSelectedItem().toString().toUpperCase() + "','" + String.valueOf(this.jComboBox2.getSelectedItem()) + "','" + String.valueOf(this.jComboBox4.getSelectedItem()) + "','" + String.valueOf(this.jComboBox12.getSelectedItem()) + "'," + tipoDiseno + ",'" + this.jTextField24.getText().toUpperCase() + "','" + this.jTextField26.getText().toUpperCase() + "','" + this.jTextField39.getText().toUpperCase() + "','" + this.jTextField40.getText().toUpperCase() + "','" + this.jTextField41.getText().toUpperCase() + "','" + this.jTextField42.getText().toUpperCase() + "'," + tieneLeyenda + ",'" + String.valueOf(this.jComboBox10.getSelectedItem()) + "','" + this.jTextField28.getText().toUpperCase() + "','" + this.jLabel107.getText() + "','" + this.jLabel108.getText() + "','" + this.jFormattedTextField1.getText() + "','" + this.jLabel114.getText() + "'," + this.TARJETA + ",'" + this.USUARIO + "','','<Por Pagar>',now(),'',       '" + String.valueOf(this.jComboBox14.getSelectedItem()) + "".toUpperCase() + "',      '" + metodos[this.jComboBox17.getSelectedIndex()] + "','" + String.valueOf(this.jComboBox15.getSelectedItem()) + "".toUpperCase() + "','" + String.valueOf(this.jComboBox19.getSelectedItem()) + "".toUpperCase() + "','" + this.jTextField19.getText().toUpperCase() + "',         '',       '',          '',          '',        0,        '',                   0,      0, now(), '','','','','','PENDIENTE'," + String.valueOf(this.jFormattedTextField10.getValue()) + "," + this.DESC_PORCENTAJE + ",'" + this.DESC_MOTIVO + "','','','SUSTITUYE A LA FACTURA #" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1)) + "','" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1)) + "')");
/*      */             } else {
/* 5547 */               this.con.inserSinMsj("insert into facturas(folio,                                    cliente,          calle,                                         num,                                     colonia,                               cp,                                          ciudad,                                 estado,                rfc,                          fecha,                     lugar,                                supedido,                                         nuestropedido,                     zona,                                           condiciones,                                          equipo,                                  plataforma,                             pozo,            tipodiseno,        encabezado,                            pie,                                       linea1,                                    linea2,                                       linea3,                                 linea4,                             tieneLeyenda,         tipoLeyenda,                        contenidoLeyenda,                                subtotal                ,iva,                         retencion,                               total,             tarjeta,    usuario, motivo, estatus, fechaRecepcion,referencia , pagoForma,                                                                  PagoMetodo,                                    numCuenta,                    banco,                                         lugarExpedicion, folioInterno, folioFiscal, serieFolio, FechaFolio, montoFolio, montoFolioLetra, EsOriginal, numPartes, fechaRecepCompleta, usuarioRecep, recibio, entrego, lugarRecep, comentarioRecep, completa, descMonto, descPorcen, descMotivo, leyendaSustituida, facturaSustituida, leyendaSustituye, facturaSustituye)values('" + this.jTextField18
/* 5548 */                   .getText().toUpperCase() + "','" + cliente + "','" + this.jTextField10.getText().toUpperCase() + "','" + this.jTextField13.getText().toUpperCase() + "','" + this.jTextField14.getText().toUpperCase() + "','" + this.jTextField15.getText().toUpperCase() + "','" + this.jTextField16.getText().toUpperCase() + "','" + estado + "','" + this.jTextField17.getText().toUpperCase() + "'," + fechaCompleta + ",'" + this.jTextField19.getText().toUpperCase() + "','" + this.jTextField20.getText().toUpperCase() + "','" + String.valueOf(this.jComboBox20.getSelectedItem()) + "".toUpperCase() + "','" + this.jTextField22.getText().toUpperCase() + "','" + this.jComboBox13.getSelectedItem().toString().toUpperCase() + "','" + String.valueOf(this.jComboBox2.getSelectedItem()) + "','" + String.valueOf(this.jComboBox4.getSelectedItem()) + "','" + String.valueOf(this.jComboBox12.getSelectedItem()) + "'," + tipoDiseno + ",'" + this.jTextField24.getText().toUpperCase() + "','" + this.jTextField26.getText().toUpperCase() + "','" + this.jTextField39.getText().toUpperCase() + "','" + this.jTextField40.getText().toUpperCase() + "','" + this.jTextField41.getText().toUpperCase() + "','" + this.jTextField42.getText().toUpperCase() + "'," + tieneLeyenda + ",'" + String.valueOf(this.jComboBox10.getSelectedItem()) + "','" + this.jTextField28.getText().toUpperCase() + "','" + this.jLabel107.getText() + "','" + this.jLabel108.getText() + "','" + this.jFormattedTextField1.getText() + "','" + this.jLabel114.getText() + "'," + this.TARJETA + ",'" + this.USUARIO + "','','<Por Pagar>',now(),'',       '" + String.valueOf(this.jComboBox14.getSelectedItem()) + "".toUpperCase() + "',      '" + metodos[this.jComboBox17.getSelectedIndex()] + "','" + String.valueOf(this.jComboBox15.getSelectedItem()) + "".toUpperCase() + "','" + String.valueOf(this.jComboBox19.getSelectedItem()) + "".toUpperCase() + "','" + this.jTextField19.getText().toUpperCase() + "',         '',       '',          '',          '',        0,        '',                   0,      0, now(), '','','','','','PENDIENTE'," + String.valueOf(this.jFormattedTextField10.getValue()) + "," + this.DESC_PORCENTAJE + ",'" + this.DESC_MOTIVO + "','','','','')");
/*      */             } 
/*      */             
/* 5551 */             String actPrefacturas = "";
/* 5552 */             String actGuias = "";
/* 5553 */             String insertarPrefac = "";
/* 5554 */             for (int i = 0; i < this.jTable4.getRowCount(); i++) {
/* 5555 */               actPrefacturas = actPrefacturas + " numFac = " + actPrefacturas;
/* 5556 */               if (i + 1 < this.jTable4.getRowCount()) {
/* 5557 */                 actPrefacturas = actPrefacturas + " or ";
/*      */               }
/*      */               
/* 5560 */               actGuias = actGuias + " prefactura = " + actGuias;
/* 5561 */               if (i + 1 < this.jTable4.getRowCount()) {
/* 5562 */                 actGuias = actGuias + " or ";
/*      */               }
/*      */               
/* 5565 */               insertarPrefac = insertarPrefac + "('" + insertarPrefac + "'," + this.jTextField18.getText().toUpperCase() + ")";
/* 5566 */               if (i + 1 < this.jTable4.getRowCount()) {
/* 5567 */                 insertarPrefac = insertarPrefac + " , ";
/*      */               }
/*      */             } 
/*      */             
/* 5571 */             if (this.jTable4.getRowCount() > 0) {
/* 5572 */               this.con.inserSinMsj("update prefacturacliente set estatus = '<Facturada " + this.jTextField18.getText().toUpperCase() + ": " + cargarFechaHoy() + ">',folio='" + this.jTextField18.getText().toUpperCase() + "' where " + actPrefacturas);
/* 5573 */               this.con.inserSinMsj("update guias set estatus='<Facturada " + this.jTextField18.getText().toUpperCase() + ": " + cargarFechaHoy() + ">',factImpresa='" + this.jTextField18.getText().toUpperCase() + "' where " + actGuias);
/* 5574 */               this.con.inserSinMsj("insert into facturas_prefacturas(factura,numfac)values " + insertarPrefac);
/*      */             } 
/*      */             
/* 5577 */             double total = 0.0D;
/* 5578 */             this.encontrado = this.con.consultar("saldoFinal", "tarjeta_contenido_cliente", "where tarjeta = " + this.TARJETA);
/* 5579 */             if (this.encontrado) {
/* 5580 */               this.encontrado = this.con.consultar("sum(importeRestante)", "tarjeta_contenido_cliente", "where tarjeta = " + this.TARJETA);
/* 5581 */               String saldoFinal = this.con.Campo;
/* 5582 */               total = Double.parseDouble(saldoFinal) + this.TOTALD;
/*      */             } else {
/* 5584 */               total = this.TOTALD;
/*      */             } 
/* 5586 */             total = redondear(total).doubleValue();
/* 5587 */             this.cantidad.setValue(Double.valueOf(total));
/* 5588 */             String saldoFinalL = this.cantidad.getText();
/* 5589 */             this.con.inserSinMsj("update tarjeta_deudor_cliente set total = '" + saldoFinalL + "' where tarjeta=" + this.TARJETA);
/* 5590 */             this.con.inserSinMsj("insert into tarjeta_contenido_cliente(fecha,tipoConcep,concepto,        referencia,                                       importe,        importeLetra,      abono, abonoLetra,    importeSaldado,importeRestante,ImporteRestanteLetra,    estatus, comentario,              factura,          num_abono,saldoFinal,saldoFinalLetra,TARJETA,usuario,pago1,pago2,pago3,pago4,tipo) values(now(),1,'CARGO POR FACTURA','FACTURA: " + this.jTextField18
/* 5591 */                 .getText().toUpperCase() + "'," + this.TOTALD + ",'" + this.jLabel114.getText() + "',0,      '',            0,           " + this.TOTALD + ",'" + this.jLabel114.getText() + "','<Por Pagar>','','" + this.jTextField18.getText().toUpperCase() + "',''," + total + ",'" + saldoFinalL + "'," + this.TARJETA + ",'" + this.USUARIO + "','','','','',1)");
/*      */             
/* 5593 */             String insertarPartidas = "";
/* 5594 */             for (int j = 0; j < this.jTable10.getRowCount(); j++) {
/* 5595 */               insertarPartidas = insertarPartidas + " (" + insertarPartidas + ",'" + String.valueOf(this.jTable10.getValueAt(j, 0)) + "','" + String.valueOf(this.jTable10.getValueAt(j, 1)) + "','','','','','','','','" + String.valueOf(this.jTable10.getValueAt(j, 2)) + "','" + String.valueOf(this.jTable10.getValueAt(j, 3)) + "','" + String.valueOf(this.jTable10.getValueAt(j, 4)) + "')";
/* 5596 */               if (j + 1 < this.jTable10.getRowCount()) {
/* 5597 */                 insertarPartidas = insertarPartidas + " , ";
/*      */               }
/*      */             } 
/* 5600 */             this.con.inserSinMsj("insert into disenotabla(cant,unidad,descripcion,guia,fserv,rspr,origen,destino,peso,manifiesto,punit,importe,folio) values " + insertarPartidas);
/*      */             
/* 5602 */             String banco = String.valueOf(this.jComboBox19.getSelectedItem());
/* 5603 */             this.encontrado = this.con.consultar("banco", "bancos", "where cliente = " + this.TARJETA + " and banco = '" + banco + "'");
/* 5604 */             if (!this.encontrado) {
/* 5605 */               this.con.inserSinMsj("insert into bancos(cliente,banco) values(" + this.TARJETA + ",'" + banco + "')");
/*      */             }
/*      */             
/* 5608 */             String cuenta = String.valueOf(this.jComboBox15.getSelectedItem());
/* 5609 */             this.encontrado = this.con.consultar("cuenta", "cuentas", "where cliente = " + this.TARJETA + " and cuenta = '" + cuenta + "'");
/* 5610 */             if (!this.encontrado) {
/* 5611 */               this.con.inserSinMsj("insert into cuentas(cliente,cuenta) values(" + this.TARJETA + ",'" + cuenta + "')");
/*      */             }
/*      */             
/* 5614 */             this.mensajeTry.guardarConf("Se ha creado una nueva Factura, usuario: " + this.USUARIO, "Nueva Factura (" + this.jTextField18.getText().toUpperCase() + ")", "INFO", "Facturacion");
/*      */           } 
/*      */ 
/*      */           
/*      */           try {
/* 5619 */             crearFactura(this.jTextField18.getText());
/* 5620 */           } catch (IOException ex) {
/* 5621 */             Logger.getLogger(Facturas.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */           } 
/* 5623 */           ImprimirFactura1 imp = new ImprimirFactura1();
/* 5624 */           imp.recibeDatos();
/* 5625 */           this.jDialog11.setVisible(false);
/* 5626 */           consultar();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton38ActionPerformed(ActionEvent evt) {
/* 5633 */     this.jTable4.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 5634 */     this.jTable4.getColumnModel().getColumn(0).setMaxWidth(50);
/* 5635 */     this.jDialog6.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/*      */     try {
/* 5640 */       crearFactura(this.jTextField18.getText());
/* 5641 */       JOptionPane.showMessageDialog(this.jDialog11, "La factura se ha creado satisfactoriamente.", "Factura creada", 0, this.INFO);
/* 5642 */     } catch (IOException ex) {
/* 5643 */       Logger.getLogger(Facturas.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton41ActionPerformed(ActionEvent evt) {
/* 5648 */     int indice = this.jTable10.getSelectedRow();
/* 5649 */     if (indice < 0) {
/* 5650 */       JOptionPane.showMessageDialog(this.jDialog11, "Necesitas seleccionar un registro para poder modificarlo", "Selecciona un registro", 0, this.ERROR);
/*      */     }
/* 5652 */     else if (this.jButton41.getText().equals("Modificar")) {
/* 5653 */       this.jButton41.setEnabled(false);
/* 5654 */       this.jButton31.setEnabled(false);
/* 5655 */       indice = this.jTable10.getRowCount();
/* 5656 */       if (indice < 0) {
/* 5657 */         JOptionPane.showMessageDialog(this.jDialog11, "Debes seleccionar un concepto para poder modificarlo", "Selecciona un concepto", 0, this.INFO);
/*      */       } else {
/*      */         
/* 5660 */         this.jTextField30.setEnabled(false);
/* 5661 */         String valor = String.valueOf(this.jTable10.getValueAt(this.jTable10.getSelectedRow(), 0));
/* 5662 */         this.jFormattedTextField2.setValue(Double.valueOf(Double.parseDouble(valor)));
/* 5663 */         this.jComboBox16.addItem(this.jTable10.getValueAt(this.jTable10.getSelectedRow(), 1));
/* 5664 */         this.jComboBox16.setSelectedItem(this.jTable10.getValueAt(this.jTable10.getSelectedRow(), 1));
/* 5665 */         this.jTextField27.setText(String.valueOf(this.jTable10.getValueAt(this.jTable10.getSelectedRow(), 2)));
/*      */         
/* 5667 */         valor = String.valueOf(this.jTable10.getValueAt(this.jTable10.getSelectedRow(), 3));
/* 5668 */         String valorP = ""; int i;
/* 5669 */         for (i = 0; i < valor.length(); i++) {
/* 5670 */           if (valor.charAt(i) != '$' && valor.charAt(i) != ',') {
/* 5671 */             valorP = valorP + valorP;
/*      */           }
/*      */         } 
/* 5674 */         this.jFormattedTextField3.setValue(Double.valueOf(Double.parseDouble(valorP)));
/*      */         
/* 5676 */         valor = String.valueOf(this.jTable10.getValueAt(this.jTable10.getSelectedRow(), 4));
/* 5677 */         valorP = "";
/* 5678 */         for (i = 0; i < valor.length(); i++) {
/* 5679 */           if (valor.charAt(i) != '$' && valor.charAt(i) != ',') {
/* 5680 */             valorP = valorP + valorP;
/*      */           }
/*      */         } 
/* 5683 */         this.jFormattedTextField4.setValue(Double.valueOf(Double.parseDouble(valorP)));
/* 5684 */         this.INDICE = this.jTable10.getSelectedRow();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox10ActionPerformed(ActionEvent evt) {
/* 5691 */     if (this.jCheckBox1.isEnabled()) {
/* 5692 */       if (this.jComboBox10.getSelectedIndex() == 0) {
/* 5693 */         this.jTextField28.setText("");
/* 5694 */         this.jTextField28.setEnabled(true);
/* 5695 */       } else if (this.jComboBox10.getSelectedIndex() == 1) {
/* 5696 */         this.jTextField28.setEnabled(false);
/* 5697 */         this.jTextField28.setText("Impuesto Retenido de Conformidad con la Ley del Impuesto al Valor Agregado");
/* 5698 */       } else if (this.jComboBox10.getSelectedIndex() == 2) {
/* 5699 */         this.jTextField28.setEnabled(false);
/* 5700 */         this.jTextField28.setText("Efectos Fiscales al Pago");
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private void jCheckBox1ActionPerformed(ActionEvent evt) {
/* 5706 */     this.jComboBox10.setSelectedIndex(0);
/* 5707 */     this.jTextField28.setText("");
/* 5708 */     if (this.jCheckBox1.isSelected()) {
/* 5709 */       this.jComboBox10.setEnabled(true);
/* 5710 */       this.jTextField28.setEnabled(true);
/*      */     } else {
/* 5712 */       this.jComboBox10.setEnabled(false);
/* 5713 */       this.jTextField28.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jFormattedTextField10KeyReleased(KeyEvent evt) {
/* 5718 */     if (!this.jFormattedTextField10.getText().equals("$0.00"))
/*      */     {
/*      */       
/* 5721 */       sacarTotales2();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabel149MouseClicked(MouseEvent evt) {
/* 5726 */     if (this.jLabel149.isEnabled() || !this.jFormattedTextField10.getText().equals("$0.00")) {
/* 5727 */       this.jSlider1.setValue(this.DESC_PORCENTAJE);
/* 5728 */       this.jTextField53.setText(this.DESC_MOTIVO);
/* 5729 */       this.jDialog14.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jFormattedTextField1CaretUpdate(CaretEvent evt) {
/* 5734 */     double valor = 0.0D;
/*      */     try {
/* 5736 */       valor = Double.parseDouble(String.valueOf(this.jFormattedTextField1.getValue()));
/* 5737 */       this.RETENCIOND = valor;
/* 5738 */       sacarTotales2();
/* 5739 */     } catch (NumberFormatException numberFormatException) {}
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton31ActionPerformed(ActionEvent evt) {
/* 5744 */     int indice = this.jTable10.getSelectedRow();
/* 5745 */     if (indice < 0) {
/* 5746 */       JOptionPane.showMessageDialog(this.jDialog11, "Necesitas seleccionar un registro para poder quitarlo", "Selecciona un registro", 0, this.ERROR);
/*      */     } else {
/* 5748 */       DefaultTableModel temp = (DefaultTableModel)this.jTable10.getModel();
/* 5749 */       String valor = String.valueOf(this.jTable10.getValueAt(this.jTable10.getSelectedRow(), 4));
/* 5750 */       String valorP = "";
/* 5751 */       for (int i = 0; i < valor.length(); i++) {
/* 5752 */         if (valor.charAt(i) != '$' && valor.charAt(i) != ',') {
/* 5753 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 5756 */       this.SUBTOTALD -= Double.parseDouble(valorP);
/* 5757 */       sacarTotales2();
/* 5758 */       temp.removeRow(indice);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField27ActionPerformed(ActionEvent evt) {
/* 5763 */     sumarConcep();
/*      */   }
/*      */   
/*      */   private void jFormattedTextField2ActionPerformed(ActionEvent evt) {
/* 5767 */     sumarConcep();
/*      */   }
/*      */   
/*      */   private void jTextField30ActionPerformed(ActionEvent evt) {
/* 5771 */     String clave = this.jTextField30.getText();
/* 5772 */     this.encontrado = this.con.consultar("concepto", "ConceptosFact", "where clave='" + clave + "'");
/* 5773 */     String[] datos = this.con.regresaReg("concepto,unidad,cantidad", "conceptosfact", "where clave='" + clave + "'", 3);
/* 5774 */     if (this.encontrado) {
/* 5775 */       this.jComboBox16.addItem(datos[1]);
/* 5776 */       this.jComboBox16.setSelectedItem(datos[1]);
/* 5777 */       this.jTextField27.setText(this.con.Campo);
/* 5778 */       this.jFormattedTextField3.setValue(Double.valueOf(Double.parseDouble(datos[2])));
/* 5779 */       this.jFormattedTextField2.setValue(Integer.valueOf(0));
/*      */     } else {
/* 5781 */       this.jTextField27.setText("");
/* 5782 */       this.jComboBox16.removeAllItems();
/* 5783 */       this.jFormattedTextField3.setValue(Integer.valueOf(0));
/* 5784 */       this.jFormattedTextField4.setValue(Integer.valueOf(0));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField30MouseClicked(MouseEvent evt) {
/* 5789 */     if (evt.getClickCount() == 2 && this.jTextField30.isEnabled()) {
/* 5790 */       sacarMayor();
/* 5791 */       this.jTextField46.setText("");
/* 5792 */       this.jTextField29.setText("");
/* 5793 */       this.jFormattedTextField5.setValue(Integer.valueOf(0));
/* 5794 */       this.jTextField9.setEnabled(true);
/* 5795 */       this.jButton12.setText("Agregar");
/*      */       
/* 5797 */       this.jDialog10.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jLabel158MouseClicked(MouseEvent evt) {
/* 5802 */     this.jDialog15.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jLabel158MouseEntered(MouseEvent evt) {
/* 5806 */     this.jLabel158.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel158MouseExited(MouseEvent evt) {
/* 5810 */     this.jLabel158.setForeground(Color.RED);
/*      */   }
/*      */   
/*      */   private void jTable6MouseClicked(MouseEvent evt) {
/* 5814 */     if (evt.getClickCount() == 2) {
/* 5815 */       verConcepto();
/* 5816 */       this.jDialog15.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField54KeyReleased(KeyEvent evt) {
/* 5821 */     consultarConceptos();
/*      */   }
/*      */   
/*      */   private void jTextField55KeyReleased(KeyEvent evt) {
/* 5825 */     consultarConceptos();
/*      */   }
/*      */   
/*      */   private void jButton46ActionPerformed(ActionEvent evt) {
/* 5829 */     int ind = this.jTable3.getSelectedRow();
/* 5830 */     if (ind < 0) {
/* 5831 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una factura para poder refacturar", "Selecciona una factura", 0, this.ERROR);
/*      */     } else {
/* 5833 */       sacarFolioMayor();
/* 5834 */       int i = JOptionPane.showConfirmDialog(this, "<html>Si deseas refacturar, las guías y perfacturas quedarán registradas con el nuevo Folio de Factura<p><font color=RED><b>Número: " + this.jTextField18.getText() + "</b></font></html>", "Refacturar con nuevo folio", 0, 0, this.PREG);
/* 5835 */       if (i == 0) {
/* 5836 */         limpiar();
/* 5837 */         this.jDialog11.setTitle("Refactura");
/* 5838 */         this.REFACTURAR = true;
/* 5839 */         this.con.consultar("tarjeta", "facturas", "where folio ='" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1)) + "'");
/* 5840 */         this.TARJETA = this.con.Campo;
/* 5841 */         verFactura();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton27ActionPerformed(ActionEvent evt) {
/* 5847 */     this.jDialog16.setVisible(false);
/* 5848 */     sacarFolioMayor();
/* 5849 */     activarFormatoFactura();
/* 5850 */     LeyendaSustituye();
/* 5851 */     this.jDialog11.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton33ActionPerformed(ActionEvent evt) {
/* 5855 */     this.jDialog16.setVisible(false);
/* 5856 */     this.jComboBox1.setSelectedItem(this.jTextField63.getText());
/* 5857 */     this.jTextField17.setText(this.jTextField64.getText());
/* 5858 */     this.jTextField10.setText(this.jTextField65.getText());
/* 5859 */     this.jTextField13.setText(this.jTextField66.getText());
/* 5860 */     this.jTextField14.setText(this.jTextField67.getText());
/* 5861 */     this.jTextField16.setText(this.jTextField69.getText());
/* 5862 */     this.jTextField15.setText(this.jTextField68.getText());
/* 5863 */     this.jComboBox9.setSelectedItem(this.jTextField70.getText());
/*      */     
/* 5865 */     sacarFolioMayor();
/* 5866 */     activarFormatoFactura();
/* 5867 */     LeyendaSustituye();
/* 5868 */     this.jDialog11.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jComboBox22ActionPerformed(ActionEvent evt) {
/* 5872 */     if (this.jComboBox22.getItemCount() > 0 && this.PRIMERA == true) {
/* 5873 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton34ActionPerformed(ActionEvent evt) {
/* 5878 */     Dimension di = this.jButton34.getSize();
/* 5879 */     Point p = this.jButton34.getLocationOnScreen();
/* 5880 */     this.jDialog1.setLocation(p.x + di.width - 200, p.y + 30);
/* 5881 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jTable8MouseClicked(MouseEvent evt) {
/* 5885 */     if (evt.getClickCount() == 2) {
/* 5886 */       this.jTextField71.setText(this.jTable8.getValueAt(this.jTable8.getSelectedRow(), 0).toString());
/* 5887 */       this.jDialog1.setVisible(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void activarFormatoFactura() {
/* 5892 */     this.jButton31.setEnabled(true);
/* 5893 */     this.jTextField18.setEnabled(true);
/* 5894 */     this.jButton9.setEnabled(false);
/* 5895 */     this.jDateChooser6.setEnabled(false);
/* 5896 */     this.jDateChooser6.setDate(new Date());
/* 5897 */     this.jTextField19.setEnabled(true);
/* 5898 */     this.jTextField20.setEnabled(true);
/*      */     
/* 5900 */     this.jComboBox13.setEnabled(true);
/* 5901 */     this.jTextField24.setEnabled(true);
/* 5902 */     this.jTextField26.setEnabled(true);
/* 5903 */     this.jTextField25.setEnabled(true);
/* 5904 */     this.jCheckBox1.setEnabled(true);
/* 5905 */     this.jComboBox10.setEnabled(true);
/* 5906 */     this.jComboBox2.setEnabled(true);
/* 5907 */     this.jComboBox4.setEnabled(true);
/* 5908 */     this.jComboBox12.setEnabled(true);
/* 5909 */     this.jComboBox2.setEnabled(true);
/* 5910 */     this.jComboBox4.setEnabled(true);
/* 5911 */     this.jTextField39.setEnabled(true);
/* 5912 */     this.jTextField40.setEnabled(true);
/* 5913 */     this.jTextField41.setEnabled(true);
/* 5914 */     this.jTextField42.setEnabled(true);
/*      */     
/* 5916 */     this.jTextField10.setEnabled(false);
/* 5917 */     this.jTextField13.setEnabled(false);
/* 5918 */     this.jTextField14.setEnabled(false);
/* 5919 */     this.jTextField15.setEnabled(false);
/* 5920 */     this.jTextField16.setEnabled(false);
/* 5921 */     this.jTextField17.setEnabled(false);
/* 5922 */     this.jButton18.setEnabled(false);
/* 5923 */     this.jComboBox9.setEnabled(false);
/* 5924 */     this.jSpinner1.setEnabled(false);
/*      */     
/* 5926 */     this.jTextField19.setEnabled(false);
/* 5927 */     this.jTextField37.setEnabled(false);
/* 5928 */     this.jTextField38.setEnabled(false);
/* 5929 */     this.jTextField44.setEnabled(false);
/* 5930 */     this.jTextField45.setEnabled(false);
/* 5931 */     this.jTextField43.setEnabled(false);
/* 5932 */     this.jRadioButton1.setEnabled(false);
/* 5933 */     this.jRadioButton2.setEnabled(false);
/*      */     
/* 5935 */     this.jComboBox14.setEnabled(true);
/* 5936 */     this.jComboBox17.setEnabled(true);
/* 5937 */     this.jComboBox19.setEnabled(true);
/* 5938 */     this.jComboBox15.setEnabled(true);
/* 5939 */     this.jComboBox20.setEnabled(true);
/* 5940 */     this.jTextField30.setEnabled(true);
/* 5941 */     this.jFormattedTextField2.setEnabled(true);
/* 5942 */     this.jTextField27.setEnabled(true);
/* 5943 */     this.jButton32.setEnabled(true);
/* 5944 */     this.jButton41.setEnabled(true);
/*      */   }
/*      */   
/*      */   public void verConcepto() {
/* 5948 */     this.jTextPane2.setEditable(false);
/* 5949 */     this.jTextPane2.setText("");
/* 5950 */     int ind = this.jTable6.getSelectedRow();
/* 5951 */     SimpleAttributeSet attrs = new SimpleAttributeSet();
/* 5952 */     StyleConstants.setBold(attrs, true);
/*      */     try {
/* 5954 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), "Número:  ", attrs);
/* 5955 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), String.valueOf(this.jTable6.getValueAt(ind, 0)) + "\n", null);
/* 5956 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), "Cliente:  ", attrs);
/* 5957 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), String.valueOf(this.jTable6.getValueAt(ind, 1)) + "\n", null);
/* 5958 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), "Clave:  ", attrs);
/* 5959 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), String.valueOf(this.jTable6.getValueAt(ind, 2)) + "\n", null);
/* 5960 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), "Unidad:  ", attrs);
/* 5961 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), String.valueOf(this.jTable6.getValueAt(ind, 3)) + "\n", null);
/* 5962 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), "Conepto:  ", attrs);
/* 5963 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), String.valueOf(this.jTable6.getValueAt(ind, 4)) + "\n", null);
/* 5964 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), "Cantidad:  ", attrs);
/* 5965 */       this.jTextPane2.getStyledDocument().insertString(this.jTextPane2.getStyledDocument().getLength(), String.valueOf(this.jTable6.getValueAt(ind, 5)) + "\n", null);
/* 5966 */     } catch (BadLocationException ex) {
/* 5967 */       Logger.getLogger(PrefacturaCliente.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultarPartidas() {
/* 5972 */     Date fecha1 = this.jDateChooser4.getDate();
/* 5973 */     Date fecha2 = this.jDateChooser5.getDate();
/*      */     
/* 5975 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 5976 */     String cadenaFecha = "";
/* 5977 */     cadenaFecha = formato.format(fecha1);
/* 5978 */     String AÑO = cadenaFecha.substring(0, 4);
/* 5979 */     String MES = cadenaFecha.substring(4, 6);
/* 5980 */     String DIA = cadenaFecha.substring(6, 8);
/* 5981 */     String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */     
/* 5983 */     cadenaFecha = formato.format(fecha2);
/* 5984 */     int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 5985 */     int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 5986 */     int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/* 5987 */     int diasTotal = diasDelMes(mm - 1, aa);
/* 5988 */     String fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + "'";
/*      */     
/* 5990 */     String estatus = " estatus='<Por Pagar>' || estatus like '%<Pagada%' || estatus like '%<Abono%'";
/* 5991 */     String cliente = "";
/* 5992 */     String equipo = "";
/* 5993 */     String plataforma = "";
/* 5994 */     String pozo = "";
/* 5995 */     String usuario = "";
/*      */     
/* 5997 */     String nuestroPedido = "";
/* 5998 */     if (this.jComboBox21.getSelectedIndex() != 0) {
/* 5999 */       nuestroPedido = String.valueOf(this.jComboBox21.getSelectedItem());
/*      */     }
/*      */     
/* 6002 */     if (this.jComboBox8.getSelectedIndex() == 1) {
/* 6003 */       estatus = " estatus like '%%'";
/* 6004 */     } else if (this.jComboBox8.getSelectedIndex() == 2) {
/* 6005 */       estatus = " estatus ='<Por Pagar>'";
/* 6006 */     } else if (this.jComboBox8.getSelectedIndex() == 3) {
/* 6007 */       estatus = " estatus like '%<Pagada%'";
/* 6008 */     } else if (this.jComboBox8.getSelectedIndex() == 4) {
/* 6009 */       estatus = " estatus like '%<Abono%'";
/* 6010 */     } else if (this.jComboBox8.getSelectedIndex() == 5) {
/* 6011 */       estatus = " estatus like '%<Cancelada%'";
/*      */     } 
/*      */     
/* 6014 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 6015 */       cliente = String.valueOf(this.jComboBox3.getSelectedItem());
/*      */     }
/* 6017 */     if (this.jComboBox5.getSelectedIndex() != 0) {
/* 6018 */       equipo = String.valueOf(this.jComboBox5.getSelectedItem());
/*      */     }
/* 6020 */     if (this.jComboBox6.getSelectedIndex() != 0) {
/* 6021 */       plataforma = String.valueOf(this.jComboBox6.getSelectedItem());
/*      */     }
/* 6023 */     if (this.jComboBox7.getSelectedIndex() != 0) {
/* 6024 */       pozo = String.valueOf(this.jComboBox7.getSelectedItem());
/*      */     }
/* 6026 */     if (this.jComboBox11.getSelectedIndex() != 0) {
/* 6027 */       usuario = String.valueOf(this.jComboBox11.getSelectedItem());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 6032 */     this.jTable7.setModel(new DefaultTableModel((Object[][])this.con
/* 6033 */           .buscarDatos(6, "disenotabla.folio,cant,unidad,descripcion,pUnit,importe", "disenotabla,facturas", "where disenotabla.folio = facturas.folio and facturas.folio like '%" + this.jTextField1.getText() + "%' and (" + estatus + ") and cliente like '%" + cliente + "%' and equipo like '%" + equipo + "%' and plataforma like '%" + plataforma + "%' and pozo like'%" + pozo + "%' and usuario like '%" + usuario + "%' and supedido like'%" + this.jTextField2.getText() + "%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " and nuestroPedido like '%" + nuestroPedido + "%' and disenotabla.descripcion like '%" + this.jTextField52.getText() + "%' order by numFactura desc"), (Object[])new String[] { "Factura", "Cant", "Unidad", "Descripcion", "P Unit", "Importe" })
/*      */         {
/*      */ 
/*      */           
/* 6037 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 6042 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 6045 */     this.jLabel69.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable7.getRowCount() + "</HTML>");
/* 6046 */     this.jLabel112.setText("$0.00");
/* 6047 */     this.jLabel70.setText("$0.00");
/* 6048 */     this.jLabel79.setText("$0.00");
/* 6049 */     double valorC = 0.0D;
/* 6050 */     double valorU = 0.0D;
/* 6051 */     double valorI = 0.0D;
/* 6052 */     for (int i = 0; i < this.jTable7.getRowCount(); i++) {
/* 6053 */       String canti = String.valueOf(this.jTable7.getValueAt(i, 1));
/* 6054 */       String valorP = ""; int j;
/* 6055 */       for (j = 0; j < canti.length(); j++) {
/* 6056 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 6057 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 6060 */       valorC += Double.parseDouble(valorP);
/* 6061 */       this.jFormattedTextField7.setValue(Double.valueOf(valorC));
/* 6062 */       this.jLabel112.setText(this.jFormattedTextField7.getText());
/*      */       
/* 6064 */       canti = String.valueOf(this.jTable7.getValueAt(i, 4));
/* 6065 */       valorP = "";
/* 6066 */       for (j = 0; j < canti.length(); j++) {
/* 6067 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 6068 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 6071 */       valorU += Double.parseDouble(valorP);
/* 6072 */       this.cantidad.setValue(Double.valueOf(valorU));
/* 6073 */       this.jLabel70.setText(this.cantidad.getText());
/*      */       
/* 6075 */       canti = String.valueOf(this.jTable7.getValueAt(i, 5));
/* 6076 */       valorP = "";
/* 6077 */       for (j = 0; j < canti.length(); j++) {
/* 6078 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 6079 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 6082 */       valorI += Double.parseDouble(valorP);
/* 6083 */       this.cantidad.setValue(Double.valueOf(valorI));
/* 6084 */       this.jLabel79.setText(this.cantidad.getText());
/*      */     } 
/*      */     
/* 6087 */     this.jTable7.setSelectionMode(0);
/* 6088 */     this.jTable7.setAutoCreateRowSorter(true);
/* 6089 */     this.jTable7.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 6091 */     this.jTable7.getColumnModel().getColumn(0).setPreferredWidth(80);
/* 6092 */     this.jTable7.getColumnModel().getColumn(0).setMaxWidth(80);
/* 6093 */     this.jTable7.getColumnModel().getColumn(1).setPreferredWidth(80);
/* 6094 */     this.jTable7.getColumnModel().getColumn(1).setMaxWidth(80);
/* 6095 */     this.jTable7.getColumnModel().getColumn(2).setPreferredWidth(80);
/* 6096 */     this.jTable7.getColumnModel().getColumn(2).setMaxWidth(80);
/* 6097 */     this.jTable7.getColumnModel().getColumn(4).setPreferredWidth(120);
/* 6098 */     this.jTable7.getColumnModel().getColumn(4).setMaxWidth(120);
/* 6099 */     this.jTable7.getColumnModel().getColumn(5).setPreferredWidth(120);
/* 6100 */     this.jTable7.getColumnModel().getColumn(5).setMaxWidth(120);
/*      */     
/* 6102 */     this.jTable7.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 6103 */     this.jTable7.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 6104 */     this.jTable7.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/*      */   }
/*      */   
/*      */   public void cargarRecepcion() {
/* 6108 */     String fact = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1));
/* 6109 */     String[] datos = this.con.regresaReg("fechaRecepcion,fechaRecepCompleta,usuarioRecep,recibio,entrego,lugarRecep,comentarioRecep", "facturas", "where folio = '" + fact + "'", 7);
/* 6110 */     if (datos[2].equals("")) {
/* 6111 */       this.jLabel147.setText("RECEPCION PENDIENTE");
/* 6112 */       this.jTextField47.setText(fact);
/* 6113 */       this.jTextField48.setText("");
/* 6114 */       this.jTextField49.setText("");
/* 6115 */       this.jTextField50.setText("");
/* 6116 */       this.jTextArea2.setText("");
/* 6117 */       this.jTextField51.setText(this.USUARIO);
/*      */       
/* 6119 */       String fecha = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 2));
/* 6120 */       String fechaCorta = fecha.substring(0, 10);
/*      */       
/* 6122 */       String año = fechaCorta.substring(0, 4);
/* 6123 */       String mes = fechaCorta.substring(5, 7);
/* 6124 */       String dia = fechaCorta.substring(8, 10);
/* 6125 */       SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 6126 */       String strFecha = dia + "-" + dia + "-" + mes;
/*      */       try {
/* 6128 */         Date fechaT = formatoDelTexto.parse(strFecha);
/* 6129 */         this.jDateChooser9.setDate(fechaT);
/* 6130 */       } catch (ParseException ex) {
/* 6131 */         ex.printStackTrace();
/*      */       } 
/*      */       
/* 6134 */       this.jDateChooser10.setDate(new Date());
/* 6135 */       datos = this.con.regresaReg("nombre,ap_pat,ap_mat", "empleados,usuarios", "where clave_emp = num_emp and nombre_usu ='" + this.USUARIO + "'", 3);
/* 6136 */       this.jTextField49.setText(datos[1] + " " + datos[1] + " " + datos[2]);
/* 6137 */       this.jButton21.setEnabled(true);
/* 6138 */       this.jDateChooser9.setEnabled(true);
/* 6139 */       this.jTextField48.setEnabled(true);
/* 6140 */       this.jTextField49.setEnabled(true);
/* 6141 */       this.jTextField50.setEnabled(true);
/* 6142 */       this.jTextArea2.setEnabled(true);
/*      */     } else {
/* 6144 */       this.jTextField47.setText(fact);
/* 6145 */       this.jLabel147.setText("RECEPCION CERRADA");
/*      */       
/* 6147 */       String fecha = datos[0];
/* 6148 */       String fechaCorta = fecha.substring(0, 10);
/*      */       
/* 6150 */       String año = fechaCorta.substring(0, 4);
/* 6151 */       String mes = fechaCorta.substring(5, 7);
/* 6152 */       String dia = fechaCorta.substring(8, 10);
/* 6153 */       SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 6154 */       String strFecha = dia + "-" + dia + "-" + mes;
/*      */       try {
/* 6156 */         Date fechaT = formatoDelTexto.parse(strFecha);
/* 6157 */         this.jDateChooser9.setDate(fechaT);
/* 6158 */       } catch (ParseException ex) {
/* 6159 */         ex.printStackTrace();
/*      */       } 
/*      */       
/* 6162 */       fecha = datos[1];
/* 6163 */       fechaCorta = fecha.substring(0, 10);
/*      */       
/* 6165 */       año = fechaCorta.substring(0, 4);
/* 6166 */       mes = fechaCorta.substring(5, 7);
/* 6167 */       dia = fechaCorta.substring(8, 10);
/* 6168 */       formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 6169 */       strFecha = dia + "-" + dia + "-" + mes;
/*      */       try {
/* 6171 */         Date fechaT = formatoDelTexto.parse(strFecha);
/* 6172 */         this.jDateChooser10.setDate(fechaT);
/* 6173 */       } catch (ParseException ex) {
/* 6174 */         ex.printStackTrace();
/*      */       } 
/*      */       
/* 6177 */       this.jTextField48.setText(datos[3]);
/* 6178 */       this.jTextField49.setText(datos[4]);
/* 6179 */       this.jTextArea2.setText(datos[6]);
/* 6180 */       this.jTextField50.setText(datos[5]);
/* 6181 */       this.jTextField51.setText(datos[2]);
/*      */       
/* 6183 */       this.jDateChooser9.setEnabled(false);
/* 6184 */       this.jTextField48.setEnabled(false);
/* 6185 */       this.jTextField49.setEnabled(false);
/* 6186 */       this.jTextField50.setEnabled(false);
/* 6187 */       this.jTextArea2.setEnabled(false);
/*      */       
/* 6189 */       this.jButton21.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void sumarConcep() {
/* 6194 */     String cant = this.jFormattedTextField2.getText();
/*      */     
/* 6196 */     boolean correcto = false;
/* 6197 */     String[] nombres = null;
/* 6198 */     int esp = 0;
/* 6199 */     String texto = this.jTextField27.getText(); int i;
/* 6200 */     for (i = 0; i < texto.length(); i++) {
/* 6201 */       if (texto.charAt(i) == ' ') {
/* 6202 */         esp++;
/*      */       }
/*      */     } 
/* 6205 */     nombres = new String[esp + 1];
/* 6206 */     for (i = 0; i <= esp; i++) {
/* 6207 */       nombres[i] = "";
/*      */     }
/* 6209 */     esp = 0;
/* 6210 */     for (i = 0; i < texto.length(); i++) {
/* 6211 */       if (texto.charAt(i) == ' ') {
/* 6212 */         esp++;
/*      */       } else {
/* 6214 */         nombres[esp] = nombres[esp] + nombres[esp];
/*      */       } 
/*      */     } 
/* 6217 */     for (i = 0; i < nombres.length; i++) {
/* 6218 */       if (nombres[i].length() == 0) {
/* 6219 */         this.jTextField27.setBackground(Color.RED);
/* 6220 */         JOptionPane.showMessageDialog(this.jDialog11, "Tienes un espacio de más en la descripción de la partida", "Error 031 - Espacio", 0, this.ERROR);
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/* 6225 */     if (Double.parseDouble(cant) <= 0.0D) {
/* 6226 */       this.jFormattedTextField2.setBackground(Color.RED);
/* 6227 */       JOptionPane.showMessageDialog(this.jDialog11, "No puedes colocar cantidad menores o iguales a cero (0.00)", "Cantidad pequeña", 0, this.ERROR);
/* 6228 */     } else if (this.jTextField27.getText().equals("")) {
/* 6229 */       this.jTextField27.setBackground(Color.RED);
/* 6230 */       JOptionPane.showMessageDialog(this.jDialog11, "No puedes dejar campo vacío", "Falta información", 0, this.ERROR);
/* 6231 */     } else if (this.jTextField27.getText().length() > 999) {
/* 6232 */       this.jTextField27.setBackground(Color.RED);
/* 6233 */       JOptionPane.showMessageDialog(this.jDialog11, "No puedes agregar más 999 caracteres en las partidas", "Partida muy larga", 0, this.ERROR);
/* 6234 */     } else if (this.jFormattedTextField3.getText().equals("$0.00")) {
/* 6235 */       this.jFormattedTextField3.setBackground(Color.RED);
/* 6236 */       JOptionPane.showMessageDialog(this.jDialog11, "No puedes dejar vacío el campo", "Falta información", 0, this.ERROR);
/*      */     } else {
/* 6238 */       String desc = this.jTextField27.getText().toUpperCase();
/* 6239 */       String valor = String.valueOf(this.jFormattedTextField3.getValue());
/*      */       
/* 6241 */       String valorP = "";
/* 6242 */       for (int j = 0; j < valor.length(); j++) {
/* 6243 */         if (valor.charAt(j) != '$' && valor.charAt(j) != ',') {
/* 6244 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 6247 */       double importe = Double.parseDouble(cant) * Double.parseDouble(valorP);
/* 6248 */       this.cantidad.setValue(Double.valueOf(importe));
/* 6249 */       this.jFormattedTextField4.setValue(Double.valueOf(importe));
/*      */       
/* 6251 */       if (!this.jTextField30.isEnabled()) {
/* 6252 */         int res = JOptionPane.showConfirmDialog(this.jDialog11, "¿Deseas modificar el concepto que seleccionaste?", "Modificar concepto", 0, 3, this.PREG);
/* 6253 */         if (res == 0) {
/* 6254 */           DefaultTableModel temp = (DefaultTableModel)this.jTable10.getModel();
/* 6255 */           Object[] nuevo = { cant, this.jComboBox16.getSelectedItem(), desc, this.jFormattedTextField3.getText(), this.cantidad.getText() };
/*      */           
/* 6257 */           valor = String.valueOf(this.jTable10.getValueAt(this.INDICE, 4));
/* 6258 */           valorP = "";
/* 6259 */           for (int k = 0; k < valor.length(); k++) {
/* 6260 */             if (valor.charAt(k) != '$' && valor.charAt(k) != ',') {
/* 6261 */               valorP = valorP + valorP;
/*      */             }
/*      */           } 
/* 6264 */           this.SUBTOTALD -= Double.parseDouble(valorP);
/* 6265 */           temp.removeRow(this.INDICE);
/*      */           
/* 6267 */           this.SUBTOTALD += importe;
/* 6268 */           sacarTotales2();
/* 6269 */           temp.insertRow(this.INDICE, nuevo);
/*      */           
/* 6271 */           this.jFormattedTextField2.setValue(Integer.valueOf(0));
/* 6272 */           this.jFormattedTextField3.setValue(Integer.valueOf(0));
/* 6273 */           this.jTextField27.setText("");
/* 6274 */           this.jFormattedTextField4.setValue(Integer.valueOf(0));
/* 6275 */           this.jTable10.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 6276 */           this.jTable10.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 6277 */           this.jTextField30.setText("");
/* 6278 */           this.jComboBox16.removeAllItems();
/* 6279 */           sacarTotales2();
/* 6280 */           this.jTextField30.setEnabled(true);
/*      */           
/* 6282 */           this.jButton41.setEnabled(true);
/* 6283 */           this.jButton31.setEnabled(true);
/*      */         } 
/*      */       } else {
/* 6286 */         int res = JOptionPane.showConfirmDialog(this.jDialog11, "¿Deseas agregar el nuevo concepto?", "Agregar concepto", 0, 3, this.PREG);
/* 6287 */         if (res == 0) {
/* 6288 */           DefaultTableModel temp = (DefaultTableModel)this.jTable10.getModel();
/* 6289 */           Object[] nuevo = { cant, this.jComboBox16.getSelectedItem(), desc, this.jFormattedTextField3.getText(), this.cantidad.getText() };
/* 6290 */           temp.addRow(nuevo);
/* 6291 */           this.SUBTOTALD += importe;
/* 6292 */           this.jFormattedTextField2.setValue(Integer.valueOf(0));
/* 6293 */           this.jFormattedTextField3.setValue(Integer.valueOf(0));
/* 6294 */           this.jTextField27.setText("");
/* 6295 */           this.jFormattedTextField4.setValue(Integer.valueOf(0));
/* 6296 */           this.jTable10.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 6297 */           this.jTable10.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 6298 */           this.jTextField30.setText("");
/* 6299 */           this.jComboBox16.removeAllItems();
/* 6300 */           sacarTotales2();
/* 6301 */           this.jButton41.setEnabled(true);
/* 6302 */           this.jButton31.setEnabled(true);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void agregarConceptos() {
/* 6309 */     String clave = this.jTextField9.getText();
/* 6310 */     String concepto = this.jTextField29.getText();
/* 6311 */     Double valor = Double.valueOf(Double.parseDouble(String.valueOf(this.jFormattedTextField5.getValue())));
/* 6312 */     if (this.jComboBox18.getSelectedIndex() == 0) {
/* 6313 */       this.jComboBox18.setBackground(Color.RED);
/* 6314 */       JOptionPane.showMessageDialog(this.jDialog10, "No puedes dejar vacío el dato para colocar el cliente", "Coloca el cliente", 0, this.ERROR);
/* 6315 */     } else if (clave.equals("")) {
/* 6316 */       this.jTextField9.setBackground(Color.RED);
/* 6317 */       JOptionPane.showMessageDialog(this.jDialog10, "No puedes dejar vacío el dato para colocar la clave", "Clave Vacía", 0, this.ERROR);
/* 6318 */     } else if (this.jTextField46.getText().equals("")) {
/* 6319 */       this.jTextField46.setBackground(Color.RED);
/* 6320 */       JOptionPane.showMessageDialog(this.jDialog10, "No puedes dejar vacío el dato para colocar la unidad", "Unidad Vacía", 0, this.ERROR);
/* 6321 */     } else if (concepto.equals("")) {
/* 6322 */       this.jTextField29.setBackground(Color.RED);
/* 6323 */       JOptionPane.showMessageDialog(this.jDialog10, "No puedes dejar vacío el dato para colocar el concepto", "Sin concepto", 0, this.ERROR);
/* 6324 */     } else if (valor.doubleValue() <= 0.0D) {
/* 6325 */       this.jFormattedTextField5.setBackground(Color.RED);
/* 6326 */       JOptionPane.showMessageDialog(this.jDialog10, "No puedes agregar cantidades menores a un peso", "Revisa la cantidad", 0, this.ERROR);
/*      */     } else {
/* 6328 */       int res = JOptionPane.showConfirmDialog(this.jDialog11, "¿Estás seguro que deseas guardar el nuevo concepto?", "Guardar Concepto", 0, 3, this.PREG);
/* 6329 */       if (res == 0) {
/* 6330 */         this.con.inserSinMsj("insert into conceptosfact(clave,concepto,unidad,cantidadLetra,cantidad,CLIENTE)values('" + this.jTextField9.getText().toUpperCase() + "','" + this.jTextField29.getText().toUpperCase() + "','" + this.jTextField46.getText().toUpperCase() + "','" + this.jFormattedTextField5.getText() + "'," + String.valueOf(this.jFormattedTextField5.getValue()) + ",'" + String.valueOf(this.jComboBox18.getSelectedItem()) + "')");
/*      */         
/* 6332 */         this.jTextField30.setText(this.jTextField9.getText());
/* 6333 */         this.jComboBox16.addItem(this.jTextField46.getText().toUpperCase());
/* 6334 */         this.jComboBox16.setSelectedItem(this.jTextField46.getText().toUpperCase());
/* 6335 */         this.jTextField27.setText(this.jTextField29.getText().toUpperCase());
/* 6336 */         this.jFormattedTextField3.setValue(Double.valueOf(Double.parseDouble(String.valueOf(this.jFormattedTextField5.getValue()))));
/* 6337 */         this.jFormattedTextField2.setValue(Integer.valueOf(0));
/*      */         
/* 6339 */         this.com_Claves.addItem(this.jTextField9.getText());
/* 6340 */         if (!this.com_Conceptos.itemExists(this.jTextField29.getText())) {
/* 6341 */           this.com_Conceptos.addItem(this.jTextField29.getText().toUpperCase());
/*      */         }
/* 6343 */         this.jTextField9.setText("");
/* 6344 */         this.jTextField46.setText("");
/* 6345 */         this.jTextField29.setText("");
/* 6346 */         this.jFormattedTextField5.setValue(Integer.valueOf(0));
/* 6347 */         sacarMayor();
/* 6348 */         consultarConceptos();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void sacarMayor() {
/* 6354 */     this.con.consultar("max(num)", "ConceptosFact", "");
/* 6355 */     String mayor = this.con.Campo;
/* 6356 */     int MAYOR = Integer.parseInt(mayor);
/* 6357 */     MAYOR++;
/*      */     
/* 6359 */     if (MAYOR < 10) {
/* 6360 */       this.jTextField9.setText("000" + MAYOR);
/* 6361 */     } else if (MAYOR < 100) {
/* 6362 */       this.jTextField9.setText("00" + MAYOR);
/* 6363 */     } else if (MAYOR < 1000) {
/* 6364 */       this.jTextField9.setText("0" + MAYOR);
/* 6365 */     } else if (MAYOR < 10000) {
/* 6366 */       this.jTextField9.setText("" + MAYOR);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultarConceptos() {
/* 6371 */     String cliente = "";
/* 6372 */     if (this.jComboBox18.getSelectedIndex() != 0) {
/* 6373 */       cliente = String.valueOf(this.jComboBox18.getSelectedItem());
/*      */     }
/*      */     
/* 6376 */     this.jTable6.setModel(new DefaultTableModel((Object[][])this.con
/* 6377 */           .buscarDatos(6, "num,cliente,clave,unidad,concepto,CantidadLetra", "conceptosfact", "where cliente like '%" + cliente + "%' and clave like '%" + this.jTextField54.getText() + "%' and concepto like '%" + this.jTextField55.getText() + "%'order by concepto"), (Object[])new String[] { "Núm", "Cliente", "Clave", "Unidad", "Concepto", "Cantidad" })
/*      */         {
/*      */           
/* 6380 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 6385 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 6389 */     this.jTable6.setShowVerticalLines(false);
/* 6390 */     this.jScrollPane8.setViewportView(this.jTable6);
/*      */     
/* 6392 */     this.jTable6.setSelectionMode(0);
/* 6393 */     this.jTable6.setAutoCreateRowSorter(true);
/* 6394 */     this.jTable6.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 6396 */     this.jTable6.getColumnModel().getColumn(0).setPreferredWidth(40);
/* 6397 */     this.jTable6.getColumnModel().getColumn(0).setMaxWidth(40);
/*      */     
/* 6399 */     this.jTable6.getColumnModel().getColumn(2).setPreferredWidth(80);
/* 6400 */     this.jTable6.getColumnModel().getColumn(2).setMaxWidth(80);
/* 6401 */     this.jTable6.getColumnModel().getColumn(3).setPreferredWidth(120);
/* 6402 */     this.jTable6.getColumnModel().getColumn(3).setMaxWidth(120);
/*      */     
/* 6404 */     this.jTable6.getColumnModel().getColumn(5).setPreferredWidth(80);
/* 6405 */     this.jTable6.getColumnModel().getColumn(5).setMaxWidth(80);
/*      */     
/* 6407 */     this.jTable6.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/*      */     
/* 6409 */     if (!this.PRIMERACONCEPTOS) {
/* 6410 */       this.PRIMERACONCEPTOS = true;
/* 6411 */       for (int i = 0; i < this.jTable6.getRowCount(); i++) {
/* 6412 */         if (!this.TODOS_UNIDADES.contains(this.jTable6.getValueAt(i, 3))) {
/* 6413 */           this.TODOS_UNIDADES.add(this.jTable6.getValueAt(i, 3));
/*      */         }
/*      */         
/* 6416 */         this.TODAS_CLAVES.add(this.jTable6.getValueAt(i, 2));
/* 6417 */         if (!this.TODOS_CONCEPTOS.contains(this.jTable6.getValueAt(i, 4))) {
/* 6418 */           this.TODOS_CONCEPTOS.add(this.jTable6.getValueAt(i, 4));
/*      */         }
/*      */       } 
/* 6421 */       this.com_Claves = new TextAutoCompleter(this.jTextField30, this.TODAS_CLAVES);
/* 6422 */       this.com_Conceptos = new TextAutoCompleter(this.jTextField27, this.TODOS_CONCEPTOS);
/* 6423 */       this.com_Unidades = new TextAutoCompleter(this.jTextField46, this.TODOS_UNIDADES);
/*      */     } 
/*      */   }
/*      */   
/*      */   public int alinearDer(int x, int letras) {
/* 6428 */     int quitar = 3 * letras;
/* 6429 */     x -= quitar;
/* 6430 */     return x;
/*      */   }
/*      */   
/*      */   public void cancelar() {
/* 6434 */     String motivo = this.jTextArea5.getText();
/* 6435 */     if (motivo.equals("")) {
/* 6436 */       this.jTextArea5.setBackground(Color.RED);
/* 6437 */       JOptionPane.showMessageDialog(this.jDialog8, "Necesitas colocar el motivo de cancelación de la factura", "Coloca un comentario", 0, this.ERROR);
/*      */     } else {
/* 6439 */       int res = JOptionPane.showConfirmDialog(this.jDialog8, "¿Estás seguro que deseas cancelar la factura que seleccionaste?", "Cancelar Factura", 0, 3, this.PREG);
/* 6440 */       if (res == 0) {
/* 6441 */         String num = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1));
/* 6442 */         this.con.inserSinMsj("update facturas set estatus='<Cancelada: " + this.USUARIO + " " + cargarFechaHoy() + ">', motivo ='" + this.jTextArea5.getText().toUpperCase() + "' where folio='" + num + "'");
/* 6443 */         this.con.inserSinMsj("update prefacturacliente set estatus='<Por Facturar>',folio='' where folio='" + num + "'");
/* 6444 */         this.con.inserSinMsj("update guias set estatus='<En Prefactura Interna>',factImpresa='' where factImpresa = '" + num + "'");
/*      */         
/* 6446 */         String[] datos = this.con.regresaReg("importe,importeLetra", "tarjeta_contenido_cliente", "where factura = '" + num + "'", 2);
/* 6447 */         double total = 0.0D;
/*      */         
/* 6449 */         this.con.inserSinMsj("update tarjeta_contenido_cliente set importeSaldado =" + datos[0] + ",importeRestante=0,ImporteRestanteLetra='$0.00',comentario='" + this.jTextArea5.getText().toUpperCase() + "', estatus='<Cancelado: " + this.USUARIO + " " + cargarFechaHoy() + ">' where factura='" + num + "'");
/*      */         
/* 6451 */         this.con.consultar("sum(importeRestante)", "tarjeta_contenido_cliente", "where tarjeta = " + this.TARJETA);
/* 6452 */         total = Double.parseDouble(this.con.Campo);
/* 6453 */         total = redondear(total).doubleValue();
/* 6454 */         this.cantidad.setValue(Double.valueOf(total));
/* 6455 */         this.con.inserSinMsj("insert into tarjeta_contenido_cliente(fecha, tipoConcep, tipo,    concepto,            referencia,   importe,importeLetra,abono,     abonoLetra,  importeSaldado,importeRestante,ImporteRestanteLetra,estatus,comentario,                                                                       factura,num_abono,saldoFinal,saldoFinalLetra,pago1,pago2,pago3,pago4,tarjeta,usuario)values(now(),    2,           2,'ABONO POR CANCELACIÓN','FACTURA: " + num + "',0,        '',  " + datos[0] + ",'" + datos[1] + "',0               ,0,                     '',     '<Aplicado>','ESTE MOVIMIENTO SE ABONÓ AUTOMÁTICO DEBIDO A UNA CANCELACIÓN POR UNA FACTURA','',        ''," + total + ",'" + this.cantidad
/* 6456 */             .getText() + "','','','',''," + this.TARJETA + ",'" + this.USUARIO + "')");
/*      */         
/* 6458 */         this.con.inserSinMsj("update tarjeta_deudor_cliente set total='" + this.cantidad.getText() + "' where tarjeta=" + this.TARJETA);
/*      */         
/* 6460 */         this.mensajeTry.guardarConf("Se cancelo una factura, USUARIO: " + this.USUARIO, "Factura Cancelada (" + num + ")", "ERROR", "Facturacion");
/* 6461 */         consultar();
/* 6462 */         this.jDialog8.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 6468 */     this.jTextArea5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6470 */             Facturas.this.jTextGanado(Facturas.this.jTextArea5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6474 */             Facturas.this.jTextPerdido(Facturas.this.jTextArea5, evt);
/*      */           }
/*      */         });
/*      */     
/* 6478 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6480 */             Facturas.this.jTextGanado(Facturas.this.jTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6484 */             Facturas.this.jTextPerdido(Facturas.this.jTextField1, evt);
/*      */           }
/*      */         });
/*      */     
/* 6488 */     this.jTextField30.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6490 */             Facturas.this.jTextGanado(Facturas.this.jTextField30, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6494 */             Facturas.this.jTextPerdido(Facturas.this.jTextField30, evt);
/*      */           }
/*      */         });
/*      */     
/* 6498 */     this.jTextField53.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6500 */             Facturas.this.jTextGanado(Facturas.this.jTextField53, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6504 */             Facturas.this.jTextPerdido(Facturas.this.jTextField53, evt);
/*      */           }
/*      */         });
/*      */     
/* 6508 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6510 */             Facturas.this.jTextGanado(Facturas.this.jTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6514 */             Facturas.this.jTextPerdido(Facturas.this.jTextField2, evt);
/*      */           }
/*      */         });
/*      */     
/* 6518 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6520 */             Facturas.this.jTextGanado(Facturas.this.jTextField6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6524 */             Facturas.this.jTextPerdido(Facturas.this.jTextField6, evt);
/*      */           }
/*      */         });
/* 6527 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6529 */             Facturas.this.jTextGanado(Facturas.this.jTextField7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6533 */             Facturas.this.jTextPerdido(Facturas.this.jTextField7, evt);
/*      */           }
/*      */         });
/* 6536 */     this.jTextField46.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6538 */             Facturas.this.jTextGanado(Facturas.this.jTextField46, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6542 */             Facturas.this.jTextPerdido(Facturas.this.jTextField46, evt);
/*      */           }
/*      */         });
/* 6545 */     this.jTextField10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6547 */             Facturas.this.jTextGanado(Facturas.this.jTextField10, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6551 */             Facturas.this.jTextPerdido(Facturas.this.jTextField10, evt);
/*      */           }
/*      */         });
/* 6554 */     this.jTextField13.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6556 */             Facturas.this.jTextGanado(Facturas.this.jTextField13, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6560 */             Facturas.this.jTextPerdido(Facturas.this.jTextField13, evt);
/*      */           }
/*      */         });
/* 6563 */     this.jTextField14.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6565 */             Facturas.this.jTextGanado(Facturas.this.jTextField14, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6569 */             Facturas.this.jTextPerdido(Facturas.this.jTextField14, evt);
/*      */           }
/*      */         });
/*      */     
/* 6573 */     this.jTextField54.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6575 */             Facturas.this.jTextGanado(Facturas.this.jTextField54, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6579 */             Facturas.this.jTextPerdido(Facturas.this.jTextField54, evt);
/*      */           }
/*      */         });
/*      */     
/* 6583 */     this.jTextField55.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6585 */             Facturas.this.jTextGanado(Facturas.this.jTextField55, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6589 */             Facturas.this.jTextPerdido(Facturas.this.jTextField55, evt);
/*      */           }
/*      */         });
/*      */     
/* 6593 */     this.jTextField15.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6595 */             Facturas.this.jTextGanado(Facturas.this.jTextField15, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6599 */             Facturas.this.jTextPerdido(Facturas.this.jTextField15, evt);
/*      */           }
/*      */         });
/* 6602 */     this.jTextField16.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6604 */             Facturas.this.jTextGanado(Facturas.this.jTextField16, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6608 */             Facturas.this.jTextPerdido(Facturas.this.jTextField16, evt);
/*      */           }
/*      */         });
/* 6611 */     this.jTextField17.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6613 */             Facturas.this.jTextGanado(Facturas.this.jTextField17, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6617 */             Facturas.this.jTextPerdido(Facturas.this.jTextField17, evt);
/*      */           }
/*      */         });
/* 6620 */     this.jTextField18.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6622 */             Facturas.this.jTextGanado(Facturas.this.jTextField18, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6626 */             Facturas.this.jTextPerdido(Facturas.this.jTextField18, evt);
/*      */           }
/*      */         });
/* 6629 */     this.jTextField19.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6631 */             Facturas.this.jTextGanado(Facturas.this.jTextField19, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6635 */             Facturas.this.jTextPerdido(Facturas.this.jTextField19, evt);
/*      */           }
/*      */         });
/* 6638 */     this.jTextField20.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6640 */             Facturas.this.jTextGanado(Facturas.this.jTextField20, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6644 */             Facturas.this.jTextPerdido(Facturas.this.jTextField20, evt);
/*      */           }
/*      */         });
/* 6647 */     this.jTextField22.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6649 */             Facturas.this.jTextGanado(Facturas.this.jTextField22, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6653 */             Facturas.this.jTextPerdido(Facturas.this.jTextField22, evt);
/*      */           }
/*      */         });
/*      */     
/* 6657 */     this.jComboBox13.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6659 */             Facturas.this.jTextGanado(Facturas.this.jComboBox13, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6663 */             Facturas.this.jTextPerdido(Facturas.this.jComboBox13, evt);
/*      */           }
/*      */         });
/* 6666 */     this.jComboBox21.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6668 */             Facturas.this.jTextGanado(Facturas.this.jComboBox21, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6672 */             Facturas.this.jTextPerdido(Facturas.this.jComboBox21, evt);
/*      */           }
/*      */         });
/* 6675 */     this.jTextField24.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6677 */             Facturas.this.jTextGanado(Facturas.this.jTextField24, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6681 */             Facturas.this.jTextPerdido(Facturas.this.jTextField24, evt);
/*      */           }
/*      */         });
/* 6684 */     this.jTextField26.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6686 */             Facturas.this.jTextGanado(Facturas.this.jTextField26, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6690 */             Facturas.this.jTextPerdido(Facturas.this.jTextField26, evt);
/*      */           }
/*      */         });
/* 6693 */     this.jTextField27.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6695 */             Facturas.this.jTextGanado(Facturas.this.jTextField27, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6699 */             Facturas.this.jTextPerdido(Facturas.this.jTextField27, evt);
/*      */           }
/*      */         });
/* 6702 */     this.jTextField28.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6704 */             Facturas.this.jTextGanado(Facturas.this.jTextField28, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6708 */             Facturas.this.jTextPerdido(Facturas.this.jTextField28, evt);
/*      */           }
/*      */         });
/* 6711 */     this.jTextField39.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6713 */             Facturas.this.jTextGanado(Facturas.this.jTextField39, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6717 */             Facturas.this.jTextPerdido(Facturas.this.jTextField39, evt);
/*      */           }
/*      */         });
/* 6720 */     this.jTextField32.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6722 */             Facturas.this.jTextGanado(Facturas.this.jTextField32, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6726 */             Facturas.this.jTextPerdido(Facturas.this.jTextField32, evt);
/*      */           }
/*      */         });
/* 6729 */     this.jTextField34.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6731 */             Facturas.this.jTextGanado(Facturas.this.jTextField34, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6735 */             Facturas.this.jTextPerdido(Facturas.this.jTextField34, evt);
/*      */           }
/*      */         });
/* 6738 */     this.jTextField35.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6740 */             Facturas.this.jTextGanado(Facturas.this.jTextField35, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6744 */             Facturas.this.jTextPerdido(Facturas.this.jTextField35, evt);
/*      */           }
/*      */         });
/* 6747 */     this.jTextField36.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6749 */             Facturas.this.jTextGanado(Facturas.this.jTextField36, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6753 */             Facturas.this.jTextPerdido(Facturas.this.jTextField36, evt);
/*      */           }
/*      */         });
/* 6756 */     this.jTextField31.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6758 */             Facturas.this.jTextGanado(Facturas.this.jTextField31, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6762 */             Facturas.this.jTextPerdido(Facturas.this.jTextField31, evt);
/*      */           }
/*      */         });
/* 6765 */     this.jTextField33.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6767 */             Facturas.this.jTextGanado(Facturas.this.jTextField33, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6771 */             Facturas.this.jTextPerdido(Facturas.this.jTextField33, evt);
/*      */           }
/*      */         });
/*      */     
/* 6775 */     this.jTextField40.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6777 */             Facturas.this.jTextGanado(Facturas.this.jTextField40, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6781 */             Facturas.this.jTextPerdido(Facturas.this.jTextField40, evt);
/*      */           }
/*      */         });
/* 6784 */     this.jTextField41.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6786 */             Facturas.this.jTextGanado(Facturas.this.jTextField41, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6790 */             Facturas.this.jTextPerdido(Facturas.this.jTextField41, evt);
/*      */           }
/*      */         });
/* 6793 */     this.jTextField42.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6795 */             Facturas.this.jTextGanado(Facturas.this.jTextField42, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6799 */             Facturas.this.jTextPerdido(Facturas.this.jTextField42, evt);
/*      */           }
/*      */         });
/*      */     
/* 6803 */     this.jTextField9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6805 */             Facturas.this.jTextGanado(Facturas.this.jTextField9, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6809 */             Facturas.this.jTextPerdido(Facturas.this.jTextField9, evt);
/*      */           }
/*      */         });
/*      */     
/* 6813 */     this.jTextField29.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6815 */             Facturas.this.jTextGanado(Facturas.this.jTextField29, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6819 */             Facturas.this.jTextPerdido(Facturas.this.jTextField29, evt);
/*      */           }
/*      */         });
/*      */     
/* 6823 */     this.jTextField48.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6825 */             Facturas.this.jTextGanado(Facturas.this.jTextField48, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6829 */             Facturas.this.jTextPerdido(Facturas.this.jTextField48, evt);
/*      */           }
/*      */         });
/*      */     
/* 6833 */     this.jTextField49.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6835 */             Facturas.this.jTextGanado(Facturas.this.jTextField49, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6839 */             Facturas.this.jTextPerdido(Facturas.this.jTextField49, evt);
/*      */           }
/*      */         });
/*      */     
/* 6843 */     this.jTextField50.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6845 */             Facturas.this.jTextGanado(Facturas.this.jTextField50, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6849 */             Facturas.this.jTextPerdido(Facturas.this.jTextField50, evt);
/*      */           }
/*      */         });
/*      */     
/* 6853 */     this.jTextField52.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6855 */             Facturas.this.jTextGanado(Facturas.this.jTextField52, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6859 */             Facturas.this.jTextPerdido(Facturas.this.jTextField52, evt);
/*      */           }
/*      */         });
/*      */     
/* 6863 */     this.jTextArea2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6865 */             Facturas.this.jTextGanado(Facturas.this.jTextArea2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6869 */             Facturas.this.jTextPerdido(Facturas.this.jTextArea2, evt);
/*      */           }
/*      */         });
/*      */     
/* 6873 */     this.jFormattedTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6875 */             Facturas.this.jTextGanado(Facturas.this.jFormattedTextField1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6879 */             Facturas.this.jTextPerdido(Facturas.this.jFormattedTextField1, evt);
/*      */           }
/*      */         });
/* 6882 */     this.jFormattedTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6884 */             Facturas.this.jTextGanado(Facturas.this.jFormattedTextField2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6888 */             Facturas.this.jTextPerdido(Facturas.this.jFormattedTextField2, evt);
/*      */           }
/*      */         });
/* 6891 */     this.jFormattedTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6893 */             Facturas.this.jTextGanado(Facturas.this.jFormattedTextField3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6897 */             Facturas.this.jTextPerdido(Facturas.this.jFormattedTextField3, evt);
/*      */           }
/*      */         });
/* 6900 */     this.jFormattedTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6902 */             Facturas.this.jTextGanado(Facturas.this.jFormattedTextField5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6906 */             Facturas.this.jTextPerdido(Facturas.this.jFormattedTextField5, evt);
/*      */           }
/*      */         });
/* 6909 */     this.jFormattedTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6911 */             Facturas.this.jTextGanado(Facturas.this.jFormattedTextField6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6915 */             Facturas.this.jTextPerdido(Facturas.this.jFormattedTextField6, evt);
/*      */           }
/*      */         });
/*      */     
/* 6919 */     this.jFormattedTextField8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6921 */             Facturas.this.jTextGanado(Facturas.this.jFormattedTextField8, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6925 */             Facturas.this.jTextPerdido(Facturas.this.jFormattedTextField8, evt);
/*      */           }
/*      */         });
/* 6928 */     this.jFormattedTextField9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6930 */             Facturas.this.jTextGanado(Facturas.this.jFormattedTextField9, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6934 */             Facturas.this.jTextPerdido(Facturas.this.jFormattedTextField9, evt);
/*      */           }
/*      */         });
/*      */     
/* 6938 */     this.jComboBox8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6940 */             Facturas.this.jTextGanado(Facturas.this.jComboBox8, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6944 */             Facturas.this.jTextPerdido(Facturas.this.jComboBox8, evt);
/*      */           }
/*      */         });
/*      */     
/* 6948 */     this.jComboBox14.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6950 */             Facturas.this.jTextGanado(Facturas.this.jComboBox14, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6954 */             Facturas.this.jTextPerdido(Facturas.this.jComboBox14, evt);
/*      */           }
/*      */         });
/*      */     
/* 6958 */     this.jComboBox17.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6960 */             Facturas.this.jTextGanado(Facturas.this.jComboBox17, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6964 */             Facturas.this.jTextPerdido(Facturas.this.jComboBox17, evt);
/*      */           }
/*      */         });
/* 6967 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6969 */             Facturas.this.jTextGanado(Facturas.this.jComboBox3, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6973 */             Facturas.this.jTextPerdido(Facturas.this.jComboBox3, evt);
/*      */           }
/*      */         });
/* 6976 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6978 */             Facturas.this.jTextGanado(Facturas.this.jComboBox4, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6982 */             Facturas.this.jTextPerdido(Facturas.this.jComboBox4, evt);
/*      */           }
/*      */         });
/* 6985 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6987 */             Facturas.this.jTextGanado(Facturas.this.jComboBox2, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 6991 */             Facturas.this.jTextPerdido(Facturas.this.jComboBox2, evt);
/*      */           }
/*      */         });
/* 6994 */     this.jComboBox5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 6996 */             Facturas.this.jTextGanado(Facturas.this.jComboBox5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7000 */             Facturas.this.jTextPerdido(Facturas.this.jComboBox5, evt);
/*      */           }
/*      */         });
/* 7003 */     this.jComboBox22.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7005 */             Facturas.this.jTextGanado(Facturas.this.jComboBox22, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7009 */             Facturas.this.jTextPerdido(Facturas.this.jComboBox22, evt);
/*      */           }
/*      */         });
/* 7012 */     this.jComboBox6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7014 */             Facturas.this.jTextGanado(Facturas.this.jComboBox6, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7018 */             Facturas.this.jTextPerdido(Facturas.this.jComboBox6, evt);
/*      */           }
/*      */         });
/* 7021 */     this.jComboBox7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7023 */             Facturas.this.jTextGanado(Facturas.this.jComboBox7, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7027 */             Facturas.this.jTextPerdido(Facturas.this.jComboBox7, evt);
/*      */           }
/*      */         });
/* 7030 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7032 */             Facturas.this.jTextGanado(Facturas.this.jComboBox1, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7036 */             Facturas.this.jTextPerdido(Facturas.this.jComboBox1, evt);
/*      */           }
/*      */         });
/* 7039 */     this.jComboBox9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7041 */             Facturas.this.jTextGanado(Facturas.this.jComboBox9, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7045 */             Facturas.this.jTextPerdido(Facturas.this.jComboBox9, evt);
/*      */           }
/*      */         });
/* 7048 */     this.jComboBox10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7050 */             Facturas.this.jTextGanado(Facturas.this.jComboBox10, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7054 */             Facturas.this.jTextPerdido(Facturas.this.jComboBox10, evt);
/*      */           }
/*      */         });
/* 7057 */     this.jComboBox11.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7059 */             Facturas.this.jTextGanado(Facturas.this.jComboBox11, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7063 */             Facturas.this.jTextPerdido(Facturas.this.jComboBox11, evt);
/*      */           }
/*      */         });
/* 7066 */     this.jComboBox12.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7068 */             Facturas.this.jTextGanado(Facturas.this.jComboBox12, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7072 */             Facturas.this.jTextPerdido(Facturas.this.jComboBox12, evt);
/*      */           }
/*      */         });
/* 7075 */     this.jComboBox18.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 7077 */             Facturas.this.jTextGanado(Facturas.this.jComboBox18, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 7081 */             Facturas.this.jTextPerdido(Facturas.this.jComboBox18, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void crearFactura(String nombre) throws IOException {
/* 7087 */     FileOutputStream fos = null;
/*      */     try {
/* 7089 */       System.out.println("Rutaaa: " + this.RUTAENTRADA + "/" + nombre + ".txt");
/* 7090 */       fos = new FileOutputStream(this.RUTAENTRADA + "/" + this.RUTAENTRADA + ".txt");
/* 7091 */     } catch (IOException l) {
/* 7092 */       JOptionPane.showMessageDialog(null, "Error al crear el archivo de configuraciones para este usuario\nSi persisten los problemas por favor contacta al diseñador o envia un correo a kofuz01@hotmail.com", "No se pudo crear el archivo config.sde", 0, this.ERROR);
/*      */     } 
/*      */     
/* 7095 */     String folio = this.jTextField18.getText();
/* 7096 */     String conse = "";
/* 7097 */     String letra = "";
/* 7098 */     for (int i = 0; i < folio.length(); i++) {
/*      */       try {
/* 7100 */         int valor = Integer.parseInt("" + folio.charAt(i));
/* 7101 */         conse = conse + conse;
/* 7102 */       } catch (NumberFormatException e) {
/* 7103 */         letra = letra + letra;
/*      */       } 
/*      */     } 
/* 7106 */     String[] metodos = { "01", "02", "03", "04", "05", "06", "08", "28", "29", "NA", "99" };
/* 7107 */     PrintWriter pw = new PrintWriter(fos);
/* 7108 */     pw.println("HOJA");
/* 7109 */     pw.println("########################################################################");
/* 7110 */     pw.println("");
/* 7111 */     pw.println("[Datos Generales]");
/* 7112 */     pw.println("serie|" + letra);
/* 7113 */     pw.println("folio|" + conse);
/* 7114 */     pw.println("asignaFolio|false");
/* 7115 */     pw.println("");
/*      */     
/* 7117 */     pw.println("[Datos del Emisor]");
/* 7118 */     pw.println("emRegimen|PERSONA MORAL REGIMEN GRAL. DE LA LISR");
/* 7119 */     pw.println("emRfc|FMF901004UZ9");
/* 7120 */     pw.println("emNombre|FLETES Y MATERIALES FORSIS, S.A. DE C.V.");
/* 7121 */     pw.println("emCalle|");
/* 7122 */     pw.println("emExterior|");
/* 7123 */     pw.println("emInterior|");
/* 7124 */     pw.println("emColonia|");
/* 7125 */     pw.println("emLocalidad|");
/* 7126 */     pw.println("emReferencia|");
/* 7127 */     pw.println("emMunicipio|");
/* 7128 */     pw.println("emEstado|");
/* 7129 */     pw.println("emPais|");
/* 7130 */     pw.println("emCodigoPostal|");
/* 7131 */     pw.println("emProveedor|");
/* 7132 */     pw.println("emGLN|");
/* 7133 */     pw.println("");
/*      */     
/* 7135 */     pw.println("[Datos de Expedicion bases]");
/* 7136 */     pw.println("exAlias|" + this.ALIAS);
/* 7137 */     pw.println("exTelefono|(01 782) 825 6455");
/* 7138 */     pw.println("exCalle|CARRETERA POZA RICA- TUXPAN KM 8.5");
/* 7139 */     pw.println("exNoExterior|");
/* 7140 */     pw.println("exNoInterior|");
/* 7141 */     pw.println("exColonia|");
/* 7142 */     pw.println("exLocalidad|");
/* 7143 */     pw.println("exReferencia|");
/* 7144 */     pw.println("exMunicipio|TIHUATLAN");
/* 7145 */     pw.println("exEstado|VERACRUZ");
/* 7146 */     pw.println("exPais|MEXICO");
/* 7147 */     pw.println("exCodigoPostal|92900");
/* 7148 */     pw.println("");
/*      */     
/* 7150 */     pw.println("[Datos del Receptor]");
/* 7151 */     pw.println("reRfc|" + this.jTextField17.getText());
/* 7152 */     pw.println("reNombre|" + String.valueOf(this.jComboBox1.getSelectedItem()));
/* 7153 */     pw.println("reCalle|" + this.jTextField10.getText());
/* 7154 */     pw.println("reNoExterior|" + this.jTextField13.getText());
/* 7155 */     pw.println("reNoInterior|");
/* 7156 */     pw.println("reColonia|" + this.jTextField14.getText());
/* 7157 */     pw.println("reLocalidad|");
/* 7158 */     pw.println("reReferencia|");
/* 7159 */     pw.println("reMunicipio|" + this.jTextField16.getText());
/* 7160 */     pw.println("reEstado|" + String.valueOf(this.jComboBox9.getSelectedItem()));
/* 7161 */     pw.println("rePais|MEXICO");
/* 7162 */     pw.println("reCodigoPostal|" + this.jTextField15.getText());
/* 7163 */     pw.println("reNoCliente|");
/* 7164 */     pw.println("reEmail|");
/* 7165 */     pw.println("reTelefono|");
/* 7166 */     pw.println("reFax|");
/* 7167 */     pw.println("reComprador|");
/* 7168 */     pw.println("reNIM|");
/* 7169 */     pw.println("");
/*      */     
/* 7171 */     pw.println("[Datos del Remitente]");
/* 7172 */     pw.println("remRfc|");
/* 7173 */     pw.println("remNombre|FLETES Y MATERIALES FORSIS, S.A. DE C.V.");
/* 7174 */     pw.println("remClaveIdentificacion|");
/* 7175 */     pw.println("remCalle|CARRETERA POZA RICA- TUXPAN KM 8.5");
/* 7176 */     pw.println("remNumero|");
/* 7177 */     pw.println("remReferencia|");
/* 7178 */     pw.println("remColonia|");
/* 7179 */     pw.println("remCiudad|TIHUATLAN");
/* 7180 */     pw.println("remMunicipio|TIHUATLAN");
/* 7181 */     pw.println("remEstado|VERACRUZ");
/* 7182 */     pw.println("remPais|MEXICO");
/* 7183 */     pw.println("remCodigoPostal|92900");
/* 7184 */     pw.println("");
/*      */     
/* 7186 */     for (int j = 0; j < this.jTable10.getRowCount(); j++) {
/* 7187 */       int va = j;
/* 7188 */       va++;
/* 7189 */       pw.println("[Datos de Conceptos]");
/* 7190 */       pw.println("cantidad|" + String.valueOf(this.jTable10.getValueAt(j, 0)));
/* 7191 */       pw.println("unidad|" + String.valueOf(this.jTable10.getValueAt(j, 1)));
/* 7192 */       pw.println("numIdentificacion|" + va);
/* 7193 */       pw.println("descripcion|" + String.valueOf(this.jTable10.getValueAt(j, 2)));
/* 7194 */       pw.println("valorUnitario|" + convertirCantTexto(String.valueOf(this.jTable10.getValueAt(j, 3))));
/* 7195 */       pw.println("importe|" + convertirCantTexto(String.valueOf(this.jTable10.getValueAt(j, 4))));
/*      */     } 
/* 7197 */     pw.println("");
/*      */     
/* 7199 */     pw.println("#1 Cuenta Predial");
/* 7200 */     pw.println("cpNumero|");
/* 7201 */     pw.println("");
/*      */     
/* 7203 */     pw.println("#2 Informacion Aduanera");
/* 7204 */     pw.println("iaNumero|");
/* 7205 */     pw.println("iaFecha|");
/* 7206 */     pw.println("iaAduanera|");
/* 7207 */     pw.println("");
/*      */     
/* 7209 */     pw.println("#3 Parte");
/* 7210 */     pw.println("parteCantidad|");
/* 7211 */     pw.println("parteUnidad|");
/* 7212 */     pw.println("parteNumIdentificacion|");
/* 7213 */     pw.println("parteDescripcion|");
/* 7214 */     pw.println("parteValorUnitario|");
/* 7215 */     pw.println("parteImporte|");
/* 7216 */     pw.println("");
/*      */     
/* 7218 */     pw.println("#Bloque de datos opcionales para introducir la informacion aduanera");
/* 7219 */     pw.println("parteIaNumero|");
/* 7220 */     pw.println("parteIaFecha|");
/* 7221 */     pw.println("parteIaAduana|");
/* 7222 */     pw.println("");
/*      */     
/* 7224 */     pw.println("#4 Complemento Concepto");
/* 7225 */     pw.println("[Datos complementarios para especificar la venta de vehiculos]");
/* 7226 */     pw.println("claveVehicular|");
/* 7227 */     pw.println("vehiculoIaNumero|");
/* 7228 */     pw.println("vehiculoIaFecha|");
/* 7229 */     pw.println("vehiculoIaAduana|");
/* 7230 */     pw.println("");
/*      */     
/* 7232 */     pw.println("#PARTES");
/* 7233 */     pw.println("vehiculoParteCantidad|");
/* 7234 */     pw.println("vehiculoParteUnidad|");
/* 7235 */     pw.println("vehiculoParteIdentificacion|");
/* 7236 */     pw.println("vehiculoParteDescripcion|");
/* 7237 */     pw.println("vehiculoParteValorUnitario|");
/* 7238 */     pw.println("vehiculoParteImporte|");
/* 7239 */     pw.println("vehiculoParteNumero|");
/* 7240 */     pw.println("vehiculoParteFecha|");
/* 7241 */     pw.println("vehiculoParteAduana|");
/* 7242 */     pw.println("");
/*      */     
/* 7244 */     pw.println("[Complemento Dutty Free]");
/* 7245 */     pw.println("dutFreeVersion|");
/* 7246 */     pw.println("dutFreeFechaTran|");
/* 7247 */     pw.println("");
/*      */     
/* 7249 */     pw.println("#Datos Transito");
/* 7250 */     pw.println("dutFreeDatVia|");
/* 7251 */     pw.println("dutFreeDatTipoID|");
/* 7252 */     pw.println("dutFreeDatVia|");
/* 7253 */     pw.println("dutFreeDatTipoID|");
/* 7254 */     pw.println("dutFreeDatNumeroId|");
/* 7255 */     pw.println("dutFreeDatNacio|");
/* 7256 */     pw.println("dutFreeDatTransporte|");
/* 7257 */     pw.println("dutFreeDatIdTransporte|");
/* 7258 */     pw.println("");
/*      */     
/* 7260 */     pw.println("[Datos Extra Conceptos]");
/* 7261 */     pw.println("conExReferencia1|");
/* 7262 */     pw.println("conExReferencia2|");
/* 7263 */     pw.println("conExIndicador|");
/* 7264 */     pw.println("conExDescripcionIngles|");
/* 7265 */     pw.println("conExNumRemision|");
/* 7266 */     pw.println("conExCargo|");
/* 7267 */     pw.println("conExDescuento|");
/* 7268 */     pw.println("conExMensaje|");
/* 7269 */     pw.println("conExTasaImpuesto|");
/* 7270 */     pw.println("conExImpuesto|");
/* 7271 */     pw.println("conExValorUnitarioMonedaExtranjera|");
/* 7272 */     pw.println("conExImporteMonedaExtranjera|");
/* 7273 */     pw.println("conExTunitarioBruto|");
/* 7274 */     pw.println("conExCvDivisas|");
/* 7275 */     pw.println("conExItemIdAlterno|");
/* 7276 */     pw.println("");
/*      */     
/* 7278 */     pw.println("[Datos Complementarios del Comprobante a nivel global]");
/* 7279 */     pw.println("subtotalConceptos|" + convertirCantTexto(this.jLabel107.getText()));
/* 7280 */     if (!this.jFormattedTextField10.getText().equals("$0.00")) {
/* 7281 */       pw.println("descuentoPorcentaje|" + this.DESC_PORCENTAJE);
/* 7282 */       pw.println("descuentoMonto|" + convertirCantTexto(this.jFormattedTextField10.getText()));
/* 7283 */       pw.println("descuentoMotivo|" + this.DESC_MOTIVO);
/*      */     } else {
/* 7285 */       pw.println("descuentoPorcentaje|");
/* 7286 */       pw.println("descuentoMonto|");
/* 7287 */       pw.println("descuentoMotivo|");
/*      */     } 
/*      */     
/* 7290 */     pw.println("");
/*      */     
/* 7292 */     pw.println("cargos|");
/* 7293 */     pw.println("totalConceptos|" + convertirCantTexto(this.jLabel107.getText()));
/* 7294 */     pw.println("pagoForma|PAGO EN UNA SOLA EXHIBICION");
/* 7295 */     pw.println("pagoCondiciones|" + String.valueOf(this.jComboBox13.getSelectedItem()));
/* 7296 */     pw.println("pagoMetodo|" + metodos[this.jComboBox17.getSelectedIndex()]);
/* 7297 */     pw.println("numCtaPago|" + String.valueOf(this.jComboBox15.getSelectedItem()));
/* 7298 */     pw.println("lugarExpedicion|" + this.jTextField19.getText());
/* 7299 */     pw.println("");
/*      */     
/* 7301 */     pw.println("[Datos complementarios para especificar el pago en parcialidades");
/* 7302 */     pw.println("folioFiscalOrig|");
/* 7303 */     pw.println("serieFolioFiscalOrig|");
/* 7304 */     pw.println("fechaFolioFiscalOrig|");
/* 7305 */     pw.println("montoFolioFiscalOrig|");
/* 7306 */     pw.println("");
/*      */     
/* 7308 */     pw.println("[Datos complementarios del comprobante a nivel global para casos de importacion de bienes");
/* 7309 */     pw.println("#Datos Globales de Aduana, el bloque es opcional y se constituye por los siguientes tres datos, el bloque se repite para cada aduana que aplique");
/* 7310 */     pw.println("comiaNumero|");
/* 7311 */     pw.println("comiaFecha|");
/* 7312 */     pw.println("comiaAduana|");
/* 7313 */     pw.println("embarque|");
/* 7314 */     pw.println("fob|");
/* 7315 */     pw.println("");
/*      */     
/* 7317 */     pw.println("[Datos Comerciales del Comprobante a nivel global]\tDatos adicionales de tipo comercial com?nmente usados.");
/* 7318 */     pw.println("refID|" + nombre);
/* 7319 */     pw.println("tipoDocumento|Factura");
/* 7320 */     pw.println("ordenCompra|" + this.jTextField20.getText());
/* 7321 */     pw.println("agente|");
/* 7322 */     pw.println("observaciones|EQUIPO:" + String.valueOf(this.jComboBox2.getSelectedItem()) + ", PLAT:" + String.valueOf(this.jComboBox4.getSelectedItem()) + ", POZO:" + String.valueOf(this.jComboBox12.getSelectedItem()));
/* 7323 */     pw.println("nombreMoneda|MXN");
/* 7324 */     pw.println("tipoCambio|1.00");
/* 7325 */     pw.println("");
/*      */     
/* 7327 */     pw.println("[Impuestos Trasladados]");
/* 7328 */     pw.println("trasladadoImpuesto|IVA");
/* 7329 */     pw.println("trasladadoImporte|" + convertirCantTexto(this.jLabel108.getText()));
/* 7330 */     pw.println("trasladadoTasa|16.00");
/* 7331 */     pw.println("subtotalTrasladados|" + convertirCantTexto(this.jLabel108.getText()));
/* 7332 */     pw.println("");
/* 7333 */     if (!this.jFormattedTextField1.getText().equals("$0.00")) {
/* 7334 */       pw.println("[Impuestos Retenidos]");
/* 7335 */       pw.println("retenidoImpuesto|IVA");
/* 7336 */       pw.println("retenidoImporte|" + convertirCantTexto(this.jFormattedTextField1.getText()));
/* 7337 */       pw.println("subtotalRetenidos|" + convertirCantTexto(this.jFormattedTextField1.getText()));
/*      */     } 
/*      */     
/* 7340 */     pw.println("");
/* 7341 */     pw.println("[Datos Totales]");
/* 7342 */     pw.println("montoTotal|" + convertirCantTexto(this.jLabel114.getText()));
/* 7343 */     pw.println("montoTotalTexto|" + this.jTextField25.getText().toUpperCase());
/* 7344 */     pw.println("");
/*      */     
/* 7346 */     pw.println("[Otros]");
/* 7347 */     pw.println("ClaveTransportista|");
/* 7348 */     pw.println("NoRelacionPemex|" + this.jTextField22.getText().toUpperCase());
/* 7349 */     pw.println("NoConvenioPemex|");
/* 7350 */     pw.println("NoCedulaPemex|");
/* 7351 */     pw.println("AireacionYSecado|");
/* 7352 */     pw.println("ApoyoEducampo|");
/* 7353 */     pw.println("Sanidad|");
/*      */     
/* 7355 */     pw.println("");
/* 7356 */     pw.println("[Otros]");
/* 7357 */     pw.println("LeyendaEspecial1|PERMISO SEMARNAT 19-I-036D-10,                      PEMISO SCT CG20045");
/* 7358 */     pw.println("LeyendaEspecial2|" + this.jTextField24.getText() + "          " + this.jTextField26.getText());
/* 7359 */     pw.println("LeyendaEspecial3|" + this.jTextField28.getText());
/* 7360 */     pw.println("LeyendaEspecial4|DEBO(MOS) Y PAGARE(MOS) INCONDICIONALMENTE EN ESTA CIUDAD A LA ORDEN DE FLETES Y MATERIALES FORSIS, S.A. DE C.V. LA CANTIDAD QUE SE INDICA COMO TOTAL EN ESTE DOCUMENTO, VALOR DE LA MERCANCIA ARRIBA DESCRITA Y QUE HEMOS RECIBIDO DE CONFORMIDAD, SI ESTA CANTIDAD NO FUERE CUBIERTA A LA PRESENTACION DE ESTE PAGARE, CAUSARA INTERESES MORATORIOS A RAZON DE  % ANUAL HASTA SU TOTAL SOLUCION");
/* 7361 */     pw.flush();
/* 7362 */     fos.close();
/*      */   }
/*      */   
/*      */   public double convertirCantTexto(String cant) {
/* 7366 */     String canti = cant;
/* 7367 */     String valorP = "";
/*      */     
/* 7369 */     for (int j = 0; j < canti.length(); j++) {
/* 7370 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 7371 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 7374 */     return Double.parseDouble(valorP);
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 7378 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 7382 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public void Facturas(String usu) {
/* 7386 */     this.USUARIO = usu;
/* 7387 */     this.panel.setViewportView(this);
/* 7388 */     limpiar();
/* 7389 */     limpiarTablaConcep();
/* 7390 */     llenarCombos();
/* 7391 */     sacarDepa();
/* 7392 */     consultar();
/* 7393 */     sacarPrivilegios();
/*      */   }
/*      */   
/*      */   public void llenarCombos() {
/* 7397 */     String[] datos = this.con.regresaColIndex("distinct(cliente)", "facturas", " order by Cliente");
/* 7398 */     this.jComboBox18.removeAllItems();
/* 7399 */     this.jComboBox1.removeAllItems();
/* 7400 */     this.jComboBox3.removeAllItems();
/* 7401 */     this.jComboBox1.addItem("<GENERAL>");
/* 7402 */     this.jComboBox3.addItem("<GENERAL>");
/* 7403 */     this.jComboBox18.addItem("<GENERAL>"); int i;
/* 7404 */     for (i = 0; i < datos.length; i++) {
/* 7405 */       this.jComboBox1.addItem(datos[i]);
/* 7406 */       this.jComboBox3.addItem(datos[i]);
/*      */     } 
/* 7408 */     datos = this.con.regresaColIndex("nombreCompleto", "tarjeta_deudor_cliente", " order by nombreCompleto");
/* 7409 */     for (i = 0; i < datos.length; i++) {
/* 7410 */       this.jComboBox1.addItem(datos[i]);
/* 7411 */       this.jComboBox18.addItem(datos[i]);
/*      */     } 
/*      */     
/* 7414 */     datos = this.con.regresaColIndex("equipo", "equipos", "where num_equipo<>0 order by equipo");
/* 7415 */     this.jComboBox5.removeAllItems();
/* 7416 */     this.jComboBox2.removeAllItems();
/* 7417 */     this.jComboBox5.addItem("<GENERAL>");
/* 7418 */     this.jComboBox2.addItem("<GENERAL>");
/* 7419 */     for (i = 0; i < datos.length; i++) {
/* 7420 */       this.jComboBox5.addItem(datos[i]);
/* 7421 */       this.jComboBox2.addItem(datos[i]);
/*      */     } 
/*      */     
/* 7424 */     datos = this.con.regresaColIndex("plataforma", "plataformas", "where num_plata<>0 order by plataforma");
/* 7425 */     this.jComboBox4.removeAllItems();
/* 7426 */     this.jComboBox6.removeAllItems();
/* 7427 */     this.jComboBox4.addItem("<GENERAL>");
/* 7428 */     this.jComboBox6.addItem("<GENERAL>");
/* 7429 */     for (i = 0; i < datos.length; i++) {
/* 7430 */       this.jComboBox6.addItem(datos[i]);
/* 7431 */       this.jComboBox4.addItem(datos[i]);
/*      */     } 
/*      */     
/* 7434 */     datos = this.con.regresaColIndex("nombre", "pozos", "where num_pozo<>0 order by nombre");
/* 7435 */     this.jComboBox12.removeAllItems();
/* 7436 */     this.jComboBox7.removeAllItems();
/* 7437 */     this.jComboBox12.addItem("<GENERAL>");
/* 7438 */     this.jComboBox7.addItem("<GENERAL>");
/* 7439 */     for (i = 0; i < datos.length; i++) {
/* 7440 */       this.jComboBox7.addItem(datos[i]);
/* 7441 */       this.jComboBox12.addItem(datos[i]);
/*      */     } 
/*      */     
/* 7444 */     datos = this.con.regresaColIndex("nombre_usu", "usuarios", "where contrasena<>'' and (priv='facturacion' || priv='super usuario' || priv='administrador') order by nombre_usu");
/* 7445 */     this.jComboBox11.removeAllItems();
/* 7446 */     this.jComboBox11.addItem("<GENERAL>");
/* 7447 */     for (i = 0; i < datos.length; i++) {
/* 7448 */       this.jComboBox11.addItem(datos[i]);
/*      */     }
/*      */     
/* 7451 */     datos = this.con.regresaColIndex("distinct(nuestropedido)", "facturas", "where nuestroPedido<>'' order by nuestroPedido");
/* 7452 */     this.jComboBox21.removeAllItems();
/* 7453 */     this.jComboBox21.addItem("<GENERAL>");
/* 7454 */     for (i = 0; i < datos.length; i++) {
/* 7455 */       this.jComboBox21.addItem(datos[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   public void limpiar() {
/* 7460 */     this.DESC_MOTIVO = "";
/* 7461 */     this.DESC_PORCENTAJE = 0;
/* 7462 */     this.jFormattedTextField10.setValue(Integer.valueOf(0));
/* 7463 */     this.jLabel149.setToolTipText("");
/*      */     
/* 7465 */     this.jButton31.setEnabled(true);
/* 7466 */     this.jTextField18.setEnabled(true);
/* 7467 */     this.jComboBox13.setSelectedIndex(0);
/* 7468 */     this.jButton9.setEnabled(false);
/* 7469 */     this.jDateChooser6.setEnabled(false);
/* 7470 */     this.jTextField19.setEnabled(true);
/* 7471 */     this.jTextField20.setEnabled(true);
/* 7472 */     this.jComboBox13.setEnabled(true);
/* 7473 */     if (this.jComboBox20.getItemCount() > 0) {
/* 7474 */       this.jComboBox20.setSelectedIndex(0);
/*      */     }
/* 7476 */     this.jButton34.setEnabled(true);
/* 7477 */     this.jTextField24.setEnabled(true);
/* 7478 */     this.jTextField26.setEnabled(true);
/* 7479 */     this.jTextField25.setEnabled(true);
/* 7480 */     this.jCheckBox1.setEnabled(true);
/* 7481 */     this.jComboBox10.setEnabled(true);
/* 7482 */     this.jComboBox2.setEnabled(true);
/* 7483 */     this.jComboBox4.setEnabled(true);
/* 7484 */     this.jComboBox12.setEnabled(true);
/* 7485 */     this.jComboBox2.setEnabled(true);
/* 7486 */     this.jComboBox4.setEnabled(true);
/* 7487 */     this.jTextField39.setEnabled(true);
/* 7488 */     this.jTextField40.setEnabled(true);
/* 7489 */     this.jTextField41.setEnabled(true);
/* 7490 */     this.jTextField42.setEnabled(true);
/*      */     
/* 7492 */     this.jTextField10.setEnabled(false);
/* 7493 */     this.jTextField13.setEnabled(false);
/* 7494 */     this.jTextField14.setEnabled(false);
/* 7495 */     this.jTextField15.setEnabled(false);
/* 7496 */     this.jTextField16.setEnabled(false);
/* 7497 */     this.jTextField17.setEnabled(false);
/* 7498 */     this.jButton18.setEnabled(false);
/* 7499 */     this.jComboBox9.setEnabled(false);
/* 7500 */     this.jSpinner1.setEnabled(false);
/*      */     
/* 7502 */     this.jTextField19.setEnabled(false);
/* 7503 */     this.jTextField37.setEnabled(false);
/* 7504 */     this.jTextField38.setEnabled(false);
/* 7505 */     this.jTextField44.setEnabled(false);
/* 7506 */     this.jTextField45.setEnabled(false);
/* 7507 */     this.jTextField43.setEnabled(false);
/* 7508 */     this.jRadioButton1.setEnabled(false);
/* 7509 */     this.jRadioButton2.setEnabled(false);
/*      */     
/* 7511 */     this.jComboBox14.setEnabled(true);
/* 7512 */     this.jComboBox17.setEnabled(true);
/* 7513 */     this.jComboBox19.setEnabled(true);
/* 7514 */     this.jComboBox15.setEnabled(true);
/* 7515 */     this.jComboBox20.setEnabled(true);
/* 7516 */     this.jTextField30.setEnabled(true);
/* 7517 */     this.jFormattedTextField2.setEnabled(true);
/* 7518 */     this.jTextField27.setEnabled(true);
/* 7519 */     this.jButton32.setEnabled(true);
/* 7520 */     this.jComboBox17.setSelectedIndex(0);
/*      */     
/* 7522 */     this.jTextField30.setText("");
/* 7523 */     this.jFormattedTextField2.setValue(Integer.valueOf(0));
/* 7524 */     this.jTextField27.setText("");
/* 7525 */     this.jFormattedTextField3.setValue(Integer.valueOf(0));
/* 7526 */     this.jFormattedTextField4.setValue(Integer.valueOf(0));
/* 7527 */     this.jComboBox1.setSelectedIndex(0);
/* 7528 */     this.jTextField10.setText("");
/* 7529 */     this.jTextField13.setText("");
/* 7530 */     this.jTextField14.setText("");
/* 7531 */     this.jTextField15.setText("");
/* 7532 */     this.jTextField16.setText("");
/* 7533 */     this.jComboBox9.setSelectedIndex(0);
/* 7534 */     this.jComboBox17.setSelectedIndex(0);
/* 7535 */     this.jComboBox19.removeAllItems();
/* 7536 */     this.jComboBox15.removeAllItems();
/* 7537 */     this.jTextField17.setText("");
/* 7538 */     this.jTextField18.setText("");
/* 7539 */     this.jDateChooser6.setDate(new Date());
/* 7540 */     this.jTextField19.setText("");
/* 7541 */     this.jTextField20.setText("");
/* 7542 */     this.jTextField71.setText("");
/*      */     
/* 7544 */     this.jTextField22.setText("");
/*      */     
/* 7546 */     this.jTextField24.setText("");
/*      */     
/* 7548 */     this.jTextField26.setText("");
/* 7549 */     this.jTextField25.setText("");
/* 7550 */     this.jComboBox10.setSelectedIndex(1);
/* 7551 */     this.jTextField28.setText("");
/* 7552 */     this.jCheckBox1.setSelected(true);
/* 7553 */     this.jComboBox10.setEnabled(false);
/* 7554 */     this.jComboBox2.setSelectedIndex(0);
/* 7555 */     this.jComboBox4.setSelectedIndex(0);
/* 7556 */     this.jComboBox12.setSelectedIndex(0);
/* 7557 */     this.jComboBox2.setSelectedIndex(0);
/* 7558 */     this.jComboBox4.setSelectedIndex(0);
/* 7559 */     this.jButton41.setEnabled(true);
/* 7560 */     this.jTextField39.setText("");
/* 7561 */     this.jTextField40.setText("");
/* 7562 */     this.jTextField41.setText("");
/* 7563 */     this.jTextField42.setText("");
/* 7564 */     this.jTextField28.setEnabled(false);
/* 7565 */     this.TOTALPREFACTURA = 0.0D;
/* 7566 */     this.jComboBox16.removeAllItems();
/* 7567 */     this.jSlider1.setValue(0);
/* 7568 */     this.jTextField53.setText("");
/* 7569 */     this.jTextField28.setText("Impuesto Retenido de Conformidad con la Ley del Impuesto al Valor Agregado");
/*      */   }
/*      */   
/*      */   public void consultarPre() {
/* 7573 */     this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 7574 */           .buscarDatos(6, "numFac,ref,subTexto,ivaTexto,retTexto,totalTexto", "prefacturacliente", "where numFac like '%" + this.jTextField6.getText() + "%' and ref like '%" + this.jTextField7.getText() + "%' and estatus='<Por Facturar>' and estado ='ACTIVA' order by numFac desc"), (Object[])new String[] { "Folio", "Ref", "Subtotal", "Iva", "Retención", "Total" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 7579 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7584 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 7587 */     this.jTable1.setSelectionMode(0);
/* 7588 */     this.jTable1.setAutoCreateRowSorter(true);
/* 7589 */     this.jTable1.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 7591 */     this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 7592 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
/*      */     
/* 7594 */     this.jTable1.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 7595 */     this.jTable1.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 7596 */     this.jTable1.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 7597 */     this.jTable1.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/*      */   }
/*      */   
/*      */   public void cargarPre() {
/* 7601 */     this.DESC_PORCENTAJE = 0;
/* 7602 */     this.DESC_MOTIVO = "";
/* 7603 */     String[] datos = null;
/* 7604 */     if (this.REFACTURAR) {
/* 7605 */       datos = this.con.regresaReg("folio,cliente,equipo,pozo,ref", "prefacturacliente", "where folio= '" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1)) + "'", 5);
/*      */     } else {
/* 7607 */       datos = this.con.regresaReg("folio,cliente,equipo,pozo,ref", "prefacturacliente", "where numFac=" + String.valueOf(this.jTable2.getValueAt(0, 0)), 5);
/*      */     } 
/* 7609 */     this.jTextField18.setText(datos[0]);
/* 7610 */     this.jComboBox2.setSelectedItem(datos[2]);
/* 7611 */     this.jComboBox12.setSelectedItem(datos[3]);
/* 7612 */     this.jTextField20.setText(datos[4]);
/*      */     
/* 7614 */     this.jLabel149.setText("<html><u>Descuento 0%</u></html>");
/* 7615 */     if (datos[1].equals("OILSERV") || datos[1].equals("PETROINTEGRAL")) {
/* 7616 */       this.jFormattedTextField10.setEnabled(true);
/* 7617 */       this.jFormattedTextField10.setValue(Integer.valueOf(0));
/* 7618 */       this.jLabel149.setEnabled(true);
/*      */       
/* 7620 */       this.jTextField53.setEnabled(true);
/* 7621 */       this.jSlider1.setEnabled(true);
/* 7622 */       this.jButton43.setEnabled(true);
/*      */     } else {
/* 7624 */       this.jFormattedTextField10.setEnabled(false);
/* 7625 */       this.jFormattedTextField10.setValue(Integer.valueOf(0));
/* 7626 */       this.jLabel149.setEnabled(false);
/* 7627 */       this.jTextField53.setEnabled(false);
/* 7628 */       this.jSlider1.setEnabled(false);
/* 7629 */       this.jButton43.setEnabled(false);
/*      */     } 
/*      */     
/* 7632 */     if (datos[1].equals("ZAPATA")) {
/* 7633 */       this.jTextField39.setText("BANCOMER base 4603");
/* 7634 */       this.jTextField40.setText("CTA. 0144652592  CLAVE 012 888 00144652592 1");
/* 7635 */       this.jTextField41.setText("POZA RICA, VERACRUZ");
/*      */     } else {
/* 7637 */       this.jTextField39.setText("");
/* 7638 */       this.jTextField40.setText("");
/* 7639 */       this.jTextField41.setText("");
/*      */     } 
/*      */     
/* 7642 */     this.encontrado = this.con.consultar("tarjeta_deudor_cliente.tarjeta", "tarjeta_deudor_cliente,emp_generadora,estados", "where tarjeta_deudor_cliente.clave_gene = emp_generadora.clave_gene and emp_generadora.id_edo = estados.id_edo and tarjeta_deudor_cliente.nombre_corto = '" + datos[1] + "'");
/* 7643 */     if (!this.encontrado) {
/* 7644 */       JOptionPane.showMessageDialog(this.jDialog5, "La tarjeta deudor del cliente no ha sido creada\nNecesitas crear la tarjeta deudor del cliente", "Sin tarjeta deudor", 0, this.ERROR);
/*      */     } else {
/* 7646 */       for (int i = 0; i < this.jTable2.getRowCount(); i++) {
/* 7647 */         String canti = String.valueOf(this.jTable2.getValueAt(i, 5));
/* 7648 */         String valorP = "";
/* 7649 */         for (int i1 = 0; i1 < canti.length(); i1++) {
/* 7650 */           if (canti.charAt(i1) != '$' && canti.charAt(i1) != ',') {
/* 7651 */             valorP = valorP + valorP;
/*      */           }
/*      */         } 
/* 7654 */         this.TOTALPREFACTURA += Double.parseDouble(valorP);
/*      */       } 
/*      */       
/* 7657 */       double RET = 0.0D;
/* 7658 */       for (int j = 0; j < this.jTable2.getRowCount(); j++) {
/* 7659 */         String canti = String.valueOf(this.jTable2.getValueAt(j, 4));
/* 7660 */         String valorP = "";
/* 7661 */         for (int i1 = 0; i1 < canti.length(); i1++) {
/* 7662 */           if (canti.charAt(i1) != '$' && canti.charAt(i1) != ',' && canti.charAt(i1) != '-') {
/* 7663 */             valorP = valorP + valorP;
/*      */           }
/*      */         } 
/* 7666 */         RET += Double.parseDouble(valorP);
/*      */       } 
/* 7668 */       this.jFormattedTextField1.setValue(Double.valueOf(RET));
/*      */       
/* 7670 */       this.TARJETA = this.con.Campo;
/* 7671 */       datos = this.con.regresaReg("calle,num,col,cp,ciudad,rfc,estado,empresa,tarjeta", "tarjeta_deudor_cliente,emp_generadora,estados", "where tarjeta_deudor_cliente.clave_gene = emp_generadora.clave_gene and emp_generadora.id_edo = estados.id_edo and tarjeta_deudor_cliente.nombre_corto = '" + datos[1] + "'", 9);
/* 7672 */       this.jComboBox1.setSelectedItem(datos[7]);
/* 7673 */       this.jTextField10.setText(datos[0]);
/* 7674 */       this.jTextField13.setText(datos[1]);
/* 7675 */       this.jTextField14.setText(datos[2]);
/* 7676 */       this.jTextField15.setText(datos[3]);
/* 7677 */       this.jTextField16.setText(datos[4]);
/* 7678 */       this.jComboBox9.setSelectedItem(datos[6]);
/* 7679 */       this.jTextField17.setText(datos[5]);
/* 7680 */       this.CLAVETARJETA = datos[8];
/*      */       
/* 7682 */       sacarFolioMayor();
/* 7683 */       this.jTextField19.setText(this.ALIAS);
/* 7684 */       this.jTextField22.setText(this.ALIAS);
/*      */       
/* 7686 */       String[] bancos = this.con.regresaColIndex("banco", "bancos", "where cliente=" + this.TARJETA);
/* 7687 */       for (int k = 0; k < bancos.length; k++) {
/* 7688 */         this.jComboBox19.addItem(bancos[k]);
/*      */       }
/*      */       
/* 7691 */       String[] cuentas = this.con.regresaColIndex("cuenta", "cuentas", "where cliente=" + this.TARJETA);
/* 7692 */       for (int m = 0; m < cuentas.length; m++) {
/* 7693 */         this.jComboBox15.addItem(cuentas[m]);
/*      */       }
/*      */       
/* 7696 */       String[] pedidos = this.con.regresaColIndex("distinct(nuestroPedido)", "facturas", "where nuestroPedido<>'' order by NuestroPedido");
/* 7697 */       this.jComboBox20.addItem("");
/* 7698 */       for (int n = 0; n < pedidos.length; n++) {
/* 7699 */         this.jComboBox20.addItem(pedidos[n]);
/*      */       }
/* 7701 */       this.jDialog5.setVisible(false);
/* 7702 */       this.jDialog11.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void sacarFolioMayor() {
/* 7707 */     this.con.consultar("folio", "facturas", "order by numFactura desc");
/* 7708 */     String folio = this.con.Campo;
/* 7709 */     String conse = "";
/* 7710 */     String letra = "";
/* 7711 */     for (int i = 0; i < folio.length(); i++) {
/*      */       try {
/* 7713 */         int valor = Integer.parseInt("" + folio.charAt(i));
/* 7714 */         conse = conse + conse;
/* 7715 */       } catch (NumberFormatException e) {
/* 7716 */         letra = letra + letra;
/*      */       } 
/*      */     } 
/* 7719 */     int nF = Integer.parseInt(conse);
/* 7720 */     nF++;
/* 7721 */     this.jTextField18.setText(letra + letra);
/*      */   }
/*      */   
/*      */   public void sacarTotales2() {
/* 7725 */     double DESCUENTO = 0.0D;
/*      */     
/*      */     try {
/* 7728 */       DESCUENTO = Double.parseDouble(this.jFormattedTextField10.getText());
/* 7729 */     } catch (NumberFormatException n) {
/* 7730 */       DESCUENTO = Double.parseDouble(String.valueOf(this.jFormattedTextField10.getValue()));
/*      */     } 
/*      */     
/* 7733 */     this.cantidad.setValue(Double.valueOf(this.SUBTOTALD));
/* 7734 */     this.jLabel107.setText(this.cantidad.getText());
/*      */     
/* 7736 */     this.IVAD = this.SUBTOTALD * 0.01D * this.IVA;
/* 7737 */     this.cantidad.setValue(Double.valueOf(this.IVAD));
/* 7738 */     this.jLabel108.setText(this.cantidad.getText());
/* 7739 */     this.RETENCIOND = Double.parseDouble(String.valueOf(this.jFormattedTextField1.getValue()));
/* 7740 */     this.TOTALD = this.SUBTOTALD + this.IVAD - this.RETENCIOND;
/* 7741 */     this.TOTALD -= DESCUENTO;
/* 7742 */     this.cantidad.setValue(Double.valueOf(this.TOTALD));
/*      */     
/* 7744 */     this.jLabel114.setText(this.cantidad.getText());
/*      */     
/* 7746 */     String canti = this.jLabel114.getText();
/* 7747 */     String valorP = "";
/* 7748 */     for (int j = 0; j < canti.length(); j++) {
/* 7749 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',' && canti.charAt(j) != '(' && canti.charAt(j) != ')') {
/* 7750 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 7753 */     double vp = Double.parseDouble(valorP);
/* 7754 */     this.numLetra = new NumerosALetras(vp, "MXN");
/* 7755 */     this.jTextField25.setText(this.numLetra.regresaNumero());
/*      */   }
/*      */   
/*      */   public class CeldaRender
/*      */     extends DefaultTableCellRenderer {
/* 7760 */     String[] indices = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 7763 */       setEnabled((table == null || table.isEnabled()));
/* 7764 */       setHorizontalAlignment(4);
/* 7765 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 7766 */       return this;
/*      */     }
/*      */   }
/*      */   
/*      */   public void limpiarTablaConcep() {
/* 7771 */     this.jTextField28.setEnabled(false);
/* 7772 */     this.jTable10 = new JTable();
/* 7773 */     this.jTable10.setFont(new Font("Tahoma", 0, 10));
/* 7774 */     this.jTable10.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Cant", "Unidad", "Descripción", "P Unitario", "Importe" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 7780 */           boolean[] canEdit = new boolean[] { false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7785 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 7788 */     this.jScrollPane12.setViewportView(this.jTable10);
/* 7789 */     this.jTable10.getColumnModel().getColumn(0).setMinWidth(50);
/* 7790 */     this.jTable10.getColumnModel().getColumn(0).setMaxWidth(50);
/* 7791 */     this.jTable10.getColumnModel().getColumn(1).setMinWidth(100);
/* 7792 */     this.jTable10.getColumnModel().getColumn(1).setMaxWidth(100);
/* 7793 */     this.jTable10.getColumnModel().getColumn(3).setMinWidth(80);
/* 7794 */     this.jTable10.getColumnModel().getColumn(3).setMaxWidth(80);
/* 7795 */     this.jTable10.getColumnModel().getColumn(4).setMinWidth(80);
/* 7796 */     this.jTable10.getColumnModel().getColumn(4).setMaxWidth(80);
/* 7797 */     this.jTable10.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 7798 */     this.jTable10.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 7799 */     this.jFormattedTextField1.setValue(Integer.valueOf(0));
/* 7800 */     this.SUBTOTALD = 0.0D;
/* 7801 */     this.IVAD = 0.0D;
/* 7802 */     this.RETENCIOND = 0.0D;
/* 7803 */     this.TOTALD = 0.0D;
/* 7804 */     sacarTotales2();
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 7808 */     this.PRIMERA = true;
/* 7809 */     Date fecha1 = this.jDateChooser4.getDate();
/* 7810 */     Date fecha2 = this.jDateChooser5.getDate();
/*      */     
/* 7812 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 7813 */     String cadenaFecha = "";
/* 7814 */     cadenaFecha = formato.format(fecha1);
/* 7815 */     String AÑO = cadenaFecha.substring(0, 4);
/* 7816 */     String MES = cadenaFecha.substring(4, 6);
/* 7817 */     String DIA = cadenaFecha.substring(6, 8);
/* 7818 */     String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */     
/* 7820 */     cadenaFecha = formato.format(fecha2);
/* 7821 */     int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 7822 */     int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 7823 */     int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/* 7824 */     int diasTotal = diasDelMes(mm - 1, aa);
/* 7825 */     String fechaCompleta2 = "'" + aa + "-" + mm + "-" + dd + "'";
/*      */     
/* 7827 */     String estatus = " estatus='<Por Pagar>' || estatus like '%<Pagada%' || estatus like '%<Abono%'";
/* 7828 */     String cliente = "";
/* 7829 */     String equipo = "";
/* 7830 */     String plataforma = "";
/* 7831 */     String pozo = "";
/* 7832 */     String usuario = "";
/*      */     
/* 7834 */     String nuestroPedido = "";
/* 7835 */     if (this.jComboBox21.getSelectedIndex() != 0) {
/* 7836 */       nuestroPedido = String.valueOf(this.jComboBox21.getSelectedItem());
/*      */     }
/*      */     
/* 7839 */     if (this.jComboBox8.getSelectedIndex() == 1) {
/* 7840 */       estatus = " estatus like '%%'";
/* 7841 */     } else if (this.jComboBox8.getSelectedIndex() == 2) {
/* 7842 */       estatus = " estatus ='<Por Pagar>'";
/* 7843 */     } else if (this.jComboBox8.getSelectedIndex() == 3) {
/* 7844 */       estatus = " estatus like '%<Pagada%'";
/* 7845 */     } else if (this.jComboBox8.getSelectedIndex() == 4) {
/* 7846 */       estatus = " estatus like '%<Abono%'";
/* 7847 */     } else if (this.jComboBox8.getSelectedIndex() == 5) {
/* 7848 */       estatus = " estatus like '%<Cancelada%'";
/*      */     } 
/*      */     
/* 7851 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 7852 */       cliente = String.valueOf(this.jComboBox3.getSelectedItem());
/*      */     }
/* 7854 */     if (this.jComboBox5.getSelectedIndex() != 0) {
/* 7855 */       equipo = String.valueOf(this.jComboBox5.getSelectedItem());
/*      */     }
/* 7857 */     if (this.jComboBox6.getSelectedIndex() != 0) {
/* 7858 */       plataforma = String.valueOf(this.jComboBox6.getSelectedItem());
/*      */     }
/* 7860 */     if (this.jComboBox7.getSelectedIndex() != 0) {
/* 7861 */       pozo = String.valueOf(this.jComboBox7.getSelectedItem());
/*      */     }
/* 7863 */     if (this.jComboBox11.getSelectedIndex() != 0) {
/* 7864 */       usuario = String.valueOf(this.jComboBox11.getSelectedItem());
/*      */     }
/*      */     
/* 7867 */     String consulSus = "";
/* 7868 */     if (this.jComboBox22.getSelectedIndex() == 0) {
/* 7869 */       consulSus = "(facturaSustituida like '%%' and facturaSustituye like '%%')";
/* 7870 */     } else if (this.jComboBox22.getSelectedIndex() == 1) {
/* 7871 */       consulSus = "(facturaSustituida<>'')";
/* 7872 */     } else if (this.jComboBox22.getSelectedIndex() == 2) {
/* 7873 */       consulSus = "(facturaSustituye<>'')";
/*      */     } 
/*      */     
/* 7876 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 7877 */           .buscarDatos(14, "numFactura,folio,fecha,cliente,COMPLETA,supedido,facturaSustituida,facturaSustituye,subtotal,iva,retencion,total,estatus,usuario", "facturas", "where folio like '%" + this.jTextField1.getText() + "%' and (" + estatus + ") and cliente like '%" + cliente + "%' and equipo like '%" + equipo + "%' and plataforma like '%" + plataforma + "%' and pozo like'%" + pozo + "%' and usuario like '%" + usuario + "%' and supedido like'%" + this.jTextField2.getText() + "%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " and nuestroPedido like '%" + nuestroPedido + "%' and " + consulSus + " order by numFactura desc"), (Object[])new String[] { "Núm", "Folio", "Fecha", "Cliente", "Recepción", "Su pedido", "Sustituida por", "Sustituye a", "Subtotal", "Iva", "Retención", "Total", "Estatus", "Documentó" })
/*      */         {
/*      */ 
/*      */           
/* 7881 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 7886 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 7889 */     this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable3.getRowCount() + "</HTML>");
/* 7890 */     this.jLabel42.setText("$0.00");
/* 7891 */     this.jLabel39.setText("$0.00");
/* 7892 */     this.jLabel38.setText("$0.00");
/* 7893 */     this.jLabel37.setText("$0.00");
/* 7894 */     double valorS = 0.0D;
/* 7895 */     double valorI = 0.0D;
/* 7896 */     double valorR = 0.0D;
/* 7897 */     double valorT = 0.0D;
/* 7898 */     for (int i = 0; i < this.jTable3.getRowCount(); i++) {
/* 7899 */       String canti = String.valueOf(this.jTable3.getValueAt(i, 8));
/* 7900 */       String valorP = ""; int j;
/* 7901 */       for (j = 0; j < canti.length(); j++) {
/* 7902 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 7903 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 7906 */       valorS += Double.parseDouble(valorP);
/* 7907 */       this.cantidad.setValue(Double.valueOf(valorS));
/* 7908 */       this.jLabel42.setText(this.cantidad.getText());
/*      */       
/* 7910 */       canti = String.valueOf(this.jTable3.getValueAt(i, 9));
/* 7911 */       valorP = "";
/* 7912 */       for (j = 0; j < canti.length(); j++) {
/* 7913 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 7914 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 7917 */       valorI += Double.parseDouble(valorP);
/* 7918 */       this.cantidad.setValue(Double.valueOf(valorI));
/* 7919 */       this.jLabel39.setText(this.cantidad.getText());
/*      */       
/* 7921 */       canti = String.valueOf(this.jTable3.getValueAt(i, 10));
/* 7922 */       valorP = "";
/* 7923 */       for (j = 0; j < canti.length(); j++) {
/* 7924 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 7925 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 7928 */       valorR += Double.parseDouble(valorP);
/* 7929 */       this.cantidad.setValue(Double.valueOf(valorR));
/* 7930 */       this.jLabel38.setText(this.cantidad.getText());
/*      */       
/* 7932 */       canti = String.valueOf(this.jTable3.getValueAt(i, 11));
/* 7933 */       valorP = "";
/* 7934 */       for (j = 0; j < canti.length(); j++) {
/* 7935 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 7936 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 7939 */       valorT += Double.parseDouble(valorP);
/* 7940 */       this.cantidad.setValue(Double.valueOf(valorT));
/* 7941 */       this.jLabel37.setText(this.cantidad.getText());
/*      */     } 
/*      */     
/* 7944 */     this.jLabel42.setToolTipText(this.jLabel42.getText());
/* 7945 */     this.jLabel39.setToolTipText(this.jLabel39.getText());
/* 7946 */     this.jLabel38.setToolTipText(this.jLabel38.getText());
/* 7947 */     this.jLabel37.setToolTipText(this.jLabel37.getText());
/*      */     
/* 7949 */     this.celda2.pasarInd3(this.con.revisarCol(this.jTable3, "<Por Pagar>", 1, 12, 0));
/* 7950 */     this.celda2.pasarInd4(this.con.revisarCol(this.jTable3, "<Abono", 1, 12, 2));
/* 7951 */     this.celda2.pasarInd5(this.con.revisarCol(this.jTable3, "<Cancelada", 1, 12, 2));
/* 7952 */     this.celda2.pasarInd6(this.con.revisarCol(this.jTable3, "PR", 1, 6, 2));
/* 7953 */     this.celda2.pasarInd7(this.con.revisarCol(this.jTable3, "PR", 1, 7, 2));
/*      */     
/* 7955 */     this.jTable3.setSelectionMode(0);
/* 7956 */     this.jTable3.setAutoCreateRowSorter(true);
/* 7957 */     this.jTable3.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 7959 */     this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 7960 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(50);
/* 7961 */     this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(60);
/* 7962 */     this.jTable3.getColumnModel().getColumn(1).setMaxWidth(60);
/* 7963 */     this.jTable3.getColumnModel().getColumn(2).setPreferredWidth(65);
/* 7964 */     this.jTable3.getColumnModel().getColumn(2).setMaxWidth(65);
/* 7965 */     this.jTable3.getColumnModel().getColumn(4).setPreferredWidth(80);
/* 7966 */     this.jTable3.getColumnModel().getColumn(4).setMaxWidth(80);
/* 7967 */     this.jTable3.getColumnModel().getColumn(6).setPreferredWidth(100);
/* 7968 */     this.jTable3.getColumnModel().getColumn(6).setMaxWidth(100);
/* 7969 */     this.jTable3.getColumnModel().getColumn(7).setPreferredWidth(100);
/* 7970 */     this.jTable3.getColumnModel().getColumn(7).setMaxWidth(100);
/* 7971 */     this.jTable3.getColumnModel().getColumn(8).setPreferredWidth(80);
/* 7972 */     this.jTable3.getColumnModel().getColumn(8).setMaxWidth(80);
/* 7973 */     this.jTable3.getColumnModel().getColumn(9).setPreferredWidth(80);
/* 7974 */     this.jTable3.getColumnModel().getColumn(9).setMaxWidth(80);
/* 7975 */     this.jTable3.getColumnModel().getColumn(10).setPreferredWidth(80);
/* 7976 */     this.jTable3.getColumnModel().getColumn(10).setMaxWidth(80);
/* 7977 */     this.jTable3.getColumnModel().getColumn(11).setPreferredWidth(80);
/* 7978 */     this.jTable3.getColumnModel().getColumn(11).setMaxWidth(80);
/*      */     
/* 7980 */     this.jTable3.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 7981 */     this.jTable3.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 7982 */     this.jTable3.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 7983 */     this.jTable3.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 7984 */     this.jTable3.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 7985 */     this.jTable3.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 7986 */     this.jTable3.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/* 7987 */     this.jTable3.getColumnModel().getColumn(7).setCellRenderer(this.celda2);
/* 7988 */     this.jTable3.getColumnModel().getColumn(8).setCellRenderer(this.celda2);
/* 7989 */     this.jTable3.getColumnModel().getColumn(9).setCellRenderer(this.celda2);
/* 7990 */     this.jTable3.getColumnModel().getColumn(10).setCellRenderer(this.celda2);
/* 7991 */     this.jTable3.getColumnModel().getColumn(11).setCellRenderer(this.celda2);
/* 7992 */     this.jTable3.getColumnModel().getColumn(12).setCellRenderer(this.celda2);
/* 7993 */     this.jTable3.getColumnModel().getColumn(13).setCellRenderer(this.celda2);
/*      */   }
/*      */   
/*      */   public int diasDelMes(int mes, int año) {
/* 7997 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 8005 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 8011 */         return 30;
/*      */       
/*      */       case 1:
/* 8014 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 8016 */           return 29;
/*      */         }
/* 8018 */         return 28;
/*      */     } 
/*      */     
/* 8021 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public void sacarDepa() {
/* 8026 */     this.con.consultar("priv", "usuarios", "where nombre_usu = '" + this.USUARIO + "'");
/* 8027 */     this.DEPARTAMENTO = this.con.Campo;
/*      */   }
/*      */   
/*      */   public String cargarFechaHoy() {
/* 8031 */     Calendar ahoraCal = Calendar.getInstance();
/* 8032 */     ahoraCal.setTime(this.fecha);
/* 8033 */     String mesesito = "";
/* 8034 */     String hoy = "";
/* 8035 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 8036 */     hoy = "" + ahoraCal.get(5);
/*      */     
/* 8038 */     if (ahoraCal.get(2) + 1 < 10) {
/* 8039 */       mesesito = "0" + mesesito;
/*      */     }
/* 8041 */     if (ahoraCal.get(5) < 10) {
/* 8042 */       hoy = "0" + hoy;
/*      */     }
/* 8044 */     return hoy + "/" + hoy + "/" + mesesito;
/*      */   }
/*      */   
/*      */   public Double redondear(double pasar) {
/* 8048 */     return Double.valueOf(Math.rint(pasar * 100.0D) / 100.0D);
/*      */   }
/*      */   
/*      */   public void sacarPrivilegios() {
/* 8052 */     if (this.DEPARTAMENTO.equals("SUPER USUARIO") || this.DEPARTAMENTO.equals("ADMINISTRADOR")) {
/* 8053 */       this.jButton25.setEnabled(true);
/*      */     } else {
/* 8055 */       this.jButton25.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void verFactura() {
/* 8060 */     this.jFormattedTextField10.setEnabled(false);
/* 8061 */     this.jFormattedTextField10.setValue(Integer.valueOf(0));
/* 8062 */     this.jLabel149.setEnabled(false);
/* 8063 */     this.jTextField53.setEnabled(false);
/* 8064 */     this.jSlider1.setEnabled(false);
/* 8065 */     this.jButton43.setEnabled(false);
/*      */     
/* 8067 */     if (this.DEPARTAMENTO.equals("SUPER USUARIO")) {
/* 8068 */       this.jButton9.setEnabled(true);
/*      */     } else {
/* 8070 */       this.jButton9.setEnabled(false);
/*      */     } 
/* 8072 */     this.jButton32.setEnabled(false);
/*      */     
/* 8074 */     this.jButton31.setEnabled(false);
/* 8075 */     this.jButton41.setEnabled(false);
/* 8076 */     this.jComboBox1.setEnabled(false);
/*      */     
/* 8078 */     this.jTextField10.setEnabled(false);
/* 8079 */     this.jTextField13.setEnabled(false);
/* 8080 */     this.jTextField14.setEnabled(false);
/* 8081 */     this.jTextField15.setEnabled(false);
/* 8082 */     this.jTextField16.setEnabled(false);
/* 8083 */     this.jComboBox9.setEnabled(false);
/* 8084 */     this.jTextField17.setEnabled(false);
/* 8085 */     this.jTextField18.setEnabled(false);
/* 8086 */     this.jDateChooser6.setEnabled(false);
/* 8087 */     this.jTextField19.setEnabled(false);
/* 8088 */     this.jTextField20.setEnabled(false);
/*      */     
/* 8090 */     this.jTextField22.setEnabled(false);
/*      */     
/* 8092 */     this.jTextField24.setEnabled(false);
/*      */ 
/*      */     
/* 8095 */     this.jTextField26.setEnabled(false);
/* 8096 */     this.jTextField25.setEnabled(false);
/* 8097 */     this.jComboBox10.setEnabled(false);
/* 8098 */     this.jTextField28.setEnabled(false);
/* 8099 */     this.jCheckBox1.setEnabled(false);
/* 8100 */     this.jComboBox10.setEnabled(false);
/* 8101 */     this.jComboBox2.setEnabled(false);
/* 8102 */     this.jComboBox4.setEnabled(false);
/* 8103 */     this.jComboBox12.setEnabled(false);
/* 8104 */     this.jComboBox2.setEnabled(false);
/* 8105 */     this.jComboBox4.setEnabled(false);
/* 8106 */     this.jTextField39.setEnabled(false);
/* 8107 */     this.jTextField40.setEnabled(false);
/* 8108 */     this.jTextField41.setEnabled(false);
/* 8109 */     this.jTextField42.setEnabled(false);
/* 8110 */     this.jComboBox13.setEnabled(false);
/* 8111 */     this.jButton34.setEnabled(false);
/* 8112 */     this.jFormattedTextField1.setEnabled(false);
/* 8113 */     this.jFormattedTextField10.setEnabled(false);
/*      */     
/* 8115 */     this.jComboBox14.setEnabled(false);
/* 8116 */     this.jRadioButton1.setEnabled(false);
/* 8117 */     this.jRadioButton2.setEnabled(false);
/* 8118 */     this.jSpinner1.setEnabled(false);
/* 8119 */     this.jComboBox17.setEnabled(false);
/*      */     
/* 8121 */     this.jComboBox19.setEnabled(false);
/* 8122 */     this.jComboBox19.removeAllItems();
/* 8123 */     this.jComboBox15.setEnabled(false);
/* 8124 */     this.jComboBox15.removeAllItems();
/* 8125 */     this.jButton18.setEnabled(false);
/* 8126 */     this.jTextField37.setEnabled(false);
/* 8127 */     this.jTextField38.setEnabled(false);
/* 8128 */     this.jTextField44.setEnabled(false);
/* 8129 */     this.jTextField45.setEnabled(false);
/* 8130 */     this.jTextField43.setEnabled(false);
/* 8131 */     this.jTextField30.setEnabled(false);
/* 8132 */     this.jFormattedTextField2.setEnabled(false);
/* 8133 */     this.jComboBox16.removeAllItems();
/* 8134 */     this.jComboBox20.setEnabled(false);
/* 8135 */     this.jTextField27.setEnabled(false);
/*      */     
/* 8137 */     String[] datos = this.con.regresaReg("folio,cliente,calle,num,colonia,cp,ciudad,estado,rfc,fecha,lugar,supedido,nuestropedido,zona,condiciones,equipo,plataforma,pozo,tipodiseno,encabezado,pie,linea1,linea2,linea3,linea4,tieneLeyenda,tipoLeyenda,contenidoLeyenda,subtotal,iva,retencion,total,pagoForma,pagoMetodo,numCuenta,banco,esOriginal,descMonto,descPorcen,descMotivo", "facturas", "where numFactura=" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0)), 40);
/* 8138 */     this.jComboBox1.setSelectedItem(datos[1]);
/* 8139 */     this.jTextField10.setText(datos[2]);
/* 8140 */     this.jTextField13.setText(datos[3]);
/* 8141 */     this.jTextField14.setText(datos[4]);
/* 8142 */     this.jTextField15.setText(datos[5]);
/* 8143 */     this.jTextField16.setText(datos[6]);
/* 8144 */     this.jComboBox9.setSelectedItem(datos[7]);
/* 8145 */     this.jTextField17.setText(datos[8]);
/*      */     
/* 8147 */     String fecha = datos[9];
/* 8148 */     String fechaCorta = fecha.substring(0, 10);
/* 8149 */     String año = fechaCorta.substring(0, 4);
/* 8150 */     String mes = fechaCorta.substring(5, 7);
/* 8151 */     String dia = fechaCorta.substring(8, 10);
/* 8152 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 8153 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     
/*      */     try {
/* 8156 */       Date fechaT = formatoDelTexto.parse(strFecha);
/* 8157 */       this.jDateChooser6.setDate(fechaT);
/* 8158 */     } catch (ParseException ex) {
/* 8159 */       ex.printStackTrace();
/*      */     } 
/*      */     
/* 8162 */     this.jTextField18.setText(datos[0]);
/* 8163 */     this.jTextField19.setText(datos[10]);
/* 8164 */     this.jTextField20.setText(datos[11]);
/*      */     
/* 8166 */     this.jTextField22.setText(datos[13]);
/* 8167 */     this.jComboBox13.setSelectedItem(datos[14]);
/*      */ 
/*      */     
/* 8170 */     this.jComboBox2.setSelectedItem(datos[15]);
/* 8171 */     this.jComboBox4.setSelectedItem(datos[16]);
/* 8172 */     this.jComboBox12.setSelectedItem(datos[17]);
/*      */     
/* 8174 */     this.jComboBox14.setSelectedItem(datos[32]);
/* 8175 */     if (datos[36].equals("0")) {
/* 8176 */       this.jRadioButton1.setSelected(true);
/*      */     } else {
/* 8178 */       this.jRadioButton1.setSelected(false);
/*      */     } 
/*      */     
/* 8181 */     this.jComboBox15.removeAllItems();
/* 8182 */     this.jComboBox19.removeAllItems();
/*      */     
/* 8184 */     String[] metodos = { "01", "02", "03", "04", "05", "06", "08", "28", "29", "NA", "99" };
/* 8185 */     String metodoPago = datos[33];
/* 8186 */     if (metodoPago.contains("TRANSFERENCIA")) {
/* 8187 */       this.jComboBox17.setSelectedIndex(2);
/* 8188 */     } else if (metodoPago.equals("NO IDENTIFICADO")) {
/* 8189 */       this.jComboBox17.setSelectedIndex(10);
/* 8190 */     } else if (metodoPago.contains("CHEQUE")) {
/* 8191 */       this.jComboBox17.setSelectedIndex(1);
/* 8192 */     } else if (metodoPago.contains("EFECTIVO")) {
/* 8193 */       this.jComboBox17.setSelectedIndex(0);
/*      */     } else {
/* 8195 */       int index = 0;
/* 8196 */       for (int j = 0; j < metodos.length; j++) {
/* 8197 */         if (metodos[j].equals(datos[33])) {
/* 8198 */           index = j;
/*      */           break;
/*      */         } 
/*      */       } 
/* 8202 */       this.jComboBox17.setSelectedIndex(index);
/*      */     } 
/*      */     
/* 8205 */     this.jComboBox15.setSelectedItem(datos[34]);
/* 8206 */     this.jComboBox19.setSelectedItem(datos[35]);
/*      */     
/* 8208 */     this.jFormattedTextField10.setValue(Integer.valueOf(Integer.parseInt(datos[37])));
/* 8209 */     this.DESC_PORCENTAJE = Integer.parseInt(datos[38]);
/* 8210 */     this.DESC_MOTIVO = datos[39];
/* 8211 */     this.jLabel149.setText("<html><u> Descuento " + this.DESC_PORCENTAJE + "%</u></html>");
/* 8212 */     this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/* 8213 */           .buscarDatos(6, "numFac,ref,subTexto,ivaTexto,retTexto,totalTexto", "Prefacturacliente", "where folio = '" + datos[0] + "' order by numFac asc"), (Object[])new String[] { "Folio", "Ref", "Subtotal", "Iva", "Retención", "Total" })
/*      */         {
/*      */ 
/*      */           
/* 8217 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 8222 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 8225 */     this.jTable4.setSelectionMode(0);
/* 8226 */     this.jTable4.setAutoCreateRowSorter(true);
/* 8227 */     this.jTable4.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 8229 */     sacarSumas();
/* 8230 */     String tipodiseno = datos[18];
/* 8231 */     if (tipodiseno.equals("1")) {
/* 8232 */       this.jTable10.setModel(new DefaultTableModel((Object[][])this.con
/* 8233 */             .buscarDatos(5, "cant,unidad,descripcion,punit,importe", "disenoTabla", "where folio = '" + datos[0] + "' order by numDiseno"), (Object[])new String[] { "Cant", "Unidad", "Descripción", "P Unit", "Importe" })
/*      */           {
/*      */ 
/*      */             
/* 8237 */             boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 8242 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 8245 */       this.jTable10.setSelectionMode(0);
/* 8246 */       this.jTable10.setAutoCreateRowSorter(true);
/* 8247 */       this.jTable10.getTableHeader().setReorderingAllowed(false);
/*      */       
/* 8249 */       this.jTable10.getColumnModel().getColumn(0).setMinWidth(50);
/* 8250 */       this.jTable10.getColumnModel().getColumn(0).setMaxWidth(50);
/* 8251 */       this.jTable10.getColumnModel().getColumn(1).setMinWidth(100);
/* 8252 */       this.jTable10.getColumnModel().getColumn(1).setMaxWidth(100);
/* 8253 */       this.jTable10.getColumnModel().getColumn(3).setMinWidth(80);
/* 8254 */       this.jTable10.getColumnModel().getColumn(3).setMaxWidth(80);
/* 8255 */       this.jTable10.getColumnModel().getColumn(4).setMinWidth(80);
/* 8256 */       this.jTable10.getColumnModel().getColumn(4).setMaxWidth(80);
/* 8257 */       this.jTable10.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 8258 */       this.jTable10.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/*      */     } else {
/* 8260 */       this.jTable10.setModel(new DefaultTableModel((Object[][])this.con
/* 8261 */             .buscarDatos(10, "guia,fserv,rspr,origen,destino,peso,manifiesto,descripcion,punit,importe", "disenoTabla", "where folio = '" + datos[0] + "' order by numDiseno"), (Object[])new String[] { "Guía", "Fecha", "RSP-R", "Origen", "Destino", "Peso", "Manifiesto", "Comentario", "P Unit", "Importe" })
/*      */           {
/*      */ 
/*      */             
/* 8265 */             boolean[] canEdit = new boolean[] { 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false };
/*      */             
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 8270 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/*      */       
/* 8274 */       this.jTable10.getColumnModel().getColumn(0).setMinWidth(75);
/* 8275 */       this.jTable10.getColumnModel().getColumn(0).setMaxWidth(75);
/* 8276 */       this.jTable10.getColumnModel().getColumn(2).setMinWidth(70);
/* 8277 */       this.jTable10.getColumnModel().getColumn(2).setMaxWidth(70);
/* 8278 */       this.jTable10.getColumnModel().getColumn(5).setMinWidth(45);
/* 8279 */       this.jTable10.getColumnModel().getColumn(5).setMaxWidth(45);
/* 8280 */       this.jTable10.getColumnModel().getColumn(6).setMinWidth(70);
/* 8281 */       this.jTable10.getColumnModel().getColumn(6).setMaxWidth(70);
/* 8282 */       this.jTable10.getColumnModel().getColumn(8).setMinWidth(75);
/* 8283 */       this.jTable10.getColumnModel().getColumn(8).setMaxWidth(75);
/* 8284 */       this.jTable10.getColumnModel().getColumn(9).setMinWidth(75);
/* 8285 */       this.jTable10.getColumnModel().getColumn(9).setMaxWidth(75);
/*      */       
/* 8287 */       this.jTable10.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/* 8288 */       this.jTable10.getColumnModel().getColumn(9).setCellRenderer(this.celda);
/*      */     } 
/* 8290 */     this.jTextField24.setText(datos[19]);
/* 8291 */     this.jTextField26.setText(datos[20]);
/* 8292 */     this.jTextField39.setText(datos[21]);
/* 8293 */     this.jTextField40.setText(datos[22]);
/* 8294 */     this.jTextField41.setText(datos[23]);
/* 8295 */     this.jTextField42.setText(datos[24]);
/*      */     
/* 8297 */     String tieneLeyenda = datos[25];
/* 8298 */     if (tieneLeyenda.equals("0")) {
/* 8299 */       this.jCheckBox1.setSelected(false);
/* 8300 */       this.jComboBox10.setSelectedIndex(0);
/* 8301 */       this.jTextField28.setText(datos[27]);
/*      */     } else {
/* 8303 */       this.jCheckBox1.setSelected(true);
/* 8304 */       this.jComboBox10.setSelectedItem(datos[26]);
/* 8305 */       this.jTextField28.setText(datos[27]);
/*      */     } 
/*      */     
/* 8308 */     String canti = datos[28];
/* 8309 */     String valorP = ""; int i;
/* 8310 */     for (i = 0; i < canti.length(); i++) {
/* 8311 */       if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 8312 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 8315 */     this.SUBTOTALD = Double.parseDouble(valorP);
/* 8316 */     canti = datos[29];
/* 8317 */     valorP = "";
/* 8318 */     for (i = 0; i < canti.length(); i++) {
/* 8319 */       if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 8320 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 8323 */     this.IVAD = Double.parseDouble(valorP);
/* 8324 */     canti = datos[30];
/* 8325 */     valorP = "";
/* 8326 */     for (i = 0; i < canti.length(); i++) {
/* 8327 */       if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 8328 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 8331 */     this.RETENCION = Double.parseDouble(valorP);
/* 8332 */     this.jFormattedTextField1.setValue(Double.valueOf(this.RETENCION));
/* 8333 */     canti = datos[31];
/* 8334 */     valorP = "";
/* 8335 */     for (i = 0; i < canti.length(); i++) {
/* 8336 */       if (canti.charAt(i) != '$' && canti.charAt(i) != ',') {
/* 8337 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 8340 */     this.TOTALD = Double.parseDouble(valorP);
/* 8341 */     if (this.REFACTURAR) {
/* 8342 */       String[] clientes = this.con.regresaReg("emp_generadora.empresa, emp_generadora.calle, emp_generadora.num, emp_generadora.col, emp_generadora.cp, emp_generadora.ciudad, emp_generadora.rfc, estados.estado", "facturas, tarjeta_deudor_cliente, estados, emp_generadora", "where facturas.tarjeta= tarjeta_deudor_cliente.tarjeta and tarjeta_deudor_cliente.clave_gene = emp_generadora.clave_gene and emp_generadora.id_edo = estados.id_edo and facturas.folio= '" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1)) + "'", 8);
/* 8343 */       boolean dif = false;
/*      */       
/* 8345 */       if (!this.jComboBox1.getSelectedItem().equals(clientes[0])) {
/* 8346 */         dif = true;
/* 8347 */         this.jLabel154.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/*      */       } else {
/* 8349 */         this.jLabel154.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Things_34164.png")));
/*      */       } 
/*      */       
/* 8352 */       if (!this.jTextField17.getText().equals(clientes[6])) {
/* 8353 */         dif = true;
/* 8354 */         this.jLabel155.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/*      */       } else {
/* 8356 */         this.jLabel155.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Things_34164.png")));
/*      */       } 
/*      */       
/* 8359 */       if (!this.jTextField10.getText().equals(clientes[1])) {
/* 8360 */         dif = true;
/* 8361 */         this.jLabel156.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/*      */       } else {
/* 8363 */         this.jLabel156.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Things_34164.png")));
/*      */       } 
/*      */       
/* 8366 */       if (!this.jTextField13.getText().equals(clientes[2])) {
/* 8367 */         dif = true;
/* 8368 */         this.jLabel160.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/*      */       } else {
/* 8370 */         this.jLabel160.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Things_34164.png")));
/*      */       } 
/*      */       
/* 8373 */       if (!this.jTextField14.getText().equals(clientes[3])) {
/* 8374 */         dif = true;
/* 8375 */         this.jLabel161.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/*      */       } else {
/* 8377 */         this.jLabel161.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Things_34164.png")));
/*      */       } 
/*      */       
/* 8380 */       if (!this.jTextField15.getText().equals(clientes[4])) {
/* 8381 */         dif = true;
/* 8382 */         this.jLabel163.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/*      */       } else {
/* 8384 */         this.jLabel163.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Things_34164.png")));
/*      */       } 
/*      */       
/* 8387 */       if (!this.jTextField16.getText().equals(clientes[5])) {
/* 8388 */         dif = true;
/* 8389 */         this.jLabel164.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/*      */       } else {
/* 8391 */         this.jLabel164.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Things_34164.png")));
/*      */       } 
/*      */       
/* 8394 */       if (!this.jComboBox9.getSelectedItem().equals(clientes[7])) {
/* 8395 */         dif = true;
/* 8396 */         this.jLabel165.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/sign-error-icon_34362.png")));
/*      */       } else {
/* 8398 */         this.jLabel165.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Things_34164.png")));
/*      */       } 
/*      */       
/* 8401 */       this.jTextField21.setText(this.jComboBox1.getSelectedItem().toString());
/* 8402 */       this.jTextField63.setText(clientes[0]);
/* 8403 */       this.jTextField56.setText(this.jTextField17.getText());
/* 8404 */       this.jTextField64.setText(clientes[6]);
/* 8405 */       this.jTextField57.setText(this.jTextField10.getText());
/* 8406 */       this.jTextField65.setText(clientes[1]);
/* 8407 */       this.jTextField58.setText(this.jTextField13.getText());
/* 8408 */       this.jTextField66.setText(clientes[2]);
/* 8409 */       this.jTextField59.setText(this.jTextField14.getText());
/* 8410 */       this.jTextField67.setText(clientes[3]);
/* 8411 */       this.jTextField60.setText(this.jTextField15.getText());
/* 8412 */       this.jTextField68.setText(clientes[4]);
/* 8413 */       this.jTextField61.setText(this.jTextField16.getText());
/* 8414 */       this.jTextField69.setText(clientes[5]);
/* 8415 */       this.jTextField62.setText(this.jComboBox9.getSelectedItem().toString());
/* 8416 */       this.jTextField70.setText(clientes[7]);
/*      */       
/* 8418 */       this.jDialog16.setVisible(dif);
/* 8419 */       this.jDialog11.setTitle("Refactura");
/* 8420 */       LeyendaSustituye();
/* 8421 */       if (!dif) {
/* 8422 */         sacarFolioMayor();
/* 8423 */         activarFormatoFactura();
/* 8424 */         this.jDialog11.setVisible(true);
/*      */       } 
/*      */     } 
/* 8427 */     if (this.jDialog11.getTitle().equals("Factura")) {
/* 8428 */       LeyendaSustituye();
/* 8429 */       this.jDialog11.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void LeyendaSustituye() {
/* 8434 */     if (this.jDialog11.getTitle().equals("Refactura")) {
/* 8435 */       if (this.jTextField24.getText().equals("")) {
/* 8436 */         this.jTextField24.setText("SUSTITUYE A LA FACTURA #" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1)));
/* 8437 */       } else if (!this.jTextField24.getText().equals("") && this.jTextField26.getText().equals("")) {
/* 8438 */         this.jTextField26.setText("SUSTITUYE A LA FACTURA #" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1)));
/*      */       } else {
/* 8440 */         this.jTextField24.setText("SUSTITUYE A LA FACTURA #" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1)) + ".      " + this.jTextField24.getText());
/*      */       } 
/* 8442 */       this.jPanel99.setBackground(new Color(102, 153, 255));
/* 8443 */       this.jPanel100.setBackground(new Color(102, 153, 255));
/* 8444 */       this.jPanel101.setBackground(new Color(102, 153, 255));
/* 8445 */       this.jPanel100.setVisible(true);
/* 8446 */       this.jPanel99.setVisible(true);
/* 8447 */       this.jLabel167.setText("SUSTITUYE A LA FACTURA #" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1)));
/* 8448 */       this.jLabel168.setText("");
/*      */     } else {
/*      */       
/* 8451 */       String[] dat = this.con.regresaReg("leyendaSustituye, leyendaSustituida", "facturas", "where folio='" + String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 1)) + "'", 2);
/* 8452 */       if (!dat[0].equals("") && dat[1].equals("")) {
/*      */         
/* 8454 */         this.jPanel99.setBackground(new Color(102, 153, 255));
/* 8455 */         this.jPanel100.setBackground(new Color(102, 153, 255));
/* 8456 */         this.jPanel101.setBackground(new Color(102, 153, 255));
/* 8457 */         this.jPanel99.setVisible(true);
/* 8458 */         this.jLabel167.setText(dat[0]);
/* 8459 */         this.jLabel168.setText("");
/* 8460 */       } else if (dat[0].equals("") && !dat[1].equals("")) {
/*      */         
/* 8462 */         this.jPanel99.setBackground(Color.RED);
/* 8463 */         this.jPanel100.setBackground(Color.RED);
/* 8464 */         this.jPanel101.setBackground(Color.RED);
/* 8465 */         this.jPanel99.setVisible(true);
/* 8466 */         this.jLabel167.setText("");
/* 8467 */         this.jLabel168.setText(dat[1]);
/* 8468 */       } else if (!dat[0].equals("") && !dat[1].equals("")) {
/*      */         
/* 8470 */         this.jPanel99.setBackground(Color.WHITE);
/* 8471 */         this.jPanel100.setBackground(new Color(102, 153, 255));
/* 8472 */         this.jPanel101.setBackground(Color.RED);
/* 8473 */         this.jPanel99.setVisible(true);
/* 8474 */         this.jLabel167.setText(dat[0]);
/* 8475 */         this.jLabel168.setText("<html>" + dat[1] + "</html");
/*      */       } else {
/*      */         
/* 8478 */         this.jPanel99.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public String dameMes(String mes) {
/* 8484 */     String mesLetra = "";
/* 8485 */     if (mes.equals("01")) {
/* 8486 */       mesLetra = "Enero";
/* 8487 */     } else if (mes.equals("02")) {
/* 8488 */       mesLetra = "Febrero";
/* 8489 */     } else if (mes.equals("03")) {
/* 8490 */       mesLetra = "Marzo";
/* 8491 */     } else if (mes.equals("04")) {
/* 8492 */       mesLetra = "Abril";
/* 8493 */     } else if (mes.equals("05")) {
/* 8494 */       mesLetra = "Mayo";
/* 8495 */     } else if (mes.equals("06")) {
/* 8496 */       mesLetra = "Junio";
/* 8497 */     } else if (mes.equals("07")) {
/* 8498 */       mesLetra = "Julio";
/* 8499 */     } else if (mes.equals("08")) {
/* 8500 */       mesLetra = "Agosto";
/* 8501 */     } else if (mes.equals("09")) {
/* 8502 */       mesLetra = "Septiembre";
/* 8503 */     } else if (mes.equals("10")) {
/* 8504 */       mesLetra = "Octubre";
/* 8505 */     } else if (mes.equals("11")) {
/* 8506 */       mesLetra = "Noviembre";
/* 8507 */     } else if (mes.equals("12")) {
/* 8508 */       mesLetra = "Diciembre";
/*      */     } 
/* 8510 */     return mesLetra;
/*      */   }
/*      */   
/*      */   public void sacarSumas() {
/* 8514 */     Double cant = Double.valueOf(0.0D); int i;
/* 8515 */     for (i = 0; i < this.jTable4.getRowCount(); i++) {
/* 8516 */       String valorP = "";
/* 8517 */       String valor = String.valueOf(this.jTable4.getValueAt(i, 2));
/* 8518 */       for (int j = 0; j < valor.length(); j++) {
/* 8519 */         if (valor.charAt(j) != '$' && valor.charAt(j) != ',') {
/* 8520 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 8523 */       cant = Double.valueOf(cant.doubleValue() + Double.parseDouble(valorP));
/*      */     } 
/* 8525 */     this.cantidad.setValue(cant);
/* 8526 */     this.jLabel18.setText(this.cantidad.getText());
/*      */ 
/*      */     
/* 8529 */     cant = Double.valueOf(0.0D);
/* 8530 */     for (i = 0; i < this.jTable4.getRowCount(); i++) {
/* 8531 */       String valorP = "";
/* 8532 */       String valor = String.valueOf(this.jTable4.getValueAt(i, 3));
/* 8533 */       for (int j = 0; j < valor.length(); j++) {
/* 8534 */         if (valor.charAt(j) != '$' && valor.charAt(j) != ',') {
/* 8535 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 8538 */       cant = Double.valueOf(cant.doubleValue() + Double.parseDouble(valorP));
/*      */     } 
/* 8540 */     this.cantidad.setValue(cant);
/* 8541 */     this.jLabel17.setText(this.cantidad.getText());
/*      */ 
/*      */     
/* 8544 */     cant = Double.valueOf(0.0D);
/* 8545 */     for (i = 0; i < this.jTable4.getRowCount(); i++) {
/* 8546 */       String valorP = "";
/* 8547 */       String valor = String.valueOf(this.jTable4.getValueAt(i, 4));
/* 8548 */       for (int j = 0; j < valor.length(); j++) {
/* 8549 */         if (valor.charAt(j) != '$' && valor.charAt(j) != ',' && valor.charAt(j) != '-') {
/* 8550 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 8553 */       cant = Double.valueOf(cant.doubleValue() + Double.parseDouble(valorP));
/*      */     } 
/* 8555 */     this.cantidad.setValue(cant);
/* 8556 */     this.jLabel14.setText(this.cantidad.getText());
/*      */ 
/*      */     
/* 8559 */     cant = Double.valueOf(0.0D);
/* 8560 */     for (i = 0; i < this.jTable4.getRowCount(); i++) {
/* 8561 */       String valorP = "";
/* 8562 */       String valor = String.valueOf(this.jTable4.getValueAt(i, 5));
/* 8563 */       for (int j = 0; j < valor.length(); j++) {
/* 8564 */         if (valor.charAt(j) != '$' && valor.charAt(j) != ',') {
/* 8565 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 8568 */       cant = Double.valueOf(cant.doubleValue() + Double.parseDouble(valorP));
/*      */     } 
/* 8570 */     this.cantidad.setValue(cant);
/* 8571 */     this.jLabel13.setText(this.cantidad.getText());
/*      */     
/* 8573 */     this.jTable4.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 8574 */     this.jTable4.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 8575 */     this.jTable4.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 8576 */     this.jTable4.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/*      */   }
/*      */   
/*      */   public void verPrefactura(String prefactura) {
/* 8580 */     this.jTextField8.setText(this.jTextField18.getText());
/* 8581 */     this.jTextField4.setText(String.valueOf(this.jComboBox1.getSelectedItem()));
/* 8582 */     this.TONELADA = false;
/* 8583 */     String[] datos2 = this.con.regresaReg("iva,ret,folio", "prefacturacliente", "where numFac=" + prefactura, 3);
/* 8584 */     this.IVA = Double.parseDouble(datos2[0]);
/* 8585 */     this.RET = Double.parseDouble(datos2[1]);
/* 8586 */     this.jLabel29.setText("Iva " + this.IVA + "%");
/* 8587 */     this.jLabel30.setText("Retención " + this.RET + "%");
/*      */     
/* 8589 */     this.jTextPane1.setText("");
/* 8590 */     String[] datos = this.con.regresaReg("prefacturacliente.ref,prefacturacliente.fecha,prefacturacliente.cliente,equipo,pozo,tons,numViajes,subTexto,ivaTexto,retTexto,totalTexto,leyenda,comentario", "prefacturacliente", "where numFac = " + prefactura, 13);
/*      */     
/* 8592 */     this.RESIDUOS = this.con.regresaColIndex("distinct(residuo)", "guiasfactura", "where numFac = " + prefactura + " order by residuo");
/*      */     
/* 8594 */     this.jLabel27.setText(datos[7]);
/* 8595 */     this.jLabel28.setText(datos[8]);
/* 8596 */     this.jLabel31.setText(datos[9]);
/* 8597 */     this.jLabel33.setText(datos[10]);
/* 8598 */     this.jTextArea1.setText(datos[12]);
/*      */     
/* 8600 */     String año = datos[1].substring(0, 4);
/* 8601 */     String mes = datos[1].substring(5, 7);
/* 8602 */     String dia = datos[1].substring(8, 10);
/* 8603 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 8604 */     String strFecha = dia + "-" + dia + "-" + mes;
/* 8605 */     Date fechaG = null;
/*      */     try {
/* 8607 */       fechaG = formatoDelTexto.parse(strFecha);
/* 8608 */       this.jDateChooser4.setDate(fechaG);
/* 8609 */     } catch (ParseException ex) {
/* 8610 */       ex.printStackTrace();
/*      */     } 
/* 8612 */     this.jTextField3.setText(datos[0]);
/* 8613 */     this.jComboBox11.setSelectedItem(datos[2]);
/* 8614 */     this.jTextField11.setText(datos[3]);
/* 8615 */     this.jTextField12.setText(datos[4]);
/*      */     
/* 8617 */     this.PREFACTURAINTERNA = prefactura;
/* 8618 */     consultarPrefacGuardada(prefactura);
/*      */     
/* 8620 */     SimpleAttributeSet attrs = new SimpleAttributeSet();
/* 8621 */     StyleConstants.setBold(attrs, true);
/* 8622 */     sacarResiduos();
/* 8623 */     String cant = "";
/* 8624 */     this.TONS = datos[5];
/*      */     try {
/* 8626 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "-[ TOTALES ]-\n\n", attrs);
/* 8627 */       for (int i = 0; i < this.RESABREV.length; i++) {
/* 8628 */         this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), this.RESABREV[i] + ":", attrs);
/* 8629 */         this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), " " + redondear((float)this.TONSRES[i]) + "\n", null);
/*      */       } 
/* 8631 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "______________________\n", null);
/* 8632 */       if (this.TONELADA) {
/* 8633 */         this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "Total de Tons: ", attrs);
/*      */         
/* 8635 */         this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "       " + datos[5] + "\n", null);
/*      */       } 
/* 8637 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "Total de Viajes: ", attrs);
/* 8638 */       this.jTextPane1.getStyledDocument().insertString(this.jTextPane1.getStyledDocument().getLength(), "    " + datos[6] + "\n", null);
/* 8639 */     } catch (BadLocationException ex) {
/* 8640 */       Logger.getLogger(PrefacturaCliente.class.getName()).log(Level.SEVERE, (String)null, ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void sacarResiduos() {
/* 8645 */     this.TONELADASTOTALES = 0.0D;
/* 8646 */     String[] otrosRes = new String[50];
/* 8647 */     int numR = 0; int i;
/* 8648 */     for (i = 0; i < this.jTable5.getRowCount(); i++) {
/* 8649 */       boolean esta = false;
/* 8650 */       String resi = String.valueOf(this.jTable5.getValueAt(i, this.colResi));
/* 8651 */       for (int j = 0; j < otrosRes.length; j++) {
/* 8652 */         if (resi.equals(otrosRes[j])) {
/* 8653 */           esta = true;
/*      */           break;
/*      */         } 
/*      */       } 
/* 8657 */       if (!esta) {
/* 8658 */         otrosRes[numR] = resi;
/* 8659 */         numR++;
/*      */       } 
/*      */     } 
/* 8662 */     this.CONTRESI = new String[numR];
/* 8663 */     this.TONSRES = new double[numR];
/* 8664 */     this.RESABREV = new String[numR];
/* 8665 */     for (i = 0; i < numR; i++) {
/* 8666 */       this.CONTRESI[i] = otrosRes[i];
/*      */     }
/* 8668 */     this.RESABREV = this.CONTRESI;
/* 8669 */     if (this.TONELADA) {
/* 8670 */       for (i = 0; i < this.RESABREV.length; i++) {
/* 8671 */         for (int j = 0; j < this.jTable5.getRowCount(); j++) {
/* 8672 */           String valorT = String.valueOf(this.jTable5.getValueAt(j, this.colResi));
/* 8673 */           if (valorT.equals(this.RESABREV[i])) {
/* 8674 */             double peso = 0.0D;
/*      */             try {
/* 8676 */               peso = Double.parseDouble(String.valueOf(this.jTable5.getValueAt(j, this.colTon)));
/* 8677 */               this.TONSRES[i] = this.TONSRES[i] + peso;
/* 8678 */               this.TONELADASTOTALES += Double.parseDouble(String.valueOf(this.jTable5.getValueAt(j, this.colTon)));
/* 8679 */             } catch (NumberFormatException numberFormatException) {}
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } else {
/*      */       
/* 8685 */       for (i = 0; i < this.RESABREV.length; i++) {
/* 8686 */         for (int j = 0; j < this.jTable5.getRowCount(); j++) {
/* 8687 */           String valorT = String.valueOf(this.jTable5.getValueAt(j, this.colResi));
/* 8688 */           if (valorT.equals(this.RESABREV[i])) {
/* 8689 */             this.TONSRES[i] = this.TONSRES[i] + 1.0D;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultarPrefacGuardada(String prefac) {
/* 8697 */     this.jLabel19.setEnabled(false);
/* 8698 */     this.con.consultar("columnas", "prefacturacliente", "where numFac=" + prefac);
/* 8699 */     String columnas = this.con.Campo;
/* 8700 */     int col = 0;
/* 8701 */     for (int i = 0; i < columnas.length(); i++) {
/* 8702 */       if (columnas.charAt(i) == '-') {
/* 8703 */         col++;
/*      */       }
/*      */     } 
/* 8706 */     columnas = columnas + "-";
/* 8707 */     String[] COLAUX = new String[col];
/* 8708 */     this.COLUMNASTABLA = new String[col];
/* 8709 */     for (int j = 0; j < this.COLUMNASTABLA.length; j++) {
/* 8710 */       this.COLUMNASTABLA[j] = "";
/* 8711 */       COLAUX[j] = "";
/*      */     } 
/* 8713 */     String campo = "";
/* 8714 */     int cont = 0;
/* 8715 */     for (int k = 1; k < columnas.length(); k++) {
/* 8716 */       char l = columnas.charAt(k);
/* 8717 */       if (l != '-') {
/* 8718 */         campo = campo + campo;
/*      */       } else {
/* 8720 */         COLAUX[cont] = campo;
/* 8721 */         cont++;
/* 8722 */         campo = "";
/*      */       } 
/*      */     } 
/* 8725 */     this.CAMPOSTABLA = new String[col];
/* 8726 */     this.tamañosCol = new int[col];
/* 8727 */     this.COLNOMBRES = new String[col];
/* 8728 */     this.COLSELEC = new int[col];
/* 8729 */     this.CAMPOSCON = "";
/* 8730 */     int cuenta = 0;
/* 8731 */     col = 0;
/* 8732 */     for (int m = 0; m < this.IMPRESION.length; m++) {
/* 8733 */       String obj = this.IMPRESION[m];
/* 8734 */       String campoSql = COLAUX[col];
/* 8735 */       if (obj.equals(campoSql)) {
/* 8736 */         if (campoSql.equals("Otros $")) {
/* 8737 */           this.colExtra++;
/* 8738 */           this.colOtros = col;
/*      */         } 
/* 8740 */         if (campoSql.equals("Peso")) {
/* 8741 */           this.colTon = col;
/* 8742 */           this.TONELADA = true;
/*      */         } 
/* 8744 */         if (campoSql.equals("Residuo")) {
/* 8745 */           this.colResi = col;
/*      */         }
/* 8747 */         this.COLUMNASTABLA[col] = campoSql;
/*      */         
/* 8749 */         this.CAMPOSCON = this.CAMPOSCON + this.CAMPOSCON + ",";
/*      */         
/* 8751 */         this.tamañosCol[col] = this.TAMAÑOS[m];
/* 8752 */         this.COLSELEC[col] = this.COLIMPRESION[m];
/* 8753 */         this.COLNOMBRES[col] = this.IMPRESION[m];
/* 8754 */         col++;
/*      */       } 
/* 8756 */       if (col == COLAUX.length) {
/*      */         break;
/*      */       }
/*      */     } 
/* 8760 */     String llamadas = "";
/* 8761 */     String guias = "";
/* 8762 */     String manifiestosAG = "";
/* 8763 */     String manifiestosAC = "";
/* 8764 */     String vales = "";
/* 8765 */     String cliente = "";
/* 8766 */     String destino = "";
/* 8767 */     String equipo = "";
/* 8768 */     String plataforma = "";
/* 8769 */     String pozo = "";
/*      */     
/* 8771 */     String cond1 = "";
/* 8772 */     String cond2 = "";
/* 8773 */     String cond3 = "";
/* 8774 */     String cond4 = "";
/* 8775 */     String cond5 = "";
/* 8776 */     String cond6 = "";
/* 8777 */     String cond7 = "";
/* 8778 */     String cond8 = "";
/* 8779 */     String cond9 = "";
/*      */     
/* 8781 */     String tablas = "";
/* 8782 */     String condicion = "";
/* 8783 */     String general = "";
/* 8784 */     if (!guias.equals("")) {
/* 8785 */       tablas = "guias,";
/*      */     }
/* 8787 */     if (!llamadas.equals("")) {
/* 8788 */       tablas = tablas + "llamadas_historicas,";
/* 8789 */       general = cond1;
/*      */     } 
/* 8791 */     if (!equipo.equals("")) {
/* 8792 */       tablas = tablas + "equipos,";
/* 8793 */       general = general + " and " + general;
/*      */     } 
/* 8795 */     if (!plataforma.equals("")) {
/* 8796 */       tablas = tablas + "plataformas,";
/* 8797 */       general = general + " and " + general;
/*      */     } 
/* 8799 */     if (!pozo.equals("")) {
/* 8800 */       tablas = tablas + "pozos,";
/* 8801 */       general = general + " and " + general;
/*      */     } 
/* 8803 */     if (!cliente.equals("")) {
/* 8804 */       tablas = tablas + "emp_generadora,";
/* 8805 */       general = general + " and " + general;
/*      */     } 
/* 8807 */     if (!destino.equals("")) {
/* 8808 */       tablas = tablas + "emp_destinataria,";
/* 8809 */       general = general + " and " + general;
/*      */     } 
/* 8811 */     if (!vales.equals("")) {
/* 8812 */       tablas = tablas + "vales,";
/* 8813 */       general = general + " and " + general;
/*      */     } 
/* 8815 */     this.CAMPOSCON = this.CAMPOSCON.substring(0, this.CAMPOSCON.length() - 1);
/*      */     
/* 8817 */     this.jTable5.setModel(new DefaultTableModel((Object[][])this.con
/* 8818 */           .buscarDatos(this.COLUMNASTABLA.length, this.CAMPOSCON, "guiasfactura", "where numFac =" + prefac + " order by guiasfactura.num"), (Object[])this.COLUMNASTABLA)
/*      */         {
/* 8820 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 8825 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 8828 */     this.jTable5.setAutoCreateRowSorter(true);
/* 8829 */     this.jTable5.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 8831 */     for (int n = 0; n < this.tamañosCol.length; n++) {
/* 8832 */       if (this.tamañosCol[n] != 0) {
/* 8833 */         this.jTable5.getColumnModel().getColumn(n).setPreferredWidth(this.tamañosCol[n]);
/* 8834 */         this.jTable5.getColumnModel().getColumn(n).setMaxWidth(this.tamañosCol[n]);
/*      */       } 
/*      */     } 
/* 8837 */     this.jTable5.getColumnModel().getColumn(this.jTable5.getColumnCount() - 2).setCellRenderer(this.celda);
/* 8838 */     this.jTable5.getColumnModel().getColumn(this.jTable5.getColumnCount() - 1).setCellRenderer(this.celda);
/* 8839 */     this.jScrollPane5.setViewportView(this.jTable5);
/* 8840 */     this.jTable12.setModel(new DefaultTableModel((Object[][])this.con
/* 8841 */           .buscarDatos(4, "cant,concepto,p_unitario,importe", "prefacturaotrosconcep", "where numPreFac =" + prefac + " order by num"), (Object[])new String[] { "Clave", "Concepto", "P Unitario", "Importe" })
/*      */         {
/*      */ 
/*      */           
/* 8845 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 8850 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 8854 */     this.jTable12.getColumnModel().getColumn(0).setMinWidth(60);
/* 8855 */     this.jTable12.getColumnModel().getColumn(0).setMaxWidth(60);
/* 8856 */     this.jTable12.getColumnModel().getColumn(2).setMinWidth(90);
/* 8857 */     this.jTable12.getColumnModel().getColumn(2).setMaxWidth(90);
/* 8858 */     this.jTable12.getColumnModel().getColumn(3).setMinWidth(90);
/* 8859 */     this.jTable12.getColumnModel().getColumn(3).setMaxWidth(90);
/*      */     
/* 8861 */     this.jTable12.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 8862 */     this.jTable12.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/*      */   }
/*      */   public class CeldaRender2 extends DefaultTableCellRenderer { int otro; String[] indices; String[] indices2; String[] indices3; String[] indices4; String[] indices5; String[] indices6; String[] indices7;
/*      */     
/*      */     public CeldaRender2() {
/* 8867 */       this.otro = -1;
/* 8868 */       this.indices = new String[0];
/* 8869 */       this.indices2 = new String[0];
/* 8870 */       this.indices3 = new String[0];
/* 8871 */       this.indices4 = new String[0];
/* 8872 */       this.indices5 = new String[0];
/* 8873 */       this.indices6 = new String[0];
/* 8874 */       this.indices7 = new String[0];
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 8877 */       setEnabled((table == null || table.isEnabled()));
/* 8878 */       String comp = String.valueOf(table.getValueAt(row, 1));
/* 8879 */       if (comparar7(comp)) {
/*      */ 
/*      */         
/* 8882 */         setBackground(new Color(34, 108, 255));
/* 8883 */         setForeground(Color.WHITE);
/* 8884 */       } else if (comparar6(comp)) {
/* 8885 */         setBackground(new Color(255, 102, 0));
/* 8886 */         setForeground(Color.WHITE);
/* 8887 */       } else if (comparar3(comp)) {
/* 8888 */         setBackground(new Color(102, 153, 255));
/* 8889 */         setForeground(Color.BLUE);
/* 8890 */       } else if (comparar4(comp)) {
/* 8891 */         setBackground(Color.LIGHT_GRAY);
/* 8892 */         setForeground(Color.RED);
/* 8893 */       } else if (comparar5(comp)) {
/* 8894 */         setBackground(Color.RED);
/* 8895 */         setForeground(Color.WHITE);
/*      */       } else {
/* 8897 */         setBackground((Color)null);
/* 8898 */         setForeground(Color.black);
/*      */       } 
/* 8900 */       if (column == 8 || column == 9 || column == 10 || column == 11) {
/* 8901 */         setHorizontalAlignment(4);
/*      */       } else {
/* 8903 */         setHorizontalAlignment(10);
/*      */       } 
/*      */       
/* 8906 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 8907 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 8911 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 8915 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd3(String[] ind) {
/* 8919 */       this.indices3 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd4(String[] ind) {
/* 8923 */       this.indices4 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd5(String[] ind) {
/* 8927 */       this.indices5 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd6(String[] ind) {
/* 8931 */       this.indices6 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd7(String[] ind) {
/* 8935 */       this.indices7 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 8939 */       for (int i = 0; i < this.indices.length; i++) {
/* 8940 */         if (this.indices[i].equals(reg)) {
/* 8941 */           return true;
/*      */         }
/*      */       } 
/* 8944 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 8948 */       for (int i = 0; i < this.indices2.length; i++) {
/* 8949 */         if (this.indices2[i].equals(reg)) {
/* 8950 */           return true;
/*      */         }
/*      */       } 
/* 8953 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar3(String reg) {
/* 8957 */       for (int i = 0; i < this.indices3.length; i++) {
/* 8958 */         if (this.indices3[i].equals(reg)) {
/* 8959 */           return true;
/*      */         }
/*      */       } 
/* 8962 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar4(String reg) {
/* 8966 */       for (int i = 0; i < this.indices4.length; i++) {
/* 8967 */         if (this.indices4[i].equals(reg)) {
/* 8968 */           return true;
/*      */         }
/*      */       } 
/* 8971 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar5(String reg) {
/* 8975 */       for (int i = 0; i < this.indices5.length; i++) {
/* 8976 */         if (this.indices5[i].equals(reg)) {
/* 8977 */           return true;
/*      */         }
/*      */       } 
/* 8980 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar6(String reg) {
/* 8984 */       for (int i = 0; i < this.indices6.length; i++) {
/* 8985 */         if (this.indices6[i].equals(reg)) {
/* 8986 */           return true;
/*      */         }
/*      */       } 
/* 8989 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar7(String reg) {
/* 8993 */       for (int i = 0; i < this.indices7.length; i++) {
/* 8994 */         if (this.indices7[i].equals(reg)) {
/* 8995 */           return true;
/*      */         }
/*      */       } 
/* 8998 */       return false;
/*      */     } }
/*      */   
/*      */   class CeldaRender3 extends DefaultTableCellRenderer { int otro;
/*      */     
/*      */     CeldaRender3() {
/* 9004 */       this.otro = -1;
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 9007 */       setEnabled((table == null || table.isEnabled()));
/* 9008 */       if (row % 2 == 0) {
/* 9009 */         setBackground(new Color(194, 213, 151));
/* 9010 */         setForeground(Color.black);
/* 9011 */         setHorizontalAlignment(2);
/*      */       } else {
/* 9013 */         setBackground((Color)null);
/* 9014 */         setForeground(Color.black);
/* 9015 */         setHorizontalAlignment(2);
/*      */       } 
/* 9017 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 9018 */       return this;
/*      */     } }
/*      */ 
/*      */   
/*      */   public class ImprimirFactura1
/*      */     implements Printable {
/* 9024 */     String[] DATOS = new String[] { "sdfsdf", "sdfsdf", "sdfsdf" };
/* 9025 */     int opc = 0; public int print(Graphics g, PageFormat f, int pageIndex) { SimpleDateFormat formato; String cadenaFecha2, año, mes, dia; Font fuente; String cliente; int linea;
/*      */       String var;
/*      */       int i;
/* 9028 */       Graphics2D g2 = (Graphics2D)g;
/* 9029 */       f.setOrientation(0);
/* 9030 */       switch (pageIndex) {
/*      */         case 0:
/* 9032 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 9033 */           cadenaFecha2 = formato.format(Facturas.this.jDateChooser6.getDate());
/* 9034 */           año = cadenaFecha2.substring(0, 4);
/* 9035 */           mes = cadenaFecha2.substring(4, 6);
/* 9036 */           dia = cadenaFecha2.substring(6, 8);
/* 9037 */           fuente = new Font("Dialog", 0, 9);
/* 9038 */           g2.setFont(fuente);
/* 9039 */           g2.drawString(Facturas.this.jTextField18.getText().toUpperCase(), 433, 72);
/* 9040 */           g2.drawString(dia + " " + dia + " " + Facturas.this.dameMes(mes), 420, 106);
/* 9041 */           g2.drawString(Facturas.this.jTextField19.getText().toUpperCase(), 423, 153);
/* 9042 */           g2.drawString(String.valueOf(Facturas.this.jComboBox1.getSelectedItem()), 25, 187);
/* 9043 */           cliente = String.valueOf(Facturas.this.jComboBox1.getSelectedItem());
/* 9044 */           if (cliente.equals("MI DRILLING FLUIDS DE MÉXICO S.A. DE C.V.") || cliente.equals("DOWELL SCHLUMBERGER DE MÉXICO S.A DE C.V.")) {
/* 9045 */             g2.drawString(Facturas.this.jTextField10.getText().toUpperCase() + " " + Facturas.this.jTextField10.getText().toUpperCase(), 25, 200);
/* 9046 */             g2.drawString(Facturas.this.jTextField14.getText().toUpperCase() + "    CP " + Facturas.this.jTextField14.getText().toUpperCase(), 25, 213);
/* 9047 */             g2.drawString(Facturas.this.jTextField16.getText().toUpperCase() + ", " + Facturas.this.jTextField16.getText().toUpperCase() + "     RFC " + String.valueOf(Facturas.this.jComboBox9.getSelectedItem()), 25, 226);
/*      */           } else {
/* 9049 */             g2.drawString(Facturas.this.jTextField10.getText().toUpperCase() + " " + Facturas.this.jTextField10.getText().toUpperCase() + " " + Facturas.this.jTextField13.getText().toUpperCase(), 25, 200);
/* 9050 */             g2.drawString("CP " + Facturas.this.jTextField15.getText().toUpperCase() + " " + Facturas.this.jTextField16.getText().toUpperCase() + ", " + String.valueOf(Facturas.this.jComboBox9.getSelectedItem()), 25, 213);
/* 9051 */             g2.drawString("RFC " + Facturas.this.jTextField17.getText().toUpperCase(), 25, 226);
/*      */           } 
/*      */           
/* 9054 */           fuente = new Font("Dialog", 0, 9);
/* 9055 */           g.setFont(fuente);
/*      */           
/* 9057 */           g2.drawString(Facturas.this.jTextField39.getText().toUpperCase(), 330, 187);
/* 9058 */           g2.drawString(Facturas.this.jTextField40.getText().toUpperCase(), 330, 200);
/* 9059 */           g2.drawString(Facturas.this.jTextField41.getText().toUpperCase(), 330, 213);
/* 9060 */           g2.drawString(Facturas.this.jTextField42.getText().toUpperCase(), 330, 226);
/*      */           
/* 9062 */           g2.drawString(Facturas.this.jTextField20.getText().toUpperCase(), 20, 270);
/*      */           
/* 9064 */           g2.drawString(Facturas.this.jTextField22.getText().toUpperCase(), 170, 270);
/*      */ 
/*      */           
/* 9067 */           linea = 320;
/* 9068 */           fuente = new Font("Dialog", 1, 10);
/* 9069 */           g.setFont(fuente);
/*      */           
/* 9071 */           var = "";
/*      */           
/* 9073 */           if (Facturas.this.jComboBox2.getSelectedIndex() != 0) {
/* 9074 */             var = "EQ: " + String.valueOf(Facturas.this.jComboBox2.getSelectedItem()) + "       ";
/*      */           }
/* 9076 */           if (Facturas.this.jComboBox4.getSelectedIndex() != 0) {
/* 9077 */             var = var + "PLAT: " + var + "       ";
/*      */           }
/* 9079 */           if (Facturas.this.jComboBox12.getSelectedIndex() != 0) {
/* 9080 */             var = var + "POZO: " + var;
/*      */           }
/*      */           
/* 9083 */           g2.drawString(var, 65, linea);
/* 9084 */           linea += 10;
/*      */           
/* 9086 */           fuente = new Font("Dialog", 1, 8);
/* 9087 */           g.setFont(fuente);
/* 9088 */           if (!Facturas.this.jTextField24.getText().equals("")) {
/* 9089 */             g2.drawString(Facturas.this.jTextField24.getText().toUpperCase(), 65, linea);
/* 9090 */             linea += 15;
/*      */           } 
/* 9092 */           fuente = new Font("Dialog", 0, 9);
/* 9093 */           g.setFont(fuente);
/* 9094 */           for (i = 0; i < Facturas.this.jTable10.getRowCount(); i++) {
/* 9095 */             int linea2 = linea;
/*      */             
/* 9097 */             g2.drawString(String.valueOf(Facturas.this.jTable10.getValueAt(i, 0)), Facturas.this.alinearDer(45, Facturas.this.jTable10.getValueAt(i, 0).toString().length()), linea);
/*      */ 
/*      */             
/* 9100 */             String texto = String.valueOf(Facturas.this.jTable10.getValueAt(i, 1));
/* 9101 */             boolean entra = false;
/* 9102 */             if (texto.length() > 46) {
/* 9103 */               entra = true;
/* 9104 */               String[] Lineas = { "", "", "", "", "", "", "", "", "", "" };
/* 9105 */               int esp = 0;
/* 9106 */               String[] nombres = null;
/* 9107 */               int contarL = 0; int j;
/* 9108 */               for (j = 0; j < texto.length(); j++) {
/* 9109 */                 if (texto.charAt(j) == ' ') {
/* 9110 */                   esp++;
/*      */                 }
/*      */               } 
/* 9113 */               nombres = new String[esp + 1];
/* 9114 */               for (j = 0; j <= esp; j++) {
/* 9115 */                 nombres[j] = "";
/*      */               }
/* 9117 */               esp = 0;
/*      */               
/* 9119 */               for (j = 0; j < texto.length(); j++) {
/* 9120 */                 if (texto.charAt(j) == ' ') {
/* 9121 */                   esp++;
/*      */                 } else {
/* 9123 */                   nombres[esp] = nombres[esp] + nombres[esp];
/*      */                 } 
/*      */               } 
/* 9126 */               esp = 0;
/*      */               
/* 9128 */               for (j = 0; j < nombres.length; j++) {
/* 9129 */                 contarL = Lineas[esp].length();
/* 9130 */                 if (contarL < 46) {
/* 9131 */                   Lineas[esp] = Lineas[esp] + Lineas[esp] + " ";
/*      */                 } else {
/* 9133 */                   Lineas[esp] = Lineas[esp] + Lineas[esp] + " ";
/* 9134 */                   esp++;
/*      */                 } 
/*      */               } 
/* 9137 */               for (j = 0; j <= esp; j++) {
/*      */                 
/* 9139 */                 g2.drawString(Lineas[j], 85, linea);
/* 9140 */                 linea += 9;
/*      */               } 
/*      */             } else {
/* 9143 */               g2.drawString(String.valueOf(Facturas.this.jTable10.getValueAt(i, 1)), 85, linea);
/*      */             } 
/*      */ 
/*      */             
/* 9147 */             g2.drawString(String.valueOf(Facturas.this.jTable10.getValueAt(i, 2)), Facturas.this.alinearDer(475, Facturas.this.jTable10.getValueAt(i, 2).toString().length()), linea2);
/* 9148 */             g2.drawString(String.valueOf(Facturas.this.jTable10.getValueAt(i, 3)), Facturas.this.alinearDer(570, Facturas.this.jTable10.getValueAt(i, 3).toString().length()), linea2);
/*      */             
/* 9150 */             if (entra) {
/* 9151 */               linea += 4;
/*      */             } else {
/* 9153 */               linea += 12;
/*      */             } 
/*      */           } 
/* 9156 */           linea += 3;
/* 9157 */           fuente = new Font("Dialog", 1, 8);
/* 9158 */           g.setFont(fuente);
/* 9159 */           g2.drawString(Facturas.this.jTextField26.getText().toUpperCase(), 65, linea);
/*      */           
/* 9161 */           fuente = new Font("Dialog", 0, 9);
/* 9162 */           g.setFont(fuente);
/*      */           
/* 9164 */           g2.drawString(Facturas.this.jLabel107.getText(), Facturas.this.alinearDer(570, Facturas.this.jLabel107.getText().length()), 497);
/* 9165 */           g2.drawString("%" + Facturas.this.CONFIGURACIONES[0], 485, 512);
/*      */           
/* 9167 */           g2.drawString(Facturas.this.jLabel108.getText(), Facturas.this.alinearDer(570, Facturas.this.jLabel108.getText().length()), 512);
/*      */ 
/*      */           
/* 9170 */           g2.drawString(Facturas.this.jLabel114.getText(), Facturas.this.alinearDer(570, Facturas.this.jLabel114.getText().length()), 542);
/* 9171 */           g2.drawString("%" + Facturas.this.CONFIGURACIONES[1], 485, 527);
/*      */           
/* 9173 */           g2.drawString(Facturas.this.jFormattedTextField1.getText(), Facturas.this.alinearDer(570, Facturas.this.jFormattedTextField1.getText().length()), 527);
/*      */           
/* 9175 */           fuente = new Font("Dialog", 0, 8);
/* 9176 */           g.setFont(fuente);
/* 9177 */           g2.drawString(Facturas.this.jTextField25.getText().toUpperCase(), 25, 515);
/* 9178 */           if (Facturas.this.jCheckBox1.isSelected()) {
/* 9179 */             if (Facturas.this.jComboBox10.getSelectedIndex() == 0) {
/* 9180 */               g2.drawString(Facturas.this.jTextField28.getText().toUpperCase(), 85, 480);
/* 9181 */             } else if (Facturas.this.jComboBox10.getSelectedIndex() == 1) {
/* 9182 */               g2.drawString("Impuesto Retenido de Conformidad con la Ley del", 85, 470);
/* 9183 */               g2.drawString("Impuesto al Valor Agregado", 85, 480);
/*      */             } else {
/* 9185 */               g2.drawString(Facturas.this.jTextField28.getText().toUpperCase(), 85, 480);
/*      */             } 
/*      */           }
/* 9188 */           return 0;
/*      */       } 
/* 9190 */       return 1; }
/*      */ 
/*      */ 
/*      */     
/*      */     public void recibeDatos() {
/* 9195 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 9196 */       job.setPrintable(this);
/*      */       
/* 9198 */       PageFormat pf = job.defaultPage();
/* 9199 */       Paper papel = pf.getPaper();
/* 9200 */       papel.setSize(612.0D, 792.0D);
/* 9201 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 9202 */       pf.setPaper(papel);
/* 9203 */       pf.setOrientation(1);
/* 9204 */       ImprimirFactura1 im = new ImprimirFactura1();
/* 9205 */       job.setPrintable(im, pf);
/* 9206 */       job.defaultPage(pf);
/*      */       
/* 9208 */       boolean ok = job.printDialog();
/* 9209 */       if (ok)
/*      */         try {
/* 9211 */           job.print();
/* 9212 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */   public class ImprimirFacturas implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[][] Lineas; int linesPerPage; int orientacion; double X;
/*      */     double Y;
/*      */     int YINICIA;
/*      */     int[] PXCOL;
/*      */     int NumLineas;
/*      */     int numBreaks;
/*      */     
/*      */     public ImprimirFacturas() {
/* 9222 */       this.g2 = null;
/* 9223 */       this.Pag = 0;
/*      */       
/* 9225 */       this.linesPerPage = 50;
/* 9226 */       this.orientacion = 0;
/* 9227 */       this.X = 0.0D;
/* 9228 */       this.Y = 0.0D;
/* 9229 */       this.YINICIA = 75;
/* 9230 */       this.PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/* 9231 */       this.NumLineas = 0;
/* 9232 */       this.numBreaks = 0;
/*      */     }
/*      */     private void initTextLines() {
/* 9235 */       if (this.textLines == null) {
/* 9236 */         int numLines = Facturas.this.jTable3.getRowCount();
/* 9237 */         this.textLines = new String[numLines];
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 9242 */       Font font = new Font("Serif", 0, 8);
/* 9243 */       FontMetrics metrics = g.getFontMetrics(font);
/* 9244 */       int lineHeight = metrics.getHeight();
/* 9245 */       if (this.pageBreaks == null) {
/* 9246 */         initTextLines();
/* 9247 */         this.orientacion = pf.getOrientation();
/* 9248 */         if (pf.getOrientation() == 1) {
/* 9249 */           this.linesPerPage = 44;
/* 9250 */           this.X = pf.getWidth();
/* 9251 */           this.Y = pf.getHeight();
/*      */         } else {
/* 9253 */           this.linesPerPage = 38;
/* 9254 */           this.X = pf.getWidth();
/* 9255 */           this.Y = pf.getHeight();
/*      */         } 
/* 9257 */         this.numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 9258 */         this.Pag = this.numBreaks;
/* 9259 */         this.pageBreaks = new int[this.numBreaks];
/* 9260 */         for (int b = 0; b < this.numBreaks; b++) {
/* 9261 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 9264 */       if (pageIndex > this.pageBreaks.length) {
/* 9265 */         return 1;
/*      */       }
/* 9267 */       Graphics2D g2d = (Graphics2D)g;
/* 9268 */       this.g2 = g;
/* 9269 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 9270 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 9271 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 9272 */       encabezado();
/* 9273 */       int y = this.YINICIA;
/* 9274 */       int lineas = 0;
/*      */       
/* 9276 */       this.g2.drawRect(25, 160, 550, 12);
/* 9277 */       this.g2.setColor(new Color(204, 0, 0));
/* 9278 */       this.g2.fillRect(25, 161, 550, 10);
/*      */       
/* 9280 */       Font fuente = new Font("Dialog", 0, 7);
/* 9281 */       this.g2.setFont(fuente);
/* 9282 */       this.g2.setColor(Color.WHITE);
/* 9283 */       int[] valores = { 29, 55, 90, 145, 200, 270, 340, 390, 430, 480, 530 };
/* 9284 */       this.g2.drawString("FOLIO", valores[0], 169);
/* 9285 */       this.g2.drawString("FECHA", valores[1], 169);
/* 9286 */       this.g2.drawString("CLIENTE", valores[2], 169);
/* 9287 */       this.g2.drawString("RECEPCIÓN", valores[3], 169);
/* 9288 */       this.g2.drawString("SU PEDIDO", valores[4], 169);
/* 9289 */       this.g2.drawString("POZO", valores[5], 169);
/* 9290 */       this.g2.drawString("SUB", valores[6] + 20, 169);
/* 9291 */       this.g2.drawString("IVA", valores[7] + 20, 169);
/* 9292 */       this.g2.drawString("RET", valores[8] + 20, 169);
/* 9293 */       this.g2.drawString("TOTAL", valores[9] + 15, 169);
/* 9294 */       this.g2.drawString("ESTATUS", valores[10], 169);
/*      */       
/* 9296 */       this.g2.setColor(Color.BLACK);
/* 9297 */       y = 170;
/* 9298 */       for (int line = start; line < end; line++) {
/* 9299 */         y += 12;
/*      */         
/* 9301 */         String valor = "";
/* 9302 */         if (line < 9) {
/* 9303 */           valor = "0" + line + 1;
/*      */         } else {
/* 9305 */           valor = "" + line + 1;
/*      */         } 
/* 9307 */         fuente = new Font("Dialog", 1, 7);
/* 9308 */         this.g2.setFont(fuente);
/* 9309 */         this.g2.drawString(valor, Facturas.this.alinearDer(20, valor.length()), y - 2);
/*      */         
/* 9311 */         fuente = new Font("Dialog", 0, 6);
/* 9312 */         this.g2.setFont(fuente);
/*      */         
/* 9314 */         this.g2.drawString(String.valueOf(Facturas.this.jTable3.getValueAt(line, 1)), valores[0], y - 2);
/* 9315 */         String fecha = String.valueOf(Facturas.this.jTable3.getValueAt(line, 2));
/* 9316 */         String col = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 9317 */         this.g2.drawString(col, valores[1], y - 2);
/*      */         
/* 9319 */         String cliente = String.valueOf(Facturas.this.jTable3.getValueAt(line, 3));
/* 9320 */         int ind = cliente.indexOf(" ");
/* 9321 */         cliente = cliente.substring(0, ind);
/* 9322 */         this.g2.drawString(cliente, valores[2], y - 2);
/*      */         
/* 9324 */         this.g2.drawString(String.valueOf(Facturas.this.jTable3.getValueAt(line, 4)), valores[3], y - 2);
/* 9325 */         this.g2.drawString(String.valueOf(Facturas.this.jTable3.getValueAt(line, 7)), valores[4], y - 2);
/* 9326 */         this.g2.drawString(String.valueOf(Facturas.this.jTable3.getValueAt(line, 8)), valores[5], y - 2);
/* 9327 */         this.g2.drawString(String.valueOf(Facturas.this.jTable3.getValueAt(line, 8)), Facturas.this.alinearDer(valores[6] + 40, Facturas.this.jTable3.getValueAt(line, 9).toString().length()), y - 2);
/* 9328 */         this.g2.drawString(String.valueOf(Facturas.this.jTable3.getValueAt(line, 9)), Facturas.this.alinearDer(valores[7] + 40, Facturas.this.jTable3.getValueAt(line, 10).toString().length()), y - 2);
/* 9329 */         this.g2.drawString(String.valueOf(Facturas.this.jTable3.getValueAt(line, 10)), Facturas.this.alinearDer(valores[8] + 40, Facturas.this.jTable3.getValueAt(line, 11).toString().length()), y - 2);
/* 9330 */         this.g2.drawString(String.valueOf(Facturas.this.jTable3.getValueAt(line, 11)), Facturas.this.alinearDer(valores[9] + 40, Facturas.this.jTable3.getValueAt(line, 12).toString().length()), y - 2);
/* 9331 */         this.g2.drawString(String.valueOf(Facturas.this.jTable3.getValueAt(line, 12)), valores[10], y - 2);
/*      */       } 
/*      */       
/* 9334 */       g.drawString("Página " + pageIndex + 1, 540, 749);
/* 9335 */       if (this.Pag == pageIndex) {
/* 9336 */         this.g2.drawLine(20, y, 90, y);
/* 9337 */         this.g2.drawLine(350, y, 390, y);
/* 9338 */         this.g2.drawLine(395, y, 435, y);
/* 9339 */         this.g2.drawLine(440, y, 480, y);
/* 9340 */         this.g2.drawLine(485, y, 525, y);
/*      */         
/* 9342 */         fuente = new Font("Dialog", 1, 6);
/* 9343 */         this.g2.setFont(fuente);
/* 9344 */         g.drawString("SUMAS", 41, y + 10);
/* 9345 */         this.g2.drawString(Facturas.this.jLabel42.getText(), Facturas.this.alinearDer(valores[6] + 40, Facturas.this.jLabel42.getText().length()), y + 10);
/* 9346 */         this.g2.drawString(Facturas.this.jLabel39.getText(), Facturas.this.alinearDer(valores[7] + 40, Facturas.this.jLabel39.getText().length()), y + 10);
/* 9347 */         this.g2.drawString(Facturas.this.jLabel38.getText(), Facturas.this.alinearDer(valores[8] + 40, Facturas.this.jLabel38.getText().length()), y + 10);
/* 9348 */         this.g2.drawString(Facturas.this.jLabel37.getText(), Facturas.this.alinearDer(valores[9] + 40, Facturas.this.jLabel37.getText().length()), y + 10);
/*      */         
/* 9350 */         fuente = new Font("Dialog", 1, 7);
/* 9351 */         this.g2.setFont(fuente);
/* 9352 */         this.g2.drawString("ELABORÓ", 190, 720);
/* 9353 */         this.g2.drawString("_____________________________________", 140, 752);
/* 9354 */         this.g2.drawString("NOMBRE Y FIRMA", 178, 765);
/*      */         
/* 9356 */         this.g2.drawString("RECIBE", 390, 720);
/* 9357 */         this.g2.drawString("_____________________________________", 340, 752);
/* 9358 */         this.g2.drawString("NOMBRE Y FIRMA", 378, 765);
/*      */       } 
/* 9360 */       return 0;
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 9364 */       Font fuente = new Font("Dialog", 0, 8);
/* 9365 */       this.g2.setFont(fuente);
/* 9366 */       this.g2.setColor(Color.BLACK);
/* 9367 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 9368 */       Image img = imagen.getImage();
/* 9369 */       this.g2.drawImage(img, 518, 1, 57, 57, null);
/*      */       
/* 9371 */       imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/sicret2.png"));
/* 9372 */       img = imagen.getImage();
/* 9373 */       this.g2.drawImage(img, 27, 8, 60, 50, null);
/*      */       
/* 9375 */       fuente = new Font("Times New Roman", 1, 16);
/* 9376 */       this.g2.setFont(fuente);
/* 9377 */       this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 135, 20);
/*      */       
/* 9379 */       fuente = new Font("Dialog", 0, 12);
/* 9380 */       this.g2.setFont(fuente);
/* 9381 */       this.g2.drawString("IMPRESIÓN DE FACTURAS", 220, 37);
/* 9382 */       this.g2.drawLine(25, 60, 575, 60);
/*      */       
/* 9384 */       this.g2.setColor(Color.BLACK);
/* 9385 */       this.g2.drawLine(25, 83, 220, 83);
/* 9386 */       this.g2.drawLine(25, 143, 220, 143);
/*      */       
/* 9388 */       fuente = new Font("Dialog", 1, 8);
/* 9389 */       this.g2.setFont(fuente);
/* 9390 */       this.g2.setColor(Color.BLACK);
/* 9391 */       this.g2.drawString("INFORMACIÓN DEL REPORTE", 25, 80);
/*      */       
/* 9393 */       fuente = new Font("Dialog", 1, 7);
/* 9394 */       this.g2.setFont(fuente);
/* 9395 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 9397 */       this.g2.drawString("Cliente: ", 27, 93);
/* 9398 */       this.g2.drawString("Equipo: ", 27, 104);
/* 9399 */       this.g2.drawString("Plataforma: ", 27, 115);
/* 9400 */       this.g2.drawString("Pozo: ", 27, 126);
/* 9401 */       this.g2.drawString("Periodo: ", 27, 137);
/*      */       
/* 9403 */       fuente = new Font("Dialog", 0, 7);
/* 9404 */       this.g2.setFont(fuente);
/* 9405 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 9407 */       this.g2.drawString(String.valueOf(Facturas.this.jComboBox3.getSelectedItem()), 85, 93);
/* 9408 */       this.g2.drawString(String.valueOf(Facturas.this.jComboBox5.getSelectedItem()), 85, 104);
/* 9409 */       this.g2.drawString(String.valueOf(Facturas.this.jComboBox6.getSelectedItem()), 85, 115);
/* 9410 */       this.g2.drawString(String.valueOf(Facturas.this.jComboBox7.getSelectedItem()), 85, 126);
/*      */       
/* 9412 */       Date fecha1 = Facturas.this.jDateChooser4.getDate();
/* 9413 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 9414 */       String cadenaFecha = "";
/* 9415 */       cadenaFecha = formato.format(fecha1);
/* 9416 */       String AÑO = cadenaFecha.substring(0, 4);
/* 9417 */       String MES = cadenaFecha.substring(4, 6);
/* 9418 */       String DIA = cadenaFecha.substring(6, 8);
/*      */       
/* 9420 */       fecha1 = Facturas.this.jDateChooser5.getDate();
/* 9421 */       formato = new SimpleDateFormat("yyyyMMdd");
/* 9422 */       cadenaFecha = "";
/* 9423 */       cadenaFecha = formato.format(fecha1);
/* 9424 */       String AA = cadenaFecha.substring(0, 4);
/* 9425 */       String MM = cadenaFecha.substring(4, 6);
/* 9426 */       String DD = cadenaFecha.substring(6, 8);
/* 9427 */       this.g2.drawString("Del " + DIA + "/" + MES + "/" + AÑO + " AL " + DD + "/" + MM + "/" + AA, 85, 137);
/*      */       
/* 9429 */       fecha1 = new Date();
/* 9430 */       formato = new SimpleDateFormat("yyyyMMdd");
/* 9431 */       cadenaFecha = "";
/* 9432 */       cadenaFecha = formato.format(fecha1);
/* 9433 */       AÑO = cadenaFecha.substring(0, 4);
/* 9434 */       MES = cadenaFecha.substring(4, 6);
/* 9435 */       DIA = cadenaFecha.substring(6, 8);
/* 9436 */       this.g2.drawString(DIA + "/" + DIA + "/" + MES, 540, 70);
/*      */       
/* 9438 */       fuente = new Font("Dialog", 0, 7);
/* 9439 */       this.g2.setFont(fuente);
/* 9440 */       this.g2.drawString("A continuación se enlistan todas las facturas en este periodo:", 25, 158);
/*      */     }
/*      */     
/*      */     public void recibeDatos() {
/* 9444 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 9445 */       job.setPrintable(this);
/*      */       
/* 9447 */       PageFormat pf = job.defaultPage();
/* 9448 */       Paper papel = pf.getPaper();
/* 9449 */       papel.setSize(612.0D, 792.0D);
/* 9450 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 9451 */       pf.setPaper(papel);
/* 9452 */       pf.setOrientation(1);
/* 9453 */       job.setPrintable(new ImprimirFacturas(), pf);
/* 9454 */       job.defaultPage(pf);
/*      */       
/* 9456 */       boolean ok = job.printDialog();
/* 9457 */       if (ok) {
/*      */         try {
/* 9459 */           job.print();
/* 9460 */         } catch (PrinterException printerException) {}
/*      */       }
/*      */     } }
/*      */ 
/*      */   
/*      */   public class Presionado
/*      */     implements Runnable
/*      */   {
/*      */     Thread t;
/* 9469 */     int cont = 0;
/*      */     
/*      */     public Presionado() {
/* 9472 */       this.t = new Thread(this);
/* 9473 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/*      */       try {
/* 9481 */         Thread.currentThread(); Thread.sleep(1000L);
/* 9482 */         detener();
/* 9483 */       } catch (InterruptedException interruptedException) {}
/*      */     }
/*      */ 
/*      */     
/*      */     public void detener() {
/* 9488 */       Facturas.this.consultarPartidas();
/* 9489 */       this.t.stop();
/*      */     }
/*      */     
/*      */     public void detenerFuera() {
/* 9493 */       this.t.stop();
/*      */     } }
/*      */   public class ImprimirConceptos implements Printable { int[] pageBreaks; String[] textLines; Graphics g2; int Pag; String[][] Lineas; int linesPerPage; int orientacion; double X; double Y; int YINICIA;
/*      */     int[] PXCOL;
/*      */     int NumLineas;
/*      */     int numBreaks;
/*      */     
/*      */     public ImprimirConceptos() {
/* 9501 */       this.g2 = null;
/* 9502 */       this.Pag = 0;
/*      */       
/* 9504 */       this.linesPerPage = 50;
/* 9505 */       this.orientacion = 0;
/* 9506 */       this.X = 0.0D;
/* 9507 */       this.Y = 0.0D;
/* 9508 */       this.YINICIA = 75;
/* 9509 */       this.PXCOL = new int[] { 36, 72, 110, 160, 240, 305, 370, 445, 505, 550, 580, 610, 640, 690 };
/* 9510 */       this.NumLineas = 0;
/* 9511 */       this.numBreaks = 0;
/*      */     }
/*      */ 
/*      */     
/*      */     private void initTextLines() {
/* 9516 */       if (this.textLines == null) {
/* 9517 */         int numLines = Facturas.this.jTable7.getRowCount();
/* 9518 */         this.textLines = new String[numLines];
/*      */       } 
/*      */     }
/*      */     
/*      */     public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/* 9523 */       Font font = new Font("Serif", 0, 8);
/* 9524 */       FontMetrics metrics = g.getFontMetrics(font);
/* 9525 */       int lineHeight = metrics.getHeight();
/* 9526 */       if (this.pageBreaks == null) {
/* 9527 */         initTextLines();
/* 9528 */         this.orientacion = pf.getOrientation();
/* 9529 */         if (pf.getOrientation() == 1) {
/* 9530 */           this.linesPerPage = 44;
/* 9531 */           this.X = pf.getWidth();
/* 9532 */           this.Y = pf.getHeight();
/*      */         } else {
/* 9534 */           this.linesPerPage = 38;
/* 9535 */           this.X = pf.getWidth();
/* 9536 */           this.Y = pf.getHeight();
/*      */         } 
/* 9538 */         this.numBreaks = (this.textLines.length - 1) / this.linesPerPage;
/* 9539 */         this.Pag = this.numBreaks;
/* 9540 */         this.pageBreaks = new int[this.numBreaks];
/* 9541 */         for (int b = 0; b < this.numBreaks; b++) {
/* 9542 */           this.pageBreaks[b] = (b + 1) * this.linesPerPage;
/*      */         }
/*      */       } 
/* 9545 */       if (pageIndex > this.pageBreaks.length) {
/* 9546 */         return 1;
/*      */       }
/* 9548 */       Graphics2D g2d = (Graphics2D)g;
/* 9549 */       this.g2 = g;
/* 9550 */       g2d.translate(pf.getImageableX(), 10.0D);
/* 9551 */       int start = (pageIndex == 0) ? 0 : this.pageBreaks[pageIndex - 1];
/* 9552 */       int end = (pageIndex == this.pageBreaks.length) ? this.textLines.length : this.pageBreaks[pageIndex];
/* 9553 */       encabezado();
/* 9554 */       int y = this.YINICIA;
/* 9555 */       int lineas = 0;
/*      */       
/* 9557 */       this.g2.drawRect(25, 160, 550, 12);
/* 9558 */       this.g2.setColor(new Color(204, 0, 0));
/* 9559 */       this.g2.fillRect(25, 161, 550, 10);
/*      */       
/* 9561 */       Font fuente = new Font("Dialog", 0, 7);
/* 9562 */       this.g2.setFont(fuente);
/* 9563 */       this.g2.setColor(Color.WHITE);
/* 9564 */       int[] valores = { 29, 70, 125, 190, 480, 520 };
/* 9565 */       this.g2.drawString("FACTURA", valores[0], 169);
/* 9566 */       this.g2.drawString("CANTIDAD", valores[1], 169);
/* 9567 */       this.g2.drawString("UNIDAD", valores[2], 169);
/* 9568 */       this.g2.drawString("DESCRIPCIÓN", valores[3], 169);
/* 9569 */       this.g2.drawString("P UNIT", valores[4], 169);
/* 9570 */       this.g2.drawString("IMPORTE", valores[5], 169);
/*      */       
/* 9572 */       this.g2.setColor(Color.BLACK);
/* 9573 */       y = 170;
/* 9574 */       for (int line = start; line < end; line++) {
/* 9575 */         y += 12;
/*      */         
/* 9577 */         String valor = "";
/* 9578 */         if (line < 9) {
/* 9579 */           valor = "0" + line + 1;
/*      */         } else {
/* 9581 */           valor = "" + line + 1;
/*      */         } 
/*      */         
/* 9584 */         this.g2.drawString(String.valueOf(Facturas.this.jTable7.getValueAt(line, 0)), valores[0], y - 2);
/* 9585 */         this.g2.drawString(String.valueOf(Facturas.this.jTable7.getValueAt(line, 1)), Facturas.this.alinearDer(valores[1] + 40, Facturas.this.jTable7.getValueAt(line, 1).toString().length()), y - 2);
/* 9586 */         this.g2.drawString(String.valueOf(Facturas.this.jTable7.getValueAt(line, 2)), valores[2], y - 2);
/* 9587 */         this.g2.drawString(String.valueOf(Facturas.this.jTable7.getValueAt(line, 3)), valores[3], y - 2);
/* 9588 */         pintar(valores[4] - 20, y + 2);
/* 9589 */         this.g2.drawString(String.valueOf(Facturas.this.jTable7.getValueAt(line, 4)), Facturas.this.alinearDer(valores[4] + 20, Facturas.this.jTable7.getValueAt(line, 4).toString().length()), y - 2);
/* 9590 */         pintar(valores[5], y + 2);
/* 9591 */         this.g2.drawString(String.valueOf(Facturas.this.jTable7.getValueAt(line, 5)), Facturas.this.alinearDer(valores[5] + 40, Facturas.this.jTable7.getValueAt(line, 5).toString().length()), y - 2);
/*      */       } 
/*      */       
/* 9594 */       g.drawString("Página " + pageIndex + 1, 540, 749);
/* 9595 */       if (this.Pag == pageIndex) {
/* 9596 */         this.g2.drawLine(20, y, 120, y);
/* 9597 */         this.g2.drawLine(465, y, 505, y);
/* 9598 */         this.g2.drawLine(525, y, 565, y);
/*      */         
/* 9600 */         fuente = new Font("Dialog", 1, 7);
/* 9601 */         this.g2.setFont(fuente);
/* 9602 */         g.drawString("SUMAS", 41, y + 10);
/* 9603 */         this.g2.drawString(Facturas.this.jLabel112.getText(), Facturas.this.alinearDer(valores[1] + 40, Facturas.this.jLabel12.getText().length()), y + 10);
/* 9604 */         this.g2.drawString(Facturas.this.jLabel70.getText(), Facturas.this.alinearDer(valores[4] + 20, Facturas.this.jLabel70.getText().length()), y + 10);
/* 9605 */         this.g2.drawString(Facturas.this.jLabel79.getText(), Facturas.this.alinearDer(valores[5] + 40, Facturas.this.jLabel79.getText().length()), y + 10);
/*      */         
/* 9607 */         fuente = new Font("Dialog", 1, 7);
/* 9608 */         this.g2.setFont(fuente);
/* 9609 */         this.g2.drawString("ELABORÓ", 190, 720);
/* 9610 */         this.g2.drawString("_____________________________________", 140, 752);
/* 9611 */         this.g2.drawString("NOMBRE Y FIRMA", 178, 765);
/*      */         
/* 9613 */         this.g2.drawString("RECIBE", 390, 720);
/* 9614 */         this.g2.drawString("_____________________________________", 340, 752);
/* 9615 */         this.g2.drawString("NOMBRE Y FIRMA", 378, 765);
/*      */       } 
/* 9617 */       return 0;
/*      */     }
/*      */     
/*      */     public void pintar(int x, int y) {
/* 9621 */       this.g2.setColor(Color.WHITE);
/* 9622 */       this.g2.fillRect(x, y - 10, 120, 10);
/* 9623 */       this.g2.setColor(Color.BLACK);
/*      */     }
/*      */     
/*      */     public void encabezado() {
/* 9627 */       Font fuente = new Font("Dialog", 0, 8);
/* 9628 */       this.g2.setFont(fuente);
/* 9629 */       this.g2.setColor(Color.BLACK);
/* 9630 */       ImageIcon imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis.png"));
/* 9631 */       Image img = imagen.getImage();
/* 9632 */       this.g2.drawImage(img, 518, 1, 57, 57, null);
/*      */       
/* 9634 */       imagen = new ImageIcon(getClass().getResource("/entrada/Imagenes/sicret2.png"));
/* 9635 */       img = imagen.getImage();
/* 9636 */       this.g2.drawImage(img, 27, 8, 60, 50, null);
/*      */       
/* 9638 */       fuente = new Font("Times New Roman", 1, 16);
/* 9639 */       this.g2.setFont(fuente);
/* 9640 */       this.g2.drawString("FLETES Y MATERIALES FORSIS S.A. DE C.V.", 135, 20);
/*      */ 
/*      */       
/* 9643 */       fuente = new Font("Dialog", 0, 12);
/* 9644 */       this.g2.setFont(fuente);
/* 9645 */       this.g2.drawString("IMPRESIÓN DE CONCEPTOS", 220, 37);
/* 9646 */       this.g2.drawLine(25, 60, 575, 60);
/*      */       
/* 9648 */       this.g2.setColor(Color.BLACK);
/* 9649 */       this.g2.drawLine(25, 83, 220, 83);
/* 9650 */       this.g2.drawLine(25, 143, 220, 143);
/*      */       
/* 9652 */       fuente = new Font("Dialog", 1, 8);
/* 9653 */       this.g2.setFont(fuente);
/* 9654 */       this.g2.setColor(Color.BLACK);
/* 9655 */       this.g2.drawString("INFORMACIÓN DEL REPORTE", 25, 80);
/*      */       
/* 9657 */       fuente = new Font("Dialog", 1, 7);
/* 9658 */       this.g2.setFont(fuente);
/* 9659 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 9661 */       this.g2.drawString("Cliente: ", 27, 93);
/* 9662 */       this.g2.drawString("Equipo: ", 27, 104);
/* 9663 */       this.g2.drawString("Plataforma: ", 27, 115);
/* 9664 */       this.g2.drawString("Pozo: ", 27, 126);
/* 9665 */       this.g2.drawString("Periodo: ", 27, 137);
/*      */       
/* 9667 */       fuente = new Font("Dialog", 0, 7);
/* 9668 */       this.g2.setFont(fuente);
/* 9669 */       this.g2.setColor(Color.BLACK);
/*      */       
/* 9671 */       this.g2.drawString(String.valueOf(Facturas.this.jComboBox3.getSelectedItem()), 85, 93);
/* 9672 */       this.g2.drawString(String.valueOf(Facturas.this.jComboBox5.getSelectedItem()), 85, 104);
/* 9673 */       this.g2.drawString(String.valueOf(Facturas.this.jComboBox6.getSelectedItem()), 85, 115);
/* 9674 */       this.g2.drawString(String.valueOf(Facturas.this.jComboBox7.getSelectedItem()), 85, 126);
/*      */       
/* 9676 */       Date fecha1 = Facturas.this.jDateChooser4.getDate();
/* 9677 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 9678 */       String cadenaFecha = "";
/* 9679 */       cadenaFecha = formato.format(fecha1);
/* 9680 */       String AÑO = cadenaFecha.substring(0, 4);
/* 9681 */       String MES = cadenaFecha.substring(4, 6);
/* 9682 */       String DIA = cadenaFecha.substring(6, 8);
/*      */       
/* 9684 */       fecha1 = Facturas.this.jDateChooser5.getDate();
/* 9685 */       formato = new SimpleDateFormat("yyyyMMdd");
/* 9686 */       cadenaFecha = "";
/* 9687 */       cadenaFecha = formato.format(fecha1);
/* 9688 */       String AA = cadenaFecha.substring(0, 4);
/* 9689 */       String MM = cadenaFecha.substring(4, 6);
/* 9690 */       String DD = cadenaFecha.substring(6, 8);
/* 9691 */       this.g2.drawString("Del " + DIA + "/" + MES + "/" + AÑO + " AL " + DD + "/" + MM + "/" + AA, 85, 137);
/*      */       
/* 9693 */       fecha1 = new Date();
/* 9694 */       formato = new SimpleDateFormat("yyyyMMdd");
/* 9695 */       cadenaFecha = "";
/* 9696 */       cadenaFecha = formato.format(fecha1);
/* 9697 */       AÑO = cadenaFecha.substring(0, 4);
/* 9698 */       MES = cadenaFecha.substring(4, 6);
/* 9699 */       DIA = cadenaFecha.substring(6, 8);
/* 9700 */       this.g2.drawString(DIA + "/" + DIA + "/" + MES, 540, 70);
/*      */       
/* 9702 */       fuente = new Font("Dialog", 0, 7);
/* 9703 */       this.g2.setFont(fuente);
/* 9704 */       this.g2.drawString("A continuación se enlistan todos los conceptos en este periodo:", 25, 158);
/*      */     }
/*      */     
/*      */     public void recibeDatos() {
/* 9708 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 9709 */       job.setPrintable(this);
/*      */       
/* 9711 */       PageFormat pf = job.defaultPage();
/* 9712 */       Paper papel = pf.getPaper();
/* 9713 */       papel.setSize(612.0D, 792.0D);
/* 9714 */       papel.setImageableArea(12.0D, 92.0D, 612.0D, 792.0D);
/* 9715 */       pf.setPaper(papel);
/* 9716 */       pf.setOrientation(1);
/* 9717 */       job.setPrintable(new ImprimirConceptos(), pf);
/* 9718 */       job.defaultPage(pf);
/*      */       
/* 9720 */       boolean ok = job.printDialog();
/* 9721 */       if (ok)
/*      */         try {
/* 9723 */           job.print();
/* 9724 */         } catch (PrinterException printerException) {} 
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/Facturas.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */