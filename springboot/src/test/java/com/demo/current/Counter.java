package com.demo.current;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="zhuo.li@ximalaya.com">Zhuo.li</a>
 * @date 2018/6/27
 */

public class Counter {

	private static final Logger log = LoggerFactory.getLogger(Counter.class);
	
    volatile long value = 3000l;


    private static final Unsafe unsafe;
    private static final long valueOffset;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
            valueOffset = unsafe.objectFieldOffset
                    (Counter.class.getDeclaredField("value"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    public boolean tryDelive(final long acquires) {
        return delive(acquires) > 0;
    }

    public long delive(final long acquires) {

        for (; ; ) {
            long available = get();
            long remaining = available - acquires;
            if (remaining < 0 ||
                    compareAndSet(available, remaining))
                return remaining;
        }
    }

    public final long get() {
        return value;
    }

    public final boolean compareAndSet(long expect, long update) {
        return unsafe.compareAndSwapLong(this, valueOffset, expect, update);
    }

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch la = new CountDownLatch(3);

        Counter counter = new Counter();

        AtomicInteger dd = new AtomicInteger(0);

        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                la.countDown();
                
                while (true) {
                    int dz = new Random().nextInt() >>> 24;
                    if (counter.tryDelive(dz)) {
                        log.info("鍙戝伐璧� {}  ,宸插彂 {}: ", dz,dd.addAndGet(dz));
                    } else {
                        log.info("浣欓 {} 涓嶈冻鍙憑{}", counter.get(),dz);
                        break;
                    }
                }

            }).start();
        }

        la.await();


       Thread.currentThread().join();


    }
}
