package info.krushik.android.speechsynthesizer;

import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends Activity {
    private static final String enginePackageName = "com.svox.pico";
    private static final String SAMPLE_TEXT = "Synthesizes speech from text for immediate playback or to create a sound file.";
//    private static final String SAMPLE_TEXT = "Привет";
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    tts.setEngineByPackageName(enginePackageName);
                    tts.setLanguage(Locale.UK);

                    speak();
                }
            }
        });
    }

    private void speak() {
        tts.speak(SAMPLE_TEXT, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tts.shutdown();
    }
}

//public class MainActivity extends Activity implements
//        TextToSpeech.OnInitListener {
//
//    private Button mButton;
//    private TextToSpeech mTTS;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        mTTS = new TextToSpeech(this, this);
//
//        mButton = (Button) findViewById(R.id.button1);
//
//        mButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                String text = "Проверка наличия голосовых данных. Игорь дибил";
//                mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
//            }
//        });
//    }
//
//    @Override
//    public void onInit(int status) {
//        // TODO Auto-generated method stub
//        if (status == TextToSpeech.SUCCESS) {
//
//            Locale locale = new Locale("ru");
//
//            int result = mTTS.setLanguage(locale);
//            //int result = mTTS.setLanguage(Locale.getDefault());
//
//            if (result == TextToSpeech.LANG_MISSING_DATA
//                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
//                Log.e("TTS", "Извините, этот язык не поддерживается");
//            } else {
//                mButton.setEnabled(true);
//            }
//
//        } else {
//            Log.e("TTS", "Ошибка!");
//        }
//
//    }
//
//
//    @Override
//    public void onDestroy() {
//        // Don't forget to shutdown mTTS!
//        if (mTTS != null) {
//            mTTS.stop();
//            mTTS.shutdown();
//        }
//        super.onDestroy();
//    }
//}
