package seedu.us.among.ui;

import static java.util.Objects.requireNonNull;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.util.Duration;
import seedu.us.among.model.endpoint.Endpoint;

/**
 * A ui for the status bar that is displayed at the header of the application.
 */
public class ResultDisplay extends UiPart<Region> {

    private static final String FXML = "ResultDisplay.fxml";

    @FXML
    private TextArea resultDisplay;
    @FXML
    private FlowPane responseMeta;
    @FXML
    private ImageView loadingSpinnerPlaceholder;
    @FXML
    private ImageView errorPlaceholder;

    private Timeline errorGifTimeline;

    private final Image loadingSpinner = new Image(this.getClass().getResourceAsStream("/images/loading_spinner.gif"));
    private final Image error = new Image(this.getClass().getResourceAsStream("/images/error.gif"));

    /**
     * Constructor for ResultDisplay.
     */
    public ResultDisplay() {
        super(FXML);
        this.loadingSpinnerPlaceholder.setImage(loadingSpinner);
        this.errorPlaceholder.setImage(error);
        // Set timeline for error message
        this.errorGifTimeline = new Timeline(
            new KeyFrame(Duration.ZERO, x -> this.getErrorPlaceholder().setVisible(true)),
            new KeyFrame(Duration.seconds(3), x -> this.getErrorPlaceholder().setVisible(false))
        );
    }

    /**
     * Gets loadingSpinnerPlaceholder.
     *
     * @return loadingSpinnerPlaceholder
     */
    public ImageView getLoadingSpinnerPlaceholder() {
        return this.loadingSpinnerPlaceholder;
    }

    /**
     * Gets errorPlaceholder.
     *
     * @return errorPlaceholder
     */
    public ImageView getErrorPlaceholder() {
        //hack to reset animation by loading image again
        this.errorPlaceholder.setImage(new Image(this.getClass().getResourceAsStream("/images/error.gif")));
        return this.errorPlaceholder;
    }

    public Timeline getErrorGifTimeline() {
        return this.errorGifTimeline;
    }

    /**
     * Helper function for setting feedback to user.
     *
     * @param feedbackToUser feedback to give user
     */
    public void feedbackHelper(String feedbackToUser) {
        responseMeta.getChildren().clear();
        resultDisplay.setText(feedbackToUser);
    }

    /**
     * Sets feedback to user.
     *
     * @param feedbackToUser feedback to give user
     */
    public void setFeedbackToUser(String feedbackToUser) {
        requireNonNull(feedbackToUser);
        if (!Platform.isFxApplicationThread()) {
            Platform.runLater(() -> feedbackHelper(feedbackToUser));
        } else {
            feedbackHelper(feedbackToUser);
        }
    }

    /**
     * Helper function for setting API feedback to user.
     *
     * @param textFeedback API feedback to give user
     * @param endpoint endpoint to give feedback for
     */
    public void apiFeedbackHelper(String textFeedback, Endpoint endpoint) {
        responseMeta.getChildren().clear();
        responseMeta.getChildren().addAll(new Label(String.format("Method: %s", endpoint.getMethod().toString())),
                new Label(String.format("Status: %s", endpoint.getResponse().getStatusCode())),
                new Label(String.format("Time: %s", endpoint.getResponse().getResponseTime())));
        resultDisplay.setText(textFeedback);
    }

    /**
     * Sets API feedback to user.
     *
     * @param feedbackToUser API feedback to give user
     * @param endpoint endpoint to give feedback for
     */
    public void setApiFeedbackToUser(String feedbackToUser, Endpoint endpoint) {
        requireNonNull(feedbackToUser);

        String textFeedback = String.format("Endpoint:\n%s\nResponse Body:\n%s", endpoint.getAddress(), feedbackToUser);

        if (!Platform.isFxApplicationThread()) {
            Platform.runLater(() -> apiFeedbackHelper(textFeedback, endpoint));
        } else {
            apiFeedbackHelper(textFeedback, endpoint);
        }
    }
}
