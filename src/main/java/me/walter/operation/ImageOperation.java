package me.walter.operation;

import me.walter.model.Attachment;
import me.walter.model.MessageData;
import me.walter.model.Payload;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenshuwang on 2016/7/25.
 */
public class ImageOperation {
    public ImageOperation() {}

    public Observable<Attachment> getAttachmentByImageUrls(List<String> urls) {
        List<Attachment> attachments = new ArrayList<>(urls.size());

        for (String url : urls) {
            Attachment attachment1 = createAttachment(url);
            attachments.add(attachment1);
        }

        return Observable.from(attachments);
    }

    public Attachment createAttachment(String url) {
        Attachment attachment = new Attachment();
        Payload payload = new Payload();
        payload.setUrl(url);

        attachment.setType("image");
        attachment.setPayload(payload);

        return attachment;
    }
}
