package com.moli.core;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.util.FileCopyUtils;

/**
 * UTF-8转码.
 * @author Lo&Wang
 */
public class UTF8StringHttpMessageConverter extends AbstractHttpMessageConverter<String> {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private final List<Charset> availableCharsets;
    private boolean writeAcceptCharset = true;
    @SuppressWarnings({"unchecked", "rawtypes"})
    public UTF8StringHttpMessageConverter() {
        super(new MediaType[]{new MediaType("text", "plain", DEFAULT_CHARSET), MediaType.ALL});
        availableCharsets = new ArrayList(Charset.availableCharsets().values());
    }
    public void setWriteAcceptCharset(boolean writeAcceptCharset) {
        this.writeAcceptCharset = writeAcceptCharset;
    }
    public boolean supports(Class<?> clazz) {
        return String.class.equals(clazz);
    }
    @SuppressWarnings("rawtypes")
    protected String readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException {
        Charset charset = getContentTypeCharset(inputMessage.getHeaders().getContentType());
        return FileCopyUtils.copyToString(new InputStreamReader(inputMessage.getBody(), charset));
    }
    protected Long getContentLength(String s, MediaType contentType) {
        Charset charset = getContentTypeCharset(contentType);
        try {
            return Long.valueOf(s.getBytes(charset.name()).length);
        } catch (UnsupportedEncodingException ex) {
            throw new InternalError(ex.getMessage());
        }
    }
    protected void writeInternal(String s, HttpOutputMessage outputMessage) throws IOException {
        if (writeAcceptCharset) {
            outputMessage.getHeaders().setAcceptCharset(getAcceptedCharsets());
        }
        Charset charset = getContentTypeCharset(outputMessage.getHeaders().getContentType());
        FileCopyUtils.copy(s, new OutputStreamWriter(outputMessage.getBody(), charset));
    }
    protected List<Charset> getAcceptedCharsets() {
        return availableCharsets;
    }
    private Charset getContentTypeCharset(MediaType contentType) {
        if ((contentType != null) && (contentType.getCharSet() != null)) {
            return contentType.getCharSet();
        }
        return DEFAULT_CHARSET;
    }
}
