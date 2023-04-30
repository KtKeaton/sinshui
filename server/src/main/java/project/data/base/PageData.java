package project.data.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "request data")
public class PageData {
    private int currentPage;
    private int totalPage;
    private long totalElement;
}
