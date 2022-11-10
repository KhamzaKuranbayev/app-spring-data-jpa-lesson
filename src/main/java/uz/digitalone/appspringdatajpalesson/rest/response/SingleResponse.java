package uz.digitalone.appspringdatajpalesson.rest.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 11/2/2022
 * Time: 9:33 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SingleResponse {
    private boolean success;
    private String message;
    private Object data;
    private List<Object> dataList;
    private HttpStatus httpStatus;

    public SingleResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
        if (success)
            this.httpStatus = HttpStatus.OK;
    }

    public SingleResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        if (data instanceof List)
            this.dataList = (List) data;
        else
            this.data = data;

        if (success)
            this.httpStatus = HttpStatus.OK;
    }

    public SingleResponse(boolean success, String message, List<Object> dataList) {
        this.success = success;
        this.message = message;
        this.dataList = dataList;
        if (success)
            this.httpStatus = HttpStatus.OK;
    }

    public SingleResponse(boolean success, String message, HttpStatus httpStatus) {
        this.success = success;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
