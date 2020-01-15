package sample.library;

import javafx.fxml.FXMLLoader;

import java.net.URL;
import java.util.ResourceBundle;

public class LayoutInflater {

    /**
     * 加载xml布局
     *
     * @param resource xml文件
     * @param clazz    转成的类型 如：Pane
     */
    @SuppressWarnings("unchecked")
    public <T> T inflaterLayout(String resource, Class<T> clazz) {
        try {
            URL url = Thread.currentThread().getContextClassLoader().getResource(resource);
            FXMLLoader loader = new FXMLLoader(url);
            return (T) loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加载xml布局
     *
     * @param resource  xml文件
     * @param clazz     转成的类型 如：Pane
     * @param resources 资源
     */
    @SuppressWarnings("unchecked")
    public <T> T inflaterLayout(String resource, Class<T> clazz, ResourceBundle resources) {
        try {
            URL url = Thread.currentThread().getContextClassLoader().getResource(resource);
            return (T) FXMLLoader.load(url, resources);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
