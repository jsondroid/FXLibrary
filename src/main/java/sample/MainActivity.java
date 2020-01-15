package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.library.Activity;
import sample.library.ApplicationContext;
import sample.library.Intent;

public class MainActivity extends Activity {

    @FXML
    Button btn_mm;
    @FXML
    Button btn_m;

    @Override
    public void onCreat(Object bundle) {
        super.onCreat(bundle);
        setContentView("fxml/sample.fxml");

//        String str = getIntent().getExtra("tt", "", String.class);
//        System.out.println("数据==" + str);

        int size = ((ApplicationContext) getApplicationContext()).getManager().getSize();
        System.out.println("size==" + size);

        btn_mm.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.putExtra("tt", getOSName());
                startActivity(intent);
            }
        });

        btn_m.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                finish();
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("onPause是否退出===");
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy===");
    }
}
