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

package xin.altitude.cms.common.entity;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * 锁元数据
 *
 * @author <a href="http://www.altitude.xin" target="_blank">赛泰先生</a>
 * @author <a href="https://gitee.com/decsa/ucode-cms-vue" target="_blank">UCode CMS</a>
 * @author <a href="https://space.bilibili.com/1936685014" target="_blank">B站视频</a>
 **/
public class LockMeta {
    /**
     * 分布式锁实例
     */
    private RLock lock;
    /**
     * 排队等待加锁时间
     */
    private long waitTime;
    /**
     * 持有锁时间
     */
    private long leaseTime;
    /**
     * 时间单位
     */
    private TimeUnit timeUnit;

    public LockMeta() {
    }

    public LockMeta(RLock lock, long waitTime, long leaseTime, TimeUnit timeUnit) {
        this.lock = lock;
        this.waitTime = waitTime;
        this.leaseTime = leaseTime;
        this.timeUnit = timeUnit;
    }

    public static LockMeta of(RLock lock, long waitTime, long leaseTime, TimeUnit timeUnit) {
        return new LockMeta(lock, waitTime, leaseTime, timeUnit);
    }

    public long getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(long waitTime) {
        this.waitTime = waitTime;
    }

    public long getLeaseTime() {
        return leaseTime;
    }

    public void setLeaseTime(long leaseTime) {
        this.leaseTime = leaseTime;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public RLock getLock() {
        return lock;
    }

    public void setLock(RLock lock) {
        this.lock = lock;
    }

}
