package sg.edu.ep.c346.id20029318.democontextmenutranslation2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtvTranslatedTxt1;
    TextView txtvTranslatedTxt2;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtvTranslatedTxt1 = findViewById(R.id.tvTranslatedTxt);
        txtvTranslatedTxt2 =findViewById(R.id.tvTranslatedTxt2);
        registerForContextMenu(txtvTranslatedTxt1);
        registerForContextMenu(txtvTranslatedTxt2);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_main, menu);
        if (v == txtvTranslatedTxt1){
            wordClicked = "hello";
        }
        else if (v == txtvTranslatedTxt2) {
            wordClicked = "bye";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // …
        if (wordClicked.equalsIgnoreCase("hello")){
            if (item.getItemId() == R.id.EnglishSelection){
                txtvTranslatedTxt1.setText("Hello");
                return true;
            }
            else if (item.getItemId() == R.id.italianSelection) {
                txtvTranslatedTxt1.setText("Ciao");
                return true;
            }
        }
        else if (wordClicked.equalsIgnoreCase("bye")){
            if (item.getItemId()==R.id.EnglishSelection){
                txtvTranslatedTxt2.setText("Bye");
            }
            else if (item.getItemId() == R.id.italianSelection) {
                txtvTranslatedTxt2.setText("Addio");
            }
        }

        return super.onContextItemSelected(item);
    }


}