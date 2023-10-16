
package SERVER;

import java.util.ArrayList;
import java.util.List;

public class MultiThreadBus {
    private List<MultiThread> threadList;

    public MultiThreadBus() {
        threadList = new ArrayList<>();
    }

    public synchronized void add(MultiThread thread) {
        threadList.add(thread);
    }

    public synchronized void remove(MultiThread thread) {
        threadList.remove(thread);
    }

    public synchronized int getLength() {
        return threadList.size();
    }

    public synchronized void stopAllThreads() {
        for (MultiThread thread : threadList) {
            thread.stopThread(); // Đây cần cài đặt phương thức stopThread() trong lớp MultiThread của bạn
        }
        threadList.clear();
    }
}

