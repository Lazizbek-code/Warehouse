package uz.lazizbek.warehouse.entity;

import javax.persistence.*;

@Entity
public class AttachmentContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private byte[]  bytes;

    @OneToOne
    private Attachment attachment;

    public AttachmentContent() {
    }

    public AttachmentContent(Integer id, byte[] bytes, Attachment attachment) {
        this.id = id;
        this.bytes = bytes;
        this.attachment = attachment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }
}
