package UILayer;

import java.awt.Window;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Created by RaidenRabit on 2016-11-25.
 */
public enum ErrorCode {
    // when you want to introduce new error code, put it before this one and put " , " instead of " ; ", only the last one should have " ; "
    WRONG_CPR_INPUT("CPR/CVR must be 10 digits long and must not contain letters."),
    ID_ALREADY_EXISTS("workId/CPR/CVR already exists in the system"),
    WRONG_NAME_INPUT("NAME must consist of at least 4 characters"),
    WRONG_ADDRESS_INPUT("ADDRESS must contain both the street and house number and must consist of at least 3 characters"),
    WRONG_EMAIL_INPUT("EMAIL must contain \"@\" and \".\" and must consist of at least 5 characters."),
    WRONG_PHONE_LENGTH_INPUT("PHONE must be between 5 and 15 numbers"),
    WRONG_PHONE_INPUT("PHONE must not contain and letters"),
    WRONG_CITY_INPUT("CITY must consist of at least 3 characters"),
    WRONG_INPUT_INTEGER("Please introduce a number, not a character"),
    WRONG_INT_INPUT("Please select one of the available options"),
    WRONG_WORKID_INPUT("WORKID must be 6 digits long and must not contain letters."),
    WRONG_SALE_OR_LOAN_NUMBERID("The numberID must be at least 5 digits long!"),
    WRONG_QUANTITY("The quantity must be not a negative number, zero or greater than the available quantity at warehouse!"),
    WRONG_PRICE("The price cannot be negative or zero!"),
    WRONG_PERIOD("The period of time must be an integer and it's read in weeks (1 == 1 week, 2 == 2 weeks ...)"),
    NO_SUCH_CUSTOMER("There is no Customer with this CPR"),
    NO_SUCH_EMPLOYEE("There is no Employee with this ID"),
    NO_SUCH_CONTRACTOR("There is no Contractor with this CVR"),
    BARCODE_ALREADY_EXISTS("This barcode already exist, chose different one"),
    NO_SUCH_ITEM("This item doesn't exist"),
    WRONG_BARCODE("Barcode must be at least 4 symbols");

    private String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }

    public static void print(ErrorCode code) {
        String Msg = "";
        Msg += code.getErrorMessage();
        if (code.getErrorMessage() == "" || code.getErrorMessage() == null) {
            Msg += "Unknown error.";
        }
        //System.out.println(Msg);
        //JOptionPane.showMessageDialog(null, Msg);
        printErrorJPanel(Msg);
    }
    
    private static void printErrorJPanel(String Msg) {
    	// create a jframe
    		JFrame frame = new JFrame("Something");

//        // show a joptionpane dialog using showMessageDialog
			JOptionPane.showMessageDialog(frame,
            "ERROR: '" + Msg + "'.",
            "ERROR",
            JOptionPane.OK_CANCEL_OPTION);
			Window window  = SwingUtilities.getWindowAncestor(frame);
			window.dispose();
    }
}
