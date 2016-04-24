/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udloansmis;

import DTO.LoanDTO;
import DTO.StudentDTO;
import RMI.IDatabaseRMI;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigInteger;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import security.TokenHandlerClient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TableCell;
import javax.swing.JFrame;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Lenovo
 */
public class UdloansMis_UdlånsMis extends javax.swing.JFrame {

    private final UdloansMis_Dato dato = new UdloansMis_Dato(this);
    private final String serverIP;
    private final JFrame logFrame;
    private UdloansMis_Log logPanel;
    private boolean logEnabled = false;
    private UdloansMis_CheckForServer checkforserver;
    private final TokenHandlerClient tokenhandler;
    private final IDatabaseRMI database;        // <------------------- DET HER ER RMI-INTERFACET (database). Eksempelvis, hvis du ønsker et component-objekt via stregkode:
    //     Med ord:             modtaget objekt = database.getComponent(stregkodenummer, min nøgle)
    //     Eksempel:            ComponentDTO recievedComponentObjekt = database.getComponent(barcodeNumber, tokenhandler.getKeyToken(), tokenhandler.getID());          

    public UdloansMis_UdlånsMis(TokenHandlerClient tokenhandler, IDatabaseRMI database, String serverIP) {
        this.logFrame = new JFrame("UdlånsMis v1.0 Log");
        this.tokenhandler = tokenhandler;
        this.database = database;
        this.serverIP = serverIP;
    }

    public void init() {
        initComponents();
        Thread dateThread = new Thread(dato);
        dateThread.start();
        checkforserver = new UdloansMis_CheckForServer(this, tokenhandler, database, serverIP);
        Thread checkForServerThread = new Thread(checkforserver);
        checkForServerThread.start();
        startLog();
    }

