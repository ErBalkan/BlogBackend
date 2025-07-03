package erbalkan.blogbackend.core.business;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import erbalkan.blogbackend.core.entities.BaseEntity;
import erbalkan.blogbackend.core.utilities.mapping.BaseMapper;
import erbalkan.blogbackend.core.utilities.messages.MessageService;
import erbalkan.blogbackend.core.utilities.messages.Messages;
import erbalkan.blogbackend.core.utilities.results.base.DataResult;
import erbalkan.blogbackend.core.utilities.results.base.Result;
import erbalkan.blogbackend.core.utilities.results.error.ErrorDataResult;
import erbalkan.blogbackend.core.utilities.results.success.SuccessDataResult;
import erbalkan.blogbackend.core.utilities.results.success.SuccessResult;
import erbalkan.blogbackend.core.utilities.validation.ValidationTool;
import erbalkan.blogbackend.core.utilities.validation.Validator;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class BaseManager 
<
TEntity extends BaseEntity,
TCreateRequest extends BaseDto,
TUpdateRequest extends BaseDto,
TDeleteRequest extends BaseDto,
TListResponse extends BaseDto,
TDetailResponse extends BaseDto,
TID
>
implements BaseService<TCreateRequest, TUpdateRequest, TDeleteRequest, TListResponse, TDetailResponse, TID>
{
    private final JpaRepository<TEntity, TID> _repository;
    private final BaseMapper<TEntity, TCreateRequest, TUpdateRequest, TDeleteRequest, TListResponse, TDetailResponse> _mapper;
    private final MessageService _messageService;
    private final Validator<TCreateRequest> _createValidator;
    private final Validator<TUpdateRequest> _updateValidator;
    private final Validator<TDeleteRequest> _deleteValidator;

    @Override
    @Transactional // bu annotation, bu metodun bir transaction içinde çalışacağını belirtir
    // Transactional annotation, veritabanı işlemlerinin atomik olmasını sağlar
    // yani ya tamamen başarılı olur ya da tamamen başarısız olur
    // bu, veritabanı tutarlılığını sağlar
    public Result create(TCreateRequest createRequest) {
        Result validationResult = ValidationTool.validate(createRequest, _createValidator);
        if(!validationResult.isSuccess())
            return validationResult; // Eğer doğrulama başarısızsa, hata mesajını döner
        // Eğer doğrulama başarılıysa, DTO'yu entity'ye dönüştürür
        TEntity entity = _mapper.createDtoToEntity(createRequest);
        // Entity'yi veritabanına kaydeder
        entity = _repository.save(entity);
        return new SuccessResult(_messageService.getMessage(Messages.CommonMessages.COMMON_CREATED_SUCCESS));
        // Başarılı bir şekilde kaydedildiğinde, başarı mesajını döner
    }

    @Override
    @Transactional
    public Result update(TUpdateRequest updateRequest) {
        Result validationResult = ValidationTool.validate(updateRequest, _updateValidator);
        if(!validationResult.isSuccess())
            return validationResult; // Eğer doğrulama başarısızsa, hata mesajını döner
        // Eğer doğrulama başarılıysa, DTO'yu entity'ye dönüştürür
        TEntity entity = _mapper.updateDtoToEntity(updateRequest);
        // Entity'yi veritabanında günceller
        entity = _repository.save(entity);
        // Başarılı bir şekilde güncellendiğinde, başarı mesajını döner
        return new SuccessResult(_messageService.getMessage(Messages.CommonMessages.COMMON_UPDATED_SUCCESS));
    }

    @Override
    @Transactional
    public Result delete(TDeleteRequest deleteRequest) {
        Result validationResult = ValidationTool.validate(deleteRequest, _deleteValidator);
        if(!validationResult.isSuccess())
            return validationResult; // Eğer doğrulama başarısızsa, hata mesajını döner
        // Eğer doğrulama başarılıysa, DTO'yu entity'ye dönüştürür
        TEntity entity = _mapper.deleteDtoToEntity(deleteRequest);
        // Entity'yi veritabanından siler
        _repository.delete(entity);
        // Başarılı bir şekilde silindiğinde, başarı mesajını döner
        return new SuccessResult(_messageService.getMessage(Messages.CommonMessages.COMMON_DELETED_SUCCESS));
    }

    @Override
    public DataResult<List<TListResponse>> getAll() {
        // Veritabanındaki tüm entity'leri alır
        var entities = _repository.findAll();
        // var dtos = _mapper.toListDto(entities); // Bu satır, entity'leri DTO'lara dönüştürür
        var dtos = _mapper.toListDto(entities);
        // Başarılı bir şekilde alındığında, DTO'ları döner
        return new SuccessDataResult<>(dtos, _messageService.getMessage(Messages.CommonMessages.COMMON_LISTED_SUCCESS));
    }

    @Override
    public DataResult<TDetailResponse> getById(TID id) {
        // Veritabanından ID'ye göre entity'yi alır
        var entity = _repository.findById(id); // findById metodu, Optional<TEntity> döner
        if(entity.isEmpty()) {
            // Eğer entity bulunamazsa, hata mesajını döner
            return new ErrorDataResult<>(null, _messageService.getMessage(Messages.CommonMessages.COMMON_NOT_FOUND));
        }
        // Entity'yi DTO'ya dönüştürür
        var dto = _mapper.toDetailDto(entity.get()); // entity.get() ile Optional'dan entity'yi alırız
        // Başarılı bir şekilde alındığında, DTO'yu döner
        return new SuccessDataResult<>(dto, _messageService.getMessage(Messages.CommonMessages.COMMON_DETAIL_SUCCESS));
    }


    protected abstract TID getId(TEntity entity); 
    // Bu metod, entity'den ID'yi alır
    // Bu metod, alt sınıflar tarafından implement edilecek
    // Örneğin, UserManager sınıfında User entity'sinin ID'sini alır
    // Bu metod, BaseManager sınıfının generic parametrelerinden biri olan TID tipini kullanır
    // Bu sayede, BaseManager sınıfı farklı entity'ler için kullanılabilir.
    // // Örneğin, UserManager sınıfı için TID tipi Long olurken, PostManager sınıfı için TID tipi Integer olabilir.

}
