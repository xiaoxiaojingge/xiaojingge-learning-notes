/*
 *
 * Copyright (c) 2020-2022, 赛泰先生 (http://www.altitude.xin).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package xin.altitude.cms.gen.code.service.core.impl;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import xin.altitude.cms.common.util.SpringUtils;
import xin.altitude.cms.gen.code.constant.CodeConstant;
import xin.altitude.cms.gen.code.service.core.IThirdSqlSessionService;

/**
 * @author <a href="http://www.altitude.xin" target="_blank">赛泰先生</a>
 * @author <a href="https://gitee.com/decsa/ucode-cms-vue" target="_blank">UCode CMS</a>
 * @author <a href="https://space.bilibili.com/1936685014" target="_blank">B站视频</a>
 */
// @Service
public class ThirdSqlSessionServiceImpl implements IThirdSqlSessionService {
    /**
     * 通过连接ID获取SqlSession会话
     *
     * @return SqlSession
     */
    @Override
    public SqlSession getSqlSession() {
        SqlSessionFactory factory = SpringUtils.getBean(CodeConstant.CODE_SQL_SESSION_FACTORY);
        return factory.openSession(ExecutorType.REUSE, true);
    }
}
