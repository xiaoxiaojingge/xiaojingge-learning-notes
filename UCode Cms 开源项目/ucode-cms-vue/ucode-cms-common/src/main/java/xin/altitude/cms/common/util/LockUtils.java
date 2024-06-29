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

package xin.altitude.cms.common.util;

import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xin.altitude.cms.common.entity.JvmLockMeta;
import xin.altitude.cms.common.entity.LockMeta;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.function.Supplier;

/**
 * 锁相关工具类
 *
 * @author <a href="http://www.altitude.xin" target="_blank">赛泰先生</a>
 * @author <a href="https://gitee.com/decsa/ucode-cms-vue" target="_blank">UCode CMS</a>
 * @author <a href="https://space.bilibili.com/1936685014" target="_blank">B站视频</a>
 **/
public class LockUtils {
    private final static Logger logger = LoggerFactory.getLogger(LockUtils.class);

    private LockUtils() {
    }


    /**
     * 通过封装减少try-catch冗余代码
     *
     * @param meta     {@link LockMeta}锁元数据子类实例
     * @param supplier 回调方法
     * @param <R>      返回值类型
     */
    public static <R> R tryLock(LockMeta meta, Supplier<R> supplier) {
        Objects.requireNonNull(supplier);
        RLock lock = Objects.requireNonNull(meta.getLock());
        try {
            if (lock.tryLock(meta.getWaitTime(), meta.getLeaseTime(), meta.getTimeUnit())) {
                // 回调被锁业务逻辑
                return supplier.get();
            } else {
                long sec = TimeUnit.SECONDS.convert(meta.getWaitTime(), meta.getTimeUnit());
                logger.error("等待{}秒仍未获得锁，已超时，请重新申请锁", sec);
                throw new RuntimeException("获取锁等待超时");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            Optional.of(lock).ifPresent(Lock::unlock);
        }
    }

    /**
     * 通过封装减少try-catch冗余代码
     *
     * @param meta     {@link LockMeta}锁元数据子类实例
     * @param supplier 回调方法
     * @param <R>      返回值类型
     */
    public static <R> R tryLock(JvmLockMeta meta, Supplier<R> supplier) {
        Objects.requireNonNull(supplier);
        Lock lock = Objects.requireNonNull(meta.getLock());
        try {
            if (lock.tryLock(meta.getWaitTime(), meta.getTimeUnit())) {
                // 回调被锁业务逻辑
                return supplier.get();
            } else {
                throw new RuntimeException("获取锁等待超时");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            Optional.of(lock).ifPresent(Lock::unlock);
        }
    }
}
