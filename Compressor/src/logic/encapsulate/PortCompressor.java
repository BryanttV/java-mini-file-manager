package logic.encapsulate;

import comunication.ICompressor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author Bryann_Valderrama
 */
public class PortCompressor implements ICompressor {

    @Override
    public boolean compress(String path, String file) {
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        FileInputStream fis = null;

        try {
            fos = new FileOutputStream(path.substring(0, path.indexOf(".")) + ".zip");
            zos = new ZipOutputStream(fos);

            File f = new File(path);
            fis = new FileInputStream(f);

            ZipEntry ze = new ZipEntry(f.getName());
            zos.putNextEntry(ze);

            byte[] bytes = new byte[1024];
            int len;

            while ((len = fis.read(bytes)) > 0) {
                zos.write(bytes, 0, len);
            }

            return true;

        } catch (IOException ex) {
            
            return false;

        } finally {
            try {
                // Cierre de flujos de datos
                if (zos != null) {
                    zos.close();
                }
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex) {
                System.out.println("Error en el cierro de flujo");
            }
        }
    }
}
