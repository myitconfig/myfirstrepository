 /*
     * 文件上传
     */
    @RequestMapping(value = "uploadfile",method = RequestMethod.POST)
    public String  fileUpload(@RequestParam CommonsMultipartFile[] file,
                                             @Value("${controller.filePath}")String filePath) throws IOException {
        for (int i = 0; i < file.length; i++) {
            long  startTime=System.currentTimeMillis();
            String path=filePath+new Date().getTime()+file[i].getOriginalFilename();
            File newFile=new File(path);
            file[i].transferTo(newFile);
            long  endTime=System.currentTimeMillis();
            logger.info("采用file.Transto上传"+file[i].getOriginalFilename()+"所用时间时间:"+(endTime-startTime)+"ms");
        }
        return "loginok";
    }

    /*
     * 文件下载
     */
    public String fileDownLoad(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String fileName="";
//     输出流
        OutputStream out = response.getOutputStream();
//         获取客户端请求头中的User-Agent
        String userAgent = request.getHeader("User-Agent");
        if (userAgent.contains("MSIE")) {
//         IE浏览器
            fileName = URLEncoder.encode(fileName, "utf-8");
            fileName = fileName.replace("+", " ");
        } else {
//         其他浏览器
            BASE64Encoder base64Encoder = new BASE64Encoder();
            fileName = "=?utf-8?B?" + base64Encoder.encode(fileName.getBytes("utf-8")) + "?=";
        }
        response.reset();
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        response.setContentType("application/msexce");
        return null;
    }