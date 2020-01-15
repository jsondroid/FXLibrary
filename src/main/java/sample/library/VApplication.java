package sample.library;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.MainActivity;
import sample.library.*;

import java.lang.reflect.Constructor;

public class VApplication extends Application {

    private ApplicationContext applicationContext;
    private ActivitContext activitContext;

    public void start(Stage primaryStage) throws Exception {
        applicationContext = new ApplicationContext();
        activitContext = new ActivitContext();
        activitContext.attachApplicationContext(applicationContext);
        onCreat();
    }

    public void onCreat() {
        applicationContext.onCreat();
        Intent intent = new Intent(activitContext, MainActivity.class);
        applicationContext.startActivity(intent);
    }

    public static void launchApp(String... args) {
        Application.launch(args);
    }
}
