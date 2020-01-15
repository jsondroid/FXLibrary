package sample.library;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Activity extends ActivitContext {

    private Intent intent;
    protected Stage stage;
    protected Scene scene;
    protected Parent parent;
    protected Window window;
    private double xOffset = 0;
    private double yOffset = 0;

    public Activity() {
        window = new Window();
    }

    public void attachBaseContext(Context context, Intent intent) {
        mBase = context;
        this.intent = intent;
        onCreat(null);
    }

    public void onCreat(Object bundle) {

    }

    public Window getWindow() {
        return window;
    }

    public void setContentView(String resource_layout) {
        this.setContentView(resource_layout, null, null);
    }

    public void setContentView(String resource_layout, StageStyle style) {
        this.setContentView(resource_layout, null, style);
    }

    public void setContentView(String resource_layout, ResourceBundle resourceBundle, StageStyle style) {
        URL url = Thread.currentThread().getContextClassLoader().getResource(resource_layout);
        FXMLLoader loader = new FXMLLoader(url);
        try {
            loader.setController(this);
            /**实现国际化的资源 ResourceBundle.getBundle("i18n/message")*/
            if (resourceBundle != null) {
                loader.setResources(resourceBundle);
            }
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        double width = window.getWidth();
        double height = window.getHeight();

        scene = new Scene(parent);
        stage = new Stage();

        if (width > 0) {
            stage.setWidth(width);
        }
        if (height > 0) {
            stage.setHeight(height);
        }

        stage.setScene(scene);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                System.out.println("窗口监听===" + event.toString());
                if (event.getEventType() == WindowEvent.WINDOW_CLOSE_REQUEST) {
                    onDestroy();
                }
                if (event.getEventType() == WindowEvent.WINDOW_HIDDEN) {
                    onStop();
                }
                if (event.getEventType() == WindowEvent.WINDOW_HIDING) {
                    onPause();
                }
                if (event.getEventType() == WindowEvent.WINDOW_SHOWING) {
                    onShowing();
                }
                if (event.getEventType() == WindowEvent.WINDOW_SHOWN) {
                    onShow();
                }
            }
        });
        if (style != null) {
            stage.initStyle(style);
        }
    }

    public Node findViewById(String name) {
        if (this.scene == null) {
            return null;
        }
        return this.scene.lookup("#" + name);
    }

    public <T extends Node> T findViewById(String name, Class<T> cls) {
        if (this.scene == null) {
            return null;
        }
        return (T) this.scene.lookup("#" + name);
    }

    @Override
    public void startActivity(Intent intent) {
        if (intent == null) {
            this.onStart();
        } else {
            super.startActivity(intent);
        }
    }

    public Intent getIntent() {
        return intent;
    }


    public void onDestroy() {
        //出栈
        ((ApplicationContext) getApplicationContext()).getManager().remove(this);
    }

    public void onShow() {

    }

    public void onShowing() {

    }

    public void onPause() {

    }

    public void onStop() {

    }

    public void onStart() {
        if (stage != null) {
            stage.show();
//            if (window != null) {
//                double width = window.getWidth() == 0 ? scene.getWidth() : window.getWidth();
//                double height = window.getHeight() == 0 ? scene.getHeight() : window.getHeight();
//                stage.setWidth(width);
//                stage.setHeight(height);
//            /**居中偏上*/
//                stage.setX((window.getScreenWidth() - stage.getScene().getWidth()) / 2f);
//                stage.setY((window.getScreenHeight() - stage.getScene().getHeight()) / 2f);
//                stage.setY((window.getScreenHeight() - stage.getScene().getHeight()) / 1.845f);
//            }
        }
    }

    public void finish() {
        if (stage != null) {
            stage.close();
            onDestroy();
        }
    }

    public void exit() {
        finish();
        System.exit(0);
    }

    public void runOnUiThread(Runnable runnable) {
        Platform.runLater(runnable);
    }

    /**
     * 鼠标按下时，记下相对于 root左上角(0,0) 的 x, y坐标, 也就是x偏移量 = x - 0, y偏移量 = y - 0
     */
    public void setOnMousePressed(MouseEvent event) {
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
    }

    /**
     * 根据偏移量设置primaryStage新的位置
     */
    public void setOnMouseDragged(MouseEvent event) {
        stage.setX(event.getScreenX() - xOffset);
        stage.setY(event.getScreenY() - yOffset);
    }

    public void setWindowMoveXYMouseDragged(Node node) {
        node.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                setOnMousePressed(event);
            }
        });
        node.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                setOnMouseDragged(event);
            }
        });
    }


    public final class Window {

        private double width;
        private double height;
        private Rectangle2D screenBounds;

        public Window() {
            this.screenBounds = Screen.getPrimary().getVisualBounds();
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public double getScreenWidth() {
            return screenBounds.getWidth();
        }

        public double getScreenHeight() {
            return screenBounds.getHeight();
        }
    }
}
