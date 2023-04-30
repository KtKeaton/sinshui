package project.data.base;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@Builder
public class PageResponseData<T> {
    private PageData pageData;
    private List<T> list;

    public static <T> PageResponseData<T> response(Page<T> dataPages) {
        return PageResponseData.<T>builder()
                .pageData(PageData.builder()
                        .currentPage(dataPages.getNumber() + 1)
                        .totalElement(dataPages.getTotalElements())
                        .totalPage(dataPages.getTotalPages())
                        .build())
                .list(dataPages.getContent())
                .build();
    }
}
