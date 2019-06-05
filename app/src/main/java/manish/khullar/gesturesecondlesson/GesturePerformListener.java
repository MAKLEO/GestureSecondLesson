package manish.khullar.gesturesecondlesson;

import android.gesture.Gesture;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.support.design.widget.Snackbar;

import java.util.ArrayList;

public class GesturePerformListener implements GestureOverlayView.OnGesturePerformedListener {

        private GestureLibrary gestureLibrary = null;

        public GesturePerformListener(GestureLibrary gestureLibrary) {
            this.gestureLibrary = gestureLibrary;
        }

        /* When GestureOverlayView widget capture a user gesture it will run the code in this method.
           The first parameter is the GestureOverlayView object, the second parameter store user gesture information.*/
        @Override
        public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
            // Recognize the gesture and return prediction list.
            ArrayList<Prediction> predictionList = gestureLibrary.recognize(gesture);
            int size = predictionList.size();
            if(size > 0)
            {
                StringBuffer messageBuffer = new StringBuffer();
                // Get the first prediction.
                Prediction firstPrediction = predictionList.get(0);
                /* Higher score higher gesture match. *///implement the logic to store
                if(firstPrediction.score > 5)
                {
                    String action = firstPrediction.name;
                    messageBuffer.append("Your gesture match " + action);
                }else
                {
                    messageBuffer.append("Your gesture do not match any predefined gestures.");
                }

                // Display a snackbar with related messages.
                Snackbar snackbar = Snackbar.make(gestureOverlayView, messageBuffer.toString(), Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        }
    }

