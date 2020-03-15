  /*
     * cookies验证
     */
    @RequestMapping("")
    public ModelAndView cookiesCheck(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
//     cookie不为空 else 为空
        if(cookies!=null){
            String adminCookie="";
            for (Cookie c: cookies) {
                if ("adminCookie".equals(c.getName())){
                    adminCookie=c.getValue();
                    break;
                }
            }
//         自己的 cookie没有添加 else cookie已经添加
            if ("".equals(adminCookie)){
                return new ModelAndView("login");
            }else{
                return new ModelAndView("index");
            }
        }else{
            return new ModelAndView("login");
        }
    }

    /*
     登录验证
     */
    @RequestMapping(value = "checklogin",method = RequestMethod.POST)
   public ModelAndView checkLogin(@RequestParam String uName,
                                  @RequestParam String uPassword,
                                  @RequestParam  String captcha,
                                  HttpServletRequest request, HttpServletResponse response){
        if (uName != null&&uPassword!=null&&captcha!=null){
           Admin admin= adminService.checkAdmin(uName,uPassword);
           if (admin!=null){
               Cookie cookie=new Cookie("adminCookie",admin.getaId()+"");
                cookie.setMaxAge(3600);
                cookie.setPath("/");
                response.addCookie(cookie);
                return new ModelAndView("redirect:index");
           }else {
               return new ModelAndView("login");
           }
        }else {
            return new ModelAndView("login");
        }
    }

    /*
     * 分页
     */
    @RequestMapping("page")
public Map<String,Object> getAdmin(HttpServletRequest request,
                                   @Value("${controller.currentPage}") Integer currentPage,
                                   @Value("${controller.pageSize}") Integer pageSize){
//    当前页
    int currentPage0=currentPage==null || currentPage<=0? 1 : currentPage;
//    设置每页显示的数量
    int pageSize0=pageSize==null || pageSize<=0? 5 : pageSize;
//    拦截器捆绑页面信息
    Page page=PageHelper.startPage(currentPage0,pageSize0);
    adminService.findAllAdminByPage(currentPage0,pageSize0);
//    返回页面信息
    PageInfo<Admin> pageInfo=new PageInfo<>(page);
//    存放页面信息
    Map<String,Object> reMap=new HashMap<>();
    reMap.put("total",pageInfo.getTotal());
    reMap.put("pageSize",pageInfo.getPageSize());
    reMap.put("currentPage",pageInfo.getPageNum());
    reMap.put("adminList",pageInfo.getList());
    request.setAttribute("reMap",reMap);
    logger.info("当前页面显示记录条数为"+pageInfo.getList().size());
    return reMap;
}