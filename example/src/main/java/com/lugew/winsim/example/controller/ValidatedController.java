package com.lugew.winsim.example.controller;

import com.lugew.winsim.controller.response.GeneralResponse;
import com.lugew.winsim.controller.response.Response;
import com.lugew.winsim.example.validation.annotation.Valid;
import com.lugew.winsim.example.validation.annotation.Validated;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LuGew
 * @since 2020/7/31
 */
@RestController
@RequestMapping("validated")
public class ValidatedController {
    @PostMapping("nameNotNull")
    public ResponseEntity<?> test(@RequestBody @Validated(
            {
                    @Valid(
                            fields = {
                                    "name"
                            }
                    )
            }
    )
                                          com.lugew.winsim.example.entity.Validated entity) {
        return ok();
    }


    @PostMapping("nameAndPasswordNotNull")
    public ResponseEntity<?> nameAndPasswordNotNull(@RequestBody @Validated({@Valid(fields = {"name", "password"})})
                                                            com.lugew.winsim.example.entity.Validated entity) {
        return ok();
    }

    @PostMapping("nameNotNullAndPasswordNull")
    public ResponseEntity<?> nameNotNullAndPasswordNull(@RequestBody @Validated({@Valid(fields = {"name"})})
                                                                com.lugew.winsim.example.entity.Validated entity) {
        return ok();
    }

    protected ResponseEntity<?> ok() {
        return ok(null);
    }

    protected <Data> ResponseEntity<?> ok(Data data) {
        Response<Data> response = GeneralResponse.build();
        response.setData(data);
        return ResponseEntity.ok(response);
    }
}
