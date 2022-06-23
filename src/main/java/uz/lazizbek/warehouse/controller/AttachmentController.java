package uz.lazizbek.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.service.AttachmentService;

import java.io.IOException;

@RestController
@RequestMapping(value = "/attachment")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @PostMapping("/upload")
    public Result upload(MultipartHttpServletRequest request) throws IOException {
        return attachmentService.uploadFile(request);
    }
}
