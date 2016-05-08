package udloansmis;

import DTO.ComponentDTO;
import DTO.LoanDTO;
import DTO.StudentDTO;
import RMI.IDatabaseRMI;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import security.TokenHandlerClient;

/**
 *
 * @author Thomas D. Høybye-Jensen, Christian Genter & Marcus Persson
 */
public class UdloansMis_UdlånsMisLogic {

    private final JFrame logFrame;
    private final TokenHandlerClient tokenhandler;
    private final UdloansMis_CheckForServer checkforserver;
    private boolean logEnabled = false;
    private IDatabaseRMI database;
    public static UdloansMis_Log logPanel;
    private final UdloansMis_UdlånsMisGUI mainGUI;

    String[] dialogTexts;

    String SCAN_BARCODE;
    String SCAN_STUDENTNR;
    String INPUT_CREDENTIALS;
    String INPUT_DELIVERY_DATE;
    String DOUBLE_CHECK_LOAN;
    String DOUBLE_CHECK_DELIVERY;
    String LOAN_CANCELLED;
    String DELIVERY_CANCELLED;
    String CONFIRM_DELIVERY;
    String CONFIRM_LOAN;
    String CONFIRM;
    String CANCEL;
    String TRY_AGAIN;
    String NOTE;
    String LOAN_SUCCESSFUL;
    String DELIVERY_SUCCESSFUL;
    String INCORRECT_BARCODE_FORMAT;
     String INCORRECT_STUDENTNR_FORMAT;
     String INCORRECT_CREDENTIALS_FORMAT;
     String INCORRECT_DATE_FORMAT;
     String COMPONENT_DOESNT_EXIST;
     String STUDENTNR_DOESNT_EXIST;
     String COMPONENT_INACTIVE;
     String STUDENT_IS_INACTIVE;
    String COMPONENT_IS_LOANED;
     String COMPONENT_IS_NOT_LOANED;
     String DATE_IS_OUTDATED;
     String COMMUNICATION_ERROR;
     String NO_RESULT;

    public UdloansMis_UdlånsMisLogic(UdloansMis_UdlånsMisGUI mainGUI, TokenHandlerClient tokenhandler, IDatabaseRMI database, String serverIP) {       
        this.logFrame = new JFrame("UdlånsMis Log");
        this.mainGUI = mainGUI;
        this.tokenhandler = tokenhandler;
        this.database = database;
        checkforserver = new UdloansMis_CheckForServer(mainGUI, this, tokenhandler, database, serverIP);
        init();
    }

    private void init() {

        // Start server-checking thread
        Thread checkForServerThread = new Thread(checkforserver);
        checkForServerThread.start();

        // 
        startLog();
    }

