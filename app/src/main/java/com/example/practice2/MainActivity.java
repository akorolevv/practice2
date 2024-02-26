package com.example.practice2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Build;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity
{

    private static final String TEXT_VIEW_KEY = "text_view_text";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) // создание явления
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Lifecycle", "onCreate");
        // Получаем строковый ресурс с именем "hello_world"
        String welcome_message = getResources().getString(R.string.hello_world);
        // Создаем новый объект TextView
        TextView textView = new TextView(this);
        // Устанавливаем текст для TextView, используя полученную строку ресурсов
        textView.setText(welcome_message);

        // Находим в макете LinearLayout по идентификатору "mainLayout"
        LinearLayout mainLayout = findViewById(R.id.mainLayout);
        // Добавляем созданный TextView к найденному LinearLayout
        mainLayout.addView(textView);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
        {
            androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
            if (actionBar != null)
            {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }


    }

    @Override
    // Запуск
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", "onStart");
    }

    @Override
    // Возобновление
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", "onResume");
    }

    @Override
    // Приостановка
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle", "onPause");
    }

    @Override
    // Остановка
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", "onStop");
    }

    @Override
    // Перезапуск
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", "onDestroy");
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Lifecycle", "saveInc");
        // Сохраняем состояние, например, текст в TextView
        if (textView != null) {
            outState.putString(TEXT_VIEW_KEY, textView.getText().toString());
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("Lifecycle", "restoreInc");
        // Восстанавливаем состояние, например, текст в TextView
        String savedText = savedInstanceState.getString(TEXT_VIEW_KEY);
        if (textView != null) {
            textView.setText(savedText);
        }
    }

}