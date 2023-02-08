package site.project.junit.web.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CMResponseDto<T> {
    private Integer code;
    private String msg;
    private T body;

    @Builder
    public CMResponseDto(Integer code, String msg, T body) {
        this.code = code;
        this.msg = msg;
        this.body = body;
    }
}
