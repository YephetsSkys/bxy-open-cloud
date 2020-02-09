package com.github.bxy;

import com.github.bxy.authority.dao.auth.MenuMapper;
import com.github.bxy.authority.dao.auth.ResourceMapper;
import com.github.bxy.authority.dao.auth.RoleMapper;
import com.github.bxy.authority.dao.auth.UserMapper;
import com.github.bxy.authority.dao.common.AreaMapper;
import com.github.bxy.authority.dao.core.StationMapper;
import com.github.bxy.authority.entity.auth.User;
import com.github.bxy.authority.entity.core.Org;
import com.github.bxy.authority.entity.core.Station;
import com.github.bxy.authority.service.auth.ResourceService;
import com.github.bxy.authority.service.auth.UserService;
import com.github.bxy.authority.service.core.OrgService;
import com.github.bxy.context.BaseContextHandler;
import com.github.bxy.dozer.DozerUtils;
import com.github.bxy.injection.core.InjectionCore;
import com.github.bxy.model.RemoteData;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class RemoteDataMybatisTest {
    @Autowired
    ResourceService resourceService;
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private MenuMapper menuMapper;
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
    @Autowired
    private InjectionCore injectionCore;

    @Before
    public void setTenant() {
        BaseContextHandler.setTenant("0000");
        BaseContextHandler.setDatabase("bxy_base");
    }

    @Test
    public void testSave3() {
        Station station = Station.builder()
                .name("test4")
                .orgId(new RemoteData<>(4L))
                .build();
        stationMapper.insert(station);
    }


    @Test
    public void test345() {
        User user = new User().builder().orgId(new RemoteData<>(101L)).build();
        Org byId = orgService.getById(user.getOrg());
        System.out.println(byId);
    }

    @Test
    public void test4() {
        D obj = new D();
        obj.setStationId(new RemoteData<>(101L));
        obj.setAsss(new RemoteData<>(101L));
        obj.setStatId(new RemoteData<>(101L));

        injectionCore.injection(obj);
        System.out.println(obj);
    }
}
