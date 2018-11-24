package com.xm.zeronews.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Comment extends Model<Comment> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("newsId")
    private Long newsId;

    @TableField("userId")
    private Long userId;

    private String context;

    @TableField("createTime")
    private LocalDateTime createTime;

    @TableField(exist = false)
    private User user;

    @TableField(exist = false)
    public List<Reply> replyList;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
