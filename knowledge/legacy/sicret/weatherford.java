/*      */ package sicret;
/*      */ import java.awt.Color;
/*      */ import java.awt.Font;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusAdapter;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.text.NumberFormat;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ 
/*      */ public class weatherford extends JPanel {
/*      */   Border borde;
/*      */   Color color;
/*      */   JFrame padre;
/*      */   JScrollPane panel;
/*   21 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*   22 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*   23 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*   24 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*   25 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*   26 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*   27 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*   28 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*   29 */   Consultas con = new Consultas();
/*      */   boolean encontrado = false;
/*      */   MostrarTabla modelo;
/*   32 */   String[] Campos = new String[] { "Núm.", "Nombre", "Apellido Paterno", "Apellido Materno", "Calle", "Número", "Colonia", "C.P.", "Ciduad", "Estado", "Teléfono 1", "Teléfono 2", "Correo", "Fecha de Nacimiento", "Sexo", "Abogados" };
/*      */   JTabbedPane fichas;
/*      */   String USUARIO;
/*      */   JTable tabla;
/*      */   EscribirReporte esc;
/*   37 */   Errores error = new Errores(false);
/*   38 */   Validaciones val = new Validaciones();
/*   39 */   String CLAVE = "";
/*   40 */   Date fechaActual = new Date();
/*   41 */   Date fecha = new Date();
/*      */   String[] CLAVES;
/*   43 */   Date fechaInicio = null;
/*   44 */   Date fechaTermino = null;
/*   45 */   Date fechaMinimo = null;
/*      */   
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
/*   58 */   String MES = "";
/*   59 */   String[] CONCEPTOS = new String[] { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };
/*   60 */   int CONTADOR = 0; private JButton jButton1; private JButton jButton10; private JButton jButton12; private JButton jButton13; private JButton jButton2; private JButton jButton3; private JButton jButton4; private JButton jButton5; private JButton jButton6; private JButton jButton7; private JButton jButton8; private JButton jButton9; private JComboBox jComboBox1; private JDateChooser jDateChooser4; private JDateChooser jDateChooser5; private JDialog jDialog1; private JDialog jDialog2; private JDialog jDialog3; private JLabel jLabel1; private JLabel jLabel11; private JLabel jLabel12; private JLabel jLabel13; private JLabel jLabel14; private JLabel jLabel15; private JLabel jLabel17; private JLabel jLabel18; private JLabel jLabel19; private JLabel jLabel2; private JLabel jLabel20; private JLabel jLabel21; private JLabel jLabel22; private JLabel jLabel23; private JLabel jLabel24; private JLabel jLabel30; private JLabel jLabel31; private JLabel jLabel32; private JLabel jLabel33; private JLabel jLabel34; private JLabel jLabel35; private JLabel jLabel36; private JLabel jLabel37; private JLabel jLabel46; private JLabel jLabel47; private JLabel jLabel48; private JLabel jLabel49; private JLabel jLabel5; private JLabel jLabel50; private JLabel jLabel51;
/*      */   public weatherford(JScrollPane panelito, String usua, JTabbedPane fichas, JTable Tabla, String num, JFrame padre) {
/*   62 */     String año = "2009";
/*   63 */     String mes = "11";
/*   64 */     String dia = "19";
/*   65 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*   66 */     String strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*   68 */       this.fechaInicio = formatoDelTexto.parse(strFecha);
/*      */     }
/*   70 */     catch (ParseException ex) {
/*   71 */       ex.printStackTrace();
/*      */     } 
/*      */     
/*   74 */     Calendar ca = Calendar.getInstance();
/*   75 */     Calendar fecha = Calendar.getInstance();
/*   76 */     int aa = fecha.get(1);
/*   77 */     int mm = fecha.get(2);
/*   78 */     int dd = fecha.get(5);
/*   79 */     int diasTotal = diasDelMes(mm, aa);
/*   80 */     formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*   81 */     strFecha = "";
/*   82 */     if (diasTotal == dd) {
/*   83 */       dd = 1;
/*   84 */       if (mm == 11) {
/*   85 */         aa++;
/*   86 */         mm = 0;
/*      */       } else {
/*      */         
/*   89 */         mm++;
/*      */       } 
/*      */     } else {
/*   92 */       dd++;
/*      */     } 
/*   94 */     mm++;
/*   95 */     año = "" + aa;
/*   96 */     mes = "" + mm;
/*   97 */     dia = "" + dd;
/*   98 */     formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/*   99 */     strFecha = dia + "-" + dia + "-" + mes;
/*      */     try {
/*  101 */       this.fechaTermino = formatoDelTexto.parse(strFecha);
/*      */     }
/*  103 */     catch (ParseException ex) {
/*  104 */       ex.printStackTrace();
/*      */     } 
/*  106 */     this.USUARIO = usua;
/*      */     
/*  108 */     this.fichas = fichas;
/*  109 */     this.padre = padre;
/*  110 */     initComponents();
/*  111 */     panelito.setViewportView(this);
/*  112 */     this.panel = panelito;
/*  113 */     colorear();
/*  114 */     consultar();
/*      */     
/*  116 */     int w = this.tama.width;
/*  117 */     int h = this.tama.height;
/*  118 */     int rw = (w - 987) / 2;
/*  119 */     int rh = (h - 737) / 2;
/*  120 */     this.jDialog1.setLocation(rw, rh);
/*  121 */     this.jDialog1.setSize(987, 737);
/*  122 */     this.jDialog1.setVisible(false);
/*  123 */     this.jDialog1.setResizable(false);
/*      */     
/*  125 */     rw = (w - 733) / 2;
/*  126 */     rh = (h - 160) / 2;
/*  127 */     this.jDialog2.setLocation(rw, rh);
/*  128 */     this.jDialog2.setSize(733, 160);
/*  129 */     this.jDialog2.setVisible(false);
/*  130 */     this.jDialog2.setResizable(false);
/*      */     
/*  132 */     this.jDialog3.setLocation(550, 20);
/*  133 */     this.jDialog3.setSize(700, 250);
/*  134 */     this.jDialog3.setVisible(false);
/*  135 */     this.jDialog2.setResizable(false);
/*      */     
/*  137 */     Image imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/link.gif"));
/*  138 */     Cursor micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  139 */     this.jLabel5.setCursor(micursor);
/*      */     
/*  141 */     imagen = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  142 */     micursor = this.tk.createCustomCursor(imagen, new Point(1, 1), null);
/*  143 */     this.jDialog1.setCursor(micursor);
/*  144 */     this.jDialog2.setCursor(micursor);
/*  145 */     this.jDialog3.setCursor(micursor);
/*  146 */     llenarCombo();
/*  147 */     sacarFecha();
/*      */   }
/*      */   private JLabel jLabel54; private JLabel jLabel56; private JLabel jLabel61; private JLabel jLabel62; private JLabel jLabel63; private JLabel jLabel64; private JLabel jLabel65; private JLabel jLabel66; private JLabel jLabel67; private JLabel jLabel68; private JPanel jPanel1; private JPanel jPanel17; private JPanel jPanel2; private JPanel jPanel21; private JPanel jPanel22; private JPanel jPanel23; private JPanel jPanel25; private JPanel jPanel26; private JPanel jPanel30; private JPanel jPanel32; private JPanel jPanel33; private JPanel jPanel34; private JPanel jPanel35; private JPanel jPanel5; private JPanel jPanel6; private JPanel jPanel8; private JPanel jPanel9; private JScrollPane jScrollPane1; private JScrollPane jScrollPane2; private JScrollPane jScrollPane3; private JSeparator jSeparator1; private JSeparator jSeparator3; private JSeparator jSeparator4; private JTable jTable1; private JTable jTable2; private JTable jTable3; private JTextField jTextField1; private JTextField jTextField10; private JTextField jTextField11; private JTextField jTextField17; private JTextField jTextField2; private JTextField jTextField3; private JTextField jTextField4; private JTextField jTextField5; private JTextField jTextField6; private JTextField jTextField7; private JTextField jTextField8; private JTextField jTextField9;
/*      */   
/*      */   private void initComponents() {
/*  152 */     this.jDialog1 = new JDialog(this.padre);
/*  153 */     this.jPanel6 = new JPanel();
/*  154 */     this.jLabel22 = new JLabel();
/*  155 */     this.jLabel11 = new JLabel();
/*  156 */     this.jPanel21 = new JPanel();
/*  157 */     this.jLabel12 = new JLabel();
/*  158 */     this.jLabel13 = new JLabel();
/*  159 */     this.jLabel14 = new JLabel();
/*  160 */     this.jLabel17 = new JLabel();
/*  161 */     this.jPanel22 = new JPanel();
/*  162 */     this.jLabel18 = new JLabel();
/*  163 */     this.jLabel20 = new JLabel();
/*  164 */     this.jLabel21 = new JLabel();
/*  165 */     this.jLabel23 = new JLabel();
/*  166 */     this.jLabel34 = new JLabel();
/*  167 */     this.jLabel35 = new JLabel();
/*  168 */     this.jLabel36 = new JLabel();
/*  169 */     this.jLabel37 = new JLabel();
/*  170 */     this.jPanel23 = new JPanel();
/*  171 */     this.jPanel25 = new JPanel();
/*  172 */     this.jLabel30 = new JLabel();
/*  173 */     this.jLabel31 = new JLabel();
/*  174 */     this.jLabel32 = new JLabel();
/*  175 */     this.jLabel50 = new JLabel();
/*  176 */     this.jLabel51 = new JLabel();
/*  177 */     this.jSeparator1 = new JSeparator();
/*  178 */     this.jLabel56 = new JLabel();
/*  179 */     this.jLabel33 = new JLabel();
/*  180 */     this.jTextField11 = new JTextField();
/*  181 */     this.jPanel26 = new JPanel();
/*  182 */     this.jTextField1 = new JTextField();
/*  183 */     this.jPanel30 = new JPanel();
/*  184 */     this.jTextField5 = new JTextField();
/*  185 */     this.jPanel32 = new JPanel();
/*  186 */     this.jLabel61 = new JLabel();
/*  187 */     this.jLabel64 = new JLabel();
/*  188 */     this.jPanel2 = new JPanel();
/*  189 */     this.jTextField2 = new JTextField();
/*  190 */     this.jPanel35 = new JPanel();
/*  191 */     this.jLabel15 = new JLabel();
/*  192 */     this.jScrollPane1 = new JScrollPane();
/*  193 */     this.jTable1 = new JTable();
/*  194 */     this.jPanel33 = new JPanel();
/*  195 */     this.jTextField3 = new JTextField();
/*  196 */     this.jPanel34 = new JPanel();
/*  197 */     this.jTextField4 = new JTextField();
/*  198 */     this.jComboBox1 = new JComboBox();
/*  199 */     this.jLabel19 = new JLabel();
/*  200 */     this.jLabel24 = new JLabel();
/*  201 */     this.jButton9 = new JButton();
/*  202 */     this.jButton8 = new JButton();
/*  203 */     this.jButton7 = new JButton();
/*  204 */     this.jButton1 = new JButton();
/*  205 */     this.jTextField9 = new JTextField();
/*  206 */     this.jDialog2 = new JDialog(this.jDialog1);
/*  207 */     this.jPanel8 = new JPanel();
/*  208 */     this.jLabel62 = new JLabel();
/*  209 */     this.jSeparator3 = new JSeparator();
/*  210 */     this.jLabel63 = new JLabel();
/*  211 */     this.jTextField6 = new JTextField();
/*  212 */     this.jButton12 = new JButton();
/*  213 */     this.jButton13 = new JButton();
/*  214 */     this.jLabel65 = new JLabel();
/*  215 */     this.jTextField7 = new JTextField();
/*  216 */     this.jLabel66 = new JLabel();
/*  217 */     this.jTextField8 = new JTextField();
/*  218 */     this.jLabel67 = new JLabel();
/*  219 */     this.jTextField17 = new JTextField();
/*  220 */     this.jDialog3 = new JDialog(this.padre);
/*  221 */     this.jPanel9 = new JPanel();
/*  222 */     this.jLabel68 = new JLabel();
/*  223 */     this.jSeparator4 = new JSeparator();
/*  224 */     this.jScrollPane2 = new JScrollPane();
/*  225 */     this.jTable2 = new JTable();
/*  226 */     this.jButton2 = new JButton();
/*  227 */     this.jLabel1 = new JLabel();
/*  228 */     this.jLabel2 = new JLabel();
/*  229 */     this.jPanel1 = new JPanel();
/*  230 */     this.jLabel54 = new JLabel();
/*  231 */     this.jPanel5 = new JPanel();
/*  232 */     this.jLabel48 = new JLabel();
/*  233 */     this.jScrollPane3 = new JScrollPane();
/*  234 */     this.jTable3 = new JTable();
/*  235 */     this.jPanel17 = new JPanel();
/*  236 */     this.jLabel46 = new JLabel();
/*  237 */     this.jDateChooser4 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  238 */     this.jDateChooser5 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  239 */     this.jLabel47 = new JLabel();
/*  240 */     this.jLabel5 = new JLabel();
/*  241 */     this.jButton3 = new JButton();
/*  242 */     this.jButton6 = new JButton();
/*  243 */     this.jButton4 = new JButton();
/*  244 */     this.jButton5 = new JButton();
/*  245 */     this.jTextField10 = new JTextField();
/*  246 */     this.jLabel49 = new JLabel();
/*  247 */     this.jButton10 = new JButton();
/*      */     
/*  249 */     this.jDialog1.setModal(true);
/*  250 */     this.jDialog1.setUndecorated(true);
/*      */     
/*  252 */     this.jPanel6.setBackground(new Color(255, 255, 255));
/*  253 */     this.jPanel6.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
/*      */     
/*  255 */     this.jLabel22.setFont(new Font("Tahoma", 1, 22));
/*  256 */     this.jLabel22.setHorizontalAlignment(0);
/*  257 */     this.jLabel22.setText("<HTML><CENTER>FLETES Y MATERIALES FORSIS,<BR> S.A. DE C.V.</CENTER></HTML>");
/*      */     
/*  259 */     this.jLabel11.setFont(new Font("Tahoma", 0, 9));
/*  260 */     this.jLabel11.setHorizontalAlignment(0);
/*  261 */     this.jLabel11.setText("<HTML><CENTER>MATRIZ<BR>AUTOPISTA MONTERREY-CADEREYTA KM. 32.5<BR>A.P. 129 C.P. 67450 CADEREYTA JÍMENEZ N.L.<BR>TELS: 01(828) 284-4291, 284-4444, 284-4290 FAX:284-5671<BR> www.forsis.com &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; R.F.C. FMF-901004-UZ9</CENTER></HTML>");
/*      */     
/*  263 */     this.jPanel21.setBackground(new Color(255, 255, 255));
/*  264 */     this.jPanel21.setBorder(BorderFactory.createTitledBorder(null, " FECHA ", 2, 1, new Font("Tahoma", 1, 11)));
/*      */     
/*  266 */     this.jLabel12.setFont(new Font("Tahoma", 1, 12));
/*  267 */     this.jLabel12.setForeground(new Color(255, 0, 0));
/*  268 */     this.jLabel12.setHorizontalAlignment(0);
/*  269 */     this.jLabel12.setText("20/10/2009");
/*      */     
/*  271 */     GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
/*  272 */     this.jPanel21.setLayout(jPanel21Layout);
/*  273 */     jPanel21Layout.setHorizontalGroup(jPanel21Layout
/*  274 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  275 */         .addGroup(jPanel21Layout.createSequentialGroup()
/*  276 */           .addContainerGap()
/*  277 */           .addComponent(this.jLabel12, -1, 163, 32767)
/*  278 */           .addContainerGap()));
/*      */     
/*  280 */     jPanel21Layout.setVerticalGroup(jPanel21Layout
/*  281 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  282 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
/*  283 */           .addContainerGap(-1, 32767)
/*  284 */           .addComponent(this.jLabel12)));
/*      */ 
/*      */     
/*  287 */     this.jLabel13.setFont(new Font("Tahoma", 0, 8));
/*  288 */     this.jLabel13.setText("<HTML><CENTER><b>BASE VERACRUZ</b><BR>AUTOPISTA AUTOPISTA A CARDEL KM. 5.<BR>COL. VERGARA TARIMOYA<BR>VERACRUZ, VER. C.P. 91810<BR>TELÉFONOS: 01(229) 924-8601 AL 03</CENTER></HTML>");
/*      */     
/*  290 */     this.jLabel14.setFont(new Font("Tahoma", 0, 8));
/*  291 */     this.jLabel14.setText("<HTML><CENTER><b>BASE POZA RICA</b><BR>EMÍLIO CARRANZA No. 6<BR>COL. LÓPEZ MATEOS<BR>POZA RICA, VERACRUZ<BR>TEL. 01 (782) 825-0387</CENTER></HTML>");
/*      */     
/*  293 */     this.jLabel17.setFont(new Font("Tahoma", 0, 8));
/*  294 */     this.jLabel17.setText("<HTML><CENTER><b>BASE TABASCO</b><BR>TEL. 01 (993) 399-9095<BR>01 (993) 160-7498<BR>VILLA HERMOSA</CENTER></HTML>");
/*      */     
/*  296 */     this.jPanel22.setBackground(new Color(255, 255, 255));
/*  297 */     this.jPanel22.setBorder(BorderFactory.createTitledBorder(null, "", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  299 */     this.jLabel18.setFont(new Font("Tahoma", 1, 11));
/*  300 */     this.jLabel18.setText("ORIGEN");
/*      */     
/*  302 */     this.jLabel20.setFont(new Font("Tahoma", 1, 11));
/*  303 */     this.jLabel20.setText("DOMICILIO");
/*      */     
/*  305 */     this.jLabel21.setFont(new Font("Tahoma", 1, 11));
/*  306 */     this.jLabel21.setText("COLONIA");
/*      */     
/*  308 */     this.jLabel23.setFont(new Font("Tahoma", 1, 11));
/*  309 */     this.jLabel23.setText("R.F.C.");
/*      */     
/*  311 */     this.jLabel34.setFont(new Font("Tahoma", 1, 11));
/*  312 */     this.jLabel34.setForeground(new Color(255, 0, 0));
/*  313 */     this.jLabel34.setText("WEATHERFORD S.A. DE C.V.");
/*      */     
/*  315 */     this.jLabel35.setFont(new Font("Tahoma", 1, 11));
/*  316 */     this.jLabel35.setForeground(new Color(255, 0, 0));
/*  317 */     this.jLabel35.setText("CARRETERA MÉXICO - TUXPAN 297,");
/*      */     
/*  319 */     this.jLabel36.setFont(new Font("Tahoma", 1, 11));
/*  320 */     this.jLabel36.setForeground(new Color(255, 0, 0));
/*  321 */     this.jLabel36.setText("S/N TIHUATLÁN, VERACRUZ");
/*      */     
/*  323 */     this.jLabel37.setFont(new Font("Tahoma", 1, 11));
/*  324 */     this.jLabel37.setForeground(new Color(255, 0, 0));
/*  325 */     this.jLabel37.setText(" ");
/*      */     
/*  327 */     GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
/*  328 */     this.jPanel22.setLayout(jPanel22Layout);
/*  329 */     jPanel22Layout.setHorizontalGroup(jPanel22Layout
/*  330 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  331 */         .addGroup(jPanel22Layout.createSequentialGroup()
/*  332 */           .addContainerGap()
/*  333 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  334 */             .addGroup(jPanel22Layout.createSequentialGroup()
/*  335 */               .addComponent(this.jLabel21, -2, 67, -2)
/*  336 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  337 */               .addComponent(this.jLabel36, -1, 357, 32767))
/*  338 */             .addGroup(jPanel22Layout.createSequentialGroup()
/*  339 */               .addComponent(this.jLabel23, -2, 67, -2)
/*  340 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  341 */               .addComponent(this.jLabel37, -1, 357, 32767))
/*  342 */             .addGroup(jPanel22Layout.createSequentialGroup()
/*  343 */               .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  344 */                 .addComponent(this.jLabel18, -2, 67, -2)
/*  345 */                 .addComponent(this.jLabel20, -2, 67, -2))
/*  346 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  347 */               .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  348 */                 .addComponent(this.jLabel35, -1, 357, 32767)
/*  349 */                 .addComponent(this.jLabel34, -1, 357, 32767))))
/*  350 */           .addGap(22, 22, 22)));
/*      */     
/*  352 */     jPanel22Layout.setVerticalGroup(jPanel22Layout
/*  353 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  354 */         .addGroup(jPanel22Layout.createSequentialGroup()
/*  355 */           .addContainerGap(-1, 32767)
/*  356 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  357 */             .addComponent(this.jLabel18)
/*  358 */             .addComponent(this.jLabel34))
/*  359 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  360 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  361 */             .addComponent(this.jLabel20)
/*  362 */             .addComponent(this.jLabel35))
/*  363 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  364 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  365 */             .addComponent(this.jLabel21)
/*  366 */             .addComponent(this.jLabel36))
/*  367 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  368 */           .addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  369 */             .addComponent(this.jLabel23)
/*  370 */             .addComponent(this.jLabel37))
/*  371 */           .addGap(26, 26, 26)));
/*      */ 
/*      */     
/*  374 */     this.jPanel23.setBackground(new Color(255, 255, 255));
/*  375 */     this.jPanel23.setBorder(BorderFactory.createTitledBorder(null, "", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  377 */     GroupLayout jPanel23Layout = new GroupLayout(this.jPanel23);
/*  378 */     this.jPanel23.setLayout(jPanel23Layout);
/*  379 */     jPanel23Layout.setHorizontalGroup(jPanel23Layout
/*  380 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  381 */         .addGap(0, 472, 32767));
/*      */     
/*  383 */     jPanel23Layout.setVerticalGroup(jPanel23Layout
/*  384 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  385 */         .addGap(0, 87, 32767));
/*      */ 
/*      */     
/*  388 */     this.jPanel25.setBackground(new Color(255, 255, 255));
/*      */     
/*  390 */     this.jLabel30.setFont(new Font("Tahoma", 1, 11));
/*  391 */     this.jLabel30.setText("SUB-TOTAL");
/*      */     
/*  393 */     this.jLabel31.setFont(new Font("Tahoma", 1, 11));
/*  394 */     this.jLabel31.setText("I.V.A.");
/*      */     
/*  396 */     this.jLabel32.setFont(new Font("Tahoma", 1, 11));
/*  397 */     this.jLabel32.setText("RET-IVA");
/*      */     
/*  399 */     this.jLabel50.setFont(new Font("Tahoma", 1, 12));
/*  400 */     this.jLabel50.setForeground(new Color(255, 0, 0));
/*  401 */     this.jLabel50.setHorizontalAlignment(4);
/*  402 */     this.jLabel50.setText("00.00");
/*      */     
/*  404 */     this.jLabel51.setFont(new Font("Tahoma", 1, 12));
/*  405 */     this.jLabel51.setForeground(new Color(255, 0, 0));
/*  406 */     this.jLabel51.setHorizontalAlignment(4);
/*  407 */     this.jLabel51.setText("00.00");
/*      */     
/*  409 */     this.jSeparator1.setForeground(new Color(0, 0, 0));
/*  410 */     this.jSeparator1.setOrientation(1);
/*      */     
/*  412 */     this.jLabel56.setFont(new Font("Tahoma", 1, 12));
/*  413 */     this.jLabel56.setForeground(new Color(255, 0, 0));
/*  414 */     this.jLabel56.setHorizontalAlignment(4);
/*  415 */     this.jLabel56.setText("00.00");
/*      */     
/*  417 */     this.jLabel33.setFont(new Font("Tahoma", 1, 11));
/*  418 */     this.jLabel33.setText("TOTAL");
/*      */     
/*  420 */     this.jTextField11.setFont(new Font("Tahoma", 1, 12));
/*  421 */     this.jTextField11.setForeground(Color.red);
/*  422 */     this.jTextField11.setHorizontalAlignment(4);
/*  423 */     this.jTextField11.setText("00.00");
/*  424 */     this.jTextField11.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/*  426 */             weatherford.this.jTextField11FocusGained(evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/*  429 */             weatherford.this.jTextField11FocusLost(evt);
/*      */           }
/*      */         });
/*  432 */     this.jTextField11.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  434 */             weatherford.this.jTextField11KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  438 */     GroupLayout jPanel25Layout = new GroupLayout(this.jPanel25);
/*  439 */     this.jPanel25.setLayout(jPanel25Layout);
/*  440 */     jPanel25Layout.setHorizontalGroup(jPanel25Layout
/*  441 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  442 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
/*  443 */           .addContainerGap(66, 32767)
/*  444 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  445 */             .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  446 */               .addComponent(this.jLabel31, GroupLayout.Alignment.TRAILING, -2, 67, -2)
/*  447 */               .addComponent(this.jLabel32, -2, 67, -2)
/*  448 */               .addComponent(this.jLabel30))
/*  449 */             .addComponent(this.jLabel33, -2, 67, -2))
/*  450 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  451 */           .addComponent(this.jSeparator1, -2, 14, -2)
/*  452 */           .addGap(10, 10, 10)
/*  453 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  454 */             .addComponent(this.jLabel56, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  455 */             .addComponent(this.jLabel51, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  456 */             .addComponent(this.jLabel50, GroupLayout.Alignment.LEADING, -1, 116, 32767)
/*  457 */             .addComponent(this.jTextField11, GroupLayout.Alignment.LEADING))
/*  458 */           .addGap(29, 29, 29)));
/*      */     
/*  460 */     jPanel25Layout.setVerticalGroup(jPanel25Layout
/*  461 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  462 */         .addGroup(jPanel25Layout.createSequentialGroup()
/*  463 */           .addGap(11, 11, 11)
/*  464 */           .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  465 */             .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  466 */               .addComponent(this.jSeparator1, GroupLayout.Alignment.LEADING)
/*  467 */               .addGroup(jPanel25Layout.createSequentialGroup()
/*  468 */                 .addComponent(this.jLabel30)
/*  469 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  470 */                 .addComponent(this.jLabel31)
/*  471 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  472 */                 .addComponent(this.jLabel32)
/*  473 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  474 */                 .addComponent(this.jLabel33)))
/*  475 */             .addGroup(jPanel25Layout.createSequentialGroup()
/*  476 */               .addComponent(this.jLabel50)
/*  477 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  478 */               .addComponent(this.jLabel51)
/*  479 */               .addGap(1, 1, 1)
/*  480 */               .addComponent(this.jTextField11, -2, -1, -2)
/*  481 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  482 */               .addComponent(this.jLabel56)))
/*  483 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  486 */     this.jPanel26.setBackground(new Color(255, 255, 255));
/*  487 */     this.jPanel26.setBorder(BorderFactory.createTitledBorder(null, "SU PEDIDO No.", 2, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  489 */     GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
/*  490 */     this.jPanel26.setLayout(jPanel26Layout);
/*  491 */     jPanel26Layout.setHorizontalGroup(jPanel26Layout
/*  492 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  493 */         .addGroup(jPanel26Layout.createSequentialGroup()
/*  494 */           .addContainerGap()
/*  495 */           .addComponent(this.jTextField1, -1, 203, 32767)
/*  496 */           .addContainerGap()));
/*      */     
/*  498 */     jPanel26Layout.setVerticalGroup(jPanel26Layout
/*  499 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  500 */         .addGroup(jPanel26Layout.createSequentialGroup()
/*  501 */           .addComponent(this.jTextField1, -2, -1, -2)
/*  502 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  505 */     this.jPanel30.setBackground(new Color(255, 255, 255));
/*  506 */     this.jPanel30.setBorder(BorderFactory.createTitledBorder(null, "CANTIDAD EN LETRA", 2, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  508 */     GroupLayout jPanel30Layout = new GroupLayout(this.jPanel30);
/*  509 */     this.jPanel30.setLayout(jPanel30Layout);
/*  510 */     jPanel30Layout.setHorizontalGroup(jPanel30Layout
/*  511 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  512 */         .addComponent(this.jTextField5, -1, 640, 32767));
/*      */     
/*  514 */     jPanel30Layout.setVerticalGroup(jPanel30Layout
/*  515 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  516 */         .addGroup(jPanel30Layout.createSequentialGroup()
/*  517 */           .addComponent(this.jTextField5, -2, -1, -2)
/*  518 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  521 */     this.jPanel32.setBackground(new Color(255, 255, 255));
/*      */     
/*  523 */     GroupLayout jPanel32Layout = new GroupLayout(this.jPanel32);
/*  524 */     this.jPanel32.setLayout(jPanel32Layout);
/*  525 */     jPanel32Layout.setHorizontalGroup(jPanel32Layout
/*  526 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  527 */         .addGap(0, 286, 32767));
/*      */     
/*  529 */     jPanel32Layout.setVerticalGroup(jPanel32Layout
/*  530 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  531 */         .addGap(0, 55, 32767));
/*      */ 
/*      */     
/*  534 */     this.jLabel61.setFont(new Font("Tahoma", 1, 10));
/*  535 */     this.jLabel61.setForeground(new Color(255, 0, 0));
/*  536 */     this.jLabel61.setHorizontalAlignment(0);
/*  537 */     this.jLabel61.setText(" ");
/*      */     
/*  539 */     this.jLabel64.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/Forsis 190x.png")));
/*      */     
/*  541 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/*  542 */     this.jPanel2.setBorder(BorderFactory.createTitledBorder(null, "FACTURA", 2, 1, new Font("Tahoma", 1, 11)));
/*      */     
/*  544 */     this.jTextField2.setFont(new Font("Tahoma", 1, 20));
/*  545 */     this.jTextField2.setForeground(new Color(255, 0, 0));
/*  546 */     this.jTextField2.setHorizontalAlignment(0);
/*      */     
/*  548 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  549 */     this.jPanel2.setLayout(jPanel2Layout);
/*  550 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/*  551 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  552 */         .addGroup(jPanel2Layout.createSequentialGroup()
/*  553 */           .addContainerGap()
/*  554 */           .addComponent(this.jTextField2, -1, 163, 32767)
/*  555 */           .addContainerGap()));
/*      */     
/*  557 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/*  558 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  559 */         .addComponent(this.jTextField2, -1, 42, 32767));
/*      */ 
/*      */     
/*  562 */     this.jPanel35.setBackground(new Color(255, 255, 255));
/*  563 */     this.jPanel35.setBorder(BorderFactory.createTitledBorder(null, "LUGAR DE EXPEDICIÓN", 2, 1, new Font("Tahoma", 1, 11)));
/*      */     
/*  565 */     this.jLabel15.setFont(new Font("Tahoma", 1, 12));
/*  566 */     this.jLabel15.setForeground(new Color(255, 0, 0));
/*  567 */     this.jLabel15.setHorizontalAlignment(0);
/*  568 */     this.jLabel15.setText("POZA RICA");
/*      */     
/*  570 */     GroupLayout jPanel35Layout = new GroupLayout(this.jPanel35);
/*  571 */     this.jPanel35.setLayout(jPanel35Layout);
/*  572 */     jPanel35Layout.setHorizontalGroup(jPanel35Layout
/*  573 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  574 */         .addGroup(jPanel35Layout.createSequentialGroup()
/*  575 */           .addContainerGap()
/*  576 */           .addComponent(this.jLabel15, -1, 163, 32767)
/*  577 */           .addContainerGap()));
/*      */     
/*  579 */     jPanel35Layout.setVerticalGroup(jPanel35Layout
/*  580 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  581 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
/*  582 */           .addContainerGap(-1, 32767)
/*  583 */           .addComponent(this.jLabel15)));
/*      */ 
/*      */     
/*  586 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "CANTIDAD", "DESCRIPCIÓN", "PRECIO UNITARIO", "IMPORTE" })
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
/*  601 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/*  606 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*  609 */     this.jTable1.setEditingRow(0);
/*  610 */     this.jTable1.setSelectionMode(0);
/*  611 */     this.jTable1.setShowHorizontalLines(false);
/*  612 */     this.jScrollPane1.setViewportView(this.jTable1);
/*  613 */     this.jTable1.getColumnModel().getColumn(0).setMinWidth(100);
/*  614 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
/*  615 */     this.jTable1.getColumnModel().getColumn(2).setMinWidth(150);
/*  616 */     this.jTable1.getColumnModel().getColumn(2).setMaxWidth(150);
/*  617 */     this.jTable1.getColumnModel().getColumn(3).setMinWidth(150);
/*  618 */     this.jTable1.getColumnModel().getColumn(3).setMaxWidth(150);
/*      */     
/*  620 */     this.jPanel33.setBackground(new Color(255, 255, 255));
/*  621 */     this.jPanel33.setBorder(BorderFactory.createTitledBorder(null, "ZONA", 2, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  623 */     this.jTextField3.setEditable(false);
/*  624 */     this.jTextField3.setHorizontalAlignment(0);
/*  625 */     this.jTextField3.setText("POZA RICA");
/*      */     
/*  627 */     GroupLayout jPanel33Layout = new GroupLayout(this.jPanel33);
/*  628 */     this.jPanel33.setLayout(jPanel33Layout);
/*  629 */     jPanel33Layout.setHorizontalGroup(jPanel33Layout
/*  630 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  631 */         .addGroup(jPanel33Layout.createSequentialGroup()
/*  632 */           .addContainerGap()
/*  633 */           .addComponent(this.jTextField3, -1, 203, 32767)
/*  634 */           .addContainerGap()));
/*      */     
/*  636 */     jPanel33Layout.setVerticalGroup(jPanel33Layout
/*  637 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  638 */         .addGroup(jPanel33Layout.createSequentialGroup()
/*  639 */           .addComponent(this.jTextField3, -2, -1, -2)
/*  640 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  643 */     this.jPanel34.setBackground(new Color(255, 255, 255));
/*  644 */     this.jPanel34.setBorder(BorderFactory.createTitledBorder(null, "CONDICIONES", 2, 0, new Font("Tahoma", 1, 11)));
/*      */     
/*  646 */     GroupLayout jPanel34Layout = new GroupLayout(this.jPanel34);
/*  647 */     this.jPanel34.setLayout(jPanel34Layout);
/*  648 */     jPanel34Layout.setHorizontalGroup(jPanel34Layout
/*  649 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  650 */         .addGroup(jPanel34Layout.createSequentialGroup()
/*  651 */           .addContainerGap()
/*  652 */           .addComponent(this.jTextField4, -1, 450, 32767)
/*  653 */           .addContainerGap()));
/*      */     
/*  655 */     jPanel34Layout.setVerticalGroup(jPanel34Layout
/*  656 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  657 */         .addGroup(jPanel34Layout.createSequentialGroup()
/*  658 */           .addComponent(this.jTextField4, -2, -1, -2)
/*  659 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/*  662 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/*  663 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Selecciona uno...", "SERVICIO INTEGRAL", "FLETE" }));
/*      */     
/*  665 */     this.jLabel19.setFont(new Font("Tahoma", 1, 11));
/*  666 */     this.jLabel19.setHorizontalAlignment(4);
/*  667 */     this.jLabel19.setText("EQUIPO");
/*      */     
/*  669 */     this.jLabel24.setFont(new Font("Tahoma", 1, 11));
/*  670 */     this.jLabel24.setHorizontalAlignment(4);
/*  671 */     this.jLabel24.setText("POZO");
/*      */     
/*  673 */     this.jButton9.setMnemonic('I');
/*  674 */     this.jButton9.setText("Imprimir");
/*  675 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  677 */             weatherford.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  681 */     this.jButton8.setMnemonic('L');
/*  682 */     this.jButton8.setText("Limpiar");
/*  683 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  685 */             weatherford.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  689 */     this.jButton7.setMnemonic('S');
/*  690 */     this.jButton7.setText("Salir");
/*  691 */     this.jButton7.setToolTipText("Salir (Alt+S)");
/*  692 */     this.jButton7.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  694 */             weatherford.this.jButton7ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  698 */     this.jButton1.setText("Agregar ");
/*  699 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  701 */             weatherford.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  705 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  706 */     this.jPanel6.setLayout(jPanel6Layout);
/*  707 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout
/*  708 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  709 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  710 */           .addContainerGap()
/*  711 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  712 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  713 */               .addComponent(this.jScrollPane1, -2, 946, -2)
/*  714 */               .addContainerGap())
/*  715 */             .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  716 */               .addGroup(jPanel6Layout.createSequentialGroup()
/*  717 */                 .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  718 */                   .addGroup(jPanel6Layout.createSequentialGroup()
/*  719 */                     .addComponent(this.jLabel64, -2, 185, -2)
/*  720 */                     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  721 */                     .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  722 */                       .addGroup(jPanel6Layout.createSequentialGroup()
/*  723 */                         .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  724 */                           .addComponent(this.jLabel11, -2, 230, -2)
/*  725 */                           .addGroup(jPanel6Layout.createSequentialGroup()
/*  726 */                             .addComponent(this.jLabel13, -2, 174, -2)
/*  727 */                             .addGap(18, 18, 18)
/*  728 */                             .addComponent(this.jLabel14, -2, 125, -2)))
/*  729 */                         .addGap(18, 18, 18)
/*  730 */                         .addComponent(this.jLabel17, -2, 125, -2)
/*  731 */                         .addGap(4, 4, 4)
/*  732 */                         .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  733 */                           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  734 */                             .addComponent(this.jPanel2, -1, -1, 32767)
/*  735 */                             .addComponent(this.jPanel21, -2, -1, -2))
/*  736 */                           .addComponent(this.jPanel35, -2, -1, -2)))
/*  737 */                       .addComponent(this.jLabel22, -2, 421, -2))
/*  738 */                     .addGap(816, 816, 816))
/*  739 */                   .addGroup(jPanel6Layout.createSequentialGroup()
/*  740 */                     .addComponent(this.jLabel61, -2, 556, -2)
/*  741 */                     .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 492, 32767)
/*  742 */                     .addComponent(this.jPanel32, -2, -1, -2)
/*  743 */                     .addGap(820, 820, 820))
/*  744 */                   .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
/*  745 */                     .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  746 */                       .addGroup(GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
/*  747 */                         .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  748 */                           .addGroup(jPanel6Layout.createSequentialGroup()
/*  749 */                             .addComponent(this.jButton9, -2, 86, -2)
/*  750 */                             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  751 */                             .addComponent(this.jButton8, -2, 90, -2)
/*  752 */                             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  753 */                             .addComponent(this.jButton7, -2, 82, -2))
/*  754 */                           .addComponent(this.jPanel30, -2, -1, -2))
/*  755 */                         .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  756 */                         .addComponent(this.jPanel25, -1, -1, 32767))
/*  757 */                       .addGroup(GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
/*  758 */                         .addComponent(this.jPanel26, -2, -1, -2)
/*  759 */                         .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  760 */                         .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  761 */                           .addComponent(this.jPanel33, -2, -1, -2)
/*  762 */                           .addGroup(jPanel6Layout.createSequentialGroup()
/*  763 */                             .addComponent(this.jLabel24, -2, 53, -2)
/*  764 */                             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  765 */                             .addComponent(this.jTextField9)))
/*  766 */                         .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  767 */                           .addGroup(jPanel6Layout.createSequentialGroup()
/*  768 */                             .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  769 */                             .addComponent(this.jPanel34, -1, -1, 32767))
/*  770 */                           .addGroup(jPanel6Layout.createSequentialGroup()
/*  771 */                             .addGap(106, 106, 106)
/*  772 */                             .addComponent(this.jButton1, -2, 124, -2))))
/*  773 */                       .addGroup(GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
/*  774 */                         .addComponent(this.jPanel22, -2, -1, -2)
/*  775 */                         .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  776 */                         .addComponent(this.jPanel23, -2, -1, -2)))
/*  777 */                     .addGap(1190, 1190, 1190)))
/*  778 */                 .addGap(0, 0, 0))
/*  779 */               .addGroup(jPanel6Layout.createSequentialGroup()
/*  780 */                 .addComponent(this.jLabel19, -2, 53, -2)
/*  781 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  782 */                 .addComponent(this.jComboBox1, -2, 162, -2)
/*  783 */                 .addContainerGap())))));
/*      */     
/*  785 */     jPanel6Layout.setVerticalGroup(jPanel6Layout
/*  786 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  787 */         .addGroup(jPanel6Layout.createSequentialGroup()
/*  788 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  789 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  790 */               .addComponent(this.jLabel22, -2, 65, -2)
/*  791 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  792 */               .addComponent(this.jLabel11)
/*  793 */               .addGap(18, 18, 18)
/*  794 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  795 */                 .addComponent(this.jLabel13, -2, 64, -2)
/*  796 */                 .addComponent(this.jLabel14, -2, 58, -2)
/*  797 */                 .addComponent(this.jLabel17, -2, 56, -2)))
/*  798 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  799 */               .addGap(11, 11, 11)
/*  800 */               .addComponent(this.jLabel64, -2, 157, -2))
/*  801 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  802 */               .addContainerGap()
/*  803 */               .addComponent(this.jPanel2, -2, -1, -2)
/*  804 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  805 */               .addComponent(this.jPanel21, -2, -1, -2)
/*  806 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  807 */               .addComponent(this.jPanel35, -2, -1, -2))
/*  808 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  809 */               .addGap(226, 226, 226)
/*  810 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  811 */                 .addComponent(this.jPanel23, -1, -1, 32767)
/*  812 */                 .addComponent(this.jPanel22, -2, 100, -2))))
/*  813 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  814 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  815 */             .addComponent(this.jPanel34, -1, -1, 32767)
/*  816 */             .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  817 */               .addComponent(this.jPanel33, -1, -1, 32767)
/*  818 */               .addComponent(this.jPanel26, -1, -1, 32767)))
/*  819 */           .addGap(12, 12, 12)
/*  820 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  821 */             .addComponent(this.jLabel19)
/*  822 */             .addComponent(this.jComboBox1, -2, -1, -2)
/*  823 */             .addComponent(this.jLabel24)
/*  824 */             .addComponent(this.jButton1)
/*  825 */             .addComponent(this.jTextField9, -2, -1, -2))
/*  826 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  827 */           .addComponent(this.jScrollPane1, -2, 168, -2)
/*  828 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  829 */           .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  830 */             .addGroup(jPanel6Layout.createSequentialGroup()
/*  831 */               .addComponent(this.jPanel30, -2, -1, -2)
/*  832 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  833 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  834 */                 .addComponent(this.jButton7)
/*  835 */                 .addComponent(this.jButton8)
/*  836 */                 .addComponent(this.jButton9))
/*  837 */               .addGap(294, 294, 294)
/*  838 */               .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  839 */                 .addGroup(jPanel6Layout.createSequentialGroup()
/*  840 */                   .addGap(42, 42, 42)
/*  841 */                   .addComponent(this.jLabel61))
/*  842 */                 .addComponent(this.jPanel32, -1, -1, 32767)))
/*  843 */             .addComponent(this.jPanel25, -2, -1, -2))
/*  844 */           .addContainerGap()));
/*      */ 
/*      */     
/*  847 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/*  848 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/*  849 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/*  850 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  851 */         .addComponent(this.jPanel6, -2, 986, -2));
/*      */     
/*  853 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/*  854 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  855 */         .addComponent(this.jPanel6, -2, 736, -2));
/*      */ 
/*      */     
/*  858 */     this.jDialog2.setTitle("Agregar Conceptos");
/*  859 */     this.jDialog2.setModal(true);
/*      */     
/*  861 */     this.jPanel8.setBackground(new Color(146, 193, 134));
/*      */     
/*  863 */     this.jLabel62.setFont(new Font("Tahoma", 1, 18));
/*  864 */     this.jLabel62.setForeground(new Color(0, 102, 102));
/*  865 */     this.jLabel62.setHorizontalAlignment(0);
/*  866 */     this.jLabel62.setText("PEDIDOS");
/*      */     
/*  868 */     this.jLabel63.setFont(new Font("Tahoma", 3, 11));
/*  869 */     this.jLabel63.setForeground(new Color(15, 87, 51));
/*  870 */     this.jLabel63.setHorizontalAlignment(0);
/*  871 */     this.jLabel63.setText("Cantidad");
/*      */     
/*  873 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  875 */             weatherford.this.jTextField6FocusLost(evt);
/*      */           }
/*      */         });
/*      */     
/*  879 */     this.jButton12.setMnemonic('C');
/*  880 */     this.jButton12.setText("Cerrar");
/*  881 */     this.jButton12.setToolTipText("Cerrar (Alt+C)");
/*  882 */     this.jButton12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  884 */             weatherford.this.jButton12ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  888 */     this.jButton13.setMnemonic('G');
/*  889 */     this.jButton13.setText("Guardar");
/*  890 */     this.jButton13.setToolTipText("Guardar Pedido(Alt+P)");
/*  891 */     this.jButton13.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  893 */             weatherford.this.jButton13ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/*  897 */     this.jLabel65.setFont(new Font("Tahoma", 3, 11));
/*  898 */     this.jLabel65.setForeground(new Color(15, 87, 51));
/*  899 */     this.jLabel65.setHorizontalAlignment(0);
/*  900 */     this.jLabel65.setText("Descripción");
/*      */     
/*  902 */     this.jLabel66.setFont(new Font("Tahoma", 3, 11));
/*  903 */     this.jLabel66.setForeground(new Color(15, 87, 51));
/*  904 */     this.jLabel66.setHorizontalAlignment(0);
/*  905 */     this.jLabel66.setText("Precio Unitario");
/*      */     
/*  907 */     this.jTextField8.addFocusListener(new FocusAdapter() {
/*      */           public void focusLost(FocusEvent evt) {
/*  909 */             weatherford.this.jTextField8FocusLost(evt);
/*      */           }
/*      */         });
/*  912 */     this.jTextField8.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  914 */             weatherford.this.jTextField8KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  918 */     this.jLabel67.setFont(new Font("Tahoma", 3, 11));
/*  919 */     this.jLabel67.setForeground(new Color(15, 87, 51));
/*  920 */     this.jLabel67.setHorizontalAlignment(0);
/*  921 */     this.jLabel67.setText("Importe");
/*      */     
/*  923 */     this.jTextField17.setEditable(false);
/*  924 */     this.jTextField17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/*  926 */             weatherford.this.jTextField17ActionPerformed(evt);
/*      */           }
/*      */         });
/*  929 */     this.jTextField17.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/*  931 */             weatherford.this.jTextField17KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/*  935 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  936 */     this.jPanel8.setLayout(jPanel8Layout);
/*  937 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/*  938 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  939 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  940 */           .addContainerGap()
/*  941 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  942 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  943 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  944 */                 .addComponent(this.jLabel63, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  945 */                 .addComponent(this.jTextField6, GroupLayout.Alignment.LEADING, -1, 113, 32767))
/*  946 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  947 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  948 */                 .addComponent(this.jLabel65, -1, -1, 32767)
/*  949 */                 .addComponent(this.jTextField7, -1, 301, 32767)
/*  950 */                 .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/*  951 */                   .addComponent(this.jButton13, -2, 98, -2)
/*  952 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  953 */                   .addComponent(this.jButton12, -2, 93, -2)))
/*  954 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  955 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/*  956 */                 .addComponent(this.jLabel66, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/*  957 */                 .addComponent(this.jTextField8, GroupLayout.Alignment.LEADING, -2, 113, -2))
/*  958 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  959 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/*  960 */                 .addComponent(this.jTextField17, -1, 144, 32767)
/*  961 */                 .addComponent(this.jLabel67, -1, -1, 32767))
/*  962 */               .addContainerGap())
/*  963 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/*  964 */               .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  965 */                 .addComponent(this.jLabel62, GroupLayout.Alignment.LEADING, -1, 689, 32767)
/*  966 */                 .addComponent(this.jSeparator3, -1, 689, 32767))
/*  967 */               .addContainerGap()))));
/*      */     
/*  969 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/*  970 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  971 */         .addGroup(jPanel8Layout.createSequentialGroup()
/*  972 */           .addComponent(this.jLabel62)
/*  973 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  974 */           .addComponent(this.jSeparator3, -2, 10, -2)
/*  975 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  976 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/*  977 */             .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  978 */               .addGroup(jPanel8Layout.createSequentialGroup()
/*  979 */                 .addComponent(this.jLabel63)
/*  980 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  981 */                 .addComponent(this.jTextField6, -2, -1, -2))
/*  982 */               .addGroup(jPanel8Layout.createSequentialGroup()
/*  983 */                 .addComponent(this.jLabel65)
/*  984 */                 .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  985 */                 .addComponent(this.jTextField7, -2, -1, -2)))
/*  986 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  987 */               .addComponent(this.jLabel66)
/*  988 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  989 */               .addComponent(this.jTextField8, -2, -1, -2))
/*  990 */             .addGroup(jPanel8Layout.createSequentialGroup()
/*  991 */               .addComponent(this.jLabel67)
/*  992 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  993 */               .addComponent(this.jTextField17, -2, -1, -2)))
/*  994 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/*  995 */           .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/*  996 */             .addComponent(this.jButton13)
/*  997 */             .addComponent(this.jButton12))
/*  998 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1001 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1002 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1003 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1004 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1005 */         .addComponent(this.jPanel8, -2, -1, -2));
/*      */     
/* 1007 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1008 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1009 */         .addComponent(this.jPanel8, -2, -1, -2));
/*      */ 
/*      */     
/* 1012 */     this.jDialog3.setTitle("Conceptos Agregados");
/* 1013 */     this.jDialog3.setAlwaysOnTop(true);
/*      */     
/* 1015 */     this.jPanel9.setBackground(new Color(146, 193, 134));
/*      */     
/* 1017 */     this.jLabel68.setFont(new Font("Tahoma", 1, 18));
/* 1018 */     this.jLabel68.setForeground(new Color(0, 102, 102));
/* 1019 */     this.jLabel68.setHorizontalAlignment(0);
/* 1020 */     this.jLabel68.setText("PEDIDOS");
/*      */     
/* 1022 */     this.jTable2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "CANTIDAD", "DESCRIPCIÓN", "PRECIO UNITARIO", "IMPORTE" })
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1030 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1035 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1038 */     this.jTable2.setShowHorizontalLines(false);
/* 1039 */     this.jScrollPane2.setViewportView(this.jTable2);
/* 1040 */     this.jTable2.getColumnModel().getColumn(0).setMinWidth(100);
/* 1041 */     this.jTable2.getColumnModel().getColumn(0).setMaxWidth(100);
/* 1042 */     this.jTable2.getColumnModel().getColumn(2).setMinWidth(120);
/* 1043 */     this.jTable2.getColumnModel().getColumn(2).setMaxWidth(120);
/* 1044 */     this.jTable2.getColumnModel().getColumn(3).setMinWidth(120);
/* 1045 */     this.jTable2.getColumnModel().getColumn(3).setMaxWidth(120);
/*      */     
/* 1047 */     this.jButton2.setText("Ocultar");
/* 1048 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1050 */             weatherford.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1054 */     this.jLabel1.setFont(new Font("Tahoma", 1, 14));
/* 1055 */     this.jLabel1.setForeground(new Color(0, 0, 204));
/* 1056 */     this.jLabel1.setText("Factura: ");
/*      */     
/* 1058 */     this.jLabel2.setFont(new Font("Tahoma", 1, 16));
/* 1059 */     this.jLabel2.setForeground(Color.red);
/* 1060 */     this.jLabel2.setText("jLabel2");
/*      */     
/* 1062 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 1063 */     this.jPanel9.setLayout(jPanel9Layout);
/* 1064 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 1065 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1066 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 1067 */           .addContainerGap()
/* 1068 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1069 */             .addComponent(this.jScrollPane2, -1, 699, 32767)
/* 1070 */             .addComponent(this.jLabel68, -1, 699, 32767)
/* 1071 */             .addComponent(this.jSeparator4, GroupLayout.Alignment.TRAILING, -1, 699, 32767)
/* 1072 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/* 1073 */               .addComponent(this.jLabel1, -2, 70, -2)
/* 1074 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1075 */               .addComponent(this.jLabel2, -2, 156, -2)
/* 1076 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 342, 32767)
/* 1077 */               .addComponent(this.jButton2, -2, 125, -2)))
/* 1078 */           .addContainerGap()));
/*      */     
/* 1080 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 1081 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1082 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 1083 */           .addComponent(this.jLabel68)
/* 1084 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1085 */           .addComponent(this.jSeparator4, -2, 10, -2)
/* 1086 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1087 */           .addComponent(this.jScrollPane2, -2, 129, -2)
/* 1088 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1089 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1090 */             .addComponent(this.jButton2)
/* 1091 */             .addComponent(this.jLabel1)
/* 1092 */             .addComponent(this.jLabel2))
/* 1093 */           .addContainerGap(-1, 32767)));
/*      */ 
/*      */     
/* 1096 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1097 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1098 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1099 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1100 */         .addComponent(this.jPanel9, -1, -1, 32767));
/*      */     
/* 1102 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1103 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1104 */         .addComponent(this.jPanel9, -2, -1, -2));
/*      */ 
/*      */     
/* 1107 */     this.jPanel1.setBackground(new Color(146, 193, 134));
/* 1108 */     this.jPanel1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
/*      */     
/* 1110 */     this.jLabel54.setFont(new Font("Times New Roman", 1, 24));
/* 1111 */     this.jLabel54.setForeground(new Color(10, 126, 68));
/* 1112 */     this.jLabel54.setHorizontalAlignment(0);
/* 1113 */     this.jLabel54.setText("FACTURACIÓN - WEATHERFORD");
/*      */     
/* 1115 */     this.jPanel5.setBackground(new Color(146, 193, 134));
/* 1116 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder(null, " Resultado de la Búsqueda", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1118 */     this.jLabel48.setFont(new Font("Tahoma", 1, 11));
/* 1119 */     this.jLabel48.setForeground(Color.red);
/* 1120 */     this.jLabel48.setHorizontalAlignment(2);
/* 1121 */     this.jLabel48.setText("t");
/* 1122 */     this.jLabel48.setBorder(new SoftBevelBorder(1));
/*      */     
/* 1124 */     this.jTable3.setFont(new Font("Tahoma", 0, 10));
/* 1125 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[] { "Factura", "Fecha", "Cliente", "Equipo", "Pozo", "Total", "Letra" }));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1133 */     this.jTable3.setShowVerticalLines(false);
/* 1134 */     this.jTable3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1136 */             weatherford.this.jTable3MouseClicked(evt);
/*      */           }
/*      */         });
/* 1139 */     this.jScrollPane3.setViewportView(this.jTable3);
/* 1140 */     this.jTable3.getColumnModel().getColumn(0).setMinWidth(100);
/* 1141 */     this.jTable3.getColumnModel().getColumn(0).setMaxWidth(100);
/* 1142 */     this.jTable3.getColumnModel().getColumn(1).setMinWidth(120);
/* 1143 */     this.jTable3.getColumnModel().getColumn(1).setMaxWidth(120);
/* 1144 */     this.jTable3.getColumnModel().getColumn(3).setMinWidth(140);
/* 1145 */     this.jTable3.getColumnModel().getColumn(3).setMaxWidth(140);
/* 1146 */     this.jTable3.getColumnModel().getColumn(4).setMinWidth(140);
/* 1147 */     this.jTable3.getColumnModel().getColumn(4).setMaxWidth(140);
/* 1148 */     this.jTable3.getColumnModel().getColumn(5).setMinWidth(140);
/* 1149 */     this.jTable3.getColumnModel().getColumn(5).setMaxWidth(140);
/*      */     
/* 1151 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 1152 */     this.jPanel5.setLayout(jPanel5Layout);
/* 1153 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout
/* 1154 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1155 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1156 */           .addComponent(this.jLabel48, -2, 163, -2)
/* 1157 */           .addContainerGap(1011, 32767))
/* 1158 */         .addComponent(this.jScrollPane3, -1, 1174, 32767));
/*      */     
/* 1160 */     jPanel5Layout.setVerticalGroup(jPanel5Layout
/* 1161 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1162 */         .addGroup(jPanel5Layout.createSequentialGroup()
/* 1163 */           .addComponent(this.jLabel48)
/* 1164 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1165 */           .addComponent(this.jScrollPane3, -1, 242, 32767)));
/*      */ 
/*      */     
/* 1168 */     this.jPanel17.setBackground(new Color(146, 193, 134));
/* 1169 */     this.jPanel17.setBorder(BorderFactory.createTitledBorder(null, " Búsqueda de Facturas", 0, 0, new Font("Tahoma", 1, 11)));
/*      */     
/* 1171 */     this.jLabel46.setFont(new Font("Tahoma", 3, 12));
/* 1172 */     this.jLabel46.setForeground(new Color(15, 87, 51));
/* 1173 */     this.jLabel46.setHorizontalAlignment(0);
/* 1174 */     this.jLabel46.setText("Periodo");
/*      */     
/* 1176 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1177 */     this.jDateChooser4.setDateFormatString("dd/MM/yyyy");
/* 1178 */     this.jDateChooser4.setIcon(this.icon);
/* 1179 */     this.jDateChooser4.setMaxSelectableDate(this.fecha);
/* 1180 */     this.jDateChooser4.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 1182 */     this.jDateChooser5.setDate(this.fechaTermino);
/* 1183 */     this.jDateChooser5.setDateFormatString("dd/MM/yyyy");
/* 1184 */     this.jDateChooser5.setIcon(this.icon);
/* 1185 */     this.jDateChooser5.setMaxSelectableDate(this.fechaTermino);
/* 1186 */     this.jDateChooser5.setMinSelectableDate(this.fechaInicio);
/*      */     
/* 1188 */     this.jLabel47.setFont(new Font("Tahoma", 3, 12));
/* 1189 */     this.jLabel47.setForeground(new Color(15, 87, 51));
/* 1190 */     this.jLabel47.setHorizontalAlignment(0);
/* 1191 */     this.jLabel47.setText("-");
/*      */     
/* 1193 */     this.jLabel5.setFont(new Font("Tahoma", 2, 12));
/* 1194 */     this.jLabel5.setForeground(new Color(15, 87, 51));
/* 1195 */     this.jLabel5.setText("<html><u>Todos </u></html>");
/* 1196 */     this.jLabel5.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1198 */             weatherford.this.jLabel5MouseClicked(evt);
/*      */           }
/*      */           public void mouseEntered(MouseEvent evt) {
/* 1201 */             weatherford.this.jLabel5MouseEntered(evt);
/*      */           }
/*      */           public void mouseExited(MouseEvent evt) {
/* 1204 */             weatherford.this.jLabel5MouseExited(evt);
/*      */           }
/*      */         });
/*      */     
/* 1208 */     this.jButton3.setMnemonic('F');
/* 1209 */     this.jButton3.setText("Filtrar");
/* 1210 */     this.jButton3.setToolTipText("Filtrar (Alt +F)");
/* 1211 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1213 */             weatherford.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1217 */     this.jButton6.setMnemonic('G');
/* 1218 */     this.jButton6.setText("Guardar Reporte");
/* 1219 */     this.jButton6.setToolTipText("Guardar Reporte (Alt+G)");
/* 1220 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1222 */             weatherford.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1226 */     this.jButton4.setText("Ver Factura");
/* 1227 */     this.jButton4.setEnabled(false);
/* 1228 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1230 */             weatherford.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1234 */     this.jButton5.setText("Agregar Factura");
/* 1235 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1237 */             weatherford.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1241 */     this.jTextField10.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1243 */             weatherford.this.jTextField10KeyReleased(evt);
/*      */           }
/*      */         });
/*      */     
/* 1247 */     this.jLabel49.setFont(new Font("Tahoma", 3, 12));
/* 1248 */     this.jLabel49.setForeground(new Color(15, 87, 51));
/* 1249 */     this.jLabel49.setHorizontalAlignment(0);
/* 1250 */     this.jLabel49.setText("Buscar por Folio");
/*      */     
/* 1252 */     this.jButton10.setMnemonic('E');
/* 1253 */     this.jButton10.setText("Eliminar");
/* 1254 */     this.jButton10.setToolTipText("Eliminar (Alt+E)");
/* 1255 */     this.jButton10.setEnabled(false);
/* 1256 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1258 */             weatherford.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/*      */     
/* 1262 */     GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
/* 1263 */     this.jPanel17.setLayout(jPanel17Layout);
/* 1264 */     jPanel17Layout.setHorizontalGroup(jPanel17Layout
/* 1265 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1266 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 1267 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1268 */             .addComponent(this.jLabel46, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 1269 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
/* 1270 */               .addComponent((Component)this.jDateChooser4, -2, 108, -2)
/* 1271 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1272 */               .addComponent(this.jLabel47)
/* 1273 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1274 */               .addComponent((Component)this.jDateChooser5, -2, 108, -2)))
/* 1275 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1276 */           .addComponent(this.jButton3)
/* 1277 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1278 */           .addComponent(this.jLabel5)
/* 1279 */           .addGap(66, 66, 66)
/* 1280 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1281 */             .addComponent(this.jLabel49, -1, -1, 32767)
/* 1282 */             .addComponent(this.jTextField10, -1, 157, 32767))
/* 1283 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 109, 32767)
/* 1284 */           .addComponent(this.jButton5, -2, 131, -2)
/* 1285 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1286 */           .addComponent(this.jButton6, -2, 121, -2)
/* 1287 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1288 */           .addComponent(this.jButton4, -2, 112, -2)
/* 1289 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1290 */           .addComponent(this.jButton10, -2, 112, -2)
/* 1291 */           .addContainerGap()));
/*      */     
/* 1293 */     jPanel17Layout.setVerticalGroup(jPanel17Layout
/* 1294 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1295 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 1296 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1297 */             .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1298 */               .addComponent(this.jLabel47, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1299 */               .addComponent((Component)this.jDateChooser4, GroupLayout.Alignment.TRAILING, -2, -1, -2))
/* 1300 */             .addComponent((Component)this.jDateChooser5, -2, -1, -2))
/* 1301 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1302 */           .addComponent(this.jLabel46)
/* 1303 */           .addGap(23, 23, 23))
/* 1304 */         .addGroup(jPanel17Layout.createSequentialGroup()
/* 1305 */           .addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1306 */             .addComponent(this.jButton3)
/* 1307 */             .addComponent(this.jLabel5, -1, -1, 32767)
/* 1308 */             .addComponent(this.jButton5)
/* 1309 */             .addComponent(this.jButton6)
/* 1310 */             .addComponent(this.jButton4)
/* 1311 */             .addComponent(this.jTextField10, -2, -1, -2)
/* 1312 */             .addComponent(this.jButton10))
/* 1313 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1314 */           .addComponent(this.jLabel49)
/* 1315 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1318 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 1319 */     this.jPanel1.setLayout(jPanel1Layout);
/* 1320 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout
/* 1321 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1322 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1323 */           .addContainerGap()
/* 1324 */           .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1325 */             .addComponent(this.jLabel54, -2, 1145, -2)
/* 1326 */             .addComponent(this.jPanel5, -1, -1, 32767)
/* 1327 */             .addComponent(this.jPanel17, -1, -1, 32767))
/* 1328 */           .addContainerGap(-1, 32767)));
/*      */     
/* 1330 */     jPanel1Layout.setVerticalGroup(jPanel1Layout
/* 1331 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1332 */         .addGroup(jPanel1Layout.createSequentialGroup()
/* 1333 */           .addContainerGap()
/* 1334 */           .addComponent(this.jLabel54, -2, 37, -2)
/* 1335 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1336 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 1337 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1338 */           .addComponent(this.jPanel5, -1, -1, 32767)
/* 1339 */           .addContainerGap()));
/*      */ 
/*      */     
/* 1342 */     GroupLayout layout = new GroupLayout(this);
/* 1343 */     setLayout(layout);
/* 1344 */     layout.setHorizontalGroup(layout
/* 1345 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1346 */         .addGap(0, 1232, 32767)
/* 1347 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1348 */           .addGroup(layout.createSequentialGroup()
/* 1349 */             .addGap(0, 11, 32767)
/* 1350 */             .addComponent(this.jPanel1, -2, -1, -2)
/* 1351 */             .addGap(0, 11, 32767))));
/*      */     
/* 1353 */     layout.setVerticalGroup(layout
/* 1354 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1355 */         .addGap(0, 483, 32767)
/* 1356 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1357 */           .addGroup(layout.createSequentialGroup()
/* 1358 */             .addContainerGap()
/* 1359 */             .addComponent(this.jPanel1, -1, -1, 32767)
/* 1360 */             .addContainerGap())));
/*      */   }
/*      */ 
/*      */   
/*      */   private void jTable3MouseClicked(MouseEvent evt) {
/* 1365 */     this.jButton4.setEnabled(true);
/* 1366 */     this.jButton10.setEnabled(true);
/* 1367 */     String folio = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0));
/* 1368 */     this.encontrado = this.con.consultar("count(numero)", "conceptos", "where factura =" + folio);
/* 1369 */     int totreg = Integer.parseInt(this.con.Campo);
/* 1370 */     this.jLabel2.setText("V " + folio);
/* 1371 */     this.jTable2.setModel(new DefaultTableModel((Object[][])this.con
/* 1372 */           .buscarReg(4, totreg, "cantidad,concepto,precio_u,importe", "CONCEPTOS", "where factura = " + folio), (Object[])new String[] { "CANTIDAD", "DESCRIPCIÓN", "PRECIO UNITARIO", "IMPORTE" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 1377 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1381 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/*      */     
/* 1385 */     this.jTable2.getColumnModel().getColumn(0).setPreferredWidth(100);
/* 1386 */     this.jTable2.getColumnModel().getColumn(0).setMaxWidth(100);
/* 1387 */     this.jTable2.getColumnModel().getColumn(2).setPreferredWidth(120);
/* 1388 */     this.jTable2.getColumnModel().getColumn(2).setMaxWidth(120);
/*      */     
/* 1390 */     this.jTable2.getColumnModel().getColumn(3).setPreferredWidth(120);
/* 1391 */     this.jTable2.getColumnModel().getColumn(3).setMaxWidth(120);
/*      */     
/* 1393 */     this.jTable2.setSelectionMode(0);
/* 1394 */     this.jTable2.setAutoCreateRowSorter(true);
/* 1395 */     this.jTable2.getTableHeader().setReorderingAllowed(false);
/* 1396 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 1399 */     String[] datos = { "FACTURA", "FECHA", "CLIENTE", "PEDIDO", "CONDICIONES", "EQUIPO", "POZO", "SUB-TOTAL", "IVA", "RET-IVA", "TOTAL", "LETRA" };
/* 1400 */     this.esc = new EscribirReporte("FACTURAS WEATHERFORD", this.jTable3, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 1404 */     int indice = this.jTable3.getSelectedRow();
/* 1405 */     this.jLabel12.setText(String.valueOf(this.jTable3.getValueAt(indice, 1)));
/* 1406 */     this.jTextField2.setText(String.valueOf(this.jTable3.getValueAt(indice, 0)));
/* 1407 */     this.jTextField1.setText(String.valueOf(this.jTable3.getValueAt(indice, 3)));
/* 1408 */     this.jTextField4.setText(String.valueOf(this.jTable3.getValueAt(indice, 4)));
/* 1409 */     this.jComboBox1.setSelectedItem(String.valueOf(this.jTable3.getValueAt(indice, 5)));
/* 1410 */     this.jTextField9.setText(String.valueOf(this.jTable3.getValueAt(indice, 6)));
/* 1411 */     this.jTextField5.setText(String.valueOf(this.jTable3.getValueAt(indice, 11)));
/* 1412 */     this.jLabel50.setText(String.valueOf(this.jTable3.getValueAt(indice, 7)));
/* 1413 */     this.jLabel51.setText(String.valueOf(this.jTable3.getValueAt(indice, 8)));
/* 1414 */     this.jTextField11.setText(String.valueOf(this.jTable3.getValueAt(indice, 9)));
/* 1415 */     this.jLabel56.setText(String.valueOf(this.jTable3.getValueAt(indice, 10)));
/* 1416 */     this.jButton9.setEnabled(false);
/* 1417 */     this.jButton8.setEnabled(false);
/*      */     
/* 1419 */     String folio = String.valueOf(this.jTable3.getValueAt(this.jTable3.getSelectedRow(), 0));
/* 1420 */     this.encontrado = this.con.consultar("count(numero)", "conceptos", "where factura =" + folio);
/* 1421 */     int totreg = Integer.parseInt(this.con.Campo);
/* 1422 */     this.jLabel2.setText(folio);
/* 1423 */     this.jTable1.setModel(new DefaultTableModel((Object[][])this.con
/* 1424 */           .buscarReg(4, totreg, "cantidad,concepto,precio_u,importe", "CONCEPTOS", "where factura = " + folio), (Object[])new String[] { "CANTIDAD", "DESCRIPCIÓN", "PRECIO UNITARIO", "IMPORTE" })
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 1429 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1433 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1436 */     this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
/* 1437 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
/* 1438 */     this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);
/* 1439 */     this.jTable1.getColumnModel().getColumn(2).setMaxWidth(120);
/*      */     
/* 1441 */     this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(120);
/* 1442 */     this.jTable1.getColumnModel().getColumn(3).setMaxWidth(120);
/*      */     
/* 1444 */     this.jTable1.setSelectionMode(0);
/* 1445 */     this.jTable1.setAutoCreateRowSorter(true);
/* 1446 */     this.jTable1.getTableHeader().setReorderingAllowed(false);
/*      */     
/* 1448 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jLabel5MouseExited(MouseEvent evt) {
/* 1452 */     this.jLabel5.setForeground(new Color(15, 87, 51));
/*      */   }
/*      */   private void jLabel5MouseEntered(MouseEvent evt) {
/* 1455 */     this.jLabel5.setForeground(new Color(153, 255, 153));
/*      */   }
/*      */   
/*      */   private void jLabel5MouseClicked(MouseEvent evt) {
/* 1459 */     this.jDateChooser4.setDate(this.fechaInicio);
/* 1460 */     this.jDateChooser5.setDate(this.fechaTermino);
/* 1461 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 1465 */     consultar();
/*      */   }
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 1468 */     this.jButton9.setEnabled(true);
/* 1469 */     this.jButton8.setEnabled(true);
/* 1470 */     limpiarTabla();
/* 1471 */     this.jTextField2.setText("");
/* 1472 */     this.jTextField1.setText("");
/* 1473 */     this.jTextField4.setText("");
/* 1474 */     this.jTextField9.setText("");
/* 1475 */     this.jTextField5.setText("");
/* 1476 */     this.jComboBox1.setSelectedIndex(0);
/* 1477 */     this.jLabel50.setText("00.00");
/* 1478 */     this.jTextField11.setText("00.00");
/* 1479 */     this.jLabel51.setText("00.00");
/* 1480 */     this.jLabel56.setText("00.00");
/* 1481 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt) {
/* 1485 */     this.jDialog1.setVisible(false);
/* 1486 */     limpiarTabla();
/*      */   }
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 1490 */     limpiarTabla();
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 1494 */     if (this.jTextField2.getText().equals("")) {
/* 1495 */       this.jTextField2.setBackground(Color.red);
/* 1496 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas colocar el número de folio de la factura");
/*      */     }
/* 1498 */     else if (this.jComboBox1.getSelectedIndex() == 0) {
/* 1499 */       this.jComboBox1.setBackground(Color.red);
/* 1500 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas Seleccionar el equipo");
/*      */     }
/* 1502 */     else if (this.jTextField9.getText().equals("")) {
/* 1503 */       this.jTextField9.setBackground(Color.red);
/* 1504 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas colocar el pozo");
/*      */     }
/* 1506 */     else if (this.jTextField5.getText().equals("")) {
/* 1507 */       this.jTextField5.setBackground(Color.red);
/* 1508 */       JOptionPane.showMessageDialog(this.jDialog1, "Necesitas colocar la cantidad en letra");
/*      */     } else {
/*      */       
/* 1511 */       this.encontrado = this.con.consultar("factura", "facturas", "where factura = " + this.jTextField2.getText());
/* 1512 */       if (this.encontrado) {
/* 1513 */         JOptionPane.showMessageDialog(this.jDialog1, "El número de factura ya está registrado en la base de datos");
/*      */       } else {
/* 1515 */         int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas imprimir la guía", "Imprimir Guía", 0, 3, this.PREG);
/* 1516 */         if (res == 0) {
/* 1517 */           String folio = this.jTextField2.getText();
/* 1518 */           String pedido = this.jTextField1.getText().toUpperCase();
/* 1519 */           String condiciones = this.jTextField4.getText();
/* 1520 */           String equipo = String.valueOf(this.jComboBox1.getSelectedItem());
/* 1521 */           String pozo = this.jTextField9.getText().toUpperCase();
/* 1522 */           String letra = this.jTextField5.getText();
/* 1523 */           this.con.inserSinMsj("insert into facturas(factura,fecha,expedicion,cliente,pedido,condiciones,equipo,pozo,sub_total,iva,ret_iva,total,letra,tipo)values(" + folio + ",now(),'POZA RICA','WEATHERFORD','" + pedido + "','" + condiciones + "','" + equipo + "','" + pozo + "','" + this.jLabel50
/* 1524 */               .getText() + "','" + this.jLabel51.getText() + "','" + this.jTextField11.getText() + "','" + this.jLabel56.getText() + "','" + letra + "','WEATHERFORD')");
/* 1525 */           for (int i = 0; i < this.CONTADOR; i++) {
/* 1526 */             this.con.inserSinMsj("insert into conceptos(cantidad,concepto,precio_u,importe,factura) values('" + String.valueOf(this.jTable1.getValueAt(i, 0)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 1)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 2)) + "','" + String.valueOf(this.jTable1.getValueAt(i, 3)) + "'," + folio + ")");
/*      */           }
/* 1528 */           imprimirFactura imp = new imprimirFactura();
/* 1529 */           String[] Datos = { folio, this.jLabel12.getText(), "POZA RICA", pedido, "Poza Rica", condiciones, equipo, pozo, this.jLabel50.getText(), this.jLabel51.getText(), this.jTextField11.getText(), this.jLabel56.getText(), letra, "0" };
/* 1530 */           imp.recibeDatos(Datos, this.jTable1, this.CONTADOR);
/* 1531 */           limpiarTabla();
/* 1532 */           consultar();
/* 1533 */           this.jDialog1.setVisible(false);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton12ActionPerformed(ActionEvent evt) {
/* 1540 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jButton13ActionPerformed(ActionEvent evt) {
/* 1544 */     if (this.jTextField6.getText().equals("") && this.jTextField7.getText().equals("") && this.jTextField8.getText().equals("")) {
/* 1545 */       JOptionPane.showMessageDialog(this.jDialog2, "Debes completar toda la información que se pide", "Falta Información", 0, this.ERROR);
/*      */     } else {
/*      */       
/* 1548 */       int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas éste concepto", "Agregar Conceptos", 0, 3, this.PREG);
/* 1549 */       if (res == 0) {
/* 1550 */         NumberFormat nf1 = NumberFormat.getInstance(Locale.US);
/* 1551 */         nf1.setMaximumFractionDigits(2);
/* 1552 */         nf1.setMinimumFractionDigits(2);
/*      */         
/* 1554 */         double dob = Double.parseDouble(this.jTextField6.getText());
/* 1555 */         this.jTable1.setValueAt(nf1.format(dob), this.CONTADOR, 0);
/* 1556 */         this.jTable1.setValueAt(this.jTextField7.getText(), this.CONTADOR, 1);
/* 1557 */         dob = Double.parseDouble(this.jTextField8.getText());
/* 1558 */         this.jTable1.setValueAt(nf1.format(dob), this.CONTADOR, 2);
/* 1559 */         this.jTable1.setValueAt(this.jTextField17.getText().toUpperCase(), this.CONTADOR, 3);
/*      */         
/* 1561 */         this.jTextField6.setText("");
/* 1562 */         this.jTextField7.setText("");
/* 1563 */         this.jTextField8.setText("");
/* 1564 */         this.jTextField17.setText("");
/* 1565 */         sumarTotal();
/* 1566 */         this.CONTADOR++;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField8KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */ 
/*      */   
/*      */   private void jTextField17ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jTextField17KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 1584 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jTextField6FocusLost(FocusEvent evt) {
/* 1588 */     calcularImporte();
/*      */   }
/*      */   
/*      */   private void jTextField8FocusLost(FocusEvent evt) {
/* 1592 */     calcularImporte();
/*      */   }
/*      */   
/*      */   private void jTextField11KeyReleased(KeyEvent evt) {
/* 1596 */     sumarTotal();
/*      */   }
/*      */   
/*      */   private void jTextField11FocusLost(FocusEvent evt) {
/* 1600 */     sumarTotal();
/* 1601 */     NumberFormat nf1 = NumberFormat.getInstance(Locale.US);
/* 1602 */     nf1.setMaximumFractionDigits(2);
/* 1603 */     nf1.setMinimumFractionDigits(2);
/* 1604 */     double ret = Double.parseDouble(this.jTextField11.getText());
/* 1605 */     this.jTextField11.setText(nf1.format(ret));
/*      */   }
/*      */   
/*      */   private void jTextField11FocusGained(FocusEvent evt) {
/* 1609 */     if (this.jTextField11.getText() != null) {
/* 1610 */       String cant = this.jTextField11.getText();
/* 1611 */       String concat = "";
/* 1612 */       for (int j = 0; j < cant.length(); j++) {
/* 1613 */         if (cant.charAt(j) != ',') {
/* 1614 */           concat = concat + concat;
/*      */         }
/*      */       } 
/* 1617 */       this.jTextField11.setText(concat);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 1622 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jTextField10KeyReleased(KeyEvent evt) {
/* 1626 */     consultar();
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 1630 */     int indice = this.jTable3.getSelectedRow();
/* 1631 */     String factura = String.valueOf(this.jTable3.getValueAt(indice, 0));
/* 1632 */     int res = JOptionPane.showConfirmDialog(this.jDialog2, "¿Estás seguro que deseas eliminar la factura que seleccionaste?", "Eliminar Factura", 0, 3, this.PREG);
/* 1633 */     if (res == 0) {
/* 1634 */       this.con.eliminar("conceptos", "where factura = " + factura);
/* 1635 */       this.con.eliminar2("facturas", "where factura = " + factura);
/* 1636 */       consultar();
/*      */     } 
/*      */   }
/*      */   public void consultar() {
/* 1640 */     this.jButton4.setEnabled(false);
/* 1641 */     this.jButton10.setEnabled(false);
/* 1642 */     boolean correcto = true;
/* 1643 */     if (this.jDateChooser4.getDate() == null) {
/* 1644 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de inicio no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'AAAA-MM-DD'</font><hr>¿Deseas insertar la fecha actual en el campo?</html>", "FECHA DE INICIO VACÍA", 0, 3, this.PREG);
/* 1645 */       if (res == 0) {
/* 1646 */         this.jDateChooser4.setDate(this.fechaActual);
/* 1647 */         correcto = true;
/*      */       } else {
/*      */         
/* 1650 */         correcto = false;
/*      */       }
/*      */     
/* 1653 */     } else if (this.jDateChooser5.getDate() == null) {
/* 1654 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de término no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'AAAA-MM-DD'</font><hr>¿Deseas insertar la fecha de ininio?</html>", "FECHA DE TÉRMINO VACÍA", 0, 3, this.PREG);
/* 1655 */       if (res == 0) {
/* 1656 */         Calendar ca = Calendar.getInstance();
/* 1657 */         Calendar fecha = Calendar.getInstance();
/* 1658 */         int aa = fecha.get(1);
/* 1659 */         int mm = fecha.get(2);
/* 1660 */         int dd = fecha.get(5);
/* 1661 */         int diasTotal = diasDelMes(mm, aa);
/* 1662 */         if (diasTotal == dd) {
/* 1663 */           dd = 1;
/* 1664 */           if (mm == 11) {
/* 1665 */             aa++;
/* 1666 */             mm = 0;
/*      */           } else {
/*      */             
/* 1669 */             mm++;
/*      */           } 
/*      */         } else {
/* 1672 */           dd++;
/*      */         } 
/* 1674 */         mm++;
/* 1675 */         String año = "" + aa;
/* 1676 */         String mes = "" + mm;
/* 1677 */         String dia = "" + dd;
/* 1678 */         SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 1679 */         String strFecha = año + "-" + año + "-" + mes;
/*      */         try {
/* 1681 */           this.fechaTermino = formatoDelTexto.parse(strFecha);
/*      */         }
/* 1683 */         catch (ParseException ex) {
/* 1684 */           ex.printStackTrace();
/*      */         } 
/* 1686 */         this.jDateChooser5.setDate(this.fechaTermino);
/* 1687 */         correcto = true;
/*      */       } else {
/*      */         
/* 1690 */         correcto = false;
/*      */       }
/*      */     
/* 1693 */     } else if (correcto) {
/* 1694 */       Date fecha1 = this.jDateChooser4.getDate();
/* 1695 */       Date fecha2 = this.jDateChooser5.getDate();
/*      */       
/* 1697 */       SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 1698 */       String cadenaFecha = "";
/* 1699 */       cadenaFecha = formato.format(fecha1);
/* 1700 */       String AÑO = cadenaFecha.substring(0, 4);
/* 1701 */       String MES = cadenaFecha.substring(4, 6);
/* 1702 */       String DIA = cadenaFecha.substring(6, 8);
/* 1703 */       String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */       
/* 1705 */       cadenaFecha = formato.format(fecha2);
/* 1706 */       AÑO = cadenaFecha.substring(0, 4);
/* 1707 */       MES = cadenaFecha.substring(4, 6);
/* 1708 */       DIA = cadenaFecha.substring(6, 8);
/* 1709 */       String fechaCompleta2 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */       
/* 1711 */       String folio = this.jTextField10.getText();
/* 1712 */       this.encontrado = this.con.consultar("count(factura)", "facturas", "where factura like '%" + folio + "%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " and tipo = 'weatherford' order by factura desc");
/* 1713 */       int totreg = Integer.parseInt(this.con.Campo);
/* 1714 */       String tot = this.con.Campo;
/* 1715 */       this.jLabel48.setText("<HTML><FONT COLOR=blue>TOTAL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>" + totreg + "</HTML>");
/* 1716 */       this.jTable3.setModel(new DefaultTableModel((Object[][])this.con
/* 1717 */             .buscarReg(12, totreg, "factura,fecha,cliente,pedido,condiciones,equipo,pozo,sub_total,iva,ret_iva,total,letra", "facturas", "where factura like '%" + folio + "%' and fecha between " + fechaCompleta1 + " and " + fechaCompleta2 + " and tipo = 'weatherford' order by factura desc"), (Object[])new String[] { "Factura", "Fecha", "Cliente", "Pedido", "Condiciones", "Equipo", "Pozo", "Sub-Total", "Iva", "Ret-Iva", "Total", "Letra" })
/*      */           {
/*      */ 
/*      */ 
/*      */             
/* 1722 */             boolean[] canEdit = new boolean[] { 
/*      */                 false, false, false, false, false, false, false, false, false, false, 
/*      */                 false, false, false };
/*      */             public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1726 */               return this.canEdit[columnIndex];
/*      */             }
/*      */           });
/* 1729 */       this.jTable3.setShowVerticalLines(false);
/* 1730 */       this.jScrollPane3.setViewportView(this.jTable3);
/*      */       
/* 1732 */       this.jTable3.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 1733 */       this.jTable3.getColumnModel().getColumn(0).setMaxWidth(50);
/* 1734 */       this.jTable3.getColumnModel().getColumn(1).setPreferredWidth(60);
/* 1735 */       this.jTable3.getColumnModel().getColumn(1).setMaxWidth(60);
/* 1736 */       this.jTable3.getColumnModel().getColumn(2).setPreferredWidth(90);
/* 1737 */       this.jTable3.getColumnModel().getColumn(2).setMaxWidth(90);
/*      */       
/* 1739 */       this.jTable3.getColumnModel().getColumn(3).setPreferredWidth(80);
/* 1740 */       this.jTable3.getColumnModel().getColumn(3).setMaxWidth(80);
/*      */       
/* 1742 */       this.jTable3.getColumnModel().getColumn(5).setPreferredWidth(80);
/* 1743 */       this.jTable3.getColumnModel().getColumn(5).setMaxWidth(80);
/* 1744 */       this.jTable3.getColumnModel().getColumn(6).setPreferredWidth(110);
/* 1745 */       this.jTable3.getColumnModel().getColumn(6).setMaxWidth(110);
/* 1746 */       this.jTable3.getColumnModel().getColumn(7).setPreferredWidth(90);
/* 1747 */       this.jTable3.getColumnModel().getColumn(7).setMaxWidth(90);
/* 1748 */       this.jTable3.getColumnModel().getColumn(8).setPreferredWidth(80);
/* 1749 */       this.jTable3.getColumnModel().getColumn(8).setMaxWidth(80);
/* 1750 */       this.jTable3.getColumnModel().getColumn(9).setPreferredWidth(80);
/* 1751 */       this.jTable3.getColumnModel().getColumn(9).setMaxWidth(80);
/* 1752 */       this.jTable3.getColumnModel().getColumn(10).setPreferredWidth(90);
/* 1753 */       this.jTable3.getColumnModel().getColumn(10).setMaxWidth(90);
/*      */       
/* 1755 */       this.jTable3.setSelectionMode(0);
/* 1756 */       this.jTable3.setAutoCreateRowSorter(true);
/* 1757 */       this.jTable3.getTableHeader().setReorderingAllowed(false);
/*      */     } 
/*      */   }
/*      */   public void weatherford(String usu) {
/* 1761 */     this.USUARIO = usu;
/* 1762 */     this.panel.setViewportView(this);
/* 1763 */     this.jDateChooser4.setDate(this.fechaActual);
/* 1764 */     this.jDateChooser4.setMaxSelectableDate(this.fechaActual);
/* 1765 */     consultar();
/*      */   }
/*      */   public void colorear() {
/* 1768 */     this.jTextField1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1770 */             weatherford.this.jTextGanado(weatherford.this.jTextField1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1773 */             weatherford.this.jTextPerdido(weatherford.this.jTextField1, evt);
/*      */           }
/*      */         });
/* 1776 */     this.jTextField2.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1778 */             weatherford.this.jTextGanado(weatherford.this.jTextField2, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1781 */             weatherford.this.jTextPerdido(weatherford.this.jTextField2, evt);
/*      */           }
/*      */         });
/* 1784 */     this.jTextField3.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1786 */             weatherford.this.jTextGanado(weatherford.this.jTextField3, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1789 */             weatherford.this.jTextPerdido(weatherford.this.jTextField3, evt);
/*      */           }
/*      */         });
/* 1792 */     this.jTextField4.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1794 */             weatherford.this.jTextGanado(weatherford.this.jTextField4, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1797 */             weatherford.this.jTextPerdido(weatherford.this.jTextField4, evt);
/*      */           }
/*      */         });
/* 1800 */     this.jTextField5.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1802 */             weatherford.this.jTextGanado(weatherford.this.jTextField5, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1805 */             weatherford.this.jTextPerdido(weatherford.this.jTextField5, evt);
/*      */           }
/*      */         });
/* 1808 */     this.jTextField6.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1810 */             weatherford.this.jTextGanado(weatherford.this.jTextField6, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1813 */             weatherford.this.jTextPerdido(weatherford.this.jTextField6, evt);
/*      */           }
/*      */         });
/* 1816 */     this.jTextField7.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1818 */             weatherford.this.jTextGanado(weatherford.this.jTextField7, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1821 */             weatherford.this.jTextPerdido(weatherford.this.jTextField7, evt);
/*      */           }
/*      */         });
/* 1824 */     this.jTextField8.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1826 */             weatherford.this.jTextGanado(weatherford.this.jTextField8, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1829 */             weatherford.this.jTextPerdido(weatherford.this.jTextField8, evt);
/*      */           }
/*      */         });
/* 1832 */     this.jTextField9.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1834 */             weatherford.this.jTextGanado(weatherford.this.jTextField9, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1837 */             weatherford.this.jTextPerdido(weatherford.this.jTextField9, evt);
/*      */           }
/*      */         });
/* 1840 */     this.jTextField10.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1842 */             weatherford.this.jTextGanado(weatherford.this.jTextField10, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1845 */             weatherford.this.jTextPerdido(weatherford.this.jTextField10, evt);
/*      */           }
/*      */         });
/* 1848 */     this.jComboBox1.addFocusListener(new FocusAdapter() {
/*      */           public void focusGained(FocusEvent evt) {
/* 1850 */             weatherford.this.jTextGanado(weatherford.this.jComboBox1, evt);
/*      */           }
/*      */           public void focusLost(FocusEvent evt) {
/* 1853 */             weatherford.this.jTextPerdido(weatherford.this.jComboBox1, evt);
/*      */           }
/*      */         });
/*      */   }
/*      */   public void jTextGanado(JComponent campo, FocusEvent evt) {
/* 1858 */     campo.setBackground(new Color(153, 255, 153));
/*      */   }
/*      */   public void jTextPerdido(JComponent campo, FocusEvent evt) {
/* 1861 */     campo.setBackground(Color.white);
/*      */   }
/*      */   public void llenarCombo() {
/* 1864 */     this.con.consultar("count(equipo)", "equipos", "where num_equipo<>0");
/* 1865 */     String[] plataformas = this.con.regresaCol("equipo", "equipos", "where num_equipo<>0 order by equipo", Integer.parseInt(this.con.Campo));
/*      */     
/* 1867 */     this.jComboBox1.removeAllItems();
/* 1868 */     this.jComboBox1.addItem("Selecciona uno...");
/* 1869 */     for (int i = 0; i < plataformas.length; i++)
/* 1870 */       this.jComboBox1.addItem(plataformas[i]); 
/*      */   }
/*      */   
/*      */   public int diasDelMes(int mes, int año) {
/* 1874 */     switch (mes) {
/*      */       case 0:
/*      */       case 2:
/*      */       case 4:
/*      */       case 6:
/*      */       case 7:
/*      */       case 9:
/*      */       case 11:
/* 1882 */         return 31;
/*      */       
/*      */       case 3:
/*      */       case 5:
/*      */       case 8:
/*      */       case 10:
/* 1888 */         return 30;
/*      */       
/*      */       case 1:
/* 1891 */         if ((año % 100 == 0 && año % 400 == 0) || (año % 100 != 0 && año % 4 == 0))
/*      */         {
/* 1893 */           return 29;
/*      */         }
/* 1895 */         return 28;
/*      */     } 
/*      */     
/* 1898 */     return 0;
/*      */   }
/*      */   
/*      */   public void sacarFecha() {
/* 1902 */     Calendar ahoraCal = Calendar.getInstance();
/* 1903 */     ahoraCal.setTime(this.fecha);
/* 1904 */     String mesesito = "";
/* 1905 */     String hoy = "";
/* 1906 */     mesesito = "" + ahoraCal.get(2) + 1;
/* 1907 */     hoy = "" + ahoraCal.get(5);
/* 1908 */     if (ahoraCal.get(2) + 1 < 10) {
/* 1909 */       mesesito = "0" + mesesito;
/*      */     }
/* 1911 */     if (ahoraCal.get(5) < 10) {
/* 1912 */       hoy = "0" + hoy;
/*      */     }
/* 1914 */     String letra = "";
/* 1915 */     if (mesesito.equals("01")) {
/* 1916 */       letra = "Enero";
/*      */     }
/* 1918 */     else if (mesesito.equals("02")) {
/* 1919 */       letra = "Febrero";
/*      */     }
/* 1921 */     else if (mesesito.equals("03")) {
/* 1922 */       letra = "Marzo";
/*      */     }
/* 1924 */     else if (mesesito.equals("04")) {
/* 1925 */       letra = "Abril";
/*      */     }
/* 1927 */     else if (mesesito.equals("05")) {
/* 1928 */       letra = "Mayo";
/*      */     }
/* 1930 */     else if (mesesito.equals("06")) {
/* 1931 */       letra = "Junio";
/*      */     }
/* 1933 */     else if (mesesito.equals("07")) {
/* 1934 */       letra = "Julio";
/*      */     }
/* 1936 */     else if (mesesito.equals("08")) {
/* 1937 */       letra = "Agosto";
/*      */     }
/* 1939 */     else if (mesesito.equals("09")) {
/* 1940 */       letra = "Septiembre";
/*      */     }
/* 1942 */     else if (mesesito.equals("10")) {
/* 1943 */       letra = "Octubre";
/*      */     }
/* 1945 */     else if (mesesito.equals("11")) {
/* 1946 */       letra = "Noviembre";
/*      */     }
/* 1948 */     else if (mesesito.equals("12")) {
/* 1949 */       letra = "Diciembre";
/*      */     } 
/* 1951 */     this.jLabel12.setText(hoy + " " + hoy + " " + letra);
/*      */   }
/*      */   public void calcularImporte() {
/* 1954 */     if (!this.jTextField6.getText().equals("") && !this.jTextField8.getText().equals("")) {
/*      */       try {
/* 1956 */         double cant = Double.parseDouble(this.jTextField6.getText());
/* 1957 */         double pre = Double.parseDouble(this.jTextField8.getText());
/* 1958 */         double im = cant * pre;
/* 1959 */         NumberFormat nf1 = NumberFormat.getInstance(Locale.US);
/* 1960 */         nf1.setMaximumFractionDigits(2);
/* 1961 */         nf1.setMinimumFractionDigits(2);
/* 1962 */         this.jTextField17.setText(nf1.format(im));
/*      */       }
/* 1964 */       catch (NumberFormatException n) {
/* 1965 */         JOptionPane.showMessageDialog(this.jDialog2, "Los campos de cantidad y precio deben contener sólo números");
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void sumarTotal() {
/* 1992 */     double subTotal = 0.0D;
/* 1993 */     double iva = 0.0D;
/* 1994 */     NumberFormat nf1 = NumberFormat.getInstance(Locale.US);
/* 1995 */     nf1.setMaximumFractionDigits(2);
/* 1996 */     nf1.setMinimumFractionDigits(2);
/* 1997 */     for (int i = 0; i < this.jTable1.getRowCount(); i++) {
/* 1998 */       if (this.jTable1.getValueAt(i, 3) != null) {
/* 1999 */         String cant = String.valueOf(this.jTable1.getValueAt(i, 3));
/* 2000 */         String concat = "";
/* 2001 */         for (int j = 0; j < cant.length(); j++) {
/* 2002 */           if (cant.charAt(j) != ',') {
/* 2003 */             concat = concat + concat;
/*      */           }
/*      */         } 
/* 2006 */         subTotal += Double.parseDouble(concat);
/*      */       } 
/*      */     } 
/* 2009 */     this.jLabel50.setText(nf1.format(subTotal));
/* 2010 */     iva = subTotal * 0.16D;
/* 2011 */     this.jLabel51.setText(nf1.format(iva));
/* 2012 */     if (this.jTextField11.getText().equals("")) {
/* 2013 */       this.jTextField11.setText("00.00");
/*      */     }
/* 2015 */     double ret = Double.parseDouble(this.jTextField11.getText());
/* 2016 */     double Tot = subTotal - ret + iva;
/* 2017 */     this.jLabel56.setText(nf1.format(Tot));
/*      */   }
/*      */   public void limpiarTabla() {
/* 2020 */     this.jTable1 = new JTable();
/* 2021 */     this.jTable1.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null }, , { null, null, null, null },  }, (Object[])new String[] { "CANTIDAD", "DESCRIPCIÓN", "PRECIO UNITARIO", "IMPORTE" })
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
/* 2036 */           boolean[] canEdit = new boolean[] { false, false, false, false };
/*      */ 
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2040 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2043 */     this.jTable1.setEditingRow(0);
/* 2044 */     this.jTable1.setSelectionMode(0);
/* 2045 */     this.jTable1.setShowHorizontalLines(false);
/* 2046 */     this.jScrollPane1.setViewportView(this.jTable1);
/* 2047 */     this.jTable1.getColumnModel().getColumn(0).setMinWidth(100);
/* 2048 */     this.jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
/* 2049 */     this.jTable1.getColumnModel().getColumn(2).setMinWidth(150);
/* 2050 */     this.jTable1.getColumnModel().getColumn(2).setMaxWidth(150);
/* 2051 */     this.jTable1.getColumnModel().getColumn(3).setMinWidth(150);
/* 2052 */     this.jTable1.getColumnModel().getColumn(3).setMaxWidth(150);
/* 2053 */     this.CONTADOR = 0;
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/weatherford.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */