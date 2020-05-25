package com.baiyi.opscloud.decorator;

import com.baiyi.opscloud.common.util.BeanCopierUtils;
import com.baiyi.opscloud.common.util.IOUtils;
import com.baiyi.opscloud.domain.generator.opscloud.OcTerminalSessionInstance;
import com.baiyi.opscloud.domain.vo.term.TerminalSessionInstanceVO;
import com.baiyi.opscloud.xterm.config.XTermConfig;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @Author baiyi
 * @Date 2020/5/25 9:35 下午
 * @Version 1.0
 */
@Component
public class TerminalSessionInstanceDecorator {

    @Resource
    private XTermConfig xtermConfig;

    public TerminalSessionInstanceVO.TerminalSessionInstance decorator(OcTerminalSessionInstance ocTerminalSessionInstance, Integer extend) {
        TerminalSessionInstanceVO.TerminalSessionInstance terminalSessionInstance
                = BeanCopierUtils.copyProperties(ocTerminalSessionInstance, TerminalSessionInstanceVO.TerminalSessionInstance.class);
        String path = xtermConfig.getAuditLogPath(ocTerminalSessionInstance.getSessionId(), terminalSessionInstance.getInstanceId());
        String content = IOUtils.readFile(path);
        TerminalSessionInstanceVO.AuditLog auditLog = new TerminalSessionInstanceVO.AuditLog();
        if (StringUtils.isEmpty(content)) {
            auditLog.setIsEmpty(true);
        } else {
            auditLog.setPath(path);
            if (extend == 1)
                auditLog.setContent(content);
            auditLog.setIsEmpty(false);
        }
        terminalSessionInstance.setAuditLog(auditLog);
        return terminalSessionInstance;
    }
}
