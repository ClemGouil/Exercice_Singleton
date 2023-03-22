import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.ResourceBundle;

public final class I18NManager {

    private HashMap<String ,ResourceBundle> cache = new HashMap<>();


    private static final I18NManager instance = new I18NManager();

    private I18NManager(){}

    public static I18NManager getInstance(){
        return instance;
    }

    public void  clear(){
    }

    public String getText(String langue ,String line) throws IOException {
        if (cache.containsKey(langue)) {
            return cache.get(langue).getString(line);
        } else {
            ResourceBundle rb = ResourceBundle.getBundle(langue);
            cache.put(langue,rb);
           ;return rb.getString(line);
        }
    }
}
