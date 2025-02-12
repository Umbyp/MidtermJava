package sit.int204.classicmodelsservice.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)// แปลงเป็น json  แต่อันไหนไม่มีก็ไม่แปลง
public class ErrorResponse {
    private final int status;
    private final String message;
    private final String instance;
    private String stackTrace;
    private List<ValidationError> errors;

    @Getter
    @Setter
    @RequiredArgsConstructor //มี constructor required finalจะเป็นตัวทำ constructor ต้องส่ง
    private static class ValidationError {
        private final String field;
        private final String message;
    }

    public void addValidationError(String field, String message) {
        if (Objects.isNull(errors)) {
            errors = new ArrayList<>();
        }
        errors.add(new ValidationError(field, message));
    }
}