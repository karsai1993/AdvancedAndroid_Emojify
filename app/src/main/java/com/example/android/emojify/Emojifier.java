package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {
    public static void detectFaces(Context context, Bitmap bitmap) {
        FaceDetector faceDetector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();
        SparseArray<Face> faces = faceDetector.detect(frame);
        Toast.makeText(context, faces.size() + " faces detected!", Toast.LENGTH_LONG).show();
        faceDetector.release();
    }
}