    public void CheckServer(boolean isConnectedToServer) {
        if (isConnectedToServer == true) {
            jTextFieldServerCheck.setForeground(new java.awt.Color(255, 255, 255));
            jTextFieldServerCheck.setBackground(new java.awt.Color(0, 150, 0));
            jTextFieldServerCheck.setText("Forbundet til komponentserver på " + serverIP);
        } else {
            jTextFieldServerCheck.setForeground(new java.awt.Color(255, 255, 255));
            jTextFieldServerCheck.setBackground(new java.awt.Color(150, 0, 0));

            jTextFieldServerCheck.setText("Ikke forbundet til komponentserver, automatisk genoprettelse foregår");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldStregkode = new javax.swing.JTextField();
        jTextFieldStudieNr = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldServerCheck = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jRadioButtonLog = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextFieldStregkode.setText("Stregkode eller navn");
        jTextFieldStregkode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStregkodeActionPerformed(evt);
            }
        });

        jTextFieldStudieNr.setText("Sxxxxxx");
        jTextFieldStudieNr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldStudieNrActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Scan eller søg efter komponent");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Studienummer");

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        jLabel3.setText("UdlånsMis v1.0");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Søg i database");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Dato");

        jTextFieldServerCheck.setEditable(false);
        jTextFieldServerCheck.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldServerCheck.setText("ServerCheck");
        jTextFieldServerCheck.setFocusable(false);
        jTextFieldServerCheck.setRequestFocusEnabled(false);
        jTextFieldServerCheck.setVerifyInputWhenFocusTarget(false);

        jTable.setAutoCreateRowSorter(true);
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Stregkodenummer", "Navn", "Udlånsdato", "Afleveringsdato", "Dage til aflevering"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable.setFocusable(false);
        jTable.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(jTable);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setText("Udlån");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setText("Aflevering");
        jButton3.setActionCommand("Aflever");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jRadioButtonLog.setText("Log");
        jRadioButtonLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonLogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldStregkode, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 388, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldStudieNr, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldServerCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButtonLog))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldStregkode, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldStudieNr, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldServerCheck, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonLog, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton2, jButton3});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jTextFieldStregkode, jTextFieldStudieNr});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldStregkodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStregkodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldStregkodeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (checkforserver.isConnectedToServer) {
            String stregkode = jTextFieldStregkode.getText();
            String studienummer = jTextFieldStudieNr.getText();
            if (!stregkode.equals("Stregkode eller navn")) {
                StringSelection stringSelection = new StringSelection(stregkode);
                Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                clpbrd.setContents(stringSelection, null);

            } else if ((studienummer.length() == 7) && (!studienummer.equals("Sxxxxxx"))) {
                if (studienummer.startsWith("S") || studienummer.startsWith("s")) {
                    String studietalString = studienummer.substring(1, 7);

                    if (!studietalString.matches("^\\d+$")) {   // Check om der er bogstaver i studienummeret.
                        String st = "Studienummer ukorrekt.";
                        JOptionPane.showMessageDialog(null, st);

                    } else {
                        System.out.print("Det indtastede studienummer er: S" + studietalString + "\n");

                        StringSelection stringSelection = new StringSelection(studienummer);
                        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clpbrd.setContents(stringSelection, null);
                        jTextFieldStudieNr.setText("Sxxxxxx");
                    }
                } else {
                    String st = "Scan stregkode, skriv navn eller studienummer, og klik på søg.";
                    JOptionPane.showMessageDialog(null, st);

                }

            }

        } else {
            String st = "Ikke forbundet til serveren. Check kabler, forbindelsen genoprettes automatisk";
            JOptionPane.showMessageDialog(null, st);
            jTable.setValueAt("12345678", 3, 0);
            jTable.setValueAt("Zybo kit #16", 3, 1);
            jTable.setValueAt("19/4-2016", 3, 2);
            jTable.setValueAt("19/6-2016", 3, 3);
            jTable.setValueAt("61", 3, 4);
            //jTable2.setBackground(Color.red);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Dato skal være i dette format 
        // ***** "24/2-16" *******

        // **** Dags dato ****
        Date curDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat();
        String DateToStr = format.format(curDate);
        System.out.println("1: Default pattern: " + DateToStr);
        format = new SimpleDateFormat("dd/MM-yy");
        DateToStr = format.format(curDate);
        System.out.println("2: Dansk pattern = " + DateToStr);
        Date strToDate = null;
        try {
            strToDate = format.parse(DateToStr);
        } catch (ParseException ex) {
            Logger.getLogger(UdloansMis_UdlånsMis.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("3: " + strToDate);

        // **** Afleveringsdato fra inputboks ****    
        String aflevDagString;
        String aflevMånString;
        String aflevÅrString;
        double msPerDay = 86400 * 1000;
        String stregkode = JOptionPane.showInputDialog(null, "Scan eller indtast stregkodenummer på udlånskomponent. (Ex. 12345678)");
        System.out.println("Stregkode: " + stregkode);
        int stregkodeInt = Integer.parseInt(stregkode);
        String studieNummer = JOptionPane.showInputDialog(null, "Læg studiekortet på RFID læser, eller indtast studienummer (Ex. s123456)");
        System.out.println("Studienummer: " + studieNummer);
        String afleveringsDato = JOptionPane.showInputDialog(null, "Indtast afleveringsdato, i dette format " + DateToStr);
        System.out.println("Afleveringsdato: " + afleveringsDato);

        if (afleveringsDato.substring(1, 2).equals("/")) {        // Hvis datoen er 1-9
            aflevDagString = afleveringsDato.substring(0, 1);

            if (afleveringsDato.substring(3, 4).equals("-")) {    // Hvis måned er 1-9
                aflevMånString = afleveringsDato.substring(2, 3);
                aflevÅrString = afleveringsDato.substring(4, 6);
            } else {                                               // Hvis måned er 10 - 12
                aflevMånString = afleveringsDato.substring(2, 4);
                aflevÅrString = afleveringsDato.substring(5, 7);

            }
        } else {                                                   // Hvis dag er 10 - 31
            aflevDagString = afleveringsDato.substring(0, 2);

            if (afleveringsDato.substring(4, 5).equals("-")) {     // Hvis måned er 1-9
                aflevMånString = afleveringsDato.substring(3, 4);
                aflevÅrString = afleveringsDato.substring(5, 7);

            } else {                                               // Hvis måned er 10 - 12
                aflevMånString = afleveringsDato.substring(3, 5);
                aflevÅrString = afleveringsDato.substring(6, 8);
            }
        }

        int aflevÅr = (Integer.parseInt(aflevÅrString) + 2000);
        int aflevMån = Integer.parseInt(aflevMånString);
        int aflevDag = Integer.parseInt(aflevDagString);
        String afleveringsdatoString = "" + aflevDag + "/" + aflevMån + "-" + aflevÅr;

        // **** Dato 2 ****
        Date afleveringsDatoFinal = new Date();
        SimpleDateFormat format2 = new SimpleDateFormat();
        format2 = new SimpleDateFormat("dd/MM-yy");
        try {
            afleveringsDatoFinal = format2.parse(afleveringsdatoString);
        } catch (ParseException ex) {
            Logger.getLogger(UdloansMis_UdlånsMis.class.getName()).log(Level.SEVERE, null, ex);
        }
        String DateToStr2 = format2.format(afleveringsDatoFinal);
        System.out.println("4: Default pattern2: " + DateToStr);

        DateToStr2 = format2.format(afleveringsDatoFinal);
        System.out.println("5: Dansk2 = " + DateToStr2);
        Date strToDate2 = null;
        try {
            strToDate2 = format2.parse(DateToStr2);
        } catch (ParseException ex) {
            Logger.getLogger(UdloansMis_UdlånsMis.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("6_2: " + strToDate2);

        // *** Beregn antal dage til aflevering. ****
        int dageTilAflevering = (int) ((afleveringsDatoFinal.getTime() - curDate.getTime()) / msPerDay) + 1;
        System.out.println("Dage til aflevering er beregnet til: " + dageTilAflevering);

        String resumeTekstBoks = "Ønsker du at lave et udlån af følgende komponent?\n"
                + "Stregkode: " + stregkode + ", til " + studieNummer + " i " + dageTilAflevering + " dage?";
        Object[] options = {"Bekræft", "Afbryd"};

        // Bekræftelse
        int n = JOptionPane.showOptionDialog(null,
                resumeTekstBoks,
                "Bekræft udlån",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        System.out.println("n er: " + n);
        // n er 0 ved Bekræft, og 1 ved Afbryd

        if (n == 0) {
            opretUdlån(stregkodeInt, studieNummer, curDate, afleveringsDatoFinal);
            // Send til RMI og vis nedenstående besked.

        } else {
            //Send ikke noget til RMI
            JOptionPane.showMessageDialog(null, "Udlånet er afbrudt", "Bemærk!", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton2ActionPerformed


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        /* // TODO add your handling code here:
            // Dato skal være i dette format
            // ***** "24/2-16" *******
            
            // **** Dags dato ****
            Date curDate = new Date();
            SimpleDateFormat format = new SimpleDateFormat();
            String DateToStr = format.format(curDate);
            System.out.println("1: Default pattern: " + DateToStr);
            format = new SimpleDateFormat("dd/MM-yy");
            DateToStr = format.format(curDate);
            System.out.println("2: Dansk pattern = " + DateToStr);
            Date strToDate = null;
            try {
            strToDate = format.parse(DateToStr);
            } catch (ParseException ex) {
            Logger.getLogger(UdloansMis_UdlånsMis.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("3: " + strToDate);
            
            // **** Afleveringsdato fra inputboks ****
            String aflevDagString;
            String aflevMånString;
            String aflevÅrString;
            double msPerDay = 86400 * 1000;
            String stregkode = JOptionPane.showInputDialog(null, "Scan eller indtast stregkodenummer på komponent til aflevering. (Ex. 12345678)");
            System.out.println("Stregkode: " + stregkode);
            int stregkodeInt = Integer.parseInt(stregkode);
            
            LoanDTO loan = new LoanDTO();
            loan.setComponentId(stregkodeInt);
            
            
            
            
            
            String afleveringsNavn = JOptionPane.showInputDialog(null, "Indtast navnet på den person der har taget imod komponenten");
            System.out.println("Afleveringsavn: " + afleveringsNavn);
            
            
            // **** Dato 2 ****
            Date afleveringsDatoFinal = new Date();
            SimpleDateFormat format2 = new SimpleDateFormat();
            format2 = new SimpleDateFormat("dd/MM-yy");
            try {
            afleveringsDatoFinal = format2.parse(afleveringsdatoString);
            } catch (ParseException ex) {
            Logger.getLogger(UdloansMis_UdlånsMis.class.getName()).log(Level.SEVERE, null, ex);
            }
            String DateToStr2 = format2.format(afleveringsDatoFinal);
            System.out.println("4: Default pattern2: " + DateToStr);
            
            DateToStr2 = format2.format(afleveringsDatoFinal);
            System.out.println("5: Dansk2 = " + DateToStr2);
            Date strToDate2 = null;
            try {
            strToDate2 = format2.parse(DateToStr2);
            } catch (ParseException ex) {
            Logger.getLogger(UdloansMis_UdlånsMis.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("6_2: " + strToDate2);
            
            // *** Beregn antal dage til aflevering. ****
            int dageTilAflevering = (int) ((afleveringsDatoFinal.getTime() - curDate.getTime()) / msPerDay) + 1;
            System.out.println("Dage til aflevering er beregnet til: " + dageTilAflevering);
            
            String resumeTekstBoks = "Ønsker du at lave et udlån af følgende komponent?\n"
            + "Stregkode: " + stregkode + ", til " + studieNummer + " i " + dageTilAflevering + " dage?";
            Object[] options = {"Bekræft", "Afbryd"};
            
            // Bekræftelse
            int n = JOptionPane.showOptionDialog(null,
            resumeTekstBoks,
            "Bekræft udlån",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[1]);
            System.out.println("n er: " + n);
            // n er 0 ved Bekræft, og 1 ved Afbryd
            
            if (n == 0) {
            opretUdlån(stregkodeInt, studieNummer, curDate, afleveringsDatoFinal);
            // Send til RMI og vis nedenstående besked.
            
            } else {
            //Send ikke noget til RMI
            JOptionPane.showMessageDialog(null, "Udlånet er afbrudt", "Bemærk!", JOptionPane.ERROR_MESSAGE);
            }
            
         */
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextFieldStudieNrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldStudieNrActionPerformed
        try {
            søgStudieNr(jTextFieldStudieNr.getText());
        } catch (RemoteException ex) {

        }
    }//GEN-LAST:event_jTextFieldStudieNrActionPerformed

    private void jRadioButtonLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonLogActionPerformed
        setLog();
    }//GEN-LAST:event_jRadioButtonLogActionPerformed

    public void setDate(String date) {
        jLabel5.setText(date);
    }

    void søgUdlån(String keyword) throws RemoteException {
        LoanDTO[] loans = database.searchLoans(keyword, tokenhandler.getKeyToken(), tokenhandler.getID());

    }

    void søgStudieNr(String keyword) throws RemoteException {
        try {
          LoanDTO[] loans = database.getLoansForStudent(keyword, tokenhandler.getKeyToken(), tokenhandler.getID());
          jTable.setValueAt(loans[0].getComponentId(), 0, 0);
        }
        catch (NullPointerException ex) {
            logPanel.println("Der er ikke registreret lån under denne bruger");
        }
    }

    void opretUdlån(int componentId, String studentId, Date loanDate, Date dueDate) {
        LoanDTO loan = new LoanDTO();
        loan.setComponentId(componentId);
        loan.setStudentId(studentId);
        loan.setLoanDateFromDate(loanDate);
        loan.setDueDateFromDate(dueDate);
        try {
            int OK = database.createLoan(loan, tokenhandler.getKeyToken(), tokenhandler.getID());
            if (OK == 0) {
                JOptionPane.showMessageDialog(null, "Udlånet er gennemført");
            } else if (OK == -1) {
                JOptionPane.showMessageDialog(null, "Fejl ved kommunikation med !", "Bemærk!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(UdloansMis_UdlånsMis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void startLog() {

        // Create jPanel
        logPanel = new UdloansMis_Log();

        // Add panel to window
        logFrame.add(logPanel);
        logFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        logFrame.setSize(570, 650);

        // Add windowListener to check for window closing;
        logFrame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                logEnabled = false;
                jRadioButtonLog.setSelected(false);
            }
        });
    }

    void setLog() {
        if (!logEnabled) {
            // Show window
            logFrame.setVisible(true);
            logEnabled = true;
        } else {
            logFrame.setVisible(false);
            logEnabled = false;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonLog;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldServerCheck;
    private javax.swing.JTextField jTextFieldStregkode;
    private javax.swing.JTextField jTextFieldStudieNr;
    // End of variables declaration//GEN-END:variables

}
