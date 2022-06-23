package uz.lazizbek.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.lazizbek.warehouse.entity.Attachment;
import uz.lazizbek.warehouse.entity.AttachmentContent;
import uz.lazizbek.warehouse.payload.Result;
import uz.lazizbek.warehouse.repository.AttachmentContentRepository;
import uz.lazizbek.warehouse.repository.AttachmentRepository;

import java.io.IOException;
import java.util.Iterator;

@Service
public class AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    public Result uploadFile(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        if (file !=null){
            String originalFilename = file.getOriginalFilename();
            long size = file.getSize();
            String contentType = file.getContentType();
            Attachment attachment = new Attachment();
            attachment.setName(originalFilename);
            attachment.setSize(size);
            attachment.setContentType(contentType);
            Attachment saveAttachment = attachmentRepository.save(attachment);

            AttachmentContent attachmentContent = new AttachmentContent();
            attachmentContent.setBytes(file.getBytes());
            attachmentContent.setAttachment(saveAttachment);
            attachmentContentRepository.save(attachmentContent);
            return new Result("File saqlandi", true, saveAttachment.getId());
        }
        return new Result("File yuborilmadi", false);

    }
}
