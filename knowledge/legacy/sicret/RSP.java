/*      */ package sicret;
/*      */ import com.toedter.calendar.JDateChooser;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
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
/*      */ import java.text.ParseException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ 
/*      */ public class RSP extends JPanel {
/*      */   Border borde;
/*      */   Color color;
/*      */   JScrollPane panel;
/*   37 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   38 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   39 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*   40 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   41 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   42 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   43 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   44 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   String USUARIO;
/*   46 */   Validaciones val = new Validaciones();
/*   47 */   Consultas con = new Consultas();
/*   48 */   Errores error = new Errores(false);
/*      */   boolean encontrado;
/*      */   JTabbedPane fichas;
/*      */   AltaOperador operador;
/*   52 */   int contador = 0;
/*      */   JFrame padre;
/*      */   EscribirReporte esc;
/*   55 */   Date fechaActual = new Date();
/*   56 */   Date fecha = new Date();
/*   57 */   Date fechaInicio = null;
/*   58 */   Date fechaTermino = null;
/*   59 */   Date fechaMinimo = null;
/*   60 */   CeldaRender celda = new CeldaRender();
/*   61 */   String CLAVEOP = "";
/*      */   String[] operadores;
/*   63 */   String NOMBRE = "";
/*   64 */   String[] GUIAS = new String[10];
/*   65 */   String CLAVE = "";
/*      */   boolean CONCEPTO = false;
/*   67 */   int INDICE = 0;
/*   68 */   String[] DATOS = null;
/*   69 */   String TIPOTRACTOR = "";
/*   70 */   Presionado presionado = null; private JButton jButton11; private JButton jButton14; private JButton jButton15; private JButton jButton16; private JButton jButton17; private JButton jButton3; private JButton jButton4; private JButton jButton5; private JButton jButton6; private JCheckBox jCheckBox1; private JComboBox jComboBox1; private JComboBox jComboBox17; private JComboBox jComboBox18; private JComboBox jComboBox19; private JComboBox jComboBox20; private JComboBox jComboBox22; private JComboBox jComboBox23; private JDateChooser jDateChooser1; private JDateChooser jDateChooser2; private JDateChooser jDateChooser3; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDateChooser jDateChooser6; private JDateChooser jDateChooser7; private JDateChooser jDateChooser8; private JDateChooser jDateChooser9; private JDialog jDialog1; private JDialog jDialog2; private JLabel jLabel10; private JLabel jLabel100; private JLabel jLabel101; private JLabel jLabel102; private JLabel jLabel103; private JLabel jLabel104; private JLabel jLabel105; private JLabel jLabel106; private JLabel jLabel107;
/*   71 */   String[] CLAVEOPERADOR = null; private JLabel jLabel108; private JLabel jLabel109; private JLabel jLabel11; private JLabel jLabel110; private JLabel jLabel111; private JLabel jLabel12; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel3; private JLabel jLabel4; private JLabel jLabel46; private JLabel jLabel48; private JLabel jLabel5; private JLabel jLabel56; private JLabel jLabel59; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel68; private JLabel jLabel69; private JLabel jLabel7; private JLabel jLabel70; private JLabel jLabel71; private JLabel jLabel72; private JLabel jLabel73; private JLabel jLabel74; private JLabel jLabel75; private JLabel jLabel76; private JLabel jLabel77; private JLabel jLabel78;
/*      */   
/*      */   public RSP(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre) {
/*   74 */     initComponents();
/*   75 */     String año = "2010";
/*   76 */     String mes = "03";
/*   77 */     String dia = "01";
/*   78 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*   79 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*   81 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*   82 */     } catch (ParseException ex) {
/*   83 */       ex.printStackTrace();
/*      */     } 
/*   85 */     this.padre = padre;
/*   86 */     this.fichas = fichas;
/*   87 */     initComponents();
/*   88 */     this.USUARIO = USUARIO;
/*   89 */     panelito.setViewportView(this);
/*   90 */     this.panel = panelito;
/*      */     
/*   92 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*   93 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*   94 */     this.jLabel7.setCursor(micursor);
/*   95 */     this.jLabel8.setCursor(micursor);
/*   96 */     this.jLabel9.setCursor(micursor);
/*   97 */     colorear();
/*   98 */     consultar();
/*      */     
/*  100 */     int w = this.tama.width;
/*  101 */     int h = this.tama.height;
/*  102 */     int rw = (w - 505) / 2;
/*  103 */     int rh = (h - 680) / 2;
/*  104 */     this.jDialog1.setLocation(rw, rh);
/*  105 */     this.jDialog1.setSize(505, 680);
/*  106 */     this.jDialog1.setVisible(false);
/*  107 */     this.jDialog1.setResizable(false);
/*      */     
/*  109 */     w = this.tama.width;
/*  110 */     h = this.tama.height;
/*  111 */     rw = (w - 505) / 2;
/*  112 */     rh = (h - 680) / 2;
/*  113 */     this.jDialog2.setLocation(rw, rh);
/*  114 */     this.jDialog2.setSize(505, 680);
/*  115 */     this.jDialog2.setVisible(false);
/*  116 */     this.jDialog2.setResizable(false);
/*      */     
/*  118 */     cargarMouse();
/*      */     
/*  120 */     this.con.consultar("nombre", "usuarios,empleados", "where empleados.clave_emp = usuarios.num_emp and nombre_usu = '" + USUARIO + "'");
/*  121 */     this.NOMBRE = this.con.Campo;
/*  122 */     this.con.consultar("ap_pat", "usuarios,empleados", "where empleados.clave_emp = usuarios.num_emp and nombre_usu = '" + USUARIO + "'");
/*  123 */     this.NOMBRE = this.NOMBRE + " " + this.NOMBRE;
/*  124 */     this.con.consultar("ap_mat", "usuarios,empleados", "where empleados.clave_emp = usuarios.num_emp and nombre_usu = '" + USUARIO + "'");
/*  125 */     this.NOMBRE = this.NOMBRE + " " + this.NOMBRE;
/*  126 */     this.jLabel83.setText(this.NOMBRE);
/*  127 */     llenarCombo();
/*      */   }
/*      */   private JLabel jLabel79; private JLabel jLabel8; private JLabel jLabel80; private JLabel jLabel81; private JLabel jLabel82; private JLabel jLabel83; private JLabel jLabel84; private JLabel jLabel85; private JLabel jLabel86; private JLabel jLabel87; private JLabel jLabel88; private JLabel jLabel89; private JLabel jLabel9; private JLabel jLabel90; private JLabel jLabel91; private JLabel jLabel92; private JLabel jLabel93; private JLabel jLabel94; private JLabel jLabel95; private JLabel jLabel96; private JLabel jLabel97; private JLabel jLabel98; private JLabel jLabel99; private JPanel jPanel10; private JPanel jPanel11; private JPanel jPanel12; private JPanel jPanel13; private JPanel jPanel14; private JPanel jPanel15; private JPanel jPanel16; private JPanel jPanel17; private JPanel jPanel18; private JPanel jPanel2; private JPanel jPanel3; private JPanel jPanel4; private JPanel jPanel6; private JPanel jPanel7; private JPanel jPanel8; private JPanel jPanel9; private JScrollPane jScrollPane2; private JSeparator jSeparator1; private JSeparator jSeparator2; private JTable jTable2; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField12; private JTextField jTextField13; private JTextField jTextField14; private JTextField jTextField16; private JTextField jTextField17; private JTextField jTextField18; private JTextField jTextField19; private JTextField jTextField2; private JTextField jTextField20; private JTextField jTextField21; private JTextField jTextField22; private JTextField jTextField23; private JTextField jTextField24; private JTextField jTextField25; private JTextField jTextField26; private JTextField jTextField27; private JTextField jTextField28; private JTextField jTextField29; private JTextField jTextField3; private JTextField jTextField30; private JTextField jTextField31; private JTextField jTextField32; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8;
/*      */   private JTextField jTextField9;
/*      */   
/*      */   private void initComponents() {
/*  133 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  134 */     this.jPanel9 = new JPanel();
/*  135 */     this.jLabel64 = new JLabel();
/*  136 */     this.jLabel67 = new JLabel();
/*  137 */     this.jTextField5 = new JTextField();
/*  138 */     this.jLabel10 = new JLabel();
/*  139 */     this.jPanel3 = new JPanel();
/*  140 */     this.jLabel68 = new JLabel();
/*  141 */     this.jTextField8 = new JTextField();
/*  142 */     this.jLabel75 = new JLabel();
/*  143 */     this.jTextField19 = new JTextField();
/*  144 */     this.jLabel76 = new JLabel();
/*  145 */     this.jTextField23 = new JTextField();
/*  146 */     this.jLabel86 = new JLabel();
/*  147 */     this.jComboBox19 = new JComboBox();
/*  148 */     this.jTextField9 = new JTextField();
/*  149 */     this.jLabel71 = new JLabel();
/*  150 */     this.jPanel7 = new JPanel();
/*  151 */     this.jLabel72 = new JLabel();
/*  152 */     this.jDateChooser1 = new JDateChooser();
/*  153 */     this.jLabel73 = new JLabel();
/*  154 */     this.jDateChooser3 = new JDateChooser();
/*  155 */     this.jLabel88 = new JLabel();
/*  156 */     this.jDateChooser6 = new JDateChooser();
/*  157 */     this.jPanel8 = new JPanel();
/*  158 */     this.jLabel65 = new JLabel();
/*  159 */     this.jTextField10 = new JTextField();
/*  160 */     this.jLabel69 = new JLabel();
/*  161 */     this.jTextField11 = new JTextField();
/*  162 */     this.jLabel74 = new JLabel();
/*  163 */     this.jComboBox17 = new JComboBox();
/*  164 */     this.jLabel78 = new JLabel();
/*  165 */     this.jTextField17 = new JTextField();
/*  166 */     this.jLabel79 = new JLabel();
/*  167 */     this.jTextField18 = new JTextField();
/*  168 */     this.jLabel70 = new JLabel();
/*  169 */     this.jTextField12 = new JTextField();
/*  170 */     this.jPanel10 = new JPanel();
/*  171 */     this.jLabel80 = new JLabel();
/*  172 */     this.jTextField24 = new JTextField();
/*  173 */     this.jLabel85 = new JLabel();
/*  174 */     this.jTextField25 = new JTextField();
/*  175 */     this.jLabel87 = new JLabel();
/*  176 */     this.jTextField13 = new JTextField();
/*  177 */     this.jLabel77 = new JLabel();
/*  178 */     this.jComboBox18 = new JComboBox();
/*  179 */     this.jSeparator1 = new JSeparator();
/*  180 */     this.jPanel11 = new JPanel();
/*  181 */     this.jLabel11 = new JLabel();
/*  182 */     this.jLabel12 = new JLabel();
/*  183 */     this.jLabel81 = new JLabel();
/*  184 */     this.jLabel82 = new JLabel();
/*  185 */     this.jLabel83 = new JLabel();
/*  186 */     this.jLabel84 = new JLabel();
/*  187 */     this.jButton15 = new JButton();
/*  188 */     this.jButton14 = new JButton();
/*  189 */     this.jCheckBox1 = new JCheckBox();
/*  190 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  191 */     this.jPanel12 = new JPanel();
/*  192 */     this.jLabel66 = new JLabel();
/*  193 */     this.jLabel89 = new JLabel();
/*  194 */     this.jTextField14 = new JTextField();
/*  195 */     this.jLabel13 = new JLabel();
/*  196 */     this.jPanel4 = new JPanel();
/*  197 */     this.jLabel90 = new JLabel();
/*  198 */     this.jLabel91 = new JLabel();
/*  199 */     this.jTextField20 = new JTextField();
/*  200 */     this.jLabel92 = new JLabel();
/*  201 */     this.jTextField26 = new JTextField();
/*  202 */     this.jLabel93 = new JLabel();
/*  203 */     this.jComboBox20 = new JComboBox();
/*  204 */     this.jComboBox23 = new JComboBox();
/*  205 */     this.jTextField16 = new JTextField();
/*  206 */     this.jLabel94 = new JLabel();
/*  207 */     this.jPanel13 = new JPanel();
/*  208 */     this.jLabel95 = new JLabel();
/*  209 */     this.jDateChooser2 = new JDateChooser();
/*  210 */     this.jLabel96 = new JLabel();
/*  211 */     this.jDateChooser7 = new JDateChooser();
/*  212 */     this.jLabel97 = new JLabel();
/*  213 */     this.jDateChooser8 = new JDateChooser();
/*  214 */     this.jPanel14 = new JPanel();
/*  215 */     this.jLabel98 = new JLabel();
/*  216 */     this.jTextField21 = new JTextField();
/*  217 */     this.jLabel99 = new JLabel();
/*  218 */     this.jTextField22 = new JTextField();
/*  219 */     this.jLabel100 = new JLabel();
/*  220 */     this.jLabel101 = new JLabel();
/*  221 */     this.jTextField27 = new JTextField();
/*  222 */     this.jLabel102 = new JLabel();
/*  223 */     this.jTextField28 = new JTextField();
/*  224 */     this.jTextField29 = new JTextField();
/*  225 */     this.jLabel103 = new JLabel();
/*  226 */     this.jPanel15 = new JPanel();
/*  227 */     this.jLabel104 = new JLabel();
/*  228 */     this.jTextField30 = new JTextField();
/*  229 */     this.jLabel105 = new JLabel();
/*  230 */     this.jTextField31 = new JTextField();
/*  231 */     this.jLabel106 = new JLabel();
/*  232 */     this.jTextField32 = new JTextField();
/*  233 */     this.jLabel107 = new JLabel();
/*  234 */     this.jComboBox22 = new JComboBox();
/*  235 */     this.jSeparator2 = new JSeparator();
/*  236 */     this.jPanel16 = new JPanel();
/*  237 */     this.jLabel14 = new JLabel();
/*  238 */     this.jLabel19 = new JLabel();
/*  239 */     this.jLabel108 = new JLabel();
/*  240 */     this.jLabel109 = new JLabel();
/*  241 */     this.jLabel110 = new JLabel();
/*  242 */     this.jLabel111 = new JLabel();
/*  243 */     this.jButton16 = new JButton();
/*  244 */     this.jButton17 = new JButton();
/*  245 */     this.jDateChooser9 = new JDateChooser();
/*  246 */     this.jPanel6 = new JPanel();
/*  247 */     this.jLabel3 = new JLabel();
/*  248 */     this.jPanel2 = new JPanel();
/*  249 */     this.jButton3 = new JButton();
/*  250 */     this.jLabel4 = new JLabel();
/*  251 */     this.jLabel5 = new JLabel();
/*  252 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  253 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  254 */     this.jLabel7 = new JLabel();
/*  255 */     this.jLabel8 = new JLabel();
/*  256 */     this.jLabel9 = new JLabel();
/*  257 */     this.jPanel17 = new JPanel();
/*  258 */     this.jTextField1 = new JTextField();
/*  259 */     this.jLabel15 = new JLabel();
/*  260 */     this.jLabel56 = new JLabel();
/*  261 */     this.jTextField3 = new JTextField();
/*  262 */     this.jTextField6 = new JTextField();
/*  263 */     this.jLabel16 = new JLabel();
/*  264 */     this.jComboBox1 = new JComboBox();
/*  265 */     this.jLabel46 = new JLabel();
/*  266 */     this.jTextField4 = new JTextField();
/*  267 */     this.jLabel59 = new JLabel();
/*  268 */     this.jLabel17 = new JLabel();
/*  269 */     this.jTextField2 = new JTextField();
/*  270 */     this.jTextField7 = new JTextField();
/*  271 */     this.jLabel18 = new JLabel();
/*  272 */     this.jPanel18 = new JPanel();
/*  273 */     this.jScrollPane2 = new JScrollPane();
/*  274 */     this.jTable2 = new JTable();
/*  275 */     this.jLabel48 = new JLabel();
/*  276 */     this.jButton4 = new JButton();
/*  277 */     this.jButton5 = new JButton();
/*  278 */     this.jButton11 = new JButton();
/*  279 */     this.jButton6 = new JButton();
/*      */     
/*  281 */     this.jDialog1.setTitle("Recepción de Documentos");
/*  282 */     this.jDialog1.setModal(true);
/*      */     
/*  284 */     this.jPanel9.setBackground(new Color(146, 193, 134));
/*      */     
/*  286 */     this.jLabel64.setFont(new Font("Tahoma", 1, 18));
/*  287 */     this.jLabel64.setForeground(new Color(0, 102, 102));
/*  288 */     this.jLabel64.setHorizontalAlignment(0);
/*  289 */     this.jLabel64.setText("RECEPCIÓN DE DOCUMENTOS");
/*      */     
/*  291 */     this.jLabel67.setFont(new Font("Tahoma", 3, 11));
/*  292 */     this.jLabel67.setForeground(new Color(15, 87, 51));
/*  293 */     this.jLabel67.setHorizontalAlignment(4);
/*  294 */     this.jLabel67.setText("Guía");
/*      */     
/*  296 */     this.jTextField5.setEditable(false);
/*  297 */     this.jTextField5.setFont(new Font("Tahoma", 1, 14));
/*  298 */     this.jTextField5.setForeground(Color.red);
/*  299 */     this.jTextField5.setHorizontalAlignment(0);
/*      */     
/*  301 */     this.jLabel10.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis75.png")));
/*      */     
/*  303 */     this.jPanel3.setBackground(new Color(146, 193, 134));
/*  304 */     this.jPanel3.setBorder(BorderFactory.createTitledBorder("Datos Personales"));
/*      */     
/*  306 */     this.jLabel68.setFont(new Font("Tahoma", 3, 11));
/*  307 */     this.jLabel68.setForeground(new Color(15, 87, 51));
/*  308 */     this.jLabel68.setHorizontalAlignment(4);
/*  309 */     this.jLabel68.setText("Cargada por");
/*      */     
/*  311 */     this.jTextField8.setEnabled(false);
/*      */     
/*  313 */     this.jLabel75.setFont(new Font("Tahoma", 3, 11));
/*  314 */     this.jLabel75.setForeground(new Color(15, 87, 51));
/*  315 */     this.jLabel75.setHorizontalAlignment(4);
/*  316 */     this.jLabel75.setText("Económico");
/*      */     
/*  318 */     this.jTextField19.setEnabled(false);
/*      */     
/*  320 */     this.jLabel76.setFont(new Font("Tahoma", 3, 11));
/*  321 */     this.jLabel76.setForeground(new Color(15, 87, 51));
/*  322 */     this.jLabel76.setHorizontalAlignment(4);
/*  323 */     this.jLabel76.setText("Remolque");
/*      */     
/*  325 */     this.jTextField23.setEnabled(false);
/*      */     
/*  327 */     this.jLabel86.setFont(new Font("Tahoma", 3, 11));
/*  328 */     this.jLabel86.setForeground(new Color(15, 87, 51));
/*  329 */     this.jLabel86.setHorizontalAlignment(4);
/*  330 */     this.jLabel86.setText("Tirada por");
/*      */     
/*  332 */     this.jComboBox19.setBackground(new Color(244, 244, 244));
/*  333 */     this.jComboBox19.setEnabled(false);
/*  334 */     this.jComboBox19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  336 */             RSP.this.jComboBox19ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  340 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  341 */     this.jPanel3.setLayout(jPanel3Layout);
/*  342 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/*  343 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  344 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  345 */           .addContainerGap()
/*  346 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  347 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  348 */               .addGap(10, 10, 10)
/*  349 */               .addComponent(this.jLabel86, -2, 69, -2)
/*  350 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  351 */               .addComponent(this.jComboBox19, 0, -1, 32767))
/*  352 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  353 */               .addComponent(this.jLabel68, -2, 84, -2)
/*  354 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  355 */               .addComponent(this.jTextField8))
/*  356 */             .addGroup(jPanel3Layout.createSequentialGroup()
/*  357 */               .addComponent(this.jLabel75, -2, 81, -2)
/*  358 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  359 */               .addComponent(this.jTextField19, -2, 78, -2)
/*  360 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  361 */               .addComponent(this.jLabel76, -2, 68, -2)
/*  362 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  363 */               .addComponent(this.jTextField23, -2, 85, -2)))
/*  364 */           .addContainerGap(-1, 32767)));
/*      */     
/*  366 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/*  367 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  368 */         .addGroup(jPanel3Layout.createSequentialGroup()
/*  369 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  370 */             .addComponent(this.jLabel68)
/*  371 */             .addComponent(this.jTextField8, -2, -1, -2))
/*  372 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 7, 32767)
/*  373 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  374 */             .addComponent(this.jLabel86)
/*  375 */             .addComponent(this.jComboBox19, -2, -1, -2))
/*  376 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  377 */           .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  378 */             .addComponent(this.jLabel75)
/*  379 */             .addComponent(this.jLabel76)
/*  380 */             .addComponent(this.jTextField23, -2, -1, -2)
/*  381 */             .addComponent(this.jTextField19, -2, -1, -2))));
/*      */ 
/*      */     
/*  384 */     this.jTextField9.setEditable(false);
/*  385 */     this.jTextField9.setFont(new Font("Tahoma", 1, 13));
/*  386 */     this.jTextField9.setForeground(Color.red);
/*  387 */     this.jTextField9.setHorizontalAlignment(0);
/*      */     
/*  389 */     this.jLabel71.setFont(new Font("Tahoma", 3, 11));
/*  390 */     this.jLabel71.setForeground(new Color(15, 87, 51));
/*  391 */     this.jLabel71.setHorizontalAlignment(4);
/*  392 */     this.jLabel71.setText("Folio");
/*      */     
/*  394 */     this.jPanel7.setBackground(new Color(146, 193, 134));
/*  395 */     this.jPanel7.setBorder(BorderFactory.createTitledBorder("Fechas"));
/*      */     
/*  397 */     this.jLabel72.setFont(new Font("Tahoma", 3, 11));
/*  398 */     this.jLabel72.setForeground(new Color(15, 87, 51));
/*  399 */     this.jLabel72.setHorizontalAlignment(0);
/*  400 */     this.jLabel72.setText("Fecha de Llegada");
/*      */     
/*  402 */     this.jDateChooser1.setDate(this.fechaActual);
/*  403 */     this.jDateChooser1.setDateFormatString("dd-MM-yyyy");
/*  404 */     this.jDateChooser1.setEnabled(false);
/*  405 */     this.jDateChooser1.setMaxSelectableDate(this.fechaActual);
/*  406 */     this.jDateChooser1.setMinSelectableDate(this.fechaInicio);
/*      */     
/*  408 */     this.jLabel73.setFont(new Font("Tahoma", 3, 11));
/*  409 */     this.jLabel73.setForeground(new Color(15, 87, 51));
/*  410 */     this.jLabel73.setHorizontalAlignment(0);
/*  411 */     this.jLabel73.setText("Fecha de Carga");
/*      */     
/*  413 */     this.jDateChooser3.setDate(this.fechaActual);
/*  414 */     this.jDateChooser3.setDateFormatString("dd-MM-yyyy");
/*  415 */     this.jDateChooser3.setEnabled(false);
/*  416 */     this.jDateChooser3.setMaxSelectableDate(this.fechaActual);
/*      */     
/*  418 */     this.jLabel88.setFont(new Font("Tahoma", 3, 11));
/*  419 */     this.jLabel88.setForeground(new Color(15, 87, 51));
/*  420 */     this.jLabel88.setHorizontalAlignment(0);
/*  421 */     this.jLabel88.setText("Fecha de Salida");
/*      */     
/*  423 */     this.jDateChooser6.setDate(this.fechaActual);
/*  424 */     this.jDateChooser6.setDateFormatString("dd-MM-yyyy");
/*  425 */     this.jDateChooser6.setEnabled(false);
/*  426 */     this.jDateChooser6.setMaxSelectableDate(this.fechaActual);
/*      */     
/*  428 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  429 */     this.jPanel7.setLayout(jPanel7Layout);
/*  430 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout
/*  431 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  432 */         .addGroup(jPanel7Layout.createSequentialGroup()
/*  433 */           .addContainerGap()
/*  434 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  435 */             .addComponent(this.jLabel72, -1, -1, 32767)
/*  436 */             .addComponent((Component)this.jDateChooser1, -1, 133, 32767))
/*  437 */           .addGap(18, 18, 18)
/*  438 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  439 */             .addComponent(this.jLabel73, -1, -1, 32767)
/*  440 */             .addComponent((Component)this.jDateChooser6, -1, 142, 32767))
/*  441 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  442 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  443 */             .addComponent(this.jLabel88, -1, -1, 32767)
/*  444 */             .addComponent((Component)this.jDateChooser3, -2, 111, -2))
/*  445 */           .addContainerGap()));
/*      */     
/*  447 */     jPanel7Layout.setVerticalGroup(jPanel7Layout
/*  448 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  449 */         .addGroup(jPanel7Layout.createSequentialGroup()
/*  450 */           .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  451 */             .addGroup(jPanel7Layout.createSequentialGroup()
/*  452 */               .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  453 */                 .addComponent(this.jLabel72)
/*  454 */                 .addComponent(this.jLabel73, -1, -1, 32767))
/*  455 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  456 */               .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  457 */                 .addComponent((Component)this.jDateChooser1, -2, -1, -2)
/*  458 */                 .addComponent((Component)this.jDateChooser6, -2, -1, -2)))
/*  459 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
/*  460 */               .addComponent(this.jLabel88, -1, -1, 32767)
/*  461 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  462 */               .addComponent((Component)this.jDateChooser3, -2, -1, -2)))
/*  463 */           .addContainerGap()));
/*      */ 
/*      */     
/*  466 */     this.jPanel8.setBackground(new Color(146, 193, 134));
/*  467 */     this.jPanel8.setBorder(BorderFactory.createTitledBorder("Origen y Destino"));
/*      */     
/*  469 */     this.jLabel65.setFont(new Font("Tahoma", 3, 11));
/*  470 */     this.jLabel65.setForeground(new Color(15, 87, 51));
/*  471 */     this.jLabel65.setHorizontalAlignment(4);
/*  472 */     this.jLabel65.setText("Origen");
/*      */     
/*  474 */     this.jTextField10.setEnabled(false);
/*      */     
/*  476 */     this.jLabel69.setFont(new Font("Tahoma", 3, 11));
/*  477 */     this.jLabel69.setForeground(new Color(15, 87, 51));
/*  478 */     this.jLabel69.setHorizontalAlignment(4);
/*  479 */     this.jLabel69.setText("Cliente");
/*      */     
/*  481 */     this.jTextField11.setEnabled(false);
/*      */     
/*  483 */     this.jLabel74.setFont(new Font("Tahoma", 3, 11));
/*  484 */     this.jLabel74.setForeground(new Color(15, 87, 51));
/*  485 */     this.jLabel74.setHorizontalAlignment(4);
/*  486 */     this.jLabel74.setText("Destino");
/*      */     
/*  488 */     this.jComboBox17.setBackground(new Color(244, 244, 244));
/*  489 */     this.jComboBox17.setEnabled(false);
/*      */     
/*  491 */     this.jLabel78.setFont(new Font("Tahoma", 3, 11));
/*  492 */     this.jLabel78.setForeground(new Color(15, 87, 51));
/*  493 */     this.jLabel78.setHorizontalAlignment(4);
/*  494 */     this.jLabel78.setText("Ticket");
/*      */     
/*  496 */     this.jTextField17.setEnabled(false);
/*      */     
/*  498 */     this.jLabel79.setFont(new Font("Tahoma", 3, 11));
/*  499 */     this.jLabel79.setForeground(new Color(15, 87, 51));
/*  500 */     this.jLabel79.setHorizontalAlignment(4);
/*  501 */     this.jLabel79.setText("Peso Neto");
/*      */     
/*  503 */     this.jTextField18.setEnabled(false);
/*      */     
/*  505 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  506 */     this.jPanel8.setLayout(jPanel8Layout);
/*  507 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/*  508 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  509 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  510 */           .addContainerGap()
/*  511 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  512 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  513 */               .addGap(29, 29, 29)
/*  514 */               .addComponent(this.jLabel69, -2, 50, -2)
/*  515 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  516 */               .addComponent(this.jTextField11))
/*  517 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  518 */               .addComponent(this.jLabel65, -2, 79, -2)
/*  519 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  520 */               .addComponent(this.jTextField10))
/*  521 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  522 */               .addComponent(this.jLabel74, -2, 79, -2)
/*  523 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  524 */               .addComponent(this.jComboBox17, -2, 269, -2))
/*  525 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  526 */               .addComponent(this.jLabel78, -2, 79, -2)
/*  527 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  528 */               .addComponent(this.jTextField17, -2, 91, -2)
/*  529 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  530 */               .addComponent(this.jLabel79, -2, 79, -2)
/*  531 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  532 */               .addComponent(this.jTextField18, -2, 91, -2)))
/*  533 */           .addGap(72, 72, 72)));
/*      */     
/*  535 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/*  536 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  537 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  538 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  539 */             .addComponent(this.jLabel65)
/*  540 */             .addComponent(this.jTextField10, -2, -1, -2))
/*  541 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  542 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  543 */             .addComponent(this.jLabel69)
/*  544 */             .addComponent(this.jTextField11, -2, -1, -2))
/*  545 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  546 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  547 */             .addComponent(this.jLabel74)
/*  548 */             .addComponent(this.jComboBox17, -2, -1, -2))
/*  549 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  550 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  551 */             .addComponent(this.jLabel78)
/*  552 */             .addComponent(this.jTextField17, -2, -1, -2)
/*  553 */             .addComponent(this.jLabel79)
/*  554 */             .addComponent(this.jTextField18, -2, -1, -2))));
/*      */ 
/*      */     
/*  557 */     this.jLabel70.setFont(new Font("Tahoma", 3, 11));
/*  558 */     this.jLabel70.setForeground(new Color(15, 87, 51));
/*  559 */     this.jLabel70.setHorizontalAlignment(4);
/*  560 */     this.jLabel70.setText("Fecha");
/*      */     
/*  562 */     this.jTextField12.setEditable(false);
/*  563 */     this.jTextField12.setFont(new Font("Tahoma", 1, 12));
/*  564 */     this.jTextField12.setForeground(Color.red);
/*      */     
/*  566 */     this.jPanel10.setBackground(new Color(146, 193, 134));
/*  567 */     this.jPanel10.setBorder(BorderFactory.createTitledBorder("Otros Datos"));
/*      */     
/*  569 */     this.jLabel80.setFont(new Font("Tahoma", 2, 11));
/*  570 */     this.jLabel80.setForeground(new Color(15, 87, 51));
/*  571 */     this.jLabel80.setHorizontalAlignment(4);
/*  572 */     this.jLabel80.setText("  No. RSP");
/*      */     
/*  574 */     this.jTextField24.setEnabled(false);
/*      */     
/*  576 */     this.jLabel85.setFont(new Font("Tahoma", 2, 11));
/*  577 */     this.jLabel85.setForeground(new Color(15, 87, 51));
/*  578 */     this.jLabel85.setHorizontalAlignment(4);
/*  579 */     this.jLabel85.setText("Estadías");
/*      */     
/*  581 */     this.jTextField25.setEnabled(false);
/*      */     
/*  583 */     this.jLabel87.setFont(new Font("Tahoma", 2, 11));
/*  584 */     this.jLabel87.setForeground(new Color(15, 87, 51));
/*  585 */     this.jLabel87.setHorizontalAlignment(4);
/*  586 */     this.jLabel87.setText("Mov. Inter.");
/*      */     
/*  588 */     this.jTextField13.setEnabled(false);
/*      */     
/*  590 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/*  591 */     this.jPanel10.setLayout(jPanel10Layout);
/*  592 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/*  593 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  594 */         .addGroup(jPanel10Layout.createSequentialGroup()
/*  595 */           .addComponent(this.jLabel80)
/*  596 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  597 */           .addComponent(this.jTextField24, -2, 71, -2)
/*  598 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  599 */           .addComponent(this.jLabel85, -2, 46, -2)
/*  600 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  601 */           .addComponent(this.jTextField25, -2, 77, -2)
/*  602 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  603 */           .addComponent(this.jLabel87, -2, 68, -2)
/*  604 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  605 */           .addComponent(this.jTextField13, -2, 77, -2)
/*  606 */           .addContainerGap(-1, 32767)));
/*      */     
/*  608 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/*  609 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  610 */         .addGroup(jPanel10Layout.createSequentialGroup()
/*  611 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  612 */             .addComponent(this.jLabel80)
/*  613 */             .addComponent(this.jTextField24, -2, -1, -2)
/*  614 */             .addComponent(this.jLabel85)
/*  615 */             .addComponent(this.jTextField25, -2, -1, -2)
/*  616 */             .addComponent(this.jTextField13, -2, -1, -2)
/*  617 */             .addComponent(this.jLabel87))
/*  618 */           .addContainerGap(13, 32767)));
/*      */ 
/*      */     
/*  621 */     this.jLabel77.setFont(new Font("Tahoma", 3, 11));
/*  622 */     this.jLabel77.setForeground(new Color(15, 87, 51));
/*  623 */     this.jLabel77.setHorizontalAlignment(4);
/*  624 */     this.jLabel77.setText("Tipo de Recepción");
/*      */     
/*  626 */     this.jComboBox18.setBackground(new Color(244, 244, 244));
/*  627 */     this.jComboBox18.setFont(new Font("Tahoma", 1, 11));
/*  628 */     this.jComboBox18.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "CARGADA Y TIRADA", "SÓLO CARGADA", "SÓLO TIRADA", "MOVIMIENTO EN FALSO", "MOVIMIENTO INTERNO", "MOVIMIENTO LATERAL" }));
/*  629 */     this.jComboBox18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  631 */             RSP.this.jComboBox18ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  635 */     this.jPanel11.setBackground(new Color(146, 193, 134));
/*      */     
/*  637 */     this.jLabel11.setHorizontalAlignment(0);
/*  638 */     this.jLabel11.setText("___________________________");
/*      */     
/*  640 */     this.jLabel12.setHorizontalAlignment(0);
/*  641 */     this.jLabel12.setText("___________________________");
/*      */     
/*  643 */     this.jLabel81.setFont(new Font("Tahoma", 3, 11));
/*  644 */     this.jLabel81.setForeground(new Color(15, 87, 51));
/*  645 */     this.jLabel81.setHorizontalAlignment(0);
/*  646 */     this.jLabel81.setText("Entrega");
/*      */     
/*  648 */     this.jLabel82.setFont(new Font("Tahoma", 3, 11));
/*  649 */     this.jLabel82.setForeground(new Color(15, 87, 51));
/*  650 */     this.jLabel82.setHorizontalAlignment(0);
/*  651 */     this.jLabel82.setText("Recibe");
/*      */     
/*  653 */     this.jLabel83.setFont(new Font("Tahoma", 0, 10));
/*  654 */     this.jLabel83.setForeground(new Color(15, 87, 51));
/*  655 */     this.jLabel83.setHorizontalAlignment(0);
/*  656 */     this.jLabel83.setText("Este es otro Ejemplo");
/*      */     
/*  658 */     this.jLabel84.setFont(new Font("Tahoma", 0, 10));
/*  659 */     this.jLabel84.setForeground(new Color(15, 87, 51));
/*  660 */     this.jLabel84.setHorizontalAlignment(0);
/*  661 */     this.jLabel84.setText("Operador que Recibe");
/*      */     
/*  663 */     this.jButton15.setMnemonic('I');
/*  664 */     this.jButton15.setText("Imprimir");
/*  665 */     this.jButton15.setToolTipText("Imprimir (Alt+I)");
/*  666 */     this.jButton15.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  668 */             RSP.this.jButton15ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  672 */     this.jButton14.setMnemonic('C');
/*  673 */     this.jButton14.setText("Cerrar");
/*  674 */     this.jButton14.setToolTipText("Cerrar (Alt+C)");
/*  675 */     this.jButton14.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  677 */             RSP.this.jButton14ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  681 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/*  682 */     this.jPanel11.setLayout(jPanel11Layout);
/*  683 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout
/*  684 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  685 */         .addGroup(jPanel11Layout.createSequentialGroup()
/*  686 */           .addContainerGap()
/*  687 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  688 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
/*  689 */               .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  690 */                 .addComponent(this.jLabel11, -2, 208, -2)
/*  691 */                 .addComponent(this.jLabel81, -2, 198, -2)
/*  692 */                 .addComponent(this.jLabel83, -2, 198, -2))
/*  693 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, 32767)
/*  694 */               .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  695 */                 .addGroup(jPanel11Layout.createSequentialGroup()
/*  696 */                   .addComponent(this.jLabel84, -2, 198, -2)
/*  697 */                   .addContainerGap(-1, 32767))
/*  698 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
/*  699 */                   .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  700 */                     .addComponent(this.jLabel12, -2, 198, -2)
/*  701 */                     .addComponent(this.jLabel82, -2, 198, -2))
/*  702 */                   .addGap(20, 20, 20))))
/*  703 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
/*  704 */               .addComponent(this.jButton15, -2, 122, -2)
/*  705 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  706 */               .addComponent(this.jButton14, -2, 125, -2)
/*  707 */               .addGap(86, 86, 86)))));
/*      */     
/*  709 */     jPanel11Layout.setVerticalGroup(jPanel11Layout
/*  710 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  711 */         .addGroup(jPanel11Layout.createSequentialGroup()
/*  712 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  713 */             .addComponent(this.jLabel83)
/*  714 */             .addComponent(this.jLabel84))
/*  715 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  716 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  717 */             .addComponent(this.jLabel11)
/*  718 */             .addComponent(this.jLabel12))
/*  719 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  720 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  721 */             .addComponent(this.jLabel81)
/*  722 */             .addComponent(this.jLabel82))
/*  723 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  724 */           .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  725 */             .addComponent(this.jButton14)
/*  726 */             .addComponent(this.jButton15))
/*  727 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  730 */     this.jCheckBox1.setText(" FULL");
/*  731 */     this.jCheckBox1.setEnabled(false);
/*      */     
/*  733 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  734 */     this.jPanel9.setLayout(jPanel9Layout);
/*  735 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/*  736 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  737 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  738 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  739 */             .addGroup(jPanel9Layout.createSequentialGroup()
/*  740 */               .addComponent(this.jLabel10)
/*  741 */               .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  742 */                 .addGroup(jPanel9Layout.createSequentialGroup()
/*  743 */                   .addGap(28, 28, 28)
/*  744 */                   .addComponent(this.jLabel64, -2, 313, -2))
/*  745 */                 .addGroup(jPanel9Layout.createSequentialGroup()
/*  746 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  747 */                   .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  748 */                     .addGroup(jPanel9Layout.createSequentialGroup()
/*  749 */                       .addComponent(this.jLabel71, -2, 27, -2)
/*  750 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  751 */                       .addComponent(this.jTextField9, -2, 81, -2)
/*  752 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  753 */                       .addComponent(this.jLabel67)
/*  754 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  755 */                       .addComponent(this.jTextField5, -2, 89, -2)
/*  756 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  757 */                       .addComponent(this.jLabel70, -2, 35, -2))
/*  758 */                     .addGroup(jPanel9Layout.createSequentialGroup()
/*  759 */                       .addComponent(this.jLabel77, -2, 113, -2)
/*  760 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  761 */                       .addComponent(this.jComboBox18, -2, 148, -2)))
/*  762 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  763 */                   .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  764 */                     .addComponent(this.jCheckBox1, -1, -1, 32767)
/*  765 */                     .addComponent(this.jTextField12, -1, 92, 32767))))
/*  766 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 3, 32767))
/*  767 */             .addGroup(jPanel9Layout.createSequentialGroup()
/*  768 */               .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  769 */                 .addComponent(this.jPanel11, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  770 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  771 */                   .addComponent(this.jPanel10, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  772 */                   .addComponent(this.jPanel7, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  773 */                   .addComponent(this.jPanel8, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  774 */                   .addComponent(this.jSeparator1, GroupLayout.Alignment.LEADING)
/*  775 */                   .addComponent(this.jPanel3, GroupLayout.Alignment.LEADING, -1, -1, 32767)))
/*  776 */               .addGap(32, 32, 32)))
/*  777 */           .addGap(0, 0, 0)));
/*      */     
/*  779 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/*  780 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  781 */         .addGroup(jPanel9Layout.createSequentialGroup()
/*  782 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  783 */             .addGroup(jPanel9Layout.createSequentialGroup()
/*  784 */               .addComponent(this.jLabel64)
/*  785 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  786 */               .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  787 */                 .addComponent(this.jLabel67)
/*  788 */                 .addComponent(this.jTextField5, -2, -1, -2)
/*  789 */                 .addComponent(this.jLabel70)
/*  790 */                 .addComponent(this.jLabel71)
/*  791 */                 .addComponent(this.jTextField9, -2, -1, -2)
/*  792 */                 .addComponent(this.jTextField12, -2, -1, -2))
/*  793 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  794 */               .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  795 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  796 */                   .addComponent(this.jLabel77)
/*  797 */                   .addComponent(this.jComboBox18, -2, -1, -2))
/*  798 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/*  799 */                   .addComponent(this.jCheckBox1)
/*  800 */                   .addGap(2, 2, 2))))
/*  801 */             .addComponent(this.jLabel10))
/*  802 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  803 */           .addComponent(this.jSeparator1, -2, -1, -2)
/*  804 */           .addGap(8, 8, 8)
/*  805 */           .addComponent(this.jPanel3, -2, -1, -2)
/*  806 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  807 */           .addComponent(this.jPanel7, -2, -1, -2)
/*  808 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  809 */           .addComponent(this.jPanel8, -2, -1, -2)
/*  810 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  811 */           .addComponent(this.jPanel10, -2, -1, -2)
/*  812 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  813 */           .addComponent(this.jPanel11, -2, -1, -2)
/*  814 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  817 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  818 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  819 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  820 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  821 */         .addComponent(this.jPanel9, -1, -1, 32767));
/*      */     
/*  823 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  824 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  825 */         .addComponent(this.jPanel9, -2, -1, -2));
/*      */ 
/*      */     
/*  828 */     this.jDialog2.setTitle("Modificar Documentos");
/*  829 */     this.jDialog2.setModal(true);
/*      */     
/*  831 */     this.jPanel12.setBackground(new Color(146, 193, 134));
/*      */     
/*  833 */     this.jLabel66.setFont(new Font("Tahoma", 1, 18));
/*  834 */     this.jLabel66.setForeground(new Color(0, 102, 102));
/*  835 */     this.jLabel66.setHorizontalAlignment(0);
/*  836 */     this.jLabel66.setText("RECEPCIÓN DE DOCUMENTOS");
/*      */     
/*  838 */     this.jLabel89.setFont(new Font("Tahoma", 3, 11));
/*  839 */     this.jLabel89.setForeground(new Color(15, 87, 51));
/*  840 */     this.jLabel89.setHorizontalAlignment(4);
/*  841 */     this.jLabel89.setText("Guía");
/*      */     
/*  843 */     this.jTextField14.setEditable(false);
/*  844 */     this.jTextField14.setFont(new Font("Tahoma", 1, 14));
/*  845 */     this.jTextField14.setForeground(Color.red);
/*  846 */     this.jTextField14.setHorizontalAlignment(0);
/*      */     
/*  848 */     this.jLabel13.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/forsis75.png")));
/*      */     
/*  850 */     this.jPanel4.setBackground(new Color(146, 193, 134));
/*  851 */     this.jPanel4.setBorder(BorderFactory.createTitledBorder("Datos Personales"));
/*      */     
/*  853 */     this.jLabel90.setFont(new Font("Tahoma", 3, 11));
/*  854 */     this.jLabel90.setForeground(new Color(15, 87, 51));
/*  855 */     this.jLabel90.setHorizontalAlignment(4);
/*  856 */     this.jLabel90.setText("Cargada por ");
/*      */     
/*  858 */     this.jLabel91.setFont(new Font("Tahoma", 3, 11));
/*  859 */     this.jLabel91.setForeground(new Color(15, 87, 51));
/*  860 */     this.jLabel91.setHorizontalAlignment(4);
/*  861 */     this.jLabel91.setText("Económico");
/*      */     
/*  863 */     this.jTextField20.setEnabled(false);
/*      */     
/*  865 */     this.jLabel92.setFont(new Font("Tahoma", 3, 11));
/*  866 */     this.jLabel92.setForeground(new Color(15, 87, 51));
/*  867 */     this.jLabel92.setHorizontalAlignment(4);
/*  868 */     this.jLabel92.setText("Remolque");
/*      */     
/*  870 */     this.jTextField26.setEnabled(false);
/*      */     
/*  872 */     this.jLabel93.setFont(new Font("Tahoma", 3, 11));
/*  873 */     this.jLabel93.setForeground(new Color(15, 87, 51));
/*  874 */     this.jLabel93.setHorizontalAlignment(4);
/*  875 */     this.jLabel93.setText("Tirada por ");
/*      */     
/*  877 */     this.jComboBox20.setBackground(new Color(244, 244, 244));
/*  878 */     this.jComboBox20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  880 */             RSP.this.jComboBox20ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  884 */     this.jComboBox23.setBackground(new Color(244, 244, 244));
/*  885 */     this.jComboBox23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  887 */             RSP.this.jComboBox23ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  891 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  892 */     this.jPanel4.setLayout(jPanel4Layout);
/*  893 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/*  894 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  895 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  896 */           .addContainerGap()
/*  897 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  898 */             .addGroup(jPanel4Layout.createSequentialGroup()
/*  899 */               .addGap(10, 10, 10)
/*  900 */               .addComponent(this.jLabel93, -2, 69, -2)
/*  901 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  902 */               .addComponent(this.jComboBox20, 0, -1, 32767))
/*  903 */             .addGroup(jPanel4Layout.createSequentialGroup()
/*  904 */               .addComponent(this.jLabel90, -2, 84, -2)
/*  905 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  906 */               .addComponent(this.jComboBox23, 0, -1, 32767))
/*  907 */             .addGroup(jPanel4Layout.createSequentialGroup()
/*  908 */               .addComponent(this.jLabel91, -2, 81, -2)
/*  909 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  910 */               .addComponent(this.jTextField20, -2, 78, -2)
/*  911 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  912 */               .addComponent(this.jLabel92, -2, 68, -2)
/*  913 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  914 */               .addComponent(this.jTextField26, -2, 85, -2)))
/*  915 */           .addContainerGap(-1, 32767)));
/*      */     
/*  917 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/*  918 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  919 */         .addGroup(jPanel4Layout.createSequentialGroup()
/*  920 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  921 */             .addComponent(this.jLabel90)
/*  922 */             .addComponent(this.jComboBox23, -2, -1, -2))
/*  923 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 7, 32767)
/*  924 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  925 */             .addComponent(this.jLabel93)
/*  926 */             .addComponent(this.jComboBox20, -2, -1, -2))
/*  927 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  928 */           .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  929 */             .addComponent(this.jLabel91)
/*  930 */             .addComponent(this.jLabel92)
/*  931 */             .addComponent(this.jTextField26, -2, -1, -2)
/*  932 */             .addComponent(this.jTextField20, -2, -1, -2))));
/*      */ 
/*      */     
/*  935 */     this.jTextField16.setEditable(false);
/*  936 */     this.jTextField16.setFont(new Font("Tahoma", 1, 13));
/*  937 */     this.jTextField16.setForeground(Color.red);
/*  938 */     this.jTextField16.setHorizontalAlignment(0);
/*      */     
/*  940 */     this.jLabel94.setFont(new Font("Tahoma", 3, 11));
/*  941 */     this.jLabel94.setForeground(new Color(15, 87, 51));
/*  942 */     this.jLabel94.setHorizontalAlignment(4);
/*  943 */     this.jLabel94.setText("Folio");
/*      */     
/*  945 */     this.jPanel13.setBackground(new Color(146, 193, 134));
/*  946 */     this.jPanel13.setBorder(BorderFactory.createTitledBorder("Fechas"));
/*      */     
/*  948 */     this.jLabel95.setFont(new Font("Tahoma", 3, 11));
/*  949 */     this.jLabel95.setForeground(new Color(15, 87, 51));
/*  950 */     this.jLabel95.setHorizontalAlignment(0);
/*  951 */     this.jLabel95.setText("Fecha de Llegada");
/*      */     
/*  953 */     this.jDateChooser2.setDate(this.fechaActual);
/*  954 */     this.jDateChooser2.setDateFormatString("dd-MM-yyyy");
/*  955 */     this.jDateChooser2.setMaxSelectableDate(this.fechaActual);
/*  956 */     this.jDateChooser2.setMinSelectableDate(this.fechaInicio);
/*      */     
/*  958 */     this.jLabel96.setFont(new Font("Tahoma", 3, 11));
/*  959 */     this.jLabel96.setForeground(new Color(15, 87, 51));
/*  960 */     this.jLabel96.setHorizontalAlignment(0);
/*  961 */     this.jLabel96.setText("Fecha de Carga");
/*      */     
/*  963 */     this.jDateChooser7.setDate(this.fechaActual);
/*  964 */     this.jDateChooser7.setDateFormatString("dd-MM-yyyy");
/*  965 */     this.jDateChooser7.setMaxSelectableDate(this.fechaActual);
/*      */     
/*  967 */     this.jLabel97.setFont(new Font("Tahoma", 3, 11));
/*  968 */     this.jLabel97.setForeground(new Color(15, 87, 51));
/*  969 */     this.jLabel97.setHorizontalAlignment(0);
/*  970 */     this.jLabel97.setText("Fecha de Salida");
/*      */     
/*  972 */     this.jDateChooser8.setDate(this.fechaActual);
/*  973 */     this.jDateChooser8.setDateFormatString("dd-MM-yyyy");
/*  974 */     this.jDateChooser8.setMaxSelectableDate(this.fechaActual);
/*      */     
/*  976 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/*  977 */     this.jPanel13.setLayout(jPanel13Layout);
/*  978 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/*  979 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  980 */         .addGroup(jPanel13Layout.createSequentialGroup()
/*  981 */           .addContainerGap()
/*  982 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  983 */             .addComponent(this.jLabel95, -1, -1, 32767)
/*  984 */             .addComponent((Component)this.jDateChooser2, -1, 133, 32767))
/*  985 */           .addGap(18, 18, 18)
/*  986 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  987 */             .addComponent(this.jLabel96, -1, -1, 32767)
/*  988 */             .addComponent((Component)this.jDateChooser8, -1, 142, 32767))
/*  989 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  990 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  991 */             .addComponent(this.jLabel97, -1, -1, 32767)
/*  992 */             .addComponent((Component)this.jDateChooser7, -2, 111, -2))
/*  993 */           .addContainerGap()));
/*      */     
/*  995 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/*  996 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  997 */         .addGroup(jPanel13Layout.createSequentialGroup()
/*  998 */           .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  999 */             .addGroup(jPanel13Layout.createSequentialGroup()
/* 1000 */               .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1001 */                 .addComponent(this.jLabel95)
/* 1002 */                 .addComponent(this.jLabel96, -1, -1, 32767))
/* 1003 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1004 */               .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1005 */                 .addComponent((Component)this.jDateChooser2, -2, -1, -2)
/* 1006 */                 .addComponent((Component)this.jDateChooser8, -2, -1, -2)))
/* 1007 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
/* 1008 */               .addComponent(this.jLabel97, -1, -1, 32767)
/* 1009 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1010 */               .addComponent((Component)this.jDateChooser7, -2, -1, -2)))
/* 1011 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1014 */     this.jPanel14.setBackground(new Color(146, 193, 134));
/* 1015 */     this.jPanel14.setBorder(BorderFactory.createTitledBorder("Origen y Destino"));
/*      */     
/* 1017 */     this.jLabel98.setFont(new Font("Tahoma", 3, 11));
/* 1018 */     this.jLabel98.setForeground(new Color(15, 87, 51));
/* 1019 */     this.jLabel98.setHorizontalAlignment(4);
/* 1020 */     this.jLabel98.setText("Origen");
/*      */     
/* 1022 */     this.jTextField21.setEnabled(false);
/*      */     
/* 1024 */     this.jLabel99.setFont(new Font("Tahoma", 3, 11));
/* 1025 */     this.jLabel99.setForeground(new Color(15, 87, 51));
/* 1026 */     this.jLabel99.setHorizontalAlignment(4);
/* 1027 */     this.jLabel99.setText("Cliente");
/*      */     
/* 1029 */     this.jTextField22.setEnabled(false);
/*      */     
/* 1031 */     this.jLabel100.setFont(new Font("Tahoma", 3, 11));
/* 1032 */     this.jLabel100.setForeground(new Color(15, 87, 51));
/* 1033 */     this.jLabel100.setHorizontalAlignment(4);
/* 1034 */     this.jLabel100.setText("Destino");
/*      */     
/* 1036 */     this.jLabel101.setFont(new Font("Tahoma", 3, 11));
/* 1037 */     this.jLabel101.setForeground(new Color(15, 87, 51));
/* 1038 */     this.jLabel101.setHorizontalAlignment(4);
/* 1039 */     this.jLabel101.setText("Ticket");
/*      */     
/* 1041 */     this.jLabel102.setFont(new Font("Tahoma", 3, 11));
/* 1042 */     this.jLabel102.setForeground(new Color(15, 87, 51));
/* 1043 */     this.jLabel102.setHorizontalAlignment(4);
/* 1044 */     this.jLabel102.setText("Peso Neto");
/*      */     
/* 1046 */     this.jTextField29.setEnabled(false);
/*      */     
/* 1048 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 1049 */     this.jPanel14.setLayout(jPanel14Layout);
/* 1050 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 1051 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1052 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 1053 */           .addContainerGap()
/* 1054 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1055 */             .addGroup(jPanel14Layout.createSequentialGroup()
/* 1056 */               .addGap(29, 29, 29)
/* 1057 */               .addComponent(this.jLabel99, -2, 50, -2)
/* 1058 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1059 */               .addComponent(this.jTextField22))
/* 1060 */             .addGroup(jPanel14Layout.createSequentialGroup()
/* 1061 */               .addComponent(this.jLabel98, -2, 79, -2)
/* 1062 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1063 */               .addComponent(this.jTextField21))
/* 1064 */             .addGroup(jPanel14Layout.createSequentialGroup()
/* 1065 */               .addComponent(this.jLabel100, -2, 79, -2)
/* 1066 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1067 */               .addComponent(this.jTextField29, -2, 269, -2))
/* 1068 */             .addGroup(jPanel14Layout.createSequentialGroup()
/* 1069 */               .addComponent(this.jLabel101, -2, 79, -2)
/* 1070 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1071 */               .addComponent(this.jTextField27, -2, 91, -2)
/* 1072 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1073 */               .addComponent(this.jLabel102, -2, 79, -2)
/* 1074 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1075 */               .addComponent(this.jTextField28, -2, 91, -2)))
/* 1076 */           .addGap(72, 72, 72)));
/*      */     
/* 1078 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 1079 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1080 */         .addGroup(jPanel14Layout.createSequentialGroup()
/* 1081 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1082 */             .addComponent(this.jLabel98)
/* 1083 */             .addComponent(this.jTextField21, -2, -1, -2))
/* 1084 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1085 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1086 */             .addComponent(this.jLabel99)
/* 1087 */             .addComponent(this.jTextField22, -2, -1, -2))
/* 1088 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1089 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1090 */             .addComponent(this.jLabel100)
/* 1091 */             .addComponent(this.jTextField29, -2, -1, -2))
/* 1092 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1093 */           .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1094 */             .addComponent(this.jLabel101)
/* 1095 */             .addComponent(this.jTextField27, -2, -1, -2)
/* 1096 */             .addComponent(this.jLabel102)
/* 1097 */             .addComponent(this.jTextField28, -2, -1, -2))));
/*      */ 
/*      */     
/* 1100 */     this.jLabel103.setFont(new Font("Tahoma", 3, 11));
/* 1101 */     this.jLabel103.setForeground(new Color(15, 87, 51));
/* 1102 */     this.jLabel103.setHorizontalAlignment(4);
/* 1103 */     this.jLabel103.setText("Fecha");
/*      */     
/* 1105 */     this.jPanel15.setBackground(new Color(146, 193, 134));
/* 1106 */     this.jPanel15.setBorder(BorderFactory.createTitledBorder("Otros Datos"));
/*      */     
/* 1108 */     this.jLabel104.setFont(new Font("Tahoma", 2, 11));
/* 1109 */     this.jLabel104.setForeground(new Color(15, 87, 51));
/* 1110 */     this.jLabel104.setHorizontalAlignment(4);
/* 1111 */     this.jLabel104.setText("  No. RSP");
/*      */     
/* 1113 */     this.jLabel105.setFont(new Font("Tahoma", 2, 11));
/* 1114 */     this.jLabel105.setForeground(new Color(15, 87, 51));
/* 1115 */     this.jLabel105.setHorizontalAlignment(4);
/* 1116 */     this.jLabel105.setText("Estadías");
/*      */     
/* 1118 */     this.jLabel106.setFont(new Font("Tahoma", 2, 11));
/* 1119 */     this.jLabel106.setForeground(new Color(15, 87, 51));
/* 1120 */     this.jLabel106.setHorizontalAlignment(4);
/* 1121 */     this.jLabel106.setText("Mov. Inter.");
/*      */     
/* 1123 */     GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
/* 1124 */     this.jPanel15.setLayout(jPanel15Layout);
/* 1125 */     jPanel15Layout.setHorizontalGroup(jPanel15Layout
/* 1126 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1127 */         .addGroup(jPanel15Layout.createSequentialGroup()
/* 1128 */           .addComponent(this.jLabel104)
/* 1129 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1130 */           .addComponent(this.jTextField30, -2, 71, -2)
/* 1131 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1132 */           .addComponent(this.jLabel105, -2, 46, -2)
/* 1133 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1134 */           .addComponent(this.jTextField31, -2, 77, -2)
/* 1135 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1136 */           .addComponent(this.jLabel106, -2, 68, -2)
/* 1137 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1138 */           .addComponent(this.jTextField32, -2, 77, -2)
/* 1139 */           .addContainerGap(-1, 32767)));
/*      */     
/* 1141 */     jPanel15Layout.setVerticalGroup(jPanel15Layout
/* 1142 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1143 */         .addGroup(jPanel15Layout.createSequentialGroup()
/* 1144 */           .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1145 */             .addComponent(this.jLabel104)
/* 1146 */             .addComponent(this.jTextField30, -2, -1, -2)
/* 1147 */             .addComponent(this.jLabel105)
/* 1148 */             .addComponent(this.jTextField31, -2, -1, -2)
/* 1149 */             .addComponent(this.jTextField32, -2, -1, -2)
/* 1150 */             .addComponent(this.jLabel106))
/* 1151 */           .addContainerGap(13, 32767)));
/*      */ 
/*      */     
/* 1154 */     this.jLabel107.setFont(new Font("Tahoma", 3, 11));
/* 1155 */     this.jLabel107.setForeground(new Color(15, 87, 51));
/* 1156 */     this.jLabel107.setHorizontalAlignment(4);
/* 1157 */     this.jLabel107.setText("Tipo de Recepción");
/*      */     
/* 1159 */     this.jComboBox22.setBackground(new Color(244, 244, 244));
/* 1160 */     this.jComboBox22.setFont(new Font("Tahoma", 1, 11));
/* 1161 */     this.jComboBox22.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "CARGADA Y TIRADA", "SÓLO CARGADA", "MOVIMIENTO EN FALSO", "MOVIMIENTO INTERNO", "MOVIMIENTO LATERAL" }));
/* 1162 */     this.jComboBox22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1164 */             RSP.this.jComboBox22ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1168 */     this.jPanel16.setBackground(new Color(146, 193, 134));
/*      */     
/* 1170 */     this.jLabel14.setHorizontalAlignment(0);
/* 1171 */     this.jLabel14.setText("___________________________");
/*      */     
/* 1173 */     this.jLabel19.setHorizontalAlignment(0);
/* 1174 */     this.jLabel19.setText("___________________________");
/*      */     
/* 1176 */     this.jLabel108.setFont(new Font("Tahoma", 3, 11));
/* 1177 */     this.jLabel108.setForeground(new Color(15, 87, 51));
/* 1178 */     this.jLabel108.setHorizontalAlignment(0);
/* 1179 */     this.jLabel108.setText("Entrega");
/*      */     
/* 1181 */     this.jLabel109.setFont(new Font("Tahoma", 3, 11));
/* 1182 */     this.jLabel109.setForeground(new Color(15, 87, 51));
/* 1183 */     this.jLabel109.setHorizontalAlignment(0);
/* 1184 */     this.jLabel109.setText("Recibe");
/*      */     
/* 1186 */     this.jLabel110.setFont(new Font("Tahoma", 0, 10));
/* 1187 */     this.jLabel110.setForeground(new Color(15, 87, 51));
/* 1188 */     this.jLabel110.setHorizontalAlignment(0);
/* 1189 */     this.jLabel110.setText("Este es otro Ejemplo");
/*      */     
/* 1191 */     this.jLabel111.setFont(new Font("Tahoma", 0, 10));
/* 1192 */     this.jLabel111.setForeground(new Color(15, 87, 51));
/* 1193 */     this.jLabel111.setHorizontalAlignment(0);
/* 1194 */     this.jLabel111.setText("Operador que Recibe");
/*      */     
/* 1196 */     this.jButton16.setMnemonic('I');
/* 1197 */     this.jButton16.setText("Guardar");
/* 1198 */     this.jButton16.setToolTipText("Guardar (Alt+G)");
/* 1199 */     this.jButton16.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1201 */             RSP.this.jButton16ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1205 */     this.jButton17.setMnemonic('C');
/* 1206 */     this.jButton17.setText("Cerrar");
/* 1207 */     this.jButton17.setToolTipText("Cerrar (Alt+C)");
/* 1208 */     this.jButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1210 */             RSP.this.jButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1214 */     GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
/* 1215 */     this.jPanel16.setLayout(jPanel16Layout);
/* 1216 */     jPanel16Layout.setHorizontalGroup(jPanel16Layout
/* 1217 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1218 */         .addGroup(jPanel16Layout.createSequentialGroup()
/* 1219 */           .addContainerGap()
/* 1220 */           .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1221 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
/* 1222 */               .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1223 */                 .addComponent(this.jLabel14, -2, 208, -2)
/* 1224 */                 .addComponent(this.jLabel108, -2, 198, -2)
/* 1225 */                 .addComponent(this.jLabel110, -2, 198, -2))
/* 1226 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, 32767)
/* 1227 */               .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1228 */                 .addGroup(jPanel16Layout.createSequentialGroup()
/* 1229 */                   .addComponent(this.jLabel111, -2, 198, -2)
/* 1230 */                   .addContainerGap(-1, 32767))
/* 1231 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
/* 1232 */                   .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1233 */                     .addComponent(this.jLabel19, -2, 198, -2)
/* 1234 */                     .addComponent(this.jLabel109, -2, 198, -2))
/* 1235 */                   .addGap(20, 20, 20))))
/* 1236 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
/* 1237 */               .addComponent(this.jButton16, -2, 122, -2)
/* 1238 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1239 */               .addComponent(this.jButton17, -2, 125, -2)
/* 1240 */               .addGap(86, 86, 86)))));
/*      */     
/* 1242 */     jPanel16Layout.setVerticalGroup(jPanel16Layout
/* 1243 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1244 */         .addGroup(jPanel16Layout.createSequentialGroup()
/* 1245 */           .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1246 */             .addComponent(this.jLabel110)
/* 1247 */             .addComponent(this.jLabel111))
/* 1248 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1249 */           .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1250 */             .addComponent(this.jLabel14)
/* 1251 */             .addComponent(this.jLabel19))
/* 1252 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1253 */           .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1254 */             .addComponent(this.jLabel108)
/* 1255 */             .addComponent(this.jLabel109))
/* 1256 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1257 */           .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1258 */             .addComponent(this.jButton17)
/* 1259 */             .addComponent(this.jButton16))
/* 1260 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1263 */     this.jDateChooser9.setDate(this.fechaActual);
/* 1264 */     this.jDateChooser9.setDateFormatString("dd-MM-yyyy");
/* 1265 */     this.jDateChooser9.setMaxSelectableDate(this.fechaActual);
/*      */     
/* 1267 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 1268 */     this.jPanel12.setLayout(jPanel12Layout);
/* 1269 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout
/* 1270 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1271 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1272 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1273 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1274 */               .addComponent(this.jLabel13)
/* 1275 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1276 */                 .addGroup(jPanel12Layout.createSequentialGroup()
/* 1277 */                   .addGap(28, 28, 28)
/* 1278 */                   .addComponent(this.jLabel66, -2, 313, -2))
/* 1279 */                 .addGroup(jPanel12Layout.createSequentialGroup()
/* 1280 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1281 */                   .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1282 */                     .addGroup(jPanel12Layout.createSequentialGroup()
/* 1283 */                       .addComponent(this.jLabel94, -2, 27, -2)
/* 1284 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1285 */                       .addComponent(this.jTextField16, -2, 81, -2)
/* 1286 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1287 */                       .addComponent(this.jLabel89)
/* 1288 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1289 */                       .addComponent(this.jTextField14, -2, 89, -2)
/* 1290 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1291 */                       .addComponent(this.jLabel103, -2, 35, -2))
/* 1292 */                     .addGroup(jPanel12Layout.createSequentialGroup()
/* 1293 */                       .addComponent(this.jLabel107, -2, 113, -2)
/* 1294 */                       .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1295 */                       .addComponent(this.jComboBox22, -2, 148, -2)))
/* 1296 */                   .addGap(15, 15, 15)
/* 1297 */                   .addComponent((Component)this.jDateChooser9, -1, 99, 32767))))
/* 1298 */             .addComponent(this.jPanel16, -1, -1, 32767)
/* 1299 */             .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1300 */               .addComponent(this.jPanel15, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1301 */               .addComponent(this.jPanel13, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1302 */               .addComponent(this.jPanel14, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1303 */               .addComponent(this.jSeparator2, GroupLayout.Alignment.LEADING)
/* 1304 */               .addComponent(this.jPanel4, GroupLayout.Alignment.LEADING, -1, -1, 32767)))
/* 1305 */           .addContainerGap()));
/*      */     
/* 1307 */     jPanel12Layout.setVerticalGroup(jPanel12Layout
/* 1308 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1309 */         .addGroup(jPanel12Layout.createSequentialGroup()
/* 1310 */           .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1311 */             .addGroup(jPanel12Layout.createSequentialGroup()
/* 1312 */               .addComponent(this.jLabel66)
/* 1313 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1314 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1315 */                 .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1316 */                   .addComponent(this.jLabel89)
/* 1317 */                   .addComponent(this.jTextField14, -2, -1, -2)
/* 1318 */                   .addComponent(this.jLabel103)
/* 1319 */                   .addComponent(this.jLabel94)
/* 1320 */                   .addComponent(this.jTextField16, -2, -1, -2))
/* 1321 */                 .addComponent((Component)this.jDateChooser9, -2, -1, -2))
/* 1322 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1323 */               .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1324 */                 .addComponent(this.jLabel107)
/* 1325 */                 .addComponent(this.jComboBox22, -2, -1, -2)))
/* 1326 */             .addComponent(this.jLabel13))
/* 1327 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1328 */           .addComponent(this.jSeparator2, -2, -1, -2)
/* 1329 */           .addGap(8, 8, 8)
/* 1330 */           .addComponent(this.jPanel4, -2, -1, -2)
/* 1331 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1332 */           .addComponent(this.jPanel13, -2, -1, -2)
/* 1333 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1334 */           .addComponent(this.jPanel14, -2, -1, -2)
/* 1335 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1336 */           .addComponent(this.jPanel15, -2, -1, -2)
/* 1337 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1338 */           .addComponent(this.jPanel16, -2, -1, -2)
/* 1339 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1342 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1343 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1344 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1345 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1346 */         .addGroup(jDialog2Layout.createSequentialGroup()
/* 1347 */           .addComponent(this.jPanel12, -2, -1, -2)
/* 1348 */           .addContainerGap(-1, 32767)));
/*      */     
/* 1350 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1351 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1352 */         .addGroup(jDialog2Layout.createSequentialGroup()
/* 1353 */           .addComponent(this.jPanel12, -2, -1, -2)
/* 1354 */           .addContainerGap(12, 32767)));
/*      */ 
/*      */     
/* 1357 */     this.jPanel6.setBackground(new Color(146, 193, 134));
/* 1358 */     this.jPanel6.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/* 1360 */     this.jLabel3.setFont(new Font("Tahoma", 1, 18));
/* 1361 */     this.jLabel3.setForeground(new Color(10, 126, 68));
/* 1362 */     this.jLabel3.setText("RECEPCIÓN DE DOCUMENTOS");
/*      */     
/* 1364 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/* 1365 */     this.jPanel2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
/*      */     
/* 1367 */     this.jButton3.setMnemonic('F');
/* 1368 */     this.jButton3.setText("Filtrar");
/* 1369 */     this.jButton3.setToolTipText("Filtrar (Alt +F)");
/* 1370 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1372 */             RSP.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1376 */     this.jLabel4.setFont(new Font("Tahoma", 1, 14));
/* 1377 */     this.jLabel4.setForeground(Color.red);
/* 1378 */     this.jLabel4.setHorizontalAlignment(0);
/* 1379 */     this.jLabel4.setText("AL");
/*      */     
/* 1381 */     this.jLabel5.setFont(new Font("Tahoma", 1, 14));
/* 1382 */     this.jLabel5.setForeground(Color.red);
/* 1383 */     this.jLabel5.setText(" REPORTE DE RSP");
/*      */     
/* 1385 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1386 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/* 1387 */     this.jDateChooser4.setIcon(this.icon);
/* 1388 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/* 1389 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 1391 */     this.jDateChooser5.setDate(this.fechaActual);
/* 1392 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 1393 */     this.jDateChooser5.setIcon(this.icon);
/* 1394 */     this.jDateChooser5.setMaxSelectableDate(this.fechaActual);
/* 1395 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 1397 */     this.jLabel7.setFont(new Font("Tahoma", 2, 12));
/* 1398 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/* 1399 */     this.jLabel7.setText("<html><u>Todos </u></html>");
/* 1400 */     this.jLabel7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1402 */             RSP.this.jLabel7MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1405 */             RSP.this.jLabel7MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1408 */             RSP.this.jLabel7MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1412 */     this.jLabel8.setFont(new Font("Tahoma", 2, 12));
/* 1413 */     this.jLabel8.setForeground(new Color(15, 87, 51));
/* 1414 */     this.jLabel8.setHorizontalAlignment(0);
/* 1415 */     this.jLabel8.setText("<html><u>Hoy</u></html>");
/* 1416 */     this.jLabel8.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1418 */             RSP.this.jLabel8MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1421 */             RSP.this.jLabel8MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1424 */             RSP.this.jLabel8MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1428 */     this.jLabel9.setFont(new Font("Tahoma", 2, 12));
/* 1429 */     this.jLabel9.setForeground(new Color(15, 87, 51));
/* 1430 */     this.jLabel9.setText("<html><u>Ayer</u></html>");
/* 1431 */     this.jLabel9.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1433 */             RSP.this.jLabel9MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1436 */             RSP.this.jLabel9MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1439 */             RSP.this.jLabel9MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1443 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 1444 */     this.jPanel2.setLayout(jPanel2Layout);
/* 1445 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 1446 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1447 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1448 */           .addComponent(this.jLabel5, -2, 146, -2)
/* 1449 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1450 */           .addComponent((Component)this.jDateChooser4, -2, 108, -2)
/* 1451 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1452 */           .addComponent(this.jLabel4, -2, 20, -2)
/* 1453 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1454 */           .addComponent((Component)this.jDateChooser5, -2, 108, -2)
/* 1455 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1456 */           .addComponent(this.jButton3)
/* 1457 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1458 */           .addComponent(this.jLabel7, -2, -1, -2)
/* 1459 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1460 */           .addComponent(this.jLabel8, -2, 31, -2)
/* 1461 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1462 */           .addComponent(this.jLabel9, -2, 31, -2)
/* 1463 */           .addContainerGap(17, 32767)));
/*      */     
/* 1465 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 1466 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1467 */         .addGroup(jPanel2Layout.createSequentialGroup()
/* 1468 */           .addContainerGap()
/* 1469 */           .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1470 */             .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1471 */               .addComponent(this.jButton3)
/* 1472 */               .addComponent(this.jLabel7)
/* 1473 */               .addComponent(this.jLabel8)
/* 1474 */               .addComponent(this.jLabel9, -2, 15, -2))
/* 1475 */             .addComponent(this.jLabel4, -1, -1, 32767)
/* 1476 */             .addComponent((Component)this.jDateChooser5, -2, -1, -2)
/* 1477 */             .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1478 */               .addComponent(this.jLabel5, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1479 */               .addComponent((Component)this.jDateChooser4, GroupLayout.Alignment.LEADING, -1, -1, 32767)))
/* 1480 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1483 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 1484 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de RSP", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1486 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1488 */             RSP.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1492 */     this.jLabel15.setFont(new Font("Tahoma", 3, 12));
/* 1493 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/* 1494 */     this.jLabel15.setHorizontalAlignment(0);
/* 1495 */     this.jLabel15.setText("Folio");
/*      */     
/* 1497 */     this.jLabel56.setFont(new Font("Tahoma", 3, 12));
/* 1498 */     this.jLabel56.setForeground(new Color(15, 87, 51));
/* 1499 */     this.jLabel56.setHorizontalAlignment(0);
/* 1500 */     this.jLabel56.setText("Operador que Carga");
/*      */     
/* 1502 */     this.jTextField3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1504 */             RSP.this.jTextField3KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1508 */     this.jTextField6.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1510 */             RSP.this.jTextField6KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1514 */     this.jLabel16.setFont(new Font("Tahoma", 3, 12));
/* 1515 */     this.jLabel16.setForeground(new Color(15, 87, 51));
/* 1516 */     this.jLabel16.setHorizontalAlignment(0);
/* 1517 */     this.jLabel16.setText("Eco");
/*      */     
/* 1519 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 1520 */     this.jComboBox1.setFont(new Font("Tahoma", 1, 11));
/* 1521 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVO", "CANCELADO", "TODOS" }));
/* 1522 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1524 */             RSP.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1528 */     this.jLabel46.setFont(new Font("Tahoma", 3, 12));
/* 1529 */     this.jLabel46.setForeground(new Color(15, 87, 51));
/* 1530 */     this.jLabel46.setHorizontalAlignment(0);
/* 1531 */     this.jLabel46.setText("Estado-RSP");
/*      */     
/* 1533 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1535 */             RSP.this.jTextField4KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1539 */     this.jLabel59.setFont(new Font("Tahoma", 3, 12));
/* 1540 */     this.jLabel59.setForeground(new Color(15, 87, 51));
/* 1541 */     this.jLabel59.setHorizontalAlignment(0);
/* 1542 */     this.jLabel59.setText("Operador que Tira");
/*      */     
/* 1544 */     this.jLabel17.setFont(new Font("Tahoma", 3, 12));
/* 1545 */     this.jLabel17.setForeground(new Color(15, 87, 51));
/* 1546 */     this.jLabel17.setHorizontalAlignment(0);
/* 1547 */     this.jLabel17.setText("Guías");
/*      */     
/* 1549 */     this.jTextField2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1551 */             RSP.this.jTextField2KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1555 */     this.jTextField7.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1557 */             RSP.this.jTextField7KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1561 */     this.jLabel18.setFont(new Font("Tahoma", 3, 12));
/* 1562 */     this.jLabel18.setForeground(new Color(15, 87, 51));
/* 1563 */     this.jLabel18.setHorizontalAlignment(0);
/* 1564 */     this.jLabel18.setText("Remolque");
/*      */     
/* 1566 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 1567 */     this.jPanel17.setLayout(jPanel17Layout);
/* 1568 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 1569 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1570 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 1571 */           .addContainerGap()
/* 1572 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1573 */             .addComponent(this.jLabel46, -1, -1, 32767)
/* 1574 */             .addComponent(this.jComboBox1, 0, 114, 32767))
/* 1575 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1576 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1577 */             .addComponent(this.jLabel15, -1, -1, 32767)
/* 1578 */             .addComponent(this.jTextField1, -2, 82, -2))
/* 1579 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1580 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1581 */             .addComponent(this.jLabel17, -1, -1, 32767)
/* 1582 */             .addComponent(this.jTextField2, -2, 82, -2))
/* 1583 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1584 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1585 */             .addComponent(this.jLabel56, -1, -1, 32767)
/* 1586 */             .addComponent(this.jTextField3, -2, 150, -2))
/* 1587 */           .addGap(8, 8, 8)
/* 1588 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1589 */             .addComponent(this.jLabel59, -1, -1, 32767)
/* 1590 */             .addComponent(this.jTextField4, -2, 150, -2))
/* 1591 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1592 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1593 */             .addComponent(this.jLabel16, -1, -1, 32767)
/* 1594 */             .addComponent(this.jTextField6, -2, 60, -2))
/* 1595 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1596 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1597 */             .addComponent(this.jLabel18, -1, -1, 32767)
/* 1598 */             .addComponent(this.jTextField7, -2, 60, -2))
/* 1599 */           .addContainerGap(986, 32767)));
/*      */     
/* 1601 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 1602 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1603 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 1604 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1605 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1606 */               .addComponent(this.jComboBox1, -2, -1, -2)
/* 1607 */               .addGap(8, 8, 8)
/* 1608 */               .addComponent(this.jLabel46))
/* 1609 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1610 */               .addComponent(this.jTextField1, -2, -1, -2)
/* 1611 */               .addGap(8, 8, 8)
/* 1612 */               .addComponent(this.jLabel15))
/* 1613 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1614 */               .addComponent(this.jTextField4, -2, -1, -2)
/* 1615 */               .addGap(8, 8, 8)
/* 1616 */               .addComponent(this.jLabel59))
/* 1617 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1618 */               .addComponent(this.jTextField2, -2, -1, -2)
/* 1619 */               .addGap(8, 8, 8)
/* 1620 */               .addComponent(this.jLabel17))
/* 1621 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1622 */               .addComponent(this.jTextField3, -2, -1, -2)
/* 1623 */               .addGap(8, 8, 8)
/* 1624 */               .addComponent(this.jLabel56))
/* 1625 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1626 */               .addComponent(this.jTextField6, -2, -1, -2)
/* 1627 */               .addGap(8, 8, 8)
/* 1628 */               .addComponent(this.jLabel16))
/* 1629 */             .addGroup(jPanel17Layout.createSequentialGroup()
/* 1630 */               .addComponent(this.jTextField7, -2, -1, -2)
/* 1631 */               .addGap(8, 8, 8)
/* 1632 */               .addComponent(this.jLabel18)))
/* 1633 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1636 */     this.jPanel18.setBackground(new Color(146, 193, 134));
/* 1637 */     this.jPanel18.setBorder(BorderFactory.createTitledBorder(null, "Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1639 */     this.jTable2.setFont(new Font("Tahoma", 0, 10));
/* 1640 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Folio", "Fecha", "Ruta", "Operador", "Eco", "Guías", "Autorizó" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1648 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1653 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1656 */     this.jTable2.setShowVerticalLines(false);
/* 1657 */     this.jTable2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1659 */             RSP.this.jTable2MouseClicked(evt);
/*      */           }
/*      */         });
/* 1662 */     this.jScrollPane2.setViewportView(this.jTable2);
/*      */     
/* 1664 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 1665 */     this.jLabel48.setForeground(Color.red);
/* 1666 */     this.jLabel48.setHorizontalAlignment(2);
/* 1667 */     this.jLabel48.setText("t");
/* 1668 */     this.jLabel48.setBorder(BorderFactory.createBevelBorder(1));
/*      */     
/* 1670 */     this.jButton4.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/ReimMani.png")));
/* 1671 */     this.jButton4.setMnemonic('A');
/* 1672 */     this.jButton4.setText("Reimprimir");
/* 1673 */     this.jButton4.setToolTipText("Cargar Vale Tractor (Alt+A)");
/* 1674 */     this.jButton4.setEnabled(false);
/* 1675 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1677 */             RSP.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1681 */     this.jButton5.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1682 */     this.jButton5.setMnemonic('U');
/* 1683 */     this.jButton5.setText("Modificar");
/* 1684 */     this.jButton5.setToolTipText("Cargar Vale Utilitario (Alt+U)");
/* 1685 */     this.jButton5.setEnabled(false);
/* 1686 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1688 */             RSP.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1692 */     this.jButton11.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Delete.png")));
/* 1693 */     this.jButton11.setMnemonic('C');
/* 1694 */     this.jButton11.setText("Cancelar");
/* 1695 */     this.jButton11.setToolTipText("Cancelar (Alt+C)");
/* 1696 */     this.jButton11.setEnabled(false);
/* 1697 */     this.jButton11.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1699 */             RSP.this.jButton11ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1703 */     this.jButton6.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 1704 */     this.jButton6.setMnemonic('G');
/* 1705 */     this.jButton6.setText("Guardar Reporte");
/* 1706 */     this.jButton6.setToolTipText("Guardar Reporte (Alt+G)");
/* 1707 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1709 */             RSP.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1713 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/* 1714 */     this.jPanel18.setLayout(jPanel18Layout);
/* 1715 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/* 1716 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1717 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 1718 */           .addContainerGap()
/* 1719 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1720 */             .addComponent(this.jScrollPane2, -1, 1713, 32767)
/* 1721 */             .addGroup(jPanel18Layout.createSequentialGroup()
/* 1722 */               .addComponent(this.jLabel48, -2, 163, -2)
/* 1723 */               .addGap(84, 84, 84)
/* 1724 */               .addComponent(this.jButton4, -2, 137, -2)
/* 1725 */               .addGap(26, 26, 26)
/* 1726 */               .addComponent(this.jButton11, -2, 141, -2)
/* 1727 */               .addGap(26, 26, 26)
/* 1728 */               .addComponent(this.jButton5, -2, 141, -2)
/* 1729 */               .addGap(102, 102, 102)
/* 1730 */               .addComponent(this.jButton6, -2, 162, -2)))
/* 1731 */           .addContainerGap()));
/*      */     
/* 1733 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/* 1734 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1735 */         .addGroup(jPanel18Layout.createSequentialGroup()
/* 1736 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1737 */             .addComponent(this.jLabel48)
/* 1738 */             .addComponent(this.jButton4)
/* 1739 */             .addComponent(this.jButton11)
/* 1740 */             .addComponent(this.jButton5)
/* 1741 */             .addComponent(this.jButton6))
/* 1742 */           .addGap(4, 4, 4)
/* 1743 */           .addComponent(this.jScrollPane2, -1, 146, 32767)));
/*      */ 
/*      */     
/* 1746 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 1747 */     this.jPanel6.setLayout(jPanel6Layout);
/* 1748 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/* 1749 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1750 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/* 1751 */           .addContainerGap()
/* 1752 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1753 */             .addComponent(this.jPanel18, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1754 */             .addComponent(this.jPanel17, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1755 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
/* 1756 */               .addComponent(this.jPanel2, -2, -1, -2)
/* 1757 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1758 */               .addComponent(this.jLabel3, -1, 1143, 32767)))
/* 1759 */           .addContainerGap()));
/*      */     
/* 1761 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/* 1762 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1763 */         .addGroup(jPanel6Layout.createSequentialGroup()
/* 1764 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1765 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 1766 */               .addContainerGap()
/* 1767 */               .addComponent(this.jPanel2, -2, 44, -2))
/* 1768 */             .addGroup(jPanel6Layout.createSequentialGroup()
/* 1769 */               .addGap(21, 21, 21)
/* 1770 */               .addComponent(this.jLabel3)))
/* 1771 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1772 */           .addComponent(this.jPanel17, -2, 69, -2)
/* 1773 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1774 */           .addComponent(this.jPanel18, -1, -1, 32767)
/* 1775 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1778 */     GroupLayout layout = new GroupLayout(this);
/* 1779 */     setLayout(layout);
/* 1780 */     layout.setHorizontalGroup(layout
/* 1781 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1782 */         .addGap(0, 1789, 32767)
/* 1783 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1784 */           .addGroup(layout.createSequentialGroup()
/* 1785 */             .addContainerGap()
/* 1786 */             .addComponent(this.jPanel6, -1, -1, 32767)
/* 1787 */             .addContainerGap())));
/*      */     
/* 1789 */     layout.setVerticalGroup(layout
/* 1790 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1791 */         .addGap(0, 365, 32767)
/* 1792 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1793 */           .addGroup(layout.createSequentialGroup()
/* 1794 */             .addGap(6, 6, 6)
/* 1795 */             .addComponent(this.jPanel6, -1, -1, 32767)
/* 1796 */             .addGap(6, 6, 6))));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 1801 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel7MouseClicked(MouseEvent evt) {
/* 1805 */     this.jDateChooser4.setDate(this.fechaInicio);
/* 1806 */     this.jDateChooser5.setDate(this.fechaActual);
/* 1807 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel7MouseEntered(MouseEvent evt) {
/* 1811 */     this.jLabel7.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel7MouseExited(MouseEvent evt) {
/* 1815 */     this.jLabel7.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel8MouseClicked(MouseEvent evt) {
/* 1819 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1820 */     this.jDateChooser5.setDate(this.fechaActual);
/* 1821 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel8MouseEntered(MouseEvent evt) {
/* 1825 */     this.jLabel8.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel8MouseExited(MouseEvent evt) {
/* 1829 */     this.jLabel8.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jLabel9MouseClicked(MouseEvent evt) {
/* 1833 */     Calendar ca = Calendar.getInstance();
/* 1834 */     Calendar fecha = Calendar.getInstance();
/* 1835 */     int aa = fecha.get(1);
/* 1836 */     int mm = fecha.get(2);
/* 1837 */     int dd = fecha.get(5);
/* 1838 */     if (dd == 1) {
/* 1839 */       if (mm == 0) {
/* 1840 */         mm = 11;
/* 1841 */         aa--;
/*      */       } else {
/* 1843 */         mm--;
/*      */       } 
/* 1845 */       int diasTotal = diasDelMes(mm, aa);
/* 1846 */       dd = diasTotal;
/*      */     } else {
/* 1848 */       dd--;
/*      */     } 
/* 1850 */     mm++;
/* 1851 */     String año = "" + aa;
/* 1852 */     String mes = "" + mm;
/* 1853 */     String dia = "" + dd;
/* 1854 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 1855 */     String strFecha = año + "-" + año + "-" + mes;
/*      */     try {
/* 1857 */       this.jDateChooser4.setDate(formatoDelTexto.parse(strFecha));
/* 1858 */       this.jDateChooser5.setDate(formatoDelTexto.parse(strFecha));
/* 1859 */     } catch (ParseException ex) {
/* 1860 */       ex.printStackTrace();
/*      */     } 
/* 1862 */     consultar();
/*      */   }
/*      */   
/*      */   private void jLabel9MouseEntered(MouseEvent evt) {
/* 1866 */     this.jLabel9.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel9MouseExited(MouseEvent evt) {
/* 1870 */     this.jLabel9.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 1874 */     String cadena = this.jTextField1.getText();
/* 1875 */     if (!cadena.equals("")) {
/* 1876 */       if (this.presionado == null) {
/* 1877 */         this.presionado = new Presionado();
/* 1878 */         this.presionado.start();
/*      */       } else {
/* 1880 */         this.presionado.detenerFuera();
/* 1881 */         this.presionado = new Presionado();
/* 1882 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 1885 */       this.jTextField1.setBackground(new Color(153, 255, 153));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField3KeyReleased(KeyEvent evt) {
/* 1890 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField6KeyReleased(KeyEvent evt) {
/* 1894 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 1898 */     if (this.jComboBox1.getItemCount() > 0) {
/* 1899 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTextField4KeyReleased(KeyEvent evt) {
/* 1904 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField2KeyReleased(KeyEvent evt) {
/* 1908 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTable2MouseClicked(MouseEvent evt) {
/* 1912 */     if (evt.getClickCount() == 2) {
/* 1913 */       this.con.consultar("priv", "usuarios", "where nombre_usu = '" + this.USUARIO + "'");
/* 1914 */       if (!this.con.Campo.equals("LIQUIDACIONES") || !this.con.Campo.equals("RECURSOS HUMANOS")) {
/* 1915 */         reimprimir();
/*      */       }
/*      */     } else {
/* 1918 */       this.con.consultar("priv", "usuarios", "where nombre_usu = '" + this.USUARIO + "'");
/* 1919 */       if (this.con.Campo.equals("LIQUIDACIONES") || this.con.Campo.equals("RECURSOS HUMANOS")) {
/* 1920 */         this.jButton4.setEnabled(false);
/* 1921 */         this.jButton5.setEnabled(false);
/* 1922 */         this.jButton11.setEnabled(false);
/*      */       } else {
/* 1924 */         this.jButton4.setEnabled(true);
/* 1925 */         this.jButton5.setEnabled(true);
/* 1926 */         this.jButton11.setEnabled(true);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 1932 */     reimprimir();
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 1936 */     verRSP();
/* 1937 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton11ActionPerformed(ActionEvent evt) {
/* 1941 */     this.error.pasarModal(true);
/* 1942 */     this.val.pasarModal(Boolean.valueOf(true));
/* 1943 */     String num = String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0));
/* 1944 */     this.CLAVE = num;
/* 1945 */     String estado = String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 8));
/* 1946 */     if (estado.equals("ACTIVO"));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField7KeyReleased(KeyEvent evt) {
/* 1954 */     consultar();
/*      */   }
/*      */   
/*      */   private void jComboBox19ActionPerformed(ActionEvent evt) {
/* 1958 */     if (this.jComboBox18.getSelectedIndex() == 3) {
/* 1959 */       this.jLabel84.setText(String.valueOf(this.jComboBox19.getSelectedItem()));
/*      */     } else {
/* 1961 */       this.jLabel84.setText(this.jTextField6.getText());
/*      */     } 
/*      */   }
/*      */   private void jComboBox18ActionPerformed(ActionEvent evt) {
/* 1965 */     if (this.jComboBox18.getSelectedIndex() == 3) {
/* 1966 */       this.jLabel84.setText(String.valueOf(this.jComboBox19.getSelectedItem()));
/*      */     } else {
/* 1968 */       this.jLabel84.setText(this.jTextField8.getText());
/*      */     } 
/*      */   }
/*      */   private void jButton15ActionPerformed(ActionEvent evt) {
/* 1972 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 1973 */     String cadenaFecha1 = formato.format(this.jDateChooser1.getDate());
/* 1974 */     String año = cadenaFecha1.substring(0, 4);
/* 1975 */     String mes = cadenaFecha1.substring(4, 6);
/* 1976 */     String dia = cadenaFecha1.substring(6, 8);
/* 1977 */     String fechaCompleta = "'" + año + "-" + mes + "-" + dia + "'";
/* 1978 */     String fenviar1 = dia + "/" + dia + "/" + mes;
/*      */     
/* 1980 */     formato = new SimpleDateFormat("yyyyMMdd");
/* 1981 */     cadenaFecha1 = formato.format(this.jDateChooser3.getDate());
/* 1982 */     año = cadenaFecha1.substring(0, 4);
/* 1983 */     mes = cadenaFecha1.substring(4, 6);
/* 1984 */     dia = cadenaFecha1.substring(6, 8);
/* 1985 */     String fechaCompleta2 = "'" + año + "-" + mes + "-" + dia + "'";
/* 1986 */     String fenviar2 = dia + "/" + dia + "/" + mes;
/* 1987 */     String nombre1 = this.jTextField8.getText();
/* 1988 */     String nombre2 = String.valueOf(this.jComboBox19.getSelectedItem());
/* 1989 */     if (this.jComboBox18.getSelectedIndex() == 0) {
/* 1990 */       JOptionPane.showMessageDialog(this.padre, "Debes seleccionar una opción para poder imprimir la HOJA DE RECEPCIÓN", "Selecciona una Opción", 0, this.ERROR);
/* 1991 */     } else if (this.jComboBox18.getSelectedIndex() == 1 && !nombre1.equals(nombre2) && !nombre2.equals("MOVIMIENTO EN FALSO") && !nombre2.equals("MOVIMIENTO INTERNO")) {
/* 1992 */       JOptionPane.showMessageDialog(this.padre, "No puedes imprimir la hoja de recepción por CARGADA Y TIRADA\nYa que son distintos operadores.", "Distintos Operadores", 0, this.ERROR);
/* 1993 */     } else if (this.jComboBox18.getSelectedIndex() == 3 && nombre2.equals("PENDIENTE DESCARGA")) {
/* 1994 */       JOptionPane.showMessageDialog(this.padre, "No puedes imprimir la hoja de recepción por SÓLO TIRADA\nYa que el material no ha sido tirado.", "Sin tirar", 0, this.ERROR);
/* 1995 */     } else if (this.jComboBox18.getSelectedIndex() == 1) {
/* 1996 */       int res = JOptionPane.showConfirmDialog(this.padre, "Estás seguro que deseas REIMPRIMIR la hoja de recepción?", "Reimprmir Hoja de Recepción", 0, 3, this.PREG);
/* 1997 */       if (res == 0) {
/* 1998 */         String tipo = "";
/* 1999 */         if (this.jCheckBox1.isSelected()) {
/* 2000 */           tipo = "FULL";
/*      */         } else {
/* 2002 */           tipo = "SENCILLO";
/*      */         } 
/* 2004 */         ImprimirRSP im = new ImprimirRSP();
/* 2005 */         String[] datos = { this.jTextField9.getText(), this.jTextField5.getText(), this.jTextField12.getText(), String.valueOf(this.jComboBox18.getSelectedItem()), this.jTextField8.getText(), String.valueOf(this.jComboBox19.getSelectedItem()), this.jTextField19.getText(), this.jTextField23.getText(), fenviar1, fenviar2, this.jTextField10.getText(), this.jTextField11.getText(), String.valueOf(this.jComboBox17.getSelectedItem()), this.jTextField17.getText(), this.jTextField18.getText(), this.jTextField24.getText(), this.jTextField25.getText(), this.jTextField13.getText(), this.jLabel83.getText(), this.jLabel84.getText(), this.TIPOTRACTOR, tipo };
/* 2006 */         im.recibeDatos(datos);
/* 2007 */         this.jDialog1.setVisible(false);
/*      */       } 
/* 2009 */     } else if (this.jComboBox18.getSelectedIndex() == 2) {
/* 2010 */       int res = JOptionPane.showConfirmDialog(this.padre, "Estás seguro que deseas REIMPRIMIR la hoja de recepción?", "Reimprmir Hoja de Recepción", 0, 3, this.PREG);
/* 2011 */       if (res == 0) {
/* 2012 */         ImprimirRSP im = new ImprimirRSP();
/* 2013 */         String[] datos = { this.jTextField9.getText(), this.jTextField5.getText(), this.jTextField12.getText(), String.valueOf(this.jComboBox18.getSelectedItem()), this.jTextField8.getText(), "-------------------------", this.jTextField19.getText(), this.jTextField23.getText(), fenviar1, fenviar2, this.jTextField10.getText(), this.jTextField11.getText(), "PATIO", "0", "0", this.jTextField24.getText(), this.jTextField25.getText(), this.jTextField13.getText(), this.jLabel83.getText(), this.jLabel84.getText(), this.TIPOTRACTOR, "SENCILLO" };
/* 2014 */         im.recibeDatos(datos);
/* 2015 */         this.jDialog1.setVisible(false);
/*      */       } 
/* 2017 */     } else if (this.jComboBox18.getSelectedIndex() == 3) {
/* 2018 */       int res = JOptionPane.showConfirmDialog(this.padre, "Estás seguro que deseas REIMPRIMIR la hoja de recepción?", "Reimprmir Hoja de Recepción", 0, 3, this.PREG);
/* 2019 */       if (res == 0) {
/* 2020 */         String tipo = "";
/* 2021 */         if (this.jCheckBox1.isSelected()) {
/* 2022 */           tipo = "FULL";
/*      */         } else {
/* 2024 */           tipo = "SENCILLO";
/*      */         } 
/* 2026 */         ImprimirRSP im = new ImprimirRSP();
/* 2027 */         String[] datos = { this.jTextField9.getText(), this.jTextField5.getText(), this.jTextField12.getText(), String.valueOf(this.jComboBox18.getSelectedItem()), this.jTextField8.getText(), String.valueOf(this.jComboBox19.getSelectedItem()), this.jTextField19.getText(), this.jTextField23.getText(), "-------", "-------", "PATIO", this.jTextField11.getText(), String.valueOf(this.jComboBox17.getSelectedItem()), this.jTextField17.getText(), this.jTextField18.getText(), "0", "0", "0", this.jLabel83.getText(), this.jLabel84.getText(), this.TIPOTRACTOR, tipo };
/* 2028 */         im.recibeDatos(datos);
/* 2029 */         this.jDialog1.setVisible(false);
/*      */       } 
/* 2031 */     } else if (this.jComboBox18.getSelectedIndex() == 4) {
/* 2032 */       int res = JOptionPane.showConfirmDialog(this.padre, "Estás seguro que deseas REIMPRIMIR la hoja de recepción?", "Reimprmir Hoja de Recepción", 0, 3, this.PREG);
/* 2033 */       if (res == 0) {
/* 2034 */         String tipo = "";
/* 2035 */         if (this.jCheckBox1.isSelected()) {
/* 2036 */           tipo = "FULL";
/*      */         } else {
/* 2038 */           tipo = "SENCILLO";
/*      */         } 
/* 2040 */         ImprimirRSP im = new ImprimirRSP();
/* 2041 */         String[] datos = { this.jTextField9.getText(), this.jTextField5.getText(), this.jTextField12.getText(), String.valueOf(this.jComboBox18.getSelectedItem()), this.jTextField8.getText(), String.valueOf(this.jComboBox19.getSelectedItem()), this.jTextField19.getText(), this.jTextField23.getText(), fenviar1, fenviar2, this.jTextField10.getText(), this.jTextField11.getText(), String.valueOf(this.jComboBox17.getSelectedItem()), this.jTextField17.getText(), this.jTextField18.getText(), this.jTextField24.getText(), this.jTextField25.getText(), this.jTextField13.getText(), this.jLabel83.getText(), this.jLabel84.getText(), this.TIPOTRACTOR, tipo };
/* 2042 */         im.recibeDatos(datos);
/* 2043 */         this.jDialog1.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton14ActionPerformed(ActionEvent evt) {
/* 2049 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 2053 */     String[] datos = { "FOLIO", "FECHA", "GUÍA", "TIPO", "TIPO TRACTOR", "OPERADOR QUE CARGA", "OPERADOR QUE TIRA", "TRACTOR", "REMOLQUE", "TICKET", "PESO", "R.S.P.", "F. LLEGADA", "F. SALIDA", "ESTADÍAS", "MOV. INTER.", "DOCUMENTÓ", "ESTAUS" };
/* 2054 */     this.esc = new EscribirReporte("HOJAS DE RECEPCIÓN", this.jTable2, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jComboBox20ActionPerformed(ActionEvent evt) {
/* 2058 */     String valor = String.valueOf(this.jComboBox20.getSelectedItem());
/* 2059 */     if (valor.equals("MOVIMIENTO EN FALSO")) {
/* 2060 */       this.jComboBox22.setSelectedIndex(3);
/* 2061 */     } else if (valor.equals("MOVIMIENTO INTERNO")) {
/* 2062 */       this.jComboBox22.setSelectedIndex(4);
/* 2063 */     } else if (valor.equals("MOVIMIENTO LATERAL")) {
/* 2064 */       this.jComboBox22.setSelectedIndex(5);
/*      */     } else {
/* 2066 */       this.jComboBox22.setSelectedIndex(1);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox22ActionPerformed(ActionEvent evt) {
/* 2071 */     if (this.jComboBox22.getSelectedIndex() == 3) {
/* 2072 */       this.jComboBox20.setSelectedItem("MOVIMIENTO EN FALSO");
/* 2073 */     } else if (this.jComboBox22.getSelectedIndex() == 4) {
/* 2074 */       this.jComboBox20.setSelectedItem("MOVIMIENTO INTERNO");
/* 2075 */     } else if (this.jComboBox22.getSelectedIndex() == 5) {
/* 2076 */       this.jComboBox20.setSelectedItem("MOVIMIENTO LATERAL");
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton16ActionPerformed(ActionEvent evt) {
/* 2081 */     int res = JOptionPane.showConfirmDialog(this.padre, "¿Estás seguro que deseas guardar los datos?", "Guardar Datos", 0, 3, this.PREG);
/* 2082 */     if (res == 0) {
/* 2083 */       String clave2 = "0";
/* 2084 */       String valor = String.valueOf(this.jComboBox20.getSelectedItem());
/* 2085 */       if (!valor.equals("MOVIMIENTO EN FALSO") && !valor.equals("MOVIMIENTO INTERNO") && !valor.equals("MOVIMIENTO LATERAL") && !valor.equals("PENDIENTE DESCARGA")) {
/* 2086 */         clave2 = this.CLAVEOPERADOR[this.jComboBox20.getSelectedIndex()];
/*      */       }
/* 2088 */       System.out.println("clave 2" + clave2);
/* 2089 */       this.con.inserSinMsj("update vales set ticket='" + this.jTextField27.getText() + "',peso=" + this.jTextField28.getText() + ",rsp=" + this.jTextField30.getText() + ",estadias=" + this.jTextField31.getText() + ",mov=" + this.jTextField32.getText() + ",ope_carga='" + String.valueOf(this.jComboBox23.getSelectedItem()) + "',ope_tira='" + String.valueOf(this.jComboBox20.getSelectedItem()) + "',clave1 = " + this.CLAVEOPERADOR[this.jComboBox23.getSelectedIndex()] + ",clave2=" + clave2 + " where num_vale='" + this.jTextField16.getText() + "'");
/* 2090 */       this.jDialog2.setVisible(false);
/* 2091 */       consultar();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton17ActionPerformed(ActionEvent evt) {
/* 2096 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jComboBox23ActionPerformed(ActionEvent evt) {
/* 2100 */     this.jLabel111.setText(String.valueOf(this.jComboBox23.getSelectedItem()));
/*      */   }
/*      */   public void jPintarTexto(JComponent campo) {
/* 2103 */     campo.setBackground(Color.ORANGE);
/*      */   }
/*      */   
/*      */   public void tieneTexto() {
/* 2107 */     if (!this.jTextField1.getText().equals("")) {
/* 2108 */       jPintarTexto(this.jTextField1);
/*      */     }
/* 2110 */     if (!this.jTextField2.getText().equals("")) {
/* 2111 */       jPintarTexto(this.jTextField2);
/*      */     }
/* 2113 */     if (!this.jTextField3.getText().equals("")) {
/* 2114 */       jPintarTexto(this.jTextField3);
/*      */     }
/* 2116 */     if (!this.jTextField4.getText().equals("")) {
/* 2117 */       jPintarTexto(this.jTextField4);
/*      */     }
/* 2119 */     if (!this.jTextField6.getText().equals("")) {
/* 2120 */       jPintarTexto(this.jTextField6);
/*      */     }
/* 2122 */     if (!this.jTextField7.getText().equals("")) {
/* 2123 */       jPintarTexto(this.jTextField7);
/*      */     }
/* 2125 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 2126 */       jPintarTexto(this.jComboBox1);
/*      */     }
/*      */   }
/*      */   
/*      */   public void cargarMouse() {
/*      */     try {
/* 2132 */       Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/* 2133 */       Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/* 2134 */       this.jDialog1.setCursor(micursor);
/* 2135 */     } catch (Exception e) {
/* 2136 */       JOptionPane.showMessageDialog(this, e, "Depura", -1);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void reimprimir() {
/* 2141 */     String tipo = String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 6));
/* 2142 */     this.jComboBox19.removeAllItems();
/* 2143 */     this.jComboBox17.removeAllItems();
/* 2144 */     this.jComboBox18.removeAllItems();
/* 2145 */     if (tipo.equals("MOVIMIENTO EN FALSO") || tipo.equals("MOVIMIENTO INTERNO")) {
/* 2146 */       this.jComboBox18.addItem("Selecciona uno...");
/* 2147 */       this.jComboBox18.addItem(tipo);
/* 2148 */       this.jComboBox17.addItem(tipo);
/*      */     } else {
/* 2150 */       this.jComboBox18.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "CARGADA Y TIRADA", "SÓLO CARGADA", "SÓLO TIRADA", "MOVIMIENTO LATERAL" }));
/*      */     } 
/* 2152 */     this.jComboBox18.setSelectedIndex(0);
/* 2153 */     String vale = String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0));
/* 2154 */     this.DATOS = this.con.regresaReg("vales.num_vale,guias.num_guia,f_expedicion1,f_expedicion2,ope_carga,ope_tira,llamadas_historicas.num_tracto,llamadas_historicas.num_rem,f_llegada,f_cargada,f_cargada,f_salida,plataformas.plataforma,emp_generadora.empresa,emp_destinataria.empresa,ticket,vales.peso,rsp,estadias,mov", "vales,guias,llamadas_historicas,tracto,remolque,emp_generadora,emp_destinataria,plataformas,operadores", "where vales.num_vale = guias.num_vale and llamadas_historicas.num_guia = guias.num_guia and llamadas_historicas.num_tracto = tracto.num_tracto and llamadas_historicas.num_rem = remolque.num_rem and llamadas_historicas.clave_gene = emp_generadora.clave_gene and llamadas_historicas.clave_desti = emp_destinataria.clave_desti and llamadas_historicas.num_ope = operadores.num_ope and llamadas_historicas.num_plata = plataformas.num_plata and vales.num_vale = '" + vale + "'", 20);
/* 2155 */     String f1 = this.DATOS[2].substring(8, 10) + "/" + this.DATOS[2].substring(8, 10) + "/" + this.DATOS[2].substring(5, 7);
/* 2156 */     if (!this.DATOS[5].equals("PENDIENTE DESCARGA")) {
/* 2157 */       String str = this.DATOS[3].substring(8, 10) + "/" + this.DATOS[3].substring(8, 10) + "/" + this.DATOS[2].substring(5, 7);
/*      */     }
/* 2159 */     String tipoC = String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 3));
/* 2160 */     this.TIPOTRACTOR = String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 4));
/* 2161 */     if (!tipoC.equals("SENCILLO")) {
/* 2162 */       this.jCheckBox1.setSelected(true);
/*      */     } else {
/* 2164 */       this.jCheckBox1.setSelected(false);
/*      */     } 
/* 2166 */     this.jTextField9.setText(this.DATOS[0]);
/* 2167 */     this.jTextField5.setText(this.DATOS[1]);
/* 2168 */     this.jTextField12.setText(f1);
/*      */     
/* 2170 */     this.jTextField8.setText(this.DATOS[4]);
/* 2171 */     this.jComboBox19.addItem(this.DATOS[5]);
/* 2172 */     this.jTextField19.setText(this.DATOS[6]);
/* 2173 */     this.jTextField23.setText(this.DATOS[7]);
/*      */     
/* 2175 */     this.jTextField10.setText(this.DATOS[12]);
/* 2176 */     this.jTextField11.setText(this.DATOS[13]);
/* 2177 */     this.jComboBox17.addItem(this.DATOS[14]);
/* 2178 */     this.jTextField17.setText(this.DATOS[15]);
/* 2179 */     this.jTextField18.setText(this.DATOS[16]);
/*      */     
/* 2181 */     this.jTextField24.setText(this.DATOS[17]);
/* 2182 */     this.jTextField25.setText(this.DATOS[18]);
/* 2183 */     this.jTextField13.setText(this.DATOS[19]);
/*      */     
/* 2185 */     this.jLabel84.setText(this.DATOS[4]);
/* 2186 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   public void llenarCombo() {
/* 2190 */     String[][] datos = this.con.buscarDatos(4, "num_ope,nombre,ap_pat,ap_mat", "operadores", "where num_ope <>0 order by nombre");
/* 2191 */     this.CLAVEOPERADOR = new String[datos.length];
/* 2192 */     String[] nombre = new String[datos.length];
/* 2193 */     String[] paterno = new String[datos.length];
/* 2194 */     String[] materno = new String[datos.length];
/*      */     int i;
/* 2196 */     for (i = 0; i < datos.length; i++) {
/* 2197 */       for (int k = 0; k < (datos[i]).length; k++) {
/* 2198 */         if (k == 0) {
/* 2199 */           this.CLAVEOPERADOR[i] = datos[i][k];
/*      */         }
/* 2201 */         if (k == 1) {
/* 2202 */           nombre[i] = datos[i][k];
/*      */         }
/* 2204 */         if (k == 2) {
/* 2205 */           paterno[i] = datos[i][k];
/*      */         }
/* 2207 */         if (k == 3) {
/* 2208 */           materno[i] = datos[i][k];
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 2214 */     this.jComboBox20.removeAllItems();
/* 2215 */     this.jComboBox23.removeAllItems();
/* 2216 */     for (i = 0; i < nombre.length; i++) {
/* 2217 */       this.jComboBox20.addItem(nombre[i] + " " + nombre[i] + " " + paterno[i]);
/* 2218 */       this.jComboBox23.addItem(nombre[i] + " " + nombre[i] + " " + paterno[i]);
/*      */     } 
/* 2220 */     this.jComboBox20.addItem("MOVIMIENTO EN FALSO");
/* 2221 */     this.jComboBox20.addItem("MOVIMIENTO INTERNO");
/* 2222 */     this.jComboBox20.addItem("MOVIMIENTO LATERAL");
/* 2223 */     this.jComboBox20.addItem("PENDIENTE DESCARGA");
/*      */   }
/*      */   
/*      */   public void verRSP() {
/* 2227 */     String vale = String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 0));
/* 2228 */     this.DATOS = this.con.regresaReg("vales.num_vale,guias.num_guia,f_expedicion1,f_expedicion2,ope_carga,ope_tira,llamadas_historicas.num_tracto,llamadas_historicas.num_rem,f_llegada,f_cargada,f_cargada,f_salida,plataformas.plataforma,emp_generadora.empresa,emp_destinataria.empresa,ticket,vales.peso,rsp,estadias,mov", "vales,guias,llamadas_historicas,tracto,remolque,emp_generadora,emp_destinataria,plataformas,operadores", "where vales.num_vale = guias.num_vale and llamadas_historicas.num_guia = guias.num_guia and llamadas_historicas.num_tracto = tracto.num_tracto and llamadas_historicas.num_rem = remolque.num_rem and llamadas_historicas.clave_gene = emp_generadora.clave_gene and llamadas_historicas.clave_desti = emp_destinataria.clave_desti and llamadas_historicas.num_ope = operadores.num_ope and llamadas_historicas.num_plata = plataformas.num_plata and vales.num_vale = '" + vale + "'", 20);
/* 2229 */     String f1 = this.DATOS[2].substring(8, 10) + "/" + this.DATOS[2].substring(8, 10) + "/" + this.DATOS[2].substring(5, 7);
/* 2230 */     String tipoC = String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 3));
/* 2231 */     this.TIPOTRACTOR = String.valueOf(this.jTable2.getValueAt(this.jTable2.getSelectedRow(), 4));
/* 2232 */     this.jTextField16.setText(this.DATOS[0]);
/* 2233 */     this.jTextField14.setText(this.DATOS[1]);
/*      */     
/* 2235 */     if (this.DATOS[4].equals(this.DATOS[5])) {
/* 2236 */       this.jComboBox22.setSelectedItem("CARGADA Y TIRADA");
/* 2237 */     } else if (this.DATOS[5].equals("PENDIENTE DESCARGA")) {
/* 2238 */       this.jComboBox22.setSelectedItem("SÓLO CARGADA");
/* 2239 */     } else if (this.DATOS[5].equals("MOVIMIENTO EN FALSO")) {
/* 2240 */       this.jComboBox22.setSelectedItem("MOVIMIENTO EN FALSO");
/* 2241 */     } else if (this.DATOS[5].equals("MOVIMIENTO INTERNO")) {
/* 2242 */       this.jComboBox22.setSelectedItem("MOVIMIENTO INTERNO");
/* 2243 */     } else if (this.DATOS[5].equals("MOVIMIENTO LATERAL")) {
/* 2244 */       this.jComboBox22.setSelectedItem("MOVIMIENTO LATERAL");
/*      */     } else {
/* 2246 */       this.jComboBox22.setSelectedItem("CARGADA Y TIRADA");
/*      */     } 
/* 2248 */     String fechaCorta = this.DATOS[2];
/* 2249 */     String año = fechaCorta.substring(0, 4);
/* 2250 */     String mes = fechaCorta.substring(5, 7);
/* 2251 */     String dia = fechaCorta.substring(8, 10);
/* 2252 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 2253 */     String strFecha = dia + "-" + dia + "-" + mes;
/* 2254 */     Date fechaT = null;
/*      */     try {
/* 2256 */       fechaT = formatoDelTexto.parse(strFecha);
/* 2257 */       this.jDateChooser9.setDate(fechaT);
/* 2258 */     } catch (ParseException ex) {
/* 2259 */       ex.printStackTrace();
/*      */     } 
/*      */     
/* 2262 */     fechaCorta = this.DATOS[8];
/* 2263 */     año = fechaCorta.substring(0, 4);
/* 2264 */     mes = fechaCorta.substring(5, 7);
/* 2265 */     dia = fechaCorta.substring(8, 10);
/* 2266 */     formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 2267 */     strFecha = dia + "-" + dia + "-" + mes;
/* 2268 */     fechaT = null;
/*      */     try {
/* 2270 */       fechaT = formatoDelTexto.parse(strFecha);
/* 2271 */       this.jDateChooser2.setDate(fechaT);
/* 2272 */     } catch (ParseException ex) {
/* 2273 */       ex.printStackTrace();
/*      */     } 
/*      */     
/* 2276 */     fechaCorta = this.DATOS[9];
/* 2277 */     año = fechaCorta.substring(0, 4);
/* 2278 */     mes = fechaCorta.substring(5, 7);
/* 2279 */     dia = fechaCorta.substring(8, 10);
/* 2280 */     formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 2281 */     strFecha = dia + "-" + dia + "-" + mes;
/* 2282 */     fechaT = null;
/*      */     try {
/* 2284 */       fechaT = formatoDelTexto.parse(strFecha);
/* 2285 */       this.jDateChooser8.setDate(fechaT);
/* 2286 */     } catch (ParseException ex) {
/* 2287 */       ex.printStackTrace();
/*      */     } 
/*      */     
/* 2290 */     fechaCorta = this.DATOS[10];
/* 2291 */     año = fechaCorta.substring(0, 4);
/* 2292 */     mes = fechaCorta.substring(5, 7);
/* 2293 */     dia = fechaCorta.substring(8, 10);
/* 2294 */     formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 2295 */     strFecha = dia + "-" + dia + "-" + mes;
/* 2296 */     fechaT = null;
/*      */     try {
/* 2298 */       fechaT = formatoDelTexto.parse(strFecha);
/* 2299 */       this.jDateChooser7.setDate(fechaT);
/* 2300 */     } catch (ParseException ex) {
/* 2301 */       ex.printStackTrace();
/*      */     } 
/*      */     
/* 2304 */     this.jComboBox23.setSelectedItem(this.DATOS[4]);
/* 2305 */     this.jComboBox20.setSelectedItem(this.DATOS[5]);
/*      */     
/* 2307 */     this.jTextField20.setText(this.DATOS[6]);
/* 2308 */     this.jTextField26.setText(this.DATOS[7]);
/*      */     
/* 2310 */     this.jTextField21.setText(this.DATOS[12]);
/* 2311 */     this.jTextField22.setText(this.DATOS[13]);
/* 2312 */     this.jTextField29.setText(this.DATOS[14]);
/*      */     
/* 2314 */     this.jTextField27.setText(this.DATOS[15]);
/* 2315 */     this.jTextField28.setText(this.DATOS[16]);
/* 2316 */     this.jTextField30.setText(this.DATOS[17]);
/* 2317 */     this.jTextField31.setText(this.DATOS[18]);
/* 2318 */     this.jTextField32.setText(this.DATOS[19]);
/*      */     
/* 2320 */     this.jLabel111.setText(this.DATOS[4]);
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 2324 */     boolean correcto = true;
/* 2325 */     if (this.jDateChooser4.getDate() == null) {
/* 2326 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de inicio no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha actual en el campo?</html>", "FECHA DE INICIO VACÍA", 0, 3, this.PREG);
/* 2327 */       if (res == 0) {
/* 2328 */         this.jDateChooser4.setDate(this.fechaActual);
/* 2329 */         correcto = true;
/*      */       } else {
/* 2331 */         correcto = false;
/*      */       } 
/* 2333 */     } else if (this.jDateChooser5.getDate() == null) {
/* 2334 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de término no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha de ininio?</html>", "FECHA DE TÉRMINO VACÍA", 0, 3, this.PREG);
/* 2335 */       if (res == 0) {
/* 2336 */         this.jDateChooser5.setDate(this.fechaActual);
/* 2337 */         correcto = true;
/*      */       } else {
/* 2339 */         correcto = false;
/*      */       } 
/* 2341 */     } else if (correcto) {
/* 2342 */       Date fecha1 = this.jDateChooser4.getDate();
/* 2343 */       Date fecha2 = this.jDateChooser5.getDate();
/*      */       
/* 2345 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 2346 */       String cadenaFecha = "";
/* 2347 */       cadenaFecha = formato.format(fecha1);
/* 2348 */       String AÑO = cadenaFecha.substring(0, 4);
/* 2349 */       String MES = cadenaFecha.substring(4, 6);
/* 2350 */       String DIA = cadenaFecha.substring(6, 8);
/* 2351 */       String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */       
/* 2353 */       cadenaFecha = formato.format(fecha2);
/* 2354 */       int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 2355 */       int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 2356 */       int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/* 2357 */       int diasTotal = diasDelMes(mm - 1, aa);
/* 2358 */       SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 2359 */       String strFecha = "";
/* 2360 */       if (diasTotal == dd) {
/* 2361 */         dd = 1;
/* 2362 */         if (mm == 11) {
/* 2363 */           aa++;
/* 2364 */           mm = 0;
/*      */         } else {
/* 2366 */           mm++;
/*      */         } 
/*      */       } else {
/* 2369 */         dd++;
/*      */       } 
/* 2371 */       String año = "" + aa;
/* 2372 */       String mes = "" + mm;
/* 2373 */       String dia = "" + dd;
/* 2374 */       formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 2375 */       strFecha = dia + "-" + dia + "-" + mes;
/* 2376 */       String fechaCompleta2 = "'" + año + "-" + mes + "-" + dia + "'";
/*      */       
/* 2378 */       this.jButton11.setEnabled(false);
/* 2379 */       String estado = "";
/* 2380 */       if (this.jComboBox1.getSelectedIndex() != 2) {
/* 2381 */         estado = String.valueOf(this.jComboBox1.getSelectedItem());
/*      */       }
/* 2383 */       this.jTable2.setModel(new DefaultTableModel((Object[][])this.con
/* 2384 */             .buscarDatos(16, "vales.num_vale,f_expedicion1,num_guia,vales.tipo,ope_carga,ope_tira,ticket,peso,rsp,f_llegada,f_salida,estadias,mov,nombre_usu,vales.estado,folio_liq1, folio_liq2", "vales", "where vales.num<>0 and vales.estado like '%" + estado + "%' and vales.num_vale like '%" + this.jTextField1.getText() + "%' and num_guia like '%" + this.jTextField2.getText() + "%' and ope_carga like '%" + this.jTextField3.getText() + "%' and ope_tira like '%" + this.jTextField4.getText() + "%' and f_expedicion1 between " + fechaCompleta1 + " and " + fechaCompleta2 + " order by f_expedicion1 desc"), (Object[])new String[] { "Folio", "Fecha", "Guía", "Tipo", "Operador que Carga", "Operador que Tira", "Ticket", "Peso", "RSP", "F. Llegada", "F. Salida", "Estadías", "Mov Inter.", "Documentó", "Estado", "Pagada Liq1", "Pagada Liq 2" })
/*      */           {
/*      */ 
/*      */ 
/*      */             
/* 2389 */             boolean[] canEdit = new boolean[] { 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false };
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2394 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 2397 */       this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + this.jTable2.getRowCount() + "</HTML>");
/* 2398 */       this.jTable2.setShowVerticalLines(false);
/* 2399 */       this.jScrollPane2.setViewportView(this.jTable2);
/*      */       
/* 2401 */       this.jTable2.getColumnModel().getColumn(0).setMinWidth(80);
/* 2402 */       this.jTable2.getColumnModel().getColumn(0).setMaxWidth(80);
/* 2403 */       this.jTable2.getColumnModel().getColumn(1).setMinWidth(100);
/* 2404 */       this.jTable2.getColumnModel().getColumn(1).setMaxWidth(100);
/* 2405 */       this.jTable2.getColumnModel().getColumn(2).setMinWidth(80);
/* 2406 */       this.jTable2.getColumnModel().getColumn(2).setMaxWidth(80);
/* 2407 */       this.jTable2.getColumnModel().getColumn(3).setMinWidth(70);
/* 2408 */       this.jTable2.getColumnModel().getColumn(3).setMaxWidth(70);
/* 2409 */       this.jTable2.getColumnModel().getColumn(4).setMinWidth(230);
/* 2410 */       this.jTable2.getColumnModel().getColumn(4).setMaxWidth(230);
/* 2411 */       this.jTable2.getColumnModel().getColumn(5).setMinWidth(230);
/* 2412 */       this.jTable2.getColumnModel().getColumn(5).setMaxWidth(230);
/* 2413 */       this.jTable2.getColumnModel().getColumn(7).setMinWidth(50);
/* 2414 */       this.jTable2.getColumnModel().getColumn(7).setMaxWidth(50);
/* 2415 */       this.jTable2.getColumnModel().getColumn(8).setMinWidth(60);
/* 2416 */       this.jTable2.getColumnModel().getColumn(8).setMaxWidth(60);
/* 2417 */       this.jTable2.getColumnModel().getColumn(9).setMinWidth(70);
/* 2418 */       this.jTable2.getColumnModel().getColumn(9).setMaxWidth(70);
/*      */       
/* 2420 */       this.jTable2.setSelectionMode(0);
/* 2421 */       this.jTable2.setAutoCreateRowSorter(true);
/* 2422 */       this.jTable2.getTableHeader().setReorderingAllowed(false);
/*      */       
/* 2424 */       String[] arre = this.con.regresaColIndex("num_vale", "vales", "where ope_tira = 'movimiento en falso' || OPE_TIRA = 'MOVIMIENTO INTERNO'");
/* 2425 */       this.celda.pasarInd(arre);
/*      */       
/* 2427 */       this.celda.pasarInd2(this.con.revisarCol(this.jTable2, "PENDIENTE DESCARGA", 0, 5, 0));
/*      */       
/* 2429 */       this.jTable2.getColumnModel().getColumn(0).setCellRenderer(this.celda);
/* 2430 */       this.jTable2.getColumnModel().getColumn(1).setCellRenderer(this.celda);
/* 2431 */       this.jTable2.getColumnModel().getColumn(2).setCellRenderer(this.celda);
/* 2432 */       this.jTable2.getColumnModel().getColumn(5).setCellRenderer(this.celda);
/* 2433 */       this.jTable2.getColumnModel().getColumn(3).setCellRenderer(this.celda);
/* 2434 */       this.jTable2.getColumnModel().getColumn(4).setCellRenderer(this.celda);
/* 2435 */       this.jTable2.getColumnModel().getColumn(6).setCellRenderer(this.celda);
/* 2436 */       this.jTable2.getColumnModel().getColumn(7).setCellRenderer(this.celda);
/* 2437 */       this.jTable2.getColumnModel().getColumn(8).setCellRenderer(this.celda);
/* 2438 */       this.jTable2.getColumnModel().getColumn(9).setCellRenderer(this.celda);
/* 2439 */       this.jTable2.getColumnModel().getColumn(10).setCellRenderer(this.celda);
/* 2440 */       this.jTable2.getColumnModel().getColumn(11).setCellRenderer(this.celda);
/* 2441 */       this.jTable2.getColumnModel().getColumn(12).setCellRenderer(this.celda);
/* 2442 */       this.jTable2.getColumnModel().getColumn(13).setCellRenderer(this.celda);
/* 2443 */       this.jTable2.getColumnModel().getColumn(14).setCellRenderer(this.celda);
/* 2444 */       this.jTable2.getColumnModel().getColumn(15).setCellRenderer(this.celda);
/* 2445 */       this.jTable2.getColumnModel().getColumn(16).setCellRenderer(this.celda);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void RSP(String usu) {
/* 2453 */     this.USUARIO = usu;
/* 2454 */     this.con.consultar("nombre", "usuarios,empleados", "where empleados.clave_emp = usuarios.num_emp and nombre_usu = '" + this.USUARIO + "'");
/* 2455 */     this.NOMBRE = this.con.Campo;
/* 2456 */     this.con.consultar("ap_pat", "usuarios,empleados", "where empleados.clave_emp = usuarios.num_emp and nombre_usu = '" + this.USUARIO + "'");
/* 2457 */     this.NOMBRE = this.NOMBRE + " " + this.NOMBRE;
/* 2458 */     this.con.consultar("ap_mat", "usuarios,empleados", "where empleados.clave_emp = usuarios.num_emp and nombre_usu = '" + this.USUARIO + "'");
/* 2459 */     this.NOMBRE = this.NOMBRE + " " + this.NOMBRE;
/* 2460 */     this.jLabel83.setText(this.NOMBRE);
/* 2461 */     this.fecha = new Date();
/* 2462 */     this.fechaActual = new Date();
/* 2463 */     this.jDateChooser4.setDate(this.fechaActual);
/* 2464 */     this.jDateChooser4.setMaxSelectableDate(this.fechaActual);
/* 2465 */     this.jDateChooser5.setDate(this.fechaActual);
/* 2466 */     this.jDateChooser5.setMaxSelectableDate(this.fechaActual);
/* 2467 */     consultar();
/* 2468 */     this.panel.setViewportView(this);
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 2472 */     this.jComboBox18.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2474 */             RSP.this.jTextGanado(RSP.this.jComboBox18, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2478 */             RSP.this.jTextPerdido(RSP.this.jComboBox18, evt);
/*      */           }
/*      */         });
/* 2481 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2483 */             RSP.this.jTextGanado(RSP.this.jComboBox1, evt);
/* 2484 */             RSP.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2488 */             RSP.this.jTextPerdido(RSP.this.jComboBox1, evt);
/* 2489 */             RSP.this.tieneTexto();
/*      */           }
/*      */         });
/* 2492 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2494 */             RSP.this.jTextGanado(RSP.this.jTextField1, evt);
/* 2495 */             RSP.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2499 */             RSP.this.jTextPerdido(RSP.this.jTextField1, evt);
/* 2500 */             RSP.this.tieneTexto();
/*      */           }
/*      */         });
/* 2503 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2505 */             RSP.this.jTextGanado(RSP.this.jTextField2, evt);
/* 2506 */             RSP.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2510 */             RSP.this.jTextPerdido(RSP.this.jTextField2, evt);
/* 2511 */             RSP.this.tieneTexto();
/*      */           }
/*      */         });
/* 2514 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2516 */             RSP.this.jTextGanado(RSP.this.jTextField3, evt);
/* 2517 */             RSP.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2521 */             RSP.this.jTextPerdido(RSP.this.jTextField3, evt);
/* 2522 */             RSP.this.tieneTexto();
/*      */           }
/*      */         });
/* 2525 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2527 */             RSP.this.jTextGanado(RSP.this.jTextField4, evt);
/* 2528 */             RSP.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2532 */             RSP.this.jTextPerdido(RSP.this.jTextField4, evt);
/* 2533 */             RSP.this.tieneTexto();
/*      */           }
/*      */         });
/* 2536 */     this.jTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2538 */             RSP.this.jTextGanado(RSP.this.jTextField5, evt);
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2542 */             RSP.this.jTextPerdido(RSP.this.jTextField5, evt);
/*      */           }
/*      */         });
/* 2545 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2547 */             RSP.this.jTextGanado(RSP.this.jTextField6, evt);
/* 2548 */             RSP.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2552 */             RSP.this.jTextPerdido(RSP.this.jTextField6, evt);
/* 2553 */             RSP.this.tieneTexto();
/*      */           }
/*      */         });
/* 2556 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 2558 */             RSP.this.jTextGanado(RSP.this.jTextField7, evt);
/* 2559 */             RSP.this.tieneTexto();
/*      */           }
/*      */           
/*      */           public void focusLost(FocusEvent evt) {
/* 2563 */             RSP.this.jTextPerdido(RSP.this.jTextField7, evt);
/* 2564 */             RSP.this.tieneTexto();
/*      */           }
/*      */         });
/*      */   }
/*      */   
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 2570 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 2574 */     campo.setBackground(Color.white);
/*      */   }
/*      */   
/*      */   public int diasDelMes(int mes, int año) {
/* 2578 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 2586 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 2592 */         return 30;
/*      */       
/*      */       case 1:
/* 2595 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 2597 */           return 29;
/*      */         }
/* 2599 */         return 28;
/*      */     } 
/*      */ 
/*      */     
/* 2603 */     return 0;
/*      */   }
/*      */   
/*      */   class CeldaRender
/*      */     extends DefaultTableCellRenderer
/*      */   {
/* 2609 */     int otro = -1;
/* 2610 */     String[] indices = new String[0];
/* 2611 */     String[] indices2 = new String[0];
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 2614 */       setEnabled((table == null || table.isEnabled()));
/* 2615 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 2616 */       if (comparar(comp)) {
/* 2617 */         setBackground(Color.ORANGE);
/* 2618 */         setForeground(Color.red);
/* 2619 */       } else if (comparar2(comp)) {
/* 2620 */         setBackground(Color.LIGHT_GRAY);
/* 2621 */         setForeground(Color.RED);
/* 2622 */       } else if (row % 2 == 0 && (column == 0 || column == 5 || column == 6)) {
/* 2623 */         setBackground(new Color(120, 200, 104));
/* 2624 */         setForeground(Color.black);
/* 2625 */       } else if (row % 2 == 0 && column == 2) {
/* 2626 */         setBackground(new Color(136, 191, 173));
/* 2627 */         setForeground(Color.black);
/* 2628 */       } else if (row % 2 == 0) {
/* 2629 */         setBackground(new Color(194, 213, 151));
/* 2630 */         setForeground(Color.black);
/*      */       } else {
/* 2632 */         setBackground((Color)null);
/* 2633 */         setForeground(Color.black);
/*      */       } 
/* 2635 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 2636 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 2640 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 2644 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 2648 */       for (int i = 0; i < this.indices.length; i++) {
/* 2649 */         if (this.indices[i].equals(reg)) {
/* 2650 */           return true;
/*      */         }
/*      */       } 
/* 2653 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 2657 */       for (int i = 0; i < this.indices2.length; i++) {
/* 2658 */         if (this.indices2[i].equals(reg)) {
/* 2659 */           return true;
/*      */         }
/*      */       } 
/* 2662 */       return false;
/*      */     } }
/*      */   
/*      */   class ImprimirRSP implements Printable { String[] DATOS;
/*      */     int opc;
/*      */     
/* 2668 */     ImprimirRSP() { this.DATOS = new String[] { "sdfsdf", "sdfsdf", "sdfsdf" };
/* 2669 */       this.opc = 0; } public int print(Graphics g, PageFormat f, int pageIndex) { Font fuente; String nombre, nombres[]; int esp, i; String nombre1;
/*      */       int j;
/*      */       String tipo, viaje;
/* 2672 */       Graphics2D g2 = (Graphics2D)g;
/* 2673 */       switch (pageIndex) {
/*      */         case 0:
/* 2675 */           g.setColor(Color.black);
/* 2676 */           g2 = (Graphics2D)g;
/* 2677 */           fuente = new Font("ARIAL", 0, 8);
/* 2678 */           g.setFont(fuente);
/* 2679 */           g.drawString(this.DATOS[0], 113, 35);
/* 2680 */           g.drawString(this.DATOS[1], 185, 35);
/* 2681 */           g.drawString(this.DATOS[2], 270, 35);
/* 2682 */           g.drawString(this.DATOS[3], 160, 50);
/* 2683 */           fuente = new Font("ARIAL", 0, 7);
/* 2684 */           g.setFont(fuente);
/* 2685 */           if (this.DATOS[3].contains("SÓLO TIRADA")) {
/* 2686 */             this.DATOS[4] = "--------------------------------------------";
/*      */           }
/*      */           
/* 2689 */           g.drawString(this.DATOS[4], 115, 90);
/* 2690 */           g.drawString(this.DATOS[5], 115, 107);
/*      */           
/* 2692 */           fuente = new Font("ARIAL", 0, 9);
/* 2693 */           g.setFont(fuente);
/* 2694 */           g.drawString(this.DATOS[6], 122, 130);
/* 2695 */           g.drawString(this.DATOS[7], 260, 130);
/*      */           
/* 2697 */           fuente = new Font("ARIAL", 0, 7);
/* 2698 */           g.setFont(fuente);
/* 2699 */           g.drawString(this.DATOS[8], 125, 160);
/* 2700 */           g.drawString(this.DATOS[9], 265, 160);
/*      */           
/* 2702 */           g.drawString(this.DATOS[10], 115, 202);
/* 2703 */           g.drawString(this.DATOS[11], 115, 220);
/* 2704 */           g.drawString(this.DATOS[12], 115, 239);
/*      */           
/* 2706 */           fuente = new Font("ARIAL", 0, 8);
/* 2707 */           g.setFont(fuente);
/*      */           
/* 2709 */           if (this.DATOS[13].equals("")) {
/* 2710 */             this.DATOS[13] = "0";
/*      */           }
/* 2712 */           g.drawString(this.DATOS[13], 118, 262);
/* 2713 */           if (this.DATOS[14].equals("")) {
/* 2714 */             this.DATOS[14] = "0";
/*      */           }
/* 2716 */           g.drawString(this.DATOS[14], 238, 262);
/* 2717 */           if (this.DATOS[15].equals("")) {
/* 2718 */             this.DATOS[15] = "0";
/*      */           }
/* 2720 */           g.drawString(this.DATOS[15], 94, 297);
/* 2721 */           if (this.DATOS[16].equals("")) {
/* 2722 */             this.DATOS[16] = "0";
/*      */           }
/* 2724 */           g.drawString(this.DATOS[16], 192, 297);
/* 2725 */           if (this.DATOS[17].equals("")) {
/* 2726 */             this.DATOS[17] = "0";
/*      */           }
/* 2728 */           g.drawString(this.DATOS[17], 282, 297);
/* 2729 */           fuente = new Font("ARIAL", 0, 6);
/* 2730 */           g.setFont(fuente);
/* 2731 */           nombre = "";
/*      */           
/* 2733 */           esp = 0;
/*      */           
/* 2735 */           for (i = 0; i < this.DATOS[18].length(); i++) {
/* 2736 */             if (this.DATOS[18].charAt(i) == ' ') {
/* 2737 */               esp++;
/*      */             }
/*      */           } 
/* 2740 */           nombres = new String[esp + 1];
/* 2741 */           for (i = 0; i <= esp; i++) {
/* 2742 */             nombres[i] = "";
/*      */           }
/* 2744 */           esp = 0;
/* 2745 */           for (i = 0; i < this.DATOS[18].length(); i++) {
/* 2746 */             if (this.DATOS[18].charAt(i) == ' ') {
/* 2747 */               esp++;
/*      */             } else {
/* 2749 */               nombres[esp] = nombres[esp] + nombres[esp];
/*      */             } 
/*      */           } 
/* 2752 */           for (i = 0; i < nombres.length; i++) {
/* 2753 */             if (i == 0) {
/* 2754 */               nombre = nombres[i];
/* 2755 */             } else if (!nombres[i].equals("")) {
/* 2756 */               nombre = nombre + " " + nombre + ". ";
/*      */             } 
/*      */           } 
/*      */           
/* 2760 */           esp = 0;
/* 2761 */           nombre1 = "";
/* 2762 */           for (j = 0; j < this.DATOS[19].length(); j++) {
/* 2763 */             if (this.DATOS[19].charAt(j) == ' ') {
/* 2764 */               esp++;
/*      */             }
/*      */           } 
/* 2767 */           nombres = new String[esp + 1];
/* 2768 */           for (j = 0; j <= esp; j++) {
/* 2769 */             nombres[j] = "";
/*      */           }
/* 2771 */           esp = 0;
/* 2772 */           for (j = 0; j < this.DATOS[19].length(); j++) {
/* 2773 */             if (this.DATOS[19].charAt(j) == ' ') {
/* 2774 */               esp++;
/*      */             } else {
/* 2776 */               nombres[esp] = nombres[esp] + nombres[esp];
/*      */             } 
/*      */           } 
/* 2779 */           for (j = 0; j < nombres.length; j++) {
/* 2780 */             if (j == 0) {
/* 2781 */               nombre1 = nombres[j];
/* 2782 */             } else if (!nombres[j].equals("")) {
/* 2783 */               nombre = nombre + " " + nombre + ". ";
/*      */             } 
/*      */           } 
/*      */           
/* 2787 */           fuente = new Font("ARIAL", 1, 11);
/* 2788 */           g.setFont(fuente);
/* 2789 */           tipo = "";
/* 2790 */           if (this.DATOS[20].equals("GÓNDOLA")) {
/* 2791 */             tipo = "G";
/*      */           } else {
/* 2793 */             tipo = "PYV";
/*      */           } 
/* 2795 */           g.drawString(tipo, 280, 72);
/* 2796 */           fuente = new Font("ARIAL", 0, 7);
/* 2797 */           g.setFont(fuente);
/* 2798 */           viaje = "";
/* 2799 */           if (this.DATOS[21].equals("FULL")) {
/* 2800 */             viaje = "TIPO DE VIAJE: FULL";
/*      */           } else {
/* 2802 */             viaje = "TIPO DE VIAJE: SENCILLO";
/*      */           } 
/* 2804 */           g.drawString(viaje, 100, 385);
/* 2805 */           g.drawString(nombre, 80, 330);
/* 2806 */           g.drawString(nombre1, 230, 330);
/*      */           
/* 2808 */           return 0;
/*      */       } 
/* 2810 */       return 1; }
/*      */ 
/*      */ 
/*      */     
/*      */     public void recibeDatos(String[] datos) {
/* 2815 */       ImprimirRSP im = new ImprimirRSP();
/* 2816 */       im.DATOS = datos;
/* 2817 */       PrinterJob job = PrinterJob.getPrinterJob();
/* 2818 */       job.setPrintable(im);
/* 2819 */       if (job.printDialog())
/*      */         try {
/* 2821 */           job.print();
/* 2822 */         } catch (PrinterException e) {
/* 2823 */           JOptionPane.showMessageDialog(null, "Error al imprimir " + e.getMessage());
/*      */         }  
/*      */     } }
/*      */ 
/*      */   
/*      */   public class Presionado
/*      */     implements Runnable
/*      */   {
/*      */     Thread t;
/* 2832 */     int cont = 0;
/*      */     
/*      */     public Presionado() {
/* 2835 */       this.t = new Thread(this);
/* 2836 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/*      */       try {
/* 2844 */         Thread.currentThread(); Thread.sleep(1000L);
/* 2845 */         detener();
/* 2846 */       } catch (InterruptedException interruptedException) {}
/*      */     }
/*      */ 
/*      */     
/*      */     public void detener() {
/* 2851 */       RSP.this.consultar();
/* 2852 */       this.t.stop();
/*      */     }
/*      */     
/*      */     public void detenerFuera() {
/* 2856 */       this.t.stop();
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/RSP.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */