package com.weilei.imageloaderlibrary;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.FileDescriptor;

/**
 * Created by weilei on 2017/7/5.
 */

public class ImageResizer {
    private static final String TAG = "ImageResizer";

    public ImageResizer() {
    }

    public Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        calculateInSampleSize(options, reqWidth, reqWidth);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public Bitmap decodeSampledBitmapFromFileDescriptor(FileDescriptor fileDescriptor, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        calculateInSampleSize(options, reqWidth, reqWidth);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        if(reqHeight == 0 || reqHeight == 0) {
            return 1;
        }

        int sampleSize = 1;
        int outWidth = options.outWidth;
        int outHeight = options.outHeight;
        Log.d(TAG, "outWidth = " + outWidth);
        Log.d(TAG, "outHeight = " + outHeight);

        if (reqHeight < outHeight || reqWidth < outWidth) {
            int halfWidth = outWidth/2;
            int halfHeight = outHeight/2;
            while (halfHeight/sampleSize < reqHeight && halfWidth < reqHeight) {
                sampleSize *= 2;
            }
        }
        Log.d(TAG, "sampleSize = " + sampleSize);
        return sampleSize;
    }
}
