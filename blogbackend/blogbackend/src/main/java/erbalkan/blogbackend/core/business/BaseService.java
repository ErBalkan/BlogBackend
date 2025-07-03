package erbalkan.blogbackend.core.business;

import java.util.List;

import erbalkan.blogbackend.core.utilities.results.base.DataResult;
import erbalkan.blogbackend.core.utilities.results.base.Result;

public interface BaseService<
    TCreateRequest  extends BaseDto, 
    TUpdateRequest  extends BaseDto, 
    TDeleteRequest  extends BaseDto,
    TListResponse   extends BaseDto, 
    TDetailResponse extends BaseDto, 
    TID> {

    Result create(TCreateRequest createDto);
    Result update(TUpdateRequest updateDto);
    Result delete(TDeleteRequest deleteDto);
    DataResult<List<TListResponse>> getAll();
    DataResult<TDetailResponse> getById(TID id);
}
