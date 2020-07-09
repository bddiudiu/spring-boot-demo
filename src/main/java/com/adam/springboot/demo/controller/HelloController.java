package com.adam.springboot.demo.controller;

import com.adam.springboot.demo.model.User;
import com.adam.springboot.demo.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by adam on 4/11/16.
 */

@RestController
public class HelloController {

//    @Autowired
//    UserMapper userMapper;
//
//    @Value("${com.adam.demo.name}")
//    private String name;
//
//    @Value("${com.adam.demo.title}")
//    private String title;
//
//    @RequestMapping("/hello")
//    public String hello(){
//        String str = name + "正在编写" + title;
//        return str;
//    }
//
//    @RequestMapping("/insert")
//    public String insert(){
////        userMapper.insert("test",2);
//        return "good";
//    }
//
//    @RequestMapping("/find")
//    public String find(){
////        User user = userMapper.findByName("test");
////        System.out.println(user.getAge());
//        return "good";
//    }


    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(@RequestParam("file")MultipartFile file){
        if(!file.isEmpty()){
            try {
              /*
               * 这段代码执行完毕之后，图片上传到了工程的跟路径；
               * 大家自己扩散下思维，如果我们想把图片上传到 d:/files大家是否能实现呢？
               * 等等;
               * 这里只是简单一个例子,请自行参考，融入到实际中可能需要大家自己做一些思考，比如：
               * 1、文件路径；
               * 2、文件名；
               * 3、文件格式;
               * 4、文件大小的限制;
               */
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return"上传失败,"+e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return"上传失败,"+e.getMessage();
            }
            return"上传成功";
        }else{
            return"上传失败，因为文件是空的.";
        }
    }

    @Autowired
    UserService userService;

    @RequestMapping("/countries")
    public ModelAndView getAll(User user) {
        ModelAndView result = new ModelAndView("index");
        System.out.println("1231231231");
        List<User> userList = userService.queryAllUser(user);
        result.addObject("pageInfo", new PageInfo<User>(userList));
        result.addObject("queryParam", user);
        result.addObject("page", user.getPage());
        result.addObject("rows", user.getRows());
        return result;
    }


    public static final String ROOT = "/Users/adam/Documents/images";

    @RequestMapping("upload")
    public String upload(MultipartFile file) {
        String ret = "";

        try{
            Files.copy(file.getInputStream(), Paths.get(ROOT, file.getOriginalFilename()));
//            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File("/resources/static/images/",file.getOriginalFilename())));
//            out.write(file.getBytes());
//            out.flush();
//            out.close();

//            //阿里云oss
//            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//            InputStream inputStream = file.getInputStream();
//            //创建上传Object的Metadata
//            ObjectMetadata objectMetadata = new ObjectMetadata();
//            objectMetadata.setContentLength(inputStream.available());
//            objectMetadata.setCacheControl("no-cache");
//            objectMetadata.setHeader("Pragma", "no-cache");
//            objectMetadata.setContentType(getcontentType(file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."))));
//            objectMetadata.setContentDisposition("inline;filename=" + originalFilename);
//            PutObjectResult putResult = ossClient.putObject(bucketName, file.getOriginalFilename(), inputStream, objectMetadata);
//            ret = putResult.getETag();

        }catch (Exception e){
            e.printStackTrace();
        }
        return ret;

    }

    @RequestMapping("toupload")
    public String toupload(){
        return "upload";
    }

    private final ResourceLoader resourceLoader;

    @Autowired
    public HelloController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @RequestMapping("image/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> image(@PathVariable String filename){
        return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ROOT, filename).toString()));
    }

    /**
     * Description: 判断OSS服务文件上传时文件的contentType
     *
     * @param FilenameExtension 文件后缀
     * @return String
     */
    public static String getcontentType(String FilenameExtension) {
        if (FilenameExtension.equalsIgnoreCase("bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equalsIgnoreCase("gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equalsIgnoreCase("jpeg") ||
                FilenameExtension.equalsIgnoreCase("jpg") ||
                FilenameExtension.equalsIgnoreCase("png")) {
            return "image/jpeg";
        }
        if (FilenameExtension.equalsIgnoreCase("html")) {
            return "text/html";
        }
        if (FilenameExtension.equalsIgnoreCase("txt")) {
            return "text/plain";
        }
        if (FilenameExtension.equalsIgnoreCase("vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equalsIgnoreCase("pptx") ||
                FilenameExtension.equalsIgnoreCase("ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equalsIgnoreCase("docx") ||
                FilenameExtension.equalsIgnoreCase("doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equalsIgnoreCase("xml")) {
            return "text/xml";
        }
        return "image/jpeg";
    }
}
