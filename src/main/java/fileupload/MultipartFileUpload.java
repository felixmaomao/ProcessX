package fileupload;/**
 * Created by shenwei on 2017/9/15.
 */


import exception.FileFormatException;
import exception.FileNumException;
import exception.FileSizeException;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shenwei
 * @create 2017-09-15
 */
@Service("multipartFileUpload")
public class MultipartFileUpload {

    @Autowired
    private FastDFSManager fastDFSManager;

    /**
     * @Author shenwei
     * @Date 2017/9/15 10:41
     * @Description 多文件上传
     */
    public List<String> uploadFiles(List<MultipartFile> files, Integer numLimit, String[] endsLimits, Integer perSizeLimit) throws Exception {
        if (CollectionUtils.isEmpty(files)) {
            return new ArrayList<>();
        }
        if (files.size() > numLimit) {
            throw new FileNumException();
        }
        List<String> fileUrls = new ArrayList<>();
        for (MultipartFile file : files) {
            if (endsLimits.length > 0) {
                String fileOriginName = file.getOriginalFilename().toLowerCase();
                Long matchCount = Arrays.stream(endsLimits).filter(x -> fileOriginName.endsWith(x)).count();
                if (matchCount == 0) {
                    throw new FileFormatException();
                }
                if (file.getSize() > perSizeLimit) {
                    throw new FileSizeException();
                }
                String fileUrl = fastDFSManager.upload(file);
                fileUrls.add(fileUrl);
            }
        }
        return fileUrls;
    }
}
