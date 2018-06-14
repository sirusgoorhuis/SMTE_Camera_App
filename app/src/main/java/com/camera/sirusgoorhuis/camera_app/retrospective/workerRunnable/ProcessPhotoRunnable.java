package com.camera.sirusgoorhuis.camera_app.retrospective.workerRunnable;

import android.media.Image;
import android.os.Environment;
import android.util.Log;

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
        Date date = new Date();
        File file = new File(Environment.getExternalStorageDirectory() + "/pic01 " + date.toString() + ".jpg");
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(bytes);
        }
        finally {
            if (outputStream != null) outputStream.close();
        }
    }
}
