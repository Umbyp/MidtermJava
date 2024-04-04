package sit.int204.classicmodelsservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class NewSimpleEmployeeDto {
    @NotEmpty
    private Integer employeeNumber;
    @JsonIgnore//เราไม่ได้แปลงเป็น json
    private String firstName;
    @JsonIgnore
    private String lastName;
    //object สองfiled
    public String getName() {
        return firstName + ' '+ lastName;
    }
}
