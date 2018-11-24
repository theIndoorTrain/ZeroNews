package com.xm.zeronews.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 回复表
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Reply extends Model<Reply> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("userId")
    private Long userId;

    @TableField("newsId")
    private Long newsId;

    @TableField("commentId")
    private Long commentId;

    private String context;

    @TableField("createTime")
    private LocalDateTime createTime;

    @TableField("replyUserId")
    private Long replyUserId;

    @TableField(exist = false)
    private User user;

    @TableField(exist = false)
    private User replyUser;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
