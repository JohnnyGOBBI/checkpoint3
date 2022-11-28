package com.example.checkpoint3.mapper;

import com.example.checkpoint3.dao.Comment;
import com.example.checkpoint3.dto.CommentDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        TypeMap<Comment, CommentDto> commentMapper = modelMapper.createTypeMap(Comment.class, CommentDto.class);
        commentMapper.addMappings(
                mapper -> mapper.map(src -> src.getPost().getId(), CommentDto::setPostId)
        );

        return modelMapper;
    }
}
