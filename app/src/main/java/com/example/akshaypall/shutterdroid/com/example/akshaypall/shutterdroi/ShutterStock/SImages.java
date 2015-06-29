package com.example.akshaypall.shutterdroid.com.example.akshaypall.shutterdroi.ShutterStock;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Akshay Pall on 19/05/2015.
 */
public class SImages {
    @SerializedName("id")
    private String mId;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("assets")
    private ImageAssets mAssets;

    public String getmId() {
        return mId;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getLargeThumbnailURL() {
        return mAssets.mLargeThumb.mUrl;
    }

    private class ImageAssets{
        @SerializedName("preview")
        private Thumbnail mPreview;

        @SerializedName("small_thumb")
        private Thumbnail mSmallThumb;

        @SerializedName("large_thumb")
        private Thumbnail mLargeThumb;
    }

    private class Thumbnail{
        @SerializedName("url")
        private String mUrl;
    }
}
