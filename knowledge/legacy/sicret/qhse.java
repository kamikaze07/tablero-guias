/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Font;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Date;
/*      */ import java.util.Vector;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ 
/*      */ public class qhse extends JPanel {
/*      */   Border borde;
/*      */   Color color;
/*      */   JFrame padre;
/*      */   JScrollPane panel;
/*   29 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   30 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   31 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   32 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   33 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   34 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   35 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   36 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   37 */   Consultas con = new Consultas();
/*      */   boolean encontrado = false;
/*      */   MostrarTabla modelo;
/*   40 */   String[] Campos = new String[] { "Núm.", "Nombre", "Apellido Paterno", "Apellido Materno", "Calle", "Número", "Colonia", "C.P.", "Ciduad", "Estado", "Teléfono 1", "Teléfono 2", "Correo", "Fecha de Nacimiento", "Sexo", "Abogados" };
/*      */   JTabbedPane fichas;
/*      */   String USUARIO;
/*      */   JTable tabla;
/*      */   EscribirReporte esc;
/*   45 */   Errores error = new Errores(false);
/*   46 */   Validaciones val = new Validaciones();
/*   47 */   String CLAVE = "";
/*   48 */   Date fechaInicio = null;
/*   49 */   Date fechaTermino = null;
/*   50 */   Date fechaActual = new Date();
/*   51 */   Date fecha = new Date();
/*   52 */   Esperando espe = null;
/*   53 */   int CONT = 0;
/*   54 */   CeldaRender celda = new CeldaRender();
/*   55 */   String SEMARNAT = ""; private JButton jButton1; private JComboBox jComboBox1; private JComboBox jComboBox2; private JComboBox jComboBox3; private JComboBox jComboBox4; private JComboBox jComboBox5; private JComboBox jComboBox6; private JComboBox jComboBox7; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDialog jDialog1; private JDialog jDialog2; private JLabel jLabel1; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel16; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24;
/*      */   
/*      */   public qhse(JScrollPane panelito, String usua, JTabbedPane fichas, JTable Tabla, String num, JFrame padre) {
/*   58 */     this.USUARIO = usua;
/*      */     
/*   60 */     this.fichas = fichas;
/*   61 */     this.padre = padre;
/*   62 */     initComponents();
/*   63 */     panelito.setViewportView(this);
/*   64 */     this.panel = panelito;
/*   65 */     colorear();
/*   66 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*   67 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*   68 */     this.jLabel1.setCursor(micursor);
/*   69 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*   70 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*   71 */     this.jLabel1.setCursor(micursor);
/*   72 */     this.jLabel8.setCursor(micursor);
/*      */     
/*   74 */     int w = this.tama.width;
/*   75 */     int h = this.tama.height;
/*   76 */     int rw = (w - 1100) / 2;
/*   77 */     int rh = (h - 350) / 2;
/*   78 */     this.jDialog1.setLocation(rw, rh);
/*   79 */     this.jDialog1.setSize(1100, 350);
/*   80 */     this.jDialog1.setVisible(false);
/*   81 */     this.jDialog1.setResizable(false);
/*      */     
/*   83 */     w = this.tama.width;
/*   84 */     h = this.tama.height;
/*   85 */     rw = (w - 1100) / 2;
/*   86 */     rh = (h - 350) / 2;
/*   87 */     this.jDialog2.setLocation(rw, rh);
/*   88 */     this.jDialog2.setSize(1100, 350);
/*   89 */     this.jDialog2.setVisible(false);
/*   90 */     this.jDialog2.setResizable(false);
/*   91 */     llenarCombos();
/*   92 */     this.con.consultar("SEMARNAT", "configuraciones", "");
/*   93 */     this.SEMARNAT = this.con.Campo;
/*   94 */     this.jTextField5.setText(this.SEMARNAT);
/*      */   }
/*      */   private JLabel jLabel25; private JLabel jLabel26; private JLabel jLabel27; private JLabel jLabel3; private JLabel jLabel4; private JLabel jLabel5; private JLabel jLabel54; private JLabel jLabel6; private JLabel jLabel7; private JLabel jLabel8; private JPanel jPanel17; private JPanel jPanel18; private JPanel jPanel19; private JPanel jPanel27; private JScrollPane jScrollPane1; private JScrollPane jScrollPane3; private JScrollPane jScrollPane4; private JSeparator jSeparator1; private JTable jTable1; private JTable jTable3; private JTable jTable4; private JTextField jTextField1; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5;
/*      */   
/*      */   private void initComponents() {
/*   99 */     this.jDialog1 = new JDialog();
/*  100 */     this.jScrollPane3 = new JScrollPane();
/*  101 */     this.jTable3 = new JTable();
/*  102 */     this.jDialog2 = new JDialog();
/*  103 */     this.jScrollPane4 = new JScrollPane();
/*  104 */     this.jTable4 = new JTable();
/*  105 */     this.jPanel27 = new JPanel();
/*  106 */     this.jLabel54 = new JLabel();
/*  107 */     this.jPanel17 = new JPanel();
/*  108 */     this.jLabel14 = new JLabel();
/*  109 */     this.jTextField1 = new JTextField();
/*  110 */     this.jLabel15 = new JLabel();
/*  111 */     this.jLabel16 = new JLabel();
/*  112 */     this.jTextField2 = new JTextField();
/*  113 */     this.jLabel17 = new JLabel();
/*  114 */     this.jTextField3 = new JTextField();
/*  115 */     this.jTextField4 = new JTextField();
/*  116 */     this.jLabel18 = new JLabel();
/*  117 */     this.jTextField5 = new JTextField();
/*  118 */     this.jPanel18 = new JPanel();
/*  119 */     this.jLabel19 = new JLabel();
/*  120 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  121 */     this.jLabel20 = new JLabel();
/*  122 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  123 */     this.jLabel1 = new JLabel();
/*  124 */     this.jPanel19 = new JPanel();
/*  125 */     this.jLabel22 = new JLabel();
/*  126 */     this.jComboBox2 = new JComboBox();
/*  127 */     this.jLabel23 = new JLabel();
/*  128 */     this.jComboBox3 = new JComboBox();
/*  129 */     this.jLabel24 = new JLabel();
/*  130 */     this.jComboBox4 = new JComboBox();
/*  131 */     this.jLabel25 = new JLabel();
/*  132 */     this.jComboBox5 = new JComboBox();
/*  133 */     this.jLabel26 = new JLabel();
/*  134 */     this.jComboBox6 = new JComboBox();
/*  135 */     this.jLabel27 = new JLabel();
/*  136 */     this.jComboBox7 = new JComboBox();
/*  137 */     this.jLabel8 = new JLabel();
/*  138 */     this.jLabel21 = new JLabel();
/*  139 */     this.jComboBox1 = new JComboBox();
/*  140 */     this.jLabel2 = new JLabel();
/*  141 */     this.jSeparator1 = new JSeparator();
/*  142 */     this.jLabel3 = new JLabel();
/*  143 */     this.jLabel4 = new JLabel();
/*  144 */     this.jLabel5 = new JLabel();
/*  145 */     this.jLabel6 = new JLabel();
/*  146 */     this.jLabel7 = new JLabel();
/*  147 */     this.jButton1 = new JButton();
/*  148 */     this.jScrollPane1 = new JScrollPane();
/*  149 */     this.jTable1 = new JTable();
/*      */     
/*  151 */     this.jDialog1.setTitle("Dialogo 1 - tabla 3");
/*      */     
/*  153 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/*  154 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Equipo", "Pozo", "Cliente", "Residuo", "Tipo", "Tons.", "Manifiesto", "Certificado", "Fecha", "Operador", "Tractor", "Placas", "Remolque", "Placas", "Destino", "Semarnat", "Municipio" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  162 */     this.jTable3.setShowVerticalLines(false);
/*  163 */     this.jScrollPane3.setViewportView(this.jTable3);
/*      */     
/*  165 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  166 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  167 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  168 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  169 */         .addGroup(jDialog1Layout.createSequentialGroup()
/*  170 */           .addContainerGap()
/*  171 */           .addComponent(this.jScrollPane3, -1, 730, 32767)
/*  172 */           .addContainerGap()));
/*      */     
/*  174 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  175 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  176 */         .addGroup(jDialog1Layout.createSequentialGroup()
/*  177 */           .addContainerGap()
/*  178 */           .addComponent(this.jScrollPane3, -2, 258, -2)
/*  179 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  182 */     this.jDialog2.setTitle("Dialogo 2 - tabla 4");
/*      */     
/*  184 */     this.jTable4.setFont(new Font("Tahoma", 0, 10));
/*  185 */     this.jTable4.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Equipo", "Pozo", "Cliente", "Residuo", "Tipo", "Tons.", "Manifiesto", "Certificado", "Fecha", "Destino", "semarnat", "Municipio" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  193 */     this.jTable4.setShowVerticalLines(false);
/*  194 */     this.jScrollPane4.setViewportView(this.jTable4);
/*      */     
/*  196 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/*  197 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/*  198 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/*  199 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  200 */         .addGroup(jDialog2Layout.createSequentialGroup()
/*  201 */           .addContainerGap()
/*  202 */           .addComponent(this.jScrollPane4, -1, 730, 32767)
/*  203 */           .addContainerGap()));
/*      */     
/*  205 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/*  206 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  207 */         .addGroup(jDialog2Layout.createSequentialGroup()
/*  208 */           .addContainerGap()
/*  209 */           .addComponent(this.jScrollPane4, -2, 258, -2)
/*  210 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  213 */     this.jPanel27.setBackground(new Color(146, 193, 134));
/*  214 */     this.jPanel27.setBorder(BorderFactory.createEtchedBorder());
/*      */     
/*  216 */     this.jLabel54.setFont(new Font("Tahoma", 1, 18));
/*  217 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/*  218 */     this.jLabel54.setHorizontalAlignment(0);
/*  219 */     this.jLabel54.setText("REPORTE QHSE");
/*      */     
/*  221 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/*  222 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Información sobre Directivas", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  224 */     this.jLabel14.setFont(new Font("Tahoma", 3, 11));
/*  225 */     this.jLabel14.setForeground(new Color(15, 87, 51));
/*  226 */     this.jLabel14.setHorizontalAlignment(4);
/*  227 */     this.jLabel14.setText("Municipio");
/*      */     
/*  229 */     this.jTextField1.setText("PR-A");
/*      */     
/*  231 */     this.jLabel15.setFont(new Font("Tahoma", 3, 11));
/*  232 */     this.jLabel15.setForeground(new Color(15, 87, 51));
/*  233 */     this.jLabel15.setHorizontalAlignment(4);
/*  234 */     this.jLabel15.setText("Activo");
/*      */     
/*  236 */     this.jLabel16.setFont(new Font("Tahoma", 3, 11));
/*  237 */     this.jLabel16.setForeground(new Color(15, 87, 51));
/*  238 */     this.jLabel16.setHorizontalAlignment(4);
/*  239 */     this.jLabel16.setText("Campo");
/*      */     
/*  241 */     this.jTextField2.setText("FURBERO");
/*      */     
/*  243 */     this.jLabel17.setFont(new Font("Tahoma", 3, 11));
/*  244 */     this.jLabel17.setForeground(new Color(15, 87, 51));
/*  245 */     this.jLabel17.setHorizontalAlignment(4);
/*  246 */     this.jLabel17.setText("Ent Federativa");
/*      */     
/*  248 */     this.jTextField3.setText("VERACRUZ");
/*      */     
/*  250 */     this.jTextField4.setText("PAPANTLA");
/*      */     
/*  252 */     this.jLabel18.setFont(new Font("Tahoma", 3, 11));
/*  253 */     this.jLabel18.setForeground(new Color(15, 87, 51));
/*  254 */     this.jLabel18.setHorizontalAlignment(4);
/*  255 */     this.jLabel18.setText("Semarnat");
/*      */     
/*  257 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/*  258 */     this.jPanel17.setLayout(jPanel17Layout);
/*  259 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/*  260 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  261 */         .addGroup(jPanel17Layout.createSequentialGroup()
/*  262 */           .addContainerGap()
/*  263 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  264 */             .addGroup(jPanel17Layout.createSequentialGroup()
/*  265 */               .addGap(2, 2, 2)
/*  266 */               .addComponent(this.jLabel15, -2, 58, -2))
/*  267 */             .addComponent(this.jLabel14, -2, 60, -2))
/*  268 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  269 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  270 */             .addComponent(this.jTextField4)
/*  271 */             .addComponent(this.jTextField1, -2, 120, -2))
/*  272 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  273 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  274 */             .addComponent(this.jLabel18, -1, -1, 32767)
/*  275 */             .addComponent(this.jLabel16, -2, 72, -2))
/*  276 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  277 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  278 */             .addComponent(this.jTextField5)
/*  279 */             .addComponent(this.jTextField2, -2, 112, -2))
/*  280 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  281 */           .addComponent(this.jLabel17, -2, 94, -2)
/*  282 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  283 */           .addComponent(this.jTextField3, -2, 102, -2)
/*  284 */           .addContainerGap(21, 32767)));
/*      */     
/*  286 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/*  287 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  288 */         .addGroup(jPanel17Layout.createSequentialGroup()
/*  289 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  290 */             .addComponent(this.jTextField1, -2, -1, -2)
/*  291 */             .addComponent(this.jTextField2, -2, -1, -2)
/*  292 */             .addComponent(this.jLabel16)
/*  293 */             .addComponent(this.jLabel15)
/*  294 */             .addComponent(this.jLabel17)
/*  295 */             .addComponent(this.jTextField3, -2, -1, -2))
/*  296 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  297 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  298 */             .addComponent(this.jTextField4, -2, -1, -2)
/*  299 */             .addComponent(this.jLabel18)
/*  300 */             .addComponent(this.jTextField5, -2, -1, -2)
/*  301 */             .addComponent(this.jLabel14))
/*  302 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  305 */     this.jPanel18.setBackground(new Color(146, 193, 134));
/*  306 */     this.jPanel18.setBorder(BorderFactory.createTitledBorder(null, "Establecer Periodo", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  308 */     this.jLabel19.setFont(new Font("Tahoma", 3, 11));
/*  309 */     this.jLabel19.setForeground(new Color(15, 87, 51));
/*  310 */     this.jLabel19.setText("Periodo de");
/*      */     
/*  312 */     this.jDateChooser4.setDate(this.fechaActual);
/*  313 */     this.jDateChooser4.setDateFormatString("yyyy/MM/dd");
/*  314 */     this.jDateChooser4.setIcon(this.icon);
/*  315 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/*  316 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/*      */     
/*  318 */     this.jLabel20.setFont(new Font("Tahoma", 3, 11));
/*  319 */     this.jLabel20.setForeground(new Color(15, 87, 51));
/*  320 */     this.jLabel20.setHorizontalAlignment(4);
/*  321 */     this.jLabel20.setText("al ");
/*      */     
/*  323 */     this.jDateChooser5.setDate(this.fechaActual);
/*  324 */     this.jDateChooser5.setDateFormatString("yyyy/MM/dd");
/*  325 */     this.jDateChooser5.setIcon(this.icon);
/*  326 */     this.jDateChooser5.setMaxSelectableDate(this.fechaActual);
/*  327 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/*      */     
/*  329 */     this.jLabel1.setFont(new Font("Tahoma", 1, 11));
/*  330 */     this.jLabel1.setText("<html><u>Clic para Filtrar</u></html>");
/*  331 */     this.jLabel1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  333 */             qhse.this.jLabel1MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/*  337 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/*  338 */     this.jPanel18.setLayout(jPanel18Layout);
/*  339 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout
/*  340 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  341 */         .addGroup(jPanel18Layout.createSequentialGroup()
/*  342 */           .addContainerGap()
/*  343 */           .addComponent(this.jLabel19)
/*  344 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  345 */           .addComponent((Component)this.jDateChooser4, -2, 119, -2)
/*  346 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  347 */           .addComponent(this.jLabel20)
/*  348 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  349 */           .addComponent((Component)this.jDateChooser5, -2, 109, -2)
/*  350 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  351 */           .addComponent(this.jLabel1, -2, 89, -2)
/*  352 */           .addContainerGap(195, 32767)));
/*      */     
/*  354 */     jPanel18Layout.setVerticalGroup(jPanel18Layout
/*  355 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  356 */         .addGroup(jPanel18Layout.createSequentialGroup()
/*  357 */           .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  358 */             .addComponent(this.jLabel19, -1, -1, 32767)
/*  359 */             .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  360 */               .addComponent((Component)this.jDateChooser5, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  361 */               .addComponent(this.jLabel20, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  362 */               .addComponent((Component)this.jDateChooser4, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  363 */               .addComponent(this.jLabel1, GroupLayout.Alignment.LEADING)))
/*  364 */           .addContainerGap()));
/*      */ 
/*      */     
/*  367 */     this.jPanel19.setBackground(new Color(146, 193, 134));
/*  368 */     this.jPanel19.setBorder(BorderFactory.createTitledBorder(null, "Establecer el Filtrado", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  370 */     this.jLabel22.setFont(new Font("Tahoma", 3, 11));
/*  371 */     this.jLabel22.setForeground(new Color(15, 87, 51));
/*  372 */     this.jLabel22.setHorizontalAlignment(4);
/*  373 */     this.jLabel22.setText("Equipo");
/*      */     
/*  375 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/*  376 */     this.jComboBox2.setFont(new Font("Tahoma", 1, 11));
/*  377 */     this.jComboBox2.setEnabled(false);
/*  378 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  380 */             qhse.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  384 */     this.jLabel23.setFont(new Font("Tahoma", 3, 11));
/*  385 */     this.jLabel23.setForeground(new Color(15, 87, 51));
/*  386 */     this.jLabel23.setHorizontalAlignment(4);
/*  387 */     this.jLabel23.setText("Plataforma");
/*      */     
/*  389 */     this.jComboBox3.setBackground(new Color(244, 244, 244));
/*  390 */     this.jComboBox3.setFont(new Font("Tahoma", 1, 11));
/*  391 */     this.jComboBox3.setEnabled(false);
/*  392 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  394 */             qhse.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  398 */     this.jLabel24.setFont(new Font("Tahoma", 3, 11));
/*  399 */     this.jLabel24.setForeground(new Color(15, 87, 51));
/*  400 */     this.jLabel24.setHorizontalAlignment(4);
/*  401 */     this.jLabel24.setText("Pozo");
/*      */     
/*  403 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/*  404 */     this.jComboBox4.setFont(new Font("Tahoma", 1, 11));
/*  405 */     this.jComboBox4.setEnabled(false);
/*  406 */     this.jComboBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  408 */             qhse.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  412 */     this.jLabel25.setFont(new Font("Tahoma", 3, 11));
/*  413 */     this.jLabel25.setForeground(new Color(15, 87, 51));
/*  414 */     this.jLabel25.setHorizontalAlignment(4);
/*  415 */     this.jLabel25.setText("Tipo");
/*      */     
/*  417 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/*  418 */     this.jComboBox5.setFont(new Font("Tahoma", 1, 11));
/*  419 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "TODOS", "PIPA", "GÓNDOLA" }));
/*  420 */     this.jComboBox5.setEnabled(false);
/*  421 */     this.jComboBox5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  423 */             qhse.this.jComboBox5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  427 */     this.jLabel26.setFont(new Font("Tahoma", 3, 11));
/*  428 */     this.jLabel26.setForeground(new Color(15, 87, 51));
/*  429 */     this.jLabel26.setHorizontalAlignment(4);
/*  430 */     this.jLabel26.setText("Destino");
/*      */     
/*  432 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/*  433 */     this.jComboBox6.setFont(new Font("Tahoma", 1, 11));
/*  434 */     this.jComboBox6.setEnabled(false);
/*  435 */     this.jComboBox6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  437 */             qhse.this.jComboBox6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  441 */     this.jLabel27.setFont(new Font("Tahoma", 3, 11));
/*  442 */     this.jLabel27.setForeground(new Color(15, 87, 51));
/*  443 */     this.jLabel27.setHorizontalAlignment(4);
/*  444 */     this.jLabel27.setText("Cd. Destino");
/*      */     
/*  446 */     this.jComboBox7.setBackground(new Color(244, 244, 244));
/*  447 */     this.jComboBox7.setFont(new Font("Tahoma", 1, 11));
/*  448 */     this.jComboBox7.setModel(new DefaultComboBoxModel<>(new String[] { "Todos", "Pipa", "Góndola" }));
/*  449 */     this.jComboBox7.setEnabled(false);
/*  450 */     this.jComboBox7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  452 */             qhse.this.jComboBox7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  456 */     this.jLabel8.setFont(new Font("Tahoma", 1, 11));
/*  457 */     this.jLabel8.setText("<html><u>Clic para Filtrar</u></html>");
/*  458 */     this.jLabel8.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/*  460 */             qhse.this.jLabel8MouseClicked(evt);
/*      */           }
/*      */         });
/*      */     
/*  464 */     this.jLabel21.setFont(new Font("Tahoma", 3, 11));
/*  465 */     this.jLabel21.setForeground(new Color(15, 87, 51));
/*  466 */     this.jLabel21.setHorizontalAlignment(4);
/*  467 */     this.jLabel21.setText("Clientes");
/*      */     
/*  469 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/*  470 */     this.jComboBox1.setFont(new Font("Tahoma", 1, 11));
/*  471 */     this.jComboBox1.setEnabled(false);
/*  472 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  474 */             qhse.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  478 */     GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
/*  479 */     this.jPanel19.setLayout(jPanel19Layout);
/*  480 */     jPanel19Layout.setHorizontalGroup(jPanel19Layout
/*  481 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  482 */         .addGroup(jPanel19Layout.createSequentialGroup()
/*  483 */           .addContainerGap()
/*  484 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  485 */             .addGroup(jPanel19Layout.createSequentialGroup()
/*  486 */               .addGap(8, 8, 8)
/*  487 */               .addComponent(this.jLabel21, -2, 55, -2)
/*  488 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  489 */               .addComponent(this.jComboBox1, -2, 213, -2)
/*  490 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  491 */               .addComponent(this.jLabel22, -2, 78, -2)
/*  492 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  493 */               .addComponent(this.jComboBox2, 0, 225, 32767))
/*  494 */             .addGroup(jPanel19Layout.createSequentialGroup()
/*  495 */               .addComponent(this.jLabel23, -2, 64, -2)
/*  496 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  497 */               .addComponent(this.jComboBox3, -2, 212, -2)
/*  498 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  499 */               .addComponent(this.jLabel24, -2, 78, -2)
/*  500 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  501 */               .addComponent(this.jComboBox4, 0, 225, 32767))
/*  502 */             .addGroup(jPanel19Layout.createSequentialGroup()
/*  503 */               .addComponent(this.jLabel25, -2, 64, -2)
/*  504 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  505 */               .addComponent(this.jComboBox5, -2, 212, -2)
/*  506 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  507 */               .addComponent(this.jLabel26, -2, 78, -2)
/*  508 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  509 */               .addComponent(this.jComboBox6, 0, 225, 32767))
/*  510 */             .addGroup(jPanel19Layout.createSequentialGroup()
/*  511 */               .addComponent(this.jLabel27, -2, 64, -2)
/*  512 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  513 */               .addComponent(this.jComboBox7, -2, 212, -2)
/*  514 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 222, 32767)
/*  515 */               .addComponent(this.jLabel8, -2, 89, -2)))
/*  516 */           .addContainerGap()));
/*      */     
/*  518 */     jPanel19Layout.setVerticalGroup(jPanel19Layout
/*  519 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  520 */         .addGroup(jPanel19Layout.createSequentialGroup()
/*  521 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  522 */             .addComponent(this.jLabel22)
/*  523 */             .addComponent(this.jComboBox2, -2, -1, -2)
/*  524 */             .addComponent(this.jLabel21)
/*  525 */             .addComponent(this.jComboBox1, -2, -1, -2))
/*  526 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  527 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  528 */             .addComponent(this.jLabel23)
/*  529 */             .addComponent(this.jComboBox3, -2, -1, -2)
/*  530 */             .addComponent(this.jLabel24)
/*  531 */             .addComponent(this.jComboBox4, -2, -1, -2))
/*  532 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  533 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  534 */             .addComponent(this.jLabel25)
/*  535 */             .addComponent(this.jComboBox5, -2, -1, -2)
/*  536 */             .addComponent(this.jLabel26)
/*  537 */             .addComponent(this.jComboBox6, -2, -1, -2))
/*  538 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  539 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  540 */             .addComponent(this.jLabel27)
/*  541 */             .addComponent(this.jComboBox7, -2, -1, -2)
/*  542 */             .addComponent(this.jLabel8))
/*  543 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  546 */     this.jLabel2.setFont(new Font("Tahoma", 1, 11));
/*  547 */     this.jLabel2.setForeground(Color.blue);
/*  548 */     this.jLabel2.setText("Resultados:");
/*      */     
/*  550 */     this.jLabel3.setFont(new Font("Tahoma", 1, 11));
/*  551 */     this.jLabel3.setText("Manifiestos Aceite:");
/*      */     
/*  553 */     this.jLabel4.setFont(new Font("Tahoma", 1, 11));
/*  554 */     this.jLabel4.setForeground(Color.red);
/*  555 */     this.jLabel4.setHorizontalAlignment(4);
/*  556 */     this.jLabel4.setText("0");
/*      */     
/*  558 */     this.jLabel5.setFont(new Font("Tahoma", 1, 11));
/*  559 */     this.jLabel5.setText("Manifiestos Agua:");
/*      */     
/*  561 */     this.jLabel6.setFont(new Font("Tahoma", 1, 11));
/*  562 */     this.jLabel6.setForeground(Color.red);
/*  563 */     this.jLabel6.setHorizontalAlignment(4);
/*  564 */     this.jLabel6.setText("0");
/*      */     
/*  566 */     this.jLabel7.setFont(new Font("Tahoma", 1, 11));
/*  567 */     this.jLabel7.setForeground(Color.red);
/*  568 */     this.jLabel7.setText("0");
/*      */     
/*  570 */     this.jButton1.setText("Guardar Archivo");
/*  571 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  573 */             qhse.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  577 */     GroupLayout jPanel27Layout = new GroupLayout(this.jPanel27);
/*  578 */     this.jPanel27.setLayout(jPanel27Layout);
/*  579 */     jPanel27Layout.setHorizontalGroup(jPanel27Layout
/*  580 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  581 */         .addGroup(jPanel27Layout.createSequentialGroup()
/*  582 */           .addContainerGap()
/*  583 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  584 */             .addComponent(this.jPanel19, -1, -1, 32767)
/*  585 */             .addComponent(this.jPanel17, -1, -1, 32767)
/*  586 */             .addComponent(this.jPanel18, -1, -1, 32767)
/*  587 */             .addGroup(jPanel27Layout.createSequentialGroup()
/*  588 */               .addComponent(this.jLabel5, -2, 108, -2)
/*  589 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  590 */               .addComponent(this.jLabel6, -2, 75, -2))
/*  591 */             .addGroup(jPanel27Layout.createSequentialGroup()
/*  592 */               .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  593 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel27Layout.createSequentialGroup()
/*  594 */                   .addComponent(this.jLabel2, -2, 77, -2)
/*  595 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/*  596 */                   .addComponent(this.jLabel7))
/*  597 */                 .addGroup(GroupLayout.Alignment.LEADING, jPanel27Layout.createSequentialGroup()
/*  598 */                   .addComponent(this.jLabel3, -2, 108, -2)
/*  599 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  600 */                   .addComponent(this.jLabel4, -1, -1, 32767))
/*  601 */                 .addComponent(this.jSeparator1, GroupLayout.Alignment.LEADING, -2, 189, -2))
/*  602 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 311, 32767)
/*  603 */               .addComponent(this.jButton1, -2, 123, -2))
/*  604 */             .addComponent(this.jLabel54, GroupLayout.Alignment.TRAILING, -1, 623, 32767))
/*  605 */           .addContainerGap()));
/*      */     
/*  607 */     jPanel27Layout.setVerticalGroup(jPanel27Layout
/*  608 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  609 */         .addGroup(jPanel27Layout.createSequentialGroup()
/*  610 */           .addGap(12, 12, 12)
/*  611 */           .addComponent(this.jLabel54)
/*  612 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  613 */           .addComponent(this.jPanel17, -2, -1, -2)
/*  614 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  615 */           .addComponent(this.jPanel18, -2, -1, -2)
/*  616 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  617 */           .addComponent(this.jPanel19, -2, -1, -2)
/*  618 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  619 */           .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  620 */             .addGroup(jPanel27Layout.createSequentialGroup()
/*  621 */               .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  622 */                 .addComponent(this.jLabel2)
/*  623 */                 .addComponent(this.jLabel7))
/*  624 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  625 */               .addComponent(this.jSeparator1, -2, 12, -2)
/*  626 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  627 */               .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  628 */                 .addComponent(this.jLabel3)
/*  629 */                 .addComponent(this.jLabel4))
/*  630 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  631 */               .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  632 */                 .addComponent(this.jLabel5)
/*  633 */                 .addComponent(this.jLabel6)))
/*  634 */             .addComponent(this.jButton1))
/*  635 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  638 */     this.jTable1.setFont(new Font("Tahoma", 0, 9));
/*  639 */     this.jTable1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Núm", "Activo", "Campo", "Ent. Fed.", "Municipio", "Equipo", "Pozo", "Cia. Perforadora", "Tipo de Residuo", "Tipo", "Tons.", "Manifiesto", "Certificado", "Fecha", "Operador", "Tractor", "Placas", "Remolque", "Placas", "Cia. Transporte", "Reg. SEMARNAT", "Cia. Manejo de Recorte", "Contrato", "Tecnología", "Nombre", "Reg. SEMARNAT", "Municipio", "Ent. Fed." })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  647 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false };
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  652 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  655 */     this.jScrollPane1.setViewportView(this.jTable1);
/*  656 */     if (this.jTable1.getColumnModel().getColumnCount() > 0) {
/*  657 */       this.jTable1.getColumnModel().getColumn(0).setMinWidth(40);
/*  658 */       this.jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
/*  659 */       this.jTable1.getColumnModel().getColumn(1).setMinWidth(50);
/*  660 */       this.jTable1.getColumnModel().getColumn(1).setMaxWidth(50);
/*  661 */       this.jTable1.getColumnModel().getColumn(2).setMinWidth(70);
/*  662 */       this.jTable1.getColumnModel().getColumn(2).setMaxWidth(70);
/*  663 */       this.jTable1.getColumnModel().getColumn(3).setMinWidth(90);
/*  664 */       this.jTable1.getColumnModel().getColumn(3).setMaxWidth(90);
/*  665 */       this.jTable1.getColumnModel().getColumn(4).setMinWidth(100);
/*  666 */       this.jTable1.getColumnModel().getColumn(4).setMaxWidth(100);
/*  667 */       this.jTable1.getColumnModel().getColumn(9).setMinWidth(60);
/*  668 */       this.jTable1.getColumnModel().getColumn(9).setMaxWidth(60);
/*  669 */       this.jTable1.getColumnModel().getColumn(10).setMinWidth(40);
/*  670 */       this.jTable1.getColumnModel().getColumn(10).setMaxWidth(40);
/*  671 */       this.jTable1.getColumnModel().getColumn(11).setMinWidth(90);
/*  672 */       this.jTable1.getColumnModel().getColumn(11).setMaxWidth(90);
/*  673 */       this.jTable1.getColumnModel().getColumn(12).setMinWidth(90);
/*  674 */       this.jTable1.getColumnModel().getColumn(12).setMaxWidth(90);
/*  675 */       this.jTable1.getColumnModel().getColumn(22).setMinWidth(60);
/*  676 */       this.jTable1.getColumnModel().getColumn(22).setMaxWidth(60);
/*  677 */       this.jTable1.getColumnModel().getColumn(26).setMinWidth(80);
/*  678 */       this.jTable1.getColumnModel().getColumn(26).setMaxWidth(80);
/*  679 */       this.jTable1.getColumnModel().getColumn(27).setMinWidth(80);
/*  680 */       this.jTable1.getColumnModel().getColumn(27).setMaxWidth(80);
/*      */     } 
/*      */     
/*  683 */     GroupLayout layout = new GroupLayout(this);
/*  684 */     setLayout(layout);
/*  685 */     layout.setHorizontalGroup(layout
/*  686 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  687 */         .addGroup(layout.createSequentialGroup()
/*  688 */           .addComponent(this.jPanel27, -2, -1, -2)
/*  689 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  690 */           .addComponent(this.jScrollPane1, -1, 2823, 32767)));
/*      */     
/*  692 */     layout.setVerticalGroup(layout
/*  693 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  694 */         .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
/*  695 */           .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  696 */             .addComponent(this.jScrollPane1)
/*  697 */             .addComponent(this.jPanel27, -1, -1, 32767))
/*  698 */           .addContainerGap()));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jComboBox5ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jComboBox6ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jComboBox7ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jLabel1MouseClicked(MouseEvent evt) {
/*  731 */     verDatos();
/*  732 */     String[] equipos = new String[100];
/*  733 */     String[] plata = new String[100];
/*  734 */     String[] pozos = new String[100];
/*  735 */     for (int i = 0; i < 100; i++) {
/*  736 */       equipos[i] = new String("");
/*  737 */       pozos[i] = new String("");
/*  738 */       plata[i] = new String("");
/*      */     } 
/*  740 */     int cont = 0;
/*  741 */     this.jComboBox2.removeAllItems();
/*  742 */     this.jComboBox2.addItem("TODOS");
/*      */ 
/*      */     
/*  745 */     this.jComboBox4.removeAllItems();
/*  746 */     this.jComboBox4.addItem("TODOS");
/*      */     
/*  748 */     int Nequipos = 0;
/*  749 */     int Nplata = 0;
/*  750 */     int Npozos = 0;
/*  751 */     Vector<Object> v = new Vector(); int j;
/*  752 */     for (j = 0; j < this.jTable3.getRowCount(); j++) {
/*  753 */       for (int k = 0; k < 100; k++) {
/*  754 */         if (!esta(equipos, String.valueOf(this.jTable3.getValueAt(j, 0)))) {
/*  755 */           equipos[cont] = String.valueOf(this.jTable3.getValueAt(j, 0));
/*  756 */           v.addElement(this.jTable3.getValueAt(j, 0));
/*  757 */           cont++;
/*      */         } 
/*      */       } 
/*      */     } 
/*  761 */     for (j = 0; j < this.jTable4.getRowCount(); j++) {
/*  762 */       for (int k = 0; k < 100; k++) {
/*  763 */         if (!esta(equipos, String.valueOf(this.jTable4.getValueAt(j, 0)))) {
/*  764 */           equipos[cont] = String.valueOf(this.jTable4.getValueAt(j, 0));
/*  765 */           v.addElement(this.jTable4.getValueAt(j, 0));
/*  766 */           cont++;
/*      */         } 
/*      */       } 
/*      */     } 
/*  770 */     Collections.sort(v);
/*  771 */     for (j = 0; j < v.size(); j++) {
/*  772 */       this.jComboBox2.addItem(v.elementAt(j));
/*      */     }
/*  774 */     Nequipos = cont;
/*  775 */     cont = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  801 */     Nplata = cont;
/*  802 */     cont = 0;
/*  803 */     for (j = 0; j < this.jTable3.getRowCount(); j++) {
/*  804 */       for (int k = 0; k < 100; k++) {
/*  805 */         if (!esta(pozos, String.valueOf(this.jTable3.getValueAt(j, 1)))) {
/*  806 */           pozos[cont] = String.valueOf(this.jTable3.getValueAt(j, 1));
/*  807 */           this.jComboBox4.addItem(pozos[cont]);
/*  808 */           cont++;
/*      */         } 
/*      */       } 
/*      */     } 
/*  812 */     for (j = 0; j < this.jTable4.getRowCount(); j++) {
/*  813 */       for (int k = 0; k < 100; k++) {
/*  814 */         if (!esta(pozos, String.valueOf(this.jTable4.getValueAt(j, 1)))) {
/*  815 */           pozos[cont] = String.valueOf(this.jTable4.getValueAt(j, 1));
/*  816 */           this.jComboBox4.addItem(pozos[cont]);
/*  817 */           cont++;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/*  823 */     String archivo = String.valueOf(this.jComboBox1.getSelectedItem());
/*  824 */     if (archivo.equals("WEATHERFORD DE MÉXICO S.A. DE C.V.")) {
/*  825 */       archivo = "Formato Wetherford.xls";
/*      */     }
/*  827 */     else if (archivo.equals("DOWELL SCHLUMBERGER DE MÉXICO S.A DE C.V.")) {
/*  828 */       archivo = "Formato slb.xls";
/*      */     }
/*  830 */     else if (archivo.equals("PERFORADORA MÉXICO, S.A. DE C.V.")) {
/*  831 */       archivo = "Formato pmx.xls";
/*      */     } else {
/*      */       
/*  834 */       archivo = "Formato general.xls";
/*      */     } 
/*      */     try {
/*  837 */       imprimirQHSE imprimirQHSE = new imprimirQHSE(this.jTable1, this.USUARIO, archivo);
/*  838 */     } catch (BiffException ex) {
/*  839 */       Logger.getLogger(qhse.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*  840 */     } catch (WriteException ex) {
/*  841 */       Logger.getLogger(qhse.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */     } 
/*      */   }
/*      */   private void jLabel8MouseClicked(MouseEvent evt) {
/*  845 */     verDatos();
/*      */   }
/*      */   public void qhse(String usu) {
/*  848 */     this.USUARIO = usu;
/*  849 */     this.panel.setViewportView(this);
/*  850 */     this.jDateChooser4.setDate(this.fechaActual);
/*  851 */     this.jDateChooser4.setMaxSelectableDate(this.fechaActual);
/*  852 */     llenarCombos();
/*      */   }
/*      */   public void colorear() {
/*  855 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  857 */             qhse.this.jTextGanado(qhse.this.jTextField1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/*  860 */             qhse.this.jTextPerdido(qhse.this.jTextField1, evt);
/*      */           }
/*      */         });
/*  863 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  865 */             qhse.this.jTextGanado(qhse.this.jTextField2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/*  868 */             qhse.this.jTextPerdido(qhse.this.jTextField2, evt);
/*      */           }
/*      */         });
/*  871 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  873 */             qhse.this.jTextGanado(qhse.this.jTextField3, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/*  876 */             qhse.this.jTextPerdido(qhse.this.jTextField3, evt);
/*      */           }
/*      */         });
/*  879 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  881 */             qhse.this.jTextGanado(qhse.this.jTextField4, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/*  884 */             qhse.this.jTextPerdido(qhse.this.jTextField4, evt);
/*      */           }
/*      */         });
/*  887 */     this.jTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  889 */             qhse.this.jTextGanado(qhse.this.jTextField5, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/*  892 */             qhse.this.jTextPerdido(qhse.this.jTextField5, evt);
/*      */           }
/*      */         });
/*  895 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  897 */             qhse.this.jTextGanado(qhse.this.jComboBox1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/*  900 */             qhse.this.jTextPerdido(qhse.this.jComboBox1, evt);
/*      */           }
/*      */         });
/*  903 */     this.jComboBox2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  905 */             qhse.this.jTextGanado(qhse.this.jComboBox2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/*  908 */             qhse.this.jTextPerdido(qhse.this.jComboBox2, evt);
/*      */           }
/*      */         });
/*  911 */     this.jComboBox3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  913 */             qhse.this.jTextGanado(qhse.this.jComboBox3, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/*  916 */             qhse.this.jTextPerdido(qhse.this.jComboBox3, evt);
/*      */           }
/*      */         });
/*  919 */     this.jComboBox4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  921 */             qhse.this.jTextGanado(qhse.this.jComboBox4, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/*  924 */             qhse.this.jTextPerdido(qhse.this.jComboBox4, evt);
/*      */           }
/*      */         });
/*  927 */     this.jComboBox5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  929 */             qhse.this.jTextGanado(qhse.this.jComboBox5, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/*  932 */             qhse.this.jTextPerdido(qhse.this.jComboBox5, evt);
/*      */           }
/*      */         });
/*  935 */     this.jComboBox6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  937 */             qhse.this.jTextGanado(qhse.this.jComboBox6, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/*  940 */             qhse.this.jTextPerdido(qhse.this.jComboBox6, evt);
/*      */           }
/*      */         });
/*  943 */     this.jComboBox7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  945 */             qhse.this.jTextGanado(qhse.this.jComboBox7, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/*  948 */             qhse.this.jTextPerdido(qhse.this.jComboBox7, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/*  953 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/*  956 */     campo.setBackground(Color.white);
/*      */   }
/*      */   public void consultar() {
/*  959 */     Date fecha1 = this.jDateChooser4.getDate();
/*  960 */     Date fecha2 = this.jDateChooser5.getDate();
/*      */     
/*  962 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/*  963 */     String cadenaFecha = "";
/*  964 */     cadenaFecha = formato.format(fecha1);
/*  965 */     String AÑO = cadenaFecha.substring(0, 4);
/*  966 */     String MES = cadenaFecha.substring(4, 6);
/*  967 */     String DIA = cadenaFecha.substring(6, 8);
/*  968 */     String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */     
/*  970 */     formato = new SimpleDateFormat("yyyyMMdd");
/*  971 */     cadenaFecha = formato.format(fecha2);
/*  972 */     AÑO = cadenaFecha.substring(0, 4);
/*  973 */     MES = cadenaFecha.substring(4, 6);
/*  974 */     DIA = cadenaFecha.substring(6, 8);
/*      */     
/*  976 */     int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/*  977 */     int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/*  978 */     int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/*      */     
/*  980 */     int diasTotal = diasDelMes(mm - 1, aa);
/*  981 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  982 */     String strFecha = "";
/*  983 */     if (diasTotal == dd) {
/*  984 */       dd = 1;
/*  985 */       if (mm == 11) {
/*  986 */         aa++;
/*  987 */         mm = 0;
/*      */       } else {
/*      */         
/*  990 */         mm++;
/*      */       } 
/*      */     } else {
/*  993 */       dd++;
/*      */     } 
/*  995 */     String año = "" + aa;
/*  996 */     String mes = "" + mm;
/*  997 */     String dia = "" + dd;
/*  998 */     formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*  999 */     strFecha = dia + "-" + dia + "-" + mes;
/* 1000 */     String fechaCompleta2 = "'" + año + "-" + mes + "-" + dia + "'";
/*      */     
/* 1002 */     String cliente = "";
/* 1003 */     String equipo = "";
/* 1004 */     String plataforma = "";
/* 1005 */     String pozo = "";
/* 1006 */     String tipo = "";
/* 1007 */     String destino = "";
/* 1008 */     String ciudad = "";
/*      */     
/* 1010 */     String conEqui = " equipo like '%%'";
/* 1011 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 1012 */       cliente = String.valueOf(this.jComboBox1.getSelectedItem()) + String.valueOf(this.jComboBox1.getSelectedItem());
/*      */     }
/* 1014 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 1015 */       equipo = String.valueOf(this.jComboBox2.getSelectedItem()) + String.valueOf(this.jComboBox2.getSelectedItem());
/* 1016 */       conEqui = " equipo = '" + equipo + "' ";
/*      */     } 
/* 1018 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 1019 */       plataforma = String.valueOf(this.jComboBox3.getSelectedItem()) + String.valueOf(this.jComboBox3.getSelectedItem());
/*      */     }
/* 1021 */     if (this.jComboBox4.getSelectedIndex() != 0) {
/* 1022 */       pozo = String.valueOf(this.jComboBox4.getSelectedItem()) + String.valueOf(this.jComboBox4.getSelectedItem());
/*      */     }
/* 1024 */     if (this.jComboBox5.getSelectedIndex() != 0) {
/* 1025 */       tipo = String.valueOf(this.jComboBox5.getSelectedItem()) + String.valueOf(this.jComboBox5.getSelectedItem());
/*      */     }
/* 1027 */     if (this.jComboBox6.getSelectedIndex() != 0) {
/* 1028 */       destino = String.valueOf(this.jComboBox6.getSelectedItem()) + String.valueOf(this.jComboBox6.getSelectedItem());
/*      */     }
/* 1030 */     if (this.jComboBox7.getSelectedIndex() != 0) {
/* 1031 */       ciudad = String.valueOf(this.jComboBox7.getSelectedItem()) + String.valueOf(this.jComboBox7.getSelectedItem());
/*      */     }
/* 1033 */     this.encontrado = this.con.consultar("count(guias.num_guia)", "vales,guias,llamadas_historicas,equipos,plataformas,pozos,emp_generadora,emp_destinataria,estados,operadores,remolque,tracto", "where llamadas_historicas.num_rem = remolque.num_rem and llamadas_historicas.num_tracto = tracto.num_tracto and operadores.num_ope = llamadas_historicas.num_ope and vales.num_vale = guias.num_vale and emp_destinataria.id_edo = estados.id_edo and guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and llamadas_historicas.clave_desti = emp_destinataria.clave_desti and emp_generadora.empresa like '%" + cliente + "%' and emp_destinataria.empresa like '%" + destino + "%' and " + conEqui + " and plataforma like '%" + plataforma + "%' and pozos.nombre like '%" + pozo + "%' and guias.tipo like '%" + tipo + "%' and emp_destinataria.ciudad like '%" + ciudad + "%' and guias.fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " and guias.estado = 'ACTIVA' and servicio ='SERVICIO INTEGRAL' order by EQUIPOS.EQUIPO");
/* 1034 */     int totreg = Integer.parseInt(this.con.Campo);
/* 1035 */     this.con.consultar("count(guias.num_guia)", "vales,guias,llamadas_historicas,equipos,plataformas,pozos,emp_generadora,emp_destinataria,estados,operadores,remolque,tracto", "where llamadas_historicas.num_rem = remolque.num_rem and llamadas_historicas.num_tracto = tracto.num_tracto and operadores.num_ope = llamadas_historicas.num_ope and vales.num_vale = guias.num_vale and emp_destinataria.id_edo = estados.id_edo and guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and llamadas_historicas.clave_desti = emp_destinataria.clave_desti and emp_generadora.empresa like '%" + cliente + "%' and emp_destinataria.empresa like '%" + destino + "%' and " + conEqui + " and plataforma like '%" + plataforma + "%' and pozos.nombre like '%" + pozo + "%' and guias.tipo like '%" + tipo + "%' and emp_destinataria.ciudad like '%" + ciudad + "%' and guias.fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " and guias.estado = 'ACTIVA' and servicio ='SERVICIO INTEGRAL' and (residuo ='RECORTE BASE ACEITE' || RESIDUO='SANEAMIENTO') order by EQUIPOS.EQUIPO");
/* 1036 */     int t1 = Integer.parseInt(this.con.Campo);
/* 1037 */     this.jLabel4.setText("" + t1);
/* 1038 */     this.jLabel6.setText("" + totreg - t1);
/* 1039 */     this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 1040 */           .buscarReg(24, totreg, "equipo,plataforma,pozos.nombre,emp_generadora.empresa,residuo,guias.tipo,vales.peso,rsp,guias.num_guia,vales.ticket,f_cargada,operadores.nombre,operadores.ap_pat,operadores.ap_mat,tracto.num_tracto,tracto.placas,remolque.num_rem,remolque.placas,emp_destinataria.empresa,emp_destinataria.semarnat,emp_destinataria.ciudad,estados.estado,guias.estado,descrip", "vales,guias,llamadas_historicas,equipos,plataformas,pozos,emp_generadora,emp_destinataria,estados,operadores,remolque,tracto", "where llamadas_historicas.num_rem = remolque.num_rem and llamadas_historicas.num_tracto = tracto.num_tracto and operadores.num_ope = llamadas_historicas.num_ope and vales.num_vale = guias.num_vale and emp_destinataria.id_edo = estados.id_edo and guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and llamadas_historicas.clave_desti = emp_destinataria.clave_desti and emp_generadora.empresa like '%" + cliente + "%' and emp_destinataria.empresa like '%" + destino + "%' and " + conEqui + " and plataforma like '%" + plataforma + "%' and pozos.nombre like '%" + pozo + "%' and guias.tipo like '%" + tipo + "%' and emp_destinataria.ciudad like '%" + ciudad + "%' and guias.fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " and guias.estado = 'ACTIVA' and servicio = 'SERVICIO INTEGRAL' order by emp_destinataria.empresa desc"), (Object[])new String[] { "Equipo", "Plataforma", "Pozo", "Cliente", "Residuo", "Tipo", "Tons.", "R.S.P.", "Manifiesto", "Certificado", "F_Cargada", "Operador", "Paterno", "Materno", "Tractor", "Placas", "Remolque", "Placas", "Destino", "Semarnat", "Municipio", "Estado", "Estado", "Descripción" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 1045 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false }; public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1049 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 1053 */     eliminarColumna(12, 11, "Paterno", this.jTable3);
/* 1054 */     eliminarColumna(12, 11, "Materno", this.jTable3);
/*      */   }
/*      */   public void eliminarColumna(int origen, int destino, String nombreCol, JTable tabla) {
/* 1057 */     int cont = tabla.getRowCount();
/* 1058 */     String[] registros = new String[cont]; int i;
/* 1059 */     for (i = 0; i < cont; i++) {
/* 1060 */       registros[i] = tabla.getValueAt(i, destino).toString();
/*      */     }
/* 1062 */     for (i = 0; i < cont; i++) {
/* 1063 */       registros[i] = registros[i] + " " + registros[i];
/* 1064 */       tabla.setValueAt(registros[i], i, destino);
/*      */     } 
/* 1066 */     TableColumn columna = tabla.getColumn(nombreCol);
/* 1067 */     tabla.removeColumn(columna);
/*      */   }
/*      */   public void consultar2() {
/* 1070 */     Date fecha1 = this.jDateChooser4.getDate();
/* 1071 */     Date fecha2 = this.jDateChooser5.getDate();
/*      */     
/* 1073 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 1074 */     String cadenaFecha = "";
/* 1075 */     cadenaFecha = formato.format(fecha1);
/* 1076 */     String AÑO = cadenaFecha.substring(0, 4);
/* 1077 */     String MES = cadenaFecha.substring(4, 6);
/* 1078 */     String DIA = cadenaFecha.substring(6, 8);
/* 1079 */     String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */     
/* 1081 */     formato = new SimpleDateFormat("yyyyMMdd");
/* 1082 */     cadenaFecha = formato.format(fecha2);
/* 1083 */     AÑO = cadenaFecha.substring(0, 4);
/* 1084 */     MES = cadenaFecha.substring(4, 6);
/* 1085 */     DIA = cadenaFecha.substring(6, 8);
/*      */     
/* 1087 */     int dd = Integer.parseInt(cadenaFecha.substring(6, 8));
/* 1088 */     int mm = Integer.parseInt(cadenaFecha.substring(4, 6));
/* 1089 */     int aa = Integer.parseInt(AÑO = cadenaFecha.substring(0, 4));
/*      */     
/* 1091 */     int diasTotal = diasDelMes(mm + 1, aa);
/* 1092 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 1093 */     String strFecha = "";
/* 1094 */     if (diasTotal == dd) {
/* 1095 */       dd = 1;
/* 1096 */       if (mm == 11) {
/* 1097 */         aa++;
/* 1098 */         mm = 0;
/*      */       } else {
/*      */         
/* 1101 */         mm++;
/*      */       } 
/*      */     } else {
/* 1104 */       dd++;
/*      */     } 
/* 1106 */     String año = "" + aa;
/* 1107 */     String mes = "" + mm;
/* 1108 */     String dia = "" + dd;
/* 1109 */     formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 1110 */     strFecha = dia + "-" + dia + "-" + mes;
/* 1111 */     String fechaCompleta2 = "'" + año + "-" + mes + "-" + dia + "'";
/*      */     
/* 1113 */     String cliente = "";
/* 1114 */     String equipo = "";
/* 1115 */     String plataforma = "";
/* 1116 */     String pozo = "";
/* 1117 */     String tipo = "";
/* 1118 */     String destino = "";
/* 1119 */     String ciudad = "";
/* 1120 */     String conEqui = " equipo like '%%'";
/*      */     
/* 1122 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 1123 */       cliente = String.valueOf(this.jComboBox1.getSelectedItem()) + String.valueOf(this.jComboBox1.getSelectedItem());
/*      */     }
/* 1125 */     if (this.jComboBox2.getSelectedIndex() != 0) {
/* 1126 */       equipo = String.valueOf(this.jComboBox2.getSelectedItem()) + String.valueOf(this.jComboBox2.getSelectedItem());
/* 1127 */       conEqui = " equipo = '" + String.valueOf(this.jComboBox2.getSelectedItem()) + "'";
/*      */     } 
/* 1129 */     if (this.jComboBox3.getSelectedIndex() != 0) {
/* 1130 */       plataforma = String.valueOf(this.jComboBox3.getSelectedItem()) + String.valueOf(this.jComboBox3.getSelectedItem());
/*      */     }
/* 1132 */     if (this.jComboBox4.getSelectedIndex() != 0) {
/* 1133 */       pozo = String.valueOf(this.jComboBox4.getSelectedItem()) + String.valueOf(this.jComboBox4.getSelectedItem());
/*      */     }
/* 1135 */     if (this.jComboBox5.getSelectedIndex() != 0) {
/* 1136 */       tipo = String.valueOf(this.jComboBox5.getSelectedItem()) + String.valueOf(this.jComboBox5.getSelectedItem());
/*      */     }
/* 1138 */     if (this.jComboBox6.getSelectedIndex() != 0) {
/* 1139 */       destino = String.valueOf(this.jComboBox6.getSelectedItem()) + String.valueOf(this.jComboBox6.getSelectedItem());
/*      */     }
/* 1141 */     if (this.jComboBox7.getSelectedIndex() != 0) {
/* 1142 */       ciudad = String.valueOf(this.jComboBox7.getSelectedItem()) + String.valueOf(this.jComboBox7.getSelectedItem());
/*      */     }
/*      */     
/* 1145 */     this.encontrado = this.con.consultar("count(guias.num_guia)", "vales,guias,llamadas_historicas,equipos,plataformas,pozos,emp_generadora,emp_destinataria,estados,operadores,tracto,remolque", "where vales.num_vale = guias.num_vale and operadores.num_ope = llamadas_historicas.num_ope and remolque.num_rem = llamadas_historicas.num_rem and llamadas_historicas.num_tracto = tracto.num_tracto and emp_destinataria.id_edo = estados.id_edo and guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and llamadas_historicas.clave_desti = emp_destinataria.clave_desti and emp_generadora.empresa like '%" + cliente + "%' and emp_destinataria.empresa like '%" + destino + "%' and " + conEqui + " and plataforma like '%" + plataforma + "%' and pozos.nombre like '%" + pozo + "%' and guias.tipo like '%" + tipo + "%' and emp_destinataria.ciudad like '%" + ciudad + "%' and guias.fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " and guias.estado = 'ACTIVA' AND servicio='SERVICIO INTEGRAL' AND (llamadas_historicas.residuo <>'RECORTE BASE ACEITE' || residuo <>'SANEAMIENTO') order by EQUIPOS.EQUIPO");
/* 1146 */     int totreg = Integer.parseInt(this.con.Campo);
/* 1147 */     this.jLabel6.setText("" + totreg);
/* 1148 */     this.jTable4.setModel(new DefaultTableModel((Object[][])this.con
/*      */           
/* 1150 */           .buscarReg(23, totreg, "equipo,plataforma,pozos.nombre,emp_generadora.empresa,residuo,guias.tipo,vales.peso,rsp,guias.num,vales.ticket,f_cargada,operadores.nombre,operadores.ap_pat,operadores.ap_mat,tracto.num_tracto,tracto.placas,remolque.num_rem,remolque.placas,emp_destinataria.empresa,emp_destinataria.semarnat,emp_destinataria.ciudad,estados.estado,guias.estado", "vales,guias,llamadas_historicas,equipos,plataformas,pozos,emp_generadora,emp_destinataria,estados,operadores,remolque,tracto", "where llamadas_historicas.num_rem = remolque.num_rem and llamadas_historicas.num_tracto = tracto.num_tracto and operadores.num_ope = llamadas_historicas.num_ope and vales.num_vale = guias.num_vale and emp_destinataria.id_edo = estados.id_edo and guias.num_llama = llamadas_historicas.num_llama and llamadas_historicas.num_equipo = equipos.num_equipo and llamadas_historicas.num_plata=plataformas.num_plata and llamadas_historicas.num_pozo = pozos.num_pozo and llamadas_historicas.clave_gene = emp_generadora.clave_gene and llamadas_historicas.clave_desti = emp_destinataria.clave_desti and emp_generadora.empresa like '%" + cliente + "%' and emp_destinataria.empresa like '%" + destino + "%' and " + conEqui + " and plataforma like '%" + plataforma + "%' and pozos.nombre like '%" + pozo + "%' and guias.tipo like '%" + tipo + "%' and emp_destinataria.ciudad like '%" + ciudad + "%' and guias.fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " and guias.estado = 'ACTIVA' and servicio = 'SERVICIO INTEGRAL' and (llamadas_historicas.residuo <>'RECORTE BASE ACEITE' || residuo <>'SANEAMIENTO') order by EQUIPOS.EQUIPO"), (Object[])new String[] { "Equipo", "Plataforma", "Pozo", "Cliente", "Residuo", "Tipo", "Tons.", "R.S.P.", "Manifiesto", "Certificado", "F_CARGADA", "Operador", "Paterno", "Materno", "Tractor", "Placas", "Remolque", "Placas", "Destino", "Semarnat", "Municipio", "Estado", "Estado" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 1155 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false, false, false }; public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1159 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1162 */     eliminarColumna(12, 11, "Paterno", this.jTable4);
/* 1163 */     eliminarColumna(12, 11, "Materno", this.jTable4);
/*      */   }
/*      */   public void llenarCombos() {
/* 1166 */     this.con.consultar("count(empresa)", "emp_generadora", "where clave_gene<>0 order by empresa");
/* 1167 */     String[] datos = this.con.regresaCol("empresa", "emp_generadora", "where clave_gene<>0 order by empresa", Integer.parseInt(this.con.Campo));
/* 1168 */     this.jComboBox1.removeAllItems();
/* 1169 */     this.jComboBox1.addItem("TODOS"); int i;
/* 1170 */     for (i = 0; i < datos.length; i++) {
/* 1171 */       this.jComboBox1.addItem(datos[i]);
/*      */     }
/*      */     
/* 1174 */     this.con.consultar("count(equipo)", "equipos", "where num_equipo<>0 order by equipo");
/* 1175 */     datos = this.con.regresaCol("equipo", "equipos", "where num_equipo<>0 order by equipo", Integer.parseInt(this.con.Campo));
/* 1176 */     this.jComboBox2.removeAllItems();
/* 1177 */     this.jComboBox2.addItem("TODOS");
/* 1178 */     for (i = 0; i < datos.length; i++) {
/* 1179 */       this.jComboBox2.addItem(datos[i]);
/*      */     }
/*      */     
/* 1182 */     this.con.consultar("count(plataforma)", "plataformas", "order by plataforma");
/* 1183 */     datos = this.con.regresaCol("plataforma", "plataformas", " order by plataforma", Integer.parseInt(this.con.Campo));
/* 1184 */     this.jComboBox3.removeAllItems();
/* 1185 */     this.jComboBox3.addItem("TODOS");
/* 1186 */     for (i = 0; i < datos.length; i++) {
/* 1187 */       this.jComboBox3.addItem(datos[i]);
/*      */     }
/*      */     
/* 1190 */     this.con.consultar("count(nombre)", "pozos", "where num_pozo<>0 order by nombre");
/* 1191 */     datos = this.con.regresaCol("nombre", "pozos", "where num_pozo<>0 order by nombre", Integer.parseInt(this.con.Campo));
/* 1192 */     this.jComboBox4.removeAllItems();
/* 1193 */     this.jComboBox4.addItem("TODOS");
/* 1194 */     for (i = 0; i < datos.length; i++) {
/* 1195 */       this.jComboBox4.addItem(datos[i]);
/*      */     }
/*      */     
/* 1198 */     this.con.consultar("count(empresa)", "emp_destinataria", "where clave_desti<>0 order by empresa");
/* 1199 */     datos = this.con.regresaCol("empresa", "emp_destinataria", "where clave_desti<>0 order by empresa", Integer.parseInt(this.con.Campo));
/* 1200 */     this.jComboBox6.removeAllItems();
/* 1201 */     this.jComboBox6.addItem("TODOS");
/* 1202 */     for (i = 0; i < datos.length; i++) {
/* 1203 */       this.jComboBox6.addItem(datos[i]);
/*      */     }
/*      */     
/* 1206 */     this.con.consultar("count(ciudad)", "emp_destinataria", "where clave_desti<>0 order by empresa");
/* 1207 */     datos = this.con.regresaCol("ciudad", "emp_destinataria", "where clave_desti<>0 order by empresa", Integer.parseInt(this.con.Campo));
/* 1208 */     this.jComboBox7.removeAllItems();
/* 1209 */     this.jComboBox7.addItem("TODOS");
/* 1210 */     for (i = 0; i < datos.length; i++) {
/* 1211 */       this.jComboBox7.addItem(datos[i]);
/*      */     }
/*      */     
/* 1214 */     this.con.consultar("count(plataforma)", "plataformas", "where num_plata<>0 order by plataforma");
/* 1215 */     datos = this.con.regresaCol("plataforma", "plataformas", "where num_plata<>0 order by plataforma", Integer.parseInt(this.con.Campo));
/* 1216 */     this.jComboBox3.removeAllItems();
/* 1217 */     this.jComboBox3.addItem("TODOS");
/* 1218 */     for (i = 0; i < datos.length; i++) {
/* 1219 */       this.jComboBox3.addItem(datos[i]);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean esta(String[] arreglo, String valor) {
/* 1224 */     for (int i = 0; i < 100; i++) {
/* 1225 */       if (arreglo[i].equals(valor)) {
/* 1226 */         return true;
/*      */       }
/*      */     } 
/* 1229 */     return false;
/*      */   }
/*      */   
/*      */   class Esperando extends Thread { Thread t;
/* 1233 */     int cont = 0;
/* 1234 */     int otro = 0;
/*      */     Esperando() {
/* 1236 */       qhse.this.consultar();
/*      */       
/* 1238 */       this.t = new Thread(this);
/* 1239 */       this.t.start();
/*      */     }
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/* 1244 */       juntarTodos();
/*      */     }
/*      */     public void juntarTodos() {
/* 1247 */       this.cont++;
/* 1248 */       if (qhse.this.jTable3 != null && qhse.this.jTable4 != null) {
/* 1249 */         int j = qhse.this.jTable3.getRowCount();
/*      */       }
/*      */       
/* 1252 */       String[] columnas = { "Núm", "Activo", "Campo", "Ent. Fed.", "Municipio", "Equipo", "Pozo", "Plataforma", "Cia. Perforadora", "Tipo de Residuo", "Tipo", "Tons.", "Manifiesto", "Certificado", "Fecha", "Cia. Transporte", "Reg. SEMARNAT", "Cia. Manejo de Recorte", "Contrato", "Tecnología", "Nombre", "Reg. SEMARNAT", "Municipio", "Ent. Fed.", "Descripción o Comentario" };
/* 1253 */       DefaultTableModel modelo = new DefaultTableModel();
/* 1254 */       qhse.this.jTable1.setModel(modelo);
/* 1255 */       modelo.addColumn("Num");
/* 1256 */       modelo.addColumn("Activo");
/* 1257 */       modelo.addColumn("Campo");
/* 1258 */       modelo.addColumn("Ent. Fed.");
/* 1259 */       modelo.addColumn("Municipio");
/* 1260 */       modelo.addColumn("Equipo");
/* 1261 */       modelo.addColumn("Plataforma");
/* 1262 */       modelo.addColumn("Pozo");
/* 1263 */       modelo.addColumn("Cia. Perforadora");
/* 1264 */       modelo.addColumn("Tipo de Residuo");
/* 1265 */       modelo.addColumn("Tipo");
/* 1266 */       modelo.addColumn("Tons.");
/* 1267 */       modelo.addColumn("R.S.P.");
/* 1268 */       modelo.addColumn("Manifiesto");
/* 1269 */       modelo.addColumn("Certificado");
/* 1270 */       modelo.addColumn("F. Carga");
/* 1271 */       modelo.addColumn("F. Descarga");
/* 1272 */       modelo.addColumn("Operador");
/* 1273 */       modelo.addColumn("Tractor");
/* 1274 */       modelo.addColumn("Placas");
/* 1275 */       modelo.addColumn("Remolque");
/* 1276 */       modelo.addColumn("Placas");
/* 1277 */       modelo.addColumn("Cia Transporte");
/* 1278 */       modelo.addColumn("Reg. SEMARNAT");
/* 1279 */       modelo.addColumn("Cia. Manejo de Recorte");
/* 1280 */       modelo.addColumn("Contrato");
/* 1281 */       modelo.addColumn("Tecnología");
/* 1282 */       modelo.addColumn("Nombre");
/* 1283 */       modelo.addColumn("Reg. SEMARNAT");
/* 1284 */       modelo.addColumn("Municipio");
/* 1285 */       modelo.addColumn("Ent. Fed.");
/* 1286 */       modelo.addColumn("Descripción o Comentario");
/* 1287 */       this.otro++;
/* 1288 */       this.cont = 1; int i;
/* 1289 */       for (i = 0; i < qhse.this.jTable3.getRowCount(); i++) {
/* 1290 */         String residuo = "";
/* 1291 */         String comp = String.valueOf(qhse.this.jTable3.getValueAt(i, 4));
/* 1292 */         String c1 = String.valueOf(qhse.this.jTable3.getValueAt(i, 3));
/* 1293 */         String c2 = String.valueOf(qhse.this.jTable3.getValueAt(i, 16));
/* 1294 */         String estado = String.valueOf(qhse.this.jTable3.getValueAt(i, 19));
/* 1295 */         if (comp.equals("RECORTE BASE ACEITE") || comp.equals("SANEAMIENTO") || comp.equals("SEDIMENTO")) {
/* 1296 */           residuo = "COPROCESAMIENTO";
/*      */         } else {
/*      */           
/* 1299 */           residuo = "CONFINAMIENTO";
/*      */         } 
/* 1301 */         if (c1.equals("DOWELL SCHLUMBERGER DE MÉXICO S.A DE C.V.")) {
/* 1302 */           c1 = "DRILLER";
/*      */         }
/* 1304 */         else if (c1.equals("WEATHERFORD DE MÉXICO S.A. DE C.V.")) {
/* 1305 */           c1 = "WEATHERFORD";
/*      */         }
/* 1307 */         else if (c1.equals("PERFORADORA MÉXICO, S.A. DE C.V.")) {
/* 1308 */           c1 = "PMX";
/*      */         }
/* 1310 */         else if (c1.equals("QMAX SOLUCIONES AMBIENTALES S.A. DE C.V.")) {
/* 1311 */           c1 = "Q-MAX";
/*      */         } 
/* 1313 */         if (c2.equals("CEMEX MÉXICO S.A DE C.V. (PLANTA TEPEACA)")) {
/* 1314 */           c2 = "CEMEX - TEPEACA";
/*      */         }
/* 1316 */         else if (c2.equals("ADT PETROSERVICIOS S.A. DE C.V.")) {
/* 1317 */           c2 = "ADT PETROSERVICIOS";
/*      */         }
/* 1319 */         else if (c2.equals("CEMEX MÉXICO (PLANTA TAMUÍN)")) {
/* 1320 */           c2 = "CEMEX - TAMUÍN";
/*      */         }
/* 1322 */         else if (c2.equals("CLEANMEX S.A. DE C.V. (MATAMOROS)")) {
/* 1323 */           c2 = "CLEANMEX - MATAMOROS";
/*      */         }
/* 1325 */         else if (c2.equals("ECOLTEC (PLANTA RAMOS ARIZPE)")) {
/* 1326 */           c2 = "ECOLTEC - RAMOS ARIZPE";
/*      */         }
/* 1328 */         else if (c2.equals("ECOLTEC S.A. DE C.V. (PLANTA ORIZABA)")) {
/* 1329 */           c2 = "ECOLTEC - ORIZABA";
/*      */         }
/* 1331 */         else if (c2.equals("ECOLTEC S.A. DE C.V. (PLANTA MACUSPANA)")) {
/* 1332 */           c2 = "ECOLTEC - MACUSPANA";
/*      */         } 
/* 1334 */         if (estado.equals("SAN LUIS POTOSÍ")) {
/* 1335 */           estado = "S.L.P.";
/*      */         }
/* 1337 */         Object[] reg = { "" + this.cont, qhse.this.jTextField1.getText().toUpperCase(), qhse.this.jTextField2.getText().toUpperCase(), qhse.this.jTextField3.getText().toUpperCase(), qhse.this.jTextField4.getText().toUpperCase(), qhse.this.jTable3.getValueAt(i, 0), qhse.this.jTable3.getValueAt(i, 1), qhse.this.jTable3.getValueAt(i, 2), c1, qhse.this.jTable3.getValueAt(i, 4), qhse.this.jTable3.getValueAt(i, 5), qhse.this.jTable3.getValueAt(i, 6), qhse.this.jTable3.getValueAt(i, 7), qhse.this.jTable3.getValueAt(i, 8), qhse.this.jTable3.getValueAt(i, 9), qhse.this.jTable3.getValueAt(i, 10), "", qhse.this.jTable3.getValueAt(i, 11), qhse.this.jTable3.getValueAt(i, 12), qhse.this.jTable3.getValueAt(i, 13), qhse.this.jTable3.getValueAt(i, 14), qhse.this.jTable3.getValueAt(i, 15), "FORSIS", "19-09PS-I-02D-03/6", "FORSIS", "", residuo, c2, qhse.this.jTable3.getValueAt(i, 17), qhse.this.jTable3.getValueAt(i, 18), estado, qhse.this.jTable3.getValueAt(i, 21) };
/* 1338 */         this.cont++;
/* 1339 */         modelo.addRow(reg);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1394 */       this.cont--;
/* 1395 */       qhse.this.jLabel7.setText("" + this.cont);
/*      */       
/* 1397 */       qhse.this.jScrollPane1.setViewportView(qhse.this.jTable1);
/* 1398 */       qhse.this.jTable1.getColumnModel().getColumn(0).setMinWidth(40);
/* 1399 */       qhse.this.jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
/* 1400 */       qhse.this.jTable1.getColumnModel().getColumn(1).setMinWidth(50);
/* 1401 */       qhse.this.jTable1.getColumnModel().getColumn(1).setMaxWidth(50);
/* 1402 */       qhse.this.jTable1.getColumnModel().getColumn(2).setMinWidth(70);
/* 1403 */       qhse.this.jTable1.getColumnModel().getColumn(2).setMaxWidth(70);
/* 1404 */       qhse.this.jTable1.getColumnModel().getColumn(3).setMinWidth(90);
/* 1405 */       qhse.this.jTable1.getColumnModel().getColumn(3).setMaxWidth(90);
/* 1406 */       qhse.this.jTable1.getColumnModel().getColumn(4).setMinWidth(90);
/* 1407 */       qhse.this.jTable1.getColumnModel().getColumn(4).setMaxWidth(90);
/* 1408 */       qhse.this.jTable1.getColumnModel().getColumn(5).setMinWidth(90);
/* 1409 */       qhse.this.jTable1.getColumnModel().getColumn(5).setMaxWidth(90);
/* 1410 */       qhse.this.jTable1.getColumnModel().getColumn(10).setMinWidth(60);
/* 1411 */       qhse.this.jTable1.getColumnModel().getColumn(10).setMaxWidth(60);
/* 1412 */       qhse.this.jTable1.getColumnModel().getColumn(11).setMinWidth(40);
/* 1413 */       qhse.this.jTable1.getColumnModel().getColumn(11).setMaxWidth(40);
/* 1414 */       qhse.this.jTable1.getColumnModel().getColumn(12).setMinWidth(60);
/* 1415 */       qhse.this.jTable1.getColumnModel().getColumn(12).setMaxWidth(60);
/*      */ 
/*      */ 
/*      */       
/* 1419 */       qhse.this.jTable1.getColumnModel().getColumn(13).setMinWidth(85);
/* 1420 */       qhse.this.jTable1.getColumnModel().getColumn(13).setMaxWidth(85);
/* 1421 */       qhse.this.jTable1.getColumnModel().getColumn(14).setMinWidth(70);
/* 1422 */       qhse.this.jTable1.getColumnModel().getColumn(14).setMaxWidth(70);
/* 1423 */       qhse.this.jTable1.getColumnModel().getColumn(15).setMinWidth(80);
/* 1424 */       qhse.this.jTable1.getColumnModel().getColumn(15).setMaxWidth(80);
/* 1425 */       qhse.this.jTable1.getColumnModel().getColumn(16).setMinWidth(80);
/* 1426 */       qhse.this.jTable1.getColumnModel().getColumn(16).setMaxWidth(80);
/* 1427 */       qhse.this.jTable1.getColumnModel().getColumn(17).setMinWidth(200);
/* 1428 */       qhse.this.jTable1.getColumnModel().getColumn(17).setMaxWidth(200);
/* 1429 */       qhse.this.jTable1.getColumnModel().getColumn(18).setMinWidth(50);
/* 1430 */       qhse.this.jTable1.getColumnModel().getColumn(18).setMaxWidth(50);
/* 1431 */       qhse.this.jTable1.getColumnModel().getColumn(19).setMinWidth(50);
/* 1432 */       qhse.this.jTable1.getColumnModel().getColumn(19).setMaxWidth(50);
/* 1433 */       qhse.this.jTable1.getColumnModel().getColumn(20).setMinWidth(65);
/* 1434 */       qhse.this.jTable1.getColumnModel().getColumn(20).setMaxWidth(65);
/* 1435 */       qhse.this.jTable1.getColumnModel().getColumn(21).setMinWidth(50);
/* 1436 */       qhse.this.jTable1.getColumnModel().getColumn(21).setMaxWidth(50);
/*      */       
/* 1438 */       qhse.this.jTable1.getColumnModel().getColumn(22).setMinWidth(90);
/* 1439 */       qhse.this.jTable1.getColumnModel().getColumn(22).setMaxWidth(90);
/* 1440 */       qhse.this.jTable1.getColumnModel().getColumn(24).setMinWidth(90);
/* 1441 */       qhse.this.jTable1.getColumnModel().getColumn(24).setMaxWidth(90);
/* 1442 */       qhse.this.jTable1.getColumnModel().getColumn(25).setMinWidth(65);
/* 1443 */       qhse.this.jTable1.getColumnModel().getColumn(25).setMaxWidth(65);
/* 1444 */       qhse.this.jTable1.getColumnModel().getColumn(26).setMinWidth(120);
/* 1445 */       qhse.this.jTable1.getColumnModel().getColumn(26).setMaxWidth(120);
/*      */       
/* 1447 */       qhse.this.jTable1.getColumnModel().getColumn(29).setMinWidth(80);
/* 1448 */       qhse.this.jTable1.getColumnModel().getColumn(29).setMaxWidth(80);
/* 1449 */       qhse.this.jTable1.getColumnModel().getColumn(30).setMinWidth(80);
/* 1450 */       qhse.this.jTable1.getColumnModel().getColumn(30).setMaxWidth(80);
/*      */ 
/*      */       
/* 1453 */       qhse.this.jTable1.setAutoCreateRowSorter(true);
/* 1454 */       qhse.this.jTable1.getTableHeader().setReorderingAllowed(false);
/*      */       
/* 1456 */       qhse.this.jTable1.getColumnModel().getColumn(0).setCellRenderer(qhse.this.celda);
/* 1457 */       qhse.this.jTable1.getColumnModel().getColumn(1).setCellRenderer(qhse.this.celda);
/* 1458 */       qhse.this.jTable1.getColumnModel().getColumn(2).setCellRenderer(qhse.this.celda);
/* 1459 */       qhse.this.jTable1.getColumnModel().getColumn(3).setCellRenderer(qhse.this.celda);
/* 1460 */       qhse.this.jTable1.getColumnModel().getColumn(4).setCellRenderer(qhse.this.celda);
/* 1461 */       qhse.this.jTable1.getColumnModel().getColumn(5).setCellRenderer(qhse.this.celda);
/* 1462 */       qhse.this.jTable1.getColumnModel().getColumn(6).setCellRenderer(qhse.this.celda);
/* 1463 */       qhse.this.jTable1.getColumnModel().getColumn(7).setCellRenderer(qhse.this.celda);
/* 1464 */       qhse.this.jTable1.getColumnModel().getColumn(8).setCellRenderer(qhse.this.celda);
/* 1465 */       qhse.this.jTable1.getColumnModel().getColumn(9).setCellRenderer(qhse.this.celda);
/* 1466 */       qhse.this.jTable1.getColumnModel().getColumn(10).setCellRenderer(qhse.this.celda);
/* 1467 */       qhse.this.jTable1.getColumnModel().getColumn(11).setCellRenderer(qhse.this.celda);
/* 1468 */       qhse.this.jTable1.getColumnModel().getColumn(12).setCellRenderer(qhse.this.celda);
/* 1469 */       qhse.this.jTable1.getColumnModel().getColumn(13).setCellRenderer(qhse.this.celda);
/* 1470 */       qhse.this.jTable1.getColumnModel().getColumn(14).setCellRenderer(qhse.this.celda);
/*      */       
/* 1472 */       qhse.this.jTable1.getColumnModel().getColumn(15).setCellRenderer(qhse.this.celda);
/* 1473 */       qhse.this.jTable1.getColumnModel().getColumn(16).setCellRenderer(qhse.this.celda);
/* 1474 */       qhse.this.jTable1.getColumnModel().getColumn(17).setCellRenderer(qhse.this.celda);
/* 1475 */       qhse.this.jTable1.getColumnModel().getColumn(18).setCellRenderer(qhse.this.celda);
/* 1476 */       qhse.this.jTable1.getColumnModel().getColumn(19).setCellRenderer(qhse.this.celda);
/* 1477 */       qhse.this.jTable1.getColumnModel().getColumn(20).setCellRenderer(qhse.this.celda);
/* 1478 */       qhse.this.jTable1.getColumnModel().getColumn(21).setCellRenderer(qhse.this.celda);
/* 1479 */       qhse.this.jTable1.getColumnModel().getColumn(22).setCellRenderer(qhse.this.celda);
/* 1480 */       qhse.this.jTable1.getColumnModel().getColumn(23).setCellRenderer(qhse.this.celda);
/* 1481 */       qhse.this.jTable1.getColumnModel().getColumn(24).setCellRenderer(qhse.this.celda);
/* 1482 */       qhse.this.jTable1.getColumnModel().getColumn(25).setCellRenderer(qhse.this.celda);
/* 1483 */       qhse.this.jTable1.getColumnModel().getColumn(26).setCellRenderer(qhse.this.celda);
/* 1484 */       qhse.this.jTable1.getColumnModel().getColumn(27).setCellRenderer(qhse.this.celda);
/* 1485 */       qhse.this.jTable1.getColumnModel().getColumn(28).setCellRenderer(qhse.this.celda);
/* 1486 */       qhse.this.jTable1.getColumnModel().getColumn(29).setCellRenderer(qhse.this.celda);
/* 1487 */       qhse.this.jTable1.getColumnModel().getColumn(30).setCellRenderer(qhse.this.celda);
/* 1488 */       qhse.this.jTable1.getColumnModel().getColumn(31).setCellRenderer(qhse.this.celda);
/*      */       
/* 1490 */       for (i = 0; i < qhse.this.jTable1.getRowCount(); i++) {
/* 1491 */         String residuo = String.valueOf(qhse.this.jTable1.getValueAt(i, 9));
/* 1492 */         String guia = String.valueOf(qhse.this.jTable1.getValueAt(i, 13));
/* 1493 */         if (residuo.equals("SANEAMIENTO") || residuo.equals("RECORTE BASE ACEITE")) {
/* 1494 */           qhse.this.con.consultar("manifiesto", "manifiestos_recorteaceite", "where num_guia = '" + guia + "'");
/* 1495 */           qhse.this.jTable1.setValueAt(qhse.this.con.Campo, i, 13);
/*      */         } else {
/*      */           
/* 1498 */           qhse.this.con.consultar("manifiesto", "manifiestos_lodoagua", "where num_guia = '" + guia + "'");
/* 1499 */           qhse.this.jTable1.setValueAt(qhse.this.con.Campo, i, 13);
/*      */         } 
/*      */       } 
/*      */     } }
/*      */   
/*      */   public void verDatos() {
/* 1505 */     if (this.jTextField1.getText().equals("")) {
/* 1506 */       this.error.cargarError(this.jTextField1, "007");
/*      */     }
/* 1508 */     else if (this.jTextField2.getText().equals("")) {
/* 1509 */       this.error.cargarError(this.jTextField2, "007");
/*      */     }
/* 1511 */     else if (this.jTextField3.getText().equals("")) {
/* 1512 */       this.error.cargarError(this.jTextField3, "007");
/*      */     }
/* 1514 */     else if (this.jTextField4.getText().equals("")) {
/* 1515 */       this.error.cargarError(this.jTextField4, "007");
/*      */     }
/* 1517 */     else if (this.jTextField5.getText().equals("")) {
/* 1518 */       this.error.cargarError(this.jTextField5, "007");
/*      */     }
/* 1520 */     else if (this.jDateChooser4.getDate() == null) {
/* 1521 */       JOptionPane.showMessageDialog(this.padre, "La fecha de inicio no la puedes dejar vacía, por favor completa tu información", "Fecha de Inicio Vacía", 0, this.ERROR);
/*      */     }
/* 1523 */     else if (this.jDateChooser5.getDate() == null) {
/* 1524 */       JOptionPane.showMessageDialog(this.padre, "La fecha de final no la puedes dejar vacía, por favor completa tu información", "Fecha de Inicio Vacía", 0, this.ERROR);
/*      */     }
/* 1526 */     else if (this.jDateChooser4.getDate().after(this.jDateChooser5.getDate())) {
/* 1527 */       JOptionPane.showMessageDialog(this.padre, "La fecha de final debe ser mayor a la fecha de inicio\nPor favor confirma las fechas.", "Fechas Erróneas", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 1530 */       this.CONT++;
/* 1531 */       this.espe = new Esperando();
/* 1532 */       this.espe.start();
/* 1533 */       this.jComboBox1.setEnabled(true);
/* 1534 */       this.jComboBox2.setEnabled(true);
/* 1535 */       this.jComboBox3.setEnabled(true);
/* 1536 */       this.jComboBox4.setEnabled(true);
/* 1537 */       this.jComboBox5.setEnabled(true);
/* 1538 */       this.jComboBox6.setEnabled(true);
/* 1539 */       this.jComboBox7.setEnabled(true);
/*      */     } 
/*      */   }
/*      */   public int diasDelMes(int mes, int año) {
/* 1543 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 1551 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 1557 */         return 30;
/*      */       
/*      */       case 1:
/* 1560 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 1562 */           return 29;
/*      */         }
/* 1564 */         return 28;
/*      */     } 
/*      */     
/* 1567 */     return 0;
/*      */   }
/*      */   class CeldaRender extends DefaultTableCellRenderer { int otro; int[] indices;
/*      */     CeldaRender() {
/* 1571 */       this.otro = -1;
/* 1572 */       this.indices = new int[0];
/*      */     } public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 1574 */       setEnabled((table == null || table.isEnabled()));
/* 1575 */       setAutoscrolls(true);
/* 1576 */       if (comparar(row)) {
/* 1577 */         setBackground(Color.red);
/*      */       }
/* 1579 */       else if (row % 2 == 0) {
/*      */         
/* 1581 */         setBackground(new Color(194, 213, 151));
/*      */       } else {
/*      */         
/* 1584 */         setBackground((Color)null);
/*      */       } 
/*      */       
/* 1587 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 1588 */       return this;
/*      */     }
/*      */     public void pasarInd(int[] ind) {
/* 1591 */       this.indices = ind;
/*      */     }
/*      */     public boolean comparar(int reg) {
/* 1594 */       for (int i = 0; i < this.indices.length; i++) {
/* 1595 */         if (this.indices[i] == reg) {
/* 1596 */           return true;
/*      */         }
/*      */       } 
/* 1599 */       return false;
/*      */     } }
/*      */ 
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/qhse.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */