package com.zavadka.lab5.lab5.dto.assembler;

import com.zavadka.lab5.lab5.controller.ResponseController;
import com.zavadka.lab5.lab5.domain.Response;
import com.zavadka.lab5.lab5.dto.ResponseDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
@Component
public class ResponseDtoAssembler  implements RepresentationModelAssembler<Response, ResponseDto> {
    @Override
    public ResponseDto toModel(Response entity) {
        ResponseDto responseDto = ResponseDto.builder()
                .id(entity.getId())
                .photo_href(entity.getPhotoHref())
                .text_response(entity.getTextResponse())
                .rating(entity.getRating())
                .build();
        Link selfLink = linkTo(methodOn(ResponseController.class).getResponse(responseDto.getId())).withSelfRel();
        responseDto.add(selfLink);
        return responseDto;
    }

    @Override
    public CollectionModel<ResponseDto> toCollectionModel(Iterable<? extends Response> entities) {
        CollectionModel<ResponseDto> responseDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ResponseController.class).getAllResponses()).withSelfRel();
        responseDtos.add(selfLink);
        return responseDtos;
    }

    public CollectionModel<ResponseDto> toCollectionModel(Iterable<? extends Response> entities, Link link) {
        CollectionModel<ResponseDto> responseDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        responseDtos.add(link);
        return responseDtos;
    }
}
