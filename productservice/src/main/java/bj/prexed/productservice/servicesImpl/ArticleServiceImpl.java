package bj.prexed.productservice.servicesImpl;


import bj.prexed.productservice.entities.Article;
import bj.prexed.productservice.exception.ResourceNotFoundException;
import bj.prexed.productservice.mappers.ArticleMapper;
import bj.prexed.productservice.records.input.ArticleRequestDTO;
import bj.prexed.productservice.records.output.ArticleResponseDTO;
import bj.prexed.productservice.repositories.ArticleRepository;
import bj.prexed.productservice.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
@Slf4j
public class ArticleServiceImpl implements ProductService {
    private final ArticleRepository repository;
    private final ArticleMapper mapper;

    public ArticleServiceImpl(ArticleRepository repository, ArticleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public ArticleResponseDTO add(ArticleRequestDTO resquest) {
        return mapper.toDtoR(repository.save(mapper.toEntity (resquest)));
    }

    @Override
    public Page<Article> all(String division, Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Page<Article> selectionParDivison(String lbl, Pageable page) {
        return repository.selectionArticleParDivision(lbl, page);
    }

    @Override
    public ArticleResponseDTO one(String id) {
        Article c = repository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by ID %s", id)));
        return mapper.toDtoR ( c );
    }

    @Override
    public ArticleResponseDTO set(String id, Article article) {
        Article  c = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Article", id));
        return mapper.toDtoR(repository.save(mapper.toUpdate(article,c)));
    }
}
