package com.android.omiplekevin.appetiserplay.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@ToString
public class EntityModel {

    @SerializedName("wrapperType")
    @Getter
    public String wrapperType;

    @SerializedName("kind")
    @Getter
    public String kind;

    @SerializedName("collectionId")
    @Getter
    public Integer collectionId;

    @SerializedName("trackId")
    @Getter
    public Integer trackId;

    @SerializedName("artistName")
    @Getter
    public String artistName;

    @SerializedName("collectionName")
    @Getter
    public String collectionName;

    @SerializedName("trackName")
    @Getter
    public String trackName;

    @SerializedName("collectionCensoredName")
    @Getter
    public String collectionCensoredName;

    @SerializedName("trackCensoredName")
    @Getter
    public String trackCensoredName;

    @SerializedName("collectionArtistId")
    @Getter
    public Integer collectionArtistId;

    @SerializedName("collectionArtistViewUrl")
    @Getter
    public String collectionArtistViewUrl;

    @SerializedName("collectionViewUrl")
    @Getter
    public String collectionViewUrl;

    @SerializedName("trackViewUrl")
    @Getter
    public String trackViewUrl;

    @SerializedName("previewUrl")
    @Getter
    public String previewUrl;

    @SerializedName("artworkUrl30")
    @Getter
    public String artworkUrl30;

    @SerializedName("artworkUrl60")
    @Getter
    public String artworkUrl60;

    @SerializedName("artworkUrl100")
    @Getter
    public String artworkUrl100;

    @SerializedName("collectionPrice")
    @Getter
    public Float collectionPrice;

    @SerializedName("trackPrice")
    @Getter
    public Float trackPrice;

    @SerializedName("collectionHdPrice")
    @Getter
    public Float collectionHdPrice;

    @SerializedName("trackHdPrice")
    @Getter
    public Float trackHdPrice;

    @SerializedName("releaseDate")
    @Getter
    public String releaseDate;

    @SerializedName("collectionExplicitness")
    @Getter
    public String collectionExplicitness;

    @SerializedName("trackExplicitness")
    @Getter
    public String trackExplicitness;

    @SerializedName("discCount")
    @Getter
    public Integer discCount;

    @SerializedName("discNumber")
    @Getter
    public Integer discNumber;

    @SerializedName("trackCount")
    @Getter
    public Integer trackCount;

    @SerializedName("trackNumber")
    @Getter
    public Integer trackNumber;

    @SerializedName("trackTimeMillis")
    @Getter
    public Integer trackTimeMillis;

    @SerializedName("country")
    @Getter
    public String country;

    @SerializedName("currency")
    @Getter
    public String currency;

    @SerializedName("primaryGenreName")
    @Getter
    public String primaryGenreName;

    @SerializedName("contentAdvisoryRating")
    @Getter
    public String contentAdvisoryRating;

    @SerializedName("longDescription")
    @Getter
    public String longDescription;

    @SerializedName("hasITunesExtras")
    @Getter
    public Boolean hasITunesExtras;
}
