package com.xm.zeronews.dto;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xm.zeronews.pojo.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel="spring")
public interface DtoMapper {

    public Audit dtoToAudit(AuditDto auditDto);
    public AuditDto dtoToAudit(Audit audit);

    public Comment dtoToComment(CommentDto commentDto);
    public CommentDto commentToDto(Comment comment);
    public List<CommentDto> commentList(List<Comment> commentList);

    public Emp dtoToEmp(EmpDto empDto);
    public EmpDto empToDto(Emp emp);

    public User dtoToUser(UserDto userDto) ;
    @Mappings({
            @Mapping(source="password",target="password",ignore=true),
            @Mapping(source="code",target="code",ignore=true)
    })
    public UserDto userToDto(User user);
    public List<UserDto> userList(List<User> userList);

    public Love dtoToLove(LoveDto loveDto);
    public LoveDto loveToDto(Love love);

    public MsgDto msgToDto(Msg msg);
    public Msg dtoToMsg(MsgDto msgDto);
    public List<MsgDto> msgList(List<Msg> msgList);

    public News dtoToNews(NewsDto newsDto);
    public NewsDto newsToDto(News news);
    public List<NewsDto> newsList(List<News> newsList);

    public Reply dtoToReply(ReplyDto replyDto);
    public ReplyDto replyToDto(Reply reply);
    public List<ReplyDto> replyList(List<Reply> replyList);

}
