//package fileupload;
//
//
//import org.apache.log4j.Logger;
//import org.csource.common.NameValuePair;
//import org.csource.fastdfs.*;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.FileInputStream;
//
///**
// * @author chenlongfei
// * @date 2016/10/11.
// * @descrption fastdf调用
// */
//public class FastDFSManager {
//    private static Logger logger  = Logger.getLogger(FastDFSManager.class);
//    private String configPath="conf/fdfs.conf";
//    public String getConfigPath() {
//        return configPath;
//    }
//    public void setConfigPath(String configPath) {
//        this.configPath = configPath;
//    }
//    private  TrackerClient  trackerClient;
//    private  TrackerServer  trackerServer;
//    private TrackerGroup trackerGroup;
//    private  StorageServer  storageServer;
//    private  StorageClient1  storageClient;
//
//    private void init(){
//        try {
//            //初始化连接
//            ClassPathResource cpr = new ClassPathResource(configPath);
//            ClientGlobal.init(cpr.getClassLoader().getResource(configPath).getPath());
//            trackerClient = new TrackerClient();
//            trackerServer = trackerClient.getConnection();
//            storageClient = new StorageClient1(trackerServer, storageServer);
//        } catch (Exception e) {
//            logger.error("初始化错误！",  e);
//
//        }
//    }
//    public String upload(MultipartFile file) throws Exception{
//        String fileId="";
//        String tempFileName = file.getOriginalFilename();
//        byte[] fileBuff = file.getBytes();
//        String fileExtName = tempFileName.substring(tempFileName.lastIndexOf(".")+1);
//        //设置元信息
//        NameValuePair[] metaList = new NameValuePair[3];
//        metaList[0] = new NameValuePair("fileName", tempFileName);
//        metaList[1] = new NameValuePair("fileExtName", fileExtName);
//        metaList[2] = new NameValuePair("fileLength", String.valueOf(file.getSize()));
//        //上传文件
//        init();
//        fileId = storageClient.upload_file1(fileBuff, fileExtName, metaList);
//        return fileId;
//    }
//    public String upload(MultipartFile file,int x,int y) throws Exception{
//        String fileId="";
//        String tempFileName = file.getOriginalFilename();
//        byte[] fileBuff = file.getBytes();
//        String fileExtName = tempFileName.substring(tempFileName.lastIndexOf(".")+1);
//        //设置元信息
//        NameValuePair[] metaList = new NameValuePair[3];
//        metaList[0] = new NameValuePair("fileName", tempFileName);
//        metaList[1] = new NameValuePair("fileExtName", fileExtName);
//        metaList[2] = new NameValuePair("fileLength", String.valueOf(file.getSize()));
//        //上传文件
//        init();
//        //压缩图片
//        byte[] afterByte= ImageUtil.compressImage(fileBuff,fileExtName,x,y);
//        fileId = storageClient.upload_file1(afterByte, fileExtName, metaList);
//        return fileId;
//    }
//
//    /**
//     * 裁剪图片
//     * @param file
//     * @param x
//     * @param y
//     * @param w
//     * @param h
//     * @return
//     * @throws Exception
//     */
//    public String upload(MultipartFile file,int x,int y,int w,int h) throws Exception{
//        String fileId="";
//        String tempFileName = file.getOriginalFilename();
//        byte[] fileBuff = file.getBytes();
//        String fileExtName = tempFileName.substring(tempFileName.lastIndexOf(".")+1);
//        //设置元信息
//        NameValuePair[] metaList = new NameValuePair[3];
//        metaList[0] = new NameValuePair("fileName", tempFileName);
//        metaList[1] = new NameValuePair("fileExtName", fileExtName);
//        metaList[2] = new NameValuePair("fileLength", String.valueOf(file.getSize()));
//        //上传文件
//        init();
//        //压缩图片
//        byte[] afterByte= ImageUtil.cutImage(fileBuff,fileExtName,x,y,w,h);
//        fileId = storageClient.upload_file1(afterByte, fileExtName, metaList);
//        return fileId;
//    }
//    public String upload(byte[] file_buff,String tempFileName,int x,int y,int w,int h) throws Exception{
//        String fileId="";
//        String fileExtName = tempFileName.substring(tempFileName.lastIndexOf(".")+1);
//        //设置元信息
//        NameValuePair[] metaList = new NameValuePair[3];
//        metaList[0] = new NameValuePair("fileName", tempFileName);
//        metaList[1] = new NameValuePair("fileExtName", fileExtName);
//        metaList[2] = new NameValuePair("fileLength", String.valueOf(file_buff.length));
//        //上传文件
//        init();
//        //裁剪图片
//        byte[] afterByte= ImageUtil.cutImage(file_buff,fileExtName,x,y,w,h);
//        fileId = storageClient.upload_file1(afterByte, fileExtName, metaList);
//        return fileId;
//    }
//    public String upload(String filePath) throws Exception{
//        String fileId="";
//        File file = new File(filePath);
//        String tempFileName = file.getName();
//        FileInputStream fis = new FileInputStream(file);
//        byte[] file_buff = null;
//        if (fis != null) {
//            int len = fis.available();
//            file_buff = new byte[len];
//            fis.read(file_buff);
//        }
//        String fileExtName = tempFileName.substring(tempFileName.lastIndexOf(".")+1);
//        //设置元信息
//        NameValuePair[] metaList = new NameValuePair[3];
//        metaList[0] = new NameValuePair("fileName", tempFileName);
//        metaList[1] = new NameValuePair("fileExtName", fileExtName);
//        metaList[2] = new NameValuePair("fileLength", String.valueOf(file_buff.length));
//        //上传文件
//        init();
//        fileId = storageClient.upload_file1(file_buff, fileExtName, metaList);
//        fis.close();
//        return fileId;
//    }
//    public String upload(String filePath,int x,int y) throws Exception{
//        String fileId="";
//        File file = new File(filePath);
//        String tempFileName = file.getName();
//        FileInputStream fis = new FileInputStream(file);
//        byte[] file_buff = null;
//        if (fis != null) {
//            int len = fis.available();
//            file_buff = new byte[len];
//            fis.read(file_buff);
//        }
//        String fileExtName = tempFileName.substring(tempFileName.lastIndexOf(".")+1);
//        //设置元信息
//        NameValuePair[] metaList = new NameValuePair[3];
//        metaList[0] = new NameValuePair("fileName", tempFileName);
//        metaList[1] = new NameValuePair("fileExtName", fileExtName);
//        metaList[2] = new NameValuePair("fileLength", String.valueOf(file_buff.length));
//        //上传文件
//        init();
//        //压缩图片
//        byte[] afterByte= ImageUtil.compressImage(file_buff,fileExtName,x,y);
//        fileId = storageClient.upload_file1(afterByte, fileExtName, metaList);
//        fis.close();
//        return fileId;
//    }
//    public String upload(byte[] file_buff,String tempFileName) throws Exception{
//        String fileId="";
//        String fileExtName = tempFileName.substring(tempFileName.lastIndexOf(".")+1);
//        //设置元信息
//        NameValuePair[] metaList = new NameValuePair[3];
//        metaList[0] = new NameValuePair("fileName", tempFileName);
//        metaList[1] = new NameValuePair("fileExtName", fileExtName);
//        metaList[2] = new NameValuePair("fileLength", String.valueOf(file_buff.length));
//        //上传文件
//        init();
//        fileId = storageClient.upload_file1(file_buff, fileExtName, metaList);
//        return fileId;
//    }
//    public String upload(byte[] file_buff,String tempFileName,int x,int y) throws Exception{
//        String fileId="";
//        String fileExtName = tempFileName.substring(tempFileName.lastIndexOf(".")+1);
//        //设置元信息
//        NameValuePair[] metaList = new NameValuePair[3];
//        metaList[0] = new NameValuePair("fileName", tempFileName);
//        metaList[1] = new NameValuePair("fileExtName", fileExtName);
//        metaList[2] = new NameValuePair("fileLength", String.valueOf(file_buff.length));
//        //上传文件
//        init();
//        //压缩图片
//        byte[] afterByte= ImageUtil.compressImage(file_buff,fileExtName,x,y);
//        fileId = storageClient.upload_file1(afterByte, fileExtName, metaList);
//        return fileId;
//    }
//    public String upload(File file) throws Exception{
//        String fileId="";
//        String tempFileName = file.getName();
//        FileInputStream fis = new FileInputStream(file);
//        byte[] file_buff = null;
//        if (fis != null) {
//            int len = fis.available();
//            file_buff = new byte[len];
//            fis.read(file_buff);
//        }
//        String fileExtName = tempFileName.substring(tempFileName.lastIndexOf(".")+1);
//        //设置元信息
//        NameValuePair[] metaList = new NameValuePair[3];
//        metaList[0] = new NameValuePair("fileName", tempFileName);
//        metaList[1] = new NameValuePair("fileExtName", fileExtName);
//        metaList[2] = new NameValuePair("fileLength", String.valueOf(file_buff.length));
//        //上传文件
//        init();
//        fileId = storageClient.upload_file1(file_buff, fileExtName, metaList);
//        fis.close();
//        return fileId;
//    }
//    public String upload(File file,int x,int y) throws Exception{
//        String fileId="";
//        String tempFileName = file.getName();
//        FileInputStream fis = new FileInputStream(file);
//        byte[] file_buff = null;
//        if (fis != null) {
//            int len = fis.available();
//            file_buff = new byte[len];
//            fis.read(file_buff);
//        }
//        String fileExtName = tempFileName.substring(tempFileName.lastIndexOf(".")+1);
//        //设置元信息
//        NameValuePair[] metaList = new NameValuePair[3];
//        metaList[0] = new NameValuePair("fileName", tempFileName);
//        metaList[1] = new NameValuePair("fileExtName", fileExtName);
//        metaList[2] = new NameValuePair("fileLength", String.valueOf(file_buff.length));
//        //上传文件
//        init();
//        //压缩图片
//        byte[] afterByte= ImageUtil.compressImage(file_buff,fileExtName,x,y);
//        fileId = storageClient.upload_file1(afterByte, fileExtName, metaList);
//        fis.close();
//        return fileId;
//    }
//    public  void deleteFile(String groupName, String remoteFileName) throws Exception {
//        init();
//        //设置元信息
//        storageClient.delete_file(groupName, remoteFileName);
//    }
//}
