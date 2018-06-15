package com.camera.sirusgoorhuis.camera_app.retrospective.workerRunnable;

import android.media.Image;
import android.os.Environment;
import android.util.Log;

import com.camera.sirusgoorhuis.camera_app.retrospective.RetrospectiveActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Date;

public class ProcessPhotoRunnable implements Runnable {
    private Image image;

    public ProcessPhotoRunnable(Image image) {
        this.image = image;
    }

    @Override
    public void run() {
        try {
            ByteBuffer buffer = image.getPlanes()[0].getBuffer();
            byte[] bytes = new byte[buffer.capacity()];
            buffer.get(bytes);
            save(bytes);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        Log.e("ProcessPhotoRunnable", new Date().toString() + " finished ImageProcessingThread");
    }

    private void save(byte[] bytes) throws IOException {
        String filePath = Environment.getExternalStorageDirectory() +
                File.separator + "filmRoll" +
                File.separator + RetrospectiveActivity.filmRoll.getName();
        File file = new File(filePath);
        if (!file.exists()) file.mkdirs();
        File newImage = new File(filePath + "image " + image.getTimestamp() + ".jpg");
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(newImage);
            outputStream.write(bytes);
        }
        finally {
            if (outputStream != null) outputStream.close();
        }
    }
}
