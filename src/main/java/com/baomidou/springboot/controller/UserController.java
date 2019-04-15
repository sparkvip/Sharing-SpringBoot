package com.baomidou.springboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.springboot.entity.Users;
import com.baomidou.springboot.service.IUserService;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 代码生成器，参考源码测试用例：
 * <p>
 * /mybatis-plus/src/test/java/com/baomidou/mybatisplus/test/generator/MysqlGenerator.java
 */
@RestController
@RequestMapping("/user")
public class UserController extends ApiController {

    @Autowired
    private IUserService userService;

    /**
     * http://localhost:8080/user/test
     */
    @GetMapping("/test")
    @CrossOrigin(origins = "http://localhost:8000")
    public ResponseEntity<String> test(String file) {
        System.out.println("file:\n"+file+"\n\n\n\n\n");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "*");
        headers.add("Access-Control-Allow-Headers:x-requested-with","content-type");
        return new ResponseEntity<String>("ookkk!", headers, HttpStatus.OK);
    }

    /**
     * 插入
     */
    @GetMapping("/insert")
    public IPage<Users> test1() {
        Users user = new Users();
        user.setInsititute("计算机");
        user.setName("李锦");
        user.setPhone("12394875433");
        user.setPassword("123");
        user.setPortrait("admin");
        user.setPrivilege("D:/1.png");
        userService.save(user);
        return userService.page(new Page<Users>(0, 12), null);
    }

    @GetMapping("/delete")
    public Boolean delete() {
        return userService.deleteAll();
    }

//    /**
//     * 增删改查 CRUD
//     * http://localhost:8080/user/test2
//     */
//    @GetMapping("/test2")
//    public User test2() {
//        System.err.println("删除一条数据：" + userService.removeById(1L));
//        System.err.println("deleteAll：" + userService.deleteAll());
//        System.err.println("插入一条数据：" + userService.save(new User(1L, "张三", AgeEnum.TWO, 1)));
//        User user = new User("张三", AgeEnum.TWO, 1);
//        boolean result = userService.save(user);
//        // 自动回写的ID
//        Long id = user.getId();
//        System.err.println("插入一条数据：" + result + ", 插入信息：" + user.toString());
//        System.err.println("查询：" + userService.getById(id).toString());
//        System.err.println("更新一条数据：" + userService.updateById(new User(1L, "三毛", AgeEnum.ONE, 1)));
//        for (int i = 0; i < 5; ++i) {
//            userService.save(new User(Long.valueOf(100 + i), "张三" + i, AgeEnum.ONE, 1));
//        }
//        IPage<User> userListPage = userService.page(new Page<User>(1, 5), new QueryWrapper<User>());
//        System.err.println("total=" + userListPage.getTotal() + ", current list size=" + userListPage.getRecords().size());
//
//        userListPage = userService.page(new Page<User>(1, 5), new QueryWrapper<User>().orderByDesc("name"));
//        System.err.println("total=" + userListPage.getTotal() + ", current list size=" + userListPage.getRecords().size());
//        return userService.getById(1L);
//    }
//
//    /**
//     * 插入 OR 修改
//     * http://localhost:8080/user/test3
//     */
//    @GetMapping("/test3")
//    public Users test3() {
//        Users user = new Users(1L, "王五", AgeEnum.ONE, 1);
//        user.setPhone(PhoneEnum.CT);
//        userService.saveOrUpdate(user);
//        return userService.getById(1L);
//    }
//
//    /**
//     * http://localhost:8080/user/add
//     */
//    @GetMapping("/add")
//    public Object addUser() {
//        User user = new User("张三'特殊`符号", AgeEnum.TWO, 1);
//        user.setPhone(PhoneEnum.CUCC);
//        return userService.save(user);
//    }
//
//    /**
//     * http://localhost:8080/user/select_sql
//     */
//    @GetMapping("/select_sql")
//    public Object getUserBySql() {
//        return userService.selectListBySQL();
//    }
//
//    /**
//     * http://localhost:8080/user/select_wrapper
//     */
//    @GetMapping("/select_wrapper")
//    public Object getUserByWrapper() {
//        return userService.selectListByWrapper(new QueryWrapper<User>()
//                .lambda().like(User::getName, "毛")
//                .or(e -> e.like(User::getName, "张")));
//    }
//
//    /**
//     * <p>
//     * 参数模式分页
//     * </p>
//     * <p>
//     * 7、分页 size 一页显示数量  current 当前页码
//     * 方式一：http://localhost:8080/user/page?size=1&current=1<br>
//     * <p>
//     * 集合模式，不进行分页直接返回所有结果集：
//     * http://localhost:8080/user/page?listMode=true
//     */
//    @GetMapping("/page")
//    public IPage page(Page page, boolean listMode) {
//        if (listMode) {
//            // size 小于 0 不在查询 total 及分页，自动调整为列表模式。
//            // 注意！！这个地方自己控制好！！
//            page.setSize(-1);
//        }
//        return userService.page(page, null);
//    }
//
//    /**
//     * 测试事物
//     * http://localhost:8080/user/test_transactional<br>
//     * 访问如下并未发现插入数据说明事物可靠！！<br>
//     * http://localhost:8080/user/test<br>
//     * <br>
//     * 启动  Application 加上 @EnableTransactionManagement 注解其实可无默认貌似就开启了<br>
//     * 需要事物的方法加上 @Transactional 必须的哦！！
//     */
//    @Transactional(rollbackFor = Exception.class)
//    @GetMapping("/test_transactional")
//    public void testTransactional() {
//        User user = new User(1000L, "测试事物", AgeEnum.ONE, 3);
//        userService.save(user);
//        System.out.println(" 这里手动抛出异常，自动回滚数据");
//        throw new RuntimeException();
//    }
}
