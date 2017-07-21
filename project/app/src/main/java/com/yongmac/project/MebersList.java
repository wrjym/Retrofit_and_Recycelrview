package com.yongmac.project;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yongmac on 2017. 7. 21..
 */

public class MebersList {

    @SerializedName("appList")
    @Expose
    private List<MemberDTO> memberDTOs;

    public List<MemberDTO> getMemberDTOs() {
        return memberDTOs;
    }

    public void setMemberDTOs(List<MemberDTO> memberDTOs) {
        this.memberDTOs = memberDTOs;
    }
}
