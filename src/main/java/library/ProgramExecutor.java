package library;

import library.runnable.ExecutorRunnable;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ProgramExecutor {

    public void execute(File file1, File file2) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20);
        try {
            ExecutorRunnable executorRunnable = new ExecutorRunnable(file1, file2);
            executor.execute(executorRunnable);
        } catch (
                Exception e) {
            System.out.println(e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}
