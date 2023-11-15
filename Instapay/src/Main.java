import Instapay.SystemGUI;

public class Main {
    public static void main(String[] args) {
        // Users
        // sarewalid => sarawalid
        // shawkyebrahim => shawkyebrahim
        // sohaila => sohaila
        // khad => khad
        // basmala => Ba123456789

        // Each user with money method
        // shawky => bank (123456789)
        // sohaila => bank (987654321)
        // sara => wallet (01012345678)
        // khadija => wallet (01004579971)
        // basmala => bank(987654321)

        SystemGUI systemGUI = new SystemGUI();
        systemGUI.displayMenu();
    }
}