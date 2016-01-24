package willzma.iris;

import android.content.Context;
import android.speech.tts.TextToSpeech;

import com.clarifai.api.ClarifaiClient;
import com.clarifai.api.RecognitionRequest;
import com.clarifai.api.RecognitionResult;
import com.clarifai.api.Tag;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;


/**
 * Created by Nick on 1/23/2016.
 */
public class Clarifai{

    private String tags = "";

    public void launchThread(File f, Context c) {
        class runner implements Runnable {
            File fi; Context ci;
            runner(File f, Context c) {fi=f;ci=c;}
        public void run() {
            ArrayList<String> arr = new ArrayList<String>();
            ClarifaiClient clarifai = new ClarifaiClient("3ZrPgHKeuAfg14XYk3wutj5QEF0biLPjBZyEhN7L", "pTk0mjLO93LmgUKoiCnKkYTiTpBgJJIvgCWrC4wp");

            List<RecognitionResult> results =
                    clarifai.recognize(new RecognitionRequest(fi));
            for (Tag tag : results.get(0).getTags()) {
                System.out.println(tag.getName() + ": " + tag.getProbability());
                tags += tag.getName() + ", ";
            }
            new TTS(ci).execute(tags);


            return;

        }
        }
        Thread t = new Thread(new runner(f, c));
        t.start();
    }
}
