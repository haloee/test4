package pte.mik.hu.service;
import java.util.concurrent.atomic.AtomicLong;
public class IdProvider {
    private static IdProvider INSTANCE;
    private final AtomicLong counter = new AtomicLong(1);

    private IdProvider() {}

    public static IdProvider getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new IdProvider();
        }
        return INSTANCE;
    }

    public long nextId() {
        return counter.getAndIncrement();
    }
}
