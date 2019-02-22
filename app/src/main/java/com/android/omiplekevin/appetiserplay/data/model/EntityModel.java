package com.android.omiplekevin.appetiserplay.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.ToString;

@ToString
public class EntityModel {

    /**
     * MERGE: movie
     */
    @SerializedName("wrapperType")
    public String wrapperType;

    @SerializedName("kind")
    public String kind;

    @SerializedName("trackId")
    public Integer trackId;

    @SerializedName("artistName")
    public String artistName;

    @SerializedName("trackName")
    public String trackName;

    @SerializedName("trackCensoredName")
    public String trackCensoredName;

    @SerializedName("trackViewUrl")
    public String trackViewUrl;

    @SerializedName("previewUrl")
    public String previewUrl;

    @SerializedName("artworkUrl30")
    public String artworkUrl30;

    @SerializedName("artworkUrl60")
    public String artworkUrl60;

    @SerializedName("artworkUrl100")
    public String artworkUrl100;

    @SerializedName("collectionPrice")
    public Float collectionPrice;

    @SerializedName("trackPrice")
    public Float trackPrice;

    @SerializedName("trackRentalPrice")
    public Float trackRentalPrice;

    @SerializedName("collectionHdPrice")
    public Float collectionHdPrice;

    @SerializedName("trackHdPrice")
    public Float trackHdPrice;

    @SerializedName("trackHdRentalPrice")
    public Float trackHdRentalPrice;

    @SerializedName("releaseDate")
    public String releaseDate;

    @SerializedName("collectionExplicitness")
    public String collectionExplicitness;

    @SerializedName("trackExplicitness")
    public String trackExplicitness;

    @SerializedName("trackTimeMillis")
    public Integer trackTimeMillis;

    @SerializedName("country")
    public String country;

    @SerializedName("currency")
    public String currency;

    @SerializedName("primaryGenreName")
    public String primaryGenreName;

    @SerializedName("contentAdvisoryRating")
    public String contentAdvisoryRating;

    @SerializedName("shortDescription")
    public String shortDescription;

    @SerializedName("longDescription")
    public String longDescription;

    @SerializedName("hasITunesExtras")
    public Boolean hasITunesExtras;

    /**
     * MERGE: music
     */
    @SerializedName("artistId")
    public Integer artistId;

    @SerializedName("collectionId")
    public Integer collectionId;

    @SerializedName("collectionName")
    public String collectionName;

    @SerializedName("collectionCensoredName")
    public String collectionCensoredName;

    @SerializedName("collectionArtistId")
    public Integer collectionArtistId;

    @SerializedName("collectionArtistName")
    public String collectionArtistName;

    @SerializedName("artistViewUrl")
    public String artistViewUrl;

    @SerializedName("collectionViewUrl")
    public String collectionViewUrl;

    @SerializedName("discCount")
    public Integer discCount;

    @SerializedName("discNumber")
    public Integer discNumber;

    @SerializedName("trackCount")
    public Integer trackCount;

    @SerializedName("trackNumber")
    public Integer trackNumber;

    @SerializedName("isStreamable")
    public Boolean isStreamable;

    /**
     * MERGE: podcast
     */
    @SerializedName("feedUrl")
    public String feedUrl;

    @SerializedName("artworkUrl600")
    public String artworkUrl600;

    @SerializedName("genreIds")
    public List<String> genreIds = null;

    @SerializedName("genres")
    public List<String> genres = null;

    /**
     * MERGE: audiobook
     */
    @SerializedName("copyright")
    public String copyright;

    @SerializedName("description")
    public String description;

    /**
     * MERGE: software
     */
    @SerializedName("screenshotUrls")
    public List<String> screenshotUrls = null;

    @SerializedName("ipadScreenshotUrls")
    public List<String> ipadScreenshotUrls = null;

    @SerializedName("appletvScreenshotUrls")
    public List<String> appletvScreenshotUrls = null;

    @SerializedName("artworkUrl512")
    public String artworkUrl512;

    @SerializedName("isGameCenterEnabled")
    public Boolean isGameCenterEnabled;

    @SerializedName("supportedDevices")
    public List<String> supportedDevices = null;

    @SerializedName("features")
    public List<String> features = null;

    @SerializedName("advisories")
    public List<String> advisories = null;

    @SerializedName("averageUserRatingForCurrentVersion")
    public Float averageUserRatingForCurrentVersion;

    @SerializedName("languageCodesISO2A")
    public List<String> languageCodesISO2A = null;

    @SerializedName("fileSizeBytes")
    public String fileSizeBytes;

    @SerializedName("sellerUrl")
    public String sellerUrl;

    @SerializedName("userRatingCountForCurrentVersion")
    public Integer userRatingCountForCurrentVersion;

    @SerializedName("trackContentRating")
    public String trackContentRating;

    @SerializedName("minimumOsVersion")
    public String minimumOsVersion;

    @SerializedName("releaseNotes")
    public String releaseNotes;

    @SerializedName("sellerName")
    public String sellerName;

    @SerializedName("version")
    public String version;

    @SerializedName("price")
    public Float price;

    @SerializedName("bundleId")
    public String bundleId;

    @SerializedName("currentVersionReleaseDate")
    public String currentVersionReleaseDate;

    @SerializedName("formattedPrice")
    public String formattedPrice;

    @SerializedName("primaryGenreId")
    public Integer primaryGenreId;

    @SerializedName("isVppDeviceBasedLicensingEnabled")
    public Boolean isVppDeviceBasedLicensingEnabled;

    @SerializedName("averageUserRating")
    public Float averageUserRating;

    @SerializedName("userRatingCount")
    public Integer userRatingCount;

    /**
     * MERGE: ebook
     */
    @SerializedName("artistIds")
    public List<Integer> artistIds = null;

}
