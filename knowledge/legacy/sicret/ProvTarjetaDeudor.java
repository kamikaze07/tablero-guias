/*      */ package sicret;
/*      */ 
/*      */ import Fuentes.Fuentes;
/*      */ import com.placeholder.PlaceHolder;
/*      */ import com.toedter.calendar.JDateChooser;
/*      */ import java.awt.Color;
/*      */ import java.awt.Component;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Dialog;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Font;
/*      */ import java.awt.GridBagConstraints;
/*      */ import java.awt.GridBagLayout;
/*      */ import java.awt.GridLayout;
/*      */ import java.awt.Image;
/*      */ import java.awt.Insets;
/*      */ import java.awt.Point;
/*      */ import java.awt.Toolkit;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.KeyAdapter;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.net.URL;
/*      */ import java.text.NumberFormat;
/*      */ import java.text.ParseException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.time.Instant;
/*      */ import java.time.LocalDate;
/*      */ import java.time.LocalDateTime;
/*      */ import java.time.ZoneId;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.ButtonGroup;
/*      */ import javax.swing.DefaultComboBoxModel;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.Icon;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JDialog;
/*      */ import javax.swing.JFormattedTextField;
/*      */ import javax.swing.JFrame;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JRadioButton;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSeparator;
/*      */ import javax.swing.JSpinner;
/*      */ import javax.swing.JTabbedPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextArea;
/*      */ import javax.swing.JTextField;
/*      */ import javax.swing.LayoutStyle;
/*      */ import javax.swing.SpinnerListModel;
/*      */ import javax.swing.table.DefaultTableCellRenderer;
/*      */ import javax.swing.table.DefaultTableModel;
/*      */ import javax.swing.text.DefaultFormatterFactory;
/*      */ import javax.swing.text.NumberFormatter;
/*      */ import net.sf.jasperreports.engine.JRDataSource;
/*      */ import net.sf.jasperreports.engine.JRException;
/*      */ import net.sf.jasperreports.engine.JasperFillManager;
/*      */ import net.sf.jasperreports.engine.JasperPrint;
/*      */ import net.sf.jasperreports.engine.data.JRTableModelDataSource;
/*      */ import net.sf.jasperreports.view.JasperViewer;
/*      */ import principal.MaterialButton;
/*      */ import rojerusan.RSTableMetro;
/*      */ import utilerias.pintarComponentes;
/*      */ 
/*      */ public class ProvTarjetaDeudor
/*      */   extends JPanel
/*      */ {
/*      */   JScrollPane panel;
/*   86 */   Date fechaActual = new Date();
/*      */   
/*   88 */   Date fechaInicio = null;
/*      */   
/*   90 */   Date fecha = new Date();
/*      */   
/*   92 */   Toolkit tk = Toolkit.getDefaultToolkit();
/*      */   
/*   94 */   Dimension tama = new Dimension(this.tk.getScreenSize());
/*      */   
/*   96 */   Icon ELIMINAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/basura1.png")));
/*      */   
/*   98 */   Icon INFO = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Info.png")));
/*      */   
/*  100 */   Icon ERROR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Cancel.png")));
/*      */   
/*  102 */   Icon GUARDAR = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/guardar.png")));
/*      */   
/*  104 */   Icon PREG = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Help.png")));
/*      */   
/*  106 */   Icon ADVER = new ImageIcon(this.tk.getImage(getClass().getResource("/entrada/Imagenes/Warning.png")));
/*      */   
/*  108 */   URL iconURL = getClass().getResource("/entrada/Imagenes/Calendar1.png");
/*      */   
/*  110 */   Image iconoImprimir = this.tk.getImage(getClass().getResource("/entrada/Imagenes/botones/Print.png"));
/*      */   
/*  112 */   ImageIcon icon = new ImageIcon(this.iconURL);
/*      */   
/*  114 */   JFrame padre = null;
/*      */   
/*  116 */   JTabbedPane fichas = null;
/*      */   
/*      */   Map<String, String> CAMPOSGENERALES;
/*      */   
/*  120 */   MensajePop mensajeTry = null;
/*      */   
/*      */   String USUARIO;
/*      */   
/*  124 */   SColores lc = new SColores();
/*      */   
/*  126 */   Fuentes fuentes = new Fuentes();
/*      */   
/*  128 */   PlaceHolder placeHolder = null;
/*      */   
/*  130 */   Consultas2 con = new Consultas2();
/*      */   
/*  132 */   String[] SUCURSALES = null;
/*      */   
/*  134 */   String holderRazonSocial = "NOMBRE DEL PROVEEDOR";
/*      */   
/*  136 */   String holderChequeTrans = "CHEQUE O TRANSFERENCIA";
/*      */   
/*  138 */   String holderFactura = "FOLIO";
/*      */   
/*      */   JLabel EtiquetaEstado;
/*      */   
/*      */   boolean entraSucPrimera = false;
/*      */   
/*  144 */   Presionado presionado = null;
/*      */   
/*  146 */   Presionado2 presionado2 = null;
/*      */   
/*  148 */   Cursor micursor = null;
/*      */   
/*  150 */   CeldaRender1 celda1 = new CeldaRender1();
/*      */   
/*  152 */   CeldaRender2 celda2 = new CeldaRender2();
/*      */   
/*  154 */   CeldaRender3 celda3 = new CeldaRender3();
/*      */   
/*  156 */   CeldaRender4 celda4 = new CeldaRender4();
/*      */   
/*  158 */   CeldaRender5 celda5 = new CeldaRender5();
/*      */   
/*      */   boolean ACTIVARCONSULTA = false;
/*      */   
/*  162 */   String CLAVEPROV = "";
/*      */   
/*      */   EscribirReporte esc;
/*      */   
/*  166 */   pintarComponentes pintar = new pintarComponentes();
/*      */   
/*      */   boolean encontrado = false;
/*      */   
/*      */   Cheques chequeAsignado;
/*      */   
/*      */   Transferencias transferenciaAsignada;
/*      */   
/*      */   boolean entraCheque = false;
/*      */   
/*      */   private JTable TablaAux;
/*      */   
/*      */   private JTable TablaGral;
/*      */   
/*      */   private JTable TablaGral1;
/*      */   
/*      */   private ButtonGroup buttonGroup1;
/*      */   
/*      */   private ButtonGroup buttonGroup2;
/*      */   
/*      */   private ButtonGroup buttonGroup3;
/*      */   
/*      */   private JFormattedTextField cantidad;
/*      */   
/*      */   private JFormattedTextField importe1;
/*      */   
/*      */   private JFormattedTextField importe2;
/*      */   
/*      */   private JFormattedTextField importe3;
/*      */   
/*      */   private JButton jButton1;
/*      */   
/*      */   private JButton jButton10;
/*      */   
/*      */   private JButton jButton17;
/*      */   
/*      */   private JButton jButton2;
/*      */   
/*      */   private JButton jButton3;
/*      */   
/*      */   private JButton jButton35;
/*      */   
/*      */   private JButton jButton4;
/*      */   
/*      */   private JButton jButton5;
/*      */   
/*      */   private JButton jButton53;
/*      */   
/*      */   private JButton jButton6;
/*      */   
/*      */   private JButton jButton8;
/*      */   
/*      */   private JButton jButton9;
/*      */   
/*      */   private JComboBox jComboBox1;
/*      */   
/*      */   private JComboBox jComboBox12;
/*      */   
/*      */   private JComboBox jComboBox2;
/*      */   
/*      */   private JComboBox<String> jComboBox3;
/*      */   
/*      */   private JComboBox jComboBox4;
/*      */   
/*      */   private JComboBox jComboBox5;
/*      */   
/*      */   private JComboBox jComboBox6;
/*      */   
/*      */   private JComboBox jComboBox8;
/*      */   
/*      */   private JDateChooser jDateChooser1;
/*      */   
/*      */   private JDateChooser jDateChooser7;
/*      */   
/*      */   private JDateChooser jDateChooser8;
/*      */   
/*      */   private JDateChooser jDateChooser9;
/*      */   
/*      */   private JDialog jDialog1;
/*      */   
/*      */   private JDialog jDialog10;
/*      */   
/*      */   private JDialog jDialog11;
/*      */   
/*      */   private JDialog jDialog12;
/*      */   
/*      */   private JDialog jDialog13;
/*      */   
/*      */   private JDialog jDialog14;
/*      */   
/*      */   private JDialog jDialog2;
/*      */   
/*      */   private JDialog jDialog3;
/*      */   
/*      */   private JDialog jDialog4;
/*      */   
/*      */   private JDialog jDialog5;
/*      */   
/*      */   private JDialog jDialog6;
/*      */   
/*      */   private JDialog jDialog7;
/*      */   
/*      */   private JDialog jDialog8;
/*      */   
/*      */   private JDialog jDialog9;
/*      */   
/*      */   private JLabel jLabel1;
/*      */   
/*      */   private JLabel jLabel10;
/*      */   
/*      */   private JLabel jLabel11;
/*      */   
/*      */   private JLabel jLabel12;
/*      */   
/*      */   private JLabel jLabel128;
/*      */   
/*      */   private JLabel jLabel129;
/*      */   
/*      */   private JLabel jLabel13;
/*      */   
/*      */   private JLabel jLabel14;
/*      */   
/*      */   private JLabel jLabel15;
/*      */   
/*      */   private JLabel jLabel16;
/*      */   
/*      */   private JLabel jLabel17;
/*      */   
/*      */   private JLabel jLabel18;
/*      */   
/*      */   private JLabel jLabel19;
/*      */   
/*      */   private JLabel jLabel2;
/*      */   
/*      */   private JLabel jLabel20;
/*      */   
/*      */   private JLabel jLabel21;
/*      */   
/*      */   private JLabel jLabel22;
/*      */   
/*      */   private JLabel jLabel23;
/*      */   
/*      */   private JLabel jLabel24;
/*      */   
/*      */   private JLabel jLabel25;
/*      */   
/*      */   private JLabel jLabel3;
/*      */   
/*      */   private JLabel jLabel35;
/*      */   
/*      */   private JLabel jLabel4;
/*      */   
/*      */   private JLabel jLabel42;
/*      */   
/*      */   private JLabel jLabel43;
/*      */   
/*      */   private JLabel jLabel44;
/*      */   
/*      */   private JLabel jLabel45;
/*      */   
/*      */   private JLabel jLabel46;
/*      */   
/*      */   private JLabel jLabel47;
/*      */   
/*      */   private JLabel jLabel48;
/*      */   
/*      */   private JLabel jLabel49;
/*      */   
/*      */   private JLabel jLabel5;
/*      */   
/*      */   private JLabel jLabel50;
/*      */   
/*      */   private JLabel jLabel51;
/*      */   
/*      */   private JLabel jLabel52;
/*      */   
/*      */   private JLabel jLabel53;
/*      */   
/*      */   private JLabel jLabel54;
/*      */   
/*      */   private JLabel jLabel56;
/*      */   
/*      */   private JLabel jLabel57;
/*      */   
/*      */   private JLabel jLabel58;
/*      */   
/*      */   private JLabel jLabel59;
/*      */   
/*      */   private JLabel jLabel6;
/*      */   
/*      */   private JLabel jLabel60;
/*      */   
/*      */   private JLabel jLabel61;
/*      */   
/*      */   private JLabel jLabel62;
/*      */   
/*      */   private JLabel jLabel63;
/*      */   
/*      */   private JLabel jLabel64;
/*      */   
/*      */   private JLabel jLabel68;
/*      */   
/*      */   private JLabel jLabel69;
/*      */   
/*      */   private JLabel jLabel7;
/*      */   
/*      */   private JLabel jLabel72;
/*      */   
/*      */   private JLabel jLabel73;
/*      */   
/*      */   private JLabel jLabel74;
/*      */   
/*      */   private JLabel jLabel75;
/*      */   
/*      */   private JLabel jLabel76;
/*      */   
/*      */   private JLabel jLabel77;
/*      */   
/*      */   private JLabel jLabel8;
/*      */   
/*      */   private JLabel jLabel82;
/*      */   
/*      */   private JLabel jLabel83;
/*      */   
/*      */   private JLabel jLabel85;
/*      */   
/*      */   private JLabel jLabel9;
/*      */   
/*      */   private JLabel jLabel94;
/*      */   
/*      */   private JPanel jPanel1;
/*      */   
/*      */   private JPanel jPanel10;
/*      */   
/*      */   private JPanel jPanel103;
/*      */   
/*      */   private JPanel jPanel11;
/*      */   
/*      */   private JPanel jPanel12;
/*      */   
/*      */   private JPanel jPanel13;
/*      */   
/*      */   private JPanel jPanel136;
/*      */   
/*      */   private JPanel jPanel14;
/*      */   
/*      */   private JPanel jPanel15;
/*      */   
/*      */   private JPanel jPanel16;
/*      */   
/*      */   private JPanel jPanel17;
/*      */   
/*      */   private JPanel jPanel18;
/*      */   
/*      */   private JPanel jPanel19;
/*      */   
/*      */   private JPanel jPanel2;
/*      */   
/*      */   private JPanel jPanel20;
/*      */   
/*      */   private JPanel jPanel21;
/*      */   
/*      */   private JPanel jPanel22;
/*      */   
/*      */   private JPanel jPanel23;
/*      */   
/*      */   private JPanel jPanel24;
/*      */   
/*      */   private JPanel jPanel25;
/*      */   
/*      */   private JPanel jPanel26;
/*      */   
/*      */   private JPanel jPanel27;
/*      */   
/*      */   private JPanel jPanel28;
/*      */   
/*      */   private JPanel jPanel29;
/*      */   
/*      */   private JPanel jPanel3;
/*      */   
/*      */   private JPanel jPanel30;
/*      */   
/*      */   private JPanel jPanel31;
/*      */   
/*      */   private JPanel jPanel32;
/*      */   
/*      */   private JPanel jPanel33;
/*      */   
/*      */   private JPanel jPanel34;
/*      */   
/*      */   private JPanel jPanel35;
/*      */   
/*      */   private JPanel jPanel36;
/*      */   
/*      */   private JPanel jPanel37;
/*      */   
/*      */   private JPanel jPanel38;
/*      */   
/*      */   private JPanel jPanel39;
/*      */   
/*      */   private JPanel jPanel4;
/*      */   
/*      */   private JPanel jPanel42;
/*      */   
/*      */   private JPanel jPanel43;
/*      */   
/*      */   private JPanel jPanel44;
/*      */   
/*      */   private JPanel jPanel45;
/*      */   
/*      */   private JPanel jPanel46;
/*      */   
/*      */   private JPanel jPanel47;
/*      */   
/*      */   private JPanel jPanel5;
/*      */   
/*      */   private JPanel jPanel6;
/*      */   
/*      */   private JPanel jPanel7;
/*      */   
/*      */   private JPanel jPanel8;
/*      */   
/*      */   private JPanel jPanel9;
/*      */   
/*      */   private JRadioButton jRadioButton1;
/*      */   
/*      */   private JRadioButton jRadioButton2;
/*      */   
/*      */   private JRadioButton jRadioButton3;
/*      */   
/*      */   private JRadioButton jRadioButton4;
/*      */   
/*      */   private JRadioButton jRadioButton5;
/*      */   
/*      */   private JRadioButton jRadioButton6;
/*      */   
/*      */   private JScrollPane jScrollPane11;
/*      */   
/*      */   private JScrollPane jScrollPane13;
/*      */   
/*      */   private JScrollPane jScrollPane16;
/*      */   
/*      */   private JScrollPane jScrollPane17;
/*      */   
/*      */   private JScrollPane jScrollPane18;
/*      */   
/*      */   private JScrollPane jScrollPane19;
/*      */   
/*      */   private JScrollPane jScrollPane2;
/*      */   
/*      */   private JScrollPane jScrollPane3;
/*      */   
/*      */   private JScrollPane jScrollPane33;
/*      */   
/*      */   private JScrollPane jScrollPane5;
/*      */   
/*      */   private JScrollPane jScrollPane6;
/*      */   
/*      */   private JSeparator jSeparator2;
/*      */   
/*      */   private JSeparator jSeparator3;
/*      */   
/*      */   private JSeparator jSeparator6;
/*      */   
/*      */   private JSeparator jSeparator8;
/*      */   
/*      */   private JSpinner jSpinner1;
/*      */   
/*      */   private JTable jTable3;
/*      */   
/*      */   private JTextArea jTextArea2;
/*      */   
/*      */   private JTextField jTextField1;
/*      */   
/*      */   private JTextField jTextField10;
/*      */   
/*      */   private JTextField jTextField11;
/*      */   
/*      */   private JTextField jTextField12;
/*      */   
/*      */   private JTextField jTextField13;
/*      */   
/*      */   private JTextField jTextField18;
/*      */   
/*      */   private JTextField jTextField2;
/*      */   
/*      */   private JTextField jTextField3;
/*      */   
/*      */   private JTextField jTextField4;
/*      */   
/*      */   private JTextField jTextField5;
/*      */   
/*      */   private JTextField jTextField6;
/*      */   
/*      */   private JTextField jTextField7;
/*      */   
/*      */   private JTextField jTextField8;
/*      */   
/*      */   private JTextField jTextField9;
/*      */   
/*      */   private MaterialButton materialButton17;
/*      */   
/*      */   private MaterialButton materialButton18;
/*      */   
/*      */   private MaterialButton materialButton19;
/*      */   
/*      */   private MaterialButton materialButton20;
/*      */   
/*      */   private MaterialButton materialButton21;
/*      */   
/*      */   private MaterialButton materialButton22;
/*      */   
/*      */   private MaterialButton materialButton23;
/*      */   
/*      */   private MaterialButton materialButton24;
/*      */   
/*      */   private MaterialButton materialButton25;
/*      */   
/*      */   private MaterialButton materialButton26;
/*      */   
/*      */   private MaterialButton materialButton27;
/*      */   
/*      */   private MaterialButton materialButton28;
/*      */   
/*      */   private MaterialButton materialButton29;
/*      */   
/*      */   private MaterialButton materialButton30;
/*      */   
/*      */   private MaterialButton materialButton31;
/*      */   
/*      */   private MaterialButton materialButton32;
/*      */   
/*      */   private MaterialButton materialButton33;
/*      */   
/*      */   private MaterialButton materialButton34;
/*      */   
/*      */   private RSTableMetro rSTableMetro1;
/*      */   
/*      */   private RSTableMetro rSTableMetro2;
/*      */   
/*      */   private RSTableMetro rSTableMetro3;
/*      */   
/*      */   private RSTableMetro rSTableMetro6;
/*      */   
/*      */   private RSTableMetro rSTableMetro7;
/*      */   
/*      */   private RSTableMetro rSTableMetro8;
/*      */   
/*      */   public ProvTarjetaDeudor(JScrollPane panelito, JTabbedPane fichas, String USUARIO, JFrame padre, MensajePop mensajeTry, JLabel EtiquetaEstado, Map<String, String> CAMPOSGENERALES) {
/*  615 */     this.EtiquetaEstado = EtiquetaEstado;
/*  616 */     this.CAMPOSGENERALES = CAMPOSGENERALES;
/*  617 */     this.mensajeTry = mensajeTry;
/*  618 */     this.padre = padre;
/*  619 */     this.fichas = fichas;
/*  620 */     this.USUARIO = USUARIO;
/*  621 */     this.panel = panelito;
/*  622 */     this.con.setBaseDatos("sicre2PR");
/*  623 */     this.con.cambiarServidor();
/*  624 */     this.panel.setViewportView(this);
/*  625 */     initComponents();
/*  626 */     this.placeHolder = new PlaceHolder(this.jTextField1, new Color(189, 189, 189), Color.BLACK, this.holderRazonSocial, false, "Century Gothic", 11);
/*  627 */     this.placeHolder = new PlaceHolder(this.jTextField4, new Color(189, 189, 189), Color.BLACK, this.holderChequeTrans, false, "Century Gothic", 11);
/*  628 */     this.placeHolder = new PlaceHolder(this.jTextField5, new Color(189, 189, 189), Color.BLACK, this.holderFactura, false, "Century Gothic", 11);
/*  629 */     Image imagen2 = this.tk.getImage(getClass().getResource("/entrada/Imagenes/puntero.gif"));
/*  630 */     Cursor micursor = this.tk.createCustomCursor(imagen2, new Point(1, 1), null);
/*  631 */     this.rSTableMetro1.setCursor(micursor);
/*  632 */     this.rSTableMetro2.setCursor(micursor);
/*  633 */     this.rSTableMetro3.setCursor(micursor);
/*  634 */     this.rSTableMetro6.setCursor(micursor);
/*  635 */     this.rSTableMetro7.setCursor(micursor);
/*  636 */     this.rSTableMetro8.setCursor(micursor);
/*  637 */     this.jDialog1.setCursor(micursor);
/*  638 */     this.jDialog2.setCursor(micursor);
/*  639 */     this.jDialog3.setCursor(micursor);
/*  640 */     this.jDialog4.setCursor(micursor);
/*  641 */     this.jDialog5.setCursor(micursor);
/*  642 */     this.jDialog6.setCursor(micursor);
/*  643 */     this.jDialog10.setCursor(micursor);
/*  644 */     this.jDialog11.setCursor(micursor);
/*  645 */     this.jDialog12.setCursor(micursor);
/*  646 */     NumberFormat dispFormat = NumberFormat.getCurrencyInstance();
/*  647 */     NumberFormat editFormat = NumberFormat.getNumberInstance(Locale.US);
/*  648 */     editFormat.setGroupingUsed(false);
/*  649 */     NumberFormatter dnFormat = new NumberFormatter(dispFormat);
/*  650 */     NumberFormatter enFormat = new NumberFormatter(editFormat);
/*  651 */     DefaultFormatterFactory currFactory = new DefaultFormatterFactory(dnFormat, dnFormat, enFormat);
/*  652 */     enFormat.setAllowsInvalid(true);
/*  653 */     this.cantidad.setFormatterFactory(currFactory);
/*  654 */     this.importe1.setFormatterFactory(currFactory);
/*  655 */     this.importe2.setFormatterFactory(currFactory);
/*  656 */     this.importe3.setFormatterFactory(currFactory);
/*      */     
/*  658 */     int w = this.tama.width;
/*  659 */     int h = this.tama.height;
/*  660 */     int rw = (w - this.tama.width - 200) / 2;
/*  661 */     int rh = (h - this.tama.height - 150) / 2;
/*  662 */     this.jDialog1.setLocation(30, 30);
/*  663 */     this.jDialog1.setSize(this.tama.width - 200, this.tama.height - 150);
/*  664 */     this.jDialog1.setVisible(false);
/*  665 */     this.jDialog1.setResizable(false);
/*      */     
/*  667 */     rw = (w - 360) / 2;
/*  668 */     rh = (h - 465) / 2;
/*  669 */     this.jDialog2.setLocation(10, 10);
/*  670 */     this.jDialog2.setSize(360, 465);
/*  671 */     this.jDialog2.setVisible(false);
/*  672 */     this.jDialog2.setResizable(false);
/*  673 */     rw = (w - 770) / 2;
/*  674 */     rh = (h - 505) / 2;
/*  675 */     this.jDialog3.setLocation(rw, rh);
/*  676 */     this.jDialog3.setSize(770, 505);
/*  677 */     this.jDialog3.setVisible(false);
/*  678 */     this.jDialog3.setResizable(false);
/*  679 */     rw = (w - 510) / 2;
/*  680 */     rh = (h - 260) / 2;
/*  681 */     this.jDialog4.setLocation(rw, rh);
/*  682 */     this.jDialog4.setSize(510, 260);
/*  683 */     this.jDialog4.setResizable(false);
/*  684 */     rw = (w - 320) / 2;
/*  685 */     rh = (h - 170) / 2;
/*  686 */     this.jDialog5.setLocation(rw, rh);
/*  687 */     this.jDialog5.setSize(340, 165);
/*  688 */     this.jDialog5.setVisible(false);
/*  689 */     this.jDialog5.setResizable(false);
/*  690 */     rw = (w - 400) / 2;
/*  691 */     rh = (h - 470) / 2;
/*  692 */     this.jDialog6.setLocation(rw, rh);
/*  693 */     this.jDialog6.setSize(430, 470);
/*  694 */     this.jDialog6.setVisible(false);
/*  695 */     this.jDialog6.setResizable(false);
/*  696 */     rw = (w - 420) / 2;
/*  697 */     rh = (h - 150) / 2;
/*  698 */     this.jDialog10.setLocation(rw, rh);
/*  699 */     this.jDialog10.setSize(420, 150);
/*  700 */     this.jDialog10.setVisible(false);
/*  701 */     this.jDialog10.setResizable(false);
/*  702 */     rw = (w - 430) / 2;
/*  703 */     rh = (h - 200) / 2;
/*  704 */     this.jDialog11.setLocation(rw, rh);
/*  705 */     this.jDialog11.setSize(430, 200);
/*  706 */     this.jDialog11.setVisible(false);
/*  707 */     this.jDialog11.setResizable(false);
/*  708 */     rw = (w - 420) / 2;
/*  709 */     rh = (h - 150) / 2;
/*  710 */     this.jDialog12.setLocation(rw, rh);
/*  711 */     this.jDialog12.setSize(370, 130);
/*  712 */     this.jDialog12.setVisible(false);
/*  713 */     this.jDialog12.setResizable(false);
/*  714 */     rw = (w - 420) / 2;
/*  715 */     rh = (h - 150) / 2;
/*  716 */     this.jDialog13.setLocation(rw, rh);
/*  717 */     this.jDialog13.setSize(350, 150);
/*  718 */     this.jDialog13.setVisible(false);
/*  719 */     this.jDialog13.setResizable(false);
/*  720 */     rw = (w - 420) / 2;
/*  721 */     rh = (h - 150) / 2;
/*  722 */     this.jDialog14.setLocation(rw, rh);
/*  723 */     this.jDialog14.setSize(450, 450);
/*  724 */     this.jDialog14.setVisible(false);
/*  725 */     this.jDialog7.setSize(300, 300);
/*  726 */     this.jDialog8.setSize(300, 300);
/*  727 */     this.jDialog9.setSize(300, 300);
/*  728 */     LocalDateTime ahora = LocalDateTime.now();
/*  729 */     int year = ahora.getYear();
/*  730 */     List<String> añitos = new ArrayList<>();
/*  731 */     for (int i = 2019; i <= year; i++) {
/*  732 */       añitos.add("" + i);
/*      */     }
/*  734 */     this.jSpinner1.setModel(new SpinnerListModel(añitos));
/*  735 */     this.buttonGroup1.add(this.jRadioButton1);
/*  736 */     this.buttonGroup1.add(this.jRadioButton2);
/*  737 */     this.buttonGroup2.add(this.jRadioButton3);
/*  738 */     this.buttonGroup2.add(this.jRadioButton4);
/*  739 */     this.buttonGroup2.add(this.jRadioButton5);
/*  740 */     this.buttonGroup2.add(this.jRadioButton6);
/*  741 */     colorear();
/*  742 */     llenarCombo();
/*  743 */     privilegios();
/*  744 */     consultar();
/*      */   }
/*      */   
/*      */   private void initComponents() {
/*  748 */     this.jDialog1 = new CerrarVentana(this.padre);
/*  749 */     this.jPanel25 = new JPanel();
/*  750 */     this.jLabel62 = new JLabel();
/*  751 */     this.jPanel1 = new JPanel();
/*  752 */     this.jPanel23 = new JPanel();
/*  753 */     this.jPanel6 = new JPanel();
/*  754 */     this.jLabel44 = new JLabel();
/*  755 */     this.jPanel7 = new JPanel();
/*  756 */     this.jDateChooser7 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  757 */     this.jLabel45 = new JLabel();
/*  758 */     this.jDateChooser8 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  759 */     this.jLabel46 = new JLabel();
/*  760 */     this.jComboBox4 = new JComboBox();
/*  761 */     this.jLabel50 = new JLabel();
/*  762 */     this.jComboBox6 = new JComboBox();
/*  763 */     this.jLabel47 = new JLabel();
/*  764 */     this.jComboBox5 = new JComboBox();
/*  765 */     this.jButton8 = new JButton();
/*  766 */     this.jPanel24 = new JPanel();
/*  767 */     this.jButton17 = new JButton();
/*  768 */     this.jLabel51 = new JLabel();
/*  769 */     this.jLabel52 = new JLabel();
/*  770 */     this.jButton5 = new JButton();
/*  771 */     this.jPanel15 = new JPanel();
/*  772 */     this.materialButton21 = new MaterialButton();
/*  773 */     this.materialButton22 = new MaterialButton();
/*  774 */     this.materialButton23 = new MaterialButton();
/*  775 */     this.jPanel27 = new JPanel();
/*  776 */     this.jTextField2 = new JTextField();
/*  777 */     this.jLabel56 = new JLabel();
/*  778 */     this.jScrollPane16 = new JScrollPane();
/*  779 */     this.rSTableMetro2 = new RSTableMetro();
/*  780 */     this.jDialog2 = new CerrarVentana(this.padre);
/*  781 */     this.jPanel19 = new JPanel();
/*  782 */     this.jSeparator6 = new JSeparator();
/*  783 */     this.jLabel73 = new JLabel();
/*  784 */     this.jTextField9 = new JTextField();
/*  785 */     this.jLabel74 = new JLabel();
/*  786 */     this.jLabel35 = new JLabel();
/*  787 */     this.jPanel20 = new JPanel();
/*  788 */     this.jRadioButton1 = new JRadioButton();
/*  789 */     this.jRadioButton2 = new JRadioButton();
/*  790 */     this.jTextField10 = new JTextField();
/*  791 */     this.jLabel75 = new JLabel();
/*  792 */     this.jTextField18 = new JTextField();
/*  793 */     this.jLabel76 = new JLabel();
/*  794 */     this.importe1 = new JFormattedTextField();
/*  795 */     this.jLabel77 = new JLabel();
/*  796 */     this.jScrollPane11 = new JScrollPane();
/*  797 */     this.jTextArea2 = new JTextArea();
/*  798 */     this.materialButton24 = new MaterialButton();
/*  799 */     this.materialButton25 = new MaterialButton();
/*  800 */     this.jDialog3 = new CerrarVentana(this.padre);
/*  801 */     this.jPanel10 = new JPanel();
/*  802 */     this.jPanel11 = new JPanel();
/*  803 */     this.jPanel12 = new JPanel();
/*  804 */     this.jLabel1 = new JLabel();
/*  805 */     this.jTextField3 = new JTextField();
/*  806 */     this.jPanel14 = new JPanel();
/*  807 */     this.jSeparator2 = new JSeparator();
/*  808 */     this.jPanel16 = new JPanel();
/*  809 */     this.jPanel18 = new JPanel();
/*  810 */     this.jLabel2 = new JLabel();
/*  811 */     this.jComboBox3 = new JComboBox<>();
/*  812 */     this.jLabel5 = new JLabel();
/*  813 */     this.importe2 = new JFormattedTextField();
/*  814 */     this.jPanel21 = new JPanel();
/*  815 */     this.jLabel4 = new JLabel();
/*  816 */     this.jPanel103 = new JPanel();
/*  817 */     this.jTextField6 = new JTextField();
/*  818 */     this.jButton35 = new JButton();
/*  819 */     this.jPanel22 = new JPanel();
/*  820 */     this.jPanel26 = new JPanel();
/*  821 */     this.jPanel28 = new JPanel();
/*  822 */     this.jPanel29 = new JPanel();
/*  823 */     this.jLabel6 = new JLabel();
/*  824 */     this.jTextField5 = new JTextField();
/*  825 */     this.jLabel7 = new JLabel();
/*  826 */     this.jPanel31 = new JPanel();
/*  827 */     this.jPanel32 = new JPanel();
/*  828 */     this.jButton1 = new JButton();
/*  829 */     this.jButton2 = new JButton();
/*  830 */     this.jButton3 = new JButton();
/*  831 */     this.jPanel33 = new JPanel();
/*  832 */     this.jPanel8 = new JPanel();
/*  833 */     this.jPanel30 = new JPanel();
/*  834 */     this.jScrollPane17 = new JScrollPane();
/*  835 */     this.rSTableMetro6 = new RSTableMetro();
/*  836 */     this.jScrollPane18 = new JScrollPane();
/*  837 */     this.rSTableMetro7 = new RSTableMetro();
/*  838 */     this.jPanel34 = new JPanel();
/*  839 */     this.jLabel57 = new JLabel();
/*  840 */     this.jLabel59 = new JLabel();
/*  841 */     this.materialButton26 = new MaterialButton();
/*  842 */     this.materialButton27 = new MaterialButton();
/*  843 */     this.jLabel8 = new JLabel();
/*  844 */     this.jLabel9 = new JLabel();
/*  845 */     this.jDialog4 = new CerrarVentana(this.padre);
/*  846 */     this.jPanel136 = new JPanel();
/*  847 */     this.jScrollPane33 = new JScrollPane();
/*  848 */     this.rSTableMetro3 = new RSTableMetro();
/*  849 */     this.jButton53 = new JButton();
/*  850 */     this.jLabel10 = new JLabel();
/*  851 */     this.jTextField4 = new JTextField();
/*  852 */     this.jDialog5 = new CerrarVentana(this.padre);
/*  853 */     this.jPanel35 = new JPanel();
/*  854 */     this.jLabel128 = new JLabel();
/*  855 */     this.jLabel129 = new JLabel();
/*  856 */     this.importe3 = new JFormattedTextField();
/*  857 */     this.jSeparator8 = new JSeparator();
/*  858 */     this.materialButton28 = new MaterialButton();
/*  859 */     this.materialButton29 = new MaterialButton();
/*  860 */     this.jDialog6 = new CerrarVentana(this.padre);
/*  861 */     this.jPanel36 = new JPanel();
/*  862 */     this.jPanel5 = new JPanel();
/*  863 */     this.jLabel11 = new JLabel();
/*  864 */     this.jTextField7 = new JTextField();
/*  865 */     this.jLabel12 = new JLabel();
/*  866 */     this.jTextField8 = new JTextField();
/*  867 */     this.jLabel13 = new JLabel();
/*  868 */     this.jTextField11 = new JTextField();
/*  869 */     this.jLabel14 = new JLabel();
/*  870 */     this.jTextField12 = new JTextField();
/*  871 */     this.jLabel15 = new JLabel();
/*  872 */     this.jTextField13 = new JTextField();
/*  873 */     this.jPanel9 = new JPanel();
/*  874 */     this.jScrollPane19 = new JScrollPane();
/*  875 */     this.rSTableMetro8 = new RSTableMetro();
/*  876 */     this.jLabel17 = new JLabel();
/*  877 */     this.jLabel18 = new JLabel();
/*  878 */     this.materialButton30 = new MaterialButton();
/*  879 */     this.jDialog7 = new JDialog();
/*  880 */     this.jScrollPane2 = new JScrollPane();
/*  881 */     this.TablaGral = new JTable();
/*  882 */     this.jLabel60 = new JLabel();
/*  883 */     this.jLabel61 = new JLabel();
/*  884 */     this.jDialog8 = new JDialog();
/*  885 */     this.jScrollPane3 = new JScrollPane();
/*  886 */     this.TablaGral1 = new JTable();
/*  887 */     this.jLabel63 = new JLabel();
/*  888 */     this.jLabel64 = new JLabel();
/*  889 */     this.jDialog9 = new JDialog();
/*  890 */     this.jScrollPane6 = new JScrollPane();
/*  891 */     this.TablaAux = new JTable();
/*  892 */     this.jLabel68 = new JLabel();
/*  893 */     this.jLabel69 = new JLabel();
/*  894 */     this.jLabel72 = new JLabel();
/*  895 */     this.jLabel82 = new JLabel();
/*  896 */     this.jLabel83 = new JLabel();
/*  897 */     this.jLabel19 = new JLabel();
/*  898 */     this.jLabel20 = new JLabel();
/*  899 */     this.jDialog10 = new CerrarVentana(this.padre);
/*  900 */     this.jLabel16 = new JLabel();
/*  901 */     this.jDateChooser9 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  902 */     this.materialButton18 = new MaterialButton();
/*  903 */     this.materialButton17 = new MaterialButton();
/*  904 */     this.jLabel43 = new JLabel();
/*  905 */     this.jComboBox12 = new JComboBox();
/*  906 */     this.jDialog11 = new CerrarVentana(this.padre);
/*  907 */     this.jPanel37 = new JPanel();
/*  908 */     this.jRadioButton3 = new JRadioButton();
/*  909 */     this.jRadioButton4 = new JRadioButton();
/*  910 */     this.jLabel85 = new JLabel();
/*  911 */     this.jLabel94 = new JLabel();
/*  912 */     this.jDateChooser1 = new JDateChooser("dd-MM-yyyy", "__-__-____", '_');
/*  913 */     this.jLabel42 = new JLabel();
/*  914 */     this.materialButton31 = new MaterialButton();
/*  915 */     this.materialButton19 = new MaterialButton();
/*  916 */     this.jDialog12 = new CerrarVentana(this.padre);
/*  917 */     this.materialButton20 = new MaterialButton();
/*  918 */     this.materialButton32 = new MaterialButton();
/*  919 */     this.jRadioButton5 = new JRadioButton();
/*  920 */     this.jRadioButton6 = new JRadioButton();
/*  921 */     this.jDialog13 = new CerrarVentana(this.padre);
/*  922 */     this.jPanel38 = new JPanel();
/*  923 */     this.materialButton34 = new MaterialButton();
/*  924 */     this.materialButton33 = new MaterialButton();
/*  925 */     this.jLabel53 = new JLabel();
/*  926 */     this.jLabel54 = new JLabel();
/*  927 */     this.jSpinner1 = new JSpinner();
/*  928 */     this.jComboBox8 = new JComboBox();
/*  929 */     this.jDialog14 = new CerrarVentana(this.padre);
/*  930 */     this.jPanel39 = new JPanel();
/*  931 */     this.jLabel21 = new JLabel();
/*  932 */     this.jSeparator3 = new JSeparator();
/*  933 */     this.jScrollPane5 = new JScrollPane();
/*  934 */     this.jTable3 = new JTable();
/*  935 */     this.jButton6 = new JButton();
/*  936 */     this.jLabel22 = new JLabel();
/*  937 */     this.jLabel23 = new JLabel();
/*  938 */     this.jLabel24 = new JLabel();
/*  939 */     this.jLabel25 = new JLabel();
/*  940 */     this.cantidad = new JFormattedTextField();
/*  941 */     this.buttonGroup1 = new ButtonGroup();
/*  942 */     this.buttonGroup2 = new ButtonGroup();
/*  943 */     this.buttonGroup3 = new ButtonGroup();
/*  944 */     this.jPanel13 = new JPanel();
/*  945 */     this.jPanel42 = new JPanel();
/*  946 */     this.jLabel3 = new JLabel();
/*  947 */     this.jPanel44 = new JPanel();
/*  948 */     this.jPanel43 = new JPanel();
/*  949 */     this.jPanel45 = new JPanel();
/*  950 */     this.jLabel49 = new JLabel();
/*  951 */     this.jPanel46 = new JPanel();
/*  952 */     this.jPanel4 = new JPanel();
/*  953 */     this.jButton10 = new JButton();
/*  954 */     this.jButton4 = new JButton();
/*  955 */     this.jButton9 = new JButton();
/*  956 */     this.jPanel47 = new JPanel();
/*  957 */     this.jLabel58 = new JLabel();
/*  958 */     this.jLabel48 = new JLabel();
/*  959 */     this.jScrollPane13 = new JScrollPane();
/*  960 */     this.rSTableMetro1 = new RSTableMetro();
/*  961 */     this.jPanel17 = new JPanel();
/*  962 */     this.jPanel3 = new JPanel();
/*  963 */     this.jTextField1 = new JTextField();
/*  964 */     this.jComboBox2 = new JComboBox();
/*  965 */     this.jComboBox1 = new JComboBox();
/*  966 */     this.jPanel2 = new JPanel();
/*  967 */     this.jDialog1.setTitle("Administrar Tarjetas de Deudor");
/*  968 */     this.jDialog1.setModal(true);
/*  969 */     this.jLabel62.setFont(new Font("Cantarell", 1, 22));
/*  970 */     this.jLabel62.setForeground(this.lc.PRIMARIO1);
/*  971 */     this.jLabel62.setHorizontalAlignment(0);
/*  972 */     this.jLabel62.setText("Tarjeta de ");
/*  973 */     this.jPanel1.setLayout(new GridLayout(1, 2, 20, 0));
/*  974 */     this.jPanel23.setBorder(BorderFactory.createTitledBorder("Búsqueda"));
/*  975 */     GridBagLayout jPanel6Layout = new GridBagLayout();
/*  976 */     jPanel6Layout.columnWidths = new int[] { 0, 5, 0, 5, 0 };
/*  977 */     jPanel6Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0 };
/*  978 */     this.jPanel6.setLayout(jPanel6Layout);
/*  979 */     this.jLabel44.setFont(new Font("Cantarell", 0, 11));
/*  980 */     this.jLabel44.setText("Fecha:");
/*  981 */     GridBagConstraints gridBagConstraints = new GridBagConstraints();
/*  982 */     gridBagConstraints.gridx = 0;
/*  983 */     gridBagConstraints.gridy = 0;
/*  984 */     gridBagConstraints.fill = 2;
/*  985 */     gridBagConstraints.anchor = 21;
/*  986 */     gridBagConstraints.insets = new Insets(0, 10, 0, 0);
/*  987 */     this.jPanel6.add(this.jLabel44, gridBagConstraints);
/*  988 */     this.jPanel7.setLayout(new GridBagLayout());
/*  989 */     this.jDateChooser7.setDate(this.fechaActual);
/*  990 */     this.jDateChooser7.setDateFormatString("dd/MM/yyyy");
/*  991 */     this.jDateChooser7.setIcon(this.icon);
/*  992 */     this.jDateChooser7.setMaxSelectableDate(this.fecha);
/*  993 */     this.jDateChooser7.setMinSelectableDate(this.fechaInicio);
/*  994 */     gridBagConstraints = new GridBagConstraints();
/*  995 */     gridBagConstraints.fill = 2;
/*  996 */     gridBagConstraints.weightx = 1.0D;
/*  997 */     this.jPanel7.add((Component)this.jDateChooser7, gridBagConstraints);
/*  998 */     this.jLabel45.setFont(new Font("Cantarell", 0, 11));
/*  999 */     this.jLabel45.setHorizontalAlignment(0);
/* 1000 */     this.jLabel45.setText("Hasta");
/* 1001 */     gridBagConstraints = new GridBagConstraints();
/* 1002 */     gridBagConstraints.insets = new Insets(0, 10, 0, 10);
/* 1003 */     this.jPanel7.add(this.jLabel45, gridBagConstraints);
/* 1004 */     this.jDateChooser8.setDate(this.fechaActual);
/* 1005 */     this.jDateChooser8.setDateFormatString("dd/MM/yyyy");
/* 1006 */     this.jDateChooser8.setIcon(this.icon);
/* 1007 */     this.jDateChooser8.setMaxSelectableDate(this.fecha);
/* 1008 */     this.jDateChooser8.setMinSelectableDate(this.fechaInicio);
/* 1009 */     gridBagConstraints = new GridBagConstraints();
/* 1010 */     gridBagConstraints.fill = 2;
/* 1011 */     gridBagConstraints.weightx = 1.0D;
/* 1012 */     this.jPanel7.add((Component)this.jDateChooser8, gridBagConstraints);
/* 1013 */     gridBagConstraints = new GridBagConstraints();
/* 1014 */     gridBagConstraints.gridx = 2;
/* 1015 */     gridBagConstraints.gridy = 0;
/* 1016 */     gridBagConstraints.fill = 2;
/* 1017 */     gridBagConstraints.weightx = 1.0D;
/* 1018 */     gridBagConstraints.insets = new Insets(0, 30, 0, 10);
/* 1019 */     this.jPanel6.add(this.jPanel7, gridBagConstraints);
/* 1020 */     this.jLabel46.setFont(new Font("Cantarell", 0, 11));
/* 1021 */     this.jLabel46.setText("Concepto");
/* 1022 */     gridBagConstraints = new GridBagConstraints();
/* 1023 */     gridBagConstraints.gridx = 0;
/* 1024 */     gridBagConstraints.gridy = 2;
/* 1025 */     gridBagConstraints.fill = 2;
/* 1026 */     gridBagConstraints.anchor = 21;
/* 1027 */     gridBagConstraints.insets = new Insets(0, 10, 0, 0);
/* 1028 */     this.jPanel6.add(this.jLabel46, gridBagConstraints);
/* 1029 */     this.jComboBox4.setBackground(new Color(244, 244, 244));
/* 1030 */     this.jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] { "TODOS", "CARGO", "ABONO" }));
/* 1031 */     this.jComboBox4.setToolTipText("Enter para establecer la consulta");
/* 1032 */     this.jComboBox4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1034 */             ProvTarjetaDeudor.this.jComboBox4ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1037 */     gridBagConstraints = new GridBagConstraints();
/* 1038 */     gridBagConstraints.gridx = 2;
/* 1039 */     gridBagConstraints.gridy = 2;
/* 1040 */     gridBagConstraints.fill = 2;
/* 1041 */     gridBagConstraints.weightx = 1.0D;
/* 1042 */     gridBagConstraints.insets = new Insets(0, 30, 0, 10);
/* 1043 */     this.jPanel6.add(this.jComboBox4, gridBagConstraints);
/* 1044 */     this.jLabel50.setFont(new Font("Cantarell", 0, 11));
/* 1045 */     this.jLabel50.setText("Estatus:");
/* 1046 */     gridBagConstraints = new GridBagConstraints();
/* 1047 */     gridBagConstraints.gridx = 0;
/* 1048 */     gridBagConstraints.gridy = 4;
/* 1049 */     gridBagConstraints.fill = 2;
/* 1050 */     gridBagConstraints.anchor = 21;
/* 1051 */     gridBagConstraints.insets = new Insets(0, 10, 0, 0);
/* 1052 */     this.jPanel6.add(this.jLabel50, gridBagConstraints);
/* 1053 */     this.jComboBox6.setBackground(new Color(244, 244, 244));
/* 1054 */     this.jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] { "TODOS", "<Por Pagar>", "<Pagada>", "<Abonada>", "<Cancelada>" }));
/* 1055 */     this.jComboBox6.setToolTipText("Enter para establecer la consulta");
/* 1056 */     this.jComboBox6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1058 */             ProvTarjetaDeudor.this.jComboBox6ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1061 */     gridBagConstraints = new GridBagConstraints();
/* 1062 */     gridBagConstraints.gridx = 2;
/* 1063 */     gridBagConstraints.gridy = 4;
/* 1064 */     gridBagConstraints.fill = 2;
/* 1065 */     gridBagConstraints.weightx = 1.0D;
/* 1066 */     gridBagConstraints.insets = new Insets(0, 30, 0, 10);
/* 1067 */     this.jPanel6.add(this.jComboBox6, gridBagConstraints);
/* 1068 */     this.jLabel47.setFont(new Font("Cantarell", 0, 11));
/* 1069 */     this.jLabel47.setText("Referencia");
/* 1070 */     gridBagConstraints = new GridBagConstraints();
/* 1071 */     gridBagConstraints.gridx = 0;
/* 1072 */     gridBagConstraints.gridy = 6;
/* 1073 */     gridBagConstraints.fill = 2;
/* 1074 */     gridBagConstraints.anchor = 21;
/* 1075 */     gridBagConstraints.insets = new Insets(0, 10, 0, 0);
/* 1076 */     this.jPanel6.add(this.jLabel47, gridBagConstraints);
/* 1077 */     this.jComboBox5.setBackground(new Color(244, 244, 244));
/* 1078 */     this.jComboBox5.setEditable(true);
/* 1079 */     this.jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] { "TODOS" }));
/* 1080 */     this.jComboBox5.setToolTipText("Enter para establecer la consulta");
/* 1081 */     this.jComboBox5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1083 */             ProvTarjetaDeudor.this.jComboBox5ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1086 */     gridBagConstraints = new GridBagConstraints();
/* 1087 */     gridBagConstraints.gridx = 2;
/* 1088 */     gridBagConstraints.gridy = 6;
/* 1089 */     gridBagConstraints.fill = 2;
/* 1090 */     gridBagConstraints.weightx = 1.0D;
/* 1091 */     gridBagConstraints.insets = new Insets(0, 30, 0, 10);
/* 1092 */     this.jPanel6.add(this.jComboBox5, gridBagConstraints);
/* 1093 */     this.jButton8.setText("Buscar");
/* 1094 */     this.jButton8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1096 */             ProvTarjetaDeudor.this.jButton8ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1099 */     GroupLayout jPanel23Layout = new GroupLayout(this.jPanel23);
/* 1100 */     this.jPanel23.setLayout(jPanel23Layout);
/* 1101 */     jPanel23Layout.setHorizontalGroup(jPanel23Layout
/* 1102 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1103 */         .addComponent(this.jPanel6, -1, 384, 32767)
/* 1104 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
/* 1105 */           .addContainerGap(-1, 32767)
/* 1106 */           .addComponent(this.jButton8, -2, 109, -2)
/* 1107 */           .addContainerGap()));
/* 1108 */     jPanel23Layout.setVerticalGroup(jPanel23Layout
/* 1109 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1110 */         .addGroup(jPanel23Layout.createSequentialGroup()
/* 1111 */           .addComponent(this.jPanel6, -2, 139, -2)
/* 1112 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1113 */           .addComponent(this.jButton8)
/* 1114 */           .addGap(0, 0, 32767)));
/* 1115 */     this.jPanel1.add(this.jPanel23);
/* 1116 */     this.jPanel24.setBorder(BorderFactory.createTitledBorder("Administración"));
/* 1117 */     this.jButton17.setMnemonic('r');
/* 1118 */     this.jButton17.setText("Cargo");
/* 1119 */     this.jButton17.setToolTipText("Cargo (Alt+R)");
/* 1120 */     this.jButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1122 */             ProvTarjetaDeudor.this.jButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1125 */     this.jLabel51.setFont(new Font("Cantarell", 0, 11));
/* 1126 */     this.jLabel51.setText("Realizar un cargo");
/* 1127 */     this.jLabel52.setFont(new Font("Cantarell", 0, 11));
/* 1128 */     this.jLabel52.setText("Realizar un abono");
/* 1129 */     this.jButton5.setMnemonic('A');
/* 1130 */     this.jButton5.setText("Abono");
/* 1131 */     this.jButton5.setToolTipText("Abono (Alt+A)");
/* 1132 */     this.jButton5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1134 */             ProvTarjetaDeudor.this.jButton5ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1137 */     GroupLayout jPanel24Layout = new GroupLayout(this.jPanel24);
/* 1138 */     this.jPanel24.setLayout(jPanel24Layout);
/* 1139 */     jPanel24Layout.setHorizontalGroup(jPanel24Layout
/* 1140 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1141 */         .addGroup(jPanel24Layout.createSequentialGroup()
/* 1142 */           .addContainerGap()
/* 1143 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1144 */             .addComponent(this.jLabel52, GroupLayout.Alignment.LEADING, -1, 118, 32767)
/* 1145 */             .addComponent(this.jLabel51, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 1146 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 134, 32767)
/* 1147 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1148 */             .addComponent(this.jButton5, -1, 120, 32767)
/* 1149 */             .addComponent(this.jButton17, -1, -1, 32767))
/* 1150 */           .addContainerGap()));
/* 1151 */     jPanel24Layout.setVerticalGroup(jPanel24Layout
/* 1152 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1153 */         .addGroup(jPanel24Layout.createSequentialGroup()
/* 1154 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1155 */             .addComponent(this.jButton17)
/* 1156 */             .addComponent(this.jLabel51))
/* 1157 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1158 */           .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1159 */             .addComponent(this.jLabel52)
/* 1160 */             .addComponent(this.jButton5))
/* 1161 */           .addContainerGap(108, 32767)));
/* 1162 */     this.jPanel1.add(this.jPanel24);
/* 1163 */     this.jPanel15.setBackground(this.lc.SECUNDARIO2);
/* 1164 */     this.materialButton21.setBackground(this.lc.SECUNDARIO1);
/* 1165 */     this.materialButton21.setForeground(new Color(255, 255, 255));
/* 1166 */     this.materialButton21.setMnemonic('C');
/* 1167 */     this.materialButton21.setText("Cerrar");
/* 1168 */     this.materialButton21.setToolTipText("Cerrar (Alt+C)");
/* 1169 */     this.materialButton21.setFont(new Font("Cantarell", 0, 12));
/* 1170 */     this.materialButton21.setHorizontalTextPosition(0);
/* 1171 */     this.materialButton21.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1173 */             ProvTarjetaDeudor.this.materialButton21ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1176 */     this.materialButton22.setBackground(this.lc.PRIMARIO1);
/* 1177 */     this.materialButton22.setForeground(new Color(255, 255, 255));
/* 1178 */     this.materialButton22.setMnemonic('G');
/* 1179 */     this.materialButton22.setText("Guardar");
/* 1180 */     this.materialButton22.setToolTipText("Guardar (Alt+G)");
/* 1181 */     this.materialButton22.setFont(new Font("Cantarell", 0, 12));
/* 1182 */     this.materialButton22.setHorizontalTextPosition(0);
/* 1183 */     this.materialButton22.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1185 */             ProvTarjetaDeudor.this.materialButton22ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1188 */     this.materialButton23.setBackground(this.lc.PRIMARIO1);
/* 1189 */     this.materialButton23.setForeground(new Color(255, 255, 255));
/* 1190 */     this.materialButton23.setMnemonic('P');
/* 1191 */     this.materialButton23.setText("Imprimir");
/* 1192 */     this.materialButton23.setToolTipText("Imprimir (Alt+P)");
/* 1193 */     this.materialButton23.setFont(new Font("Cantarell", 0, 12));
/* 1194 */     this.materialButton23.setHorizontalTextPosition(0);
/* 1195 */     this.materialButton23.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1197 */             ProvTarjetaDeudor.this.materialButton23ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1200 */     GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
/* 1201 */     this.jPanel15.setLayout(jPanel15Layout);
/* 1202 */     jPanel15Layout.setHorizontalGroup(jPanel15Layout
/* 1203 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1204 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
/* 1205 */           .addContainerGap(-1, 32767)
/* 1206 */           .addComponent((Component)this.materialButton23, -2, 150, -2)
/* 1207 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1208 */           .addComponent((Component)this.materialButton22, -2, 150, -2)
/* 1209 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1210 */           .addComponent((Component)this.materialButton21, -2, 105, -2)
/* 1211 */           .addContainerGap()));
/* 1212 */     jPanel15Layout.setVerticalGroup(jPanel15Layout
/* 1213 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1214 */         .addComponent((Component)this.materialButton21, -2, 38, -2)
/* 1215 */         .addComponent((Component)this.materialButton22, GroupLayout.Alignment.TRAILING, -2, 38, -2)
/* 1216 */         .addComponent((Component)this.materialButton23, GroupLayout.Alignment.TRAILING, -2, 38, -2));
/* 1217 */     this.jTextField2.setEditable(false);
/* 1218 */     this.jTextField2.setFont(new Font("Cantarell", 1, 13));
/* 1219 */     this.jTextField2.setForeground(this.lc.PRIMARIO1);
/* 1220 */     this.jTextField2.setHorizontalAlignment(4);
/* 1221 */     this.jTextField2.setText("$ 10000.00");
/* 1222 */     this.jLabel56.setFont(new Font("Cantarell", 0, 11));
/* 1223 */     this.jLabel56.setForeground(this.lc.PRIMARIO1);
/* 1224 */     this.jLabel56.setText("jLabel56");
/* 1225 */     GroupLayout jPanel27Layout = new GroupLayout(this.jPanel27);
/* 1226 */     this.jPanel27.setLayout(jPanel27Layout);
/* 1227 */     jPanel27Layout.setHorizontalGroup(jPanel27Layout
/* 1228 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1229 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
/* 1230 */           .addComponent(this.jLabel56, -1, -1, 32767)
/* 1231 */           .addGap(471, 471, 471)
/* 1232 */           .addComponent(this.jTextField2, -2, 159, -2)
/* 1233 */           .addGap(18, 18, 18)));
/* 1234 */     jPanel27Layout.setVerticalGroup(jPanel27Layout
/* 1235 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1236 */         .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1237 */           .addComponent(this.jTextField2, -2, -1, -2)
/* 1238 */           .addComponent(this.jLabel56)));
/* 1239 */     (new String[2])[0] = "Clave"; (new String[2])[1] = "Nombre Completo"; this.rSTableMetro2.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[2]) {
/* 1240 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1243 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1246 */     this.rSTableMetro2.setAltoHead(25);
/* 1247 */     this.rSTableMetro2.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1248 */     this.rSTableMetro2.setColorBordeFilas(this.lc.REJILLATABLA);
/* 1249 */     this.rSTableMetro2.setColorBordeHead(this.lc.PRIMARIO1);
/* 1250 */     this.rSTableMetro2.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1251 */     this.rSTableMetro2.setColorFilasForeground1(new Color(102, 102, 102));
/* 1252 */     this.rSTableMetro2.setColorFilasForeground2(new Color(102, 102, 102));
/* 1253 */     this.rSTableMetro2.setColorSelBackgound(new Color(237, 107, 107));
/* 1254 */     this.rSTableMetro2.setFont(new Font("Cantarell", 0, 10));
/* 1255 */     this.rSTableMetro2.setFuenteFilas(new Font("Cantarell", 0, 10));
/* 1256 */     this.rSTableMetro2.setFuenteFilasSelect(new Font("Cantarell", 0, 10));
/* 1257 */     this.rSTableMetro2.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1258 */     this.rSTableMetro2.setGridColor(this.lc.FONDOTABLA);
/* 1259 */     this.rSTableMetro2.setRowHeight(18);
/* 1260 */     this.rSTableMetro2.setSelectionBackground(this.lc.PRIMARIO2);
/* 1261 */     this.rSTableMetro2.getTableHeader().setResizingAllowed(false);
/* 1262 */     this.rSTableMetro2.getTableHeader().setReorderingAllowed(false);
/* 1263 */     this.rSTableMetro2.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1265 */             ProvTarjetaDeudor.this.rSTableMetro2MouseClicked(evt);
/*      */           }
/*      */         });
/* 1268 */     this.rSTableMetro2.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1270 */             ProvTarjetaDeudor.this.rSTableMetro2KeyReleased(evt);
/*      */           }
/*      */         });
/* 1273 */     this.jScrollPane16.setViewportView((Component)this.rSTableMetro2);
/* 1274 */     GroupLayout jPanel25Layout = new GroupLayout(this.jPanel25);
/* 1275 */     this.jPanel25.setLayout(jPanel25Layout);
/* 1276 */     jPanel25Layout.setHorizontalGroup(jPanel25Layout
/* 1277 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1278 */         .addComponent(this.jLabel62, -1, -1, 32767)
/* 1279 */         .addComponent(this.jPanel15, -1, -1, 32767)
/* 1280 */         .addComponent(this.jPanel1, -1, 809, 32767)
/* 1281 */         .addComponent(this.jScrollPane16)
/* 1282 */         .addComponent(this.jPanel27, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/* 1283 */     jPanel25Layout.setVerticalGroup(jPanel25Layout
/* 1284 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1285 */         .addGroup(jPanel25Layout.createSequentialGroup()
/* 1286 */           .addComponent(this.jLabel62, -2, 20, -2)
/* 1287 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1288 */           .addComponent(this.jScrollPane16, -1, 197, 32767)
/* 1289 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1290 */           .addComponent(this.jPanel27, -2, -1, -2)
/* 1291 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1292 */           .addComponent(this.jPanel1, -2, -1, -2)
/* 1293 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1294 */           .addComponent(this.jPanel15, -2, -1, -2)));
/* 1295 */     GroupLayout jDialog1Layout = new GroupLayout(this.jDialog1.getContentPane());
/* 1296 */     this.jDialog1.getContentPane().setLayout(jDialog1Layout);
/* 1297 */     jDialog1Layout.setHorizontalGroup(jDialog1Layout
/* 1298 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1299 */         .addComponent(this.jPanel25, -1, -1, 32767));
/* 1300 */     jDialog1Layout.setVerticalGroup(jDialog1Layout
/* 1301 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1302 */         .addComponent(this.jPanel25, -1, -1, 32767));
/* 1303 */     this.jDialog2.setTitle("Nuevo Cargo Directo");
/* 1304 */     this.jDialog2.setModal(true);
/* 1305 */     this.jLabel73.setFont(new Font("Cantarell", 0, 11));
/* 1306 */     this.jLabel73.setText("Fecha ");
/* 1307 */     this.jTextField9.setEditable(false);
/* 1308 */     this.jTextField9.setFont(new Font("Tahoma", 1, 11));
/* 1309 */     this.jTextField9.setText("26/04/2010");
/* 1310 */     this.jLabel74.setFont(new Font("Cantarell", 0, 11));
/* 1311 */     this.jLabel74.setHorizontalAlignment(2);
/* 1312 */     this.jLabel74.setText("A cargo de ");
/* 1313 */     this.jLabel35.setFont(new Font("Cantarell", 1, 11));
/* 1314 */     this.jLabel35.setText("jLabel35");
/* 1315 */     this.jPanel20.setBorder(BorderFactory.createTitledBorder(null, "Concepto del Cargo", 0, 0, new Font("Tahoma", 1, 11)));
/* 1316 */     this.jRadioButton1.setFont(new Font("Cantarell", 0, 11));
/* 1317 */     this.jRadioButton1.setSelected(true);
/* 1318 */     this.jRadioButton1.setText("Cargo por factura");
/* 1319 */     this.jRadioButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1321 */             ProvTarjetaDeudor.this.jRadioButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1324 */     this.jRadioButton2.setFont(new Font("Cantarell", 0, 11));
/* 1325 */     this.jRadioButton2.setText("Otro...");
/* 1326 */     this.jRadioButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1328 */             ProvTarjetaDeudor.this.jRadioButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1331 */     this.jTextField10.setEnabled(false);
/* 1332 */     GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
/* 1333 */     this.jPanel20.setLayout(jPanel20Layout);
/* 1334 */     jPanel20Layout.setHorizontalGroup(jPanel20Layout
/* 1335 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1336 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 1337 */           .addContainerGap()
/* 1338 */           .addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1339 */             .addComponent(this.jRadioButton2, GroupLayout.Alignment.LEADING, -1, 281, 32767)
/* 1340 */             .addComponent(this.jRadioButton1, -1, 281, 32767))
/* 1341 */           .addGap(19, 19, 19))
/* 1342 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 1343 */           .addGap(27, 27, 27)
/* 1344 */           .addComponent(this.jTextField10, -1, 273, 32767)
/* 1345 */           .addContainerGap()));
/* 1346 */     jPanel20Layout.setVerticalGroup(jPanel20Layout
/* 1347 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1348 */         .addGroup(jPanel20Layout.createSequentialGroup()
/* 1349 */           .addComponent(this.jRadioButton1)
/* 1350 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1351 */           .addComponent(this.jRadioButton2)
/* 1352 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1353 */           .addComponent(this.jTextField10, -2, -1, -2)
/* 1354 */           .addContainerGap()));
/* 1355 */     this.jLabel75.setFont(new Font("Cantarell", 0, 11));
/* 1356 */     this.jLabel75.setText("Factura, nota, vale ó referencia");
/* 1357 */     this.jTextField18.setFont(new Font("Tahoma", 1, 11));
/* 1358 */     this.jLabel76.setFont(new Font("Cantarell", 0, 11));
/* 1359 */     this.jLabel76.setHorizontalAlignment(0);
/* 1360 */     this.jLabel76.setText("Cantidad ");
/* 1361 */     this.importe1.setHorizontalAlignment(4);
/* 1362 */     this.importe1.setText("$0.0");
/* 1363 */     this.importe1.setFont(new Font("Tahoma", 1, 11));
/* 1364 */     this.importe1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1366 */             ProvTarjetaDeudor.this.importe1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1369 */     this.jLabel77.setFont(new Font("Cantarell", 0, 11));
/* 1370 */     this.jLabel77.setText("Comentarios");
/* 1371 */     this.jTextArea2.setColumns(20);
/* 1372 */     this.jTextArea2.setFont(new Font("Tahoma", 0, 11));
/* 1373 */     this.jTextArea2.setLineWrap(true);
/* 1374 */     this.jTextArea2.setRows(5);
/* 1375 */     this.jScrollPane11.setViewportView(this.jTextArea2);
/* 1376 */     this.materialButton24.setBackground(this.lc.SECUNDARIO1);
/* 1377 */     this.materialButton24.setForeground(new Color(255, 255, 255));
/* 1378 */     this.materialButton24.setMnemonic('C');
/* 1379 */     this.materialButton24.setText("Cerrar");
/* 1380 */     this.materialButton24.setToolTipText("Cerrar (Alt+C)");
/* 1381 */     this.materialButton24.setFont(new Font("Cantarell", 0, 12));
/* 1382 */     this.materialButton24.setHorizontalTextPosition(0);
/* 1383 */     this.materialButton24.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1385 */             ProvTarjetaDeudor.this.materialButton24ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1388 */     this.materialButton25.setBackground(this.lc.PRIMARIO1);
/* 1389 */     this.materialButton25.setForeground(new Color(255, 255, 255));
/* 1390 */     this.materialButton25.setMnemonic('G');
/* 1391 */     this.materialButton25.setText("Guardar");
/* 1392 */     this.materialButton25.setToolTipText("Guardar (Alt+G)");
/* 1393 */     this.materialButton25.setFont(new Font("Cantarell", 0, 12));
/* 1394 */     this.materialButton25.setHorizontalTextPosition(0);
/* 1395 */     this.materialButton25.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1397 */             ProvTarjetaDeudor.this.materialButton25ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1400 */     GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
/* 1401 */     this.jPanel19.setLayout(jPanel19Layout);
/* 1402 */     jPanel19Layout.setHorizontalGroup(jPanel19Layout
/* 1403 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1404 */         .addGroup(jPanel19Layout.createSequentialGroup()
/* 1405 */           .addContainerGap()
/* 1406 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1407 */             .addComponent(this.jScrollPane11, -1, 316, 32767)
/* 1408 */             .addComponent(this.jPanel20, -1, -1, 32767)
/* 1409 */             .addComponent(this.jSeparator6, -1, 316, 32767)
/* 1410 */             .addGroup(jPanel19Layout.createSequentialGroup()
/* 1411 */               .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 1412 */                 .addComponent(this.jTextField18, -1, 190, 32767)
/* 1413 */                 .addComponent(this.jLabel75, -1, -1, 32767))
/* 1414 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, 32767)
/* 1415 */               .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 1416 */                 .addComponent(this.importe1)
/* 1417 */                 .addComponent(this.jLabel76, -2, 105, -2)))
/* 1418 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
/* 1419 */               .addGap(0, 0, 32767)
/* 1420 */               .addComponent((Component)this.materialButton25, -2, 150, -2)
/* 1421 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1422 */               .addComponent((Component)this.materialButton24, -2, 105, -2))
/* 1423 */             .addGroup(jPanel19Layout.createSequentialGroup()
/* 1424 */               .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1425 */                 .addComponent(this.jLabel74, -2, 70, -2)
/* 1426 */                 .addGroup(jPanel19Layout.createSequentialGroup()
/* 1427 */                   .addGap(31, 31, 31)
/* 1428 */                   .addComponent(this.jLabel35, -2, 271, -2))
/* 1429 */                 .addComponent(this.jLabel77, -2, 96, -2)
/* 1430 */                 .addGroup(jPanel19Layout.createSequentialGroup()
/* 1431 */                   .addComponent(this.jLabel73, -2, 42, -2)
/* 1432 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1433 */                   .addComponent(this.jTextField9, -2, 94, -2)))
/* 1434 */               .addGap(0, 0, 32767)))
/* 1435 */           .addContainerGap()));
/* 1436 */     jPanel19Layout.setVerticalGroup(jPanel19Layout
/* 1437 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1438 */         .addGroup(jPanel19Layout.createSequentialGroup()
/* 1439 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1440 */             .addComponent(this.jLabel73)
/* 1441 */             .addComponent(this.jTextField9, -2, -1, -2))
/* 1442 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1443 */           .addComponent(this.jSeparator6, -2, 10, -2)
/* 1444 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1445 */           .addComponent(this.jLabel74)
/* 1446 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1447 */           .addComponent(this.jLabel35)
/* 1448 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1449 */           .addComponent(this.jPanel20, -2, -1, -2)
/* 1450 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1451 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1452 */             .addGroup(jPanel19Layout.createSequentialGroup()
/* 1453 */               .addComponent(this.jLabel75)
/* 1454 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1455 */               .addComponent(this.jTextField18, -2, -1, -2))
/* 1456 */             .addGroup(jPanel19Layout.createSequentialGroup()
/* 1457 */               .addComponent(this.jLabel76)
/* 1458 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1459 */               .addComponent(this.importe1, -2, -1, -2)))
/* 1460 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1461 */           .addComponent(this.jLabel77)
/* 1462 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1463 */           .addComponent(this.jScrollPane11, -1, 109, 32767)
/* 1464 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1465 */           .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1466 */             .addComponent((Component)this.materialButton24, -2, 38, -2)
/* 1467 */             .addComponent((Component)this.materialButton25, GroupLayout.Alignment.TRAILING, -2, 38, -2))
/* 1468 */           .addContainerGap()));
/* 1469 */     GroupLayout jDialog2Layout = new GroupLayout(this.jDialog2.getContentPane());
/* 1470 */     this.jDialog2.getContentPane().setLayout(jDialog2Layout);
/* 1471 */     jDialog2Layout.setHorizontalGroup(jDialog2Layout
/* 1472 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1473 */         .addComponent(this.jPanel19, -1, -1, 32767));
/* 1474 */     jDialog2Layout.setVerticalGroup(jDialog2Layout
/* 1475 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1476 */         .addComponent(this.jPanel19, -1, -1, 32767));
/* 1477 */     this.jDialog3.setTitle("Nuevo Abono");
/* 1478 */     this.jDialog3.setModal(true);
/* 1479 */     this.jPanel11.setLayout(new GridLayout(1, 2, 40, 0));
/* 1480 */     this.jPanel12.setLayout(new GridLayout(1, 2, 6, 0));
/* 1481 */     this.jLabel1.setText(" Fecha del abono");
/* 1482 */     this.jPanel12.add(this.jLabel1);
/* 1483 */     this.jTextField3.setEditable(false);
/* 1484 */     this.jTextField3.setFont(new Font("Dialog", 1, 12));
/* 1485 */     this.jTextField3.setText("jTextField3");
/* 1486 */     this.jPanel12.add(this.jTextField3);
/* 1487 */     this.jPanel11.add(this.jPanel12);
/* 1488 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 1489 */     this.jPanel14.setLayout(jPanel14Layout);
/* 1490 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout
/* 1491 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1492 */         .addGap(0, 302, 32767));
/* 1493 */     jPanel14Layout.setVerticalGroup(jPanel14Layout
/* 1494 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1495 */         .addGap(0, 24, 32767));
/* 1496 */     this.jPanel11.add(this.jPanel14);
/* 1497 */     this.jPanel16.setBorder(BorderFactory.createTitledBorder("Información del abono"));
/* 1498 */     this.jPanel16.setLayout(new GridLayout(1, 2, 40, 0));
/* 1499 */     this.jPanel18.setLayout(new GridLayout(2, 2, 6, 6));
/* 1500 */     this.jLabel2.setText("Tipo de abono");
/* 1501 */     this.jPanel18.add(this.jLabel2);
/* 1502 */     this.jComboBox3.setBackground(Color.WHITE);
/* 1503 */     this.jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] { "SELECCIONA UNO...", "CHEQUE", "EFECTIVO", "NOTA DE CRÉDITO", "TRANSFERENCIA", "OTRO..." }));
/* 1504 */     this.jComboBox3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1506 */             ProvTarjetaDeudor.this.jComboBox3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1509 */     this.jPanel18.add(this.jComboBox3);
/* 1510 */     this.jLabel5.setText("Importe");
/* 1511 */     this.jPanel18.add(this.jLabel5);
/* 1512 */     this.importe2.setHorizontalAlignment(4);
/* 1513 */     this.importe2.setText("importe2");
/* 1514 */     this.importe2.setFont(new Font("Dialog", 1, 13));
/* 1515 */     this.importe2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1517 */             ProvTarjetaDeudor.this.importe2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1520 */     this.jPanel18.add(this.importe2);
/* 1521 */     this.jPanel16.add(this.jPanel18);
/* 1522 */     this.jPanel21.setLayout(new GridLayout(2, 2, 6, 6));
/* 1523 */     this.jLabel4.setHorizontalAlignment(0);
/* 1524 */     this.jLabel4.setText("Referencia");
/* 1525 */     this.jPanel21.add(this.jLabel4);
/* 1526 */     this.jTextField6.setFont(new Font("Dialog", 1, 13));
/* 1527 */     this.jTextField6.setNextFocusableComponent(this.importe2);
/* 1528 */     this.jButton35.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/bottomarrow.png")));
/* 1529 */     this.jButton35.setToolTipText("Buscar...");
/* 1530 */     this.jButton35.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1532 */             ProvTarjetaDeudor.this.jButton35ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1535 */     GroupLayout jPanel103Layout = new GroupLayout(this.jPanel103);
/* 1536 */     this.jPanel103.setLayout(jPanel103Layout);
/* 1537 */     jPanel103Layout.setHorizontalGroup(jPanel103Layout
/* 1538 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1539 */         .addGroup(jPanel103Layout.createSequentialGroup()
/* 1540 */           .addComponent(this.jTextField6, -1, 120, 32767)
/* 1541 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1542 */           .addComponent(this.jButton35, -2, 19, -2)));
/* 1543 */     jPanel103Layout.setVerticalGroup(jPanel103Layout
/* 1544 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1545 */         .addComponent(this.jTextField6)
/* 1546 */         .addComponent(this.jButton35, -1, -1, 32767));
/* 1547 */     this.jPanel21.add(this.jPanel103);
/* 1548 */     GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
/* 1549 */     this.jPanel22.setLayout(jPanel22Layout);
/* 1550 */     jPanel22Layout.setHorizontalGroup(jPanel22Layout
/* 1551 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1552 */         .addGap(0, 145, 32767));
/* 1553 */     jPanel22Layout.setVerticalGroup(jPanel22Layout
/* 1554 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1555 */         .addGap(0, 26, 32767));
/* 1556 */     this.jPanel21.add(this.jPanel22);
/* 1557 */     this.jPanel16.add(this.jPanel21);
/* 1558 */     this.jPanel26.setBorder(BorderFactory.createTitledBorder("Búsqueda de facturas"));
/* 1559 */     this.jPanel28.setLayout(new GridLayout(1, 2, 40, 0));
/* 1560 */     this.jPanel29.setLayout(new GridLayout(1, 2, 6, 0));
/* 1561 */     this.jLabel6.setText("Ingresa el folio");
/* 1562 */     this.jPanel29.add(this.jLabel6);
/* 1563 */     this.jTextField5.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1565 */             ProvTarjetaDeudor.this.jTextField5ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1568 */     this.jTextField5.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1570 */             ProvTarjetaDeudor.this.jTextField5KeyReleased(evt);
/*      */           }
/*      */         });
/* 1573 */     this.jPanel29.add(this.jTextField5);
/* 1574 */     this.jPanel28.add(this.jPanel29);
/* 1575 */     this.jLabel7.setFont(new Font("Cantarell", 0, 11));
/* 1576 */     this.jLabel7.setForeground(this.lc.PRIMARIO1);
/* 1577 */     this.jLabel7.setHorizontalAlignment(2);
/* 1578 */     this.jLabel7.setText("Buscando...");
/* 1579 */     this.jPanel28.add(this.jLabel7);
/* 1580 */     this.jPanel31.setLayout(new GridLayout(1, 5, 6, 0));
/* 1581 */     GroupLayout jPanel32Layout = new GroupLayout(this.jPanel32);
/* 1582 */     this.jPanel32.setLayout(jPanel32Layout);
/* 1583 */     jPanel32Layout.setHorizontalGroup(jPanel32Layout
/* 1584 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1585 */         .addGap(0, 122, 32767));
/* 1586 */     jPanel32Layout.setVerticalGroup(jPanel32Layout
/* 1587 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1588 */         .addGap(0, 30, 32767));
/* 1589 */     this.jPanel31.add(this.jPanel32);
/* 1590 */     this.jButton1.setText("Saldar");
/* 1591 */     this.jButton1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1593 */             ProvTarjetaDeudor.this.jButton1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1596 */     this.jPanel31.add(this.jButton1);
/* 1597 */     this.jButton2.setText("Importe");
/* 1598 */     this.jButton2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1600 */             ProvTarjetaDeudor.this.jButton2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1603 */     this.jPanel31.add(this.jButton2);
/* 1604 */     this.jButton3.setText("Quitar");
/* 1605 */     this.jButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1607 */             ProvTarjetaDeudor.this.jButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1610 */     this.jPanel31.add(this.jButton3);
/* 1611 */     GroupLayout jPanel33Layout = new GroupLayout(this.jPanel33);
/* 1612 */     this.jPanel33.setLayout(jPanel33Layout);
/* 1613 */     jPanel33Layout.setHorizontalGroup(jPanel33Layout
/* 1614 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1615 */         .addGap(0, 122, 32767));
/* 1616 */     jPanel33Layout.setVerticalGroup(jPanel33Layout
/* 1617 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1618 */         .addGap(0, 30, 32767));
/* 1619 */     this.jPanel31.add(this.jPanel33);
/* 1620 */     this.jPanel30.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1622 */             ProvTarjetaDeudor.this.jPanel30MouseClicked(evt);
/*      */           }
/*      */         });
/* 1625 */     this.jPanel30.setLayout(new GridLayout(1, 2, 10, 0));
/* 1626 */     (new String[2])[0] = "Clave"; (new String[2])[1] = "Nombre Completo"; this.rSTableMetro6.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[2]) {
/* 1627 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1630 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1633 */     this.rSTableMetro6.setAltoHead(25);
/* 1634 */     this.rSTableMetro6.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1635 */     this.rSTableMetro6.setColorBordeFilas(new Color(200, 200, 200));
/* 1636 */     this.rSTableMetro6.setColorBordeHead(this.lc.PRIMARIO1);
/* 1637 */     this.rSTableMetro6.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1638 */     this.rSTableMetro6.setColorFilasForeground1(new Color(102, 102, 102));
/* 1639 */     this.rSTableMetro6.setColorFilasForeground2(new Color(102, 102, 102));
/* 1640 */     this.rSTableMetro6.setColorSelBackgound(new Color(237, 107, 107));
/* 1641 */     this.rSTableMetro6.setFont(new Font("Cantarell", 0, 10));
/* 1642 */     this.rSTableMetro6.setFuenteFilas(new Font("Cantarell", 0, 10));
/* 1643 */     this.rSTableMetro6.setFuenteFilasSelect(new Font("Cantarell", 0, 10));
/* 1644 */     this.rSTableMetro6.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1645 */     this.rSTableMetro6.setGrosorBordeFilas(0);
/* 1646 */     this.rSTableMetro6.setRowHeight(18);
/* 1647 */     this.rSTableMetro6.setSelectionBackground(this.lc.PRIMARIO2);
/* 1648 */     this.rSTableMetro6.setShowHorizontalLines(false);
/* 1649 */     this.rSTableMetro6.setShowVerticalLines(false);
/* 1650 */     this.rSTableMetro6.getTableHeader().setResizingAllowed(false);
/* 1651 */     this.rSTableMetro6.getTableHeader().setReorderingAllowed(false);
/* 1652 */     this.rSTableMetro6.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1654 */             ProvTarjetaDeudor.this.rSTableMetro6MouseClicked(evt);
/*      */           }
/*      */         });
/* 1657 */     this.rSTableMetro6.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1659 */             ProvTarjetaDeudor.this.rSTableMetro6KeyReleased(evt);
/*      */           }
/*      */         });
/* 1662 */     this.jScrollPane17.setViewportView((Component)this.rSTableMetro6);
/* 1663 */     this.jPanel30.add(this.jScrollPane17);
/* 1664 */     (new String[2])[0] = "Clave"; (new String[2])[1] = "Nombre Completo"; this.rSTableMetro7.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[2]) {
/* 1665 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1668 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1671 */     this.rSTableMetro7.setAltoHead(25);
/* 1672 */     this.rSTableMetro7.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1673 */     this.rSTableMetro7.setColorBordeFilas(new Color(200, 200, 200));
/* 1674 */     this.rSTableMetro7.setColorBordeHead(this.lc.PRIMARIO1);
/* 1675 */     this.rSTableMetro7.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1676 */     this.rSTableMetro7.setColorFilasForeground1(new Color(102, 102, 102));
/* 1677 */     this.rSTableMetro7.setColorFilasForeground2(new Color(102, 102, 102));
/* 1678 */     this.rSTableMetro7.setColorSelBackgound(new Color(237, 107, 107));
/* 1679 */     this.rSTableMetro7.setFont(new Font("Cantarell", 0, 10));
/* 1680 */     this.rSTableMetro7.setFuenteFilas(new Font("Cantarell", 0, 10));
/* 1681 */     this.rSTableMetro7.setFuenteFilasSelect(new Font("Cantarell", 0, 10));
/* 1682 */     this.rSTableMetro7.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1683 */     this.rSTableMetro7.setGrosorBordeFilas(0);
/* 1684 */     this.rSTableMetro7.setRowHeight(18);
/* 1685 */     this.rSTableMetro7.setSelectionBackground(this.lc.PRIMARIO2);
/* 1686 */     this.rSTableMetro7.setShowHorizontalLines(false);
/* 1687 */     this.rSTableMetro7.setShowVerticalLines(false);
/* 1688 */     this.rSTableMetro7.getTableHeader().setResizingAllowed(false);
/* 1689 */     this.rSTableMetro7.getTableHeader().setReorderingAllowed(false);
/* 1690 */     this.rSTableMetro7.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1692 */             ProvTarjetaDeudor.this.rSTableMetro7MouseClicked(evt);
/*      */           }
/*      */         });
/* 1695 */     this.rSTableMetro7.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1697 */             ProvTarjetaDeudor.this.rSTableMetro7KeyReleased(evt);
/*      */           }
/*      */         });
/* 1700 */     this.jScrollPane18.setViewportView((Component)this.rSTableMetro7);
/* 1701 */     this.jPanel30.add(this.jScrollPane18);
/* 1702 */     this.jPanel34.setLayout(new GridLayout(1, 2, 10, 0));
/* 1703 */     this.jLabel57.setFont(new Font("Cantarell", 2, 11));
/* 1704 */     this.jLabel57.setForeground(this.lc.PRIMARIO1);
/* 1705 */     this.jLabel57.setHorizontalAlignment(0);
/* 1706 */     this.jLabel57.setText("Facturas pendientes de pago");
/* 1707 */     this.jPanel34.add(this.jLabel57);
/* 1708 */     this.jLabel59.setFont(new Font("Cantarell", 2, 11));
/* 1709 */     this.jLabel59.setForeground(this.lc.PRIMARIO1);
/* 1710 */     this.jLabel59.setHorizontalAlignment(0);
/* 1711 */     this.jLabel59.setText("Facturas seleccionadas para pago: 0");
/* 1712 */     this.jPanel34.add(this.jLabel59);
/* 1713 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 1714 */     this.jPanel8.setLayout(jPanel8Layout);
/* 1715 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout
/* 1716 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1717 */         .addComponent(this.jPanel30, -2, 0, 32767)
/* 1718 */         .addComponent(this.jPanel34, -1, -1, 32767));
/* 1719 */     jPanel8Layout.setVerticalGroup(jPanel8Layout
/* 1720 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1721 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
/* 1722 */           .addComponent(this.jPanel34, -2, -1, -2)
/* 1723 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1724 */           .addComponent(this.jPanel30, -1, 162, 32767)));
/* 1725 */     GroupLayout jPanel26Layout = new GroupLayout(this.jPanel26);
/* 1726 */     this.jPanel26.setLayout(jPanel26Layout);
/* 1727 */     jPanel26Layout.setHorizontalGroup(jPanel26Layout
/* 1728 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1729 */         .addComponent(this.jPanel28, -1, -1, 32767)
/* 1730 */         .addComponent(this.jPanel31, -1, 635, 32767)
/* 1731 */         .addComponent(this.jPanel8, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
/* 1732 */     jPanel26Layout.setVerticalGroup(jPanel26Layout
/* 1733 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1734 */         .addGroup(jPanel26Layout.createSequentialGroup()
/* 1735 */           .addComponent(this.jPanel28, -2, -1, -2)
/* 1736 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1737 */           .addComponent(this.jPanel8, -1, -1, 32767)
/* 1738 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1739 */           .addComponent(this.jPanel31, -2, 30, -2)
/* 1740 */           .addContainerGap()));
/* 1741 */     this.materialButton26.setBackground(this.lc.PRIMARIO1);
/* 1742 */     this.materialButton26.setForeground(new Color(255, 255, 255));
/* 1743 */     this.materialButton26.setMnemonic('G');
/* 1744 */     this.materialButton26.setText("Guardar");
/* 1745 */     this.materialButton26.setToolTipText("Guardar (Alt+G)");
/* 1746 */     this.materialButton26.setFont(new Font("Cantarell", 0, 12));
/* 1747 */     this.materialButton26.setHorizontalTextPosition(0);
/* 1748 */     this.materialButton26.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1750 */             ProvTarjetaDeudor.this.materialButton26ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1753 */     this.materialButton27.setBackground(this.lc.SECUNDARIO1);
/* 1754 */     this.materialButton27.setForeground(new Color(255, 255, 255));
/* 1755 */     this.materialButton27.setMnemonic('C');
/* 1756 */     this.materialButton27.setText("Cerrar");
/* 1757 */     this.materialButton27.setToolTipText("Cerrar (Alt+C)");
/* 1758 */     this.materialButton27.setFont(new Font("Cantarell", 0, 12));
/* 1759 */     this.materialButton27.setHorizontalTextPosition(0);
/* 1760 */     this.materialButton27.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1762 */             ProvTarjetaDeudor.this.materialButton27ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1765 */     this.jLabel8.setText(" Sumas:");
/* 1766 */     this.jLabel9.setFont(new Font("Dialog", 1, 11));
/* 1767 */     this.jLabel9.setText("jLabel9");
/* 1768 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1769 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1770 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout
/* 1771 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1772 */         .addComponent(this.jPanel16, -2, 0, 32767)
/* 1773 */         .addComponent(this.jPanel26, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 1774 */         .addComponent(this.jSeparator2)
/* 1775 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
/* 1776 */           .addComponent(this.jLabel8, -2, 68, -2)
/* 1777 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1778 */           .addComponent(this.jLabel9, -2, 158, -2)
/* 1779 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 1780 */           .addComponent((Component)this.materialButton26, -2, 150, -2)
/* 1781 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1782 */           .addComponent((Component)this.materialButton27, -2, 105, -2))
/* 1783 */         .addComponent(this.jPanel11, -1, -1, 32767));
/* 1784 */     jPanel10Layout.setVerticalGroup(jPanel10Layout
/* 1785 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1786 */         .addGroup(jPanel10Layout.createSequentialGroup()
/* 1787 */           .addComponent(this.jPanel11, -2, -1, -2)
/* 1788 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1789 */           .addComponent(this.jSeparator2, -2, 10, -2)
/* 1790 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1791 */           .addComponent(this.jPanel16, -2, 80, -2)
/* 1792 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1793 */           .addComponent(this.jPanel26, -2, -1, -2)
/* 1794 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1795 */           .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1796 */             .addComponent((Component)this.materialButton27, -2, 38, -2)
/* 1797 */             .addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1798 */               .addComponent((Component)this.materialButton26, -2, 38, -2)
/* 1799 */               .addComponent(this.jLabel8)
/* 1800 */               .addComponent(this.jLabel9)))));
/* 1801 */     GroupLayout jDialog3Layout = new GroupLayout(this.jDialog3.getContentPane());
/* 1802 */     this.jDialog3.getContentPane().setLayout(jDialog3Layout);
/* 1803 */     jDialog3Layout.setHorizontalGroup(jDialog3Layout
/* 1804 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1805 */         .addComponent(this.jPanel10, -1, -1, 32767));
/* 1806 */     jDialog3Layout.setVerticalGroup(jDialog3Layout
/* 1807 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1808 */         .addComponent(this.jPanel10, -2, -1, -2));
/* 1809 */     this.jDialog4.setTitle("Búsqueda de cheques");
/* 1810 */     this.jDialog4.setUndecorated(true);
/* 1811 */     this.jPanel136.setBorder(BorderFactory.createLineBorder(this.lc.SECUNDARIO1));
/* 1812 */     (new String[2])[0] = "Num"; (new String[2])[1] = "Tipo"; this.rSTableMetro3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[2]) {
/* 1813 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 1816 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 1819 */     this.rSTableMetro3.setAltoHead(25);
/* 1820 */     this.rSTableMetro3.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 1821 */     this.rSTableMetro3.setColorBordeFilas(new Color(200, 200, 200));
/* 1822 */     this.rSTableMetro3.setColorBordeHead(this.lc.PRIMARIO1);
/* 1823 */     this.rSTableMetro3.setColorFilasBackgound2(new Color(239, 239, 239));
/* 1824 */     this.rSTableMetro3.setColorFilasForeground1(new Color(102, 102, 102));
/* 1825 */     this.rSTableMetro3.setColorFilasForeground2(new Color(102, 102, 102));
/* 1826 */     this.rSTableMetro3.setColorSelBackgound(new Color(237, 107, 107));
/* 1827 */     this.rSTableMetro3.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 1828 */     this.rSTableMetro3.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 1829 */     this.rSTableMetro3.setFuenteHead(new Font("Cantarell", 1, 12));
/* 1830 */     this.rSTableMetro3.setGrosorBordeFilas(0);
/* 1831 */     this.rSTableMetro3.setSelectionBackground(this.lc.PRIMARIO2);
/* 1832 */     this.rSTableMetro3.setShowHorizontalLines(false);
/* 1833 */     this.rSTableMetro3.setShowVerticalLines(false);
/* 1834 */     this.rSTableMetro3.getTableHeader().setResizingAllowed(false);
/* 1835 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/* 1836 */     this.rSTableMetro3.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 1838 */             ProvTarjetaDeudor.this.rSTableMetro3MouseClicked(evt);
/*      */           }
/*      */         });
/* 1841 */     this.rSTableMetro3.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1843 */             ProvTarjetaDeudor.this.rSTableMetro3KeyReleased(evt);
/*      */           }
/*      */         });
/* 1846 */     this.jScrollPane33.setViewportView((Component)this.rSTableMetro3);
/* 1847 */     this.jButton53.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Add.png")));
/* 1848 */     this.jButton53.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1850 */             ProvTarjetaDeudor.this.jButton53ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1853 */     this.jLabel10.setText(" Buscar");
/* 1854 */     this.jTextField4.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 1856 */             ProvTarjetaDeudor.this.jTextField4KeyReleased(evt);
/*      */           }
/*      */         });
/* 1859 */     GroupLayout jPanel136Layout = new GroupLayout(this.jPanel136);
/* 1860 */     this.jPanel136.setLayout(jPanel136Layout);
/* 1861 */     jPanel136Layout.setHorizontalGroup(jPanel136Layout
/* 1862 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1863 */         .addComponent(this.jScrollPane33, -1, 416, 32767)
/* 1864 */         .addGroup(jPanel136Layout.createSequentialGroup()
/* 1865 */           .addComponent(this.jLabel10, -2, 70, -2)
/* 1866 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1867 */           .addComponent(this.jTextField4)
/* 1868 */           .addGap(154, 154, 154)
/* 1869 */           .addComponent(this.jButton53)
/* 1870 */           .addContainerGap()));
/* 1871 */     jPanel136Layout.setVerticalGroup(jPanel136Layout
/* 1872 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1873 */         .addGroup(jPanel136Layout.createSequentialGroup()
/* 1874 */           .addComponent(this.jScrollPane33, -1, 164, 32767)
/* 1875 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1876 */           .addGroup(jPanel136Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 1877 */             .addGroup(jPanel136Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1878 */               .addComponent(this.jLabel10)
/* 1879 */               .addComponent(this.jTextField4, -2, -1, -2))
/* 1880 */             .addComponent(this.jButton53, -2, 26, -2))
/* 1881 */           .addContainerGap()));
/* 1882 */     GroupLayout jDialog4Layout = new GroupLayout(this.jDialog4.getContentPane());
/* 1883 */     this.jDialog4.getContentPane().setLayout(jDialog4Layout);
/* 1884 */     jDialog4Layout.setHorizontalGroup(jDialog4Layout
/* 1885 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1886 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog4Layout.createSequentialGroup()
/* 1887 */           .addGap(0, 0, 0)
/* 1888 */           .addComponent(this.jPanel136, -1, -1, 32767)));
/* 1889 */     jDialog4Layout.setVerticalGroup(jDialog4Layout
/* 1890 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1891 */         .addGroup(jDialog4Layout.createSequentialGroup()
/* 1892 */           .addComponent(this.jPanel136, -1, -1, 32767)
/* 1893 */           .addGap(0, 0, 0)));
/* 1894 */     this.jDialog5.setTitle("Cantidad ");
/* 1895 */     this.jDialog5.setModal(true);
/* 1896 */     this.jLabel128.setHorizontalAlignment(4);
/* 1897 */     this.jLabel128.setText("Cantidad ");
/* 1898 */     this.jLabel129.setHorizontalAlignment(0);
/* 1899 */     this.jLabel129.setText("Ingresa la cantidad que deseas abonar");
/* 1900 */     this.importe3.setHorizontalAlignment(4);
/* 1901 */     this.importe3.setFont(new Font("Tahoma", 1, 14));
/* 1902 */     this.materialButton28.setBackground(this.lc.SECUNDARIO1);
/* 1903 */     this.materialButton28.setForeground(new Color(255, 255, 255));
/* 1904 */     this.materialButton28.setMnemonic('C');
/* 1905 */     this.materialButton28.setText("Cerrar");
/* 1906 */     this.materialButton28.setToolTipText("Cerrar (Alt+C)");
/* 1907 */     this.materialButton28.setFont(new Font("Cantarell", 0, 12));
/* 1908 */     this.materialButton28.setHorizontalTextPosition(0);
/* 1909 */     this.materialButton28.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1911 */             ProvTarjetaDeudor.this.materialButton28ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1914 */     this.materialButton29.setBackground(this.lc.PRIMARIO1);
/* 1915 */     this.materialButton29.setForeground(new Color(255, 255, 255));
/* 1916 */     this.materialButton29.setMnemonic('A');
/* 1917 */     this.materialButton29.setText("Abonar");
/* 1918 */     this.materialButton29.setToolTipText("Abonar (Alt+A)");
/* 1919 */     this.materialButton29.setFont(new Font("Cantarell", 0, 12));
/* 1920 */     this.materialButton29.setHorizontalTextPosition(0);
/* 1921 */     this.materialButton29.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 1923 */             ProvTarjetaDeudor.this.materialButton29ActionPerformed(evt);
/*      */           }
/*      */         });
/* 1926 */     GroupLayout jPanel35Layout = new GroupLayout(this.jPanel35);
/* 1927 */     this.jPanel35.setLayout(jPanel35Layout);
/* 1928 */     jPanel35Layout.setHorizontalGroup(jPanel35Layout
/* 1929 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1930 */         .addComponent(this.jLabel129, -1, -1, 32767)
/* 1931 */         .addGroup(jPanel35Layout.createSequentialGroup()
/* 1932 */           .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1933 */             .addGroup(jPanel35Layout.createSequentialGroup()
/* 1934 */               .addContainerGap()
/* 1935 */               .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1936 */                 .addComponent(this.jSeparator8)
/* 1937 */                 .addGroup(jPanel35Layout.createSequentialGroup()
/* 1938 */                   .addGap(0, 44, 32767)
/* 1939 */                   .addComponent((Component)this.materialButton29, -2, 150, -2)
/* 1940 */                   .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1941 */                   .addComponent((Component)this.materialButton28, -2, 105, -2))))
/* 1942 */             .addGroup(jPanel35Layout.createSequentialGroup()
/* 1943 */               .addComponent(this.jLabel128, -2, 72, -2)
/* 1944 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 1945 */               .addComponent(this.importe3)))
/* 1946 */           .addContainerGap()));
/* 1947 */     jPanel35Layout.setVerticalGroup(jPanel35Layout
/* 1948 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1949 */         .addGroup(jPanel35Layout.createSequentialGroup()
/* 1950 */           .addComponent(this.jLabel129)
/* 1951 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1952 */           .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1953 */             .addComponent(this.jLabel128)
/* 1954 */             .addComponent(this.importe3, -2, 33, -2))
/* 1955 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1956 */           .addComponent(this.jSeparator8, -2, 10, -2)
/* 1957 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 1958 */           .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 1959 */             .addComponent((Component)this.materialButton28, -2, 38, -2)
/* 1960 */             .addComponent((Component)this.materialButton29, -2, 38, -2))
/* 1961 */           .addContainerGap(15, 32767)));
/* 1962 */     GroupLayout jDialog5Layout = new GroupLayout(this.jDialog5.getContentPane());
/* 1963 */     this.jDialog5.getContentPane().setLayout(jDialog5Layout);
/* 1964 */     jDialog5Layout.setHorizontalGroup(jDialog5Layout
/* 1965 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1966 */         .addGroup(jDialog5Layout.createSequentialGroup()
/* 1967 */           .addComponent(this.jPanel35, -2, -1, -2)
/* 1968 */           .addGap(0, 0, 32767)));
/* 1969 */     jDialog5Layout.setVerticalGroup(jDialog5Layout
/* 1970 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 1971 */         .addComponent(this.jPanel35, -2, -1, -2));
/* 1972 */     this.jDialog6.setTitle("Cantidad ");
/* 1973 */     this.jDialog6.setModal(true);
/* 1974 */     this.jPanel5.setBorder(BorderFactory.createTitledBorder("Información del movimiento"));
/* 1975 */     GridBagLayout jPanel5Layout = new GridBagLayout();
/* 1976 */     jPanel5Layout.columnWidths = new int[] { 0, 5, 0, 5, 0 };
/* 1977 */     jPanel5Layout.rowHeights = new int[] { 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0 };
/*      */ 
/*      */     
/* 1980 */     this.jPanel5.setLayout(jPanel5Layout);
/* 1981 */     this.jLabel11.setText("Fecha");
/* 1982 */     gridBagConstraints = new GridBagConstraints();
/* 1983 */     gridBagConstraints.gridx = 0;
/* 1984 */     gridBagConstraints.gridy = 0;
/* 1985 */     gridBagConstraints.fill = 2;
/* 1986 */     gridBagConstraints.anchor = 17;
/* 1987 */     this.jPanel5.add(this.jLabel11, gridBagConstraints);
/* 1988 */     this.jTextField7.setEditable(false);
/* 1989 */     this.jTextField7.setText("jTextField7");
/* 1990 */     gridBagConstraints = new GridBagConstraints();
/* 1991 */     gridBagConstraints.gridx = 2;
/* 1992 */     gridBagConstraints.gridy = 0;
/* 1993 */     gridBagConstraints.fill = 2;
/* 1994 */     gridBagConstraints.weightx = 1.0D;
/* 1995 */     this.jPanel5.add(this.jTextField7, gridBagConstraints);
/* 1996 */     this.jLabel12.setText("Concepto");
/* 1997 */     gridBagConstraints = new GridBagConstraints();
/* 1998 */     gridBagConstraints.gridx = 0;
/* 1999 */     gridBagConstraints.gridy = 2;
/* 2000 */     gridBagConstraints.fill = 2;
/* 2001 */     gridBagConstraints.anchor = 17;
/* 2002 */     this.jPanel5.add(this.jLabel12, gridBagConstraints);
/* 2003 */     this.jTextField8.setEditable(false);
/* 2004 */     this.jTextField8.setText("jTextField8");
/* 2005 */     gridBagConstraints = new GridBagConstraints();
/* 2006 */     gridBagConstraints.gridx = 2;
/* 2007 */     gridBagConstraints.gridy = 2;
/* 2008 */     gridBagConstraints.fill = 2;
/* 2009 */     gridBagConstraints.weightx = 1.0D;
/* 2010 */     this.jPanel5.add(this.jTextField8, gridBagConstraints);
/* 2011 */     this.jLabel13.setText("Referencia");
/* 2012 */     gridBagConstraints = new GridBagConstraints();
/* 2013 */     gridBagConstraints.gridx = 0;
/* 2014 */     gridBagConstraints.gridy = 4;
/* 2015 */     gridBagConstraints.fill = 2;
/* 2016 */     gridBagConstraints.anchor = 17;
/* 2017 */     this.jPanel5.add(this.jLabel13, gridBagConstraints);
/* 2018 */     this.jTextField11.setEditable(false);
/* 2019 */     this.jTextField11.setText("jTextField11");
/* 2020 */     gridBagConstraints = new GridBagConstraints();
/* 2021 */     gridBagConstraints.gridx = 2;
/* 2022 */     gridBagConstraints.gridy = 4;
/* 2023 */     gridBagConstraints.fill = 2;
/* 2024 */     gridBagConstraints.weightx = 1.0D;
/* 2025 */     this.jPanel5.add(this.jTextField11, gridBagConstraints);
/* 2026 */     this.jLabel14.setText("Importe");
/* 2027 */     gridBagConstraints = new GridBagConstraints();
/* 2028 */     gridBagConstraints.gridx = 0;
/* 2029 */     gridBagConstraints.gridy = 6;
/* 2030 */     gridBagConstraints.fill = 2;
/* 2031 */     gridBagConstraints.anchor = 17;
/* 2032 */     this.jPanel5.add(this.jLabel14, gridBagConstraints);
/* 2033 */     this.jTextField12.setEditable(false);
/* 2034 */     this.jTextField12.setHorizontalAlignment(4);
/* 2035 */     this.jTextField12.setText("jTextField12");
/* 2036 */     gridBagConstraints = new GridBagConstraints();
/* 2037 */     gridBagConstraints.gridx = 2;
/* 2038 */     gridBagConstraints.gridy = 6;
/* 2039 */     gridBagConstraints.fill = 2;
/* 2040 */     gridBagConstraints.weightx = 1.0D;
/* 2041 */     this.jPanel5.add(this.jTextField12, gridBagConstraints);
/* 2042 */     this.jLabel15.setText("Debe");
/* 2043 */     gridBagConstraints = new GridBagConstraints();
/* 2044 */     gridBagConstraints.gridx = 0;
/* 2045 */     gridBagConstraints.gridy = 8;
/* 2046 */     gridBagConstraints.fill = 2;
/* 2047 */     gridBagConstraints.anchor = 17;
/* 2048 */     this.jPanel5.add(this.jLabel15, gridBagConstraints);
/* 2049 */     this.jTextField13.setEditable(false);
/* 2050 */     this.jTextField13.setHorizontalAlignment(4);
/* 2051 */     this.jTextField13.setText("jTextField13");
/* 2052 */     gridBagConstraints = new GridBagConstraints();
/* 2053 */     gridBagConstraints.gridx = 2;
/* 2054 */     gridBagConstraints.gridy = 8;
/* 2055 */     gridBagConstraints.fill = 2;
/* 2056 */     gridBagConstraints.weightx = 1.0D;
/* 2057 */     this.jPanel5.add(this.jTextField13, gridBagConstraints);
/* 2058 */     this.jPanel9.setBorder(BorderFactory.createTitledBorder("Relación de pagos"));
/* 2059 */     (new String[2])[0] = "Clave"; (new String[2])[1] = "Nombre Completo"; this.rSTableMetro8.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[2]) {
/* 2060 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2063 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2066 */     this.rSTableMetro8.setAltoHead(25);
/* 2067 */     this.rSTableMetro8.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 2068 */     this.rSTableMetro8.setColorBordeFilas(new Color(200, 200, 200));
/* 2069 */     this.rSTableMetro8.setColorBordeHead(this.lc.PRIMARIO1);
/* 2070 */     this.rSTableMetro8.setColorFilasBackgound2(new Color(239, 239, 239));
/* 2071 */     this.rSTableMetro8.setColorFilasForeground1(new Color(102, 102, 102));
/* 2072 */     this.rSTableMetro8.setColorFilasForeground2(new Color(102, 102, 102));
/* 2073 */     this.rSTableMetro8.setColorSelBackgound(new Color(237, 107, 107));
/* 2074 */     this.rSTableMetro8.setFont(new Font("Cantarell", 0, 10));
/* 2075 */     this.rSTableMetro8.setFuenteFilas(new Font("Cantarell", 0, 10));
/* 2076 */     this.rSTableMetro8.setFuenteFilasSelect(new Font("Cantarell", 0, 10));
/* 2077 */     this.rSTableMetro8.setFuenteHead(new Font("Cantarell", 1, 12));
/* 2078 */     this.rSTableMetro8.setGrosorBordeFilas(0);
/* 2079 */     this.rSTableMetro8.setRowHeight(18);
/* 2080 */     this.rSTableMetro8.setSelectionBackground(this.lc.PRIMARIO2);
/* 2081 */     this.rSTableMetro8.setShowHorizontalLines(false);
/* 2082 */     this.rSTableMetro8.setShowVerticalLines(false);
/* 2083 */     this.rSTableMetro8.getTableHeader().setResizingAllowed(false);
/* 2084 */     this.rSTableMetro8.getTableHeader().setReorderingAllowed(false);
/* 2085 */     this.rSTableMetro8.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2087 */             ProvTarjetaDeudor.this.rSTableMetro8MouseClicked(evt);
/*      */           }
/*      */         });
/* 2090 */     this.rSTableMetro8.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2092 */             ProvTarjetaDeudor.this.rSTableMetro8KeyReleased(evt);
/*      */           }
/*      */         });
/* 2095 */     this.jScrollPane19.setViewportView((Component)this.rSTableMetro8);
/* 2096 */     this.jLabel17.setFont(new Font("Dialog", 1, 13));
/* 2097 */     this.jLabel17.setHorizontalAlignment(4);
/* 2098 */     this.jLabel17.setText("jLabel17");
/* 2099 */     this.jLabel18.setHorizontalAlignment(4);
/* 2100 */     this.jLabel18.setText("Total:");
/* 2101 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/* 2102 */     this.jPanel9.setLayout(jPanel9Layout);
/* 2103 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout
/* 2104 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2105 */         .addComponent(this.jScrollPane19, -2, 0, 32767)
/* 2106 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
/* 2107 */           .addContainerGap(116, 32767)
/* 2108 */           .addComponent(this.jLabel18, -2, 163, -2)
/* 2109 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2110 */           .addComponent(this.jLabel17, -2, 104, -2)
/* 2111 */           .addContainerGap()));
/* 2112 */     jPanel9Layout.setVerticalGroup(jPanel9Layout
/* 2113 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2114 */         .addGroup(jPanel9Layout.createSequentialGroup()
/* 2115 */           .addComponent(this.jScrollPane19, -1, 132, 32767)
/* 2116 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2117 */           .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2118 */             .addComponent(this.jLabel17, -1, 27, 32767)
/* 2119 */             .addComponent(this.jLabel18, -1, -1, 32767))));
/* 2120 */     GroupLayout jPanel36Layout = new GroupLayout(this.jPanel36);
/* 2121 */     this.jPanel36.setLayout(jPanel36Layout);
/* 2122 */     jPanel36Layout.setHorizontalGroup(jPanel36Layout
/* 2123 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2124 */         .addComponent(this.jPanel5, -1, -1, 32767)
/* 2125 */         .addComponent(this.jPanel9, -1, -1, 32767));
/* 2126 */     jPanel36Layout.setVerticalGroup(jPanel36Layout
/* 2127 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2128 */         .addGroup(jPanel36Layout.createSequentialGroup()
/* 2129 */           .addComponent(this.jPanel5, -2, -1, -2)
/* 2130 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2131 */           .addComponent(this.jPanel9, -1, -1, 32767)
/* 2132 */           .addContainerGap()));
/* 2133 */     this.materialButton30.setBackground(this.lc.SECUNDARIO1);
/* 2134 */     this.materialButton30.setForeground(new Color(255, 255, 255));
/* 2135 */     this.materialButton30.setMnemonic('C');
/* 2136 */     this.materialButton30.setText("Cerrar");
/* 2137 */     this.materialButton30.setToolTipText("Cerrar (Alt+C)");
/* 2138 */     this.materialButton30.setFont(new Font("Cantarell", 0, 12));
/* 2139 */     this.materialButton30.setHorizontalTextPosition(0);
/* 2140 */     this.materialButton30.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2142 */             ProvTarjetaDeudor.this.materialButton30ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2145 */     GroupLayout jDialog6Layout = new GroupLayout(this.jDialog6.getContentPane());
/* 2146 */     this.jDialog6.getContentPane().setLayout(jDialog6Layout);
/* 2147 */     jDialog6Layout.setHorizontalGroup(jDialog6Layout
/* 2148 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2149 */         .addComponent(this.jPanel36, -1, -1, 32767)
/* 2150 */         .addGroup(jDialog6Layout.createSequentialGroup()
/* 2151 */           .addGap(0, 0, 32767)
/* 2152 */           .addComponent((Component)this.materialButton30, -2, 105, -2)));
/* 2153 */     jDialog6Layout.setVerticalGroup(jDialog6Layout
/* 2154 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2155 */         .addGroup(jDialog6Layout.createSequentialGroup()
/* 2156 */           .addComponent(this.jPanel36, -1, -1, 32767)
/* 2157 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2158 */           .addComponent((Component)this.materialButton30, -2, 38, -2)
/* 2159 */           .addContainerGap()));
/* 2160 */     this.jDialog7.setTitle("Vencido");
/* 2161 */     (new Object[4])[0] = null; (new Object[4])[1] = null; (new Object[4])[2] = null; (new Object[4])[3] = null; (new Object[4][])[0] = new Object[4]; (new Object[4])[0] = null; (new Object[4])[1] = null; (new Object[4])[2] = null; (new Object[4])[3] = null; (new Object[4][])[1] = new Object[4]; (new Object[4])[0] = null; (new Object[4])[1] = null; (new Object[4])[2] = null; (new Object[4])[3] = null; (new Object[4][])[2] = new Object[4]; (new Object[4])[0] = null; (new Object[4])[1] = null; (new Object[4])[2] = null; (new Object[4])[3] = null; (new Object[4][])[3] = new Object[4]; (new String[4])[0] = "Title 1"; (new String[4])[1] = "Title 2"; (new String[4])[2] = "Title 3"; (new String[4])[3] = "Title 4"; this.TablaGral.setModel(new DefaultTableModel(new Object[4][], (Object[])new String[4]));
/* 2162 */     this.jScrollPane2.setViewportView(this.TablaGral);
/* 2163 */     this.jLabel60.setText("Vencido");
/* 2164 */     this.jLabel61.setText("jLabel61");
/* 2165 */     GroupLayout jDialog7Layout = new GroupLayout(this.jDialog7.getContentPane());
/* 2166 */     this.jDialog7.getContentPane().setLayout(jDialog7Layout);
/* 2167 */     jDialog7Layout.setHorizontalGroup(jDialog7Layout
/* 2168 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2169 */         .addGroup(jDialog7Layout.createSequentialGroup()
/* 2170 */           .addGroup(jDialog7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2171 */             .addGroup(jDialog7Layout.createSequentialGroup()
/* 2172 */               .addContainerGap()
/* 2173 */               .addComponent(this.jScrollPane2, -1, 819, 32767))
/* 2174 */             .addGroup(jDialog7Layout.createSequentialGroup()
/* 2175 */               .addGroup(jDialog7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2176 */                 .addGroup(jDialog7Layout.createSequentialGroup()
/* 2177 */                   .addGap(148, 148, 148)
/* 2178 */                   .addComponent(this.jLabel60, -2, 272, -2))
/* 2179 */                 .addGroup(jDialog7Layout.createSequentialGroup()
/* 2180 */                   .addContainerGap()
/* 2181 */                   .addComponent(this.jLabel61, -2, 219, -2)))
/* 2182 */               .addGap(0, 0, 32767)))
/* 2183 */           .addContainerGap()));
/* 2184 */     jDialog7Layout.setVerticalGroup(jDialog7Layout
/* 2185 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2186 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog7Layout.createSequentialGroup()
/* 2187 */           .addContainerGap()
/* 2188 */           .addComponent(this.jLabel60)
/* 2189 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2190 */           .addComponent(this.jScrollPane2, -1, 450, 32767)
/* 2191 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2192 */           .addComponent(this.jLabel61)
/* 2193 */           .addContainerGap()));
/* 2194 */     this.jDialog8.setTitle("Por Vencer");
/* 2195 */     (new Object[4])[0] = null; (new Object[4])[1] = null; (new Object[4])[2] = null; (new Object[4])[3] = null; (new Object[4][])[0] = new Object[4]; (new Object[4])[0] = null; (new Object[4])[1] = null; (new Object[4])[2] = null; (new Object[4])[3] = null; (new Object[4][])[1] = new Object[4]; (new Object[4])[0] = null; (new Object[4])[1] = null; (new Object[4])[2] = null; (new Object[4])[3] = null; (new Object[4][])[2] = new Object[4]; (new Object[4])[0] = null; (new Object[4])[1] = null; (new Object[4])[2] = null; (new Object[4])[3] = null; (new Object[4][])[3] = new Object[4]; (new String[4])[0] = "Title 1"; (new String[4])[1] = "Title 2"; (new String[4])[2] = "Title 3"; (new String[4])[3] = "Title 4"; this.TablaGral1.setModel(new DefaultTableModel(new Object[4][], (Object[])new String[4]));
/* 2196 */     this.jScrollPane3.setViewportView(this.TablaGral1);
/* 2197 */     this.jLabel63.setText("Por Vencer");
/* 2198 */     this.jLabel64.setText("jLabel64");
/* 2199 */     GroupLayout jDialog8Layout = new GroupLayout(this.jDialog8.getContentPane());
/* 2200 */     this.jDialog8.getContentPane().setLayout(jDialog8Layout);
/* 2201 */     jDialog8Layout.setHorizontalGroup(jDialog8Layout
/* 2202 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2203 */         .addGroup(jDialog8Layout.createSequentialGroup()
/* 2204 */           .addGroup(jDialog8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2205 */             .addGroup(jDialog8Layout.createSequentialGroup()
/* 2206 */               .addContainerGap()
/* 2207 */               .addComponent(this.jScrollPane3, -1, 819, 32767))
/* 2208 */             .addGroup(jDialog8Layout.createSequentialGroup()
/* 2209 */               .addGroup(jDialog8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2210 */                 .addGroup(jDialog8Layout.createSequentialGroup()
/* 2211 */                   .addGap(148, 148, 148)
/* 2212 */                   .addComponent(this.jLabel63, -2, 272, -2))
/* 2213 */                 .addGroup(jDialog8Layout.createSequentialGroup()
/* 2214 */                   .addContainerGap()
/* 2215 */                   .addComponent(this.jLabel64, -2, 216, -2)))
/* 2216 */               .addGap(0, 0, 32767)))
/* 2217 */           .addContainerGap()));
/* 2218 */     jDialog8Layout.setVerticalGroup(jDialog8Layout
/* 2219 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2220 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog8Layout.createSequentialGroup()
/* 2221 */           .addContainerGap()
/* 2222 */           .addComponent(this.jLabel63)
/* 2223 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2224 */           .addComponent(this.jScrollPane3, -1, 450, 32767)
/* 2225 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2226 */           .addComponent(this.jLabel64)
/* 2227 */           .addContainerGap()));
/* 2228 */     this.jDialog9.setTitle("Resumen");
/* 2229 */     (new Object[4])[0] = null; (new Object[4])[1] = null; (new Object[4])[2] = null; (new Object[4])[3] = null; (new Object[4][])[0] = new Object[4]; (new Object[4])[0] = null; (new Object[4])[1] = null; (new Object[4])[2] = null; (new Object[4])[3] = null; (new Object[4][])[1] = new Object[4]; (new Object[4])[0] = null; (new Object[4])[1] = null; (new Object[4])[2] = null; (new Object[4])[3] = null; (new Object[4][])[2] = new Object[4]; (new Object[4])[0] = null; (new Object[4])[1] = null; (new Object[4])[2] = null; (new Object[4])[3] = null; (new Object[4][])[3] = new Object[4]; (new String[4])[0] = "Title 1"; (new String[4])[1] = "Title 2"; (new String[4])[2] = "Title 3"; (new String[4])[3] = "Title 4"; this.TablaAux.setModel(new DefaultTableModel(new Object[4][], (Object[])new String[4]));
/* 2230 */     this.jScrollPane6.setViewportView(this.TablaAux);
/* 2231 */     this.jLabel68.setText("Todos");
/* 2232 */     this.jLabel69.setFont(new Font("Dialog", 0, 11));
/* 2233 */     this.jLabel69.setText("jLabel69");
/* 2234 */     this.jLabel72.setFont(new Font("Dialog", 0, 11));
/* 2235 */     this.jLabel72.setHorizontalAlignment(4);
/* 2236 */     this.jLabel72.setText("jLabel72");
/* 2237 */     this.jLabel82.setFont(new Font("Dialog", 0, 11));
/* 2238 */     this.jLabel82.setHorizontalAlignment(4);
/* 2239 */     this.jLabel82.setText("jLabel82");
/* 2240 */     this.jLabel83.setFont(new Font("Dialog", 0, 11));
/* 2241 */     this.jLabel83.setHorizontalAlignment(4);
/* 2242 */     this.jLabel83.setText("jLabel83");
/* 2243 */     this.jLabel19.setFont(new Font("Dialog", 0, 11));
/* 2244 */     this.jLabel19.setHorizontalAlignment(4);
/* 2245 */     this.jLabel19.setText("jLabel19");
/* 2246 */     this.jLabel20.setFont(new Font("Dialog", 0, 11));
/* 2247 */     this.jLabel20.setHorizontalAlignment(4);
/* 2248 */     this.jLabel20.setText("jLabel20");
/* 2249 */     GroupLayout jDialog9Layout = new GroupLayout(this.jDialog9.getContentPane());
/* 2250 */     this.jDialog9.getContentPane().setLayout(jDialog9Layout);
/* 2251 */     jDialog9Layout.setHorizontalGroup(jDialog9Layout
/* 2252 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2253 */         .addGroup(jDialog9Layout.createSequentialGroup()
/* 2254 */           .addContainerGap()
/* 2255 */           .addGroup(jDialog9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2256 */             .addGroup(jDialog9Layout.createSequentialGroup()
/* 2257 */               .addGroup(jDialog9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2258 */                 .addComponent(this.jScrollPane6)
/* 2259 */                 .addGroup(jDialog9Layout.createSequentialGroup()
/* 2260 */                   .addComponent(this.jLabel68, -2, 272, -2)
/* 2261 */                   .addGap(0, 0, 32767)))
/* 2262 */               .addContainerGap())
/* 2263 */             .addGroup(jDialog9Layout.createSequentialGroup()
/* 2264 */               .addComponent(this.jLabel69, -2, 130, -2)
/* 2265 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2266 */               .addComponent(this.jLabel72, -2, 154, -2)
/* 2267 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2268 */               .addComponent(this.jLabel82, -2, 169, -2)
/* 2269 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2270 */               .addComponent(this.jLabel83, -2, 163, -2)
/* 2271 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2272 */               .addComponent(this.jLabel19, -2, 134, -2)
/* 2273 */               .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2274 */               .addComponent(this.jLabel20, -1, 170, 32767)))));
/* 2275 */     jDialog9Layout.setVerticalGroup(jDialog9Layout
/* 2276 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2277 */         .addGroup(GroupLayout.Alignment.TRAILING, jDialog9Layout.createSequentialGroup()
/* 2278 */           .addContainerGap()
/* 2279 */           .addComponent(this.jLabel68)
/* 2280 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2281 */           .addComponent(this.jScrollPane6, -1, 451, 32767)
/* 2282 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2283 */           .addGroup(jDialog9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2284 */             .addComponent(this.jLabel69)
/* 2285 */             .addComponent(this.jLabel72)
/* 2286 */             .addComponent(this.jLabel82)
/* 2287 */             .addComponent(this.jLabel83)
/* 2288 */             .addComponent(this.jLabel19)
/* 2289 */             .addComponent(this.jLabel20))
/* 2290 */           .addContainerGap()));
/* 2291 */     this.jDialog10.setTitle("Fecha de corte");
/* 2292 */     this.jDialog10.setModal(true);
/* 2293 */     this.jLabel16.setFont(new Font("Cantarell", 0, 11));
/* 2294 */     this.jLabel16.setText("Selecciona la fecha de corte");
/* 2295 */     this.jDateChooser9.setDate(this.fechaActual);
/* 2296 */     this.jDateChooser9.setDateFormatString("dd/MM/yyyy");
/* 2297 */     this.jDateChooser9.setIcon(this.icon);
/* 2298 */     this.jDateChooser9.setMaxSelectableDate(this.fecha);
/* 2299 */     this.jDateChooser9.setMinSelectableDate(this.fechaInicio);
/* 2300 */     this.materialButton18.setBackground(this.lc.SECUNDARIO1);
/* 2301 */     this.materialButton18.setForeground(new Color(255, 255, 255));
/* 2302 */     this.materialButton18.setMnemonic('C');
/* 2303 */     this.materialButton18.setText("Cerrar");
/* 2304 */     this.materialButton18.setToolTipText("Cerrar (Alt+C)");
/* 2305 */     this.materialButton18.setFont(new Font("Cantarell", 0, 12));
/* 2306 */     this.materialButton18.setHorizontalTextPosition(0);
/* 2307 */     this.materialButton18.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2309 */             ProvTarjetaDeudor.this.materialButton18ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2312 */     this.materialButton17.setBackground(this.lc.PRIMARIO1);
/* 2313 */     this.materialButton17.setForeground(new Color(255, 255, 255));
/* 2314 */     this.materialButton17.setMnemonic('A');
/* 2315 */     this.materialButton17.setText("Aceptar");
/* 2316 */     this.materialButton17.setToolTipText("Aceptar (Alt+A)");
/* 2317 */     this.materialButton17.setFont(new Font("Cantarell", 0, 12));
/* 2318 */     this.materialButton17.setHorizontalTextPosition(0);
/* 2319 */     this.materialButton17.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2321 */             ProvTarjetaDeudor.this.materialButton17ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2324 */     this.jLabel43.setFont(new Font("Cantarell", 0, 11));
/* 2325 */     this.jLabel43.setText("Selecciona el tipo de moneda");
/* 2326 */     this.jComboBox12.setBackground(new Color(244, 244, 244));
/* 2327 */     this.jComboBox12.setModel(new DefaultComboBoxModel<>(new String[] { "Moneda" }));
/* 2328 */     this.jComboBox12.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2330 */             ProvTarjetaDeudor.this.jComboBox12ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2333 */     GroupLayout jDialog10Layout = new GroupLayout(this.jDialog10.getContentPane());
/* 2334 */     this.jDialog10.getContentPane().setLayout(jDialog10Layout);
/* 2335 */     jDialog10Layout.setHorizontalGroup(jDialog10Layout
/* 2336 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2337 */         .addGroup(jDialog10Layout.createSequentialGroup()
/* 2338 */           .addContainerGap()
/* 2339 */           .addGroup(jDialog10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2340 */             .addGroup(jDialog10Layout.createSequentialGroup()
/* 2341 */               .addComponent((Component)this.materialButton17, -2, 150, -2)
/* 2342 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2343 */               .addComponent((Component)this.materialButton18, -2, 105, -2))
/* 2344 */             .addGroup(jDialog10Layout.createSequentialGroup()
/* 2345 */               .addGroup(jDialog10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2346 */                 .addComponent(this.jLabel43, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2347 */                 .addComponent(this.jLabel16, GroupLayout.Alignment.LEADING, -1, -1, 32767))
/* 2348 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2349 */               .addGroup(jDialog10Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2350 */                 .addComponent((Component)this.jDateChooser9, -1, 205, 32767)
/* 2351 */                 .addComponent(this.jComboBox12, 0, -1, 32767))))
/* 2352 */           .addContainerGap(-1, 32767)));
/* 2353 */     jDialog10Layout.setVerticalGroup(jDialog10Layout
/* 2354 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2355 */         .addGroup(jDialog10Layout.createSequentialGroup()
/* 2356 */           .addContainerGap()
/* 2357 */           .addGroup(jDialog10Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2358 */             .addComponent((Component)this.jDateChooser9, -1, -1, 32767)
/* 2359 */             .addComponent(this.jLabel16, -1, -1, 32767))
/* 2360 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2361 */           .addGroup(jDialog10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2362 */             .addComponent(this.jLabel43)
/* 2363 */             .addComponent(this.jComboBox12, -2, 26, -2))
/* 2364 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2365 */           .addGroup(jDialog10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2366 */             .addComponent((Component)this.materialButton18, -2, 38, -2)
/* 2367 */             .addComponent((Component)this.materialButton17, -2, 38, -2))
/* 2368 */           .addContainerGap(13, 32767)));
/* 2369 */     this.jDialog11.setTitle("Imprimir estado de cuenta");
/* 2370 */     this.jDialog11.setModal(true);
/* 2371 */     this.jPanel37.setLayout(new GridBagLayout());
/* 2372 */     this.jRadioButton3.setFont(new Font("Cantarell", 0, 11));
/* 2373 */     this.jRadioButton3.setText("Todo");
/* 2374 */     this.jRadioButton3.setEnabled(false);
/* 2375 */     this.jRadioButton3.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2377 */             ProvTarjetaDeudor.this.jRadioButton3ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2380 */     gridBagConstraints = new GridBagConstraints();
/* 2381 */     gridBagConstraints.gridx = 0;
/* 2382 */     gridBagConstraints.gridy = 4;
/* 2383 */     gridBagConstraints.anchor = 17;
/* 2384 */     gridBagConstraints.weightx = 1.0D;
/* 2385 */     this.jPanel37.add(this.jRadioButton3, gridBagConstraints);
/* 2386 */     this.jRadioButton4.setFont(new Font("Cantarell", 0, 11));
/* 2387 */     this.jRadioButton4.setText("Reporte de Saldos Individual");
/* 2388 */     this.jRadioButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2390 */             ProvTarjetaDeudor.this.jRadioButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2393 */     gridBagConstraints = new GridBagConstraints();
/* 2394 */     gridBagConstraints.gridx = 0;
/* 2395 */     gridBagConstraints.gridy = 0;
/* 2396 */     gridBagConstraints.anchor = 17;
/* 2397 */     gridBagConstraints.weightx = 1.0D;
/* 2398 */     this.jPanel37.add(this.jRadioButton4, gridBagConstraints);
/* 2399 */     this.jLabel85.setFont(new Font("Cantarell", 0, 11));
/* 2400 */     this.jLabel85.setForeground(this.lc.PRIMARIO2);
/* 2401 */     this.jLabel85.setText("Imprime todo lo que se muestra en pantalla");
/* 2402 */     this.jLabel85.setEnabled(false);
/* 2403 */     gridBagConstraints = new GridBagConstraints();
/* 2404 */     gridBagConstraints.gridx = 2;
/* 2405 */     gridBagConstraints.gridy = 4;
/* 2406 */     gridBagConstraints.anchor = 17;
/* 2407 */     this.jPanel37.add(this.jLabel85, gridBagConstraints);
/* 2408 */     this.jLabel94.setFont(new Font("Cantarell", 0, 11));
/* 2409 */     this.jLabel94.setForeground(this.lc.PRIMARIO2);
/* 2410 */     this.jLabel94.setText("Genera un reporte separado por condiciones de pago");
/* 2411 */     gridBagConstraints = new GridBagConstraints();
/* 2412 */     gridBagConstraints.gridx = 2;
/* 2413 */     gridBagConstraints.gridy = 0;
/* 2414 */     gridBagConstraints.anchor = 17;
/* 2415 */     this.jPanel37.add(this.jLabel94, gridBagConstraints);
/* 2416 */     this.jDateChooser1.setDate(this.fechaActual);
/* 2417 */     this.jDateChooser1.setDateFormatString("dd/MM/yyyy");
/* 2418 */     this.jDateChooser1.setIcon(this.icon);
/* 2419 */     this.jDateChooser1.setMaxSelectableDate(this.fechaActual);
/* 2420 */     gridBagConstraints = new GridBagConstraints();
/* 2421 */     gridBagConstraints.gridx = 0;
/* 2422 */     gridBagConstraints.gridy = 2;
/* 2423 */     gridBagConstraints.fill = 2;
/* 2424 */     gridBagConstraints.insets = new Insets(0, 26, 0, 14);
/* 2425 */     this.jPanel37.add((Component)this.jDateChooser1, gridBagConstraints);
/* 2426 */     this.jLabel42.setFont(new Font("Cantarell", 0, 11));
/* 2427 */     this.jLabel42.setForeground(this.lc.PRIMARIO2);
/* 2428 */     this.jLabel42.setText("Fecha de corte");
/* 2429 */     gridBagConstraints = new GridBagConstraints();
/* 2430 */     gridBagConstraints.gridx = 2;
/* 2431 */     gridBagConstraints.gridy = 2;
/* 2432 */     gridBagConstraints.fill = 2;
/* 2433 */     gridBagConstraints.anchor = 17;
/* 2434 */     this.jPanel37.add(this.jLabel42, gridBagConstraints);
/* 2435 */     this.materialButton31.setBackground(this.lc.SECUNDARIO1);
/* 2436 */     this.materialButton31.setForeground(new Color(255, 255, 255));
/* 2437 */     this.materialButton31.setMnemonic('C');
/* 2438 */     this.materialButton31.setText("Cerrar");
/* 2439 */     this.materialButton31.setToolTipText("Cerrar (Alt+C)");
/* 2440 */     this.materialButton31.setFont(new Font("Cantarell", 0, 12));
/* 2441 */     this.materialButton31.setHorizontalTextPosition(0);
/* 2442 */     this.materialButton31.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2444 */             ProvTarjetaDeudor.this.materialButton31ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2447 */     this.materialButton19.setBackground(this.lc.PRIMARIO1);
/* 2448 */     this.materialButton19.setForeground(new Color(255, 255, 255));
/* 2449 */     this.materialButton19.setMnemonic('A');
/* 2450 */     this.materialButton19.setText("Aceptar");
/* 2451 */     this.materialButton19.setToolTipText("Aceptar (Alt+A)");
/* 2452 */     this.materialButton19.setFont(new Font("Cantarell", 0, 12));
/* 2453 */     this.materialButton19.setHorizontalTextPosition(0);
/* 2454 */     this.materialButton19.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2456 */             ProvTarjetaDeudor.this.materialButton19ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2459 */     GroupLayout jDialog11Layout = new GroupLayout(this.jDialog11.getContentPane());
/* 2460 */     this.jDialog11.getContentPane().setLayout(jDialog11Layout);
/* 2461 */     jDialog11Layout.setHorizontalGroup(jDialog11Layout
/* 2462 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2463 */         .addComponent(this.jPanel37, -1, 508, 32767)
/* 2464 */         .addGroup(jDialog11Layout.createSequentialGroup()
/* 2465 */           .addGap(0, 0, 32767)
/* 2466 */           .addComponent((Component)this.materialButton19, -2, 150, -2)
/* 2467 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2468 */           .addComponent((Component)this.materialButton31, -2, 105, -2)));
/* 2469 */     jDialog11Layout.setVerticalGroup(jDialog11Layout
/* 2470 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2471 */         .addGroup(jDialog11Layout.createSequentialGroup()
/* 2472 */           .addComponent(this.jPanel37, -2, 119, -2)
/* 2473 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2474 */           .addGroup(jDialog11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2475 */             .addComponent((Component)this.materialButton31, -2, 38, -2)
/* 2476 */             .addComponent((Component)this.materialButton19, -2, 38, -2))
/* 2477 */           .addContainerGap(-1, 32767)));
/* 2478 */     this.jDialog12.setTitle("Tipo de reporte");
/* 2479 */     this.jDialog12.setModal(true);
/* 2480 */     this.materialButton20.setBackground(this.lc.SECUNDARIO1);
/* 2481 */     this.materialButton20.setForeground(new Color(255, 255, 255));
/* 2482 */     this.materialButton20.setMnemonic('C');
/* 2483 */     this.materialButton20.setText("Cerrar");
/* 2484 */     this.materialButton20.setToolTipText("Cerrar (Alt+C)");
/* 2485 */     this.materialButton20.setFont(new Font("Cantarell", 0, 12));
/* 2486 */     this.materialButton20.setHorizontalTextPosition(0);
/* 2487 */     this.materialButton20.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2489 */             ProvTarjetaDeudor.this.materialButton20ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2492 */     this.materialButton32.setBackground(this.lc.PRIMARIO1);
/* 2493 */     this.materialButton32.setForeground(new Color(255, 255, 255));
/* 2494 */     this.materialButton32.setMnemonic('A');
/* 2495 */     this.materialButton32.setText("Aceptar");
/* 2496 */     this.materialButton32.setToolTipText("Aceptar (Alt+A)");
/* 2497 */     this.materialButton32.setFont(new Font("Cantarell", 0, 12));
/* 2498 */     this.materialButton32.setHorizontalTextPosition(0);
/* 2499 */     this.materialButton32.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2501 */             ProvTarjetaDeudor.this.materialButton32ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2504 */     this.jRadioButton5.setText("Reporte de cuentas por pagar (por Mes)");
/* 2505 */     this.jRadioButton6.setText("Reporte de cuentas por pagar (por Año)");
/* 2506 */     this.jRadioButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2508 */             ProvTarjetaDeudor.this.jRadioButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2511 */     GroupLayout jDialog12Layout = new GroupLayout(this.jDialog12.getContentPane());
/* 2512 */     this.jDialog12.getContentPane().setLayout(jDialog12Layout);
/* 2513 */     jDialog12Layout.setHorizontalGroup(jDialog12Layout
/* 2514 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2515 */         .addGroup(jDialog12Layout.createSequentialGroup()
/* 2516 */           .addGroup(jDialog12Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2517 */             .addGroup(jDialog12Layout.createSequentialGroup()
/* 2518 */               .addGap(96, 96, 96)
/* 2519 */               .addComponent((Component)this.materialButton32, -2, 150, -2)
/* 2520 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2521 */               .addComponent((Component)this.materialButton20, -2, 105, -2)
/* 2522 */               .addGap(0, 0, 32767))
/* 2523 */             .addComponent(this.jRadioButton6, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 2524 */             .addComponent(this.jRadioButton5, GroupLayout.Alignment.TRAILING, -1, -1, 32767))
/* 2525 */           .addContainerGap()));
/* 2526 */     jDialog12Layout.setVerticalGroup(jDialog12Layout
/* 2527 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2528 */         .addGroup(jDialog12Layout.createSequentialGroup()
/* 2529 */           .addComponent(this.jRadioButton5)
/* 2530 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2531 */           .addComponent(this.jRadioButton6)
/* 2532 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2533 */           .addGroup(jDialog12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2534 */             .addComponent((Component)this.materialButton20, -2, 38, -2)
/* 2535 */             .addComponent((Component)this.materialButton32, -2, 38, -2))
/* 2536 */           .addContainerGap(26, 32767)));
/* 2537 */     this.jDialog13.setTitle("Selecciona el periodo");
/* 2538 */     this.jDialog13.setModal(true);
/* 2539 */     this.materialButton34.setBackground(this.lc.PRIMARIO1);
/* 2540 */     this.materialButton34.setForeground(new Color(255, 255, 255));
/* 2541 */     this.materialButton34.setMnemonic('A');
/* 2542 */     this.materialButton34.setText("Aceptar");
/* 2543 */     this.materialButton34.setToolTipText("Aceptar (Alt+A)");
/* 2544 */     this.materialButton34.setFont(new Font("Cantarell", 0, 12));
/* 2545 */     this.materialButton34.setHorizontalTextPosition(0);
/* 2546 */     this.materialButton34.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2548 */             ProvTarjetaDeudor.this.materialButton34ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2551 */     this.materialButton33.setBackground(this.lc.SECUNDARIO1);
/* 2552 */     this.materialButton33.setForeground(new Color(255, 255, 255));
/* 2553 */     this.materialButton33.setMnemonic('C');
/* 2554 */     this.materialButton33.setText("Cerrar");
/* 2555 */     this.materialButton33.setToolTipText("Cerrar (Alt+C)");
/* 2556 */     this.materialButton33.setFont(new Font("Cantarell", 0, 12));
/* 2557 */     this.materialButton33.setHorizontalTextPosition(0);
/* 2558 */     this.materialButton33.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2560 */             ProvTarjetaDeudor.this.materialButton33ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2563 */     this.jLabel53.setFont(new Font("Cantarell", 0, 11));
/* 2564 */     this.jLabel53.setText("Pediodo");
/* 2565 */     this.jLabel54.setFont(new Font("Cantarell", 0, 11));
/* 2566 */     this.jLabel54.setText("Año");
/* 2567 */     this.jSpinner1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2568 */     (new String[2])[0] = "2018"; (new String[2])[1] = "2019"; this.jSpinner1.setModel(new SpinnerListModel((Object[])new String[2]));
/* 2569 */     this.jComboBox8.setBackground(new Color(244, 244, 244));
/* 2570 */     this.jComboBox8.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2571 */     this.jComboBox8.setModel(new DefaultComboBoxModel<>(new String[] { "TODO EL AÑO", "ENERO - JUNIO", "JULIO - DICIEMBRE" }));
/* 2572 */     this.jComboBox8.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2574 */             ProvTarjetaDeudor.this.jComboBox8ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2577 */     GroupLayout jPanel38Layout = new GroupLayout(this.jPanel38);
/* 2578 */     this.jPanel38.setLayout(jPanel38Layout);
/* 2579 */     jPanel38Layout.setHorizontalGroup(jPanel38Layout
/* 2580 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2581 */         .addGroup(jPanel38Layout.createSequentialGroup()
/* 2582 */           .addContainerGap()
/* 2583 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2584 */             .addGroup(jPanel38Layout.createSequentialGroup()
/* 2585 */               .addComponent((Component)this.materialButton34, -2, 150, -2)
/* 2586 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2587 */               .addComponent((Component)this.materialButton33, -2, 105, -2))
/* 2588 */             .addGroup(jPanel38Layout.createSequentialGroup()
/* 2589 */               .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
/* 2590 */                 .addComponent(this.jLabel54, GroupLayout.Alignment.LEADING, -1, -1, 32767)
/* 2591 */                 .addComponent(this.jLabel53, GroupLayout.Alignment.LEADING, -1, 94, 32767))
/* 2592 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2593 */               .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2594 */                 .addComponent(this.jSpinner1)
/* 2595 */                 .addComponent(this.jComboBox8, 0, 202, 32767))))
/* 2596 */           .addContainerGap(15, 32767)));
/* 2597 */     jPanel38Layout.setVerticalGroup(jPanel38Layout
/* 2598 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2599 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
/* 2600 */           .addContainerGap(-1, 32767)
/* 2601 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2602 */             .addComponent(this.jLabel53)
/* 2603 */             .addComponent(this.jComboBox8, -2, -1, -2))
/* 2604 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2605 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2606 */             .addComponent(this.jLabel54)
/* 2607 */             .addComponent(this.jSpinner1, -2, -1, -2))
/* 2608 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2609 */           .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2610 */             .addComponent((Component)this.materialButton33, -2, 38, -2)
/* 2611 */             .addComponent((Component)this.materialButton34, -2, 38, -2))));
/* 2612 */     GroupLayout jDialog13Layout = new GroupLayout(this.jDialog13.getContentPane());
/* 2613 */     this.jDialog13.getContentPane().setLayout(jDialog13Layout);
/* 2614 */     jDialog13Layout.setHorizontalGroup(jDialog13Layout
/* 2615 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2616 */         .addComponent(this.jPanel38, -1, -1, 32767));
/* 2617 */     jDialog13Layout.setVerticalGroup(jDialog13Layout
/* 2618 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2619 */         .addComponent(this.jPanel38, -1, -1, 32767));
/* 2620 */     this.jDialog14.setTitle("Selecciona el periodo");
/* 2621 */     this.jDialog14.setModal(true);
/* 2622 */     this.jLabel21.setFont(new Font("Tahoma", 1, 16));
/* 2623 */     this.jLabel21.setHorizontalAlignment(0);
/* 2624 */     this.jLabel21.setText("REPORTE DE TARJETAS DEUDOR");
/* 2625 */     this.jTable3.setFont(new Font("Tahoma", 0, 9));
/* 2626 */     (new String[10])[0] = "Clave"; (new String[10])[1] = "Nombre"; (new String[10])[2] = "Tipo"; (new String[10])[3] = "Estatus"; (new String[10])[4] = "ENE"; (new String[10])[5] = "FEB"; (new String[10])[6] = "MAR"; (new String[10])[7] = "ABR"; (new String[10])[8] = "MAY"; (new String[10])[9] = "JUN"; this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[10]));
/* 2627 */     this.jScrollPane5.setViewportView(this.jTable3);
/* 2628 */     this.jButton6.setText("Cerrar");
/* 2629 */     this.jButton6.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2631 */             ProvTarjetaDeudor.this.jButton6ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2634 */     this.jLabel22.setText("Registros encontrados:");
/* 2635 */     this.jLabel23.setFont(new Font("Tahoma", 1, 12));
/* 2636 */     this.jLabel23.setText("jLabel8");
/* 2637 */     this.jLabel24.setHorizontalAlignment(4);
/* 2638 */     this.jLabel24.setText("Año:");
/* 2639 */     this.jLabel25.setFont(new Font("Tahoma", 1, 12));
/* 2640 */     this.jLabel25.setHorizontalAlignment(4);
/* 2641 */     this.jLabel25.setText("2013");
/* 2642 */     GroupLayout jPanel39Layout = new GroupLayout(this.jPanel39);
/* 2643 */     this.jPanel39.setLayout(jPanel39Layout);
/* 2644 */     jPanel39Layout.setHorizontalGroup(jPanel39Layout
/* 2645 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2646 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
/* 2647 */           .addContainerGap()
/* 2648 */           .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/* 2649 */             .addComponent(this.jScrollPane5, GroupLayout.Alignment.LEADING, -1, 823, 32767)
/* 2650 */             .addComponent(this.jLabel21, GroupLayout.Alignment.LEADING, -1, 823, 32767)
/* 2651 */             .addComponent(this.jSeparator3, -1, 823, 32767)
/* 2652 */             .addGroup(GroupLayout.Alignment.LEADING, jPanel39Layout.createSequentialGroup()
/* 2653 */               .addComponent(this.jLabel22, -2, 156, -2)
/* 2654 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2655 */               .addComponent(this.jLabel23, -2, 71, -2)
/* 2656 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2657 */               .addComponent(this.jLabel24, -2, 63, -2)
/* 2658 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2659 */               .addComponent(this.jLabel25, -2, 84, -2))
/* 2660 */             .addGroup(jPanel39Layout.createSequentialGroup()
/* 2661 */               .addGap(0, 0, 32767)
/* 2662 */               .addComponent(this.jButton6, -2, 100, -2)))
/* 2663 */           .addContainerGap()));
/* 2664 */     jPanel39Layout.setVerticalGroup(jPanel39Layout
/* 2665 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2666 */         .addGroup(jPanel39Layout.createSequentialGroup()
/* 2667 */           .addComponent(this.jLabel21)
/* 2668 */           .addGap(9, 9, 9)
/* 2669 */           .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 2670 */             .addComponent(this.jLabel22)
/* 2671 */             .addComponent(this.jLabel23)
/* 2672 */             .addComponent(this.jLabel25)
/* 2673 */             .addComponent(this.jLabel24))
/* 2674 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 2675 */           .addComponent(this.jSeparator3, -2, 10, -2)
/* 2676 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2677 */           .addComponent(this.jScrollPane5, -1, 381, 32767)
/* 2678 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2679 */           .addComponent(this.jButton6)
/* 2680 */           .addGap(14, 14, 14)));
/* 2681 */     GroupLayout jDialog14Layout = new GroupLayout(this.jDialog14.getContentPane());
/* 2682 */     this.jDialog14.getContentPane().setLayout(jDialog14Layout);
/* 2683 */     jDialog14Layout.setHorizontalGroup(jDialog14Layout
/* 2684 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2685 */         .addComponent(this.jPanel39, -1, -1, 32767));
/* 2686 */     jDialog14Layout.setVerticalGroup(jDialog14Layout
/* 2687 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2688 */         .addComponent(this.jPanel39, -1, -1, 32767));
/* 2689 */     this.cantidad.setText("jFormattedTextField2");
/* 2690 */     this.jPanel13.setBackground(new Color(255, 255, 255));
/* 2691 */     this.jPanel42.setBackground(this.lc.SECUNDARIO1);
/* 2692 */     this.jLabel3.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 22.0F));
/* 2693 */     this.jLabel3.setForeground(this.lc.PRIMARIO2);
/* 2694 */     this.jLabel3.setHorizontalAlignment(0);
/* 2695 */     this.jLabel3.setText("Tarjetas Deudor");
/* 2696 */     GroupLayout jPanel42Layout = new GroupLayout(this.jPanel42);
/* 2697 */     this.jPanel42.setLayout(jPanel42Layout);
/* 2698 */     jPanel42Layout.setHorizontalGroup(jPanel42Layout
/* 2699 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2700 */         .addComponent(this.jLabel3, -1, -1, 32767));
/* 2701 */     jPanel42Layout.setVerticalGroup(jPanel42Layout
/* 2702 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2703 */         .addGroup(jPanel42Layout.createSequentialGroup()
/* 2704 */           .addContainerGap()
/* 2705 */           .addComponent(this.jLabel3)
/* 2706 */           .addContainerGap(-1, 32767)));
/* 2707 */     this.jPanel44.setBackground(this.lc.SECUNDARIO2);
/* 2708 */     this.jPanel43.setBackground(this.lc.SECUNDARIO2);
/* 2709 */     this.jPanel45.setLayout(new GridLayout(1, 0));
/* 2710 */     this.jLabel49.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 22.0F));
/* 2711 */     this.jLabel49.setForeground(this.lc.PRIMARIO1);
/* 2712 */     this.jLabel49.setHorizontalAlignment(4);
/* 2713 */     this.jLabel49.setText("t");
/* 2714 */     this.jLabel49.setBorder(BorderFactory.createEtchedBorder());
/* 2715 */     this.jPanel45.add(this.jLabel49);
/* 2716 */     this.jPanel46.setBackground(this.lc.SECUNDARIO2);
/* 2717 */     this.jPanel46.setLayout(new GridLayout(1, 4, 6, 0));
/* 2718 */     this.jPanel4.setBackground(this.lc.SECUNDARIO2);
/* 2719 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 2720 */     this.jPanel4.setLayout(jPanel4Layout);
/* 2721 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout
/* 2722 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2723 */         .addGap(0, 133, 32767));
/* 2724 */     jPanel4Layout.setVerticalGroup(jPanel4Layout
/* 2725 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2726 */         .addGap(0, 36, 32767));
/* 2727 */     this.jPanel46.add(this.jPanel4);
/* 2728 */     this.jButton10.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2729 */     this.jButton10.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Info.png")));
/* 2730 */     this.jButton10.setMnemonic('V');
/* 2731 */     this.jButton10.setText("Ver Detalle");
/* 2732 */     this.jButton10.setToolTipText("Ver Detalle (Alt+V)");
/* 2733 */     this.jButton10.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2735 */             ProvTarjetaDeudor.this.jButton10ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2738 */     this.jPanel46.add(this.jButton10);
/* 2739 */     this.jButton4.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2740 */     this.jButton4.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Print.png")));
/* 2741 */     this.jButton4.setMnemonic('I');
/* 2742 */     this.jButton4.setText("Imprimir");
/* 2743 */     this.jButton4.setToolTipText("Imprimir");
/* 2744 */     this.jButton4.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2746 */             ProvTarjetaDeudor.this.jButton4ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2749 */     this.jPanel46.add(this.jButton4);
/* 2750 */     this.jButton9.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2751 */     this.jButton9.setIcon(new ImageIcon(getClass().getResource("/entrada/Imagenes/botones/Save.png")));
/* 2752 */     this.jButton9.setMnemonic('G');
/* 2753 */     this.jButton9.setText("Guardar Reporte");
/* 2754 */     this.jButton9.setToolTipText("Guardar Reporte (Alt+G)");
/* 2755 */     this.jButton9.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2757 */             ProvTarjetaDeudor.this.jButton9ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2760 */     this.jPanel46.add(this.jButton9);
/* 2761 */     this.jPanel47.setBackground(this.lc.SECUNDARIO2);
/* 2762 */     this.jPanel47.setLayout(new GridLayout(1, 2, 6, 0));
/* 2763 */     this.jLabel58.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 14.0F));
/* 2764 */     this.jLabel58.setForeground(this.lc.SECUNDARIO1);
/* 2765 */     this.jLabel58.setHorizontalAlignment(4);
/* 2766 */     this.jLabel58.setText("Total: ");
/* 2767 */     this.jPanel47.add(this.jLabel58);
/* 2768 */     this.jLabel48.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.BOLD, 14.0F));
/* 2769 */     this.jLabel48.setForeground(this.lc.PRIMARIO1);
/* 2770 */     this.jLabel48.setHorizontalAlignment(2);
/* 2771 */     this.jLabel48.setText("t");
/* 2772 */     this.jPanel47.add(this.jLabel48);
/* 2773 */     GroupLayout jPanel43Layout = new GroupLayout(this.jPanel43);
/* 2774 */     this.jPanel43.setLayout(jPanel43Layout);
/* 2775 */     jPanel43Layout.setHorizontalGroup(jPanel43Layout
/* 2776 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2777 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
/* 2778 */           .addComponent(this.jPanel47, -2, 110, -2)
/* 2779 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 2780 */           .addComponent(this.jPanel46, -2, 550, -2)
/* 2781 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2782 */           .addComponent(this.jPanel45, -2, 211, -2)
/* 2783 */           .addGap(12, 12, 12)));
/* 2784 */     jPanel43Layout.setVerticalGroup(jPanel43Layout
/* 2785 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2786 */         .addGroup(jPanel43Layout.createSequentialGroup()
/* 2787 */           .addGroup(jPanel43Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
/* 2788 */             .addComponent(this.jPanel45, -1, -1, 32767)
/* 2789 */             .addComponent(this.jPanel46, -1, -1, 32767)
/* 2790 */             .addComponent(this.jPanel47, -2, 36, -2))
/* 2791 */           .addGap(0, 6, 32767)));
/* 2792 */     (new String[2])[0] = "Clave"; (new String[2])[1] = "Nombre Completo"; this.rSTableMetro1.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[2]) {
/* 2793 */           boolean[] canEdit = new boolean[] { false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 2796 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 2799 */     this.rSTableMetro1.setAltoHead(40);
/* 2800 */     this.rSTableMetro1.setColorBackgoundHead(this.lc.PRIMARIO1);
/* 2801 */     this.rSTableMetro1.setColorBordeFilas(this.lc.REJILLATABLA);
/* 2802 */     this.rSTableMetro1.setColorBordeHead(this.lc.PRIMARIO1);
/* 2803 */     this.rSTableMetro1.setColorFilasBackgound2(this.lc.REJILLATABLA);
/* 2804 */     this.rSTableMetro1.setColorFilasForeground1(new Color(102, 102, 102));
/* 2805 */     this.rSTableMetro1.setColorFilasForeground2(new Color(102, 102, 102));
/* 2806 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 2807 */     this.rSTableMetro1.setFuenteFilas(new Font("Cantarell", 0, 11));
/* 2808 */     this.rSTableMetro1.setFuenteFilasSelect(new Font("Cantarell", 0, 12));
/* 2809 */     this.rSTableMetro1.setFuenteHead(new Font("Cantarell", 1, 12));
/* 2810 */     this.rSTableMetro1.setGrosorBordeFilas(0);
/* 2811 */     this.rSTableMetro1.setRowHeight(18);
/* 2812 */     this.rSTableMetro1.setSelectionBackground(this.lc.PRIMARIO2);
/* 2813 */     this.rSTableMetro1.setShowHorizontalLines(false);
/* 2814 */     this.rSTableMetro1.setShowVerticalLines(false);
/* 2815 */     this.rSTableMetro1.getTableHeader().setResizingAllowed(false);
/* 2816 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 2817 */     this.rSTableMetro1.addMouseListener(new MouseAdapter() {
/*      */           public void mouseClicked(MouseEvent evt) {
/* 2819 */             ProvTarjetaDeudor.this.rSTableMetro1MouseClicked(evt);
/*      */           }
/*      */         });
/* 2822 */     this.rSTableMetro1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2824 */             ProvTarjetaDeudor.this.rSTableMetro1KeyReleased(evt);
/*      */           }
/*      */         });
/* 2827 */     this.jScrollPane13.setViewportView((Component)this.rSTableMetro1);
/* 2828 */     GroupLayout jPanel44Layout = new GroupLayout(this.jPanel44);
/* 2829 */     this.jPanel44.setLayout(jPanel44Layout);
/* 2830 */     jPanel44Layout.setHorizontalGroup(jPanel44Layout
/* 2831 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2832 */         .addComponent(this.jPanel43, -1, -1, 32767)
/* 2833 */         .addComponent(this.jScrollPane13));
/* 2834 */     jPanel44Layout.setVerticalGroup(jPanel44Layout
/* 2835 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2836 */         .addGroup(GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
/* 2837 */           .addComponent(this.jScrollPane13, -1, 264, 32767)
/* 2838 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2839 */           .addComponent(this.jPanel43, -2, -1, -2)));
/* 2840 */     this.jPanel17.setBackground(new Color(255, 255, 255));
/* 2841 */     this.jPanel17.setMinimumSize(new Dimension(220, 24));
/* 2842 */     this.jPanel17.setPreferredSize(new Dimension(220, 24));
/* 2843 */     this.jPanel17.setLayout(new GridLayout(1, 5, 6, 0));
/* 2844 */     this.jPanel3.setBackground(new Color(255, 255, 255));
/* 2845 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 2846 */     this.jPanel3.setLayout(jPanel3Layout);
/* 2847 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout
/* 2848 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2849 */         .addGap(0, 174, 32767));
/* 2850 */     jPanel3Layout.setVerticalGroup(jPanel3Layout
/* 2851 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2852 */         .addGap(0, 24, 32767));
/* 2853 */     this.jPanel17.add(this.jPanel3);
/* 2854 */     this.jTextField1.setBackground(new Color(255, 255, 255));
/* 2855 */     this.jTextField1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2857 */             ProvTarjetaDeudor.this.jTextField1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2860 */     this.jTextField1.addKeyListener(new KeyAdapter() {
/*      */           public void keyReleased(KeyEvent evt) {
/* 2862 */             ProvTarjetaDeudor.this.jTextField1KeyReleased(evt);
/*      */           }
/*      */         });
/* 2865 */     this.jPanel17.add(this.jTextField1);
/* 2866 */     this.jComboBox2.setBackground(new Color(244, 244, 244));
/* 2867 */     this.jComboBox2.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2868 */     this.jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "ACTIVAS", "ELIMINADAS", "TODAS" }));
/* 2869 */     this.jComboBox2.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2871 */             ProvTarjetaDeudor.this.jComboBox2ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2874 */     this.jPanel17.add(this.jComboBox2);
/* 2875 */     this.jComboBox1.setBackground(new Color(244, 244, 244));
/* 2876 */     this.jComboBox1.setFont(this.fuentes.setFuente(this.fuentes.FCentury, this.fuentes.PLAIN, 11.0F));
/* 2877 */     this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "SUCURSAL OPERATIVA" }));
/* 2878 */     this.jComboBox1.addActionListener(new ActionListener() {
/*      */           public void actionPerformed(ActionEvent evt) {
/* 2880 */             ProvTarjetaDeudor.this.jComboBox1ActionPerformed(evt);
/*      */           }
/*      */         });
/* 2883 */     this.jPanel17.add(this.jComboBox1);
/* 2884 */     this.jPanel2.setBackground(new Color(255, 255, 255));
/* 2885 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 2886 */     this.jPanel2.setLayout(jPanel2Layout);
/* 2887 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout
/* 2888 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2889 */         .addGap(0, 174, 32767));
/* 2890 */     jPanel2Layout.setVerticalGroup(jPanel2Layout
/* 2891 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2892 */         .addGap(0, 24, 32767));
/* 2893 */     this.jPanel17.add(this.jPanel2);
/* 2894 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 2895 */     this.jPanel13.setLayout(jPanel13Layout);
/* 2896 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout
/* 2897 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2898 */         .addComponent(this.jPanel42, GroupLayout.Alignment.TRAILING, -1, -1, 32767)
/* 2899 */         .addComponent(this.jPanel44, -1, -1, 32767)
/* 2900 */         .addComponent(this.jPanel17, -1, -1, 32767));
/* 2901 */     jPanel13Layout.setVerticalGroup(jPanel13Layout
/* 2902 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2903 */         .addGroup(jPanel13Layout.createSequentialGroup()
/* 2904 */           .addComponent(this.jPanel42, -2, -1, -2)
/* 2905 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2906 */           .addComponent(this.jPanel17, -2, -1, -2)
/* 2907 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 2908 */           .addComponent(this.jPanel44, -1, -1, 32767)));
/* 2909 */     GroupLayout layout = new GroupLayout(this);
/* 2910 */     setLayout(layout);
/* 2911 */     layout.setHorizontalGroup(layout
/* 2912 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2913 */         .addGap(0, 895, 32767)
/* 2914 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2915 */           .addComponent(this.jPanel13, -1, -1, 32767)));
/* 2916 */     layout.setVerticalGroup(layout
/* 2917 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2918 */         .addGap(0, 363, 32767)
/* 2919 */         .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 2920 */           .addComponent(this.jPanel13, -1, -1, 32767)));
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro1KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void rSTableMetro1MouseClicked(MouseEvent evt) {
/* 2927 */     if (evt.getClickCount() == 2) {
/* 2928 */       this.CLAVEPROV = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0));
/* 2929 */       verTarjeta();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(ActionEvent evt) {
/* 2934 */     if (this.rSTableMetro1.getRowCount() > 0) {
/* 2935 */       this.jRadioButton5.setSelected(true);
/* 2936 */       this.jDialog12.setVisible(true);
/*      */     } else {
/* 2938 */       JOptionPane.showMessageDialog(this.padre, "No hay datos para generar el reporte", "Sin datos", 0, this.ERROR);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton9ActionPerformed(ActionEvent evt) {
/* 2943 */     String[] datos = { "ID", "PROVEEDOR", "SALDO", "MONEDA", "SUCURSAL OPERATIVA", "ESTADO", "ACTUALIZÓ (dd/mm/aaaa)" };
/* 2944 */     this.esc = new EscribirReporte("TAJETA DEUDOR DE PROVEEDORES", (JTable)this.rSTableMetro1, datos, (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_pat"));
/*      */   }
/*      */   
/*      */   private void jButton10ActionPerformed(ActionEvent evt) {
/* 2948 */     int indice = this.rSTableMetro1.getSelectedRow();
/* 2949 */     if (indice < 0) {
/* 2950 */       JOptionPane.showMessageDialog(this.padre, "Necesitas seleccionar una tarjeta deudor para ver la información", "Selecciona una tarjeta", 0, this.ADVER);
/*      */     } else {
/* 2952 */       verTarjeta();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jComboBox1ActionPerformed(ActionEvent evt) {
/* 2957 */     if (this.entraSucPrimera) {
/* 2958 */       consultar();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jComboBox2ActionPerformed(ActionEvent evt) {
/* 2963 */     consultar();
/*      */   }
/*      */   
/*      */   private void jTextField1KeyReleased(KeyEvent evt) {
/* 2967 */     String cadena = this.jTextField1.getText();
/* 2968 */     if (!cadena.equals("")) {
/* 2969 */       if (this.presionado == null) {
/* 2970 */         this.presionado = new Presionado();
/* 2971 */         this.presionado.start();
/*      */       } else {
/* 2973 */         this.presionado.detenerFuera();
/* 2974 */         this.presionado = new Presionado();
/* 2975 */         this.presionado.start();
/*      */       } 
/*      */     } else {
/* 2978 */       this.jTextField1.setBackground(this.lc.PRIMARIO2);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField1ActionPerformed(ActionEvent evt) {
/* 2983 */     consultar();
/*      */   }
/*      */   
/*      */   private void rSTableMetro2MouseClicked(MouseEvent evt) {
/* 2987 */     if (evt.getClickCount() == 2) {
/* 2988 */       int ind = this.rSTableMetro2.getSelectedRow();
/* 2989 */       String v = this.rSTableMetro2.getValueAt(ind, 2).toString();
/* 2990 */       String titulo = "CARGO";
/* 2991 */       String importe = "";
/* 2992 */       String debe = "";
/* 2993 */       if ("ABONO".equals(v)) {
/* 2994 */         titulo = "ABONO";
/* 2995 */         importe = this.rSTableMetro2.getValueAt(ind, 5).toString();
/* 2996 */         debe = "$0.00";
/*      */       } else {
/* 2998 */         importe = this.rSTableMetro2.getValueAt(ind, 4).toString();
/* 2999 */         debe = this.rSTableMetro2.getValueAt(ind, 6).toString();
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
/* 3053 */       String[] campos = { this.rSTableMetro2.getValueAt(ind, 1).toString(), this.rSTableMetro2.getValueAt(ind, 2).toString(), this.rSTableMetro2.getValueAt(ind, 3).toString(), importe, debe };
/*      */ 
/*      */ 
/*      */       
/* 3057 */       ProvTarjetaDeudorMovimiento provTarjetaDeudorMovimiento = new ProvTarjetaDeudorMovimiento(this.padre, true, titulo, this.rSTableMetro2.getValueAt(ind, 0).toString(), campos);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro2KeyReleased(KeyEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jComboBox4ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jComboBox5ActionPerformed(ActionEvent evt) {}
/*      */ 
/*      */   
/*      */   private void jComboBox6ActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt) {
/* 3074 */     consultarContenido();
/*      */   }
/*      */   
/*      */   private void jButton17ActionPerformed(ActionEvent evt) {
/* 3078 */     this.jTextField9.setText(sacarFechaHoy().substring(2, sacarFechaHoy().length() - 1));
/* 3079 */     this.importe1.setValue(Integer.valueOf(0));
/* 3080 */     this.jRadioButton1.setSelected(true);
/* 3081 */     this.jTextField18.setText("");
/* 3082 */     this.jTextField10.setText("");
/* 3083 */     this.jTextArea2.setText("");
/* 3084 */     this.jLabel35.setText(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1).toString());
/* 3085 */     this.jDialog2.setTitle("Cargo a " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1)));
/* 3086 */     this.jDialog2.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/* 3090 */     this.jTextField3.setText(sacarFechaHoy().substring(2, sacarFechaHoy().length() - 1));
/* 3091 */     this.jComboBox3.setSelectedIndex(0);
/* 3092 */     this.jTextField6.setText("");
/* 3093 */     this.jTextField6.setToolTipText("");
/* 3094 */     this.jButton35.setEnabled(false);
/* 3095 */     this.importe2.setValue(Integer.valueOf(0));
/* 3096 */     this.jLabel7.setVisible(false);
/* 3097 */     this.jLabel9.setText("$0.00");
/* 3098 */     limpiarTablaFactporPagar();
/* 3099 */     consultarFacturasPendientes();
/* 3100 */     this.jDialog3.setVisible(true);
/*      */   }
/*      */   
/*      */   private void materialButton21ActionPerformed(ActionEvent evt) {
/* 3104 */     this.jDialog1.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton22ActionPerformed(ActionEvent evt) {
/* 3108 */     String[] datos = { "MOV", "FECHA", "CONCEPTO", "REFERENCIA", "IMPORTE", "ABONO", "DEBE", "SALDO", "ESTADO" };
/* 3109 */     this.esc = new EscribirReporte(this.jLabel62.getText().toUpperCase(), (JTable)this.rSTableMetro2, datos, this.USUARIO);
/*      */   }
/*      */   
/*      */   private void materialButton23ActionPerformed(ActionEvent evt) {
/* 3113 */     this.jRadioButton4.setSelected(true);
/* 3114 */     this.jDateChooser1.setEnabled(true);
/* 3115 */     this.jLabel42.setEnabled(true);
/* 3116 */     this.jDialog11.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jRadioButton1ActionPerformed(ActionEvent evt) {
/* 3120 */     this.jTextField10.setText("");
/* 3121 */     this.jTextField10.setEnabled(false);
/*      */   }
/*      */   
/*      */   private void jRadioButton2ActionPerformed(ActionEvent evt) {
/* 3125 */     this.jTextField10.setEnabled(true);
/*      */   }
/*      */ 
/*      */   
/*      */   private void importe1ActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   private void materialButton24ActionPerformed(ActionEvent evt) {
/* 3132 */     this.jDialog2.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton25ActionPerformed(ActionEvent evt) {
/* 3136 */     if (this.jRadioButton2.isSelected() && this.jTextField10.getText().equals("")) {
/* 3137 */       this.jTextField10.setBackground(Color.RED);
/* 3138 */       JOptionPane.showMessageDialog(this.jDialog2, "El campo esperaba algún un tipo de información", "Falta el concepto", 0, this.ERROR);
/* 3139 */     } else if (this.jTextField18.getText().equals("")) {
/* 3140 */       this.jTextField18.setBackground(Color.RED);
/* 3141 */       JOptionPane.showMessageDialog(this.jDialog2, "El campo esperaba algún un tipo de información", "Falta la referencia", 0, this.ERROR);
/* 3142 */     } else if (this.importe1.getText().equals("$0.00")) {
/* 3143 */       this.importe1.setBackground(Color.RED);
/* 3144 */       JOptionPane.showMessageDialog(this.jDialog2, "El campo esperaba algún un tipo de información", "Falta la cantidad", 0, this.ERROR);
/*      */     } else {
/* 3146 */       String concep = "CARGO POR FACTURA";
/* 3147 */       int res = JOptionPane.showConfirmDialog(this.jDialog1, "<html>¿Estás seguro que deseas generar el siguiente cargo por <b>" + this.importe1.getText() + "</b>?</html>", "Generar Cargo", 0, 3, this.PREG);
/* 3148 */       if (res == 0) {
/* 3149 */         String numProv = this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0).toString();
/* 3150 */         String actualizo = this.USUARIO + this.USUARIO;
/* 3151 */         double total = 0.0D;
/* 3152 */         double totalF = convertirCantTexto(this.importe1.getText());
/* 3153 */         this.encontrado = this.con.consultar("sum(importeRestante)", "prov_tarjetadeudor", "where numProv = " + numProv);
/* 3154 */         if (this.con.Campo == null) {
/* 3155 */           total = totalF;
/*      */         } else {
/* 3157 */           String saldoFinal = this.con.Campo;
/* 3158 */           total = Double.parseDouble(saldoFinal) + totalF;
/*      */         } 
/* 3160 */         this.cantidad.setValue(Double.valueOf(total));
/* 3161 */         String saldoFinalLetra = this.cantidad.getText();
/* 3162 */         this.con.inserSinMsj("update prov_proveedores set saldo = '" + saldoFinalLetra + "', usuarioTarjeta='" + actualizo + "' where numProv= " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)));
/* 3163 */         this.rSTableMetro1.setValueAt(saldoFinalLetra, this.rSTableMetro1.getSelectedRow(), 2);
/* 3164 */         calcularTotalGral();
/* 3165 */         this.con.inserSinMsj("insert into prov_tarjetadeudor ( fecha, fechaPago, tipoConcep, concepto, referencia, importe, importeLetra, abono, abonoLetra, importeSaldado, importeRestante, importeRestanteLetra, estatus, comentario,  uuid, factura, num_abono, saldoFinal, saldoFinalLetra, numProv, numFactura, usuario  ) values ( now(), now(), 1, '" + concep + "',  '" + this.jTextField18
/* 3166 */             .getText().toUpperCase() + "'," + totalF + ",'" + this.importe1.getText() + "',0,'',  0," + totalF + ",'" + this.importe1
/* 3167 */             .getText() + "','<Por Pagar>', '" + this.jTextArea2.getText().toUpperCase() + "',  '', '', '', " + total + ", '" + saldoFinalLetra + "', " + numProv + ",0,'" + actualizo + "')");
/* 3168 */         verTarjeta();
/* 3169 */         this.jDialog2.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void importe2ActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   private void jButton35ActionPerformed(ActionEvent evt) {
/* 3178 */     Dimension di = this.jButton35.getSize();
/* 3179 */     Point p = this.jButton35.getLocationOnScreen();
/* 3180 */     if (this.jComboBox3.getSelectedItem().toString().equals("CHEQUE")) {
/* 3181 */       this.entraCheque = true;
/*      */     } else {
/* 3183 */       this.entraCheque = false;
/*      */     } 
/* 3185 */     consultarDatoExtra();
/* 3186 */     this.jDialog4.setLocation(p.x + di.width - this.jDialog4.getWidth(), p.y + 30);
/* 3187 */     this.jDialog4.setVisible(true);
/*      */   }
/*      */   
/*      */   private void rSTableMetro6MouseClicked(MouseEvent evt) {
/* 3191 */     if (evt.getClickCount() == 2) {
/* 3192 */       if (this.importe2.getText().equals("$0.00")) {
/* 3193 */         this.importe2.setBackground(Color.RED);
/* 3194 */         JOptionPane.showMessageDialog(this.jDialog3, "Necesitas ingresar la cantidad que deseas guardar para este abono", "Coloca la cantidad", 0, this.ERROR);
/*      */       } else {
/* 3196 */         String valor1 = String.valueOf(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 1));
/* 3197 */         for (int i = 0; i < this.rSTableMetro7.getRowCount(); i++) {
/* 3198 */           String valor2 = String.valueOf(this.rSTableMetro7.getValueAt(i, 1));
/* 3199 */           if (valor1.equals(valor2)) {
/* 3200 */             JOptionPane.showMessageDialog(this.jDialog3, "La factura que seleccionaste ya se encuentra almacenada en la parte para saldar", "Factura Duplicada", 0, this.ERROR);
/*      */             return;
/*      */           } 
/*      */         } 
/* 3204 */         pasarFactura();
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro6KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void rSTableMetro7MouseClicked(MouseEvent evt) {
/* 3213 */     if (evt.getClickCount() == 2) {
/* 3214 */       int ind = this.rSTableMetro7.getSelectedRow();
/* 3215 */       this.importe3.setValue(Double.valueOf(convertirCantTexto(this.rSTableMetro7.getValueAt(ind, 4).toString())));
/* 3216 */       this.jDialog5.setVisible(true);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro7KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 3224 */     int ind = this.rSTableMetro6.getSelectedRow();
/* 3225 */     if (ind < 0) {
/* 3226 */       JOptionPane.showMessageDialog(this.jDialog3, "Necesitas seleccionar una factura para saldarla", "Selecciona una factura", 0, this.ERROR);
/* 3227 */     } else if (this.importe2.getText().equals("$0.00")) {
/* 3228 */       this.importe2.setBackground(Color.RED);
/* 3229 */       JOptionPane.showMessageDialog(this.jDialog3, "Necesitas ingresar la cantidad que deseas guardar para este abono", "Coloca la cantidad", 0, this.ERROR);
/*      */     } else {
/* 3231 */       String valor1 = String.valueOf(this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 1));
/* 3232 */       for (int i = 0; i < this.rSTableMetro7.getRowCount(); i++) {
/* 3233 */         String valor2 = String.valueOf(this.rSTableMetro7.getValueAt(i, 1));
/* 3234 */         if (valor1.equals(valor2)) {
/* 3235 */           JOptionPane.showMessageDialog(this.jDialog3, "La factura que seleccionaste ya se encuentra almacenada en la parte para saldar", "Factura Duplicada", 0, this.ERROR);
/*      */           return;
/*      */         } 
/*      */       } 
/* 3239 */       pasarFactura();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 3244 */     int ind = this.rSTableMetro7.getSelectedRow();
/* 3245 */     if (ind < 0) {
/* 3246 */       JOptionPane.showMessageDialog(this.jDialog3, "Necesitas seleccionar una factura de la parte derecha", "Selecciona una factura", 0, this.ERROR);
/*      */     } else {
/* 3248 */       this.importe3.setValue(Double.valueOf(convertirCantTexto(this.rSTableMetro7.getValueAt(ind, 4).toString())));
/* 3249 */       this.jDialog5.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton26ActionPerformed(ActionEvent evt) {
/* 3254 */     double interPos = 5.0D;
/* 3255 */     double interNeg = -5.0D;
/* 3256 */     if (this.jComboBox3.getSelectedIndex() == 0) {
/* 3257 */       this.jComboBox3.setBackground(Color.RED);
/* 3258 */       JOptionPane.showMessageDialog(this.jDialog3, "Necesitas seleccionar un tipo de abono", "Falta información", 0, this.ERROR);
/* 3259 */     } else if (this.jTextField6.getText().equals("")) {
/* 3260 */       this.jTextField6.setBackground(Color.RED);
/* 3261 */       JOptionPane.showMessageDialog(this.jDialog3, "Necesitas ingresar la referencia del movimiento", "Falta referencia", 0, this.ERROR);
/* 3262 */     } else if (this.importe2.getText().equals("$0.00")) {
/* 3263 */       this.importe2.setBackground(Color.RED);
/* 3264 */       JOptionPane.showMessageDialog(this.jDialog3, "Necesitas ingresar la cantidad por el abono", "Falta información", 0, this.ERROR);
/* 3265 */     } else if (this.jLabel9.getText().equals("$0.00")) {
/* 3266 */       JOptionPane.showMessageDialog(this.jDialog3, "Necesitas seleccionar las facturas que serán abonadas para éste movimiento", "Falta información", 0, this.ERROR);
/*      */     } else {
/* 3268 */       double sumas = convertirCantTexto(this.jLabel9.getText());
/* 3269 */       double importe = Double.parseDouble(this.importe2.getValue().toString());
/* 3270 */       double resultado = importe - sumas;
/* 3271 */       this.cantidad.setValue(Double.valueOf(resultado));
/* 3272 */       if (resultado > interPos || resultado < interNeg) {
/* 3273 */         JOptionPane.showMessageDialog(this.jDialog3, "<html>Verifica tus importes, ya que las sumas no coinciden con el depósto<p>Importe: <b>" + this.importe2
/* 3274 */             .getText() + "</b><p>Sumas: <b>" + this.jLabel9.getText() + "</b><p>____________________________<p>Diferencia: <b>" + this.cantidad.getText() + "</b></html>", "Cantidades diferentes", 0, this.ERROR);
/*      */       } else {
/* 3276 */         String tabla = "";
/* 3277 */         String clave = "";
/* 3278 */         String claveValor = "";
/* 3279 */         boolean entraTabla = false;
/* 3280 */         if (this.jComboBox3.getSelectedItem().toString().equals("CHEQUE")) {
/* 3281 */           tabla = "prov_cheques";
/* 3282 */           clave = "poliza";
/* 3283 */           claveValor = this.chequeAsignado.getPoliza();
/* 3284 */           entraTabla = true;
/* 3285 */         } else if (this.jComboBox3.getSelectedItem().toString().equals("TRANSFERENCIA")) {
/* 3286 */           tabla = "prov_transferencias";
/* 3287 */           clave = "folio";
/* 3288 */           claveValor = this.transferenciaAsignada.getFolio();
/* 3289 */           entraTabla = true;
/*      */         } 
/* 3291 */         String insertarPagos = "";
/* 3292 */         String actualizo = this.USUARIO + this.USUARIO;
/* 3293 */         int res = JOptionPane.showConfirmDialog(this.jDialog3, "<html>¿Estás seguro que deseas aplicar el abono por: <b>" + this.importe2.getText() + "</b>?</html>", "Generar Abono", 0, 3, this.PREG);
/* 3294 */         if (res == 0) {
/* 3295 */           List<FacturasAbonadas> facturas = new ArrayList<>();
/* 3296 */           String Prefijo = "";
/* 3297 */           if (this.jComboBox3.getSelectedIndex() == 2) {
/* 3298 */             Prefijo = "EFECTIVO: ";
/* 3299 */           } else if (this.jComboBox3.getSelectedIndex() == 3) {
/* 3300 */             Prefijo = "NC: ";
/*      */           } 
/* 3302 */           for (int i = 0; i < this.rSTableMetro7.getRowCount(); i++) {
/* 3303 */             facturas.add(new FacturasAbonadas(
/* 3304 */                   Integer.parseInt(this.rSTableMetro7.getValueAt(i, 0).toString()), this.rSTableMetro7
/* 3305 */                   .getValueAt(i, 1).toString(), this.rSTableMetro7
/* 3306 */                   .getValueAt(i, 2).toString(), this.rSTableMetro7
/* 3307 */                   .getValueAt(i, 3).toString(), this.rSTableMetro7
/* 3308 */                   .getValueAt(i, 4).toString(), 
/* 3309 */                   Integer.parseInt(this.rSTableMetro7.getValueAt(i, 5).toString())));
/* 3310 */             if (!((FacturasAbonadas)facturas.get(i)).getResta().equals(((FacturasAbonadas)facturas.get(i)).getAbono())) {
/* 3311 */               double saldado = convertirCantTexto(((FacturasAbonadas)facturas.get(i)).getImporte()) - convertirCantTexto(((FacturasAbonadas)facturas.get(i)).getResta()) + convertirCantTexto(((FacturasAbonadas)facturas.get(i)).getAbono());
/* 3312 */               this.cantidad.setValue(Double.valueOf(saldado));
/* 3313 */               String saldadoLetra = this.cantidad.getText();
/* 3314 */               double resta = convertirCantTexto(((FacturasAbonadas)facturas.get(i)).getImporte()) - saldado;
/* 3315 */               this.cantidad.setValue(Double.valueOf(resta));
/* 3316 */               String restaLetra = this.cantidad.getText();
/* 3317 */               this.con.inserSinMsj("update prov_tarjetadeudor set importeSaldado = " + saldado + ", importeRestante = " + resta + ", importeRestanteLetra ='" + restaLetra + "', estatus='<Abono: " + saldadoLetra + ">' where mov = " + ((FacturasAbonadas)facturas
/* 3318 */                   .get(i)).getMov());
/* 3319 */               this.con.inserSinMsj("update prov_facturas set estado ='<Abono: " + saldadoLetra + ">', totalDebe='" + restaLetra + "' where numFactura = " + ((FacturasAbonadas)facturas.get(i)).getId());
/*      */             } else {
/* 3321 */               double saldado = convertirCantTexto(((FacturasAbonadas)facturas.get(i)).getImporte());
/* 3322 */               this.con.inserSinMsj("update prov_tarjetadeudor set importeSaldado = " + saldado + ", importeRestante=0, importeRestanteLetra ='$0.00', estatus='<Pagada: " + this.jTextField3
/* 3323 */                   .getText() + ">' where mov = " + ((FacturasAbonadas)facturas.get(i)).getMov());
/* 3324 */               this.con.inserSinMsj("update prov_facturas set estado ='<Pagada: " + this.jTextField3.getText() + " >', totalDebe='$0.00' where numFactura = " + ((FacturasAbonadas)facturas.get(i)).getId());
/*      */             } 
/* 3326 */             insertarPagos = insertarPagos + "('" + insertarPagos + Prefijo + "', '" + this.jTextField6.getText().toUpperCase() + "', '" + ((FacturasAbonadas)facturas.get(i)).getAbono() + "', " + actualizo + ")";
/* 3327 */             if (i + 1 < this.rSTableMetro7.getRowCount()) {
/* 3328 */               insertarPagos = insertarPagos + " , ";
/* 3329 */               System.out.println("entra Pagos: " + insertarPagos);
/*      */             } 
/*      */           } 
/* 3332 */           if (entraTabla) {
/* 3333 */             this.con.inserSinMsj("update " + tabla + " set estado = '<Aplicada: " + this.jTextField3.getText() + ">' where " + clave + " = '" + claveValor + "'");
/*      */           }
/* 3335 */           this.con.inserSinMsj("insert into prov_tarjetadeudor_pagos (referencia, abono, usuario, mov) values " + insertarPagos);
/* 3336 */           this.con.consultar("sum(importeRestante)", "prov_tarjetadeudor", "where numProv = " + this.CLAVEPROV);
/* 3337 */           double total = Double.parseDouble(this.con.Campo);
/* 3338 */           this.cantidad.setValue(Double.valueOf(total));
/* 3339 */           this.con.inserSinMsj("update prov_proveedores set saldo='" + this.cantidad.getText() + "', usuarioTarjeta='" + actualizo + "' where numProv = " + this.CLAVEPROV);
/* 3340 */           this.con.inserSinMsj("insert into prov_tarjetadeudor ( fecha, fechaPago, tipoConcep, concepto, referencia, importe, importeLetra, abono, abonoLetra, importeSaldado, importeRestante, importeRestanteLetra, estatus, comentario,  uuid, factura, num_abono, saldoFinal, saldoFinalLetra, numProv, numFactura, usuario  ) values ( now(), now(), 2, 'ABONO',  '" + Prefijo + this.jTextField6
/* 3341 */               .getText().toUpperCase() + "',0,''," + importe + ",'" + this.importe2.getText() + "',  0,0,'','<Aplicado>', '',  '', '', '', " + total + ", '" + this.cantidad
/* 3342 */               .getText() + "', " + this.CLAVEPROV + ",0, '" + actualizo + "')");
/* 3343 */           calcularTotalGral();
/* 3344 */           this.jDialog3.setVisible(false);
/* 3345 */           verTarjeta();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton27ActionPerformed(ActionEvent evt) {
/* 3352 */     this.jDialog3.setVisible(false);
/*      */   }
/*      */   
/*      */   private void jComboBox3ActionPerformed(ActionEvent evt) {
/* 3356 */     String v = this.jComboBox3.getSelectedItem().toString();
/* 3357 */     this.jTextField6.setText("");
/* 3358 */     this.importe2.setValue(Integer.valueOf(0));
/* 3359 */     switch (v) {
/*      */       case "CHEQUE":
/*      */       case "TRANSFERENCIA":
/* 3362 */         this.jTextField6.setEnabled(false);
/* 3363 */         this.importe2.setEditable(false);
/* 3364 */         this.jButton35.setEnabled(true);
/*      */         return;
/*      */       case "NOTA DE CRÉDITO":
/*      */       case "EFECTIVO":
/*      */       case "OTRO...":
/* 3369 */         this.jTextField6.setEnabled(true);
/* 3370 */         this.importe2.setEditable(true);
/* 3371 */         this.jButton35.setEnabled(false);
/*      */         return;
/*      */     } 
/* 3374 */     this.jTextField6.setEnabled(false);
/* 3375 */     this.importe2.setEditable(false);
/* 3376 */     this.jButton35.setEnabled(false);
/*      */   }
/*      */   
/*      */   private void rSTableMetro3MouseClicked(MouseEvent evt) {
/* 3380 */     if (evt.getClickCount() == 2) {
/* 3381 */       cargarChequeTrans();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro3KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void jButton53ActionPerformed(ActionEvent evt) {
/* 3389 */     int indice = this.rSTableMetro3.getSelectedRow();
/* 3390 */     if (indice < 0) {
/* 3391 */       JOptionPane.showMessageDialog(this.jDialog4, "Necesitas seleccionar un registro para cargar los datos", "Selecciona un dato", 0, this.ADVER);
/*      */     } else {
/* 3393 */       cargarChequeTrans();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void jTextField4KeyReleased(KeyEvent evt) {
/* 3398 */     consultarDatoExtra();
/*      */   }
/*      */   
/*      */   private void jTextField5KeyReleased(KeyEvent evt) {
/* 3402 */     String cadena = this.jTextField5.getText();
/* 3403 */     if (!cadena.equals("")) {
/* 3404 */       if (this.presionado2 == null) {
/* 3405 */         this.presionado2 = new Presionado2();
/* 3406 */         this.presionado2.start();
/*      */       } else {
/* 3408 */         this.presionado2.detenerFuera();
/* 3409 */         this.presionado2 = new Presionado2();
/* 3410 */         this.presionado2.start();
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTextField5ActionPerformed(ActionEvent evt) {
/* 3416 */     consultarFacturasPendientes();
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 3420 */     int ind = this.rSTableMetro7.getSelectedRow();
/* 3421 */     if (ind < 0) {
/* 3422 */       JOptionPane.showMessageDialog(this.jDialog3, "Necesitas seleccionar una factura para quitarla", "Selecciona una factura", 0, this.ERROR);
/*      */     } else {
/* 3424 */       DefaultTableModel temp = (DefaultTableModel)this.rSTableMetro7.getModel();
/* 3425 */       temp.removeRow(ind);
/* 3426 */       sumarFacturas();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton28ActionPerformed(ActionEvent evt) {
/* 3431 */     this.jDialog5.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton29ActionPerformed(ActionEvent evt) {
/* 3435 */     cambiarSaldo();
/*      */   }
/*      */ 
/*      */   
/*      */   private void jPanel30MouseClicked(MouseEvent evt) {}
/*      */   
/*      */   private void materialButton30ActionPerformed(ActionEvent evt) {
/* 3442 */     this.jDialog6.setVisible(false);
/*      */   }
/*      */ 
/*      */   
/*      */   private void rSTableMetro8MouseClicked(MouseEvent evt) {}
/*      */ 
/*      */   
/*      */   private void rSTableMetro8KeyReleased(KeyEvent evt) {}
/*      */   
/*      */   private void materialButton18ActionPerformed(ActionEvent evt) {
/* 3452 */     this.jDialog10.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton17ActionPerformed(ActionEvent evt) {
/* 3456 */     boolean correcto = false;
/* 3457 */     if (this.jDateChooser9.getDate() == null) {
/* 3458 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de corte no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha actual en el campo?</html>", "Fecha de corte vacía", 0, 3, this.PREG);
/* 3459 */       if (res == 0) {
/* 3460 */         this.jDateChooser9.setDate(new Date());
/* 3461 */         correcto = true;
/*      */       } 
/* 3463 */     } else if (this.jDateChooser9.getDate().after(new Date())) {
/* 3464 */       int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de corte no puede ser mayor a la fecha de HOY, por favor verifica tu información<br>¿Deseas insertar la fecha actual en el campo?</html>", "Fecha no Válida", 0, 3, this.PREG);
/* 3465 */       if (res == 0) {
/* 3466 */         this.jDateChooser9.setDate(new Date());
/* 3467 */         correcto = true;
/*      */       } 
/*      */     } else {
/* 3470 */       correcto = true;
/*      */     } 
/* 3472 */     if (correcto) {
/* 3473 */       boolean TODOPAGADO = false;
/* 3474 */       ArrayList<String> tarjetas = new ArrayList<>();
/* 3475 */       ArrayList<String> nombreCorto = new ArrayList<>();
/* 3476 */       Map<Integer, String> PROVEEDORES = new HashMap<>();
/* 3477 */       for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 3478 */         if (!this.rSTableMetro1.getValueAt(i, 2).toString().equals("$0.00")) {
/* 3479 */           TODOPAGADO = true;
/* 3480 */           tarjetas.add(this.rSTableMetro1.getValueAt(i, 0).toString());
/* 3481 */           nombreCorto.add(this.rSTableMetro1.getValueAt(i, 1).toString());
/* 3482 */           PROVEEDORES.put(Integer.valueOf(Integer.parseInt(this.rSTableMetro1.getValueAt(i, 0).toString())), this.rSTableMetro1.getValueAt(i, 1).toString());
/*      */         } 
/*      */       } 
/* 3485 */       if (TODOPAGADO) {
/* 3486 */         SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3487 */         String cadenaFecha = "";
/* 3488 */         cadenaFecha = formato.format(this.jDateChooser9.getDate());
/* 3489 */         String AÑO = cadenaFecha.substring(0, 4);
/* 3490 */         String MES = cadenaFecha.substring(4, 6);
/* 3491 */         String DIA = cadenaFecha.substring(6, 8);
/* 3492 */         String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/* 3493 */         String consulta = "";
/* 3494 */         String consulta2 = "";
/* 3495 */         for (int j = 0; j < tarjetas.size(); j++) {
/* 3496 */           consulta = consulta + " prov_tarjetadeudor.numProv = " + consulta + " and prov_tarjetadeudor.fechaPago <= " + (String)tarjetas.get(j);
/* 3497 */           consulta2 = consulta2 + " prov_tarjetadeudor.numProv =" + consulta2 + " and prov_tarjetadeudor.fechaPago > " + (String)tarjetas.get(j);
/* 3498 */           if (nombreCorto.size() - 1 > j) {
/* 3499 */             consulta = consulta + " or ";
/* 3500 */             consulta2 = consulta2 + " or ";
/*      */           } 
/*      */         } 
/*      */         
/* 3504 */         (new String[7])[0] = "Tarjeta"; (new String[7])[1] = "Cliente"; (new String[7])[2] = "Folio"; (new String[7])[3] = "Fecha"; (new String[7])[4] = "total"; (new String[7])[5] = "Resta"; (new String[7])[6] = "Estatus"; this.TablaGral.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos(7, "prov_tarjetadeudor.numProv,prov_proveedores.razonSocial,prov_tarjetadeudor.factura,prov_tarjetadeudor.fechaPago,prov_tarjetadeudor.importeLetra,prov_tarjetadeudor.importeRestanteLetra,prov_tarjetadeudor.estatus", "prov_tarjetadeudor, prov_proveedores", "where prov_tarjetadeudor.numProv = prov_proveedores.numProv and prov_tarjetadeudor.tipoConcep=1 and (prov_tarjetadeudor.estatus like '%<Por Pagar%' || prov_tarjetadeudor.estatus like '%<Abono%') and (" + consulta + ") order by prov_proveedores.razonSocial asc, prov_tarjetadeudor.fecha asc"), (Object[])new String[7]) {
/* 3505 */               boolean[] canEdit = new boolean[] { 
/*      */                   false, false, false, false, false, false, false, false, false, false, 
/*      */                   false };
/*      */               
/*      */               public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3510 */                 return this.canEdit[columnIndex];
/*      */               }
/*      */             });
/* 3513 */         this.jLabel61.setText("" + this.TablaGral.getRowCount());
/*      */         
/* 3515 */         (new String[7])[0] = "Tarjeta"; (new String[7])[1] = "Cliente"; (new String[7])[2] = "Folio"; (new String[7])[3] = "Fecha"; (new String[7])[4] = "total"; (new String[7])[5] = "Resta"; (new String[7])[6] = "Estatus"; this.TablaGral1.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos(7, "prov_tarjetadeudor.numProv,prov_proveedores.razonSocial,prov_tarjetadeudor.factura,prov_tarjetadeudor.fechaPago,prov_tarjetadeudor.importeLetra,prov_tarjetadeudor.importeRestanteLetra,prov_tarjetadeudor.estatus", "prov_tarjetadeudor, prov_proveedores", "where prov_tarjetadeudor.numProv = prov_proveedores.numProv and prov_tarjetadeudor.tipoConcep=1 and (prov_tarjetadeudor.estatus like '%<Por Pagar%' || prov_tarjetadeudor.estatus like '%<Abono%') and (" + consulta2 + ") order by prov_proveedores.razonSocial asc, prov_tarjetadeudor.fecha asc"), (Object[])new String[7]) {
/* 3516 */               boolean[] canEdit = new boolean[] { 
/*      */                   false, false, false, false, false, false, false, false, false, false, 
/*      */                   false };
/*      */               
/*      */               public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3521 */                 return this.canEdit[columnIndex];
/*      */               }
/*      */             });
/* 3524 */         this.jLabel64.setText("" + this.TablaGral1.getRowCount());
/* 3525 */         this.jLabel69.setText("" + tarjetas.size());
/* 3526 */         this.TablaAux = new JTable(tarjetas.size(), 6);
/* 3527 */         double importe = 0.0D;
/* 3528 */         for (int k = 0; k < tarjetas.size(); k++) {
/* 3529 */           this.TablaAux.setValueAt(Integer.valueOf(k + 1), k, 0);
/* 3530 */           this.TablaAux.setValueAt(tarjetas.get(k), k, 1);
/* 3531 */           this.TablaAux.setValueAt(nombreCorto.get(k), k, 2);
/*      */           int n;
/* 3533 */           for (n = 0; n < this.TablaGral.getRowCount(); n++) {
/* 3534 */             String cliente = this.TablaGral.getValueAt(n, 0).toString();
/* 3535 */             if (cliente.equals(tarjetas.get(k))) {
/* 3536 */               String cant = this.TablaGral.getValueAt(n, 5).toString();
/* 3537 */               importe += convertirCantTexto(cant);
/*      */             } 
/*      */           } 
/* 3540 */           this.cantidad.setValue(Double.valueOf(importe));
/* 3541 */           this.TablaAux.setValueAt(this.cantidad.getText(), k, 3);
/* 3542 */           importe = 0.0D;
/* 3543 */           for (n = 0; n < this.TablaGral1.getRowCount(); n++) {
/* 3544 */             String cliente = this.TablaGral1.getValueAt(n, 0).toString();
/* 3545 */             if (cliente.equals(tarjetas.get(k))) {
/* 3546 */               String cant = this.TablaGral1.getValueAt(n, 5).toString();
/* 3547 */               importe += convertirCantTexto(cant);
/*      */             } 
/*      */           } 
/* 3550 */           this.cantidad.setValue(Double.valueOf(importe));
/* 3551 */           this.TablaAux.setValueAt(this.cantidad.getText(), k, 4);
/* 3552 */           importe = 0.0D;
/*      */         } 
/* 3554 */         double TOTALVENCIDO = 0.0D;
/* 3555 */         double TOTALPORVENCER = 0.0D;
/* 3556 */         double TOTALGRAL = 0.0D;
/* 3557 */         for (int m = 0; m < this.TablaAux.getRowCount(); m++) {
/* 3558 */           String vencido = this.TablaAux.getValueAt(m, 3).toString();
/* 3559 */           String porvencer = this.TablaAux.getValueAt(m, 4).toString();
/* 3560 */           double total = convertirCantTexto(vencido) + convertirCantTexto(porvencer);
/* 3561 */           this.cantidad.setValue(Double.valueOf(total));
/* 3562 */           this.TablaAux.setValueAt(this.cantidad.getText(), m, 5);
/* 3563 */           TOTALVENCIDO += convertirCantTexto(vencido);
/* 3564 */           TOTALPORVENCER += convertirCantTexto(porvencer);
/*      */         } 
/* 3566 */         TOTALGRAL = TOTALVENCIDO + TOTALPORVENCER;
/* 3567 */         this.cantidad.setValue(Double.valueOf(TOTALVENCIDO));
/* 3568 */         this.jLabel72.setText(this.cantidad.getText());
/* 3569 */         this.cantidad.setValue(Double.valueOf(TOTALPORVENCER));
/* 3570 */         this.jLabel82.setText(this.cantidad.getText());
/* 3571 */         this.cantidad.setValue(Double.valueOf(TOTALGRAL));
/* 3572 */         this.jLabel83.setText(this.cantidad.getText());
/* 3573 */         this.jScrollPane6.setViewportView(this.TablaAux);
/* 3574 */         this.jDialog10.setVisible(false);
/*      */         try {
/* 3576 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 3577 */           String cadenaFecha1 = formato.format(this.jDateChooser9.getDate());
/* 3578 */           String año = cadenaFecha1.substring(0, 4);
/* 3579 */           String mes = cadenaFecha1.substring(4, 6);
/* 3580 */           String dia = cadenaFecha1.substring(6, 8);
/* 3581 */           String fechaCompleta = dia + "/" + dia + "/" + mes;
/* 3582 */           String sicret = "LOGO.jpg";
/* 3583 */           String forsis = "forsis100x.jpg";
/* 3584 */           Map<Object, Object> datos = new HashMap<>();
/* 3585 */           datos.put("sucursal", this.CAMPOSGENERALES.get("sucursal"));
/* 3586 */           datos.put("periodo", fechaCompleta);
/* 3587 */           datos.put("documento", (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_pat"));
/* 3588 */           datos.put("sicret", getClass().getResourceAsStream(sicret));
/* 3589 */           datos.put("forsis", getClass().getResourceAsStream(forsis));
/* 3590 */           datos.put("vencido", this.jLabel72.getText());
/* 3591 */           datos.put("porVencer", this.jLabel82.getText());
/* 3592 */           datos.put("totalGral", this.jLabel83.getText());
/* 3593 */           JRTableModelDataSource jRTableModelDataSource = new JRTableModelDataSource(this.TablaAux.getModel());
/* 3594 */           JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Proveedores/Prov_Tarjetadeudor_Saldos.jasper"), datos, (JRDataSource)jRTableModelDataSource);
/* 3595 */           JasperViewer visor = new JasperViewer(print, false);
/* 3596 */           visor.setTitle("Reporte de cuentas por cobrar");
/* 3597 */           visor.setIconImage(this.iconoImprimir);
/* 3598 */           visor.setZoomRatio(0.59F);
/* 3599 */           visor.setExtendedState(6);
/* 3600 */           visor.setVisible(true);
/* 3601 */         } catch (JRException e) {
/* 3602 */           System.out.println(e.getMessage());
/* 3603 */           Logger.getLogger(TarjetaCliente.class.getName()).log(Level.SEVERE, (String)null, (Throwable)e);
/*      */         } 
/*      */       } else {
/* 3606 */         JOptionPane.showMessageDialog(this.padre, "No hay deudores en la consulta, verifica tu información", "Sin deudores", 0, this.ADVER);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox12ActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   private void jRadioButton3ActionPerformed(ActionEvent evt) {
/* 3615 */     this.jDateChooser1.setEnabled(false);
/* 3616 */     this.jLabel42.setEnabled(false);
/*      */   }
/*      */   
/*      */   private void jRadioButton4ActionPerformed(ActionEvent evt) {
/* 3620 */     this.jDateChooser1.setEnabled(true);
/* 3621 */     this.jLabel42.setEnabled(true);
/*      */   }
/*      */   
/*      */   private void materialButton31ActionPerformed(ActionEvent evt) {
/* 3625 */     this.jDialog11.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton19ActionPerformed(ActionEvent evt) {
/* 3629 */     if (this.jRadioButton4.isSelected()) {
/* 3630 */       boolean correcto = false;
/* 3631 */       if (this.jDateChooser1.getDate() == null) {
/* 3632 */         int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de corte no la puedes dejar vacía, por favor verifica tu información<br><b>Formato Correcto.- <font color = red>'DD-MM-AAAA'</font><hr>¿Deseas insertar la fecha actual en el campo?</html>", "Fecha de corte vacía", 0, 3, this.PREG);
/* 3633 */         if (res == 0) {
/* 3634 */           this.jDateChooser1.setDate(new Date());
/* 3635 */           correcto = true;
/*      */         } 
/* 3637 */       } else if (this.jDateChooser1.getDate().after(new Date())) {
/* 3638 */         int res = JOptionPane.showConfirmDialog(this.padre, "<html>La fecha de corte no puede ser mayor a la fecha de HOY, por favor verifica tu información<br>¿Deseas insertar la fecha actual en el campo?</html>", "Fecha no Válida", 0, 3, this.PREG);
/* 3639 */         if (res == 0) {
/* 3640 */           this.jDateChooser1.setDate(new Date());
/* 3641 */           correcto = true;
/*      */         } 
/*      */       } else {
/* 3644 */         correcto = true;
/*      */       } 
/* 3646 */       if (correcto) {
/* 3647 */         SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 3648 */         String cadenaFecha = "";
/* 3649 */         cadenaFecha = formato.format(this.jDateChooser1.getDate());
/* 3650 */         String AÑO = cadenaFecha.substring(0, 4);
/* 3651 */         String MES = cadenaFecha.substring(4, 6);
/* 3652 */         String DIA = cadenaFecha.substring(6, 8);
/* 3653 */         String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/*      */         
/* 3655 */         (new String[8])[0] = "Tarjeta"; (new String[8])[1] = "Cliente"; (new String[8])[2] = "Folio"; (new String[8])[3] = "Fecha"; (new String[8])[4] = "Fecha de Pago"; (new String[8])[5] = "total"; (new String[8])[6] = "Resta"; (new String[8])[7] = "Estatus"; this.TablaGral.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos(8, "prov_tarjetadeudor.numProv, prov_proveedores.razonSocial, prov_tarjetadeudor.factura, prov_facturas.fechaRecepcion, prov_tarjetadeudor.fechaPago, prov_tarjetadeudor.importeLetra, prov_tarjetadeudor.importeRestanteLetra, prov_tarjetadeudor.estatus", "prov_tarjetadeudor, prov_proveedores, prov_facturas", "where prov_tarjetadeudor.numFactura = prov_facturas.numFactura and prov_tarjetadeudor.numProv = prov_proveedores.numProv and prov_tarjetadeudor.tipoConcep=1 and (prov_tarjetadeudor.estatus like '%<Por Pagar%' || prov_tarjetadeudor.estatus like '%<Abono%') and (prov_tarjetadeudor.numProv = " + 
/* 3656 */                 String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)) + " and prov_tarjetadeudor.fechaPago<=" + fechaCompleta1 + ") order by prov_proveedores.razonsocial asc, prov_facturas.fechaRecepcion asc"), (Object[])new String[8]) {
/* 3657 */               boolean[] canEdit = new boolean[] { 
/*      */                   false, false, false, false, false, false, false, false, false, false, 
/*      */                   false };
/*      */               
/*      */               public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 3662 */                 return this.canEdit[columnIndex];
/*      */               }
/*      */             });
/* 3665 */         this.jLabel61.setText("" + this.TablaGral.getRowCount());
/* 3666 */         double TOTALNETO = 0.0D;
/* 3667 */         double TOTAL30 = 0.0D;
/* 3668 */         double TOTAL60 = 0.0D;
/* 3669 */         double TOTAL90 = 0.0D;
/* 3670 */         double TOTALMAS = 0.0D;
/* 3671 */         double TOTALDEBE = 0.0D;
/* 3672 */         this.TablaAux = new JTable(this.TablaGral.getRowCount(), 10);
/* 3673 */         for (int i = 0; i < this.TablaGral.getRowCount(); i++) {
/* 3674 */           this.TablaAux.setValueAt(Integer.valueOf(i + 1), i, 0);
/* 3675 */           this.TablaAux.setValueAt(this.TablaGral.getValueAt(i, 2), i, 1);
/* 3676 */           String fecha = this.TablaGral.getValueAt(i, 3).toString();
/* 3677 */           String col = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 3678 */           this.TablaAux.setValueAt(col, i, 2);
/* 3679 */           fecha = this.TablaGral.getValueAt(i, 4).toString();
/* 3680 */           col = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 3681 */           this.TablaAux.setValueAt(col, i, 3);
/* 3682 */           this.TablaAux.setValueAt(this.TablaGral.getValueAt(i, 5), i, 4);
/* 3683 */           this.TablaAux.setValueAt(this.TablaGral.getValueAt(i, 7), i, 5);
/* 3684 */           Date fechaInicial = this.jDateChooser1.getDate();
/* 3685 */           Date fechaFinal = convierteTextoAFecha(this.TablaGral.getValueAt(i, 4).toString());
/* 3686 */           long diferenciaDias = fechaInicial.getTime() - fechaFinal.getTime();
/* 3687 */           long dias = diferenciaDias / 86400000L;
/* 3688 */           if (dias <= 30L) {
/* 3689 */             this.TablaAux.setValueAt(this.TablaGral.getValueAt(i, 6), i, 6);
/* 3690 */             TOTAL30 += convertirCantTexto(this.TablaGral.getValueAt(i, 6).toString());
/* 3691 */             this.TablaAux.setValueAt("", i, 7);
/* 3692 */             this.TablaAux.setValueAt("", i, 8);
/* 3693 */             this.TablaAux.setValueAt("", i, 9);
/* 3694 */           } else if (dias > 30L && dias <= 60L) {
/* 3695 */             this.TablaAux.setValueAt(this.TablaGral.getValueAt(i, 6), i, 7);
/* 3696 */             TOTAL60 += convertirCantTexto(this.TablaGral.getValueAt(i, 6).toString());
/* 3697 */             this.TablaAux.setValueAt("", i, 6);
/* 3698 */             this.TablaAux.setValueAt("", i, 8);
/* 3699 */             this.TablaAux.setValueAt("", i, 9);
/* 3700 */           } else if (dias > 60L && dias <= 90L) {
/* 3701 */             this.TablaAux.setValueAt(this.TablaGral.getValueAt(i, 6), i, 8);
/* 3702 */             TOTAL90 += convertirCantTexto(this.TablaGral.getValueAt(i, 6).toString());
/* 3703 */             this.TablaAux.setValueAt("", i, 6);
/* 3704 */             this.TablaAux.setValueAt("", i, 7);
/* 3705 */             this.TablaAux.setValueAt("", i, 9);
/*      */           } else {
/* 3707 */             this.TablaAux.setValueAt(this.TablaGral.getValueAt(i, 6), i, 9);
/* 3708 */             TOTALMAS += convertirCantTexto(this.TablaGral.getValueAt(i, 6).toString());
/* 3709 */             this.TablaAux.setValueAt("", i, 6);
/* 3710 */             this.TablaAux.setValueAt("", i, 7);
/* 3711 */             this.TablaAux.setValueAt("", i, 8);
/*      */           } 
/* 3713 */           TOTALNETO += convertirCantTexto(this.TablaGral.getValueAt(i, 5).toString());
/*      */         } 
/* 3715 */         this.cantidad.setValue(Double.valueOf(TOTAL30));
/* 3716 */         this.jLabel72.setText(this.cantidad.getText());
/* 3717 */         this.cantidad.setValue(Double.valueOf(TOTAL60));
/* 3718 */         this.jLabel82.setText(this.cantidad.getText());
/* 3719 */         this.cantidad.setValue(Double.valueOf(TOTAL90));
/* 3720 */         this.jLabel83.setText(this.cantidad.getText());
/* 3721 */         this.cantidad.setValue(Double.valueOf(TOTALMAS));
/* 3722 */         this.jLabel19.setText(this.cantidad.getText());
/* 3723 */         this.cantidad.setValue(Double.valueOf(TOTALNETO));
/* 3724 */         this.jLabel69.setText(this.cantidad.getText());
/* 3725 */         TOTALDEBE = TOTAL30 + TOTAL60 + TOTAL90 + TOTALMAS;
/* 3726 */         this.cantidad.setValue(Double.valueOf(TOTALDEBE));
/* 3727 */         this.jLabel20.setText(this.cantidad.getText());
/*      */         try {
/* 3729 */           formato = new SimpleDateFormat("yyyyMMdd");
/* 3730 */           String cadenaFecha1 = formato.format(this.jDateChooser1.getDate());
/* 3731 */           String año = cadenaFecha1.substring(0, 4);
/* 3732 */           String mes = cadenaFecha1.substring(4, 6);
/* 3733 */           String dia = cadenaFecha1.substring(6, 8);
/* 3734 */           String fechaCompleta = dia + "/" + dia + "/" + mes;
/* 3735 */           String sicret = "LOGO.jpg";
/* 3736 */           String forsis = "forsis100x.jpg";
/* 3737 */           Map<Object, Object> datos = new HashMap<>();
/* 3738 */           datos.put("sucursal", this.CAMPOSGENERALES.get("sucursal"));
/* 3739 */           String[] DAT = this.con.regresaReg("calle,num,col,cp,cd,estadoRegion,rfc, razonSocial", "prov_proveedores", "where numPRov=" + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0)), 8);
/* 3740 */           datos.put("periodo", fechaCompleta);
/* 3741 */           datos.put("documento", (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_pat"));
/* 3742 */           datos.put("sicret", getClass().getResourceAsStream(sicret));
/* 3743 */           datos.put("forsis", getClass().getResourceAsStream(forsis));
/* 3744 */           datos.put("cliente", DAT[7]);
/* 3745 */           datos.put("rfc", DAT[6]);
/* 3746 */           datos.put("direccion", DAT[0] + " " + DAT[0] + " " + DAT[1] + " " + DAT[2] + ", " + DAT[4] + ", " + DAT[3]);
/* 3747 */           datos.put("30Dias", this.jLabel72.getText());
/* 3748 */           datos.put("60Dias", this.jLabel82.getText());
/* 3749 */           datos.put("90Dias", this.jLabel83.getText());
/* 3750 */           datos.put("90Mas", this.jLabel19.getText());
/* 3751 */           datos.put("totalDebe", this.jLabel20.getText());
/* 3752 */           JRTableModelDataSource jRTableModelDataSource = new JRTableModelDataSource(this.TablaAux.getModel());
/* 3753 */           JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Proveedores/Prov_Tarjetadeudor_CuentasPorPagar.jasper"), datos, (JRDataSource)jRTableModelDataSource);
/* 3754 */           JasperViewer visor = new JasperViewer(print, false);
/* 3755 */           visor.setTitle("Reporte de Saldos");
/* 3756 */           visor.setIconImage(this.iconoImprimir);
/* 3757 */           visor.setZoomRatio(0.59F);
/* 3758 */           visor.setExtendedState(6);
/* 3759 */           visor.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
/* 3760 */           visor.setVisible(true);
/* 3761 */         } catch (JRException e) {
/* 3762 */           System.out.println(e.getMessage());
/* 3763 */           Logger.getLogger(TarjetaCliente.class.getName()).log(Level.SEVERE, (String)null, (Throwable)e);
/*      */         } 
/* 3765 */         this.jScrollPane6.setViewportView(this.TablaAux);
/* 3766 */         this.jDialog11.setVisible(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton20ActionPerformed(ActionEvent evt) {
/* 3772 */     this.jDialog12.setVisible(false);
/*      */   }
/*      */   
/*      */   private void materialButton32ActionPerformed(ActionEvent evt) {
/* 3776 */     this.jDialog12.setVisible(false);
/* 3777 */     if (this.jRadioButton5.isSelected()) {
/* 3778 */       this.jDialog10.setVisible(true);
/*      */     } else {
/* 3780 */       System.out.println("año " + añoActual());
/* 3781 */       this.jSpinner1.setValue("" + añoActual());
/* 3782 */       this.jDialog13.setVisible(true);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void materialButton33ActionPerformed(ActionEvent evt) {
/* 3787 */     this.jDialog13.setVisible(false);
/*      */   }
/*      */   
/*      */   public int añoActual() {
/* 3791 */     ZoneId defaultZoneId = ZoneId.systemDefault();
/* 3792 */     Instant instant = (new Date()).toInstant();
/* 3793 */     LocalDate fechaTrans = instant.atZone(defaultZoneId).toLocalDate();
/* 3794 */     return fechaTrans.getYear();
/*      */   }
/*      */   
/*      */   private void materialButton34ActionPerformed(ActionEvent evt) {
/* 3798 */     this.jDialog13.setVisible(false);
/* 3799 */     String[] campos = null;
/* 3800 */     double[] sumasM = null;
/* 3801 */     int vueltas = 0;
/* 3802 */     int cont = 0;
/* 3803 */     String[] Ttotales = null;
/* 3804 */     float FPROMEDIO = 0.0F;
/* 3805 */     String SPROMEDIO = "";
/* 3806 */     if (this.jComboBox8.getSelectedIndex() == 0) {
/* 3807 */       campos = new String[] { "Clave", "Nombre", "Sucursal", "Estatus", "ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC", "PROM" };
/*      */       
/* 3809 */       Ttotales = new String[] { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };
/*      */       
/* 3811 */       sumasM = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D };
/*      */ 
/*      */       
/* 3814 */       vueltas = 12;
/* 3815 */     } else if (this.jComboBox8.getSelectedIndex() == 1) {
/* 3816 */       campos = new String[] { "Clave", "Nombre", "Sucursal", "Estatus", "ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "PROM" };
/*      */       
/* 3818 */       Ttotales = new String[] { "", "", "", "", "", "", "", "", "", "", "" };
/*      */       
/* 3820 */       sumasM = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D };
/* 3821 */       vueltas = 6;
/*      */     } else {
/* 3823 */       campos = new String[] { "Clave", "Nombre", "Sucursal", "Estatus", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC", "PROM" };
/*      */       
/* 3825 */       Ttotales = new String[] { "", "", "", "", "", "", "", "", "", "", "" };
/*      */       
/* 3827 */       sumasM = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D };
/* 3828 */       vueltas = 6;
/* 3829 */       cont = 6;
/*      */     } 
/* 3831 */     this.jTable3.setModel(new DefaultTableModel(new Object[0][], (Object[])campos));
/* 3832 */     this.jScrollPane5.setViewportView(this.jTable3);
/* 3833 */     DefaultTableModel temp = (DefaultTableModel)this.jTable3.getModel();
/* 3834 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/*      */       String[] arrayOfString;
/* 3836 */       Object[] nuevo = null;
/* 3837 */       if (this.jComboBox8.getSelectedIndex() == 0) {
/* 3838 */         arrayOfString = new String[] { this.rSTableMetro1.getValueAt(i, 0).toString(), this.rSTableMetro1.getValueAt(i, 1).toString(), this.rSTableMetro1.getValueAt(i, 4).toString(), this.rSTableMetro1.getValueAt(i, 5).toString(), "$0", "$0", "$0", "$0", "$0", "$0", "$0", "$0", "$0", "$0", "$0", "$0", "$0" };
/*      */       } else {
/* 3840 */         arrayOfString = new String[] { this.rSTableMetro1.getValueAt(i, 0).toString(), this.rSTableMetro1.getValueAt(i, 1).toString(), this.rSTableMetro1.getValueAt(i, 4).toString(), this.rSTableMetro1.getValueAt(i, 5).toString(), "$0", "$0", "$0", "$0", "$0", "$0", "$0" };
/*      */       } 
/* 3842 */       temp.addRow((Object[])arrayOfString);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 3848 */     this.jLabel23.setText("" + temp.getRowCount());
/* 3849 */     this.jLabel25.setText(this.jSpinner1.getValue().toString());
/* 3850 */     String añoSelec = this.jSpinner1.getValue().toString();
/* 3851 */     for (int j = 0; j < this.jTable3.getRowCount(); j++) {
/* 3852 */       String llave = String.valueOf(this.jTable3.getValueAt(j, 0));
/* 3853 */       System.out.println("Prov " + llave + " " + String.valueOf(this.jTable3.getValueAt(j, 1)));
/* 3854 */       String consulta = "";
/* 3855 */       boolean primera = true;
/* 3856 */       String and = "";
/* 3857 */       String numLetra = "";
/* 3858 */       for (int m = 1; m <= vueltas; m++) {
/* 3859 */         int otro = cont + m;
/* 3860 */         if (!primera) {
/* 3861 */           and = " or ";
/*      */         }
/* 3863 */         if (otro < 10) {
/* 3864 */           numLetra = "0" + otro;
/*      */         } else {
/* 3866 */           numLetra = "" + otro;
/*      */         } 
/* 3868 */         consulta = consulta + consulta + " mov=(select max(mov) from prov_tarjetadeudor where numProv =" + and + " and fecha like '" + llave + "-" + añoSelec + "-%%')";
/* 3869 */         primera = false;
/*      */       } 
/* 3871 */       String[][] registros = this.con.buscarDatos(3, "saldoFinalLetra,fecha,saldoFinal", "prov_tarjetadeudor", "where " + consulta);
/* 3872 */       float prom = 0.0F;
/* 3873 */       int n = 0;
/* 3874 */       for (int i1 = 0; i1 < registros.length; i1++) {
/* 3875 */         String mesesito = registros[i1][1].substring(5, 7);
/* 3876 */         int col = Integer.parseInt(mesesito) - cont;
/* 3877 */         this.jTable3.setValueAt(quitarDecimales(registros[i1][0]), j, 3 + col);
/* 3878 */         float cant = Float.parseFloat(registros[i1][2]);
/* 3879 */         sumasM[col - 1] = sumasM[col - 1] + cant;
/* 3880 */         if (cant > 0.0F) {
/* 3881 */           n++;
/* 3882 */           prom += cant;
/*      */         } 
/*      */       } 
/* 3885 */       prom /= n;
/* 3886 */       if (!Float.isNaN(prom)) {
/* 3887 */         this.cantidad.setValue(Float.valueOf(prom));
/* 3888 */         this.jTable3.setValueAt(quitarDecimales(this.cantidad.getText()), j, this.jTable3.getColumnCount() - 1);
/*      */       } 
/*      */     } 
/* 3891 */     int entraProm = 0;
/* 3892 */     for (int k = 0; k < sumasM.length; k++) {
/* 3893 */       this.cantidad.setValue(Double.valueOf(sumasM[k]));
/* 3894 */       Ttotales[k] = this.cantidad.getText();
/* 3895 */       if (sumasM[k] > 0.0D) {
/* 3896 */         FPROMEDIO = (float)(FPROMEDIO + sumasM[k]);
/* 3897 */         entraProm++;
/*      */       } 
/*      */     } 
/* 3900 */     FPROMEDIO /= entraProm;
/* 3901 */     this.cantidad.setValue(Float.valueOf(FPROMEDIO));
/* 3902 */     SPROMEDIO = quitarDecimales(this.cantidad.getText());
/*      */     try {
/* 3904 */       String sicret = "LOGO.jpg";
/* 3905 */       String forsis = "forsis100x.jpg";
/* 3906 */       Map<Object, Object> datos = new HashMap<>();
/* 3907 */       datos.put("sucursal", this.CAMPOSGENERALES.get("sucursal"));
/* 3908 */       datos.put("periodo", String.valueOf(this.jComboBox8.getSelectedItem()) + "/" + String.valueOf(this.jComboBox8.getSelectedItem()));
/* 3909 */       datos.put("usuario", (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.nombre") + " " + (String)this.CAMPOSGENERALES.get("empleados.ap_pat"));
/* 3910 */       datos.put("sicret", getClass().getResourceAsStream(sicret));
/* 3911 */       datos.put("forsis", getClass().getResourceAsStream(forsis));
/* 3912 */       datos.put("mes1", campos[4]);
/* 3913 */       datos.put("mes2", campos[5]);
/* 3914 */       datos.put("mes3", campos[6]);
/* 3915 */       datos.put("mes4", campos[7]);
/* 3916 */       datos.put("mes5", campos[8]);
/* 3917 */       datos.put("mes6", campos[9]);
/* 3918 */       datos.put("Tmes1", quitarDecimales(Ttotales[0]));
/* 3919 */       datos.put("Tmes2", quitarDecimales(Ttotales[1]));
/* 3920 */       datos.put("Tmes3", quitarDecimales(Ttotales[2]));
/* 3921 */       datos.put("Tmes4", quitarDecimales(Ttotales[3]));
/* 3922 */       datos.put("Tmes5", quitarDecimales(Ttotales[4]));
/* 3923 */       datos.put("Tmes6", quitarDecimales(Ttotales[5]));
/* 3924 */       datos.put("TProm", SPROMEDIO);
/* 3925 */       JasperPrint print = null;
/* 3926 */       if (this.jComboBox8.getSelectedIndex() == 0) {
/* 3927 */         datos.put("mes7", campos[10]);
/* 3928 */         datos.put("mes8", campos[11]);
/* 3929 */         datos.put("mes9", campos[12]);
/* 3930 */         datos.put("mes10", campos[13]);
/* 3931 */         datos.put("mes11", campos[14]);
/* 3932 */         datos.put("mes12", campos[15]);
/* 3933 */         datos.put("Tmes7", quitarDecimales(Ttotales[6]));
/* 3934 */         datos.put("Tmes8", quitarDecimales(Ttotales[7]));
/* 3935 */         datos.put("Tmes9", quitarDecimales(Ttotales[8]));
/* 3936 */         datos.put("Tmes10", quitarDecimales(Ttotales[9]));
/* 3937 */         datos.put("Tmes11", quitarDecimales(Ttotales[10]));
/* 3938 */         datos.put("Tmes12", quitarDecimales(Ttotales[11]));
/* 3939 */         JTable aux = crearTablaAux2(this.jTable3, new Object[] { "Cont", "Clave", "Proveedor", "Sucursal", "Estado", "Mes1", "Mes2", "Mes3", "Mes4", "Mes5", "Mes6", "Mes7", "Mes8", "Mes9", "Mes10", "Mes11", "Mes12", "Prom" });
/*      */ 
/*      */         
/* 3942 */         JRTableModelDataSource jRTableModelDataSource = new JRTableModelDataSource(aux.getModel());
/* 3943 */         print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Proveedores/Prov_Tarjetadeudor_Acumulado2.jasper"), datos, (JRDataSource)jRTableModelDataSource);
/*      */       } else {
/* 3945 */         JTable aux = crearTablaAux1(this.jTable3, new Object[] { "Cont", "Clave", "Proveedor", "Sucursal", "Estado", "Mes1", "Mes2", "Mes3", "Mes4", "Mes5", "Mes6", "Prom" });
/*      */ 
/*      */         
/* 3948 */         JRTableModelDataSource jRTableModelDataSource = new JRTableModelDataSource(aux.getModel());
/* 3949 */         print = JasperFillManager.fillReport(getClass().getResourceAsStream("/Reportes/Proveedores/Prov_Tarjetadeudor_Acumulado1.jasper"), datos, (JRDataSource)jRTableModelDataSource);
/*      */       } 
/* 3951 */       JasperViewer visor = new JasperViewer(print, false);
/* 3952 */       visor.setTitle("Reporte de saldos mensual");
/* 3953 */       visor.setIconImage(this.iconoImprimir);
/* 3954 */       visor.setZoomRatio(0.59F);
/* 3955 */       visor.setExtendedState(6);
/* 3956 */       visor.setVisible(true);
/* 3957 */     } catch (JRException e) {
/* 3958 */       System.out.println(e.getMessage());
/* 3959 */       Logger.getLogger(TarjetaCliente.class.getName()).log(Level.SEVERE, (String)null, (Throwable)e);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void jComboBox8ActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 3967 */     this.jDialog14.setVisible(false);
/*      */   }
/*      */ 
/*      */   
/*      */   private void jRadioButton6ActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   public String quitarDecimales(String cantidad) {
/* 3974 */     return cantidad.substring(0, cantidad.length() - 3);
/*      */   }
/*      */   
/*      */   public JTable crearTablaAux1(JTable Original, Object[] columnas) {
/* 3978 */     Object[] Columnas = columnas;
/* 3979 */     Object[][] registros = new Object[Original.getRowCount()][columnas.length];
/* 3980 */     for (int i = 0; i < Original.getRowCount(); i++) {
/* 3981 */       registros[i][0] = Integer.valueOf(i + 1);
/* 3982 */       for (int j = 0; j < Original.getColumnCount(); j++) {
/* 3983 */         if (j == 0) {
/* 3984 */           registros[i][1] = Original.getValueAt(i, j);
/*      */         }
/* 3986 */         if (j == 1) {
/* 3987 */           registros[i][2] = Original.getValueAt(i, j);
/*      */         }
/* 3989 */         if (j == 2) {
/* 3990 */           registros[i][3] = Original.getValueAt(i, j);
/*      */         }
/* 3992 */         if (j == 3) {
/* 3993 */           registros[i][4] = Original.getValueAt(i, j);
/*      */         }
/* 3995 */         if (j == 4) {
/* 3996 */           registros[i][5] = Original.getValueAt(i, j);
/*      */         }
/* 3998 */         if (j == 5) {
/* 3999 */           registros[i][6] = Original.getValueAt(i, j);
/*      */         }
/* 4001 */         if (j == 6) {
/* 4002 */           registros[i][7] = Original.getValueAt(i, j);
/*      */         }
/* 4004 */         if (j == 7) {
/* 4005 */           registros[i][8] = Original.getValueAt(i, j);
/*      */         }
/* 4007 */         if (j == 8) {
/* 4008 */           registros[i][9] = Original.getValueAt(i, j);
/*      */         }
/* 4010 */         if (j == 9) {
/* 4011 */           registros[i][10] = Original.getValueAt(i, j);
/*      */         }
/* 4013 */         if (j == 10) {
/* 4014 */           registros[i][11] = Original.getValueAt(i, j);
/*      */         }
/*      */       } 
/*      */     } 
/* 4018 */     JTable aux = new JTable(registros, Columnas);
/* 4019 */     return aux;
/*      */   }
/*      */   
/*      */   public JTable crearTablaAux2(JTable Original, Object[] columnas) {
/* 4023 */     Object[] Columnas = columnas;
/* 4024 */     Object[][] registros = new Object[Original.getRowCount()][columnas.length];
/* 4025 */     for (int i = 0; i < Original.getRowCount(); i++) {
/* 4026 */       registros[i][0] = Integer.valueOf(i + 1);
/* 4027 */       for (int j = 0; j < Original.getColumnCount(); j++) {
/* 4028 */         if (j == 0) {
/* 4029 */           registros[i][1] = Original.getValueAt(i, j);
/*      */         }
/* 4031 */         if (j == 1) {
/* 4032 */           registros[i][2] = Original.getValueAt(i, j);
/*      */         }
/* 4034 */         if (j == 2) {
/* 4035 */           registros[i][3] = Original.getValueAt(i, j);
/*      */         }
/* 4037 */         if (j == 3) {
/* 4038 */           registros[i][4] = Original.getValueAt(i, j);
/*      */         }
/* 4040 */         if (j == 4) {
/* 4041 */           registros[i][5] = Original.getValueAt(i, j);
/*      */         }
/* 4043 */         if (j == 5) {
/* 4044 */           registros[i][6] = Original.getValueAt(i, j);
/*      */         }
/* 4046 */         if (j == 6) {
/* 4047 */           registros[i][7] = Original.getValueAt(i, j);
/*      */         }
/* 4049 */         if (j == 7) {
/* 4050 */           registros[i][8] = Original.getValueAt(i, j);
/*      */         }
/* 4052 */         if (j == 8) {
/* 4053 */           registros[i][9] = Original.getValueAt(i, j);
/*      */         }
/* 4055 */         if (j == 9) {
/* 4056 */           registros[i][10] = Original.getValueAt(i, j);
/*      */         }
/* 4058 */         if (j == 10) {
/* 4059 */           registros[i][11] = Original.getValueAt(i, j);
/*      */         }
/* 4061 */         if (j == 11) {
/* 4062 */           registros[i][12] = Original.getValueAt(i, j);
/*      */         }
/* 4064 */         if (j == 12) {
/* 4065 */           registros[i][13] = Original.getValueAt(i, j);
/*      */         }
/* 4067 */         if (j == 13) {
/* 4068 */           registros[i][14] = Original.getValueAt(i, j);
/*      */         }
/* 4070 */         if (j == 14) {
/* 4071 */           registros[i][15] = Original.getValueAt(i, j);
/*      */         }
/* 4073 */         if (j == 15) {
/* 4074 */           registros[i][16] = Original.getValueAt(i, j);
/*      */         }
/* 4076 */         if (j == 16) {
/* 4077 */           registros[i][17] = Original.getValueAt(i, j);
/*      */         }
/*      */       } 
/*      */     } 
/* 4081 */     JTable aux = new JTable(registros, Columnas);
/* 4082 */     return aux;
/*      */   }
/*      */   
/*      */   public Date convierteTextoAFecha(String fechaTexto) {
/* 4086 */     String fechaCorta = fechaTexto.substring(0, 10);
/* 4087 */     String año = fechaCorta.substring(0, 4);
/* 4088 */     String mes = fechaCorta.substring(5, 7);
/* 4089 */     String dia = fechaCorta.substring(8, 10);
/* 4090 */     SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 4091 */     String strFecha = dia + "-" + dia + "-" + mes;
/* 4092 */     Date fechaT = null;
/*      */     try {
/* 4094 */       fechaT = formatoDelTexto.parse(strFecha);
/* 4095 */     } catch (ParseException ex) {
/* 4096 */       ex.printStackTrace();
/*      */     } 
/* 4098 */     return fechaT;
/*      */   }
/*      */   
/*      */   public void cambiarSaldo() {
/* 4102 */     int ind = this.rSTableMetro7.getSelectedRow();
/* 4103 */     double abono = Double.parseDouble(String.valueOf(this.importe3.getValue()));
/* 4104 */     double resta = convertirCantTexto(this.rSTableMetro7.getValueAt(ind, 3).toString());
/* 4105 */     if (abono < 0.0D) {
/* 4106 */       JOptionPane.showMessageDialog(this.jDialog5, "No puedes colocar cantidades negativas en el campo", "Cantidad negativa", 0, this.ERROR);
/* 4107 */     } else if (abono > resta) {
/* 4108 */       JOptionPane.showMessageDialog(this.jDialog5, "La cantidad que colocaste es mayor al resto de la factura\nVerifica tus cantidades", "Cantidad mayor", 0, this.ERROR);
/*      */     } else {
/* 4110 */       this.rSTableMetro7.setValueAt(this.importe3.getText(), this.rSTableMetro7.getSelectedRow(), 4);
/* 4111 */       this.jDialog5.setVisible(false);
/* 4112 */       sumarFacturas();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void pasarFactura() {
/* 4117 */     int ind = this.rSTableMetro6.getSelectedRow();
/* 4118 */     DefaultTableModel temp = (DefaultTableModel)this.rSTableMetro7.getModel();
/* 4119 */     String[] arrayOfString = new String[6];
/* 4120 */     arrayOfString[0] = (String)this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 0);
/* 4121 */     arrayOfString[1] = (String)this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 1);
/* 4122 */     arrayOfString[2] = (String)this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 2);
/* 4123 */     arrayOfString[3] = (String)this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 3);
/* 4124 */     arrayOfString[4] = (String)this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 3);
/* 4125 */     arrayOfString[5] = (String)this.rSTableMetro6.getValueAt(this.rSTableMetro6.getSelectedRow(), 4);
/* 4126 */     temp.addRow((Object[])arrayOfString);
/* 4127 */     temp = (DefaultTableModel)this.rSTableMetro6.getModel();
/* 4128 */     temp.removeRow(ind);
/* 4129 */     sumarFacturas();
/*      */   }
/*      */   
/*      */   public void limpiarTablaFactporPagar() {
/* 4133 */     (new String[6])[0] = "Mov"; (new String[6])[1] = "Referencia"; (new String[6])[2] = "Importe"; (new String[6])[3] = "Resta"; (new String[6])[4] = "Abono"; (new String[6])[5] = "ID"; this.rSTableMetro7.setModel(new DefaultTableModel(new Object[0][], (Object[])new String[6]) {
/* 4134 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4137 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4140 */     this.rSTableMetro7.setColumnSelectionAllowed(true);
/* 4141 */     this.rSTableMetro6.setSelectionMode(0);
/* 4142 */     this.rSTableMetro6.setAutoCreateRowSorter(true);
/* 4143 */     this.rSTableMetro7.getTableHeader().setReorderingAllowed(false);
/* 4144 */     this.rSTableMetro7.getColumnModel().getSelectionModel().setSelectionMode(1);
/* 4145 */     this.rSTableMetro7.getColumnModel().getColumn(0).setPreferredWidth(45);
/* 4146 */     this.rSTableMetro7.getColumnModel().getColumn(0).setMaxWidth(45);
/* 4147 */     this.rSTableMetro7.getColumnModel().getColumn(1).setPreferredWidth(120);
/* 4148 */     this.rSTableMetro7.getColumnModel().getColumn(1).setMaxWidth(120);
/* 4149 */     this.rSTableMetro7.getColumnModel().getColumn(5).setPreferredWidth(30);
/* 4150 */     this.rSTableMetro7.getColumnModel().getColumn(5).setMaxWidth(30);
/* 4151 */     this.rSTableMetro7.getColumnModel().getColumn(0).setCellRenderer(this.celda4);
/* 4152 */     this.rSTableMetro7.getColumnModel().getColumn(1).setCellRenderer(this.celda4);
/* 4153 */     this.rSTableMetro7.getColumnModel().getColumn(2).setCellRenderer(this.celda4);
/* 4154 */     this.rSTableMetro7.getColumnModel().getColumn(3).setCellRenderer(this.celda4);
/* 4155 */     this.rSTableMetro7.getColumnModel().getColumn(4).setCellRenderer(this.celda4);
/* 4156 */     this.rSTableMetro7.getColumnModel().getColumn(5).setCellRenderer(this.celda4);
/* 4157 */     this.rSTableMetro7.setFont(new Font("Cantarell", 0, 10));
/* 4158 */     sumarFacturas();
/*      */   }
/*      */   
/*      */   public void cargarChequeTrans() {
/* 4162 */     int indice = this.rSTableMetro3.getSelectedRow();
/* 4163 */     String factAmp = "";
/* 4164 */     if (this.entraCheque) {
/* 4165 */       this.chequeAsignado = new Cheques(this.rSTableMetro3.getValueAt(indice, 0).toString(), this.rSTableMetro3.getValueAt(indice, 1).toString(), this.rSTableMetro3.getValueAt(indice, 2).toString(), this.rSTableMetro3.getValueAt(indice, 3).toString(), this.rSTableMetro3.getValueAt(indice, 4).toString());
/* 4166 */       this.jTextField6.setText("POL: " + this.chequeAsignado.getPoliza() + ", CHEQUE: " + this.chequeAsignado.getCheque());
/* 4167 */       this.importe2.setValue(Double.valueOf(convertirCantTexto(this.chequeAsignado.getImporte())));
/* 4168 */       factAmp = this.chequeAsignado.getConcepto();
/*      */     } else {
/* 4170 */       this.transferenciaAsignada = new Transferencias(this.rSTableMetro3.getValueAt(indice, 0).toString(), this.rSTableMetro3.getValueAt(indice, 1).toString(), this.rSTableMetro3.getValueAt(indice, 2).toString(), this.rSTableMetro3.getValueAt(indice, 3).toString(), this.rSTableMetro3.getValueAt(indice, 4).toString());
/* 4171 */       this.jTextField6.setText("TRANS: " + this.transferenciaAsignada.getFolio());
/* 4172 */       this.importe2.setValue(Double.valueOf(convertirCantTexto(this.transferenciaAsignada.getImporte())));
/* 4173 */       factAmp = this.transferenciaAsignada.getConcepto();
/*      */     } 
/* 4175 */     for (int i = 0; i < this.rSTableMetro6.getRowCount(); i++) {
/* 4176 */       String ref = this.rSTableMetro6.getValueAt(i, 1).toString();
/* 4177 */       if (factAmp.contains(ref)) {
/* 4178 */         DefaultTableModel temp = (DefaultTableModel)this.rSTableMetro7.getModel();
/* 4179 */         String[] arrayOfString = new String[6];
/* 4180 */         arrayOfString[0] = (String)this.rSTableMetro6.getValueAt(i, 0);
/* 4181 */         arrayOfString[1] = (String)this.rSTableMetro6.getValueAt(i, 1);
/* 4182 */         arrayOfString[2] = (String)this.rSTableMetro6.getValueAt(i, 2);
/* 4183 */         arrayOfString[3] = (String)this.rSTableMetro6.getValueAt(i, 3);
/* 4184 */         arrayOfString[4] = (String)this.rSTableMetro6.getValueAt(i, 3);
/* 4185 */         arrayOfString[5] = (String)this.rSTableMetro6.getValueAt(i, 4);
/* 4186 */         temp.addRow((Object[])arrayOfString);
/* 4187 */         temp = (DefaultTableModel)this.rSTableMetro6.getModel();
/* 4188 */         temp.removeRow(i);
/* 4189 */         sumarFacturas();
/*      */       } 
/*      */     } 
/* 4192 */     this.jTextField6.setToolTipText(this.jTextField6.getText());
/* 4193 */     this.jDialog4.setVisible(false);
/*      */   }
/*      */   
/*      */   public void sumarFacturas() {
/* 4197 */     double TOTAL = 0.0D;
/* 4198 */     for (int j = 0; j < this.rSTableMetro7.getRowCount(); j++) {
/* 4199 */       String canti = String.valueOf(this.rSTableMetro7.getValueAt(j, 4));
/* 4200 */       String valorP = "";
/* 4201 */       for (int i = 0; i < canti.length(); i++) {
/* 4202 */         if (canti.charAt(i) != '$' && canti.charAt(i) != ',' && canti.charAt(i) != '-') {
/* 4203 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 4206 */       TOTAL += Double.parseDouble(valorP);
/*      */     } 
/* 4208 */     this.cantidad.setValue(Double.valueOf(TOTAL));
/* 4209 */     this.jLabel9.setText(this.cantidad.getText());
/* 4210 */     this.jLabel59.setText("Facturas seleccionadas para pago: " + this.rSTableMetro7.getRowCount());
/*      */   }
/*      */   
/*      */   public String sacarFechaHoy() {
/* 4214 */     Date fechaHoy = new Date(Calendar.getInstance().getTimeInMillis());
/* 4215 */     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
/* 4216 */     return " (" + formatter.format(fechaHoy) + ")";
/*      */   }
/*      */   
/*      */   public double convertirCantTexto(String cant) {
/* 4220 */     String canti = cant;
/* 4221 */     String valorP = "";
/* 4222 */     for (int j = 0; j < canti.length(); j++) {
/* 4223 */       if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 4224 */         valorP = valorP + valorP;
/*      */       }
/*      */     } 
/* 4227 */     return Double.parseDouble(valorP);
/*      */   }
/*      */   
/*      */   public void colorear() {
/* 4231 */     this.pintar.colorear(this.jTextField1);
/* 4232 */     this.pintar.colorear(this.jComboBox1);
/* 4233 */     this.pintar.colorear(this.jComboBox2);
/* 4234 */     this.pintar.colorear(this.jComboBox4);
/* 4235 */     this.pintar.colorear(this.jComboBox5);
/* 4236 */     this.pintar.colorear(this.jComboBox6);
/* 4237 */     this.pintar.colorear(this.jTextField18);
/* 4238 */     this.pintar.colorear(this.importe1);
/* 4239 */     this.pintar.colorear(this.jTextArea2);
/* 4240 */     this.pintar.colorear(this.jTextField4);
/* 4241 */     this.pintar.colorear(this.jTextField6);
/* 4242 */     this.pintar.colorear(this.importe2);
/* 4243 */     this.pintar.colorear(this.importe3);
/* 4244 */     this.pintar.colorear(this.jTextField5);
/* 4245 */     this.pintar.colorear(this.jComboBox3);
/*      */   }
/*      */   
/*      */   public void privilegios() {
/* 4249 */     if (((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPER USUARIO") || ((String)this.CAMPOSGENERALES.get("priv")).toString().equals("SUPERVISOR DE CUENTAS POR PAGAR")) {
/* 4250 */       this.jComboBox1.setEnabled(true);
/*      */     } else {
/* 4252 */       this.jComboBox1.setEnabled(false);
/* 4253 */       this.jComboBox1.setSelectedItem(((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/*      */     } 
/* 4255 */     this.jComboBox1.setSelectedItem(((String)this.CAMPOSGENERALES.get("sucursal")).toString());
/*      */   }
/*      */   
/*      */   public void verTarjeta() {
/* 4259 */     this.ACTIVARCONSULTA = false;
/* 4260 */     this.jComboBox5.setSelectedIndex(0);
/* 4261 */     this.jComboBox4.setSelectedIndex(0);
/* 4262 */     this.jComboBox6.setSelectedIndex(0);
/* 4263 */     this.CLAVEPROV = String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 0));
/* 4264 */     this.jLabel62.setText("TARJETA DE " + String.valueOf(this.rSTableMetro1.getValueAt(this.rSTableMetro1.getSelectedRow(), 1)));
/* 4265 */     consultarContenido();
/* 4266 */     if (this.rSTableMetro2.getRowCount() > 0) {
/* 4267 */       String fecha = String.valueOf(this.rSTableMetro2.getValueAt(this.rSTableMetro2.getRowCount() - 1, 1));
/* 4268 */       String fechaCorta = fecha.substring(0, 10);
/* 4269 */       String FechaNormal = fecha.substring(8, 10) + "/" + fecha.substring(8, 10) + "/" + fecha.substring(5, 7);
/* 4270 */       String año = fechaCorta.substring(0, 4);
/* 4271 */       String mes = fechaCorta.substring(5, 7);
/* 4272 */       String dia = fechaCorta.substring(8, 10);
/* 4273 */       SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
/* 4274 */       String strFecha = dia + "-" + dia + "-" + mes;
/* 4275 */       Date fechaT = null;
/*      */       try {
/* 4277 */         fechaT = formatoDelTexto.parse(strFecha);
/* 4278 */       } catch (ParseException ex) {
/* 4279 */         ex.printStackTrace();
/*      */       } 
/*      */     } 
/* 4282 */     this.jDialog1.setVisible(true);
/*      */   }
/*      */   
/*      */   public void consultarContenido() {
/* 4286 */     String consulta = "";
/* 4287 */     Date fechaI = this.jDateChooser7.getDate();
/* 4288 */     Date fechaT = this.jDateChooser8.getDate();
/* 4289 */     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
/* 4290 */     String cadenaFecha = "";
/* 4291 */     cadenaFecha = formato.format(fechaI);
/* 4292 */     String AÑO = cadenaFecha.substring(0, 4);
/* 4293 */     String MES = cadenaFecha.substring(4, 6);
/* 4294 */     String DIA = cadenaFecha.substring(6, 8);
/* 4295 */     String fechaCompleta1 = "'" + AÑO + "-" + MES + "-" + DIA + "'";
/* 4296 */     formato = new SimpleDateFormat("yyyyMMdd");
/* 4297 */     cadenaFecha = formato.format(fechaT);
/* 4298 */     AÑO = cadenaFecha.substring(0, 4);
/* 4299 */     MES = cadenaFecha.substring(4, 6);
/* 4300 */     DIA = cadenaFecha.substring(6, 8);
/* 4301 */     String fechaCompleta2 = "'" + AÑO + "-" + MES + "-" + DIA + " 23:59:59'";
/* 4302 */     String concepto = String.valueOf(this.jComboBox4.getSelectedItem());
/* 4303 */     String estatus = "";
/* 4304 */     if (this.jComboBox4.getSelectedIndex() == 1) {
/* 4305 */       concepto = " and concepto like 'Cargo%'";
/* 4306 */     } else if (this.jComboBox4.getSelectedIndex() == 2) {
/* 4307 */       concepto = " and concepto like 'Abono%'";
/*      */     } else {
/* 4309 */       concepto = "";
/*      */     } 
/* 4311 */     if (this.jComboBox6.getSelectedIndex() == 1) {
/* 4312 */       estatus = " and estatus ='<Por Pagar>'";
/* 4313 */     } else if (this.jComboBox6.getSelectedIndex() == 2) {
/* 4314 */       estatus = " and estatus like '%<Pagado%'";
/* 4315 */     } else if (this.jComboBox6.getSelectedIndex() == 3) {
/* 4316 */       estatus = " and estatus like '%<Abono%'";
/* 4317 */     } else if (this.jComboBox6.getSelectedIndex() == 4) {
/* 4318 */       estatus = " and estatus like '%<Cancelado%'";
/*      */     } else {
/* 4320 */       estatus = "";
/*      */     } 
/* 4322 */     String ref = String.valueOf(this.jComboBox5.getSelectedItem());
/* 4323 */     if (!ref.equals("TODOS") && !ref.equals("todos")) {
/* 4324 */       ref = " and referencia like '%" + ref + "%'";
/*      */     } else {
/* 4326 */       ref = "";
/*      */     } 
/* 4328 */     if (this.ACTIVARCONSULTA) {
/* 4329 */       consulta = consulta + "and fecha between " + consulta + " and " + fechaCompleta1;
/*      */     }
/*      */     
/* 4332 */     (new String[9])[0] = "Mov."; (new String[9])[1] = "Fecha"; (new String[9])[2] = "Concepto"; (new String[9])[3] = "Referencia"; (new String[9])[4] = "Importe"; (new String[9])[5] = "Abono"; (new String[9])[6] = "Debe"; (new String[9])[7] = "Saldo"; (new String[9])[8] = "Estado"; this.rSTableMetro2.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos(9, "mov,fecha,concepto,referencia,importeLetra,abonoLetra,ImporteRestanteLetra,saldoFinalLetra,estatus", "prov_tarjetadeudor", "where numProv=" + this.CLAVEPROV + " " + consulta + " " + estatus + " " + concepto + " " + ref + " order by mov desc"), (Object[])new String[9]) {
/* 4333 */           boolean[] canEdit = new boolean[] { 
/*      */               false, false, false, false, false, false, false, false, false, false, 
/*      */               false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4338 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4341 */     this.jLabel56.setText(" " + this.rSTableMetro2.getRowCount() + " Movimientos encontrados.");
/* 4342 */     if (this.rSTableMetro2.getRowCount() > 0) {
/* 4343 */       this.jTextField2.setText(String.valueOf(this.rSTableMetro2.getValueAt(0, 7)));
/*      */     } else {
/* 4345 */       this.jTextField2.setText("$0.00");
/*      */     } 
/* 4347 */     this.celda3.pasarInd(this.con.revisarCol((JTable)this.rSTableMetro2, "<Por Pagar>", 0, 8, 0));
/* 4348 */     this.celda3.pasarInd2(this.con.revisarCol((JTable)this.rSTableMetro2, "<Cancelado", 0, 8, 2));
/* 4349 */     this.celda3.pasarInd3(this.con.revisarCol((JTable)this.rSTableMetro2, "<Abono", 0, 8, 2));
/* 4350 */     this.rSTableMetro2.setShowVerticalLines(false);
/* 4351 */     this.rSTableMetro2.setSelectionMode(0);
/* 4352 */     this.rSTableMetro2.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 4353 */     this.rSTableMetro2.getColumnModel().getColumn(0).setMaxWidth(50);
/* 4354 */     this.rSTableMetro2.getColumnModel().getColumn(1).setPreferredWidth(130);
/* 4355 */     this.rSTableMetro2.getColumnModel().getColumn(1).setMaxWidth(130);
/* 4356 */     this.rSTableMetro2.getColumnModel().getColumn(4).setPreferredWidth(90);
/* 4357 */     this.rSTableMetro2.getColumnModel().getColumn(4).setMaxWidth(90);
/* 4358 */     this.rSTableMetro2.getColumnModel().getColumn(5).setPreferredWidth(90);
/* 4359 */     this.rSTableMetro2.getColumnModel().getColumn(5).setMaxWidth(90);
/* 4360 */     this.rSTableMetro2.getColumnModel().getColumn(6).setPreferredWidth(90);
/* 4361 */     this.rSTableMetro2.getColumnModel().getColumn(6).setMaxWidth(90);
/* 4362 */     this.rSTableMetro2.getColumnModel().getColumn(0).setCellRenderer(this.celda3);
/* 4363 */     this.rSTableMetro2.getColumnModel().getColumn(1).setCellRenderer(this.celda3);
/* 4364 */     this.rSTableMetro2.getColumnModel().getColumn(2).setCellRenderer(this.celda3);
/* 4365 */     this.rSTableMetro2.getColumnModel().getColumn(3).setCellRenderer(this.celda3);
/* 4366 */     this.rSTableMetro2.getColumnModel().getColumn(4).setCellRenderer(this.celda3);
/* 4367 */     this.rSTableMetro2.getColumnModel().getColumn(5).setCellRenderer(this.celda3);
/* 4368 */     this.rSTableMetro2.getColumnModel().getColumn(6).setCellRenderer(this.celda3);
/* 4369 */     this.rSTableMetro2.getColumnModel().getColumn(7).setCellRenderer(this.celda3);
/* 4370 */     this.rSTableMetro2.getColumnModel().getColumn(8).setCellRenderer(this.celda3);
/* 4371 */     this.rSTableMetro2.setFont(new Font("Cantarell", 0, 10));
/* 4372 */     if (!this.ACTIVARCONSULTA) {
/* 4373 */       String fecha1 = "";
/* 4374 */       String fecha2 = "";
/* 4375 */       if (this.rSTableMetro2.getRowCount() > 0) {
/* 4376 */         fecha1 = String.valueOf(this.rSTableMetro2.getValueAt(this.rSTableMetro2.getRowCount() - 1, 1));
/* 4377 */         fecha2 = String.valueOf(this.rSTableMetro2.getValueAt(0, 1));
/* 4378 */         String año = fecha1.substring(0, 4);
/* 4379 */         String mes = fecha1.substring(5, 7);
/* 4380 */         String dia = fecha1.substring(8, 10);
/* 4381 */         SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4382 */         String strFecha = año + "-" + año + "-" + mes;
/* 4383 */         Date fecha = null;
/*      */         try {
/* 4385 */           fecha = formatoDelTexto.parse(strFecha);
/* 4386 */         } catch (ParseException ex) {
/* 4387 */           ex.printStackTrace();
/*      */         } 
/* 4389 */         this.jDateChooser7.setDate(fecha);
/* 4390 */         año = fecha2.substring(0, 4);
/* 4391 */         mes = fecha2.substring(5, 7);
/* 4392 */         dia = fecha2.substring(8, 10);
/* 4393 */         formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
/* 4394 */         strFecha = año + "-" + año + "-" + mes;
/* 4395 */         fecha = null;
/*      */         try {
/* 4397 */           fecha = formatoDelTexto.parse(strFecha);
/* 4398 */         } catch (ParseException ex) {
/* 4399 */           ex.printStackTrace();
/*      */         } 
/* 4401 */         this.jDateChooser8.setDate(fecha);
/*      */       } else {
/* 4403 */         this.jDateChooser7.setDate(new Date());
/* 4404 */         this.jDateChooser8.setDate(new Date());
/*      */       } 
/* 4406 */       this.jComboBox4.setSelectedIndex(0);
/* 4407 */       this.ACTIVARCONSULTA = true;
/*      */     } 
/*      */   }
/*      */   
/*      */   public void consultarDatoExtra() {
/* 4412 */     String t = this.jComboBox3.getSelectedItem().toString();
/* 4413 */     String campos = "";
/* 4414 */     String tabla = "";
/* 4415 */     String condicion = "";
/* 4416 */     String[] titulos = null;
/* 4417 */     String[][] matriz = null;
/* 4418 */     String v = "";
/* 4419 */     if (!this.jTextField4.getText().equals(this.holderChequeTrans)) {
/* 4420 */       v = this.jTextField4.getText();
/*      */     }
/* 4422 */     switch (t) {
/*      */       case "CHEQUE":
/* 4424 */         campos = "poliza, fechaPoliza, cheque, concepto, importe";
/* 4425 */         tabla = "prov_cheques";
/* 4426 */         condicion = "where (poliza like '%" + v + "%' or cheque like '%" + v + "%' or beneficiario like '%" + v + "%') and estado ='<Por Aplicar>' and sucOp ='" + (String)this.CAMPOSGENERALES.get("sucursal") + "' and numProv= " + this.CLAVEPROV + " order by fechaPoliza desc, poliza desc";
/* 4427 */         titulos = new String[] { "Póliza", "Fecha", "Cheque", "Concepto", "Importe" };
/* 4428 */         matriz = this.con.buscarDatos(5, campos, tabla, condicion);
/*      */         break;
/*      */       case "TRANSFERENCIA":
/* 4431 */         campos = "folio, fecha, concepto, beneficiario, importe";
/* 4432 */         tabla = "prov_transferencias";
/* 4433 */         condicion = "where (folio like '%" + v + "%' or beneficiario like '%" + v + "%') and estado ='<Por Aplicar>' and sucOp ='" + (String)this.CAMPOSGENERALES.get("sucursal") + "' and numProv= " + this.CLAVEPROV + " order by fecha desc, folio desc";
/* 4434 */         titulos = new String[] { "Folio", "Fecha", "Concepto", "Beneficiario", "Importe" };
/* 4435 */         matriz = this.con.buscarDatos(5, campos, tabla, condicion);
/*      */         break;
/*      */     } 
/* 4438 */     this.rSTableMetro3.setModel(new DefaultTableModel((Object[][])matriz, (Object[])titulos) {
/* 4439 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4442 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4445 */     this.rSTableMetro3.setShowVerticalLines(false);
/* 4446 */     this.rSTableMetro3.setSelectionMode(0);
/* 4447 */     this.rSTableMetro3.setAutoCreateRowSorter(true);
/* 4448 */     this.rSTableMetro3.getTableHeader().setReorderingAllowed(false);
/* 4449 */     if (tabla.equals("prov_cheques")) {
/* 4450 */       this.rSTableMetro3.getColumnModel().getColumn(3).setPreferredWidth(160);
/* 4451 */       this.rSTableMetro3.getColumnModel().getColumn(3).setMaxWidth(160);
/*      */     } else {
/* 4453 */       this.rSTableMetro3.getColumnModel().getColumn(0).setPreferredWidth(60);
/* 4454 */       this.rSTableMetro3.getColumnModel().getColumn(0).setMaxWidth(60);
/* 4455 */       this.rSTableMetro3.getColumnModel().getColumn(1).setPreferredWidth(70);
/* 4456 */       this.rSTableMetro3.getColumnModel().getColumn(1).setMaxWidth(70);
/* 4457 */       this.rSTableMetro3.getColumnModel().getColumn(4).setPreferredWidth(90);
/* 4458 */       this.rSTableMetro3.getColumnModel().getColumn(4).setMaxWidth(90);
/*      */     } 
/* 4460 */     this.rSTableMetro3.getColumnModel().getColumn(0).setCellRenderer(this.celda1);
/* 4461 */     this.rSTableMetro3.getColumnModel().getColumn(1).setCellRenderer(this.celda1);
/* 4462 */     this.rSTableMetro3.getColumnModel().getColumn(2).setCellRenderer(this.celda1);
/* 4463 */     this.rSTableMetro3.getColumnModel().getColumn(3).setCellRenderer(this.celda1);
/* 4464 */     this.rSTableMetro3.getColumnModel().getColumn(4).setCellRenderer(this.celda1);
/* 4465 */     this.rSTableMetro3.setFont(new Font("Cantarell", 0, 10));
/*      */   }
/*      */   
/*      */   public void consultarFacturasPendientes() {
/* 4469 */     String v = "";
/* 4470 */     if (!this.jTextField5.getText().equals(this.holderFactura)) {
/* 4471 */       v = this.jTextField5.getText();
/*      */     }
/*      */     
/* 4474 */     (new String[5])[0] = "Mov"; (new String[5])[1] = "Referencia"; (new String[5])[2] = "Importe"; (new String[5])[3] = "Resta"; (new String[5])[4] = "ID"; this.rSTableMetro6.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos(5, "mov,referencia,importeLetra,importeRestanteLetra,numFactura", "prov_tarjetadeudor", "where (estatus='<Por Pagar>' || estatus like '%Abono:%') and factura like '%" + v + "%' and numProv=" + this.CLAVEPROV + " ORDER BY MOV desc"), (Object[])new String[5]) {
/* 4475 */           Class[] types = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class };
/*      */           
/* 4477 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4480 */             return this.canEdit[columnIndex];
/*      */           }
/*      */           
/*      */           public Class getColumnClass(int columnIndex) {
/* 4484 */             return this.types[columnIndex];
/*      */           }
/*      */         });
/* 4487 */     this.rSTableMetro6.setShowVerticalLines(false);
/* 4488 */     this.rSTableMetro6.setSelectionMode(0);
/* 4489 */     this.rSTableMetro6.setAutoCreateRowSorter(true);
/* 4490 */     this.rSTableMetro6.getTableHeader()
/* 4491 */       .setReorderingAllowed(false);
/* 4492 */     this.rSTableMetro6.getColumnModel()
/* 4493 */       .getColumn(0).setPreferredWidth(40);
/* 4494 */     this.rSTableMetro6.getColumnModel()
/* 4495 */       .getColumn(0).setMaxWidth(40);
/* 4496 */     this.rSTableMetro6.getColumnModel()
/* 4497 */       .getColumn(1).setPreferredWidth(120);
/* 4498 */     this.rSTableMetro6.getColumnModel()
/* 4499 */       .getColumn(1).setMaxWidth(120);
/* 4500 */     this.rSTableMetro6.getColumnModel()
/* 4501 */       .getColumn(4).setPreferredWidth(40);
/* 4502 */     this.rSTableMetro6.getColumnModel()
/* 4503 */       .getColumn(4).setMaxWidth(40);
/* 4504 */     this.rSTableMetro6.getColumnModel()
/* 4505 */       .getColumn(0).setCellRenderer(this.celda4);
/* 4506 */     this.rSTableMetro6.getColumnModel()
/* 4507 */       .getColumn(1).setCellRenderer(this.celda4);
/* 4508 */     this.rSTableMetro6.getColumnModel()
/* 4509 */       .getColumn(2).setCellRenderer(this.celda4);
/* 4510 */     this.rSTableMetro6.getColumnModel()
/* 4511 */       .getColumn(3).setCellRenderer(this.celda4);
/* 4512 */     this.rSTableMetro6.getColumnModel()
/* 4513 */       .getColumn(4).setCellRenderer(this.celda4);
/*      */   }
/*      */   
/*      */   public void llenarCombo() {
/* 4517 */     this.SUCURSALES = this.con.regresaColIndex("sucursal", "prov_sucursales", " order by sucursal");
/* 4518 */     List<String> lista = Arrays.asList(this.SUCURSALES);
/* 4519 */     Iterator<String> it = lista.iterator();
/* 4520 */     while (it.hasNext()) {
/* 4521 */       String v = it.next();
/* 4522 */       this.jComboBox1.addItem(v);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void tarjetaDeudor(String USUARIO) {
/* 4527 */     privilegios();
/* 4528 */     this.USUARIO = USUARIO;
/* 4529 */     this.panel.setViewportView(this);
/*      */   }
/*      */   
/*      */   public void consultar() {
/* 4533 */     this.entraSucPrimera = true;
/* 4534 */     String razon = "";
/* 4535 */     if (!this.jTextField1.getText().equals(this.holderRazonSocial)) {
/* 4536 */       razon = this.jTextField1.getText();
/*      */     }
/* 4538 */     String sucursalForsis = "";
/* 4539 */     if (this.jComboBox1.getSelectedIndex() != 0) {
/* 4540 */       sucursalForsis = this.jComboBox1.getSelectedItem().toString();
/*      */     }
/* 4542 */     String estado = " estado like '%%'";
/* 4543 */     if (this.jComboBox2.getSelectedIndex() == 0) {
/* 4544 */       estado = " estado = 'ACTIVO'";
/* 4545 */     } else if (this.jComboBox2.getSelectedIndex() == 1) {
/* 4546 */       estado = " estado = 'ELIMINADO'";
/*      */     } 
/*      */     
/* 4549 */     (new String[7])[0] = "ID"; (new String[7])[1] = "Proveedor"; (new String[7])[2] = "Saldo"; (new String[7])[3] = "Moneda"; (new String[7])[4] = "Sucursal Operativa"; (new String[7])[5] = "Estado"; (new String[7])[6] = " Actualizó (dd/mm/aaaa)"; this.rSTableMetro1.setModel(new DefaultTableModel((Object[][])this.con.buscarDatos(7, "numProv, razonSocial, saldo, moneda, sucOp, estado, usuarioTarjeta", "prov_proveedores", "where nombreComercial like '%" + razon + "%' and sucOp like '%" + sucursalForsis + "%' and " + estado + " order by razonSocial"), (Object[])new String[7])
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 4554 */           boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false };
/*      */           
/*      */           public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 4557 */             return this.canEdit[columnIndex];
/*      */           }
/*      */         });
/* 4560 */     this.jLabel48.setText("" + this.rSTableMetro1.getRowCount());
/* 4561 */     this.rSTableMetro1.getColumnModel().getColumn(0).setPreferredWidth(50);
/* 4562 */     this.rSTableMetro1.getColumnModel().getColumn(0).setMaxWidth(50);
/* 4563 */     this.rSTableMetro1.getColumnModel().getColumn(1).setPreferredWidth(300);
/* 4564 */     this.rSTableMetro1.getColumnModel().getColumn(1).setMaxWidth(300);
/* 4565 */     this.rSTableMetro1.getColumnModel().getColumn(2).setPreferredWidth(140);
/* 4566 */     this.rSTableMetro1.getColumnModel().getColumn(2).setMaxWidth(140);
/* 4567 */     this.rSTableMetro1.getColumnModel().getColumn(3).setPreferredWidth(70);
/* 4568 */     this.rSTableMetro1.getColumnModel().getColumn(3).setMaxWidth(70);
/* 4569 */     this.rSTableMetro1.getColumnModel().getColumn(0).setCellRenderer(this.celda2);
/* 4570 */     this.rSTableMetro1.getColumnModel().getColumn(1).setCellRenderer(this.celda2);
/* 4571 */     this.rSTableMetro1.getColumnModel().getColumn(2).setCellRenderer(this.celda2);
/* 4572 */     this.rSTableMetro1.getColumnModel().getColumn(3).setCellRenderer(this.celda2);
/* 4573 */     this.rSTableMetro1.getColumnModel().getColumn(4).setCellRenderer(this.celda2);
/* 4574 */     this.rSTableMetro1.getColumnModel().getColumn(5).setCellRenderer(this.celda2);
/* 4575 */     this.rSTableMetro1.getColumnModel().getColumn(6).setCellRenderer(this.celda2);
/* 4576 */     this.rSTableMetro1.setSelectionMode(0);
/* 4577 */     this.rSTableMetro1.setAutoCreateRowSorter(true);
/* 4578 */     this.rSTableMetro1.getTableHeader().setReorderingAllowed(false);
/* 4579 */     this.rSTableMetro1.setFont(new Font("Cantarell", 0, 10));
/* 4580 */     this.rSTableMetro1.setColorSelBackgound(new Color(237, 107, 107));
/* 4581 */     this.celda2.pasarInd(this.con.revisarCol((JTable)this.rSTableMetro1, "ELIMINADO", 0, 5, 0));
/* 4582 */     calcularTotalGral();
/*      */   }
/*      */   
/*      */   public void calcularTotalGral() {
/* 4586 */     this.jLabel49.setText("$0.00");
/* 4587 */     double valorS = 0.0D;
/* 4588 */     for (int i = 0; i < this.rSTableMetro1.getRowCount(); i++) {
/* 4589 */       String canti = String.valueOf(this.rSTableMetro1.getValueAt(i, 2));
/* 4590 */       String valorP = "";
/* 4591 */       for (int j = 0; j < canti.length(); j++) {
/* 4592 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 4593 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 4596 */       valorS += Double.parseDouble(valorP);
/* 4597 */       this.cantidad.setValue(Double.valueOf(valorS));
/* 4598 */       this.jLabel49.setText(this.cantidad.getText());
/*      */     } 
/*      */   }
/*      */   
/*      */   public void calcularTotalAbonos() {
/* 4603 */     this.jLabel17.setText("$0.00");
/* 4604 */     double valorS = 0.0D;
/* 4605 */     for (int i = 0; i < this.rSTableMetro8.getRowCount(); i++) {
/* 4606 */       String canti = String.valueOf(this.rSTableMetro8.getValueAt(i, 1));
/* 4607 */       String valorP = "";
/* 4608 */       for (int j = 0; j < canti.length(); j++) {
/* 4609 */         if (canti.charAt(j) != '$' && canti.charAt(j) != ',') {
/* 4610 */           valorP = valorP + valorP;
/*      */         }
/*      */       } 
/* 4613 */       valorS += Double.parseDouble(valorP);
/*      */     } 
/* 4615 */     this.cantidad.setValue(Double.valueOf(valorS));
/* 4616 */     this.jLabel17.setText(this.cantidad.getText());
/*      */   }
/*      */   
/*      */   class CeldaRender1
/*      */     extends DefaultTableCellRenderer {
/* 4621 */     int otro = -1;
/*      */     
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4624 */       setEnabled((table == null || table.isEnabled()));
/* 4625 */       if (row % 2 == 0) {
/* 4626 */         setBackground(ProvTarjetaDeudor.this.lc.FONDOTABLA);
/*      */       } else {
/* 4628 */         setBackground((Color)null);
/*      */       } 
/* 4630 */       if (column == 4) {
/* 4631 */         setHorizontalAlignment(4);
/*      */       } else {
/* 4633 */         setHorizontalAlignment(2);
/*      */       } 
/* 4635 */       setForeground(ProvTarjetaDeudor.this.lc.SECUNDARIO1);
/* 4636 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4637 */       return this;
/*      */     } }
/*      */   class CeldaRender2 extends DefaultTableCellRenderer { int otro;
/*      */     String[] indices;
/*      */     
/*      */     CeldaRender2() {
/* 4643 */       this.otro = -1;
/*      */       
/* 4645 */       this.indices = new String[0];
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4648 */       setEnabled((table == null || table.isEnabled()));
/* 4649 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 4650 */       setForeground(ProvTarjetaDeudor.this.lc.SECUNDARIO1);
/* 4651 */       if (comparar(comp)) {
/* 4652 */         setBackground(Color.RED);
/* 4653 */         setForeground(Color.WHITE);
/* 4654 */       } else if (row % 2 == 0) {
/* 4655 */         setBackground(ProvTarjetaDeudor.this.lc.FONDOTABLA);
/*      */       } else {
/* 4657 */         setBackground((Color)null);
/*      */       } 
/* 4659 */       if (column == 0 || column == 2) {
/* 4660 */         setHorizontalAlignment(4);
/*      */       } else {
/* 4662 */         setHorizontalAlignment(10);
/*      */       } 
/* 4664 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4665 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 4669 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 4673 */       for (int i = 0; i < this.indices.length; i++) {
/* 4674 */         if (this.indices[i].equals(reg)) {
/* 4675 */           return true;
/*      */         }
/*      */       } 
/* 4678 */       return false;
/*      */     } }
/*      */   class CeldaRender3 extends DefaultTableCellRenderer { int otro;
/*      */     String[] indices;
/*      */     
/*      */     CeldaRender3() {
/* 4684 */       this.otro = -1;
/*      */       
/* 4686 */       this.indices = new String[0];
/*      */       
/* 4688 */       this.indices2 = new String[0];
/*      */       
/* 4690 */       this.indices3 = new String[0];
/*      */     } String[] indices2; String[] indices3;
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4693 */       setEnabled((table == null || table.isEnabled()));
/* 4694 */       String comp = String.valueOf(table.getValueAt(row, 0));
/* 4695 */       if (comparar(comp)) {
/* 4696 */         setBackground((Color)null);
/* 4697 */         setForeground(Color.BLUE);
/* 4698 */         setHorizontalAlignment(2);
/* 4699 */       } else if (comparar2(comp)) {
/* 4700 */         setBackground(Color.LIGHT_GRAY);
/* 4701 */         setForeground(Color.red);
/* 4702 */         setHorizontalAlignment(2);
/* 4703 */       } else if (comparar3(comp)) {
/* 4704 */         setBackground((Color)null);
/* 4705 */         setForeground(Color.RED);
/* 4706 */         setHorizontalAlignment(2);
/*      */       } else {
/* 4708 */         setBackground((Color)null);
/* 4709 */         setForeground(ProvTarjetaDeudor.this.lc.SECUNDARIO1);
/* 4710 */         setHorizontalAlignment(2);
/*      */       } 
/* 4712 */       if (column == 1 || column == 4 || column == 5 || column == 6 || column == 7) {
/* 4713 */         setHorizontalAlignment(4);
/*      */       }
/* 4715 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4716 */       return this;
/*      */     }
/*      */     
/*      */     public void pasarInd(String[] ind) {
/* 4720 */       this.indices = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd2(String[] ind) {
/* 4724 */       this.indices2 = ind;
/*      */     }
/*      */     
/*      */     public void pasarInd3(String[] ind) {
/* 4728 */       this.indices3 = ind;
/*      */     }
/*      */     
/*      */     public boolean comparar(String reg) {
/* 4732 */       for (int i = 0; i < this.indices.length; i++) {
/* 4733 */         if (this.indices[i].equals(reg)) {
/* 4734 */           return true;
/*      */         }
/*      */       } 
/* 4737 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar2(String reg) {
/* 4741 */       for (int i = 0; i < this.indices2.length; i++) {
/* 4742 */         if (this.indices2[i].equals(reg)) {
/* 4743 */           return true;
/*      */         }
/*      */       } 
/* 4746 */       return false;
/*      */     }
/*      */     
/*      */     public boolean comparar3(String reg) {
/* 4750 */       for (int i = 0; i < this.indices3.length; i++) {
/* 4751 */         if (this.indices3[i].equals(reg)) {
/* 4752 */           return true;
/*      */         }
/*      */       } 
/* 4755 */       return false;
/*      */     } }
/*      */   
/*      */   class CeldaRender4 extends DefaultTableCellRenderer { int otro;
/*      */     
/*      */     CeldaRender4() {
/* 4761 */       this.otro = -1;
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4764 */       setEnabled((table == null || table.isEnabled()));
/* 4765 */       if (row % 2 == 0) {
/* 4766 */         setBackground(ProvTarjetaDeudor.this.lc.FONDOTABLA);
/*      */       } else {
/* 4768 */         setBackground((Color)null);
/*      */       } 
/* 4770 */       if (column == 1) {
/* 4771 */         setHorizontalAlignment(2);
/*      */       } else {
/* 4773 */         setHorizontalAlignment(4);
/*      */       } 
/* 4775 */       setForeground(ProvTarjetaDeudor.this.lc.SECUNDARIO1);
/* 4776 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4777 */       return this;
/*      */     } }
/*      */   
/*      */   class CeldaRender5 extends DefaultTableCellRenderer { int otro;
/*      */     
/*      */     CeldaRender5() {
/* 4783 */       this.otro = -1;
/*      */     }
/*      */     public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
/* 4786 */       setEnabled((table == null || table.isEnabled()));
/* 4787 */       if (row % 2 == 0) {
/* 4788 */         setBackground(ProvTarjetaDeudor.this.lc.FONDOTABLA);
/*      */       } else {
/* 4790 */         setBackground((Color)null);
/*      */       } 
/* 4792 */       if (column == 1) {
/* 4793 */         setHorizontalAlignment(4);
/*      */       } else {
/* 4795 */         setHorizontalAlignment(2);
/*      */       } 
/* 4797 */       setForeground(ProvTarjetaDeudor.this.lc.SECUNDARIO1);
/* 4798 */       super.getTableCellRendererComponent(table, value, selected, focused, row, column);
/* 4799 */       return this;
/*      */     } }
/*      */ 
/*      */   
/*      */   class Presionado
/*      */     implements Runnable
/*      */   {
/*      */     Thread t;
/* 4807 */     int cont = 0;
/*      */     
/*      */     public Presionado() {
/* 4810 */       this.t = new Thread(this);
/* 4811 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/*      */       try {
/* 4819 */         ProvTarjetaDeudor.this.EtiquetaEstado.setVisible(true);
/* 4820 */         ProvTarjetaDeudor.this.EtiquetaEstado.setText("Buscando datos, por favor espere...");
/* 4821 */         ProvTarjetaDeudor.this.setCursor(new Cursor(3));
/* 4822 */         Thread.currentThread();
/* 4823 */         Thread.sleep(1000L);
/* 4824 */         detener();
/* 4825 */       } catch (InterruptedException interruptedException) {}
/*      */     }
/*      */ 
/*      */     
/*      */     public void detener() {
/* 4830 */       ProvTarjetaDeudor.this.consultar();
/* 4831 */       ProvTarjetaDeudor.this.setCursor(ProvTarjetaDeudor.this.micursor);
/* 4832 */       ProvTarjetaDeudor.this.EtiquetaEstado.setVisible(false);
/* 4833 */       this.t.stop();
/*      */     }
/*      */     
/*      */     public void detenerFuera() {
/* 4837 */       this.t.stop();
/*      */     }
/*      */   }
/*      */   
/*      */   class Presionado2
/*      */     implements Runnable
/*      */   {
/*      */     Thread t;
/* 4845 */     int cont = 0;
/*      */     
/*      */     public Presionado2() {
/* 4848 */       this.t = new Thread(this);
/* 4849 */       this.t.start();
/*      */     }
/*      */ 
/*      */     
/*      */     public void start() {}
/*      */     
/*      */     public void run() {
/*      */       try {
/* 4857 */         ProvTarjetaDeudor.this.jLabel7.setVisible(true);
/* 4858 */         Thread.currentThread();
/* 4859 */         Thread.sleep(1000L);
/* 4860 */         detener();
/* 4861 */       } catch (InterruptedException interruptedException) {}
/*      */     }
/*      */ 
/*      */     
/*      */     public void detener() {
/* 4866 */       ProvTarjetaDeudor.this.consultarFacturasPendientes();
/* 4867 */       ProvTarjetaDeudor.this.jLabel7.setVisible(false);
/* 4868 */       this.t.stop();
/*      */     }
/*      */     
/*      */     public void detenerFuera() {
/* 4872 */       this.t.stop();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public class Cheques
/*      */   {
/*      */     String poliza;
/*      */     
/*      */     String fecha;
/*      */     
/*      */     String cheque;
/*      */     
/*      */     String concepto;
/*      */     String importe;
/*      */     
/*      */     public Cheques(String poliza, String fecha, String cheque, String concepto, String importe) {
/* 4889 */       this.poliza = poliza;
/* 4890 */       this.fecha = fecha;
/* 4891 */       this.cheque = cheque;
/* 4892 */       this.concepto = concepto;
/* 4893 */       this.importe = importe;
/*      */     }
/*      */     
/*      */     public String getPoliza() {
/* 4897 */       return this.poliza;
/*      */     }
/*      */     
/*      */     public void setPoliza(String poliza) {
/* 4901 */       this.poliza = poliza;
/*      */     }
/*      */     
/*      */     public String getFecha() {
/* 4905 */       return this.fecha;
/*      */     }
/*      */     
/*      */     public void setFecha(String fecha) {
/* 4909 */       this.fecha = fecha;
/*      */     }
/*      */     
/*      */     public String getCheque() {
/* 4913 */       return this.cheque;
/*      */     }
/*      */     
/*      */     public void setCheque(String cheque) {
/* 4917 */       this.cheque = cheque;
/*      */     }
/*      */     
/*      */     public String getConcepto() {
/* 4921 */       return this.concepto;
/*      */     }
/*      */     
/*      */     public void setConcepto(String concepto) {
/* 4925 */       this.concepto = concepto;
/*      */     }
/*      */     
/*      */     public String getImporte() {
/* 4929 */       return this.importe;
/*      */     }
/*      */     
/*      */     public void setImporte(String importe) {
/* 4933 */       this.importe = importe;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public class Transferencias
/*      */   {
/*      */     String folio;
/*      */     
/*      */     String fecha;
/*      */     
/*      */     String concepto;
/*      */     
/*      */     String beneficiario;
/*      */     String importe;
/*      */     
/*      */     public Transferencias(String folio, String fecha, String concepto, String beneficiario, String importe) {
/* 4950 */       this.folio = folio;
/* 4951 */       this.fecha = fecha;
/* 4952 */       this.concepto = concepto;
/* 4953 */       this.beneficiario = beneficiario;
/* 4954 */       this.importe = importe;
/*      */     }
/*      */     
/*      */     public String getFolio() {
/* 4958 */       return this.folio;
/*      */     }
/*      */     
/*      */     public void setFolio(String folio) {
/* 4962 */       this.folio = folio;
/*      */     }
/*      */     
/*      */     public String getFecha() {
/* 4966 */       return this.fecha;
/*      */     }
/*      */     
/*      */     public void setFecha(String fecha) {
/* 4970 */       this.fecha = fecha;
/*      */     }
/*      */     
/*      */     public String getConcepto() {
/* 4974 */       return this.concepto;
/*      */     }
/*      */     
/*      */     public void setConcepto(String concepto) {
/* 4978 */       this.concepto = concepto;
/*      */     }
/*      */     
/*      */     public String getBeneficiario() {
/* 4982 */       return this.beneficiario;
/*      */     }
/*      */     
/*      */     public void setBeneficiario(String beneficiario) {
/* 4986 */       this.beneficiario = beneficiario;
/*      */     }
/*      */     
/*      */     public String getImporte() {
/* 4990 */       return this.importe;
/*      */     }
/*      */     
/*      */     public void setImporte(String importe) {
/* 4994 */       this.importe = importe;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public class FacturasAbonadas
/*      */   {
/*      */     int mov;
/*      */     
/*      */     String ref;
/*      */     
/*      */     String importe;
/*      */     
/*      */     String resta;
/*      */     
/*      */     String abono;
/*      */     int id;
/*      */     
/*      */     public FacturasAbonadas(int mov, String ref, String importe, String resta, String abono, int id) {
/* 5013 */       this.mov = mov;
/* 5014 */       this.ref = ref;
/* 5015 */       this.importe = importe;
/* 5016 */       this.resta = resta;
/* 5017 */       this.abono = abono;
/* 5018 */       this.id = id;
/*      */     }
/*      */     
/*      */     public int getMov() {
/* 5022 */       return this.mov;
/*      */     }
/*      */     
/*      */     public void setMov(int mov) {
/* 5026 */       this.mov = mov;
/*      */     }
/*      */     
/*      */     public String getRef() {
/* 5030 */       return this.ref;
/*      */     }
/*      */     
/*      */     public void setRef(String ref) {
/* 5034 */       this.ref = ref;
/*      */     }
/*      */     
/*      */     public String getImporte() {
/* 5038 */       return this.importe;
/*      */     }
/*      */     
/*      */     public void setImporte(String importe) {
/* 5042 */       this.importe = importe;
/*      */     }
/*      */     
/*      */     public String getResta() {
/* 5046 */       return this.resta;
/*      */     }
/*      */     
/*      */     public void setResta(String resta) {
/* 5050 */       this.resta = resta;
/*      */     }
/*      */     
/*      */     public String getAbono() {
/* 5054 */       return this.abono;
/*      */     }
/*      */     
/*      */     public void setAbono(String abono) {
/* 5058 */       this.abono = abono;
/*      */     }
/*      */     
/*      */     public int getId() {
/* 5062 */       return this.id;
/*      */     }
/*      */     
/*      */     public void setId(int id) {
/* 5066 */       this.id = id;
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/kamikaze07/Google Drive/Otros ordenadores/Mi MacBook Pro/Desktop/Sicret/SICRET.jar!/sicret/ProvTarjetaDeudor.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */