package com.baiyi.opscloud.facade;

import com.baiyi.opscloud.domain.BusinessWrapper;
import com.baiyi.opscloud.domain.DataTable;
import com.baiyi.opscloud.domain.param.server.ServerParam;
import com.baiyi.opscloud.domain.vo.server.OcServerVO;

/**
 * @Author baiyi
 * @Date 2020/2/21 4:47 下午
 * @Version 1.0
 */
public interface ServerFacade {

    DataTable<OcServerVO.Server> queryServerPage(ServerParam.PageQuery pageQuery);

    BusinessWrapper<Boolean> addServer(OcServerVO.Server server);

    BusinessWrapper<Boolean> updateServer(OcServerVO.Server server);

    BusinessWrapper<Boolean> deleteServerById(int id);
}