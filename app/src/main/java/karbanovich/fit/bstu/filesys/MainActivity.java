package karbanovich.fit.bstu.filesys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Environment;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;
import java.io.File;

public class MainActivity extends AppCompatActivity {

    private TextView absolute;
    private TextView name;
    private TextView path;
    private TextView read_write;
    private TextView externalState;
    private String read;
    private String write;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        absolute = (TextView) findViewById(R.id.absolute);
        name = (TextView) findViewById(R.id.name);
        path = (TextView) findViewById(R.id.path);
        read_write = (TextView) findViewById(R.id.read_write);
        externalState = (TextView) findViewById(R.id.externalState);

        absolute.setText("Absolute: ");
        name.setText("Name: ");
        path.setText("Path: ");
        read_write.setText("Read/Write: ");
        externalState.setText("External state: ");
    }

    public void getFilesDir(View view) {
        File file = super.getFilesDir();
        setFileInfo(file);
    }

    public void getCacheDir(View view){
        File file = super.getCacheDir();
        setFileInfo(file);
    }

    public void getExternalFilesDir(View view){
        File file = super.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        setFileInfo(file);
    }

    public void getExternalCacheDir(View view){
        File file = super.getExternalCacheDir();
        setFileInfo(file);
    }

    public void getExternalStorageDirectory(View view){
        File file = Environment.getExternalStorageDirectory();
        setFileInfo(file);
    }

    public void getExternalStoragePublicDirectory(View view){
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        setFileInfo(file);
    }

    private void setFileInfo(File file){
        absolute.setText("Absolute: " + file.getAbsolutePath());
        name.setText("Name: " + file.getName());
        path.setText("Path: " + file.getPath());

        if(file.canRead() == true) read = "yes";
        else read = "no";
        if(file.canWrite() == true) write = "yes";
        else read = "no";

        read_write.setText("Read/Write: " + read + "/" + write);
        externalState.setText("External state: " + Environment.getExternalStorageState(file));
    }
}