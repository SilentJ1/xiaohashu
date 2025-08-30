package com.quanxiaoha.xiaohashu.note.biz.model.vo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateNoteVisibleOnlyMeReqVO {

    @NotNull(message = "笔记 ID 不能为空")
    private Long id;

}
