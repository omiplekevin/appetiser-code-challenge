package com.android.omiplekevin.appetiserplay.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

@ToString
public class SearchResponseModel {

    @Getter
    @SerializedName("resultCount")
    int resultCount;

    @Getter
    @SerializedName("results")
    List<EntityModel> trackSearchResult;

}
