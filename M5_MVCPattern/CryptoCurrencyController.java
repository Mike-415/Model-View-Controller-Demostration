package M5_MVCPattern;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static M5_MVCPattern.CryptoCurrencyController.CryptocurrencyType.PROGRAMMABLE_COIN;

public class CryptoCurrencyController extends Application
{


    enum CryptocurrencyType
    {
        PROGRAMMABLE_COIN(1),
        ANONYMOUS_COIN(2),
        LOTTERY_COIN(3);
        private int type;
        CryptocurrencyType(int type)
        {
            this.type = type;
        }

    }
    private CryptoCurrency     theModel;     //The Model
    private CryptoCurrencyView theView;       //The View
    private static final String ERROR = "Please select a cryptocurrency \n"+
                                        "in the drop-down menu";
    //I attempted to use the 'CryptocurrencyType' enum in a switch statement,
    // but there was an error that occured.
    public static final String ADA_COIN = "AdaCoin";
    public static final String HUSH_COIN = "HushCoin";
    public static final String LUCKY_COIN = "LuckyCoin";

    public CryptoCurrencyController()
    {
        theView = new CryptoCurrencyView();
        theView.setInfoButtonAction(this::displayInfo);
        theView.setProcessButtonAction(this::processCryptocurrency);
        theView.setOnSelectionAction(this::clearTextArea);
    }
    private boolean optionSelected()
    {
        String fieldSelected = theView.getSelectionField();
        if(fieldSelected.equals(CryptoCurrencyView.DEFAULT_SELECTION))
        {

            return false;
        }
        return true;
    }
    private void assignTheModel()
    {
        switch (theView.getSelectionField())
        {
            case ADA_COIN:
                theModel = CryptoCurrencyFactory.getInstance(PROGRAMMABLE_COIN.type);
                break;
            case HUSH_COIN:
                theModel = CryptoCurrencyFactory.getInstance(CryptocurrencyType.ANONYMOUS_COIN.type);
                break;
            case LUCKY_COIN:
                theModel = CryptoCurrencyFactory.getInstance(CryptocurrencyType.LOTTERY_COIN.type);
                break;
        }
    }

    private String evokeClassMethod()
    {
        String results = "";
        switch (theModel.getName())
        {
            case ADA_COIN:
                ProgrammableCoin programmableCoin = (ProgrammableCoin) theModel;
                results += programmableCoin.runProgram();
                break;
            case HUSH_COIN:
                AnonymousCoin anonymousCoin = (AnonymousCoin) theModel;
                results += anonymousCoin.getHashingAlgoType();
                break;
            case LUCKY_COIN:
                LotteryCoin lotteryCoin = (LotteryCoin) theModel;
                results += lotteryCoin.playLotto();
                break;

        }

        return results;
    }

    private void displayInfo(ActionEvent event)
    {
        if(optionSelected())
        {
            assignTheModel();
            theView.displayResultText(theModel.toString());
        }
        else
        {
            displayError();
        }
    }


    private void processCryptocurrency(ActionEvent event)
    {
        if(optionSelected())
        {
            assignTheModel();
            theView.displayResultText(evokeClassMethod());
        }
        else
        {
            displayError();
        }
    }
    private void displayError()
    {
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("Error");
        error.setHeaderText(null);
        error.setContentText(ERROR);
        error.showAndWait();
    }

    private void clearTextArea(Event event)
    {
        theView.hideResultText();
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        CryptoCurrencyController controller = new CryptoCurrencyController();

        Scene scene = new Scene(controller.theView.getRootNode(), 600, 400, Color.WHEAT);
        primaryStage.setTitle("Cryptocurrency Information");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
