package org.dgrytsyna;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService =  Executors.newCachedThreadPool();
        List<Future<FinalModelStatistic>> statisticList = new ArrayList<>();
        for(int i=0; i<5; i++){
            Future<FinalModelStatistic> finalModelsStatistic = executorService.submit(new SimulationModel());
            statisticList.add(finalModelsStatistic);
        }

        for(int i=0; i<5; i++){
            System.out.println(statisticList.get(i).get().toString());
        }

        executorService.shutdown();

    }
}