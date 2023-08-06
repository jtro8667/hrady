package com.example.hrady.data;

import java.util.List;

public class CastleDetail {

    public String folder;
    public List<PictureInfo> pictures;

    public CastleDetail(String folder, List<PictureInfo> pictures) {
        this.folder = folder;
        this.pictures = pictures;
    }

}
