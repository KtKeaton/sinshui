package project.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;


public class PageUtil {

    public static Pageable getPageable(int pageNo, int pageSize, String sort) {
        String[] sortStr = sort.split(":");
        Sort.Direction direction = StringUtils.endsWithIgnoreCase(sortStr[1], "acs") ? Sort.Direction.ASC : Sort.Direction.DESC;
        return PageRequest.of(pageNo - 1, pageSize, Sort.by(direction, sortStr[0]));
    }

    public static Pageable getPageable(int pageNo, int pageSize) {
        return PageRequest.of(pageNo - 1, pageSize);
    }
}