    // Initialise log
    private void startLog() {

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
                mainGUI.setLogButtonState(false);
            }
        });
    }

    public void loan() {
        String dialogText = "";
        String errorText = "";
        String buttonText = "";
        String barcode = "";
        String studentNumber = "";
        String deliveryDateString = "";
        int daysUntilDelivery = 0;
        Date deliveryDate = null;
        Date currentDate = null;

        // *****************************************************************************
        // ***************************** SCAN THE BARCODE ******************************
        // *****************************************************************************
        errorText = "";
        dialogText = SCAN_BARCODE;
        while (true) {
            barcode = JOptionPane.showInputDialog(null, errorText + dialogText);
            if (barcode == null) {
                JOptionPane.showMessageDialog(null, LOAN_CANCELLED, NOTE, JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!barcode.matches("^([0-9]{6,10})$")) {
                errorText = INCORRECT_BARCODE_FORMAT;
                continue;
            }
            try {
                ComponentDTO component = database.getComponent(barcode, tokenhandler.getKeyToken(), tokenhandler.getID());
                if (component == null) {
                    errorText = COMPONENT_DOESNT_EXIST;
                    continue;
                }
                if (component.getStatus() != 1) {
                    errorText = COMPONENT_INACTIVE;
                    continue;
                }
                if (isLoaned(barcode)) {
                    errorText = COMPONENT_IS_LOANED;
                    continue;
                }
            } catch (RemoteException ex) {
                errorText = COMMUNICATION_ERROR;
                continue;
            }
            break;
        }

        // *****************************************************************************
        // ************************* SCAN THE STUDENT NUMBER ***************************
        // *****************************************************************************
        errorText = "";
        dialogText = SCAN_STUDENTNR;
        while (true) {
            studentNumber = JOptionPane.showInputDialog(null, errorText + dialogText);
            if (studentNumber == null) {
                JOptionPane.showMessageDialog(null, LOAN_CANCELLED, NOTE, JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!studentNumber.matches("^([sS][0-9]{6})$")) {
                errorText = INCORRECT_STUDENTNR_FORMAT;
                continue;
            }
            try {
                StudentDTO student = database.getStudent(studentNumber, tokenhandler.getKeyToken(), tokenhandler.getID());
                if (student == null) {
                    errorText = STUDENTNR_DOESNT_EXIST;
                    continue;
                }
                if (student.getStatus() != 1) {
                    errorText = STUDENT_IS_INACTIVE;
                    continue;
                }

            } catch (RemoteException ex) {
                errorText = COMMUNICATION_ERROR;
                continue;
            }
            break;
        }

        // *****************************************************************************
        // ************************** TYPE THE DELIVERY DATE ***************************
        // *****************************************************************************
        errorText = "";
        dialogText = INPUT_DELIVERY_DATE;
        while (true) {
            deliveryDateString = JOptionPane.showInputDialog(null, String.format(errorText + dialogText, dateToString(new Date())));
            if (deliveryDateString == null) {
                JOptionPane.showMessageDialog(null, LOAN_CANCELLED, NOTE, JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!deliveryDateString.matches("^(0?[1-9]|[12][0-9]|3[01])[/](0?[1-9]|1[012])[-](20)?[0-9][0-9]$")) {
                errorText = INCORRECT_DATE_FORMAT;
                continue;
            }
            currentDate = new Date();
            deliveryDate = getDateFromString(deliveryDateString);
            daysUntilDelivery = (int) ((deliveryDate.getTime() - currentDate.getTime()) / 86400000) + 1;
            if (daysUntilDelivery < 0) {
                errorText = DATE_IS_OUTDATED;
                continue;
            }
            break;
        }

        // *****************************************************************************
        // ******************************* CONFIRM LOAN ********************************
        // *****************************************************************************
        buttonText = CONFIRM;
        errorText = "";
        dialogText = DOUBLE_CHECK_LOAN;
        while (true) {
            String resumeTekstBoks = String.format(errorText + dialogText, barcode, studentNumber, daysUntilDelivery);
            Object[] options = {buttonText, CANCEL};
            int n = JOptionPane.showOptionDialog(null, resumeTekstBoks, CONFIRM_LOAN, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (n != 0) {
                JOptionPane.showMessageDialog(null, LOAN_CANCELLED, NOTE, JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                LoanDTO loan = new LoanDTO();
                loan.setComponent(database.getComponent(barcode, tokenhandler.getKeyToken(), tokenhandler.getID()));
                loan.setBarcode(barcode);
                loan.setStudentId(studentNumber);
                loan.setLoanDateFromDate(currentDate);
                loan.setDueDateFromDate(deliveryDate);
                int OK = database.createLoan(loan, tokenhandler.getKeyToken(), tokenhandler.getID());
                if (OK < 1) {
                    errorText = COMMUNICATION_ERROR;
                    buttonText = TRY_AGAIN;
                    continue;
                }
            } catch (RemoteException ex) {
                errorText = COMMUNICATION_ERROR;
                buttonText = TRY_AGAIN;
                continue;
            }
            break;
        }
        JOptionPane.showMessageDialog(null, LOAN_SUCCESSFUL);
    }

    public void delivery() {
        String dialogText = "";
        String errorText = "";
        String buttonText = "";
        String barcode = "";
        String credentials = "";
        ComponentDTO component = null;

        // *****************************************************************************
        // ***************************** SCAN THE BARCODE ******************************
        // *****************************************************************************
        errorText = "";
        dialogText = SCAN_BARCODE;
        while (true) {
            barcode = JOptionPane.showInputDialog(null, errorText + dialogText);
            if (barcode == null) {
                JOptionPane.showMessageDialog(null, DELIVERY_CANCELLED, NOTE, JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!barcode.matches("^([0-9]{6,10})$")) {
                errorText = INCORRECT_BARCODE_FORMAT;
                continue;
            }
            try {
                component = database.getComponent(barcode, tokenhandler.getKeyToken(), tokenhandler.getID());
                if (component == null) {
                    errorText = INCORRECT_BARCODE_FORMAT;
                    continue;
                }
                if (!isLoaned(barcode)) {
                    errorText = COMPONENT_IS_NOT_LOANED;
                    continue;
                }
            } catch (RemoteException ex) {
                errorText = COMMUNICATION_ERROR;
                continue;
            }
            break;

        }

        // *****************************************************************************
        // **************************** INPUT CREDENTIALS ******************************
        // *****************************************************************************
        errorText = "";
        dialogText = INPUT_CREDENTIALS;
        while (true) {
            credentials = JOptionPane.showInputDialog(null, errorText + dialogText);
            if (credentials == null) {
                JOptionPane.showMessageDialog(null, DELIVERY_CANCELLED, NOTE, JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (credentials.length() < 2 || credentials.length() > 30) {
                errorText = INCORRECT_CREDENTIALS_FORMAT;
                continue;
            }
            break;
        }

        // *****************************************************************************
        // ***************************** CONFIRM DELIVERY ******************************
        // *****************************************************************************
        buttonText = CONFIRM;
        errorText = "";
        dialogText = DOUBLE_CHECK_DELIVERY;
        while (true) {
            String resumeTekstBoks = String.format(errorText + dialogText, barcode, component.getComponentGroup().getName(), component.getComponentNumber());
            Object[] options = {buttonText, CANCEL};
            int n = JOptionPane.showOptionDialog(null, resumeTekstBoks, CONFIRM_LOAN, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            if (n != 0) {
                JOptionPane.showMessageDialog(null, DELIVERY_CANCELLED, NOTE, JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                LoanDTO loan = findLoaned(barcode);
                if (loan == null) {
                    JOptionPane.showMessageDialog(null, DELIVERY_CANCELLED, NOTE, JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Date currentDate = new Date();
                loan.setDeliveryDate(dateToString(currentDate));
                loan.setDeliveryDateFromDate(currentDate);
                loan.setDeliveredTo(credentials);
                int OK = database.updateLoan(loan, tokenhandler.getKeyToken(), tokenhandler.getID());
                if (OK < 1) {
                    errorText = COMMUNICATION_ERROR;
                    buttonText = TRY_AGAIN;
                    continue;
                }
            } catch (RemoteException ex) {
                errorText = COMMUNICATION_ERROR;
                buttonText = TRY_AGAIN;
                continue;
            }
            break;
        }
        JOptionPane.showMessageDialog(null, DELIVERY_SUCCESSFUL);
    }

    public void search(String keyword) throws RemoteException {

        LoanDTO[] loans;
        // Check filter and get DTO
        if (mainGUI.searchStudent) {
            loans = database.getLoansForStudent(keyword, tokenhandler.getKeyToken(), tokenhandler.getID());
        } else if (mainGUI.searchBarcode) {
            loans = database.getLoansForBarcode(keyword, tokenhandler.getKeyToken(), tokenhandler.getID());
        } else {
            loans = database.searchLoans(keyword, tokenhandler.getKeyToken(), tokenhandler.getID());
        }
        try {
            // Check if loaned and paint table
            int rowCount = 0;
            for (LoanDTO loan : loans) {
                if (mainGUI.searchState == 0) {
                    mainGUI.paintTable(loan, rowCount++);
                } else if (mainGUI.searchState == 1 && loan.getDeliveryDate() == null) {
                    mainGUI.paintTable(loan, rowCount++);
                } else if (mainGUI.searchState == 2 && loan.getDeliveryDate() != null) {
                    mainGUI.paintTable(loan, rowCount++);
                }
            }
        } catch (NullPointerException ex) {
            logPanel.println(NO_RESULT);
        }
    }

    private boolean isLoaned(String barcode) throws RemoteException {
        return findLoaned(barcode) != null;
    }

    private LoanDTO findLoaned(String barcode) throws RemoteException {
        LoanDTO[] loans = database.getLoansForBarcode(barcode, tokenhandler.getKeyToken(), tokenhandler.getID());
        if (loans == null) { // first time loaned check
            return null;
        }
        for (LoanDTO picked_loan : loans) {
            if (picked_loan.getDeliveryDate() == null) {
                return picked_loan;
            }
        }
        return null;
    }

    private String dateToString(Date currentDate) {
        return format.format(currentDate);
    }

    SimpleDateFormat format = new SimpleDateFormat("dd/MM-yy");

    private Date getDateFromString(String dateString) {
        String first = dateString.substring(0, dateString.indexOf("-") + 1);
        String last = dateString.substring(dateString.indexOf("-") + 1, dateString.length());
        if (last.length() < 4) {
            dateString = first + "20" + last;
        }
        Date date = null;
        try {
            date = format.parse(dateString);
        } catch (ParseException ex) {
            return null;
        }

        return date;
    }

    // Toggle log-window
    public void setLog() {
        if (!logEnabled) {
            // Show window
            logFrame.setVisible(true);
            logEnabled = true;
        } else {
            logFrame.setVisible(false);
            logEnabled = false;
        }
    }

    // Method to sync database when connection is lost
    public void setDatabase(IDatabaseRMI database) {
        this.database = database;
    }

    public void setLanguage(String lang) {
        if (lang.equals("EN")) {
            dialogTexts = new String[]{
                "Scan or type in the barcode on the component.\n(Fx. 12345678)",
                "Put the studentcard on the RFID læser, or type it in manually.\n(Fx. s123456)",
                "Returned to: (Type name or initials)",
                "Type in the due date, with the following format dd/MM-yy. (Fx. %s)",
                "Do you wish to create a loan for the following component?\n Barcode: %s, to %s, for %s days?",
                "Do you wish to deliver the following component?\nBarcode: %s, component type: %s (#%s)?",
                "The loan process has been cancelled.",
                "The delivering process has been cancelled.",
                "Confirm delivery",
                "Confirm loan",
                "Confirm",
                "Cancel",
                "Try again",
                "Observe!!",
                "The loan is registered.",
                "The delivery is completed.",
                "Incorrect barcode format!\n",
                "Incorrect studentnumber format!\n",
                "Incorrect credentials format!\n",
                "Incorrect date format!\n",
                "The component doesn't exist!\n",
                "The studentnumber doesn't exist!\n",
                "The component is inactive!\n",
                "The studentnumber is inactive!\n",
                "The component is already lent out!\n",
                "The component isn't lent out!\n",
                "Outdated date!\n",
                "Communication error!\n",
                "No result!\n"
            };
        } else if (lang.equals("DK")) {
            dialogTexts = new String[]{
                "Scan eller indtast stregkodenummer på udlånskomponent.\n(Ex. 12345678)",
                "Læg studiekortet på RFID læser, eller indtast studienummer.\n(Ex. s123456)",
                "Returneret til: (Indtast navn)",
                "Indtast afleveringsdato i dette format dd/MM-yy. (Ex. %s)",
                "Ønsker du at lave et udlån af følgende komponent?\nStregkode: %s, til %s i %s dage?",
                "Ønsker du at aflevere følgende komponent?\nStregkode: %s, komponent navn: %s?",
                "Udlånet er afbrudt.",
                "Aflevereringen er afbrudt.",
                "Bekræft afleverering",
                "Bekræft udlån",
                "Bekræft",
                "Afbryd",
                "Prøv igen",
                "Bemærk!",
                "Udlånet er gennemført.",
                "Aflevereringen er gennemført.",
                "Forkert stregkode-format!\n",
                "Forkert studienummer-format!\n",
                "Forkert credentials-format!\n",
                "Forkert dato format!\n",
                "Komponenten findes ikke!\n",
                "Studienumeret findes ikke!\n",
                "Komponenten er inaktiv!\n",
                "Studienumeret er inaktiv!\n",
                "Komponenten er allerede lånt ud!\n",
                "Komponenten er ikke lånt ud!\n",
                "Forældet dato!\n",
                "Kommunikationsfejl!\n",
                "Intet resultat!\n"
            };
        }
        SCAN_BARCODE = dialogTexts[0];
        SCAN_STUDENTNR = dialogTexts[1];
        INPUT_CREDENTIALS = dialogTexts[2];
        INPUT_DELIVERY_DATE = dialogTexts[3];
        DOUBLE_CHECK_LOAN = dialogTexts[4];
        DOUBLE_CHECK_DELIVERY = dialogTexts[5];
        LOAN_CANCELLED = dialogTexts[6];
        DELIVERY_CANCELLED = dialogTexts[7];
        CONFIRM_DELIVERY = dialogTexts[8];
        CONFIRM_LOAN = dialogTexts[9];
        CONFIRM = dialogTexts[10];
        CANCEL = dialogTexts[11];
        TRY_AGAIN = dialogTexts[12];
        NOTE = dialogTexts[13];
        LOAN_SUCCESSFUL = dialogTexts[14];
        DELIVERY_SUCCESSFUL = dialogTexts[15];
        INCORRECT_BARCODE_FORMAT = dialogTexts[16];
        INCORRECT_STUDENTNR_FORMAT = dialogTexts[17];
        INCORRECT_CREDENTIALS_FORMAT = dialogTexts[18];
        INCORRECT_DATE_FORMAT = dialogTexts[19];
        COMPONENT_DOESNT_EXIST = dialogTexts[20];
        STUDENTNR_DOESNT_EXIST = dialogTexts[21];
        COMPONENT_INACTIVE = dialogTexts[22];
        STUDENT_IS_INACTIVE = dialogTexts[23];
        COMPONENT_IS_LOANED = dialogTexts[24];
        COMPONENT_IS_NOT_LOANED = dialogTexts[25];
        DATE_IS_OUTDATED = dialogTexts[26];
        COMMUNICATION_ERROR = dialogTexts[27];
        NO_RESULT = dialogTexts[28];
    }
}
