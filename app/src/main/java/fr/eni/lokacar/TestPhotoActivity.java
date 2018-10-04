package fr.eni.lokacar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestPhotoActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_PHOTO = 1;

    String localImageFilePath;
    ImageView mIvApercu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_photo);

        mIvApercu = findViewById(R.id.ivApercu);
        ImageView mIvRecuperee =findViewById(R.id.mIvRecuperee);;
        File imgFile = new  File("/storage/emulated/0/Android/data/fr.eni.lokacar/files/Pictures/IMG_20181004_095350_1742131846.jpg");

        if(imgFile.exists()){
             Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
             mIvRecuperee.setImageBitmap(myBitmap);

        }else
        {
            Toast.makeText(this, "Photo non trouvée", Toast.LENGTH_SHORT).show();
            Log.i("LOKAKAR" , "Petit chien Introuvable");
        }

    }

    public void takePicture(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photo = null;
            try {
                photo = createImageFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Uri uriToUpload = FileProvider.getUriForFile(TestPhotoActivity.this,
                    "fr.eni.lokacar.fileprovider",
                    photo);
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriToUpload);
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private File createImageFile() throws IOException {
        String timeStamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss",
                        Locale.getDefault()).format(new Date());
        String imageFileName = "IMG_" + timeStamp + "_";
        File storageDir =
                getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = null;
        try {
            image = File.createTempFile(
                    imageFileName,  /* prefix */
                    ".jpg",         /* suffix */
                    storageDir      /* directory */
            );
            localImageFilePath = image.getAbsolutePath();
            Log.i("LOKAKAR IMG PATH: " , localImageFilePath);
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode)
        {
            case REQUEST_IMAGE_CAPTURE:
                Bitmap imageBitmap = BitmapFactory.decodeFile(this.localImageFilePath);
                ImageView iv = findViewById(R.id.ivApercu);
                iv.setImageBitmap(imageBitmap);
                break;
            default:
                super.onActivityResult(requestCode,resultCode,data);
        }

    }
}
