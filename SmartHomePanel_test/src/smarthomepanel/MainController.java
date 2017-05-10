package smarthomepanel;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class MainController implements Initializable {

    @FXML
    private Button btnVideo;
    @FXML
    private Button btnControl;
    @FXML
    private Button btnChart;
    @FXML
    private Button btnNotice;
    @FXML
    private Button btnSetting;
    @FXML
    private Button btnCall;
    @FXML
    private Button btnHome;
    @FXML
    private ImageView btnHomeImage;
    @FXML
    private ImageView btnVideoImage;
    @FXML
    private ImageView btnControlImage;
    @FXML
    private ImageView btnChartImage;
    @FXML
    private ImageView btnNoticeImage;
    @FXML
    private ImageView btnSettingImage;
    @FXML
    private ImageView btnCallImage;
    @FXML
    private Label lblTime;
    @FXML
    private StackPane stackPane;
    @FXML
    private ImageView packImage;

    private boolean packNotice = true;

    public void setPackNotice(boolean packNotice) {
        this.packNotice = packNotice;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Hover 상태일때 이미지에 그림자 효과주기
        btnHome.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue == true) {
                    btnHomeImage.setImage(new Image(getClass().getResource("images/icons/home_shadow.png").toString()));
                } else {
                    btnHomeImage.setImage(new Image(getClass().getResource("images/icons/home(white).png").toString()));
                }
            }
        });

        btnCall.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue == true) {
                    btnCallImage.setImage(new Image(getClass().getResource("images/icons/call(shadow).png").toString()));
                } else {
                    btnCallImage.setImage(new Image(getClass().getResource("images/icons/call.png").toString()));
                }
            }
        });

        btnVideo.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue == true) {
                    btnVideoImage.setImage(new Image(getClass().getResource("images/icons/eye(shadow).png").toString()));
                } else {
                    btnVideoImage.setImage(new Image(getClass().getResource("images/icons/eye(white).png").toString()));
                }
            }
        });

        btnControl.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue == true) {
                    btnControlImage.setImage(new Image(getClass().getResource("images/icons/ammeter(shadow).png").toString()));
                } else {
                    btnControlImage.setImage(new Image(getClass().getResource("images/icons/ammeter(white).png").toString()));
                }
            }
        });

        btnChart.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue == true) {
                    btnChartImage.setImage(new Image(getClass().getResource("images/icons/chart(shadow).png").toString()));
                } else {
                    btnChartImage.setImage(new Image(getClass().getResource("images/icons/chart(white).png").toString()));
                }
            }
        });

        btnNotice.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue == true) {
                    btnNoticeImage.setImage(new Image(getClass().getResource("images/icons/notepad(shadow).png").toString()));
                } else {
                    btnNoticeImage.setImage(new Image(getClass().getResource("images/icons/notepad(white).png").toString()));
                }
            }
        });

        btnSetting.hoverProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue == true) {
                    btnSettingImage.setImage(new Image(getClass().getResource("images/icons/settings(shadow).png").toString()));
                } else {
                    btnSettingImage.setImage(new Image(getClass().getResource("images/icons/settings(white).png").toString()));
                }
            }
        });

        //시간정보 설정
        Thread thread = new Thread() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm");
                while (true) {
                    String strTime = sdf.format(new Date());
                    Platform.runLater(() -> {
                        lblTime.setText(strTime);
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        thread.setDaemon(true);
        thread.start();

        //택배알림
        if (packNotice == true) {
            FadeTransition ft = new FadeTransition(Duration.millis(700), packImage);
            ft.setFromValue(1.0);
            ft.setToValue(0.1);
            ft.setCycleCount(Timeline.INDEFINITE);
            ft.setAutoReverse(true);
            ft.play();
        }
        
        //버튼 눌렀을 때 화면 전환
        btnCall.setOnAction(e -> handleBtnCall(e));
        btnVideo.setOnAction(e -> handleBtnVideo(e));
        btnControl.setOnAction(e -> handleBtnControl(e));
        btnChart.setOnAction(e -> handleBtnChart(e));
        btnNotice.setOnAction(e -> handleBtnNotice(e));
        btnSetting.setOnAction(e -> handleBtnSetting(e));

    }

    private void handleBtnCall(ActionEvent e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("call/Call.fxml"));
            stackPane.getChildren().add(parent); // root.fxml의 stackpane보다 위에 Chart.fxml이 쌓인다

            parent.setOpacity(0);

            KeyValue keyValue = new KeyValue(parent.opacityProperty(), 1);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
            Timeline timeLine = new Timeline();
            timeLine.getKeyFrames().add(keyFrame);
            timeLine.play();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void handleBtnVideo(ActionEvent e) { // suyang
			try {
            Parent parent = FXMLLoader.load(getClass().getResource("video/Video.fxml"));
            stackPane.getChildren().add(parent); // root.fxml의 stackpane보다 위에 Vidio.fxml이 쌓인다

            parent.setOpacity(0);

            KeyValue keyValue = new KeyValue(parent.opacityProperty(), 1);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
            Timeline timeLine = new Timeline();
            timeLine.getKeyFrames().add(keyFrame);
            timeLine.play();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void handleBtnControl(ActionEvent e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("Control.fxml"));
            stackPane.getChildren().add(parent);

            parent.setOpacity(0);

            KeyValue keyValue = new KeyValue(parent.opacityProperty(), 1);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
            Timeline timeLine = new Timeline();
            timeLine.getKeyFrames().add(keyFrame);
            timeLine.play();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void handleBtnChart(ActionEvent e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("Chart.fxml"));
            stackPane.getChildren().add(parent); // root.fxml의 stackpane보다 위에 Chart.fxml이 쌓인다

            parent.setOpacity(0);

            KeyValue keyValue = new KeyValue(parent.opacityProperty(), 1);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
            Timeline timeLine = new Timeline();
            timeLine.getKeyFrames().add(keyFrame);
            timeLine.play();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void handleBtnNotice(ActionEvent e) {
    }

    private void handleBtnSetting(ActionEvent e) {
    }

}
