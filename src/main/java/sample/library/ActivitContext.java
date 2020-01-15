package sample.library;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ActivitContext extends ContextWrapper {

    public ActivitContext() {
        super(null);
    }

    public ActivitContext(Context context) {
        super(context);
    }


    public void startActivity(Intent intent) {
        if (intent != null) {
            intent.getActivity().attachBaseContext(mBase, intent);
            intent.getActivity().onStart();
        }
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        mBase.startActivityForResult(intent, requestCode);
    }


}
