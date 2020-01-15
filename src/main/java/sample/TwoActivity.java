package sample;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.StageStyle;
import sample.library.Activity;
import sample.library.ActivityManager;
import sample.library.ApplicationContext;

public class TwoActivity extends Activity {

    @Override
    public void onCreat(Object bundle) {
        super.onCreat(bundle);
        getWindow().setHeight(700);
        getWindow().setWidth(700);
        setContentView("fxml/two.fxml");

        AnchorPane a = findViewById("apl", AnchorPane.class);
        setWindowMoveXYMouseDragged(a);

        int size = ((ApplicationContext) getApplicationContext()).getManager().getSize();
        System.out.println("size==" + size);

        ActivityManager activityManager = ((ApplicationContext) getApplicationContext()).getManager();

        for (int i = 0; i < size; i++) {
            Activity activity = activityManager.getActivity(i);
            System.out.println("getName==" + activity.getClass().getName());
        }
    }
}
