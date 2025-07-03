package erbalkan.blogbackend.core.utilities.mapping;

import java.util.List;
import erbalkan.blogbackend.core.business.BaseDto;

public interface BaseMapper<
    TEntity, 
    TCreateRequest extends BaseDto, 
    TUpdateRequest extends BaseDto, 
    TDeleteRequest extends BaseDto,
    TListResponse extends BaseDto, 
    TDetailResponse extends BaseDto
    > {

    TEntity createDtoToEntity(TCreateRequest createDto);
    TEntity updateDtoToEntity(TUpdateRequest updateDto); 
    TEntity deleteDtoToEntity(TDeleteRequest deleteDto);
    TDetailResponse toDetailDto(TEntity entity);
    TListResponse toListDto(TEntity entity);
    List<TListResponse> toListDto(List<TEntity> entities);
    List<TDetailResponse> toListDetailDto(List<TEntity> entities);
    TEntity detailDtoToEntity(TDetailResponse detailDto);
}
