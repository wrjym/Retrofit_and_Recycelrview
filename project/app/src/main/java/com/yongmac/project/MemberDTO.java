package com.yongmac.project;

/**
 * Created by yongmac on 2017. 7. 20..
 */

public class MemberDTO {
    public String rank;
    public String Nm;
    public String url;

    @Override
    public String toString() {
        return "MemberDTO{" +
                "rank='" + rank + '\'' +
                ", Nm='" + Nm + '\'' +
                ", image='" + url + '\'' +
                '}';
    }


    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getNm() {
        return Nm;
    }

    public void setNm(String nm) {
        Nm = nm;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MemberDTO(String rank, String nm ){

        this.rank = rank;
        this.Nm = nm;
    }
}
