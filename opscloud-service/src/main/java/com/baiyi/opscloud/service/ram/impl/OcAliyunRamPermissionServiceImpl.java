package com.baiyi.opscloud.service.ram.impl;

import com.baiyi.opscloud.domain.generator.opscloud.OcAliyunRamPermission;
import com.baiyi.opscloud.mapper.opscloud.OcAliyunRamPermissionMapper;
import com.baiyi.opscloud.service.ram.OcAliyunRamPermissionService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @Author baiyi
 * @Date 2020/6/10 6:17 下午
 * @Version 1.0
 */
@Service
public class OcAliyunRamPermissionServiceImpl implements OcAliyunRamPermissionService {

    @Resource
    private OcAliyunRamPermissionMapper ocAliyunRamPermissionMapper;

    @Override
    public void addOcAliyunRamPermission(OcAliyunRamPermission ocAliyunRamPermission) {
        ocAliyunRamPermissionMapper.insert(ocAliyunRamPermission);
    }

    @Override
    public void deleteOcAliyunRamPermissionById(int id) {
        ocAliyunRamPermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public OcAliyunRamPermission queryOcAliyunRamPermissionByUniqueKey(OcAliyunRamPermission ocAliyunRamPermission) {
        Example example = new Example(OcAliyunRamPermission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("accountUid", ocAliyunRamPermission.getAccountUid());
        criteria.andEqualTo("userId", ocAliyunRamPermission.getUserId());
        criteria.andEqualTo("policyId", ocAliyunRamPermission.getPolicyId());
        return ocAliyunRamPermissionMapper.selectOneByExample(example);
    }

}
