package willzma.iris;

import android.content.Context;
import android.os.AsyncTask;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import java.io.File;
import java.util.List;
import java.util.Locale;

import java.util.Random;

/**
 * Created by ChaityaShah on 1/24/16.
 */
public class TTS extends AsyncTask<String, Void, Boolean> implements TextToSpeech.OnInitListener {
    private Context context;

    public TTS(Context context, boolean prefix) {
        this.context = context;
        runIt = prefix;
    }

    private Exception exception;
    private TextToSpeech speaker;
    private String txt = "";
    private String[] phrases = {"Here's what I'm seeing, ", "Picture thisssss, ",
        "If I could pick a few words to describe your surroundings, I'd saay, ", "Here's what's in front of yoou, "};
    private boolean runIt;

    protected Boolean doInBackground(String... params) {

        speaker = new TextToSpeech(context, this);

        Random r = new Random();
        //r.nextInt(phrases.length);
        if(runIt)
        txt += phrases[r.nextInt(phrases.length)];

        txt += params[0];
        return true;
    }

    private void speak(String textToSpeak) {

        speaker.speak(textToSpeak, TextToSpeech.QUEUE_FLUSH, null);

    }

    @Override
    public void onInit(int status) {

        // status can be either TextToSpeech.SUCCESS or TextToSpeech.ERROR
        if (status == TextToSpeech.SUCCESS) {
            // Set preferred language to US english.
            // Note that a language may not be available, and the result will indicate this.
            int result = speaker.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA ||
                    result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Lanuage data is missing or the language is not supported.
                Log.e("404", "Language is not available.");
            }
        }
        System.out.println(txt);
        speak(txt);
        System.out.println(txt);
        cancel(true);
    }
}
