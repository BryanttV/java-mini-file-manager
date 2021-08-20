package comunication;

/**
 *
 * @author Bryann_Valderrama
 */
public interface IArchiver {

    public boolean save(String path, String text);

    public String load(String path);

}
