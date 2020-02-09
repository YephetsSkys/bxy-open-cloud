package com.github.bxy;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.log.StaticLog;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.bxy.authority.dao.auth.MenuMapper;
import com.github.bxy.authority.dao.auth.ResourceMapper;
import com.github.bxy.authority.dao.auth.RoleMapper;
import com.github.bxy.authority.dao.auth.UserMapper;
import com.github.bxy.authority.dao.common.AreaMapper;
import com.github.bxy.authority.dao.core.StationMapper;
import com.github.bxy.authority.dto.core.StationPageDTO;
import com.github.bxy.authority.entity.auth.Resource;
import com.github.bxy.authority.entity.auth.User;
import com.github.bxy.authority.entity.common.OptLog;
import com.github.bxy.authority.entity.core.Org;
import com.github.bxy.authority.entity.core.Station;
import com.github.bxy.authority.service.auth.ResourceService;
import com.github.bxy.authority.service.auth.UserService;
import com.github.bxy.authority.service.core.OrgService;
import com.github.bxy.context.BaseContextHandler;
import com.github.bxy.database.mybatis.conditions.Wraps;
import com.github.bxy.database.mybatis.conditions.query.LbqWrapper;
import com.github.bxy.dozer.DozerUtils;
import com.github.bxy.log.entity.OptLogDTO;
import com.github.bxy.model.RemoteData;
import com.github.bxy.utils.NumberHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 测试类
 *
 * @author bxy
 * @date 2019/06/26
 */


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class TestResource {
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    ResourceService resourceService;
    @Autowired

    private OrgService orgService;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private DozerUtils dozer;
    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private StationMapper stationMapper;


    @Before
    public void setTenant() {
        BaseContextHandler.setTenant("0000");
        BaseContextHandler.setDatabase("bxy_base");
    }

    @Test
    public void testDozer() {
        Station station = Station.builder().id(1L).orgId(new RemoteData(12L)).build();

        StationPageDTO stationPageDTO = dozer.map(station, StationPageDTO.class);

        System.out.println(stationPageDTO.getOrgId());
    }


    @Test
    public void testDozer3333() {
        Org org = Org.builder()
                .name("string")
                .id(123L)
                .build();
        Station station = Station.builder().id(1L).orgId(new RemoteData(12L, org)).build();

//        StationPageDTO stationPageDTO = dozer.map(station, StationPageDTO.class);
        StationPageDTO stationPageDTO = new StationPageDTO();
        BeanUtil.copyProperties(station, stationPageDTO);
        System.out.println(stationPageDTO.getOrgId());
    }

    @Test
    public void testDozerAndBean() {

        //10000 - 688
        //50000 - 2130
        //100000 - 4050  2438
        //1000000 - 22085   20375

        // 放弃理由

        TimeInterval timer = DateUtil.timer();
        for (int i = 0; i <= 1000000; i++) {
            Org org = Org.builder()
                    .name("string")
                    .id(123L + i)
                    .createTime(LocalDateTime.now())
                    .build();
            Station station = Station.builder().id(1L + i).name("nihaoa").createTime(LocalDateTime.now()).orgId(new RemoteData(12L, org)).build();

            StationPageDTO stationPageDTO = dozer.map(station, StationPageDTO.class);
        }

        long interval = timer.interval();// 花费毫秒数
        long intervalMinute = timer.intervalMinute();// 花费分钟数
        StaticLog.info("本次程序执行 花费毫秒数: {} ,   花费分钟数:{} . ", interval, intervalMinute);
    }


    @Test
    public void testDozer2() {
//        StationPageDTO page = StationPageDTO.builder().orgId(3333L).build();
//        Station station = dozer.map(page, Station.class);
//        System.out.println(station.getOrgId());
    }

    @Test
    public void testSaveUser() {
        List<Long> menuIdByResourceId = resourceService.findMenuIdByResourceId(Arrays.asList(643444897201784193L, 643445674330819745L, 643445641149680705L));
        System.out.println(menuIdByResourceId.size());
    }


    @Test
    public void test() {
        List<Long> userIdByCode = roleMapper.findUserIdByCode(new String[]{"SUPER_ADMIN"});
        System.out.println(userIdByCode.size());
    }

    @Test
    public void testFindUserByRoleId() {
        List<User> list = userMapper.findUserByRoleId(100L, "ad%min");
        log.info("list.size= " + list.size());
    }

    @Test
    public void testWrapper() {
        Resource build = Resource.builder().code("123%456").name("nide %z").build();
        LbqWrapper<Resource> ignore = Wraps.lbQ(build).ignore(Resource::setCode).eq(Resource::getCode, build.getCode());
        resourceService.list(ignore);
    }

    @Test
    public void testfindChildren() {
        List<Org> children = orgService.findChildren(Arrays.asList(101L));
        log.info("size={}", children.size());
    }

    @Test
    public void testObjlist() {
        for (int i = 0; i < 20; i++) {
            List<Long> list = orgService.listObjs(NumberHelper::longValueOf0);
            log.info("listsize={}", list.size());
        }
        log.info("endendendendend");
    }

    @Test
    public void testDelete() {
//        boolean flag = userService.removeById(2221L);
//        log.info(flag);
//        boolean flag2 = resourceService.removeById(32L);
//        log.info(flag2);
        resourceService.update(Wraps.<Resource>lbU().set(Resource::getMenuId, null).eq(Resource::getId, 1L));
//        resourceService.updateById(Resource.builder().menuId(null).describe("1").id(1L).build());
    }

    @Test
    public void dozerTest() {
        OptLogDTO dot = new OptLogDTO();
        dot.setHttpMethod("POST");
        dot.setType("EX");

        OptLog opt = dozer.map(dot, OptLog.class);
        log.info("method={}", opt.getHttpMethod());
        log.info("type={}", opt.getType());

    }

    @Test
    public void dozer2Test() {
        D d = new D();
        d.setD2(new Date());
        d.setDate(LocalDateTime.now());
        D2 opt = dozer.map(d, D2.class);
        log.info("{}", opt);

    }


    @Test
    public void test3() {

        LbqWrapper<Resource> query2 = Wraps.<Resource>lbQ().eq(Resource::getName, "xiz");
        List<Resource> resources2 = resourceMapper.selectList(query2);
        log.info("{}", resources2.size());


        LbqWrapper<Resource> query = Wraps.lbQ(Resource.builder().name("新增%").build());
        List<Resource> resources = resourceMapper.selectList(query);
        log.info("{}", resources.size());


    }


    @Test
    public void test2() {
        List<Resource> list = resourceService.list(
                Wrappers.lambdaQuery(Resource.builder()
                        .code("aaa")
                        .name("vvv")
                        .build()));
//        List<Resource> list = resourceService.list(
//                Wraps.lbQ(Resource.builder()
//                        .code("aaa")
//                        .name("vvv")
//                        .build()));

        log.info("{}", list.size());
    }


}
