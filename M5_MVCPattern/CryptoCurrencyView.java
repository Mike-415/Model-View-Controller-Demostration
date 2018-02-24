package M5_MVCPattern;
import MVCPatternTemp2.Status;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;


public class CryptoCurrencyView
{
    //List<String> cryptoCurrencyList;
    private Text selectionText;
    private TextArea infoTextArea;
    private ComboBox<String> cryptocurrencySelection;
    private HBox nestedTopNode, nestedFirstMiddleNode, nestedSecondMiddleNode, nestedBottomNode;
    private Button processButton, infoButton;
    private VBox rootNode;
    private static final Font FONT = Font.font("roboto mono", FontWeight.BOLD, 18);
    private static final int PADDING = 30;
    public static final String DEFAULT_SELECTION = "Choose a cryptocurrency..."; //used in controller

    private Text formatSelectionText()
    {
        Text text = new Text("Please choose a cryptocurrency:");
        text.setFont(FONT);
        return text;
    }
    private HBox formatNestedNode(Node...nodes)
    {
        HBox hBox = new HBox(nodes);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(15);
        return hBox;
    }

    private HBox formatNestedTopNode(Node...nodes)
    {
        HBox hBox = formatNestedNode(nodes);
        hBox.setPadding(new Insets(30, 0, PADDING, 0));
        return hBox;
    }


    private ComboBox formatCryptocurrencySelection()
    {
        List<String> list = new ArrayList<>();
        list.add("AdaCoin");
        list.add("HushCoin");
        list.add("LuckyCoin");
        ObservableList<String> cryptoCurrencyOptions = FXCollections.observableArrayList(list);
        ComboBox<String> comboBox = new ComboBox<>(cryptoCurrencyOptions);
        comboBox.setValue(DEFAULT_SELECTION);
        comboBox.setMinWidth(277);
        return comboBox;
    }

    private HBox formatNestedFirstMiddleNode(Node...nodes)
    {
        HBox hBox = formatNestedNode(nodes);
        hBox.setPadding(new Insets(0, 0, PADDING, 0));
        return hBox;
    }
    private TextArea formatInfoTextArea()
    {
        TextArea textArea = new TextArea();
        textArea.setMinSize(100, 100);
        textArea.setVisible(false);
        return textArea;
    }

    private Button formatButton(String buttonLabel)
    {
        Button button = new Button(buttonLabel);
        button.setMinWidth(131);
        return button;
    }
    private HBox formatNestedBottomNode(Node...nodes)
    {
        HBox hBox = formatNestedNode(nodes);
        hBox.setPadding(new Insets(PADDING, 0, PADDING, 0));
        return hBox;
    }

    public VBox getRootNode()
    {
        return rootNode;
    }

    public void setProcessButtonAction(EventHandler<ActionEvent> handler)
    {
        processButton.setOnAction(handler);
    }
    public void setInfoButtonAction(EventHandler<ActionEvent> handler)
    {
        infoButton.setOnAction(handler);
    }
    public void setOnSelectionAction(EventHandler<Event> handler){cryptocurrencySelection.setOnShowing(handler);}
    public String getSelectionField()
    {
        return cryptocurrencySelection.getValue();
    }
    public void displayResultText(String output)
    {
        infoTextArea.clear();
        infoTextArea.setVisible(true);
        infoTextArea.setText(output);
    }

    public void hideResultText()
    {
        infoTextArea.clear();
        infoTextArea.setVisible(false);
        infoTextArea.setVisible(false);
    }

    public CryptoCurrencyView()
    {
        selectionText = formatSelectionText();
        nestedTopNode = formatNestedTopNode(selectionText);

        cryptocurrencySelection = formatCryptocurrencySelection();
        nestedFirstMiddleNode = formatNestedFirstMiddleNode(cryptocurrencySelection);

        infoTextArea = formatInfoTextArea();
        nestedSecondMiddleNode = formatNestedNode(infoTextArea);

        processButton = formatButton("Process");
        infoButton = formatButton("Info");
        nestedBottomNode = formatNestedBottomNode(infoButton, processButton);

        rootNode = new VBox(nestedTopNode, nestedFirstMiddleNode, nestedSecondMiddleNode, nestedBottomNode);
        rootNode.setStyle("-fx-background-color:null;");
    }
//    @Override
//    public void start(Stage primaryStage) throws Exception
//    {
//        selectionText = formatSelectionText();
//        nestedTopNode = formatNestedTopNode(selectionText);
//
//        cryptocurrencySelection = formatCryptocurrencySelection();
//        nestedFirstMiddleNode = formatNestedFirstMiddleNode(cryptocurrencySelection);
//
//        infoTextArea = formatInfoTextArea();
//        nestedSecondMiddleNode = formatNestedNode(infoTextArea);
//
//        processButton = formatButton("Process");
//        infoButton = formatButton("Info");
//        nestedBottomNode = formatNestedBottomNode(processButton, infoButton);
//
//        rootNode = new VBox(nestedTopNode, nestedFirstMiddleNode, nestedSecondMiddleNode, nestedBottomNode);
//        rootNode.setStyle("-fx-background-color:null;");
//
//        Scene scene = new Scene(rootNode, 400, 400, Paint.valueOf("white"));
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Cryptocurrency Information");
//        primaryStage.show();
//
//    }
//
//    public static void main(String[] args)
//    {
//        launch(args);
//    }
}
