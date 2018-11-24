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
 * 新闻表
 * </p>
 *
 * @author Xm Guo
 * @since 2018-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class News extends Model<News> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("userId")
    private Long userId;

    private String title;

    private String context;

    private String images;

    private Integer type;

    private Integer status;

    @TableField("createTime")
    private LocalDateTime createTime;

    @TableField("pullTime")
    private LocalDateTime pullTime;

    @TableField(exist = false)
    private User user;

    @TableField(exist = false)
    private Long commentNum;

    @TableField(exist = false)
    private Long zanNum;

    @TableField(exist = false)
    private String reply;



    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
