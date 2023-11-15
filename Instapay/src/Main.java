import Instapay.SystemGUI;

public class Main {
    public static void main(String[] args) {
        // Users
        // sarewalid => Sa12345
        // shawky => Sh12345
        // sohaila => So12345
        // khadija => Kh12345

        // Each user with money method
        // shawky => bankNumber (123456789)
        // sohaila => bankNumber (987654321)
        // sara => walletNumber (01012345678)
        // khadija => walletNumber (01004579971)

        // To register a new account, use any one from the below (bank or wallet) please :)
        // Available wallets numbers:
        // 01004579971
        // 01012345678

        // Available banks account numbers:
        // bankNumber: 123456789 - mobileNumber: 01004579971
        // bankNumber: 987654321 - mobileNumber: 01012345678

        SystemGUI systemGUI = new SystemGUI();
        systemGUI.displayMenu();
    }
}
