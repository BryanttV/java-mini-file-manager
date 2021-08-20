package comunication;

import logic.encapsulate.PortCompressor;

/**
 *
 * @author Bryann_Valderrama
 */
public class PCompressor {

    public static ICompressor compressFile() {
        PortCompressor pc = new PortCompressor();
        return pc;
    }
}
