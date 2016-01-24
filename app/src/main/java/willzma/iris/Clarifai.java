package willzma.iris;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import com.clarifai.api.ClarifaiClient;
import com.clarifai.api.RecognitionRequest;
import com.clarifai.api.RecognitionResult;
import com.clarifai.api.Tag;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nick on 1/23/2016.
 */
public class Clarifai extends AsyncTask<File, Void, List<String>>{

    private Exception exception;


    protected List<String> doInBackground(File... params) {
        ArrayList<String> arr = new ArrayList<String>();
        ClarifaiClient clarifai = new ClarifaiClient("3ZrPgHKeuAfg14XYk3wutj5QEF0biLPjBZyEhN7L", "pTk0mjLO93LmgUKoiCnKkYTiTpBgJJIvgCWrC4wp");
        System.out.println("Here goes nothing... #################################");

        List<RecognitionResult> results =
                clarifai.recognize(new RecognitionRequest(params[0]));
        System.out.println("OK!... #################################");

        for (Tag tag : results.get(0).getTags()) {
            System.out.println(tag.getName() + ": " + tag.getProbability());
        }
        return null;
    }

}
