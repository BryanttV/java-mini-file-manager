package comunication;

import logic.encapsulate.PortArchiver;

/**
 *
 * @author Bryann_Valderrama
 */
public class PArchiver {

    public static IArchiver obtainFile() {
        PortArchiver pa = new PortArchiver();
        return pa;
    }
}
